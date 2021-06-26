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

public class WifiScanCancelPopupPage extends Settings {
	
	/*         created on 08-05-2020          */
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Cancel\"]")//added on 19-05-2020
	@AndroidFindBy(id = "android:id/button2")
	@CacheLookup
	private MobileElement cancelButton;
	
	//Constructor
	@SuppressWarnings("static-access")
	public WifiScanCancelPopupPage(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}

	/** 
	* Method Name: clickCancelButton(), 
	* This function is used to click Back button from Manual Setup page
	*/
		
	public void clickCancelButton() {
		try {
			Thread.sleep(6000);
			cancelButton.click();
			Log.addMessage("Clicked Cancel from Wifi Scanning popup page");
		}catch(Exception e) {
			Log.addMessage("Failed to click Back button from Wifi Scanning popup page");
			Assert.assertTrue(false, "Failed to click Back button from Wifi Scanning popup page");
		}
	}

}
