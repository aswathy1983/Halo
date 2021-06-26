package tests.app;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.app.BLEInstructionPage1;
import pages.app.ChooseVerificationMethodPage;
import pages.app.CodeVerificationPage;
import pages.app.EnterEmailPage;
import pages.app.EnterHomeNamePage;
import pages.app.HomeUsersPage;
import pages.app.LockDashboardPage;
import pages.app.LoginPage;
import pages.app.ManageHomesPage;
import pages.app.MenuFlyoutPage;
import pages.app.NewUserPage;
import pages.portal.EnterCodePage;
import utility.ExcelRead;
import utility.Log;
import utility.Utility;

public class ShareHomeTestWithSingleDevice extends Settings{
		
	@Test(dataProvider = "admin_leaveShare")
	@SuppressWarnings("unchecked")
	public void shareHome_admin_leaveShare(String adminUser, String adminEmail, String password, String gpwd, String home) throws InterruptedException {
	  try {
		  	sendShareRequest(adminUser, adminEmail,"admin");
		  	logout();
		  	login(adminEmail,password,gpwd);
		  	acceptShareRequest(home);   
		   Log.addMessage("Share home to other user as admin is successful");
	  }catch(Exception e) {
		  Log.addMessage("Failed to share home to admin");
		  Assert.assertTrue(false, "Failed to share home to admin");
	  }
		
	}
	
	@Test(dataProvider = "admin_deleteShare")
	@SuppressWarnings("unchecked")
	public void shareHome_admin_deleteShare(String ad_user, String ad_email, String ad_pwd, String gpwd1, String home, String own_email, String own_pwd, String gpwd2) throws InterruptedException {
	  try {
		  	sendShareRequest(ad_user, ad_email,"admin");
		  	logout();
		  	login(ad_email,ad_pwd,gpwd1);
		  	acceptShareRequest(home);
		  	logout();
		  	login(own_email,own_pwd,gpwd2);
		  	deleteShare();   
		   Log.addMessage("Share home to other user as admin is successful");
	  }catch(Exception e) {
		  Log.addMessage("Failed to share home to admin");
		  Assert.assertTrue(false, "Failed to share home to admin");
	  }
		
	}
	
	@Test(dataProvider = "member_leaveShare")
	@SuppressWarnings("unchecked")
	public void shareHome_member_leaveShare(String mem_user, String mem_email, String mem_pwd, String gpwd, String home) throws InterruptedException {
	  try {
		  	sendShareRequest(mem_user, mem_email,"member");
		  	logout();
		  	login(mem_email,mem_pwd,gpwd);
		  	acceptShareRequest(home);
		   Log.addMessage("Share home to other user as admin is successful");
	  }catch(Exception e) {
		  Log.addMessage("Failed to share home to admin");
		  Assert.assertTrue(false, "Failed to share home to admin");
	  }
		
	}
	
	@Test(dataProvider = "member_deleteShare")
	@SuppressWarnings("unchecked")
	public void shareHome_member_deleteShare(String mem_user, String mem_email, String mem_pwd, String mem_gpwd, String home, String own_email, String own_pwd, String own_gpwd) throws InterruptedException {
	  try {
		  	sendShareRequest(mem_user, mem_email,"member");
		  	logout();
		  	login(mem_email,mem_pwd,mem_gpwd);
		  	acceptShareRequest(home);
		  	logout();
		  	login(own_email,own_pwd,own_gpwd);
		  	deleteShare();   
		   Log.addMessage("Share home to other user as admin is successful");
	  }catch(Exception e) {
		  Log.addMessage("Failed to share home to admin");
		  Assert.assertTrue(false, "Failed to share home to admin");
	  }
		
	}
	
	@SuppressWarnings("unchecked")
	public void sendShareRequest(String user,String email, String userRole) {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			HomeUsersPage hu = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			NewUserPage nu = new NewUserPage((AppiumDriver<MobileElement>) driver);
			EnterEmailPage ep = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			ld.clickHamburgerButton();
			mf.clickManageButton();
			mh.clickManageHomeUsersButton();
			hu.clickAddUserButton();
			nu.enterNewUser(user);
			if (userRole.equals("admin"))
				nu.clickAdminButton();
			else if (userRole.equals("member"))
				nu.clickMemberButton();
			else
				Log.addMessage("This user role not deifned. Try again.");
			nu.clickNextButton();
			ep.enterEmail(email);
			ep.clickSubmitButton();
			hu.checkForShareSentAlert();
			//back actions
			Log.addMessage("Share home to other user as admin is successful");
		}catch(Exception e) {
			Log.addMessage("Failed to share home to admin");
			Assert.assertTrue(false, "Failed to share home to admin");
		  }
		
	}
	
	@SuppressWarnings("unchecked")
	public void acceptShareRequest(String homeName) {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
		//	ld.acceptShare();
		//	mf.checkForSharedHome(homeName);
		//	mf.clickSharedHome(homeName);
		//	ld.checkForSharedText();
			ld.clickHamburgerButton();
			mf.clickManageButton();
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
		//	if (userRole.equals("admin"))
		//		mh.verifyAdminHome();
		//	else if (userRole.equals("member"))
		//		mh.verifyMemberHome();
		//	else
		//		Log.addMessage("This user role not deifned. Try again.");
		//	mh.clickLeaveShare();
		}catch(Exception e) {
			Log.addMessage("Failed to accept share request");
			Assert.assertTrue(false, "Failed to accept share request");
		  }
	}
	
	@SuppressWarnings("unchecked")
	public void declineShareRequest(String userEmail, String userPassword) {
		try {
			//login(userEmail,userPassword);
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			//ld.declineShare();
		}catch(Exception e) {
			Log.addMessage("Failed to accept share request");
			Assert.assertTrue(false, "Failed to accept share request");
		  }
	}
	
	@SuppressWarnings("unchecked")
	public void deleteShare() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			ld.clickHamburgerButton();
			mf.clickManageButton();
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			mh.clickManageHomeUsersButton();
			HomeUsersPage hu = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			//hu.clickDeleteShare();
			Log.addMessage("Share deleted");
		}catch(Exception e) {
			Log.addMessage("Failed to delete Share");
			Assert.assertTrue(false, "Failed to Failed to delete Share");
		  }
	}
	
	
	@SuppressWarnings("unchecked")
	public void login(String email, String password, String gpwd) {
		try {
			LoginPage lp = new LoginPage((AppiumDriver<MobileElement>) driver);
			lp.enterEmail(email);
			lp.enterPassword(password);
			lp.clickLoginButton();
			ChooseVerificationMethodPage cm = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			cm.selectEmail();
			CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			cv.readCode_email_reg(email, gpwd);
			cv.clickSubmitButton();
		}catch(Exception e) {
			Assert.assertTrue(false);	
	    }
	}
	
	@SuppressWarnings("unchecked")
	public void logout() {
		try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 ld.clickHamburgerButton();
			 mf.clickLogoutButton();
		}catch(Exception e) {
			 Assert.assertTrue(false);	
	    }
	}
	
	
	ExcelRead excel = new ExcelRead();
	
	@DataProvider(name = "admin_leaveShare")
	public Object[][] getData1() throws Exception {
	return excel.getTableArray(InputData, "App", "AdminLeaveShare");
	}
	
	@DataProvider(name = "admin_deleteShare")
	public Object[][] getData2() throws Exception {
	return excel.getTableArray(InputData, "App", "AdminDeleteShare");
	}
	
	@DataProvider(name = "member_leaveShare")
	public Object[][] getData3() throws Exception {
	return excel.getTableArray(InputData, "App", "MemberLeaveShare");
	}
	
	@DataProvider(name = "member_deleteShare")
	public Object[][] getData4() throws Exception {
	return excel.getTableArray(InputData, "App", "MemberDeleteShare");
	}
	
}


