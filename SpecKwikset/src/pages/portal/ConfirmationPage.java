package pages.portal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import base.Settings;
import utility.Log;
import utility.Utility;

public class ConfirmationPage extends Settings {
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement passwordField;
	
	@FindBy(xpath="//input[@placeholder='Re-enter Password']")
	WebElement confirmPasswordField;
	
	@FindBy(id="create")
	WebElement confirmButton;
	
	@FindBy(xpath="//div[1]/label[1]")
	WebElement firstNameField;
	
	@FindBy(xpath="//div[1]/label[2]")
	WebElement firstNameValue;
	
	@FindBy(xpath="//div[2]/label[1]")
	WebElement lastNameField;
	
	@FindBy(xpath="//div[2]/label[2]")
	WebElement lastNameValue;
	
	@FindBy(xpath="//div[3]/label[1]")
	WebElement EmailField;
	
	@FindBy(xpath="//div[3]/label[2]")
	WebElement EmailValue;
	
	@FindBy(xpath="//div[4]/label[1]")
	WebElement mobilePhoneField;
	
	@FindBy(xpath="//div[4]/label[2]")
	WebElement MobilePhoneValue;
	
	@FindBy(xpath="//input[@placeholder='Password']/following-sibling::p")
	WebElement passwordValidationMessage1;
	
	@FindBy(xpath="//input[@placeholder='Re-enter Password']/following-sibling::p")
	WebElement rePasswordValidationMessage1;
	
	
	@SuppressWarnings("static-access")
	public ConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Method Name: enterPassword() Description: This function will be called
	 * to enter Password in Password text field
	 */
	
	public void enterPassword(String password) {
		try {
			Assert.assertTrue(passwordField.isDisplayed(), "Password Text field is visible");
			passwordField.clear();
			passwordField.sendKeys(password);
			Assert.assertTrue(confirmPasswordField.isDisplayed(), "Confirm Password Text field is visible");
			confirmPasswordField.clear();
			confirmPasswordField.sendKeys(password);
			Log.addMessage("Password entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter Password");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter Password");
		}
	}
	
	/**
	 * Method Name: enterPassword() Description: This function will be called
	 * to enter Password in Password text field
	 */
	
	/*public void enterConfPassword(String password, String rePassword) {
		try {
			Assert.assertTrue(passwordField.isDisplayed(), "Password Text field is visible");
			passwordField.clear();
			passwordField.sendKeys(password);
			Assert.assertTrue(confirmPasswordField.isDisplayed(), "Confirm Password Text field is visible");
			confirmPasswordField.clear();
			confirmPasswordField.sendKeys(rePassword);
			Log.addMessage("Password entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter Password");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter Password");
		}
	}*/
	
	/**
	 * Method Name: valEnterPassword() Description: This function will be called
	 * to validate Password in Password text field
	 */
	
	public void valEnterPassword(String password, String rePassword) {
		try {
			Assert.assertTrue(passwordField.isDisplayed(), "Password Text field is visible");
			passwordField.clear();
			passwordField.sendKeys(password);
			Assert.assertTrue(confirmPasswordField.isDisplayed(), "Confirm Password Text field is visible");
			confirmPasswordField.clear();
			confirmPasswordField.sendKeys(rePassword);
			Log.addMessage("Password entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter Password");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter Password");
		}
	}
	
	
	/**
	 * Method Name: validateFirstName() Description: This function will be called
	 * to validate First name value
	 */
	
	public void validateFirstName(String Firstname) {
		try {
			Assert.assertTrue(firstNameValue.getText().equalsIgnoreCase(Firstname),"First name validation passed");
			Log.addMessage("First name validation passed");
		}catch(Exception e) {
			Log.addMessage("Failed to validate firstname");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to validate firstname");
		}
	}
	
	/**
	 * Method Name: validateBackButtonpopup() Description: This function will be called
	 * to validate back button pop up
	 */
	
	public void validateBackButtonpopup(String popupmessage) {
		try {
			Utility.simpleWait(2000);
			driver.navigate().back(); 
			driver.switchTo().alert();
			System.out.println("text="+driver.switchTo().alert().getText());
			Assert.assertEquals(driver.switchTo().alert().getText(),popupmessage,"Pop up verbiage is matching");
			Log.addMessage("Pop up verbiage is matching");
			Thread.sleep(3000);
			driver.switchTo().alert().dismiss();
			Thread.sleep(3000);
			Log.addMessage("Clicked cancel button in the pop up");
		}catch(Exception e) {
			Log.addMessage("Failed to validate back button popup");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to validate back button popup");
		}
	}
	
	/**
	 * Method Name: clickBrwsrBackButton() Description: This function will be called
	 * to click browser back button
	 */
	
	public void clickBrwsrBackButton() {
		try {
			Utility.simpleWait(2000);
			driver.navigate().back(); 
			Thread.sleep(3000);
			Log.addMessage("Clicked back button in the browser");
		}catch(Exception e) {
			Log.addMessage("Failed to validate back button popup");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to validate back button popup");
		}
	}
	
	
	/**
	 * Method Name: validateLastName() Description: This function will be called
	 * to validate Last Name value
	 */
	
	public void ValidateLastName(String lastName) {
		try {
			Assert.assertTrue(lastNameValue.getText().equalsIgnoreCase(lastName), "Last name validation passed ");
			Log.addMessage("Last name validation passed");
		}catch(Exception e) {
			Log.addMessage("Failed to validate lastname");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to validate lastname");
		}
	}


	/**
	 * Method Name: validateEmail() Description: This function will be called
	 * to validate Email value
	 */
	
	public void validateEmail(String email) {
		try {
			Assert.assertTrue(EmailValue.getText().equals(email), "Email validation passed ");
			Log.addMessage("Email validation passed");
		}catch(Exception e) {
			Log.addMessage("Failed to validate email");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to validate email");
		}
	}
	

	/**
	 * Method Name: validateMobilePhone() Description: This function will be called
	 * to validate Mobile Phone number
	 */
	
	public void validateMobilePhone(String Phone) {
		try {
			Assert.assertTrue(MobilePhoneValue.getText().equalsIgnoreCase(Phone), "Mobile Phone validation passed ");
			Log.addMessage("Mobile Phone validation passed");
		}catch(Exception e) {
			Log.addMessage("Failed to validate Mobile Phone");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to validate Mobile Phone");
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
			Utility.simpleWait(5000);
			Log.addMessage("Confirm Button is clicked");
		}
		catch(Exception e) {
			Log.addMessage("Failed to click Confirm Button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click Confirm button");
		}
	}
	
	/**
	 * Method Name: checkConfirmButton() Description: This function will be called
	 * to click send button
	 */
	
	public void checkConfirmButton() {
		try {
			Utility.waitForElementToBeVisible(confirmButton);
			Utility.waitForElementToBeClickable(confirmButton);
			Assert.assertTrue(false, "Failed to disable confirm button for invalid selection");
			Log.addMessage("Confirm button clicked");
		}
		catch(Exception e) {
			Log.addMessage("Confirm button is disabled for invalid selection");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(true, "Confirm button is disabled for invalid selection");
		}
	}
	
	/**
	 * Method Name: invalidAns1Check() Description: This function will be called
	 * to enter phone number and verify the same
	*/
	public void invalidPasswordCheck() {
		try {
			Utility.simpleWait(6000);
			Utility.waitForElementToBeVisible(passwordValidationMessage1);
			System.out.println("Validation message is: "+passwordValidationMessage1.getText());
			Assert.assertTrue(passwordValidationMessage1.isDisplayed(), "Validation message displayed for password does not exist");
			//Assert.assertEquals(passwordValidationMessage1.getText(), valMessage, "Incorrect validation");
			Log.addMessage("Password to be verified is entered");
		}
		catch(Exception e) {
			Log.addMessage("Failed to enter password");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter password");
		}
	}
	
	/**
	 * Method Name: invalidRePasswordCheck() Description: This function will be called
	 * to enter password and verify the same
	 */
	
	public void invalidRePasswordCheck() {
		try {
			Utility.simpleWait(6000);
			Utility.waitForElementToBeVisible(rePasswordValidationMessage1);
			System.out.println("Validation message is: "+rePasswordValidationMessage1.getText());
			Assert.assertTrue(rePasswordValidationMessage1.isDisplayed(), "Validation message displayed for password re-entered does not exist");
			//Assert.assertEquals(rePasswordValidationMessage1.getText(), valMessage, "Incorrect validation");
			Log.addMessage("Password re-entered to be verified");
		}
		catch(Exception e) {
			Log.addMessage("Failed to re-enter password");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to re-enter password");
		}
	}
}
