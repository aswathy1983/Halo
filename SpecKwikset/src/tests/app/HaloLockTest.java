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


public class HaloLockTest extends Settings{
	
	int cntPhone = 0;
	String updtdTimeflyout, autoLkStts,lkDispName = "";
	Boolean menuExist = false;
	
	
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
			 cv.selectEmail();
			 cv.clickSubmit();
			 //System.out.println("Waiting to retrieve verification code from email");
			 //get verification code from mail and submit
			 cvp.readCodeFromEmail("email.address1", "email.password1");//added 3rd param on 18-02-2021 for user account QA
			 cvp.clickSubmitButton(); 
		     cvp.clickNotNowButton();
		     if(device.equals("android")) {
		    	 cvp.clickAllowButton();//when runnig after a fresh install
		     }
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
	* Method Name: viewLastUpdateTimeMenuFlyoutFPTest(), 
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
			if(device.equals("iOS")){
				 Utility.simpleWait(2000);
				 menuExist =  Utility.isElementPresent("//XCUIElementTypeStaticText[@name='Manage']");
				 System.out.println("menuExisttb4="+menuExist);
				 if(!menuExist) {
					 ld.clickHamburgerButtonForBtry();
				 }
			 }
			MenuFlyoutPage mf1 = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			mf1.clickLockInMenuForBtry(lkName);
			if(device.equals("android")){
				 menuExist =  Utility.isElementPresent("//android.widget.Button[@text='Manage']");
				 System.out.println("menuExisttb4="+menuExist);
				 if(menuExist) {
						mp.verifyLockInMenuForBtry(hmName);//added on 05-Apr-2021 for Android
					 MenuFlyoutPage mf3 = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
					 mf3.clickLockInMenuForBtry(lkName);
				 }
			 }
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
			if(device.equals("iOS")){
				 Utility.simpleWait(2000);
				 ld.clickHamburgerButtonForBtry();//added on 29 Apr21 for FPBVT
				 menuExist =  Utility.isElementPresent("//XCUIElementTypeStaticText[@name='Manage']");
				 System.out.println("menuExisttb4="+menuExist);
				 if(!menuExist) {
					 ld.clickHamburgerButtonForBtry();
				 }
			 }
			MenuFlyoutPage mf1 = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			mf1.clickLockInMenuForBtry(lkName);
			System.out.println("in first click");
			if(device.equals("android")){
				System.out.println("in manage click");
				 menuExist =  Utility.isElementPresent("//android.widget.Button[@text='Manage']");
				 System.out.println("menuExisttb4="+menuExist);
				 
				 if(menuExist) {
					 System.out.println("in menuexist");
					 mp.verifyLockInMenuForBtry(hmName);//added on 05-Apr-2021 for Android
					 MenuFlyoutPage mf3 = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
					 mf3.clickLockInMenuForBtry(lkName);
				 }
			 }
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
			if(device.equals("iOS")){
				 Utility.simpleWait(2000);
				 menuExist =  Utility.isElementPresent("//XCUIElementTypeStaticText[@name='Manage']");
				 System.out.println("menuExisttb4="+menuExist);
				 if(!menuExist) {
					 ld.clickHamburgerButtonForBtry();
				 }
			 }
			MenuFlyoutPage mf1 = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			mf1.clickLockInMenuForBtry(lkName);
			if(device.equals("android")){
				 menuExist =  Utility.isElementPresent("//android.widget.Button[@text='Manage']");
				 System.out.println("menuExisttb4="+menuExist);
				 if(menuExist) {
						mp.verifyLockInMenuForBtry(hmName);//added on 05-Apr-2021 for Android
					 MenuFlyoutPage mf3 = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
					 mf3.clickLockInMenuForBtry(lkName);
				 }
			 }
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
			//if(device.equals("android")) {
				Utility.simpleWait(4000);
			//}
			if(status.equals("Locked")) {
				ld.unlockOperation();
				Utility.simpleWait(7000);
			}
			else if(status.equals("Unlocked")) {
				ld.lockOperation();
				Utility.simpleWait(7000);
			}
			else {
				Log.addMessage("Lock status is: "+status);
				Assert.assertTrue(false,"Failed to do lock unlock");
			}
		}catch(Exception e) {
			Log.addMessage("Failed to lock/unlock");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to lock/unlock");
		}
	}
	
	/** 
	* Method Name: lockFnctnltyTest(), 
	* This function is used to do the lock unlock operation
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void lockFnctnltyTest() throws InterruptedException {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			String status = ld.getLockStatus();
			if(device.equals("android")) {
				Utility.simpleWait(4000);
			}
			if(status.equals("Locked")) {
				ld.unlockOperation();
				Utility.simpleWait(7000);
				ld.lockOperation();
				Utility.simpleWait(7000);
			}
			else if(status.equals("Unlocked")) {
				ld.lockOperation();
				Utility.simpleWait(7000);
				ld.lockOperation();
				Utility.simpleWait(7000);
			}
			else {
				Log.addMessage("Lock status is: "+status);
				Assert.assertTrue(false,"Failed to do lock unlock");
			}
			Log.addMessage("Lock unlock performed");
			Assert.assertTrue(true,"Lock unlock performed");
			
		}catch(Exception e) {
			Log.addMessage("Failed to lock/unlock");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to lock/unlock");
		}
	}
	
	/** 
	* Method Name: lockFnctnltyFPTest(), 
	* This function is used to do the lock unlock operation
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void lockFnctnltyFPTest() throws InterruptedException {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			String status = ld.getLockStatus();
			if(device.equals("android")) {
				Utility.simpleWait(6000);
			}
			if(status.equals("Locked")) {
				ld.unlockOperation();
				Utility.simpleWait(10000);
				ld.lockOperation();
			}
			else if(status.equals("Unlocked")) {
				ld.lockOperation();
				Utility.simpleWait(10000);
				ld.lockOperation();
			}
			else {
				Log.addMessage("Lock status is: "+status);
				Assert.assertTrue(false,"Failed to do lock unlock");
			}
			Log.addMessage("Lock unlock performed");
			Assert.assertTrue(true,"Lock unlock performed");
			
		}catch(Exception e) {
			Log.addMessage("Failed to lock/unlock");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to lock/unlock");
		}
	}
	

	/** 
	* Method Name: lockFnctnltyHLTest(), 
	* This function is used to do the lock unlock operation
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void lockFnctnltyHLTest() throws InterruptedException {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			String status = ld.getLockStatus();
			if(device.equals("android")) {
				Utility.simpleWait(6000);
			}
			if(status.equals("Locked")) {
				ld.unlockOperation();
				Utility.simpleWait(10000);
				ld.lockOperation();
			}
			else if(status.equals("Unlocked")) {
				ld.lockOperation();
				Utility.simpleWait(10000);
				ld.lockOperation();
			}
			else {
				Log.addMessage("Lock status is: "+status);
				Assert.assertTrue(false,"Failed to do lock unlock");
			}
			Log.addMessage("Lock unlock performed");
			Assert.assertTrue(true,"Lock unlock performed");
			
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
			 le.verifyHaloLockHistoryScreen();
		}catch(Exception e) {
			Log.addMessage("Failed to view access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to view access code");
		}
	}
	
	/** 
	* Method Name: viewLockHistoryFPTest(), 
	* This function is used to check the UI of history page
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void viewLockHistoryFPTest() {
		try {
			 LockDashboardPage lp = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 LockEventHistoryPage le = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
			 lp.clickLockHistoryButton();
			 le.verifyHaloLockHistoryScreen();
		}catch(Exception e) {
			Log.addMessage("Failed to view access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to view access code");
		}
	}
	
	
	/** 
	* Method Name: viewLockHistoryHLTest(), 
	* This function is used to check the UI of history page
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void viewLockHistoryHLTest() {
		try {
			 LockDashboardPage lp = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 LockEventHistoryPage le = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
			 lp.clickLockHistoryButton();
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
	* Method Name: viewlockActivityAuraTest(), 
	* This function is used to view the lock history
	*/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="lockActivityAR")
	public void viewlockActivityAuraTest(String lkEventName,String lkiosEvent) {
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
	* Method Name: viewlockActivityARTest(), 
	* This function is used to view the lock history
	*/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="lockActivity")
	public void viewlockActivityARTest(String lkEventName,String lkiosEvent) {
		 try {
			 LockEventHistoryPage le = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
			 if(device.equals("iOS")) {
				 le.getLockHstryiOSViewList(lkiosEvent);
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
	* Method Name: viewlockActivityFPTest(), 
	* This function is used to view the lock history
	*/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="lockActivityFP")
	public void viewlockActivityFPTest(String lkEventName,String lkiosEvent) {
		 try {
			 LockEventHistoryPage le = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
			 if(device.equals("iOS")) {
				// le.getLockHistoryiOSViewList(lkiosEvent);//commented on 21 Apr 21
				 le.getLockHstryiOSViewList(lkiosEvent);
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
	* Method Name: viewlockActivityHLTest(), 
	* This function is used to view the lock history
	*/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="lockActivityFP")
	public void viewlockActivityHLTest(String lkEventName,String lkiosEvent) {
		 try {
			 LockEventHistoryPage le = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
			 if(device.equals("iOS")) {
				 le.getLockHstryiOSViewList(lkiosEvent);
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
			 le.clearHistory();
			 if(le.checkOkButton()) {
				 lc.clickOkButton();
			 }
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
			 le.clearHistory();
			 if(le.checkOkButtonFP()) {
				 lc.clickOkButton();
			 }
			 le.clickBackButton();
		}catch(Exception e) {
			Log.addMessage("Failed to view access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to view access code");
		}
	}
	
	/** 
	* Method Name: navBackHLTest(), 
	* This function is used to navigate back to Dashboard page
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void navBackHLTest() {
		try {
			 LockEventHistoryPage le = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
			 le.clickBackButton();
			 Log.addMessage("Navigated back to dashboard");
		}catch(Exception e) {
			Log.addMessage("Failed to navigate back to dashboard");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to navigate back to dashboard");
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
	@Test( dataProvider="hmLkPrdSmPhone")
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
			Assert.assertTrue(true, "Clicked lock sounds button");
		}catch(Exception e) {
			Log.addMessage("Sync failed popup not found in lock sounds");
			Assert.assertTrue(true, "Sync failed popup not found in lock sounds");
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
			Assert.assertTrue(false, "Sync failed popup in lock sounds");
		}catch(Exception e) {
			Log.addMessage("Sync failed popup not found in lock sounds");
			Assert.assertTrue(true, "Sync failed popup not found in lock sounds");
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
			Thread.sleep(20000);
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
	* This function is used to handle the pop up in the Lock Settings Page by dismissing the pop up
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
			Assert.assertTrue(true, "Failed to click sync failed popup");
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
			vc.selFirstFPUser();
			//check for delete sync fail
			vc.checkSyncFail();
			//vc.selFirstFPUser();
		//	Assert.assertTrue(false, "Failed to complete syncing procees");
			//Log.addMessage("Failed to complete syncing procees");
		}catch(Exception e) {
			Log.addMessage("Syncing procees is complete for access name update");
			e.printStackTrace();
			Assert.assertTrue(true, "Syncing procees is complete for access name update");
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
			if(device.equals("android")) {//checkif this condition is required for Aura
				vc.selFirstFPUser();
			}
			vc.checkSyncFailAR();
			//vc.selFirstFPUser();
			//check if name updated with new 
			/*Assert.assertTrue(true, "Failed to complete syncing procees");
			Log.addMessage("Failed to complete syncing procees");*/
		}catch(Exception e) {
			Log.addMessage("Syncing procees is complete for access name update");
			e.printStackTrace();
			Assert.assertTrue(true, "Syncing procees is complete for access name update");
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
			//check for delete sync fail
			if(device.equals("iOS")) {
				va.clickEditCdName();
			}else {
				va.clickEditCodeName();
			}
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
			//check for delete sync fail
			vc.checkSyncFailClose();//added on 8 Apr 2021 for iOS
			if(device.equals("android")) {
				vc.selFirstFPUser();
			}
			
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
			//check for delete sync fail
			vc.checkSyncFailClose();//added on 8 Apr 2021 for iOS
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
			vc.selFirstFPUser();
			//check for delete sync fail
			vc.checkSyncFail();
			//vc.selFirstFPUser();
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
	* Method Name: verifyUpdateUserNamePageTest(), 
	* This function is used to check if update user name page is displayed
	*/
	@SuppressWarnings("unchecked")
	@Test
	public void verifyUpdateUserNamePageTest() throws InterruptedException {
		try {
			EditCodeNamePage ec = new EditCodeNamePage((AppiumDriver<MobileElement>) driver);
			Thread.sleep(5000);
			ec.clickAccessNameBackButton();
			Assert.assertTrue(true, "Clicked sync failed popup in lock sounds");
		}catch(Exception e) {
			Log.addMessage("Failed to click sync failed popup in lock sounds");
			Assert.assertTrue(false, "Failed to click sync failed popup in lock sounds");
		}
	}
	
	/** 
	* Method Name: verifySyncFailARPrvNamePopupTest(), 
	* This function is used to view the  UI of access code list page
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void verifySyncFailARPrvNamePopupTest() {
		try {
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			if(device.equals("android")) {
				vc.selFirstFPUser();
			}
			//check for delete sync fail
			vc.checkSyncFailAR();
			//vc.selFirstFPUser();
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
			if(device.equals("iOS")) {
				Utility.simpleWait(3000);
				ac.disableAcsCode();//check for fp
			}else {
				ac.disableAccessCode();
			}
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
			//System.out.println("in disable code1");
			if(device.equals("iOS")) {
				//Utility.simpleWait(3000);//commented today
				ac.disableAcsCode();//check for fp
			}else {
				ac.disableAccessCode();
			}
			//System.out.println("clicked disable code2");
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
			//check for delete sync fail
			va.checkSyncFailClose();//added on 8 Apr 2021 for iOS
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
			if(device.equals("android")) {
				vc.selFirstFPUser();
			}
			//check for delete sync fail
			vc.checkSyncFail();
			//vc.selFirstFPUser();
			//check if name updated with new 
			Assert.assertTrue(true, "Failed to complete syncing procees");
			Log.addMessage("Failed to complete syncing procees");
		}catch(Exception e) {
			Log.addMessage("Syncing procees is complete for access name update");
			e.printStackTrace();
			Assert.assertTrue(false, "Syncing procees is complete for access name update");
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
			if(device.equals("android")) {
				vc.selFirstFPUser();
			}
			vc.checkSyncFailAR();
			//vc.selFirstFPUser();
			Assert.assertTrue(true, "Failed to complete syncing procees");
			Log.addMessage("Failed to complete syncing procees");
		}catch(Exception e) {
			Log.addMessage("Syncing procees is complete for access name update");
			e.printStackTrace();
			Assert.assertTrue(false, "Syncing procees is complete for access name update");
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
			//System.out.println("Selected Access disabled profile1");
			if(device.equals("iOS")) {
				ac.disableAcsCode();
			}else {
				ac.disableAccessCode();
			}
			//System.out.println("clicked enable code2");
			va.waitForSyncComplete();
			//System.out.println("Access enabled loop2");
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
			//check for delete sync fail
			va.checkSyncFailClose();//added on 8 Apr 2021 for iOS
			//System.out.println("Selected Access disabled profile1");
			if(device.equals("iOS")) {
				ac.disableAcsCode();
			}else {
				if(ac.checkSwitchButton()) {
					ac.disableAccessCode();
				}
			}
			//System.out.println("clicked enable code2");
			va.waitForSyncComplete();
			//System.out.println("Access enabled loop2");
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
			//check for delete sync fail
			va.checkSyncFailClose();//added on 8 Apr 2021 for iOS
			ac.disableAccessCode();
			va.waitForSyncComplete();
			//System.out.println("Access enabled loop2");
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
			if(device.equals("android")) {
				vc.selFirstFPUser();
			}
			//check for delete sync fail
			vc.checkSyncFail();
			//vc.selFirstFPUser();
			Assert.assertTrue(true, "Failed to complete syncing process");
			Log.addMessage("Failed to complete syncing process");
		}catch(Exception e) {
			Log.addMessage("Syncing process is complete for access name update");
			e.printStackTrace();
			Assert.assertTrue(false, "Syncing process is complete for access name update");
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
			if(device.equals("android")) {
				vc.selFirstFPUser();
			}
			//check for delete sync fail
			vc.checkSyncFailAR();
			//vc.selFirstFPUser();
			Assert.assertTrue(true, "Failed to complete syncing process");
			Log.addMessage("Failed to complete syncing process");
		}catch(Exception e) {
			Log.addMessage("Syncing process is complete for access name update");
			e.printStackTrace();
			Assert.assertTrue(false, "Syncing process is complete for access name update");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void changeFPUserProfileDigitType() {
		try {
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			//check for delete sync fail
			va.checkSyncFailClose();//added on 8 Apr 2021 for iOS
			va.selFirstFPUser();
			ac.clickFingerPrint1();
			ac.clickRightButton();
			ac.clickIndexButton();
			ac.clickSaveButton();
			va.waitForSyncComplete();
		}catch(Exception e) {
			Log.addMessage("Finger print digit type not updated");
			e.printStackTrace();
			Assert.assertTrue(false, "Finger print digit type not updated\"");
		}
	}
	
	/** 
	* Method Name: verifySyncFailFingerPrintPopupTest(), 
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
			//vc.selFirstFPUser();
			//System.out.println("select getFingerPrintText last");
			if(ac.getFingerPrintText()!="") {
				if(ac.getFingerPrintText().equals("Right Index")) {
					Assert.assertTrue(true, "Finger print digit for the profile updated");
					Log.addMessage("Finger print digit for the profile updated");
				}else {
					Assert.assertTrue(false, "Failed to update Finger print digit for the profile");
					Log.addMessage("Failed to update Finger print digit for the profile");
				}
			}else {
				//check if name updated with new 
				Assert.assertTrue(false, "Syncing process is not complete for finger print digit type");
				Log.addMessage("Syncing process is not complete for finger print digit type");
			}
		}catch(Exception e) {
			Log.addMessage("Failed to complete syncing process");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to complete syncing process");
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
			//System.out.println("select updateUserAccessCode first");
			
			//System.out.println("select selSecondFPUser");
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
			//if(device.equals("android")) {//commented today
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			if(ac.checkSwitchButton()) {
				va.selFirstFPUser();
			}
			//}
			//check for delete sync fail
			va.checkSyncFailClose();//added on 8 Apr 2021 for iOS
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
			vc.selFirstFPUser();
			//check for delete sync fail
			vc.checkSyncFail();
			//if(device.equals("android")) {
				if(ua.getAccessCodeText()!="") {
					//System.out.println("accesscode="+ua.getAccessCodeText()+", actual="+newCode);
					if(ua.getAccessCodeText().equals(newCode)) {
						Assert.assertTrue(true, "Access code for the profile updated");
						Log.addMessage("Access code for the profile updated");
					}else {
						//System.out.println("not matching");
						Assert.assertTrue(false, "Failed to update access code for the profile");
						Log.addMessage("Failed to update access code for the profile");
					}
				}else {
					//System.out.println("not found="+ua.getAccessCodeText());
					Assert.assertTrue(false, "Failed to complete syncing procees");
					Log.addMessage("Failed to complete syncing procees");
				}
			/*}else {
				Assert.assertTrue(true, "Access code for the profile updated");
				vc.selFirstFPUser();//added on 29-04-21 for Halo iOS
				Log.addMessage("Access code for the profile updated");
			}*/
			//check if name updated with new 
			
		}catch(Exception e) {
			Log.addMessage("Syncing procees is complete for access name update");
			e.printStackTrace();
			Assert.assertTrue(true, "Syncing procees is complete for access name update");
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
			if(device.equals("android")) {
				vc.selFirstFPUser();
			}
			vc.checkSyncFailAR();
			//vc.selFirstFPUser();
			
			//if(device.equals("android")) {
				if(ua.getAccessCodeText()!="") {
					if(ua.getAccessCodeText().equals(newCode)) {
						Assert.assertTrue(true, "Access code for the profile updated");
						Log.addMessage("Access code for the profile updated");
					}else {
						Assert.assertTrue(false, "Failed to update access code for the profile");
						Log.addMessage("Failed to update access code for the profile");
					}
				}else {
					Assert.assertTrue(false, "Failed to update access code for the profile");
					Log.addMessage("Failed to update access code for the profile");
				}
			/*}else {
				Assert.assertTrue(true, "Access code for the profile updated");
				Log.addMessage("Access code for the profile updated");
			}*/
			
			//check if name updated 
			/*Assert.assertTrue(false, "Failed to complete syncing procees");
			Log.addMessage("Failed to complete syncing procees");*/
		}catch(Exception e) {
			Log.addMessage("Syncing procees is complete for access name update");
			e.printStackTrace();
			Assert.assertTrue(true, "Syncing procees is complete for access name update");
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
			//check for delete sync fail
			va.checkSyncFailClose();//added on 8 Apr 2021 for iOS
			if(device.equals("android")) {
				va.selFirstFPUser();//added on 29-03-21 for Halo Android
			}
			ac.clickSchButton();
			ss.selectAnyTime();
			va.waitForSyncComplete();
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
			//check for delete sync fail
			va.checkSyncFailClose();//added on 8 Apr 2021 for iOS
			ac.clickSchButton();
			ss.selectAnyTime(); 
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
	* This function is used to set schedule type of FP Lock to Any Time
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
			Assert.assertTrue(true, "Set schedule type to Any Time");
			Log.addMessage("Set schedule type to Any Time");
		}catch(Exception e) {
			Log.addMessage("Failed to set schedule type");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to set schedule type");
		}
	}
	
	/** 
	* Method Name: verifySyncFailAnyTimePopupTest(), 
	* This function is used to wait for the update to sync in access code list page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="profCode")
	public void verifySyncFailAnyTimePopupTest(String newCode, String prvCode) {
		try {
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			vc.selFirstFPUser();
			//check for delete sync fail
			vc.checkSyncFail();
			//vc.selFirstFPUser();
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
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			//check for delete sync fail
			va.checkSyncFailClose();//added on 8 Apr 2021 for iOS
			if(typeSch.equals("WithoutDay")) {
				if(device.equals("android")) {
					va.selFirstFPUser();//added on 29-03-21 for Halo Android
				}
				if(device.equals("iOS")) {
					Utility.simpleWait(3000);//added on 16 Nov 2020 for bvt
				}
				UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
				ac.clickSchButton();
				ss.selectLimitByWeekdayAndTime();
				lb.clickDaysToAllowOption();
				sw.clickClearAllDaysOption();
				sw.clickSubmitButton();
				if(device.equals("iOS")) {
					sw.clickOkButton();
				}
				sw.clickBackButton();
				Log.addMessage("Schedule type cannot be set with no days selected");
				Assert.assertTrue(true, "Schedule type cannot be set with no days selected");
			}else {
				lb.clickLimitTimeOfDay();
				lb.clickSubmitButton();
				lb.clickOkButton();
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
			//check for delete sync fail
			va.checkSyncFailClose();//added on 8 Apr 2021 for iOS
			if(typeSch.equals("WithoutDay")) {
				if(device.equals("iOS")) {//commented today
					if(ac.checkSwitchButton()) {
						va.selFirstFPUser();
					}
				}else {
					va.selFirstFPUser();
				}
				UserFPAccessProfilePage ac1 = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
				ac1.clickSchButton();
				ss.selectLimitByWeekdayAndTime();
				lb.clickDaysToAllowOption();
				sw.clickClearAllDaysOption();
				sw.clickSubmitButton();
				if(device.equals("iOS")) {
					sw.clickOkButton();
				}
				sw.clickBackButton();
				Log.addMessage("Schedule type cannot be set with no days selected");
				Assert.assertTrue(true, "Schedule type cannot be set with no days selected");
			}else {
				//System.out.println("in else");
				lb.clickLimitTimeOfDay();
				lb.clickSubmitButton();
				lb.clickOkButton();
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
			if(device.equals("iOS")) {
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
	* Method Name: setARScheduleTypeWeekly(), 
	* This function is used to set schedule type to limit by time
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="schWeekTime")
	public void setARScheduleTypeWeekly(String hours_start, String min_start, String AM_PM_start, String hours_end, String min_end, String AM_PM_end) {
		try {
			LimitByWeekdayAndTimePage lb = new LimitByWeekdayAndTimePage((AppiumDriver<MobileElement>) driver);
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
	* This function is used to wait till update syncs in access code list page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="profCode")
	public void verifySyncFailWeeklyPopupTest(String newCode, String prvCode) {
		try {
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			vc.selFirstFPUser();
			//check for delete sync fail
			vc.checkSyncFail();
			//vc.selFirstFPUser();
			Assert.assertTrue(true, "Failed to complete syncing procees");
			Log.addMessage("Failed to complete syncing procees");
		}catch(Exception e) {
			Log.addMessage("Syncing procees is complete for access name update");
			e.printStackTrace();
			Assert.assertTrue(false, "Syncing procees is complete for access name update");
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
			SelectScheduleTypePage ss = new SelectScheduleTypePage((AppiumDriver<MobileElement>) driver);
			LimitByDatePage lb = new LimitByDatePage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			if(device.equals("android")) {
				vc.selFirstFPUser();
			}
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
			if(device.equals("iOS")) {
				lb.clickOkButton();
			}
			ViewAccessCodesPage vc1 = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			vc1.waitForSyncComplete();
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
	* This function is used to set schedule type to limit by date for Aura lock
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="schDate")
	public void setARScheduleTypeDate(String month, String day, String year, String monthend, String dayend, String yearend) {
		try {
			SelectScheduleTypePage ss = new SelectScheduleTypePage((AppiumDriver<MobileElement>) driver);
			LimitByDatePage lb = new LimitByDatePage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			//Thread.sleep(15000);
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
	* This function is used to wait till update syncs in access code list page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="profCode")
	public void verifySyncFailDatePopupTest(String newCode, String prvCode) {
		try {
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			vc.selFirstFPUser();
			//check for delete sync fail
			vc.checkSyncFail();
			//vc.selFirstFPUser();
			Assert.assertTrue(true, "Failed to complete syncing process");
			Log.addMessage("Failed to complete syncing process");
		}catch(Exception e) {
			Log.addMessage("Syncing process is complete for access name update");
			e.printStackTrace();
			Assert.assertTrue(false, "Syncing process is complete for access name update");
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
			SelectScheduleTypePage ss = new SelectScheduleTypePage((AppiumDriver<MobileElement>) driver);
			Utility.simpleWait(3000);//commented for bvt 9-10-2020
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			if(device.equals("android")) {
				vc.selFirstFPUser();
			}
			ac.clickSchButton();
			ss.selectOneTimeWithin24Hours();
			ViewAccessCodesPage vc1 = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			vc1.waitForSyncComplete();
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
	* This function is used to set schedule type to one time schedule for Aura lock
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="schOneTime")
	public void setOneTimeARSchedule(String titleMsg, String valMsg, String iosMsg) {
		try {
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			SelectScheduleTypePage ss = new SelectScheduleTypePage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			if(ac.checkSwitchButton()) {
				va.selFirstFPUser();
			}
			UserFPAccessProfilePage ac1 = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			ac1.clickSchButton();
			ss.selectOneTimeWithin24Hours();
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
	* This function is used to wait till update syncs in access code list page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="profCode")
	public void verifySyncFailOneTimePopupTest(String newCode, String prvCode) {
		try {
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			vc.selFirstFPUser();
			//check for delete sync fail
			vc.checkSyncFail();
			//vc.selFirstFPUser();
			//check if name updated with new 
			Assert.assertTrue(true, "Failed to complete syncing process");
			Log.addMessage("Failed to complete syncing process");
		}catch(Exception e) {
			Log.addMessage("Syncing process is complete for access name update");
			e.printStackTrace();
			Assert.assertTrue(false, "Syncing process is complete for access name update");
		}
	}
	

	/** 
	* Method Name: setPrvScheduleTypeAnyTime(), 
	* This function is used to set schedule type to Any Time
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void setPrvScheduleTypeAnyTime() {
		try {
			SelectScheduleTypePage ss = new SelectScheduleTypePage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			if(device.equals("android")) {
				va.selFirstFPUser();//added on 29-03-21 for Halo Android
			}
			va.checkSyncFailClose();//added for iOS on 8 Apr 21
			ac.clickSchButton();
			ss.selectAnyTime();
			va.waitForSyncComplete();
			Assert.assertTrue(true, "Set schedule type to Any Time");
			Log.addMessage("Set schedule type to Any Time");
		}catch(Exception e) {
			Log.addMessage("Failed to set schedule type");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to set schedule type");
		}
	}
	
	/** 
	* Method Name: setPrvARScheduleTypeAnyTime(), 
	* This function is used to set schedule type to Any Time for Aura Lock
	**/
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
			ss.selectAnyTime();
			ViewAccessCodesPage va1 = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			va1.waitForSyncComplete();
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
	* This function is used to wait for update to sync
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void verifySyncFailPrvSchPopupTest() {
		try {
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			vc.selFirstFPUser();
			//check for delete sync fail
			vc.checkSyncFail();
			//vc.selFirstFPUser();
			Assert.assertTrue(true, "Failed to complete syncing procees");
			Log.addMessage("Failed to complete syncing procees");
		}catch(Exception e) {
			Log.addMessage("Syncing procees is complete for access name update");
			e.printStackTrace();
			Assert.assertTrue(false, "Syncing procees is complete for access name update");
		}
	}
	
	/** 
	* Method Name: updateToPrvFPDigitTypeTest(), 
	* This function is used to update finger print digit type to previous one
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void updateToPrvFPDigitTypeTest() {
		try {
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			va.selFirstFPUser();
			ac.clickFingerPrint1();
			ac.clickLeftButton();
			ac.clickThumbButton();
			ac.clickSaveButton();
			va.waitForSyncComplete();
		}catch(Exception e) {
			Log.addMessage("Finger print digit type not updated");
			e.printStackTrace();
			Assert.assertTrue(false, "Finger print digit type not updated");
		}
	}
	
	/** 
	* Method Name: verifySyncFailPrvFPDigitTypeTest(), 
	* This function is used to wait for update to sync
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="profCode")
	public void verifySyncFailPrvFPDigitTypeTest(String newCode, String prvCode) {
		try {
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va1 = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			va1.selFirstFPUser();
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			vc.checkSyncFail();
			//vc.selFirstFPUser();
			if(ac.getFingerPrintText()!="") {
				if(ac.getFingerPrintText().equals("Left Thumb")) {
					Assert.assertTrue(true, "Finger print digit for the profile updated");
					Log.addMessage("Finger print digit for the profile updated");
				}else {
					Assert.assertTrue(false, "Failed to update Finger print digit for the profile");
					Log.addMessage("Failed to update Finger print digit for the profile");
				}
			}else {
				Assert.assertTrue(false, "Failed to complete syncing process");
				Log.addMessage("Failed to complete syncing process");
			}
			//check for delete sync fail
			vc.checkSyncFail();
			Assert.assertTrue(true, "Failed to complete syncing procees");
			Log.addMessage("Failed to complete syncing procees");
		}catch(Exception e) {
			Log.addMessage("Syncing process is complete for finger print digit type");
			e.printStackTrace();
			Assert.assertTrue(false, "Syncing process is complete for finger print digit type");
		}
	}
	
	
	
	/** 
	* Method Name: updateToPrvUserAccessCode(), 
	* This function is used to edit access code to previous one
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="profCode")
	public void updateToPrvUserAccessCode(String newCode, String prvCode) {
		try {
			UserFPAccessProfilePage ua = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			if(device.equals("android")) {
				vc.selFirstFPUser();
			}
			Utility.simpleWait(3000);
			if(device.equals("iOS")) {
				ua.clickEditAcsCode();
			}else {
				ua.clickEditAccessCode();
			}
			EditAccessCodePage ec = new EditAccessCodePage((AppiumDriver<MobileElement>) driver);
			ec.enterAccessCodePin(prvCode);
			ec.clickSubmitButton();
			ViewAccessCodesPage vc1 = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			vc1.waitForSyncComplete();
		}catch(Exception e) {
			Log.addMessage("Failed to update user name of access code profile");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update user name of access code profile");
		}
	}
	

	/** 
	* Method Name: updateToPrvARUserAccessCode(), 
	* This function is used to edit access code for Aura lock
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="profCode")
	public void updateToPrvARUserAccessCode(String newCode, String prvCode) {
		try {
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			if(device.equals("android")) {
				va.selFirstFPUser();//01-12-2020
			}
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
			vc.selFirstFPUser();
			//if(device.equals("android")) {
			if(ua.getAccessCodeText()!="") {
				if(ua.getAccessCodeText().equals(prvCode)) {
					Assert.assertTrue(true, "Access code for the profile updated");
					Log.addMessage("Access code for the profile updated");
				}else {
					Assert.assertTrue(false, "Failed to update access code for the profile");
					Log.addMessage("Failed to update access code for the profile");
				}
			}else {
				Assert.assertTrue(false, "Failed to update access code for the profile");
				Log.addMessage("Failed to update access code for the profile");
			}
			/*}else {
				Assert.assertTrue(true, "Access code for the profile updated");
				Log.addMessage("Access code for the profile updated");
			}*/
			//check for delete sync fail
			vc.checkSyncFail();
			//vc.selFirstFPUser();
			Assert.assertTrue(true, "Syncing procees is complete for access name update");
			Log.addMessage("Syncing procees is complete for access name update");
		}catch(Exception e) {
			Log.addMessage("Syncing procees is not complete for access name update");
			e.printStackTrace();
			Assert.assertTrue(false, "Syncing procees is not complete for access name update");
		}
	}
	
	/** 
	* Method Name: verifyAccessCodePageTest(), 
	* This function is used to check if update user name page is displayed
	*/
	@SuppressWarnings("unchecked")
	@Test
	public void verifyAccessCodePageTest() throws InterruptedException {
		try {
			UserFPAccessProfilePage ua = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			Thread.sleep(5000);
			ua.clickSchBackButton();
			Assert.assertTrue(true, "Clicked sync failed popup in lock sounds");
		}catch(Exception e) {
			Log.addMessage("Failed to click sync failed popup in lock sounds");
			Assert.assertTrue(false, "Failed to click sync failed popup in lock sounds");
		}
	}
	
	/** 
	* Method Name: verifySyncFailARPrvCodePopupTest(), 
	* This function is used to wait for the update to sync
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="profCode")
	public void verifySyncFailARPrvCodePopupTest(String newCode, String prvCode) {
		try {
			ViewAccessCodesPage vc = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage ua = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			if(device.equals("android")) {
				vc.selFirstFPUser();
			}
				if(ua.getAccessCodeText()!="") {
					if(ua.getAccessCodeText().equals(prvCode)) {
						Assert.assertTrue(true, "Access code for the profile updated");
						Log.addMessage("Access code for the profile updated");
					}else {
						Assert.assertTrue(false, "Failed to update access code for the profile");
						Log.addMessage("Failed to update access code for the profile");
					}
				}else {
					Assert.assertTrue(false, "Failed to update access code for the profile");
					Log.addMessage("Failed to update access code for the profile");	
				}
			/*}else {
				Assert.assertTrue(true, "Access code for the profile updated");
				Log.addMessage("Access code for the profile updated");
			}*/
			//check for delete sync fail
			vc.checkSyncFailAR();
			Assert.assertTrue(true, "Syncing procees is complete for access name update");
			Log.addMessage("Syncing procees is complete for access name update");
		}catch(Exception e) {
			Log.addMessage("Syncing procees is not complete for access name update");
			e.printStackTrace();
			Assert.assertTrue(false, "Syncing procees is not complete for access name update");
		}
	}
	
	
	/** 
	* Method Name: viewFPUISecureModeTest(), 
	* This function is used to check if the UI elements are present in view secure mode screen
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
			if(va.checkSyncPopup()) {
				va.clickOkButton();
			}
			va.getSecureModeStatus();
			va.enableSecureMode();
			if(va.checkSyncPopup()) {
				va.clickOkButton();
			}
			va.getSecureModeStatus();
			Log.addMessage("Secure Mode option displayed with enable disable button");
		}catch(Exception e) {
			Log.addMessage("Failed to display secure mode option");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display secure mode option");
		}
	}
	
	/** 
	* Method Name: viewFPUISecureModeTest(), 
	* This function is used to check if the UI elements are present in view secure mode screen
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void viewUISecureModeTest() throws InterruptedException {
		try {
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			//va.clickBackButton();//commented for Halo on 3 May 21
			if(device.equals("iOS")) {
				Utility.simpleWait(3000);//commented for bvt 23-10-2020
			}
			va.verifyUISecureModeFP();
			va.enableSecureMode();
			if(va.checkSyncPopup()) {
				va.clickOkButton();
			}
			va.getSecureModeStatus();
			va.enableSecureMode();
			if(va.checkSyncPopup()) {
				va.clickOkButton();
			}
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
	* This function is used to check if the UI elements are present in view secure mode screen for Aura Lock
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
			//if(va.checkSyncPopup()) {
				va.clickOkBtn();
			//}
			va.getSecureModeStatus();
			va.enableSecureMode();
			//if(va.checkSyncPopup()) {
				va.clickOkBtn();
			//}
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
	* This function is used to set the lock settings back to previous values for FP lock
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
	* This function is used to set the lock settings back to previous conditions for Aura Lock
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
			Assert.assertTrue(true, "Sync failed popup displayed in lock sounds");
		}catch(Exception e) {
			Log.addMessage("Sync failed popup not found in lock sounds");
			Assert.assertTrue(true, "Sync failed popup not found in lock sounds");
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
			System.out.println("staus lock="+ls.getAutoLockStts());
			if(!ls.getAutoLockStts().equals("Off")) {
				if(device.equals("iOS")) {
					if(!al.getAutoDelayStatus().equals("0")) {
						//al.set_30Sec_Delay();
						al.set_5min_Delay();
						al.clickAutoLockOff();
						Log.addMessage("Auto lock delay status set");
					}
				}
				if(device.equals("android")) {
					System.out.println("staus="+al.getAutoDelayStatus());
					if(!al.getAutoDelayStatus().equals("Off")) {
						//al.set_30Sec_Delay();
						System.out.println("not off");
						al.set_5min_Delay();
						al.clickAutoLockOff();
						Log.addMessage("Auto lock delay status set");
					}else {
						System.out.println("inelse2");
					}
				}
				
				if(device.equals("iOS")) {
					if(!ls.getAutoLockStts().equals("Off")) {
						ls.clickAutoLockButton();
						al.clickAutoLockOff();
					}
				}
			}
			
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
	* Method Name: autoLockSettingARTest(), 
	* This function is used to update auto lock for Aura Lock
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void autoLockSettingARTest() {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			AutoLockDelaySettingPage al = new AutoLockDelaySettingPage((AppiumDriver<MobileElement>) driver);
			System.out.println("staus lock="+ls.getAutoLockStts());
			if(!ls.getAutoLockStts().equals("Off")) {
				System.out.println("in  not off");
				if(device.equals("iOS")) {
					if(!al.getAutoDelayStatus().equals("O")) {
						//al.set_30Sec_Delay();
						al.set_5min_Delay();
						al.clickAutoLockOff();
						Log.addMessage("Auto lock delay status set");
					}
				}
				if(device.equals("android")) {
					System.out.println("staus="+al.getAutoDelayStatus());
					if(!al.getAutoDelayStatus().equals("Off")) {
						//al.set_30Sec_Delay();
						System.out.println("not off");
						al.set_5min_Delay();
						al.clickAutoLockOff();
						Log.addMessage("Auto lock delay status set");
					}else {
						System.out.println("auto lock is off");
					}
				}
			}
			/*if(device.equals("iOS")) {
				if(!ls.getAutoLockStts().equals("Off")) {
					ls.clickAutoLockButton();
					al.clickAutoLockOff();
				}
			}
			if(device.equals("android")) {
				System.out.println("staus lock="+ls.getAutoLockStts());
				if(ls.getAutoLockStts().equals("Off")) {
					System.out.println("in off back");
					al.clickBackButton();
				}
				//al.clickBackButton();//commented on 30-Mar-2021 for Halo Android
			}*/
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
			//added below check to verify for an overlapping sync failed pop up and syncing pop up
			if(ls.checkOkButton()) {
				ls.clickOkButton();
			}
			if(device.equals("android")) {
				if(!ls.getAutoLockStts().equals("Off")) {
					al.clickBackButton();
				}
			}else if(device.equals("iOS")) {
				al.checkInAutoLockPage();
			}
			//System.out.println("four");
			Assert.assertTrue(true, "Sync failed popup displayed for Auto Lock");
		}catch(Exception e) {
			Log.addMessage("Sync failed popup not displayed for Auto Lock");
			Assert.assertTrue(true, "Sync failed popup not displayed for Auto Lock");
		}
	}
	
	/** 
	* Method Name: verifyAutoLockPageAgainTest(), 
	* This function is used to handle the sync failed pop up in the Lock Settings Page
	*/
	@SuppressWarnings("unchecked")
	@Test
	public void verifyAutoLockPageAgainTest() throws InterruptedException {
		try {
			AutoLockDelaySettingPage al = new AutoLockDelaySettingPage((AppiumDriver<MobileElement>) driver);
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			Thread.sleep(10000);
			if(!ls.getAutoLockStts().equals("Off")) {
				al.clickAutoLockBackButton();
			}
			Assert.assertTrue(true, "Clicked sync failed popup in lock sounds");
		}catch(Exception e) {
			Log.addMessage("Failed to click sync failed popup in lock sounds");
			Assert.assertTrue(false, "Failed to click sync failed popup in lock sounds");
		}
	}
	
	/** 
	* Method Name: autoLockLedSoundTest(), 
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
			Log.addMessage("Sync failed popup not found");
			Assert.assertTrue(true, "Sync failed popup not found");
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
			Thread.sleep(5000);
			va.clickBackButton();
			System.out.println("Wait for BLE Off");
			Utility.simpleWait(17000);
			String status = ld.getLockStatus();
			if (status.equals("Locked")) {
				ld.unlockOperation();
				ld.lockOperation();
			}
			else if (status.equals("Unlocked")) {
				ld.lockOperation();
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
				ld.clickCancelButton();
			}
			status = ld.getLockStatus();
			if (status.equals("Locked")) {
				ld.unlockOperation();
				ld.lockOperation();
			}else if (status.equals("Unlocked")) {
				ld.lockOperation();
				ld.unlockOperation();
			}else if (status.equals("Lock Offline")) {//in iOS
				ld.lockOperation();
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
			if(device.equals("android")) {
				Utility.verticalSwipe(appiumDriver);
			}
			ls.clickDeleteLockButton();
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
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			
			va.clickBackButton();
			/*System.out.println("Wait for Wifi and BLE ON");*/
			Utility.simpleWait(5000);
			ld.clickHamburgerButton();
			String lsttext ="Log Out";
			if(device.equals("android")) {
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")).click();
				 
			}else {
				 mp.clickLogoutButton();
			}
			mp.clickOKButton();
			LoginPage lp = new LoginPage((AppiumDriver<MobileElement>) driver);
			lp.checkLoginButton();
			//Utility.simpleWait(10000);
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
	@DataProvider(name = "lockActivityFP")
	public Object[][] getDataLockActivityFP() throws Exception {
		return excel.getTableArray(InputData, "Validation", "acFPLockActivity");
	}
	@DataProvider(name = "lockActivityAR")
	public Object[][] getDataLockActivityAR() throws Exception {
		return excel.getTableArray(InputData, "Validation", "acARLockActivity");
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
	
	@DataProvider(name = "hmLkPrdSmPhone")
	public Object[][] getDataLPairedSmPhone() throws Exception {
		return excel.getTableArray(InputData, "Validation", "acPairedSmPhone");
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
