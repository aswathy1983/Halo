package tests.app;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.app.BLEPopUpPage;
import pages.app.BLEPopUpiOSPage;
import pages.app.ConfirmDeleteLockPage;
import pages.app.EditAccessCodePage;
import pages.app.EnterWiFiPasswordPage;
import pages.app.FPAddFailPopUpPage;
import pages.app.FPUserScheduleTypePage;
import pages.app.FactoryResetPopUpPage;
import pages.app.FingerPrintEnrollmentPage;
import pages.app.HelpFAQPage;
import pages.app.LockAddNotCompletedPopupPage;
import pages.app.LockAddSuccessPopupPage;
import pages.app.LockCancelPopupPage;
import pages.app.LockDashboardPage;
import pages.app.LockEventHistoryPage;
import pages.app.LockNamePage;
import pages.app.LockNextPage1;
import pages.app.LockNextPage2;
import pages.app.LockSettingsPage;
import pages.app.ManageHomesPage;
import pages.app.ManualSetupPage;
import pages.app.MenuFlyoutPage;
import pages.app.SearchLocksPage;
import pages.app.TestConnectionPage;
import pages.app.ViewAccessCodesPage;
import pages.app.WiFiInstructionPage;
import pages.app.WiFiLockActivationPage;
import pages.app.WiFiScanningPage;
import pages.app.WifiPopUpPage;
import pages.app.WifiScanCancelPopupPage;
import utility.ExcelRead;
import utility.Log;
import utility.Utility;



public class AddFingerPrintLockTest extends Settings{
	
	String lkText ="";
	int lkcnt, sbcnt, timecnt, lstCnt, totalCount= 0;
	String[][] eventList =null;
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyLockImageTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			ld.verifyAddLockImage();
			Log.addMessage("Lock Image present in Manage Home");
		}catch(Exception e) {
			Log.addMessage("Lock Image not present in Manage Home");
			e.printStackTrace();
			Assert.assertTrue(false, "Lock Image not present Manage Home");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyLockImageInMenu() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			ld.clickHamburgerButton();
			mf.verifyLockImageInMenu();
			
			Log.addMessage("Lock image present in dashboard");
			
		}catch(Exception e) {
			Log.addMessage("Lock Image not present in dashboar");
			e.printStackTrace();
			Assert.assertTrue(false, "Lock Image not present in dashboar");
		}
	}
	
	@SuppressWarnings("unchecked")
	
	@Test
	public void clickLockImageInMenu() {
		try {
			MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			mf.clickLockImageInMenu("hl");
			Log.addMessage("Lock image clicked from dashboard");
			
		}catch(Exception e) {
			Log.addMessage("Lock Image not clicked from dashboar");
			e.printStackTrace();
			Assert.assertTrue(false, "Lock Image not clicked from dashboar");
		}
	}
		
	@SuppressWarnings("unchecked")
	//updated on 22-05-2020
	@Test(dataProvider="blePopup")
	public void verifyBLEPopUpVerbiage(String titleMsg,String mainMsg, String iosMsg) {
		try {
			Utility.simpleWait(6000);
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			ld.clickAddLockButton();
			BLEPopUpPage bp = new BLEPopUpPage((AppiumDriver<MobileElement>) driver);
			
			bp.verifyPopUpVerbiage(titleMsg, mainMsg, iosMsg);
			//bp.verifySettingsButton();
			bp.clickCancelButton();
			Log.addMessage("BLE pop up verified");
		}catch(Exception e) {
			Log.addMessage("Failed to verify BLE pop up");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify BLE pop up");
		}
	}
	
	
	
	//Method for checking BLE popup verbiage for iOS
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="iblefirstPopup")
	public void verifyLaunchBLEPopUpVerbiage(String mainMsg) {
		try {
			Utility.simpleWait(6000);
			
			BLEPopUpiOSPage bp = new BLEPopUpiOSPage((AppiumDriver<MobileElement>) driver);
			
			bp.verifyPopUpVerbiage(mainMsg);
			//bp.verifySettingsButton();
			bp.clickCloseButton();
			Log.addMessage("BLE pop up verified");
		}catch(Exception e) {
			Log.addMessage("Failed to verify BLE pop up");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify BLE pop up");
		}
	}
	
	
	@SuppressWarnings("unchecked")
	
	@Test(dataProvider="wifiPopup")
	public void verifyWifiPopUpVerbiage(String titleMsg,String mainMsg, String iosMsg) {
		try {
			Utility.simpleWait(6000);
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			ld.clickAddLockButton();
			WifiPopUpPage wp = new WifiPopUpPage((AppiumDriver<MobileElement>) driver);
			
			wp.verifyPopUpVerbiage(titleMsg, mainMsg, iosMsg);
			//wp.verifySettingsButton();
			wp.clickCancelButton();
			Log.addMessage("Wifi pop up verified");
		}catch(Exception e) {
			Log.addMessage("Failed to verify Wifi pop up");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify Wifi pop up");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void addLockTest() {
		try {
			System.out.println("Wait for deleting lock from BLE pairing");
			Thread.sleep(10000);
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			ld.clickAddLockButton();
			LockNextPage1 ln1 =new LockNextPage1((AppiumDriver<MobileElement>) driver); 
			ln1.clickNext();
			LockNextPage2 ln2 =new LockNextPage2((AppiumDriver<MobileElement>) driver); 
			ln2.clickNext();
			Log.addMessage("Clicked next button");
		}catch(Exception e) {
			Log.addMessage("Failed to click next Button");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click next Button");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void moveNextTest() {
		try {
			LockNextPage2 ln2 =new LockNextPage2((AppiumDriver<MobileElement>) driver); 
			ln2.clickNext();
			Log.addMessage("Clicked next button");
		}catch(Exception e) {
			Log.addMessage("Failed to click next Button");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click next Button");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void selectLockTest() {
		try {
			Thread.sleep(3000);
			SearchLocksPage sl = new SearchLocksPage((AppiumDriver<MobileElement>) driver);
			
			sl.selectLockoneCell();
			
		}catch(Exception e) {
			Log.addMessage("Failed to select lock");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to select Lock");
		}
	}
	
	//check factory reset popup
	@SuppressWarnings("unchecked")
	@Test(dataProvider="factoryRstPopup")
	public void factoryResetPopUpVerbiageTest(String expTitle, String expMessage) {
		try {
			FactoryResetPopUpPage fr = new FactoryResetPopUpPage((AppiumDriver<MobileElement>) driver);
			fr.verifyPopUpVerbiage(expTitle, expMessage);
			Log.addMessage("Factory reset Pop Up verbiage is matching");
		}catch(Exception e) {
			Log.addMessage("Factory reset Pop Up verbiage is matching");
			e.printStackTrace();
			Assert.assertTrue(false, "Factory reset Pop Up verbiage is matching");
			
		}
	}
	
	@SuppressWarnings("unchecked")
	
	@Test
	public void factoryResetPopUpTest() {
		try {
			FactoryResetPopUpPage fr = new FactoryResetPopUpPage((AppiumDriver<MobileElement>) driver);
			fr.clickOKButton();
			Log.addMessage("Clicked OK button in factory reset pop up");
			Thread.sleep(70000);
			Log.addMessage("Waited for user to do factory reset");
			
			moveNextTest();
			Log.addMessage("Clicked next button from select A button in the lock add page");
		}catch(Exception e) {
			Log.addMessage("Failed to click OK button in factory reset pop up");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click OK button in factory reset pop up");
			
		}
	}
	//finish factory popup test
	
	//after factory reset again click Back, Next and select no try again/back buttons
	@SuppressWarnings("unchecked")
	
	@Test
	public void navBackTest() {
		try {
			//Thread.sleep(50000);
			TestConnectionPage tc = new TestConnectionPage((AppiumDriver<MobileElement>) driver);
			//moveNextTest();
			//Log.addMessage("Clicked Next button");
			
			selectLockTest(); // commented on 08-05-2020 as factory reset popup unavailable
			Log.addMessage("Selected one lock");
			
			tc.clickBackButton();
			Log.addMessage("Clicked Back button from Test Connection page");
			SearchLocksPage sl = new SearchLocksPage((AppiumDriver<MobileElement>) driver);
			sl.clickBackButton();
			Log.addMessage("Clicked Back button from Search Locks page");
		}catch(Exception e) {
			Log.addMessage("Failed to click Back button");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click Back button");
			
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void helpFaqTest() {
		try {
			Thread.sleep(3000);
			TestConnectionPage tc = new TestConnectionPage((AppiumDriver<MobileElement>) driver);
			//moveNextTest();//commented on 10-05-2020 for testing without factory reset pop up
			Log.addMessage("Clicked Next button");
			//selectLockTest();//commented on 10-05-2020 for testing without factory reset pop up
			Log.addMessage("Selected one lock");
			tc.clickHelpFaqButton();
			Log.addMessage("Clicked Help/Faq button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Help/Faq button");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click Help/Faq again button");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void helpFaqBackTest() {
		try {
			Thread.sleep(15000);
			HelpFAQPage hf = new HelpFAQPage((AppiumDriver<MobileElement>) driver);
			hf.clickBackButton();
			
			Log.addMessage("Clicked Help/FAQ back button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Help/FAQ back buttonn");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click Help/FAQ back buttonn");
			
		}
	}
	
	@SuppressWarnings("unchecked")
	
	@Test
	public void clickTryAgainTest() {
		try {
			TestConnectionPage tc = new TestConnectionPage((AppiumDriver<MobileElement>) driver);
			//moveNextTest();
			tc.clickTryAgainButton();
			Log.addMessage("Clicked No try again button");
			Thread.sleep(5000);
			selectLockTest();
			Log.addMessage("Selected one lock listed");
			//Thread.sleep(5000);
			//connectionTest();
			
		}catch(Exception e) {
			Log.addMessage("Failed to click No try again button");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click No try again button");
			
		}
	}
	
	@SuppressWarnings("unchecked")
	
	@Test
	public void connectionWifiOffTest() {
		try {
			TestConnectionPage tc = new TestConnectionPage((AppiumDriver<MobileElement>) driver);
			tc.clickYesButton();
			Log.addMessage("Clicked Yes button");
			if (device.equals("iOS")) {//added on 20-05-2020
				System.out.println("clicked yes second time");
				Thread.sleep(2000);
				System.out.println("pair second time");
				tc.clickPairButton();
				System.out.println("clicked pair button second time");
							
			}
			Thread.sleep(12000);
			//commented on 11-05-2020 to avoid wifi off test as its going to timeout error
			
			/*Thread.sleep(7000);
			Log.addMessage("Wait to switch wifi off before clicking Yes button");
			
			WifiPopUpPage wp = new WifiPopUpPage((AppiumDriver<MobileElement>) driver);
			
			wp.clickCancelButton();
			Log.addMessage("Wifi pop up observed");
			Log.addMessage("Clicked cancel button in wifi off popup");
			Thread.sleep(2000);
			Log.addMessage("Wait to switch wifi on before clicking Yes button");*/
			//tc.clickYesButton();
			
		}catch(Exception e) {
			Log.addMessage("Failed to click Yes button with Wifi Off");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click Yes button with Wifi Off");
			
		}
	}
	
	@Test
	public void connectAgainTest() {
		try {
			//wait to reach this page
			Thread.sleep(10000);
			selectLockTest();
			Thread.sleep(5000);
			connectionTest();
			
		}catch(Exception e) {
			Log.addMessage("Failed to select lock");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to select lock ");
		}
	}

	@SuppressWarnings("unchecked")
	
	@Test
	public void connectionTest() {
		try {
			TestConnectionPage tc = new TestConnectionPage((AppiumDriver<MobileElement>) driver);
			tc.clickYesButton();
			if (device.equals("iOS")) {//added on 20-05-2020
				
				System.out.println("clicked yes second time");
				Thread.sleep(2000);
				System.out.println("pair second time");
				tc.clickPairButton();
				System.out.println("clicked pair button second time");
				
			}
			Thread.sleep(12000);
			
			Log.addMessage("Clicked Yes button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Yes button");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click Yes button");
			
		}
	}
	
@SuppressWarnings("unchecked")
	
	@Test
	public void connectioniOSTest() {
		try {
			TestConnectionPage tc = new TestConnectionPage((AppiumDriver<MobileElement>) driver);
			tc.clickYesButton();
			if (device.equals("iOS")) {//added on 18-05-2020
				//Testing the Cancel button functionality
				Thread.sleep(2000);
				tc.clickCancelButton();
				Thread.sleep(2000);
				tc.clickOkButton();
				Thread.sleep(2000);/*commented for reducing delay on 19-05-2020*/
				//tc.clickOkButton();
				//Again add lock after ok and manually remove device from BLE device list
				Thread.sleep(12000);
				addLockTest();
				selectLockTest();
				System.out.println("selected lock second time");
				
				System.out.println("lock second time");/*commented for reducing delay on 19-05-2020*/
				TestConnectionPage tc2 = new TestConnectionPage((AppiumDriver<MobileElement>) driver);
				tc2.clickYesButton();/*commented for reducing delay on 19-05-2020*/
				System.out.println("clicked yes second time");
				Thread.sleep(2000);
				System.out.println("pair second time");
				tc2.clickPairButton();
				System.out.println("clicked pair button second time");
				
			}
			Thread.sleep(12000);
			
			Log.addMessage("Clicked Yes button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Yes button");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click Yes button");
			
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void clearLockNameTextTest() {
		try {
			Thread.sleep(3000);
			LockNamePage ln = new LockNamePage((AppiumDriver<MobileElement>) driver);
			System.out.println("in lockname clear test");
			ln.verifyClearButton();
			Log.addMessage("Clear Text button is working");
		}catch(Exception e) {
			Log.addMessage("Failed to display submit button");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display submit button");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="lkcnclPopup")
	public void verifyLockBackButtonTest(String titleMsg,String contentMsg) {
		try {
			Thread.sleep(10000);
			System.out.println("in lock back button");
			LockNamePage ln = new LockNamePage((AppiumDriver<MobileElement>) driver);
			ln.clickBkButton();
			Log.addMessage("Clicked back button in the lock name page");
			LockCancelPopupPage lc = new LockCancelPopupPage((AppiumDriver<MobileElement>) driver);
			lc.verifyPopUpVerbiage(titleMsg,contentMsg);
			Log.addMessage("Displayed cancel pop up from lock name page");
			Log.addMessage("Pop up verbiage is matching");
			lc.displayOkButton();
			Log.addMessage("Displayed OK button in the popup");
			lc.clickCancelButton();
			Log.addMessage("Displayed Cancel button in the wifi scanning cancel popup");
			Log.addMessage("Clicked cancel button from popup");
			
			//verifyLockImageTest();//commented on 10-05-2020 as not verifying OK functionality
			Log.addMessage("Lock Back button functionality verified");
		}catch(Exception e) {
			Log.addMessage("Lock Back button functionality failed");
			e.printStackTrace();
			Assert.assertTrue(false, "Lock Back button functionality failed");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="IlkcnclPopup")
	public void verifyLockBackButtoniOSTest(String titleMsg,String contentMsg) {
		try {
			Utility.simpleWait(10000);
			System.out.println("in lock back button");
			LockNamePage ln = new LockNamePage((AppiumDriver<MobileElement>) driver);
			Utility.simpleWait(2000);
			System.out.println("in lock back button");
			ln.clickBkButton();
			Utility.simpleWait(3000);
			Log.addMessage("Clicked back button in the lock name page");
			LockCancelPopupPage lc = new LockCancelPopupPage((AppiumDriver<MobileElement>) driver);
			lc.verifyPopUpVerbiage(titleMsg,contentMsg);
			Log.addMessage("Displayed cancel pop up from lock name page");
			Log.addMessage("Pop up verbiage is matching");
			lc.displayOkButton();
			Log.addMessage("Displayed Yes button in the popup");
			lc.clickCancelButton();
			Log.addMessage("Displayed Cancel button in the wifi scanning cancel popup");
			Log.addMessage("Clicked cancel button from popup");
			
			Log.addMessage("Lock Back button functionality verified");
		}catch(Exception e) {
			Log.addMessage("Lock Back button functionality failed");
			e.printStackTrace();
			Assert.assertTrue(false, "Lock Back button functionality failed");
		}
	}
	
	@Test
	public void validLockAddTest() {
		try {
			addLockTest();
			
			selectLockTest();
			Thread.sleep(5000);
			connectionTest();
			
		}catch(Exception e) {
			Log.addMessage("Failed to enter lock name");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to enter lock name");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void valdtLockNameTest() {
		try {
			Thread.sleep(10000);
			
			System.out.println("in test");
			LockNamePage ln = new LockNamePage((AppiumDriver<MobileElement>) driver);
			System.out.println("set name");
			if(device.equals("iOS")) {
				System.out.println("submit name ios");
				ln.enterLockNameiOS("Front Door");
				System.out.println("after submit name ios");
			}else {
				ln.enterLockName("Front Door");
				System.out.println("submit name");
				//ln.clickSubmitButton();
			}
			System.out.println("done");
			Thread.sleep(6000);
			Log.addMessage("Lock name added");
			
		}catch(Exception e) {
			Log.addMessage("Failed to enter lock name");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to enter lock name");
		}
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="hmLkName")
	public void lockNameTest(String lockname, String expMessage) {
		try {
			LockNamePage ln = new LockNamePage((AppiumDriver<MobileElement>) driver);
			ln.valLockName(lockname, expMessage);
			Log.addMessage("lock name validated");
			
		}catch(Exception e) {
			Log.addMessage("Failed to enter lock name");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to enter lock name");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="hmILkName")
	public void lockNameIosTest(String lockname, String expMessage) {
		try {
			LockNamePage ln = new LockNamePage((AppiumDriver<MobileElement>) driver);
			ln.valLockName(lockname, expMessage);
			Log.addMessage("lock name validated");
			
		}catch(Exception e) {
			Log.addMessage("Failed to enter lock name");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to enter lock name");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="WifiInstr")
	public void readWiFiInstructionTest(String titleMsg, String expMsg1, String expMsg2) {
		try {
			WiFiInstructionPage wi = new WiFiInstructionPage((AppiumDriver<MobileElement>) driver);
			wi.clickBackButton();
			Log.addMessage("Clicked Back button of Wifi Instruction page");
			Thread.sleep(3000);
			valdtLockNameTest();
			Log.addMessage("Came back after first Back test");
			Thread.sleep(3000);
			wi.verifyWifiInstructionVerbiage(titleMsg, expMsg1, expMsg2);
			Log.addMessage("WifiInstructionVerbiage success");
			Thread.sleep(3000);
			wi.clickNextButton();
			Log.addMessage("Clicked Next button of Wifi Instruction page");
		}catch(Exception e) {
			Log.addMessage("Failed to read WiFi Instructions");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to read WiFi Instructions");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="IWifiInstr")
	public void readWiFiInstructioniOSTest(String titleMsg, String expMsg1, String expMsg2) {
		try {
			WiFiInstructionPage wi = new WiFiInstructionPage((AppiumDriver<MobileElement>) driver);
			wi.clickBackButton();
			Log.addMessage("Clicked Back button of Wifi Instruction page");
			Thread.sleep(3000);
			valdtLockNameTest();
			Log.addMessage("Came back after first Back test");
			Thread.sleep(3000);
			wi.verifyiOSWifiInstructionVerbiage(titleMsg, expMsg1, expMsg2);
			Log.addMessage("WifiInstructionVerbiage success");
			Thread.sleep(3000);
			wi.clickNextButton();
			Log.addMessage("Clicked Next button of Wifi Instruction page");
		}catch(Exception e) {
			Log.addMessage("Failed to read WiFi Instructions");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to read WiFi Instructions");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void readWiFiInstrTest() {
		try {
			WiFiInstructionPage wi = new WiFiInstructionPage((AppiumDriver<MobileElement>) driver);
			Thread.sleep(6000);
			wi.clickNextButton();
			Log.addMessage("Clicked Next button of Wifi Instruction page");
		}catch(Exception e) {
			Log.addMessage("Failed to read WiFi Instructions");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to read WiFi Instructions");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void selectWiFiHotSpotTest() {
		try {
			Thread.sleep(8000);
			System.out.println("in hotspot list");
			WiFiScanningPage ws = new WiFiScanningPage((AppiumDriver<MobileElement>) driver);
			ManualSetupPage ms = new ManualSetupPage((AppiumDriver<MobileElement>) driver);
			WifiScanCancelPopupPage wp = new WifiScanCancelPopupPage((AppiumDriver<MobileElement>) driver);
			
			ws.clickReScanButton();
			Log.addMessage("Clicked ReScan button in Wifi Scanning page");
			Thread.sleep(50000);
			
			
			ws.clickCancelButton();
			Log.addMessage("Clicked Cancel button in Wifi Scanning page");
			
			Thread.sleep(2000);
			wp.clickCancelButton();
			Log.addMessage("Clicked Cancel button in Cancel popup page");
			
			//commented on 08-05 for retesting without delay
			
			ws.clickManualSetupButton();
			Log.addMessage("Clicked Manual setup in Wifi Scanning page");
			ms.clickBackButton();
			Log.addMessage("Clicked Back button from Manual setup page");
			Thread.sleep(50000);
			ws.listAllHotSpot();
			Log.addMessage("Listed the hotspots");
			ws.selectFirstHotSpot();
			Log.addMessage("Clicked first hot spot listed in Wifi Scanning page");
		}catch(Exception e) {
			Log.addMessage("Failed to select Hotspot");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to select Hotspot");
		}
	}
		//added on 19-05-2020
		@SuppressWarnings("unchecked")
		@Test
		public void selectWiFiHotSpotiOSTest() {
			try {
				Thread.sleep(25000);
				System.out.println("in hotspot list");
				WiFiScanningPage ws = new WiFiScanningPage((AppiumDriver<MobileElement>) driver);
				ManualSetupPage ms = new ManualSetupPage((AppiumDriver<MobileElement>) driver);
				WifiScanCancelPopupPage wp = new WifiScanCancelPopupPage((AppiumDriver<MobileElement>) driver);
				
				
				ws.clickCancelButton();
				Log.addMessage("Clicked Cancel button in Wifi Scanning page");
				
				Thread.sleep(2000);
				wp.clickCancelButton();
				Log.addMessage("Clicked Cancel button in Cancel popup page");
				
				Thread.sleep(2000);
				ws.clickManualSetupiOSButton();//changed the function on 19-05-2020
				Log.addMessage("Clicked Manual setup in Wifi Scanning page");
				ms.clickBackButton();
				Log.addMessage("Clicked Back button from Manual setup page");
				Thread.sleep(30000);
				
				//added Rescan on 19-05-2020 for iOS
				
				ws.clickReScanButton();
				Log.addMessage("Clicked ReScan button in Wifi Scanning page");
				Thread.sleep(20000);
				ws.listAllHotSpot();
				Log.addMessage("Listed the hotspots");
				ws.selectFirstHotSpot();
				Log.addMessage("Clicked first hot spot listed in Wifi Scanning page");
			}catch(Exception e) {
				Log.addMessage("Failed to select Hotspot");
				e.printStackTrace();
				Assert.assertTrue(false, "Failed to select Hotspot");
			}
	}
	
		@SuppressWarnings("unchecked")
		@Test
		public void selWiFiHotSpotiOSTest() {
			try {
				Thread.sleep(25000);
				System.out.println("in hotspot list");
				WiFiScanningPage ws = new WiFiScanningPage((AppiumDriver<MobileElement>) driver);
				WifiScanCancelPopupPage wp = new WifiScanCancelPopupPage((AppiumDriver<MobileElement>) driver);
				
				ws.clickCancelButton();
				Log.addMessage("Clicked Cancel button in Wifi Scanning page");
				
				Thread.sleep(2000);
				wp.clickCancelButton();
				Log.addMessage("Clicked Cancel button in Cancel popup page");
				
				Thread.sleep(20000);
				ws.listAllHotSpot();
				Log.addMessage("Listed the hotspots");
				ws.selectFirstHotSpot();
				Log.addMessage("Clicked first hot spot listed in Wifi Scanning page");
			}catch(Exception e) {
				Log.addMessage("Failed to select Hotspot");
				e.printStackTrace();
				Assert.assertTrue(false, "Failed to select Hotspot");
			}
		}
	@SuppressWarnings("unchecked")
	@Test
	public void selWiFiHotSpotTest() {
		try {
			Thread.sleep(8000);
			System.out.println("in hotspot list");
			WiFiScanningPage ws = new WiFiScanningPage((AppiumDriver<MobileElement>) driver);
			WifiScanCancelPopupPage wp = new WifiScanCancelPopupPage((AppiumDriver<MobileElement>) driver);
			//ManualSetupPage ms = new ManualSetupPage((AppiumDriver<MobileElement>) driver);
			
			//commented on 08-05 for retesting without delay
			
			/*ws.clickManualSetupButton();
			Log.addMessage("Clicked Manual setup in Wifi Scanning page");
			ms.clickBackButton();
			Log.addMessage("Clicked Back button from Manual setup page");*/
			if(!device.equals("iOS")) {
				ws.clickReScanButton();
				Thread.sleep(50000);
			}else {
				Thread.sleep(25000);
			}
			ws.clickCancelButton();
			Log.addMessage("Clicked Cancel button in Wifi Scanning page");
			
			Thread.sleep(2000);
			wp.clickCancelButton();
			Log.addMessage("Clicked Cancel button in Cancel popup page");
			
			ws.listAllHotSpot();
			Log.addMessage("Listed the hotspots");
			ws.selectFirstHotSpot();
			Log.addMessage("Clicked first hot spot listed in Wifi Scanning page");
		}catch(Exception e) {
			Log.addMessage("Failed to select Hotspot");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to select Hotspot");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void passwordBackTest() {
		try {
			Thread.sleep(5000);
			EnterWiFiPasswordPage ew = new EnterWiFiPasswordPage((AppiumDriver<MobileElement>) driver);
			WiFiScanningPage ws = new WiFiScanningPage((AppiumDriver<MobileElement>) driver);
			ew.clickBackButton();
			Log.addMessage("Clicked Back button from Wifi Password page");
			Thread.sleep(50000);
			ws.selectFirstHotSpot();
			Log.addMessage("Clicked first hotspot");
			
		}catch(Exception e) {
			Log.addMessage("Failed to click back button");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click back button");
		}
	}
	//added on 19-05-2020
	@SuppressWarnings("unchecked")
	@Test
	public void passwordBackiOSTest() {
		try {
			Thread.sleep(5000);
			System.out.println("in wifi password back");
			EnterWiFiPasswordPage ew = new EnterWiFiPasswordPage((AppiumDriver<MobileElement>) driver);
			WiFiScanningPage ws = new WiFiScanningPage((AppiumDriver<MobileElement>) driver);
			ew.clickBackButton();
			Log.addMessage("Clicked Back button from Wifi Password page");
			Thread.sleep(20000);
			ws.selectFirstHotSpot();
			Log.addMessage("Clicked first hotspot");
			
		}catch(Exception e) {
			Log.addMessage("Failed to click back button");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click back button");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="WifiPwd")
	public void enterWiFiPasswordTest(String password, String tMsg, String errmsg) {
		try {
			Thread.sleep(5000);
			EnterWiFiPasswordPage ew = new EnterWiFiPasswordPage((AppiumDriver<MobileElement>) driver);
			ew.valPassword(password,tMsg,  errmsg);
			Log.addMessage("Entered Wifi Password");
			//ew.clickSubmitButton();
			Log.addMessage("Clicked Submit Password");
		}catch(Exception e) {
			Log.addMessage("Failed to select Hotspot");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to select Hotspot");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="IWifiPwd")
	public void enterWiFiPasswordiOSTest(String password, String tMsg, String errmsg) {
		try {
			Thread.sleep(5000);
			EnterWiFiPasswordPage ew = new EnterWiFiPasswordPage((AppiumDriver<MobileElement>) driver);
			ew.valPassword(password,tMsg,  errmsg);
			Log.addMessage("Entered Wifi Password");
			//ew.clickSubmitButton();
			Log.addMessage("Clicked Submit Password");
		}catch(Exception e) {
			Log.addMessage("Failed to select Hotspot");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to select Hotspot");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="valWifi")
	public void wiFiPasswordTest(String password) {
		try {
			Thread.sleep(5000);
			EnterWiFiPasswordPage ew = new EnterWiFiPasswordPage((AppiumDriver<MobileElement>) driver);
			ew.enterWiFiPassword(password);
			Log.addMessage("Entered Wifi Password");
			//if(device.contentEquals("iOS"))//check for iOS also commented on 27-05-2020
				//ew.clickSubmitButton();
			Log.addMessage("Clicked Submit Password");
		}catch(Exception e) {
			Log.addMessage("Failed to enter Password");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to enter Password");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="chLst")
	public void lockActivationTest(String chkList1, String chkList2, String chkList3, String chkList4) {
		try {
			Thread.sleep(30000);
			WiFiLockActivationPage wa = new WiFiLockActivationPage((AppiumDriver<MobileElement>) driver);
			
			//changed on 10-05-2020
			wa.verifyCheckList(chkList1, chkList2, chkList3, chkList4);
			
			
			Thread.sleep(5000);
			
			
		}catch(Exception e) {
			Log.addMessage("Failed to display all checklist");
			e.printStackTrace();
			Assert.assertTrue(false, "Lock Activation failed");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="ichLst")
	public void lockActivationiOSTest(String chkList1, String chkList2, String chkList3, String chkList4) {
		try {
			Thread.sleep(20000);
			System.out.println("inside lock activation");
			WiFiLockActivationPage wa = new WiFiLockActivationPage((AppiumDriver<MobileElement>) driver);
			
			//changed on 10-05-2020
			wa.verifyiOSCheckList(chkList1, chkList2, chkList3, chkList4);
			
			
			Thread.sleep(5000);
			
			
		}catch(Exception e) {
			Log.addMessage("Failed to display all checklist");
			e.printStackTrace();
			Assert.assertTrue(false, "Lock Activation failed");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="sucsPopup")
	public void lockActvtnSuccessPopupTest(String title, String msg) {
		try {
			
			LockAddSuccessPopupPage la = new LockAddSuccessPopupPage((AppiumDriver<MobileElement>) driver);
			System.out.println("Lock Add Success popup");
			Thread.sleep(5000);
			la.verifyPopUpVerbiage(title,msg);
			la.clickOkButton();
			Thread.sleep(3000);
			Log.addMessage("Lock Activation success popup displayed and clicked OK button");
			
		}catch(Exception e) {
			Log.addMessage("Failed to display lock activation success popup");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display lock activation success popup");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void lockActivationKillReLaunchTest() {
		try {
			Thread.sleep(30000);
			appiumDriver.terminateApp("com.kwikset.blewifi.dev");
			
			System.out.println("after quit");
			
			appiumDriver.activateApp("com.kwikset.blewifi.dev");
			
			System.out.println("after re-launch");
			
			LockAddNotCompletedPopupPage la = new LockAddNotCompletedPopupPage((AppiumDriver<MobileElement>) driver);
			
			la.clickCancelButton();
			System.out.println("Clicked Cancel in popup");
			
			Log.addMessage("Application relaunch success");
			Thread.sleep(5000);
			//wa.clickOKButton();
		}catch(Exception e) {
			Log.addMessage("Failed to kill and re-launch the app");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to kill and re-launch the app");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void lockActivationImageTest() {
		try {
			Thread.sleep(10000);
			WiFiLockActivationPage wa = new WiFiLockActivationPage((AppiumDriver<MobileElement>) driver);
			wa.verifyCheckListImg();
			Log.addMessage("All checklist tick marks are verified");
			
			Thread.sleep(5000);
		}catch(Exception e) {
			Log.addMessage("Failed to display all checklist tick marks");
			e.printStackTrace();
			Assert.assertTrue(false, "Lock Activation failed tick marks");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void lockAddSchTypeElementsPresentTest() {
		try {
			Thread.sleep(7000);
			FPUserScheduleTypePage fs = new FPUserScheduleTypePage((AppiumDriver<MobileElement>) driver);
			
			if(!device.equals("iOS")) {
				fs.displayBackButton();
			}
			fs.displaySubmit();
			
			if(fs.getUserName()!="" && fs.getUserName()!="ex. John or Dog Sitter") {
				Log.addMessage("User name populated with text "+fs.getUserName());
			}else {
				Log.addMessage("User name text is empty.");
			}
			fs.labelScheduleVisible();
			
			Log.addMessage("Schedule type displayed");
			Log.addMessage("All elements are displayed");
			
			Thread.sleep(5000);
			
		}catch(Exception e) {
			Log.addMessage("Failed to display all checklist tick marks");
			e.printStackTrace();
			Assert.assertTrue(false, "Lock Activation failed tick marks");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="schUserName")
	public void valScheduleUserNameTest(String username, String tMsg, String errmsg) {
		try {
			Thread.sleep(5000);
			FPUserScheduleTypePage fs = new FPUserScheduleTypePage((AppiumDriver<MobileElement>) driver);
			fs.valUserName(username, tMsg, errmsg);
			Log.addMessage("Updated lock user's name");
			
		}catch(Exception e) {
			Log.addMessage("Failed to select Hotspot");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to select Hotspot");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="ischUserName")
	public void valScheduleUserNameiOSTest(String username, String errmsg) {
		try {
			Thread.sleep(5000);
			FPUserScheduleTypePage fs = new FPUserScheduleTypePage((AppiumDriver<MobileElement>) driver);
			
			fs.valUserNameiOS(username, errmsg);
			Log.addMessage("Updated lock users name");
			
		}catch(Exception e) {
			Log.addMessage("Failed to select Hotspot");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to select Hotspot");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void scheduleTypePageBackTest() {
		try {
			Thread.sleep(5000);
			FPUserScheduleTypePage fs = new FPUserScheduleTypePage((AppiumDriver<MobileElement>) driver);
			EditAccessCodePage ea = new EditAccessCodePage((AppiumDriver<MobileElement>) driver);
			
			fs.clickScheduleType();
			ea.clickBackButton();
			Thread.sleep(2000);
			fs.clickScheduleType();
			Thread.sleep(2000);
			
		}catch(Exception e) {
			Log.addMessage("Failed to update schedule type");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update schedule type");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void scheduleTypePageBackiOSTest() {
		try {
			Thread.sleep(2000);
			FPUserScheduleTypePage fs = new FPUserScheduleTypePage((AppiumDriver<MobileElement>) driver);
			EditAccessCodePage ea = new EditAccessCodePage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			//appiumDriver.hideKeyboard();
			System.out.println("hide keyboard");
			
			fs.clickBackButton();
			va.clickAddAccessCodeButton();
			Thread.sleep(3000);
			fs.clickScheduleType();
			System.out.println("clicked schedule type");
			ea.clickBackButton();
			Thread.sleep(2000);
			
		}catch(Exception e) {
			Log.addMessage("Failed to update schedule type");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update schedule type");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void valdtUserNameTest() {
		try {
			Thread.sleep(10000);
			
			System.out.println("in edit user name test");
			
			FPUserScheduleTypePage fs = new FPUserScheduleTypePage((AppiumDriver<MobileElement>) driver);
			System.out.println("set name");
			fs.editUserName("Test username1");
			System.out.println("submit name");
			fs.clickSubmitButton();
			System.out.println("done");
			Log.addMessage("User name updated");
			
		}catch(Exception e) {
			Log.addMessage("Failed to update user name");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update user name");
		}
	}
	@SuppressWarnings("unchecked")
	@Test
	public void editScheduleTypeTest() {
			try {
				Thread.sleep(5000);
				FPUserScheduleTypePage fs = new FPUserScheduleTypePage((AppiumDriver<MobileElement>) driver);
				EditAccessCodePage ea = new EditAccessCodePage((AppiumDriver<MobileElement>) driver);
				ea.clickAnyTimeButton();
				ea.clickOkButton();
				System.out.println("pop up closed");
				Thread.sleep(4000);
				if(fs.getSchType().equals("Any Time")) {
					Log.addMessage("Schedule Type updated to Any Time access");
				}else {
					Log.addMessage("Failed to update schedule type");
				}
				System.out.println("schtype");
				
				
			}catch(Exception e) {
				Log.addMessage("Failed to update user name");
				e.printStackTrace();
				Assert.assertTrue(false, "Failed to update user name");
			}
	}
	@SuppressWarnings("unchecked")
	@Test
	public void editScheduleTypeiOSTest() {
			try {
				//Thread.sleep(5000);
				FPUserScheduleTypePage fs = new FPUserScheduleTypePage((AppiumDriver<MobileElement>) driver);
				EditAccessCodePage ea = new EditAccessCodePage((AppiumDriver<MobileElement>) driver);
				fs.clickScheduleType();
				Utility.simpleWait(6000);
				ea.clickAnyTimeButton();
				
				System.out.println("pop up closed");
				Thread.sleep(4000);
				//FPUserScheduleTypePage fs2 = new FPUserScheduleTypePage((AppiumDriver<MobileElement>) driver);
				if(fs.getSchTypeiOS().equals("Any Time")) {
					Log.addMessage("Schedule Type updated to Any Time access");
				}else {
					Log.addMessage("Failed to update schedule type");
				}
				System.out.println("schtype");
				
				
			}catch(Exception e) {
				Log.addMessage("Failed to update user name");
				e.printStackTrace();
				Assert.assertTrue(false, "Failed to update user name");
			}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void fpEnrollmentPageDisplayTest() {
		try {
			Thread.sleep(7000);
			
			System.out.println("in fpEnrollmentPageDisplayTest");
			
			FingerPrintEnrollmentPage fs = new FingerPrintEnrollmentPage((AppiumDriver<MobileElement>) driver);
			System.out.println("set name");
			if(fs.getFPScanMessage().equals("Scan your fingerprint")) {
				Log.addMessage("Finger print enrollment page displayed");
			}else {
				Log.addMessage("Finger print enrollment page not displayed");
			}
			System.out.println("done scan message="+fs.getFPScanMessage());
			
			
		}catch(Exception e) {
			Log.addMessage("Failed to display Finger print enrollment page");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display Finger print enrollment page");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void fpEnrollmentPageDisplayiOSTest() {
		try {
			//Thread.sleep(3000);//changed from 5 sec to 3 sec
			
			System.out.println("in fpEnrollmentPageDisplayTest");
			
			FingerPrintEnrollmentPage fs = new FingerPrintEnrollmentPage((AppiumDriver<MobileElement>) driver);
			System.out.println("set name");
			if(fs.getFPScanMessage().equals("Scan your fingerprint")) {
				Log.addMessage("Finger print enrollment page displayed");
			}else {
				Log.addMessage("Finger print enrollment page not displayed");
			}
			System.out.println("done scan message="+fs.getFPScanMessage());
			
			
		}catch(Exception e) {
			Log.addMessage("Failed to display Finger print enrollment page");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display Finger print enrollment page");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void fpEnrollmentBackHomeTest() {
		try {
			FingerPrintEnrollmentPage fs = new FingerPrintEnrollmentPage((AppiumDriver<MobileElement>) driver);
			//FPUserScheduleTypePage ft= new FPUserScheduleTypePage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			System.out.println("set name");
			fs.clickBackButton();
			//Thread.sleep(1000);
			//ft.clickBackButton();
			//Thread.sleep(1000);
			va.clickBackButton();
			System.out.println("back button clicked");
			Thread.sleep(6000);
			
		}catch(Exception e) {
			Log.addMessage("Failed to display Finger print enrollment page");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display Finger print enrollment page");
		}
	}
	@SuppressWarnings("unchecked")
	@Test
	public void fpEnrollmentBackHomeiOSTest() {
		try {
			FingerPrintEnrollmentPage fs = new FingerPrintEnrollmentPage((AppiumDriver<MobileElement>) driver);
			FPUserScheduleTypePage ft= new FPUserScheduleTypePage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			System.out.println("set name");
			fs.clickBackButton();
			Thread.sleep(1000);
			ft.clickBackButton();
			Thread.sleep(1000);
			va.clickBackButton();
			System.out.println("back button clicked");
			Thread.sleep(2000);
			
		}catch(Exception e) {
			Log.addMessage("Failed to display Finger print enrollment page");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display Finger print enrollment page");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="fpFailPopup")
	public void fpAddFailPagePopupTest(String ttlMsg, String mainMsg) {
		try {
			Thread.sleep(2000);    
			
			System.out.println("in fp fail popup test");
			
			FPAddFailPopUpPage fp = new FPAddFailPopUpPage((AppiumDriver<MobileElement>) driver);
			FingerPrintEnrollmentPage fs = new FingerPrintEnrollmentPage((AppiumDriver<MobileElement>) driver);
			System.out.println("Finger print enrollment failed popup");
			
			fp.verifyPopUpVerbiage(ttlMsg,mainMsg);
			fp.verifyRetryButton();
			Thread.sleep(7000);
			fp.clickCancelButton();
			Thread.sleep(2000);
			fs.clickBackButton();
			Log.addMessage("Finger print enrollment failed popup displayed");
			
			System.out.println("done fp popup message");
			Thread.sleep(6000);
			
		}catch(Exception e) {
			Log.addMessage("Failed to display Finger print enrollment page");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display Finger print enrollment page");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="fpFailPopup")
	public void fpAddFailPagePopupiOSTest(String ttlMsg, String mainMsg) {
		try {
			Thread.sleep(2000);    
			
			System.out.println("in fp fail popup test");
			
			FPAddFailPopUpPage fp = new FPAddFailPopUpPage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			System.out.println("Finger print enrollment failed popup");
			
			fp.verifyPopUpVerbiage(ttlMsg,mainMsg);
			fp.verifyRetryButton();
			Thread.sleep(7000);
			fp.clickCancelButton();
			va.clickBackButton();
			Log.addMessage("Finger print enrollment failed popup displayed");
			
			System.out.println("done fp popup message");
			Thread.sleep(6000);
			
		}catch(Exception e) {
			Log.addMessage("Failed to display Finger print enrollment page");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display Finger print enrollment page");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void addFingerPrintAccessCodeTest() {
		try {
			//Thread.sleep(10000);
			
			System.out.println("in lock user name test");
			
			LockDashboardPage lp = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			
			System.out.println("set name");
			lp.clickAccessCodeButton();
			Thread.sleep(2000);
			va.clickAddAccessCodeButton();
			
			System.out.println("done");
			Thread.sleep(6000);
			Log.addMessage("Access Code button clicked");
			
		}catch(Exception e) {
			Log.addMessage("Failed to click access code button");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click access code button");
		}
	}
	@SuppressWarnings("unchecked")
	@Test
	public void userScheduleKeepIdleTest() {
		try {
			Log.addMessage("Application relaunch success");
			System.out.println("in idle");
			FPUserScheduleTypePage fp = new FPUserScheduleTypePage((AppiumDriver<MobileElement>) driver);
			fp.displaySubmit();
			System.out.println("confirm in user schedule page idle");
			Thread.sleep(30000);
			Log.addMessage("Keep idle for 60 secs");
			
		}catch(Exception e) {
			Log.addMessage("Failed to display timeout popup");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display timeout popup");
		}
	}
	
	@Test
	public void userNameKillReLaunchTest() {
		try {
			Thread.sleep(30000);
			if(device.equals("iOS")) {
				
				appiumDriver.terminateApp("com.spectrumhhi.ble-wifi");
				
				System.out.println("after quit iOS");
				
				appiumDriver.activateApp("com.spectrumhhi.ble-wifi");
				
				System.out.println("after re-launch iOS");
				
			}else {
				appiumDriver.terminateApp("com.kwikset.blewifi.dev");
				
				System.out.println("after quit");
				
				appiumDriver.activateApp("com.kwikset.blewifi.dev");
				
				System.out.println("after re-launch");
			}
			
			Log.addMessage("Application relaunch success");
			Thread.sleep(5000);
			
			//wa.clickOKButton();
		}catch(Exception e) {
			Log.addMessage("Failed to kill and re-launch the app");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to kill and re-launch the app");
		}
	}
	
	@Test
	public void userScheduleTypeKillReLaunchTest() {
		try {
			Thread.sleep(3000);
			if(device.equals("iOS")) {
				appiumDriver.terminateApp("com.spectrumhhi.ble-wifi");
				
				System.out.println("after quit iOS");
				
				appiumDriver.activateApp("com.spectrumhhi.ble-wifi");
				
				System.out.println("after re-launch iOS");
				
			}else {
				appiumDriver.terminateApp("com.kwikset.blewifi.dev");
				
				System.out.println("after quit");
				
				appiumDriver.activateApp("com.kwikset.blewifi.dev");
				
				System.out.println("after re-launch");
			}
			Log.addMessage("Application relaunch success");
			//Thread.sleep(5000);
			addFingerPrintAccessCodeTest();
			
		}catch(Exception e) {
			Log.addMessage("Failed to kill and re-launch the app");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to kill and re-launch the app");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void valdtAnyTimeAccessTest() {
		try {
			Thread.sleep(1000);
			
			System.out.println("in edit user name test");
			
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			System.out.println("set name");
			//ld.getLockStatus();
			Log.addMessage("Lock of your door is "+ ld.getLockStatus());
			System.out.println("submit name");
			ld.clickLockUnlockButton();
			Thread.sleep(30000);
			ld.getLockStatus();
			Log.addMessage("Lock of your door after button click is "+ ld.getLockStatus());
			System.out.println("done");
			Log.addMessage("Lock accessibility verified");
			
		}catch(Exception e) {
			Log.addMessage("Failed to check Any Time lock accessibility");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to check Any Time lock accessibility");
		}
	}
	@SuppressWarnings("unchecked")
	@Test
	public void valdtAnyTimeAccessiOSTest() {
		try {
			Thread.sleep(1000);
			
			System.out.println("in edit user name test");
			
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			System.out.println("set name");
			//ld.getLockStatus();
			Log.addMessage("Lock of your door is :"+ ld.getLockStatus());
			System.out.println("submit name");
			ld.clickLockUnlockButtoniOS();
			Thread.sleep(30000);
			ld.getLockStatus();
			Log.addMessage("Lock of your door after button click is :"+ ld.getLockStatus());
			System.out.println("done");
			Log.addMessage("Lock accessibility verified");
			
		}catch(Exception e) {
			Log.addMessage("Failed to check Any Time lock accessibility");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to check Any Time lock accessibility");
		}
	}
	
		
	@SuppressWarnings("unchecked")
	@Test
	public void overlayMessageTest() {
		try {
			appiumDriver.terminateApp("com.kwikset.blewifi.dev");
			
			System.out.println("after quit");
			
			appiumDriver.activateApp("com.kwikset.blewifi.dev");
			
			System.out.println("after re-launch");
			Thread.sleep(20000);
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			
			ld.verifyOverLayMessage();
			System.out.println("after msg count");
			ld.displayNoAccessBanner();
			System.out.println("banner msg");
			Log.addMessage("Overlay messages verified");
			Log.addMessage("Lock Status of the added lock is :"+ld.getLockStatus());
			
			Thread.sleep(5000);
			System.out.println("end");
			//wa.clickOKButton();
		}catch(Exception e) {
			Log.addMessage("Failed to display Overlay messages");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display Overlay messages");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="menuHmName")
	public void deleteLockTest(String hmName) {
		try {
			Thread.sleep(20000);
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			//if(device.equals("android")) {//commented on 16-06-2020
				ld.clickHamburgerButton();
				Thread.sleep(2000);
				//mp.clickFPHomeNameInMenu(hmName);
				mp.clickLockImageInMenu("hl");
				Thread.sleep(5000);
			//}
			ld.clickLockSettingsButton();
			Thread.sleep(3000);
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			ConfirmDeleteLockPage cd = new ConfirmDeleteLockPage((AppiumDriver<MobileElement>) driver);
			System.out.println("after msg count");
			ls.clickDeleteLockButton();
			cd.deleteLock();
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			if(device.equals("iOS")) {
				mh.clickOkButton();
			}
			mh.clickBackButton();
			System.out.println("lock deleted");
			Log.addMessage("Lock deleted online");
			//if(device.equals("android")) {
				ld.clickHamburgerButton();
				Thread.sleep(2000);
				System.out.println("lock hmName="+hmName);
				mp.clickFPHomeNameInMenu(hmName);
				Thread.sleep(5000);
			//}
			ld.verifyDashboardWithNoLocks();
			Log.addMessage("Lock deletion verified in dashboard");
			Thread.sleep(5000);
			System.out.println("end");
		}catch(Exception e) {
			Log.addMessage("Failed to delete lock");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to delete lock");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="lockDelHistry")
	public void viewLockHistoryAfterDeleteTest(String lkEventName,String lkSubType, String lkTime, String lkiosTime, String lkiosEvent, String totCount) {
		 try {
			 LockEventHistoryPage le = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("Wait to delete ");
			 Thread.sleep(10000);//for testing in between
			 if(lkcnt==0) {
				 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
				 MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
				 if(device.equals("android")) {
					 ld.tapDashboardScreen();
				 }
			
				//if(device.equals("android")) {
					ld.clickHamburgerButton();
					Thread.sleep(2000);
					mp.clickLockImageInMenu("hl");
					Thread.sleep(2000);
				//}
				ld.clickLockHistoryButton();
				System.out.println("cnt");
				totalCount = Integer.parseInt(totCount) ;
				System.out.println("totalCount="+totalCount);
			 }
			 Thread.sleep(3000);
			 
			 if(lkSubType!="") {
				 sbcnt++;
			 }
			 if(lkTime!="") {
				 timecnt++;
			 }
			 lkcnt = lkcnt+1;
			
			 if(device.equals("iOS")) {
				 le.getFPLockEventHistoryiOSList(lkiosEvent, lkiosTime, lkcnt-1, sbcnt-1,timecnt-1,totalCount);
				 Thread.sleep(10000);
			 }else {
				 if(lstCnt==0) {
					 lstCnt = lstCnt+1;
					 eventList = le.getAllHistoryEvents(totalCount);
				 }
				
				 System.out.println("after storing data in an array size="+eventList.length);
				 le.getFPLockEventHistoryList(lkEventName, lkSubType, lkTime, lkcnt-1, sbcnt-1,timecnt-1,totalCount, eventList);
				 Thread.sleep(10000);
			 }
			
			 Log.addMessage("Previous Lock History is deleted and new lock add history listed");
		 }catch(Exception e) {
			 Log.addMessage("Failed to delete previous lock history");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to delete previous lock history");
		 }
	}
	

	
	ExcelRead excel = new ExcelRead();
	
	@DataProvider(name = "blePopup")
	public Object[][] getDataBLEPopup() throws Exception {
		return excel.getTableArray(InputData, "App", "Blepopup");
	}
	
	@DataProvider(name = "iblefirstPopup")
	public Object[][] getDataiOSfirstBLEPopup() throws Exception {
		return excel.getTableArray(InputData, "App", "Iblefirstpopup");
	}
	
	@DataProvider(name = "wifiPopup")
	public Object[][] getDataWifiPopup() throws Exception {
		return excel.getTableArray(InputData, "App", "Wifipopup");
	}
	
	@DataProvider(name = "factoryRstPopup")
	public Object[][] getDataFacRstPopup() throws Exception {
		return excel.getTableArray(InputData, "App", "FactoryPopup");
	}
	
	@DataProvider(name = "WifiInstr")
	public Object[][] getDataWifinstr() throws Exception {
		return excel.getTableArray(InputData, "App", "WifiInstruction");
	}
	
	@DataProvider(name = "IWifiInstr")
	public Object[][] getDataWifinstriOS() throws Exception {
		return excel.getTableArray(InputData, "App", "IwifiInstruction");
	}
	
	@DataProvider(name = "WifiPwd")
	public Object[][] getDataValWifiPwd() throws Exception {
		return excel.getTableArray(InputData, "Validation", "ValWifiPassword");
	}
	
	@DataProvider(name = "IWifiPwd")
	public Object[][] getDataValWifiPwdIos() throws Exception {
		return excel.getTableArray(InputData, "Validation", "IvalWifiPassword");
	}
	
	@DataProvider(name = "schUserName")
	public Object[][] getDataValSchUserName() throws Exception {
		return excel.getTableArray(InputData, "Validation", "ValEditUserNamePopup");
	}
	
	@DataProvider(name = "ischUserName")
	public Object[][] getDataiOSValSchUserName() throws Exception {
		return excel.getTableArray(InputData, "Validation", "IvalEditUserNamePopup");
	}
	
	@DataProvider(name = "valWifi")
	public Object[][] getDataWifiPwd() throws Exception {
		return excel.getTableArray(InputData, "App", "WifiPassword");
	}
	
	@DataProvider(name = "chLst")
	public Object[][] getDataChkList() throws Exception {
		return excel.getTableArray(InputData, "App", "Checklist");
	}
	
	@DataProvider(name = "ichLst")
	public Object[][] getDataIChkList() throws Exception {
		return excel.getTableArray(InputData, "App", "Ichecklist");
	}
	
	@DataProvider(name = "sucsPopup")
	public Object[][] getDataSuccessPopup() throws Exception {
		return excel.getTableArray(InputData, "App", "lockAddScsPopup");
	}
	
	@DataProvider(name = "fpFailPopup")
	public Object[][] getDataFPFailPopup() throws Exception {
		return excel.getTableArray(InputData, "App", "AddFPFail");
	}
	
	@DataProvider(name = "lkcnclPopup")
	public Object[][] getDataBLockCancelopup() throws Exception {
		return excel.getTableArray(InputData, "App", "lkCancelpopup");
	}
	
	@DataProvider(name = "IlkcnclPopup")
	public Object[][] getDataBLockCancelopupIos() throws Exception {
		return excel.getTableArray(InputData, "App", "IlkCancelpopup");
	}
	
	
	@DataProvider(name = "hmLkName")
	public Object[][] getData() throws Exception {
		return excel.getTableArray(InputData, "Validation", "ValLockName");
	}
	
	@DataProvider(name = "hmILkName")
	public Object[][] getDataIos() throws Exception {
		return excel.getTableArray(InputData, "Validation", "IvalLockName");
	}
	
	@DataProvider(name = "lockDelHistry")
	public Object[][] getDataLockHistoryiOS() throws Exception {
		return excel.getTableArray(InputData, "Validation", "fpLockDelHistory");
	}
	
	@DataProvider(name = "menuHmName")
	public Object[][] getDataName() throws Exception {
		return excel.getTableArray(InputData, "App", "MenuHomeName");
	}
	
}
