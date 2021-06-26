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

public class AccountNamePage extends Settings{
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[1]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/first_name"),
		@AndroidBy(id = "com.kwikset.blewifi:id/first_name"),
		@AndroidBy(id = "com.spectrum.giga:id/first_name"),
		@AndroidBy(id = "com.weiser.blewifi:id/first_name")
	})
	@CacheLookup
	private MobileElement firstNameField;
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[2]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/last_name"),
		@AndroidBy(id = "com.kwikset.blewifi:id/last_name"),
		@AndroidBy(id = "com.spectrum.giga:id/last_name"),
		@AndroidBy(id = "com.weiser.blewifi:id/last_name")
	})
	@CacheLookup
	private MobileElement lastNameField;
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Next']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_next"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_next"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_next"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_next")
	})
	@CacheLookup
	private MobileElement nextButton;
	
	//added on 29-06-2020
	@iOSXCUITFindBy(id = "Back")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_back"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_back"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_back"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_back")
	})
	@CacheLookup
	private MobileElement backButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/email"),
		@AndroidBy(id = "com.kwikset.blewifi:id/email"),
		@AndroidBy(id = "com.spectrum.giga:id/email"),
		@AndroidBy(id = "com.weiser.blewifi:id/email")
	})
	@CacheLookup
	private MobileElement emailField;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Next:']")
	private MobileElement nextKeyboard;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
	private MobileElement doneKeyboard;
	
	@iOSXCUITFindBy(id = "Ok")
	@AndroidFindBy(id = "android:id/button1")
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
	public AccountNamePage(AppiumDriver<MobileElement> driver) {
	this.appiumDriver = driver;
	PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void enterFirstName(String firstname) {
		try {
			Utility.waitForElementToBeVisible(firstNameField);
			//Utility.waitForElementToBeClickable(firstNameField);
			//firstNameField.click();
			firstNameField.clear();
			firstNameField.sendKeys(firstname);
			Log.addMessage("First Name entered");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to enter first name");
			Assert.assertTrue(false, "Failed to enter first name");
		}
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void enterLastName(String lastname) {
		try {
			Utility.waitForElementToBeVisible(firstNameField);
			//Utility.waitForElementToBeClickable(firstNameField);
			//lastNameField.click();
			lastNameField.clear();
			lastNameField.sendKeys(lastname);
			Log.addMessage("Last Name entered");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to enter last name");
			Assert.assertTrue(false, "Failed to enter last name");
		}
	}
	
	/** 
	* Method Name: clickNextButton(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void clickNextButton() {
		try {
			Utility.waitForElementToBeVisible(nextButton);
			Utility.waitForElementToBeClickable(nextButton);
			nextButton.click();
			Log.addMessage("Clicked Next Button");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click Next button");
			Assert.assertTrue(false, "Failed to click Next button");
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
	
	public void verifyUIAccountName() {
		try {
			Utility.waitForElementToBeVisible(firstNameField);
			Log.addMessage("First Name is displayed");
			Utility.waitForElementToBeVisible(lastNameField);
			Log.addMessage("Last Name is displayed");
			Utility.waitForElementToBeVisible(nextButton);
			Log.addMessage("Next button is displayed");
			Utility.waitForElementToBeVisible(backButton);
			Log.addMessage("Back button is displayed");
			Assert.assertTrue(true,"All elements displayed in account name page");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to display all elements in account name page");
			Assert.assertTrue(false, "Failed to display all elements in account name page");
		}
	}
	
	@SuppressWarnings("unchecked")
	public void valAccountName(String firstname,String lastname, String titleMsg, String errMessage, String iMessage) {
		try {
			enterFirstName(firstname);
			enterLastName(lastname);			
			clickNextButton();
            //Utility.simpleWait(2000);	
			if(OKButton.isDisplayed()) {
				if(titleMsg!="") {
					actTitle=alertTitle.getText().trim();
					actMessage=confirmMessage.getText().trim();
				}else {
					actMessage=alertTitle.getText().trim();
				}
				System.out.println("mainMessage="+actMessage);
				if(device.equals("iOS")) {
					setErrMsg(iMessage,actMessage,titleMsg, actTitle);
				}else {
					setErrMsg(errMessage,actMessage,titleMsg, actTitle);
				}
				System.out.println("after validation");
				Utility.simpleWait(2000);
			}
			Log.addMessage("Account Name Updated and directed to AccountSettings page");
		}catch(Exception e) {
			Log.addMessage("Validation message not proper for account name");
			System.out.println(e.getMessage().toString());
			try {
				EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
				Utility.waitForElementToBeVisible(emailField);
				if(device.equals("iOS")) {//on create user flow
					 ee.clickBackIButton();
				 }else {
					 ee.clickBackButton();
				 }
				Assert.assertTrue(false, "Account Name Not validated");
			}catch(Exception ex) {
				Log.addMessage("Account Name Not Updated");
				System.out.println(ex.getMessage().toString());
				Assert.assertTrue(false, "Validation message not proper for account name");
			}
			
		}
	}
		
	public void setErrMsg(String exRes, String mnMsg, String ttlMsg, String actTtl) {
		try {
			System.out.println("in errmsg");
			actualRes = "";
			actTitle = "";
			if(exRes!="") {
				System.out.println("in errmsg2");
				if(OKButton.isDisplayed()) {
					OKButton.click();
					System.out.println("in confirmVerificationButton");
					actualRes = mnMsg;
					//System.out.println("in actualRes="+confirmMessage.getText());
					if(ttlMsg!="") {
						actTitle = actTtl;
						if(actTitle.equals(ttlMsg)) {
							System.out.println("title true");
							
						}
						System.out.println("actTitle---="+actTitle+", expttl="+ttlMsg);
						Assert.assertEquals(actTitle, ttlMsg,"Please check the title validation message.");
						System.out.println("assert true1");
					}
				}
				System.out.println("actRes---="+actualRes);
				System.out.println("expRes---="+exRes);
				if(actualRes.trim().equals(exRes.trim())) {
					System.out.println("true");
				}else {
					System.out.println("false");
				}
				Assert.assertEquals(actualRes, exRes,"Please check the validation message.");
				System.out.println("assert true2");
			}
		}catch(Exception e) {
			e.printStackTrace();
			Assert.assertEquals(false, "Expected message is null.");
		}
	}
	/** 
	* Method Name: clickNextKey(), 
	* This function is used to select Email option from the MFA Page
	*/	
	public void clickFirstNameNextKey(String firstname) {
		try {
			//Script to select done button from the keyboard 
			//added on 01-07-2020
			Utility.waitForElementToBeVisible(firstNameField);
			firstNameField.click();
			firstNameField.clear();
			firstNameField.sendKeys(firstname);
			if(device.equals("iOS")) {
				nextKeyboard.click();
			}else {
				Map<String, Object> params = new HashMap<>();
				JavascriptExecutor js = appiumDriver;
				params.put("action", "Next");
				params.put("element", firstNameField);
				js.executeScript("mobile: performEditorAction", params);
			}
			Log.addMessage("Clicked Next Button");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click Next button");
			Assert.assertTrue(false, "Failed to click Next button");
		}
	}
	public void clickLastNameDoneKey(String lastname) {
		try {
			//Script to select done button from the keyboard 
			//added on 01-07-2020
			Utility.waitForElementToBeVisible(lastNameField);
			lastNameField.click();
			lastNameField.clear();
			lastNameField.sendKeys(lastname);
			
			if(device.equals("iOS")) {
				doneKeyboard.click();
			}else {
				JavascriptExecutor js = appiumDriver;
				Map<String, Object> params = new HashMap<>();
				params.put("action", "Done");
				params.put("element", lastNameField);
				js.executeScript("mobile: performEditorAction", params);
			}
			Log.addMessage("Clicked Next Button");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click Next button");
			Assert.assertTrue(false, "Failed to click Next button");
		}
	}
	//added on 02-07-2020
	/** 
	* Method Name: clickOKButton(), 
	* This function is used to select Back option from the Name Page
	*/
		
	public void clickOKButton() {
		try {
			Utility.waitForElementToBeVisible(OKButton);
			Utility.waitForElementToBeClickable(OKButton);
			OKButton.click();
			Log.addMessage("Clicked OK Button");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click OK button");
			Assert.assertTrue(false, "Failed to click OK button");
		}
	}
}
