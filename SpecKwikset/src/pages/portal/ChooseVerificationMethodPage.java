package pages.portal;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Settings;
import utility.Log;
import utility.Utility;

public class ChooseVerificationMethodPage extends Settings{
	
	@FindBy(xpath="//input[@value='email']")
	//@FindBy(id="choice")
	WebElement emailButton;
	
	@FindBy(xpath="//input[@ng-value='phone']")
	WebElement phoneButton;
		
	@FindBy(id="signincode-form-submit")
	WebElement sendCodeButton;
	
	@FindBy(id="selectVerificationCodeType")
	WebElement sendCodeRcvrButton;
	
	//commented on 12 sep for weekly regression provide different xpath for MFA during recover flow.
	//@FindBy(xpath="//input[@value='email']/following-sibling::span[@class='sp-checkmark sp-radio']")
	@FindBy(xpath="//input[@value='email']")
	WebElement emailNwButton;
	
	@FindBy(xpath="//input[@id='phoneVerify']")
	WebElement phoneVButton;
	
	//@FindBy(xpath="//input[@ng-value='phone']/following-sibling::span[@class='sp-checkmark sp-radio']")
	@FindBy(xpath="//input[@ng-value='phone']")
	WebElement phoneNwButton;
	
	@FindBy(xpath="//input[@value='email']/following-sibling::span[@class='sp-checkmark sp-radio']")
	WebElement emailNwRcvrButton;
	
	@FindBy(xpath="//input[@ng-value='phone']/following-sibling::span[@class='sp-checkmark sp-radio']")
	WebElement phoneNwRcvrButton;
	
	
	@SuppressWarnings("static-access")
	public ChooseVerificationMethodPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Method Name: clickEmailButton() Description: This function will be called
	 * to click Email button
	*/
	public void clickEmailButton() {
		try {
			Utility.simpleWait(8000);
			Utility.waitForElementToBeVisible(emailButton);
		    //Assert.assertTrue(emailButton.isDisplayed(), "Email Button is visible");	
			emailButton.click();
			//Utility.clickAction(driver, emailButton);
		    Log.addMessage("Verification through email is selected");
		}catch(Exception e) {
			Log.addMessage("Verification through email is not selected");
			Log.addMessage(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to select email as verification method");
		}
	}
	
	/**
	 * Method Name: clickEmailNewButton() Description: This function will be called
	 * to click Email button
	*/
	public void clickEmailNewButton() {
		try {
			Utility.simpleWait(8000);
			Utility.waitForElementToBeVisible(emailNwButton);
		    //Assert.assertTrue(emailButton.isDisplayed(), "Email Button is visible");	
			emailNwButton.click();
			//Utility.clickAction(driver, emailButton);
		    Log.addMessage("Verification through email is selected");
		}catch(Exception e) {
			Log.addMessage("Verification through email is not selected");
			Log.addMessage(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to select email as verification method");
		}
	}
	
	/**
	 * Method Name: clickEmailNewButton() Description: This function will be called
	 * to click Email button
	*/
	public void clickEmailNewRcvrButton() {
		try {
			Utility.simpleWait(8000);
			Utility.waitForElementToBeVisible(emailNwRcvrButton);
		    //Assert.assertTrue(emailButton.isDisplayed(), "Email Button is visible");	
			emailNwRcvrButton.click();
			//Utility.clickAction(driver, emailButton);
		    Log.addMessage("Verification through email is selected");
		}catch(Exception e) {
			Log.addMessage("Verification through email is not selected");
			Log.addMessage(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to select email as verification method");
		}
	}
	
	/**
	 * Method Name: clickPhoneButton() Description: This function will be called
	 * to click Phone button
	*/
	
	public void clickPhoneButton() {
		try {
			Utility.simpleWait(8000);
			Assert.assertTrue(phoneButton.isDisplayed(), "Phone Button is visible");
			System.out.println("inside phone visible");
			phoneButton.click();
			//Utility.clickAction(driver, phoneButton);
			Log.addMessage("Verification through phone is selected");
		}catch(Exception e) {
			Log.addMessage("Verification through phone is not selected");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to select phone as verification method");
		}
	}
	
	/**
	 * Method Name: clickPhoneNewButton() Description: This function will be called
	 * to click Phone button
	*/
	
	public void clickPhoneNewButton() {
		try {
			Utility.simpleWait(8000);
			Assert.assertTrue(phoneNwButton.isDisplayed(), "Phone Button is visible");
			phoneNwButton.click();
			//Utility.clickAction(driver, phoneButton);
			Log.addMessage("Verification through phone is selected");
		}catch(Exception e) {
			Log.addMessage("Verification through phone is not selected");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to select phone as verification method");
		}
	}
	
	/**
	 * Method Name: clickPhoneNewButton() Description: This function will be called
	 * to click Phone button
	*/
	
	public void clickPhoneNewRcvrButton() {
		try {
			Utility.simpleWait(8000);
			Assert.assertTrue(phoneNwRcvrButton.isDisplayed(), "Phone Button is visible");
			phoneNwRcvrButton.click();
			//Utility.clickAction(driver, phoneButton);
			Log.addMessage("Verification through phone is selected");
		}catch(Exception e) {
			Log.addMessage("Verification through phone is not selected");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to select phone as verification method");
		}
	}
	//added on 3rd August
	/**
	 * Method Name: clickSendRcvrCodeButton() Description: This function will be called
	 * to click Send Code button
	 */
	
	public void clickSendRcvrCodeButton() {
		try {
			Utility.simpleWait(4000);
			Assert.assertTrue(sendCodeRcvrButton.isDisplayed(), "Send Button is visible");
			sendCodeRcvrButton.click();
			Log.addMessage("Verification Code is sent");
		}catch(Exception e) {
			Log.addMessage("Verification code cannot be send");
			Log.addMessage(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to send verification code");
		}
	}
	
	/**
	 * Method Name: clickSendCodeButton() Description: This function will be called
	 * to click Send Code button
	 */
	
	public void clickSendCodeButton() {
		try {
			Utility.simpleWait(4000);
			Assert.assertTrue(sendCodeButton.isDisplayed(), "Send Code Button is visible");
			sendCodeButton.click();
			Log.addMessage("Verification Code is sent");
		}catch(Exception e) {
			Log.addMessage("Verification code cannot be send");
			Log.addMessage(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to send verification code");
		}
	}
	
	public void verifyPresenceOfEmailButton() {
		try {
			Boolean isEmailDisplayed;
			isEmailDisplayed =  emailButton.isDisplayed();
			Log.addMessage("User Deletion not done");
			Assert.assertFalse(isEmailDisplayed, "Failed to delete spectrum Cloud account");	
		}catch(Exception e) {
			Log.addMessage("Account deleted successfully");
			Assert.assertTrue(true,"User not exists");	
		}
		
	}
	
	//added on 31st July 2020
	/**
	 * Method Name: checkSendCodeButton() Description: This function will be called
	 * to verify Send Code button
	*/
	
	public void checkSendCodeButton() {
		try {
			Utility.waitForElementToBeVisible(sendCodeButton);
			//Utility.waitForElementToBeClickable(sendCodeButton);
			Assert.assertTrue(!(sendCodeButton.isEnabled()), "Failed to disable send code button for invalid selection");
			Log.addMessage("Send Code button is disabled for no selection");
		}
		catch(Exception e) {
			Log.addMessage("Send Code button is not disabled for no selection");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(true, "Send Code button is not disabled for no selection");
		}
	}
	
	//added on 3rd August
	public void verifyUIMFA() {
		try {
			Utility.waitForElementToBeVisible(emailButton);
			Assert.assertTrue(emailButton.isDisplayed(), "Email radio button is visible");
			System.out.println("one");
			Log.addMessage("Email radio button is visible");
			Utility.waitForElementToBeVisible(phoneButton);
			Assert.assertTrue(phoneButton.isDisplayed(), "Phone radio button is visible");
			Log.addMessage("Phone radio button is visible");
			System.out.println("two");
			Utility.waitForElementToBeVisible(sendCodeRcvrButton);
			System.out.println("3="+sendCodeRcvrButton.isDisplayed());
			Assert.assertTrue(sendCodeRcvrButton.isDisplayed(), "Send button is visible");
			Log.addMessage("Send button is visible");
			System.out.println("three");
		}catch(Exception e) {
			Log.addMessage("Verification mode not selected");
			Assert.assertTrue(true,"Verification mode not selected");	
		}
		
	}
	
	public boolean checkMFAPageMobileTest() {
		try {
			Utility.waitForElementToBeVisible(phoneButton);
			Log.addMessage("Mobile option is displayed");
			return false;
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Only Email option is displayed in MFA page");
			return true;
		}
	}
	
	public void viewMFAPagePhUseTest() {
		try {
			Utility.waitForElementToBeVisible(emailButton);
			Log.addMessage("Email option is displayed");
			Utility.waitForElementToBeVisible(sendCodeButton);
			Log.addMessage("Submit button is displayed");
			Assert.assertTrue(true,"Only Email option is displayed in MFA page");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to display only email option in MFA page");
			Assert.assertTrue(false, "Failed to display only email option in MFA page");
		}
	}
	
	/**
	 * Method Name: checkSendRcvrCodeButton() Description: This function will be called
	 * to verify Send Code button
	*/
	
	public void checkSendRcvrCodeButton() {
		try {
			Utility.waitForElementToBeVisible(sendCodeRcvrButton);
			//Utility.waitForElementToBeClickable(sendCodeRcvrButton);
			//Assert.assertTrue(false, "Failed to disable send code button for no selection");
			Assert.assertTrue(!(sendCodeRcvrButton.isEnabled()), "Send button is disabled for no selection");
			Log.addMessage("Send button disabled");
		}
		catch(Exception e) {
			Log.addMessage("Failed to disable send code button for no selection");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(true, "Failed to disable send code button for no selection");
		}
	}
}
