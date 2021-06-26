package tests.app;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.app.AutoLockDelaySettingPage;
import pages.app.LockDashboardPage;
import pages.app.LockSettingsPage;
import utility.Log;

public class LockGeneralFeaturesTest extends Settings{
	
	@SuppressWarnings("unchecked")
	@Test
	public void autoLockTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			AutoLockDelaySettingPage ad = new AutoLockDelaySettingPage((AppiumDriver<MobileElement>) driver);
			ld.clickLockSettingsButton();
			ls.clickAutoLockButton();
			ad.clickAutoLock();
			ad.set_30Sec_Delay();
			Log.addMessage("Auto Lock Test passed successfully");
		}catch(Exception e) {
			Log.addMessage("Auto lock test failed");
			e.printStackTrace();
			Assert.assertTrue(false, "Auto lock test failed");
		}	
	 }
	
	@SuppressWarnings("unchecked")
	@Test
	public void lockSoundsTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			ld.clickLockSettingsButton();
			ls.clickLockSoundsButton();
			Log.addMessage("Lock sounds test passed");
		}catch(Exception e) {
			Log.addMessage("Lock Sounds test failed");
			e.printStackTrace();
			Assert.assertTrue(false, "Lock Sounds test failed");
		}	
	 }
	
	@SuppressWarnings("unchecked")
	@Test
	public void LEDStatusTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			ld.clickLockSettingsButton();
			ls.clickLEDStatusButton();
			Log.addMessage("LED status test passed");
		}catch(Exception e) {
			Log.addMessage("Lock status test failed");
			e.printStackTrace();
			Assert.assertTrue(false, "Lock status test failed");
		}	
	 }
	
	@SuppressWarnings("unchecked")
	@Test
	public void removeOrphanedPairingKeysTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			ld.clickLockSettingsButton();
			ls.clickPairedSmartPhonesButton();
			Log.addMessage("Paired Smartphones test passed");
		}catch(Exception e) {
			Log.addMessage("Paired Smartphones test failed");
			e.printStackTrace();
			Assert.assertTrue(false, "Paired Smartphones test failed");
		}	
	 }
	

}
