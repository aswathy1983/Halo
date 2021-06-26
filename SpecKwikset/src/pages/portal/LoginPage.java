package pages.portal;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.Settings;
import utility.Log;
import utility.PropertyUtility;
import utility.Utility;

public class LoginPage extends Settings{
	
	@FindBy(className="logo")
	WebElement KwiksetLogo;
	
	@FindBy(id="loginEmail")
	WebElement emailTextField;
	
	@FindBy(id="loginPassword")
	WebElement passwordTextField;
	
	@FindBy(id="loginSubmit")
	WebElement loginButton;
	
	@FindBy(linkText="Forgot Password")
	WebElement forgotPassword;
	
	@FindBy(linkText="here")
	WebElement createAccount;
	
	@FindBy(xpath="//select[@class='select']")
	WebElement languageSelect;
	
	@FindBy(linkText="Terms of Use")
	WebElement termsOfUse;
	
	@FindBy(linkText="Privacy Policy")
	WebElement privacyPolicy;
	
	@FindBy(xpath="//div[@class='form-group has-feedback']/div[1]/p")
	WebElement emailValidationMessage;
	
	@FindBy(xpath="//div[@class='form-group has-feedback']/div[2]/p")
	WebElement passwordValidationMessage;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible fade in']")
	WebElement incorrectUserAlertMessage;
	
	@FindBy(xpath="(//div[@class='alert alert-danger alert-dismissible fade in']/a)[1]")
	WebElement closeButton;
	
	@FindBy(xpath="(//button[@aria-label='Close Banner'])[2]")
	WebElement closeBanner;
	
	@FindBy(xpath="//div[@class='modal-footer']/button")
	WebElement OKbutton;
	
	//updated on 1st August
	//@FindBy(xpath="//h3[text()='Login into your Account']")
	@FindBy(xpath="//h3[text()='Log in to your account']")
	WebElement heading;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible fade in']")
	WebElement validationMsg;
	
	
	@SuppressWarnings("static-access")
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	/**
	 * Method Name: verifyPageTitle() Description: This function will be called
	 * to verify title of the page
	 */

	public static void verifyPageTitle(String expectedTitle) {
		try {
			Assert.assertEquals(driver.getTitle(), expectedTitle, "Page title matches");
			Log.addMessage("Verified the page title");
		} catch (Exception e) {
			Log.addMessage("Page title verification failed");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Page title not verified");
		}
	}


	/**
	 * Method Name: verifyLogo() Description: This function will be called
	 * to verify Kwikset Logo 
	 */
	

	public void verifyLogo() {
		try {
			Utility.waitForElementToBeVisible(KwiksetLogo);
			Assert.assertTrue(KwiksetLogo.isDisplayed(), "Kwikset Logo is not visible");
			Log.addMessage("Kwikset Logo is visible");
		}catch(Exception e) {
			Log.addMessage("Kwikset logo is not visible");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to display Kwikset logo");
		}
	}
	

	/**
	 * Method Name: enterLoginDetails() Description: This function will be called
	 * to login to the Consumer Portal
	 */

	public void enterLoginDetails(String email, String password) {
		try {
			Utility.waitForElementToBeVisible(emailTextField);
			Assert.assertTrue(emailTextField.isDisplayed(), "Email Text field is visible");
			emailTextField.clear();
			emailTextField.sendKeys(email);
			Log.addMessage("Email address entered");
			Utility.waitForElementToBeVisible(passwordTextField);
			Assert.assertTrue(passwordTextField.isDisplayed(), "Password Text field is visible");
			passwordTextField.clear();
			passwordTextField.sendKeys(password);
			heading.click();
			Log.addMessage("Password entered");
			Utility.waitForElementToBeVisible(loginButton);
			Utility.waitForElementToBeClickable(loginButton);
			Assert.assertTrue(loginButton.isDisplayed(), "Login Button is visible");
			Utility.clickAction(driver, loginButton);
			Log.addMessage("Login button clicked");
		}
		catch(Exception e) {
			Log.addMessage("User not logged in");
			Log.addMessage(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to login");
		}
	}
	

	/**
	 * Method Name: clickForgotPassword() Description: This function will be called
	 * to click Forgot password link
	 */

	public void clickForgotPassword() {
		try {
			Utility.waitForElementToBeVisible(forgotPassword);
			Utility.waitForElementToBeClickable(forgotPassword);
			Assert.assertTrue(forgotPassword.isDisplayed(), "Forgot Password link is visible");
			forgotPassword.click();
			Log.addMessage("Forgot Password link clicked");
		}
		catch(Exception e) {
			Log.addMessage("Failed to click Forgot Password link");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click Forgot Password link");
		}
	}

	/**
	 * Method Name: checkCloseBanner() Description: This function will be called
	 * to check for close button present in the Cookies Accept Banner
	 */

	public Boolean checkCloseBanner() {
		try {
			System.out.println("click");
			Utility.waitForElementToBeVisible(closeBanner);
			Utility.waitForElementToBeClickable(closeBanner);
			Log.addMessage("Closed the pop up");
			return true;
		}
		catch(Exception e) {
			Log.addMessage("Failed to click the pop up");
			System.out.println(e.getMessage().toString());
			return false;
		}
	}
	
	/**
	 * Method Name: closeBanner() Description: This function will be called
	 * to close the Cookies Accept Banner
	 */

	public void clickCloseBanner() {
		try {
			System.out.println("click");
			Utility.waitForElementToBeVisible(closeBanner);
			Utility.waitForElementToBeClickable(closeBanner);
			System.out.println("clicked");
			Assert.assertTrue(closeBanner.isDisplayed(), "Close button is visible");
			closeBanner.click();
			Log.addMessage("Closed the pop up");
		}
		catch(Exception e) {
			Log.addMessage("Failed to click the pop up");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click the pop up");
		}
	}
	
	/**
	 * Method Name: clickCreateAccount() Description: This function will be called
	 * to click Create Account Link
	 */

	public void clickCreateAccount() {
		try {
			System.out.println("click");
			Utility.waitForElementToBeVisible(createAccount);
			Utility.waitForElementToBeClickable(createAccount);
			System.out.println("clicked");
			Assert.assertTrue(createAccount.isDisplayed(), "Create An Account Link is visible");
			createAccount.click();
			Log.addMessage("Create An Account link clicked");
		}
		catch(Exception e) {
			Log.addMessage("Failed to click Create Account link");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click Create Account link");
		}
	}
	

	/**
	 * Method Name: languageCheck() Description: This function will be called
	 * to check languages
	 */
	
	public void languageCheck() {
		try {
			Select oSelect =new Select(languageSelect);
			String[] languages= {"English", "French","Spanish"};
			List <WebElement> elementCount = oSelect.getOptions();
			int iSize = elementCount.size(); 
			for(int i =0; i<iSize ; i++){
				String sValue = elementCount.get(i).getText();
				Assert.assertEquals(sValue,languages[i] );
				}
		}
			catch(Exception e) {
				Log.addMessage("Language options are not available");
				Assert.assertTrue(false);
			}
			
		}
	

	/**
	 * Method Name: clickTermsOfUse() Description: This function will be called
	 * to click Terms Of Use link
	 */
	

	public void clickTermsOfUse() {
		try {
			Utility.waitForElementToBeVisible(termsOfUse);
			Utility.waitForElementToBeClickable(termsOfUse);
			Assert.assertTrue(termsOfUse.isDisplayed(), "Terms of Use link is visible");
			termsOfUse.click();
			Log.addMessage("Terms of Use link clicked");
		}
		catch(Exception e) {
			Log.addMessage("Failed to click Terms of Use link");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click Terms of Use link");
		}
	}

	/**
	 * Method Name: clickPrivacyPolicy() Description: This function will be called
	 * to click Privacy policy link
	 */
	

	public void clickPrivacyPolicy() {
		try {
			Utility.waitForElementToBeVisible(privacyPolicy);
			Utility.waitForElementToBeClickable(privacyPolicy);
			privacyPolicy.click();
			Log.addMessage("Privacy Policylink clicked");
		}
		catch(Exception e) {
			Log.addMessage("Unable to click Privacy Policy link");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click Privacy Policy link");
		}
	}
	

	/**
	 * Method Name: checkRedirectionOfLogo() Description: This function will be called
	 * to check redirection to home page on clicking the Kwikset Logo
	 */
	

	public void checkRedirectionOfLogo() {
		try {
			Utility.waitForElementToBeVisible(KwiksetLogo);
			Utility.waitForElementToBeClickable(KwiksetLogo);
			KwiksetLogo.click();
			Assert.assertTrue(driver.getCurrentUrl().equals(PropertyUtility.getProperty("prodUrl")), "Redirection to home page is successful");
		}
		catch(Exception e) {
			Log.addMessage("Redirection is not possible from the Kwikset Logo");
			System.out.println(e.getMessage().toString());
			Assert.assertFalse(true, "Redirection is not possible from the Kwikset Logo");
		}
	}
	

	/**
	 * Method Name: validationMessageCheck() Description: This function will be called
	 * to check validation messages
	 */

	public void validationMessageCheck(String emailValidation, String passwordValidation) {
		try {
			Utility.waitForElementToBeVisible(emailTextField);
			Utility.waitForElementToBeClickable(emailTextField);
			emailTextField.click();
			Utility.waitForElementToBeVisible(heading);
			Utility.waitForElementToBeClickable(heading);
			heading.click();
			Utility.waitForElementToBeVisible(emailValidationMessage);
			Assert.assertTrue(emailValidationMessage.isDisplayed(), "Validation Message for Email is displayed");
			Assert.assertTrue(emailValidationMessage.getText().equalsIgnoreCase(emailValidation), "Validation message is proper");
			Utility.waitForElementToBeVisible(passwordTextField);
			Utility.waitForElementToBeClickable(passwordTextField);
			passwordTextField.click();
			heading.click();
			Utility.waitForElementToBeVisible(passwordValidationMessage);
			Assert.assertTrue(passwordValidationMessage.isDisplayed(), "Validation Message for Password is displayed");
			Assert.assertTrue(passwordValidationMessage.getText().equalsIgnoreCase(passwordValidation), "Validation message is proper");
		}
		catch(Exception e) {
			Log.addMessage("Validation messages are not proper for text fields");
			Log.addMessage(e.getMessage().toString());
			Assert.assertFalse(true, "Validation messages are not proper for text fields");
		}
	}
	

	/**
	 * Method Name: incorrectUserAlertMessageCheck() Description: This function will be called
	 * to check incorrect user alert message
	 */
	

	public void incorrectUserAlertMessageCheck() {
		try {	
			Utility.waitForElementToBeVisible(incorrectUserAlertMessage);
			Assert.assertTrue(incorrectUserAlertMessage.isDisplayed(), "Validation message displayed for user not exists");
			Log.addMessage("User not exists");
		}catch(Exception e) {
			Log.addMessage("Failed to display validation message for user not exists");
			System.out.println(e.getMessage().toString());
			Assert.assertFalse(true, "Failed to display validation message for user not exists");
		}
	}

	/**
	 * Method Name: invalidLoginCheck() Description: This function will be called
	 * to check login with invalid credentials
	 */
	

	public void invalidLoginCheck(String email, String password, String validationMsg) {
		try {	
			Utility.simpleWait(6000);
			userLogin(email,password);
			Utility.waitForElementToBeVisible(incorrectUserAlertMessage);
			System.out.println("Validation message is: "+incorrectUserAlertMessage.getText());
			Assert.assertTrue(incorrectUserAlertMessage.isDisplayed(), "Validation message displayed for user not exists");
			Log.addMessage("User not exists");
		}catch(Exception e) {
			Log.addMessage("Failed to display validation message for user not exists");
			System.out.println(e.getMessage().toString());
			Assert.assertFalse(true, "Failed to display validation message for user not exists");
		}
	}

	/**
	 * Method Name: clickOKbutton() Description: This function will be called
	 * to click Ok button
	 */
	

	public void clickOKbutton() {
		try {
			Utility.waitForElementToBeVisible(OKbutton);
			Utility.waitForElementToBeClickable(OKbutton);
			Assert.assertTrue(OKbutton.isDisplayed(), "OK button is visible");
			OKbutton.click();
			Log.addMessage("OK button clicked");
		}catch(Exception e) {
			Log.addMessage("Failed to click OK button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click OK Button");
		}
	}
	//added on 28-07-2020
	/**
	 * Method Name: verifyUILogin() Description: This function will be called
	 * to login to the Consumer Portal
	 */

	public void verifyUILogin() {
		try {
			Utility.waitForElementToBeVisible(emailTextField);
			Assert.assertTrue(emailTextField.isDisplayed(), "Email Text field is visible");
			System.out.println("one");
			Log.addMessage("Email Text field is visibled");
			Utility.waitForElementToBeVisible(passwordTextField);
			Assert.assertTrue(passwordTextField.isDisplayed(), "Password Text field is visible");
			System.out.println("2");
			Log.addMessage("Password Text field is visible");
			Utility.waitForElementToBeVisible(KwiksetLogo);
			Assert.assertTrue(KwiksetLogo.isDisplayed(), "Kwikset logo is visible");
			System.out.println("3");
			Log.addMessage("Kwikset logo is visible");
			Utility.waitForElementToBeVisible(loginButton);
			Assert.assertTrue(loginButton.isDisplayed(), "Login Button is visible");
			System.out.println("4");
			Log.addMessage("Login Button is visible");
			Utility.waitForElementToBeVisible(forgotPassword);
			Utility.waitForElementToBeClickable(forgotPassword);
			Assert.assertTrue(forgotPassword.isDisplayed(), "Forgot password link is visible");
			System.out.println("5");
			Log.addMessage("Forgot password link is visible");
			Utility.waitForElementToBeVisible(createAccount);
			Utility.waitForElementToBeClickable(createAccount);
			Assert.assertTrue(createAccount.isDisplayed(), "Create account link is visible");
			System.out.println("6");
			Log.addMessage("Create account link is visible");
		}
		catch(Exception e) {
			Log.addMessage("User not logged in");
			Log.addMessage(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to login");
		}
	}
	
	/**
	 * Method Name: invalidEmailCheck() Description: This function will be called
	 * to check email with invalid entry
	 */
	

	public void invalidEmailCheck(String validationMsg) {
		try {	
			Utility.simpleWait(6000);
			Utility.waitForElementToBeVisible(emailValidationMessage);
			System.out.println("Validation message is: "+emailValidationMessage.getText());
			Assert.assertTrue(emailValidationMessage.isDisplayed(), "Validation message displayed for invalid email");
			Assert.assertEquals(emailValidationMessage.getText(), validationMsg, "Incorrect validation");
			Log.addMessage("Invalid Email");
		}catch(Exception e) {
			Log.addMessage("Failed to display validation message for email field");
			System.out.println(e.getMessage().toString());
			Assert.assertFalse(true, "Failed to display validation message for email field");
		}
	}
	
	/**
	 * Method Name: invalidPasswordCheck() Description: This function will be called
	 * to check password with invalid entry
	*/
	public void invalidPasswordCheck(String validationMsg) {
		try {	
			Utility.simpleWait(6000);
			Utility.waitForElementToBeVisible(passwordValidationMessage);
			System.out.println("Validation message is: "+passwordValidationMessage.getText());
			Assert.assertTrue(passwordValidationMessage.isDisplayed(), "Validation message displayed for password does not exists");
			Assert.assertEquals(passwordValidationMessage.getText(), validationMsg, "Incorrect password validation");
			Log.addMessage("Invalid password");
		}catch(Exception e) {
			Log.addMessage("Failed to display validation message for password field");
			System.out.println(e.getMessage().toString());
			Assert.assertFalse(true, "Failed to display validation message for password field");
		}
	}
	
	/**
	 * Method Name: checkLoginButton() Description: This function will be called
	 * to click login button
	 */

	public void checkLoginButton() {
		try {
			Utility.waitForElementToBeVisible(loginButton);
			Assert.assertTrue(!(loginButton.isEnabled()), "Failed to disable login button for invalid selection");
			Log.addMessage("Login button disabled for invalid selection");
		}
		catch(Exception e) {
			Log.addMessage("Failed to disable login button for invalid selection");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(true, "Failed to disable login button for invalid selection");
		}
	}
	
	/**
	 * Method Name: userLogin() Description: This function will be called
	 * to login to the Consumer Portal
	 */

	public void userLogin(String email, String password) {
		try {
			Utility.waitForElementToBeVisible(emailTextField);
			Assert.assertTrue(emailTextField.isDisplayed(), "Email Text field is visible");
			emailTextField.clear();
			emailTextField.sendKeys(email);
			Log.addMessage("Email address entered");
			Utility.waitForElementToBeVisible(passwordTextField);
			Assert.assertTrue(passwordTextField.isDisplayed(), "Password Text field is visible");
			passwordTextField.clear();
			passwordTextField.sendKeys(password);
			heading.click();
			Log.addMessage("Password entered");
		}
		catch(Exception e) {
			Log.addMessage("User not logged in");
			Log.addMessage(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to login");
		}
	}
	/**
	 * Method Name: clickForgotPassword() Description: This function will be called
	 * to click Forgot password link
	 */

	 public void clickLoginButton() {
		try {
			Utility.waitForElementToBeVisible(loginButton);
			Utility.waitForElementToBeClickable(loginButton);
			Assert.assertTrue(loginButton.isDisplayed(), "Login Button is visible");
			//Utility.clickAction(driver, loginButton);
			loginButton.click();
			Log.addMessage("Login button clicked");
		}
		catch(Exception e) {
			Log.addMessage("Failed to click Forgot Password link");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click Forgot Password link");
		}
	}
	 
	 /** 
		* Method Name: valLogin(), 
		* This function is used to validate Login Page
		*/
			
		public void valLogin(String email, String password, String valMessage, String titleMsg,String iMessage) {
			try {
				userLogin(email,password);
				if(iMessage.equals("")) {
					checkLoginButton();
				}else {
					clickLoginButton();
				}
				System.out.println("updated");
				Utility.simpleWait(5000);
				if(valMessage!="") {
					System.out.println("valMessage1="+valMessage);
					System.out.println("emailValidationMessage="+emailValidationMessage.getText());
					Assert.assertTrue(emailValidationMessage.getText().contains(valMessage),"Email validation is not proper");
				}
				if(titleMsg!="") {
					System.out.println("valMessage2="+titleMsg);
					System.out.println("passwordValidationMessage="+passwordValidationMessage.getText());
					Assert.assertTrue(passwordValidationMessage.getText().contains(titleMsg),"Password validation is not proper");
				}
				if(iMessage!="") {
					System.out.println("iMessage="+iMessage);
					System.out.println("incorrectUserAlertMessage="+incorrectUserAlertMessage.getText());
					Assert.assertTrue(incorrectUserAlertMessage.getText().contains(iMessage),"Login validation is not proper");
					System.out.println("out for close");
					closeButton.click();
				}
				Log.addMessage("Login validtion is proper");
			}catch(Exception e) {
				Log.addMessage("Login validtion is not proper");
				System.out.println(e.getMessage().toString());
				Assert.assertTrue(false, "Login validtion is not proper");
			}
		}


}

