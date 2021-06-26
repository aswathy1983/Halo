package tests.app;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.app.BLEInstructionPage1;
import pages.app.EnterEmailPage;
import pages.app.EnterHomeNamePage;
import pages.app.HomeUsersPage;
import pages.app.LockDashboardPage;
import pages.app.ManageHomesPage;
import pages.app.MenuFlyoutPage;
import pages.app.NewUserPage;
import utility.Log;

public class ManageHomesTest extends Settings{
	
	@SuppressWarnings("unchecked")
	@Test (dataProvider = "secondHome")
	public void addAnotherHomeTest(String homeName) {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			EnterHomeNamePage eh = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
			ld.clickHamburgerButton();
			mf.clickManageButton();
			mh.clickAddHomeButton();
			eh.enterHomeName(homeName);
			eh.clickSubmitButton();
			ld.verifyDashboardWithNoLocks();
		}catch(Exception e) {
			Log.addMessage("Failed to add new home");
			Assert.assertTrue(false, "Failed to add new home");
		  }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void addLockButtonNavigationTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			BLEInstructionPage1 bi = new BLEInstructionPage1((AppiumDriver<MobileElement>) driver);
			ld.clickHamburgerButton();
			mf.clickManageButton();
			mh.clickAddLockButton();
			bi.verifyInstruction();
			bi.clickBackButton();
			mh.clickBackButton();
		}catch(Exception e) {
			Log.addMessage("Failed to verify add lock button navigation");
			Assert.assertTrue(false, "Failed to verify add lock button navigation");
		  }
	}
	
	@SuppressWarnings("unchecked")
	@Test (dataProvider = "editHomeName")
	public void editHomeNameTest(String homeName) {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			EnterHomeNamePage eh = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
			ld.clickHamburgerButton();
			mf.clickManageButton();
			mh.clickEditHomeNameButton();
		//	eh.verifyHomeNameAutoPopulated();
			eh.enterHomeName(homeName);
			eh.clickSubmitButton();
			mh.clickBackButton();
		}catch(Exception e) {
			Log.addMessage("Failed to verify add lock button navigation");
			Assert.assertTrue(false, "Failed to verify add lock button navigation");
		  }
	}
	
	
	
	@SuppressWarnings("unchecked")
	public void shareHomeAdminTest(String adminUser, String adminEmail) throws InterruptedException {
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
		nu.enterNewUser(adminUser);
		nu.clickAdminButton();
		nu.clickNextButton();
		ep.enterEmail(adminEmail);
		ep.clickSubmitButton();
		hu.checkForShareSentAlert();
		Log.addMessage("Share home to other user as admin is successful");
	  }catch(Exception e) {
		Log.addMessage("Failed to share home to admin");
		e.printStackTrace();
		Assert.assertTrue(false, "Failed to share home to admin");
	  }
		
	}

	@SuppressWarnings("unchecked")
	public void shareHomeMemberTest(String memberUser, String memberEmail) throws InterruptedException {
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
		nu.enterNewUser(memberUser);
		nu.clickMemberButton();
		nu.clickNextButton();
		ep.enterEmail(memberEmail);
		ep.clickSubmitButton();
		hu.checkForShareSentAlert();
		Log.addMessage("Share home to other user as member is successful");
	  }catch(Exception e) {
		Log.addMessage("Failed to share home to member");
		e.printStackTrace();
		Assert.assertTrue(false, "Failed to share home to member");	
	  }
	}
	
}
