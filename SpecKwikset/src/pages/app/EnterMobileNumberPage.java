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

public class EnterMobileNumberPage extends Settings{
		
	/*@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tvPhone"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tvPhone"),
		@AndroidBy(id = "com.spectrum.giga:id/tvPhone"),
		//@AndroidBy(id = "com.weiser.blewifi:id/tvPhone")commented to add below for weiser beta
		@AndroidBy(id = "com.spectrum.giga:id/etCode")
	})*/
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[2]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/edtPhone"),
		@AndroidBy(id = "com.kwikset.blewifi:id/edtPhone"),
		@AndroidBy(id = "com.spectrum.giga:id/edtPhone"),
		//@AndroidBy(id = "com.weiser.blewifi:id/tvPhone")commented to add below for weiser beta
		@AndroidBy(id = "com.spectrum.giga:id/edtPhone")
	})
	@CacheLookup
	private MobileElement phoneNumberField;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='United States (+1)']")
	@CacheLookup
	private MobileElement countryCodeField;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Submit']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_submit"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_submit"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_submit"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_submit")
	})
	@CacheLookup
	private MobileElement submitButton;
	
	//added on 11-07-2020
	@iOSXCUITFindBy(id = "Back")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_back"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_back"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_back"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_back")
	})
	@CacheLookup
	private MobileElement backButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
	private MobileElement doneKeyboard;
	
	@iOSXCUITFindBy(id = "Ok")
	@AndroidFindBy(id="android:id/button1")
	private MobileElement OKButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[2]")
	@AndroidFindBy(id="android:id/message")
	private MobileElement confirmMessage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[1]")
	@AndroidFindBy(id="android:id/alertTitle")
	private MobileElement alertTitle;
	
	String actTitle, actMessage, actualRes ="";
	
	
	//Constructor
	
	@SuppressWarnings("static-access")
	public EnterMobileNumberPage(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void enterMobileNumber(String phoneNumber) {
		try {
			System.out.println("in phone");
			Utility.waitForElementToBeVisible(phoneNumberField);
			//Utility.waitForElementToBeClickable(phoneNumberField);
			System.out.println("in phoneNumber="+phoneNumber);
			phoneNumberField.clear();
			phoneNumberField.sendKeys(phoneNumber);
			System.out.println("after phone");
			Log.addMessage("Phone Number entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter phone number");
			Assert.assertTrue(false, "Failed to enter phone number");
		}
	}
	
	/** 
	* Method Name: enterMobileNumberDoneKey(), 
	* This function is used to enter done key in keyboard from the phone number Page
	*/	
	public void enterMobileNumberDoneKey(String phoneNumber) {
		try {
			Utility.waitForElementToBeVisible(phoneNumberField);
			phoneNumberField.click();
			phoneNumberField.clear();
			phoneNumberField.sendKeys(phoneNumber);
			Log.addMessage("Phone Number entered");
			Log.addMessage("Email verification code entered");
			
			if(device.equals("iOS")) {
				doneKeyboard.click();
			}else {
				JavascriptExecutor js = appiumDriver;
				Map<String, Object> params = new HashMap<>();
				params.put("action", "Done");
				params.put("element", phoneNumberField);
				js.executeScript("mobile: performEditorAction", params);
			}
			
			Log.addMessage("Clicked Done Button");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to enter phone number");
			Assert.assertTrue(false, "Failed to enter phone number");
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
			/*if(device.equals("android")) {
				Utility.waitForElementToBeVisible(oKButton);
				Utility.waitForElementToBeClickable(oKButton);
				oKButton.click();
			}*/
			Log.addMessage("Clicked Submit Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Submit button");
			Assert.assertTrue(false, "Failed to click Submit button");
		}
	}
	
	//added on 29-06-2020
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
	
	/** 
	* Method Name: valPhoneNumber(), 
	* This function is used to update PhoneNumber in PhoneNumber Page
	*/
	public void valPhoneNumber(String mobileNum, String titleMsg, String errMessage, String ititleMsg, String iMessage) {
		try {
			if(checkCountryCodeButton()) {
				
			}
			enterMobileNumber(mobileNum);			
			clickSubmitButton();
			if(mobileNum!="") {
				if(mobileNum.length()>=10) {
					Utility.simpleWait(6000);
				}
			}
			System.out.println("updated");
			if(device.equals("android")) {
				if(OKButton.isDisplayed()) {
					if(titleMsg!="") {
						actTitle=alertTitle.getText();
						actMessage=confirmMessage.getText();
					}else {
						actMessage=confirmMessage.getText();
					}
					System.out.println("mainMessage="+actMessage);
					setErrMsg(errMessage,actMessage,titleMsg, actTitle);
					Utility.simpleWait(2000);
				}
			}else {
				if(ititleMsg!="") {
					actTitle=alertTitle.getText();
					actMessage=confirmMessage.getText();
				}else {
					actMessage=alertTitle.getText();
				}
				System.out.println("mainMessage="+actMessage);
				//setErrMsg(errMessage,actMessage,titleMsg, actTitle);
				setErrMsg(iMessage,actMessage,ititleMsg, actTitle);
				Utility.simpleWait(2000);
			}
			//verfCodeSubmit.click();
			System.out.println("out");
			Utility.simpleWait(3000);
			Log.addMessage("Phone Number Updated and directed to AccountSettings page");
		}catch(Exception e) {
			Log.addMessage("Phone Number Not Updated");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Phone Number Not Updated");
		}
	}
	
	public void setErrMsg(String exRes, String mnMsg, String ttlMsg, String actTtl) {
		try {
			System.out.println("in errmsg");
			if(exRes!="") {
				System.out.println("in errmsg2");
				if(OKButton.isDisplayed()) {
					System.out.println("in confirmVerificationButton");
					OKButton.click();
					actualRes = mnMsg;
					
					if(ttlMsg!="") {
						actTitle = actTtl;
						System.out.println("actTitle---="+actTitle+", expttl="+ttlMsg);
						Assert.assertEquals(actTitle, ttlMsg,"Please check the title validation message.");
					}
				}
				System.out.println("actRes---="+actualRes);
				System.out.println("expRes---="+exRes);
				Assert.assertEquals(actualRes, exRes,"Please check the validation message.");
			}
		}catch(Exception e) {
			System.out.println("catch errmssg");
			e.printStackTrace();
			Assert.assertEquals(false, "Expected message is null.");
		}
	}
	
	/** 
	* Method Name: checkCountryCodeButton(), 
	* This function is used to check for country code Button
	*/
		
	public boolean checkCountryCodeButton() {
		try {			
			if(device.equals("iOS")) {
				Utility.waitForElementToBeVisible(countryCodeField);
				countryCodeField.click();
			}
			//Thread.sleep(5000);
			Log.addMessage("Country Code button visible in phone verification page");;
			return true;
		}catch(Exception e) {
			Log.addMessage("Country Code button not visible in phone verification page");
			System.out.println(e.getMessage().toString());
			return false;
		}
	}
	
	
	/** 
	* Method Name: clickOKButton(), 
	* This function is used to click OK Button
	*/
		
	public void clickOKButton() {
		try {			
			Utility.waitForElementToBeVisible(OKButton);
			Utility.waitForElementToBeClickable(OKButton);
			OKButton.click();	
			Log.addMessage("Clicked OK button in phone number page");
		}catch(Exception e) {
			Log.addMessage("Failed to click OK button in phone number page");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click OK button in phone number page");
		}
	}
		

}
