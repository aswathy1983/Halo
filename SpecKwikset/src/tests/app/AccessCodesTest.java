package tests.app;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.app.AccessCodePage;
import pages.app.AddAccessCodePage;
import pages.app.EditAccessCodePage;
import pages.app.EditCodeNamePage;
import pages.app.LimitByDatePage;
import pages.app.LimitByWeekdayAndTimePage;
import pages.app.LockDashboardPage;
import pages.app.SelectScheduleTypePage;
import pages.app.SelectWeekDayPage;
import pages.app.ViewAccessCodesPage;
import utility.ExcelRead;
import utility.Log;
import utility.Utility;

public class AccessCodesTest extends Settings{
	
	
	
	Random rand = new Random();
	String name;
	
	@SuppressWarnings("unchecked")
	@Test
	public void clickAccessCodeButtonTest() {
	  try {
		LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
		ld.clickAccessCodeButton();
	  }catch(Exception e) {
		  Log.addMessage("Failed to click access code button");
		  e.printStackTrace();
		  Assert.assertTrue(false, "Failed to click access code button");
	  }
	}
	
	@SuppressWarnings("unchecked")
	//@Test(dataProvider="addAccessCode")
	@Test ()
	public void addAccessCodeTest() {
		try {
		//	LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage ap = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			AddAccessCodePage ac = new AddAccessCodePage((AppiumDriver<MobileElement>) driver);
		//	ld.clickAccessCodeButton();
			for (int i =244;i<250;i++) {
			 ap.clickAddAccessCodeButton();
			 name = "tcode";
			 name = name + i;
			 ac.enterAccessCodeName(name);
			 ac.clickGenerateRandomCodeButton();
			 ac.clickSubmitButton();
			 Utility.simpleWait(10000);
			 System.out.println("Access code "+i+" created");
			}
		}catch(Exception e) {
			//check for presence of invalid access code pop up->if yes->dismiss pop up->click generate random code and submit.
			Log.addMessage("Failed to add access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to add access code");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void viewAccessCodesTest() {
		try {
			ViewAccessCodesPage ap = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			ap.fetchAllAccessCodes();
		}catch(Exception e) {
			Log.addMessage("Failed to view access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to view access code");
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void setAnyTimeScheduleType(String accessCode) {
		try {
			ViewAccessCodesPage ap = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			AccessCodePage ac = new AccessCodePage((AppiumDriver<MobileElement>) driver);
			SelectScheduleTypePage sp = new SelectScheduleTypePage((AppiumDriver<MobileElement>) driver);
			ap.fetchGivenAccessCode(accessCode);
			ac.editScheduleType();
			sp.selectAnyTime();
			Log.addMessage("Anytime schedule type is set for the access code");		
		}catch(Exception e) {
			Log.addMessage("Failed to set anytime schedule type for the access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to set anytime schedule type for the access code");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void setLimitByDateScheduleType(String accessCode,String start_month, String start_day,String start_year, String end_month, String end_day,String end_year) {
		try {
			ViewAccessCodesPage ap = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			AccessCodePage ac = new AccessCodePage((AppiumDriver<MobileElement>) driver);
			SelectScheduleTypePage sp = new SelectScheduleTypePage((AppiumDriver<MobileElement>) driver);
			LimitByDatePage ld = new LimitByDatePage((AppiumDriver<MobileElement>) driver);
			ap.fetchGivenAccessCode(accessCode);
			ac.editScheduleType();
			sp.selectLimitByDate();
			ld.selectStartDate(start_month, start_day, start_year);
			ld.selectEndDate(end_month, end_day, end_year);
			ld.clickSubmitButton();
			Log.addMessage("Limit By Date schedule type is set for the access code");		
		}catch(Exception e) {
			Log.addMessage("Failed to set Limit By Date schedule type for the access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to set Limit By Date schedule type for the access code");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void setLimitByWeekdayAndTimeScheduleType(String accessCode, String day) {
		try {
			ViewAccessCodesPage ap = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			AccessCodePage ac = new AccessCodePage((AppiumDriver<MobileElement>) driver);
			SelectScheduleTypePage sp = new SelectScheduleTypePage((AppiumDriver<MobileElement>) driver);
			LimitByWeekdayAndTimePage ld = new LimitByWeekdayAndTimePage((AppiumDriver<MobileElement>) driver);
			SelectWeekDayPage sd = new SelectWeekDayPage((AppiumDriver<MobileElement>) driver);
			ap.fetchGivenAccessCode(accessCode);
			ac.editScheduleType();
			sp.selectLimitByWeekdayAndTime();
			ld.clickDaysToAllowOption();
			sd.clickClearAllDaysOption();
			sd.selectADay(day);
			ld.clickSubmitButton();
			Log.addMessage("Limit By Weekday and Time schedule type is set for the access code");		
		}catch(Exception e) {
			Log.addMessage("Failed to set Limit By Weekday and Time schedule type for the access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to set Limit By Weekday and Time schedule type for the access code");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void setOneTimeWithin24HoursScheduleType(String accessCode) {
		try {
			ViewAccessCodesPage ap = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			AccessCodePage ac = new AccessCodePage((AppiumDriver<MobileElement>) driver);
			SelectScheduleTypePage sp = new SelectScheduleTypePage((AppiumDriver<MobileElement>) driver);
			ap.fetchGivenAccessCode(accessCode);
			ac.editScheduleType();
			sp.selectOneTimeWithin24Hours();
			Log.addMessage("One time within 24 hours schedule type is set for the access code");		
		}catch(Exception e) {
			Log.addMessage("Failed to set One time within 24 hours schedule type for the access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to set One time within 24 hours schedule type for the access code");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shareAccessCode(String accessCode) {
		try {
			ViewAccessCodesPage ap = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			AccessCodePage ac = new AccessCodePage((AppiumDriver<MobileElement>) driver);
			ap.fetchGivenAccessCode(accessCode);
			ac.clickShareAccessCode();
			Log.addMessage("Access code is shared.");
		}catch(Exception e) {
			Log.addMessage("Failed to share access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to share access code");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void disableAccessCode(String accessCode) {
		try {
			ViewAccessCodesPage ap = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			AccessCodePage ac = new AccessCodePage((AppiumDriver<MobileElement>) driver);
			ap.fetchGivenAccessCode(accessCode);
			ac.disableAccessCode();
			Log.addMessage("Access code is disabled");
		}catch(Exception e) {
			Log.addMessage("Failed to share access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to share access code");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void editAccessCode(String accessCode, String code) {
		try {
			ViewAccessCodesPage ap = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			AccessCodePage ac = new AccessCodePage((AppiumDriver<MobileElement>) driver);
			EditAccessCodePage ea = new EditAccessCodePage((AppiumDriver<MobileElement>) driver);
			ap.fetchGivenAccessCode(accessCode);
			ac.clickEditAccessCode();
			ea.enterAccessCodePin(code);
			ea.clickSubmitButton();
			Log.addMessage("Access code pin is updated");
		}catch(Exception e) {
			Log.addMessage("Failed to update access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update access code");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void editAccessCodeName(String accessCode, String newName) {
		try {
			ViewAccessCodesPage ap = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			AccessCodePage ac = new AccessCodePage((AppiumDriver<MobileElement>) driver);
			EditCodeNamePage ea = new EditCodeNamePage((AppiumDriver<MobileElement>) driver);
			ap.fetchGivenAccessCode(accessCode);
			ac.clickEditAccessCode();
			ea.enterAccessCodeName(newName);
			ea.clickSubmitButton();
			Log.addMessage("Access code name is updated");
		}catch(Exception e) {
			Log.addMessage("Failed to update access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update access code");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void deleteAccessCodeName(String accessCode, String newName) {
		try {
			ViewAccessCodesPage ap = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			AccessCodePage ea = new AccessCodePage((AppiumDriver<MobileElement>) driver);
			ap.fetchGivenAccessCode(accessCode);
			ea.deleteAccessCode();
			Log.addMessage("Access code name is deleted");
		}catch(Exception e) {
			Log.addMessage("Failed to delete access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to delete access code");
		}
	}
	

	ExcelRead excel = new ExcelRead();
	
	@DataProvider(name = "addAccessCode")
	public Object[][] getData() throws Exception {
	return excel.getTableArray(InputData, "App", "AddAccessCode");
	}
}
