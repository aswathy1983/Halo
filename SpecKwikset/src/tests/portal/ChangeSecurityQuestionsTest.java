package tests.portal;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Settings;
import pages.portal.BetaJumpPage;
import pages.portal.BrandNeutralPage;
import pages.portal.SecretQuestionsPage;
import pages.portal.UserHomePage;
import utility.ExcelRead;
import utility.Log;
import utility.Utility;

public class ChangeSecurityQuestionsTest extends Settings{
	
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
	
	@Test(dataProvider="changeSecurityQuestion",priority=4)
	public void changeSecurityQuestionsTest(String que1, String ans1, String que2, String ans2, String que3, String ans3) {
		try {
			UserHomePage up=new UserHomePage(driver);
			SecretQuestionsPage sp= new SecretQuestionsPage(driver);
			up.clickHamburgerMenuButton();
			up.selectChangeSecurityQuestionsOption();
			sp.secretQuestion1(que1, ans1);
			sp.secretQuestion2(que2, ans2);
			sp.secretQuestion3(que3, ans3);
			sp.clickUpdateButton();
			Log.addMessage("Secret Questions updated successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to update secret questions");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update secret questions");
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
	
	@DataProvider(name = "changeSecurityQuestion")
	public Object[][] getData5() throws Exception {
	return excel.getTableArray(InputData, "Portal", "ChangeSecurityQuestion");
	}
}
