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

public class ChooseVerificationMethodPage extends Settings{
	
	@iOSXCUITFindBy(xpath ="//XCUIElementTypeButton[normalize-space(@name)='Email']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/rd_email"),
		@AndroidBy(id = "com.kwikset.blewifi:id/rd_email"),
		@AndroidBy(id = "com.spectrum.giga:id/rd_email"),
		@AndroidBy(id = "com.weiser.blewifi:id/rd_email"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/rd_email")
	})
	@CacheLookup
	private MobileElement email;
	
	@iOSXCUITFindBy(xpath ="//XCUIElementTypeButton[normalize-space(@name)='Mobile']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/rd_mobile"),
		@AndroidBy(id = "com.kwikset.blewifi:id/rd_mobile"),
		@AndroidBy(id = "com.spectrum.giga:id/rd_mobile"),
		@AndroidBy(id = "com.weiser.blewifi:id/rd_mobile"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/rd_mobile")
	})
	@CacheLookup
	private MobileElement mobile;
	
	@iOSXCUITFindBy(xpath ="//XCUIElementTypeButton[@name='Submit']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_submit"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_submit"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_submit"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_submit"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/tv_submit")
	})
	@CacheLookup
	private MobileElement submit;
	
	//added on 02-07-2020
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_back"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_back"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_back"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_back"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/tv_back")
	})
	@CacheLookup
	private MobileElement backButton;
	
	@iOSXCUITFindBy(id = "Ok")
	@AndroidFindBy(id="android:id/button1")
	private MobileElement OKButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[1]")
	@AndroidFindBy(id = "android:id/message")
	private MobileElement popUpMessageVerbiage;
	
	String actMessage ="";
	
	
	
	//Constructor
	@SuppressWarnings("static-access")
	public ChooseVerificationMethodPage(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void selectEmail() {
		try {
			Utility.waitForElementToBeVisible(email);
			Utility.waitForElementToBeClickable(email);
			email.click();
			Log.addMessage("Email selected");
		}catch(Exception e) {
			Log.addMessage("Failed to select email");
			Assert.assertTrue(false, "Failed to select email");
		}
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void selectMobile() {
		try {
			Utility.waitForElementToBeVisible(mobile);
			Utility.waitForElementToBeClickable(mobile);
			mobile.click();
			Log.addMessage("Mobile selected");
		}catch(Exception e) {
			Log.addMessage("Failed to select mobile");
			Assert.assertTrue(false, "Failed to select mobile");
		}
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void clickSubmit() {
		try {
			Utility.waitForElementToBeVisible(submit);
			Utility.waitForElementToBeClickable(submit);
			submit.click();
			Log.addMessage("Clicked Submit Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Submit button");
			Assert.assertTrue(false, "Failed to click Submit button");
		}
	}
	
	//added on 02-07-2020
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
	
	public void verifyUIMFAPage() {
		try {
			Utility.waitForElementToBeVisible(email);
			Log.addMessage("Email option is displayed");
			Utility.waitForElementToBeVisible(mobile);
			Log.addMessage("Mobile option is displayed");
			Utility.waitForElementToBeVisible(submit);
			Log.addMessage("Submit button is displayed");
			Utility.waitForElementToBeVisible(backButton);
			Log.addMessage("Back button is displayed");
			Assert.assertTrue(true,"All elements displayed in MFA page");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to display all elements in MFA page");
			Assert.assertTrue(false, "Failed to display all elements in MFA page");
		}
	}
	
	public void viewMFAPagePhUseTest() {
		try {
			Utility.waitForElementToBeVisible(email);
			Log.addMessage("Email option is displayed");
			Utility.waitForElementToBeVisible(submit);
			Log.addMessage("Submit button is displayed");
			Utility.waitForElementToBeVisible(backButton);
			Log.addMessage("Back button is displayed");
			Assert.assertTrue(true,"Only Email option is displayed in MFA page");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to display only email option in MFA page");
			Assert.assertTrue(false, "Failed to display only email option in MFA page");
		}
	}
	
	public boolean checkMFAPageMobileTest() {
		try {
			Utility.waitForElementToBeVisible(mobile);
			Log.addMessage("Mobile option is displayed");
			return false;
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Only Email option is displayed in MFA page");
			return true;
		}
	}
	
	
	public void verifyPopUpVerbiage(String expMessage) {
		try {
			Utility.waitForElementToBeVisible(popUpMessageVerbiage);
			System.out.println("in popup");
			actMessage = popUpMessageVerbiage.getText();
			System.out.println("actMessage="+actMessage);
			System.out.println("expmainMsg="+expMessage+",mainMsg="+actMessage);	
			Assert.assertEquals(actMessage, expMessage,"Popup content message is not matching");
			
			Log.addMessage("Pop up verbiage is matching");
		}catch(Exception e) {
			Log.addMessage("Pop up verbiage is not matching");
			Assert.assertTrue(false, "Pop up verbiage is not matching");
		}
	}
	
	/** 
	* Method Name: clickOKButton(), 
	* This function is used to click OK button from the pop up Page
	*/ 
		
	public void clickOKButton() {
		try {
			Utility.waitForElementToBeVisible(OKButton);
			Utility.waitForElementToBeClickable(OKButton);
			OKButton.click();
			Log.addMessage("Clicked OK Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click OK Button");
			Assert.assertTrue(false, "Failed to click OK Button");
		}
	}

}
