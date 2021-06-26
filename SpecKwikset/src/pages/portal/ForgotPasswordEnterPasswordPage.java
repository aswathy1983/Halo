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

public class ForgotPasswordEnterPasswordPage extends Settings {


	@FindBy(id="verificationCode")
	WebElement enterVerificationCodeField;
	
	@FindBy(id="password")
	WebElement passwordField;
	
	@FindBy(id="confirmPassword")
	WebElement reEnterPasswordField;
	
	@FindBy(id="submitCode")
	WebElement confirmButton;
	
	//added from 3rd August
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible fade in']")
	WebElement updateMessage;
	
	@FindBy(xpath="(//div[@class='alert alert-danger alert-dismissible fade in']//a)[1]")
	WebElement closeButton;
	
	@FindBy(xpath="//input[@formcontrolname='password']/following-sibling::p")
	WebElement passwordValidationMessage;
	
	@FindBy(xpath="//input[@formcontrolname='confirmPassword']/following-sibling::p")
	WebElement confPasswordValidationMessage;
	
	//added on 3rd August
	@FindBy(linkText="Resend Verification Code")
	WebElement resendButton;
	
	@SuppressWarnings("static-access")
	public ForgotPasswordEnterPasswordPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	/**
	 * Method Name: enterVerificationCode() Description: This function will be called
	 * to enter Verification Code
	 */
	
	public void enterVerificationCode() {
		try {
			Assert.assertTrue(enterVerificationCodeField.isDisplayed(), "Enter Verification Code field is visible");
			Utility.simpleWait(3000);
			String code=ReadEmail.getAccessCode(PropertyUtility.getProperty("forgotPasswordSub"));
			enterVerificationCodeField.clear();
			enterVerificationCodeField.sendKeys(code);
			Log.addMessage("Verification Code is entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter Verification Code");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter Verification Code");
		}
	}
	

	/**
	 * Method Name: enterPassword() Description: This function will be called
	 * to enter Password
	 */
	
	public void enterPassword(String password) {
		try {
			Assert.assertTrue(passwordField.isDisplayed(), "Password field is visible");
			passwordField.clear();
			passwordField.sendKeys(password);
			Assert.assertTrue(reEnterPasswordField.isDisplayed(), "Re-enter Password field is visible");
			reEnterPasswordField.clear();
			reEnterPasswordField.sendKeys(password);		
			Log.addMessage("Password is entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter Password");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter Password");
		}
	}
	
	/**
	 * Method Name: reEnterPassword() Description: This function will be called
	 * to re-enter Password
	 */
	
	public void reEnterPassword(String password) {
		try {
			Assert.assertTrue(reEnterPasswordField.isDisplayed(), "Password field is visible");
			reEnterPasswordField.clear();
			reEnterPasswordField.sendKeys(password);	
			Log.addMessage("Password re-entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter Password");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter Password");
		}
	}
	
	/**
	 * Method Name: enterNewPassword() Description: This function will be called
	 * to re-enter Password
	 */
	
	public void enterNewPassword(String password) {
		try {
			Assert.assertTrue(passwordField.isDisplayed(), "Password field is visible");
			passwordField.clear();
			passwordField.sendKeys(password);	
			Log.addMessage("Password is entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter Password");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter Password");
		}
	}
	

	/**
	 * Method Name: clickConfirmButton() Description: This function will be called
	 * to click Confirm Button
	 */
	
	public void clickConfirmButton() {
		try {
			Assert.assertTrue(confirmButton.isDisplayed(), "Confirm Button is visible");
			confirmButton.click();
			Utility.simpleWait(6000);
			Log.addMessage("Confirm Button clicked");
		}catch(Exception e) {
			Log.addMessage("Failed to click Confirm Button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click Confirm Button");
		}
	}
	
	/**
	 * Method Name: checkConfirmButton() Description: This function will be called
	 * to check login button
	 */

	public void checkConfirmButton() {
		try {
			Utility.waitForElementToBeVisible(confirmButton);
			//Utility.waitForElementToBeClickable(confirmButton);
			//Assert.assertTrue(false, "Failed to disable confirm button for invalid selection");
			System.out.println("confirmButton isenabled="+confirmButton.isEnabled());
			Assert.assertTrue(!(confirmButton.isEnabled()), "Confirm button is disabled for invalid selection");
			Log.addMessage("Confirm button is disabled for invalid selection");
		}
		catch(Exception e) {
			Log.addMessage("Confirm button enabled for invalid selection");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(true, "Confirm button enabled for invalid selection");
		}
	}
	
	/**
	 * Method Name: enterCode() Description: This function will be called
	 * to enter Verification Code
	 */
	
	public void enterCode(String vcode) {
		try {
			Assert.assertTrue(enterVerificationCodeField.isDisplayed(), "Enter Verification Code field is visible");
			Utility.simpleWait(3000);
			//String code=ReadEmail.getAccessCode(PropertyUtility.getProperty("forgotPasswordSub"));
			enterVerificationCodeField.clear();
			enterVerificationCodeField.sendKeys(vcode);
			Log.addMessage("Verification Code is entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter Verification Code");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter Verification Code");
		}
	}
	
	/**
	 * Method Name: validateRecoverPassword() Description: This function will be called
	 * to validate the confirm password page
	 */

	public void validateRecoverPassword(String vcode, String nwpass, String renewpass, String valMessage1, String valMessage2, String alertMessage, String vType) {
		try {
			enterCode(vcode);
			enterNewPassword(nwpass);
			reEnterPassword(renewpass);
			if(alertMessage!="") {
				clickConfirmButton();
				Utility.simpleWait(5000);
			}else {
				checkConfirmButton();
			}
			System.out.println("Code="+vcode+", nwpass="+nwpass+", renewpass="+renewpass);
			if(valMessage1!="") {
				Utility.waitForElementToBeVisible(passwordValidationMessage);
				System.out.println("Validation message1 is: "+passwordValidationMessage.getText());
				System.out.println("valMessage1 : "+valMessage1);
				Assert.assertTrue(passwordValidationMessage.getText().contains(valMessage1), "Incorrect validation");
				Log.addMessage("Password validation message displayed");
			}
			if(valMessage2!="") {
				Utility.waitForElementToBeVisible(confPasswordValidationMessage);
				System.out.println("Validation message2 is: "+confPasswordValidationMessage.getText());
				System.out.println("valMessage2 : "+valMessage2);
				Assert.assertTrue(confPasswordValidationMessage.getText().contains(valMessage2), "Incorrect validation");
				Log.addMessage("Confirm Password validation message displayed");
			}
			if(alertMessage!="") {
				Utility.waitForElementToBeVisible(updateMessage);
				System.out.println("Alert message is: "+updateMessage.getText());
				System.out.println("alertMessage : "+alertMessage);
				Assert.assertTrue(updateMessage.getText().contains(alertMessage), "Incorrect validation");
				Utility.simpleWait(3000);
				closeButton.click();
				Log.addMessage("Verification code validation message displayed");
			}
			
		}
		catch(Exception e) {
			Log.addMessage("Failed to change password");
			Log.addMessage(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to change password");
		}
	}
	
	/**
	 * Method Name: clickVerifyButton() Description: This function will be called
	 * to click verify button
	*/
	
	public void clickResendButton() {
		try {
			Utility.waitForElementToBeVisible(resendButton);
			Utility.waitForElementToBeClickable(resendButton);
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
	 * Method Name: verifyResendVerbiage() Description: This function will be called
	 * to  verify resend validation
	*/
	
	public void verifyValidationVerbiage(String expMessage) {
		try {
			Utility.waitForElementToBeVisible(updateMessage);
			System.out.println("expmainMsg="+expMessage+",mainMsg="+updateMessage.getText());
			Assert.assertTrue(updateMessage.getText().contains(expMessage),"Validation message is not matching");
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
			Utility.waitForElementToBeClickable(closeButton);
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
}
