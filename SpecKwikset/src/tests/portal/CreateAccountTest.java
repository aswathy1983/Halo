package tests.portal;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Settings;
import pages.portal.BetaJumpPage;
import pages.portal.BrandNeutralPage;
import pages.portal.ConfirmationPage;
import pages.portal.CreateAnAccountPage;
import pages.portal.EmailVerificationPage;
import pages.portal.LoginPage;
import pages.portal.MobilePhoneVerificationPage;
import pages.portal.SecretQuestionsPage;
import utility.ExcelRead;
import utility.Log;
import utility.Utility;

/*
 * TEST CASE: Check whether user is able to successfully register in Spectrum Cloud
 */

public class CreateAccountTest extends Settings{
	
	@Test(priority=1)
	public void betaUserLogin() {
		if(!((environment.equals("24x7"))||(environment.equals("QA2")))) {
		try {
			open(getPageURL());
			BetaJumpPage bp = new BetaJumpPage(driver);
			bp.verifyJumpPage();
		}catch(Exception e) {
			Log.addMessage("Failed to login as Beta user");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to login as Beta User");
		}
		}
		else {
			open(getPageURL());
		}
	}
	
	@Test(dataProvider="brand",priority=2)
	public void chooseBrandTest(String brand) {
		try {
			BrandNeutralPage bn = new BrandNeutralPage(driver);
			bn.chooseBrand(brand);
		}catch(Exception e) {
			Log.addMessage("Failed to choose brand");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to choose brand");
		}
	}
	
	@SuppressWarnings("static-access")
	@Test(dataProvider="title",priority=3)
	public void clickCreateAnAccountLinkTest(String expectedTitle) {
		try {
			LoginPage lp = new LoginPage(driver);
			lp.verifyPageTitle(expectedTitle);
			lp.clickCreateAccount();
			Log.addMessage("Started registration");
		}catch(Exception e) {
			Log.addMessage("New account creation encountered some errors");
			e.printStackTrace();
			Assert.assertTrue(false, "Some errors found in registration");
		}
	}
	
	@Test(dataProvider = "userDetails",priority = 4)
	public void enterUserDetailsTest(String firstname,String lastname) {
		try {
			CreateAnAccountPage cp = new CreateAnAccountPage(driver);
			cp.enterFirstName(firstname);
			cp.enterLastName(lastname);
			cp.clickCaptchaCheckBox();
			cp.clickTermsAndConditionsCheckBox();
			cp.clickEULAcheckBox();
			cp.clickNextButton();
			Log.addMessage("User details entered successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to enter user details");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to enter user details");
		}
	}
	
	@Test(dataProvider = "emailVerification",priority=5)
	public void emailVerificationTest(String email) {
		try {
			EmailVerificationPage ep = new EmailVerificationPage(driver);
			ep.enterEmailAndVerify(email);
			ep.enterVerificationCode();
			ep.clickVerifyButton();
			Log.addMessage("Email address of the user verified successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to verify user's email address");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify user's email address");
		}
	}
	
	@Test(dataProvider = "mobileVerification",priority=6)
	public void mobileVerificationTest(String phoneNumber) {
		try {
			MobilePhoneVerificationPage mp = new MobilePhoneVerificationPage(driver);
			mp.enterPhoneAndVerify(phoneNumber);
			mp.enterVerificationCode();
			mp.clickVerifyButton();
			Log.addMessage("Phone Number of the user verified successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to verify user's phone number");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify user's phone number");
		}
	}
	
	@Test(dataProvider = "secretQuestion",priority = 7)
	public void SetUpSecretQuestionsTest(String question1, String answer1, String question2, String answer2, String question3, String answer3) {
		try {
			SecretQuestionsPage sp = new SecretQuestionsPage(driver);
			sp.secretQuestion1(question1, answer1);
			sp.secretQuestion2(question2, answer2);
			sp.secretQuestion3(question3, answer3);
			sp.clickUpdateButton();
			Log.addMessage("Secret Questions setup completed");
		}catch(Exception e) {
			Log.addMessage("Failed to set up Secret Questions");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to set up Secret Questions ");
		}
	}
	
	@Test(dataProvider = "userDetails",priority = 8)
	public void userDetailsConfirmationTest(String firstName, String lastName) {
		try {
			ConfirmationPage cp = new ConfirmationPage(driver);
			cp.validateFirstName(firstName);
			cp.ValidateLastName(lastName);
			Log.addMessage("Firstname nad Lastname verified");
		}catch(Exception e) {
			Log.addMessage("Failed to confirm user details");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to confirm user details");
		}
	}
	
	@Test(dataProvider = "emailVerification",priority =9)
	public void emailConfirmationTest(String email) {
		try {
			ConfirmationPage cp = new ConfirmationPage(driver);
			cp.validateEmail(email);
			Log.addMessage("Email verified");
		}catch(Exception e) {
			Log.addMessage("Failed to confirm email");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to confirm email");
		}
	}
	
	@Test(dataProvider = "mobileVerification",priority = 10)
	public void phoneConfirmationTest(String phone) {
		try {
			ConfirmationPage cp = new ConfirmationPage(driver);
			cp.validateMobilePhone(phone);
			Log.addMessage("Mobile Phone verified");
		}catch(Exception e) {
			Log.addMessage("Failed to confirm mobile Phone");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to confirm mobile Phone");
		}
	} 

	@Test(dataProvider = "password",priority = 11)
	public void registrationConfirmationTest(String password) {
		try {
			ConfirmationPage cp = new ConfirmationPage(driver);
			cp.enterPassword(password);
			cp.clickConfirmButton();
			Utility.simpleWait(4000);
			Log.addMessage("A new user is registered successfully in Spectrum Cloud");
		}catch(Exception e) {
			Log.addMessage("Failed to register new user");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to register");
		}
	}
	
	
	ExcelRead excel = new ExcelRead();
	
	@DataProvider(name = "brand")
	public Object[][] getData() throws Exception {
	return excel.getTableArray(InputData, "Portal", "Brand");
	}

	@DataProvider(name = "title")
	public Object[][] getData1() throws Exception {
	return excel.getTableArray(InputData, "Portal", "Title");
	}
	
	@DataProvider(name = "userDetails")
	public Object[][] getData2() throws Exception {
	return excel.getTableArray(InputData, "Portal", "UserDetails");
	}
	
	@DataProvider(name = "emailVerification")
	public Object[][] getData3() throws Exception {
	return excel.getTableArray(InputData, "Portal", "EmailVerification");
	}
	
	@DataProvider(name = "mobileVerification")
	public Object[][] getData4() throws Exception {
	return excel.getTableArray(InputData, "Portal", "MobileVerification");
	}
	
	@DataProvider(name = "secretQuestion")
	public Object[][] getData5() throws Exception {
	return excel.getTableArray(InputData, "Portal", "SecretQuestion");
	}
	
	@DataProvider(name = "password")
	public Object[][] getData6() throws Exception {
	return excel.getTableArray(InputData, "Portal", "Password");
	}

}
