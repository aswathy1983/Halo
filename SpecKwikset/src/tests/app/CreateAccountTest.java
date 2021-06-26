package tests.app;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.app.AccountNamePage;
import pages.app.CodeVerificationPage;
import pages.app.EULAPage;
import pages.app.EnterEmailPage;
import pages.app.EnterMobileNumberPage;
import pages.app.EnterPasswordPage;
import pages.app.HelloPage;
import pages.app.LockInstallationGuidePage;
import pages.app.LoginPage;
import pages.app.SecurityQuestionsPage;
import pages.app.SplashScreenPage;
import utility.ExcelRead;
import utility.Log;

public class CreateAccountTest extends Settings{
	
	@SuppressWarnings("unchecked")
	
	@Test( priority = 0)
	public void initialSetup() {
	 try {
		SplashScreenPage sp = new SplashScreenPage((AppiumDriver<MobileElement>) driver);
		HelloPage hp = new HelloPage((AppiumDriver<MobileElement>) driver);
		EULAPage ep = new EULAPage((AppiumDriver<MobileElement>) driver);
		LockInstallationGuidePage lg = new LockInstallationGuidePage((AppiumDriver<MobileElement>) driver);
		sp.clickOnAllowButton();
		if(device.equals("iOS")) {
			hp.clickOkButtonToUseBluetooth();
			hp.AcceptPopupIfPresent();
			hp.AcceptPopupIfPresent();
		}
		hp.ClickOnReadAgreementButton();
		ep.clickIAgreeButton();
		lg.clickSkipButton();
		Log.addMessage("Initial Set up completed");
	 }catch(Exception e) {
		 Log.addMessage("Initial Set up failed");
		 Assert.assertTrue(false, "Initial Set up failed");
	 }
		
	}

	
	@SuppressWarnings("unchecked")
	@Test(priority =1)
	public void clickCreateAccountButtonTest() {
		try {
			LoginPage lp = new LoginPage((AppiumDriver<MobileElement>) driver);
			lp.clickCreateAnAccountButton();
			Log.addMessage("Create An Account link tapped");
		}catch(Exception e) {
			Log.addMessage("Failed to click Create An Account Button");
			Assert.assertTrue(false, "Failed to click Create An Account Button");
		}
	}
	
	@SuppressWarnings("unchecked")
	
	@Test(dataProvider="accountname", priority =2)
	public void enterAccountNameTest(String firstname, String lastname) {
		try {
			AccountNamePage an = new AccountNamePage((AppiumDriver<MobileElement>) driver);
			an.enterFirstName(firstname);
			an.enterLastName(lastname);
			an.clickNextButton();
		}catch(Exception e){
			Log.addMessage("Failed to enter account credentials");
			Assert.assertTrue(false, "Failed to click Create An Account Button");
		}
		
	}
	
	@SuppressWarnings("unchecked")
	
	@Test(dataProvider="email", priority =3)
	public void emailVerificationTest(String email) {
		try {
			EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			ee.enterEmail(email);
			ee.clickSubmitButton();
			cv.enterVerificationCode_email_reg();
			cv.clickSubmitButton();
		}catch(Exception e){
			Log.addMessage("Failed to verify email address");
			Assert.assertTrue(false, "Failed to verify email address");
		}
		
	}
	
	@SuppressWarnings("unchecked")
	
	@Test(dataProvider="phone", priority =4)
	public void phoneVerificationTest(String phoneNumber) {
		try {
			EnterMobileNumberPage em = new EnterMobileNumberPage((AppiumDriver<MobileElement>) driver);
			CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			em.enterMobileNumber(phoneNumber);
			em.clickSubmitButton();
			cv.enterVerificationCode_phone();
			cv.clickSubmitButton();
		}catch(Exception e){
			Log.addMessage("Failed to verify phone number");
			Assert.assertTrue(false, "Failed to verify phone number");
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider = "secretQuestion",priority = 5)
	public void SetUpSecretQuestionsTest(String question1, String answer1, String question2, String answer2, String question3, String answer3) {
		try {
			SecurityQuestionsPage sp = new SecurityQuestionsPage((AppiumDriver<MobileElement>) driver);
			sp.enterQuestion1();
			sp.enterAnswer1(answer1);
			sp.enterQuestion2();
			sp.enterAnswer2(answer2);
			sp.enterQuestion3();
			sp.enterAnswer3(answer3);
			sp.clickNextButton();
			Log.addMessage("Secret Questions setup completed");
		}catch(Exception e) {
			Log.addMessage("Failed to set up Secret Questions");
			Assert.assertTrue(false, "Failed to set up Secret Questions ");
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="password", priority =6)
	public void enterPasswordTest(String password) {
		try {
			EnterPasswordPage ep = new EnterPasswordPage((AppiumDriver<MobileElement>) driver);
			ep.enterPassword(password);
			ep.reEnterPassword(password);
			ep.clickSubmitButton();
			ep.clickOKButton();
		}catch(Exception e){
			Log.addMessage("Failed to enter Password");
			Assert.assertTrue(false, "Failed to enter Password");
		}
		
	}
	
	ExcelRead excel = new ExcelRead();
	
	@DataProvider(name = "accountname")
	public Object[][] getData() throws Exception {
	return excel.getTableArray(InputData, "App", "AccountName");
	}
	
	@DataProvider(name = "email")
	public Object[][] getData1() throws Exception {
	return excel.getTableArray(InputData, "App", "Email");
	}

	@DataProvider(name = "phone")
	public Object[][] getData2() throws Exception {
	return excel.getTableArray(InputData, "App", "Phone");
	}
	
	
	@DataProvider(name = "secretQuestion")
	public Object[][] getData3() throws Exception {
	return excel.getTableArray(InputData, "App", "SecurityQuestions");
	}
	
	@DataProvider(name = "password")
	public Object[][] getData4() throws Exception {
	return excel.getTableArray(InputData, "App", "Password");
	}
}
