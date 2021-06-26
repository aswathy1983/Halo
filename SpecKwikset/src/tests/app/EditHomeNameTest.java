package tests.app;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.app.EnterHomeNamePage;
import pages.app.LockDashboardPage;
import pages.app.ManageHomesPage;
import pages.app.MenuFlyoutPage;
import utility.Log;

public class EditHomeNameTest extends Settings{
	
	@SuppressWarnings("unchecked")
	@Test
	public void editHomeName(String home) {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			EnterHomeNamePage ep = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
			ld.clickHamburgerButton();
			mf.clickManageButton();
			mh.clickEditHomeNameButton();
			ep.enterHomeName(home);
			Log.addMessage("Home name edited");
		}catch(Exception e) {
			Log.addMessage("Failed to edit home name");  
			Assert.assertTrue(false, "Failed to edit home name");
		}
	}

}
