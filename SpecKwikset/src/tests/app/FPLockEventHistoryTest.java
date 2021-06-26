package tests.app;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import pages.app.AutoLockDelaySettingPage;
import pages.app.ClearHistoryPopupPage;
import pages.app.ConfirmDeleteLockPage;
import pages.app.LockDashboardPage;
import pages.app.LockEventHistoryPage;
import pages.app.LockNamePage;
import pages.app.LockSettingsPage;
import pages.app.ManageHomesPage;
import pages.app.MenuFlyoutPage;
import pages.app.PairedSmartPhoneListPage;
import pages.app.UserFPAccessProfilePage;
import pages.app.ViewAccessCodesPage;
import utility.ExcelRead;
import utility.Log;


public class FPLockEventHistoryTest extends Settings{
	
	int sbcnt, timecnt, lkcnt, cntPhone, totalCount, lstCnt = 0;
	 String[][] eventList =null;
	 String status = "";
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="lockHistry")
	public void viewlockActivityTest(String lkEventName,String lkSubType, String lkTime, String lkiosTime, String lkiosEvent, String totCount) {
		 try {
			 LockEventHistoryPage le = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
			 if(lkcnt==0) {
				 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
				 MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
				Thread.sleep(15000);//to test in between
			
				if(device.equals("android")) {
					ld.clickHamburgerButton();
					Thread.sleep(2000);
					mp.clickLockImageInMenu("hl");
					Thread.sleep(2000);
				}
				ld.clickLockHistoryButton();
				System.out.println("cnt");
				totalCount = Integer.parseInt(totCount) ;
				System.out.println("totalCount="+totalCount);
			 }
			 Thread.sleep(3000);
			 if(lkSubType!="") {
				 sbcnt++;
			 }
			 if(lkTime!="") {
				 timecnt++;
			 }
			 lkcnt = lkcnt+1;
			
			 if(device.equals("iOS")) {
				 le.getFPLockEventHistoryiOSList(lkiosEvent, lkiosTime, lkcnt-1, sbcnt-1,timecnt-1,totalCount);
			 }else {
				 if(lstCnt==0) {
					 lstCnt = lstCnt+1;
					 eventList = le.getAllHistoryEvents(totalCount);
				 }
				
				 System.out.println("after storing data in an array size="+eventList.length);
				 //for testing add to array method with scroll
				 //le.getFPLockEventHistoryList(lkEventName, lkSubType, lkTime, lkcnt-1, sbcnt-1,timecnt-1,totalCount, eventList);
				 Thread.sleep(10000);
			 }
			
			 Log.addMessage("Lock History is listed");
		 }catch(Exception e) {
			 Log.addMessage("Lock History is listed");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Lock History is not listed");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void viewLockEventsTest() {
		try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
		
			if(device.equals("android")) {
				ld.clickHamburgerButton();
				Thread.sleep(2000);
				mp.clickLockImageInMenu("hl");
				Thread.sleep(2000);
			}
			ld.clickLockHistoryButton();
			Thread.sleep(3000);
			System.out.println("cnt");
			LockEventHistoryPage le = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
			String[][] eventList = le.getAllHistoryEvents(18);
			
			System.out.println("after");
			System.out.println("after storing data in an array size="+eventList.length);
			for(int i=0; i<eventList.length; i++) {
				for(int j=0; j<eventList[i].length;j++) {
					 System.out.print("row["+i+"]["+j+"]="+eventList[i][j]+" "); 
				}
				 System.out.print("\n");
			}
			Thread.sleep(10000);
		}catch(Exception e) {
			Log.addMessage("Failed to list lock events");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to list lock events");
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void clearHistoryWifiOffTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			LockEventHistoryPage le = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
			ClearHistoryPopupPage ch = new ClearHistoryPopupPage((AppiumDriver<MobileElement>) driver);
			System.out.println("Wait for Wifi off");
			Thread.sleep(10000);//for testing in between
			//ld.clickCancelButton();
			ld.clickLockHistoryButton();
			//ld.clickOKButton();
			Thread.sleep(3000);
			le.clearHistory();
			ld.clickCancelButton();
			/*ch.verifyPopUpVerbiage(expTitle, expMessage);
			ch.verifyCancelButton();
			ch.clickYesButton();
			Thread.sleep(3000);
			le.clearHistory();
			ClearHistoryPopupPage ch1 = new ClearHistoryPopupPage((AppiumDriver<MobileElement>) driver);*/
			LockEventHistoryPage le1 = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
			/*ch1.clickYesButton();
			le1.clearHistoryWhenEmpty(histClearMssg);*/
			le1.clickBackButton();
			Log.addMessage("Lock events history cleared");
		}catch(Exception e) {
			Log.addMessage("Failed to clear lock events history");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to clear lock events history");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="clearHist")
	public void clearHistoryTest(String expTitle, String expMessage, String histClearMssg, String histClearMsg) {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			LockEventHistoryPage le = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
			ClearHistoryPopupPage ch = new ClearHistoryPopupPage((AppiumDriver<MobileElement>) driver);
			System.out.println("Wait for BLE and Wifi ON");
			Thread.sleep(15000);//for testing in between
			
			ld.clickLockHistoryButton();
			Thread.sleep(3000);
			le.clearHistory();
			ch.verifyPopUpVerbiage(expTitle, expMessage);
			ch.verifyCancelButton();
			ch.clickYesButton();
			Thread.sleep(3000);
			le.clearHistory();
			ClearHistoryPopupPage ch1 = new ClearHistoryPopupPage((AppiumDriver<MobileElement>) driver);
			LockEventHistoryPage le1 = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
			if(device.equals("iOS")) {
				ch1.clickYesButton();
				le1.clearHistoryWhenEmpty(histClearMssg);
			}else {
				le1.clearHistoryWhenEmpty(histClearMsg);
			}
			le1.clickBackButton();
			Log.addMessage("Lock events history cleared");
		}catch(Exception e) {
			Log.addMessage("Failed to clear lock events history");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to clear lock events history");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void lockDashboardStatusTest() throws InterruptedException {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			System.out.println("Wait for Wifi off");
			Thread.sleep(25000);
			
			String chkMsg = "App: Locked//05:38 PM";
			chkMsg.split("/");
			String[] arrSplit = chkMsg.split("/");
		    for (int i=0; i < arrSplit.length; i++)
		    {
		      System.out.println(arrSplit[i]);
		    }
			/*ld.clickCancelButton();
			status = ld.getLockStatus();
			Log.addMessage("Lock status is: "+status+" when Wifi off");
			
			System.out.println("Wait for BLE off");
			Thread.sleep(15000);
			status = ld.getLockStatus();
			Log.addMessage("Lock status is: "+status+" when BLE off");
			ld.lockOperation();
			Log.addMessage("Lock status is: "+ld.getLockStatus()+" when BLE off");
			ld.lockOperation();
			Log.addMessage("Lock status is: "+ld.getLockStatus()+" when BLE off");
			ld.verifyBLEImage();
			Log.addMessage("BLE image is displayed in the dashboard");*/
			System.out.println("before refresh");
			//System.out.println("before refresh="+driver.getPageSource());
			ld.refreshlockDashboard();
			Thread.sleep(2000);
			//driver.navigate().to(appiumDriver.getCurrentUrl());
			//appiumDriver.navigate().refresh();
			System.out.println("after refresh");
			status = ld.getLockStatus();
			Log.addMessage("Lock status is: "+status+" after page refresh");
			
		}catch(Exception e) {
			Log.addMessage("Failed to lock/unlock");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to lock/unlock");
		}
	}
	
	
	ExcelRead excel = new ExcelRead();
	
	@DataProvider(name = "lockHistry")
	public Object[][] getDataLockHistoryiOS() throws Exception {
		return excel.getTableArray(InputData, "Validation", "fpLockEventHistory");
	}
	
	@DataProvider(name = "clearHist")
	public Object[][] getDataLockSetting() throws Exception {
		return excel.getTableArray(InputData, "App", "fpHistClearPopup");
	}

}
