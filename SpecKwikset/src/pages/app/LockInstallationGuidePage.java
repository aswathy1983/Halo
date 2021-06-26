package pages.app;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import utility.Log;
import utility.Utility;

public class LockInstallationGuidePage extends Settings{
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Skip']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tvSkip"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tvSkip"),
		@AndroidBy(id = "com.spectrum.giga:id/tvSkip"),
		@AndroidBy(id = "com.weiser.blewifi:id/tvSkip")
	})
	@CacheLookup
	private MobileElement skipButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/cancelAllhomes"),
		@AndroidBy(id = "com.kwikset.blewifi:id/cancelAllhomes"),
		@AndroidBy(id = "com.spectrum.giga:id/cancelAllhomes"),
		@AndroidBy(id = "com.weiser.blewifi:id/cancelAllhomes")
	})
	@CacheLookup
	private MobileElement backButton;

	//Constructor
		@SuppressWarnings("static-access")
		public LockInstallationGuidePage(AppiumDriver<MobileElement> driver) {
			this.appiumDriver = driver;
			PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
		}
		
		
	/** 
	* Method Name: clickSkipButton(), 
	* This function is used to skip Lock Installation guide
	*/
	public void clickSkipButton() {
		try {
			skipButton.click();
			Log.addMessage("Skipped Lock Installation Guide");
		}catch(Exception e) {
			Log.addMessage("'Skip' button is not present");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Skip' button is not present");
		}
	}
	
	/** 
	* Method Name: clickBackButton(), 
	* This function is used to click Back button from Lock Installation page
	*/
		
	public void clickBackButton() {
		try {
			Thread.sleep(6000);
			System.out.println("in lockname backmthd");
			Utility.waitForElementToBeVisible(backButton);
			Utility.waitForElementToBeClickable(backButton);
			System.out.println("inside clickBackButton");
			backButton.click();
			System.out.println("clicked clickBackButton");
			Log.addMessage("Clicked Back Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Back button");
			Assert.assertTrue(false, "Failed to click Back button");
		}
	}

}
