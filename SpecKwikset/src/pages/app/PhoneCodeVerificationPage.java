package pages.app;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Constants;
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

public class PhoneCodeVerificationPage extends Settings{
	
	//created on 06-07-2020
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/et_code"),
		@AndroidBy(id = "com.kwikset.blewifi:id/et_code"),
		@AndroidBy(id = "com.spectrum.giga:id/et_code"),
		@AndroidBy(id = "com.weiser.blewifi:id/et_code")
	})
	@CacheLookup
	private MobileElement codeTextField;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Submit']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_submit"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_submit"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_submit"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_submit")
	})
	@CacheLookup
	private MobileElement submitButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/cancelAllhomes"),
		@AndroidBy(id = "com.kwikset.blewifi:id/cancelAllhomes"),
		@AndroidBy(id = "com.spectrum.giga:id/cancelAllhomes"),
		@AndroidBy(id = "com.weiser.blewifi:id/cancelAllhomes")
	})
	@CacheLookup
	private MobileElement backButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Resend']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/btn_resend"),
		@AndroidBy(id = "com.kwikset.blewifi:id/btn_resend"),
		@AndroidBy(id = "com.spectrum.giga:id/btn_resend"),
		@AndroidBy(id = "com.weiser.blewifi:id/btn_resend")
	})
	private MobileElement resendButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText")
	@AndroidFindBy(xpath="(//android.widget.Toast)[1]")
	@CacheLookup
	private MobileElement confirmToastMsg;
	
	@iOSXCUITFindBy(id = "Ok")
	@AndroidFindBy(id="android:id/button1")
	private MobileElement confirmVerificationButton;
	
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
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[1]")
	@AndroidFindBy(id = "android:id/message")
	@CacheLookup
	private MobileElement bioPopUpVerbiage;
	
	
	By okBtn= By.xpath("//XCUIElementTypeButton[@name='Ok']");
	By okAnBtn= By.id("android:id/button1");
	
	boolean okButtonPresent = false;
	
	
	String actTitle, actMessage, actualRes, toastMessage ="";
	

	//Constructor
	
	public PhoneCodeVerificationPage(AppiumDriver<MobileElement> driver) {
		Constants.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
		
		
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		

	public void enterVerificationCode_email_reg() {
		try {
			Utility.simpleWait(7000);
			String code = ReadEmail.getAccessCode(PropertyUtility.getProperty("emailSub"));
			code = code.replace("code is ","");
			Utility.waitForElementToBeVisible(codeTextField);
			codeTextField.clear();
			codeTextField.sendKeys(code);
			Log.addMessage("Verification code entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter Verification code");
			Assert.assertTrue(false, "Failed to enter Verification code");
		}
	}
	
	public void enterVerificationCode_email() {
		try {	
			Utility.simpleWait(8000);
			String code = ReadEmail.getAccessCode(PropertyUtility.getProperty("emailSub"));
			code = code.replace("code is ", "");
			Utility.waitForElementToBeVisible(codeTextField);
			codeTextField.clear();
			codeTextField.sendKeys(code);
			Log.addMessage("Verification code entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter Verification code");
			Assert.assertTrue(false, "Failed to enter Verification code");
		}
	}

	public void enterVerificationCode_phone() {
		try {	
			Utility.simpleWait(7000);
			String code=ReadEmail.getAccessCodeMobile(PropertyUtility.getProperty("phoneSub"));
			code = code.replace("code is ", "");
			Utility.waitForElementToBeVisible(codeTextField);
			codeTextField.clear();
			codeTextField.sendKeys(code);
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
		
	public void clickSubmitButton() {
		try {
			Utility.waitForElementToBeVisible(submitButton);
			Utility.waitForElementToBeClickable(submitButton);
			submitButton.click();
			//Utility.simpleWait(8000);
			Log.addMessage("Clicked Submit button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Submit button");
			Assert.assertTrue(false, "Failed to click Submit button");
		}
	}
	
	
	/** 
	* Method Name: enterMobileCode(), 
	* This function is used to select mobile code from the Mobile Page
	*/
		
	public void enterMobileCode(String emailCode) {
		try {
			Utility.waitForElementToBeVisible(codeTextField);
			codeTextField.clear();
			codeTextField.sendKeys(emailCode);
			Log.addMessage("Phone verification code entered");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to enter Phone verification code");
			Assert.assertTrue(false, "Failed to enter Phone verification code");
		}
	}
	
	/** 
	* Method Name: enterEmailCodeDoneKey(), 
	* This function is used to enter done key in keyboard from the MFA Page
	*/
		
	public void enterPhoneVerifyDoneKey(String emailCode, String valType) {
		try {
			Utility.waitForElementToBeVisible(codeTextField);
			codeTextField.click();
			codeTextField.clear();
			codeTextField.sendKeys(emailCode);
			Log.addMessage("Phone verification code entered");
			if(device.equals("android")) {
				JavascriptExecutor js = appiumDriver;
				Map<String, Object> params = new HashMap<>();
				params.put("action", "Done");
				params.put("element", codeTextField);
				js.executeScript("mobile: performEditorAction", params);
			}
			if(valType.equals("edit")) {
				Utility.simpleWait(2000);
				toastMessage="";
				toastMessage=confirmToastMsg.getAttribute("name");
			}
			Log.addMessage("Clicked Done Button");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click done button");
			Assert.assertTrue(false, "Failed to click done button");
		}
	}
	
	/** 
	* Method Name: clickResendButton(), 
	* This function is used to click Resend Button
	*/
		
	public void clickResendButton() {
		try {			
			Utility.waitForElementToBeVisible(resendButton);
			Utility.waitForElementToBeClickable(resendButton);
			resendButton.click();	
			Thread.sleep(5000);
			Log.addMessage("Clicked Resend button for entering Verification Code");
		}catch(Exception e) {
			Log.addMessage("Resend button for requesting new Verification Code is not visible");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Resend button for requesting new Verification Code is not visible");
		}
	}
	
	public boolean checkOkButton() throws InterruptedException {
		try {
			if(device.equals("iOS")) {
				 Utility.waitForElementPresent(okBtn,appiumDriver);
			}else {
				 Utility.waitForElementPresent(okAnBtn,appiumDriver);
			}
		    okButtonPresent=true;
		    Log.addMessage("Ok button found, syncing in progress");
		    return okButtonPresent;
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to display Ok button");
			okButtonPresent=false;
			return okButtonPresent;
		}
	}
	
	/** 
	* Method Name: clickOKButton(), 
	* This function is used to click OK Button
	*/
		
	public void clickOKButton() {
		try {			
			Utility.waitForElementToBeVisible(confirmVerificationButton);
			Utility.waitForElementToBeClickable(confirmVerificationButton);
			confirmVerificationButton.click();	
			Log.addMessage("Clicked OK button for entering Verification Code");
		}catch(Exception e) {
			Log.addMessage("OK button in resend pop up is not visible");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "OK button in resend pop up is not visible");
		}
	}
	
	
	public void setErrMsg(String exRes, String mnMsg, String ttlMsg, String actTtl, String valType) {
		try {
			System.out.println("in errmsg");
			if(exRes!="") {
				System.out.println("in errmsg2");
				if(valType.equals("new")) {
					if(confirmVerificationButton.isDisplayed()) {
						System.out.println("in confirmVerificationButton");
						actualRes = mnMsg;
						//System.out.println("in actualRes="+confirmMessage.getText());
						if(ttlMsg!="") {
							actTitle = actTtl;
							System.out.println("actTitle---="+actTitle+", expttl="+ttlMsg);
							Assert.assertEquals(actTitle, ttlMsg,"Please check the title validation message.");
						}
					}
				}else {
					actualRes = mnMsg;
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
	* Method Name: valMobileVerificationCode(), 
	* This function is used to update VerificationCode in Email Page
	*/	
	public void valMobileVerificationCode(String vmobile, String titleMsg, String errMessage, String actlToastMsg, String valType) {
		try {
			//Utility.simpleWait(2000);
			enterMobileCode(vmobile);	
			System.out.println("updated vmobile="+vmobile);
			if(valType.equals("new")) {
				clickSubmitButton();	
				Utility.simpleWait(2000);
				System.out.println("updated out");
				if(confirmVerificationButton.isDisplayed()) {
					if(titleMsg!="") {
						actTitle=alertTitle.getText();
						actMessage=confirmMessage.getText();
					}else {
						actMessage=alertTitle.getText();
					}
					System.out.println("mainMessage="+actMessage);
					setErrMsg(errMessage, actMessage, titleMsg, actTitle, valType);
					confirmVerificationButton.click();
					Utility.simpleWait(2000);
				}
			}else {
				if(actlToastMsg!="") {
					System.out.println("in edit");
					clickSubmitButton();
					Utility.simpleWait(2000);
					toastMessage="";
					toastMessage=confirmToastMsg.getAttribute("name");
					System.out.println("toastMessage="+toastMessage);
					setErrMsg(actlToastMsg, toastMessage, titleMsg, actTitle, valType);	
				}
			}
			
			System.out.println("out");
			Log.addMessage("VerificationCode Updated and directed to AccountSettings page");
		}catch(Exception e) {
			Log.addMessage("VerificationCode Not Updated");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "VerificationCode Not Updated");
		}
	}
	
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
	
	public void verifyResendPopUpVerbiage(String expMessage) {
		try {
			Utility.waitForElementToBeVisible(popUpMessageVerbiage);
			actMessage = popUpMessageVerbiage.getText();
			System.out.println("expmainMsg="+expMessage+",mainMsg="+actMessage);	
			Assert.assertEquals(actMessage, expMessage,"Popup content message is not matching");
			
			Log.addMessage("Pop up verbiage is matching");
		}catch(Exception e) {
			Log.addMessage("Pop up verbiage is not matching");
			Assert.assertTrue(false, "Pop up verbiage is not matching");
		}
	}
	
	public void verifyBioPopUpVerbiage(String expMessage) {
		try {
			Utility.waitForElementToBeVisible(bioPopUpVerbiage);
			actMessage = bioPopUpVerbiage.getText();
			System.out.println("expmainMsg="+expMessage+",mainMsg="+actMessage);	
			Assert.assertEquals(actMessage, expMessage,"Popup content message is not matching");
			
			Log.addMessage("Pop up verbiage is matching");
		}catch(Exception e) {
			Log.addMessage("Pop up verbiage is not matching");
			Assert.assertTrue(false, "Pop up verbiage is not matching");
		}
	}
}
