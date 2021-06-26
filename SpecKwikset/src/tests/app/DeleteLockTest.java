package tests.app;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.app.ConfirmDeleteLockPage;
import pages.app.LockDashboardPage;
import pages.app.LockSettingsPage;
import utility.Log;

public class DeleteLockTest extends Settings{
	
	@SuppressWarnings("unchecked")
	@Test
	public void deleteLockTest(String name) {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			ConfirmDeleteLockPage cd = new ConfirmDeleteLockPage((AppiumDriver<MobileElement>) driver);
			ld.clickLockSettingsButton();
			ls.clickDeleteLockButton();
			cd.deleteLock();		
		}catch(Exception e) {
			Log.addMessage("Failed to delete lock");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to delete lock");
		}
	}

}
