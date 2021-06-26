package tests.portal;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.Settings;
import pages.portal.BetaJumpPage;
import pages.portal.BrandNeutralPage;
import pages.portal.ChooseVerificationMethodPage;
import pages.portal.EnterCodePage;
import pages.portal.LoginPage;
import pages.portal.UserHomePage;
import utility.ExcelRead;
import utility.Log;

public class LoginTest extends Settings {
	
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
	}else{
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

	@Test(dataProvider="validation",priority=3)
	public void validationMessageTest(String emailValidationMessage,String passwordValidationMessage) {
		try {
			LoginPage lp=new LoginPage(driver);
			lp.validationMessageCheck(emailValidationMessage, passwordValidationMessage);
			Log.addMessage("Validation check completed. No errors");
		}catch(Exception e) {
			Log.addMessage("Some errors found in validation check");
			e.printStackTrace();
			Assert.assertTrue(false, "Some errors found in validation check");
		}
	}
	
	@Test(dataProvider="userLogin", priority=4)
	public void userLoginTest(String email, String password) {
		try {
			LoginPage lp=new LoginPage(driver);
			ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
			EnterCodePage ec=new EnterCodePage(driver);
			lp.userLogin(email, password);
			cvm.clickEmailButton();
			cvm.clickSendCodeButton();
			ec.enterCode();
			Log.addMessage("User logged in successfully");
		}catch(Exception e) {
			Log.addMessage("Login failed");
			Assert.assertFalse(true, "Failed to login");
			e.printStackTrace();
		}
	}
	
	@Test(dataProvider="username", priority=5)
	public void userLoginValidationTest(String userName) {
		try {
			UserHomePage up=new UserHomePage(driver);
			up.validateUserName(userName);
			Log.addMessage("User login validated successfully");
		}catch(Exception e) {
			Log.addMessage("Login validation failed");
			Assert.assertFalse(true, "Failed to validate login");
			e.printStackTrace();
		}
	}	
	
	@Test(dataProvider="invalidLogin", priority=5)
	public void loginInvalidCredentialsTest(String email, String password, String validationMsg) {
		try {
			LoginPage lp=new LoginPage(driver);
			lp.invalidLoginCheck(email,password,validationMsg);
			Log.addMessage("Invalid User login validated successfully");
		}catch(Exception e) {
			Log.addMessage("Login validation failed");
			Assert.assertFalse(true, "Failed to validate login");
			e.printStackTrace();
		}
	}
	
	ExcelRead excel = new ExcelRead();

	@DataProvider(name = "brand")
	public Object[][] getData1() throws Exception {
	return excel.getTableArray(InputData, "Portal", "Brand");
	}
	
	@DataProvider(name = "validation")
	public Object[][] getData2() throws Exception {
	return excel.getTableArray(InputData,"Portal", "Validation");
	}
	
	@DataProvider(name = "userLogin")
	public Object[][] getData3() throws Exception {
	return excel.getTableArray(InputData, "Portal", "UserLogin");
	}
	
	@DataProvider(name = "username")
	public Object[][] getData4() throws Exception {
	return excel.getTableArray(InputData,"Portal", "Username");
	}
	
	@DataProvider(name = "invalidLogin")
	public Object[][] getData5() throws Exception {
	return excel.getTableArray(InputData,"Portal", "InvalidLogin");
	}

}
