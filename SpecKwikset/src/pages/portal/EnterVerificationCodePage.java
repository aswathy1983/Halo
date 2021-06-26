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

public class EnterVerificationCodePage extends Settings {
	
	@FindBy(id="verificationCode")
	WebElement enterVerificationCodeField;
	
	@FindBy(id="submitCode")
	WebElement verifyButton;
	
	@SuppressWarnings("static-access")
	public EnterVerificationCodePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
  

	/**
	 * Method Name: enterVerificationCode() Description: This function will be called
	 * to enter verification code
	 */
	

	public void enterVerificationCodeEmail() {
		try {
			Assert.assertTrue(enterVerificationCodeField.isDisplayed(), "Enter Verification Code field is visible");
			enterVerificationCodeField.clear();
			String code=ReadEmail.getAccessCode(PropertyUtility.getProperty("emailSub"));
			enterVerificationCodeField.sendKeys(code);
			Log.addMessage("Verification Code is entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter Verification Code");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter Verification Code");
		}
	}

	public void enterVerificationCodeMobile() {
		try {
			Utility.simpleWait(3000);
			enterVerificationCodeField.click();
			enterVerificationCodeField.clear();
			Utility.simpleWait(7000);
			String code=ReadEmail.getAccessCodeMobile(PropertyUtility.getProperty("phoneSub"));
			code = code.replace("code is ", "");
			enterVerificationCodeField.sendKeys(code);
			Log.addMessage("Verification code entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter Verification code");
			Assert.assertTrue(false, "Failed to enter Verification code");
		}
	}


	/**
	 * Method Name: clickVerifyButton() Description: This function will be called
	 * to click Verify button
	 */
	
	public void clickVerifyButton() {
		try {
			Assert.assertTrue(verifyButton.isDisplayed(), "Verify Button is visible");
			verifyButton.click();
			Log.addMessage("Verify Button Clicked");
		}catch(Exception e) {
			Log.addMessage("Failed to click Verify Button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click Verify Button");
		}
	}

}
