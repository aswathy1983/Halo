package tests.portal;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Settings;
import pages.portal.BetaJumpPage;
import pages.portal.BrandNeutralPage;
import pages.portal.ChooseVerificationMethodPage;
import pages.portal.DeleteMyAccountPage;
import pages.portal.LoginPage;
import pages.portal.UserHomePage;
import utility.ExcelRead;
import utility.Log;
import utility.Utility;

public class DeleteMyAccountTest extends Settings{
	
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
		//	open(getPageURL());
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

	@Test(groups="delete",priority=4)
	public void deleteAccountTest() {
		try {
			UserHomePage up=new UserHomePage(driver);
			DeleteMyAccountPage dp= new DeleteMyAccountPage(driver);
			up.clickHamburgerMenuButton();
			up.selectDeleteMyAccountOption();
			dp.deleteAccount();
			Log.addMessage("User deleted successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to delete");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to delete");
		}
	}
	
	@Test(dependsOnGroups="delete",dataProvider="userlogin")
	public void confirmDeletionTest(String email, String password) {
		try {
			betaUserLogin();
			LoginPage lp= new LoginPage(driver);
			lp.userLogin(email, password);
			ChooseVerificationMethodPage cp=new ChooseVerificationMethodPage(driver);
			cp.verifyPresenceOfEmailButton();
			Log.addMessage("User deletion confirmed");
		}catch(Exception e) {
			Log.addMessage("Failed to confirm deletion");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to confirm deletion");
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
