package tests.app;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.app.LockDashboardPage;
import pages.app.LockNamePage;
import pages.app.LockSettingsPage;
import utility.Log;

public class EditLockNameTest extends Settings{
	
	@SuppressWarnings("unchecked")
	@Test
	public void editLockName(String lockname) {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			LockNamePage el = new LockNamePage((AppiumDriver<MobileElement>) driver);
			ld.clickLockSettingsButton();
			ls.clickEditLockNameButton();
			el.enterLockName(lockname);
			el.clickSubmitButton();
			Log.addMessage("Lock name is updated");
		}catch(Exception e) {
			Log.addMessage("Failed to edit lock name");  
			Assert.assertTrue(false, "Failed to edit lock name");
		}
	}

}
