package pages.portal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import base.Settings;
import utility.Log;
import utility.Utility;


public class EditProfilePage extends Settings {
	
	@FindBy(id="emailValue")
	WebElement emailValue;
	
	@FindBy(id="firstName")
	WebElement firstName;
	
	@FindBy(id="lastName")
	WebElement lastName;
	
	@FindBy(id="phone")
	WebElement mobileNumber;
	
	@FindBy(id="saveButton")
	WebElement confirmButton;
	
	@FindBy(xpath="//div[@class='modal-footer']/button")
	WebElement OKButton;

	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible fade in']")
	WebElement updateMessage;
	
	@FindBy(xpath="(//div[@class='alert alert-danger alert-dismissible fade in']/a)[1]")
	WebElement closeButton;
	
	@FindBy(xpath="//input[@formcontrolname='firstName']/following-sibling::p")
	WebElement firstNameValidationMessage;
	
	@FindBy(xpath="//input[@formcontrolname='lastName']/following-sibling::p")
	WebElement lastNameValidationMessage;
	
	@FindBy(xpath="//input[@formcontrolname='phone']/following-sibling::p")
	WebElement phoneValidationMessage;
	
	
	@SuppressWarnings("static-access")
	public EditProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	/**
	 * Method Name: validateEmail() Description: This function will be called
	 * to validate Email
	 */
	
	public void validateEmail(String email) {
		try {
			Assert.assertTrue(emailValue.getText().equalsIgnoreCase(email),"Email address is correctly displayed");
			Log.addMessage("Email address of the user is validated");
		}catch(Exception e) {
			Log.addMessage("Email address is incorrect");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to validate email address");
		}
	}


	/**
	 * Method Name: updateFirstName() Description: This function will be called
	 * to update First Name
	 */
	
	public void updateFirstName(String firstname) {
		try {
			Assert.assertTrue(firstName.isDisplayed(),"First Name field is visible");
			firstName.clear();
			firstName.sendKeys(firstname);
			Log.addMessage("First Name of the user is successfully updated");
		}catch(Exception e) {
			Log.addMessage("Failed to update First Name");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to update First Name");
		}
	}
	

	/**
	 * Method Name: updateLastName() Description: This function will be called
	 * to update Last Name
	 */
	
	public void updateLastName(String lastname) {
		try {
			Assert.assertTrue(lastName.isDisplayed(),"Last Name field is visible");
			lastName.clear();
			lastName.sendKeys(lastname);
			Log.addMessage("Last Name of the user is successfully updated");
		}catch(Exception e) {
			Log.addMessage("Failed to update Last Name");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to update Last Name");
		}
	}
	

	/**
	 * Method Name: updateMbobileNumber() Description: This function will be called
	 * to update Mobile Number
	 */
	
	public void updateMobileNumber(String phone) {
		try {
			Assert.assertTrue(mobileNumber.isDisplayed(),"Mobile Number field is visible");
			mobileNumber.clear();
			if(phone!="") {
				mobileNumber.sendKeys(phone);
			}
			Log.addMessage("Mobile Number of the user is successfully updated");
		}catch(Exception e) {
			Log.addMessage("Failed to update Mobile Number");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to update Mobile Number");
		}
	}
	

	/**
	 * Method Name: clickConfirmButton() Description: This function will be called
	 * to click Confirm button
	 */
	
	public void clickConfirmButton() {
		try {
			Assert.assertTrue(confirmButton.isDisplayed(),"Confirm Button is visible");
			confirmButton.click();
			Utility.simpleWait(3000);
			Log.addMessage("Confirm Button clicked");
		}catch(Exception e) {
			Log.addMessage("Failed to click Confirm Button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click Confirm Button");
		}
	}
	
	/**
	 * Method Name: clickOkButton() Description: This function will be called
	 * to click OK button
	 */
	
	public void clickOKButton() {
		try {
			Utility.waitForElementToBeVisible(OKButton);
			Assert.assertTrue(OKButton.isDisplayed());
			OKButton.click();
		}catch(Exception e) {
			Log.addMessage("Failed to click OK Button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click OK Button");
		}
	}
	
	public void checkUpdateMessage(String successMessage) {
		try {
			Utility.waitForElementToBeVisible(updateMessage);
			Assert.assertTrue(updateMessage.isDisplayed(),"Update message displayed");
			Assert.assertTrue(updateMessage.getText().contains(successMessage),"Profile updated successfully");
			closeButton.click();
		}catch(Exception e) {
			Log.addMessage("Failed to update profile");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Profile not updated");
		}
	}
	
	public void updateUserName(String firstname,String lastname,String mobNumber,String firstNameValMsg,String lastNameValMsg,String MobileValMsg,String errValMsg) {
		try {
			EditProfilePage ep=new EditProfilePage(driver);
			ep.updateFirstName(firstname);
			ep.updateLastName(lastname);
			if(!mobNumber.equals("same")) {
				ep.updateMobileNumber(mobNumber);
			}
			ep.clickConfirmButton();
			Utility.simpleWait(2000);
			if(firstNameValMsg!="") {
				if(firstNameValidationMessage.isDisplayed()) {
				Assert.assertTrue(firstNameValidationMessage.getText().contains(firstNameValMsg), "Validation is proper");
				Log.addMessage("Validation message for first name is proper");
				}
			}
			
			if(lastNameValMsg!="") {
				Assert.assertTrue(lastNameValidationMessage.getText().contains(lastNameValMsg), "Validation is proper");
				Log.addMessage("Validation message for last name is proper");
			}
			if(MobileValMsg!="") {
				Assert.assertTrue(phoneValidationMessage.getText().contains(MobileValMsg), "Validation is proper");
				Log.addMessage("Validation message for mobile number is proper");
			}
			
			if(errValMsg!="") {
				Assert.assertTrue(updateMessage.getText().contains(errValMsg), "Validation is proper");
				Log.addMessage("Validation error message is proper");
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
