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
import pages.app.LockInfoPage;
import pages.app.LockNamePage;
import pages.app.LockSettingsPage;
import pages.app.ManageHomesPage;
import pages.app.MenuFlyoutPage;
import pages.app.ViewAccessCodesPage;
import utility.ExcelRead;
import utility.Log;


public class FPLockGeneralFeaturesTest extends Settings{
	
	int sbcnt, timecnt, lkcnt, cntPhone = 0;
	String delayStts = "";
	
	@SuppressWarnings("unchecked")
	@Test
	public void viewlockSettingsTest() throws InterruptedException {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			LockInfoPage li = new LockInfoPage((AppiumDriver<MobileElement>) driver);
			//if(device.equals("android")) {
				ld.clickHamburgerButton();
				Thread.sleep(2000);
				mp.clickLockImageInMenu("hl");
				Thread.sleep(5000);
			//}
			ld.clickLockSettingsButton();
			Thread.sleep(3000);
			Log.addMessage("Lock name for the home is :"+ls.getLockName());
			Log.addMessage("Auto lock status of the lock is :"+ls.getAutoLockStts());
			Log.addMessage("Lock sounds of the lock is :"+ls.getAudioStatus());
			Log.addMessage("Lock sounds of the lock is :"+ls.getLEDStatus());
			if(device.equals("iOS")) {
				Log.addMessage("Lock percentage for the battery is :"+ls.getBatteryPercentage());
			}
			Log.addMessage("Lock settings displayed for the home after pairing");
			ls.clickLockInfoButton();
			Thread.sleep(3000);
			li.getManufactureDate();
			li.getActivationDate();
			li.clickBackButton();
			Thread.sleep(5000);
			ls.clickBackButton();
			Thread.sleep(3000);
			
		}catch(Exception e) {
			Log.addMessage("Failed to display lock settings");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display lock settings");
		}
	}
	@SuppressWarnings("unchecked")
	@Test(dataProvider="noAccess")
	public void noAccessCodeTest(String expTitle, String expMessage, String iosMessage) throws InterruptedException {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			AutoLockDelaySettingPage al = new AutoLockDelaySettingPage((AppiumDriver<MobileElement>) driver);
			System.out.println("in noAccessCodeTest");
			Thread.sleep(27000);//for test in between
			if(device.equals("android")) {
				ld.clickHamburgerButton();
				Thread.sleep(2000);
				mp.clickLockImageInMenu("hl");
				Thread.sleep(5000);
			}
			ld.clickLockSettingsButton();
			Thread.sleep(3000);
			ls.clickAutoLockButton();
			Thread.sleep(3000);
			al.verifyPopUpVerbiage(expTitle,expMessage,iosMessage);
			al.clickBackButton();
			Thread.sleep(3000);
			ls.clickEditLockNameButton();
			Log.addMessage("No Access Code set pop up is displayed");
		}catch(Exception e)
		{
			Log.addMessage("Failed to display no access code set pop up");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display no access code set pop up");
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
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="fpSyncPopup")
	public void verifySyncingPopUpTest(String expTitle, String expMessage) {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			System.out.println("in setAudioStatusTest");
			Thread.sleep(27000);//for testing in between
			Thread.sleep(3000);
			System.out.println("after wait");
			ls.clickLockSoundsButton();
			System.out.println("after clickLockSoundsButton");
			if(device.contentEquals("iOS")) {
				Thread.sleep(5000);
				LockSettingsPage ls1 = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
				ls1.clickLockSoundsButton();
			}else {
				ls.clickLockSoundsButton();
			}
			//check font color of a text field while syncing
			/*Try this code, you will get element Color code in RGB, this will work for Native applications

			MobileElement elem = (MobileElement) driver.findElement(By.id(“loginButton”));

			org.openqa.selenium.Point point = elem.getCenter();
			int centerx = point.getX();
			int centerY = point.getY();
			
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			 BufferedImage image = ImageIO.read(scrFile);
			  // Getting pixel color by position x and y 
			  int clr=  image.getRGB(centerx,centerY); 
			  int  red   = (clr & 0x00ff0000) >> 16;
			  int  green = (clr & 0x0000ff00) >> 8;
			  int  blue  =  clr & 0x000000ff;
			  System.out.println("Red Color value = "+ red);
			  System.out.println("Green Color value = "+ green);
			  System.out.println("Blue Color value = "+ blue);*/
			//to verify syncing popup
			
			Thread.sleep(3000);
			ls.verifyPopUpVerbiage(expTitle,expMessage);
			Thread.sleep(5000);
			ls.clickBackButton();
			Log.addMessage("Lock settings are syncing popup displayed");
			Assert.assertTrue(true,"Lock settings are syncing popup displayed");
		}catch(Exception e) {
			 Log.addMessage("Failed to display lock syncing popup");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to display lock syncing popup");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void viewlockSettingsBLEOffTest() throws InterruptedException {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			LockInfoPage li = new LockInfoPage((AppiumDriver<MobileElement>) driver);
			System.out.println("Wait for BLE off");
			Thread.sleep(27000);
			if(device.equals("android")) {
				ld.clickHamburgerButton();
				Thread.sleep(2000);
				mp.clickLockImageInMenu("hl");
				Thread.sleep(5000);
			}
			ld.clickLockSettingsButton();
			Thread.sleep(3000);
			Log.addMessage("Lock name for the home is :"+ls.getLockName());
			Log.addMessage("Auto lock status of the lock is :"+ls.getAutoLockStts());
			Log.addMessage("Lock sounds of the lock is :"+ls.getAudioStatus());
			Log.addMessage("Lock sounds of the lock is :"+ls.getLEDStatus());
			Log.addMessage("Lock settings displayed for the home after pairing");
			ls.clickLockInfoButton();
			Thread.sleep(3000);
			li.getManufactureDate();
			li.getActivationDate();
			li.clickBackButton();
			Thread.sleep(5000);
			ls.clickBackButton();
			Thread.sleep(3000);
			
		}catch(Exception e) {
			Log.addMessage("Failed to display lock settings");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display lock settings");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void viewlockSettingsBLEOffWifiOffTest() throws InterruptedException {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			LockInfoPage li = new LockInfoPage((AppiumDriver<MobileElement>) driver);
			System.out.println("Wait for BLE Off and Wifi Off");
			Thread.sleep(27000);
			if(device.equals("android")) {
				ld.clickCancelButton(); 
			}
			if(device.equals("android")) {
				ld.clickHamburgerButton();
				Thread.sleep(2000);
				mp.clickLockImageInMenu("hl");
				Thread.sleep(5000);
			}
			ld.clickLockSettingsButton();
			Thread.sleep(3000);
			Log.addMessage("Lock name for the home is :"+ls.getLockName());
			Log.addMessage("Auto lock status of the lock is :"+ls.getAutoLockStts());
			Log.addMessage("Lock sounds of the lock is :"+ls.getAudioStatus());
			Log.addMessage("Lock sounds of the lock is :"+ls.getLEDStatus());
			Log.addMessage("Lock settings displayed for the home after pairing");
			ls.clickLockInfoButton();
			Thread.sleep(3000);
			li.getManufactureDate();
			li.getActivationDate();
			li.clickBackButton();
			Thread.sleep(5000);
			ls.clickBackButton();
			Thread.sleep(3000);
			
		}catch(Exception e) {
			Log.addMessage("Failed to display lock settings");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display lock settings");
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void viewFPUISecureModeTest() throws InterruptedException {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			System.out.println("Wait for BLE ON and Wifi ON");
			Thread.sleep(27000);
			//if(device.equals("android")) {
				ld.clickHamburgerButton();
				Thread.sleep(2000);
				mp.clickLockImageInMenu("hl");
				Thread.sleep(5000);
			//}
			ld.clickAccessCodeButton();
			Thread.sleep(3000);
			va.verifyUISecureModeFP();
			Log.addMessage("Secure Mode option displayed with enable disable button");
			
		}catch(Exception e) {
			Log.addMessage("Failed to display secure mode option");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display secure mode option");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void enableDisableSecureModeTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			System.out.println("enableDisableSecureModeTest");
			Thread.sleep(3000);
			System.out.println("one");
			va.enableSecureMode();
			System.out.println("check status="+va.getSecureModeStatus());
			if((va.getSecureModeStatus()).equals("On")) {
				Log.addMessage("Secure mode enabled icon displayed");
			}else {
				Log.addMessage("Secure mode disabled icon displayed");
			}
			System.out.println("two");
			Thread.sleep(10000);
			Log.addMessage("Secure mode enabled icon displayed");
			va.clickBackButton();
			Thread.sleep(3000);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			//if(device.equals("android")) {
				ld.clickHamburgerButton();
				Thread.sleep(2000);
				mp.clickLockImageInMenu("hl");
				Thread.sleep(5000);
			//}
			ld.secureModeScreen();
			Log.addMessage("Navigated back to dashboard page.");
			Assert.assertTrue(true,"Secure mode enabled");
			
		}catch(Exception e) {
			 Log.addMessage("Failed to enable secure mode");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enable secure mode");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void viewFPUISecureModeRemoteTest() throws InterruptedException {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			System.out.println("Wait for BLE off");
			Thread.sleep(27000);
			ld.secureModeScreen();
			ld.clickAccessCodeButton();
			va.verifyUISecureModeFP();
			Log.addMessage("Secure Mode option displayed with enable disable button in remote mode");
		}catch(Exception e) {
			Log.addMessage("Failed to display secure mode option in remote mode");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display secure mode option in remote mode");
		}
	}
	@SuppressWarnings("unchecked")
	@Test
	public void enableSecureModeRemoteTest() {
		try {
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			System.out.println("enableDisableSecureModeRemoteTest");
			Thread.sleep(3000);
			va.enableSecureMode();
			if(device.contentEquals("iOS")) {
				va.clickOkButton();
			}else {
				va.clickCancelButton();
			}
			Log.addMessage("Secure mode cannot be changed in remote mode");
			va.clickBackButton();
			Thread.sleep(3000);
			/*MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			if(device.equals("android")) {
				ld.clickHamburgerButton();
				Thread.sleep(2000);
				mp.clickLockImageInMenu();
				Thread.sleep(5000);
			}
			//check condition for secure mode on before checking the banner
			//ld.secureModeScreen();
			Log.addMessage("Secure mode banner displayed in dashboard page");*/
			Log.addMessage("Navigated back to dashboard page.");
			Assert.assertTrue(true,"Secure mode cannot be updated in remote mode");
			
		}catch(Exception e) {
			 Log.addMessage("Secure mode can be updated");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Secure mode can be updated");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void viewAudioStatusTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			System.out.println("Wait for BLE and Wifi ON");
			Thread.sleep(27000);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			//if(device.equals("android")) {
				ld.clickHamburgerButton();
				Thread.sleep(2000);
				mp.clickLockImageInMenu("hl");
				Thread.sleep(5000);
			//}
			ld.clickLockSettingsButton();
			
			Thread.sleep(3000);
			Log.addMessage("Lock audio status is:"+ls.getAudioStatus());
			Assert.assertTrue(true,"Lock audio status displayed");
		}catch(Exception e) {
			 Log.addMessage("Failed to display lock audio status");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to display lock audio status");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void setAudioStatusTest() {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			System.out.println("in setAudioStatusTest");
			
			ls.clickLockSoundsButton();
			Thread.sleep(27000);
			Log.addMessage("Lock audio status is set to:"+ls.getAudioStatus());
			Assert.assertTrue(true,"Lock audio status displayed");
		}catch(Exception e) {
			 Log.addMessage("Failed to set lock audio status");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to set lock audio status");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void setAudioStatusWifiOffTest() {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			System.out.println("Wait for Wifi Off");
			Thread.sleep(27000);
			if(device.equals("android")) {
				ls.clickCancelButton();
			}
			ls.clickLockSoundsButton();
			
			Thread.sleep(27000);
			Log.addMessage("Lock audio status is set to:"+ls.getAudioStatus());
			Assert.assertTrue(true,"Lock audio status displayed");
		}catch(Exception e) {
			 Log.addMessage("Failed to set lock audio status");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to set lock audio status");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void viewAutoLockStateTest() {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			System.out.println("In viewAutoLockStateTest");
			System.out.println("Wait for Wifi ON");
			Thread.sleep(27000);
			Log.addMessage("Auto lock status of the door is:"+ls.getAutoLockStts());
			Assert.assertTrue(true,"Auto Lock status displayed");
		}catch(Exception e) {
			 Log.addMessage("Failed to display auto lock status");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to display auto lock status");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void setAutoLockStateTest() {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			AutoLockDelaySettingPage al = new AutoLockDelaySettingPage((AppiumDriver<MobileElement>) driver);
			System.out.println("In setAutoLockStateTest");
			Thread.sleep(10000);//for testing in between
			Log.addMessage("Auto lock status of the door is:"+ls.getAutoLockStts());
			for(int i=1;i<6;i++) {
				ls.clickAutoLockButton();
				
				Thread.sleep(3000);
				delayStts="";
				delayStts=al.getAutoDelayStatus();
				//confirm or condition for iOS
				if(i==1 && (delayStts.equals("Off") || delayStts.equals("0"))) {
					al.clickAutoLock();
				}
				al.selectTimeDelay(Integer.toString(i));
				if(device.equals("android")) {
					al.clickBackButton();
				}
				Thread.sleep(27000);
				Log.addMessage("Auto lock status of the door after update is:"+ls.getAutoLockStts());
			}
			Thread.sleep(10000);
			Assert.assertTrue(true,"Auto Lock status displayed");
		}catch(Exception e) {
			 Log.addMessage("Failed to display auto lock status");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to display auto lock status");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void setAutoLockStateWifiOffTest() {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			AutoLockDelaySettingPage al = new AutoLockDelaySettingPage((AppiumDriver<MobileElement>) driver);
			System.out.println("Wait for Wifi Off");
			Thread.sleep(27000);
			if(device.equals("android")) {
				ls.clickCancelButton();
			}
			//ls.getAutoLockStts();
			Log.addMessage("Auto lock status of the door is:"+ls.getAutoLockStts());
			Thread.sleep(3000);
				ls.clickAutoLockButton();
				//commented as toggle button will be on after the previous test case 
				/*delayStts="";
				delayStts=al.getAutoDelayStatus();
				//confirm or condition for iOS
				if(delayStts.equals("Off") || delayStts.contentEquals("0")) {
					al.clickAutoLock();
				}*/
				al.set_5min_Delay();
				if(device.equals("android")) {
					al.clickBackButton();
				}
				Thread.sleep(20000);
				ls.getAutoLockStts();
				Log.addMessage("Auto lock status of the doorafter update is:"+ls.getAutoLockStts());
			
			Assert.assertTrue(true,"Auto Lock status displayed");
		}catch(Exception e) {
			 Log.addMessage("Failed to display auto lock status");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to display auto lock status");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void setAutoLockStateBleOffTest() {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			AutoLockDelaySettingPage al = new AutoLockDelaySettingPage((AppiumDriver<MobileElement>) driver);
			System.out.println("Wait for BLE Off and Wifi ON");
			Thread.sleep(27000);
			//ls.getAutoLockStts();
			Log.addMessage("Auto lock status of the door is:"+ls.getAutoLockStts());
			
				ls.clickAutoLockButton();
				Thread.sleep(3000);
				//confirm or condition for iOS
				/*if(al.getAutoDelayStatus().equals("Off") || al.getAutoDelayStatus().contentEquals("0")) {
					al.clickAutoLock();
				}*/
				al.set_10min_Delay();
				if(device.equals("android")) {
					al.clickBackButton();
				}
				Thread.sleep(20000);
				ls.getAutoLockStts();
				Log.addMessage("Auto lock status of the door after update is:"+ls.getAutoLockStts());
			
			Assert.assertTrue(true,"Auto Lock status displayed");
		}catch(Exception e) {
			 Log.addMessage("Failed to display auto lock status");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to display auto lock status");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void viewLEDStatusTest() {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			System.out.println("In viewLEDStatusTest");
			System.out.println("Wait for BLE ON and Wifi ON");
			Thread.sleep(27000);
			//ls.getLEDStatus();
			Log.addMessage("Lock LED status of the door is:"+ls.getLEDStatus());
			ls.clickLEDStatusButton();
			Thread.sleep(20000);
			LockSettingsPage ls1 = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			Log.addMessage("Lock LED status of the door after update is:"+ls1.getLEDStatus());
			Thread.sleep(3000);
			Assert.assertTrue(true,"LED status of the door displayed");
		}catch(Exception e) {
			 Log.addMessage("Failed to display LED status");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to display LED status");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void viewLEDStatusBLEOffTest() {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			System.out.println("Wait for BLE Off");
			Thread.sleep(27000);
			//ls.getLEDStatus();
			Log.addMessage("Lock LED status of the door is:"+ls.getLEDStatus());
			ls.clickLEDStatusButton();
			Thread.sleep(20000);
			LockSettingsPage ls1 = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			Log.addMessage("Lock LED status of the door after update is:"+ls1.getLEDStatus());
			Thread.sleep(3000);
			Assert.assertTrue(true,"LED status of the door displayed");
		}catch(Exception e) {
			 Log.addMessage("Failed to display LED status");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to display LED status");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void viewLEDStatusWifiOffTest() {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			System.out.println("Wait for Wifi Off and BLE ON");
			Thread.sleep(27000);
			if(device.equals("android")) {
				ls.clickCancelButton();
			}
			//ls.getLEDStatus();
			Log.addMessage("Lock LED status of the door is:"+ls.getLEDStatus());
			ls.clickLEDStatusButton();
			Thread.sleep(20000);
			LockSettingsPage ls1 = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			Log.addMessage("Lock LED status of the door after update is:"+ls1.getLEDStatus());
			Thread.sleep(3000);
			Assert.assertTrue(true,"LED status of the door displayed");
		}catch(Exception e) {
			 Log.addMessage("Failed to display LED status");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to display LED status");
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
			//commented on 23-06-2020
			/*LockNamePage ln = new LockNamePage((AppiumDriver<MobileElement>) driver);
			//check where the page redirects after lock name update
			ln.clickBkButton();*/
			System.out.println("Wait for Wifi ON and BLE ON to Delete Lock");
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
	
	@DataProvider(name = "hmLkName")
	public Object[][] getData() throws Exception {
		return excel.getTableArray(InputData, "Validation", "ValFPLockName");
	}
	
	@DataProvider(name = "noAccess")
	public Object[][] getDataNoAccess() throws Exception {
		return excel.getTableArray(InputData, "App", "NoAccessPopUp");
	}
	
	@DataProvider(name = "fpSyncPopup")
	public Object[][] getDataSync() throws Exception {
		return excel.getTableArray(InputData, "App", "fpSyncingPopup");
	}


}
