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

public class EditAccessCodePage extends Settings{
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
	@AndroidFindBy(xpath = "//android.widget.EditText")
	@CacheLookup
	private MobileElement acceessCodePinField;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/cancelAllhomes")// added on 14-05-2020
	@CacheLookup
	private MobileElement backButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Submit']")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Submit']")
	@CacheLookup
	private MobileElement submitButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Generate Random Code']")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Generate Random Code']")
	@CacheLookup
	private MobileElement generateRandomCodeButton;
	
	/*           added from 14-05-2020              */
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Any Time']")
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/ll_anytime_access")
	@CacheLookup
	private MobileElement anyTimeButton;
	
	@AndroidFindBy(id = "android:id/button1")
	@CacheLookup
	private MobileElement OkButton;
	
	@AndroidFindBy(id = "android:id/message")
	@CacheLookup
	private MobileElement popUpMessageVerbiage;
	
	
	

	//Constructor
		@SuppressWarnings("static-access")
		public EditAccessCodePage(AppiumDriver<MobileElement> driver) {
			this.appiumDriver = driver;
			PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
		}
		
		
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void enterAccessCodePin(String code) {
		try {
			Thread.sleep(6000);
			acceessCodePinField.clear();
			acceessCodePinField.sendKeys(code);
			Log.addMessage("Access Code Pin entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter access code pin");
			Assert.assertTrue(false, "Failed to enter access code pin");
		}
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void clickGenerateRandomCodeButton() {
		try {
			Thread.sleep(6000);
			generateRandomCodeButton.click();
			Log.addMessage("Clicked 'Generate Random Code' Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click 'Generate Random Code' button");
			Assert.assertTrue(false, "Failed to click 'Generate Random Code' button");
		}
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void clickSubmitButton() {
		try {
			Thread.sleep(6000);
			submitButton.click();
			Log.addMessage("Clicked Submit Button");
			utility.Utility.simpleWait(8000);
		}catch(Exception e) {
			Log.addMessage("Failed to click Submit button");
			Assert.assertTrue(false, "Failed to click Submit button");
		}
	}
	
	/*                     added on 14-05-2020                      */
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void clickAnyTimeButton() {
		try {
			Thread.sleep(6000);
			System.out.println("in Anytime");
			anyTimeButton.click();
			System.out.println("clicked Anytime");
			Log.addMessage("Clicked Any Time access button");
			utility.Utility.simpleWait(8000);
		}catch(Exception e) {
			Log.addMessage("Failed to click Any Time Access button");
			Assert.assertTrue(false, "Failed to click Any Time Access button");
		}
	}
	
	public void clickOkButton() {
		try {
			Utility.waitForElementToBeVisible(OkButton);
			Utility.waitForElementToBeClickable(OkButton);
			OkButton.click();
			
			Log.addMessage("Ok button present and clicked in the pop up page");
		}catch(Exception e) {
			Log.addMessage("Failed to click Ok button in the pop up");
			Assert.assertTrue(false, "Failed to click Ok button in the pop up");
		}
	}
	
	public void clickBackButton() {
		try {
			Thread.sleep(3000);
			System.out.println("inside Edit Access Code back button");
			Utility.waitForElementToBeVisible(backButton);
			backButton.click();
			Log.addMessage("Clicked back button of edit access code page");
		}catch(Exception e) {
			Log.addMessage("Failed to click back button in edit access code page");
			Assert.assertTrue(false, "Failed to click back button in edit access code page");
		}
	}



}
