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

public class SettingsPage extends Settings{
	//XCUIElementTypeStaticText[@name="Account"]/parent::XCUIElementTypeCell//added on 25-05-2020
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell")
	@AndroidFindAll({
		/*@AndroidBy(id = "com.kwikset.blewifi.dev:id/tvAccount"),//commented on 19-02-2021
		@AndroidBy(id = "com.kwikset.blewifi:id/tvAccount"),
		@AndroidBy(id = "com.spectrum.giga:id/tvAccount"),
		@AndroidBy(id = "com.weiser.blewifi:id/tvAccount")*/
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_name"),
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_name"),
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_name"),
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_name")
	})
	@CacheLookup
	private MobileElement accountOption;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/backArrowLayout"),
		@AndroidBy(id = "com.kwikset.blewifi:id/backArrowLayout"),
		@AndroidBy(id = "com.spectrum.giga:id/backArrowLayout"),
		@AndroidBy(id = "com.weiser.blewifi:id/backArrowLayout")
	})//added on 04-05-2020
	@CacheLookup
	private MobileElement backButton;

	
	//Constructor
	
	@SuppressWarnings("static-access")
	public SettingsPage(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
		
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
			
	public void clickAccountOption() {
		try {
			Utility.waitForElementToBeVisible(accountOption);
			Utility.waitForElementToBeClickable(accountOption);
			accountOption.click();
			Log.addMessage("Clicked Account option");
		}catch(Exception e) {
			Log.addMessage("Failed to click Account option.");
			Assert.assertTrue(false, "Failed to click Account option.");
		}
	}
	
	/*  Code added on 04-05-2020  */
	
	/** 
	* Method Name: clickNavBack(), 
	* This function is used to go Back from Account Page to Lock Settings Page
	*/
			
	public void clickNavBack() {
		try {
			Utility.waitForElementToBeVisible(backButton);
			Utility.waitForElementToBeClickable(backButton);
			backButton.click();
			Log.addMessage("Clicked Back Button");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click Back option.");
			Assert.assertTrue(false, "Failed to click Back option.");
		}
	}

}

