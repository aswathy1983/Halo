package pages.app;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
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

public class EnterPasswordPage extends Settings{
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[1]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/edPassword"),
		@AndroidBy(id = "com.kwikset.blewifi:id/edPassword"),
		@AndroidBy(id = "com.spectrum.giga:id/edPassword"),
		@AndroidBy(id = "com.weiser.blewifi:id/edPassword")
	})
	@CacheLookup
	private MobileElement passwordField;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[2]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/edReEnterPassword"),
		@AndroidBy(id = "com.kwikset.blewifi:id/edReEnterPassword"),
		@AndroidBy(id = "com.spectrum.giga:id/edReEnterPassword"),
		@AndroidBy(id = "com.weiser.blewifi:id/edReEnterPassword")
	})
	@CacheLookup
	private MobileElement reEnterPasswordField;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Submit']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_submit"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_submit"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_submit"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_submit")
	})
	@CacheLookup
	private MobileElement submitButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Ok']")
	@AndroidFindBy(id = "android:id/button1")
	@CacheLookup
	private MobileElement OkButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='next']")
	private MobileElement nextKeyboard;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='done']")
	private MobileElement doneKeyboard;
	
	//added on 29-06-2020
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_back"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_back"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_back"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_back")
	})
	@CacheLookup
	private MobileElement backButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[2]")
	@AndroidFindBy(id="android:id/message")
	private MobileElement confirmMessage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[1]")
	@AndroidFindBy(id="android:id/alertTitle")
	private MobileElement alertTitle;
	
	String actTitle, actMessage, actBMessage, actualRes ="";
	
	
	//Constructor
	
	@SuppressWarnings("static-access")
	public EnterPasswordPage(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void enterPassword(String password) {
		try {
			Utility.waitForElementToBeVisible(passwordField);
			passwordField.clear();
			passwordField.sendKeys(password);
			Log.addMessage("Password entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter password");
			Assert.assertTrue(false, "Failed to enter password");
		}
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void enterPasswordNextKey(String password) {
		try {
			Utility.waitForElementToBeVisible(passwordField);
			passwordField.click();
			passwordField.clear();
			passwordField.sendKeys(password);
			Log.addMessage("Password entered");
			if(device.equals("iOS")) {
				nextKeyboard.click();
			}else {
				JavascriptExecutor js = appiumDriver;
				Map<String, Object> params = new HashMap<>();
				params.put("action", "Next");
				params.put("element", passwordField);
				js.executeScript("mobile: performEditorAction", params);
			}
			
			Log.addMessage("Clicked Next Button");
		}catch(Exception e) {
			Log.addMessage("Failed to enter password");
			Assert.assertTrue(false, "Failed to enter password");
		}
	}

	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void reEnterPassword(String password) {
		try {
			Utility.waitForElementToBeVisible(reEnterPasswordField);
			reEnterPasswordField.clear();
			reEnterPasswordField.sendKeys(password);
			Log.addMessage("Password re-entered");
		}catch(Exception e) {
			Log.addMessage("Failed to re-enter Password");
			Assert.assertTrue(false, "Failed to re-enter password");
		}
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void reEnterPasswordDoneKey(String password) {
		try {
			Utility.waitForElementToBeVisible(reEnterPasswordField);
			reEnterPasswordField.clear();
			reEnterPasswordField.sendKeys(password);
			Log.addMessage("Password re-entered");
			Log.addMessage("Phone Number entered");
			Log.addMessage("Email verification code entered");
			if(device.equals("iOS")) {
				doneKeyboard.click();
			}else {
				JavascriptExecutor js = appiumDriver;
				Map<String, Object> params = new HashMap<>();
				params.put("action", "Done");
				params.put("element", reEnterPasswordField);
				js.executeScript("mobile: performEditorAction", params);
			}
			Log.addMessage("Clicked Done Button");
		}catch(Exception e) {
			Log.addMessage("Failed to re-enter Password");
			Assert.assertTrue(false, "Failed to re-enter password");
		}
	}

	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
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
	
	
	/** 
	* Method Name: clickOKButton(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void clickOKButton() {
		try {
			Thread.sleep(5000);
			Utility.waitForElementToBeVisible(OkButton);
			OkButton.click();
			Log.addMessage("Clicked Ok Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Ok button");
			Assert.assertTrue(false, "Failed to click Ok button");
		}
	}
	
	/** 
	* Method Name: updatePassword(), 
	* This function is used to update Password in Edit field of  EditPassword Page
	*/
		
	public void valPassword(String nwPwd,String reNewPwd, String valMessage, String titleMsg, String iMessage) {
		try {		
			enterPassword(nwPwd);
			reEnterPassword(reNewPwd);
			clickSubmitButton();
			Thread.sleep(6000);
			if(OkButton.isDisplayed()) {
				if(titleMsg!="") {
					actTitle=alertTitle.getText();
					actMessage=confirmMessage.getText();
				}else {
					if(device.equals("iOS")) {
						actMessage=alertTitle.getText();
					}else {
						actMessage=confirmMessage.getText();
					}
				}
				System.out.println("mainMessage="+actMessage);
				System.out.println("actTitle="+actTitle);
				if(device.equals("iOS")) {
					setErrMsg(iMessage,actMessage,titleMsg, actTitle);	
				}else {
					setErrMsg(valMessage,actMessage,titleMsg, actTitle);	
				}
				System.out.println("after message");
				if(device.equals("android")) {
					if(titleMsg.equals("Account Created")) {
						OkButton.click();
					}
				}
				//Utility.simpleWait(5000);//commented on 8th Aug 2020
			}
			
			Log.addMessage("Password Updated and directed to AccountSettings page");
		}catch(Exception e) {
			Log.addMessage("Password Not Updated");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Password Not Updated");
		}
	}
	
	public void setErrMsg(String exRes, String mnMsg, String ttlMsg, String actTtl) {
		try {
			if(exRes!="") {
				if(OkButton.isDisplayed()) {
					System.out.println("two");
					OkButton.click();
					actualRes = mnMsg;
					if(ttlMsg!="") {
						actTitle = actTtl;
						System.out.println("actTitle---="+actTitle+", expttl="+ttlMsg);
						Assert.assertEquals(actTitle, ttlMsg,"Please check the title validation message.");
					}
					System.out.println("actualres---="+actualRes);
					System.out.println("exRes---="+exRes);
				}
				System.out.println("in Assert");
				
				//below code to bypass the assert error.
				//confirmVerificationButton.click();
				Assert.assertEquals(actualRes, exRes,"Please check the validation message.");
			}
		}catch(Exception e) {
			e.printStackTrace();
			Assert.assertEquals(false, "Expected message is null.");
		}
	}
	
	public void verifyUIPassword() {
		try {
			Utility.waitForElementToBeVisible(passwordField);
			Log.addMessage("Password field is displayed");
			Utility.waitForElementToBeVisible(reEnterPasswordField);
			Log.addMessage("Re-enter password field is displayed");
			Utility.waitForElementToBeVisible(submitButton);
			Log.addMessage("Submit button is displayed");
			Utility.waitForElementToBeVisible(backButton);
			Log.addMessage("Back button is displayed");
			/*Utility.waitForElementToBeVisible(backButton);
			Log.addMessage("Info button is displayed");*/
			Assert.assertTrue(true,"All elements displayed in enter password page");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to display all elements in enter password page");
			Assert.assertTrue(false, "Failed to display all elements in enter password page");
		}
	}
	
	//added on 01-07-2020
	/** 
	* Method Name: clickBackButton(), 
	* This function is used to select Back option from the Name Page
	*/
		
	public void clickBackButton() {
		try {
			Utility.waitForElementToBeVisible(backButton);
			Utility.waitForElementToBeClickable(backButton);
			backButton.click();
			Log.addMessage("Clicked Back Button");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click Back button");
			Assert.assertTrue(false, "Failed to click Back button");
		}
	}
	
	public void valSuccessPopUp(String ttlMessage, String expMessage,String ttliMessage, String expiMessage) {
		try {
			Utility.waitForElementToBeVisible(alertTitle);
			actMessage = alertTitle.getText();
			actBMessage = confirmMessage.getText();
			System.out.println("expmainMsg="+expMessage+",mainMsg="+actMessage);
			OkButton.click();
			if(device.equals("android")) {
				Assert.assertEquals(actMessage, ttlMessage,"Popup title message is not matching");
				Log.addMessage("Tile message is matching");
				Assert.assertEquals(actBMessage, expMessage,"Popup content message is not matching");
				Log.addMessage("Pop up verbiage is matching");
			}else {
				Assert.assertEquals(actMessage, ttliMessage,"Popup title message is not matching");
				Log.addMessage("Tile message is matching");
				Assert.assertEquals(actBMessage, expiMessage,"Popup content message is not matching");
				Log.addMessage("Pop up verbiage is matching");
			}
		}catch(Exception e) {
			Log.addMessage("Pop up verbiage is not matching");
			Assert.assertTrue(false, "Pop up verbiage is not matching");
		}
	}
	
	public void valSuccessSessionPopUp(String ttlMessage, String expMessage) {
		try {
			Utility.waitForElementToBeVisible(alertTitle);
			actMessage = alertTitle.getText();
			actBMessage = confirmMessage.getText();
			System.out.println("expmainMsg="+expMessage+",mainMsg="+confirmMessage.getText());
			OkButton.click();
			Assert.assertEquals(actMessage, ttlMessage,"Popup title message is not matching");
			Log.addMessage("Tile message is matching");
			Assert.assertEquals(actBMessage, expMessage,"Popup content message is not matching");
			Log.addMessage("Pop up verbiage is matching");
		}catch(Exception e) {
			Log.addMessage("Pop up verbiage is not matching");
			Assert.assertTrue(false, "Pop up verbiage is not matching");
		}
	}
	
	public void valDisblSuccessSessionPopUp(String ttlMessage, String expMessage) {
		try {
			Utility.waitForElementToBeVisible(alertTitle);
			actMessage = alertTitle.getText();
			actBMessage = confirmMessage.getText();
			System.out.println("expmainMsg="+expMessage+",mainMsg="+confirmMessage.getText());
			OkButton.click();
			Assert.assertEquals(actMessage, ttlMessage,"Popup title message is not matching");
			Log.addMessage("Tile message is matching");
			Assert.assertEquals(actBMessage, expMessage,"Popup content message is not matching");
			Log.addMessage("Pop up verbiage is matching");
		}catch(Exception e) {
			Log.addMessage("Pop up verbiage is not matching");
			if(device.equals("android")) {
				 appiumDriver.closeApp();//.runAppInBackground(10);//put app in background for 10 seconds
	   			 appiumDriver.launchApp();//launch the app again
			}
			Assert.assertTrue(false, "Pop up verbiage is not matching");
		}
	}
	
	public void verifySuccessSessionPopUp(String ttlMessage, String expMessage) {
		try {
			Utility.waitForElementToBeVisible(alertTitle);
			actMessage = alertTitle.getText();
			actBMessage = confirmMessage.getText();
			System.out.println("expmainMsg="+expMessage+",mainMsg="+confirmMessage.getText());
			OkButton.click();
			if(actMessage.equals(ttlMessage)) {
				Assert.assertTrue(false,"Session expired after forgot password flow");
				Log.addMessage("Session expired after forgot password flow");
			}else {
				Assert.assertTrue(false,"Unable to login a pop up found");
				Log.addMessage("Unable to login a pop up found");
			}
			
		}catch(Exception e) {
			Log.addMessage("Session not expired");
			Assert.assertTrue(true,"Session not expired");
		}
	}
	
	public void verifyDeletedAccountPopUp(String ttlMessage) {
		try {
			if(device.equals("android")) {
				Utility.waitForElementToBeVisible(confirmMessage);
				actMessage = confirmMessage.getText();
			}else {
				Utility.waitForElementToBeVisible(alertTitle);
				actMessage = alertTitle.getText();
			}
			System.out.println("mainMsg="+actMessage);
			OkButton.click();
			if(actMessage.contains(ttlMessage)) {
				Assert.assertTrue(true,"Popup title message is matching");
				Log.addMessage("Popup title message is matching");
			}else {
				Assert.assertTrue(false,"Popup title message is not matching");
				Log.addMessage("Popup title message is not matching");
			}
			
		}catch(Exception e) {
			Log.addMessage("Pop up verbiage is not matching");
			Assert.assertTrue(false, "Pop up verbiage is not matching");
		}
	}
	
	public void verifyDeletedFailPopUp(String ttlMessage) {
		try {
			Utility.waitForElementToBeVisible(alertTitle);
			actMessage = alertTitle.getText();
			System.out.println("mainMsg="+actMessage);
			OkButton.click();
			Assert.assertEquals(actMessage, ttlMessage,"Popup title message is not matching");
			Log.addMessage("Pop up verbiage is matching");
		}catch(Exception e) {
			Log.addMessage("Pop up verbiage is not matching");
			Assert.assertTrue(false, "Pop up verbiage is not matching");
		}
	}
	
}
