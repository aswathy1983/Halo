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

public class CreateAHomePage extends Settings{

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Create A Home']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/btn_add"),
		@AndroidBy(id = "com.kwikset.blewifi:id/btn_add"),
		@AndroidBy(id = "com.spectrum.giga:id/btn_add"),
		@AndroidBy(id = "com.weiser.blewifi:id/btn_add")
	})
	@CacheLookup
	private MobileElement createAHomeButton;
	
	@AndroidFindBy(id="android:id/button2")
	private MobileElement cancelButton;
	
	//Constructor
	
	@SuppressWarnings("static-access")
	
	public CreateAHomePage(AppiumDriver<MobileElement> driver) {
	this.appiumDriver = driver;
	PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
		
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
			
	public void clickCreateAHomeButton() {
		try {
			Utility.waitForElementToBeVisible(createAHomeButton);
			Utility.waitForElementToBeClickable(createAHomeButton);
			createAHomeButton.click();
			Log.addMessage("Create A Home button clicked");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click Create A Home button");
			Assert.assertTrue(false, "Failed to click Create A Home button");
		}
	}
	
	public void verifyCreateHomeButton() {
		try {
			//Utility.simpleWait(7000);
			Utility.waitForElementToBeVisible(createAHomeButton);
			Utility.waitForElementToBeClickable(createAHomeButton);
			Log.addMessage("Create home button is displayed");
			if(createAHomeButton.getText().equals("Create A Home")) {
				Assert.assertTrue(true,"Failed to display 'Create A Home' button");
				Log.addMessage("'Create A Home' button is displayed");
			}
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to display 'Create A Home' button");
			Assert.assertTrue(false, "Failed to display 'Create A Home' button");
		}
	}
	
	/** 
	* Method Name: clickCancelButton(), 
	* This function is used to click cancel button
	*/
		
	public void clickCancelButton() {
		try {
			Utility.waitForElementToBeVisible(cancelButton);
			Utility.waitForElementToBeClickable(cancelButton);
			cancelButton.click();
			Log.addMessage("Clicked cancel button");
		}catch(Exception e) {
			Log.addMessage("Failed to click cancel button");
			Assert.assertTrue(false, "Failed to click cancel button");
		}
	}
	
	


}
