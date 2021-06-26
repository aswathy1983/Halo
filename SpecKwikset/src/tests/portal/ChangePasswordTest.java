package tests.portal;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.Settings;
import pages.portal.BetaJumpPage;
import pages.portal.BrandNeutralPage;
import pages.portal.ChangePasswordPage;
import pages.portal.ChooseVerificationMethodPage;
import pages.portal.EnterCodePage;
import pages.portal.LoginPage;
import pages.portal.UserHomePage;
import utility.ExcelRead;
import utility.Log;
import utility.Utility;

public class ChangePasswordTest extends Settings {
	
	@Test
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
			//open(getPageURL());
		}
	}
	
	@Test(dataProvider="brand")
	public void chooseBrandTest(String brand) {
		try {
			open(getPageURL());
			BrandNeutralPage bn=new BrandNeutralPage(driver);
			bn.chooseBrand(brand);
		}catch(Exception e) {
			Log.addMessage("Failed to choose brand");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to choose brand");
		}
	}
	
	@Test(dataProvider="userlogin")
	public void userLoginTest(String email, String password) {
		try {
			Utility.userlogin(email, password);
			Log.addMessage("User logged in successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to login");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to login");
		}
	}
	@Test(dataProvider="changePassword")
	public void changePasswordTest(String oldPassword, String newPassword) {
		try {
			UserHomePage up=new UserHomePage(driver);
			ChangePasswordPage cp=new ChangePasswordPage(driver);
			up.clickHamburgerMenuButton();
			up.selectChangePasswordOption();
			cp.enterExistingPassword(oldPassword);
			cp.enterNewPassword(newPassword);
			cp.enterConfirmNewPassword(newPassword);
			cp.clickUpdateButton();
			Log.addMessage("Password updated successfully");
			//betaUserLogin();
		}catch(Exception e) {
			Log.addMessage("Failed to update password");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update password");
		}
	}
	
	@Test(dataProvider="loginWithChangedPassword")
	public void userLoginWithChangedPasswordTest(String email, String password) {
		try {
			LoginPage lp=new LoginPage(driver);
			ChooseVerificationMethodPage cp = new ChooseVerificationMethodPage(driver);
			EnterCodePage ep= new EnterCodePage(driver);
			lp.userLogin(email, password);
			cp.clickEmailButton();
			cp.clickSendCodeButton();
			ep.enterCode();
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
	
	@DataProvider(name = "userlogin")
	public Object[][] getData1() throws Exception {
	return excel.getTableArray(InputData, "Portal", "UserLogin");
	}
	
	@DataProvider(name = "changePassword")
	public Object[][] getData2() throws Exception {
	return excel.getTableArray(InputData, "Portal", "ChangePassword");
	}
	
	@DataProvider(name = "loginWithChangedPassword")
	public Object[][] getData3() throws Exception {
	return excel.getTableArray(InputData, "Portal", "LoginWithChangedPassword");
	}
}
