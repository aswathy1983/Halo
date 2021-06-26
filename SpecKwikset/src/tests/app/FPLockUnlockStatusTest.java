package tests.app;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionState;
import okhttp3.Connection;
import pages.app.AutoLockDelaySettingPage;
import pages.app.ClearHistoryPopupPage;
import pages.app.ConfirmDeleteLockPage;
import pages.app.LockDashboardPage;
import pages.app.LockEventHistoryPage;
import pages.app.LockNamePage;
import pages.app.LockSettingsPage;
import pages.app.ManageHomesPage;
import pages.app.MenuFlyoutPage;
import pages.app.PairedSmartPhoneListPage;
import pages.app.UserFPAccessProfilePage;
import pages.app.ViewAccessCodesPage;
import utility.ExcelRead;
import utility.Log;


public class FPLockUnlockStatusTest extends Settings{
	
	int sbcnt, timecnt, lkcnt, cntPhone = 0;
	
	@SuppressWarnings("unchecked")
	@Test
	public void lockFunctionalityTest() throws InterruptedException {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			if(device.equals("android")) {
				ld.clickHamburgerButton();
				Thread.sleep(2000);
				mp.clickLockImageInMenu("hl");
				Thread.sleep(5000);
			}
			//lu.lockUnlockTest();// commented as this method is in another test method check if we can make dependency to another test method
			String status = ld.getLockStatus();
			if (status.equals("Locked")) {
				ld.unlockOperation();
				Thread.sleep(5000);
				ld.lockOperation();
				Thread.sleep(5000);
			}
			else if (status.equals("Unlocked")) {
				ld.lockOperation();
				Thread.sleep(5000);
				ld.unlockOperation();
				Thread.sleep(5000);
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
	
	
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void lockUnlockBLEOff() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			ConfirmDeleteLockPage cd = new ConfirmDeleteLockPage((AppiumDriver<MobileElement>) driver);
			System.out.println("Wait for BLE Off");
			Thread.sleep(27000);
			String status = ld.getLockStatus();
			if (status.equals("Locked")) {
				ld.unlockOperation();
				//Thread.sleep(5000);
				ld.lockOperation();
			}
			else if (status.equals("Unlocked")) {
				ld.lockOperation();
				//Thread.sleep(5000);
				ld.unlockOperation();
			}
			else {
				Log.addMessage("Lock status is: "+status);
				Assert.assertTrue(false,"Failed to do lock unlock with no BLE");
			}
			Log.addMessage("Lock unlock performed with ble off");
			Assert.assertTrue(true,"Lock unlock performed with no BLE");
			
		}catch(Exception e) {
			 Log.addMessage("Failed to do lock unlock with no BLE");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to do lock unlock with no BLE");
		 }
	}
	
	@SuppressWarnings("unchecked")
	public void lockUnlockWithStatus() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			
			//System.out.println("Wait for BLE ON and Wifi Off");
			Thread.sleep(27000);
			/*if(device.equals("android")) {
				ld.clickCancelButton();
			}*/
			
			String status = ld.getLockStatus();
			if (status.equals("Locked")) {
				ld.unlockOperation();
				Thread.sleep(5000);
				ld.lockOperation();
			}else if (status.equals("Unlocked")) {
				ld.lockOperation();
				Thread.sleep(5000);
				ld.unlockOperation();
			}else if (status.equals("Lock Offline")) {//in iOS
				ld.lockOperation();
				Thread.sleep(5000);
				ld.unlockOperation();
			}else {
				Log.addMessage("Lock status is: "+status);
				Assert.assertTrue(false,"Failed to do lock unlock with no internet connection");
			}
			Log.addMessage("Lock unlock performed with no internet connection");
			Assert.assertTrue(true,"Lock unlock performed with no internet connection");
			
		}catch(Exception e) {
			 Log.addMessage("Failed to perform lock unlock");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to perform lock unlock");
		 }
	}
	@SuppressWarnings("unchecked")
	@Test
	public void lockUnlockInternetOff() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			
			System.out.println("Wait for BLE ON and Wifi Off");
			
			Thread.sleep(27000);
			if(device.equals("android")) {
				ld.clickCancelButton();
			}
			
			String status = ld.getLockStatus();
			if (status.equals("Locked")) {
				ld.unlockOperation();
				Thread.sleep(5000);
				ld.lockOperation();
			}else if (status.equals("Unlocked")) {
				ld.lockOperation();
				Thread.sleep(5000);
				ld.unlockOperation();
			}else if (status.equals("Lock Offline")) {//in iOS
				ld.lockOperation();
				Thread.sleep(5000);
				ld.unlockOperation();
			}else {
				Log.addMessage("Lock status is: "+status);
				Assert.assertTrue(false,"Failed to do lock unlock with no internet connection");
			}
			Log.addMessage("Lock unlock performed with no internet connection");
			Assert.assertTrue(true,"Lock unlock performed with no internet connection");
			
		}catch(Exception e) {
			 Log.addMessage("Failed to perform lock unlock");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to perform lock unlock");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void lockUnlockWifiandBLEOffTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			
			System.out.println("Wait for BLE OFF and Wifi Off");
			Thread.sleep(27000);
			if(device.equals("android")) {
				ld.clickCancelButton();
				Log.addMessage("Internet connection required popup displayed with both wifi and ble off");
				Assert.assertTrue(true,"Internet connection required popup displayed with both wifi and ble off");
			}else {
				//commented on 10-06-2020 for iOS
				String status = ld.getLockStatus();
				if (status.equals("Locked")) {
					ld.unlockOperation();
					//Thread.sleep(5000);
					//ld.lockOperation();
				}else if (status.equals("Unlocked")) {
					ld.lockOperation();
					//Thread.sleep(5000);
					//ld.unlockOperation();
				}else if (status.equals("Lock Offline")) {//in iOS
					ld.lockOperation();
					//Thread.sleep(5000);
					//ld.unlockOperation();
				}else {
					Log.addMessage("Lock status is: "+status);
					Assert.assertTrue(false,"Failed to do lock unlock with both wifi and ble off");
				}
				ld.clickOKButton();
				Log.addMessage("Lock Offline popup displayed with both wifi and ble off");
				Assert.assertTrue(true,"Lock Offline popup displayed with both wifi and ble off");
			}
			
			
		}catch(Exception e) {
			 Log.addMessage("Failed to display Lock Offline popup with both wifi and ble off");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to display Lock Offline popup with both wifi and ble off");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void lockFunctionalityRemoteTest() throws InterruptedException {
		try {
			System.out.println("Wait for BLE off for remote mode");
			//Thread.sleep(27000);//commented on 16-06-2020
			//lockFunctionalityTest();
			lockUnlockWithStatus();
			Log.addMessage("");
		}catch(Exception e) {
			Log.addMessage("Failed to lock/unlock in remote mode");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to lock/unlock in remote mode");
		}
	}
	
	@Test
	public void lockUnlockBLEOffRemoteTest() {
		try {
			System.out.println("Wait for BLE Off");
			//Thread.sleep(27000);
			lockUnlockWithStatus();
			Log.addMessage("Lock unlock performed in remote with ble off");
			Assert.assertTrue(true,"Lock unlock performed in remote with no BLE");
			
		}catch(Exception e) {
			 Log.addMessage("Failed to do lock unlock in remote with no BLE");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to do lock unlock in remote with no BLE");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void lockUnlockInternetOffRemoteTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			System.out.println("Wait for Wifi Off");
			Thread.sleep(27000);
			if(device.equals("android")) {
				ld.clickCancelButton();
				Log.addMessage("Internet required popup displayed in remote with no internet connection");
				Assert.assertTrue(true,"Internet required popup displayed in remote with no internet connection");
			}else {
				String status = ld.getLockStatus();
				if(status.equals("Locked")) {
					ld.unlockOperation();
				}else if (status.equals("Unlocked")) {
					ld.lockOperation();
				}else if (status.equals("Lock Offline")) {//in iOS
					ld.lockOperation();
				}else {
					Log.addMessage("Lock status is: "+status);
					Assert.assertTrue(false,"Failed to do lock unlock with both wifi and ble off");
				}
				ld.clickOKButton();
				
				Log.addMessage("Lock Offline popup displayed in remote with no internet connection");
				Assert.assertTrue(true,"Lock Offline popup displayed in remote with no internet connection");
			}
			
		}catch(Exception e) {
			 Log.addMessage("Failed to display Lock Offline popup in remote with no internet connection");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to display Lock Offline popup in remote with no internet connection");
		 }
	}
	
	
	@Test
	public void lockUnlockWifiandBLEOffRemoteTest() {
		try {
			lockUnlockInternetOffRemoteTest();
			Log.addMessage("Lock Offline popup displayed in remote with both wifi and ble off");
			Assert.assertTrue(true,"Lock Offline popup displayed in remote with both wifi and ble off");
			
		}catch(Exception e) {
			 Log.addMessage("Failed to display Lock Offline popup in remote with both wifi and ble off");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to display Lock Offline popup in remote with both wifi and ble off");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void displaylockActivityScreenTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			LockEventHistoryPage le = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
			System.out.println("Wait for Wifi and BLE on");
			Thread.sleep(27000);
			
			ld.clickLockHistoryButton();
			Thread.sleep(3000);
			le.verifyLockHistoryScreen();
			le.clickBackButton();
			Thread.sleep(3000);
			
			Log.addMessage("UI elements of list history screen is dispalyed and back button is navigating back to lock dashboard screen.");
		}catch(Exception e) {
			Log.addMessage("Failed to display all elements in the list history screen");
			e.printStackTrace();
			Assert.assertTrue(false, "UI of finger print profile details not dispalyed");
		}
	}
	
	@Test
	public void displaylockActivityScreenRemoteTest() {
		try {
			System.out.println("Wait for BLE Off");
			Thread.sleep(27000);
			displaylockActivityScreenTest();
			
			Log.addMessage("UI elements of list history screen is dispalyed and back button is navigating back to lock dashboard screen in remote mode");
		}catch(Exception e) {
			Log.addMessage("Failed to display all elements in the list history screen in remote mode");
			e.printStackTrace();
			Assert.assertTrue(false, "UI of finger print profile details not dispalyed in remote mode");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="clearHist")
	public void clearHistoryBLEOffTest(String expTitle, String expMessage, String histClearMsgiOS, String histClearMsg) {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			LockEventHistoryPage le = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
			ClearHistoryPopupPage ch = new ClearHistoryPopupPage((AppiumDriver<MobileElement>) driver);
			System.out.println("Wait for BLE off");
			Thread.sleep(10000);//for testing in between
			ld.clickLockHistoryButton();
			Thread.sleep(5000);
			le.clearHistory();
			ch.verifyPopUpVerbiage(expTitle, expMessage);
			ch.verifyCancelButton();
			ch.clickYesButton();
			Thread.sleep(3000);
			le.clearHistory();
			ClearHistoryPopupPage ch1 = new ClearHistoryPopupPage((AppiumDriver<MobileElement>) driver);
			LockEventHistoryPage le1 = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
			if(device.equals("iOS")) {
				ch1.clickYesButton();
				le1.clearHistoryWhenEmpty(histClearMsgiOS);
			}else {
				le1.clearHistoryWhenEmpty(histClearMsg);
			}
			le1.clickBackButton();
			Log.addMessage("Lock events history cleared");
		}catch(Exception e) {
			Log.addMessage("Failed to clear lock events history");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to clear lock events history");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void clearHistoryBLEWifiOffTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			LockEventHistoryPage le = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
			ClearHistoryPopupPage ch = new ClearHistoryPopupPage((AppiumDriver<MobileElement>) driver);
			System.out.println("Wait for BLE and Wifi off");
			Thread.sleep(15000);//for testing in between
			
			ld.clickCancelButton();
			ld.clickLockHistoryButton();
			ld.clickOKButton();
			Thread.sleep(3000);
			if(device.equals("android")) {
				le.clearHistory();
				le.clickCancelButton();
			}
			LockEventHistoryPage le1 = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
			le1.clickBackButton();
			Log.addMessage("Lock events history cleared");
		}catch(Exception e) {
			Log.addMessage("Failed to clear lock events history");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to clear lock events history");
		}
	}
	ExcelRead excel = new ExcelRead();
	
	@DataProvider(name = "clearHist")
	public Object[][] getDataLockSetting() throws Exception {
		return excel.getTableArray(InputData, "App", "fpHistClearPopup");
	}
	
	@DataProvider(name = "wifiOffpopup")
	public Object[][] getDataWifiOffPopup() throws Exception {
		return excel.getTableArray(InputData, "App", "fpWifiOffPopup");
	}
	
	@DataProvider(name = "lockHistry")
	public Object[][] getDataLockHistoryiOS() throws Exception {
		return excel.getTableArray(InputData, "Validation", "acBvtLockHistory");
	}

}
