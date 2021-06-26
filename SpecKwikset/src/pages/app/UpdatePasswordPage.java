package pages.app;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
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

public class UpdatePasswordPage extends Settings{
		
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[1]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/edt_old_password"),
		@AndroidBy(id = "com.kwikset.blewifi:id/edt_old_password"),
		@AndroidBy(id = "com.spectrum.giga:id/edt_old_password"),
		@AndroidBy(id = "com.weiser.blewifi:id/edt_old_password")
	})
	@CacheLookup
	private MobileElement oldPasswordField;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[2]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/edt_new_password"),
		@AndroidBy(id = "com.kwikset.blewifi:id/edt_new_password"),
		@AndroidBy(id = "com.spectrum.giga:id/edt_new_password"),
		@AndroidBy(id = "com.weiser.blewifi:id/edt_new_password")
	})
	@CacheLookup
	private MobileElement newPasswordField;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[3]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/edt_re_enter"),
		@AndroidBy(id = "com.kwikset.blewifi:id/edt_re_enter"),
		@AndroidBy(id = "com.spectrum.giga:id/edt_re_enter"),
	})
	@CacheLookup
	private MobileElement reEnterNewPasswordField;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Submit']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_submit"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_submit"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_submit"),
	})
	@CacheLookup
	private MobileElement submitButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/cancelAllhomes"),
		@AndroidBy(id = "com.kwikset.blewifi:id/cancelAllhomes"),
		@AndroidBy(id = "com.spectrum.giga:id/cancelAllhomes"),
	})
	@CacheLookup
	private MobileElement backButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Ok']")
	@AndroidFindBy(id="android:id/button1")
	@CacheLookup
	private MobileElement okButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[2]")
	@AndroidFindBy(id="android:id/message")
	private MobileElement confirmMessage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[1]")
	@AndroidFindBy(id="android:id/alertTitle")
	private MobileElement alertTitle;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
	private MobileElement doneKeyboard;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Next:']")
	private MobileElement nextKeyboard;
	
	String actTitle, actMessage, actualRes ="";
	
	
	//Constructor
	
	@SuppressWarnings("static-access")
	public UpdatePasswordPage(AppiumDriver<MobileElement> driver) {
	this.appiumDriver = driver;
	PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void enterOldPassword(String oldPassword) {
		try {
			Utility.simpleWait(5000);
			//oldPasswordField.click();//commented on 07-07-2020
			oldPasswordField.clear();
			oldPasswordField.sendKeys(oldPassword);
			Log.addMessage("Old Password entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter Old password");
			Assert.assertTrue(false, "Failed to enter Old Password");
		}
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void enterNewPassword(String newPassword) {
		try {
			Utility.simpleWait(5000);
			//newPasswordField.click();//commented on 07-07-2020
			newPasswordField.clear();
			newPasswordField.sendKeys(newPassword);
			Log.addMessage("New Password entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter New password");
			Assert.assertTrue(false, "Failed to enter New Password");
		}
	}

	public void reEnterNewPassword(String newPassword) {
		try {
			Utility.simpleWait(5000);
			//reEnterNewPasswordField.click();//commented on 07-07-2020
			reEnterNewPasswordField.clear();
			reEnterNewPasswordField.sendKeys(newPassword);
			Log.addMessage("New Password re-entered");
		}catch(Exception e) {
			Log.addMessage("Failed to re-enter New password");
			Assert.assertTrue(false, "Failed to re-enter New Password");
		}
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void clickSubmitButton() {
		try {
			Utility.simpleWait(5000);
			submitButton.click();
			Log.addMessage("Clicked Submit Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Submit Button");
			Assert.assertTrue(false, "Failed to click Submit Button");
		}
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void clickBackButton() {
		try {
			Utility.simpleWait(5000);
			backButton.click();
			Log.addMessage("Clicked Back Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Back Button");
			Assert.assertTrue(false, "Failed to click Back Button");
		}
	}
	
	public void clickOkButton() {
		try {
			Utility.simpleWait(5000);
			System.out.println("first Ok");
			okButton.click();
			Log.addMessage("Clicked ok Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click ok Button");
			Assert.assertTrue(false, "Failed to click ok Button");
		}
	}
	
	/** 
	* Method Name: updatePassword(), 
	* This function is used to update Password in Edit field of  EditPassword Page
	*/
		
	public void valPassword(String oldPwd,String nwPwd, String reNewPwd, String titleMsg, String errMessage, String iTitle, String iMessage) {
		try {		
			//Utility.simpleWait(5000);//commented on 8th Aug for regression
			//System.out.println("in update pwd");
			enterOldPassword(oldPwd);
			enterNewPassword(nwPwd);
			reEnterNewPassword(reNewPwd);
			clickSubmitButton();			
			Utility.simpleWait(2000);	
			if(errMessage!="") {
				if(okButton.isDisplayed()) {
					System.out.println("in confirmVerificationButtonnP="+nwPwd+",oP="+oldPwd+",RP="+reNewPwd);
					if(device.equals("iOS")) {
						if(iTitle!="") {
							actTitle=alertTitle.getText();
							actMessage=confirmMessage.getText();
						}else {
							actMessage=alertTitle.getText();	
						}
					}else {
						if(titleMsg!="") {
							actTitle=alertTitle.getText();
							actMessage=confirmMessage.getText();
						}else {
							actMessage=confirmMessage.getText();
						}
					}
					System.out.println("mainMessage="+actMessage);
					if(device.equals("iOS")) {
						setErrMsg(iMessage, actMessage, iTitle, actTitle);
					}else {
						setErrMsg(errMessage, actMessage, titleMsg, actTitle);
					}
					//Utility.simpleWait(2000);//commented for regression on 8th Aug 2020
				}
			}else {
				okButton.click();
			}
			Utility.simpleWait(2000);
			Log.addMessage("Password Updated and directed to AccountSettings page");
		}catch(Exception e) {
			Log.addMessage("Password Not Updated");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Password Not Updated");
		}
	}
	
	public void setErrMsg(String exRes, String mnMsg, String ttlMsg, String actTtl) {
		try {
			System.out.println("in errmsg");
			if(exRes!="") {
				System.out.println("in errmsg2");
				
				if(okButton.isDisplayed()) {
					System.out.println("in confirmVerificationButton");
					okButton.click();
					
					actualRes = mnMsg;
					//System.out.println("in actualRes="+confirmMessage.getText());
					if(ttlMsg!="") {
						actTitle = actTtl;
						System.out.println("actTitle---="+actTitle+", expttl="+ttlMsg);
						Assert.assertEquals(actTitle, ttlMsg,"Please check the title validation message.");
					}
				}
				
				System.out.println("actRes---="+actualRes);
				System.out.println("expRes---="+exRes);
				Assert.assertEquals(actualRes, exRes,"Please check the validation message.");
			}
		}catch(Exception e) {
			System.out.println("catch errmssg");
			e.printStackTrace();
			Assert.assertEquals(false, "Expected message is null.");
		}
	}
	
	public void verifyUIPassword() {
		try {
			System.out.println("in verify");
			Utility.waitForElementToBeVisible(oldPasswordField);
			Log.addMessage("Old password field is displayed");
			Utility.waitForElementToBeVisible(newPasswordField);
			Log.addMessage("Password field is displayed");
			Utility.waitForElementToBeVisible(reEnterNewPasswordField);
			Log.addMessage("Re-enter password field is displayed");
			Utility.waitForElementToBeVisible(submitButton);
			Log.addMessage("Submit button is displayed");
			Utility.waitForElementToBeVisible(backButton);
			Log.addMessage("Back button is displayed");
			/*Utility.waitForElementToBeVisible(backButton);
			Log.addMessage("Info button is displayed");*/
			Assert.assertTrue(true,"All elements displayed in enter password page");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to display all elements in enter password page");
			Assert.assertTrue(false, "Failed to display all elements in enter password page");
		}
	}
	//added on 07-07-2020
	/** 
	* Method Name: enterEmailCodeDoneKey(), 
	* This function is used to enter done key in keyboard from the MFA Page
	*/
		
	public void enterOldPasswordNextKey() {
		try {
			Utility.waitForElementToBeVisible(oldPasswordField);
			oldPasswordField.click();
			oldPasswordField.clear();
			oldPasswordField.sendKeys("ab");
			Log.addMessage("Phone verification code entered");
		
			if(device.equals("iOS")) {
				nextKeyboard.click();
			}else {
				JavascriptExecutor js = appiumDriver;
				Map<String, Object> params = new HashMap<>();
				params.put("action", "Next");
				params.put("element", oldPasswordField);
				js.executeScript("mobile: performEditorAction", params);
			}
			
			Log.addMessage("Clicked Next Button in keyboard");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click next button in keyboard");
			Assert.assertTrue(false, "Failed to click next button in keyboard");
		}
	}
	
	/** 
	* Method Name: enterEmailCodeDoneKey(), 
	* This function is used to enter done key in keyboard from the MFA Page
	*/
		
	public void enterNewPasswordNextKey() {
		try {
			Utility.waitForElementToBeVisible(newPasswordField);
			newPasswordField.click();
			newPasswordField.clear();
			newPasswordField.sendKeys("ab");
			Log.addMessage("Phone verification code entered");
			
			if(device.equals("iOS")) {
				nextKeyboard.click();
			}else {
				JavascriptExecutor js = appiumDriver;
				Map<String, Object> params = new HashMap<>();
				params.put("action", "Next");
				params.put("element", newPasswordField);
				js.executeScript("mobile: performEditorAction", params);
			}
			
			Log.addMessage("Clicked Next Button in keyboard");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click next button in keyboard");
			Assert.assertTrue(false, "Failed to click next button in keyboard");
		}
	}

	/** 
	* Method Name: enterEmailCodeDoneKey(), 
	* This function is used to enter done key in keyboard from the MFA Page
	*/
		
	public void reenterNewPasswordDoneKey() {
		try {
			Utility.waitForElementToBeVisible(reEnterNewPasswordField);
			reEnterNewPasswordField.click();
			reEnterNewPasswordField.clear();
			reEnterNewPasswordField.sendKeys("ab");
			Log.addMessage("password re-entered");
			if(device.equals("iOS")) {
				doneKeyboard.click();
			}else {
				Map<String, Object> params = new HashMap<>();
				Log.addMessage("Phone verification code entered");
				JavascriptExecutor js = appiumDriver;
				params.put("action", "Done");
				params.put("element", reEnterNewPasswordField);
				js.executeScript("mobile: performEditorAction", params);
			}
			
			Log.addMessage("Clicked Next Button in keyboard");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click next button in keyboard");
			Assert.assertTrue(false, "Failed to click next button in keyboard");
		}
	}
}