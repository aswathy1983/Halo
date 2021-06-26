package tests.app;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.app.LockDashboardPage;
import pages.app.LockInfoPage;
import pages.app.LockNamePage;
import pages.app.LockSettingsPage;
import pages.app.MenuFlyoutPage;
import utility.Log;


public class FPLockAttributesTest extends Settings{
	
	int sbcnt, timecnt, lkcnt, cntPhone = 0;
	String delayStts, updtdTimeflyout, updtdTimeDashboard = "";
	
	@SuppressWarnings("unchecked")
	@Test
	public void viewLastUpdateTimeDashboardTest() throws InterruptedException {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			updtdTimeflyout="";
			updtdTimeDashboard="";
			System.out.println("before refresh");
			if(device.equals("android")) {
				Thread.sleep(27000);
			}
			
			ld.refreshlockDashboard();
			System.out.println("after refresh");
			Thread.sleep(1000);
			updtdTimeDashboard = ld.getLastUpdateTime();
			ld.clickHamburgerButton();
			Thread.sleep(2000);
			updtdTimeflyout = mp.getLastUpdateTime();
			System.out.println("updtdTimeflyout="+updtdTimeflyout);
			mp.clickLockImageInMenu("hl");
			Thread.sleep(5000);
			
			System.out.println("updtdTimeDashboard="+updtdTimeDashboard);
			
			if(updtdTimeflyout.equals(updtdTimeDashboard)){
				Log.addMessage("Last updated time in flyout menu page is same as in lock dashboard page");
			}else {
				Log.addMessage("Last updated time in flyout menu page is different than in lock dashboard page");
			}
			Thread.sleep(3000);
			Log.addMessage("Last updated time in flyout menu page is :"+updtdTimeflyout);
			Log.addMessage("Last updated time in lcok dashoard is :"+updtdTimeDashboard);
			/*if(device.equals("iOS")) {
				Log.addMessage("Lock percentage for the battery is :"+ls.getBatteryPercentage());
			}*/
			Thread.sleep(3000);
		}catch(Exception e) {
			Log.addMessage("Failed to display last updated time");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display last updated time");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void viewLockInfoTest() throws InterruptedException {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			LockInfoPage li = new LockInfoPage((AppiumDriver<MobileElement>) driver);
			System.out.println("in viewLockInfoTest");
			Thread.sleep(27000);//for test in between
			Thread.sleep(1000);
			ld.getBatteryPercentageDashboard();
			ld.clickHamburgerButton();
			Thread.sleep(2000);
			mp.clickLockImageInMenu("hl");
			Thread.sleep(5000);
			
			ld.clickLockSettingsButton();
			Thread.sleep(3000);
			li.getLockInfoBatteryPercentage();
			ls.getBatteryPercentage();
			ls.clickLockInfoButton();
			Thread.sleep(3000);
			li.getModelInfo();
			li.getProductFamilyInfo();
			li.getSKUInfo();
			li.getSerialNumberInfo();
			li.getFWBundleVersionInfo();
			li.getMBFirmwareInfo();
			li.getBLEFirmwareInfo();
			li.getWFCFirmwareInfo();
			li.getWFRFirmwareInfo();
			li.getHardwareRevisionInfo();
			li.getManufactureDate();
			li.getActivationDate();
			
			li.clickBackButton();
			Thread.sleep(3000);
			ls.clickEditLockNameButton();
			Log.addMessage("Lock info displayed");
		}catch(Exception e)
		{
			Log.addMessage("Failed to display lock info");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display lock info");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="hmLkName")
	public void lockNameTest(String lockname, String expMessage, String expMessageiOS) {
		try {
			LockNamePage ln = new LockNamePage((AppiumDriver<MobileElement>) driver);
			if(device.contentEquals("iOS")) {
				ln.valLockName(lockname, expMessageiOS);
			}else {
				ln.valLockName(lockname, expMessage);
			}
			
			Log.addMessage("lock name validated");
			
		}catch(Exception e) {
			Log.addMessage("Failed to enter lock name");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to enter lock name");
		}
	}
	
}
