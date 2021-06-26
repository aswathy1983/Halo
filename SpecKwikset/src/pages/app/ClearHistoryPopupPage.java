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

public class ClearHistoryPopupPage extends Settings {
	
	/*         created on 06-05-2020          */
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	@AndroidFindBy(id = "android:id/button2")
	@CacheLookup
	private MobileElement cancelButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Yes']")
	@AndroidFindBy(id = "android:id/button1")
	@CacheLookup
	private MobileElement yesButton;
	
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
		public ClearHistoryPopupPage(AppiumDriver<MobileElement> driver) {
			this.appiumDriver = driver;
			PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
		}
		
		public void verifyCancelButton() {
			try {
				Utility.waitForElementToBeVisible(cancelButton);
				Utility.waitForElementToBeClickable(cancelButton);
				//cancelButton.click();
				if(device.contentEquals("iOS")) {
					Log.addMessage("Cancel button displayed in the pop up");
				}else
				Log.addMessage("Cancel button displayed in the pop up");
			}catch(Exception e) {
				Log.addMessage("Failed to display cancel button in the pop up");
				Assert.assertTrue(false, "Failed to display cancel button in the pop up");
			}
		}

		public void clickYesButton() {
			try {
				Utility.waitForElementToBeVisible(yesButton);
				//Utility.waitForElementToBeClickable(yesButton);
				yesButton.click();
				Log.addMessage("Yes button is clicked in the pop up page");
			}catch(Exception e) {
				Log.addMessage("Failed to display Yes button in the pop up page");
				Assert.assertTrue(false, "Failed to display Yes button in the pop up page");
			}
		}
		
		public void verifyPopUpVerbiage(String expTitle, String expMessage) {
			try {
				Utility.waitForElementToBeVisible(popUpTitleVerbiage);
				actTitle = popUpTitleVerbiage.getText();
				Assert.assertEquals(actTitle, expTitle,"Title message is not matching");
				Log.addMessage("Pop up title verbiage is matching");
				Utility.waitForElementToBeVisible(popUpMessageVerbiage);
				actMessage = popUpMessageVerbiage.getText();
				System.out.println("exptitleMsg="+expTitle+",xptitleMsg="+actTitle+",expmainMsg="+expMessage+",mainMsg="+actMessage);
				/*if(device.contentEquals("iOS")) {//commented on 11-06-2020
					Assert.assertEquals(actMessage, iosMessage,"Content message is not matching");
				}else {*/
					
					Assert.assertEquals(actMessage, expMessage,"Popup content message is not matching");
				//}
				
				Log.addMessage("Pop up verbiage is matching");
			}catch(Exception e) {
				Log.addMessage("Pop up verbiage is not matching");
				Assert.assertTrue(false, "Pop up verbiage is not matching");
			}
		}

}
