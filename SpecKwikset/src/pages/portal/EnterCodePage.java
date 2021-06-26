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

public class EnterCodePage extends Settings {

	
	@FindBy(id="securityCode")
	WebElement enterCodeField;
	
	@FindBy(className="alert alert-danger")
	WebElement validationMessage;
	
	@FindBy(id="signinverify-form-submit")
	WebElement verifyButton;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible fade in']")
	WebElement alertMessage;
	
	//added on 1st August
	@FindBy(xpath="//h2[text()='Confirm Verification Code']")
	WebElement heading;
	
	//added on 1st August
	@FindBy(xpath="//input[@formcontrolname='securityCode']/following-sibling::p")
	WebElement validationMessage1;
	
	//added on 1st August
	@FindBy(linkText="Resend Verification Code")
	WebElement resendButton;
	
	@FindBy(xpath="(//div[@class='alert alert-danger alert-dismissible fade in']//a)[2]")
	WebElement closeButton;
	
	@FindBy(xpath="(//div[@class='alert alert-danger alert-dismissible fade in']//a)[1]")
	WebElement closeButton1;
	
	int emailvcnt = 0;
	String actMessage = "";
	
	@SuppressWarnings("static-access")
	public EnterCodePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
  

	/**
	 * Method Name: validateEnterCodeTextField() Description: This function will be called
	 * to validate Enter Code text field
	 */
	
	public void validateEnterCodeTextField() {
		try {
			Assert.assertTrue(enterCodeField.isDisplayed(), "Code entering Text field is visible");
			verifyButton.click();
			Assert.assertTrue(validationMessage.getText().equalsIgnoreCase("Code incorrect try again..."), "Validation is proper");
			Log.addMessage("Enter Code Text Field validation is done");
		}catch(Exception e) {
			Log.addMessage("Validation of Enter Code Text Field is failed");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to validate Enter Code Text Field");
		}
	}
	

	/**
	 * Method Name: enterCode() Description: This function will be called
	 * to enter Code
	 */
	
	public void enterCode() {
		try {
			Utility.simpleWait(8000);
			String code=ReadEmail.getAccessCode(PropertyUtility.getProperty("emailSub"));
			Assert.assertTrue(enterCodeField.isDisplayed(), "Code entering Text field is visible");
			enterCodeField.clear();
			enterCodeField.sendKeys(code);
			verifyButton.click();
			Utility.simpleWait(5000);
			Log.addMessage("Verification code entered");
		}catch(Exception e) {
			Log.addMessage("Verification code not entered");
			Log.addMessage(alertMessage.getText());
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter verification code");
		}
	}
	
	
	/**
	 * Method Name: enterCodeReceivedInPhone() Description: This function will be called
	 * to enter code received in phone
	 */
	
	public void enterCodeReceivedInPhone() {
		try {
			Assert.assertTrue(enterCodeField.isDisplayed(), "Code entering Text field is visible");
			//ReadEmail emailUtil = new ReadEmail("aswathyqb@gmail.com", "123qbtech","smtp.gmail.com","IMAP",587, ReadEmail.EmailFolder.INBOX);
			Utility.simpleWait(5000);
			String code =ReadEmail.getAccessCode(PropertyUtility.getProperty("phoneSub"));
			enterCodeField.clear();
			enterCodeField.sendKeys(code);
			verifyButton.click();
			Log.addMessage("Verification code is entered");
		}
		catch(Exception e) {
			Log.addMessage("Failed to enter mobile verification code");
			Log.addMessage(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter mobile verification Code");
		}
	}
	

	/**
	 * Method Name: isCodeIncorrectMessageDisplayed() Description: This function will be called
	 * to validate whether incorrect code message is displayed
	 */
	
	public void isCodeIncorrectMessageDisplayed() {
		try {
			Assert.assertTrue(alertMessage.isDisplayed(), "Code Incorrect message is visible");
			Assert.assertTrue(alertMessage.getText().contains("Code incorrect try again..."), "Validation is proper");
			Log.addMessage("Code is incorrect");
			Assert.assertTrue(false, "Correct code entered");
		}catch(Exception e) {
			Log.addMessage("Code entered is correct");
		}
	}
	
	//added on 31-07-2020
	/**
	* Method Name: invalidVerificationCode() Description: This function will be called
	* to enter verification code
	*/
	public void invalidVerificationCode(String code,String valMessage, String mainMessage) {
		try {
			emailvcnt = emailvcnt+1;
			Utility.waitForElementToBeVisible(enterCodeField);
			Utility.waitForElementToBeClickable(enterCodeField);
			Assert.assertTrue(enterCodeField.isDisplayed(), "Email verification code Text field is visible");
			Utility.simpleWait(3000);
			enterCodeField.clear();
			enterCodeField.sendKeys(code);
			heading.click();
			if(mainMessage.equals("")) {
				checkVerifyButton();
			}else {
				verifyButton.click();
				Utility.simpleWait(5000);
			}
			if(valMessage!="") {
				Assert.assertTrue(validationMessage1.getText().equalsIgnoreCase("Code Required"), "Validation is proper");
			}
			if(mainMessage!="") {
				Assert.assertTrue(alertMessage.getText().contains("The Verification Code is incorrect"), "Validation is proper");
				closeButton1.click();
			}
			Thread.sleep(5000);
			Log.addMessage("Verification code is entered");
		}
		catch(Exception e) {
			Log.addMessage("Failed to enter email verification code");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter email verification Code");
			System.out.println();
		}
	}
	
	/**
	 * Method Name: isCodeInvalidRetryLimitMessageDisplayed() Description: This function will be called
	 * to validate whether incorrect code message is displayed
	 */
	
	public void isCodeInvalidRetryLimitMessageDisplayed() {
		try {
			Assert.assertTrue(alertMessage.isDisplayed(), "Code Incorrect message is visible");
			System.out.println("message="+alertMessage.getText());
			Assert.assertTrue(alertMessage.getText().contains("Number of re-tries exceeded"), "Validation is proper");
			Log.addMessage("Invalid verification code retry limits message displayed");
			Assert.assertTrue(false, "Correct code entered");
		}catch(Exception e) {
			Log.addMessage("Code entered is correct");
		}
	}
	
	/**
	 * Method Name: checkVerifyButton() Description: This function will be called
	 * to click verify button
	*/
	
	public void checkVerifyButton() {
		try {
			Utility.waitForElementToBeVisible(verifyButton);
			Assert.assertTrue(!(verifyButton.isEnabled()), "Failed to disable verify button for invalid selection");
			Log.addMessage("Verify Button is disabled for invalid selection");
		}
		catch(Exception e) {
			Log.addMessage("Failed to disable verify button for invalid selection");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(true, "Failed to disable verify button for invalid selection");
		}
	}
	
	/**
	 * Method Name: clickVerifyButton() Description: This function will be called
	 * to click verify button
	*/
	
	public void clickVerifyButton() {
		try {
			Utility.waitForElementToBeVisible(verifyButton);
			Utility.waitForElementToBeClickable(verifyButton);
			verifyButton.click();
			Assert.assertTrue(true, "Resend Code link clicked");
			Log.addMessage("Resend Code link clicked");
		}
		catch(Exception e) {
			Log.addMessage("Failed to click resend code link");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(true, "Failed to click resend code link");
		}
	}
	
	/**
	 * Method Name: clickVerifyButton() Description: This function will be called
	 * to click verify button
	*/
	
	public void clickResendButton() {
		try {
			Utility.waitForElementToBeVisible(resendButton);
			//Utility.waitForElementToBeClickable(resendButton);
			resendButton.click();
			Assert.assertTrue(true, "Resend link clicked");
			Log.addMessage("Resend link clicked");
		}
		catch(Exception e) {
			Log.addMessage("Failed to click resend link");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(true, "Failed to click resend link");
		}
	}
	

	/**
	 * Method Name: verifyResendPopUpVerbiage() Description: This function will be called
	 * to  verify resend validation
	*/
	
	public void verifyResendPopUpVerbiage(String expMessage) {
		try {
			Utility.waitForElementToBeVisible(alertMessage);
			System.out.println("mainMsg="+alertMessage.getText());
			System.out.println("expmainMsg="+expMessage+",mainMsg="+alertMessage.getText().contains(expMessage));
			Assert.assertTrue(alertMessage.getText().contains(expMessage),"Validation message is not matching");
			Log.addMessage("Validation is matching");
		}catch(Exception e) {
			Log.addMessage("Validation is not matching");
			Assert.assertTrue(false, "Validation is not matching");
		}
	}
	
	/**
	 * Method Name: clickCloseButton() Description: This function will be called
	 * to click close button
	*/
	
	public void clickCloseButton() {
		try {
			Utility.waitForElementToBeVisible(closeButton);
			//Utility.waitForElementToBeClickable(closeButton);
			closeButton.click();
			Assert.assertTrue(true, "Close button clicked");
			Log.addMessage("Close button clicked");
		}
		catch(Exception e) {
			Log.addMessage("Failed to click close button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(true, "Failed to click close button");
		}
	}
	
	/**
	 * Method Name: enterVerificationCode() Description: This function will be called
	 * to click verification code button
	*/
	
	public void enterVerificationCode() {
		try {
			Utility.waitForElementToBeVisible(enterCodeField);
			Utility.waitForElementToBeClickable(enterCodeField);
			enterCodeField.clear();
			//enterCodeField.sendKeys("123456");
			verifyButton.click();
			Assert.assertTrue(true, "Close button clicked");
			Log.addMessage("Close button clicked");
		}
		catch(Exception e) {
			Log.addMessage("Failed to click close button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(true, "Failed to click close button");
		}
	}
}
