package pages.portal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Settings;
import utility.Log;
import utility.Utility;

public class UserHomePage extends Settings {
	
	@FindBy(xpath="//p[@class='sp-red-text']")
	WebElement userName;
	
	@FindBy(xpath="//button[@data-toggle='dropdown']")
	WebElement dropDownButton;
	
	//@FindBy(linkText="Edit My Profile")
	@FindBy(xpath="//a[text()='Edit My Profile']")
	WebElement editProfile;
	
	@FindBy(linkText="Change Password")
	WebElement changePassword;
	
	@FindBy(linkText="Change Security Questions")
	WebElement changeSecurityQuestions;
	
	@FindBy(linkText="Enable/Disable My Account")
	WebElement enableDisableMyAccount;

	@FindBy(linkText="Delete My Account")
	WebElement deleteMyAccount;
	
	@FindBy(linkText="Log Out")
	WebElement logout;
	
	
	@SuppressWarnings("static-access")
	public UserHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	/**
	 * Method Name: clickHAmburgerMenuButton() Description: This function will be called
	 * to click Hamburger menu button
	*/
	
	public void clickHamburgerMenuButton(){
		try {
			Utility.simpleWait(6000);
			Utility.waitForElementToBeVisible(dropDownButton);
			dropDownButton.click();
			//Utility.clickAction(driver, dropDownButton);
			Log.addMessage("Hamburger Menu button clicked");
		}catch(Exception e) {
			Log.addMessage("Failed to click Hamburger Menu button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click Hamburger Menu button");
		}		
	}
	
	/**
	 * Method Name: validateUserName() Description: This function will be called
	 * to validate Username
	 */
	
	public void validateUserName(String name) {
		try {
			Assert.assertTrue(userName.getText().equalsIgnoreCase("Hi "+name),"Username is correctly displayed");
			Log.addMessage("Username correctly displayed");
		}catch(Exception e) {
			Log.addMessage("Validation of User Login is failed");
			Log.addMessage(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to validate User Login");
		}
	}
	
	/**
	 * Method Name: validateContentsInDropDown() Description: This function will be called
	 * to validate Contents in the drop down
	 */
	
	public void validateContentsInDropDown() {
		try {
			List<WebElement>dropDownList=driver.findElements(By.xpath("//app-nav-bar/div/div/ul[@class='dropdown-menu sp-dropdown']/li"));
			for(int i=0;i<dropDownList.size();i++) {
				Log.addMessage("Element "+i+" is:"+driver.findElement(By.xpath("//app-nav-bar/div/div/ul[@class='dropdown-menu sp-dropdown']/li["+i+"]/a")).getText());
			}
			Log.addMessage("Contents in Drop Down list are validated");
		}catch(Exception e) {
			Log.addMessage("Validation of Hamburger menu contents failed");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to validate Hamburger menu contents");
		}
	}

	/**
	 * Method Name: selectEditProfileOption() Description: This function will be called
	 * to select Edit Profile option from the drop down
	 */
	
	public void selectEditProfileOption() {
		try {
			//Utility.wait(editProfile);
			editProfile.click();
			Log.addMessage("Edit Profile option selected");
		}catch(Exception e) {
			Log.addMessage("Failed to select EditProfile option");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to select EditProfile option");
		}
	}
	
	/**
	 * Method Name: selectChangePasswordOption() Description: This function will be called
	 * to select Change Password option from the drop down
	 */
	
	public void selectChangePasswordOption() {
		try {
			//Utility.wait(changePassword);
			changePassword.click();
			Log.addMessage("Change Password option selected");
		}catch(Exception e) {
			Log.addMessage("Failed to select Change Password option");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to select Change Password option");
		}
	}
	
	/**
	 * Method Name: selectChnageSecurityQuestionsOption() Description: This function will be called
	 * to select Change Security Questions option from the drop down
	 */
	
	public void selectChangeSecurityQuestionsOption() {
		try {
		
			//Utility.wait(changeSecurityQuestions);
			changeSecurityQuestions.click();
			Utility.simpleWait(6000);
			Log.addMessage("Change Security Questions option selected");
		}catch(Exception e) {
			Log.addMessage("Failed to select Change Security Questions option");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to slect Change Security Questions option");
		}
	}
	
	/**
	 * Method Name: selectEnableDisableMyAccountOption() Description: This function will be called
	 * to select Enable/Disable My Account option from the drop down
	 */
	
	public void selectEnableDisableMyAccountOption() {
		try {
			//Utility.wait(enableDisableMyAccount);
			enableDisableMyAccount.click();
			Log.addMessage("Enable/Disable My Account option selected");
		}catch(Exception e) {
			Log.addMessage("Failed to select Enable/Disable My Account option");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to select Enable/Disable My Account option");
		}
	}
	
	/**
	 * Method Name: selectDeleteMyAccountOption() Description: This function will be called
	 * to select Delete My Account option from the drop down
	 */
	
	public void selectDeleteMyAccountOption() {
		try {
			//Utility.wait(deleteMyAccount);
			deleteMyAccount.click();
			Utility.simpleWait(6000);
			//Utility.clickAction(driver, deleteMyAccount);
			Log.addMessage("Delete My Account option selected");
		}catch(Exception e) {
			Log.addMessage("Failed to select Delete My Account option");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click Delete My Account option");
		}
	}
	
	/**
	 * Method Name: clickLogoutOption() Description: This function will be called
	 * to select Logout option from the drop down
	 */
	
	public void clickLogout() {
		try {
			Utility.simpleWait(2000);
			logout.click();
			Log.addMessage("Logout option clicked");
			Utility.simpleWait(3000);
		}catch(Exception e) {
			Log.addMessage("Failed to click logout option");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click logout option");
		}
	}
	
	/**
	 * Method Name: viewListofHomes() Description: This function will be called
	 * to view list of homes
	 */
	
	public void viewListofHomes() {
		try {
			
		}catch(Exception e) {
			Log.addMessage("Failed to get list of homes");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to get list of homes");
		}
	}
	
	/**
	 * Method Name: viewListofLocks() Description: This function will be called
	 * to view list of locks
	 */
	
	public void viewListofLocks() {
		try {
			
		}catch(Exception e) {
			Log.addMessage("Failed to get list of locks");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to get list of locks");
		}
	}
	
	
}
