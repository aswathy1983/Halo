package pages.portal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Settings;
import utility.Log;

public class ForgotPasswordPage extends Settings{
	
	@FindBy(id="emailVerify")
	WebElement usernameField;
	
	@FindBy(id="submitEmail")
	WebElement confirmButton;
	
	@SuppressWarnings("static-access")
	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
  

	/**
	 * Method Name: enterUsername() Description: This function will be called
	 * to enter username
	 */
	
	public void enterUsername(String email) {
		try {
			Assert.assertTrue(usernameField.isDisplayed(), "Username field is visible");
			usernameField.clear();
			usernameField.sendKeys(email);
			Log.addMessage("Username is entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter username");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter username");
		}
	}

	/**
	 * Method Name: clickConfirmButton() Description: This function will be called
	 * to click Confirm button
	 */
	
	public void clickConfirmButton() {
		try {
			Assert.assertTrue(confirmButton.isDisplayed(), "Confirm Button is visible");
			confirmButton.click();
			Log.addMessage("Confirm Button clicked");
		}catch(Exception e) {
			Log.addMessage("Failed to click confirm Button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click confirm Button");
		}
	}

}
