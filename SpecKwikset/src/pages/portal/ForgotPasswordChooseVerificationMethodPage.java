package pages.portal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Settings;
import utility.Log;
import utility.Utility;

public class ForgotPasswordChooseVerificationMethodPage extends Settings {

	@FindBy(id="choice-email")
	WebElement emailButton;
	
	@FindBy(id="choice-phone")
	WebElement phoneButton;
		
	@FindBy(id="selectVerificationCodeType")
	WebElement sendButton;
	
	
	@SuppressWarnings("static-access")
	public ForgotPasswordChooseVerificationMethodPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	/**
	 * Method Name: clickEmailButton() Description: This function will be called
	 * to click Email button
	 */
	
	public void clickEmailButton() {
		try {
			//Assert.assertTrue(emailButton.isDisplayed(), "Email Button is visible");
			Utility.simpleWait(4000);
			emailButton.click();
			Log.addMessage("Verification through email is selected");
		}catch(Exception e) {
			Log.addMessage("Verification through email is not selected");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to select email as verification method");
		}
	}
	

	/**
	 * Method Name: clickPhoneButton() Description: This function will be called
	 * to click phone button
	 */
	
	public void clickPhoneButton() {
		try {
			Assert.assertTrue(phoneButton.isDisplayed(), "Phone Button is visible");
			phoneButton.click();
			Log.addMessage("Verification through phone is selected");
		}catch(Exception e) {
			Log.addMessage("Verification through phone is not selected");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to select phone as verification method");
		}
	}
	
	/**
	 * Method Name: clickSendButton() Description: This function will be called
	 * to click Send button
	 */
	
	public void clickSendButton() {
		try {
			Assert.assertTrue(sendButton.isDisplayed(), "Send Button is visible");
			sendButton.click();
			Log.addMessage("Verification Code is sent");
		}catch(Exception e) {
			Log.addMessage("Verification code cannot be send");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to send verification code");
		}
	}
}
