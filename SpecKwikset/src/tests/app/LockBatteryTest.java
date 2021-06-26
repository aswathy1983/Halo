package tests.app;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.app.AppReLaunchPage;
import pages.app.LockDashboardPage;
import pages.app.MenuFlyoutPage;
import utility.ExcelRead;
import utility.Log;
import utility.PropertyUtility;
import utility.Utility;

public class LockBatteryTest extends Settings{
	
	
	String lockName, titleMessage, locksUpdate, nameAfterUpdate, eleLockStr, lockComment, sheetName, currDate, lockNameExist, lockNameChk, lockNameListed, lockNameDashboard;
	String lockNameList[], lockUpdateList[];
	String lockBatryPer = "";
	Integer cntLock, cntUpdatedLock = 0;
	Boolean lockExist, menuExist, lockNameUpdate = false;
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="btryPercentage")
	public void selectLockBatteryTest(String homeName, String titleMsg, String titleMsgiOS) {
	  try {
		    LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			//reading lock names from property file
			lockName = PropertyUtility.getLockProperty("lock.names");
			System.out.println("lockName="+lockName);
			lockNameList = lockName.split(",");
			cntLock = lockNameList.length;
			System.out.println("lockcount="+cntLock);
			//Below code to handle any pop ups on launching the app
			// if(ld.checkForPairPopUp() || ld.checkForInternetPopUp()) {
			if(ld.checkHandlePopUp()) {
				titleMessage = ld.verifyLowBatteryPopUpVerbiage();
				if(titleMessage!=null || titleMessage!="") {
					System.out.println("titleMessage="+titleMessage);
					if(titleMessage.equals("Lock Pairing Available") || titleMessage.equals("Internet Connection Required")) {
						ld.clickCancelPairForBtry();
					}else{
						ld.clickOKButtonForBtry();	
					}
				  }
			 }

			if(lockNameList.length>0) {
				System.out.println("in >0");
				locksUpdate = "";
				for(int i=0;i<lockNameList.length;i++) {
					 System.out.println("lockName="+lockNameList[i].toString());
					 lockNameDashboard = lockNameList[i].toString();
					 Format formatter = new SimpleDateFormat("dd-MMM-yyyy");
					 currDate = formatter.format(new Date());
					 System.out.println("currDate="+currDate);
					 lockExist = false;
					 lockNameUpdate = false;
					 titleMessage ="";
					 ld.clickHamburgerButtonForBtry();
					 mp.verifyLockInMenuForBtry(homeName);
					 System.out.println("verified home");
					 if(device.equals("iOS")){
						 Utility.simpleWait(2000);
						 menuExist =  Utility.isElementPresent("//XCUIElementTypeStaticText[@name='Manage']");
						 System.out.println("menuExisttb4="+menuExist);
						 if(!menuExist) {
							 ld.clickHamburgerButtonForBtry();
						 }
					 }System.out.println("menuExistb41="+menuExist);
					 MenuFlyoutPage mf1 = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
					 mf1.clickLockInMenuForBtry(lockNameList[i].toString());
					 System.out.println("clicked lock in home");
					 //below condition if home name drop down is not displayed in android
					 if(device.equals("android")){
						 menuExist =  Utility.isElementPresent("//android.widget.Button[@text='Manage']");
						System.out.println("menuExisttb4="+menuExist);
						 if(menuExist) {
							 mp.verifyLockInMenuForBtry(homeName);
							 MenuFlyoutPage mf3 = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
							 mf3.clickLockInMenuForBtry(lockNameList[i].toString());
						 }
					 }
					 LockDashboardPage ld1 =  new LockDashboardPage(appiumDriver);
					 lockExist = ld1.checkForLockName(lockNameList[i].toString());
					
					 System.out.println("lockExistA="+lockExist);
					 if(device.equals("iOS") && !lockExist) {
						 System.out.println("again hamburger");
						 //added below code to handle pair pop up in ios check
						// if(ld.checkForPopUp() || ld.checkForPairPopUp() || ld.checkForInternetPopUp()) {
						 if(ld.checkHandlePopUp()) {
							titleMessage = ld.verifyLowBatteryPopUpVerbiage();
							LockDashboardPage ld8 = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
							if(titleMessage!=null || titleMessage!="") {
								System.out.println("titleMessage="+titleMessage);
								if(titleMessage.equals("Lock Pairing Available") || titleMessage.equals("Internet Connection Required")) {
									ld8.clickCancelPairForBtry();
								}else{
									ld8.clickOKButtonForBtry();	
								}
							}
						 }
						 ld.clickHamburgerButtonForBtry();
						 LockDashboardPage ld3 =  new LockDashboardPage(appiumDriver);
						 lockExist = ld3.checkForLockName(lockNameList[i].toString());
						 MenuFlyoutPage mf2 = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
						 mf2.clickLockInMenuForBtry(lockNameList[i].toString());
					 } 
					 //added below code to verify if app is stuck
					 if(device.equals("android")){
						 MenuFlyoutPage mfc = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
						// if(!mfc.checkForAppStuckMenu() && !mfc.checkForAppStuckDashboard()) {
						 if(!mfc.checkForAppStuckMenu()) {
							 AppReLaunchPage ar = new AppReLaunchPage((AppiumDriver<MobileElement>) driver);
							 System.out.println("in quit n relaunch2 of app stuch");
							 ar.appQuitAndRelaunch();
							 System.out.println("after relaunch2 of appstuck");
						 }
					 }
					//added below code to verify menu flyout is not collapsed for android if yes then quit and relaunch the app
					 if(device.equals("android") && !lockExist) {
						 System.out.println("again and hamburger");
						 AppReLaunchPage ar1 = new AppReLaunchPage((AppiumDriver<MobileElement>) driver);
						 System.out.println("in quit n relaunch1");
						 ar1.appQuitAndRelaunch();
						 System.out.println("after relaunch1");
					     ld.clickHamburgerButtonForBtry();
					     menuExist =  Utility.isElementPresent("//android.widget.Button[@text='Manage']");
						 System.out.println("menuExisttb4="+menuExist);
						 if(menuExist) {
							 mp.verifyLockInMenuForBtry(homeName);
							 MenuFlyoutPage mf3 = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
							 mf3.clickLockInMenuForBtry(lockNameList[i].toString());
						 }
						 LockDashboardPage ld13 =  new LockDashboardPage(appiumDriver);
						 lockExist = ld13.checkForLockName(lockNameList[i].toString());
					 } 
					 System.out.println("lockExistB="+lockExist);
					 if(lockExist) {
						 System.out.println("in break titleMessage1="+titleMessage); 
						// if(ld.checkForPopUp() || ld.checkForPairPopUp() || ld.checkForInternetPopUp()) {
						 if(ld.checkHandlePopUp()) {
								titleMessage = ld.verifyLowBatteryPopUpVerbiage();
								 System.out.println("titleMessage1 b4="+titleMessage); 
								  LockDashboardPage ld4 = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
								  if(titleMessage!=null || titleMessage!="") {
									System.out.println("titleMessage1="+titleMessage);
									if(titleMessage.equals("Lock Pairing Available") || titleMessage.equals("Internet Connection Required")) {
										ld4.clickCancelPairForBtry();
									}else{
										ld4.clickOKButtonForBtry();	
									}
								  }
						 }
						 lockUnlockOperationForBtry();
						 System.out.println("perform lock unlock operation1");
						 titleMessage ="";
						// if(ld.checkForPopUp() || ld.checkForPairPopUp() || ld.checkForInternetPopUp()) {
						 if(ld.checkHandlePopUp()) {
							 LockDashboardPage ld5 = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
							  titleMessage = ld5.verifyLowBatteryPopUpVerbiage();
							  System.out.println("titleMessage2b4="+titleMessage);
							  if(titleMessage!=null || titleMessage!="") {
								System.out.println("titleMessage2="+titleMessage);
								if(titleMessage.equals("Lock Pairing Available") || titleMessage.equals("Internet Connection Required")) {
									System.out.println("in cancel1");
									ld5.clickCancelPairForBtry();
								}else{
									ld5.clickOKButtonForBtry();	
								}
							  }
						 }else if(device.equals("android") && ld.checkForFailedPopUp()) {
							 //if(ld.checkForPopUp()|| ld.checkForInternetPopUp()) {//check for popup again 
								 LockDashboardPage ld2 = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
								 titleMessage = ld2.verifyLowBatteryPopUpVerbiage();
								 System.out.println("titleMessage5b4="+titleMessage);
								 if(titleMessage!=null || titleMessage!="") {
									 //if(titleMessage.contains("Locking Failed") || titleMessage.contains("Unlocking Failed")) {
									 if(titleMessage.equals("Internet Connection Required")) {
										 ld2.clickCancelPairForBtry();
										}else{
											ld2.clickOKButtonForBtry();	
										}
								 }
							// }
						 }
						 lockUnlockOperationForBtry();
						 System.out.println("perform lock unlock operation2");
						 titleMessage ="";
						// if(ld.checkForPopUp() || ld.checkForPairPopUp() || ld.checkForInternetPopUp()) {
						 if(ld.checkHandlePopUp()) {
							LockDashboardPage ld9 = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
							titleMessage = ld9.verifyLowBatteryPopUpVerbiage();
							System.out.println("one");
							 if(titleMessage!=null || titleMessage!="") {
								if(titleMessage.equals("Lock Pairing Available") || titleMessage.equals("Internet Connection Required")) {
									ld9.clickCancelPairForBtry();
								}else{
									ld9.clickOKButtonForBtry();	
								}
							 }
						 }else if(device.equals("android") && ld.checkForFailedPopUp()) {
							 LockDashboardPage ld16 = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
							 titleMessage = ld16.verifyLowBatteryPopUpVerbiage();
							 System.out.println("titleMessage6b4="+titleMessage);
							 if(titleMessage!=null || titleMessage!="") {
								// if(titleMessage.contains("Locking Failed") || titleMessage.contains("Unlocking Failed")) {
								    if(titleMessage.equals("Internet Connection Required")) {
									    ld16.clickCancelPairForBtry();
									}else{
										ld16.clickOKButtonForBtry();	
									}
							 }
						 }
						 System.out.println("titleMessagelocknameupdate="+titleMessage);
						 if(titleMessage!=null || titleMessage!="") {
						    System.out.println("titleMessage3="+titleMessage+",titleMsg="+titleMsg);
						    if(device.equals("android")) {
							    if(!titleMessage.contains(titleMsg)) {
							    	lockNameUpdate = true;
							    	if(locksUpdate!="") {
							    		locksUpdate = locksUpdate+lockNameList[i] +",";
							    	}else {
							    		locksUpdate = lockNameList[i] +",";
							    	}
									System.out.println("locknameupdate="+locksUpdate);
							    }
						    }else {
						    	if(!titleMessage.equals(titleMsgiOS)) {
						    		lockNameUpdate = true;
						    		if(locksUpdate!="") {
							    		locksUpdate = locksUpdate+lockNameList[i] +",";
							    	}else {
							    		locksUpdate = lockNameList[i] +",";
							    	}
							    }	
						    }
						}
						 lockBatryPer="";
						 //write to excel under Itrations
						 lockBatryPer = ld.getBatteryPercentageDashboard();
						 System.out.println("lockBatryPer b4="+lockBatryPer);
						/* if(!(lockBatryPer!=null) || !(lockBatryPer!="")) {*///commented for android
						 if(!(lockBatryPer!="")) {
							 System.out.println("battery is null1");
							 lockBatryPer = "NIL";
						 }else if(!lockBatryPer.contains("%")) {
							 System.out.println("battery is null2");
							 lockBatryPer = "NIL";
						 }
						
						 if(!(titleMessage!=null) ||  !(titleMessage!="")) {
							System.out.println("in empty");
							if(ld.getLockStatus()!=null) {//added on 26 Jan 2021
								if(ld.getLockStatus().equals("Jammed")) {
									lockComment = "Jammed";
								}else {
									lockComment = "NIL";
								}
							 
							}else {
								lockComment = "NIL";
							}
						 }else {
							System.out.println("in null titleMessage="+titleMessage);
							lockComment = titleMessage;
						 }
						System.out.println("comment="+lockComment);
						sheetName =lockNameList[i].toString();
						System.out.println("sheetName="+sheetName);
						ExcelRead er = new ExcelRead();
						if(lockBatryPer!="NIL" && lockBatryPer!="") {
							if(!lockBatryPer.contains("%")) {
								er.writeRow(OutputLockData,lockNameList[i].toString(), currDate,"NIL","Lock Not Found");
							}else {
								er.writeRow(OutputLockData,lockNameList[i].toString(), currDate,lockBatryPer,lockComment);
							}
						}else {
							System.out.println("in nil battery="+lockBatryPer+", lockComment="+lockComment);
							System.out.println("lockname="+lockNameList[i].toString());
							System.out.println("currDate="+currDate);
							er.writeRow(OutputLockData,lockNameList[i].toString(), currDate,lockBatryPer,lockComment);
						}
						
					 }else{ //end lock exist loop
						 System.out.println("in hamburgerlocknotfound");
						 ExcelRead er = new ExcelRead();
						 lockComment = "Lock Not Found";
						// if(ld.checkForPopUp() || ld.checkForPairPopUp() || ld.checkForInternetPopUp()) {
						 if(ld.checkHandlePopUp()) {
							titleMessage = ld.verifyLowBatteryPopUpVerbiage();
							LockDashboardPage ld7 = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
							if(titleMessage!=null || titleMessage!="") {
								System.out.println("titleMessageinlocknotfound="+titleMessage);
								if(titleMessage.equals("Lock Pairing Available") || titleMessage.equals("Internet Connection Required")) {
									lockComment = titleMessage;
									ld7.clickCancelPairForBtry();
								}else{
									ld7.clickOKButtonForBtry();	
								}
							}
						 }
						 if(!lockNameUpdate) {
						    	lockNameUpdate = true;
						    	if(locksUpdate!="") {
						    		locksUpdate = locksUpdate+lockNameList[i] +",";
						    	}else {
						    		locksUpdate = lockNameList[i] +",";
						    	}
						 }
						 System.out.println("locknameupdate17="+locksUpdate);
						 er.writeRow(OutputLockData,lockNameList[i].toString(), currDate,"NIL",lockComment);
						 ld.clickHamburgerButtonForBtry();
					 }
				}
				if(locksUpdate!=null) {
					System.out.println("in locksUpdate");
					if(locksUpdate.length()<lockName.length()) {
						System.out.println("in lesser length");
						nameAfterUpdate = locksUpdate.substring(0, locksUpdate.lastIndexOf(","));
						System.out.println("nameAfterUpdate="+nameAfterUpdate);
						PropertyUtility.setLockPropertyValue("lock.names", nameAfterUpdate);
					}
				}
			}
	  }catch(Exception e) {
		  Log.addMessage("Failed to click lock from menu");
		  e.printStackTrace();
		  Assert.assertTrue(false, "Failed to click lock from menu");
	  }
	}
	
	public void lockUnlockOperation() throws InterruptedException {	
		 try {
				LockDashboardPage ld =  new LockDashboardPage(appiumDriver);
				String LockStatus = ld.getLockStatus();
				if ((LockStatus).equals("Locked")) {
					 ld.unlockOperation();
				}
				else if(LockStatus.equals("Unlocked")) {
					ld.lockOperation();
				}
				else {
					Log.addMessage("Lock status is: "+LockStatus);
					ld.lockOperation();//added on 19 Jan 2021
				}
			}catch(Exception e) {
				Log.addMessage("Failed to lock/unlock");
				e.printStackTrace();
				Assert.assertTrue(false, "Failed to lock/unlock");
			}
	 }
	
	public void lockUnlockOperationForBtry() throws InterruptedException {	
		 try {
				LockDashboardPage ld =  new LockDashboardPage(appiumDriver);
				String LockStatus = ld.getLockStatusForBtry();
				System.out.println("LockStatus="+LockStatus);
				if(LockStatus!=null) {
					if ((LockStatus).equals("Locked")) {
						 ld.unlockOperationForBtry();
					}
					else if(LockStatus.equals("Unlocked")) {
						ld.lockOperationForBtry();
					}
					else {
						Log.addMessage("Lock status is: "+LockStatus);
						System.out.println("in else");
						if(device.equals("android")) {
							ld.clickLockUnlockButton();
						}else {
							ld.clickLockUnlockButtoniOS();
						}
					}
				}
			}catch(Exception e) {
				Log.addMessage("Failed to lock/unlock");
				e.printStackTrace();
				//Assert.assertTrue(false, "Failed to lock/unlock");
			}
	 }
	
	@SuppressWarnings("unchecked")
	public void checkTooLowToOperatePopUp() {
		try {
			LockDashboardPage ap = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			if(ap.checkForPopUp()) {
				//check for popup title
				titleMessage = ap.verifyLowBatteryPopUpVerbiage();
				//write to comments in excel
				ap.clickOKButtonForBtry();
			}else {
				//update NIL in comments for lock1
			}
		}catch(Exception e) {
			Log.addMessage("Failed to view access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to view access code");
		}
	}

	ExcelRead excel = new ExcelRead();
	
	@DataProvider(name = "btryPercentage")
	public Object[][] getData() throws Exception {
	return excel.getTableArray(InputData, "App", "BatteryTooLow");
	}
}
