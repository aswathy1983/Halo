package pages.app;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class LoginPage extends Settings {
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
	@AndroidFindAll({
	@AndroidBy (id = "com.kwikset.blewifi.dev:id/tv_email"),
	@AndroidBy (id = "com.kwikset.blewifi:id/tv_email"),
	@AndroidBy (id = "com.spectrum.giga:id/tv_email"),
	@AndroidBy (id = "com.weiser.blewifi:id/tv_email"),
	@AndroidBy (id = "com.weiser.blewifi.dev:id/tv_email")
	})
	@CacheLookup
	private MobileElement emailTextField;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField")
	@AndroidFindAll({
	@AndroidBy (id = "com.kwikset.blewifi.dev:id/tv_password"),
	@AndroidBy (id = "com.kwikset.blewifi:id/tv_password"),
	@AndroidBy (id = "com.spectrum.giga:id/tv_password"),
	@AndroidBy (id = "com.weiser.blewifi:id/tv_password"),
	@AndroidBy (id = "com.weiser.blewifi.dev:id/tv_password")
	})
	@CacheLookup
	private MobileElement passwordTextField;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='fingerID']")
	@AndroidFindAll({
	@AndroidBy (id = "com.kwikset.blewifi.dev:id/biometric_login_icon"),
	@AndroidBy (id = "com.kwikset.blewifi:id/biometric_login_icon"),
	@AndroidBy (id = "com.spectrum.giga:id/biometric_login_icon"),
	@AndroidBy (id = "com.weiser.blewifi:id/biometric_login_icon"),
	@AndroidBy (id = "com.weiser.blewifi.dev:id/biometric_login_icon")
	})
	@CacheLookup
	private MobileElement bioButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Log In']")
	@AndroidFindAll({
	@AndroidBy (id = "com.kwikset.blewifi.dev:id/tv_login"),
	@AndroidBy (id = "com.kwikset.blewifi:id/tv_login"),
	@AndroidBy (id = "com.spectrum.giga:id/tv_login"),
	@AndroidBy (id = "com.weiser.blewifi:id/tv_login"),
	@AndroidBy (id = "com.weiser.blewifi.dev:id/tv_login")
	})
	@CacheLookup
	private MobileElement logInButton;
	
	@iOSXCUITFindBy(id = "Forgot Password")
	@AndroidFindAll({
	@AndroidBy (id = "com.kwikset.blewifi.dev:id/tv_forgot_password"),
	@AndroidBy (id = "com.kwikset.blewifi:id/tv_forgot_password"),
	@AndroidBy (id = "com.spectrum.giga:id/tv_forgot_password"),
	@AndroidBy (id = "com.weiser.blewifi:id/tv_forgot_password"),
	@AndroidBy (id = "com.weiser.blewifi.dev:id/tv_forgot_password")
	})
	@CacheLookup
	private MobileElement forgotPasswordButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Create An Account']")
	@AndroidFindAll({
	@AndroidBy (id = "com.kwikset.blewifi.dev:id/btn_create"),
	@AndroidBy (id = "com.kwikset.blewifi:id/btn_create"),
	@AndroidBy (id = "com.spectrum.giga:id/btn_create"),
	@AndroidBy (id = "com.weiser.blewifi:id/btn_create"),
	@AndroidBy (id = "com.weiser.blewifi.dev:id/btn_create")
	})
	@CacheLookup
	private MobileElement createAnAccountButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Ok']")
	@AndroidFindBy(id = "android:id/button1")
	@CacheLookup
	private MobileElement OkButton;
	
	//added on 29-06-2020
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Back']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_back"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_back"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_back"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_back"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/tv_back")
	})
	@CacheLookup
	private MobileElement backButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[2]")
	@AndroidFindBy(id="android:id/message")
	private MobileElement confirmMessage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[1]")
	@AndroidFindBy(id="android:id/alertTitle")
	private MobileElement alertTitle;
	
	@iOSXCUITFindBy(id = "Ok")
	@AndroidFindBy(id = "android:id/button2")//added on 02-07-2020
	@CacheLookup
	private MobileElement cancelButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeMenuItem[@name='Select All']")
	@CacheLookup
	private MobileElement selectAllMenu;
	
	By loginBtn =By.xpath("//XCUIElementTypeButton[@name='Log In']");
	By loginBtnAn =By.xpath("//android.widget.Button[@text='Log In']");
	
	String actTitle, actMessage, actualRes ="";

	//Constructor
	@SuppressWarnings("static-access")
	public LoginPage(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
		
		
	/** 
	* Method Name: enterEmail(), 
	* This function is used to enter email address in Email Text field in Login Page
	*/
		
	public void enterEmail(String email) {
		try {
			Utility.waitForElementToBeVisible(emailTextField);
			if(device.equals("iOS")) {
				if(!(emailTextField.getText()).equals("Email")) {
					emailTextField.click();
					emailTextField.click();
					Thread.sleep(2000);
					selectAllMenu.click();
					emailTextField.clear();
				}
			}else {
				emailTextField.click();
				emailTextField.clear();
			}
			emailTextField.sendKeys(email);
			Log.addMessage("Email Address entered");
		}catch(Exception e) {
			Log.addMessage("Email Text field is not visible");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Email Text field is not visible");
		}
	}
	
	/** 
	* Method Name: enterPassword(), 
	* This function is used to enter password in Password Text field in Login Page
	*/
		
	public void enterPassword(String password) {
		try {
			Utility.waitForElementToBeVisible(passwordTextField);
			if(device.equals("iOS")) {
				//System.out.println("email="+passwordTextField.getText());
				if(!(passwordTextField.getText()).equals("Password")) {
					//System.out.println("in email");
					//passwordTextField.click();
					passwordTextField.click();
					passwordTextField.click();
					Thread.sleep(1000);
					selectAllMenu.click();
					passwordTextField.clear();
				}
			}else {
				passwordTextField.clear();
			}
			passwordTextField.sendKeys(password);
			Log.addMessage("Password entered");
		}catch(Exception e) {
			Log.addMessage("Password Text field is not visible");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Password Text field is not visible");
		}
	}
	
	/** 
	* Method Name: checkPwdHidden(), 
	* This function is used to verify if password text field is hidden
	*/
		
	public void checkPwdHidden() {
		try {
			Utility.waitForElementToBeVisible(passwordTextField);
			if((passwordTextField.getAttribute("type")).equals("password")) {
				Assert.assertTrue(true, "Password text field is hidden");
				Log.addMessage("Password text field is hidden");
			}else {
				Assert.assertTrue(false, "Password text field is not hidden");
				Log.addMessage("Password text field is not hidden");
			}
		}catch(Exception e) {
			Log.addMessage("Password Text field is not visible");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Password Text field is not visible");
		}
	}
	
	/** 
	* Method Name: clickLoginButton(), 
	* This function is used to click Login button
	*/
		
	public void clickLoginButton() {
		try {
			Utility.waitForElementToBeVisible(logInButton);
			Utility.waitForElementToBeClickable(logInButton);
			logInButton.click();
			Log.addMessage("Clicked Login button");
		}catch(Exception e) {
			Log.addMessage("Login button is not visible");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Login button is not visible");
		}
	}
	
	/** 
	* Method Name: checkLoginButton(), 
	* This function is used to verify Login button
	*/
		
	public void checkLoginButton() {
		try {
			if(device.equals("iOS")) {
				Utility.waitForElementPresent(loginBtn, appiumDriver);
			}else {
				Utility.waitForElementPresent(loginBtnAn, appiumDriver);
			}
			Log.addMessage("Logged out of the account");
		}catch(Exception e) {
			Log.addMessage("Failed to logout");
			System.out.println(e.getMessage().toString());
			//Assert.assertTrue(false, "Login button is not visible");
		}
	}
	
	/** 
	* Method Name: verifyLogout(), 
	* This function is used to verify if account is logged out 
	*/
		
	public boolean verifyLogout() {
		try {
			if(device.equals("iOS")) {
				Utility.waitForElementPresent(loginBtn, appiumDriver);
			}else {
				Utility.waitForElementPresent(loginBtnAn, appiumDriver);
			}
			Log.addMessage("Logged out of the account");
			return true;
		}catch(Exception e) {
			Log.addMessage("Failed to logout");
			System.out.println(e.getMessage().toString());
			return false;
		}
	}
	
	/** 
	* Method Name: login(), 
	* This function is used to enter email address in Email Text field in Login Page
	*/
		
	public void login(String email, String password) {
		try {
			enterEmail(email);
			enterPassword(password);
			clickLoginButton();
			Log.addMessage("User logged in and directed to MFA page");
		}catch(Exception e) {
			Log.addMessage("User credentials was not accepted");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "User credentials was not accepted");
		}
	}
	
	/** 
	* Method Name: clickLoginButton(), 
	* This function is used to click Login button
	*/
		
	public void clickCreateAnAccountButton() {
		try {
			Utility.waitForElementToBeVisible(createAnAccountButton);
			Utility.waitForElementToBeClickable(createAnAccountButton);
			createAnAccountButton.click();
			Log.addMessage("Clicked Create An Account button");
		}catch(Exception e) {
			Log.addMessage("Create An Account button button is not visible");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Create An Account button is not visible");
		}
	}
	
	public void clickForgotPasswordButton() {
		try {
			Utility.waitForElementToBeVisible(forgotPasswordButton);
			Utility.waitForElementToBeClickable(forgotPasswordButton);
			forgotPasswordButton.click();
			Log.addMessage("Clicked Forgot Password button");
		}catch(Exception e) {
			Log.addMessage("Forgot Password button  is not visible");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Forgot Password button is not visible");
		}
	}
	/** 
	* Method Name: valLogin(), 
	* This function is used to enter email address in Email Text field in Login Page
	*/
		
	public void valLogin(String email, String password, String valMessage, String titleMsg,String iMessage) {
		try {
			enterEmail(email);
			enterPassword(password);
			clickLoginButton();
			System.out.println("updated");
			Utility.simpleWait(5000);
			if(valMessage!="") {
				Utility.simpleWait(2000);
				if(OkButton.isDisplayed()) {
					
					if(titleMsg!="") {
						actTitle=alertTitle.getText();
						actMessage=confirmMessage.getText();
					}else {
						if(device.equals("iOS")) {
							actMessage=alertTitle.getText();
						}else {
							actMessage=confirmMessage.getText();
						}
					}
					System.out.println("mainMessage="+actMessage);
					if(device.contentEquals("iOS")) {
						setErrMsg(iMessage,actMessage,titleMsg, actTitle);	
					}else {
						setErrMsg(valMessage,actMessage,titleMsg, actTitle);	
					}
					System.out.println("after message");
					Utility.simpleWait(5000);
				}
			}
			Log.addMessage("User logged in and directed to MFA page");
		}catch(Exception e) {
			Log.addMessage("User credentials was not accepted");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "User credentials are not accepted");
		}
	}
	
	public void setErrMsg(String exRes, String mnMsg, String ttlMsg, String actTtl) {
		try {
			if(exRes!="") {
				if(OkButton.isDisplayed()) {
					OkButton.click();
					System.out.println("in confirmVerificationButton");
					actualRes = mnMsg;
					//System.out.println("in actualRes="+confirmMessage.getText());
					if(ttlMsg!="") {
						actTitle = actTtl;
						if(actTitle.equals(ttlMsg)) {
							System.out.println("title true");
						}
						System.out.println("actTitle---="+actTitle+", expttl="+ttlMsg);
						Assert.assertEquals(actTitle, ttlMsg,"Please check the title validation message.");
						System.out.println("assert true1");
					}
				}
				System.out.println("actRes---="+actualRes);
				System.out.println("expRes---="+exRes);
				Assert.assertEquals(actualRes, exRes,"Please check the validation message.");
			}
	    }catch(Exception e) {
			e.printStackTrace();
			Assert.assertEquals(false, "Expected message is null.");
		}
	}
	
	//added on 02-07-2020
	public void clickCancelButton() {
		try {
			Thread.sleep(6000);
			cancelButton.click();
			System.out.println("in cancel");
			Log.addMessage("Clicked Cancel Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Cancel button ");
			Assert.assertTrue(false, "Failed to click Cancel button");
		}
	}
	
	//added on 14-07-2020
	/** 
	* Method Name: clickOKButton(), 
	* This function is used to select Back option from the Name Page
	*/
		
	  public void clickOKButton() {
			try {
				Utility.waitForElementToBeVisible(OkButton);
				Utility.waitForElementToBeClickable(OkButton);
				OkButton.click();
				Log.addMessage("Clicked OK Button");
			}catch(Exception e) {
				Log.addMessage(e.getMessage().toString());
				Log.addMessage("Failed to click OK button");
				Assert.assertTrue(false, "Failed to click OK button");
			}
	}
	
	/** 
	* Method Name: clickBioButton(), 
	* This function is used to select Biometric option from the Login Page
	*/
			
	  public void clickBioButton() {
			try {
				Utility.waitForElementToBeVisible(bioButton);
				Utility.waitForElementToBeClickable(bioButton);
				bioButton.click();
				if(device.equals("iOS")) {
					bioButton.click();
				}
				Log.addMessage("Clicked Biometric Button");
			}catch(Exception e) {
				Log.addMessage(e.getMessage().toString());
				Log.addMessage("Failed to click Biometric button");
				Assert.assertTrue(false, "Failed to click Biometric button");
			}
		}
		
}
