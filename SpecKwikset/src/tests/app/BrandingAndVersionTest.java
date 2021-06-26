package tests.app;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.app.LockDashboardPage;
import pages.app.MenuFlyoutPage;
import utility.Log;

public class BrandingAndVersionTest extends Settings{
	
	@SuppressWarnings("unchecked")
	@Test
	public void checkAppVersion_EnvTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			ld.clickHamburgerButton();
			mf.getAppEnv();
			mf.getAppVersion();
		}catch(Exception e) {
			Log.addMessage("Failed to get app version and environment");  
			Assert.assertTrue(false, "Failed to get app version and environment");
		}
	}

}
