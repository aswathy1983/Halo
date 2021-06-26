package tests.app;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.app.ChooseVerificationMethodPage;
import pages.app.CodeVerificationPage;
import pages.app.EULAPage;
import pages.app.HelloPage;
import pages.app.LockInstallationGuidePage;
import pages.app.LoginPage;
import pages.app.SplashScreenPage;
import utility.ExcelRead;
import utility.Log;

public class LoginTest extends Settings {
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

	ExcelRead excel = new ExcelRead();
	
	@DataProvider(name = "login")
	public Object[][] getData() throws Exception {
	return excel.getTableArray(InputData, "App", "Login");
	}
	
}
