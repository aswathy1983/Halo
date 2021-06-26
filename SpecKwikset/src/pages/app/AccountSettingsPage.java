package pages.app;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import utility.Log;
import utility.Utility;

public class AccountSettingsPage extends Settings{
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Delete Account']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/ll_delete_account"),
		@AndroidBy(id = "com.kwikset.blewifi:id/ll_delete_account"),
		@AndroidBy(id = "com.spectrum.giga:id/ll_delete_account"),
		@AndroidBy(id = "com.weiser.blewifi:id/ll_delete_account")
	})
	@CacheLookup
	private MobileElement deleteAccountOption;
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Delete Account']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/ll_delete_account"),
		@AndroidBy(id = "com.kwikset.blewifi:id/ll_delete_account"),
		@AndroidBy(id = "com.spectrum.giga:id/ll_delete_account"),
		@AndroidBy(id = "com.weiser.blewifi:id/ll_delete_account")
	})
	@CacheLookup
	private MobileElement deleteOption;
	//added on 29-07-2020 regression
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Delete Account']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/ll_delete_account"),
		@AndroidBy(id = "com.kwikset.blewifi:id/ll_delete_account"),
		@AndroidBy(id = "com.spectrum.giga:id/ll_delete_account"),
		@AndroidBy(id = "com.weiser.blewifi:id/ll_delete_account")
	})
	@CacheLookup
	private MobileElement deleteIOption;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Ok']")
	@AndroidFindBy(xpath = "//android.widget.Switch")
	@CacheLookup
	private MobileElement bioUnlockButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Ok']")
	@AndroidFindBy(id = "android:id/button1")
	@CacheLookup
	private MobileElement okButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	@AndroidFindBy(id = "android:id/button2")
	@CacheLookup
	private MobileElement cancelButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Delete']")
	@CacheLookup
	private MobileElement deleteButton;
	
	//@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]//XCUIElementTypeStaticText[@name='Name']/following-sibling::XCUIElementTypeStaticText")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[1]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_name"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_name"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_name"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_name")
	})//added on 05-05-2020
	@CacheLookup
	private MobileElement name;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[2]")
	//XCUIElementTypeStaticText[@name='Phone Number']/following-sibling::XCUIElementTypeStaticText")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_phone_number"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_phone_number"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_phone_number"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_phone_number")
	})//added on 05-05-2020
	@CacheLookup
	private MobileElement phoneNumber;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[3]")
	//XCUIElementTypeStaticText[@name='Email']/following-sibling::XCUIElementTypeStaticText")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_email"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_email"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_email"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_email")
	})//added on 06-07-2020
	@CacheLookup
	private MobileElement email;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[4]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/edt_change_password"),
		@AndroidBy(id = "com.kwikset.blewifi:id/edt_change_password"),
		@AndroidBy(id = "com.spectrum.giga:id/edt_change_password"),
		@AndroidBy(id = "com.weiser.blewifi:id/edt_change_password")
	})//added on 06-07-2020
	@CacheLookup
	private MobileElement changePassword;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[5]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_change_question"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_change_question"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_change_question"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_change_question")
	})//added on 06-07-2020
	@CacheLookup
	private MobileElement changeSecurityQuestions;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/cancelAllhomes"),
		@AndroidBy(id = "com.kwikset.blewifi:id/cancelAllhomes"),
		@AndroidBy(id = "com.spectrum.giga:id/cancelAllhomes"),
		@AndroidBy(id = "com.weiser.blewifi:id/cancelAllhomes")
	})//added on 04-05-2020
	private MobileElement navBack;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[1]")
	@AndroidFindBy(id="android:id/alertTitle")
	private MobileElement alertTitle;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[2]")
	@AndroidFindBy(id = "android:id/message")
	@CacheLookup
	private MobileElement popUpMessageVerbiage;
	
	String actTitle, actMessage, actualRes, toastMessage ="";
	
		
	//Constructor
	
	@SuppressWarnings("static-access")
	public AccountSettingsPage(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
		
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
			
	public void clickDeleteAccountOption() {
		try {
			Utility.waitForElementToBeVisible(deleteAccountOption);
			Utility.waitForElementToBeClickable(deleteAccountOption);
			deleteAccountOption.click();
			Log.addMessage("Clicked Delete Account option");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click Delete Account option.");
			Assert.assertTrue(false, "Failed to click Delete Account option.");
		}
	}
	
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
			
	public void clickNameOption() {
		try {
			Thread.sleep(3000);
			Utility.waitForElementToBeVisible(name);
			//Utility.waitForElementToBeClickable(name);
			name.click();
			Log.addMessage("Clicked Name option");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click Name option.");
			Assert.assertTrue(false, "Failed to click Name option.");
		}
	}
	
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
			
	public void clickPhoneNumberOption() {
		try {
			Utility.waitForElementToBeVisible(phoneNumber);
			Utility.waitForElementToBeClickable(phoneNumber);
			phoneNumber.click();
			Log.addMessage("Clicked Phone Number option");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click Phone Number option.");
			Assert.assertTrue(false, "Failed to click Phone Number option.");
		}
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
			
	public void getEmailofUser() {
		try {
			Utility.waitForElementToBeVisible(email);
			String emailAddress = email.getText();
			Log.addMessage("Email Address of the user is: "+emailAddress);
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to get email address of the user.");
			Assert.assertTrue(false, "Failed to get email address of the user.");
		}
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
			
	public void clickChangePasswordOption() {
		try {
			Utility.waitForElementToBeVisible(changePassword);
			Utility.waitForElementToBeClickable(changePassword);
			changePassword.click();
			Log.addMessage("Clicked Change Password option");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click Change Password option.");
			Assert.assertTrue(false, "Failed to click Change Password option.");
		}
	}
	
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
			
	public void clickChangeSecurityQuestionsOption() {
		try {
			Utility.waitForElementToBeVisible(changeSecurityQuestions);
			Utility.waitForElementToBeClickable(changeSecurityQuestions);
			changeSecurityQuestions.click();
			Log.addMessage("Clicked Change Security Questions option");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click Change Security Questions option.");
			Assert.assertTrue(false, "Failed to click Change Security Questions option.");
		}
	}
	
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
			
	public void clickDeleteOption() {
		try {
			Utility.waitForElementToBeVisible(deleteOption);
			Utility.waitForElementToBeClickable(deleteOption);
			deleteOption.click();
			Utility.waitForElementToBeVisible(okButton);
			Utility.waitForElementToBeClickable(okButton);
			okButton.click();
			Log.addMessage("Clicked Delete option in the pop up");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click Delete option in the pop up.");
			Assert.assertTrue(false, "Failed to click Delete option in the pop up.");
		}
	}
	
	/*  Code added on 04-05-2020  */
	
	/** 
	* Method Name: clickNavBack(), 
	* This function is used to go Back from Account Settings to Account Page
	*/
			
	public void clickNavBack() {
		try {
			Utility.waitForElementToBeVisible(navBack);
			Utility.waitForElementToBeClickable(navBack);
			navBack.click();
			Log.addMessage("Clicked Back Button");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click Back option.");
			Assert.assertTrue(false, "Failed to click Back option.");
		}
	}
	/*  Code added on 03-07-2020  */
	
	public void verifyUIAccountSettingsPage() {
		try {
			Utility.simpleWait(7000);
			Utility.waitForElementToBeVisible(name);
			Log.addMessage("Account Name is displayed");
			Utility.waitForElementToBeVisible(phoneNumber);
			Log.addMessage("Phone Number is displayed");
			Utility.waitForElementToBeVisible(email);
			Log.addMessage("Email is displayed");
			Utility.waitForElementToBeVisible(changePassword);
			Log.addMessage("Change Password option is displayed");
			Utility.waitForElementToBeVisible(changeSecurityQuestions);
			Log.addMessage("Change Security Questions option is displayed");
			Utility.waitForElementToBeVisible(deleteAccountOption);
			Log.addMessage("Delete Account option is displayed");
			Utility.waitForElementToBeVisible(navBack);
			Log.addMessage("Back button is displayed");
			Assert.assertTrue(true,"All elements displayed in account settings page");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to display all elements in account settings page");
			Assert.assertTrue(false, "Failed to display all elements in account settings page");
		}
	}
	
	/** 
	* Method Name: clickBiometricUnlockOption(), 
	* This function is used to select biometric unlock option from account settings Page
	*/
			
	public void clickBiometricUnlockOption() {
		try {
			Utility.waitForElementToBeVisible(bioUnlockButton);
			Utility.waitForElementToBeClickable(bioUnlockButton);
			bioUnlockButton.click();
			Utility.simpleWait(2000);
			System.out.println("Biometric option is :"+bioUnlockButton.getText());
			Log.addMessage("Biometric option is :"+bioUnlockButton.getText());
			Log.addMessage("Clicked biometric unlock option");
		}catch(Exception e) {
			Log.addMessage("Failed to click biometric unlock option.");
			Assert.assertTrue(false, "Failed to click biometric unlock option.");
		}
	}
	
	public void verifyDeletePopUpVerbiage(String ttlMessage, String expMessage) {
		try {
			Utility.waitForElementToBeVisible(popUpMessageVerbiage);
			actMessage = popUpMessageVerbiage.getText();
			System.out.println("expmainMsg="+expMessage+",mainMsg="+actMessage);	
			Assert.assertEquals(actMessage, expMessage,"Popup content message is not matching");
			
			Log.addMessage("Pop up verbiage is matching");
		}catch(Exception e) {
			Log.addMessage("Pop up verbiage is not matching");
			Assert.assertTrue(false, "Pop up verbiage is not matching");
		}
	}
	
	public void clickDeleteButton() {
		try {
			if(device.equals("iOS")) {
				Utility.waitForElementToBeVisible(deleteIOption);
				Utility.waitForElementToBeClickable(deleteIOption);
				deleteIOption.click();
			}else {
				Utility.waitForElementToBeVisible(deleteOption);
				Utility.waitForElementToBeClickable(deleteOption);
				deleteOption.click();
			}
			
			Log.addMessage("Clicked Delete option in the pop up");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click Delete option in the pop up.");
			Assert.assertTrue(false, "Failed to click Delete option in the pop up.");
		}
	}
	
	public void clickOKButton() {
		try {
			Utility.waitForElementToBeVisible(okButton);
			Utility.waitForElementToBeClickable(okButton);
			okButton.click();
			Log.addMessage("Clicked Ok button in the pop up");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click Ok button in the pop up.");
			Assert.assertTrue(false, "Failed to click Ok button in the pop up.");
		}
	}
	
	public void clickCancelButton() {
		try {
			Utility.waitForElementToBeVisible(cancelButton);
			Utility.waitForElementToBeClickable(cancelButton);
			cancelButton.click();
			Log.addMessage("Clicked cancel button in the pop up");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click cancel button in the pop up.");
			Assert.assertTrue(false, "Failed to click cancel button in the pop up.");
		}
	}
	
	public void confirmDelete() {
		try {
			Utility.waitForElementToBeVisible(deleteButton);
			Utility.waitForElementToBeClickable(deleteButton);
			deleteButton.click();
			Log.addMessage("Clicked delete button in the pop up");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click delete button in the pop up.");
			Assert.assertTrue(false, "Failed to click delete button in the pop up.");
		}
	}

}
