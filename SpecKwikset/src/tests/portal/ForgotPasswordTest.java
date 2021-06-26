package tests.portal;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Settings;
import pages.portal.AccountInformationPage;
import pages.portal.BetaJumpPage;
import pages.portal.BrandNeutralPage;
import pages.portal.ForgotPasswordChooseVerificationMethodPage;
import pages.portal.ForgotPasswordEnterPasswordPage;
import pages.portal.ForgotPasswordSecretQuestionsPage;
import pages.portal.LoginPage;
import utility.ExcelRead;
import utility.Log;
import utility.Utility;

public class ForgotPasswordTest extends Settings {
	
	@Test(priority=1)
	public void betaUserLogin() {
		if(!(environment.equals("24x7"))) {
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
			//open(getPageURL());
			BrandNeutralPage bn=new BrandNeutralPage(driver);
			bn.chooseBrand(brand);
		}catch(Exception e) {
			Log.addMessage("Failed to choose brand");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to choose brand");
		}
	}
	
	@Test(dataProvider="forgotPassword",priority=3)
	public void forgotPasswordTest(String email, String question, String answer, String password) {
		try {
			LoginPage lp=new LoginPage(driver);
			AccountInformationPage ai=new AccountInformationPage(driver);
			ForgotPasswordChooseVerificationMethodPage cv=new ForgotPasswordChooseVerificationMethodPage(driver);
			ForgotPasswordSecretQuestionsPage sq=new ForgotPasswordSecretQuestionsPage(driver);
			ForgotPasswordEnterPasswordPage ep=new ForgotPasswordEnterPasswordPage(driver);
			lp.clickForgotPassword();
			ai.enterEmail(email);
			ai.clickConfirmButton();
			sq.enterSecretQuestion(question, answer);
			sq.clickNextButton();
			cv.clickEmailButton();
			cv.clickSendButton();
			ep.enterVerificationCode();
		//	sq.enterSecretQuestion(question, answer);
		//	sq.clickNextButton();
			ep.enterPassword(password);
			ep.clickConfirmButton();
			Log.addMessage("Password reset successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to reset password");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to reset password");
		}
	}
	
	@Test(dataProvider="userlogin",priority=4)
	public void userLoginWithChangedPasswordTest(String email, String password) {
		try {
			Utility.userlogin(email, password);
			Log.addMessage("User logged in successfully with new password");
		}catch(Exception e) {
			Log.addMessage("Failed to login with new password");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to login with new password");
		}
	}

ExcelRead excel = new ExcelRead();

	@DataProvider(name = "brand")
	public Object[][] getData() throws Exception {
	return excel.getTableArray(InputData, "Portal", "Brand");
	}

	@DataProvider(name = "forgotPassword")
	public Object[][] getData1() throws Exception {
	return excel.getTableArray(InputData, "Portal", "ForgotPassword");
	}
	
	@DataProvider(name = "userlogin")
	public Object[][] getData2() throws Exception {
	return excel.getTableArray(InputData, "Portal", "UserLogin");
	}
	
}
