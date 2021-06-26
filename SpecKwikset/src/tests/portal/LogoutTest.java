package tests.portal;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Settings;
import pages.portal.BetaJumpPage;
import pages.portal.BrandNeutralPage;
import pages.portal.UserHomePage;
import utility.ExcelRead;
import utility.Log;
import utility.Utility;

public class LogoutTest extends Settings {
	
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
	
	@Test(dataProvider="userlogin",priority=3)
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
	
	@Test(priority=4)
	public void UserLogoutTest() {
		try {
			UserHomePage up=new UserHomePage(driver);
			up.clickHamburgerMenuButton();
			up.clickLogout();
			betaUserLogin();
			Log.addMessage("User Logged out successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to logout");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to logout");
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
}
