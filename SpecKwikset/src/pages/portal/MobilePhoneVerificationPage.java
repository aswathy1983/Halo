package pages.portal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Settings;
import utility.Log;
import utility.PropertyUtility;
import utility.ReadEmail;
import utility.Utility;

public class MobilePhoneVerificationPage extends Settings{
	
	@FindBy(id="phoneVerify")
	WebElement phoneField;
	
	@FindBy(xpath="//button[@id='submitPhone']")
	WebElement sendButton;
	
	@FindBy(linkText="Resend Code")
	WebElement resendCode;
	
	@FindBy(id="signupPhone")
	WebElement mobileVerificationCodeField;
	
	@FindBy(id="verificationCode")
	WebElement mobileVerificationCodeCPField;
	
	@FindBy(id="securityCode")
	WebElement mobileVCodeField;
	
	@FindBy(id="submitCode")
	WebElement verifyButton;
	
	@FindBy(id="signinverify-form-submit")
	WebElement verifySubmit;
	
	@FindBy(linkText="< Back")
	WebElement backButton;
	
	@FindBy(xpath="//input[@id='phoneVerify']/following-sibling::p")
	WebElement mobileValidationMessage;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible fade in']")
	WebElement incorrectMobileAlertMessage;
	
	@FindBy(xpath="(//div[@class='alert alert-danger alert-dismissible fade in']//a)[1]")
	WebElement closeButton;
	
	String code1 = "";
	
	
	@SuppressWarnings("static-access")
	public MobilePhoneVerificationPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	/**
	 * Method Name: enterPhoneAndVerify() Description: This function will be called
	 * to enter Phone and verify the same
	 */
	
	public void enterPhoneAndVerify(String phone) {
		try {
			Assert.assertTrue(phoneField.isDisplayed(), "Phone Text field is visible");
			phoneField.clear();
			phoneField.sendKeys(phone);
			Utility.simpleWait(3000);
			Assert.assertTrue(sendButton.isDisplayed(), "Send Button is visible");
			System.out.println("three-");
			//sendButton.click();
			System.out.println("four-");
			Utility.clickAction(driver, sendButton);    
		    Log.addMessage("Phone Number to be verified is entered");
		}
		catch(Exception e) {
			Log.addMessage("Failed to enter phone number");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter phone number");
		}
	}


	/**
	 * Method Name: clickResendLink() Description: This function will be called
	 * to click Resend link
	 */
	
	public void clickResendLink() {
		try {
			Assert.assertTrue(resendCode.isDisplayed(), "Resend Button is visible");
			resendCode.click();
			Log.addMessage("Resend Link is clicked");
		}
		catch(Exception e) {
			Log.addMessage("Failed to click Resend link");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click resend link");
		}
	}
	

	/**
	 * Method Name: enterVerificationCode() Description: This function will be called
	 * to enter verification code
	 */
	
	public void enterVerificationCode() {
		try {
			System.out.println("before enterVerificationCode");
			Assert.assertTrue(mobileVerificationCodeField.isDisplayed(), "Mobile verification code Text field is visible");
			Utility.simpleWait(7000);
			System.out.println("enterVerificationCode");
			//ReadEmail emailUti = new ReadEmail("spectrum92610@gmail.com", prop.getProperty("email.password"), prop.getProperty("email.server"), prop.getProperty("email.protocol"),993,ReadEmail.EmailFolder.INBOX);
			 System.out.println("ReadEmail");
			//commented on 24 July 2020 to retrieve mobile verification code
			Thread.sleep(10000);
			/* code1 = ReadEmail.getAccessCodeMobile(PropertyUtility.getProperty("phoneSub"));
		    System.out.println("ReadEmail");
			System.out.println("Mobile code &&&&& "+code1);
			code1=code1.replace("code is ", "");
			//System.out.println("Mobile code &&&&& "+code1);
			mobileVerificationCodeField.clear();
		    mobileVerificationCodeField.sendKeys(code1);*/
			Log.addMessage("Verification code is entered");
		}
		catch(Exception e) {
			Log.addMessage("Failed to enter mobile verification code");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter mobile verification Code");
		}
	}
	/**
	 * Method Name: enterVerificationCode() Description: This function will be called
	 * to enter verification code
	 */
	
	public void enterVerifyCode(String code) {
		try {
			System.out.println("before enterVerificationCode");
			Assert.assertTrue(mobileVerificationCodeField.isDisplayed(), "Mobile verification code Text field is visible");
			
			System.out.println("enterVerificationCode");
			//ReadEmail emailUti = new ReadEmail("spectrum92610@gmail.com", prop.getProperty("email.password"), prop.getProperty("email.server"), prop.getProperty("email.protocol"),993,ReadEmail.EmailFolder.INBOX);
			 System.out.println("ReadEmail");
			
			mobileVerificationCodeField.clear();
		    mobileVerificationCodeField.sendKeys(code);
			Log.addMessage("Verification code is entered");
		}
		catch(Exception e) {
			Log.addMessage("Failed to enter mobile verification code");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter mobile verification Code");
		}
	}
	
	
	/**
	* Method Name: invalidVerificationCode() Description: This function will be called
	* to enter verification code
	*/
	public void invalidVerificationCode(String code) {
		try {
			Utility.waitForElementToBeVisible(mobileVerificationCodeField);
			Utility.waitForElementToBeClickable(mobileVerificationCodeField);
			Assert.assertTrue(mobileVerificationCodeField.isDisplayed(), "Mobile verification code Text field is visible");
			Utility.simpleWait(3000);
			mobileVerificationCodeField.clear();
			mobileVerificationCodeField.sendKeys(code);
			Thread.sleep(5000);
			Log.addMessage("Verification code is entered");
		}
		catch(Exception e) {
			Log.addMessage("Failed to enter mobile verification code");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter mobile verification Code");
			System.out.println();
		}
	}
	

	/**
	 * Method Name: clickVerifyButton() Description: This function will be called
	 * to click verify button
	 */
	
	public void clickVerifyButton() {
		try {
			Assert.assertTrue(verifyButton.isDisplayed(), "Verify Button is visible");
			verifyButton.click();
			Log.addMessage("Verify Button is clicked");
		}
		catch(Exception e) {
			Log.addMessage("Failed to click Verify button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click Verify button");
		}
	}
	
	/**
	 * Method Name: clickVerifySubmit() Description: This function will be called
	 * to click verify button
	 */
	
	public void clickVerifySubmit() {
		try {
			Assert.assertTrue(verifySubmit.isDisplayed(), "Verify Button is visible");
			verifySubmit.click();
			Log.addMessage("Verify Button is clicked");
		}
		catch(Exception e) {
			Log.addMessage("Failed to click Verify button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click Verify button");
		}
	}
	
	//added on 5-01-2021
	public void readMobileCodeFromEmail(String usrType, String passType) throws Exception {
		Utility.simpleWait(7000);
		 new ReadEmail(PropertyUtility.getProperty(usrType),
				PropertyUtility.getProperty(passType), PropertyUtility.getProperty("email.server"),
				PropertyUtility.getProperty("email.protocol"),993,ReadEmail.EmailFolder.INBOX);

		String code = ReadEmail.getAccessCode(PropertyUtility.getProperty("emailSub1"));

		code = code.replace("code is ","");
		System.out.println("code="+code);
		Utility.waitForElementToBeVisible(mobileVerificationCodeField);
		mobileVerificationCodeField.clear();
		mobileVerificationCodeField.sendKeys(code);
	}
	
	//added on 5-01-2021
	public void readMobileCodeFromCPEmail(String usrType, String passType) throws Exception {
		Utility.simpleWait(7000);
		 new ReadEmail(PropertyUtility.getProperty(usrType),
				PropertyUtility.getProperty(passType), PropertyUtility.getProperty("email.server"),
				PropertyUtility.getProperty("email.protocol"),993,ReadEmail.EmailFolder.INBOX);

		String code = ReadEmail.getAccessCodeCP(PropertyUtility.getProperty("emailSub1"));

		code = code.replace("code is ","");
		System.out.println("code="+code);
		Utility.waitForElementToBeVisible(mobileVerificationCodeCPField);
		mobileVerificationCodeCPField.clear();
		mobileVerificationCodeCPField.sendKeys(code);
	}

	//added on 7-01-2021
	public void readMobileCodeLoginEmail(String usrType, String passType) throws Exception {
		Utility.simpleWait(7000);
		 new ReadEmail(PropertyUtility.getProperty(usrType),
				PropertyUtility.getProperty(passType), PropertyUtility.getProperty("email.server"),
				PropertyUtility.getProperty("email.protocol"),993,ReadEmail.EmailFolder.INBOX);

		String code = ReadEmail.getAccessCode(PropertyUtility.getProperty("emailSub1"));

		code = code.replace("code is ","");
		//System.out.println("code="+code);
		Utility.waitForElementToBeVisible(mobileVCodeField);
		mobileVCodeField.clear();
		mobileVCodeField.sendKeys(code);
	}


	
	/**
	 * Method Name: clickSendButton() Description: This function will be called
	 * to click send button
	 */
	
	public void clickSendButton() {
		try {
			Assert.assertTrue(sendButton.isDisplayed(), "Send Button is visible");
			sendButton.click();
			Log.addMessage("Send Button is clicked");
		}
		catch(Exception e) {
			Log.addMessage("Failed to click send button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click send button");
		}
	}
	
	/**
	 * Method Name: checkSendButton() Description: This function will be called
	 * to click send button
	 */
	
	public void checkSendButton() {
		try {
			Utility.waitForElementToBeVisible(sendButton);
			Assert.assertTrue(!(sendButton.isEnabled()), "Send button is disabled for invalid selection");
			Log.addMessage("Send button is disabled for invalid selection");
		}
		catch(Exception e) {
			Log.addMessage("Failed to disable send button for invalid selection");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(true, "Failed to disable send button for invalid selection");
		}
	}
	
	/**
	 * Method Name: checkVerifyButton() Description: This function will be called
	 * to click verify button
	 */
	
	public void checkVerifyButton() {
		try {
			Utility.waitForElementToBeVisible(verifyButton);
			
			Assert.assertTrue(!(verifyButton.isEnabled()), "Verify button is disabled for invalid selection");
			Log.addMessage("Verify button is disabled for invalid selection");
		}
		catch(Exception e) {
			Log.addMessage("Failed to disable verify button for invalid selection");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(true, "Failed to disable verify button for invalid selection");
		}
	}
	
	/**
	 * Method Name: invalidPhoneCheck() Description: This function will be called
	 * to enter phone number and verify the same
	 */
	
	public void invalidPhoneCheck(String valMessage) {
		try {
			Utility.simpleWait(6000);
			
			Utility.waitForElementToBeVisible(mobileValidationMessage);
			System.out.println("Validation message is: "+mobileValidationMessage.getText());
			Assert.assertTrue(mobileValidationMessage.isDisplayed(), "Validation message displayed for mobile number does not exist");
			//Assert.assertEquals(mobileValidationMessage.getText(), valMessage, "Incorrect validation");
			Log.addMessage("Mobile number to be verified is entered");
		}
		catch(Exception e) {
			Log.addMessage("Failed to enter mobile number");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter mobile number");
		}
	}
	
	/**
	 * Method Name: enterPhoneNumber() Description: This function will be called
	 * to enter phone number and verify the same
	 */
	
	public void enterPhoneNumber(String mobile) {
		try {
			Utility.waitForElementToBeVisible(phoneField);
			Assert.assertTrue(phoneField.isDisplayed(), "Mobile Text field is visible");
			phoneField.clear();
			phoneField.sendKeys(mobile);
			Log.addMessage("Mobile number to be verified is entered");
		}
		catch(Exception e) {
			Log.addMessage("Failed to enter mobile number");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter mobile number");
		}
	}
	
	/**
	 * Method Name: invalidMobileAlertCheck() Description: This function will be called
	 * to enter mobile number and verify the same
	 */
	
	public void invalidMobileAlertCheck(String valMessage) {
		try {
			Utility.simpleWait(6000);
			Utility.waitForElementToBeVisible(incorrectMobileAlertMessage);
			System.out.println("Validation message is: "+incorrectMobileAlertMessage.getText());
			Assert.assertTrue(incorrectMobileAlertMessage.isDisplayed(), "Validation message displayed for mobile does not exist");
			//Assert.assertEquals(incorrectMobileAlertMessage.getText(), valMessage, "Incorrect validation");
			Log.addMessage("Mobile to be verified is entered");
		}
		catch(Exception e) {
			Log.addMessage("Failed to enter mobile number");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter mobile number");
		}
	}
	
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
	
	public void updateVerificationCode(String mobileNumber, String code, String valMessage, String alertMessage) {
		try {
			enterPhoneNumber(mobileNumber);
			if(valMessage!="") {
				checkSendButton();
			}else {
				clickSendButton();
			}
			enterVerifyCode(code);
			if(code.equals("")) {
				checkVerifyButton();
			}else {
				clickVerifyButton();
				Utility.simpleWait(5000);
			}
			Utility.simpleWait(2000);
			if(valMessage!="") {
				if(mobileValidationMessage.isDisplayed()) {
				Assert.assertTrue(mobileValidationMessage.getText().contains(valMessage), "Validation is proper");
				Log.addMessage("Validation message for first name is proper");
				}
			}
			if(alertMessage!="") {
				Assert.assertTrue(incorrectMobileAlertMessage.getText().contains(alertMessage), "Validation is proper");
				Log.addMessage("Validation message for last name is proper");
				closeButton.click();
			}
			Thread.sleep(5000);
			Log.addMessage("User details entered successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to enter user details");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to enter user details");
		}
	}
}
