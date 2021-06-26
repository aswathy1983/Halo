package tests.app;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pages.app.AccessCodePage;
import pages.app.AccountSettingsPage;
import pages.app.AddAccessCodePage;
import pages.app.AppUpgradePage;
import pages.app.AutoLockDelaySettingPage;
import pages.app.ChooseVerificationMethodPage;
import pages.app.CodeVerificationPage;
import pages.app.EnterMobileNumberPage;
import pages.app.HomeUserList;
import pages.app.LockDashboardPage;
import pages.app.LockEventHistoryPage;
import pages.app.LockInfoPage;
import pages.app.LockNamePage;
import pages.app.LockSettingsPage;
import pages.app.LoginPage;
import pages.app.ManageHomesPage;
import pages.app.MenuFlyoutPage;
import pages.app.PairedSmartPhoneListPage;
import pages.app.SelectScheduleTypePage;
import pages.app.SettingsPage;
import pages.app.UpdateAccountNamePage;
import pages.app.UpdatePhoneNumberPage;
import pages.app.ViewAccessCodesPage;
import utility.ExcelRead;
import utility.Log;

public class DataRetentionTest extends Settings{
	
int cnt, usr, cdcnt, lkcnt, sbcnt, timecnt, cntPhone = 0;
String currStatus, autoLkStts = "";

	/** 
	* Method Name: loginDataUserTest(), 
	* This function is used to login to the app
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="userData")
	public void loginDataUserTest(String email, String password) {
		try {
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 cv.selectEmail();
			 cv.clickSubmit();
			 System.out.println("wait to retrieve verification code from email");
			 //get verification code from mail and submit
			 cvp.readCodeFromEmail("email.address", "email.password");//added 3rd param on 18-02-2021 for user account QA
			 cvp.clickSubmitButton(); 
			}catch(Exception e) {
				Log.addMessage("Failed to log in");
				e.printStackTrace();
				Assert.assertTrue(false, "Failed to log in");
			}
	}

/** 
	* Method Name: appUpgradeTest(), 
	* This function is used to do the app upgrade test to the latest version
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void appUpgradeTest() throws InterruptedException {
		try {
			AppUpgradePage au = new AppUpgradePage((AppiumDriver<MobileElement>) driver);
			au.appUpgrade();
			Log.addMessage("App upgrade completed");
		}catch(Exception e) {
			 Log.addMessage("Failed to upgrade the app");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to upgrade the app");
		 }
	}
	
	/** 
	* Method Name: accountNameTest(), 
	* This function is used to verify if account name is retained after app upgrade
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="acName")
	public void accountNameTest(String firstName, String lastName) {
	 try {
		 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
		 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
		 SettingsPage sp = new SettingsPage((AppiumDriver<MobileElement>) driver);
		 AccountSettingsPage as = new AccountSettingsPage((AppiumDriver<MobileElement>) driver);
		 UpdateAccountNamePage ua = new UpdateAccountNamePage((AppiumDriver<MobileElement>) driver);
			ld.clickHamburgerButton();
			mf.clickAccountSettingsButton();
			sp.clickAccountOption();
			as.clickNameOption();
			ua.verifyAccountName(firstName, lastName);
			Log.addMessage("Account name is matching");
		 }catch(Exception e) {
			 Log.addMessage("Account name is not matching");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Account name is not matching");
		 }
	}
	
	/** 
	* Method Name: navigateBackTest(), 
	* This function is used to navigate back to lock settings page
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void navigateBackTest() {
	 try {
		 	UpdateAccountNamePage ua = new UpdateAccountNamePage((AppiumDriver<MobileElement>) driver);	
			ua.clickBack();
			Log.addMessage("Navigated back to lock settings page");
		 }catch(Exception e) {
			 Log.addMessage("Failed to navigate back to lock settings page");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to navigate back to lock settings page");
		 }
	}
	
	/** 
	* Method Name: phoneNumberTest(), 
	* This function is used to verify if phone number is retained
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="pNum")
	public void phoneNumberTest(String phoneNumber) {
	 try {
		 AccountSettingsPage as = new AccountSettingsPage((AppiumDriver<MobileElement>) driver);
		 UpdatePhoneNumberPage up = new UpdatePhoneNumberPage((AppiumDriver<MobileElement>) driver);
		 EnterMobileNumberPage em = new EnterMobileNumberPage((AppiumDriver<MobileElement>) driver);
			as.clickPhoneNumberOption();
			if(em.checkCountryCodeButton())
			up.verifyPhoneNumber(phoneNumber);
			Log.addMessage("Phone Number is matching");
		 }catch(Exception e) {
			 Log.addMessage("Phone Number not matching");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Phone Number not matching");
		 }
	}
	
	/** 
	* Method Name: phoneNumberBackTest(), 
	* This function is used to navigate back to lock dashboard page
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void phoneNumberBackTest() {
	 try {
			AccountSettingsPage as = new AccountSettingsPage((AppiumDriver<MobileElement>) driver);
			UpdatePhoneNumberPage up = new UpdatePhoneNumberPage((AppiumDriver<MobileElement>) driver);
		 	up.clickBackButton();
		 	as.clickNavBack();
			//as.clickNavBack();
			Log.addMessage("Navigated back to lock dashboard");
		 }catch(Exception e) {
			 Log.addMessage("Failed to navigate back to lock dashboard");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to navigate back to lock dashboard");
		 }
	}
	
	/** 
	* Method Name: homeNameTest(), 
	* This function is used to verify if the home names are retained for android
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="hmName")
	public void homeNameTest(String homeName) {
		 try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 if(cnt==0) {
				 ld.clickHamburgerButton();
			 }
			 cnt =cnt+1;
			 mp.verifyAllHomes(homeName, cnt-1);
			 Log.addMessage("Added homes are listed");
		 }catch(Exception e) {
			 Log.addMessage("Failed to list the added homes");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to list the added homes");
		 }
	}
	
	/** 
	* Method Name: homeNameiOSTest(), 
	* This function is used to verify if the home names are retained for iOS
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="hmNameiOS")
	public void homeNameiOSTest(String homeName) {
		 try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 if(cnt==0) {
				 ld.clickHamburgerButton();
			 }
			 cnt =cnt+1;
			 mp.verifyAllHomesiOS(homeName, cnt-1);
			 Log.addMessage("Added homes are listed");
		 }catch(Exception e) {
			 Log.addMessage("Failed to list the added homes");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to list the added homes");
		 }
	}
	
	/** 
	* Method Name: homeUserTest(), 
	* This function is used to verify if the home users are retained for a home
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="hmUser")
	public void homeUserTest(String homeUser,String homeUserType) {
		 try {
			 MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 HomeUserList hu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			 if(usr==0) {
				 mp.clickManageButton();
				 mh.clickManageHomeUsersButton();
			 }
			 usr =usr+1;
			 hu.verifyHomeUsers(homeUser, homeUserType, usr-1);
			 Log.addMessage("Users fot the home are listed");
		 }catch(Exception e) {
			 Log.addMessage("Failed to list the home users");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to list the home users");
		 }
	}
	

	
	/** 
	* Method Name: homenavBackTest(), 
	* This function is used to navigate back to lock history page
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void homenavBackTest() {
		 try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 HomeUserList hu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			 hu.clickBackButton();
			 mh.clickBackButton();
			 ld.clickLockHistoryButton();
			 Log.addMessage("Navigated to Lock history page");
		 }catch(Exception e) {
			 Log.addMessage("Failed to navigate to Lock history page");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to navigate to Lock history page");
		 }
	}
	
	/** 
	* Method Name: homenavBackHlTest(), 
	* This function is used to navigate back to lock history page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="lkNameHl")
	public void homenavBackHLTest(String lkName, String hmName) {
		 try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 HomeUserList hu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			
			 hu.clickBackButton();
			 mh.clickBackButton();
			 ld.clickHamburgerButton();
			 mf.verifyLockInMenu(hmName);
			 MenuFlyoutPage mf1 = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 mf1.clickLockInMenu(lkName);
			 LockDashboardPage ld1 = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 //below code to select the lock after the order of locks listed changes
			/* if(device.equals("iOS")) {
				 ld1.clickHamburgerButton();
				 mf1.verifyLockInMenu(hmName);
				 MenuFlyoutPage mf2 = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
				 mf2.clickLockInMenu(lkName);
			 }*/
			 ld1.clickLockHistoryButton();
			 Log.addMessage("Navigated to Lock history page");
		 }catch(Exception e) {
			 Log.addMessage("Failed to navigate to Lock history page");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to navigate to Lock history page");
		 }
	}
	
	/** 
	* Method Name: homenavBackFPTest(), 
	* This function is used to navigate back to lock history page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="lkNameFP")
	public void homenavBackFPTest(String lkName, String hmName) {
		 try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 HomeUserList hu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			
			 hu.clickBackButton();
			 mh.clickBackButton();
			 ld.clickHamburgerButton();
			 mf.verifyLockInMenu(hmName);
			 MenuFlyoutPage mf1 = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 mf1.clickLockInMenu(lkName);
			 ld.clickLockHistoryButton();
			 Log.addMessage("Navigated to Lock history page");
		 }catch(Exception e) {
			 Log.addMessage("Failed to navigate to Lock history page");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to navigate to Lock history page");
		 }
	}
	
	/** 
	* Method Name: homenavBackARTest(), 
	* This function is used to navigate back to lock history page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="lkNameAR")
	public void homenavBackARTest(String lkName, String hmName) {
		 try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 HomeUserList hu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			
			 hu.clickBackButton();
			 mh.clickBackButton();
			 ld.clickHamburgerButton();
			 mf.verifyLockInMenu(hmName);
			 MenuFlyoutPage mf1 = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 mf1.clickLockInMenu(lkName);
			 ld.clickLockHistoryButton();
			 Log.addMessage("Navigated to Lock history page");
		 }catch(Exception e) {
			 Log.addMessage("Failed to navigate to Lock history page");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to navigate to Lock history page");
		 }
	}
	
	/** 
	* Method Name: homeLockHistoryHaloTest(), 
	* This function is used to verify if the lock history is maintained in the page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="hmLockHistryHalo")
	public void homeLockHistoryHaloTest(String lkEventName,String lkSubType, String lkTime, String lkHlTime, String lkiosEvent) {
		 try {
			 LockEventHistoryPage le = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
			
			 if(lkSubType!="") {
				 sbcnt++;
			 }
			 if(lkTime!="") {
				 timecnt++;
			 }
			 lkcnt =lkcnt+1;
			 if(device.equals("iOS")) {
				 le.getLockHistoryiOSList(lkiosEvent, lkHlTime, lkcnt-1, sbcnt-1,timecnt-1);
			 }else {
				 le.getLockHistoryList(lkEventName, lkSubType, lkTime, lkcnt-1, sbcnt-1,timecnt-1);
			 }
			 Log.addMessage("Lock History is listed");
		 }catch(Exception e) {
			 Log.addMessage("Failed to list lock history");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to list lock history");
		 }
	}
	
	/** 
	* Method Name: homeLockHistoryFPTest(), 
	* This function is used to verify if the lock history is maintained in the page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="hmfplockHistry")
	public void homeLockHistoryFPTest(String lkEventName,String lkSubType, String lkTime, String lkHlTime, String lkiosEvent) {
		 try {
			 LockEventHistoryPage le = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
			
			 if(lkSubType!="") {
				 sbcnt++;
			 }
			 if(lkTime!="") {
				 timecnt++;
			 }
			 lkcnt =lkcnt+1;
			 if(device.equals("iOS")) {
				 le.getLockHistoryiOSList(lkiosEvent, lkHlTime, lkcnt-1, sbcnt-1,timecnt-1);
			 }else {
				 le.getLockHistoryList(lkEventName, lkSubType, lkTime, lkcnt-1, sbcnt-1,timecnt-1);
			 }
			 Log.addMessage("Lock History is listed");
		 }catch(Exception e) {
			 Log.addMessage("Failed to list lock history");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to list lock history");
		 }
	}
	
	/** 
	* Method Name: homeLockHistoryARTest(), 
	* This function is used to verify if the lock history is maintained in the page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="hmARlockHistry")
	public void homeLockHistoryARTest(String lkEventName,String lkSubType, String lkTime, String lkHlTime, String lkiosEvent) {
		 try {
			 LockEventHistoryPage le = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
			
			 if(lkSubType!="") {
				 sbcnt++;
			 }
			 if(lkTime!="") {
				 timecnt++;
			 }
			 lkcnt =lkcnt+1;
			 if(device.equals("iOS")) {
				 le.getLockHistoryiOSList(lkiosEvent, lkHlTime, lkcnt-1, sbcnt-1,timecnt-1);
			 }else {
				 le.getLockHistoryList(lkEventName, lkSubType, lkTime, lkcnt-1, sbcnt-1,timecnt-1);
			 }
			 Log.addMessage("Lock History is listed");
		 }catch(Exception e) {
			 Log.addMessage("Failed to list lock history");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to list lock history");
		 }
	}
	
	
	/** 
	* Method Name: homeLockHistoryTest(), 
	* This function is used to verify if the lock history is maintained in the page
	**/
	@SuppressWarnings("unchecked")
	@Test( dataProvider="hmLockHistry")
	public void homeLockHistoryTest(String lkEventName,String lkSubType, String lkTime) {
		 try {
			 LockEventHistoryPage le = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver); 
			 if(lkSubType!="") {
				 sbcnt++;
			 }
			 if(lkTime!="") {
				 timecnt++;
			 }
			 lkcnt =lkcnt+1;
			 le.getLockHistoryList(lkEventName, lkSubType, lkTime, lkcnt-1, sbcnt-1,timecnt-1);
			 Log.addMessage("Lock History is listed");
		 }catch(Exception e) {
			 Log.addMessage("Failed to list lock history");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to list lock history");
		 }
	}
	
	/** 
	* Method Name: homeLockHistoryiOSTest(), 
	* This function is used to verify if the lock history is maintained in the page
	**/
	@SuppressWarnings("unchecked")
	@Test( dataProvider="hmLockHistiOS")
	public void homeLockHistoryiOSTest(String lkEventName, String lkTime) {
		 try {
			 LockEventHistoryPage le = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
			
			 if(lkTime!="") {
				 timecnt++;
			 }
			lkcnt =lkcnt+1;
			le.getLockHistoryiOSList(lkEventName, lkTime, lkcnt-1, sbcnt-1,timecnt-1);
			
			 Log.addMessage("Lock History is listed");
		 }catch(Exception e) {
			 Log.addMessage("Failed to list lock history");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to list lock history");
		 }
	}
	
	/** 
	* Method Name: homeBackTest(), 
	* This function is used to navigate back to access code page
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void homeBackTest() {
		 try {
			 LockEventHistoryPage le = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			// MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 le.clickBackButton();
			 //commented below code to remain in already selected lock dashboard
			/* ld.clickHamburgerButton();
			 mf.clickLockImageInMenu("hl");*/
			 ld.clickAccessCodeButton();
			 Log.addMessage("Redirected to view access code page");
		 }catch(Exception e) {
			 Log.addMessage("Failed to redirect to view access code page");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to redirect to view access code page");
		 }
	}
	
	/** 
	* Method Name: homeAccessCodeTest(), 
	* This function is used to navigate back to access code page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="hmACode")
	public void homeAccessCodeTest(String accessCode,String shType, String accessHlCd, String shHlType) {
		 try {
			 ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);	
			 cdcnt =cdcnt+1;
			 if(device.contentEquals("iOS")) {
				 va.getAccessCodeiOSList(accessHlCd, shHlType, cdcnt-1); 
			 }else {
				 va.getAccessCodeList(accessCode, shType, cdcnt-1);
			 } 
			 Log.addMessage("Access codes are listed");
		 }catch(Exception e) {
			 Log.addMessage("Failed to list access codes");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to list access codes");
		 }
	}
	
	/** 
	* Method Name: homeFPAccessCodeTest(), 
	* This function is used to navigate back to access code page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="hmAFPCode")
	public void homeFPAccessCodeTest(String accessCode,String shType, String accessHlCd, String shHlType) {
		 try {
			 ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);	
			 cdcnt =cdcnt+1;
			 if(device.contentEquals("iOS")) {
				 va.getAccessCodeiOSList(accessHlCd, shHlType, cdcnt-1); 
			 }else {
				 va.getAccessCodeList(accessCode, shType, cdcnt-1);
			 } 
			 Log.addMessage("Access codes are listed");
		 }catch(Exception e) {
			 Log.addMessage("Failed to list access codes");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to list access codes");
		 }
	}
	
	/** 
	* Method Name: homeAccessCodeiOSTest(), 
	* This function is used to navigate back to access code page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="hmACodeiOS")
	public void homeAccessCodeiOSTest(String accessCode,String shType) {
		 try {
			 ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);	
			 cdcnt =cdcnt+1;
			 if(device.contentEquals("iOS")) {
				 va.getAccessCodeiOSList(accessCode, shType, cdcnt-1); 
			 }else {
				 va.getAccessCodeList(accessCode, shType, cdcnt-1);
			 } 
			 Log.addMessage("Access codes are listed");
		 }catch(Exception e) {
			 Log.addMessage("Failed to list access codes");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to list access codes");
		 }
	}
	
	/** 
	* Method Name: homegoBackTest(), 
	* This function is used to navigate back to lock settings page
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void homegoBackTest() {
		 try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			// MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 va.clickBackButton();
			 //commented below code to remain in already selected lock dashboard on 24-11-2020
			/* ld.clickHamburgerButton();
			 mf.clickLockImageInMenu("hl");*/
			 ld.clickLockSettingsButton();
			 Log.addMessage("Navigated to lock settings page");
		 }catch(Exception e) {
			 Log.addMessage("Failed to navigate to lock settings page");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to navigate to lock settings page");
		 }
	}
	
	/** 
	* Method Name: homeLockSettingsTest(), 
	* This function is used to verify the lock settings page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="hmLockSet")
	public void homeLockSettingsTest(String lkName,String lkSound, String lkLED, String lkAuto) {
		 try {
			 LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
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
	@Test(dataProvider="hmLockSetFp")
	public void homeLockSettingsFPTest(String lkName,String lkSound, String lkLED, String lkAuto) {
		 try {
			 LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
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
	@Test(dataProvider="hmLockSetAr")
	public void homeLockSettingsARTest(String lkName,String lkSound, String lkLED, String lkAuto) {
		 try {
			 LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			 ls.getLockSettingsList(lkName, lkSound, lkLED, lkAuto);
			 Log.addMessage("Lock History is listed");
		 }catch(Exception e) {
			 Log.addMessage("Lock History is listed");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Lock History is not listed");
		 }
	}
	
	/** 
	* Method Name: homeLockInfoHLTest(), 
	* This function is used to verify the lock info of Halo lock
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="lockInfohl")
	public void homeLockInfoHLTest(String mdl, String prod, String sku, String srl, String fwBundle, String mbfwver, String blefw, String wfcfw, String wfrfw, String hwRev, String manDt, String actvDate) throws InterruptedException {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			LockInfoPage li = new LockInfoPage((AppiumDriver<MobileElement>) driver);
			li.getLockInfoBatteryPercentage();
			ls.getBatteryPercentage();
			ls.clickLockInfoButton();
			//Thread.sleep(3000);
			li.getModel(mdl);
			li.getProductFamily(prod);
			li.getSKU(sku);
			li.getSerialNumber(srl);
			if(device.equals("iOS")) {
				li.getFWBundleVersion(fwBundle);
				li.getMBFirmware(mbfwver);
				li.getBLEFirmware(blefw);
				li.getWFCFirmware(wfcfw);
				li.getWFRFirmware(wfrfw);
				li.getHardwareRevision(hwRev);
				li.getManufactureDate(manDt);
				li.getActivationDate(actvDate);
			}
			li.clickBackButton();
			Log.addMessage("Lock info displayed");
		}catch(Exception e)
		{
			Log.addMessage("Failed to display lock info");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display lock info");
		}
	}
	
	/** 
	* Method Name: homeLockInfoFPTest(), 
	* This function is used to verify the lock info page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="lockInfoFp")
	public void homeLockInfoFPTest(String mdl, String prod, String sku, String srl, String fwBundle, String mbfwver, String blefw, String wfcfw, String wfrfw, String hwRev, String manDt, String actvDate, String extfwRev) throws InterruptedException {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			LockInfoPage li = new LockInfoPage((AppiumDriver<MobileElement>) driver);
			li.getLockInfoBatteryPercentage();
			ls.getBatteryPercentage();
			ls.clickLockInfoButton();
			//Thread.sleep(3000);
			li.getModel(mdl);
			li.getProductFamily(prod);
			li.getSKU(sku);
			li.getSerialNumber(srl);
			li.getFWBundleVersion(fwBundle);
			li.getMBFirmware(mbfwver);
			li.getBLEFirmware(blefw);
			li.getWFCFirmware(wfcfw);
			li.getWFRFirmware(wfrfw);
			li.getHardwareRevision(hwRev);
			li.getManufactureDate(manDt);
			li.getActivationDate(actvDate);
			li.getExtFirmwareRevision(extfwRev);
			System.out.println("in lock info");
			li.clickBackButton();
			Log.addMessage("Lock info displayed");
		}catch(Exception e)
		{
			Log.addMessage("Failed to display lock info");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display lock info");
		}
	}
	
	/** 
	* Method Name: homeLockInfoARTest(), 
	* This function is used to verify the lock info page
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="lockInfoar")
	public void homeLockInfoARTest(String mdl, String prod, String sku, String srl, String fwBundle, String mbfwver, String blefw, String wfcfw, String wfrfw, String hwRev, String manDt, String actvDate) throws InterruptedException {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			LockInfoPage li = new LockInfoPage((AppiumDriver<MobileElement>) driver);
			li.getLockInfoBatteryPercentage();
			ls.getBatteryPercentage();
			ls.clickLockInfoButton();
			//Thread.sleep(3000);
			li.getModel(mdl);
			li.getProductFamily(prod);
			li.getSKU(sku);
			li.getSerialNumber(srl);
			li.getFWBundleVersion(fwBundle);
			li.getMBFirmware(mbfwver);
			li.getBLEFirmware(blefw);
			if(device.equals("android")) {
				li.getWFCFirmware(wfcfw);
				li.getWFRFirmware(wfrfw);
			}
			li.getHardwareRevision(hwRev);
			li.getManufactureDate(manDt);
			li.getActivationDate(actvDate);
			li.clickBackButton();
			Log.addMessage("Lock info displayed");
		}catch(Exception e)
		{
			Log.addMessage("Failed to display lock info");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display lock info");
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
	* Method Name: lockSettingNameTest(), 
	* This function is used to update lock name
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="hllockSetting")
	public void lockSettingNameTest(String lockName, String phameExp, String phameios) {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			LockNamePage ln = new LockNamePage((AppiumDriver<MobileElement>) driver);
			//added below condition on 02-12-2020
			
			if(!ls.getLockName().equals(lockName)) {
				ls.clickEditLockNameButton();
				ln.setLockName(lockName);
			}else {
				ls.clickEditLockNameButton();
				ln.setLockName(lockName+"i");
			}
			//ln.setLockName(lockName);
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
			
			if(!ls.getLockName().equals(lockName)) {
				ls.clickEditLockNameButton();
				ln.setLockName(lockName);
			}else {
				ls.clickEditLockNameButton();
				ln.setLockName(lockName+"i");
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
			
			if(!ls.getLockName().equals(lockName)) {
				ls.clickEditLockNameButton();
				ln.setLockName(lockName);
			}else {
				ls.clickEditLockNameButton();
				ln.setLockName(lockName+"i");
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
	* This function is used to update auto lock
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
				al.clickOkButton();
			}
			/*if(device.equals("android")) {
				al.clickBackButton();
			}else if(device.equals("iOS")) {
				al.clickAutoLockBackButton();
			}*/
			Assert.assertTrue(false, "Clicked sync failed popup in lock sounds");
		}catch(Exception e) {
			Log.addMessage("Failed to click sync failed popup in lock sounds");
			Assert.assertTrue(true, "Failed to click sync failed popup in lock sounds");
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
			Assert.assertTrue(false, "Sync failed popup displayed");
		}catch(Exception e) {
			Log.addMessage("Sync failed popup not found");
			Assert.assertTrue(true, "Sync failed popup not found");
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
	* Method Name: lockFunctionalityTest(), 
	* This function is used check lock functionality Page
	*/
	@SuppressWarnings("unchecked")
	@Test
	public void lockFunctionalityTest() throws InterruptedException {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			
			String status = ld.getLockStatus();
			if(status.equals("Locked")) {
				ld.unlockOperation();
				//Utility.simpleWait(5000);
				ld.lockOperation();
				//Utility.simpleWait(5000);
			}
			else if(status.equals("Unlocked")) {
				ld.lockOperation();
				//Utility.simpleWait(5000);
				ld.unlockOperation();
				//Utility.simpleWait(5000);
			}
			else {
				Log.addMessage("Lock status is: "+status);
			}
			currStatus = ld.getLockStatus();
		}catch(Exception e) {
			Log.addMessage("Failed to lock/unlock");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to lock/unlock");
		}
	}
	
	/** 
	* Method Name: navToHistoryTest(), 
	* This function is used to navigate to lock history Page
	*/
	@SuppressWarnings("unchecked")
	@Test
	public void navToHistoryTest() {
		 try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 ld.clickLockHistoryButton();
			 Log.addMessage("Paired Phones are listed");
		 }catch(Exception e) {
			 Log.addMessage("Paired Phones are not listed");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Paired Phones are not listed");
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
	* Method Name: navToAccessCodeTest(), 
	* This function is used to navigate to view access code page
	*/
	@SuppressWarnings("unchecked")
	@Test
	public void navToAccessCodeTest() {
		 try {
			 LockEventHistoryPage le = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			// if(device.equals("android")) {//commented on 13 Jan 2021
				 le.clickBackButton();
			// }
			 ld.clickAccessCodeButton();
			 Log.addMessage("Navigated to people page");
		 }catch(Exception e) {
			 Log.addMessage("Failed navigating to people page");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed navigating to people page");
		 }
	}
	
	/** 
	* Method Name: addAccessCodeTest(), 
	* This function is used to add access code
	*/
	@SuppressWarnings("unchecked")
	@Test(dataProvider = "acCdName")
	public void addAccessCodeTest(String acName) {
		try {
			 ViewAccessCodesPage ap = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			 AddAccessCodePage ac = new AddAccessCodePage((AppiumDriver<MobileElement>) driver);
			 SelectScheduleTypePage ss = new SelectScheduleTypePage((AppiumDriver<MobileElement>) driver);
			 ap.clickAddAccessCodeButton();
			 ac.enterAccessCodeName(acName+ap.accessCodeCnt());
			 ac.clickGenerateRandomCodeButton();
			 ac.clickSchTypeButton();
			 ss.selectAnyTime();//to verify if  schedule type updated as Any Time 
			 if(device.equals("android")) {
				 ap.clickOkButton();
			 }
			 ac.clickSubmitButton();
			 ap.waitForSyncComplete();
			 Assert.assertTrue(true, "Set schedule type to Any Time");
			 Log.addMessage("Set schedule type to Any Time");
		}catch(Exception e) {
			Log.addMessage("Failed to add access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to add access code");
		}
	}
	
	/** 
	* Method Name: addAccessCodeTest(), 
	* This function is used to add access code
	*/
	@SuppressWarnings("unchecked")
	@Test(dataProvider = "acCdName")
	public void addAccessCodeFPTest(String acName) {
		try {
			 ViewAccessCodesPage ap = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			 AddAccessCodePage ac = new AddAccessCodePage((AppiumDriver<MobileElement>) driver);
			 SelectScheduleTypePage ss = new SelectScheduleTypePage((AppiumDriver<MobileElement>) driver);
			 ap.clickAddAccessCodeButton();
			 ac.enterAccessCodeName(acName+ap.accessCodeCnt());
			// ac.clickGenerateRandomCodeButton();
			 ac.clickSchTypeButton();
			 ss.selectAnyTime();//to verify if  schedule type updated as Any Time 
			 if(device.equals("android")) {
				 ap.clickOkButton();
			 }
			 ac.clickSubmitButton();
			 ap.waitForSyncComplete();
			 Assert.assertTrue(true, "Set schedule type to Any Time");
			 Log.addMessage("Set schedule type to Any Time");
		}catch(Exception e) {
			Log.addMessage("Failed to add access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to add access code");
		}
	}
	
	
	/** 
	* Method Name: verifyAccessCodeFailedPopupTest(), 
	* This function is used to handle sync failed popup in  view access code page
	**/
	@SuppressWarnings("unchecked")
	@Test
	public void verifyAccessCodeFailedPopupTest() throws InterruptedException {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			if(ls.checkOkButton()) {
				ls.clickSyncFailPopUp();
			}
			if(device.equals("android")) {
				ls.clickBackButton();
			}
			Assert.assertTrue(true, "Clicked sync failed popup");
		}catch(Exception e) {
			Log.addMessage("Failed to click sync failed popup");
			Assert.assertTrue(false, "Failed to click sync failed popup");
		}
	}
	
	/** 
	* Method Name: deleteAccessCodeTest(), 
	* This function is used to delete the newly added access code to keep the data back to preset condition
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider = "accessName")
	public void deleteAccessCodeTest(String cdName) {
		 try {
			 ViewAccessCodesPage ap = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			 AccessCodePage ac = new AccessCodePage((AppiumDriver<MobileElement>) driver);
			 if(device.equals("iOS")) {
				 ap.selGivenAccessCodeName(cdName);
			 }else {
				 ap.selGivenAccessCodeNameAn(cdName); 
			 }
			 ac.deleteAccessCode();
			 ap.waitForSyncComplete();
			 Log.addMessage("Access code deleted");
		 }catch(Exception e) {
			 Log.addMessage("Failed to delete access code");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to delete access code");
		 }
	}
	
	/** 
	* Method Name: verifyAccessCodeDeleteFailPopupTest(), 
	* This function is used to handle the sync failed pop up in access code delete
	*/
	@SuppressWarnings("unchecked")
	@Test
	public void verifyAccessCodeDeleteFailPopupTest() throws InterruptedException {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			if(ls.checkOkButton()) {
				ls.clickSyncFailPopUp();
			}
			Assert.assertTrue(false, "CSync failed popup displayed");
		}catch(Exception e) {
			Log.addMessage("Sync failed popupnot found");
			Assert.assertTrue(true, "Sync failed popupnot found");
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
			System.out.println("lockName="+ls.getLockName());
			if(!ls.getLockName().equals(lockName)) {
				ls.clickEditLockNameButton();
				ln.setLockName(lockName);
				ln.clickSubmitButton();
				if(device.equals("android")) {
					ln.clickOkButton();
				}
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
			System.out.println("lockName="+ls.getLockName());
			if(!ls.getLockName().equals(lockName)) {
				ls.clickEditLockNameButton();
				ln.setLockName(lockName);
				ln.clickSubmitButton();
				if(device.equals("android")) {
					ln.clickOkButton();
				}
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
			System.out.println("lockName="+ls.getLockName());
			if(!ls.getLockName().equals(lockName)) {
				ls.clickEditLockNameButton();
				ln.setLockName(lockName);
				ln.clickSubmitButton();
				if(device.equals("android")) {
					ln.clickOkButton();
				}
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
			
			Assert.assertTrue(false, "Sync failed popup displayed in lock sounds");
		}catch(Exception e) {
			Log.addMessage("Sync failed popup not displayed in lock sounds");
			Assert.assertTrue(true, "Sync failed popup not displayed in lock sounds");
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
			/*LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			AutoLockDelaySettingPage al = new AutoLockDelaySettingPage((AppiumDriver<MobileElement>) driver);
			ls.clickAutoLockButton();
			if(al.getAutoDelayStatus().equals("Off") || al.getAutoDelayStatus().equals("0")) {
				al.clickAutoLock();
			}
			al.set_30Sec_Delay();
			Log.addMessage("Auto lock delay status set");
			
			Log.addMessage("lock settings displayed");
			Assert.assertTrue(true,"Auto lock settings displayed")*/;
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			AutoLockDelaySettingPage al = new AutoLockDelaySettingPage((AppiumDriver<MobileElement>) driver);
			System.out.println("Auto lock status updated to "+ls.getAutoLockStts());
			/*if(!ls.getAutoLockStts().equals("Off")) {
				ls.clickAutoLockButton();*/
				if(!al.getAutoDelayStatus().equals("Off") || !al.getAutoDelayStatus().equals("0")) {
					al.set_5min_Delay();//al.set_30Sec_Delay();//commented on 28Apr21
					al.clickAutoLockOff();
					Log.addMessage("Auto lock delay status set");
				}
				if(device.contentEquals("iOS")) {
					ls.clickAutoLockButton();
					al.clickAutoLockOff();
				}
				//commented on 11 jan 2021
				/*if(device.equals("android")) {
					al.clickBackButton();
				}*/
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
			Assert.assertTrue(false, "Clicked sync failed popup in Auto Lock");
		}catch(Exception e) {
			Log.addMessage("Sync failed popup not found in Auto Lock");
			Assert.assertTrue(true, "Sync failed popup not found in Auto Lock");
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
	* Method Name: autoLockSettingsTest(), 
	* This function is used to set the lock settings back to previous stage
	**/
	@SuppressWarnings("unchecked")
	@Test(dataProvider="lockSettingUpdt")
	public void autoLockLedSoundTest(String lockName, String autLockSts) {
		try {
			/*LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			AutoLockDelaySettingPage al = new AutoLockDelaySettingPage((AppiumDriver<MobileElement>) driver);
			System.out.println("Auto lock status updated to "+ls.getAutoLockStts());
			if(!ls.getAutoLockStts().equals("Off")) {
				ls.clickAutoLockButton();
				if(!al.getAutoDelayStatus().equals("Off") || !al.getAutoDelayStatus().equals("0")) {
					al.clickAutoLockOff();
				}
				if(device.equals("android")) {
					al.clickBackButton();
				}
			}
			LockSettingsPage lp = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			autoLkStts = lp.getAutoLockStts();
			Log.addMessage("Auto lock status updated to "+autoLkStts);*/
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
			Assert.assertTrue(false, "Clicked sync failed popup");
		}catch(Exception e) {
			Log.addMessage("Sync failed popup not found");
			Assert.assertTrue(true, "Sync failed popup not found");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void logoutTest() {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			ls.clickBackButton();
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
		
	@DataProvider(name = "userData")
	public Object[][] getDataNameUser() throws Exception {
		return excel.getTableArray(InputData, "App", "userData");
	}
	
	@DataProvider(name = "acName")
	public Object[][] getDataName() throws Exception {
		return excel.getTableArray(InputData, "Validation", "acName");
	}
	
	@DataProvider(name = "pNum")
	public Object[][] getDataNumber() throws Exception {
		return excel.getTableArray(InputData, "Validation", "acPhNum");
	}
	
	@DataProvider(name = "hmName")
	public Object[][] getDataHomeName() throws Exception {
		return excel.getTableArray(InputData, "Validation", "acHomeName");
	}
	
	@DataProvider(name = "lkNameHl")
	public Object[][] getDataLockName() throws Exception {
		return excel.getTableArray(InputData, "App", "LockNameHL");
	}
	
	@DataProvider(name = "lkNameFP")
	public Object[][] getDataLockNameFP() throws Exception {
		return excel.getTableArray(InputData, "App", "LockNameFP");
	}
	
	@DataProvider(name = "lkNameAR")
	public Object[][] getDataLockNameAR() throws Exception {
		return excel.getTableArray(InputData, "App", "LockNameAR");
	}
	
	@DataProvider(name = "hmNameiOS")
	public Object[][] getDataHomeNameiOS() throws Exception {
		return excel.getTableArray(InputData, "Validation", "aciosFPHomeName");
	}
	
	@DataProvider(name = "hmUser")
	public Object[][] getDataHomeUser() throws Exception {
		return excel.getTableArray(InputData, "Validation", "acHomeUser");
	}
	
	@DataProvider(name = "hmAFPCode")
	public Object[][] getDataHomeFPUser() throws Exception {
		return excel.getTableArray(InputData, "Validation", "acFPAccessCode");
	}
	
	@DataProvider(name = "hmACode")
	public Object[][] getDataAccessCode() throws Exception {
		return excel.getTableArray(InputData, "Validation", "acAccessCode");
	}
	
	@DataProvider(name = "hmACodeiOS")
	public Object[][] getDataAccessCodeiOS() throws Exception {
		return excel.getTableArray(InputData, "Validation", "aciosFPAccessCode");
	}
	
	@DataProvider(name = "hmLockHistryHalo")
	public Object[][] getDataLockHistoryHalo() throws Exception {
		return excel.getTableArray(InputData, "Validation", "acLockHistory");
	} 
	
	@DataProvider(name = "hmfplockHistry")
	public Object[][] getDataFpLockHistory() throws Exception {
		return excel.getTableArray(InputData, "Validation", "fpLockEventHistory");
	}
	
	@DataProvider(name = "hmARlockHistry")
	public Object[][] getDataARLockHistory() throws Exception {
		return excel.getTableArray(InputData, "Validation", "arLockEventHistory");
	}
	
	@DataProvider(name = "hmLockHistry")
	public Object[][] getDataLockHistory() throws Exception {
		return excel.getTableArray(InputData, "Validation", "acFPLockHistory");
	}
	
	@DataProvider(name = "hmLockHistiOS")
	public Object[][] getDataLockHistoryiOS() throws Exception {
		return excel.getTableArray(InputData, "Validation", "aciosFPLockHistory");
	}
	
	@DataProvider(name = "hmLockSet")
	public Object[][] getDataLockSetting() throws Exception {
		return excel.getTableArray(InputData, "Validation", "acLockSetting");
	}
	
	@DataProvider(name = "hmLockSetFp")
	public Object[][] getDataLockSettingFP() throws Exception {
		return excel.getTableArray(InputData, "Validation", "acFpLockSetting");
	}
	
	@DataProvider(name = "hmLockSetAr")
	public Object[][] getDataLockSettingAR() throws Exception {
		return excel.getTableArray(InputData, "Validation", "acArLockSetting");
	}
	
	@DataProvider(name = "hmLkPrdSmPhone")
	public Object[][] getDataLPairedSmPhone() throws Exception {
		return excel.getTableArray(InputData, "Validation", "acPairedSmPhone");
	}
	
	@DataProvider(name = "hmLkPrdPhone")
	public Object[][] getDataLPairedPhone() throws Exception {
		return excel.getTableArray(InputData, "Validation", "acPairedPhone");
	}
	
	@DataProvider(name = "hllockSetting")
	public Object[][] getDataLockSettingEdit() throws Exception {
		return excel.getTableArray(InputData, "App", "hlLockSetting");
	}
	
	@DataProvider(name = "fplockSetting")
	public Object[][] getDataLockSettingFpEdit() throws Exception {
		return excel.getTableArray(InputData, "App", "fpLockSetting");
	}
	
	@DataProvider(name = "arlockSetting")
	public Object[][] getDataLockSettingArEdit() throws Exception {
		return excel.getTableArray(InputData, "App", "arLockSetting");
	}
	
	@DataProvider(name = "lockSettingUpdt")
	public Object[][] getDataLockSettinUpdt() throws Exception {
		return excel.getTableArray(InputData, "App", "updateLockSetting");
	}
	
	@DataProvider(name = "lockSettingFpUpdt")
	public Object[][] getDataLockSettinFpUpdt() throws Exception {
		return excel.getTableArray(InputData, "App", "updateFpLockSetting");
	}
	
	@DataProvider(name = "lockSettingArUpdt")
	public Object[][] getDataLockSettinArUpdt() throws Exception {
		return excel.getTableArray(InputData, "App", "updateArLockSetting");
	}
	
	@DataProvider(name = "lockActivity")
	public Object[][] getDataLockActivity() throws Exception {
		return excel.getTableArray(InputData, "Validation", "acLockActivity");
	}
	
	@DataProvider(name = "acCdName")
	public Object[][] getDataAcCodeName() throws Exception {
		return excel.getTableArray(InputData, "App", "acCodeName");
	}
	
	@DataProvider(name = "lockInfohl")
	public Object[][] getDataAcLockInfo() throws Exception {
		return excel.getTableArray(InputData, "App", "acLockInfo");
	}
	
	@DataProvider(name = "lockInfoFp")
	public Object[][] getDataAcLockInfoFP() throws Exception {
		return excel.getTableArray(InputData, "App", "acLockInfoFP");
	}
	
	@DataProvider(name = "lockInfoar")
	public Object[][] getDataAcLockInfoAR() throws Exception {
		return excel.getTableArray(InputData, "App", "acLockInfoAR");
	}
	
	@DataProvider(name = "stsupdt")
	public Object[][] getDataAcStatusUpdt() throws Exception {
		return excel.getTableArray(InputData, "App", "acStstusUpdt");
	}
	
	@DataProvider(name = "accessName")
	public Object[][] getDataAccessName() throws Exception {
		return excel.getTableArray(InputData, "App", "accessCodeName");
	}
	
}
