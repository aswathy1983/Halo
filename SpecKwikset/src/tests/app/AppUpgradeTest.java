package tests.app;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.app.LockDashboardPage;
import pages.app.MenuFlyoutPage;
import utility.Log;
import utility.PropertyUtility;
import utility.Utility;

public class AppUpgradeTest extends Settings{

	String iOS_App = System.getProperty("user.dir") + PropertyUtility.getProperty("iOSAppPath");
	String appPackage = System.getProperty("user.dir") + PropertyUtility.getProperty("AndroidAppPackage");
	String appActivity = System.getProperty("user.dir") +  PropertyUtility.getProperty("AndroidAppActivity");
	String android_App = System.getProperty("user.dir") +  PropertyUtility.getProperty("AndroidAppPath");	
	
	@Test
	@SuppressWarnings("unchecked")
	
	public void appUpgradeTest() throws InterruptedException {
	  try {
		LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
		MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
		ld.clickHamburgerButton();
		String ver_1 = mf.getAppVersion();
		appUpgrade();
		LockDashboardPage lc = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
		lc.clickHamburgerButton();
		MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
		String ver_2 = mp.getAppVersion();
		mp.compareAppVersions(ver_1, ver_2);
		Log.addMessage("App Upgrade Test passed successfully");
	  }catch(Exception e) {
		  Log.addMessage(e.getMessage().toString());
		  Log.addMessage("App upgrade Test failed");
		  Assert.assertTrue(false, "App upgrade Test failed");
	  }
	}
	
	@SuppressWarnings("unchecked")
	public void appUpgrade() throws InterruptedException {
	 try {	
		if (device.equals("iOS")) {
			HashMap<String, String> bundleArgs = new HashMap<>();
			bundleArgs.put("bundleId", "com.spectrumhhi.ble-wifi");
			((AppiumDriver<MobileElement>) driver).executeScript("mobile: terminateApp", bundleArgs);
			HashMap<String, String> installArgs = new HashMap<>();
			installArgs.put("app", iOS_App);
			((AppiumDriver<MobileElement>) driver).executeScript("mobile: installApp", installArgs);
			((AppiumDriver<MobileElement>)driver).executeScript("mobile: launchApp", bundleArgs);
		}
		else if (device.equals("android")) {
			((AppiumDriver<MobileElement>) driver).installApp(android_App);
			((AppiumDriver<MobileElement>) driver).launchApp();
		}
		else {
			Log.addMessage("Error!!!!!!!!...Application not found.");
			Assert.assertTrue(false);
		}
		Utility.simpleWait(10000);
	 }catch(Exception e) {
		  Log.addMessage(e.getMessage().toString());
		  Log.addMessage("Something went wrong. App upgrade cannot be done");
		  Assert.assertTrue(false, "Some error occured. App upgrade cannot be carried out");
	 }
	}

}
