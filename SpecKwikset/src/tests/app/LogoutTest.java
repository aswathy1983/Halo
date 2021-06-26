package tests.app;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.app.LockDashboardPage;
import pages.app.MenuFlyoutPage;
import utility.Log;

public class LogoutTest extends Settings {
	
@SuppressWarnings("unchecked")
	
	@Test
	public void logoutTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			ld.clickHamburgerButton();
			mf.clickLogoutButton();
		}catch(Exception e) {
			Log.addMessage("Logout failed");
			e.printStackTrace();
			Assert.assertTrue(false, "Logout failed");
		}
    }
}
