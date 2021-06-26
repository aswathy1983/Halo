package pages.app;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import utility.Log;
import utility.Utility;

public class SelectScheduleTypePage extends Settings{
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/cancelAllhomes"),
		@AndroidBy(id = "com.kwikset.blewifi:id/cancelAllhomes"),
		@AndroidBy(id = "com.spectrum.giga:id/cancelAllhomes"),
		@AndroidBy(id = "com.weiser.blewifi:id/cancelAllhomes"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/cancelAllhomes")
	})
	@CacheLookup
	private MobileElement backButton;
		
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Any Time']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/ll_anytime_access"),
		@AndroidBy(id = "com.kwikset.blewifi:id/ll_anytime_access"),
		@AndroidBy(id = "com.spectrum.giga:id/ll_anytime_access"),
		@AndroidBy(id = "com.weiser.blewifi:id/ll_anytime_access"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/ll_anytime_access")
	})
	
	@CacheLookup		
	private MobileElement anyTimeOption;
	
	@iOSXCUITFindBy(id = "Limit by Date")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/layoutLimitbyDateRange"),
		@AndroidBy(id = "com.kwikset.blewifi:id/layoutLimitbyDateRange"),
		@AndroidBy(id = "com.spectrum.giga:id/layoutLimitbyDateRange"),
		@AndroidBy(id = "com.weiser.blewifi:id/layoutLimitbyDateRange"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/layoutLimitbyDateRange")
	})
	
	@CacheLookup
	private MobileElement limitByDate;
	
	@iOSXCUITFindBy(id = "Limit by Weekday and Time")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/layoutLimitbyDayorTime"),
		@AndroidBy(id = "com.kwikset.blewifi:id/layoutLimitbyDayorTime"),
		@AndroidBy(id = "com.spectrum.giga:id/layoutLimitbyDayorTime"),
		@AndroidBy(id = "com.weiser.blewifi:id/layoutLimitbyDayorTime"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/layoutLimitbyDayorTime")
	})
	
	@CacheLookup
	private MobileElement limitByWeekdayAndTime;
	
	@iOSXCUITFindBy(id = "One Time Within 24 hours")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/ll_one_time_24_hr"),
		@AndroidBy(id = "com.kwikset.blewifi:id/ll_one_time_24_hr"),
		@AndroidBy(id = "com.spectrum.giga:id/ll_one_time_24_hr"),
		@AndroidBy(id = "com.weiser.blewifi:id/ll_one_time_24_hr"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/ll_one_time_24_hr")
	})
	@CacheLookup
	private MobileElement oneTimeWithin24Hours;
	
	@iOSXCUITFindBy(id = "Start Now")
	@AndroidFindBy(id = "android:id/button1")
	@CacheLookup
	private MobileElement startNowButton;
	
	@iOSXCUITFindBy(id = "Ok")
	@AndroidFindBy(id = "android:id/button2")
	@CacheLookup
	private MobileElement cancelButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[1]")
	@AndroidFindBy(id = "android:id/alertTitle")
	@CacheLookup
	private MobileElement popUpTitleVerbiage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[2]")
	@AndroidFindBy(id = "android:id/message")
	@CacheLookup
	private MobileElement popUpMessageVerbiage;
	
	String actTitle, actMessage ="";
	

	//Constructor
	@SuppressWarnings("static-access")
	public SelectScheduleTypePage(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
		
		
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void selectAnyTime() {
		try {
			if(device.equals("iOS")) {
				Thread.sleep(6000);//added on 27-nov-2020
			}
			Utility.waitForElementToBeVisible(anyTimeOption);
			Utility.waitForElementToBeClickable(anyTimeOption);
			anyTimeOption.click();
			Log.addMessage("Schedule Type is set as 'AnyTime'");
		}catch(Exception e) {
			Log.addMessage("Failed to set schedule Type as anytime");
			Assert.assertTrue(false, "Failed to set schedule Type as anytime");
		}
	}
	
	
	public void selectLimitByDate() {
	  try {
		  Utility.waitForElementToBeVisible(limitByDate);
		  Utility.waitForElementToBeClickable(limitByDate);
		  limitByDate.click();
		  Log.addMessage("Schedule Type is set as 'Limit By date'");
	  }catch(Exception e) {
			Log.addMessage("Failed to get schedule type of the access code");
			Assert.assertTrue(false, "Failed to get schedule type of the access code");
	  }
	}
	
	public void selectLimitByWeekdayAndTime() {
		  try {
			  Utility.waitForElementToBeVisible(limitByWeekdayAndTime);
			  Utility.waitForElementToBeClickable(limitByWeekdayAndTime);
			  limitByWeekdayAndTime.click();
			  Log.addMessage("Schedule Type is set as 'Limit By Weekday and Time'");
		  }catch(Exception e) {
				Log.addMessage("Failed to set schedule type as Limit by weekday and time");
				Assert.assertTrue(false, "Failed to set schedule type of the access code as 'Limit By Weekday and Time'");
		  }
		}
	
	public void selectOneTimeWithin24Hours() {
		  try {
			  if(device.equals("iOS")) {
					Utility.simpleWait(6000);//added on 16 Nov 2020 for bvt
			  }
			  Utility.waitForElementToBeVisible(oneTimeWithin24Hours);
			  Utility.waitForElementToBeClickable(oneTimeWithin24Hours);
			  oneTimeWithin24Hours.click();
			  startNowButton.click();
			  Log.addMessage("Sschedule Type is set as 'One Time within 24 hours'");
		  }catch(Exception e) {
				Log.addMessage("Failed to set schedule type as 'One Time Within 24 hours'");
				Assert.assertTrue(false, "Failed to set schedule type as 'One Time Within 24 hours'");
		  }
		}
	
	public void clickCancelButton() {
		try {
			Utility.waitForElementToBeVisible(cancelButton);
			Utility.waitForElementToBeClickable(cancelButton);
			cancelButton.click();
			if(device.contentEquals("iOS")) {
				Log.addMessage("Clicked Ok button in the pop up");
			}else
			Log.addMessage("Clicked cancel button in the pop up");
		}catch(Exception e) {
			Log.addMessage("Failed to display cancel button in the pop up");
			Assert.assertTrue(false, "Failed to display cancel button in the pop up");
		}
	}

	public void cliclStartNowButton() {
		try {
			Utility.waitForElementToBeVisible(startNowButton);
			Utility.waitForElementToBeClickable(startNowButton);
			startNowButton.click();
			Log.addMessage("Start now button is displayed in the pop up page");
		}catch(Exception e) {
			Log.addMessage("Failed to display Start now in the pop up page");
			Assert.assertTrue(false, "Failed to display Start now in the pop up page");
		}
	}
	
	public void verifyPopUpVerbiage(String expTitle, String expMessage, String iosMessage) {
		try {
			Utility.waitForElementToBeVisible(popUpTitleVerbiage);
			actTitle = popUpTitleVerbiage.getText();
			Assert.assertEquals(actTitle, expTitle,"Title message is not matching");
			Utility.waitForElementToBeVisible(popUpMessageVerbiage);
			actMessage = popUpMessageVerbiage.getText();
			System.out.println("exptitleMsg="+expTitle+",xptitleMsg="+actTitle+",expmainMsg="+expMessage+",mainMsg="+actMessage);
			if(device.contentEquals("iOS")) {//added on 22-05-2020
				Assert.assertEquals(actMessage, iosMessage,"Content message is not matching");
			}else {
				
				Assert.assertEquals(actMessage, expMessage,"Content message is not matching");
			}
			
			Log.addMessage("Pop up verbiage is matching");
		}catch(Exception e) {
			Log.addMessage("Pop up verbiage is not matching");
			Assert.assertTrue(false, "Pop up verbiage is not matching");
		}
	}
	
}
