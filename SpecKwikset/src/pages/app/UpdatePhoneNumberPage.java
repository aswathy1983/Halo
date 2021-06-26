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

public class UpdatePhoneNumberPage extends Settings{
		
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[2]")//modified from //XCUIElementTypeTextField on 19 April 21
	@AndroidFindBy(className="android.widget.EditText")//added on 04-05-2020
	@CacheLookup
	private MobileElement phoneNumberField;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[2]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_submit"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_submit"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_submit"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_submit")
	})//added on 06-07-2020
	@CacheLookup
	private MobileElement nextButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/backArrowLayout"),
		@AndroidBy(id = "com.kwikset.blewifi:id/backArrowLayout"),
		@AndroidBy(id = "com.spectrum.giga:id/backArrowLayout"),
		@AndroidBy(id = "com.weiser.blewifi:id/backArrowLayout")
	})//added on 04-05-2020
	@CacheLookup
	private MobileElement backButton;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Clear text'])[1]")
	@AndroidFindBy(xpath="(//android.widget.ImageButton)[1]")//added on 07-07-2020
	@CacheLookup
	private MobileElement clearPhoneNumberButton;
	
	
	@iOSXCUITFindBy(id = "Ok")
	@AndroidFindBy(id = "android:id/button1")
	private MobileElement OKButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[2]")
	@AndroidFindBy(id="android:id/message")
	private MobileElement confirmMessage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[1]")
	@AndroidFindBy(id="android:id/alertTitle")
	private MobileElement alertTitle;
	
	String actTitle, actMessage, actualRes, pNumber = "";
	
	//Constructor
	
	@SuppressWarnings("static-access")
	public UpdatePhoneNumberPage(AppiumDriver<MobileElement> driver) {
	this.appiumDriver = driver;
	PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void updatePhoneNumber(String phoneNumber) {
		try {
			Utility.simpleWait(5000);
			phoneNumberField.click();
			phoneNumberField.clear();
			phoneNumberField.sendKeys(phoneNumber);
			Log.addMessage("Phone Number entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter Phone Number");
			Assert.assertTrue(false, "Failed to enter Phone Number");
		}
	}

	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void clickNextButton() {
		try {
			Utility.simpleWait(5000);
			nextButton.click();
			Log.addMessage("Clicked Next Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Next Button");
			Assert.assertTrue(false, "Failed to click Next Button");
		}
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void clickBackButton() {
		try {
			Utility.simpleWait(5000);
			backButton.click();
			Log.addMessage("Clicked Back Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Back Button");
			Assert.assertTrue(false, "Failed to click Back Button");
		}
	}
	/*  Code added on 04-05-2020  */
	/** 
	* Method Name: verifyPhoneNumber(), 
	* This function is used to get first name in Account First Name Text field in Edit Account Name Page
	*/
	public void verifyPhoneNumber(String phoneNumber) {
		try {
			Utility.waitForElementToBeVisible(phoneNumberField);
			Utility.waitForElementToBeClickable(phoneNumberField);
			phoneNumberField.click();
			pNumber = phoneNumberField.getText();
			Assert.assertEquals(pNumber, phoneNumber,"Phone Number of the account is not matching.");
			Log.addMessage("Phone Number of the account is matching.");
		}catch(Exception e) {
			Log.addMessage("Phone Number of the account is not matching.");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Phone Number of the account is not matching.");
		}
		
	}
	
	/*  Code added on 06-07-2020  */
	
	/** 
	* Method Name: verifyClearButton(), 
	* This function is used to sverify ClearButton in update phone number Page
	*/
		
	public void verifyClearButton() {
		try {
			Utility.simpleWait(5000);
			clearPhoneNumberButton.click();
			if(phoneNumberField.getText().equals("Phone Number")) {
				Assert.assertTrue(true,"Clear button is not working");
			}
			Log.addMessage("Clicked clear button");
		}catch(Exception e) {
			Log.addMessage("Failed to click clear button");
			Assert.assertTrue(false, "Failed to click clear button");
		}
	}
	
	/** 
	* Method Name: updatePhoneNumber(), 
	* This function is used to update PhoneNumber in Edit field of  EditPhoneNumber Page
	*/
		
	public void updatePhoneNumber(String PNumber, String errMessage, String titleMsg) {
		try {
			updatePhoneNumber(PNumber);			
			clickNextButton();
			System.out.println("updated");
			if(titleMsg.equals("Verification code send successfully")) {//added 23-03-21
				Utility.simpleWait(4000);
				if(OKButton.isDisplayed()) {//added on 16 Apr 2021 for Android
					System.out.println("in confirmVerificationButton");
					OKButton.click();
				}
			}
			if(errMessage!="") {
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
			}
			Log.addMessage("Phone Number Updated and directed to AccountSettings page");
		}catch(Exception e) {
			Log.addMessage("Phone Number Not Updated");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Phone Number Not Updated");
		}
	}
	
	public void setErrMsg(String exRes, String mnMsg, String ttlMsg, String actTtl) {
		try {
			if(exRes!="") {
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
			e.printStackTrace();
			Assert.assertEquals(false, "Expected message is null.");
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
