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

public class BLEPopUpiOSPage extends Settings {
	
	/*         created on 20-05-2020          */
	
	@iOSXCUITFindBy(id = "Close")
	@CacheLookup
	private MobileElement closeButton;
	
	@iOSXCUITFindBy(id = "Settings")
	@AndroidFindBy(id = "android:id/button1")
	@CacheLookup
	private MobileElement settingsButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[1]")
	@AndroidFindBy(id = "android:id/message")
	@CacheLookup
	private MobileElement popUpMessageVerbiage;
	
	String actTitle, actMessage ="";
	
		//Constructor
	
		@SuppressWarnings("static-access")
		public BLEPopUpiOSPage(AppiumDriver<MobileElement> driver) {
			this.appiumDriver = driver;
			PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
		}
		
		public void clickCloseButton() {
			try {
				Utility.waitForElementToBeVisible(closeButton);
				Utility.waitForElementToBeClickable(closeButton);
				closeButton.click();
				if(device.contentEquals("iOS")) {
					Log.addMessage("Clicked close button in the pop up");
				}else
				Log.addMessage("Clicked close button in the pop up");
			}catch(Exception e) {
				Log.addMessage("Failed to display close button in the pop up");
				Assert.assertTrue(false, "Failed to display close button in the pop up");
			}
		}

		public void verifySettingsButton() {
			try {
				Utility.waitForElementToBeVisible(settingsButton);
				Utility.waitForElementToBeClickable(settingsButton);
				settingsButton.click();
				Log.addMessage("Settings button is displayed in the pop up page");
			}catch(Exception e) {
				Log.addMessage("Failed to display Settings button in the pop up page");
				Assert.assertTrue(false, "Failed to display Settings button in the pop up page");
			}
		}
		
		public void verifyPopUpVerbiage(String expMessage) {
			try {
				Utility.waitForElementToBeVisible(popUpMessageVerbiage);
				actMessage = popUpMessageVerbiage.getText();
				System.out.println("expmainMsg="+expMessage+",mainMsg="+actMessage);
				Assert.assertEquals(actMessage, expMessage,"Content message is not matching");
				
				Log.addMessage("Pop up verbiage is matching");
			}catch(Exception e) {
				Log.addMessage("Pop up verbiage is not matching");
				Assert.assertTrue(false, "Pop up verbiage is not matching");
			}
		}

}
