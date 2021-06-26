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
import pages.app.EditCodeNamePage;
import pages.app.LimitByDatePage;
import pages.app.LimitByWeekdayAndTimePage;
import pages.app.LockCancelPopupPage;
import pages.app.LockDashboardPage;
import pages.app.LockEventHistoryPage;
import pages.app.LockInfoPage;
import pages.app.LockNamePage;
import pages.app.LockSettingsPage;
import pages.app.ManageHomesPage;
import pages.app.MenuFlyoutPage;
import pages.app.PairedSmartPhoneListPage;
import pages.app.SelectScheduleTypePage;
import pages.app.SelectWeekDayPage;
import pages.app.UserFPAccessProfilePage;
import pages.app.ViewAccessCodesPage;
import utility.ExcelRead;
import utility.Log;
import utility.Utility;


public class HaloTouchLockTest extends Settings{
	
	int sbcnt, timecnt, lkcnt, cntPhone, namecnt = 0;
	String delayStts, updtdTimeflyout, updtdTimeDashboard = "";
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="adminLockPair")
	public void lockStatusAfterAcceptShareTest(String titleMsg, String valMsg) {
		try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 Utility.simpleWait(10000);
			 //check how to create the pair pop up on tapping lock status
			 ld.clickOKButton();
			 Utility.simpleWait(2000);
			 System.out.println("Lock Status after accepting share invitation is :"+ld.getLockStatus());
		}catch(Exception e) {
			Log.addMessage("Failed to get lock status after share invite accept");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to get lock status after share invite accept");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void viewLastUpdateTimeMenuFlyoutTest() throws InterruptedException {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			updtdTimeflyout="";
			updtdTimeDashboard="";
			System.out.println("in");
			ld.clickHamburgerButton();
			updtdTimeflyout = mp.getLastUpdateTime();
			System.out.println("updtdTimeflyout="+updtdTimeflyout);
			mp.clickLockImageInMenu("hl");
		}catch(Exception e) {
			Log.addMessage("Failed to display last updated time");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display last updated time");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void lockFunctionalityTest() throws InterruptedException {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			
			String status = ld.getLockStatus();
			if(status.equals("Locked")) {
				ld.unlockOperation();
				ld.lockOperation();
			}
			else if(status.equals("Unlocked")) {
				ld.lockOperation();
				//Utility.simpleWait(5000);/commented on 06-10-2020
				ld.unlockOperation();
				//Utility.simpleWait(5000);//commented on 06-10-2020
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
	public void viewLockHistoryTest() {
		try {
			 LockDashboardPage lp = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 LockEventHistoryPage le = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
			 lp.clickLockHistoryButton();
			 //Utility.simpleWait(5000);
			 le.verifyLockHistoryScreen();
		}catch(Exception e) {
			Log.addMessage("Failed to view access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to view access code");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void clearLockHistoryTest() {
		try {
			 LockEventHistoryPage le = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
			 LockCancelPopupPage lc = new LockCancelPopupPage((AppiumDriver<MobileElement>) driver);
			 //Utility.simpleWait(8000);//commented on 06-10-2020 for bvt
			 le.clearHistory();
			 //checkhow to handle if OK button not there
			 lc.clickOkButton();
			// Utility.simpleWait(8000);//commented on 06-10-2020 for bvt
			 le.clickBackButton();
		}catch(Exception e) {
			Log.addMessage("Failed to view access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to view access code");
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
			//Utility.simpleWait(15000);//for testing in btwn
			//le.clickBackButton();
			ld.clickLockSettingsButton();
			//Utility.simpleWait(8000);
			System.out.println("1");
			ls.waitForSettings();//check
			System.out.println("2");
			ls.clickEditLockNameButton();
			System.out.println("3");
			ln.setLockName(lockName);
			ln.clickSubmitButton();
			//Utility.simpleWait(8000);
			if(device.equals("android")) {
				ln.clickOkButton();
			}
			Log.addMessage("Lock name updated");
			//Utility.simpleWait(3000);//commented on 27th oct 2020 check
			ls.waitForSettings();
			System.out.println("locksound");
			ls.clickLockSoundsButton();
			Utility.simpleWait(25000);//didnt observe delay after 1st try check
			Log.addMessage("Lock sounds updated");
			
			ls.clickAutoLockButton();
			//Utility.simpleWait(3000);
			if(al.getAutoDelayStatus().equals("Off") || al.getAutoDelayStatus().equals("0")) {
				al.clickAutoLock();
				Utility.simpleWait(25000);
			}
			//check below code failed in bvt
			al.set_10min_Delay();
			Utility.simpleWait(25000);
			Log.addMessage("Auto lock delay status set");
			if(device.equals("android")) {
				al.clickBackButton();
			}
			ls.waitForSettings();
			System.out.println("pairedphone");
			//Utility.simpleWait(3000);//commented on 27th oct 2020 
			ls.clickPairedSmartPhonesButton();
			System.out.println("paired");
			//Utility.simpleWait(3000);//commented on 27th oct 2020 
			ps.waitForSmartPhone();
			if(device.equals("iOS")) {
				ps.pairedPhoneList(phameios, cntPhone);//change the function for 1 data.
			}else {
				System.out.println("phameExp");
				ps.pairedPhoneList(phameExp, cntPhone);//change the function for 1 data.
			}
			//Utility.simpleWait(3000);//commented on 27th oct 2020 
			ps.clickBackButton();
			ls.clickLEDStatusButton();
			Utility.simpleWait(25000);
			Log.addMessage("lock settings displayed");
			Assert.assertTrue(true,"lock settings displayed");
		}catch(Exception e) {
			 Log.addMessage("Failed to update Lock Settings");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to update Lock Settings");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyUIFPViewUserName() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			va.clickBackButton();
			ld.clickAccessCodeButton();
			va.verifyUIFP();
			va.getAccessCodeCnt();
			Log.addMessage("UI for selecting finger Print username is dispalyed");
		}catch(Exception e) {
			Log.addMessage("UI for selecting finger Print username is not dispalyed");
			e.printStackTrace();
			Assert.assertTrue(false, "UI for selecting finger Print username is not dispalyed");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyUIFPUserProfile() {
		try {
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			va.selFirstFPUser();
			ac.verifyUIFPUserProfile();
			Log.addMessage("UI of finger print profile details is dispalyed");
		}catch(Exception e) {
			Log.addMessage("UI of finger print profile details not dispalyed");
			e.printStackTrace();
			Assert.assertTrue(false, "UI of finger print profile details not dispalyed");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void updateUserProfileName() {
		try {
			EditCodeNamePage ec = new EditCodeNamePage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage va = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			System.out.println("namecnt="+namecnt);
			va.clickEditCodeName();
			if(namecnt==0) {
				ec.enterAccessCodeName("Spectrum2");
				namecnt++;
			}
			ec.clickSubmitButton();
			va.clickOkButton();//added on 06-10-2020
			Assert.assertTrue(true, "User name of finger print profile is updated");
			Log.addMessage("User name of finger print profile is updated");
		}catch(Exception e) {
			Log.addMessage("Failed to update user name of finger print profile");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update user name of finger print profile");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void disableFPProfile() {
		try {
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			//Utility.simpleWait(20000);//commented on 27th Oct 2020
			va.waitForSyncComplete();
			System.out.println("in disable code");
			//disable access code
			//va.clickBackButton();//06-10-20
			if(device.equals("iOS")) {
				va.selSecondFPUser();
			}else {
				va.selFirstFPUser();
			}
			System.out.println("in disable code1");
			ac.disableAccessCode();
			System.out.println("clicked disable code2");
			//Utility.simpleWait(10000);
			va.waitForSyncComplete();
			Log.addMessage("Access Code disabled  for the profile");
		}catch(Exception e) {
			Log.addMessage("Access Code disable failed for the profile");
			e.printStackTrace();
			Assert.assertTrue(false, "Access Code disable failed for the profile");
		}
	}		
			
	@SuppressWarnings("unchecked")
	@Test
	public void enableFPProfile() {
		try {
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			va.selDisabledFPUser();
			/*if(va.checkOkButton()) {
				va.clickOkButton();
				Utility.simpleWait(20000);
				va.selDisabledFPUser();
			}*/
			System.out.println("Selected Access disabled profile1");
			ac.disableAccessCode();
			System.out.println("clicked enable code2");
			//Utility.simpleWait(10000);
			va.waitForSyncComplete();
			System.out.println("Access enabled loop2");
			Log.addMessage("Access Code enabled  for the profile");
		}catch(Exception e) {
			Log.addMessage("Access Code enable failed for the profile");
			e.printStackTrace();
			Assert.assertTrue(false, "Access Code enable failed for the profile");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void changeFPUserProfileDigitType() {
		try {
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			
			System.out.println("select changeFPUserProfileDigitType first");
			//va.clickBackButton();//06-10-2020
			va.selFirstFPUser();
			//Utility.simpleWait(3000);//commented on 27-10-2020
			System.out.println("select selSecondFPUser");
			ac.clickFingerPrint1();
			System.out.println("select clickFingerPrint1");
			ac.clickRightButton();
			System.out.println("select clickRightButton");
			ac.clickIndexButton();
			System.out.println("select clickIndexButton");
			ac.clickSaveButton();
			System.out.println("select clickSaveButton");
			//Utility.simpleWait(35000);
			va.waitForSyncComplete();
			ViewAccessCodesPage va1 = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			va1.selFirstFPUser();
			//Utility.simpleWait(3000);
			System.out.println("select getFingerPrintText last");
			if(ac.getFingerPrintText().equals("Right Index")) {
				Assert.assertTrue(true, "Finger print digit for the profile updated");
				Log.addMessage("Finger print digit for the profile updated");
			}else {
				Assert.assertTrue(false, "Failed to update Finger print digit for the profile");
				Log.addMessage("Failed to update Finger print digit for the profile");
			}
		}catch(Exception e) {
			Log.addMessage("UI of finger print profile details not dispalyed");
			e.printStackTrace();
			Assert.assertTrue(false, "UI of finger print profile details not dispalyed");
		}
	}
	//write method for viewschedule type and check assign scheduletype
	@SuppressWarnings("unchecked")
	@Test
	public void setScheduleTypeAnyTime() {
		try {
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			SelectScheduleTypePage ss = new SelectScheduleTypePage((AppiumDriver<MobileElement>) driver);
			System.out.println("in setScheduleTypeAnyTime");
			System.out.println("selected clickScheduleButton");
			ac.clickScheduleButton();
			System.out.println("click clickScheduleButton");
			ss.selectAnyTime();//verify if  schedule type updated as Any Time 
			//Utility.simpleWait(20000);
			va.waitForSyncComplete();
			Assert.assertTrue(true, "Set schedule type to Any Time");
			Log.addMessage("Set schedule type to Any Time");
		}catch(Exception e) {
			Log.addMessage("Failed to set schedule type");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to set schedule type");
		}
	}
	@SuppressWarnings("unchecked")
	@Test(dataProvider="schWeek")
	public void valScheduleTypeWeekly(String typeSch) {
		try {
			
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			SelectScheduleTypePage ss = new SelectScheduleTypePage((AppiumDriver<MobileElement>) driver);
			LimitByWeekdayAndTimePage lb = new LimitByWeekdayAndTimePage((AppiumDriver<MobileElement>) driver);
			SelectWeekDayPage sw = new SelectWeekDayPage((AppiumDriver<MobileElement>) driver);
			System.out.println("in valScheduleTypeWeekly");
			
			//Utility.simpleWait(3000);
			System.out.println("after wait");
			if(typeSch.equals("WithoutDay")) {
				va.selFirstFPUser();
				/*if(va.checkOkButton()) {
					va.clickOkButton();
					Utility.simpleWait(25000);
					va.selFirstFPUser();
				}*/
				//Utility.simpleWait(3000);
				System.out.println("selected clickScheduleButton");
				ac.clickScheduleButton();
				System.out.println("click clickScheduleButton");
				ss.selectLimitByWeekdayAndTime();
				//Utility.simpleWait(3000);//commented on 23rd Oct 2020 check for toast
				lb.clickDaysToAllowOption();
				sw.clickClearAllDaysOption();
				sw.clickSubmitButton();
				if(device.equals("iOS")) {
					sw.clickOkButton();
				}else {
					Utility.simpleWait(3000);//for toast message to disappear
				}
				sw.clickBackButton();
				Log.addMessage("Schedule type cannot be set with no days selected");
				Assert.assertTrue(true, "Schedule type cannot be set with no days selected");
			}else {
				lb.clickLimitTimeOfDay();
				lb.clickSubmitButton();
				//if(device.equals("iOS")) {
					lb.clickOkButton();//in android updating with default date
				//}
				Log.addMessage("Schedule type cannot be set with no time selected");
				Assert.assertTrue(true, "Schedule type cannot be set with no time selected");
			}
		}catch(Exception e) {
			Log.addMessage("Schedule type set without selecting any days or time");
			e.printStackTrace();
			Assert.assertTrue(false, "Schedule type set without selecting any days or time");
		}
	}
	@SuppressWarnings("unchecked")
	@Test(dataProvider="schWeekTime")
	public void setScheduleTypeWeekly(String hours_start, String min_start, String AM_PM_start, String hours_end, String min_end, String AM_PM_end) {
		try {
			SelectScheduleTypePage ss = new SelectScheduleTypePage((AppiumDriver<MobileElement>) driver);
			LimitByWeekdayAndTimePage lb = new LimitByWeekdayAndTimePage((AppiumDriver<MobileElement>) driver);
			System.out.println("in setScheduleTypeWeekly");
			
			//check dates in excel
			if(device.equals("iOS")) {
				lb.clickLimitTimeOfDay();
			}
			if(device.equals("iOS")) {
				lb.selectEndTime(hours_end, min_end, AM_PM_end);
				lb.selectStartTime(hours_start, min_start, AM_PM_start);
			}else {
				lb.selectStartTime(hours_start, min_start, AM_PM_start);
				lb.selectEndTime(hours_end, min_end, AM_PM_end);
			}
			lb.clickSubmitButton();
			//Utility.simpleWait(8000);//commented on 23rd Oct 2020 check
			if(device.equals("iOS")) {
				lb.clickOkButton();
			}
			
			
			Log.addMessage("Schedule type set with limit by weekday and time");
			Assert.assertTrue(true, "Schedule type set with limit by weekday and time");
			
		}catch(Exception e) {
			Log.addMessage("Failed to set schedule type with limit by weekday and time");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to set schedule type with limit by weekday and time");
		}
	}
	@SuppressWarnings("unchecked")
	@Test(dataProvider="schDate")
	public void setScheduleTypeDate(String month, String day, String year, String monthend, String dayend, String yearend) {
		try {
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			SelectScheduleTypePage ss = new SelectScheduleTypePage((AppiumDriver<MobileElement>) driver);
			LimitByDatePage lb = new LimitByDatePage((AppiumDriver<MobileElement>) driver);
			Utility.simpleWait(17000);//for testing in between
			System.out.println("in setScheduleTypeDate");
			//Utility.simpleWait(20000);//for testing in between commented for faster testing in between uncomment for full flow.
			va.waitForSyncComplete();
			va.selFirstFPUser();
			/*if(va.checkOkButton()) {
				va.clickOkButton();
				//Utility.simpleWait(25000);commented for bvt
				Utility.simpleWait(10000);
				va.selFirstFPUser();
			}*/
			//Utility.simpleWait(3000);commented for bvt 9-10-2020
			System.out.println("selected clickScheduleButton");
			ac.clickScheduleButton();
			System.out.println("click clickScheduleButton");
			//Utility.simpleWait(3000);commented for bvt 9-10-2020
			ss.selectLimitByDate();
			System.out.println("click LimitByDate");
			if(device.equals("iOS")) {
				lb.selectStartDate( month,  day,  year);
				lb.selectEndDate( monthend,  dayend,  yearend);
			}else {
				lb.setCurrStartDate();
				//Utility.simpleWait(3000);//commented for bvt 23-10-2020 check
				lb.setCurrEndDate();
			}
			lb.clickSubmitButton();
			//Utility.simpleWait(8000);//commented for bvt 23-10-2020 check
			if(device.equals("iOS")) {
				lb.clickOkButton();//commented on 09-10-2020 for Android during bvt
			}
			Log.addMessage("Schedule type set with limit by date");
			Assert.assertTrue(true, "Schedule type set with limit by date");
		}catch(Exception e) {
			Log.addMessage("Failed to set schedule type with limit by weekday and time");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to set schedule type with limit by weekday and time");
		}
	}
	

	@SuppressWarnings("unchecked")
	@Test
	public void viewFPUISecureModeTest() throws InterruptedException {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			
			//ld.clickAccessCodeButton();//commented for bvt 27-10-2020
			//Utility.simpleWait(3000);
			va.waitForSyncComplete();
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
	public void lockUnlockBLEOff() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			ConfirmDeleteLockPage cd = new ConfirmDeleteLockPage((AppiumDriver<MobileElement>) driver);
			va.clickBackButton();
			System.out.println("Wait for BLE Off");
			Utility.simpleWait(17000);
			String status = ld.getLockStatus();
			if (status.equals("Locked")) {
				ld.unlockOperation();
				//Utility.simpleWait(5000);for bvt
				ld.lockOperation();
			}
			else if (status.equals("Unlocked")) {
				ld.lockOperation();
				//Utility.simpleWait(5000);for bvt
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
			String status;
			System.out.println("Wait for BLE ON and Wifi Off");
			Utility.simpleWait(5000);
			if(device.equals("android")) {
				ld.clickCancelButton();
				/*ld.lockOperationWOLockStatus();
				ld.clickCancelButton();
				Log.addMessage("Failed to do lock unlock with no internet connection");
				Assert.assertTrue(true,"Lock unlock possible with no internet connection");*/
			}
			
			status = ld.getLockStatus();
			if (status.equals("Locked")) {
				ld.unlockOperation();
				//Utility.simpleWait(5000);
				ld.lockOperation();
			}else if (status.equals("Unlocked")) {
				ld.lockOperation();
				//Utility.simpleWait(5000);
				ld.unlockOperation();
			}else if (status.equals("Lock Offline")) {//in iOS
				ld.lockOperation();
				//Utility.simpleWait(5000);
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
	@Test( dataProvider="wifiOffpopup")
	public void deleteLockWifiOffTest(String popupMsg) {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			ConfirmDeleteLockPage cd = new ConfirmDeleteLockPage((AppiumDriver<MobileElement>) driver);
			
			ld.clickLockSettingsButton();
			//Utility.simpleWait(3000);//commented on 06-10-2020 for bvt
			ls.clickDeleteLockButton();
			System.out.println("clicked delete lock");
			if(device.equals("android")) {
				ls.valWifiOffMessage(popupMsg);
			}else {
				cd.deleteLock();
				//System.out.println("1");
				cd.clickOKButton();
				//System.out.println("2");
				cd.clickBackButton();
				//System.out.println("3");
			}
			ls.clickBackButton();
			Log.addMessage("Wifi Off pop up displayed");
			Assert.assertTrue(true,"Wifi Off pop up displayed");
			
		}catch(Exception e) {
			 Log.addMessage("Failed to display wifi off popup");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to display wifi off popup");
		 }
	}
	
	
	ExcelRead excel = new ExcelRead();
	
	@DataProvider(name = "adminLockPair")
	public Object[][] getDataAdminLockPair() throws Exception {
		return excel.getTableArray(InputData, "App", "LockPairPopUp");
	}
	@DataProvider(name = "lockHistry")
	public Object[][] getDataLockHistoryiOS() throws Exception {
		return excel.getTableArray(InputData, "Validation", "acBvtLockHistory");
	}
	@DataProvider(name = "lockSetting")
	public Object[][] getDataLockSetting() throws Exception {
		return excel.getTableArray(InputData, "App", "fpLockSetting");
	}
	@DataProvider(name = "wifiOffpopup")
	public Object[][] getDataWifiOffPopup() throws Exception {
		return excel.getTableArray(InputData, "App", "fpWifiOffPopup");
	}
	@DataProvider(name = "schWeek")
	public Object[][] getDataSchTypeWeek() throws Exception {
		return excel.getTableArray(InputData, "Validation", "ValSchTypeWeek");
	}
	@DataProvider(name = "schWeekTime")
	public Object[][] getDataSchTypeWeekTime() throws Exception {
		return excel.getTableArray(InputData, "Validation", "ValSchTypeWeekTime");
	}
	@DataProvider(name = "schDate")
	public Object[][] getDataSchTypeDate() throws Exception {
		return excel.getTableArray(InputData, "Validation", "ValSchTypeDate");
	}
	
}
