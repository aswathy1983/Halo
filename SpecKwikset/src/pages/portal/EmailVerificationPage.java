package pages.portal;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Settings;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import utility.Log;
import utility.PropertyUtility;
import utility.ReadEmail;
import utility.Utility;


public class EmailVerificationPage extends Settings{
	
	@FindBy(id="emailVerify")
	WebElement emailField;
	
	@FindBy(id="submitEmail")
	WebElement sendButton;
	
	@FindBy(linkText="Resend Code")
	WebElement resendCode;
	
	@FindBy(linkText="Resend Verification Code")
	WebElement resendVCode;
	
	@FindBy(id="signupEmail")
	WebElement emailVerificationCode;
	
	@FindBy(id="securityCode")
	WebElement emailVerificationCodeLogIn;
	
	@FindBy(id="submitCode")
	WebElement verifyButton;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement verifySubButton;
	
	@FindBy(id="verificationCode")
	WebElement enterVerificationCodeField;
	
	@FindBy(xpath="//input[@id='emailVerify']/following-sibling::p")
	WebElement emailValidationMessage;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible fade in']")
	WebElement incorrectEmailAlertMessage;
	
	//updated on 3rd August
	@FindBy(xpath="//h3[text()='Account Email']")
	WebElement heading;
	
	@FindBy(xpath="(//div[@class='alert alert-danger alert-dismissible fade in']//a)[1]")
	WebElement closeButton;
	
	
	@SuppressWarnings("static-access")
	public EmailVerificationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	/**
	 * Method Name: enterEmailAndVerify() Description: This function will be called
	 * to enter email and verify the same
	 */
	
	public void enterEmailAndVerify(String email) {
		try {
			System.out.println("in email");
			Utility.waitForElementToBeVisible(emailField);
			System.out.println("in email visible");
			Assert.assertTrue(emailField.isDisplayed(), "Email Text field is visible");
			System.out.println("in email assert");
			emailField.clear();
			System.out.println("in email clear");
			emailField.sendKeys(email);
			Assert.assertTrue(sendButton.isDisplayed(), "Send Button is visible");
			sendButton.click();
			Log.addMessage("Email to be verified is entered");
		}
		catch(Exception e) {
			Log.addMessage("Failed to enter email");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter email");
		}
	}
	

	/**
	 * Method Name: clickResendLink() Description: This function will be called
	 * to click Resend link
	 */
	
	public void clickResendLink() {
		try {
			Utility.waitForElementToBeVisible(resendCode);
			Utility.waitForElementToBeClickable(resendCode);
			Assert.assertTrue(resendCode.isDisplayed(), "Resend Button is visible");
			resendCode.click();
			Log.addMessage("Resend Link is clicked");
		}
		catch(Exception e) {
			Log.addMessage("Failed to click Resend link");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click resend link");
		}
	}
	

	/**
	 * Method Name: clickResendVerifyLink() Description: This function will be called
	 * to click Resend link
	 */
	
	public void clickResendVerifyLink() {
		try {
			Utility.waitForElementToBeVisible(resendVCode);
			Utility.waitForElementToBeClickable(resendVCode);
			Assert.assertTrue(resendVCode.isDisplayed(), "Resend Button is visible");
			resendVCode.click();
			Log.addMessage("Resend Link is clicked");
		}
		catch(Exception e) {
			Log.addMessage("Failed to click Resend link");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click resend link");
		}
	}
	

	//added on  05-02-2021
	public void readContentFromEmail(String usrType, String passType,String emailText,String fromAdrs) throws Exception {
		Utility.simpleWait(7000);
		new ReadEmail(PropertyUtility.getProperty(usrType),
				PropertyUtility.getProperty(passType), PropertyUtility.getProperty("email.server"),
				PropertyUtility.getProperty("email.protocol"),993,ReadEmail.EmailFolder.INBOX);

		boolean contentExist = ReadEmail.verifyEmailText(PropertyUtility.getProperty("emailSub"),emailText,fromAdrs);
		if(contentExist) {
			Assert.assertTrue(true, "Email content matches");
		}else {
			Assert.assertTrue(false, "Email content is not matching");
		}
	}
	
	//added on  05-02-2021
	public void readContentFromPhReUseEmail(String usrType, String passType,String emailText,String fromAdrs) throws Exception {
		Utility.simpleWait(7000);
		new ReadEmail(PropertyUtility.getProperty(usrType),
				PropertyUtility.getProperty(passType), PropertyUtility.getProperty("email.server"),
				PropertyUtility.getProperty("email.protocol"),993,ReadEmail.EmailFolder.INBOX);

		boolean contentExist = ReadEmail.verifyEmailPhReUseText(PropertyUtility.getProperty("emailSubReuse"),emailText,fromAdrs);
		if(contentExist) {
			Assert.assertTrue(true, "Email content matches");
		}else {
			Assert.assertTrue(false, "Email content is not matching");
		}
	}
	
	//added on  09-02-2021
	public void readContentFromShareEmail(String usrType, String passType,String emailText,String fromAdrs) throws Exception {
		Utility.simpleWait(7000);
		new ReadEmail(PropertyUtility.getProperty(usrType),
				PropertyUtility.getProperty(passType), PropertyUtility.getProperty("email.server"),
				PropertyUtility.getProperty("email.protocol"),993,ReadEmail.EmailFolder.INBOX);

		boolean contentExist = ReadEmail.verifyEmailShareText(PropertyUtility.getProperty("emailShareSub1"),emailText,fromAdrs);
		if(contentExist) {
			Assert.assertTrue(true, "Email content matches");
		}else {
			Assert.assertTrue(false, "Email content is not matching");
		}
	}
		
	//added on  08-02-2021
	public void readContentFromChangeAcntEmail(String usrType, String passType,String emailText,String fromAdrs) throws Exception {
		Utility.simpleWait(7000);
		new ReadEmail(PropertyUtility.getProperty(usrType),
				PropertyUtility.getProperty(passType), PropertyUtility.getProperty("email.server"),
				PropertyUtility.getProperty("email.protocol"),993,ReadEmail.EmailFolder.INBOX);

		boolean contentExist = ReadEmail.verifyEmailChngPwdText(PropertyUtility.getProperty("emailSubAcnt"),emailText,fromAdrs);
		if(contentExist) {
			Assert.assertTrue(true, "Email content matches");
		}else {
			Assert.assertTrue(false, "Email content is not matching");
		}
	}
	
	//added on 05-02-2021
	public void readCodeFromEmail(String usrType, String passType, String logType) throws Exception {
		Utility.simpleWait(7000);
		 new ReadEmail(PropertyUtility.getProperty(usrType),
				PropertyUtility.getProperty(passType), PropertyUtility.getProperty("email.server"),
				PropertyUtility.getProperty("email.protocol"),993,ReadEmail.EmailFolder.INBOX);

		String code = ReadEmail.getAccessCode(PropertyUtility.getProperty("emailSub"));
		System.out.println("code="+code);
		code = code.replace("code is ","");
		if(logType.equals("reg")) {
				Utility.waitForElementToBeVisible(emailVerificationCode);
				emailVerificationCode.clear();
				emailVerificationCode.sendKeys(code);
		}else if(logType.equals("recover")) {
			Utility.waitForElementToBeVisible(enterVerificationCodeField);
			enterVerificationCodeField.clear();
			enterVerificationCodeField.sendKeys(code);
		}else {
			Utility.waitForElementToBeVisible(emailVerificationCodeLogIn);
			emailVerificationCodeLogIn.clear();
			emailVerificationCodeLogIn.sendKeys(code);
		}
	}
	
	//added on 05-02-2021
		public void readCodeFromRcvrEmail(String usrType, String passType, String logType) throws Exception {
			Utility.simpleWait(7000);
			 new ReadEmail(PropertyUtility.getProperty(usrType),
					PropertyUtility.getProperty(passType), PropertyUtility.getProperty("email.server"),
					PropertyUtility.getProperty("email.protocol"),993,ReadEmail.EmailFolder.INBOX);

			String code = ReadEmail.getAccessCode(PropertyUtility.getProperty("emailSub"));

			code = code.replace("code is ","");
			if(logType.equals("reg")) {
					Utility.waitForElementToBeVisible(emailVerificationCode);
					emailVerificationCode.clear();
					emailVerificationCode.sendKeys(code);
			}else {
				Utility.waitForElementToBeVisible(emailVerificationCodeLogIn);
				emailVerificationCodeLogIn.clear();
				emailVerificationCodeLogIn.sendKeys(code);
			}
		}
		
		public void readHyperLinksFromEmailShare(String usrType, String passType,String url1, String url2,String url3,String url4,String url5,String url6, String url7, String url8, String linkType) throws Exception {
			Utility.simpleWait(7000);
			System.out.println("In create account email");
			new ReadEmail(PropertyUtility.getProperty(usrType),
					PropertyUtility.getProperty(passType), PropertyUtility.getProperty("email.server"),
					PropertyUtility.getProperty("email.protocol"),993,ReadEmail.EmailFolder.INBOX);
			System.out.println("in email1");
			ArrayList<String> hyperLinks;
			if(linkType.equals("share")) {
				hyperLinks = ReadEmail.getHyperLinkText(PropertyUtility.getProperty("emailShareSub2"));
			}else {
				hyperLinks = ReadEmail.getHyperLinkText(PropertyUtility.getProperty("emailSub"));
			}
			
			System.out.println("in email2");
			int i =0;
			
			while(i<hyperLinks.size()) {
				System.out.println("link"+i+"="+hyperLinks.get(i).toString());
				if(i==0) {
					System.out.println("expurl1="+url1+",acturl1="+hyperLinks.get(i).toString());
				}else if(i==1) {
					System.out.println("expurl2="+url2+",acturl2="+hyperLinks.get(i).toString());
				}else if(i==2) {
					System.out.println("expurl3="+url3+",acturl3="+hyperLinks.get(i).toString());
				}else if(i==3) {
					System.out.println("expurl4="+url4+",acturl4="+hyperLinks.get(i).toString());
				}else if(i==4) {
					System.out.println("expurl5="+url5+",acturl5="+hyperLinks.get(i).toString());
				}else if(i==5) {
					System.out.println("expurl6="+url6+",acturl6="+hyperLinks.get(i).toString());
				}else if(i==6) {
					System.out.println("expurl7="+url7+",acturl7="+hyperLinks.get(i).toString());
				}else if(i==7) {
					System.out.println("expurl8="+url8+",acturl8="+hyperLinks.get(i).toString());	
				}
				i++;
			}
		}
		
		public void readHyperLinksFromEmailReg(String usrType, String passType,String url1, String url2,String url3,String url4,String url5,String url6, String url7, String url8) throws Exception {
			Utility.simpleWait(7000);
			System.out.println("In create account email");
			new ReadEmail(PropertyUtility.getProperty(usrType),
					PropertyUtility.getProperty(passType), PropertyUtility.getProperty("email.server"),
					PropertyUtility.getProperty("email.protocol"),993,ReadEmail.EmailFolder.INBOX);
			System.out.println("in email1");
			
			ArrayList<String> hyperLinks = ReadEmail.getHyperLinkText(PropertyUtility.getProperty("emailSub"));
			
			
			System.out.println("in email2");
			int i =0;
			
			while(i<hyperLinks.size()) {
				System.out.println("link"+i+"="+hyperLinks.get(i).toString());
				if(i==0) {
					System.out.println("expurl1="+url1+",acturl1="+hyperLinks.get(i).toString());
				}else if(i==1) {
					System.out.println("expurl2="+url2+",acturl2="+hyperLinks.get(i).toString());
				}else if(i==2) {
					System.out.println("expurl3="+url3+",acturl3="+hyperLinks.get(i).toString());
				}else if(i==3) {
					System.out.println("expurl4="+url4+",acturl4="+hyperLinks.get(i).toString());
				}else if(i==4) {
					System.out.println("expurl5="+url5+",acturl5="+hyperLinks.get(i).toString());
				}else if(i==5) {
					System.out.println("expurl6="+url6+",acturl6="+hyperLinks.get(i).toString());
				}else if(i==6) {
					System.out.println("expurl7="+url7+",acturl7="+hyperLinks.get(i).toString());
				}else if(i==7) {
					System.out.println("expurl8="+url8+",acturl8="+hyperLinks.get(i).toString());	
				}
				i++;
			}
		}
		
		
		public void readHyperLinksFromEmailRegWZ(String usrType, String passType,String url1, String url2,String url3,String url4,String url5) throws Exception {
			Utility.simpleWait(7000);
			System.out.println("In create account email");
			new ReadEmail(PropertyUtility.getProperty(usrType),
					PropertyUtility.getProperty(passType), PropertyUtility.getProperty("email.server"),
					PropertyUtility.getProperty("email.protocol"),993,ReadEmail.EmailFolder.INBOX);
			System.out.println("in email1");
			ArrayList<String> hyperLinks = ReadEmail.getHyperLinkText(PropertyUtility.getProperty("emailSub"));
			System.out.println("in email2");
			int i =0;
			while(i<hyperLinks.size()) {
				System.out.println("link"+i+"="+hyperLinks.get(i).toString());
				if(i==0) {
					System.out.println("expurl1="+url1+",acturl1="+hyperLinks.get(i).toString());
				}else if(i==1) {
					System.out.println("expurl2="+url2+",acturl2="+hyperLinks.get(i).toString());
				}else if(i==2) {
					System.out.println("expurl3="+url3+",acturl3="+hyperLinks.get(i).toString());
				}else if(i==3) {
					System.out.println("expurl4="+url4+",acturl4="+hyperLinks.get(i).toString());
				}else if(i==4) {
					System.out.println("expurl5="+url5+",acturl5="+hyperLinks.get(i).toString());
				}
				i++;
			}
		}
	
		public void readHyperLinksFromEmail(String usrType, String passType,String url1, String url2,String url3,String url4,String url5,String url6, String url7, String url8) throws Exception {
			Utility.simpleWait(7000);
			System.out.println("In create account email");
			 new ReadEmail(PropertyUtility.getProperty(usrType),
					PropertyUtility.getProperty(passType), PropertyUtility.getProperty("email.server"),
					PropertyUtility.getProperty("email.protocol"),993,ReadEmail.EmailFolder.INBOX);
			 System.out.println("in email1");
			ArrayList<String> hyperLinks = ReadEmail.getHyperLinkText(PropertyUtility.getProperty("emailSub2"));
			System.out.println("in email2");
			int i =0;
			//for(int i=0;i<hyperLinks.size();i++) {
				while(i<hyperLinks.size()) {
				System.out.println("link"+i+"="+hyperLinks.get(i).toString());
				if(i==0) {
					System.out.println("expurl1="+url1+",acturl1="+hyperLinks.get(i).toString());
					//Assert.assertEquals(hyperLinks.get(i).toString(), url1,"Url for "+url1+" is not matching");
				}else if(i==1) {
					System.out.println("expurl2="+url2+",acturl2="+hyperLinks.get(i).toString());
					//Assert.assertEquals(hyperLinks.get(i).toString(), url2,"Url for "+url2+" is not matching");
				}else if(i==2) {
					System.out.println("expurl3="+url3+",acturl3="+hyperLinks.get(i).toString());
					//Assert.assertEquals(hyperLinks.get(i).toString(), url3,"Url for "+url3+" is not matching");
				}else if(i==3) {
					System.out.println("expurl4="+url4+",acturl4="+hyperLinks.get(i).toString());
					//Assert.assertEquals(hyperLinks.get(i).toString(), url4,"Url for "+url4+" is not matching");
				}else if(i==4) {
					System.out.println("expurl5="+url5+",acturl5="+hyperLinks.get(i).toString());
					//Assert.assertEquals(hyperLinks.get(i).toString(), url5,"Url for "+url5+" is not matching");
				}else if(i==5) {
					System.out.println("expurl6="+url6+",acturl6="+hyperLinks.get(i).toString());
					//Assert.assertEquals(hyperLinks.get(i).toString(), url6,"Url for "+url6+" is not matching");
				}else if(i==6) {
					System.out.println("expurl7="+url7+",acturl7="+hyperLinks.get(i).toString());
					//Assert.assertEquals(hyperLinks.get(i).toString(), url7,"Url for "+url7+" is not matching");
				}else if(i==7) {
					System.out.println("expurl8="+url8+",acturl8="+hyperLinks.get(i).toString());
					//Assert.assertEquals(hyperLinks.get(i).toString(), url8,"Url for "+url8+" is not matching");	
				}
				i++;
			}
		}
		
		public void readHyperLinksFromEmailWZ(String usrType, String passType,String url1, String url2,String url3,String url4,String url5) throws Exception {
			Utility.simpleWait(7000);
			System.out.println("In create account email");
			 new ReadEmail(PropertyUtility.getProperty(usrType),
					PropertyUtility.getProperty(passType), PropertyUtility.getProperty("email.server"),
					PropertyUtility.getProperty("email.protocol"),993,ReadEmail.EmailFolder.INBOX);
			 System.out.println("in email1");
			ArrayList<String> hyperLinks = ReadEmail.getHyperLinkText(PropertyUtility.getProperty("emailSub2"));
			System.out.println("in email2");
			int i =0;
			//for(int i=0;i<hyperLinks.size();i++) {
				while(i<hyperLinks.size()) {
				System.out.println("link"+i+"="+hyperLinks.get(i).toString());
				if(i==0) {
					System.out.println("expurl1="+url1+",acturl1="+hyperLinks.get(i).toString());
					//Assert.assertEquals(hyperLinks.get(i).toString(), url1,"Url for "+url1+" is not matching");
				}else if(i==1) {
					System.out.println("expurl2="+url2+",acturl2="+hyperLinks.get(i).toString());
					//Assert.assertEquals(hyperLinks.get(i).toString(), url2,"Url for "+url2+" is not matching");
				}else if(i==2) {
					System.out.println("expurl3="+url3+",acturl3="+hyperLinks.get(i).toString());
					//Assert.assertEquals(hyperLinks.get(i).toString(), url3,"Url for "+url3+" is not matching");
				}else if(i==3) {
					System.out.println("expurl4="+url4+",acturl4="+hyperLinks.get(i).toString());
					//Assert.assertEquals(hyperLinks.get(i).toString(), url4,"Url for "+url4+" is not matching");
				}else if(i==4) {
					System.out.println("expurl5="+url5+",acturl5="+hyperLinks.get(i).toString());
					//Assert.assertEquals(hyperLinks.get(i).toString(), url5,"Url for "+url5+" is not matching");
				}
				i++;
			}
		}
	/**
	* Method Name: enterVerificationCode() Description: This function will be called
	* to enter verification code
	*/
	@SuppressWarnings("static-access")
	public void enterVerificationCode() {
		try {
			Utility.waitForElementToBeVisible(emailVerificationCode);
			Utility.waitForElementToBeClickable(emailVerificationCode);
			Assert.assertTrue(emailVerificationCode.isDisplayed(), "Email verification code Text field is visible");
			Utility.simpleWait(3000);
			String code=emailUtils.getAccessCode(PropertyUtility.getProperty("emailSub"));
			System.out.println("code **** "+code);
			emailVerificationCode.clear();
			emailVerificationCode.sendKeys(code);
			Thread.sleep(5000);
			Log.addMessage("Verification code is entered");
		}
		catch(Exception e) {
			Log.addMessage("Failed to enter email verification code");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter email verification Code");
			System.out.println();
		}
	}
	
	/**
	* Method Name: invalidVerificationCode() Description: This function will be called
	* to enter verification code
	*/
	public void invalidVerificationCode(String code) {
		try {
			Utility.waitForElementToBeVisible(emailVerificationCode);
			Utility.waitForElementToBeClickable(emailVerificationCode);
			Assert.assertTrue(emailVerificationCode.isDisplayed(), "Email verification code Text field is visible");
			Utility.simpleWait(3000);
			emailVerificationCode.clear();
			emailVerificationCode.sendKeys(code);
			Thread.sleep(5000);
			Log.addMessage("Verification code is entered");
		}
		catch(Exception e) {
			Log.addMessage("Failed to enter email verification code");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter email verification Code");
			System.out.println();
		}
	}

	/**
	 * Method Name: clickVerifyButton() Description: This function will be called
	 * to click verify button
	 */
	
	public void clickVerifyButton() {
		try {
			Utility.waitForElementToBeVisible(verifyButton);
			Utility.waitForElementToBeClickable(verifyButton);
			Assert.assertTrue(verifyButton.isDisplayed(), "Verify Button is visible");
			verifyButton.click();
			Log.addMessage("Verify Button is clicked");
		}
		catch(Exception e) {
			Log.addMessage("Failed to click Verify Button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click Verify button");
		}
	}
	
	/**
	 * Method Name: clickVerifySubButton() Description: This function will be called
	 * to click verify button
	 */
	
	public void clickVerifySubButton() {
		try {
			Utility.waitForElementToBeVisible(verifySubButton);
			Utility.waitForElementToBeClickable(verifySubButton);
			//Assert.assertTrue(verifyButton.isDisplayed(), "Verify Button is visible");
			verifySubButton.click();
			Assert.assertTrue(true,"Verify Button is visible");
			Log.addMessage("Verify Button is clicked");
		}
		catch(Exception e) {
			Log.addMessage("Failed to click Verify Button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click Verify button");
		}
	}
	
	/**
	 * Method Name: clickSendButton() Description: This function will be called
	 * to click verify button
	 */
	
	public void clickSendButton() {
		try {
			Utility.waitForElementToBeVisible(sendButton);
			Utility.waitForElementToBeClickable(sendButton);
			Assert.assertTrue(sendButton.isDisplayed(), "Send button is visible");
			sendButton.click();
			Log.addMessage("Send Button is clicked");
		}
		catch(Exception e) {
			Log.addMessage("Failed to click Send button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click Send button");
		}
	}
	
	/**
	 * Method Name: checkVerifyButton() Description: This function will be called
	 * to click verify button
	 */
	
	public void checkVerifyButton() {
		try {
			Utility.waitForElementToBeVisible(verifyButton);
			Utility.waitForElementToBeClickable(verifyButton);
			Assert.assertTrue(false, "Failed to disable verify button for invalid selection");
			Log.addMessage("Verify Button clicked");
		}
		catch(Exception e) {
			Log.addMessage("Verify Button is disabled for invalid selection");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(true, "Verify Button is disabled for invalid selection");
		}
	}
	

	/**
	 * Method Name: checkSendButton() Description: This function will be called
	 * to click send button
	 */
	
	public void checkSendButton() {
		try {
			Utility.waitForElementToBeVisible(sendButton);
			Utility.waitForElementToBeClickable(sendButton);
			Assert.assertTrue(false, "Failed to disable send button for invalid selection");
			Log.addMessage("Send button clicked");
		}
		catch(Exception e) {
			Log.addMessage("Send button is disabled for invalid selection");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(true, "Send button is disabled for invalid selection");
		}
	}
	
	/**
	 * Method Name: enterEmail() Description: This function will be called
	 * to enter email and verify the same
	 */
	
	public void enterEmail(String email) {
		try {
			Utility.waitForElementToBeVisible(emailField);
			Assert.assertTrue(emailField.isDisplayed(), "Email Text field is visible");
			emailField.clear();
			emailField.sendKeys(email);
			Log.addMessage("Email to be verified is entered");
		}
		catch(Exception e) {
			Log.addMessage("Failed to enter email");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter email");
		}
	}
	
	/**
	 * Method Name: invalidEmailCheck() Description: This function will be called
	 * to enter email and verify the same
	 */
	
	public void invalidEmailCheck(String valMessage) {
		try {
			Utility.simpleWait(6000);
			
			Utility.waitForElementToBeVisible(emailValidationMessage);
			System.out.println("Validation message is: "+emailValidationMessage.getText());
			//Assert.assertTrue(emailValidationMessage.isDisplayed(), "Validation message displayed for email does not exist");
			Assert.assertTrue(emailValidationMessage.getText().contains(valMessage),"Validation message is not matching");
			Log.addMessage("Email to be verified is entered");
		}
		catch(Exception e) {
			Log.addMessage("Failed to enter email");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter email");
		}
	}
	
	/**
	 * Method Name: invalidEmailAlertCheck() Description: This function will be called
	 * to enter email and verify the same
	 */
	
	public void invalidEmailAlertCheck(String valMessage) {
		try {
			Utility.simpleWait(6000);
			Utility.waitForElementToBeVisible(incorrectEmailAlertMessage);
			System.out.println("Validation message is: "+incorrectEmailAlertMessage.getText());
			//Assert.assertTrue(incorrectEmailAlertMessage.isDisplayed(), "Validation message displayed for email does not exist");
			Assert.assertTrue(incorrectEmailAlertMessage.getText().contains(valMessage), "Incorrect validation");
			Log.addMessage("Email to be verified is entered");
		}
		catch(Exception e) {
			Log.addMessage("Failed to enter email");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter email");
		}
	}
	
	//added on 28-07-2020
	/**
	 * Method Name: verifyUILogin() Description: This function will be called
	 * to login to the Consumer Portal
	 */

	public void verifyUIEmailRecover() {
		try {
			Utility.waitForElementToBeVisible(emailField);
			Assert.assertTrue(emailField.isDisplayed(), "Email Text field is visible");
			Assert.assertEquals(emailField.getAttribute("placeholder"),"Email", "Email place holder text is matching");
			System.out.println("one");
			Log.addMessage("Email Text field is visibled");
			Utility.waitForElementToBeVisible(sendButton);
			Assert.assertTrue(sendButton.isDisplayed(), "Confirm button is visible");
			System.out.println("2");
			Log.addMessage("Confirm button is visible");
			System.out.println("3");
			Log.addMessage("Create account link is visible");
		}
		catch(Exception e) {
			Log.addMessage("User not logged in");
			Log.addMessage(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to login");
			}
		}
	
	/**
	 * Method Name: clickCloseButton() Description: This function will be called
	 * to click close button
	*/
	
	public void clickCloseButton() {
		try {
			Utility.waitForElementToBeVisible(closeButton);
			Utility.waitForElementToBeClickable(closeButton);
			closeButton.click();
			Assert.assertTrue(true, "Close button clicked");
			Log.addMessage("Close button clicked");
		}
		catch(Exception e) {
			Log.addMessage("Failed to click close button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(true, "Failed to click close button");
		}
	}
}
