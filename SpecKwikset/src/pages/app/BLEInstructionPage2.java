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

public class BLEInstructionPage2 extends Settings {
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Next']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_next"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_next"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_next"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_next")
	})
	@CacheLookup
	private MobileElement nextButton;
	
	//Constructor
	@SuppressWarnings("static-access")
	public BLEInstructionPage2(AppiumDriver<MobileElement> driver) {
	this.appiumDriver = driver;
	PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void clickNextButton() {
		try {
			Thread.sleep(6000);
			nextButton.click();
			Log.addMessage("Clicked Next button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Next button");
			Assert.assertTrue(false, "Failed to click Next button");
		}
	}


}
