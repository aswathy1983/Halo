package tests.app;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pages.app.AutoLockDelaySettingPage;
import pages.app.ChooseVerificationMethodPage;
import pages.app.CodeVerificationPage;
import pages.app.ConfirmDeleteLockPage;
import pages.app.EditAccessCodePage;
import pages.app.EditCodeNamePage;
import pages.app.LimitByDatePage;
import pages.app.LimitByWeekdayAndTimePage;
import pages.app.LockCancelPopupPage;
import pages.app.LockDashboardPage;
import pages.app.LockEventHistoryPage;
import pages.app.LockNamePage;
import pages.app.LockSettingsPage;
import pages.app.LoginPage;
import pages.app.MenuFlyoutPage;
import pages.app.PairedSmartPhoneListPage;
import pages.app.SelectScheduleTypePage;
import pages.app.SelectWeekDayPage;
import pages.app.UserFPAccessProfilePage;
import pages.app.ViewAccessCodesPage;
import utility.ExcelRead;
import utility.Log;
import utility.Utility;


public class HaloLockTest1 extends Settings{
	
	int sbcnt, timecnt, lkcnt, cntPhone, namecnt = 0;
	String delayStts, updtdTimeflyout, currStatus, autoLkStts,lkDispName = "";
	
	
	/** 
	* Method Name: loginUserTest(), 
	* This function is used to login to the app
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="userHlBvt")
	public void loginUserTest(String email, String password) {
		try {
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			
			 cp.login(email, password);
			 //Thread.sleep(5000);
			 cv.selectEmail();
			 cv.clickSubmit();
			// Thread.sleep(15000);
			 System.out.println("wait to retrieve verification code from email");
			 //get verification code from mail and submit
			 cvp.readCodeFromEmail("email.address1", "email.password1");//added 3rd param on 18-02-2021 for user account QA
			// cvp.enterMobileCode("123456");
			// Thread.sleep(5000);//to edit while testing
			 cvp.clickSubmitButton(); 
			// Thread.sleep(15000);
		}catch(Exception e) {
			Log.addMessage("Failed to log in");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to log in");
		}
	}
	
	/** 
	* Method Name: lockStatusAfterAcceptShareTest(), 
	* This function is used to do the check the lock status after share accept
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="adminLockPair")
	public void lockStatusAfterAcceptShareTest(String titleMsg, String valMsg) {
		try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 Utility.simpleWait(10000);
			 //check how to create the pair pop up on tapping lock status
			 ld.clickOKButton();
			 Utility.simpleWait(2000);
			 System.out.println("Lock Status after accepting share invitation is :"+ld.getLockStatus());
		}catch(Exception e) {
			Log.addMessage("Failed to get lock status after share invite accept");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to get lock status after share invite accept");
		}
	}
	
	/** 
	* Method Name: viewLastUpdateTimeMenuFlyoutTest(), 
	* This function is used to do the last update time in menuflyout page
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void viewLastUpdateTimeMenuFlyoutTest() throws InterruptedException {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			updtdTimeflyout="";
			ld.clickHamburgerButton();
			updtdTimeflyout = mp.getLastUpdateTime();
			mp.clickLockImageInMenu("hl");
		}catch(Exception e) {
			Log.addMessage("Failed to display last updated time");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display last updated time");
		}
	}
	
	/** 
	* Method Name: viewLastUpdateTimeMenuFlyoutTest(), 
	* This function is used to do the last update time in menuflyout page
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void viewLastUpdateTimeMenuFlyoutFPTest() throws InterruptedException {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			updtdTimeflyout="";
			ld.clickHamburgerButton();
			updtdTimeflyout = mp.getLastUpdateTime();
			mp.clickLockImageInMenu("fp");
		}catch(Exception e) {
			Log.addMessage("Failed to display last updated time");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display last updated time");
		}
	}
	
	/** 
	* Method Name: viewLastUpdtTimeInMenuTest(), 
	* This function is used to do the last update time in menuflyout page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="lkNameHl")
	public void viewLastUpdtTimeInMenuTest(String lkName, String hmName) throws InterruptedException {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			updtdTimeflyout="";
			ld.clickHamburgerButton();
			updtdTimeflyout = mp.getLastUpdateTime();
			 mp.verifyLockInMenu(hmName);
			 MenuFlyoutPage mf1 = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 mf1.clickLockInMenu(lkName);
		}catch(Exception e) {
			Log.addMessage("Failed to display last updated time");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display last updated time");
		}
	}
	
	/** 
	* Method Name: viewLastUpdtTimeInMenuFPTest(), 
	* This function is used to do the last update time in menuflyout page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="lkNameFP")
	public void viewLastUpdtTimeInMenuFPTest(String lkName, String hmName) throws InterruptedException {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			updtdTimeflyout="";
			ld.clickHamburgerButton();
			updtdTimeflyout = mp.getLastUpdateTime();
			 mp.verifyLockInMenu(hmName);
			 MenuFlyoutPage mf1 = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 mf1.clickLockInMenu(lkName);
		}catch(Exception e) {
			Log.addMessage("Failed to display last updated time");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display last updated time");
		}
	}
	
	/** 
	* Method Name: viewLastUpdtTimeInMenuARTest(), 
	* This function is used to do the last update time in menuflyout page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="lkNameAR")
	public void viewLastUpdtTimeInMenuARTest(String lkName, String hmName) throws InterruptedException {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			updtdTimeflyout="";
			ld.clickHamburgerButton();
			updtdTimeflyout = mp.getLastUpdateTime();
			 mp.verifyLockInMenu(hmName);
			 MenuFlyoutPage mf1 = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 mf1.clickLockInMenu(lkName);
		}catch(Exception e) {
			Log.addMessage("Failed to display last updated time");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display last updated time");
		}
	}
	
	/** 
	* Method Name: lockFunctionalityTest(), 
	* This function is used to do the lock unlock operation
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void lockFunctionalityTest() throws InterruptedException {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			String status = ld.getLockStatus();
			if(status.equals("Locked")) {
				ld.unlockOperation();
				//Utility.simpleWait(5000);//commented on 06-10-2020
				//ld.lockOperation();
				//Utility.simpleWait(5000);//commented on 06-10-2020
			}
			else if(status.equals("Unlocked")) {
				ld.lockOperation();
				//Utility.simpleWait(5000);//commented on 06-10-2020
				//ld.unlockOperation();
				//Utility.simpleWait(5000);//commented on 06-10-2020
			}
			else {
				Log.addMessage("Lock status is: "+status);
			}
		}catch(Exception e) {
			Log.addMessage("Failed to lock/unlock");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to lock/unlock");
		}
	}
	
	/** 
	* Method Name: viewLockHistoryTest(), 
	* This function is used to check the UI of history page
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void viewLockHistoryTest() {
		try {
			 LockDashboardPage lp = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 LockEventHistoryPage le = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
			 lp.clickLockHistoryButton();
			 //Utility.simpleWait(5000);
			 le.verifyHaloLockHistoryScreen();
		}catch(Exception e) {
			Log.addMessage("Failed to view access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to view access code");
		}
	}
	
	/** 
	* Method Name: viewlockActivityTest(), 
	* This function is used to view the lock history
	*/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="lockActivity")
	public void viewlockActivityTest(String lkEventName,String lkiosEvent) {
		 try {
			 LockEventHistoryPage le = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
			 if(device.equals("iOS")) {
				 le.getLockHistoryiOSViewList(lkiosEvent);
			 }else {
				 le.getLockHistoryViewList(lkEventName);
			 }
			 Log.addMessage("Lock History is listed");
		 }catch(Exception e) {
			 Log.addMessage("Lock History is listed");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Lock History is not listed");
		 }
	}
	
	
	/** 
	* Method Name: clearLockHistoryTest(), 
	* This function is used to clear the lock history 
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void clearLockHistoryTest() {
		try {
			 LockEventHistoryPage le = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
			 LockCancelPopupPage lc = new LockCancelPopupPage((AppiumDriver<MobileElement>) driver);
			 //Utility.simpleWait(8000);//commented on 06-10-2020 for bvt
			 le.clearHistory();
			 //checkhow to handle if OK button not there
			 if(le.checkOkButton()) {
				 lc.clickOkButton();
			 }
			 //Utility.simpleWait(8000);//commented on 06-10-2020 for bvt
			 le.clickBackButton();
		}catch(Exception e) {
			Log.addMessage("Failed to view access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to view access code");
		}
	}
	
	/** 
	* Method Name: clearLockHistoryFPTest(), 
	* This function is used to clear the lock history 
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void clearLockHistoryFPTest() {
		try {
			 LockEventHistoryPage le = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
			 LockCancelPopupPage lc = new LockCancelPopupPage((AppiumDriver<MobileElement>) driver);
			 //Utility.simpleWait(8000);//commented on 06-10-2020 for bvt
			 le.clearHistory();
			 //checkhow to handle if OK button not there
			 if(le.checkOkButtonFP()) {
				 lc.clickOkButton();
			 }
			 //Utility.simpleWait(8000);//commented on 06-10-2020 for bvt
			 le.clickBackButton();
		}catch(Exception e) {
			Log.addMessage("Failed to view access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to view access code");
		}
	}
	
	/** 
	* Method Name: homeLockSettingsTest(), 
	* This function is used to verify the lock settings page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="hlLockSet")
	public void homeLockSettingsTest(String lkName,String lkSound, String lkLED, String lkAuto) {
		 try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			 ld.clickLockSettingsButton();
			 ls.getLockSettingsList(lkName, lkSound, lkLED, lkAuto);
			 Log.addMessage("Lock History is listed");
		 }catch(Exception e) {
			 Log.addMessage("Lock History is listed");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Lock History is not listed");
		 }
	}
	
	/** 
	* Method Name: homeLockSettingsFPTest(), 
	* This function is used to verify the lock settings page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="fpLockSet")
	public void homeLockSettingsFPTest(String lkName,String lkSound, String lkLED, String lkAuto) {
		 try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			 ld.clickLockSettingsButton();
			 ls.getLockSettingsList(lkName, lkSound, lkLED, lkAuto);
			 Log.addMessage("Lock History is listed");
		 }catch(Exception e) {
			 Log.addMessage("Lock History is listed");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Lock History is not listed");
		 }
	}
	
	/** 
	* Method Name: homeLockSettingsARTest(), 
	* This function is used to verify the lock settings page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="arLockSet")
	public void homeLockSettingsARTest(String lkName,String lkSound, String lkLED, String lkAuto) {
		 try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			 ld.clickLockSettingsButton();
			 ls.getLockSettingsList(lkName, lkSound, lkLED, lkAuto);
			 Log.addMessage("Lock History is listed");
		 }catch(Exception e) {
			 Log.addMessage("Lock History is listed");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Lock History is not listed");
		 }
	}
	
	/** 
	* Method Name: homePairedPhoneTest(), 
	* This function is used to verify the paired smart phones are retained
	**/
	@SuppressWarnings("unchecked")
	@Test( dataProvider="hmLkPrdPhone")
	public void homePairedPhoneTest(String phNameExp) {
		 try {
			 LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			 PairedSmartPhoneListPage ps = new PairedSmartPhoneListPage((AppiumDriver<MobileElement>) driver);
			 if(cntPhone==0) {
				 ls.clickPairedSmartPhonesButton();
			 }
			 cntPhone++;
			 ps.pairedPhoneList(phNameExp, cntPhone-1);
			 Log.addMessage("Paired Phones are listed");
		 }catch(Exception e) {
			 Log.addMessage("Paired Phones are not listed");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Paired Phones are not listed");
		 }
	}
	
	/** 
	* Method Name: navBackTest(), 
	* This function is used to navigate back to lock settings page
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void navBackTest() {
		 try {
			 PairedSmartPhoneListPage ps = new PairedSmartPhoneListPage((AppiumDriver<MobileElement>) driver);
			 ps.clickBackButton();
			 Log.addMessage("Paired Phones are listed");
		 }catch(Exception e) {
			 Log.addMessage("Paired Phones are not listed");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Paired Phones are not listed");
		 }
	}
	
	/** 
	* Method Name: lockSettingsTest(), 
	* This function is used to update the lock settings 
	**/
	@SuppressWarnings("unchecked")
	@Test( dataProvider="lockSettingHl")
	public void lockSettingsTest(String lockName, String phameExp, String phameios) {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			LockNamePage ln = new LockNamePage((AppiumDriver<MobileElement>) driver);
			AutoLockDelaySettingPage al = new AutoLockDelaySettingPage((AppiumDriver<MobileElement>) driver);
			PairedSmartPhoneListPage ps = new PairedSmartPhoneListPage((AppiumDriver<MobileElement>) driver);
			ld.clickLockSettingsButton();
			//Utility.simpleWait(8000);//commented on 23rd oct 2020 check
			//ls.waitForSync();//check//commented on 27-11-2020
			ls.waitForSettings();
			ls.clickEditLockNameButton();
			ln.setLockName(lockName);
			ln.clickSubmitButton();
			//Utility.simpleWait(8000);//commented on 23rd oct 2020 check
			if(device.equals("android")) {
				ln.clickOkButton();
			}
			Log.addMessage("Lock name updated");
			//Utility.simpleWait(3000);//commented on 23rd oct 2020 check
			//ls.waitForSync();//commented on 27-11-2020
			ls.waitForSettings();
			ls.clickLockSoundsButton();
			//Utility.simpleWait(25000);//didnt observe delay after 1st try check in ios//commented on 27-11-2020
			Log.addMessage("Lock sounds updated");
			ls.clickAutoLockButton();
			//Utility.simpleWait(3000);//commented on 23rd oct 2020 check
			if(al.getAutoDelayStatus().equals("Off") || al.getAutoDelayStatus().equals("0")) {
				al.clickAutoLock();
				//Utility.simpleWait(25000);//check why required -if this delay in ios//commented on 27-11-2020
			}
			//check below code failed in bvt
			al.set_10min_Delay();
			//Utility.simpleWait(25000);//check if this delay in ios not in android//commented on 27-11-2020
			Log.addMessage("Auto lock delay status set");
			if(device.equals("android")) {
				al.clickBackButton();
			}
			//Utility.simpleWait(3000);//commented on 23rd oct 2020 
			ls.clickPairedSmartPhonesButton();
			//Utility.simpleWait(3000);//check how to remove this sleep
			ps.waitForSmartPhone();//check added on 27th Oct 2020
			if(device.equals("iOS")) {
				ps.pairedPhoneList(phameios, cntPhone);//change the function for 1 data.
			}else {
				ps.pairedPhoneList(phameExp, cntPhone);//change the function for 1 data.
			}
			//Utility.simpleWait(3000);//commented on 23rd oct 2020 
			ps.clickBackButton();
			ls.clickLEDStatusButton();//check how to remove this sleep
			//Utility.simpleWait(25000);//commented on 27-11-2020
			//check below code for android
			/*ls.clickGoogleAstButton();
			ls.clickBackButton();
			*/
			Log.addMessage("lock settings displayed");
			Assert.assertTrue(true,"lock settings displayed");
		}catch(Exception e) {
			 Log.addMessage("Failed to update Lock Settings");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to update Lock Settings");
		 }
	}
	//check below function
	/** added on 01-12-2020 **/
	/** 
	* Method Name: lockSettingNameTest(), 
	* This function is used to update lock name
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="hllockSetting")
	public void lockSettingNameTest(String lockName, String phameExp, String phameios) {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			LockNamePage ln = new LockNamePage((AppiumDriver<MobileElement>) driver);
			lkDispName = ls.getLockName();
			ls.clickEditLockNameButton();
			//System.out.println("lname="+ls.getLockName()+", lockName="+lockName);
			if(lkDispName!="") {
				//System.out.println("in not null");
				if(!lkDispName.equals(lockName)) {
					ln.setLockName(lockName);
				}else {
					ln.setLockName(lockName+"i");
				}
			}
			ln.clickSubmitButton();
			if(device.equals("android")) {
				ln.clickOkButton();
			}
			
			Log.addMessage("Lock name updated");
			Assert.assertTrue(true,"Lock name updated");
		}catch(Exception e) {
			 Log.addMessage("Failed to update lock name");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to update lock name");
		 }
	}
	
	/** 
	* Method Name: lockSettingNameFPTest(), 
	* This function is used to update lock name
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="fplockSetting")
	public void lockSettingNameFPTest(String lockName, String phameExp, String phameios) {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			LockNamePage ln = new LockNamePage((AppiumDriver<MobileElement>) driver);
			lkDispName = ls.getLockName();
			ls.clickEditLockNameButton();
			//System.out.println("lname="+ls.getLockName()+", lockName="+lockName);
			if(lkDispName!="") {
				//System.out.println("in not null");
				if(!lkDispName.equals(lockName)) {
					ln.setLockName(lockName);
				}else {
					ln.setLockName(lockName+"i");
				}
			}
			ln.clickSubmitButton();
			if(device.equals("android")) {
				ln.clickOkButton();
			}
			Log.addMessage("Lock name updated");
			Assert.assertTrue(true,"Lock name updated");
		}catch(Exception e) {
			 Log.addMessage("Failed to update lock name");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to update lock name");
		 }
	}
	
	/** 
	* Method Name: lockSettingNameARTest(), 
	* This function is used to update lock name
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="arlockSetting")
	public void lockSettingNameARTest(String lockName, String phameExp, String phameios) {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			LockNamePage ln = new LockNamePage((AppiumDriver<MobileElement>) driver);
			lkDispName = ls.getLockName();
			ls.clickEditLockNameButton();
			//System.out.println("lname="+ls.getLockName()+", lockName="+lockName);
			if(lkDispName!="") {
				//System.out.println("in not null");
				if(!lkDispName.equals(lockName)) {
					ln.setLockName(lockName);
				}else {
					ln.setLockName(lockName+"i");
				}
			}
			ln.clickSubmitButton();
			if(device.equals("android")) {
				ln.clickOkButton();
			}
			Log.addMessage("Lock name updated");
			Assert.assertTrue(true,"Lock name updated");
		}catch(Exception e) {
			 Log.addMessage("Failed to update lock name");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to update lock name");
		 }
	}
	/** 
	* Method Name: lockSettingSoundTest(), 
	* This function is used to update lock sounds
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void lockSettingSoundTest() {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			
			ls.clickLockSoundsButton();
			Log.addMessage("Lock sounds updated");
			ls.clickAutoLockButton();
			
			Log.addMessage("Lock sounds displayed");
			Assert.assertTrue(true,"lock settings displayed");
		}catch(Exception e) {
			 Log.addMessage("Failed to update lock sound");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to update lock soud ");
		 }
	}
	
	/** 
	* Method Name: verifyLockSoundSyncFailedPopupTest(), 
	* This function is used to handle the sync failed pop up in the Lock Settings Page
	*/
	@SuppressWarnings("unchecked")
	@Test
	public void verifyLockSoundSyncFailedPopupTest() throws InterruptedException {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			if(ls.checkOkButton()) {
				ls.clickSyncFailPopUp();
			}
			//added below check to verify for an overlapping sync failed pop up and syncing pop up
			if(ls.checkOkButton()) {
				ls.clickOkButton();
			}
			//ls.clickAutoLockButton();
			Assert.assertTrue(true, "Clicked sync failed popup in lock sounds");
		}catch(Exception e) {
			Log.addMessage("Failed to click sync failed popup in lock sounds");
			Assert.assertTrue(false, "Failed to click sync failed popup in lock sounds");
		}
	}
	
	/** 
	* Method Name: lockSettingAutoLockTest(), 
	* This function is used to update auto lock delay
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void lockSettingAutoLockTest() {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			AutoLockDelaySettingPage al = new AutoLockDelaySettingPage((AppiumDriver<MobileElement>) driver);
			ls.clickAutoLockButton();
			if(al.getAutoDelayStatus().equals("Off") || al.getAutoDelayStatus().equals("0")) {
				al.clickAutoLock();
			}
			al.set_10min_Delay();
			Log.addMessage("Auto lock delay status set");
			Assert.assertTrue(true,"Auto lock settings displayed");
		}catch(Exception e) {
			 Log.addMessage("Failed to update auto lock settings");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to update auto lock settings");
		 }
	}
	

	/** 
	* Method Name: lockSettingARAutoLockTest(), 
	* This function is used to update auto lock
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void lockSettingARAutoLockTest() {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			AutoLockDelaySettingPage al = new AutoLockDelaySettingPage((AppiumDriver<MobileElement>) driver);
			ls.clickAutoLockButton();
			if(al.getAutoDelayStatus().equals("Off") || al.getAutoDelayStatus().equals("0")) {
				al.clickAutoLock();
			}
			if(device.equals("iOS")) {
				al.set_10min_Delay();
			}else {
				LockSettingsPage ls1 = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
				ls1.clickAutoLockButton();
				al.set_10min_Delay();
			}
			Log.addMessage("Auto lock delay status set");
			
			Log.addMessage("lock settings displayed");
			Assert.assertTrue(true,"Auto lock settings displayed");
		}catch(Exception e) {
			 Log.addMessage("Failed to update auto lock settings");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to update auto lock settings");
		 }
	}
	
	/** 
	* Method Name: verifyAutoLockSyncFailedPopupTest(), 
	* This function is used to handle the sync failed pop up in the Lock Settings Page
	*/
	@SuppressWarnings("unchecked")
	@Test
	public void verifyAutoLockSyncFailedPopupTest() throws InterruptedException {
		try {
			AutoLockDelaySettingPage al = new AutoLockDelaySettingPage((AppiumDriver<MobileElement>) driver);
			al.checkAutoLockOff();
			
			//added below check to verify for an overlapping sync failed pop up and syncing pop up
			if(al.checkOkButton()) {
				//System.out.println("in ok");
				al.clickOkButton();
			}
			/*if(device.equals("android")) {
				al.clickBackButton();
			}else if(device.equals("iOS")) {
				al.clickAutoLockBackButton();
			}*/
			Assert.assertTrue(true, "Clicked sync failed popup in lock sounds");
		}catch(Exception e) {
			Log.addMessage("Failed to click sync failed popup in lock sounds");
			Assert.assertTrue(false, "Failed to click sync failed popup in lock sounds");
		}
	}
	
	/** 
	* Method Name: verifyAutoLockPageTest(), 
	* This function is used to handle the sync failed pop up in the Lock Settings Page
	*/
	@SuppressWarnings("unchecked")
	@Test
	public void verifyAutoLockPageTest() throws InterruptedException {
		try {
			AutoLockDelaySettingPage al = new AutoLockDelaySettingPage((AppiumDriver<MobileElement>) driver);
			
			/*if(device.equals("android")) {
				al.clickBackButton();
			}else if(device.equals("iOS")) {*/
				al.clickAutoLockBackButton();
			//}
			Assert.assertTrue(true, "Clicked sync failed popup in lock sounds");
		}catch(Exception e) {
			Log.addMessage("Failed to click sync failed popup in lock sounds");
			Assert.assertTrue(false, "Failed to click sync failed popup in lock sounds");
		}
	}
	
	
	/** 
	* Method Name: lockSettingLedStatusTest(), 
	* This function is used to update led status
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void lockSettingLedStatusTest() {
		try {
			LockSettingsPage ls1 = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			ls1.clickLEDStatusButton();
			Log.addMessage("Lock led status displayed");
			Assert.assertTrue(true,"Lock led status displayed");
		}catch(Exception e) {
			 Log.addMessage("Failed to update lock led status");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to update lock led status");
		 }
	}
	
	/** 
	* Method Name: verifySyncFailedPopupTest(), 
	* This function is used to handle the sync failed pop up in the Lock Settings Page
	*/
	@SuppressWarnings("unchecked")
	@Test
	public void verifySyncFailedPopupTest() throws InterruptedException {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			if(ls.checkOkButton()) {
				ls.clickSyncFailPopUp();
			}
			Assert.assertTrue(true, "Clicked sync failed popup");
		}catch(Exception e) {
			Log.addMessage("Failed to click sync failed popup");
			Assert.assertTrue(false, "Failed to click sync failed popup");
		}
	}
	
	
	/** 
	* Method Name: verifyLockSettingTest(), 
	* This function is used to verify if the Lock Settings are updated
	*/
	@SuppressWarnings("unchecked")
	@Test(dataProvider = "stsupdt")
	public void verifyLockSettingTest(String autSts, String ledSts, String lkSndSts, String anAutStts) throws InterruptedException {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			if(device.equals("iOS")) {
				ls.verifyAutoLockUpdate(autSts, ledSts, lkSndSts);
			}else {
				ls.verifyAutoLockUpdate(anAutStts, ledSts, lkSndSts);
			}
		}catch(Exception e) {
			Log.addMessage("Failed to display all elements in UI for FP username view page");
			Assert.assertTrue(false, "Failed to display all elements in UI for FP username view page");
		}
	}
	
	/** 
	* Method Name: navBackAgnTest(), 
	* This function is used to go back to Lock Dashboard Page
	*/
	@SuppressWarnings("unchecked")
	@Test
	public void navBackAgnTest() {
		 try {
			 LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			 ls.clickBackButton();
			 Log.addMessage("Paired Phones are listed");
		 }catch(Exception e) {
			 Log.addMessage("Paired Phones are not listed");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Paired Phones are not listed");
		 }
	}
	/**  added on 01-12-2020  **/
	
	/** 
	* Method Name: verifyUIViewUserName(), 
	* This function is used to view the  UI of access code list page
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void verifyUIViewUserName() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			//va.clickBackButton();
			ld.clickAccessCodeButton();
			va.verifyUIFP();
			va.getAccessCodeCnt();
			Log.addMessage("UI for selecting user access name is dispalyed");
		}catch(Exception e) {
			Log.addMessage("UI for selecting  user access name is not dispalyed");
			e.printStackTrace();
			Assert.assertTrue(false, "UI for selecting  user access name is not dispalyed");
		}
	}
	
	/** 
	* Method Name: verifyUIUserProfile(), 
	* This function is used to view the  UI of access code list page
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void verifyUIUserProfile() {
		try {
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			va.selFirstFPUser();
			ac.verifyUIUserAccessProfile();
			Log.addMessage("UI of  user access profile details is dispalyed");
		}catch(Exception e) {
			Log.addMessage("UI of user access profile details not dispalyed");
			e.printStackTrace();
			Assert.assertTrue(false, "UI of user access profile details not dispalyed");
		}
	}
	
	/** 
	* Method Name: verifyUIFpUserProfile(), 
	* This function is used to view the  UI of access code list page
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void verifyUIFpUserProfile() {
		try {
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			va.selFirstFPUser();
			ac.verifyUIFPUserProfile();
			Log.addMessage("UI of  user access profile details is dispalyed");
		}catch(Exception e) {
			Log.addMessage("UI of user access profile details not dispalyed");
			e.printStackTrace();
			Assert.assertTrue(false, "UI of user access profile details not dispalyed");
		}
	}
	
	/** 
	* Method Name: updateUserProfileName(), 
	* This function is used to view the  UI of access code list page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="profName")
	public void updateUserProfileName(String newName, String prvName) {
		try {
			EditCodeNamePage ec = new EditCodeNamePage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage va = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			System.out.println("namecnt="+namecnt);
			if(device.equals("iOS")) {
				va.clickEditCdName();
			}else {
				va.clickEditCodeName();
			}
			ec.enterAccessCodeName(newName);
			ec.clickSubmitButton();
			va.clickOkButton();
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			vc.waitForSyncComplete();
			Assert.assertTrue(true, "User name of access code profile is updated");
			Log.addMessage("User name of access code profile is updated");
		}catch(Exception e) {
			Log.addMessage("Failed to update user name of access code profile");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update user name of access code profile");
		}
	}
	
	/** 
	* Method Name: updateARUserProfileName(), 
	* This function is used to view the  UI of access code list page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="profName")
	public void updateARUserProfileName(String newName, String prvName) {
		try {
			EditCodeNamePage ec = new EditCodeNamePage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage va = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			System.out.println("namecnt="+namecnt);
			if(device.equals("iOS")) {
				va.clickEditCdName();
			}else {
				va.clickEditCodeName();
			}
			ec.enterAccessCodeName(newName);
			ec.clickSubmitButton();
			if(device.equals("android")) {
				ViewAccessCodesPage vac = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
				vac.waitForSyncComplete();
				if(vac.checkOkButton()) {
					va.clickOkButton();
				} 
			}else {
				va.clickOkButton();
			}
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			vc.waitForSyncComplete();
			Assert.assertTrue(true, "User name of access code profile is updated");
			Log.addMessage("User name of access code profile is updated");
		}catch(Exception e) {
			Log.addMessage("Failed to update user name of access code profile");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update user name of access code profile");
		}
	}
	
	
	/** 
	* Method Name: updateFPUserProfileName(), 
	* This function is used to view the  UI of access code list page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="profName")
	public void updateFPUserProfileName(String newName, String prvName) {
		try {
			EditCodeNamePage ec = new EditCodeNamePage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage va = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			va.clickEditCodeName();
			ec.enterAccessCodeName(newName);
			namecnt++;
			ec.clickSubmitButton();
			va.clickOkButton();
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			vc.waitForSyncComplete();
			Assert.assertTrue(true, "User name of access code profile is updated");
			Log.addMessage("User name of access code profile is updated");
		}catch(Exception e) {
			Log.addMessage("Failed to update user name of access code profile");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update user name of access code profile");
		}
	}
	
	

	/** 
	* Method Name: verifySyncFailNamePopupTest(), 
	* This function is used to view the  UI of access code list page
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void verifySyncFailNamePopupTest() {
		try {
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			System.out.println("namecnt="+namecnt);
			//vc.waitForSyncComplete();
			vc.selFirstFPUser();
			//check for delete sync fail
			vc.checkSyncFail();
			vc.selFirstFPUser();
			//check if name updated with new 
			Assert.assertTrue(true, "Syncing procees is complete for access name update");
			Log.addMessage("Syncing procees is complete for access name update");
		}catch(Exception e) {
			Log.addMessage("Failed to complete syncing procees");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to complete syncing procees");
		}
	}
	
	/** 
	* Method Name: verifySyncFailNameARPopupTest(), 
	* This function is used to view the  UI of access code list page
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void verifySyncFailNameARPopupTest() {
		try {
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			System.out.println("namecnt="+namecnt);
			if(device.equals("android")) {
				vc.selFirstFPUser();
			}
			vc.checkSyncFail();
			vc.selFirstFPUser();
			//check if name updated with new 
			Assert.assertTrue(true, "Syncing procees is complete for access name update");
			Log.addMessage("Syncing procees is complete for access name update");
		}catch(Exception e) {
			Log.addMessage("Failed to complete syncing procees");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to complete syncing procees");
		}
	}
	
	/** 
	* Method Name: updateToPrvUserProfileName(), 
	* This function is used to view the  UI of access code list page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="profName")
	public void updateToPrvUserProfileName(String newName, String prvName) {
		try {
			EditCodeNamePage ec = new EditCodeNamePage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage va = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			System.out.println("namecnt="+namecnt);
			/*vc.waitForSyncComplete();
			vc.selFirstFPUser();*/
			//check for delete sync fail
			if(device.equals("iOS")) {
				va.clickEditCdName();
			}else {
				va.clickEditCodeName();
			}
		//	if(namecnt==0) {
				ec.enterAccessCodeName(prvName);
				//namecnt++;
			//}
			ec.clickSubmitButton();
			va.clickOkButton();
			//ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			System.out.println("namecnt="+namecnt);
			vc.waitForSyncComplete();
			Assert.assertTrue(true, "User name of access code profile is updated");
			Log.addMessage("User name of access code profile is updated");
		}catch(Exception e) {
			Log.addMessage("Failed to update user name of access code profile");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update user name of access code profile");
		}
	}
	
	/** 
	* Method Name: updateToPrvARUserProfileName(), 
	* This function is used to view the  UI of access code list page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="profName")
	public void updateToPrvARUserProfileName(String newName, String prvName) {
		try {
			EditCodeNamePage ec = new EditCodeNamePage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage va = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			System.out.println("namecnt="+namecnt);
			if(device.equals("android")) {
				vc.selFirstFPUser();
			}
			//check for delete sync fail
			if(device.equals("iOS")) {
				va.clickEditCdName();
			}else {
				va.clickEditCodeName();
			}
			ec.enterAccessCodeName(prvName);
			ec.clickSubmitButton();
			if(device.equals("android")) {
				ViewAccessCodesPage vac = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
				vac.waitForSyncComplete();
				if(vac.checkOkButton()) {
					va.clickOkButton();
				}
			}else {
				va.clickOkButton();
			}
			System.out.println("namecnt="+namecnt);
			vc.waitForSyncComplete();
			Assert.assertTrue(true, "User name of access code profile is updated");
			Log.addMessage("User name of access code profile is updated");
		}catch(Exception e) {
			Log.addMessage("Failed to update user name of access code profile");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update user name of access code profile");
		}
	}
	
	/** 
	* Method Name: updateToPrvFpUserProfileName(), 
	* This function is used to view the  UI of access code list page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="profName")
	public void updateToPrvFpUserProfileName(String newName, String prvName) {
		try {
			EditCodeNamePage ec = new EditCodeNamePage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage va = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			va.clickEditCodeName();
			ec.enterAccessCodeName(prvName);
			ec.clickSubmitButton();
			va.clickOkButton();
			vc.waitForSyncComplete();
			Assert.assertTrue(true, "User name of access code profile is updated");
			Log.addMessage("User name of access code profile is updated");
		}catch(Exception e) {
			Log.addMessage("Failed to update user name of access code profile");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update user name of access code profile");
		}
	}
	
	/** 
	* Method Name: verifySyncFailUpdatePrvNamePopupTest(), 
	* This function is used to view the  UI of access code list page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="profName")
	public void verifySyncFailUpdatePrvNamePopupTest(String newName, String prvName) {
		try {
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			System.out.println("namecnt="+namecnt);
			//vc.waitForSyncComplete();
			vc.selFirstFPUser();
			//check for delete sync fail
			vc.checkSyncFail();
			vc.selFirstFPUser();
			//check if name updated with new 
			Assert.assertTrue(true, "Syncing failed for access name updated");
			Log.addMessage("Syncing failed for access name update");
		}catch(Exception e) {
			Log.addMessage("Syncing success");
			e.printStackTrace();
			Assert.assertTrue(false, "Syncing success");
		}
	}
	
	/** 
	* Method Name: verifySyncFailARPrvNamePopupTest(), 
	* This function is used to view the  UI of access code list page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="profName")
	public void verifySyncFailARPrvNamePopupTest(String newName, String prvName) {
		try {
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			System.out.println("namecnt="+namecnt);
			if(device.equals("android")) {
				vc.selFirstFPUser();
			}
			//check for delete sync fail
			vc.checkSyncFail();
			vc.selFirstFPUser();
			//check if name updated with new 
			Assert.assertTrue(true, "Syncing failed for access name updated");
			Log.addMessage("Syncing failed for access name update");
		}catch(Exception e) {
			Log.addMessage("Syncing success");
			e.printStackTrace();
			Assert.assertTrue(false, "Syncing success");
		}
	}
	
	
	/** 
	* Method Name: disableAccessProfile(), 
	* This function is used to disable access code
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void disableAccessProfile() {
		try {
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			//commented on 01-12-2020
			//va.waitForSyncComplete();
			System.out.println("in disable code");
			//commented on 01-12-2020
			/*if(device.equals("iOS")) {//added on 27th nov 2020
				Utility.simpleWait(3000);
			}
			va.selFirstFPUser();*/
			
			System.out.println("in disable code1");
			if(device.equals("iOS")) {
				Utility.simpleWait(3000);
				ac.disableAcsCode();//check for fp
			}else {
				ac.disableAccessCode();
			}
			System.out.println("clicked disable code2");
			va.waitForSyncComplete();
			Log.addMessage("Access Code disabled  for the profile");
		}catch(Exception e) {
			Log.addMessage("Access Code disable failed for the profile");
			e.printStackTrace();
			Assert.assertTrue(false, "Access Code disable failed for the profile");
		}
	}	
	
	/** 
	* Method Name: disableARAccessProfile(), 
	* This function is used to disable access code
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void disableARAccessProfile() {
		try {
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			//if(device.equals("android")) {//commented today 
			if(ac.checkSwitchButton()) {
				va.selFirstFPUser();
			}
			//}
			System.out.println("in disable code1");
			if(device.equals("iOS")) {
				//Utility.simpleWait(3000);//commented today
				ac.disableAcsCode();//check for fp
			}else {
				ac.disableAccessCode();
			}
			System.out.println("clicked disable code2");
			va.waitForSyncComplete();
			Log.addMessage("Access Code disabled  for the profile");
		}catch(Exception e) {
			Log.addMessage("Access Code disable failed for the profile");
			e.printStackTrace();
			Assert.assertTrue(false, "Access Code disable failed for the profile");
		}
	}	
	
	/** 
	* Method Name: disableFpAccessProfile(), 
	* This function is used to disable access code
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void disableFpAccessProfile() {
		try {
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			ac.disableAccessCode();
			va.waitForSyncComplete();
			Log.addMessage("Access Code disabled  for the profile");
		}catch(Exception e) {
			Log.addMessage("Access Code disable failed for the profile");
			e.printStackTrace();
			Assert.assertTrue(false, "Access Code disable failed for the profile");
		}
	}	
	
	/** 
	* Method Name: verifySyncFailDisablePopupTest(), 
	* This function is used to view the  UI of access code list page
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void verifySyncFailDisablePopupTest() {
		try {
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			System.out.println("namecnt="+namecnt);
			//vc.waitForSyncComplete();
			vc.selFirstFPUser();
			//check for delete sync fail
			vc.checkSyncFail();
			vc.selFirstFPUser();
			//check if name updated with new 
			Assert.assertTrue(true, "Syncing procees is complete for access name update");
			Log.addMessage("Syncing procees is complete for access name update");
		}catch(Exception e) {
			Log.addMessage("Failed to complete syncing procees");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to complete syncing procees");
		}
	}
	
	/** 
	* Method Name: verifySyncFailARDisablePopupTest(), 
	* This function is used to view the  UI of access code list page
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void verifySyncFailARDisablePopupTest() {
		try {
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			System.out.println("namecnt="+namecnt);
			if(device.equals("android")) {
				vc.selFirstFPUser();
			}
			vc.checkSyncFail();
			vc.selFirstFPUser();
			Assert.assertTrue(true, "Syncing procees is complete for access name update");
			Log.addMessage("Syncing procees is complete for access name update");
		}catch(Exception e) {
			Log.addMessage("Failed to complete syncing procees");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to complete syncing procees");
		}
	}
	
	/** 
	* Method Name: enableAccessProfile(), 
	* This function is used to enable access code
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void enableAccessProfile() {
		try {
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			System.out.println("Selected Access disabled profile1");
			if(device.equals("iOS")) {
				ac.disableAcsCode();
			}else {
				ac.disableAccessCode();
			}
			System.out.println("clicked enable code2");
			va.waitForSyncComplete();
			System.out.println("Access enabled loop2");
			Log.addMessage("Access Code enabled  for the profile");
		}catch(Exception e) {
			Log.addMessage("Access Code enable failed for the profile");
			e.printStackTrace();
			Assert.assertTrue(false, "Access Code enable failed for the profile");
		}
	}
	
	/** 
	* Method Name: enableARAccessProfile(), 
	* This function is used to enable access code
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void enableARAccessProfile() {
		try {
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			//if(device.equals("android")) {//commented today
			if(ac.checkSwitchButton()) {
				va.selFirstFPUser();
			}
			//}
			System.out.println("Selected Access disabled profile1");
			if(device.equals("iOS")) {
				ac.disableAcsCode();
			}else {
				if(ac.checkSwitchButton()) {
					ac.disableAccessCode();
				}
			}
			System.out.println("clicked enable code2");
			va.waitForSyncComplete();
			System.out.println("Access enabled loop2");
			Log.addMessage("Access Code enabled  for the profile");
		}catch(Exception e) {
			Log.addMessage("Access Code enable failed for the profile");
			e.printStackTrace();
			Assert.assertTrue(false, "Access Code enable failed for the profile");
		}
	}
	
	/** 
	* Method Name: enableFpAccessProfile(), 
	* This function is used to enable access code
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void enableFpAccessProfile() {
		try {
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			ac.disableAccessCode();
			va.waitForSyncComplete();
			System.out.println("Access enabled loop2");
			Log.addMessage("Access Code enabled  for the profile");
		}catch(Exception e) {
			Log.addMessage("Access Code enable failed for the profile");
			e.printStackTrace();
			Assert.assertTrue(false, "Access Code enable failed for the profile");
		}
	}
	
	/** 
	* Method Name: verifySyncFailEnablePopupTest(), 
	* This function is used to view the  UI of access code list page
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void verifySyncFailEnablePopupTest() {
		try {
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			System.out.println("namecnt="+namecnt);
			//vc.waitForSyncComplete();
			vc.selFirstFPUser();
			//check for delete sync fail
			vc.checkSyncFail();
			vc.selFirstFPUser();
			//check if name updated with new 
			Assert.assertTrue(true, "Syncing procees is complete for access name update");
			Log.addMessage("Syncing procees is complete for access name update");
		}catch(Exception e) {
			Log.addMessage("Failed to complete syncing procees");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to complete syncing procees");
		}
	}
	
	/** 
	* Method Name: verifySyncFailAREnablePopupTest(), 
	* This function is used to view the  UI of access code list page
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void verifySyncFailAREnablePopupTest() {
		try {
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			System.out.println("namecnt="+namecnt);
			if(device.equals("android")) {
				vc.selFirstFPUser();
			}
			//check for delete sync fail
			vc.checkSyncFail();
			vc.selFirstFPUser();
			//check if name updated with new 
			Assert.assertTrue(true, "Syncing procees is complete for access name update");
			Log.addMessage("Syncing procees is complete for access name update");
		}catch(Exception e) {
			Log.addMessage("Failed to complete syncing procees");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to complete syncing procees");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void changeFPUserProfileDigitType() {
		try {
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			
			System.out.println("select changeFPUserProfileDigitType first");
			//va.clickBackButton();//06-10-2020
			va.selFirstFPUser();
			//Utility.simpleWait(3000);//commented on 27-10-2020
			System.out.println("select selSecondFPUser");
			ac.clickFingerPrint1();
			System.out.println("select clickFingerPrint1");
			ac.clickRightButton();
			System.out.println("select clickRightButton");
			ac.clickIndexButton();
			System.out.println("select clickIndexButton");
			ac.clickSaveButton();
			System.out.println("select clickSaveButton");
			//Utility.simpleWait(35000);
			va.waitForSyncComplete();
			
		}catch(Exception e) {
			Log.addMessage("Finger print digit type not updated");
			e.printStackTrace();
			Assert.assertTrue(false, "Finger print digit type not updated\"");
		}
	}
	
	/** 
	* Method Name: verifySyncFailAccessCodePopupTest(), 
	* This function is used to view the  UI of access code list page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="profCode")
	public void verifySyncFailFingerPrintPopupTest(String newCode, String prvCode) {
		try {
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va1 = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			va1.selFirstFPUser();
			//check for delete sync fail
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			vc.checkSyncFail();
			vc.selFirstFPUser();
			System.out.println("select getFingerPrintText last");
			if(ac.getFingerPrintText()!="") {
				if(ac.getFingerPrintText().equals("Right Index")) {
					Assert.assertTrue(true, "Finger print digit for the profile updated");
					Log.addMessage("Finger print digit for the profile updated");
				}else {
					Assert.assertTrue(false, "Failed to update Finger print digit for the profile");
					Log.addMessage("Failed to update Finger print digit for the profile");
				}
			}
			//check if name updated with new 
			Assert.assertTrue(true, "Syncing procees is complete for finger print digit type");
			Log.addMessage("Syncing procees is complete forfinger print digit type");
		}catch(Exception e) {
			Log.addMessage("Failed to complete syncing procees");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to complete syncing procees");
		}
	}
	
	/** 
	* Method Name: updateUserAccessCode(), 
	* This function is used to edit access code
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="profCode")
	public void updateUserAccessCode(String newCode, String prvCode) {
		try {
			EditAccessCodePage ec = new EditAccessCodePage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage ua = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			System.out.println("select updateUserAccessCode first");
			//va.clickBackButton();//06-10-2020
			/*if(device.equals("iOS")) {//added on 27th nov 2020
				Utility.simpleWait(3000);
			}
			va.selFirstFPUser();*/
			System.out.println("select selSecondFPUser");
			if(device.equals("iOS")) {
				ua.clickEditAcsCode();
			}else {
				ua.clickEditAccessCode();
			}
			ec.enterAccessCodePin(newCode);
			ec.clickSubmitButton();
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			vc.waitForSyncComplete();
			//va.clickOkButton();//added on 06-10-2020
			/*va.waitForSyncComplete();
			ViewAccessCodesPage va1 = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			va1.selFirstFPUser();
			System.out.println("select accesscode last");
			if(device.equals("android")) {
				if(ua.getAccessCodeText().equals(newCode)) {
					Assert.assertTrue(true, "Access code for the profile updated");
					Log.addMessage("Access code for the profile updated");
				}else {
					Assert.assertTrue(false, "Failed to update access code for the profile");
					Log.addMessage("Failed to update access code for the profile");
				}
			}else {
				Assert.assertTrue(true, "Access code for the profile updated");
				Log.addMessage("Access code for the profile updated");
			}*/
		}catch(Exception e) {
			Log.addMessage("Failed to update user name of access code profile");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update user name of access code profile");
		}
	}
	
	/** 
	* Method Name: updateARUserAccessCode(), 
	* This function is used to edit access code
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="profCode")
	public void updateARUserAccessCode(String newCode, String prvCode) {
		try {
			EditAccessCodePage ec = new EditAccessCodePage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage ua = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			//Thread.sleep(15000);
			System.out.println("select updateUserAccessCode first");
			//if(device.equals("android")) {//commented today
				UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
				if(ac.checkSwitchButton()) {
					va.selFirstFPUser();
				}
			//}
			System.out.println("select selSecondFPUser");
			if(device.equals("iOS")) {
				ua.clickEditAcsCode();
			}else {
				ua.clickEditAccessCode();
			}
			ec.enterAccessCodePin(newCode);
			ec.clickSubmitButton();
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			vc.waitForSyncComplete();
		}catch(Exception e) {
			Log.addMessage("Failed to update user name of access code profile");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update user name of access code profile");
		}
	}
	
	/** 
	* Method Name: verifySyncFailAccessCodePopupTest(), 
	* This function is used to view the  UI of access code list page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="profCode")
	public void verifySyncFailAccessCodePopupTest(String newCode, String prvCode) {
		try {
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage ua = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			System.out.println("namecnt="+namecnt);
			//vc.waitForSyncComplete();
			vc.selFirstFPUser();
			//check for delete sync fail
			vc.checkSyncFail();
			vc.selFirstFPUser();
			if(device.equals("android")) {
				if(ua.getAccessCodeText()!="") {
					if(ua.getAccessCodeText().equals(newCode)) {
						Assert.assertTrue(true, "Access code for the profile updated");
						Log.addMessage("Access code for the profile updated");
					}else {
						Assert.assertTrue(false, "Failed to update access code for the profile");
						Log.addMessage("Failed to update access code for the profile");
					}
				}
			}else {
				Assert.assertTrue(true, "Access code for the profile updated");
				Log.addMessage("Access code for the profile updated");
			}
			
			//check if name updated with new 
			Assert.assertTrue(true, "Syncing procees is complete for access name update");
			Log.addMessage("Syncing procees is complete for access name update");
		}catch(Exception e) {
			Log.addMessage("Failed to complete syncing procees");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to complete syncing procees");
		}
	}
	
	/** 
	* Method Name: verifySyncFailARPopupTest(), 
	* This function is used to view the  UI of access code list page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="profCode")
	public void verifySyncFailARPopupTest(String newCode, String prvCode) {
		try {
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage ua = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			System.out.println("namecnt="+namecnt);
			//vc.waitForSyncComplete();
			if(device.equals("android")) {
				vc.selFirstFPUser();
			}
			vc.checkSyncFail();
			vc.selFirstFPUser();
			
			if(device.equals("android")) {
				if(ua.getAccessCodeText()!="") {
					if(ua.getAccessCodeText().equals(newCode)) {
						Assert.assertTrue(true, "Access code for the profile updated");
						Log.addMessage("Access code for the profile updated");
					}else {
						Assert.assertTrue(false, "Failed to update access code for the profile");
						Log.addMessage("Failed to update access code for the profile");
					}
				}
			}else {
				Assert.assertTrue(true, "Access code for the profile updated");
				Log.addMessage("Access code for the profile updated");
			}
			
			//check if name updated with new 
			Assert.assertTrue(true, "Syncing procees is complete for access name update");
			Log.addMessage("Syncing procees is complete for access name update");
		}catch(Exception e) {
			Log.addMessage("Failed to complete syncing procees");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to complete syncing procees");
		}
	}
	
	/** 
	* Method Name: setScheduleTypeAnyTime(), 
	* This function is used to set schedule type to Any Time
	**/
	//write method for view schedule type and check assign schedule type
	@SuppressWarnings("unchecked")
	@Test
	public void setScheduleTypeAnyTime() {
		try {
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			SelectScheduleTypePage ss = new SelectScheduleTypePage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			ac.clickSchButton();
			ss.selectAnyTime();//verify if  schedule type updated as Any Time 
			va.waitForSyncComplete();
			//Utility.simpleWait(20000);//commented on 23rd Oct
			Assert.assertTrue(true, "Set schedule type to Any Time");
			Log.addMessage("Set schedule type to Any Time");
		}catch(Exception e) {
			Log.addMessage("Failed to set schedule type");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to set schedule type");
		}
	}
	
	/** 
	* Method Name: setScheduleTypeARAnyTime(), 
	* This function is used to set schedule type to Any Time
	**/
	//write method for view schedule type and check assign schedule type
	@SuppressWarnings("unchecked")
	@Test
	public void setScheduleTypeARAnyTime() {
		try {
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			SelectScheduleTypePage ss = new SelectScheduleTypePage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			if(device.equals("iOS")) {
				if(ac.checkSwitchButton()) {
					va.selFirstFPUser();
				}
			}
			ac.clickSchButton();
			ss.selectAnyTime();//verify if  schedule type updated as Any Time 
			va.waitForSyncComplete();
			if(device.equals("android")) {
				ViewAccessCodesPage vac = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
				vac.waitForSyncComplete();
				if(vac.checkOkButton()) {
					va.clickOkButton();
				} 
			}
			Assert.assertTrue(true, "Set schedule type to Any Time");
			Log.addMessage("Set schedule type to Any Time");
		}catch(Exception e) {
			Log.addMessage("Failed to set schedule type");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to set schedule type");
		}
	}
	
	/** 
	* Method Name: setScheduleTypeFpAnyTime(), 
	* This function is used to set schedule type to Any Time
	**/
	//write method for view schedule type and check assign schedule type
	@SuppressWarnings("unchecked")
	@Test
	public void setScheduleTypeFpAnyTime() {
		try {
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			SelectScheduleTypePage ss = new SelectScheduleTypePage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			ac.clickSchButton();
			ss.selectAnyTime();//verify if  schedule type updated as Any Time 
			va.waitForSyncComplete();
			//Utility.simpleWait(20000);//commented on 23rd Oct
			Assert.assertTrue(true, "Set schedule type to Any Time");
			Log.addMessage("Set schedule type to Any Time");
		}catch(Exception e) {
			Log.addMessage("Failed to set schedule type");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to set schedule type");
		}
	}
	
	
	/*** rmvd anytime access funtion **/
	
	/** 
	* Method Name: verifySyncFailAccessCodePopupTest(), 
	* This function is used to view the  UI of access code list page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="profCode")
	public void verifySyncFailAnyTimePopupTest(String newCode, String prvCode) {
		try {
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			vc.selFirstFPUser();
			//check for delete sync fail
			vc.checkSyncFail();
			vc.selFirstFPUser();
			Assert.assertTrue(true, "Syncing procees is complete for access name update");
			Log.addMessage("Syncing procees is complete for access name update");
		}catch(Exception e) {
			Log.addMessage("Failed to complete syncing procees");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to complete syncing procees");
		}
	}
	
	/** 
	* Method Name: valScheduleTypeWeekly(), 
	* This function is used to set schedule type to limit by week
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="schWeek")
	public void valScheduleTypeWeekly(String typeSch) {
		try {
			SelectScheduleTypePage ss = new SelectScheduleTypePage((AppiumDriver<MobileElement>) driver);
			LimitByWeekdayAndTimePage lb = new LimitByWeekdayAndTimePage((AppiumDriver<MobileElement>) driver);
			SelectWeekDayPage sw = new SelectWeekDayPage((AppiumDriver<MobileElement>) driver);
			if(typeSch.equals("WithoutDay")) {
				System.out.println("in if");
				if(device.equals("iOS")) {
					Utility.simpleWait(3000);//added on 16 Nov 2020 for bvt
				}
				//commented on 01 Dec 2020
				/*ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
				va.selFirstFPUser();*/
				//commented below code on 23rd Oct 2020
				
				UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
				System.out.println("selected clickScheduleButton");
				ac.clickSchButton();
				System.out.println("click clickScheduleButton");
				ss.selectLimitByWeekdayAndTime();
				//Utility.simpleWait(3000);//commented on 23rd Oct 2020 check for toast
				lb.clickDaysToAllowOption();
				sw.clickClearAllDaysOption();
				sw.clickSubmitButton();
				if(device.equals("iOS")) {
					sw.clickOkButton();
				}else {
					//Utility.simpleWait(3000);//for toast message to disappear//commented for bvt on 26-11-2020
				}
				sw.clickBackButton();
				Log.addMessage("Schedule type cannot be set with no days selected");
				Assert.assertTrue(true, "Schedule type cannot be set with no days selected");
			}else {
				System.out.println("in else");
				lb.clickLimitTimeOfDay();
				lb.clickSubmitButton();
				//if(device.equals("iOS")) {
					lb.clickOkButton();//in android updating with default date
				//}
				Log.addMessage("Schedule type cannot be set with no time selected");
				Assert.assertTrue(true, "Schedule type cannot be set with no time selected");
			}
		}catch(Exception e) {
			Log.addMessage("Schedule type set without selecting any days or time");
			e.printStackTrace();
			Assert.assertTrue(false, "Schedule type set without selecting any days or time");
		}
	}
	
	/** 
	* Method Name: valScheduleTypeARWeekly(), 
	* This function is used to set schedule type to limit by week
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="schWeek")
	public void valScheduleTypeARWeekly(String typeSch) {
		try {
			SelectScheduleTypePage ss = new SelectScheduleTypePage((AppiumDriver<MobileElement>) driver);
			LimitByWeekdayAndTimePage lb = new LimitByWeekdayAndTimePage((AppiumDriver<MobileElement>) driver);
			SelectWeekDayPage sw = new SelectWeekDayPage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			if(typeSch.equals("WithoutDay")) {
				System.out.println("in if");
				if(device.equals("iOS")) {//commented today
					if(ac.checkSwitchButton()) {
						va.selFirstFPUser();
					}
					//Utility.simpleWait(3000);//added on 16 Nov 2020 for bvt
				}else {
					
					va.selFirstFPUser();
				}
				UserFPAccessProfilePage ac1 = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
				System.out.println("selected clickScheduleButton");
				ac1.clickSchButton();
				System.out.println("click clickScheduleButton");
				ss.selectLimitByWeekdayAndTime();
				//Utility.simpleWait(3000);//commented on 23rd Oct 2020 check for toast
				lb.clickDaysToAllowOption();
				sw.clickClearAllDaysOption();
				sw.clickSubmitButton();
				if(device.equals("iOS")) {
					sw.clickOkButton();
				}else {
					//Utility.simpleWait(3000);//for toast message to disappear//commented for bvt on 26-11-2020
				}
				sw.clickBackButton();
				Log.addMessage("Schedule type cannot be set with no days selected");
				Assert.assertTrue(true, "Schedule type cannot be set with no days selected");
			}else {
				System.out.println("in else");
				lb.clickLimitTimeOfDay();
				lb.clickSubmitButton();
				//if(device.equals("iOS")) {
					lb.clickOkButton();//in android updating with default date
				//}
				Log.addMessage("Schedule type cannot be set with no time selected");
				Assert.assertTrue(true, "Schedule type cannot be set with no time selected");
			}
		}catch(Exception e) {
			Log.addMessage("Schedule type set without selecting any days or time");
			e.printStackTrace();
			Assert.assertTrue(false, "Schedule type set without selecting any days or time");
		}
	}
		
	
	/** 
	* Method Name: setScheduleTypeWeekly(), 
	* This function is used to set schedule type to limit by time
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="schWeekTime")
	public void setScheduleTypeWeekly(String hours_start, String min_start, String AM_PM_start, String hours_end, String min_end, String AM_PM_end) {
		try {
			LimitByWeekdayAndTimePage lb = new LimitByWeekdayAndTimePage((AppiumDriver<MobileElement>) driver);
			//System.out.println("in setScheduleTypeWeekly");
			
			//check dates in excel
			if(device.equals("iOS")) {
				lb.clickLimitTimeOfDay();
			}
			if(device.equals("iOS")) {
				lb.selectEndTime(hours_end, min_end, AM_PM_end);
				lb.selectStartTime(hours_start, min_start, AM_PM_start);
			}else {
				lb.selectStartTime(hours_start, min_start, AM_PM_start);
				lb.selectEndTime(hours_end, min_end, AM_PM_end);
			}
			lb.clickSubmitButton();
			//Utility.simpleWait(8000);//commented on 23rd Oct 2020 check
			if(device.equals("iOS")) {
				lb.clickOkButton();//commented on 16-10-2020 for halo bvt android
			}
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			vc.waitForSyncComplete();
			Log.addMessage("Schedule type set with limit by weekday and time");
			Assert.assertTrue(true, "Schedule type set with limit by weekday and time");
		}catch(Exception e) {
			Log.addMessage("Failed to set schedule type with limit by weekday and time");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to set schedule type with limit by weekday and time");
		}
	}
	
	/** 
	* Method Name: setARScheduleTypeWeekly(), 
	* This function is used to set schedule type to limit by time
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="schWeekTime")
	public void setARScheduleTypeWeekly(String hours_start, String min_start, String AM_PM_start, String hours_end, String min_end, String AM_PM_end) {
		try {
			LimitByWeekdayAndTimePage lb = new LimitByWeekdayAndTimePage((AppiumDriver<MobileElement>) driver);
			//System.out.println("in setScheduleTypeWeekly");
			
			//check dates in excel
			if(device.equals("iOS")) {
				lb.clickLimitTimeOfDay();
			}else {
				ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
				va.selFirstFPUser();
			}
			if(device.equals("iOS")) {
				lb.selectEndTime(hours_end, min_end, AM_PM_end);
				lb.selectStartTime(hours_start, min_start, AM_PM_start);
			}else {
				lb.selectStartTime(hours_start, min_start, AM_PM_start);
				lb.selectEndTime(hours_end, min_end, AM_PM_end);
			}
			lb.clickSubmitButton();
			if(device.equals("android")) {
				ViewAccessCodesPage vac = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
				vac.waitForSyncComplete();
				if(vac.checkOkButton()) {
					lb.clickOkButton();
				} 
			}else {
				lb.clickOkButton();
			}
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			vc.waitForSyncComplete();
			Log.addMessage("Schedule type set with limit by weekday and time");
			Assert.assertTrue(true, "Schedule type set with limit by weekday and time");
		}catch(Exception e) {
			Log.addMessage("Failed to set schedule type with limit by weekday and time");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to set schedule type with limit by weekday and time");
		}
	}
	
	
	/** 
	* Method Name: verifySyncFailWeeklyPopupTest(), 
	* This function is used to view the  UI of access code list page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="profCode")
	public void verifySyncFailWeeklyPopupTest(String newCode, String prvCode) {
		try {
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage ua = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			System.out.println("namecnt="+namecnt);
			//vc.waitForSyncComplete();
			vc.selFirstFPUser();
			
			//check for delete sync fail
			vc.checkSyncFail();
			vc.selFirstFPUser();
			//check if name updated with new 
			Assert.assertTrue(true, "Syncing procees is complete for access name update");
			Log.addMessage("Syncing procees is complete for access name update");
		}catch(Exception e) {
			Log.addMessage("Failed to complete syncing procees");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to complete syncing procees");
		}
	}
	
	/** 
	* Method Name: setScheduleTypeDate(), 
	* This function is used to set schedule type to limit by date
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="schDate")
	public void setScheduleTypeDate(String month, String day, String year, String monthend, String dayend, String yearend) {
		try {
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			SelectScheduleTypePage ss = new SelectScheduleTypePage((AppiumDriver<MobileElement>) driver);
			LimitByDatePage lb = new LimitByDatePage((AppiumDriver<MobileElement>) driver);
			//commented below code on 02 dec 2020.
			/*va.waitForSyncComplete();
			va.selFirstFPUser();*/
			//commented below code on 23rd oct 2020.
			/*if(va.checkOkButton()) {
				va.clickOkButton();
				//Utility.simpleWait(25000);commented for bvt
				Utility.simpleWait(10000);
				va.selFirstFPUser();
			}*/
			//Utility.simpleWait(3000);commented for bvt 9-10-2020
			//System.out.println("selected clickScheduleButton");
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);//changed to this position to run iOS
			ac.clickSchButton();
			//System.out.println("click clickScheduleButton");
			//Utility.simpleWait(3000);commented for bvt 9-10-2020
			ss.selectLimitByDate();
			//System.out.println("click LimitByDate");
			if(device.equals("iOS")) {
				lb.selectStartDate( month,  day,  year);
				lb.selectEndDate( monthend,  dayend,  yearend);
			}else {
				lb.setCurrStartDate();
				//Utility.simpleWait(3000);//commented for bvt 23-10-2020 check  
				lb.setCurrEndDate();
			}
			lb.clickSubmitButton();
			//Utility.simpleWait(8000);//commented for bvt 23-10-2020 check
			if(device.equals("iOS")) {
				lb.clickOkButton();//commented on 09-10-2020 for Android during bvt
			}
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			vc.waitForSyncComplete();
			Log.addMessage("Schedule type set with limit by date");
			Assert.assertTrue(true, "Schedule type set with limit by date");
			
		}catch(Exception e) {
			Log.addMessage("Failed to set schedule type with limit by weekday and time");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to set schedule type with limit by weekday and time");
		}
	}
	
	/** 
	* Method Name: setARScheduleTypeDate(), 
	* This function is used to set schedule type to limit by date
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="schDate")
	public void setARScheduleTypeDate(String month, String day, String year, String monthend, String dayend, String yearend) {
		try {
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			SelectScheduleTypePage ss = new SelectScheduleTypePage((AppiumDriver<MobileElement>) driver);
			LimitByDatePage lb = new LimitByDatePage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);//changed to this position to run iOS
			ac.clickSchButton();
			ss.selectLimitByDate();
			if(device.equals("iOS")) {
				lb.selectStartDate( month,  day,  year);
				lb.selectEndDate( monthend,  dayend,  yearend);
			}else {
				lb.setCurrStartDate(); 
				lb.setCurrEndDate();
			}
			lb.clickSubmitButton();
			if(device.equals("android")) {
				ViewAccessCodesPage vac = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
				vac.waitForSyncComplete();
				if(vac.checkOkButton()) {
					lb.clickOkButton();
				} 
			}else {
				lb.clickOkButton();
			}
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			vc.waitForSyncComplete();
			Log.addMessage("Schedule type set with limit by date");
			Assert.assertTrue(true, "Schedule type set with limit by date");
			
		}catch(Exception e) {
			Log.addMessage("Failed to set schedule type with limit by weekday and time");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to set schedule type with limit by weekday and time");
		}
	}
	
	
	/** 
	* Method Name: verifySyncFailDatePopupTest(), 
	* This function is used to view the  UI of access code list page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="profCode")
	public void verifySyncFailDatePopupTest(String newCode, String prvCode) {
		try {
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage ua = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			System.out.println("namecnt="+namecnt);
			//vc.waitForSyncComplete();
			vc.selFirstFPUser();
			//check for delete sync fail
			vc.checkSyncFail();
			vc.selFirstFPUser();
			//check if name updated with new 
			Assert.assertTrue(true, "Syncing procees is complete for access name update");
			Log.addMessage("Syncing procees is complete for access name update");
		}catch(Exception e) {
			Log.addMessage("Failed to complete syncing procees");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to complete syncing procees");
		}
	}
	
	
	/** 
	* Method Name: setOneTimeSchedule(), 
	* This function is used to set schedule type to one time schedule
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="schOneTime")
	public void setOneTimeSchedule(String titleMsg, String valMsg, String iosMsg) {
		try {
			
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			SelectScheduleTypePage ss = new SelectScheduleTypePage((AppiumDriver<MobileElement>) driver);
			//commented on 01-12-2020
			/*va.waitForSyncComplete();
			va.selFirstFPUser();*/
			
			Utility.simpleWait(3000);//commented for bvt 9-10-2020
			//System.out.println("selected clickScheduleButton");
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			ac.clickSchButton();
			//System.out.println("click clickScheduleButton");
			//Utility.simpleWait(3000);commented for bvt 9-10-2020
			ss.selectOneTimeWithin24Hours();
			System.out.println("click OneTimeWithin24Hours");
			//Utility.simpleWait(3000);//commented for bvt 23-10-2020
			/*ss.clickCancelButton();
			ss.selectOneTimeWithin24Hours();
			if(device.equals("android")) {
				ss.verifyPopUpVerbiage(titleMsg, valMsg, iosMsg);
				ss.cliclStartNowButton();
			}else {
				ss.cliclStartNowButton();
			}
			
			lb.clickSubmitButton();*/
			//Utility.simpleWait(8000);//commented for bvt 23-10-2020
			
			//lb.clickOkButton();//commented on 09-10-2020 during bvt
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			vc.waitForSyncComplete();
			Log.addMessage("Schedule type set with limit by date");
			Assert.assertTrue(true, "Schedule type set with limit by date");
			
		}catch(Exception e) {
			Log.addMessage("Failed to set schedule type with limit by weekday and time");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to set schedule type with limit by weekday and time");
		}
	}
	
	/** 
	* Method Name: setOneTimeARSchedule(), 
	* This function is used to set schedule type to one time schedule
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="schOneTime")
	public void setOneTimeARSchedule(String titleMsg, String valMsg, String iosMsg) {
		try {
			
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			SelectScheduleTypePage ss = new SelectScheduleTypePage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			//if(device.equals("android")) {//commented today
			if(ac.checkSwitchButton()) {
				va.selFirstFPUser();
			}
			//}
			//Utility.simpleWait(3000);//commented for bvt 9-10-2020
			//System.out.println("selected clickScheduleButton");
			UserFPAccessProfilePage ac1 = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			ac1.clickSchButton();
			//System.out.println("click clickScheduleButton");
			//Utility.simpleWait(3000);commented for bvt 9-10-2020
			ss.selectOneTimeWithin24Hours();
			System.out.println("click OneTimeWithin24Hours");
			if(device.equals("android")) {
				ViewAccessCodesPage vac = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
				vac.waitForSyncComplete();
				if(vac.checkOkButton()) {
					vac.clickOkButton();
				} 
			}
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			vc.waitForSyncComplete();
			Log.addMessage("Schedule type set with limit by date");
			Assert.assertTrue(true, "Schedule type set with limit by date");
			
		}catch(Exception e) {
			Log.addMessage("Failed to set schedule type with limit by weekday and time");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to set schedule type with limit by weekday and time");
		}
	}
	
	
	
	/** 
	* Method Name: verifySyncFailOneTimePopupTest(), 
	* This function is used to view the  UI of access code list page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="profCode")
	public void verifySyncFailOneTimePopupTest(String newCode, String prvCode) {
		try {
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage ua = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			System.out.println("namecnt="+namecnt);
			//vc.waitForSyncComplete();
			vc.selFirstFPUser();
			
			//check for delete sync fail
			vc.checkSyncFail();
			vc.selFirstFPUser();
			//check if name updated with new 
			Assert.assertTrue(true, "Syncing procees is complete for access name update");
			Log.addMessage("Syncing procees is complete for access name update");
		}catch(Exception e) {
			Log.addMessage("Failed to complete syncing procees");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to complete syncing procees");
		}
	}
	

	/** 
	* Method Name: setPrvScheduleTypeAnyTime(), 
	* This function is used to set schedule type to Any Time
	**/
	//write method for view schedule type and check assign schedule type
	@SuppressWarnings("unchecked")
	@Test
	public void setPrvScheduleTypeAnyTime() {
		try {
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			SelectScheduleTypePage ss = new SelectScheduleTypePage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			ac.clickSchButton();
			//System.out.println("click clickScheduleButton");
			
			ss.selectAnyTime();//verify if  schedule type updated as Any Time 
			ViewAccessCodesPage va1 = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			va1.waitForSyncComplete();
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			//vc.selFirstFPUser();//changed from this function to syncpopup
			//Utility.simpleWait(20000);//commented on 23rd Oct
			Assert.assertTrue(true, "Set schedule type to Any Time");
			Log.addMessage("Set schedule type to Any Time");
		}catch(Exception e) {
			Log.addMessage("Failed to set schedule type");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to set schedule type");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void setPrvARScheduleTypeAnyTime() {
		try {
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			SelectScheduleTypePage ss = new SelectScheduleTypePage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			if(device.equals("android")) {
				va.selFirstFPUser();
			}
			ac.clickSchButton();
			//System.out.println("click clickScheduleButton");
			
			ss.selectAnyTime();//verify if  schedule type updated as Any Time 
			ViewAccessCodesPage va1 = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			va1.waitForSyncComplete();
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			if(device.equals("android")) {
				ViewAccessCodesPage vac = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
				vac.waitForSyncComplete();
				if(vac.checkOkButton()) {
					va.clickOkButton();
				} 
			}
			Assert.assertTrue(true, "Set schedule type to Any Time");
			Log.addMessage("Set schedule type to Any Time");
		}catch(Exception e) {
			Log.addMessage("Failed to set schedule type");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to set schedule type");
		}
	}
	
	/** 
	* Method Name: verifySyncFailPrvSchPopupTest(), 
	* This function is used to view the  UI of access code list page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="profCode")
	public void verifySyncFailPrvSchPopupTest(String newCode, String prvCode) {
		try {
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage ua = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			System.out.println("namecnt="+namecnt);
			//vc.waitForSyncComplete();
			vc.selFirstFPUser();
			
			//check for delete sync fail
			vc.checkSyncFail();
			vc.selFirstFPUser();
			//check if name updated with new 
			Assert.assertTrue(true, "Syncing procees is complete for access name update");
			Log.addMessage("Syncing procees is complete for access name update");
		}catch(Exception e) {
			Log.addMessage("Failed to complete syncing procees");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to complete syncing procees");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void updateToPrvFPDigitTypeTest() {
		try {
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			
			System.out.println("select changeFPUserProfileDigitType first");
			//va.clickBackButton();//06-10-2020
			va.selFirstFPUser();
			//Utility.simpleWait(3000);//commented on 27-10-2020
			System.out.println("select selSecondFPUser");
			ac.clickFingerPrint1();
			System.out.println("select clickFingerPrint1");
			ac.clickLeftButton();
			System.out.println("select clickLeftButton");
			ac.clickThumbButton();
			System.out.println("select clickThumbButton");
			ac.clickSaveButton();
			System.out.println("select clickSaveButton");
			//Utility.simpleWait(35000);
			va.waitForSyncComplete();
			
		}catch(Exception e) {
			Log.addMessage("Finger print digit type not updated");
			e.printStackTrace();
			Assert.assertTrue(false, "Finger print digit type not updated");
		}
	}
	
	/** 
	* Method Name: verifySyncFailAccessCodePopupTest(), 
	* This function is used to view the  UI of access code list page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="profCode")
	public void verifySyncFailPrvFPDigitTypeTest(String newCode, String prvCode) {
		try {
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va1 = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			va1.selFirstFPUser();
			//check for delete sync fail
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			vc.checkSyncFail();
			vc.selFirstFPUser();
			System.out.println("select getFingerPrintText last");
			if(ac.getFingerPrintText()!="") {
				if(ac.getFingerPrintText().equals("Left Thumb")) {
					Assert.assertTrue(true, "Finger print digit for the profile updated");
					Log.addMessage("Finger print digit for the profile updated");
				}else {
					Assert.assertTrue(false, "Failed to update Finger print digit for the profile");
					Log.addMessage("Failed to update Finger print digit for the profile");
				}
			}
			//check if name updated with new 
			Assert.assertTrue(true, "Syncing procees is complete for finger print digit type");
			Log.addMessage("Syncing procees is complete forfinger print digit type");
		}catch(Exception e) {
			Log.addMessage("Failed to complete syncing procees");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to complete syncing procees");
		}
	}
	
	
	
	/** 
	* Method Name: updateToPrvUserAccessCode(), 
	* This function is used to edit access code
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="profCode")
	public void updateToPrvUserAccessCode(String newCode, String prvCode) {
		try {
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			System.out.println("select updateUserAccessCode first");
			//va.clickBackButton();//06-10-2020
			//va.selFirstFPUser();//01-12-2020
			Utility.simpleWait(3000);
			System.out.println("select selSecondPrevFPUser");
			UserFPAccessProfilePage ua = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			if(device.equals("iOS")) {
				ua.clickEditAcsCode();
			}else {
				ua.clickEditAccessCode();
			}
			EditAccessCodePage ec = new EditAccessCodePage((AppiumDriver<MobileElement>) driver);
			ec.enterAccessCodePin(prvCode);
			ec.clickSubmitButton();
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			vc.waitForSyncComplete();
			//va.clickOkButton();//added on 06-10-2020
			/*va.waitForSyncComplete();
			//Utility.simpleWait(35000);//commented on 23 oct 2020
			ViewAccessCodesPage va1 = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			va1.selFirstFPUser();
			//Utility.simpleWait(3000);
			System.out.println("select accesscode last");
			if(device.equals("android")) {
				if(ua.getAccessCodeText().equals(prvCode)) {
					Assert.assertTrue(true, "Access code for the profile updated");
					Log.addMessage("Access code for the profile updated");
				}else {
					Assert.assertTrue(false, "Failed to update access code for the profile");
					Log.addMessage("Failed to update access code for the profile");
				}
			}else {
				Assert.assertTrue(true, "Access code for the profile updated");
				Log.addMessage("Access code for the profile updated");
			}*/
		}catch(Exception e) {
			Log.addMessage("Failed to update user name of access code profile");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update user name of access code profile");
		}
	}
	

	/** 
	* Method Name: updateToPrvARUserAccessCode(), 
	* This function is used to edit access code
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="profCode")
	public void updateToPrvARUserAccessCode(String newCode, String prvCode) {
		try {
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			System.out.println("select updateUserAccessCode first");
			//va.clickBackButton();//06-10-2020
			if(device.equals("android")) {
				va.selFirstFPUser();//01-12-2020
			}
			//Utility.simpleWait(3000);
			System.out.println("select selSecondPrevFPUser");
			UserFPAccessProfilePage ua = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			if(device.equals("iOS")) {
				ua.clickEditAcsCode();
			}else {
				ua.clickEditAccessCode();
			}
			EditAccessCodePage ec = new EditAccessCodePage((AppiumDriver<MobileElement>) driver);
			ec.enterAccessCodePin(prvCode);
			ec.clickSubmitButton();
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			vc.waitForSyncComplete();
			
			/*va.waitForSyncComplete();
			//Utility.simpleWait(35000);//commented on 23 oct 2020
			ViewAccessCodesPage va1 = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			va1.selFirstFPUser();
			//Utility.simpleWait(3000);
			System.out.println("select accesscode last");
			if(device.equals("android")) {
				if(ua.getAccessCodeText().equals(prvCode)) {
					Assert.assertTrue(true, "Access code for the profile updated");
					Log.addMessage("Access code for the profile updated");
				}else {
					Assert.assertTrue(false, "Failed to update access code for the profile");
					Log.addMessage("Failed to update access code for the profile");
				}
			}else {
				Assert.assertTrue(true, "Access code for the profile updated");
				Log.addMessage("Access code for the profile updated");
			}*/
		}catch(Exception e) {
			Log.addMessage("Failed to update user name of access code profile");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update user name of access code profile");
		}
	}
	
	/** 
	* Method Name: verifySyncFailPrvCodePopupTest(), 
	* This function is used to view the  UI of access code list page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="profCode")
	public void verifySyncFailPrvCodePopupTest(String newCode, String prvCode) {
		try {
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage ua = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			System.out.println("namecnt="+namecnt);
			//vc.waitForSyncComplete();
			vc.selFirstFPUser();
			if(device.equals("android")) {
				if(ua.getAccessCodeText().equals(newCode)) {
					Assert.assertTrue(true, "Access code for the profile updated");
					Log.addMessage("Access code for the profile updated");
				}else {
					Assert.assertTrue(false, "Failed to update access code for the profile");
					Log.addMessage("Failed to update access code for the profile");
				}
			}else {
				Assert.assertTrue(true, "Access code for the profile updated");
				Log.addMessage("Access code for the profile updated");
			}
			//check for delete sync fail
			vc.checkSyncFail();
			vc.selFirstFPUser();
			//check if name updated with new 
			Assert.assertTrue(true, "Syncing procees is complete for access name update");
			Log.addMessage("Syncing procees is complete for access name update");
		}catch(Exception e) {
			Log.addMessage("Failed to complete syncing procees");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to complete syncing procees");
		}
	}
	
	/** 
	* Method Name: verifySyncFailARPrvCodePopupTest(), 
	* This function is used to view the  UI of access code list page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="profCode")
	public void verifySyncFailARPrvCodePopupTest(String newCode, String prvCode) {
		try {
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage ua = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			
			if(device.equals("android")) {
				vc.selFirstFPUser();
				if(ua.getAccessCodeText().equals(newCode)) {
					Assert.assertTrue(true, "Access code for the profile updated");
					Log.addMessage("Access code for the profile updated");
				}else {
					Assert.assertTrue(false, "Failed to update access code for the profile");
					Log.addMessage("Failed to update access code for the profile");
				}
			}else {
				Assert.assertTrue(true, "Access code for the profile updated");
				Log.addMessage("Access code for the profile updated");
			}
			//check for delete sync fail
			vc.checkSyncFail();
			vc.selFirstFPUser();
			//check if name updated with new 
			Assert.assertTrue(true, "Syncing procees is complete for access name update");
			Log.addMessage("Syncing procees is complete for access name update");
		}catch(Exception e) {
			Log.addMessage("Failed to complete syncing procees");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to complete syncing procees");
		}
	}
	
	
	/** 
	* Method Name: viewFPUISecureModeTest(), 
	* This function is used to enable and disable secure mode
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void viewFPUISecureModeTest() throws InterruptedException {
		try {
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			va.clickBackButton();
			if(device.equals("iOS")) {
				Utility.simpleWait(3000);//commented for bvt 23-10-2020
			}
			va.verifyUISecureModeFP();
			va.enableSecureMode();
			va.getSecureModeStatus();
			
			va.enableSecureMode();
			va.getSecureModeStatus();
			Log.addMessage("Secure Mode option displayed with enable disable button");
			
		}catch(Exception e) {
			Log.addMessage("Failed to display secure mode option");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display secure mode option");
		}
	}
	
	/** 
	* Method Name: viewARUISecureModeTest(), 
	* This function is used to enable and disable secure mode
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void viewARUISecureModeTest() throws InterruptedException {
		try {
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			va.clickBackButton();
			if(device.equals("iOS")) {
				Utility.simpleWait(3000);//commented for bvt 23-10-2020
			}
			va.verifyUISecureModeFP();
			va.enableSecureMode();
			va.getSecureModeStatus();
			
			va.enableSecureMode();
			va.getSecureModeStatus();
			Log.addMessage("Secure Mode option displayed with enable disable button");
			
		}catch(Exception e) {
			Log.addMessage("Failed to display secure mode option");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display secure mode option");
		}
	}
	
	
	/** 
	* Method Name: homenavBackAgnTest(), 
	* This function is used to navigate back to lock dashboard page and then to lock settings page
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void homenavBackAgnTest() {
		 try {
			 ViewAccessCodesPage ap = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 ap.clickBackButton();
			 ld.clickLockSettingsButton();
			 Log.addMessage("Redirecting to Lock listPage");
		 }catch(Exception e) {
			 Log.addMessage("Not Redirected to Lock listPage");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Not Redirected to Lock listPage");
		 }
	}
	
	/** 
	* Method Name: autoLockSettingNameHlTest(), 
	* This function is used to set the lock settings back to previous stage
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="lockSettingUpdt")
	public void autoLockSettingNameHLTest(String lockName, String autLockSts) {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			LockNamePage ln = new LockNamePage((AppiumDriver<MobileElement>) driver);
			ls.clickEditLockNameButton();
			ln.setLockName(lockName);
			ln.clickSubmitButton();
			if(device.equals("android")) {
				ln.clickOkButton();
			}
			Log.addMessage("Lock name updated");
			Assert.assertTrue(true,"lock name updated");
		}catch(Exception e) {
			 Log.addMessage("Failed to update lock name");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to update lock name");
		 }
	}
	
	/** 
	* Method Name: autoLockSettingNameFpTest(), 
	* This function is used to set the lock settings back to previous stage
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="lockSettingFpUpdt")
	public void autoLockSettingNameFPTest(String lockName, String autLockSts) {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			LockNamePage ln = new LockNamePage((AppiumDriver<MobileElement>) driver);
			ls.clickEditLockNameButton();
			ln.setLockName(lockName);
			ln.clickSubmitButton();
			if(device.equals("android")) {
				ln.clickOkButton();
			}
			Log.addMessage("Lock name updated");
			Assert.assertTrue(true,"lock name updated");
		}catch(Exception e) {
			 Log.addMessage("Failed to update lock name");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to update lock name");
		 }
	}
	
	/** 
	* Method Name: autoLockSettingNameArTest(), 
	* This function is used to set the lock settings back to previous stage
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="lockSettingArUpdt")
	public void autoLockSettingNameARTest(String lockName, String autLockSts) {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			LockNamePage ln = new LockNamePage((AppiumDriver<MobileElement>) driver);
			ls.clickEditLockNameButton();
			ln.setLockName(lockName);
			ln.clickSubmitButton();
			if(device.equals("android")) {
				ln.clickOkButton();
			}
			Log.addMessage("Lock name updated");
			Assert.assertTrue(true,"lock name updated");
		}catch(Exception e) {
			 Log.addMessage("Failed to update lock name");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to update lock name");
		 }
	}
	
	/** 
	* Method Name: autoLockSettingSoundTest(), 
	* This function is used to set the lock settings back to previous stage
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="lockSettingUpdt")
	public void autoLockSettingSoundTest(String lockName, String autLockSts) {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			
			ls.clickLockSoundsButton();
			Log.addMessage("Lock sounds updated");
			if(!ls.getAutoLockStts().equals("Off")) {
				ls.clickAutoLockButton();
			}
			Log.addMessage("Lock sounds displayed");
			Assert.assertTrue(true,"lock settings displayed");
		}catch(Exception e) {
			 Log.addMessage("Failed to update lock sound");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to update lock soud ");
		 }
	}
	
	/** 
	* Method Name: verifyLockSoundSyncFailPopupTest(), 
	* This function is used to handle the sync failed pop up in the Lock Settings Page
	*/
	@SuppressWarnings("unchecked")
	@Test
	public void verifyLockSoundSyncFailPopupTest() throws InterruptedException {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			if(ls.checkOkButton()) {
				ls.clickSyncFailPopUp();
			}
			//added below check to verify for an overlapping sync failed pop up and syncing pop up
			if(ls.checkOkButton()) {
				ls.clickOkButton();
			}
			
			Assert.assertTrue(true, "Clicked sync failed popup in lock sounds");
		}catch(Exception e) {
			Log.addMessage("Failed to click sync failed popup in lock sounds");
			Assert.assertTrue(false, "Failed to click sync failed popup in lock sounds");
		}
	}
	
	/** 
	* Method Name: autoLockSettingTest(), 
	* This function is used to update auto lock
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void autoLockSettingTest() {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			AutoLockDelaySettingPage al = new AutoLockDelaySettingPage((AppiumDriver<MobileElement>) driver);
			System.out.println("Auto lock status updated to "+ls.getAutoLockStts());
			/*if(!ls.getAutoLockStts().equals("Off")) {
				ls.clickAutoLockButton();*/
				if(!al.getAutoDelayStatus().equals("Off") || !al.getAutoDelayStatus().equals("0")) {
					al.set_30Sec_Delay();
					al.clickAutoLockOff();
					Log.addMessage("Auto lock delay status set");
				}
				if(device.equals("iOS")) {
					if(!ls.getAutoLockStts().equals("Off")) {
						ls.clickAutoLockButton();
						al.clickAutoLockOff();
					}
				}
				if(device.equals("android")) {
					al.clickBackButton();
				}
			//}
			LockSettingsPage lp = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			autoLkStts = lp.getAutoLockStts();
			Log.addMessage("Auto lock status updated to "+autoLkStts);
			Assert.assertTrue(true,"Auto lock settings displayed");
		}catch(Exception e) {
			 Log.addMessage("Failed to update auto lock settings");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to update auto lock settings");
		 }
	}
	
	/** 
	* Method Name: verifyAutoLockSyncFailPopupTest(), 
	* This function is used to handle the sync failed pop up in the Lock Settings Page
	*/
	@SuppressWarnings("unchecked")
	@Test
	public void verifyAutoLockSyncFailPopupTest() throws InterruptedException {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			AutoLockDelaySettingPage al = new AutoLockDelaySettingPage((AppiumDriver<MobileElement>) driver);
			al.checkAutoLockOff();
			System.out.println("one");
			//added below check to verify for an overlapping sync failed pop up and syncing pop up
			if(ls.checkOkButton()) {
				//System.out.println("in ok");
				ls.clickOkButton();
			}
			System.out.println("two");
			if(device.equals("android")) {
				al.clickBackButton();
			}else if(device.equals("iOS")) {
				System.out.println("three");
				al.checkInAutoLockPage();
			}
			System.out.println("four");
			Assert.assertTrue(true, "Clicked sync failed popup in lock sounds");
		}catch(Exception e) {
			Log.addMessage("Failed to click sync failed popup in lock sounds");
			Assert.assertTrue(false, "Failed to click sync failed popup in lock sounds");
		}
	}
	
	
	/** 
	* Method Name: autoLockSettingsTest(), 
	* This function is used to set the lock settings back to previous stage
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="lockSettingUpdt")
	public void autoLockLedSoundTest(String lockName, String autLockSts) {
		try {
			
			LockSettingsPage ls1 = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			ls1.clickLEDStatusButton();
			Log.addMessage("lock settings displayed");
			Assert.assertTrue(true,"lock settings displayed");
		}catch(Exception e) {
			 Log.addMessage("Failed to update Lock Settings");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to update Lock Settings");
		 }
	}
	
	/** 
	* Method Name: verifySyncFailPopupTest(), 
	* This function is used to handle the sync failed pop up in the Lock Settings Page
	*/
	@SuppressWarnings("unchecked")
	@Test
	public void verifySyncFailPopupTest() throws InterruptedException {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			if(ls.checkOkButton()) {
				ls.clickSyncFailPopUp();
			}
			Assert.assertTrue(true, "Clicked sync failed popup");
		}catch(Exception e) {
			Log.addMessage("Failed to click sync failed popup");
			Assert.assertTrue(false, "Failed to click sync failed popup");
		}
	}
	
	/** 
	* Method Name: lockUnlockBLEOff(), 
	* This function is used to do lock unlock with ble off
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void lockUnlockBLEOff() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			va.clickBackButton();
			System.out.println("Wait for BLE Off");
			Utility.simpleWait(17000);
			String status = ld.getLockStatus();
			if (status.equals("Locked")) {
				ld.unlockOperation();
				//Utility.simpleWait(5000);for bvt
				ld.lockOperation();
			}
			else if (status.equals("Unlocked")) {
				ld.lockOperation();
				//Utility.simpleWait(5000);for bvt
				ld.unlockOperation();
			}
			else {
				Log.addMessage("Lock status is: "+status);
				Assert.assertTrue(false,"Failed to do lock unlock with no BLE");
			}
			Log.addMessage("Lock unlock performed with ble off");
			Assert.assertTrue(true,"Lock unlock performed with no BLE");
			
		}catch(Exception e) {
			 Log.addMessage("Failed to do lock unlock with no BLE");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to do lock unlock with no BLE");
		 }
	}
	
	/** 
	* Method Name: lockUnlockInternetOff(), 
	* This function is used to do lock unlock with wifi off
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void lockUnlockInternetOff() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			String status;
			System.out.println("Wait for BLE ON and Wifi Off");
			Utility.simpleWait(17000);
			if(device.equals("android")) {
				//System.out.println("in android");
				ld.clickCancelButton();
				//System.out.println("clicked cancel");
				/*ld.unlockOperation();
				Log.addMessage("Failed to do lock unlock with no internet connection");
				Assert.assertTrue(true,"Lock unlock possible with no internet connection");*/
			}
			//System.out.println("exit android");
			status = ld.getLockStatus();
			//System.out.println("get status");
			if (status.equals("Locked")) {
				ld.unlockOperation();
				//Utility.simpleWait(7000);
				ld.lockOperation();
			}else if (status.equals("Unlocked")) {
				ld.lockOperation();
				//Utility.simpleWait(7000);
				ld.unlockOperation();
			}else if (status.equals("Lock Offline")) {//in iOS
				ld.lockOperation();
				//Utility.simpleWait(7000);
				ld.unlockOperation();
			}else {
				Log.addMessage("Lock status is: "+status);
				Assert.assertTrue(false,"Failed to do lock unlock with no internet connection");
			}
			Log.addMessage("Lock unlock performed with no internet connection");
			Assert.assertTrue(true,"Lock unlock performed with no internet connection");
			
		}catch(Exception e) {
			 Log.addMessage("Failed to perform lock unlock");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to perform lock unlock");
		 }
	}
	
	/** 
	* Method Name: deleteLockWifiOffTest(), 
	* This function is used to do delete lock with wifi off
	**/
	@SuppressWarnings("unchecked")
	@Test( dataProvider="wifiOffpopup")
	public void deleteLockWifiOffTest(String popupMsg) {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			ConfirmDeleteLockPage cd = new ConfirmDeleteLockPage((AppiumDriver<MobileElement>) driver);
			ld.clickLockSettingsButton();
			//Utility.simpleWait(3000);//commented on 06-10-2020 for bvt
			if(device.equals("android")) {
				//System.out.println("before swipe");
				Utility.verticalSwipe(appiumDriver);
				//System.out.println("after swipe");
			}
			ls.clickDeleteLockButton();
			//System.out.println("clicked delete lock");
			if(device.equals("android")) {
				ls.valWifiOffMessage(popupMsg);
			}else {
				cd.deleteLock();
				cd.clickOKButton();
				cd.clickBackButton();
			}
			ls.clickBackButton();
			Log.addMessage("Wifi Off pop up displayed");
			Assert.assertTrue(true,"Wifi Off pop up displayed");
		}catch(Exception e) {
			 Log.addMessage("Failed to display wifi off popup");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to display wifi off popup");
		 }
	}
	

	@SuppressWarnings("unchecked")
	@Test
	public void logoutTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			System.out.println("Wait for Wifi and BLE ON");
			Utility.simpleWait(17000);
			ld.clickHamburgerButton();
			//Thread.sleep(2000);
			String lsttext ="Log Out";
			if(device.equals("android")) {
				 System.out.println("in scroll3");
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")).click();
			}else {
				 mp.clickLogoutButton();
			}
			mp.clickOKButton();
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	
	ExcelRead excel = new ExcelRead();
	
	@DataProvider(name = "userHlBvt")
	public Object[][] getDataNameUser() throws Exception {
		return excel.getTableArray(InputData, "App", "userHlBVT");
	}
	@DataProvider(name = "lkNameHl")
	public Object[][] getDataLockName() throws Exception {
		return excel.getTableArray(InputData, "App", "LkNameHL");
	}
	@DataProvider(name = "profName")
	public Object[][] getDataProfName() throws Exception {
		return excel.getTableArray(InputData, "App", "UserProfName");
	}
	@DataProvider(name = "profCode")
	public Object[][] getDataProfCode() throws Exception {
		return excel.getTableArray(InputData, "App", "UserProfCode");
	}
	@DataProvider(name = "lockActivity")
	public Object[][] getDataLockActivity() throws Exception {
		return excel.getTableArray(InputData, "Validation", "acLockActivity");
	}
	@DataProvider(name = "hlLockSet")
	public Object[][] getDataHlLockSetting() throws Exception {
		return excel.getTableArray(InputData, "Validation", "LockSettingHL");
	}
	@DataProvider(name = "fpLockSet")
	public Object[][] getDataFpLockSetting() throws Exception {
		return excel.getTableArray(InputData, "Validation", "LockSettingFP");
	}
	@DataProvider(name = "arLockSet")
	public Object[][] getDataArLockSetting() throws Exception {
		return excel.getTableArray(InputData, "Validation", "LockSettingAR");
	}
	@DataProvider(name = "adminLockPair")
	public Object[][] getDataAdminLockPair() throws Exception {
		return excel.getTableArray(InputData, "App", "LockPairPopUp");
	}
	@DataProvider(name = "hllockSetting")
	public Object[][] getDataLockSettingEdit() throws Exception {
		return excel.getTableArray(InputData, "App", "HaloLockSetting");
	}
	
	@DataProvider(name = "fplockSetting")
	public Object[][] getDataLockSettingFpEdit() throws Exception {
		return excel.getTableArray(InputData, "App", "FPLkSetting");
	}
	
	@DataProvider(name = "arlockSetting")
	public Object[][] getDataLockSettingArEdit() throws Exception {
		return excel.getTableArray(InputData, "App", "ARLkSetting");
	}
	@DataProvider(name = "stsupdt")
	public Object[][] getDataAcStatusUpdt() throws Exception {
		return excel.getTableArray(InputData, "App", "acStstusUpdt");
	}
	@DataProvider(name = "lockHistry")
	public Object[][] getDataLockHistoryiOS() throws Exception {
		return excel.getTableArray(InputData, "Validation", "acBvtLockHistory");
	}
	@DataProvider(name = "lockSettingHl")
	public Object[][] getHlDataLockSetting() throws Exception {
		return excel.getTableArray(InputData, "App", "HLLockSetting");
	}
	@DataProvider(name = "hmLkPrdPhone")
	public Object[][] getDataLPairedPhone() throws Exception {
		return excel.getTableArray(InputData, "Validation", "acPairedPhone");
	}
	
	@DataProvider(name = "wifiOffpopup")
	public Object[][] getDataWifiOffPopup() throws Exception {
		return excel.getTableArray(InputData, "App", "fpWifiOffPopup");
	}
	@DataProvider(name = "schWeek")
	public Object[][] getDataSchTypeWeek() throws Exception {
		return excel.getTableArray(InputData, "Validation", "ValSchTypeWeek");
	}
	@DataProvider(name = "schWeekTime")
	public Object[][] getDataSchTypeWeekTime() throws Exception {
		return excel.getTableArray(InputData, "Validation", "ValSchTypeWeekTime");
	}
	@DataProvider(name = "schDate")
	public Object[][] getDataSchTypeDate() throws Exception {
		return excel.getTableArray(InputData, "Validation", "ValSchTypeDate");
	}
	@DataProvider(name = "schOneTime")
	public Object[][] getDataSchOneTime() throws Exception {
		return excel.getTableArray(InputData, "App", "SchOneTimePopup");
	}
	@DataProvider(name = "lockSettingUpdt")
	public Object[][] getDataLockSettinUpdt() throws Exception {
		return excel.getTableArray(InputData, "App", "updtHLLkSetting");
	}
	@DataProvider(name = "lockSettingFpUpdt")
	public Object[][] getDataLockSettinFpUpdt() throws Exception {
		return excel.getTableArray(InputData, "App", "updtFpLkSetting");
	}
	@DataProvider(name = "lockSettingArUpdt")
	public Object[][] getDataLockSettinArUpdt() throws Exception {
		return excel.getTableArray(InputData, "App", "updtArLkSetting");
	}
	@DataProvider(name = "lkNameFP")
	public Object[][] getDataLockNameFP() throws Exception {
		return excel.getTableArray(InputData, "App", "LkNameFP");
	}
	
	@DataProvider(name = "lkNameAR")
	public Object[][] getDataLockNameAR() throws Exception {
		return excel.getTableArray(InputData, "App", "LkNameAR");
	}
	
	
}
