package pages.app;

import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import utility.Log;
import utility.Utility;

public class SelectWeekDayPage extends Settings{
	
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
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Submit']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_submit"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_submit"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_submit"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_submit"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/tv_submit")
	})
	@CacheLookup
	private MobileElement submitButton;
		
	@iOSXCUITFindBy(id = "Clear All Days")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/textViewClearAll"),
		@AndroidBy(id = "com.kwikset.blewifi:id/textViewClearAll"),
		@AndroidBy(id = "com.spectrum.giga:id/textViewClearAll"),
		@AndroidBy(id = "com.weiser.blewifi:id/textViewClearAll"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/textViewClearAll")
	})
	@CacheLookup		
	private MobileElement clearAllDaysOption;
	
	@iOSXCUITFindBy(id = "Monday")
	@CacheLookup
	private MobileElement monday;
	
	@iOSXCUITFindBy(id = "Tuesday")
	@CacheLookup
	private MobileElement tuesday;
	
	@iOSXCUITFindBy(id = "Wednesday")
	@CacheLookup
	private MobileElement wednesday;
	
	@iOSXCUITFindBy(id = "Thursday")
	@CacheLookup
	private MobileElement thursday;
	
	@iOSXCUITFindBy(id = "Friday")
	@CacheLookup
	private MobileElement friday;
	
	@iOSXCUITFindBy(id = "Saturday")
	@CacheLookup
	private MobileElement saturday;
	
	@iOSXCUITFindBy(id = "Sunday")
	@CacheLookup
	private MobileElement sunday;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText")
	@CacheLookup
	private MobileElement messagePopup;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Ok']")
	@AndroidFindBy(id = "android:id/button1")
	@CacheLookup
	private MobileElement OkButton;
	
	By timePicker = MobileBy.xpath("//XCUIElementTypePickerWheel");
	
	WebDriverWait wait = new WebDriverWait(driver,10);


	//Constructor
	@SuppressWarnings("static-access")
	public SelectWeekDayPage(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
		
		
	/** 
	* Method Name: clickClearAllDaysOption(), 
	* This function is used to clear all days option
	*/
	public void clickClearAllDaysOption() {
		try {
			Utility.waitForElementToBeVisible(clearAllDaysOption);
			Utility.waitForElementToBeClickable(clearAllDaysOption);
			clearAllDaysOption.click();
			Log.addMessage("Clear All Days option clicked");
		}catch(Exception e) {
			Log.addMessage("Failed to click Clear All Days option");
			Assert.assertTrue(false, "Failed to click days to allow option");
		}
	}
	
	/** 
	* Method Name: selectADay(), 
	* This function is used to select a day
	*/
	public void selectADay(String day) {
		try {
			Thread.sleep(6000);
			
			switch(day) {
			
			case "Monday" : monday.click();
							break;
							
			case "Tuesday" : tuesday.click();
							 break;
			
			case "Wednesday" : wednesday.click();
			break;
			
			case "Thursday" : thursday.click();
			break;
			
			case "Friday" : friday.click();
			break;
			
			case "Saturday" : saturday.click();
			break;
			
			case "Sunday" : sunday.click();
			break;
							
			default: monday.click();
			break;
							
			}
		  Log.addMessage("Selected day is: "+day);
		}catch(Exception e) {
			Log.addMessage("Failed to select a day");
			Assert.assertTrue(false, "Failed to select a day");
		}
	}
	
	public void clickSubmitButton() {
		  try {
			  Utility.waitForElementToBeVisible(submitButton);
			  Utility.waitForElementToBeClickable(submitButton);
			  submitButton.click();
			  Log.addMessage("Clicked Submit Button");
		  }catch(Exception e) {
				Log.addMessage("Failed to click Submit button");
				Assert.assertTrue(false, "Failed to click Submit button");
		  }
	}
	
	public void clickOkButton() {
		  try {
			  Thread.sleep(6000);
			  OkButton.click();
			  Log.addMessage("Clicked Ok Button");
		  }catch(Exception e) {
				Log.addMessage("Failed to click Ok button");
				Assert.assertTrue(false, "Failed to click Ok button");
		  }
	}
	
	public void clickBackButton() {
		  try {
			  Utility.waitForElementToBeVisible(backButton);
			  Utility.waitForElementToBeClickable(backButton);
			  backButton.click();
			  Log.addMessage("Clicked back button");
		  }catch(Exception e) {
				Log.addMessage("Failed to click back button");
				Assert.assertTrue(false, "Failed to click back button");
		  }
	}
}
