package tests.app;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.app.LockDashboardPage;
import utility.Log;

public class LockUnlockTest extends Settings{

	@SuppressWarnings("unchecked")
	
	@Test
	public void lockUnlockTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			String status = ld.getLockStatus();
			if (status.equals("Locked")) {
				ld.unlockOperation();
				ld.lockOperation();
			}
			else if (status.equals("Unlocked")) {
				ld.lockOperation();
				ld.unlockOperation();
			}
			else {
				Log.addMessage("Lock status is: "+status);
			}
		}catch(Exception e) {
			Log.addMessage("Failed to lock/unlock");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to lock/unlock");
		}
	}
}
