package pages.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Constants;
import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import utility.Log;
import utility.PropertyUtility;
import utility.ReadEmail;
import utility.Utility;

public class CodeVerificationPage extends Settings{

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
	//@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name='Spectrum-QA2']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/verification_code"),
		@AndroidBy(id = "com.kwikset.blewifi:id/verification_code"),
		@AndroidBy(id = "com.spectrum.giga:id/verification_code"),
		@AndroidBy(id = "com.weiser.blewifi:id/verification_code"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/verification_code")
	})
	@CacheLookup
	private MobileElement codeTextField1;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/etCode"),
		@AndroidBy(id = "com.kwikset.blewifi:id/etCode"),
		@AndroidBy(id = "com.spectrum.giga:id/etCode"),
		@AndroidBy(id = "com.weiser.blewifi:id/etCode"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/etCode")
	})
	@CacheLookup
	private MobileElement codeTextField2;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/edt_code"),
		@AndroidBy(id = "com.kwikset.blewifi:id/edt_code"),
		@AndroidBy(id = "com.spectrum.giga:id/edt_code"),
		@AndroidBy(id = "com.weiser.blewifi:id/edt_code"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/edt_code")
	})
	@CacheLookup
	private MobileElement codeTextFieldRcvr;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Submit']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_submit"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_submit"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_submit"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_submit"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/tv_submit")
	})
	@CacheLookup
	private MobileElement submitButton;
	
	//added on 11-07-2020
	@iOSXCUITFindBy(id = "Back")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_back"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_back"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_back"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_back"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/tv_back")
	})
	@CacheLookup
	private MobileElement backButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Resend']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/btn_resend"),
		@AndroidBy(id = "com.kwikset.blewifi:id/btn_resend"),
		@AndroidBy(id = "com.spectrum.giga:id/btn_resend"),
		@AndroidBy(id = "com.weiser.blewifi:id/btn_resend"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/btn_resend")
	})
	private MobileElement resendButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Not now']")
	@AndroidFindBy(id="android:id/button2")
	private MobileElement notNowButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Use Touch ID']")
	@AndroidFindBy(id="com.android.packageinstaller:id/permission_allow_button")
	private MobileElement allowButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Use Touch ID']")
	@AndroidFindBy(id="android:id/button1")
	private MobileElement bioAllowButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText")//added on 18-05-2020
	@AndroidFindBy(xpath="(//android.widget.Toast)[1]")
	@CacheLookup
	private MobileElement confirmToastMsg;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
	private MobileElement doneKeyboard;
	
	@iOSXCUITFindBy(id = "Ok")
	@AndroidFindBy(id="android:id/button1")
	private MobileElement confirmVerificationButton;
	
	@iOSXCUITFindBy(id = "Cancel")
	@AndroidFindBy(id="android:id/button2")
	private MobileElement cancelButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Decline']")
	@AndroidFindBy(id="android:id/button2")
	private MobileElement declineButton;
	
	@iOSXCUITFindBy(id = "Accept")
	@AndroidFindBy(id="android:id/button1")
	private MobileElement acceptButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[2]")
	@AndroidFindBy(id="android:id/message")
	private MobileElement confirmMessage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[1]")
	@AndroidFindBy(id="android:id/alertTitle")
	private MobileElement alertTitle;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[1]")
	@AndroidFindBy(id = "android:id/message")
	@CacheLookup
	private MobileElement popUpMessageVerbiage;
	
	String actTitle, actMessage, actualRes, toastMessage ="";
	

	//Constructor
	
	public CodeVerificationPage(AppiumDriver<MobileElement> driver) {
		Constants.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
		
		
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		

	public void enterVerificationCode_email_reg() {
		try {
			Utility.simpleWait(7000);
			String code = ReadEmail.getAccessCode(PropertyUtility.getProperty("emailSub"));
			code = code.replace("code is ","");
			Utility.waitForElementToBeVisible(codeTextField1);
			codeTextField1.clear();
			codeTextField1.sendKeys(code);
			Log.addMessage("Verification code entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter Verification code");
			Assert.assertTrue(false, "Failed to enter Verification code");
		}
	}
	
	public void enterVerificationCode_email() {
		try {	
			Utility.simpleWait(8000);
			String code = ReadEmail.getAccessCode(PropertyUtility.getProperty("emailSub"));
			System.out.println("code before replace="+code);
			code = code.replace("code is ", "");
			System.out.println("code after replace="+code);
			Utility.waitForElementToBeVisible(codeTextField2);
			codeTextField2.clear();
			codeTextField2.sendKeys(code);
			Log.addMessage("Verification code entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter Verification code");
			Assert.assertTrue(false, "Failed to enter Verification code");
		}
	}
	
	public void readCode_email_reg(String email, String pwd) throws Exception {
		//try {	
			Utility.simpleWait(8000);
			System.out.println("in readCode_email_reg");
			new ReadEmail(email, pwd, PropertyUtility.getProperty("email.server"), PropertyUtility.getProperty("email.protocol"),993,ReadEmail.EmailFolder.INBOX);
			System.out.println("in readCode_email_reg");
			String code = ReadEmail.getAccessCode(PropertyUtility.getProperty("emailSub"));
			code = code.replace("code is ", "");
			System.out.println("code="+code);
			Utility.waitForElementToBeVisible(codeTextField2);
			codeTextField2.clear();
			codeTextField2.sendKeys(code);
			Log.addMessage("Verification code entered");
		/*}catch(Exception e) {
			Log.addMessage("Failed to enter Verification code");
			Assert.assertTrue(false, "Failed to enter Verification code");
		}*/
	}

	public void enterVerificationCode_phone() {
		try {	
			Utility.simpleWait(7000);
			String code=ReadEmail.getAccessCodeMobile(PropertyUtility.getProperty("phoneSub"));
			code = code.replace("code is ", "");
			Utility.waitForElementToBeVisible(codeTextField2);
			codeTextField2.clear();
			codeTextField2.sendKeys(code);
			Log.addMessage("Verification code entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter Verification code");
			Assert.assertTrue(false, "Failed to enter Verification code");
		}
	}

	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void clickSubmitButton() {
		try {
			Utility.waitForElementToBeVisible(submitButton);
			Utility.waitForElementToBeClickable(submitButton);
			submitButton.click();
			Log.addMessage("Clicked Submit button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Submit button");
			Assert.assertTrue(false, "Failed to click Submit button");
		}
	}
	
	//added on 29-06-2020
	/** 
	* Method Name: enterEmailCode(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void enterEmailCode(String emailCode) {
		try {
			Utility.waitForElementToBeVisible(codeTextField1);
			codeTextField1.clear();
			codeTextField1.sendKeys(emailCode);
			Log.addMessage("Email verification code entered");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to enter email verification code");
			Assert.assertTrue(false, "Failed to enter email verification code");
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
	
	/** 
	* Method Name: enterEmailCodeDoneKey(), 
	* This function is used to enter done key in keyboard from the MFA Page
	*/
		
	public void enterEmailCodeDoneKey(String emailCode, String valType) {
		try {
			if(valType.equals("new")) {
				Utility.waitForElementToBeVisible(codeTextField1);
				codeTextField1.click();
				codeTextField1.clear();
				codeTextField1.sendKeys(emailCode);
			}else {
				Utility.waitForElementToBeVisible(codeTextField2);
				codeTextField2.click();
				codeTextField2.clear();
				codeTextField2.sendKeys(emailCode);
			}
			Log.addMessage("Email verification code entered");
			if(device.equals("iOS")) {
				doneKeyboard.click();
			}else {
				JavascriptExecutor js = appiumDriver;
				Map<String, Object> params = new HashMap<>();
				params.put("action", "Done");
				if(valType.equals("new")) {
					params.put("element", codeTextField1);
				}else {
					params.put("element", codeTextField2);
				}
				js.executeScript("mobile: performEditorAction", params);
				if(valType.equals("edit")) {
					Utility.simpleWait(2000);
					toastMessage="";
					toastMessage=confirmToastMsg.getAttribute("name");
				}
			}
			Log.addMessage("Clicked Done Button");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click done button");
			Assert.assertTrue(false, "Failed to click done button");
		}
	}
	
	/** 
	* Method Name: enterMobileCode(), 
	* This function is used to select mobile code from the Mobile Page
	*/
		
	public void enterMobileCode(String emailCode) {
		try {
			Utility.waitForElementToBeVisible(codeTextField2);
			codeTextField2.clear();
			codeTextField2.sendKeys(emailCode);
			Log.addMessage("Phone verification code entered");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to enter Phone verification code");
			Assert.assertTrue(false, "Failed to enter Phone verification code");
		}
	}
	
	//added on 04-11-2020
	public void readCodeFromEmail(String usrType, String passType) throws Exception {
		Utility.simpleWait(7000);
		 new ReadEmail(PropertyUtility.getProperty(usrType),
				PropertyUtility.getProperty(passType), PropertyUtility.getProperty("email.server"),
				PropertyUtility.getProperty("email.protocol"),993,ReadEmail.EmailFolder.INBOX);

		String code = ReadEmail.getAccessCode(PropertyUtility.getProperty("emailSub"));

		code = code.replace("code is ","");
		Utility.waitForElementToBeVisible(codeTextField2);
		codeTextField2.clear();
		codeTextField2.sendKeys(code);
	}
	
	//added on 26-02-2021
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
	
	//added on 26-02-2021
	public void readContentFromEmailChange(String usrType, String passType,String emailText,String fromAdrs) throws Exception {
		Utility.simpleWait(7000);
		new ReadEmail(PropertyUtility.getProperty(usrType),
				PropertyUtility.getProperty(passType), PropertyUtility.getProperty("email.server"),
				PropertyUtility.getProperty("email.protocol"),993,ReadEmail.EmailFolder.INBOX);

		boolean contentExist = ReadEmail.verifyEmailText(PropertyUtility.getProperty("emailSub2"),emailText,fromAdrs);
		if(contentExist) {
			Assert.assertTrue(true, "Email content matches");
		}else {
			Assert.assertTrue(false, "Email content is not matching");
		}
	}
	
	public void readCodeFromEmailReg(String usrType, String passType) throws Exception {
		Utility.simpleWait(7000);
		System.out.println("in email");
		new ReadEmail(PropertyUtility.getProperty(usrType),
				PropertyUtility.getProperty(passType), PropertyUtility.getProperty("email.server"),
				PropertyUtility.getProperty("email.protocol"),993,ReadEmail.EmailFolder.INBOX);
		 System.out.println("in email1");
		String code = ReadEmail.getAccessCode(PropertyUtility.getProperty("emailSub"));
		System.out.println("in email2");
		code = code.replace("code is ","");
		System.out.println("in code="+code);
		Utility.waitForElementToBeVisible(codeTextField1);
		codeTextField1.clear();
		codeTextField1.sendKeys(code);
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
	
	//added on 17-12-2020
	public void readMobileCodeFromEmail(String usrType, String passType) throws Exception {
		 Utility.simpleWait(7000);
		 new ReadEmail(PropertyUtility.getProperty(usrType),
				PropertyUtility.getProperty(passType), PropertyUtility.getProperty("email.server"),
				PropertyUtility.getProperty("email.protocol"),993,ReadEmail.EmailFolder.INBOX);
		 String code = "";
		 if(environment.equals("QA")) {
			 System.out.println("in QA");
			 	 code = ReadEmail.getAccessCode(PropertyUtility.getProperty("emailSub1"));//changed for QA
		 }else {
			 System.out.println("in other env");
				 code = ReadEmail.getAccessCode(PropertyUtility.getProperty("phoneSub"));//change the subject based on env
		 }
		 System.out.println("in QA code");
		code = code.replace("code is ","");
		System.out.println("after QA code");
		Utility.waitForElementToBeVisible(codeTextField2);
		codeTextField2.clear();
		codeTextField2.sendKeys(code);
	}

	//added on 02-02-2021 for android
	public void readMobileCodeFromRcvrEmail(String usrType, String passType) throws Exception {
			 Utility.simpleWait(7000);
			 new ReadEmail(PropertyUtility.getProperty(usrType),
					PropertyUtility.getProperty(passType), PropertyUtility.getProperty("email.server"),
					PropertyUtility.getProperty("email.protocol"),993,ReadEmail.EmailFolder.INBOX);

			//String code = ReadEmail.getAccessCode(PropertyUtility.getProperty("forgotPasswordSub"));//change the subject based on env commented for Android on 17 mar 2021
			 String code = ReadEmail.getAccessCode(PropertyUtility.getProperty("phoneSub"));

			code = code.replace("code is ","");

			Utility.waitForElementToBeVisible(codeTextFieldRcvr);
			codeTextFieldRcvr.clear();
			codeTextFieldRcvr.sendKeys(code);
	}
	
	//added on 02-02-2021 for android
	public void readMobileCodeFromRcvrWzEmail(String usrType, String passType) throws Exception {
			 Utility.simpleWait(7000);
			 new ReadEmail(PropertyUtility.getProperty(usrType),
					PropertyUtility.getProperty(passType), PropertyUtility.getProperty("email.server"),
					PropertyUtility.getProperty("email.protocol"),993,ReadEmail.EmailFolder.INBOX);

			//String code = ReadEmail.getAccessCode(PropertyUtility.getProperty("forgotPasswordSub"));//change the subject based on env commented for Android on 17 mar 2021
			 String code = ReadEmail.getAccessCodeRcvr(PropertyUtility.getProperty("phoneSub"));

			code = code.replace("code is ","");

			Utility.waitForElementToBeVisible(codeTextFieldRcvr);
			codeTextFieldRcvr.clear();
			codeTextFieldRcvr.sendKeys(code);
	}
	
	//added on 19-02-2021 for android
		public void readEmailCodeFromRcvrEmail(String usrType, String passType) throws Exception {
				 Utility.simpleWait(7000);
				 new ReadEmail(PropertyUtility.getProperty(usrType),
						PropertyUtility.getProperty(passType), PropertyUtility.getProperty("email.server"),
						PropertyUtility.getProperty("email.protocol"),993,ReadEmail.EmailFolder.INBOX);

				String code = "";
				code = ReadEmail.getAccessCode(PropertyUtility.getProperty("forgotPasswordSub"));//changed for QA
				
				code = code.replace("code is ","");

				Utility.waitForElementToBeVisible(codeTextFieldRcvr);
				codeTextFieldRcvr.clear();
				codeTextFieldRcvr.sendKeys(code);
		}
		
	/** 
	* Method Name: enterEmailCodeDoneKey(), 
	* This function is used to enter done key in keyboard from the MFA Page
	*/
		
	public void enterPhoneVerifyDoneKey(String emailCode, String valType) {
		try {
			Utility.waitForElementToBeVisible(codeTextField2);
			codeTextField2.click();
			codeTextField2.clear();
			codeTextField2.sendKeys(emailCode);
			Log.addMessage("Phone verification code entered");
			
			if(device.equals("iOS")) {
				doneKeyboard.click();
			}else {
				JavascriptExecutor js = appiumDriver;
				Map<String, Object> params = new HashMap<>();
				params.put("action", "Done");params.put("element", codeTextField2);
				js.executeScript("mobile: performEditorAction", params);
				if(valType.equals("edit")) {
					Utility.simpleWait(2000);
					toastMessage="";
					toastMessage=confirmToastMsg.getAttribute("name");
				}
			}
			Log.addMessage("Clicked Done Button");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click done button");
			Assert.assertTrue(false, "Failed to click done button");
		}
	}
	
	/** 
	* Method Name: clickResendButton(), 
	* This function is used to click Resend Button
	*/
		
	public void clickResendButton() {
		try {			
			Utility.waitForElementToBeVisible(resendButton);
			Utility.waitForElementToBeClickable(resendButton);
			resendButton.click();	
			Thread.sleep(5000);
			Log.addMessage("Clicked Resend button for entering Verification Code");
		}catch(Exception e) {
			Log.addMessage("Resend button for requesting new Verification Code is not visible");
			System.out.println(e.getMessage().toString());
			//Assert.assertTrue(false, "Resend button for requesting new Verification Code is not visible");
		}
	}
	
	/** 
	* Method Name: checkResendButton(), 
	* This function is used to check for Resend Button
	*/
		
	public boolean checkResendButton() {
		try {			
			Utility.waitForElementToBeVisible(resendButton);
			//Thread.sleep(5000);
			Log.addMessage("Clicked Resend button for entering Verification Code");;
			return true;
		}catch(Exception e) {
			Log.addMessage("Resend button for requesting new Verification Code is not visible");
			System.out.println(e.getMessage().toString());
			return false;
		}
	}
	
	/** 
	* Method Name: clickOKButton(), 
	* This function is used to click OK Button
	*/
		
	public void clickOKButton() {
		try {		
			Utility.simpleWait(3000);
			Utility.waitForElementToBeVisible(confirmVerificationButton);
			Utility.waitForElementToBeClickable(confirmVerificationButton);
			confirmVerificationButton.click();	
			Log.addMessage("Clicked OK button for entering Verification Code");
		}catch(Exception e) {
			Log.addMessage("OK button is not visible");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "OK button is not visible");
		}
	}
	
	/** 
	* Method Name: clickAcceptButton(), 
	* This function is used to click OK Button
	*/
		
	public void clickAcceptButton() {
		try {		
			System.out.println("one");
			Utility.waitForElementToBeVisible(acceptButton);
			System.out.println("two");
			Utility.waitForElementToBeClickable(acceptButton);
			System.out.println("three");
			acceptButton.click();	
			Log.addMessage("Clicked accept button");
		}catch(Exception e) {
			Log.addMessage("Accept button is not visible");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Accept button is not visible");
		}
	}
	
	/** 
	* Method Name: clickCancelButton(), 
	* This function is used to click OK Button
	*/
		
	public void clickCancelButton() {
		try {	
			System.out.println("one");
			Utility.waitForElementToBeVisible(cancelButton);
			System.out.println("two");
			Utility.waitForElementToBeClickable(cancelButton);
			System.out.println("three");
			cancelButton.click();
			System.out.println("four");
			Log.addMessage("Clicked cancel button");
		}catch(Exception e) {
			Log.addMessage("Cancel button is not visible");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Cancel button is not visible");
		}
	}
	
	/** 
	* Method Name: clickDeclineButton(), 
	* This function is used to click decline Button
	*/
		
	public void clickDeclineButton() {
		try {	
			System.out.println("one");
			Utility.waitForElementToBeVisible(declineButton);
			System.out.println("two");
			Utility.waitForElementToBeClickable(declineButton);
			System.out.println("three");
			declineButton.click();
			System.out.println("four");
			Log.addMessage("Clicked decline button");
		}catch(Exception e) {
			Log.addMessage("Decline button is not visible");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Decline button is not visible");
		}
	}
	
	/** 
	* Method Name: valEmailVerificationCode(), 
	* This function is used to update VerificationCode in Email Page
	*/	
	public void valEmailVerificationCode(String VCode, String titleMsg, String errMessage, String actlToastMsg, String valType, String iMessage) {
		try {
			if(valType.equals("new")) {
				if(VCode.equals("")) {
					Utility.simpleWait(6000);
				}
				enterEmailCode(VCode);
			}else {
				enterMobileCode(VCode);
			}	
			System.out.println("updated VCode="+VCode);
			System.out.println("updated errMessage="+errMessage);
			if(valType.equals("new")) {
				clickSubmitButton();
				if(VCode!="") {
					if(VCode.length()>=6) {
						Utility.simpleWait(8000);
					}
				}
				if(confirmVerificationButton.isDisplayed()) {
					if(titleMsg!="") {
						actTitle=alertTitle.getText();
						actMessage=confirmMessage.getText();
					}else {
						actMessage=alertTitle.getText();
					}
					System.out.println("mainMessage="+actMessage);
					if(device.equals("iOS")) {
						setErrMsg(iMessage,actMessage,titleMsg, actTitle, valType);
					}else {
						setErrMsg(errMessage,actMessage,titleMsg, actTitle, valType);
					}
					
					//Utility.simpleWait(2000);commented on 8th Aug for less wait during regression
				}
			}else {
				if(device.equals("iOS")) {
					clickSubmitButton();
					if(confirmVerificationButton.isDisplayed()) {
						if(titleMsg!="") {
							actTitle=alertTitle.getText();
							actMessage=confirmMessage.getText();
						}else {
							actMessage=alertTitle.getText();
						}
						System.out.println("mainMessage="+actMessage);
						setErrMsg(iMessage,actMessage,titleMsg, actTitle, valType);
						//Utility.simpleWait(2000);commented on 8th Aug for less wait during regression
					}	
				}else if(actlToastMsg!="") {
					System.out.println("in edit");
					clickSubmitButton();
					Utility.simpleWait(2000);
					toastMessage="";
					toastMessage=confirmToastMsg.getAttribute("name");
					System.out.println("toastMessage="+toastMessage);
					setErrMsg(actlToastMsg, toastMessage, titleMsg, actTitle, valType);	
				}
			}
			System.out.println("out");
			Log.addMessage("VerificationCode Updated and directed to AccountSettings page");
		}catch(Exception e) {
			Log.addMessage("VerificationCode Not Updated");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "VerificationCode Not Updated");
		}
	}
	
	public void setErrMsg(String exRes, String mnMsg, String ttlMsg, String actTtl, String valType) {
		try {
			System.out.println("in errmsg");
			if(exRes!="") {
				System.out.println("in errmsg2");
				if(valType.equals("new")) {
					if(confirmVerificationButton.isDisplayed()) {
						System.out.println("in confirmVerificationButton");
						
						confirmVerificationButton.click();
						actualRes = mnMsg;
						//System.out.println("in actualRes="+confirmMessage.getText());
						if(ttlMsg!="") {
							actTitle = actTtl;
							System.out.println("actTitle---="+actTitle+", expttl="+ttlMsg);
							Assert.assertEquals(actTitle, ttlMsg,"Please check the title validation message.");
						}
					}
				}else {
					if(device.equals("iOS")) {
						System.out.println("in iOS edit click OK");
						confirmVerificationButton.click();
					}
					actualRes = mnMsg;
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
	
	/** 
	* Method Name: valMobileVerificationCode(), 
	* This function is used to update VerificationCode in Email Page
	*/	
	public void valMobileVerificationCode(String vmobile, String titleMsg, String errMessage, String actlToastMsg, String valType, String iTitle, String iMessage, String iEditMsg) {
		try {
			enterMobileCode(vmobile);	
			System.out.println("updated vmobile="+vmobile);
			if(valType.equals("new")) {
				clickSubmitButton();	
				if(vmobile!="") {
					if(vmobile.length()>=6) {
						Utility.simpleWait(10000);
					}
				}
				System.out.println("updated out");
				if(confirmVerificationButton.isDisplayed()) {
					if(titleMsg!="") {
						actTitle=alertTitle.getText();
						actMessage=confirmMessage.getText();
					}else {
						actMessage=alertTitle.getText();
					}
					
					System.out.println("mainMessage="+actMessage);
					if(device.equals("iOS")) {
						
						setErrMsg(iMessage, actMessage, iTitle, actTitle, valType);
					}else {
						setErrMsg(errMessage, actMessage, titleMsg, actTitle, valType);
					}
					//Utility.simpleWait(2000);commented on 8th Aug for less wait during regression
				}
			}else {
				if(device.equals("iOS")) {
					System.out.println("in edit");
					clickSubmitButton();
					Utility.simpleWait(2000);
					if(confirmVerificationButton.isDisplayed()) {
						if(titleMsg!="") {
							actTitle=alertTitle.getText();
							actMessage=confirmMessage.getText();
						}else {
							actMessage=alertTitle.getText();
						}
						
						System.out.println("mainMessage="+actMessage);
						setErrMsg(iEditMsg, actMessage, iTitle, actTitle, valType);
					}
				}else if(actlToastMsg!="") { 
					System.out.println("in edit");
					clickSubmitButton();
					Utility.simpleWait(2000);
					toastMessage="";
					toastMessage=confirmToastMsg.getAttribute("name");
					System.out.println("toastMessage="+toastMessage);
					setErrMsg(actlToastMsg, toastMessage, titleMsg, actTitle, valType);	
				}
			}
			
			System.out.println("out");
			Log.addMessage("VerificationCode Updated and directed to AccountSettings page");
		}catch(Exception e) {
			Log.addMessage("VerificationCode Not Updated");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "VerificationCode Not Updated");
		}
	}
	
	//added on 29-06-2020
	/** 
	* Method Name: clickBackButton(), 
	* This function is used to select Back option from the Name Page
	*/
		
	public void clickBackButton() {
		try {
			Utility.waitForElementToBeVisible(backButton);
			Utility.waitForElementToBeClickable(backButton);
			backButton.click();
			Log.addMessage("Clicked Back Button");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click Back button");
			Assert.assertTrue(false, "Failed to click Back button");
		}
	}
	
	public void verifyResendPopUpVerbiage(String expMessage) {
		try {
			Utility.waitForElementToBeVisible(popUpMessageVerbiage);
			actMessage = popUpMessageVerbiage.getText();
			System.out.println("expmainMsg="+expMessage+",mainMsg="+actMessage);
			confirmVerificationButton.click();
			Assert.assertEquals(actMessage, expMessage,"Popup content message is not matching");
			
			Log.addMessage("Pop up verbiage is matching");
		}catch(Exception e) {
			Log.addMessage("Pop up verbiage is not matching");
			Assert.assertTrue(false, "Pop up verbiage is not matching");
		}
	}
	
	/** 
	* Method Name: clickNotNowButton(), 
	* This function is used to click Not Now Button
	*/
		
	public void clickNotNowButton() {
		try {			
			Utility.waitForElementToBeVisible(notNowButton);
			Utility.waitForElementToBeClickable(notNowButton);
			notNowButton.click();	
			Log.addMessage("Clicked Not now button for disabling finger print");
			Utility.waitForElementToBeVisible(confirmVerificationButton);
			confirmVerificationButton.click();	
		}catch(Exception e) {
			Log.addMessage("Failed to disable fingerprint");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to disable fingerprint");
		}
	}
	
	/** 
	* Method Name: clickAllowButton(), 
	* This function is used to click Not Now Button
	*/
		
	public void clickAllowButton() {
		try {			
			Utility.waitForElementToBeVisible(allowButton);
			Utility.waitForElementToBeClickable(allowButton);
			allowButton.click();	
			Log.addMessage("Clicked Allow button for allowing access to device locaton");
		}catch(Exception e) {
			Log.addMessage("Allow button for allowing access to device locaton not found");
			System.out.println(e.getMessage().toString());
			//Assert.assertTrue(false, "Failed to disable fingerprint");
		}
	}
	
	/** 
	* Method Name: clickAllowBioButton(), 
	* This function is used to click allow biometric button
	*/
		
	public void clickAllowBioButton() {
		try {			
			Utility.waitForElementToBeVisible(bioAllowButton);
			Utility.waitForElementToBeClickable(bioAllowButton);
			bioAllowButton.click();	
			Log.addMessage("Clicked biometric allow button");
		}catch(Exception e) {
			Log.addMessage("Failed to activate biometric");
			System.out.println(e.getMessage().toString());
		}
	}
}
