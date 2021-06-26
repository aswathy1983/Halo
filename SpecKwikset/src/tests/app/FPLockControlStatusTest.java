package tests.app;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.app.AutoLockDelaySettingPage;
import pages.app.ConfirmDeleteLockPage;
import pages.app.LockDashboardPage;
import pages.app.LockEventHistoryPage;
import pages.app.LockNamePage;
import pages.app.LockSettingsPage;
import pages.app.ManageHomesPage;
import pages.app.MenuFlyoutPage;
import pages.app.PairedSmartPhoneListPage;
import utility.ExcelRead;
import utility.Log;


public class FPLockControlStatusTest extends Settings{
	
	int sbcnt, timecnt, lkcnt, cntPhone = 0;
	
	@SuppressWarnings("unchecked")
	@Test
	public void lockFunctionalityTest() throws InterruptedException {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			if(device.equals("android")) {
				ld.clickHamburgerButton();
				mp.clickLockImageInMenu("hl");
				Thread.sleep(2000);
			}
			//lu.lockUnlockTest();// commented as this method is in another test method check if we can access another test method
			String status = ld.getLockStatus();
			if(status.equals("Locked")) {
				ld.unlockOperation();
				Thread.sleep(5000);
				ld.lockOperation();
				Thread.sleep(5000);
			}
			else if(status.equals("Unlocked")) {
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
	
   /*	@SuppressWarnings("unchecked")
	@Test(dataProvider="hmLockHistry")
	public void viewlockActivityTest(String lkEventName,String lkSubType, String lkTime) {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			LockEventHistoryPage le = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
				
			ld.clickLockHistoryButton();
			Thread.sleep(3000);
			 if(lkSubType!="") {
				 sbcnt++;
			 }
			 if(lkTime!="") {
				 timecnt++;
			 }
			lkcnt =lkcnt+1;
			
			
			le.getLockHistoryList(lkEventName, lkSubType, lkTime, lkcnt-1, sbcnt-1,timecnt-1);	
			
			
			 Log.addMessage("Lock History is listed");
		 }catch(Exception e) {
			 Log.addMessage("Lock History is listed");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Lock History is not listed");
		 }
	}*/
	
	@SuppressWarnings("unchecked")
	@Test( dataProvider="lockHistry")
	public void viewlockActivityTest(String lkEventName,String lkSubType, String lkTime, String lkiosTime, String lkiosEvent) {
		 try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 LockEventHistoryPage le = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
			 if(lkcnt==0) {
				 ld.clickLockHistoryButton();
			 }
			 Thread.sleep(3000);
			if(lkSubType!="") {
				 sbcnt++;
			 }
			 if(lkTime!="") {
				 timecnt++;
			 }
			lkcnt =lkcnt+1;
			 
			 if(device.equals("iOS")) {
				 le.getLockHistoryiOSList(lkiosEvent, lkiosTime, lkcnt-1, sbcnt-1,timecnt-1);
			 }else {
				 le.getLockHistoryList(lkEventName, lkSubType, lkTime, lkcnt-1, sbcnt-1,timecnt-1);
			 }
			
			 Log.addMessage("Lock History is listed");
		 }catch(Exception e) {
			 Log.addMessage("Lock History is listed");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Lock History is not listed");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test( dataProvider="lockSetting")
	public void lockSettingsTest(String lockName, String phameExp, String phameios) {
		try {
			LockEventHistoryPage le = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			LockNamePage ln = new LockNamePage((AppiumDriver<MobileElement>) driver);
			AutoLockDelaySettingPage al = new AutoLockDelaySettingPage((AppiumDriver<MobileElement>) driver);
			PairedSmartPhoneListPage ps = new PairedSmartPhoneListPage((AppiumDriver<MobileElement>) driver);
			//Thread.sleep(15000);//for testing in btwn
			le.clickBackButton();
			ld.clickLockSettingsButton();
			Thread.sleep(8000);
			ls.clickEditLockNameButton();
			ln.setLockName(lockName);
			ln.clickSubmitButton();
			Thread.sleep(8000);
			if(device.equals("android")) {
				ln.clickOkButton();
			}
			Log.addMessage("Lock name updated");
			Thread.sleep(3000);
			
			ls.clickLockSoundsButton();
			Thread.sleep(25000);
			Log.addMessage("Lock sounds updated");
			
			ls.clickAutoLockButton();
			Thread.sleep(3000);
			if(al.getAutoDelayStatus().equals("Off") || al.getAutoDelayStatus().equals("0")) {
				al.clickAutoLock();
				Thread.sleep(25000);
			}
			al.set_10min_Delay();
			Thread.sleep(25000);
			Log.addMessage("Auto lock delay status set");
			if(device.equals("android")) {
				al.clickBackButton();
			}
			Thread.sleep(3000);
			
			ls.clickPairedSmartPhonesButton();
			Thread.sleep(3000);
			if(device.equals("iOS")) {
				ps.pairedPhoneList(phameios, cntPhone);//change the function for 1 data.
			}else {
				ps.pairedPhoneList(phameExp, cntPhone);//change the function for 1 data.
			}
			
			Thread.sleep(3000);
			ps.clickBackButton();
			
			ls.clickLEDStatusButton();
			Thread.sleep(25000);
			
			Log.addMessage("lock settings displayed");
			Assert.assertTrue(true,"lock settings displayed");
		}catch(Exception e) {
			 Log.addMessage("Failed to update Lock Settings");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to update Lock Settings");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test( dataProvider="wifiOffpopup")
	public void deleteLockWifiOffTest(String popupMsg) {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			ConfirmDeleteLockPage cd = new ConfirmDeleteLockPage((AppiumDriver<MobileElement>) driver);
			System.out.println("Wait to switch Off  Wifi");
			Thread.sleep(27000);
			if(device.equals("android")) {
				ls.clickCancelButton();
			}
			Thread.sleep(3000);
			ls.clickDeleteLockButton();
			System.out.println("clicked delete lock");
			if(device.equals("android")) {
				ls.valWifiOffMessage(popupMsg);
			}else {
				cd.deleteLock();
				cd.clickOKButton();
				cd.clickBackButton();
			}
			System.out.println("validated wifi off popup");
			System.out.println("Wait to switch ON  Wifi");
			//Thread.sleep(27000);
			Thread.sleep(5000);
			ls.clickBackButton();
			Log.addMessage("Wifi Off pop up displayed");
			Assert.assertTrue(true,"Wifi Off pop up displayed");
			
		}catch(Exception e) {
			 Log.addMessage("Failed to display wifi off popup");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to display wifi off popup");
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
				Thread.sleep(5000);
				ld.lockOperation();
			}
			else if (status.equals("Unlocked")) {
				ld.lockOperation();
				Thread.sleep(5000);
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
	public void deleteLockTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			ConfirmDeleteLockPage cd = new ConfirmDeleteLockPage((AppiumDriver<MobileElement>) driver);
			System.out.println("Wait for Wifi ON to Delete Lock");
			Thread.sleep(27000);
			ld.clickLockSettingsButton();
			Thread.sleep(3000);
			ls.clickDeleteLockButton();
			Thread.sleep(3000);
			cd.deleteLock();
			if(device.equals("iOS")) {
				Thread.sleep(20000);
				mh.clickOkButton();
			}
			mh.clickBackButton();
			Thread.sleep(5000);
			Log.addMessage("Lock deleted");
			Assert.assertTrue(true,"Lock deleted");
			
		}catch(Exception e) {
			 Log.addMessage("Failed to delete the lock");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to delete the lock");
		 }
	}
	
	ExcelRead excel = new ExcelRead();
	
	/*@DataProvider(name = "lockHistry")
	public Object[][] getDataLockHistory() throws Exception {
		return excel.getTableArray(InputData, "Validation", "acFPLockHistory");
	}*/
	
	@DataProvider(name = "lockSetting")
	public Object[][] getDataLockSetting() throws Exception {
		return excel.getTableArray(InputData, "App", "fpLockSetting");
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
