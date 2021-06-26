package pages.portal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Settings;
import utility.Log;
import utility.Utility;

public class ChangePasswordPage extends Settings {
	
	@FindBy(id="existingPassword")
	WebElement existingPasswordField;
	
	@FindBy(id="newPassword")
	WebElement newPasswordField;
	
	@FindBy(id="confirmNewPassword")
	WebElement confirmNewPasswordField;
	
	@FindBy(id="submitPassword")
	WebElement updateButton;
	
	@FindBy(id="loginSubmit")
	WebElement loginButton;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible fade in']")
	WebElement updateMessage;
	
	@FindBy(xpath="(//div[@class='alert alert-danger alert-dismissible fade in']/a)[1]")
	WebElement closeButton;
	
	@FindBy(xpath="//input[@formcontrolname='newPassword']/following-sibling::p")
	WebElement newPwdValidationMessage1;
	
	@FindBy(xpath="//input[@formcontrolname='confirmNewPassword']/following-sibling::p")
	WebElement confPwdValidationMessage2;
	
	@SuppressWarnings("static-access")
	public ChangePasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Method Name: enterExistingPassword() Description: This function will be called
	 * to enter xisting password in the existing password text field
	 */

	public void enterExistingPassword(String password) {
		try {
			Assert.assertTrue(existingPasswordField.isDisplayed(),"Existing password field is visible");
			existingPasswordField.clear();
			existingPasswordField.sendKeys(password);
			Log.addMessage("Existing password is entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter existing password");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter existing password");
		}
	}
	
	/**
	 * Method Name: enterNewPassword() Description: This function will be called
	 * to enter new password in the New password text field
	 */
	
	public void enterNewPassword(String newPassword) {
		try {
			Assert.assertTrue(newPasswordField.isDisplayed(),"New password field is visible");
			newPasswordField.clear();
			newPasswordField.sendKeys(newPassword);
			Log.addMessage("New password is entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter New password");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter new password");
		}
	}
	
	/**
	 * Method Name: enterConfirmNewPassword() Description: This function will be called
	 * to enter password in the Confirm New Password text field
	 */
	
	public void enterConfirmNewPassword(String newPassword) {
		try {
			Assert.assertTrue(confirmNewPasswordField.isDisplayed(),"Confirm New password field is visible");
			confirmNewPasswordField.clear();
			confirmNewPasswordField.sendKeys(newPassword);
			Log.addMessage("New password is confirmed");
		}catch(Exception e) {
			Log.addMessage("Failed to Confirm New password");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to confirm new password");
		}
	}
	
	/**
	 * Method Name: clickUpdateButton() Description: This function will be called
	 * to click Update Button
	 */
	
	public void clickUpdateButton() {
		try {
			Assert.assertTrue(updateButton.isDisplayed(),"Update Button is visible");
			updateButton.click();
			Utility.simpleWait(10000);
			Log.addMessage("Update Button clicked");
		}catch(Exception e) {
			Log.addMessage("Failed to click Update Button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click Update Button");
		}
	}
	//added on 5th August
	/**
	 * Method Name: checkUpdateButton() Description: This function will be called
	 * to check Update Button
	 */
	
	public void checkUpdateButton() {
		try {
			Utility.waitForElementToBeVisible(updateButton);
			System.out.println("in btn="+updateButton.isEnabled());
			Assert.assertTrue(!(updateButton.isEnabled()),"Update Button is disabled for invalid selection");
			Utility.simpleWait(3000);
			Log.addMessage("Update Button is disabled for invalid selection");
		}catch(Exception e) {
			Log.addMessage("Failed to disable Update Button for invalid selection");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to disable Update Button for invalid selection");
		}
	}
	
		//added on 4th March 2021
		/**
		 * Method Name: checkLoginButton() Description: This function will be called
		 * to check if password is changed and redirected to login page 
		 */
		
		public void checkLoginButton() {
			try {
				Utility.waitForElementToBeVisible(loginButton);
				Utility.waitForElementToBeClickable(loginButton);
				Assert.assertTrue(loginButton.isDisplayed(), "Login Button is visible");
				Utility.simpleWait(3000);
				Log.addMessage("Password updated successfully");
			}catch(Exception e) {
				Log.addMessage("Failed to update password");
				System.out.println(e.getMessage().toString());
				Assert.assertTrue(false, "Failed to update password");
			}
		}
	
	/** 
	* Method Name: updatePassword(), 
	* This function is used to update Password in Edit field of  EditPassword Page
	*/
		
	public void valPassword(String oldPwd,String nwPwd, String reNewPwd, String titleMsg, String errMessage, String mainMsg) {
		try {		
			Utility.simpleWait(5000);
			//System.out.println("in update pwd");
			enterExistingPassword(oldPwd);
			enterNewPassword(nwPwd);
			enterConfirmNewPassword(reNewPwd);
			//clickUpdateButton();			
			Utility.simpleWait(2000);	
			if(mainMsg!="") {
				updateButton.click();
			}else {
				checkUpdateButton();
			}
			
			if(titleMsg!="") {
				Assert.assertTrue(newPwdValidationMessage1.getText().contains(titleMsg), "Validation is proper");
				Log.addMessage("Validation message for New Password is proper");	
			}
			if(errMessage!="") {
				Assert.assertTrue(confPwdValidationMessage2.getText().contains(errMessage), "Validation is proper");
				Log.addMessage("Validation message for Confirm Password is proper");	
			}
			if(mainMsg!="") {
				Assert.assertTrue(updateMessage.getText().contains(mainMsg), "Validation is proper");
				closeButton.click();
				Log.addMessage("Validation message after update is clicked is proper");	
			}
			Utility.simpleWait(2000);
			Log.addMessage("Password Updated and directed to AccountSettings page");
		}catch(Exception e) {
			Log.addMessage("Password Not Updated");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Password Not Updated");
		}
	}
	
	
}
