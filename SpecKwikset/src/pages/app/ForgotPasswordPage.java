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
import utility.PropertyUtility;
import utility.ReadEmail;
import utility.Utility;

public class ForgotPasswordPage extends Settings{
	

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/edt_code"),
		@AndroidBy(id = "com.kwikset.blewifi:id/edt_code"),
		@AndroidBy(id = "com.spectrum.giga:id/edt_code"),
		@AndroidBy(id = "com.weiser.blewifi:id/edt_code")
	})
	@CacheLookup
	private MobileElement verificationCodeField;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[1]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/edt_password"),
		@AndroidBy(id = "com.kwikset.blewifi:id/edt_password"),
		@AndroidBy(id = "com.spectrum.giga:id/edt_password"),
		@AndroidBy(id = "com.weiser.blewifi:id/edt_password")
	})
	@CacheLookup
	private MobileElement passwordField;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[2]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/edt_confirm_password"),
		@AndroidBy(id = "com.kwikset.blewifi:id/edt_confirm_password"),
		@AndroidBy(id = "com.spectrum.giga:id/edt_confirm_password"),
		@AndroidBy(id = "com.weiser.blewifi:id/edt_confirm_password")
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
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Resend']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/btn_resend"),
		@AndroidBy(id = "com.kwikset.blewifi:id/btn_resend"),
		@AndroidBy(id = "com.spectrum.giga:id/btn_resend"),
		@AndroidBy(id = "com.weiser.blewifi:id/btn_resend")
	})
	@CacheLookup
	private MobileElement resendButton;
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Ok']")
	@AndroidFindBy(id="android:id/button1")
	@CacheLookup
	private MobileElement OkButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Back']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_back"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_back"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_back"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_back")
	})
	@CacheLookup
	private MobileElement backButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	@CacheLookup
	private MobileElement backIButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
	private MobileElement doneKeyboard;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[2]")
	@AndroidFindBy(id="android:id/message")
	private MobileElement confirmMessage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[1]")
	@AndroidFindBy(id="android:id/alertTitle")
	private MobileElement alertTitle;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[2]")
	@AndroidFindBy(id = "android:id/message")
	@CacheLookup
	private MobileElement popUpMessageVerbiage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Enter Verification Code and Password.']")
	@CacheLookup
	private MobileElement headerText;
	
	@iOSXCUITFindBy(xpath ="//XCUIElementTypeButton[@name='Return to Log In']")
	@CacheLookup
	private MobileElement returnLogIn;
	
	String actTitle, actMessage, actualRes ="";
	
	
	//Constructor
	
	@SuppressWarnings("static-access")
	public ForgotPasswordPage(AppiumDriver<MobileElement> driver) {
	this.appiumDriver = driver;
	PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
	
	
	@SuppressWarnings("static-access")
	public void enterVerificationCodeEmail() {
		try {
			Utility.simpleWait(3000);
			verificationCodeField.click();
			verificationCodeField.clear();
			Utility.simpleWait(7000);
			String code=ReadEmail.getAccessCode(PropertyUtility.getProperty("emailSub"));
			verificationCodeField.sendKeys(code);
			Log.addMessage("Verification code entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter Verification code");
			Assert.assertTrue(false, "Failed to enter Verification code");
		}
	}
	
	
	@SuppressWarnings("static-access")
	public void enterVerificationCodeMobile() {
		try {
			Utility.simpleWait(3000);
			verificationCodeField.click();
			verificationCodeField.clear();
			Utility.simpleWait(7000);
			String code=ReadEmail.getAccessCodeMobile(PropertyUtility.getProperty("phoneSub"));
			code = code.replace("code is ", "");
			verificationCodeField.sendKeys(code);
			Log.addMessage("Verification code entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter Verification code");
			Assert.assertTrue(false, "Failed to enter Verification code");
		}
	}
		
	public void enterPassword(String password) {
		try {
			Thread.sleep(6000);
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
		
	public void reEnterPassword(String password) {
		try {
			Thread.sleep(6000);
			reEnterPasswordField.clear();
			reEnterPasswordField.sendKeys(password);
			Log.addMessage("Password re-entered");
		}catch(Exception e) {
			Log.addMessage("Failed to re-enter Password");
			Assert.assertTrue(false, "Failed to re-enter password");
		}
	}
	
	/** 
	* Method Name: enterAnswer1NextKey(), 
	* This function is used to enter next key in keyboard from the Security Question Page
	*/
	public void reEnterPasswordDoneKey() {
		try {
			Utility.waitForElementToBeVisible(reEnterPasswordField);
			reEnterPasswordField.click();
			reEnterPasswordField.clear();
			reEnterPasswordField.sendKeys("a");
			Log.addMessage("Password re-entered");
			
			if(device.equals("iOS")) {
				doneKeyboard.click();
			}else {
				JavascriptExecutor js = appiumDriver;
				Map<String, Object> params = new HashMap<>();
				params.put("action", "Done");
				params.put("element", reEnterPasswordField);
				js.executeScript("mobile: performEditorAction", params);
			}
			Log.addMessage("Clicked Done Button in keyboard");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click done button in keyboard");
			Assert.assertTrue(false, "Failed to click done button in keyboard");
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
		}catch(Exception e) {
			Log.addMessage("Failed to click Submit button");
			Assert.assertTrue(false, "Failed to click Submit button");
		}
	}
	
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void clickOKButton() {
		try {
			//Thread.sleep(3000);
			OkButton.click();
			//Thread.sleep(6000);
			Log.addMessage("Clicked Ok Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Ok button");
			Assert.assertTrue(false, "Failed to click Ok button");
		}
	}
	
	/** 
	* Method Name: clickBackButton(), 
	* This function is used to click back button the MFA Page
	*/
		
	public void clickBackButton() {
		try {
			Thread.sleep(6000);
			if(device.equals("android")) {
				backButton.click();
			}else {
				backIButton.click();
			}
			Thread.sleep(6000);
			Log.addMessage("Clicked back Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click back button");
			Assert.assertTrue(false, "Failed to click back button");
		}
	}
	
	/** 
	* Method Name: clickResendButton(), 
	* This function is used to click Re-send Button
	*/
		
	public void clickHeaderText() {
		try {			
			Utility.waitForElementToBeVisible(headerText);
			//Utility.waitForElementToBeClickable(resendButton);
			headerText.click();	
			Log.addMessage("Clicked header to hide keyboard");
		}catch(Exception e) {
			Log.addMessage("Failed to click header to hide keyboard");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click header to hide keyboard");
		}
	}
	/** 
	* Method Name: clickResendButton(), 
	* This function is used to click Re-send Button
	*/
		
	public void clickResendButton() {
		try {			
			Utility.waitForElementToBeVisible(resendButton);
			//Utility.waitForElementToBeClickable(resendButton);
			resendButton.click();	
			Thread.sleep(5000);
			Log.addMessage("Clicked Resend button for entering Verification Code");
		}catch(Exception e) {
			Log.addMessage("Resend button for requesting new Verification Code is not visible");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Resend button for requesting new Verification Code is not visible");
		}
	}
	
	public void verifyUIRecoverPassword() {
		try {
			Utility.waitForElementToBeVisible(verificationCodeField);
			Log.addMessage("Verification Code textfield is displayed");
			Utility.waitForElementToBeVisible(passwordField);
			Log.addMessage("Password field is displayed");
			Utility.waitForElementToBeVisible(reEnterPasswordField);
			Log.addMessage("Re- enter password field  is displayed");
			Utility.waitForElementToBeVisible(submitButton);
			Log.addMessage("Submit button is displayed");
			if(device.equals("android")) {
				Utility.waitForElementToBeVisible(backButton);
			}else {
				Utility.waitForElementToBeVisible(backIButton);
			}
			Log.addMessage("Back button is displayed");
			Utility.waitForElementToBeVisible(resendButton);
			Log.addMessage("Resend button is displayed");
			Assert.assertTrue(true,"All elements are displayed in forgot password page");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to display all elements in forgot password page");
			Assert.assertTrue(false, "Failed to display all elements in forgot password page");
		}
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
	
	
	@SuppressWarnings("static-access")
	public void enterVCodeEmail(String vCode) {
		try {
			Utility.simpleWait(3000);
			//verificationCodeField.click();
			verificationCodeField.clear();
			Utility.simpleWait(7000);
			verificationCodeField.sendKeys(vCode);
			Log.addMessage("Verification code entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter Verification code");
			Assert.assertTrue(false, "Failed to enter Verification code");
		}
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
	
	
	@SuppressWarnings("static-access")
	public void enterVCodeMobile(String vCode) {
		try {
			Utility.simpleWait(3000);
			//verificationCodeField.click();
			verificationCodeField.clear();
			Utility.simpleWait(7000);
			verificationCodeField.sendKeys(vCode);
			Log.addMessage("Verification code entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter Verification code");
			Assert.assertTrue(false, "Failed to enter Verification code");
		}
	}
	
	//added on 17-12-2020
	public void readMobileCodeFromEmail(String usrType, String passType) throws Exception {
		 Utility.simpleWait(7000);
		 new ReadEmail(PropertyUtility.getProperty(usrType),
				PropertyUtility.getProperty(passType), PropertyUtility.getProperty("email.server"),
				PropertyUtility.getProperty("email.protocol"),993,ReadEmail.EmailFolder.INBOX);

		String code = ReadEmail.getAccessCode(PropertyUtility.getProperty("phoneSub"));//change the subject based on env

		code = code.replace("code is ","");

		Utility.waitForElementToBeVisible(verificationCodeField);
		verificationCodeField.clear();
		verificationCodeField.sendKeys(code);
	}
		
	public void changePassword(String nwPwd, String reNewPwd) {
		try {		
			Utility.simpleWait(5000);
			System.out.println("after email code");
			enterPassword(nwPwd);
			reEnterPassword(reNewPwd);
			clickSubmitButton();
			Utility.simpleWait(7000);
			Log.addMessage("New Password Updated");
		}catch(Exception e) {
			Log.addMessage("Password Not Updated");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Password Not Updated");
		}
	}
	
	/** 
	* Method Name: updateFrgtPassword(), 
	* This function is used to update Password in Edit field of  EditPassword Page
	*/
		
	public void updateFrgtPassword(String vCode,String nwPwd, String reNewPwd, String titleMsg, String errMessage, String valType, String ititleMsg, String iMessage) {
		try {		
			Utility.simpleWait(5000);
			System.out.println("in val password");
			/*if(valType.equals("email")) {
				enterVCodeEmail(vCode);
				enterVerificationCodeEmail();
			}else {
				enterVCodeMobile(vCode);
				enterVerificationCodeMobile();
			}*/
			enterVCodeEmail(vCode);
			System.out.println("after email code");
			enterPassword(nwPwd);
			reEnterPassword(reNewPwd);
			if(errMessage!="") {
				clickSubmitButton();			
			}	
			if(device.equals("android")) {
				if(OkButton.isDisplayed()) {
					//System.out.println("in confirmVerificationButtonnP="+nwPwd+",oP="+oldPwd+",RP="+reNewPwd);
					if(titleMsg!="") {
						actTitle=alertTitle.getText();
						actMessage=confirmMessage.getText();
					}else {
						actMessage=confirmMessage.getText();
					}
					
					System.out.println("mainMessage="+actMessage);
					setErrMsg(errMessage, actMessage, titleMsg, actTitle);
					//OkButton.click();
					Utility.simpleWait(2000);
					if(errMessage.equals("Password Changed")) {
						OkButton.click();
					}
					Utility.simpleWait(2000);
				}
			}else {
				if(iMessage!="") {
					//System.out.println("in confirmVerificationButtonnP="+nwPwd+",oP="+oldPwd+",RP="+reNewPwd);
					if(ititleMsg!="") {
						actTitle=alertTitle.getText();
						actMessage=confirmMessage.getText();
					}else {
						actMessage=alertTitle.getText();
					}
					
					System.out.println("mainMessage="+actMessage);
					setErrMsg(iMessage, actMessage, ititleMsg, actTitle);
					//OkButton.click();
					Utility.simpleWait(2000);
					if(errMessage.equals("Password Changed")) {
						OkButton.click();
					}
					Utility.simpleWait(2000);
				}
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
					System.out.println("in confirmVerificationButton");
					OkButton.click();
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
			e.printStackTrace();
			Assert.assertEquals(false, "Expected message is null.");
		}
	}
	
	public void verifyResendPopUpVerbiage(String expMessage) {
		try {
			Utility.waitForElementToBeVisible(popUpMessageVerbiage);
			actMessage = popUpMessageVerbiage.getText();
			System.out.println("expmainMsg="+expMessage+",mainMsg="+actMessage);
			OkButton.click();
			System.out.println("actMessage="+actMessage+",expMessage="+expMessage);
			Assert.assertEquals(actMessage, expMessage,"Popup content message is not matching");
			
			Log.addMessage("Pop up verbiage is matching");
		}catch(Exception e) {
			Log.addMessage("Pop up verbiage is not matching");
			Assert.assertTrue(false, "Pop up verbiage is not matching");
		}
	}
	
	/** 
	* Method Name: clickReturnLoginButton(), 
	* This function is used to return to Login Page
	*/
		
	public void clickReturnLoginButton() {
		try {
			Thread.sleep(6000);
			returnLogIn.click();
			Log.addMessage("Clicked return to Login Page Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click return to Login Page button");
			Assert.assertTrue(false, "Failed to click return to Login Page button");
		}
	}
}
