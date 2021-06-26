package pages.app;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import utility.Log;
import utility.Utility;

public class ManualSetupPage extends Settings {
	
	/*         created on 08-05-2020          */
	
	//XCUIElementTypeButton[@name="Back"]

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")//added on 19-05-2020
	@AndroidFindBy(id = "com.kwikset.blewifi.dev:id/cancelAllhomes")
	@CacheLookup
	private MobileElement backButton;
	
	//Constructor
	@SuppressWarnings("static-access")
	public ManualSetupPage(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
	
	/** 
	* Method Name: clickBackButton(), 
	* This function is used to click Back button from Manual Setup page
	*/
		
	public void clickBackButton() {
		try {
			Thread.sleep(6000);
			Utility.waitForElementToBeVisible(backButton);//added on 19-05-2020
			backButton.click();
			Log.addMessage("Clicked Back Button from Manual Setup page");
		}catch(Exception e) {
			Log.addMessage("Failed to click Back button from Manual Setup page");
			Assert.assertTrue(false, "Failed to click Back button from Manual Setup page");
		}
	}

}
