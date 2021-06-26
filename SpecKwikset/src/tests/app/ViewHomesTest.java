package tests.app;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.app.LockDashboardPage;
import pages.app.ManageHomesPage;
import pages.app.MenuFlyoutPage;
import utility.Log;

public class ViewHomesTest extends Settings{
	
	@SuppressWarnings("unchecked")
	@Test
	public void viewHomes() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			ld.clickHamburgerButton();
			mf.clickManageButton();
			mh.viewAllHomes();
			Log.addMessage("Added homes are displayed");
		}catch(Exception e) {
			Log.addMessage("Failed to display all homes");  
			Assert.assertTrue(false, "Failed to display all homes");
		}
	}

}
