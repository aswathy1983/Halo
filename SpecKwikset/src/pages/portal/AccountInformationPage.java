package pages.portal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Settings;
import utility.Log;
import utility.Utility;

public class AccountInformationPage extends Settings{
	
	@FindBy(id="emailVerify")
	WebElement emailField;
	
	@FindBy(id="submitEmail") 
	WebElement confirmButton;
	
	
	@SuppressWarnings("static-access")
	public AccountInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Method Name: enterEmail() Description: This function will be called
	 * to enter Email address in the email text field
	 */
	
	public void enterEmail(String email) {
		try {
			Assert.assertTrue(emailField.isDisplayed(),"Email field is visible");
			emailField.sendKeys(email);
			Log.addMessage("Email address of the user is entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter email address");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter email address");
		}
	}
	
	/**
	 * Method Name: clickConfirmButton() Description: This function will be called
	 * to click Confirm Button
	 */
	
	public void clickConfirmButton() {
		try {
			Utility.simpleWait(5000);
			//Utility.wait(confirmButton);
			Assert.assertTrue(confirmButton.isDisplayed(),"Confirm Button is visible");
			confirmButton.click();
			Log.addMessage("Confirm Button clicked");
		}catch(Exception e) {
			Log.addMessage("Failed to click Confirm Button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click Confirm Button");
		}
	}

}
