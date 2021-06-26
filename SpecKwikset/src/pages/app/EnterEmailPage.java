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

public class EnterEmailPage extends Settings{
		
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/email"),
		@AndroidBy(id = "com.kwikset.blewifi:id/email"),
		@AndroidBy(id = "com.spectrum.giga:id/email"),
		@AndroidBy(id = "com.weiser.blewifi:id/email")
	})
	@CacheLookup
	private MobileElement emailField;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
	@AndroidBy(id = "com.kwikset.blewifi.dev:id/forgotPassword_edtEmail")
	@CacheLookup
	private MobileElement emailText;
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Submit']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_submit"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_submit"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_submit"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_submit")
	})
	@CacheLookup
	private MobileElement submitButton;
	
	//commented on 11-07-2020
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Back']")
	//@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")//commented on 14-07-2020
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_back"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_back"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_back"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_back")
	})
	@CacheLookup
	private MobileElement backButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")//added on 15-07-2020
	@CacheLookup
	private MobileElement backIButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/forgotPassword_edtEmail"),
		@AndroidBy(id = "com.kwikset.blewifi:id/forgotPassword_edtEmail"),
		@AndroidBy(id = "com.spectrum.giga:id/forgotPassword_edtEmail"),
		@AndroidBy(id = "com.weiser.blewifi:id/forgotPassword_edtEmail")
	})
	@CacheLookup
	private MobileElement rcvrEmailField;
	
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
	public EnterEmailPage(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/	
	public void enterEmail(String email) {
		try {
			Utility.waitForElementToBeVisible(emailField);
			//emailField.click();
			emailField.clear();
			emailField.sendKeys(email);
			Log.addMessage("Email entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter Email");
			Assert.assertTrue(false, "Failed to enter Email");
		}
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/	
	public void enterEmailDoneKey(String email) {
		try {
			Utility.waitForElementToBeVisible(emailField);
			emailField.click();
			emailField.clear();
			emailField.sendKeys(email);
			Log.addMessage("Email entered");
			
			if(device.equals("iOS")) {
				doneKeyboard.click();
			}else {
				JavascriptExecutor js = appiumDriver;
				Map<String, Object> params = new HashMap<>();
				params.put("action", "Done");
				params.put("element", emailField);
				js.executeScript("mobile: performEditorAction", params);
			}
			Log.addMessage("Clicked Done Button");
		}catch(Exception e) {
			Log.addMessage("Failed to enter Email");
			Assert.assertTrue(false, "Failed to enter Email");
		}
	}
	
	/** 
	* Method Name: clickSubmitButton(), 
	* This function is used to click Submit option from the MFA Page
	*/
		
	public void clickSubmitButton() {
		try {
			Utility.waitForElementToBeVisible(submitButton);
			Utility.waitForElementToBeClickable(submitButton);
			submitButton.click();
			
			/*if (device.equals("android")) {
				Utility.waitForElementToBeVisible(OKButton);
				Utility.waitForElementToBeClickable(OKButton);
				OKButton.click();
			}*/
			Log.addMessage("Clicked Submit Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Submit Button");
			Assert.assertTrue(false, "Failed to click Submit Button");
		}
	}
	
	/** 
	* Method Name: clickOKButton(), 
	* This function is used to click OK button from the pop up Page
	*/ 
		
	public void clickOKButton() {
		try {
			//if (device.equals("android")) {
			Utility.waitForElementToBeVisible(OKButton);
			Utility.waitForElementToBeClickable(OKButton);
			OKButton.click();
			//}
			Log.addMessage("Clicked OK Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click OK Button");
			Assert.assertTrue(false, "Failed to click OK Button");
		}
	}
	
	/** 
	* Method Name: valEmail(), 
	* This function is used to update Email for validation
	*/
		
	public void valEmail(String email, String titleMsg, String errMessage, String iMessage) {
		try {
			enterEmail(email);
			clickSubmitButton();
			System.out.println("updated="+titleMsg);
			if(titleMsg!="") {
				if(!titleMsg.equals("Invalid Email Address")) {
					Thread.sleep(6000);
				}
				Utility.waitForElementToBeVisible(OKButton);
				if(OKButton.isDisplayed()) {
					if(titleMsg!="") {
						System.out.println("one");
						actTitle=alertTitle.getText();
						actMessage=confirmMessage.getText();
					}else {
						if(device.equals("iOS")) {
							System.out.println("two");
							actMessage=alertTitle.getText();
						}else {
							System.out.println("three");
							actMessage=confirmMessage.getText();
						}
					}
					System.out.println("iMessage="+iMessage);
					System.out.println("mainMessage="+actMessage);
					if(device.equals("iOS")) {
						setErrMsg(iMessage,actMessage,titleMsg, actTitle);
					}else {
						setErrMsg(errMessage,actMessage,titleMsg, actTitle);
					}
					Utility.simpleWait(2000);
				}
			}else {
				Utility.waitForElementToBeVisible(OKButton);
				if(OKButton.isDisplayed()) {
					OKButton.click();
				}
			}
			
			Log.addMessage("User logged in.");
		}catch(Exception e) {
			Log.addMessage("User credentials was not accepted");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Submit button is not visible");
		}
	}
	
	public void setErrMsg(String exRes, String mnMsg, String ttlMsg, String actTtl) {
		try {
			System.out.println("in errmsg");
			if(exRes!="") {
				System.out.println("in errmsg2");
				if(OKButton.isDisplayed()) {
					OKButton.click();
					System.out.println("in confirmVerificationButton");
					actualRes = mnMsg;
					//System.out.println("in actualRes="+confirmMessage.getText());
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
	* Method Name: valEmail(), 
	* This function is used to update Email for validation
	*/	
	public void valRcvrEmail(String email, String titleMsg, String errMessage, String iMessage) {
		try {
			enterRcvrEmail(email);
			clickSubmitButton();
			Thread.sleep(6000);
			System.out.println("updated");
			if(iMessage!="") {
				if(OKButton.isDisplayed()) {
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
					System.out.println("iMessage="+iMessage);
					System.out.println("mainMessage="+actMessage);
					if(device.equals("iOS")) {
						setErrMsg(iMessage,actMessage,titleMsg, actTitle);
					}else {
						setErrMsg(errMessage,actMessage,titleMsg, actTitle);
					}
					Utility.simpleWait(2000);
				}
			}else {
				if(device.equals("android")) {
					System.out.println("in success message");
				}
			}
			Log.addMessage("User logged in.");
		}catch(Exception e) {
			Log.addMessage("User credentials was not accepted");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Submit button is not visible");
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
	* Method Name: clickBackButton(), 
	* This function is used to select Back option from the Name Page
	*/
		
	public void clickBackIButton() {
		try {
			Utility.waitForElementToBeVisible(backIButton);
			Utility.waitForElementToBeClickable(backIButton);
			backIButton.click();
			Log.addMessage("Clicked Back Button");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click Back button");
			Assert.assertTrue(false, "Failed to click Back button");
		}
	}
	
	/** 
	* Method Name: clickBackButton(), 
	* This function is used to select Back option from the Name Page
	*/ 
		
	public void viewEmailPage() {
		try {
			Utility.waitForElementToBeVisible(rcvrEmailField);
			Log.addMessage("Email text field displayed");
			Utility.waitForElementToBeVisible(submitButton);
			Log.addMessage("Submit button displayed");
			if(device.equals("iOS")) {
				Utility.waitForElementToBeVisible(backIButton);
				Log.addMessage("Back button displayed");
				backIButton.click();
			}else {
				Utility.waitForElementToBeVisible(backButton);
				Log.addMessage("Back button displayed");
				backButton.click();
			}
			Log.addMessage("Clicked Back Button");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click Back button");
			Assert.assertTrue(false, "Failed to click Back button");
		}
	}
	
	/** 
	* Method Name: enterRcvrEmail(), 
	* This function is used to enter Email option from the Recover Password  Email Page
	*/	
	public void enterRcvrEmail(String email) {
		try {
			Utility.waitForElementToBeVisible(rcvrEmailField);
			//emailField.click();
			rcvrEmailField.clear();
			rcvrEmailField.sendKeys(email);
			Log.addMessage("Email entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter Email");
			Assert.assertTrue(false, "Failed to enter Email");
		}
	}
		
}
