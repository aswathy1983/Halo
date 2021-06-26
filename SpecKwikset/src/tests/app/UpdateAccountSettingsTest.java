package tests.app;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.app.AccountSettingsPage;
import pages.app.ChooseVerificationMethodPage;
import pages.app.CodeVerificationPage;
import pages.app.EULAPage;
import pages.app.HelloPage;
import pages.app.LockDashboardPage;
import pages.app.LockInstallationGuidePage;
import pages.app.LoginPage;
import pages.app.MenuFlyoutPage;
import pages.app.SecurityQuestionsPage;
import pages.app.SettingsPage;
import pages.app.UpdateAccountNamePage;
import pages.app.UpdatePasswordPage;
import pages.app.UpdatePhoneNumberPage;
import utility.ExcelRead;
import utility.Log;

public class UpdateAccountSettingsTest extends Settings {
	
	@SuppressWarnings("unchecked")
	
	@Test( priority = 0)
	public void initialSetup() {
	 try {
		HelloPage hp = new HelloPage((AppiumDriver<MobileElement>) driver);
		EULAPage ep = new EULAPage((AppiumDriver<MobileElement>) driver);
		LockInstallationGuidePage lg = new LockInstallationGuidePage((AppiumDriver<MobileElement>) driver);
		hp.AcceptPopupIfPresent();
		hp.AcceptPopupIfPresent();
		hp.ClickOnReadAgreementButton();
		ep.clickIAgreeButton();
		lg.clickSkipButton();
		Log.addMessage("Initial Set up completed");
	 }catch(Exception e) {
		 Log.addMessage("Initial Set up failed");
		 e.printStackTrace();
		 Assert.assertTrue(false, "Initial Set up failed");
	 }
		
	}
	
	
	@SuppressWarnings("unchecked")
  
	@Test(dataProvider="login",priority = 1)
	public void enterLoginCredentialsTest(String email, String password) {
	 try {
		 LoginPage lp = new LoginPage((AppiumDriver<MobileElement>) driver);
		 lp.enterEmail(email);
		 lp.enterPassword(password);
		 lp.clickLoginButton();
	 }catch(Exception e) {
		 Log.addMessage("Failed to enter login credentials");
		 e.printStackTrace();
		 Assert.assertTrue(false, "Failed to enter login credentials");
	 }
	}

	@SuppressWarnings("unchecked")
	
	@Test(priority = 2)
	public void verificationTest() {
	 try {
		ChooseVerificationMethodPage cm = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
		CodeVerificationPage cp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
		cm.selectEmail();
		cm.clickSubmit();
		cp.enterVerificationCode_email();
		cp.clickSubmitButton();
	 }catch(Exception e) {
		Log.addMessage("MFA failed");
		e.printStackTrace();
	    Assert.assertTrue(false, "MFA failed");
	 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="updateName",priority = 3)
	public void UpdateNameTest(String firstname, String lastname) {
	 try {
		LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
		MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
		SettingsPage sp = new SettingsPage((AppiumDriver<MobileElement>) driver);
		AccountSettingsPage as = new AccountSettingsPage((AppiumDriver<MobileElement>) driver);
		UpdateAccountNamePage an = new UpdateAccountNamePage((AppiumDriver<MobileElement>) driver);
		ld.clickHamburgerButton();
		mf.clickAccountSettingsButton();
		sp.clickAccountOption();
		as.clickNameOption();
		an.updateFirstName(firstname);
		an.updateLastName(lastname);
		an.clickNextButton();
		Log.addMessage("Account name updated");
	 }catch(Exception e) {
		Log.addMessage("Failed to update name");
		e.printStackTrace();
	    Assert.assertTrue(false, "Failed to update name");
	 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="updatePhoneNumber",priority = 4)
	public void UpdatePhoneNumberTest(String phoneNumber) {
	 try {
		LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
		MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
		SettingsPage sp = new SettingsPage((AppiumDriver<MobileElement>) driver);
		AccountSettingsPage as = new AccountSettingsPage((AppiumDriver<MobileElement>) driver);
		UpdatePhoneNumberPage an = new UpdatePhoneNumberPage((AppiumDriver<MobileElement>) driver);
		ld.clickHamburgerButton();
		mf.clickAccountSettingsButton();
		sp.clickAccountOption();
		as.clickPhoneNumberOption();
		an.updatePhoneNumber(phoneNumber);
		an.clickNextButton();
		Log.addMessage("Phone Number updated");
	 }catch(Exception e) {
		Log.addMessage("Failed to update Phone Number");
		e.printStackTrace();
	    Assert.assertTrue(false, "Failed to update Phone Number");
	 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="updatePassword",priority = 5)
	public void UpdatePasswordTest(String oldPassword, String newPassword) {
	 try {
		LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
		MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
		SettingsPage sp = new SettingsPage((AppiumDriver<MobileElement>) driver);
		AccountSettingsPage as = new AccountSettingsPage((AppiumDriver<MobileElement>) driver);
		UpdatePasswordPage up = new UpdatePasswordPage((AppiumDriver<MobileElement>) driver);
		ld.clickHamburgerButton();
		mf.clickAccountSettingsButton();
		sp.clickAccountOption();
		as.clickChangePasswordOption();
		up.enterOldPassword(oldPassword);
		up.enterNewPassword(newPassword);
		up.reEnterNewPassword(newPassword);
		up.clickSubmitButton();
		up.clickOkButton();
		Log.addMessage("Password updated");
	 }catch(Exception e) {
		Log.addMessage("Failed to update password");
		e.printStackTrace();
	    Assert.assertTrue(false, "Failed to update Password");
	 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="updateSecurityQuestions",priority = 5)
	public void UpdateSecurityQustionsTest(String answer1, String answer2, String answer3 ) {
	 try {
		LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
		MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
		SettingsPage sp = new SettingsPage((AppiumDriver<MobileElement>) driver);
		AccountSettingsPage as = new AccountSettingsPage((AppiumDriver<MobileElement>) driver);
		SecurityQuestionsPage sq = new SecurityQuestionsPage((AppiumDriver<MobileElement>) driver);
		ld.clickHamburgerButton();
		mf.clickAccountSettingsButton();
		sp.clickAccountOption();
		as.clickChangeSecurityQuestionsOption();
		sq.enterQuestion1();
		sq.enterAnswer1(answer1);
		sq.enterQuestion2();
		sq.enterAnswer2(answer2);
		sq.enterQuestion3();
		sq.enterAnswer3(answer3);
		Log.addMessage("Security Questions updated");
	 }catch(Exception e) {
		Log.addMessage("Failed to update security questions");
		e.printStackTrace();
	    Assert.assertTrue(false, "Failed to update security questions");
	 }
	}



	ExcelRead excel = new ExcelRead();
	
	@DataProvider(name = "login")
	public Object[][] getData() throws Exception {
	return excel.getTableArray(InputData, "App", "Login");
	}
	
	@DataProvider(name = "updateName")
	public Object[][] getData1() throws Exception {
	return excel.getTableArray(InputData, "App", "UpdateName");
	}
	
	@DataProvider(name = "updatePhoneNumber")
	public Object[][] getData2() throws Exception{
	return excel.getTableArray(InputData, "App", "UpdatePhoneNumber");
	}
	
	@DataProvider(name = "updatePassword")
	public Object[][] getData3() throws  Exception{
	return excel.getTableArray(InputData, "App", "UpdatePassword");
	}
	
	@DataProvider(name = "updateSecurityQuestions")
	public Object[][] getData4() throws Exception {
	return excel.getTableArray(InputData, "App", "UpdateSecurityQuestions");
	}
}
