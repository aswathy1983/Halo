package tests.app;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.app.ChooseVerificationMethodPage;
import pages.app.EnterEmailPage;
import pages.app.ForgotPasswordPage;
import pages.app.LoginPage;
import pages.app.SecurityQuestionsPage;
import utility.ExcelRead;
import utility.Log;

public class ForgotPasswordTest extends Settings{
	
	@SuppressWarnings("unchecked")
	
	@Test(dataProvider="forgotPassword")
	public void ForgotPassword(String email,String question, String answer, String password) {
	  try {
		LoginPage lp = new LoginPage((AppiumDriver<MobileElement>) driver);
		EnterEmailPage ep = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
		SecurityQuestionsPage sq = new SecurityQuestionsPage((AppiumDriver<MobileElement>) driver);
		ChooseVerificationMethodPage cp = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
		ForgotPasswordPage fp = new ForgotPasswordPage((AppiumDriver<MobileElement>) driver);
		lp.clickForgotPasswordButton();
		ep.enterEmail(email);
		ep.clickSubmitButton();
		sq.enterQuestion1();
		sq.enterAnswer1(answer);
		cp.selectEmail();
		cp.clickSubmit();
		fp.enterVerificationCodeEmail();
		fp.enterPassword(password);
		fp.reEnterPassword(password);
		fp.clickSubmitButton();
		Log.addMessage("Forgot password test completed");
	  }catch(Exception e) {
		Log.addMessage("Forgot password failed."); 
		Assert.assertTrue(false,"Forgot Password test failed.");
	  }
	}
	

	ExcelRead excel = new ExcelRead();
	
	@DataProvider(name = "forgotPassword")
	public Object[][] getData() throws Exception {
	return excel.getTableArray(InputData, "App", "ForgotPassword");
	}
}
