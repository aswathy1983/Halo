package tests.app;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.app.AccountSettingsPage;
import pages.app.LockDashboardPage;
import pages.app.MenuFlyoutPage;
import pages.app.SettingsPage;
import utility.Log;

public class DeleteAccountTest extends Settings{
	
	@SuppressWarnings("unchecked")
	
	@Test
	public void deleteAccountTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			SettingsPage sp = new SettingsPage((AppiumDriver<MobileElement>) driver);
			AccountSettingsPage as = new AccountSettingsPage((AppiumDriver<MobileElement>) driver);
			ld.clickHamburgerButton();
			mf.clickAccountSettingsButton();
			sp.clickAccountOption();
			as.clickDeleteAccountOption();
			as.clickDeleteOption();
		}catch(Exception e) {
			Log.addMessage("Failed to delete account");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to delete account");
		}
	}	
	
	@Test
	public void confirmDeletionTest() {
		
	}
}
