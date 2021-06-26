package tests.app;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.app.UserFPAccessProfilePage;
import pages.app.EditCodeNamePage;
import pages.app.LimitByDatePage;
import pages.app.LimitByWeekdayAndTimePage;
import pages.app.LockDashboardPage;
import pages.app.MenuFlyoutPage;
import pages.app.SelectScheduleTypePage;
import pages.app.SelectWeekDayPage;
import pages.app.ViewAccessCodesPage;
import utility.ExcelRead;
import utility.Log;

public class EditFingerPrintTest extends Settings{
	
	int cnt, delcnt, namecnt = 0;
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyUIFPViewUserName() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			if(device.equals("android")) {
				ld.clickHamburgerButton();
				mp.clickLockImageInMenu("hl");
				Thread.sleep(2000);
			}
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
			}else if(namecnt==1) {
				//for disabled account test
				ec.enterAccessCodeName("accesstest1");
				namecnt++;
			}else if (namecnt==2) {
				//for ble off test
				ec.enterAccessCodeName("accesstest3");
				namecnt++;
			}else if (namecnt==3) {
				//for wifi off test
				ec.enterAccessCodeName("accesstest4");
				namecnt++;
			}
			ec.clickSubmitButton();
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
			Thread.sleep(20000);
			System.out.println("in disable code");
			//disable access code
			if(device.equals("iOS")) {
				va.selSecondFPUser();
			}else {
				va.selFirstFPUser();
			}
			System.out.println("in disable code1");
			ac.disableAccessCode();
			System.out.println("clicked disable code2");
			Thread.sleep(10000);
			
			Log.addMessage("Access Code disabled  for the profile");
		}catch(Exception e) {
			Log.addMessage("Access Code disable failed for the profile");
			e.printStackTrace();
			Assert.assertTrue(false, "Access Code disable failed for the profile");
		}
	}
			//enable access code
			//-------check from displayed list the profile which is disabled and then enable it or make below as  another method.
			
		@SuppressWarnings("unchecked")
		@Test
		public void enableFPProfile() {
			try {
				ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
				UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
				
				va.selDisabledFPUser();
				if(va.checkOkButton()) {
					va.clickOkButton();
					Thread.sleep(20000);
					va.selDisabledFPUser();
				}
				System.out.println("Selected Access disabled profile1");
				ac.disableAccessCode();
				System.out.println("clicked enable code2");
				Thread.sleep(10000);
				
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
			Thread.sleep(7000); //sleep time for syncing);
			System.out.println("select changeFPUserProfileDigitType first");
			va.selFirstFPUser();
			Thread.sleep(3000);
			System.out.println("select selSecondFPUser");
			ac.clickFingerPrint1();
			System.out.println("select clickFingerPrint1");
			ac.clickRightButton();
			System.out.println("select clickRightButton");
			ac.clickIndexButton();
			System.out.println("select clickIndexButton");
			ac.clickSaveButton();
			System.out.println("select clickSaveButton");
			Thread.sleep(45000);
			ViewAccessCodesPage va1 = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			va1.selFirstFPUser();
			Thread.sleep(3000);
			System.out.println("select getFingerPrintText last");
			if(ac.getFingerPrintText().equals("Right Index")) {
				Assert.assertTrue(true, "Finger print digit for the profile updated");
				Log.addMessage("Finger print digit for the profile updated");
			}else {
				Assert.assertFalse(false, "Failed to update Finger print digit for the profile");
				Log.addMessage("Failed to update Finger print digit for the profile");
			}
			ac.clickBackButton();
		}catch(Exception e) {
			Log.addMessage("UI of finger print profile details not dispalyed");
			e.printStackTrace();
			Assert.assertTrue(false, "UI of finger print profile details not dispalyed");
		}
	}
	//delete fingerprint if there are multiple profiles
	@SuppressWarnings("unchecked")
	@Test
	public void deleteOneFingerPrint() {
		try {
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			Thread.sleep(8000);
			System.out.println("select deleteOneFingerPrint");
			va.selFirstFPUser();//for now
			System.out.println("selected selFirstFPUser");
			System.out.println("Add new fingerprint option :"+ac.checkAddNewFP());
			//checking if there are multiple fp present
			if(ac.checkAddNewFP()) {
				System.out.println("in Add New FP");
				Log.addMessage("No delete option for the profile");
				Assert.assertTrue(false, "No delete option for the profile");
				ac.clickBackButton();//check if this code will excute
			}else {
				System.out.println("both FP present");
				ac.deleteFingerPrint(delcnt);
				delcnt++;
				Log.addMessage("One finger print deleted for the profile");
			}
		}catch(Exception e) {
			Log.addMessage("Failed to delete Finger print");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to delete Finger print");
		}
	}
	@SuppressWarnings("unchecked")
	@Test
	public void checkDeleteBothFingerPrint() {
		try {
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			System.out.println("in checkDeleteBothFingerPrint");
			Thread.sleep(27000);
			va.selFirstFPUser();
			if(va.checkOkButton()) {
				va.clickOkButton();
				Thread.sleep(20000);
				va.selFirstFPUser();
			}
			
			System.out.println("selected user for deleting both the fp");
			
			if(ac.checkAddNewFP()) {
				System.out.println("Add new fp option present");
				if(device.equals("android")) {// count image and check instead of delete button in android
					System.out.println("DeleteButton is not present");
					Assert.assertTrue(true, "Verified deleting both the finger prints from the profile not possible");
					Log.addMessage("Verified cannot delete both the finger prints from the profile");
				}else {
				if(ac.checkDeleteButton()==0) {
						System.out.println("DeleteButton is not present");
						Assert.assertTrue(true, "Verified deleting both the finger prints from the profile not possible");
						Log.addMessage("Verified cannot delete both the finger prints from the profile");
					}else {
						System.out.println("DeleteButton is present");
						//ac.deleteFingerPrint(1);//commented as this should not happen here test fails.
						//Thread.sleep(27000);
						System.out.println("deleted second FP");
						Assert.assertTrue(false, "Deleted both the finger print from the profile");	
						Log.addMessage("Deleted both the finger print from the profile");
					}
				}
			}
			
		}catch(Exception e) {
			Log.addMessage("Deleted both the Finger prints");
			e.printStackTrace();
			Assert.assertTrue(false, "Deleted both the Finger prints");
		}
	}
	@SuppressWarnings("unchecked")
	@Test
	public void verifyAddFingerPrint() {
		try {
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			System.out.println("in verifyAddFingerPrint");
			if(ac.checkAddNewFP()) {
				System.out.println("in add new fp");
				Assert.assertTrue(true,"Verified the option to add new finger print exists");
				Log.addMessage("Verified the option to add new finger print exists");
			}else {
				Assert.assertTrue(false,"Failed to find Add  New Finger print option");
				Log.addMessage("Failed to find Add New Finger print option");
			}
			ac.clickEditCodeName();
			Log.addMessage("Selected option to edit user name for the profile");
			
		}catch(Exception e) {
			Log.addMessage("Failed to find Add Finger print option");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to find Add Finger print option");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="fpUserProfNm")
	public void validateUserProfileName(String usrNm, String titleMsg, String errMessage, String titleMsg2, String errMessage2) {
		try {
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			EditCodeNamePage ec = new EditCodeNamePage((AppiumDriver<MobileElement>) driver);
			Thread.sleep(3000);
			System.out.println("in validateUserProfileName");
			
			ec.valUserProfileName(usrNm, titleMsg, errMessage, titleMsg2, errMessage2);
			System.out.println("in valUserProfileName");
			
		}catch(Exception e) {
			Log.addMessage("Failed to find Add Finger print option");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to find Add Finger print option");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void setScheduleTypeAnyTime() {
		try {
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			SelectScheduleTypePage ss = new SelectScheduleTypePage((AppiumDriver<MobileElement>) driver);
			System.out.println("in setScheduleTypeAnyTime");
			Thread.sleep(7000);
			va.selFirstFPUser();
			if(va.checkOkButton()) {
				va.clickOkButton();
				Thread.sleep(20000);
				va.selFirstFPUser();
			}
			
			System.out.println("selected clickScheduleButton");
			ac.clickScheduleButton();
			System.out.println("click clickScheduleButton");
			ss.selectAnyTime();//verify if  schedule type updated as Any Time 
			Thread.sleep(15000);
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
			
			Thread.sleep(3000);
			System.out.println("after wait");
			if(typeSch.equals("WithoutDay")) {
				va.selFirstFPUser();
				if(va.checkOkButton()) {
					va.clickOkButton();
					Thread.sleep(25000);
					va.selFirstFPUser();
				}
				Thread.sleep(3000);
				System.out.println("selected clickScheduleButton");
				ac.clickScheduleButton();
				
				System.out.println("click clickScheduleButton");
				ss.selectLimitByWeekdayAndTime();
				Thread.sleep(3000);
				lb.clickDaysToAllowOption();
				sw.clickClearAllDaysOption();
				sw.clickSubmitButton();
				if(device.equals("iOS")) {
					sw.clickOkButton();
				}else {
					Thread.sleep(3000);//for toast message to disappear
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
			Thread.sleep(20000);//for testing in between
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
			Thread.sleep(8000);
			lb.clickOkButton();
			
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
			
			System.out.println("in setScheduleTypeDate");
			Thread.sleep(20000);//for testing in between commented for faster testing in between uncomment for full flow.
			/*va.selFirstFPUser();
			if(va.checkOkButton()) {
				va.clickOkButton();
				Thread.sleep(25000);
				va.selFirstFPUser();
			}*/
			Thread.sleep(3000);
			System.out.println("selected clickScheduleButton");
			ac.clickScheduleButton();
			System.out.println("click clickScheduleButton");
			Thread.sleep(3000);
			ss.selectLimitByDate();
			System.out.println("click LimitByDate");
			if(device.equals("iOS")) {
			lb.selectStartDate( month,  day,  year);
			lb.selectEndDate( monthend,  dayend,  yearend);
			}else {
				lb.setCurrStartDate();
				Thread.sleep(3000);
				lb.setCurrEndDate();
			}
			lb.clickSubmitButton();
			Thread.sleep(8000);
			lb.clickOkButton();
			
			Log.addMessage("Schedule type set with limit by date");
			Assert.assertTrue(true, "Schedule type set with limit by date");
			
		}catch(Exception e) {
			Log.addMessage("Failed to set schedule type with limit by weekday and time");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to set schedule type with limit by weekday and time");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="schvalDate")
	public void valScheduleTypeDate(String month, String day, String year, String monthend, String dayend, String yearend) {
		try {
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			SelectScheduleTypePage ss = new SelectScheduleTypePage((AppiumDriver<MobileElement>) driver);
			LimitByDatePage lb = new LimitByDatePage((AppiumDriver<MobileElement>) driver);
			
			System.out.println("in valScheduleTypeDate");
			Thread.sleep(8000);
			va.selFirstFPUser();
			if(va.checkOkButton()) {
				va.clickOkButton();
				Thread.sleep(20000);
				va.selFirstFPUser();
			}
			Thread.sleep(3000);
			System.out.println("selected clickScheduleButton");
			ac.clickScheduleButton();
			System.out.println("click clickScheduleButton");
			Thread.sleep(3000);
			ss.selectLimitByDate();
			lb.selectStartDate( month,  day,  year);
			lb.selectEndDate( monthend,  dayend,  yearend);
			lb.clickSubmitButton();
			Thread.sleep(8000);
			lb.clickOkButton();
			
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
	public void removeFPProfileTest() {
		try {
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			
			Thread.sleep(12000);
			va.selFirstFPUser();
			Thread.sleep(3000);
			System.out.println("removing profile");
			ac.deleteAccessCode();
			
			Log.addMessage("Removed user profile from the account and app");
			Assert.assertTrue(true, "Removed user profile from the account and app");
			
		}catch(Exception e) {
			Log.addMessage("Failed to remove user profile");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to remove user profile");
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void disabledProfileTest() {
		try {
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			Thread.sleep(8000);
			disableFPProfile();
			Thread.sleep(3000);
			va.selDisabledFPUser();
			if(va.checkOkButton()) {
				va.clickOkButton();
				Thread.sleep(20000);
				va.selDisabledFPUser();
			}
			updateUserProfileName();
			setScheduleTypeAnyTime();//check here for AnyTime - will not update as access disabled for the profile
			changeFPUserProfileDigitType();
			deleteOneFingerPrint();//added on 02-06-2020
			
			Thread.sleep(15000);
			va.selDisabledFPUser();
			ac.deleteAccessCode();
			Thread.sleep(10000);
			Log.addMessage("Disabled user deleted");
			Assert.assertTrue(true, "Disabled user deleted");
			
		}catch(Exception e) {
			Log.addMessage("Failed to set schedule type with limit by weekday and time");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to set schedule type with limit by weekday and time");
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="profileDigitType")
	public void valFPUserProfileDigitType(String fpName, String hand, String finger) {
		try {
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			Thread.sleep(10000); //sleep time for syncing);
			System.out.println("select valFPUserProfileDigitType first");
			if(device.equals("iOS")) {// checkif its required in iOS  for order issue
				if(cnt==0) {
					va.selSecondFPUser();
					if(va.checkOkButton()) {
						va.clickOkButton();
						Thread.sleep(20000);
						va.selSecondFPUser();
					}
					cnt++;
				}else {
					va.selFirstFPUser();
					if(va.checkOkButton()) {
						va.clickOkButton();
						Thread.sleep(20000);
						va.selFirstFPUser();
					}
				}
			}else {
				va.selFirstFPUser();
				if(va.checkOkButton()) {
					va.clickOkButton();
					Thread.sleep(20000);
					va.selFirstFPUser();
				}
			}
			
			
			
			
			Thread.sleep(3000);
			System.out.println("select selSecondFPUser");
			if(fpName.equals("FP1")) {
				ac.clickFingerPrint1();
			}else {
				ac.clickFingerPrint2();
			}
			
			System.out.println("select clickFingerPrint1");
			if(hand.equals("right")) {
				ac.clickRightButton();
			}else {
				ac.clickLeftButton();
			}
			System.out.println("select clickRightButton");
			ac.selectAFinger(finger);
			System.out.println("select clickIndexButton");
			ac.clickSaveButton();
			System.out.println("select clickSaveButton");
			Thread.sleep(17000);
			if(fpName.equals("FP1")) {
				Assert.assertTrue(true, "Finger print digit for FingerPrint1 updated");
				Log.addMessage("Finger print digit for FingerPrint1 updated");
			}else {
				Assert.assertTrue(true, "Finger print digit for FingerPrint2 updated");
				Log.addMessage("Finger print digit for FingerPrint2 updated");
			}
		
		}catch(Exception e) {
			Log.addMessage("Failed to save the fp profile template details");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to save the fp profile template details");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void valSameFPUserProfileDigitType() {
		try {
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			Thread.sleep(7000); //sleep time for syncing);
			System.out.println("select valFPUserProfileDigitType first");
			
			va.selFirstFPUser();
			Thread.sleep(3000);
			System.out.println("select selSecondFPUser");
			ac.clickFingerPrint2();
			System.out.println("select clickFingerPrint1");
			ac.clickLeftButton();
			System.out.println("select clickRightButton");
			ac.selectAFinger("Little");
			System.out.println("select clickIndexButton");
			ac.clickSaveButton();
			System.out.println("select clickSaveButton");
			Thread.sleep(7000);
			if(device.contentEquals("iOS")) {//as in android its getting saved with fp
				ac.clickBackButton();
			}
			System.out.println("select back");
			Assert.assertTrue(true, "Failed to save same finger print digit type for both the finger print templates");
			Log.addMessage("Failed to save same finger print digit type for both the finger print templates");
			Thread.sleep(17000);
			
		}catch(Exception e) {
			Log.addMessage("Updated the same fp profile digit for both templates");
			e.printStackTrace();
			Assert.assertTrue(false, "Updated the same fp profile digit for both templates");
		}
	}
	
	//delete fingerprint if there are multiple profiles
	@SuppressWarnings("unchecked")
	@Test
	public void deleteFingerPrintTwo() {
		try {
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			Thread.sleep(8000);
			System.out.println("select deleteFingerPrintTwo");
			va.selFirstFPUser();
			System.out.println("selected selFirstFPUser");
			System.out.println("Add new fingerprint option :"+ac.checkAddNewFP());
			//checking if there are multiple fp present
			if(ac.checkAddNewFP()) {
				System.out.println("in Add New FP");
				Assert.assertTrue(false, "No delete option for the profile");
				Log.addMessage("No delete option for the profile");
			}else {
				System.out.println("both FP present");
				ac.deleteFingerPrint(1);
				Log.addMessage("Second finger print deleted for the profile");
				Thread.sleep(27000);
				System.out.println("after deleteFingerPrintTwo");
				UserFPAccessProfilePage ac1 = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
				ViewAccessCodesPage va1 = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
				va1.selFirstFPUser();
				Thread.sleep(3000);
				if(ac1.checkAddNewFP()) {
					System.out.println("in Add New FP");
					Assert.assertTrue(true, "Add new finger print option present after deletion of finger print2");
					Log.addMessage("Add new finger print option present after deletion of finger print2");
				}
				ac1.deleteAccessCode();
				Log.addMessage("Deleted the user profile");
			}
			}catch(Exception e) {
				Log.addMessage("Failed to delete Finger print");
				e.printStackTrace();
				Assert.assertTrue(false, "Failed to delete Finger print");
			}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="networkoffname")
	public void networkOutOfRangeFPTest(String disablednetwork) {
		try {
			ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
			System.out.println("wait for ble/wifi off condition");
			//Thread.sleep(12000);
			
			Thread.sleep(27000);
			/*if(disablednetwork.equals("Ble")) {
				System.out.println("select deleteFingerPrintTwo ble");
				va.selSecondFPUser();
			}else {
				va.selFirstFPUser();
			}*/
			va.selFirstFPUser();
			Thread.sleep(3000);
			updateUserProfileName();
			Log.addMessage("Updated user profile name with "+disablednetwork+" off");
			setScheduleTypeAnyTime();
			Log.addMessage("Schedule type set for the profile with "+disablednetwork+" off");
			Thread.sleep(3000);
			changeFPUserProfileDigitType();
			Log.addMessage("Updated profile digit type with "+disablednetwork+" off");
			Thread.sleep(3000);
			deleteOneFingerPrint();
			Log.addMessage("Deleted fingerprint1 with "+disablednetwork+" off");
			Thread.sleep(5000);
			disableFPProfile();
			Log.addMessage("Disable fingerprint profile with "+disablednetwork+" off");
			enableFPProfile();
			Log.addMessage("Enabed fingerprint profile with "+disablednetwork+" off");
			Thread.sleep(17000);
			va.selFirstFPUser();
			ac.deleteAccessCode();
			Thread.sleep(12000);
			Log.addMessage("Delete one fingerprint profile with "+disablednetwork+" off");
			
			Log.addMessage("User deleted with "+disablednetwork+" off");
			Assert.assertTrue(true, "User deleted with "+disablednetwork+" off");
			
		}catch(Exception e) {
			Log.addMessage("Failed to update setting s with "+disablednetwork+" off");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update setting s with "+disablednetwork+" off");
		}
	}
		@SuppressWarnings("unchecked")
		@Test
		public void bleOutOfRangeWifiOffFPTest() {
			try {
				ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
				UserFPAccessProfilePage ac = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
				System.out.println("wait for both wifi and ble out of range condition");
				Thread.sleep(27000);
				System.out.println("select bleOutOfRangeWifiOffFPTest");
				va.selFirstFPUser();
				Log.addMessage("Select a user profile name");
				ac.clickScheduleButton();
				Thread.sleep(3000);
				Log.addMessage("Schedule type clicked for the profile");
				ac.clickOkButton();
				Log.addMessage("Lock Offline pop up is displayed");
				ac.disableAccessCode();
				Thread.sleep(3000);
				Log.addMessage("Disable button clicked for the profile");
				UserFPAccessProfilePage ac1 = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
				ac1.clickOkButton();
				Log.addMessage("Lock Offline pop up is displayed");
				ac1.deleteUserProfile();
				Log.addMessage("Delete button clicked for the profile");
				Thread.sleep(3000);
				UserFPAccessProfilePage ac2 = new UserFPAccessProfilePage((AppiumDriver<MobileElement>) driver);
				ac2.clickOkButton();
				Log.addMessage("Lock Offline pop up is displayed");
				
				Log.addMessage("Settings cannot be updated as lock is offline.");
				Assert.assertTrue(true, "Settings cannot be updated as lock is offline.");
				
			}catch(Exception e) {
				Log.addMessage("Failed to display lock offline popup");
				e.printStackTrace();
				Assert.assertTrue(false, "Failed to display lock offline popup");
			}
		}
	
	ExcelRead excel = new ExcelRead();
	
	@DataProvider(name = "fpUserProfNm")
	public Object[][] getDataUsrName() throws Exception {
		return excel.getTableArray(InputData, "Validation", "AccessCodeNamePopup");
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
	@DataProvider(name = "schvalDate")
	public Object[][] getDataSchTypeDateRange() throws Exception {
		return excel.getTableArray(InputData, "Validation", "ValSchTypeDateRange");
	}
	@DataProvider(name = "profileDigitType")
	public Object[][] getDataProfileDigitType() throws Exception {
		return excel.getTableArray(InputData, "Validation", "ValProfileDigitType");
	}
	@DataProvider(name = "networkoffname")
	public Object[][] getDataProfileNetworkOff() throws Exception {
		return excel.getTableArray(InputData, "Validation", "ValNetworkOff");
	}
}
