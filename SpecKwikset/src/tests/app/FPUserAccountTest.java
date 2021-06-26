package tests.app;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionState;
import okhttp3.Connection;
import pages.app.AccountNamePage;
import pages.app.AccountSettingsPage;
import pages.app.AutoLockDelaySettingPage;
import pages.app.ChooseVerificationMethodPage;
import pages.app.ClearHistoryPopupPage;
import pages.app.CodeVerificationPage;
import pages.app.ConfirmDeleteLockPage;
import pages.app.CreateAHomePage;
import pages.app.EnterEmailPage;
import pages.app.EnterHomeNamePage;
import pages.app.EnterMobileNumberPage;
import pages.app.EnterPasswordPage;
import pages.app.ForgotPasswordPage;
import pages.app.LockDashboardPage;
import pages.app.LockEventHistoryPage;
import pages.app.LockInfoPage;
import pages.app.LockNamePage;
import pages.app.LockSettingsPage;
import pages.app.LoginPage;
import pages.app.ManageHomesPage;
import pages.app.MenuFlyoutPage;
import pages.app.PairedSmartPhoneListPage;
import pages.app.PhoneCodeVerificationPage;
import pages.app.SecurityQuestionsPage;
import pages.app.SettingsPage;
import pages.app.UpdateAccountNamePage;
import pages.app.UpdatePasswordPage;
import pages.app.UpdatePhoneNumberPage;
import pages.app.UserFPAccessProfilePage;
import pages.app.ViewAccessCodesPage;
import pages.portal.ChangePasswordPage;
import pages.portal.EmailVerificationPage;
import pages.portal.UserHomePage;
import utility.ExcelRead;
import utility.Log;
import utility.Utility;


public class FPUserAccountTest extends Settings{
	
	int sbcnt, timecnt, lkcnt, cntPhone = 0;
	String delayStts, updtdTimeflyout, updtdTimeDashboard = "";
	
	@SuppressWarnings("unchecked")
	@Test
	public void viewAccountNameTest() throws InterruptedException {
		try {
			LoginPage lp = new LoginPage((AppiumDriver<MobileElement>) driver);
			AccountNamePage an = new AccountNamePage((AppiumDriver<MobileElement>) driver);
			
			
			System.out.println("before refresh");
			//if(device.equals("android")) {
				//Thread.sleep(27000);
			//}
			lp.clickCreateAnAccountButton();
			System.out.println("after refresh");
			Thread.sleep(3000);
			an.verifyUIAccountName();
			Thread.sleep(3000);
			Thread.sleep(27000);
			Log.addMessage("All elements displayed in the account name page");
		}catch(Exception e) {
			Log.addMessage("Failed to display elements in account name page");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display elements in account name page");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void valAccountNameKeyboardTest() {
		 try {
			 AccountNamePage an = new AccountNamePage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for test in between
			 an.clickFirstNameNextKey("t");
			 an.clickLastNameDoneKey("u");
			 Log.addMessage("Clicked keyboard Next button");
			 an.clickOKButton();
			 Log.addMessage("Clicked keyboard Done button");
			 Thread.sleep(5000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to click back button");
			 e.printStackTrace();
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void valAccountNameBackTest() {
		 try {
			 AccountNamePage an = new AccountNamePage((AppiumDriver<MobileElement>) driver);
			 LoginPage lp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 an.clickBackButton();
			 lp.clickCreateAnAccountButton();
			 Thread.sleep(5000);
			 Log.addMessage("Clicked back button");
		 }catch(Exception e) {
			 Log.addMessage("Failed to click back button");
			 e.printStackTrace();
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void clickCreateAccountTest() {
		 try {
			 LoginPage lp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 lp.clickCreateAnAccountButton();
			 Thread.sleep(5000);
			 Log.addMessage("Clicked create account button");
		 }catch(Exception e) {
			 Log.addMessage("Failed to click create account button");
			 e.printStackTrace();
		 }
	}
	
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="acntName")
	public void valAccountNameTest(String firstname,String lastname,String titleMsg,String errMessage,String iMessage) {
		try {
			AccountNamePage an = new AccountNamePage((AppiumDriver<MobileElement>) driver);
			//Thread.sleep(27000);//for test in between
			an.valAccountName(firstname, lastname, titleMsg, errMessage,iMessage);
			System.out.println("after val return");
			Log.addMessage("Account name validated");
		}catch(Exception e){
			Log.addMessage("Failed to validate account name");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to validate account name");
		} 
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="validDelAcntName")
	public void validAcntNameTest(String firstname,String lastname) {
		try {
			AccountNamePage an = new AccountNamePage((AppiumDriver<MobileElement>) driver);
			//Thread.sleep(27000);//for test in between
			an.enterFirstName(firstname);
			an.enterLastName(lastname);			
			an.clickNextButton();
			Log.addMessage("Account name entered");
		}catch(Exception e){
			Log.addMessage("Failed to enter account name");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to enter account name");
		} 
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void validAccountNameTest() {
		try {
			AccountNamePage an = new AccountNamePage((AppiumDriver<MobileElement>) driver);
			//Thread.sleep(27000);//for test in between
			/*an.enterFirstName("specBVT");
			an.enterLastName("envBVT");*/
			an.enterFirstName("test");
			an.enterLastName("test");
			an.clickNextButton();
			System.out.println("after val return");
			Log.addMessage("Account name entered");
		}catch(Exception e){
			Log.addMessage("Failed to enter account name");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to enter account name");
		} 
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void valEmailKeyboardTest() {
		 try {
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			//Thread.sleep(27000);//for test in between
			 ee.enterEmailDoneKey("test");
			 Thread.sleep(2000);
			 ee.clickOKButton();
			 Log.addMessage("Clicked Done button from keyboard");
			 Thread.sleep(5000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to click Done button");
			 e.printStackTrace();
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void valEmailBackTest() {
		 try {
			 AccountNamePage an = new AccountNamePage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 if(device.equals("iOS")) {//on create user flow
				 ee.clickBackIButton();
			 }else {
				 ee.clickBackButton();
			 }
			 an.clickNextButton();
			 Thread.sleep(5000);
			 Log.addMessage("Clicked back button");
		 }catch(Exception e) {
			 Log.addMessage("Failed to click back button");
			 e.printStackTrace();
		 }
	}

	@SuppressWarnings("unchecked")
	@Test(dataProvider="email")
	public void valEmailTest(String email, String titleMsg, String errMessage, String iMessage) {
		try {
			EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			//Thread.sleep(1000);
			System.out.println("in val main");
			ee.valEmail(email, titleMsg, errMessage, iMessage);
			//Thread.sleep(3000);
			Log.addMessage("Email validated");
		}catch(Exception e){
			Log.addMessage("Failed to validate email");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to validate email");
		} 
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vemail")
	public void validEmailTest(String email) {
		try {
			EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			//Thread.sleep(1000);
			System.out.println("in val main");
			ee.enterEmail(email);
			ee.clickSubmitButton();
			if(device.equals("android")) {
				ee.clickOKButton();
			}
			//Thread.sleep(3000);
			Log.addMessage("Email validated");
		}catch(Exception e){
			Log.addMessage("Failed to validate email");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to validate email");
		} 
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="emailVerify")
	public void valEmailVerifyCodeTest(String valCode, String titleMsg, String valMessage, String toastMsg, String iMessage) {
		 try {
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 cv.valEmailVerificationCode(valCode,titleMsg, valMessage, toastMsg,"new",iMessage);
			 Log.addMessage("Email verification Code entered");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter email verification Code");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter email verification Code");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void validEmailCodeTest() {
		try {
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("Wait for reading email code from mail");
			 Thread.sleep(20000);
			// cv.enterEmailCode("123456");
			 cv.readCodeFromEmailReg("email.address3", "email.password3");
			 cv.clickSubmitButton(); 
			 if(device.equals("iOS")) {
				Utility.simpleWait(5000);
			 }
			Log.addMessage("Email validated");
		}catch(Exception e){
			Log.addMessage("Failed to validate email");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to validate email");
		} 
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="resendPopup")
	public void valEmailResendLimitTest(String popupMsg, String ipopupMsg) {
		 try {
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			
			 for(int i=0; i<5; i++) {
				 cv.clickResendButton();
				 cv.clickOKButton();
			 }
			 //check the popup verbiage for resend limits
			 //Thread.sleep(5000);//commented for regression 8th Aug 2020
			 cv.clickResendButton();
			 if(device.equals("iOS")) {
				 cv.verifyResendPopUpVerbiage(ipopupMsg);
			 }else {
				 cv.verifyResendPopUpVerbiage(popupMsg);
			 }
			// cv.clickOKButton();
			 Log.addMessage("Resend limits set");
		 }catch(Exception e) {
			 Log.addMessage("Resend limits not set for Email verification code");
			 e.printStackTrace();
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vmobile")
	public void validEmailResendTest(String firstNm, String lastNm, String email, String mobile) {
		try {
			 LoginPage lp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 AccountNamePage an = new AccountNamePage((AppiumDriver<MobileElement>) driver);
			 lp.clickCreateAnAccountButton();//comment for testing in between
			 //Thread.sleep(5000);
			 Log.addMessage("Clicked create account button");
			 System.out.println("in val main");
			 an.enterFirstName(firstNm);
			 an.enterLastName(lastNm);			
			 an.clickNextButton();
			 Thread.sleep(3000);
			 ee.enterEmail(email);
			 ee.clickSubmitButton();
			 Thread.sleep(2000);
			 if(device.equals("android")) {
				 ee.clickOKButton();
			 }
			 Log.addMessage("Email validated");
		}catch(Exception e){
			Log.addMessage("Failed to validate email");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to validate email");
		} 
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void valEmailVerifyKeyboardTest() {
		 try {
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for test in between
			 cv.enterEmailCodeDoneKey("12","new");
			 cv.clickOKButton();
			 Log.addMessage("Clicked Done button from keyboard");
			 Thread.sleep(3000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to click Done button");
			 e.printStackTrace();
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void valEmailVerifyBackTest() {
		 try {
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//to test in between
			 cv.clickBackButton();
			 Thread.sleep(3000);
			 ee.clickSubmitButton();
			 Thread.sleep(3000);
			 if(device.equals("android")) {
				 ee.clickOKButton();
			 }
			/* Thread.sleep(15000);
			 System.out.println("wait to retrieve verification code from email");
			 //get verification code from mail and submit
			 cv.enterEmailCode("123456");
			 Thread.sleep(5000);//to edit while testing
			 cv.clickSubmitButton();*/
			 //cv.readCode_email_reg("email.address3", "email.password3");//commented for iOS on 19-02-2021
			 cv.readCodeFromEmailReg("email.address3", "email.password3");
			 cv.clickSubmitButton(); 
			 if(device.equals("iOS")) {
				Utility.simpleWait(5000);
			 }
			 Log.addMessage("Clicked email code submit button");
		 }catch(Exception e) {
			 Log.addMessage("Failed to click email code submit button");
			 e.printStackTrace();
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void valMobileKeyboardTest() {
		 try {
			 EnterMobileNumberPage em = new EnterMobileNumberPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("Wait for page load");
			 //Thread.sleep(27000);//for test in between
			/* if(device.equals("android")) {
				 Thread.sleep(3000);
				 System.out.println("in back");
				 cv.clickBackButton();
				 Thread.sleep(3000);
			 }*/
			 em.enterMobileNumberDoneKey("12");
			 em.clickOKButton();
			 Log.addMessage("Clicked Done button in keyboard");
			 Thread.sleep(3000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to click Done button in keyboard");
			 e.printStackTrace();
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="valphone")
	public void valMobileBackTest(String phoneNumber) {
		 try {
			 EnterMobileNumberPage em = new EnterMobileNumberPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("Wait for loading Mobile entry page");
			 Thread.sleep(3000);//to test in between
			 em.clickBackButton();
			 Thread.sleep(3000);
			 cv.clickSubmitButton();
			 Thread.sleep(3000);
			 if(device.equals("android")) {
				 cv.clickOKButton();
			 }
			/* cv.clickResendButton();
			 Thread.sleep(5000);
			 cv.clickOKButton();
			
			 cv.readCodeFromEmailReg("email.address6", "email.password6");//commented for iOS on 19-feb-2021
			
			 if(device.equals("iOS")) {
				Utility.simpleWait(4000);
			 }
			 //CodeVerificationPage cv1 = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 cv.clickSubmitButton(); 
			
			 Log.addMessage("Clicked submit button");
			 Thread.sleep(6000);
			 em.enterMobileNumber(phoneNumber);
			 em.clickSubmitButton();
			 if(device.equals("android")) {
				 em.clickOKButton();
			 }
			 Thread.sleep(5000);*/
		 }catch(Exception e) {
			 Log.addMessage("Failed to click back button");
			 e.printStackTrace();
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="mobile")
	public void valMobileTest(String mobileNum, String titleMsg, String valMessage, String ititleMsg, String iMessage) {
		 try {
			 EnterMobileNumberPage em = new EnterMobileNumberPage((AppiumDriver<MobileElement>) driver);
			 em.valPhoneNumber(mobileNum,titleMsg, valMessage, ititleMsg,iMessage);
			 Log.addMessage("Phone number entered");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter phone number");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter phone number");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vphone")
	public void validMobileTest(String mobileNum) {
		 try {
			// Thread.sleep(20000);
			 EnterMobileNumberPage em = new EnterMobileNumberPage((AppiumDriver<MobileElement>) driver);
			 if(em.checkCountryCodeButton()) {
					
			 }
			 em.enterMobileNumber(mobileNum);
			 em.clickSubmitButton();
			 if(device.equals("android")) {
				 em.clickOKButton();
			 }
			 Log.addMessage("Phone number entered");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter phone number");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter phone number");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="resendPopup")
	public void valMobileResendLimitTest(String rMessage, String irMessage) {
		 try {
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			//Thread.sleep(27000);
			 Thread.sleep(3000);
			 for(int i=0; i<4; i++) {
				 cv.clickResendButton();
				 cv.clickOKButton();
			 }
			 //check the popup verbiage for resend limits
			 //Thread.sleep(5000);//commented for regression 8th August
			 cv.clickResendButton();
			 if(device.equals("iOS")) {
				 cv.verifyResendPopUpVerbiage(irMessage);
			 }else {
				 cv.verifyResendPopUpVerbiage(rMessage);
			 }
			 Log.addMessage("Resend limits set for verify phone number page");
		 }catch(Exception e) {
			 Log.addMessage("Resend limits not set for verify phone number page");
			 e.printStackTrace();
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vmobile")
	public void validMobileResendTest(String firstNm, String lastNm, String email, String mobileNum) {
		try {
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 EnterMobileNumberPage em = new EnterMobileNumberPage((AppiumDriver<MobileElement>) driver); 
			 AccountNamePage an = new AccountNamePage((AppiumDriver<MobileElement>) driver);
			// lp.clickCreateAnAccountButton();//commented to test in between
			 Thread.sleep(5000);
			 Log.addMessage("Clicked create account button");
			 System.out.println("in val main");
			 an.enterFirstName(firstNm);
			 an.enterLastName(lastNm);			
			 an.clickNextButton();
			 Thread.sleep(3000);
			 ee.enterEmail(email);
			 ee.clickSubmitButton();
			 Thread.sleep(2000);
			 if(device.equals("android")) {
				 ee.clickOKButton();
			 }
			// cv.readCode_email_reg("email.address3", "email.password3");
			 cv.readCodeFromEmailReg("email.address3", "email.password3");
			 cv.clickSubmitButton(); 
			 Log.addMessage("Clicked email code submit button");
			 em.enterMobileNumber(mobileNum);
			 em.clickSubmitButton();
			 if(device.equals("android")) {
				 ee.clickOKButton();
			 }
			 Log.addMessage("Email validated");
		}catch(Exception e){
			Log.addMessage("Failed to validate email");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to validate email");
		} 
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void valMobileVerifyKeyboardTest() {
		 try {
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("user login");
			// Thread.sleep(27000);//for testing in between
			 /*cp.login(email, password);
			 cvm.selectMobile();
			 cvm.clickSubmit();
			 Thread.sleep(2000);*/
			 cv.enterPhoneVerifyDoneKey("12","new");
			 cv.clickOKButton();
			 Log.addMessage("Clicked Done button in keyboard");
			 Thread.sleep(3000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to click Done button in keyboard");
			 e.printStackTrace();
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="valphone")
	public void valMobileVerifyBackTest(String phoneNumber) {
		 try {
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 EnterMobileNumberPage em = new EnterMobileNumberPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//to test
			 cv.clickBackButton();
			 Utility.simpleWait(2000);
			 em.enterMobileNumber(phoneNumber);
			 em.clickSubmitButton();
			 if(device.equals("android")) {
				 em.clickOKButton();
			 }
			 Thread.sleep(3000);
			 Log.addMessage("Clicked back button");
		 }catch(Exception e) {
			 Log.addMessage("Failed to click back button");
			 e.printStackTrace();
		 }
	}

	 @SuppressWarnings("unchecked")
	 @Test(dataProvider="mobileVerify")
	 public void valMobilelVerifyTest(String valCode, String titleMsg, String valMessage, String toastMsg, String iTitle, String iMessage, String iEditMsg) {
		 try {
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 cv.valMobileVerificationCode(valCode,titleMsg, valMessage, toastMsg, "new",iTitle,iMessage,iEditMsg);
			 Log.addMessage("Email verification Code entered");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter email verification Code");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter email verification Code");
		 }
	}
	 
	 @SuppressWarnings("unchecked")
	 @Test
	 public void validMobileCodeTest() {
		 try {
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 Thread.sleep(20000);//for testing in between
			 cv.clickResendButton();
			 cv.clickOKButton();
			 Thread.sleep(2000);
			 System.out.println("Wait for reading mobile verification code");
			 cv.readMobileCodeFromEmail("email.address5", "email.password5");
			 cv.clickSubmitButton(); 
			 /* Thread.sleep(15000);
			 cv.enterMobileCode("123456");
			 Thread.sleep(5000);//for editing wo reading from mail for testing purpose
			 cv.clickSubmitButton();*/
			 Log.addMessage("Email verification Code entered");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter email verification Code");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter email verification Code");
		 }
	}
	 
	 @SuppressWarnings("unchecked")
	 @Test
	 public void validPhoneCodeTest() {
		 try {
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("Wait for reading code from email");
			 Thread.sleep(15000);
			// cv.enterMobileCode("123456");
			 cv.readMobileCodeFromEmail("email.address5", "email.password5");
			 cv.clickSubmitButton(); 
			 Thread.sleep(5000);//for editing wo reading from mail for testing purpose
			// cv.clickSubmitButton();
			 Log.addMessage("Email verification Code entered");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter email verification Code");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter email verification Code");
		 }
	}
	 
	//change below code for security questions page
	@SuppressWarnings("unchecked")
	@Test
	public void valSecurityQuestionKeyboardTest() {
		 try {
			 SecurityQuestionsPage eq = new SecurityQuestionsPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for test in between
			 eq.enterAnswer1NextKey();
  			 eq.enterAnswer2NextKey();
  			 eq.enterAnswer3NextKey();
  			 //eq.clickNextButton();
  			 eq.clickOKButton();
			 Log.addMessage("Clicked Done button in keyboard");
			 Thread.sleep(5000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to click Done button in keyboard");
			 e.printStackTrace();
		 }
	}
	 
	@SuppressWarnings("unchecked")
	@Test
	public void valSecurityQuestionBackTest() {
		 try {
			 SecurityQuestionsPage eq = new SecurityQuestionsPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			
			 eq.clickBack();
			 Thread.sleep(3000);
			 cv.clickResendButton();
			 cv.clickOKButton();
			 Thread.sleep(6000);
			 //get the verification code from email
			 cv.readMobileCodeFromEmail("email.address5", "email.password5");
			 cv.clickSubmitButton(); 
			/* Thread.sleep(15000);
			 cv.enterMobileCode("123456");
			 Thread.sleep(5000);//for editing wo reading from mail for testing purpose
			 cv.clickSubmitButton();
			 Thread.sleep(3000);*/
			 Log.addMessage("Resend limits set for verify phone number page");
		 }catch(Exception e) {
			 Log.addMessage("Resend limits not set for verify phone number page");
			 e.printStackTrace();
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="dupQn1")
	public void securityQuestion1DuplicateCheckTest(String qn1, String qn2, String qn3) {
		 try {
			 SecurityQuestionsPage eq = new SecurityQuestionsPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 if(device.equals("iOS")) {
						System.out.println("is not null");
						eq.enterQuestion1();
			}else {
				eq.clickChangeSecurityQn1();
				eq.checkForCountAndDuplicateInQn(qn1,1);
				eq.checkForDuplicateInNextQn(qn1,qn2,qn3,1);
			}
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter security question1");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter security question1");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="dupQn1")
	public void securityQuestion2DuplicateCheckTest(String qn1, String qn2, String qn3) {
		 try {
			 SecurityQuestionsPage eq = new SecurityQuestionsPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 if(device.equals("iOS")) {
						System.out.println("is not null");
						eq.enterQuestion2();
			}else {
				eq.clickChangeSecurityQn2();
				eq.checkForCountAndDuplicateInQn(qn2,1);
				eq.checkForDuplicateInNextQn(qn1,qn2,qn3,2);
			}
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter security question2");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter security question2");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="dupQn1")
	public void securityQuestion3DuplicateCheckTest(String qn1, String qn2, String qn3) {
		 try {
			 SecurityQuestionsPage eq = new SecurityQuestionsPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 if(device.equals("iOS")) {
						System.out.println("is not null");
						eq.enterQuestion3();
			}else {
				eq.clickChangeSecurityQn3();
				eq.checkForCountAndDuplicateInQn(qn3,2);
				eq.checkForDuplicateInNextQn(qn1,qn2,qn3,3);
			}
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter security question2");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter security question2");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vISecQn")
	public void valSecurityQuestionIosTest(String qn1,String ans1,String qn2, String ans2,String qn3, String ans3, String ttlMessage, String valMessage) {
		 try {
			 SecurityQuestionsPage eq = new SecurityQuestionsPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 eq.updateSecurityQuestion(qn1,ans1, qn2,ans2, qn3,ans3, valMessage, ttlMessage,"new");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter security questions");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter security questions");
		 }
	}
	
	 @SuppressWarnings("unchecked")
	 @Test(dataProvider="vSecQn")
	 public void valSecurityQuestionTest(String qn1,String ans1,String qn2, String ans2,String qn3, String ans3, String ttlMessage, String valMessage) {
		 try {
			 SecurityQuestionsPage eq = new SecurityQuestionsPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 eq.updateSecurityQuestion(qn1,ans1, qn2,ans2, qn3,ans3, valMessage, ttlMessage,"new");
			 
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter security questions");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter security questions");
		 }
	 }
	 
	 @SuppressWarnings("unchecked")
	 @Test(dataProvider="vldSecQn")
	 public void validSecurityQuestionTest(String qn1,String ans1,String qn2, String ans2,String qn3, String ans3) {
		 try {
			 SecurityQuestionsPage eq = new SecurityQuestionsPage((AppiumDriver<MobileElement>) driver);
			 Thread.sleep(15000);
			 eq.clickChangeSecurityQn1();
			 eq.selectSecurityQn1(qn1);
			 eq.enterAnswer1(ans1);
			 
			 eq.clickChangeSecurityQn2();
			 eq.selectSecurityQn2(qn2);
			 eq.enterAnswer2(ans2);
			 
			 eq.clickChangeSecurityQn3();
			 eq.selectSecurityQn3(qn3);
			 eq.enterAnswer3(ans3);
			 eq.clickNextButton();
			 Log.addMessage("Entered security questions");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter security questions");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter security questions");
		 }
	 }
	 
	 @SuppressWarnings("unchecked")
	 @Test(dataProvider="vldSecQn")
	 public void validSecurityQuestioniOSTest(String qn1,String ans1,String qn2, String ans2,String qn3, String ans3) {
		 try {
			SecurityQuestionsPage eq = new SecurityQuestionsPage((AppiumDriver<MobileElement>) driver);
			Thread.sleep(15000);
			System.out.println("qn1="+qn1);
			if(qn1!="") {
				System.out.println("is not null");
				eq.enterQuestion1();
				eq.enterAnswer1(ans1);
			}
			System.out.println("qn2="+qn2);
			if(qn2!="") {
				System.out.println("is not null");
				eq.enterQuestion2();
				eq.enterAnswer2(ans2);
			}
			System.out.println("qn3="+qn3);
			if(qn3!="") {
				System.out.println("is not null");
				eq.enterQuestion3();
				eq.enterAnswer3(ans3);
			}
			eq.clickNextButton();
			Log.addMessage("Entered security questions");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter security questions");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter security questions");
		 }
	 }
	
	 
	 @SuppressWarnings("unchecked")
	 @Test
	 public void viewPasswordTest() {
		 try {
			 EnterPasswordPage cp = new EnterPasswordPage((AppiumDriver<MobileElement>) driver);
			 
			 cp.verifyUIPassword();
			 Log.addMessage("Displayed all elements in password page");
		 }catch(Exception e) {
			 Log.addMessage("Failed to display all elements in password page");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to display all elements in password page");
		 }
	}
	 
	 @SuppressWarnings("unchecked")
	 @Test
	 public void valPasswordKeyboardTest() {
		 try {
			 EnterPasswordPage cp = new EnterPasswordPage((AppiumDriver<MobileElement>) driver);
			// Thread.sleep(47000);
			 cp.enterPasswordNextKey("12");
			 Log.addMessage("Clicked keyboard Next button");
			 cp.reEnterPasswordDoneKey("34");
			 Log.addMessage("Clicked keyboard Done button");
			 cp.clickOKButton();
			 Log.addMessage("Clicked keyboard Done button");
		 }catch(Exception e) {
			 Log.addMessage("Failed to click Done button in keyboard");
			 e.printStackTrace();
		 }
	 }
	 
	 @SuppressWarnings("unchecked")
	 @Test
	 public void valPasswordBackTest() {
		 try {
			 EnterPasswordPage cp = new EnterPasswordPage((AppiumDriver<MobileElement>) driver);
			 SecurityQuestionsPage eq = new SecurityQuestionsPage((AppiumDriver<MobileElement>) driver);
			// Thread.sleep(27000);//for testing in between
			 cp.clickBackButton();
			 Thread.sleep(3000);
			 
			 eq.clickNextButton();//valid for iOS create user flowand Android 
			 Log.addMessage("Clicked Back button");
		 }catch(Exception e) {
			 Log.addMessage("Failed to click back button");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to click back button");
		 }
	}
	 
	@SuppressWarnings("unchecked")
	 @Test(dataProvider="ValidatePwd")
	 public void valPasswordTest(String nwPwd,String rePwd, String ttlMessage, String valMessage, String iMessage) {
		 try {
			 EnterPasswordPage cp = new EnterPasswordPage((AppiumDriver<MobileElement>) driver);
			
			 cp.valPassword(nwPwd, rePwd, valMessage, ttlMessage, iMessage);
			 
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter login credentials"); 
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter login credentials");
		 }
	}
	
	@SuppressWarnings("unchecked")
	 @Test(dataProvider="VPwd")
	 public void validPasswordTest(String nwPwd,String rePwd) {
		 try {
			 EnterPasswordPage cp = new EnterPasswordPage((AppiumDriver<MobileElement>) driver);
			
			 cp.enterPassword(nwPwd);
			 cp.reEnterPassword(rePwd);
			 cp.clickSubmitButton();
			 
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter login credentials"); 
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter login credentials");
		 }
	}
	
	//added for iOS create flow check message
	@SuppressWarnings("unchecked")
	@Test(dataProvider="valCreatePopup")
	public void valRegisterSuccessPopupTest(String ttlMessage, String valMessage,String ttliMessage, String valiMessage) {
		 try {
			 EnterPasswordPage cp = new EnterPasswordPage((AppiumDriver<MobileElement>) driver);
			
			 cp.valSuccessPopUp(ttlMessage, valMessage,ttliMessage, valiMessage);
			 
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter login credentials"); 
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter login credentials");
		 }
	}
	
	//added for android create flow check message
	@SuppressWarnings("unchecked")
	@Test(dataProvider="createPopUp")
	public void validCreateSuccessTest(String ttlMessage, String valMessage) {
		 try {
			 EnterPasswordPage cp = new EnterPasswordPage((AppiumDriver<MobileElement>) driver);
			
			 cp.valSuccessSessionPopUp(ttlMessage, valMessage);
			 
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter login credentials"); 
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter login credentials");
		 }
	}
	
	@Test
	public void valWaitTest() {
		 try {
			 Thread.sleep(47000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to Wait");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to Wait");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="login")
	public void valLoginTest(String email, String password, String titleMessage, String errMessage, String iMessage) {
		 try {
			 LoginPage lp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 lp.valLogin(email, password, errMessage, titleMessage,iMessage);
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter login credentials");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter login credentials");
		 }
	}
	 
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vlogin")
	public void valLoginBackTest(String email, String password) {
		 try {
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 //cv.clickBackButton();
			 cp.login(email, password);
			 Log.addMessage("Clicked Back button");
		 }catch(Exception e) {
			 Log.addMessage("Failed to click back button");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to click back button");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vlogin")
	public void valLoginWifiOffTest(String email, String password) {
		 try {
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			
			 //Thread.sleep(27000);
			 cv.clickBackButton();
			 System.out.println("Wait for Wifi Off");
			 Thread.sleep(27000);
			 cp.login(email, password);
			 if(device.equals("android")) {
					cp.clickCancelButton();
			 }else {
				 cp.clickOKButton();
			 }
			 Log.addMessage("Clicked Back button");
		 }catch(Exception e) {
			 Log.addMessage("Failed to click back button");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to click back button");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vlogin")
	public void valLoginBLEOffTest(String email, String password) {
		 try {
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("Wait for BLE Off");
			 Thread.sleep(27000);
			 //cv.clickBackButton();
			 System.out.println("email="+email+", password="+password);
			 cp.login(email, password);
			 Log.addMessage("Clicked Back button");
		 }catch(Exception e) {
			 Log.addMessage("Failed to click back button");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to click back button");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vlogin")
	public void valLoginBLEWifiOffTest(String email, String password) {
		 try {
			 LoginPage lp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("Wait for both BLE and Wifi Off");
			 Thread.sleep(27000);
			 cv.clickBackButton();
			 lp.login(email, password);
			 if(device.equals("android")) {
				 lp.clickCancelButton();
			 }else {
				 lp.clickOKButton();
			 }
			 Thread.sleep(5000);
			 Log.addMessage("Clicked Back button");
		 }catch(Exception e) {
			 Log.addMessage("Failed to login");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to login");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vlogin")
	public void viewMFAPageTest(String email, String password) {
		 try {
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("Wait for Wifi and BLE ON");
			 //Thread.sleep(27000);//for testing in between
			// cp.login(email, password);
			 Thread.sleep(3000);
			 cv.verifyUIMFAPage();
			 Log.addMessage("Displayed all elements in MFA page");
		 }catch(Exception e) {
			 Log.addMessage("Failed to display all elements in MFA page");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to display all elements in MFA page");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="mfapopup")
	public void valNoSelectTest(String expMessage, String iMessage) {
		 try {
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 cv.clickSubmit();
			 if(device.equals("iOS")) {
				 cv.verifyPopUpVerbiage(iMessage);
			 }else {
				 cv.verifyPopUpVerbiage(expMessage);
			 }
			 cv.clickOKButton();
			 Log.addMessage("No option selected condition verified");
		 }catch(Exception e) {
			 Log.addMessage("Failed to verify no option selected condition");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to verify no option selected condition");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vlogin")
	public void emailCodeBackTest(String email, String password) {
		 try {
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 cv.selectEmail();
			 cv.clickSubmit();
			 Thread.sleep(3000);
			 ee.clickBackButton();
			 Thread.sleep(7000);
			 cp.login(email, password);
			 Thread.sleep(5000);
			 ChooseVerificationMethodPage cv1 = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 cv1.selectEmail();
			 cv1.clickSubmit();
			 Log.addMessage("Clicked Back button of email page");
		 }catch(Exception e) {
			 Log.addMessage("Failed to click Back button of email page");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to click Back button of email page");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="emailVerify")
	public void valEmailVerifyCodeEditTest(String valCode, String titleMsg, String valMessage, String toastMsg, String iMessage) {
		 try {
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing
			 cv.valEmailVerificationCode(valCode,titleMsg, valMessage,toastMsg,"edit",iMessage);
			 Log.addMessage("Email verification Code entered");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter email verification Code");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter email verification Code");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void valEmailVerifyKeyboardEditTest() {
		 try {
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 Thread.sleep(27000);//for test in between
			 cv.enterEmailCodeDoneKey("12","edit");
			// cv.clickOKButton();//check for toast message
			 Log.addMessage("Clicked Done button from keyboard");
			 Thread.sleep(5000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to click Done button");
			 e.printStackTrace();
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="resendPopup")
	public void valEmailResendLimitEditTest(String popupMsg, String ipopupMsg) {
		 try {
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 Thread.sleep(3000);
			 for(int i=0; i<4; i++) {
				 cv.clickResendButton();
				 if(device.equals("iOS")) {
					 cv.clickOKButton();
				 }
			 }
			 //check the popup verbiage for resend limits
			 Thread.sleep(5000);
			 //if(cv.checkResendButton()) {
				 cv.clickResendButton();
				// Assert.assertTrue(false,"Resend limits not set");
				 Log.addMessage("Resend limits not set");
			/* }else {
				// Assert.assertTrue(true,"Resend limits set");
				 Log.addMessage("Resend limits set");
			 }*/
			 if(device.equals("iOS")) {
				 cv.verifyResendPopUpVerbiage(ipopupMsg);
			 }else {
				 cv.verifyResendPopUpVerbiage(popupMsg);
			 }
			 
		 }catch(Exception e) {
			 Log.addMessage("Resend limits not set");
			 e.printStackTrace();
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="resendPopup")
	public void valMobileResendLimitEditTest(String popupMsg, String ipopupMsg) {
		 try {
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 Thread.sleep(3000);
			 for(int i=0; i<4; i++) {
				 cv.clickResendButton();
				 if(device.equals("iOS")) {
					 cv.clickOKButton();
				 }
			 }
			 //check the popup verbiage for resend limits
			// Thread.sleep(5000);
			 cv.clickResendButton();
			 if(device.equals("iOS")) {
				 cv.verifyResendPopUpVerbiage(ipopupMsg);
			 }else {
				 cv.verifyResendPopUpVerbiage(popupMsg);
			 }
			
			// cv.clickOKButton();
			 Log.addMessage("Resend limits set");
		 }catch(Exception e) {
			 Log.addMessage("Resend limits not set");
			 e.printStackTrace();
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vlogin")
	public void validLoginEmailTest(String email, String password) {
		 try {
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(30000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(5000);
			 cv.selectEmail();
			 cv.clickSubmit();
			/* System.out.println("wait to retrieve verification code from email");
			 cvp.readCodeFromEmail("email.address3", "email.password3");
			 cvp.clickSubmitButton(); */
			 Log.addMessage("Clicked Back button of email page");
		 }catch(Exception e) {
			 Log.addMessage("Failed to click Back button of email page");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to click Back button of email page");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void validLoginEmailCodeTest() {
		 try {
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(30000);//for testing in between
			
			 System.out.println("wait to retrieve verification code from email");
			 cvp.readCodeFromEmail("email.address3", "email.password3");
			 cvp.clickSubmitButton(); 
			 Log.addMessage("Clicked Back button of email page");
		 }catch(Exception e) {
			 Log.addMessage("Failed to click Back button of email page");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to click Back button of email page");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void validLoginAgainCancelTouchTest() {
		 try {
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			// if(device.contentEquals("iOS")) {
				 cvp.clickNotNowButton();
			 //}
			 Log.addMessage("Clicked not now button ");
		 }catch(Exception e) {
			 Log.addMessage("Failed to click not now button");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to click not now button");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void validLoginCancelTouchTest() {
		 try {
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			// if(device.contentEquals("iOS")) {
				 cvp.clickNotNowButton();
				 //in weiser after login allow this app to access location ok/Cancel will be displayed
			 //}
			 Log.addMessage("Clicked not now button ");
		 }catch(Exception e) {
			 Log.addMessage("Failed to click not now button");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to click not now button");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void logOutWifiOffTest() {
		 try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("Wait for Wifi Off");
			 Thread.sleep(27000);
			 if(device.equals("android")) {
				 ld.clickCancelButton();
			 }else {
				 ld.clickHamburgerButton();
				 Thread.sleep(2000);
				 if(device.equals("android")) {
					mp.clickCancelButton();
				 }else {
					 mp.clickLogoutButton();//added on 29-07-2020 regression
					 mp.clickOKButton();
				 }
			 }
			 Log.addMessage("Internet connection required pop up displayed");
		 }catch(Exception e) {
			 Log.addMessage("Failed to display internet connection required pop up");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to display internet connection required pop up");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void logOutBLEOffTest() {
		 try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("Wait for Wifi ON and BLE Off");
			 //Thread.sleep(27000);
			 ld.clickHamburgerButton();
			 Thread.sleep(2000);
			 mp.clickLogoutButton();
			 if(device.equals("android")) {
				//mp.clickCancelButton();
				 mp.clickOKButton();
			 }else {
				 mp.clickOKButton();
			 }
			 Log.addMessage("Logout confirmation pop up displayed");
		 }catch(Exception e) {
			 Log.addMessage("Failed to display logout confirmation pop up");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to display logout confirmation pop up");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vdisablelogin")
	public void validDisableAccountLoginTest(String email, String password) {
		 try {
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("user login");
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			// Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(5000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 System.out.println("wait to retrieve verification code from email");
			 cvp.readCodeFromEmail("email.address3", "email.password3");
			 cvp.clickSubmitButton(); 
			 Log.addMessage("Clicked Back button");
		 }catch(Exception e) {
			 Log.addMessage("Failed to click back button");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to click back button");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void validCreateDeletedAccountTest() throws InterruptedException {
		try {
			LoginPage lp = new LoginPage((AppiumDriver<MobileElement>) driver);
			AccountNamePage an = new AccountNamePage((AppiumDriver<MobileElement>) driver);
			
			lp.clickCreateAnAccountButton();
			System.out.println("after refresh");
			Thread.sleep(3000);
			an.verifyUIAccountName();
			Thread.sleep(3000);
			Log.addMessage("All elements displayed in the account name page");
		}catch(Exception e) {
			Log.addMessage("Failed to display elements in account name page");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display elements in account name page");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="validDelAcntName")
	public void validDeletedAccountNameTest(String firstname,String lastname) {
		try {
			AccountNamePage an = new AccountNamePage((AppiumDriver<MobileElement>) driver);
			//Thread.sleep(27000);//for test in between
			an.enterFirstName(firstname);
			an.enterLastName(lastname);			
			an.clickNextButton();
			System.out.println("after val return");
			Log.addMessage("Account name entered");
		}catch(Exception e){
			Log.addMessage("Failed to enter account name");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to enter account name");
		} 
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vemail")
	public void validDeletedEmailTest(String email) {
		try {
			EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			System.out.println("in val main");
			ee.enterEmail(email);
			ee.clickSubmitButton();
			if(device.equals("android")) {
				Thread.sleep(3000);
				ee.clickOKButton();
			}
			Log.addMessage("Email validated");
		}catch(Exception e){
			Log.addMessage("Failed to validate email");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to validate email");
		} 
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vurl")
	public void createAcntEmailHyperLinksTest(String url1, String url2,String url3,String url4,String url5,String url6, String url7, String url8) {
		 try {
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 Utility.simpleWait(8000);
			 cv.readHyperLinksFromEmailReg("email.address3", "email.password3", url1, url2, url3, url4, url5, url6, url7, url8);
			 if(device.equals("iOS")) {
				Utility.simpleWait(10000);
			 }
			 Log.addMessage("Verified hyperlinks in create account");
		 }catch(Exception e) {
			 Log.addMessage("Failed to verify hyperlinks in create account");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to verify  hyperlinks in create account");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void deletedAccountBackTest() {
		 try {
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 Utility.simpleWait(8000);
			 cv.clickBackButton();
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("in val main");
			 Utility.simpleWait(2000);
			 ee.clickSubmitButton();
			 if(device.equals("android")) {
				 ee.clickOKButton();
			 }
			 Log.addMessage("Email validated");
		 }catch(Exception e) {
			 Log.addMessage("Failed to verify hyperlinks in create account");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to verify  hyperlinks in create account");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="emailCntnt")
	public void createAccountEmailContentTest(String emailText, String frmAdrs) {
		 try {
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 Thread.sleep(5000);
			 System.out.println("wait to retrieve verification code from email");
			 cvp.readContentFromEmail("email.address3", "email.password3",emailText,frmAdrs);
			 //cvp.clickSubmitButton();
			 Log.addMessage("Entered valid email verification code");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter valid email verification code.");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter valid email verification code.");
		 }
			
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void deletedAccountBackAgnTest() {
		 try {
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 Utility.simpleWait(8000);
			 cv.clickBackButton();
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("in val main");
			 Utility.simpleWait(2000);
			 ee.clickSubmitButton();
			 if(device.equals("android")) {
				 ee.clickOKButton();
			 }
			 Log.addMessage("Email validated");
		 }catch(Exception e) {
			 Log.addMessage("Failed to verify hyperlinks in create account");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to verify  hyperlinks in create account");
		 }
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void validDeletedEmailCodeTest() {
		 try {
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 Utility.simpleWait(8000);
			 cv.readCodeFromEmailReg("email.address3", "email.password3");
			 cv.clickSubmitButton(); 
			 if(device.equals("iOS")) {
				Utility.simpleWait(10000);
			 }
			 Log.addMessage("Clicked email code submit button");
		 }catch(Exception e) {
			 Log.addMessage("Failed to verify email verification code");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to verify email verification code");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vphone")
	public void validDeletedPhNumberTest(String mobileNum) {
		 try {
			 EnterMobileNumberPage em = new EnterMobileNumberPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("in valid mobile");
			 em.enterMobileNumber(mobileNum);
			 em.clickSubmitButton();
			 if(device.contentEquals("android")) {
				 em.clickOKButton();
			 }
			 Log.addMessage("Phone number entered");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter phone number");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter phone number");
		 }
	}
	
	
	 @SuppressWarnings("unchecked")
	 @Test
	 public void validDeletedPhNumberCodeTest() {
		 try {
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(2000);//for testing in between
			 System.out.println("Wait for reading mobile verification code");
			 cv.readMobileCodeFromEmail("email.address5", "email.password5");
			 cv.clickSubmitButton(); 
			 Log.addMessage("Email verification Code entered");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter email verification Code");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter email verification Code");
		 }
	}
	 
	 @SuppressWarnings("unchecked")
	 @Test(dataProvider="valISecQn")
	 public void valDeletedPhReUseSecurityQuestionIosTest(String qn1,String ans1,String qn2, String ans2,String qn3, String ans3) {
		 try {
			 SecurityQuestionsPage eq = new SecurityQuestionsPage((AppiumDriver<MobileElement>) driver);
			 Thread.sleep(7000);//for testing in between
			 eq.updateValidSecurityQuestion(qn1,ans1, qn2,ans2, qn3,ans3);
			 
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter security questions");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter security questions");
		 }
	 }
	 
	 @SuppressWarnings("unchecked")
	 @Test(dataProvider="valSecQn")
	 public void valDeletedPhReUseSecurityQuestionTest(String qn1,String ans1,String qn2, String ans2,String qn3, String ans3) {
		 try {
			 SecurityQuestionsPage eq = new SecurityQuestionsPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 eq.updateValidSecurityQuestion(qn1,ans1, qn2,ans2, qn3,ans3);
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter security questions");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter security questions");
		 }
	 }
	 
	 @SuppressWarnings("unchecked")
	 @Test(dataProvider="ValPwd")
	 public void validDeletedPasswordTest(String nwPwd,String rePwd) {
		 try {
			 EnterPasswordPage cp = new EnterPasswordPage((AppiumDriver<MobileElement>) driver);
			 cp.enterPassword(nwPwd);
			 cp.reEnterPassword(rePwd);
			 cp.clickSubmitButton();
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter login credentials"); 
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter login credentials");
		 }
	}
	 
	//added for iOS create flow check message
	@SuppressWarnings("unchecked")
	@Test(dataProvider="valCreatePopup")
	public void valDelAcntRegisterSuccessTest(String ttlMessage, String valMessage,String ttliMessage, String valiMessage) {
		 try {
			 EnterPasswordPage cp = new EnterPasswordPage((AppiumDriver<MobileElement>) driver);
			
			 cp.valSuccessPopUp(ttlMessage, valMessage,ttliMessage, valiMessage);
			 
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter login credentials"); 
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter login credentials");
		 }
	} 
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vlogin")
	public void deletedAcntCrtdLoginTest(String email, String password) {
		 try {
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("user login");
			 cp.login(email, password);
			 Log.addMessage("Clicked login button");
			 Thread.sleep(5000);
			 ChooseVerificationMethodPage cv1 = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 cv1.selectEmail();
			 cv1.clickSubmit();
			 Log.addMessage("Selected Email option");
		 }catch(Exception e) {
			 Log.addMessage("Failed to click login button");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to click login button");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vurl")
	public void deletedAcntLoginEmailHyperLinksTest(String url1, String url2,String url3,String url4,String url5,String url6, String url7, String url8) {
		 try {
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 Utility.simpleWait(10000);//tested for iOS
			 cv.readHyperLinksFromEmailReg("email.address3", "email.password3", url1, url2, url3, url4, url5, url6, url7, url8);
			 if(device.equals("iOS")) {
				Utility.simpleWait(10000);
			 }
			 Log.addMessage("Verified hyperlinks in create account");
		 }catch(Exception e) {
			 Log.addMessage("Failed to verify hyperlinks in create account");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to verify  hyperlinks in create account");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void deletedAccountLoginBackTest() {
		 try {
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 Utility.simpleWait(8000);
			 cv.clickBackButton();
			 Log.addMessage("Clicked back button");
		 }catch(Exception e) {
			 Log.addMessage("Failed to verify hyperlinks in create account");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to verify  hyperlinks in create account");
		 }
	}
	    
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vlogin")
	public void deletedAcntCrtdLoginAgnTest(String email, String password) {
		 try {
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("user login");
			 cp.login(email, password);
			 Log.addMessage("Clicked login button");
			 Thread.sleep(5000);
			 ChooseVerificationMethodPage cv1 = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 cv1.selectEmail();
			 cv1.clickSubmit();
			 Log.addMessage("Selected Email option");
		 }catch(Exception e) {
			 Log.addMessage("Failed to click login button");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to click login button");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="emailCntnt")
	public void deletedAcntCrtdEmailContentTest(String emailText, String frmAdrs) {
		 try {
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 Thread.sleep(5000);
			 System.out.println("wait to retrieve verification code from email");
			 cvp.readContentFromEmail("email.address3", "email.password3",emailText,frmAdrs);
			 //cvp.clickSubmitButton();
			 Log.addMessage("Entered valid email verification code");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter valid email verification code.");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter valid email verification code.");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void deletedAccountLoginBackAgainTest() {
		 try {
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 Utility.simpleWait(8000);
			 cv.clickBackButton();
			 Log.addMessage("Clicked back button");
		 }catch(Exception e) {
			 Log.addMessage("Failed to verify hyperlinks in create account");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to verify  hyperlinks in create account");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="rcvrLink")
	public void forgotPwdLoginTest(String email, String qn1, String secAns, String qnios, String ansios) {
		 try {
			 LoginPage lp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 SecurityQuestionsPage eq = new SecurityQuestionsPage((AppiumDriver<MobileElement>) driver);
			 Thread.sleep(3000);
			 ChooseVerificationMethodPage cv1= new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			
			 lp.clickForgotPasswordButton();
			 Thread.sleep(5000);
			 ee.enterRcvrEmail(email);
			 ee.clickSubmitButton();
			 Thread.sleep(2000);
			 if(device.equals("android")) {
 				 eq.validSecurityQuestion(qn1,secAns);
 			 }else {
 				eq.validSecurityQuestion(qnios,ansios);
 			 }
			 cv1.selectEmail();
			 cv1.clickSubmit();
			 Thread.sleep(3000);
			 Log.addMessage("Selected email option");
		 }catch(Exception e) {
			 Log.addMessage("Failed to select email option");
			 e.printStackTrace();
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vurl")
	public void forgotPwdEmailHyperLinksTest(String url1, String url2,String url3,String url4,String url5,String url6, String url7, String url8) {
		 try {
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 Utility.simpleWait(10000);//tested for iOS
			 cv.readHyperLinksFromEmailReg("email.address3", "email.password3", url1, url2, url3, url4, url5, url6, url7, url8);
			 if(device.equals("iOS")) {
				Utility.simpleWait(10000);
			 }
			 Log.addMessage("Verified hyperlinks in create account");
		 }catch(Exception e) {
			 Log.addMessage("Failed to verify hyperlinks in create account");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to verify  hyperlinks in create account");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void forgotPwdNavBackTest() {
		 try {
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cv1= new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 Utility.simpleWait(8000);
			 cv.clickBackButton();
			 Log.addMessage("Clicked back button");
			 Utility.simpleWait(2000);
			 cv1.clickSubmit();
		 }catch(Exception e) {
			 Log.addMessage("Failed to verify hyperlinks in create account");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to verify  hyperlinks in create account");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="emailCntntChPass")
	public void forgotPwdEmailCntntTest(String emailiText, String frmAdrs, String emailText) {
		 try {
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 Thread.sleep(5000);
			 System.out.println("wait to retrieve verification code from email");
			 if(device.equals("android")) {
				 cvp.readContentFromEmail("email.address3", "email.password3",emailText,frmAdrs);
			 }else {
				 cvp.readContentFromEmail("email.address3", "email.password3",emailiText,frmAdrs);
			 }
			 //cvp.clickSubmitButton();
			 Log.addMessage("Entered valid email verification code");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter valid email verification code.");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter valid email verification code.");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void forgotPwdNavBackAgnTest() {
		 try {
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 Utility.simpleWait(5000);
			 System.out.println("wait to retrieve verification code from email");
			 cvp.clickBackButton();
			 Utility.simpleWait(2000);
			 cvp.clickSubmitButton();
			 Log.addMessage("Entered valid email verification code");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter valid email verification code.");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter valid email verification code.");
		 }
	}
	
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="validChangePwd")
	public void forgotPwdChangeTest(String vCode, String nwPwd, String reNewPwd) {
		 try {
			 ForgotPasswordPage fp = new ForgotPasswordPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 Thread.sleep(7000);
			//get the verification code from email
			 System.out.println("Wait for retrieving verification code from email");
			 cv.readEmailCodeFromRcvrEmail("email.address3", "email.password3");
			 fp.changePassword(nwPwd, reNewPwd);
			 Thread.sleep(2000);
			 
			 if(device.equals("iOS")) {
				 fp.clickReturnLoginButton();
			 }else {
				 fp.clickOKButton();
			 }
			 LoginPage lp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 lp.checkLoginButton();
			 
			 Log.addMessage("Password updated");
		 }catch(Exception e) {
			 Log.addMessage("Failed to change password");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to change password");
		 }
	}

	@SuppressWarnings("unchecked")
	@Test(dataProvider="emailCntntChange")
	public void forgotPwdVerifyEmailContentTest(String emailText, String frmAdrs) {
		 try {
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 Thread.sleep(10000);
			 System.out.println("wait to retrieve verification code from email");
			 cvp.readContentFromEmailChange("email.address3", "email.password3",emailText,frmAdrs);
			 //cvp.clickSubmitButton();
			 Log.addMessage("Entered valid email verification code");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter valid email verification code.");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter valid email verification code.");
		 }
			
	}
	 
	@SuppressWarnings("unchecked")
	@Test
	public void validPhReUseCreateAccountTest() throws InterruptedException {
		try {
			LoginPage lp = new LoginPage((AppiumDriver<MobileElement>) driver);
			AccountNamePage an = new AccountNamePage((AppiumDriver<MobileElement>) driver);
			Utility.simpleWait(3000);
			lp.clickCreateAnAccountButton();
			System.out.println("after refresh");
			Thread.sleep(3000);
			an.verifyUIAccountName();
			Thread.sleep(3000);
			Log.addMessage("All elements displayed in the account name page");
		}catch(Exception e) {
			Log.addMessage("Failed to display elements in account name page");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display elements in account name page");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="validAcntName")
	public void validPhReUseAccountNameTest(String firstname,String lastname) {
		try {
			AccountNamePage an = new AccountNamePage((AppiumDriver<MobileElement>) driver);
			//Thread.sleep(27000);//for test in between
			an.enterFirstName(firstname);
			an.enterLastName(lastname);			
			an.clickNextButton();
			System.out.println("after val return");
			Log.addMessage("Account name entered");
		}catch(Exception e){
			Log.addMessage("Failed to enter account name");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to enter account name");
		} 
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="phvalidemail")
	public void validPhReUseEmailTest(String email) {
		try {
			EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			System.out.println("in val main");
			ee.enterEmail(email);
			ee.clickSubmitButton();
			if(device.equals("android")) {
				ee.clickOKButton();
			}
			Log.addMessage("Email validated");
		}catch(Exception e){
			Log.addMessage("Failed to validate email");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to validate email");
		} 
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void validPhReUseEmailCodeTest() {
		 try {
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 Utility.simpleWait(8000);
			 cv.readCodeFromEmailReg("email.address6", "email.password6");
			 cv.clickSubmitButton(); 
			 if(device.equals("iOS")) {
				Utility.simpleWait(10000);
			 }else {
				 
			 }
			 Log.addMessage("Clicked email code submit button");
		 }catch(Exception e) {
			 Log.addMessage("Failed to verify email verification code");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to verify email verification code");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vphone")
	public void validPhNumberReUseTest(String mobileNum) {
		 try {
			 EnterMobileNumberPage em = new EnterMobileNumberPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("in valid mobile");
			 Utility.simpleWait(5000);
			 em.enterMobileNumber(mobileNum);
			 em.clickSubmitButton();
			 if(device.equals("android")) {
				 em.clickOKButton();
			 }
			 Log.addMessage("Phone number entered");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter phone number");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter phone number");
		 }
	}
	
	
	 @SuppressWarnings("unchecked")
	 @Test
	 public void validPhNumberReUseCodeTest() {
		 try {
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(2000);//for testing in between
			 System.out.println("Wait for reading mobile verification code");
			 cv.readMobileCodeFromEmail("email.address5", "email.password5");
			 cv.clickSubmitButton(); 
			 Log.addMessage("Email verification Code entered");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter email verification Code");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter email verification Code");
		 }
	}
	 
	 @SuppressWarnings("unchecked")
	 @Test(dataProvider="valISecQn")
	 public void valPhReUseSecurityQuestionIosTest(String qn1,String ans1,String qn2, String ans2,String qn3, String ans3) {
		 try {
			 SecurityQuestionsPage eq = new SecurityQuestionsPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 eq.updateValidSecurityQuestion(qn1,ans1, qn2,ans2, qn3,ans3);
			 
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter security questions");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter security questions");
		 }
	 }
	 
	 @SuppressWarnings("unchecked")
	 @Test(dataProvider="valSecQn")
	 public void valPhReUseSecurityQuestionTest(String qn1,String ans1,String qn2, String ans2,String qn3, String ans3) {
		 try {
			 SecurityQuestionsPage eq = new SecurityQuestionsPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 eq.updateValidSecurityQuestion(qn1,ans1, qn2,ans2, qn3,ans3);
			 
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter security questions");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter security questions");
		 }
	 }
	 
	 @SuppressWarnings("unchecked")
	 @Test(dataProvider="valSecQn")
	 public void valSecurityQuestionPhUseTest(String qn1,String ans1,String qn2, String ans2,String qn3, String ans3) {
		 try {
			 SecurityQuestionsPage eq = new SecurityQuestionsPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 eq.updateValidSecurityQuestion(qn1,ans1, qn2,ans2, qn3,ans3);
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter security questions");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter security questions");
		 }
	 }
	 
	 @SuppressWarnings("unchecked")
	 @Test(dataProvider="ValPwd")
	 public void validPhReUsePasswordTest(String nwPwd,String rePwd) {
		 try {
			 EnterPasswordPage cp = new EnterPasswordPage((AppiumDriver<MobileElement>) driver);
			 cp.enterPassword(nwPwd);
			 cp.reEnterPassword(rePwd);
			 cp.clickSubmitButton();
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter login credentials"); 
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter login credentials");
		 }
	}
	 
	//added for iOS create flow check message
	@SuppressWarnings("unchecked")
	@Test(dataProvider="valCreatePopup")
	public void valRegisterSuccessPhReUsePopupTest(String ttlMessage, String valMessage,String ttliMessage, String valiMessage) {
		 try {
			 EnterPasswordPage cp = new EnterPasswordPage((AppiumDriver<MobileElement>) driver);
			
			 cp.valSuccessPopUp(ttlMessage, valMessage,ttliMessage, valiMessage);
			 
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter login credentials"); 
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter login credentials");
		 }
	}
	
	 @Test(dataProvider="emailCntntPhReuse")
	 public void phUsedOwnerEmailContentTest(String emailText, String frmAdrs) {
		 try {
			 EmailVerificationPage ep = new EmailVerificationPage(driver);
			 Thread.sleep(5000);
			 System.out.println("wait to retrieve verification code from email");
			 ep.readContentFromPhReUseEmail("email.address3", "email.password3",emailText,frmAdrs);
			 Log.addMessage("Entered valid email verification code");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter valid email verification code.");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter valid email verification code.");
		 }
	 }
	
	@SuppressWarnings("unchecked")
	@Test
	public void disableAcntRcvrPwdEmailPageTest() {
		 try {
			 LoginPage lp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//to test in between
			 Thread.sleep(5000);
			 lp.clickForgotPasswordButton();
			 Log.addMessage("Clicked forgot password");
		 }catch(Exception e) {
			 Log.addMessage("Failed to click forgot password");
			 e.printStackTrace();
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vdisableemail")
	public void disabledValidEmailPageTest(String email) {
		 try {
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 Thread.sleep(5000);
			 ee.enterRcvrEmail(email);
			 ee.clickSubmitButton();
			
		 }catch(Exception e) {
			 Log.addMessage("Failed to validate email field");
			 e.printStackTrace();
		 }
	}
	
	@SuppressWarnings("unchecked")
 	@Test(dataProvider="validRcvrSecQn")
 	public void disableRcvrPwdSecurityQnTest(String qn1,String ans1, String qnios,String ansios) {
 		 try {
 			 SecurityQuestionsPage eq = new SecurityQuestionsPage((AppiumDriver<MobileElement>) driver);
 			 if(device.equals("android")) {
 				 eq.validSecurityQuestion(qn1,ans1);
 			 }else {
 				eq.validSecurityQuestion(qnios,ansios);
 			 }
 		 }catch(Exception e) {
 			 Log.addMessage("Failed to enter security questions");
 			 e.printStackTrace();
 			 Assert.assertTrue(false, "Failed to enter security questions");
 		 }
 	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void disableRcvrPwdMFAPageTest() {
		 try {
			 ChooseVerificationMethodPage cv1= new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 cv1.selectEmail();
			 cv1.clickSubmit();
			 Thread.sleep(3000);
			 Log.addMessage("Clicked Back button");
		 }catch(Exception e) {
			 Log.addMessage("Failed to display all elements in MFA page");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to display all elements in MFA page");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="validChangePwd")
	public void disableValidPasswordChangeTest(String vCode, String nwPwd, String reNewPwd) {
		 try {
			 ForgotPasswordPage fp = new ForgotPasswordPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 Thread.sleep(7000);
			//get the verification code from email
			 System.out.println("Wait for retrieving verification code from email");
			 cv.readEmailCodeFromRcvrEmail("email.address7", "email.password7");
			 fp.changePassword(nwPwd, reNewPwd);
			 Thread.sleep(2000);
			 
			 if(device.equals("iOS")) {
				 fp.clickReturnLoginButton();
			 }else {
				 fp.clickOKButton();
			 }
			 LoginPage lp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 lp.checkLoginButton();
			 
			 Log.addMessage("Password updated");
		 }catch(Exception e) {
			 Log.addMessage("Failed to change password");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to change password");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vrcvrdisablelogin")
	public void reLoginAfterRecoverPasswordDisableTest(String email, String password) {
		 try {
			 LoginPage lp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 
			 System.out.println("user login");
			// Thread.sleep(27000);//for testing in between
			 lp.login(email, password);
			 Thread.sleep(10000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 cp.readCodeFromEmail("email.address7", "email.password7");
			 cp.clickSubmitButton(); 
			 Thread.sleep(2000);
			 Log.addMessage("Logged in after password recovery");
		 }catch(Exception e) {
			 Log.addMessage("Failed to log in after recover password");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to log in after recover password");
		 }
	}
	
	 @SuppressWarnings("unchecked")
     @Test
   	 public void validDsblRcvrLoginCanTouchTest() {
   		 try {
   			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
   			// if(device.contentEquals("iOS")) {
   				 cvp.clickNotNowButton();
   			 //}
   			 Log.addMessage("Clicked not now button ");
   		 }catch(Exception e) {
   			 Log.addMessage("Failed to click not now button");
   			 e.printStackTrace();
   			 Assert.assertTrue(false, "Failed to click not now button");
   		 }
   	 }
	
	 @SuppressWarnings("unchecked")
	 @Test(dataProvider="disableLoginPopUp")
	 public void disableAcntLogInPopupTest(String titleMsg, String valMessage) {
		 try {
			 EnterPasswordPage ep = new EnterPasswordPage((AppiumDriver<MobileElement>) driver);
			 Thread.sleep(10000);
			 ep.valDisblSuccessSessionPopUp(titleMsg,valMessage);
			 Thread.sleep(2000);
			 Log.addMessage("Unable to login to deleted account. Pop up verbiage verified");
		 }catch(Exception e) {
			 Log.addMessage("Failed to verify deleted account pop up");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to verify deleted account pop up");
		 }
	 }
	
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vchlogin")
	public void valPhUsedLoginTest(String email, String password) {
		 try {
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("user login");
			// Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Log.addMessage("Clicked login button");
		 }catch(Exception e) {
			 Log.addMessage("Failed to click login button");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to click login button");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void viewMFAPagePhUseTest() {
		 try {
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 Thread.sleep(3000);
			 if(cv.checkMFAPageMobileTest()) {
				 cv.viewMFAPagePhUseTest();
				 Log.addMessage("Displayed all elements in MFA page");
			 }else {
				 Assert.assertTrue(false, "Mobile option displayed in MFA page");
				 Log.addMessage("Mobile option displayed in MFA page");
			 }
		 }catch(Exception e) {
			 Log.addMessage("Failed to display all elements in MFA page");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to display all elements in MFA page");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="mfapopup")
	public void valNoSelectPhUseTest(String expMessage, String iMessage) {
		 try {
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 cv.clickSubmit();
			 if(device.equals("iOS")) {
				 cv.verifyPopUpVerbiage(iMessage);
			 }else {
				 cv.verifyPopUpVerbiage(expMessage);
			 }
			 cv.clickOKButton();
			 Log.addMessage("No option selected condition verified");
		 }catch(Exception e) {
			 Log.addMessage("Failed to verify no option selected condition");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to verify no option selected condition");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vchlogin")
	public void emailCodePhUseTest(String email, String password) {
		 try {
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 cv.selectEmail();
			 cv.clickSubmit();
			 Thread.sleep(3000);
			 ee.clickBackButton();
			 Thread.sleep(7000);
			 cp.login(email, password);
			 Thread.sleep(5000);
			 ChooseVerificationMethodPage cv1 = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 cv1.selectEmail();
			 cv1.clickSubmit();
			 Log.addMessage("Clicked Back button of email page");
		 }catch(Exception e) {
			 Log.addMessage("Failed to click Back button of email page");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to click Back button of email page");
		 }
	}
	
	 @SuppressWarnings("unchecked")
	 @Test(dataProvider="vurl")
	 public void disableAcntEmailHyperLinksTest(String url1, String url2,String url3,String url4,String url5,String url6, String url7, String url8) {
		 try {
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 Utility.simpleWait(10000);//tested for iOS
			 cv.readHyperLinksFromEmailReg("email.address3", "email.password3", url1, url2, url3, url4, url5, url6, url7, url8);
			 if(device.equals("iOS")) {
				Utility.simpleWait(10000);
			 }
			 Log.addMessage("Verified hyperlinks in create account");
		 }catch(Exception e) {
			 Log.addMessage("Failed to verify hyperlinks in create account");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to verify  hyperlinks in create account");
		 }
	 }
	 
	 @SuppressWarnings("unchecked")
		@Test(dataProvider="vchlogin")
		public void emailCodeBackAgnPhUseTest(String email, String password) {
			 try {
				 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
				 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
				 //Thread.sleep(27000);//for testing in between
				
				 Thread.sleep(3000);
				 ee.clickBackButton();
				 Thread.sleep(7000);
				 cp.login(email, password);
				 Thread.sleep(5000);
				 ChooseVerificationMethodPage cv1 = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
				 cv1.selectEmail();
				 cv1.clickSubmit();
				 Log.addMessage("Clicked Back button of email page");
			 }catch(Exception e) {
				 Log.addMessage("Failed to click Back button of email page");
				 e.printStackTrace();
				 Assert.assertTrue(false, "Failed to click Back button of email page");
			 }
		}
	 
	 @SuppressWarnings("unchecked")
	 @Test(dataProvider="emailCntnt")
	 public void phUsedEmailContentTest(String emailText, String frmAdrs) {
		 try {
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 Thread.sleep(5000);
			 System.out.println("wait to retrieve verification code from email");
			 cvp.readContentFromEmail("email.address3", "email.password3",emailText,frmAdrs);
			 //cvp.clickSubmitButton();
			 Log.addMessage("Entered valid email verification code");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter valid email verification code.");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter valid email verification code.");
		 }
	 }
	 
	@SuppressWarnings("unchecked")
	@Test(dataProvider="email")
	public void valEmailPhUseTest(String email, String titleMsg, String errMessage, String iMessage) {
		try {
			EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			//Thread.sleep(1000);
			System.out.println("in val main");
			ee.valEmail(email, titleMsg, errMessage, iMessage);
			//Thread.sleep(3000);
			Log.addMessage("Email validated");
		}catch(Exception e){
			Log.addMessage("Failed to validate email");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to validate email");
		} 
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="emailVerify")
	public void valEmailVerifyCodePhUseTest(String valCode, String titleMsg, String valMessage, String toastMsg, String iMessage) {
		 try {
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 cv.valEmailVerificationCode(valCode,titleMsg, valMessage, toastMsg,"edit",iMessage);
			 Log.addMessage("Email verification Code entered");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter email verification Code");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter email verification Code");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void validEmailCodePhUseTest() {
		 try {
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 Thread.sleep(5000);
			 cvp.clickResendButton();
			 if(device.equals("iOS")) {
				 cvp.clickOKButton();//commented for android on 03-03-21
			 }
			 System.out.println("wait to retrieve verification code from email");
			 cvp.readCodeFromEmail("email.address3", "email.password3");
			 cvp.clickSubmitButton();
			 Log.addMessage("Entered valid email verification code");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter valid email verification code.");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter valid email verification code.");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void validLoginCancelTouchPhUseTest() {
		 try {
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			// if(device.contentEquals("iOS")) {
				 cvp.clickNotNowButton();
			 //}
			 Log.addMessage("Clicked not now button ");
		 }catch(Exception e) {
			 Log.addMessage("Failed to click not now button");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to click not now button");
		 }
	}
	
	
	@SuppressWarnings("unchecked")
	 @Test
	 public void validMobileCodePhUseTest() {
		 try {
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(2000);//for testing in between
			 cv.clickResendButton();
			 cv.clickOKButton();
			 System.out.println("Wait for reading mobile verification code");
			 cv.readMobileCodeFromEmail("email.address5", "email.password5");
			 cv.clickSubmitButton(); 
			 /* Thread.sleep(15000);
			 cv.enterMobileCode("123456");
			 Thread.sleep(5000);//for editing wo reading from mail for testing purpose
			 cv.clickSubmitButton();*/
			 Log.addMessage("Email verification Code entered");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter email verification Code");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter email verification Code");
		 }
	}
	
	 @SuppressWarnings("unchecked")
     @Test
   	 public void validPhUsedLoginCanTouchTest() {
   		 try {
   			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
   			// if(device.contentEquals("iOS")) {
   				 cvp.clickNotNowButton();
   			 //}
   			 Log.addMessage("Clicked not now button ");
   		 }catch(Exception e) {
   			 Log.addMessage("Failed to click not now button");
   			 e.printStackTrace();
   			 Assert.assertTrue(false, "Failed to click not now button");
   		 }
   	 }
	 
	@SuppressWarnings("unchecked")
	@Test
	public void navToAcntSettingsPageTest() {
		 try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("user login");
			 ld.clickHamburgerButton();
			 mp.clickAccountSettingsButton();
			 Thread.sleep(2000);
			 Log.addMessage("Logged in after password recovery");
		 }catch(Exception e) {
			 Log.addMessage("Failed to log in after recover password");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to log in after recover password");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="delAcPopUp")
	public void valDeletePhReusedAccountTest(String titleMsg, String valMsg, String iTitle, String iMsg) {
		 try {
			 AccountSettingsPage as = new AccountSettingsPage((AppiumDriver<MobileElement>) driver);
			 Thread.sleep(5000);
			 Thread.sleep(2000);
			 as.clickDeleteButton();
			 if(device.equals("iOS")) {
				 as.verifyDeletePopUpVerbiage(iTitle,iMsg);
			 }else {
				 as.verifyDeletePopUpVerbiage(titleMsg,valMsg);
			 }
			 as.clickCancelButton();
			 Thread.sleep(2000);
			 as.clickDeleteButton();
			 Thread.sleep(3000);
			 if(device.equals("iOS")) {
				 as.confirmDelete();
				 Thread.sleep(7000);//check again in iOS increased sleep from5 to 7sec
				 as.clickOKButton();
				 //check if 1 more account disabled/logged out pop up is displayed
			 }else {
				 as.clickOKButton();
				 Thread.sleep(5000);
				 as.clickOKButton();//deleted pop up ok button
			 }
			 Thread.sleep(7000);
			 //check for success pop up verbiage
			 Log.addMessage("Account deleted");
		 }catch(Exception e) {
			 Log.addMessage("Failed to delete account");
			 e.printStackTrace();
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vlogin")
	public void valOldAcntLoginTest(String email, String password) {
		 try {
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("user login");
			 cp.login(email, password);
			 Log.addMessage("Clicked login button");
			 Thread.sleep(5000);
			 ChooseVerificationMethodPage cv1 = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 cv1.selectEmail();
			 cv1.clickSubmit();
			 Log.addMessage("Selected Email option");
		 }catch(Exception e) {
			 Log.addMessage("Failed to click login button");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to click login button");
		 }
	}
	
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="mobile")
	public void valMobilePhUseTest(String mobileNum, String titleMsg, String valMessage, String ititleMsg, String iMessage) {
		 try {
			 EnterMobileNumberPage em = new EnterMobileNumberPage((AppiumDriver<MobileElement>) driver);
			 em.valPhoneNumber(mobileNum,titleMsg, valMessage, ititleMsg,iMessage);
			 Log.addMessage("Phone number entered");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter phone number");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter phone number");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vphone")
	public void validMobilePhUseTest(String mobileNum) {
		 try {
			 EnterMobileNumberPage em = new EnterMobileNumberPage((AppiumDriver<MobileElement>) driver);
			 if(device.equals("android")) {
				 Thread.sleep(3000);
				 System.out.println("in back");
				 em.clickBackButton();
				 Thread.sleep(3000);
			 }
			 em.enterMobileNumber(mobileNum);
			 em.clickSubmitButton();
			 //if(device.equals("android")) {//commented on 20 Apr 21
				 em.clickOKButton();
			// }
			 Log.addMessage("Phone number entered");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter phone number");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter phone number");
		 }
	}
	
	@SuppressWarnings("unchecked")
	 @Test(dataProvider="mobileVerify")
	 public void valMobilelVerifyEditPhUseTest(String valCode, String titleMsg, String valMessage, String toastMsg, String iTitle, String iMessage, String iEditMsg) {
		 try {
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 cv.valMobileVerificationCode(valCode,titleMsg, valMessage, toastMsg, "new", iTitle, iMessage,iEditMsg);
			 Log.addMessage("Email verification Code entered");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter email verification Code");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter email verification Code");
		 }
	}
	
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="wifiOfflogout")
	public void logOutMobileTest(String expTitle, String expMessage, String expiMessage) {
		 try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("Wait for Wifi and BLE on");
			 Thread.sleep(27000);
			 //uncommented on  17-07-2020. commented on 14-07-2020
			 if(device.equals("android")) {
				 ld.clickHamburgerButton();
			 }
			 Thread.sleep(2000);
			 mp.clickLogoutButton();
			 if(device.equals("iOS")) {
				 mp.verifyPopUpVerbiage(expTitle, expiMessage);
			 }else {
				 mp.verifyPopUpVerbiage(expTitle, expMessage);
			 }
			 /*mp.clickCancelButton();
			 mp.clickLogoutButton();*/
			 mp.clickOKButton();
			 Thread.sleep(15000);
			
			 //check code below
			// mp.verifyPopUpVerbiage(expTitle, expMessage);
			 Log.addMessage("Logged out of Dashboard page");
		 }catch(Exception e) {
			 Log.addMessage("Failed to log out");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to log out");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="wifiOfflogout")
	public void logOutTest(String expTitle, String expMessage, String expiMessage) {
		 try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("Wait for Wifi and BLE on");
			 Thread.sleep(27000);
			 //commented on 22-02-2021 uncommented on  17-07-2020. commented on 14-07-2020
			// if(device.equals("android")) {
				 ld.clickHamburgerButton();
			// }
			 Thread.sleep(2000);
			 mp.clickLogoutButton();
			 if(device.equals("iOS")) {
				 mp.verifyPopUpVerbiage(expTitle, expiMessage);
			 }else {
				 mp.verifyPopUpVerbiage(expTitle, expMessage);
			 }
			 /*mp.clickCancelButton();
			 mp.clickLogoutButton();*/
			 mp.clickOKButton();
			 Thread.sleep(15000);
			
			 //check code below
			// mp.verifyPopUpVerbiage(expTitle, expMessage);
			 Log.addMessage("Logged out of Dashboard page");
		 }catch(Exception e) {
			 Log.addMessage("Failed to log out");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to log out");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vlogin")
	public void valLoginIdleTest(String email, String password) {
		 try {
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 cv.clickBackButton();
			 cp.login(email, password);
			 Log.addMessage("Clicked Back button");
		 }catch(Exception e) {
			 Log.addMessage("Failed to click back button");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to click back button");
		 }
	}
	
	@SuppressWarnings("unchecked")
	 @Test(dataProvider="vlogin")
	 public void userLoginIdleTest(String email, String password) {
		 try {
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("Wait for checking idle time out");
			 //Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(2000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 Thread.sleep(190000);
			//get the verification code from email
			 cvp.readCodeFromEmail("email.address3", "email.password3");
			 cvp.clickSubmitButton(); 
			 Log.addMessage("Clicked submit button");
		 }catch(Exception e) {
			 Log.addMessage("Failed to click submit button");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to click submit button");
		 }
	 }
	
	//added for iOS create flow check message
	@SuppressWarnings("unchecked")
	@Test(dataProvider="valSessionPopup")
	public void valSessionExpirePopupTest(String ttlMessage, String valMessage) {
		 try {
			 EnterPasswordPage cp = new EnterPasswordPage((AppiumDriver<MobileElement>) driver);
			
			 cp.valSuccessSessionPopUp( ttlMessage, valMessage);
			 cp.clickOKButton();
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter login credentials"); 
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter login credentials");
		 }
	}
		
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vlogin")
	public void validLoginTest(String email, String password) {
		 try {
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("user login");
			// Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Log.addMessage("Clicked Back button");
		 }catch(Exception e) {
			 Log.addMessage("Failed to click back button");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to click back button");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void mobileCodeBackTest() {
		 try {
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 cv.selectMobile();
			 cv.clickSubmit();
			 Thread.sleep(2000);
			 ee.clickBackButton();
			 Thread.sleep(2000);
			 Log.addMessage("Clicked Back button of email page");
		 }catch(Exception e) {
			 Log.addMessage("Failed to click Back button of email page");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to click Back button of email page");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vlogin")
	public void valMobileVerifyKeyboardEditTest(String email, String password) {
		 try {
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cvm = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("user login");
			 //Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 cvm.selectMobile();
			 cvm.clickSubmit();
			 Thread.sleep(2000);
			 cv.enterPhoneVerifyDoneKey("12","edit");
			 cv.clickOKButton();
			 Log.addMessage("Clicked Done button in keyboard");
			 Thread.sleep(5000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to click Done button in keyboard");
			 e.printStackTrace();
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vlogin")
	public void valMobileVerifyLoginEditTest(String email, String password) {
		 try {
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cvm = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("user login");
			// Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 cvm.selectMobile();
			 cvm.clickSubmit();
			 Thread.sleep(2000);
			 Log.addMessage("Selected mobile option");
			 Thread.sleep(5000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to select mobile option");
			 e.printStackTrace();
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vlogin")
	public void validReLoginTest(String email, String password) {
		 try {
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("user login");
			// Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(2000);
			 cv.selectMobile();
			 cv.clickSubmit();
		 }catch(Exception e) {
			 Log.addMessage("Failed to click back button");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to click back button");
		 }
	}
	
	 @SuppressWarnings("unchecked")
	 @Test(dataProvider="mobileVerify")
	 public void valMobilelVerifyEditTest(String valCode, String titleMsg, String valMessage, String toastMsg, String iTitle, String iMessage, String iEditMsg) {
		 try {
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 cv.valMobileVerificationCode(valCode,titleMsg, valMessage, toastMsg, "edit", iTitle, iMessage,iEditMsg);
			 Log.addMessage("Email verification Code entered");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter email verification Code");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter email verification Code");
		 }
	}
	 
	 @SuppressWarnings("unchecked")
	 @Test
	 public void validMobileCodeEditTest() {
		 try {
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 cv.clickResendButton();
			 if(device.equals("iOS")) {
				 cv.clickOKButton();
			 }
			 //get the verification code from email
			 System.out.println("Wait for retrieving verification code from mobile");
			 cv.readMobileCodeFromEmail("email.address5", "email.password5");
			 cv.clickSubmitButton(); 
			 /* Thread.sleep(15000);
			 cv.enterMobileCode("123456");
			 Thread.sleep(5000);*///for editing wo reading from mail for testing purpose
			 //cv.clickSubmitButton();
			 Log.addMessage("Email verification Code entered");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter email verification Code");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter email verification Code");
		 }
	}
	 
	 @SuppressWarnings("unchecked")
	 @Test
	 public void validPhoneCodeEditTest() {
		 try {
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("Wait for reading code from email");
			 Thread.sleep(15000);
			 cv.enterMobileCode("123456");
			 Thread.sleep(5000);//for editing wo reading from mail for testing purpose
			 cv.clickSubmitButton();
			 Log.addMessage("Email verification Code entered");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter email verification Code");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter email verification Code");
		 }
	}
	 
	@SuppressWarnings("unchecked")
	@Test
	public void logOutMobileWifiOffTest() {
		 try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("Wait for Wifi Off");
			 Thread.sleep(27000);
			 if(device.equals("android")) {
				 ld.clickCancelButton();
			 }else {
				 ld.clickHamburgerButton();
				 Thread.sleep(2000);
				 if(device.equals("android")) {
					mp.clickCancelButton();
				 }else {
					 mp.clickOKButton();
				 }
			 }
			 Log.addMessage("Internet connection required pop up displayed");
		 }catch(Exception e) {
			 Log.addMessage("Failed to display internet connection required pop up");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to display internet connection required pop up");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void logOutRecPasswordTest() {
		 try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 SecurityQuestionsPage eq = new SecurityQuestionsPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("login");
			 Thread.sleep(7000);
			 eq.clickBack();
			 //sp.clickNavBack();//commented on 19-02-2021
			 ld.clickHamburgerButton();
			 mp.clickLogoutButton();
			 Thread.sleep(2000);
			 mp.clickOKButton();
			
			 Log.addMessage("Clicked log out");
		 }catch(Exception e) {
			 Log.addMessage("Failed to log out");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to log out");
		 }
	}
		
	
	//Account Settings Test Cases
	//session logged out in iOS
    @SuppressWarnings("unchecked")
	@Test(dataProvider="vlogin")
	public void userLoginTest(String email, String password) {
		 try {
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("Wait for Wifi and BLE ON");
			// Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(2000);
			 cv.selectEmail();
			 cv.clickSubmit();
			//get the verification code from email
			 cvp.readCodeFromEmail("email.address3", "email.password3");
			 cvp.clickSubmitButton(); 
			/* Thread.sleep(15000);
			 cvp.enterMobileCode("123456");
			 Thread.sleep(5000);//for editing wo reading from mail for testing purpose
			 cvp.clickSubmitButton();*/
			 Log.addMessage("Clicked submit button");
		 }catch(Exception e) {
			 Log.addMessage("Failed to click submit button");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to click submit button");
		 }
	}
	
	
	//Account Settings Test Cases
	//session logged out in iOS
    @SuppressWarnings("unchecked")
	@Test(dataProvider="valChLogin")
	public void userLoginValTest(String email, String password) {
		 try {
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("Wait for Wifi and BLE ON");
			// Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(2000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 cvp.readCodeFromEmail("email.address3", "email.password3");
			 cvp.clickSubmitButton(); 
			 Log.addMessage("Clicked submit button");
		 }catch(Exception e) {
			 Log.addMessage("Failed to click submit button");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to click submit button");
		 }
	}
    
    @SuppressWarnings("unchecked")
	@Test
	public void validLoginAgnCanTouchTest() {
		 try {
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			// if(device.contentEquals("iOS")) {
				 cvp.clickNotNowButton();
			 //}
			 Log.addMessage("Clicked not now button ");
		 }catch(Exception e) {
			 Log.addMessage("Failed to click not now button");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to click not now button");
		 }
	}
    
    @SuppressWarnings("unchecked")
   	@Test
   	public void biometricLoginAcceptTest() {
   		 try {
   			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
   			 cvp.clickAllowBioButton();
   			 cvp.clickOKButton();
   			 Utility.simpleWait(2000);
   			 cvp.clickAllowButton();//during fresh install login
   			 Log.addMessage("Clicked allow biometric button");
   		 }catch(Exception e) {
   			 Log.addMessage("Failed to allow biometric  button");
   			 e.printStackTrace();
   			 Assert.assertTrue(false, "Failed to allow biometric allow button");
   		 }
   	}
       
    
    @SuppressWarnings("unchecked")
	@Test
	public void createAFirstHomeTest() {
		try {
			 CreateAHomePage ch = new CreateAHomePage((AppiumDriver<MobileElement>) driver);
			 EnterHomeNamePage eh = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
			 ch.clickCreateAHomeButton();
			 eh.enterHomeName("firstHome");
			 eh.clickSubmitButton();
			 Thread.sleep(5000);
			 if(device.equals("android")) {
				 eh.clickOKButton();
			 }
			 Log.addMessage("First home created");
		}catch(Exception e) {
			Log.addMessage("Failed to create First Home");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to create First Home");
		}
	}
    
    @SuppressWarnings("unchecked")
	@Test
	public void viewAccountSettingsPageTest() {
		 try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 SettingsPage sp = new SettingsPage((AppiumDriver<MobileElement>) driver);
			 UpdateAccountNamePage ua = new UpdateAccountNamePage((AppiumDriver<MobileElement>) driver);
			 
			 Thread.sleep(10000);//for testing in between
			 ld.clickHamburgerButton();
			 mp.clickAccountSettingsButton();
			 Thread.sleep(2000);
			 sp.clickNavBack();
			 Thread.sleep(2000);
			 System.out.println("after1");
			 ld.clickHamburgerButton();
			 MenuFlyoutPage mp1 = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 mp1.clickAccountSettingsButton();
			// sp1.clickAccountOption();
			 Thread.sleep(2000);
			// as.clickNavBack();
			 //Thread.sleep(2000);
			 System.out.println("after2");
			// sp1.clickAccountOption();
			 AccountSettingsPage as1 = new AccountSettingsPage((AppiumDriver<MobileElement>) driver);
			 as1.verifyUIAccountSettingsPage();
			 as1.clickNameOption();
			 Thread.sleep(2000);
			 ua.clickBack();
			 Thread.sleep(5000);
			 System.out.println("after3");
			 AccountSettingsPage as2 = new AccountSettingsPage((AppiumDriver<MobileElement>) driver);
			 as2.clickNameOption();
			 Log.addMessage("Clicked Back button");
		 }catch(Exception e) {
			 Log.addMessage("Failed to click back button");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to click back button");
		 }
	}
    
    @SuppressWarnings("unchecked")
   	@Test
   	public void navigateToAccountSettingsPageTest() {
   		 try {
   			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
   			 MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
   			// Thread.sleep(20000);//for testing in between
   			 ld.clickHamburgerButton();
   			 mp.clickAccountSettingsButton();
   			 Thread.sleep(2000);
   			/* SettingsPage sp1 = new SettingsPage((AppiumDriver<MobileElement>) driver);
   			 sp1.clickAccountOption();
   			 Thread.sleep(2000);*/
   			 System.out.println("after2");
   			 AccountSettingsPage as1 = new AccountSettingsPage((AppiumDriver<MobileElement>) driver);
   			 as1.clickBiometricUnlockOption();//added on 9 Apr 21
   			 
   			 as1.verifyUIAccountSettingsPage();
   			 
   			 as1.clickNameOption();
   			 Thread.sleep(2000);
   			 System.out.println("after3");
   			 Log.addMessage("Clicked Name option");
   		 }catch(Exception e) {
   			 Log.addMessage("Failed to click name option");
   			 e.printStackTrace();
   			 Assert.assertTrue(false, "Failed to click name option");
   		 }
   	}
    
    @SuppressWarnings("unchecked")
   	@Test
   	public void navigateToAccountSettingsBioTest() {
   		 try {
   			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
   			 MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
   			// Thread.sleep(20000);//for testing in between
   			 ld.clickHamburgerButton();
   			 mp.clickAccountSettingsButton();
   			 Thread.sleep(2000);
   			 System.out.println("after2");
   			 AccountSettingsPage as1 = new AccountSettingsPage((AppiumDriver<MobileElement>) driver);
   			 as1.clickBiometricUnlockOption();//added on 9 Apr 21
   			 Thread.sleep(2000);
   			 System.out.println("after3");
   			 Log.addMessage("Clicked Name option");
   		 }catch(Exception e) {
   			 Log.addMessage("Failed to click name option");
   			 e.printStackTrace();
   			 Assert.assertTrue(false, "Failed to click name option");
   		 }
   	}
   	  
    @SuppressWarnings("unchecked")
	 @Test
	 public void verifyNameClearButtonTest() {
		 try {
			 UpdateAccountNamePage ap = new UpdateAccountNamePage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//to test in between
			 ap.verifyClearButton();
			 
		 }catch(Exception e) {
			 Log.addMessage("Failed to clear account name");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to clear account name");
		 }
    }
    
     @SuppressWarnings("unchecked")
	 @Test(dataProvider="chngAcntName")
	 public void validateEditAccountTest(String firstName, String lastName, String valMessage, String iTitle,String iMessage) {
		 try {
			 UpdateAccountNamePage ap = new UpdateAccountNamePage((AppiumDriver<MobileElement>) driver);
			 ap.updateAccountName(firstName, lastName,valMessage, iTitle, iMessage);
			 
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter login credentials");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter login credentials");
		 }
     }
     
    @SuppressWarnings("unchecked")
 	@Test
 	public void validAccountNameEditTest() {
 		try {
 			UpdateAccountNamePage an = new UpdateAccountNamePage((AppiumDriver<MobileElement>) driver);
 			an.updateFirstName("specBVT1");
			an.updateLastName("envBVT1");	
			an.clickNextButton();
 			System.out.println("after val return");
 			Log.addMessage("Account name entered");
 		}catch(Exception e){
 			Log.addMessage("Failed to enter account name");
 			e.printStackTrace();
 			Assert.assertTrue(false, "Failed to enter account name");
 		} 
 	}
     
    @SuppressWarnings("unchecked")
 	@Test
 	public void viewPhoneNumberPageTest() {
 		 try {
 			 AccountSettingsPage as = new AccountSettingsPage((AppiumDriver<MobileElement>) driver);
 			 UpdatePhoneNumberPage up = new UpdatePhoneNumberPage((AppiumDriver<MobileElement>) driver);
 			 
 			// Thread.sleep(15000);//commented on 14-12-2020
 			 as.clickPhoneNumberOption();
 			 Thread.sleep(3000);
 			 up.clickBackButton();
 			 AccountSettingsPage as1 = new AccountSettingsPage((AppiumDriver<MobileElement>) driver);
 			 UpdatePhoneNumberPage up1 = new UpdatePhoneNumberPage((AppiumDriver<MobileElement>) driver);
 			 as1.clickPhoneNumberOption();
 			// up1.verifyClearButton();//commented for latest QA no clear button inphone number page
 			 Log.addMessage("Phone number page displayed and clear button working");
 		 }catch(Exception e) {
 			 Log.addMessage("Failed to display all elements in edit phone number page");
 			 e.printStackTrace();
 			 Assert.assertTrue(false, "Failed to display all elements in edit phone number page");
 		 }
 	}
    
    @SuppressWarnings("unchecked")
 	@Test(dataProvider="vEditphone")
 	public void validPhoneNumberPageEditTest(String phNum) {
 		 try {
 			 AccountSettingsPage as = new AccountSettingsPage((AppiumDriver<MobileElement>) driver);
 			 
 			 Thread.sleep(15000);//for testing in between
 			 as.clickPhoneNumberOption();
 			 Thread.sleep(3000);
 			 UpdatePhoneNumberPage up1 = new UpdatePhoneNumberPage((AppiumDriver<MobileElement>) driver);
 			 up1.updatePhoneNumber(phNum);
 			 up1.clickNextButton();
 			 Log.addMessage("Phone number page displayed and clear button working");
 		 }catch(Exception e) {
 			 Log.addMessage("Failed to display all elements in edit phone number page");
 			 e.printStackTrace();
 			 Assert.assertTrue(false, "Failed to display all elements in edit phone number page");
 		 }
 	}
    
    @SuppressWarnings("unchecked")
	@Test(dataProvider="editPhnNum")
	public void validatePhoneNumTest(String phnNum, String titleMsg, String valMessage, String iValMessage) {
		 try {
			 UpdatePhoneNumberPage cp = new UpdatePhoneNumberPage((AppiumDriver<MobileElement>) driver);
			 if(device.contentEquals("iOS")) {
				 cp.updatePhoneNumber(phnNum, iValMessage, titleMsg);
			 }else {
				 cp.updatePhoneNumber(phnNum, valMessage, titleMsg);
			 }
			 
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter Phone Number");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter Phone Number");
		 }
	}
    
    @SuppressWarnings("unchecked")
	@Test(dataProvider="resendPopup")
	public void phoneCodeResendLimitEditTest(String popupMsg, String ipopupMsg) {
		 try {
			 PhoneCodeVerificationPage cv = new PhoneCodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 Thread.sleep(27000);
			 for(int i=0; i<4; i++) {
				 cv.clickResendButton();
				 if(device.equals("iOS")) {
					 cv.clickOKButton();
				 }
			 }
			 //check the popup verbiage for resend limits
			 Thread.sleep(5000);
			 cv.clickResendButton();
			 if(device.equals("iOS")) {
				 cv.verifyResendPopUpVerbiage(ipopupMsg);
			 }else {
				 cv.verifyResendPopUpVerbiage(popupMsg);
			 }
			 //added on 29-07-2020 regression
			 if(device.equals("iOS")) {
			 cv.clickOKButton();
			 }
			
			 Log.addMessage("Resend limits set for verify phone number page");
		 }catch(Exception e) {
			 Log.addMessage("Resend limits not set for verify phone number page");
			 e.printStackTrace();
		 }
	}
    
    @SuppressWarnings("unchecked")
   	@Test
   	public void verifyOKInCodeResendTest() {
   		 try {
   			 PhoneCodeVerificationPage cv = new PhoneCodeVerificationPage((AppiumDriver<MobileElement>) driver);
   			 if(cv.checkOkButton()) {
   				 cv.clickOKButton();
   			 }
   			 Log.addMessage("OK button clicked in verify phone number page");
   		 }catch(Exception e) {
   			 Log.addMessage("Failed to click OK button in verify phone number page");
   			 e.printStackTrace();
   		 }
   	}
    
    @SuppressWarnings("unchecked")
	@Test
	public void valPhoneCodeKeyboardEditTest() {
		 try {
			 PhoneCodeVerificationPage cv = new PhoneCodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("user login");
			// Thread.sleep(27000);//for testing in between
			
			 cv.enterPhoneVerifyDoneKey("12","edit");
			 cv.clickOKButton();
			 Log.addMessage("Clicked Done button in keyboard");
			 Thread.sleep(5000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to click Done button in keyboard");
			 e.printStackTrace();
		 }
	}
    
    @SuppressWarnings("unchecked")
	@Test
	public void valPhoneCodeBackTest() {
		 try {
			 PhoneCodeVerificationPage cv = new PhoneCodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 UpdatePhoneNumberPage up = new UpdatePhoneNumberPage((AppiumDriver<MobileElement>) driver);
			 AccountSettingsPage as = new AccountSettingsPage((AppiumDriver<MobileElement>) driver);
			 //CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);

			 cv.clickBackButton();
			/* up.clickNextButton();//commented on 16 Apr 2021
			 if(device.equals("android")) {
				 up.clickOKButton();
			 }*/
			 System.out.println("wait to retrieve verification code from email");
			 //commented on 19-Feb-2021 as mobile number is not valid
			/* cvp.readMobileCodeFromEmail("email.address5", "email.password5");
			 cvp.clickSubmitButton(); */
			// cv.clickBackButton();//commented on 16 Apr 2021
			 up.clickBackButton();
			 as.clickChangePasswordOption();
			 Log.addMessage("Clicked back button");
		 }catch(Exception e) {
			 Log.addMessage("Failed to click back button");
			 e.printStackTrace();
		 }
	}
    
    @SuppressWarnings("unchecked")
   	@Test
   	public void validPhoneCodeSettingsTest() {
   		 try {
   			 PhoneCodeVerificationPage cv = new PhoneCodeVerificationPage((AppiumDriver<MobileElement>) driver);
   			 Thread.sleep(15000);
   			
   			 System.out.println("wait to retrieve verification code from email");
   			 //get verification code from mail and submit
   			 cv.enterMobileCode("123456");
   			 Thread.sleep(5000);//to edit while testing
   			 cv.clickSubmitButton();
   			 Thread.sleep(2000);
   			 //as.clickChangePasswordOption();
   			 Log.addMessage("Clicked back button");
   		 }catch(Exception e) {
   			 Log.addMessage("Failed to click back button");
   			 e.printStackTrace();
   		 }
   	}
    
    @SuppressWarnings("unchecked")
	 @Test
	 public void viewChangePasswordPageTest() {
		 try {
			 UpdatePasswordPage cp = new UpdatePasswordPage((AppiumDriver<MobileElement>) driver);
			 AccountSettingsPage as = new AccountSettingsPage((AppiumDriver<MobileElement>) driver);
			 Thread.sleep(5000);//for testing in between
			 cp.verifyUIPassword();
			 cp.clickBackButton();
			 Thread.sleep(2000);
			 as.clickChangePasswordOption();
			 Thread.sleep(2000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to display all elements in change password page");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to display all elements in change password page");
		 }
	}
    
  	@SuppressWarnings("unchecked")
  	@Test
  	public void valChangePasswordKeyboardTest() {
  		 try {
  			 UpdatePasswordPage eq = new UpdatePasswordPage((AppiumDriver<MobileElement>) driver);
  			 //Thread.sleep(27000);//for test in between
  			 eq.enterOldPasswordNextKey();
  			 eq.enterNewPasswordNextKey();
  			 eq.reenterNewPasswordDoneKey();
  			 Thread.sleep(2000);
  			 eq.clickOkButton();
  			 Log.addMessage("Clicked Done button in keyboard");
  			 Thread.sleep(5000);
  		 }catch(Exception e) {
  			 Log.addMessage("Failed to click Done button in keyboard");
  			 e.printStackTrace();
  		 }
  	}
  	
  	@SuppressWarnings("unchecked")
  	@Test
  	public void validChangePasswordTest() {
  		 try {
  			 UpdatePasswordPage eq = new UpdatePasswordPage((AppiumDriver<MobileElement>) driver);
  			 //Thread.sleep(27000);//for test in between
  			 eq.enterOldPasswordNextKey();
  			 eq.enterNewPasswordNextKey();
  			 eq.reenterNewPasswordDoneKey();
  			 Thread.sleep(2000);
  			 eq.clickOkButton();
  			 Log.addMessage("Clicked Done button in keyboard");
  			 Thread.sleep(5000);
  		 }catch(Exception e) {
  			 Log.addMessage("Failed to click Done button in keyboard");
  			 e.printStackTrace();
  		 }
  	}
    
    
    @SuppressWarnings("unchecked")
	@Test(dataProvider="ValidateEditPwd")
	public void valChangePasswordTest(String nwPwd,String rePwd,String oldPwd, String titleMessage, String valMessage, String iTitle, String iMessage) {
		 try {
			 UpdatePasswordPage up = new UpdatePasswordPage((AppiumDriver<MobileElement>) driver);
			 up.valPassword(oldPwd, nwPwd, rePwd, titleMessage, valMessage, iTitle, iMessage);
			 
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter login credentials");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter login credentials");
		 }
	}
    
    @SuppressWarnings("unchecked")
	@Test(dataProvider="emailCntntChPwd")
	public void editAccountEmailContentTest(String emailText, String frmAdrs) {
		 try {
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 Thread.sleep(5000);
			 System.out.println("wait to retrieve verification code from email");
			 cvp.readContentFromChangeAcntEmail("email.address3", "email.password3",emailText,frmAdrs);
			 Log.addMessage("Entered valid email verification code");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter valid email verification code.");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter valid email verification code.");
		 }	
	}
	

	/** 
	* Method Name: valAccountLogOutPopUpTest(), 
	* This function is used to verify the account log pop up in the Change Password Page
	*/
	@SuppressWarnings("unchecked")
	@Test
	public void valAccountLogOutPopUpTest() throws InterruptedException {
		try {
			UpdatePasswordPage up = new UpdatePasswordPage((AppiumDriver<MobileElement>) driver);
			//if(up.checkOkButton()) {
				//up.clickOkButton();//added for Android QA 12 Apr 2021
				up.clickOkButton();
			//}
			
			Assert.assertTrue(true, "Clicked account logout popup in change password page");
		}catch(Exception e) {
			Log.addMessage("Failed to click account logout popup in change password page");
			Assert.assertTrue(false, "Failed to click account logout popup in change password page");
		}
	}
	
    @SuppressWarnings("unchecked")
	@Test(dataProvider="bioLoginPopup")
	public void valChPwdBioPopUpTest(String vemail, String popupMsg, String ipopupMsg) {
		 try {
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 PhoneCodeVerificationPage cv = new PhoneCodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 cp.enterEmail(vemail);
			 cp.clickBioButton();
			 if(device.equals("iOS")) {
				 cv.verifyBioPopUpVerbiage(ipopupMsg);
			 }else {
				 cv.verifyBioPopUpVerbiage(popupMsg);
			 }
			 cv.clickOKButton();
			 Log.addMessage("Popup message to enable biometric token is displayed");
		 }catch(Exception e) {
			 Log.addMessage("Failed to display pop up for enabling biometric token");
			 e.printStackTrace();
		 }
	}
    
    @SuppressWarnings("unchecked")
	@Test(dataProvider="vrelogin")
	public void reLoginAfterChngPwdTest(String email, String password) {
		 try {
			 LoginPage lp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 AccountSettingsPage as = new AccountSettingsPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("user login");
			// Thread.sleep(27000);//for testing in between
			 lp.login(email, password);
			 Thread.sleep(10000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 cvp.readCodeFromEmail("email.address3", "email.password3");
			 cvp.clickSubmitButton(); 
			/* ld.clickHamburgerButton();
			 mp.clickAccountSettingsButton();*/
			// sp.clickAccountOption();
			 Thread.sleep(2000);
			// as.clickChangeSecurityQuestionsOption();
			 Log.addMessage("Logged in success");
		 }catch(Exception e) {
			 Log.addMessage("Failed to log in");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to log in");
		 }
	}
    
    //added for iOS create flow check message
  	@SuppressWarnings("unchecked")
  	@Test(dataProvider="valSessionPopup")
  	public void valGlblSessionExpireChngPwdPopupTest(String ttlMessage, String valMessage) {
  		 try {
  			 EnterPasswordPage cp = new EnterPasswordPage((AppiumDriver<MobileElement>) driver);
  			 cp.verifySuccessSessionPopUp( ttlMessage, valMessage);
  			//cp.clickOKButton();
  		 }catch(Exception e) {
  			 Log.addMessage("Failed to enter login credentials"); 
  			 e.printStackTrace();
  			 Assert.assertTrue(false, "Failed to enter login credentials");
  		 }
  	}
  	
  //added for iOS create flow check message
  	@SuppressWarnings("unchecked")
  	@Test(dataProvider="vrelogin")
  	public void verifyPasswordHiddenTest(String email, String password) {
  		 try {
  			 LoginPage lp = new LoginPage((AppiumDriver<MobileElement>) driver);
  			 lp.enterEmail(email);
			 lp.enterPassword(password);
  			lp.checkPwdHidden();
  		 }catch(Exception e) {
  			 Log.addMessage("Failed to enter login credentials"); 
  			 e.printStackTrace();
  			 Assert.assertTrue(false, "Failed to enter login credentials");
  		 }
  	}
  	
  	@SuppressWarnings("unchecked")
 	@Test(dataProvider="vrelogin")
 	public void reLoginAfterChangePasswordTest(String email, String password) {
 		 try {
 			 LoginPage lp = new LoginPage((AppiumDriver<MobileElement>) driver);
 			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
 			 AccountSettingsPage as = new AccountSettingsPage((AppiumDriver<MobileElement>) driver);
 			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
 			 System.out.println("user login");
 			// Thread.sleep(27000);//for testing in between
 			 lp.login(email, password);
 			 Thread.sleep(10000);
 			 cv.selectEmail();
 			 cv.clickSubmit();
 			 cvp.readCodeFromEmail("email.address3", "email.password3");
 			 cvp.clickSubmitButton(); 
 			/* ld.clickHamburgerButton();
 			 mp.clickAccountSettingsButton();*/
 			// sp.clickAccountOption();
 			// Thread.sleep(2000);
 			 //as.clickChangeSecurityQuestionsOption();
 			 Log.addMessage("Logged in success");
 		 }catch(Exception e) {
 			 Log.addMessage("Failed to log in");
 			 e.printStackTrace();
 			 Assert.assertTrue(false, "Failed to log in");
 		 }
 	}
    
    @SuppressWarnings("unchecked")
   	@Test
   	public void validReLoginAgnCanTouchTest() {
   		 try {
   			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
   			// if(device.contentEquals("iOS")) {
   				 cvp.clickNotNowButton();
   			 //}
   			 Log.addMessage("Clicked not now button ");
   		 }catch(Exception e) {
   			 Log.addMessage("Failed to click not now button");
   			 e.printStackTrace();
   			 Assert.assertTrue(false, "Failed to click not now button");
   		 }
   	}
    
    @SuppressWarnings("unchecked")
   	@Test(dataProvider="vrelogin")
   	public void verifyLoginTest(String email, String password) {
   		 try {
   			 LoginPage lp = new LoginPage((AppiumDriver<MobileElement>) driver);
   			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
   			 AccountSettingsPage as = new AccountSettingsPage((AppiumDriver<MobileElement>) driver);
   			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
   			 System.out.println("user login");
   			 //Thread.sleep(27000);//for testing in between
   			 if(lp.verifyLogout()) {
	   			 lp.login(email, password);
	   			 Thread.sleep(10000);
	   			 cv.selectEmail();
	   			 cv.clickSubmit();
	   			 cvp.readCodeFromEmail("email.address3", "email.password3");
	   			 cvp.clickSubmitButton(); 
	   			 Thread.sleep(2000);
	   			 CodeVerificationPage cvp1 = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
	    		 cvp1.clickNotNowButton();
	    		 Log.addMessage("Clicked not now button ");
	   			 Log.addMessage("Logged in success");
   			 }else {
   				 Log.addMessage("Already logged in"); 
   			 }
   			
   		 }catch(Exception e) {
   			 Log.addMessage("Failed to log in");
   			 e.printStackTrace();
   			 Assert.assertTrue(false, "Failed to log in");
   		 }
   	}
       
    
    @SuppressWarnings("unchecked")
   	@Test(dataProvider="vrecoverlogin")
   	public void minimiseAndRelaunchTest(String email, String password) {
   		 try {
   			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
   			 MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
   			 AccountSettingsPage as = new AccountSettingsPage((AppiumDriver<MobileElement>) driver);
   			 System.out.println("user login");
   			 appiumDriver.closeApp();//.runAppInBackground(10);//put app in background for 10 seconds
   			 appiumDriver.launchApp();//launch the app again
   			 ld.clickHamburgerButton();
   			 mp.clickAccountSettingsButton();
   			// as.clickChangeSecurityQuestionsOption();
   			 as.clickNavBack();
   			 Thread.sleep(2000);
   			 Log.addMessage("Credentials retained after app minimised");
   		 }catch(Exception e) {
   			 Log.addMessage("Failed to retain the credentials after app minimised");
   			 e.printStackTrace();
   			 Assert.assertTrue(false, "Failed to retain the credentials after app minimised");
   		 }
   	}
    
    @SuppressWarnings("unchecked")
	@Test(dataProvider="vrecoverlogin")
	public void navToAccountSettingsPageSQTest(String email, String password) {
		 try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 AccountSettingsPage as = new AccountSettingsPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("user login");
			 ld.clickHamburgerButton();
			 mp.clickAccountSettingsButton();
			 as.clickChangeSecurityQuestionsOption();
			 Thread.sleep(2000);
			 Log.addMessage("Logged in after change password");
		 }catch(Exception e) {
			 Log.addMessage("Failed to log in after change password");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to log in after change password");
		 }
	}
    
    @SuppressWarnings("unchecked")
	@Test
	public void viewSecurityQuestionPageTest() {
		 try {
			 SecurityQuestionsPage cp = new SecurityQuestionsPage((AppiumDriver<MobileElement>) driver);
			 AccountSettingsPage as = new AccountSettingsPage((AppiumDriver<MobileElement>) driver);
			 Thread.sleep(15000);//for testing in between
			 cp.verifyUISecurityQuestion("view");
			 if(device.equals("android")) {
				 cp.clickBack();
			 }else {
				 cp.clickBackButton();
			 }
			 Thread.sleep(2000);
			 as.clickChangeSecurityQuestionsOption();
			 Thread.sleep(2000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to click back button");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to click back button");
		 }
	}
    
	@SuppressWarnings("unchecked")
	@Test(dataProvider="dupQn1")
	public void scrtyQstn1DuplicateCheckASTest(String qn1, String qn2, String qn3) {
		 try {
			 SecurityQuestionsPage eq = new SecurityQuestionsPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 if(device.equals("iOS")) {
						System.out.println("is not null");
						eq.enterQuestion1();
			}else {
				eq.clickChangeSecurityQn1();
				eq.checkForCountAndDuplicateInQn(qn1,1);
				eq.checkForDuplicateInNextQn(qn1,qn2,qn3,1);
			}
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter security question1");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter security question1");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="dupQn1")
	public void scrtyQstn2DuplicateCheckASTest(String qn1, String qn2, String qn3) {
		 try {
			 SecurityQuestionsPage eq = new SecurityQuestionsPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 if(device.equals("iOS")) {
						System.out.println("is not null");
						eq.enterQuestion2();
			}else {
				eq.clickChangeSecurityQn2();
				eq.checkForCountAndDuplicateInQn(qn2,1);
				eq.checkForDuplicateInNextQn(qn1,qn2,qn3,2);
			}
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter security question2");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter security question2");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="dupQn1")
	public void scrtyQstn3DuplicateCheckASTest(String qn1, String qn2, String qn3) {
		 try {
			 SecurityQuestionsPage eq = new SecurityQuestionsPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 if(device.equals("iOS")) {
						System.out.println("is not null");
						eq.enterQuestion3();
			}else {
				eq.clickChangeSecurityQn3();
				eq.checkForCountAndDuplicateInQn(qn3,2);
				eq.checkForDuplicateInNextQn(qn1,qn2,qn3,3);
			}
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter security question2");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter security question2");
		 }
	}
    
  	@SuppressWarnings("unchecked")
  	@Test
  	public void valEditSecurityQuestionKeyboardTest() {
  		 try {
  			 SecurityQuestionsPage eq = new SecurityQuestionsPage((AppiumDriver<MobileElement>) driver);
  			 eq.enterAnswer1NextKey();
  			 eq.enterAnswer2NextKey();
  			 eq.enterAnswer3NextKey();
  			 //eq.clickNextButton();
  			 eq.clickOKButton();
  			 Log.addMessage("Clicked Done button in keyboard");
  			 Thread.sleep(5000);
  		 }catch(Exception e) {
  			 Log.addMessage("Failed to click Done button in keyboard");
  			 e.printStackTrace();
  		 }
  	}
  	 
  	@SuppressWarnings("unchecked")
  	@Test
  	public void valEditSecurityQuestionBackTest() {
  		 try {
  			 SecurityQuestionsPage eq = new SecurityQuestionsPage((AppiumDriver<MobileElement>) driver);
  			 AccountSettingsPage cv = new AccountSettingsPage((AppiumDriver<MobileElement>) driver);
  			 Thread.sleep(7000);
  			 eq.clickBack();
  			 Thread.sleep(2000);
  			 cv.clickChangeSecurityQuestionsOption();
  			 Thread.sleep(2000);
  			 Log.addMessage("Resend limits set for verify phone number page");
  		 }catch(Exception e) {
  			 Log.addMessage("Resend limits not set for verify phone number page");
  			 e.printStackTrace();
  		 }
  	}
  	
  	 @SuppressWarnings("unchecked")
  	 @Test(dataProvider="vSecQn")
  	 public void valEditSecurityQuestionTest(String qn1,String ans1,String qn2, String ans2,String qn3, String ans3, String ttlMessage, String valMessage) {
  		 try {
  			 SecurityQuestionsPage eq = new SecurityQuestionsPage((AppiumDriver<MobileElement>) driver);
  			 //Thread.sleep(27000);//for testing in between
  			 eq.updateSecurityQuestion(qn1,ans1, qn2,ans2, qn3,ans3, valMessage, ttlMessage,"edit");
  			 
  		 }catch(Exception e) {
  			 Log.addMessage("Failed to enter security questions");
  			 e.printStackTrace();
  			 Assert.assertTrue(false, "Failed to enter security questions");
  		 }
  	}
  	 
  	 @SuppressWarnings("unchecked")
  	 @Test(dataProvider="vldSecEQn")
  	 public void vaidlEditSecurityQuestionTest(String qn1,String ans1,String qn2, String ans2,String qn3, String ans3) {
  		 try {
  			 SecurityQuestionsPage eq = new SecurityQuestionsPage((AppiumDriver<MobileElement>) driver);
  			 
  			 eq.clickChangeSecurityQn1();
			 eq.selectSecurityQn1(qn1);
			 eq.enterAnswer1(ans1);
			 
			 eq.clickChangeSecurityQn2();
			 eq.selectSecurityQn2(qn2);
			 eq.enterAnswer2(ans2);
			 
			 eq.clickChangeSecurityQn3();
			 eq.selectSecurityQn3(qn3);
			 eq.enterAnswer3(ans3);
			 eq.clickNextButton();
			 Log.addMessage("Updated security questions");
  		 }catch(Exception e) {
  			 Log.addMessage("Failed to update security questions");
  			 e.printStackTrace();
  			 Assert.assertTrue(false, "Failed to update security questions");
  		 }
  	}
  	 
  	@SuppressWarnings("unchecked")
	@Test(dataProvider="PwdChng")
	public void validChangePasswordBioTest(String oldPassword, String newPassword) {
		try {
			 AccountSettingsPage as = new AccountSettingsPage((AppiumDriver<MobileElement>) driver);
			 UpdatePasswordPage up = new UpdatePasswordPage((AppiumDriver<MobileElement>) driver);
			 Utility.simpleWait(3000);
			 as.clickChangePasswordOption();
			 up.enterOldPassword(oldPassword);
			 up.enterNewPassword(newPassword);
			 up.reEnterNewPassword(newPassword);
			 up.clickSubmitButton();
			 up.clickOkButton();//for Android QA
			 if(device.equals("iOS")) {
				 up.clickOkButton();//added for Weiser ios
			 }
			 Utility.simpleWait(5000);
			 Log.addMessage("Password updated successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to update password");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update password");
		}
	}
  	
  	@SuppressWarnings("unchecked")
 	@Test(dataProvider="vISecQn")
 	public void valEditSecurityQuestioniOSTest(String qn1,String ans1,String qn2, String ans2,String qn3, String ans3, String ttlMessage, String valMessage) {
 		 try {
 			 SecurityQuestionsPage eq = new SecurityQuestionsPage((AppiumDriver<MobileElement>) driver);
 			 //Thread.sleep(27000);//for testing in between
 			 eq.updateSecurityQuestion(qn1,ans1, qn2,ans2, qn3,ans3, valMessage, ttlMessage,"edit");
 			 
 		 }catch(Exception e) {
 			 Log.addMessage("Failed to enter security questions");
 			 e.printStackTrace();
 			 Assert.assertTrue(false, "Failed to enter security questions");
 		 }
 	}
  	 
	@SuppressWarnings("unchecked")
	@Test
	public void viewRcvrPwdEmailPageTest() {
		 try {
			 LoginPage lp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//to test in between
			 Thread.sleep(5000);
			 lp.clickForgotPasswordButton();
			 Thread.sleep(2000);
			 ee.viewEmailPage();
			 Thread.sleep(3000);
			 lp.clickForgotPasswordButton();
			 Log.addMessage("Resend limits set");
		 }catch(Exception e) {
			 Log.addMessage("Resend limits not set");
			 e.printStackTrace();
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="rcvremail")
	public void valEmailPageTest(String email,String titleMsg, String valMsg, String iMsg) {
		 try {
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 Thread.sleep(5000);
			 ee.valRcvrEmail(email, titleMsg, valMsg, iMsg);
			
		 }catch(Exception e) {
			 Log.addMessage("Failed to validate email field");
			 e.printStackTrace();
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void viewRcvrPwdSecurityQnPageTest() {
		 try {
			 SecurityQuestionsPage eq = new SecurityQuestionsPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			// Thread.sleep(27000);//to test in between
			 Thread.sleep(5000);
			 eq.verifyUISecurityQuestion("recover");
			 eq.clickBackButton();
			 Thread.sleep(2000);
			 ee.clickSubmitButton();
		 }catch(Exception e) {
			 Log.addMessage("Failed to display elements in security question page");
			 e.printStackTrace();
		 }
	}
	
	@SuppressWarnings("unchecked")
 	@Test(dataProvider="vRcvrSecQn")
 	public void valRcvrPwdSecurityQnTest(String qn1,String ans1, String ttlMessage, String valMessage, String toastMessage, String iTitle, String iMessage) {
 		 try {
 			 SecurityQuestionsPage eq = new SecurityQuestionsPage((AppiumDriver<MobileElement>) driver);
 			 eq.recoverSecurityQuestion(qn1,ans1,valMessage, ttlMessage, toastMessage, iTitle, iMessage);
 		 }catch(Exception e) {
 			 Log.addMessage("Failed to enter security questions");
 			 e.printStackTrace();
 			 Assert.assertTrue(false, "Failed to enter security questions");
 		 }
 	}
	
	@SuppressWarnings("unchecked")
 	@Test(dataProvider="validRcvrSecQn")
 	public void validRcvrPwdSecurityQnTest(String qn1,String ans1, String qnios,String ansios) {
 		 try {
 			 SecurityQuestionsPage eq = new SecurityQuestionsPage((AppiumDriver<MobileElement>) driver);
 			 if(device.equals("android")) {
 				 eq.validSecurityQuestion(qn1,ans1);
 			 }else {
 				eq.validSecurityQuestion(qnios,ansios);
 			 }
 		 }catch(Exception e) {
 			 Log.addMessage("Failed to enter security questions");
 			 e.printStackTrace();
 			 Assert.assertTrue(false, "Failed to enter security questions");
 		 }
 	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void viewRcvrPwdMFAPageTest() {
		 try {
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 SecurityQuestionsPage eq = new SecurityQuestionsPage((AppiumDriver<MobileElement>) driver);
			// System.out.println("Wait for Wifi and BLE ON");
			//Thread.sleep(27000);//for testing in between
			 Thread.sleep(7000);
			 cv.verifyUIMFAPage();
			 cv.clickBackButton();
			 Thread.sleep(3000);
			 if(device.equals("iOS")) {
				 eq.clickNextIButton();
				}else {
					eq.clickNextButton();
				}
			 Thread.sleep(3000);
			 ChooseVerificationMethodPage cv1= new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 cv1.selectEmail();
			 cv1.clickSubmit();
			 Thread.sleep(3000);
			 Log.addMessage("Clicked Back button");
		 }catch(Exception e) {
			 Log.addMessage("Failed to display all elements in MFA page");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to display all elements in MFA page");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void viewRecoverPasswordPageTest() {
		 try {
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 ForgotPasswordPage fp = new ForgotPasswordPage((AppiumDriver<MobileElement>) driver);
			// System.out.println("Wait for Wifi and BLE ON");
			// Thread.sleep(27000);//for testing in between
			 Thread.sleep(7000);
			 fp.verifyUIRecoverPassword();
			 fp.clickBackButton();
			 Thread.sleep(2000);
			 cv.clickSubmit();
			 Thread.sleep(2000);
			 Log.addMessage("Clicked Back button");
		 }catch(Exception e) {
			 Log.addMessage("Failed to display all elements in MFA page");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to display all elements in MFA page");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="verifyPassword")
	public void valFrgtVerifyPassEmailTest(String vcode, String nwpass, String renewpass, String titleMessage, String errMessage, String ititleMessage, String iMessage) {
	 try {
		 ForgotPasswordPage fp = new ForgotPasswordPage((AppiumDriver<MobileElement>) driver);
		 fp.updateFrgtPassword(vcode, nwpass, renewpass, titleMessage, errMessage,"email", ititleMessage, iMessage);		
	 }catch(Exception e) {
		 Log.addMessage("Failed to enter Email credentials");
		 e.printStackTrace();
		 Assert.assertTrue(false, "Failed to enter Email credentials");
	 }	 
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="resendPopup")
	public void emailCodeResendLimitRecoverTest(String popupMsg, String ipopupMsg) {
		 try {
			 Thread.sleep(5000);
			 //code added during regression to hide keyboard for iOS to make Resend button visible check for android
			 ForgotPasswordPage fp2 = new ForgotPasswordPage((AppiumDriver<MobileElement>) driver);
			 if(device.equals("iOS")) {
				Thread.sleep(2000);
				JavascriptExecutor js = appiumDriver;
				Map<String, Object> params = new HashMap<>();
				params.put("direction", "down");
				params.put("element",  driver.findElement(By.xpath("//XCUIElementTypeTextField")));
				js.executeScript("mobile: swipe", params);
				fp2.clickHeaderText();
			 }
			 for(int i=0; i<4; i++) {
				 ForgotPasswordPage fp = new ForgotPasswordPage((AppiumDriver<MobileElement>) driver);
				 fp.clickResendButton();
				 fp.clickOKButton();
			 }
			 ForgotPasswordPage fp1 = new ForgotPasswordPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("after loop");
			 Thread.sleep(5000);
			 fp1.clickResendButton();
			 if(device.equals("iOS")) {
				 fp1.verifyResendPopUpVerbiage(ipopupMsg);
			 }else {
				 fp1.verifyResendPopUpVerbiage(popupMsg);
			 }
			 fp1.clickOKButton();
			 Log.addMessage("Resend limits set for email verification code");
		 }catch(Exception e) {
			 Log.addMessage("Resend limits not set for email verification code");
			 e.printStackTrace();
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void valRecoverPasswordPageBackTest() {
		 try {
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 ForgotPasswordPage fp = new ForgotPasswordPage((AppiumDriver<MobileElement>) driver);
			 //System.out.println("Wait for Wifi and BLE ON");
			// Thread.sleep(27000);//for testing in between
			 Thread.sleep(7000);
			 fp.clickBackButton();
			 Thread.sleep(2000);
			 cv.selectMobile();
			 cv.clickSubmit();
			 Thread.sleep(2000);
			 Log.addMessage("Clicked Back button and selected mobile option");
		 }catch(Exception e) {
			 Log.addMessage("Failed to click back button in recover password page");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to click back button in recover password page");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="verifyMblPassword")
	public void valFrgtVerifyPassMobileTest(String vcode, String nwpass, String renewpass, String titleMessage, String errMessage, String ititleMessage, String iMessage) {
	 try {
		 ForgotPasswordPage fp = new ForgotPasswordPage((AppiumDriver<MobileElement>) driver);
		 fp.updateFrgtPassword(vcode, nwpass, renewpass, titleMessage, errMessage,"mobile", ititleMessage, iMessage);		
	 }catch(Exception e) {
		 Log.addMessage("Failed to enter Email credentials");
		 e.printStackTrace();
		 Assert.assertTrue(false, "Failed to enter Email credentials");
	 }	 
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="resendPopup")
	public void mobileCodeResendLimitRecoverTest(String popupMsg, String ipopupMsg) {
		 try {
			 //Thread.sleep(27000);
			 Thread.sleep(3000);
			 ForgotPasswordPage fp2 = new ForgotPasswordPage((AppiumDriver<MobileElement>) driver);
			 if(device.equals("iOS")) {
				Thread.sleep(2000);
				JavascriptExecutor js = appiumDriver;
				Map<String, Object> params = new HashMap<>();
				params.put("direction", "down");
				params.put("element",  driver.findElement(By.xpath("//XCUIElementTypeTextField")));
				js.executeScript("mobile: swipe", params);
				fp2.clickHeaderText();
			 }
			 for(int i=0; i<4; i++) {
				 ForgotPasswordPage fp = new ForgotPasswordPage((AppiumDriver<MobileElement>) driver);
				 fp.clickResendButton();
				 fp.clickOKButton();
			 }
			 ForgotPasswordPage fp1 = new ForgotPasswordPage((AppiumDriver<MobileElement>) driver);
			 //check the popup verbiage for resend limits
			 //Thread.sleep(5000);
			 fp1.clickResendButton();
			 if(device.equals("iOS")) {
				 fp1.verifyResendPopUpVerbiage(ipopupMsg);
			 }else {
				 fp1.verifyResendPopUpVerbiage(popupMsg);
			 }
			// fp1.clickOKButton();//commented on 17-07-2020 for android
			 Log.addMessage("Resend limits set for mobile verification code");
		 }catch(Exception e) {
			 Log.addMessage("Resend limits not set for mobile verification code");
			 e.printStackTrace();
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void valRecoverPasswordMobilePageBackTest() {
		 try {
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 ForgotPasswordPage fp = new ForgotPasswordPage((AppiumDriver<MobileElement>) driver);
			 //System.out.println("Wait for Wifi and BLE ON");
			// Thread.sleep(27000);//for testing in between
			 Thread.sleep(7000);
			 fp.clickBackButton();
			 Thread.sleep(2000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 Thread.sleep(2000);
			 Log.addMessage("Clicked Back button and selected mobile option");
		 }catch(Exception e) {
			 Log.addMessage("Failed to click back button in recover password page");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to click back button in recover password page");
		 }
	}
	
	
	@SuppressWarnings("unchecked")
  	@Test
  	public void valFrgtPasswordMobileKeyboardTest() {
  		 try {
  			 ForgotPasswordPage fp = new ForgotPasswordPage((AppiumDriver<MobileElement>) driver);
  			 Thread.sleep(27000);//for test in between
  			 fp.reEnterPasswordDoneKey();
  			 fp.clickOKButton();
  			 Log.addMessage("Clicked Done button in keyboard");
  			 Thread.sleep(5000);
  		 }catch(Exception e) {
  			 Log.addMessage("Failed to click Done button in keyboard");
  			 e.printStackTrace();
  		 }
  	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="validChangePwd")
	public void validFrgtPasswordChangeTest(String vCode, String nwPwd, String reNewPwd) {
		 try {
			 ForgotPasswordPage fp = new ForgotPasswordPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 //System.out.println("Wait for Wifi and BLE ON");
			// Thread.sleep(27000);//for testing in between
			 Thread.sleep(7000);
			//get the verification code from email
			 System.out.println("Wait for retrieving verification code from email");
			 if(device.equals("android")) {
				// cv.readMobileCodeFromRcvrEmail("email.address3", "email.password3");//for android
				 cv.readMobileCodeFromRcvrWzEmail("email.address3", "email.password3");//for android
			 }else {
				// cv.readEmailCodeFromRcvrEmail("email.address5", "email.password5");//for iOS kwikset and below code for weiser
				 cv.readMobileCodeFromRcvrWzEmail("email.address5", "email.password5");//for iOS
			 }
			 fp.changePassword(nwPwd, reNewPwd);
			 Thread.sleep(2000);
			 
			 if(device.equals("iOS")) {
				 //below code for kwikset added for iOS on 15-Mar-2021
				// fp.clickOKButton();//commented for Weiser
				 fp.clickReturnLoginButton();
			 }else {
				 fp.clickOKButton();
			 }
			 LoginPage lp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 lp.checkLoginButton();
			 
			 Log.addMessage("Password updated");
		 }catch(Exception e) {
			 Log.addMessage("Failed to change password");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to change password");
		 }
	}
	
	
	//added below hyper link test code on 26-02-2021
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vurl")
	public void changePwdEmailHyperLinksTest(String url1, String url2,String url3,String url4,String url5,String url6, String url7, String url8) {
		 try {
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 Utility.simpleWait(10000);//tested for iOS
			 cv.readHyperLinksFromEmail("email.address3", "email.password3", url1, url2, url3, url4, url5, url6, url7, url8);
			 if(device.equals("iOS")) {
				Utility.simpleWait(10000);
			 }
			 Log.addMessage("Verified hyperlinks in create account");
		 }catch(Exception e) {
			 Log.addMessage("Failed to verify hyperlinks in create account");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to verify  hyperlinks in create account");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vrecoverlogin")
	public void reLoginAfterRcvrPwdLogoutPopupTest(String email, String password) {
		 try {
			 LoginPage lp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 
			 System.out.println("user login");
			 lp.login(email, password);
			 Thread.sleep(10000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 //cp.readCode_email_reg("email.address3", "email.password3");//commented on 19-02-2021
			 cp.readCodeFromEmail("email.address3", "email.password3");
			 cp.clickSubmitButton(); 
			 Thread.sleep(2000);
			 cp.clickNotNowButton();
			 Log.addMessage("Logged in after password recovery");
		 }catch(Exception e) {
			 Log.addMessage("Failed to log in after recover password");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to log in after recover password");
		 }
	}
	
	//added for iOS create flow check message
	@SuppressWarnings("unchecked")
	@Test(dataProvider="valSessionPopup")
	public void valGlblSessionExpirePopupTest(String ttlMessage, String valMessage) {
		 try {
			 EnterPasswordPage cp = new EnterPasswordPage((AppiumDriver<MobileElement>) driver);
			 cp.verifySuccessSessionPopUp( ttlMessage, valMessage);
			//cp.clickOKButton();
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter login credentials"); 
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter login credentials");
		 }
	}
	 
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vrecoverlogin")
	public void reLoginAfterRecoverPasswordTest(String email, String password) {
		 try {
			 LoginPage lp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 
			 System.out.println("user login");
			 lp.login(email, password);
			 Thread.sleep(10000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 //cp.readCode_email_reg("email.address3", "email.password3");//commented on 19-02-2021
			 cp.readCodeFromEmail("email.address3", "email.password3");
			 cp.clickSubmitButton(); 
			 Log.addMessage("Logged in after session expired");
		 }catch(Exception e) {
			 Log.addMessage("Failed to log in after session expired");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to log in after session expired");
		 }
	}
	
	 @SuppressWarnings("unchecked")
     @Test
   	 public void validRecoverCanTouchTest() {
   		 try {
   			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
   			// if(device.contentEquals("iOS")) {
   				 cvp.clickNotNowButton();
   			 //}
   			 Log.addMessage("Clicked not now button ");
   		 }catch(Exception e) {
   			 Log.addMessage("Failed to click not now button");
   			 e.printStackTrace();
   			 Assert.assertTrue(false, "Failed to click not now button");
   		 }
   	 }
	 
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vrecoverlogin")
	public void navToAccountSettingsPageTest(String email, String password) {
		 try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("user login");
			 ld.clickHamburgerButton();
			 mp.clickAccountSettingsButton();
			 Thread.sleep(2000);
			 Log.addMessage("Logged in after password recovery");
		 }catch(Exception e) {
			 Log.addMessage("Failed to log in after recover password");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to log in after recover password");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="PwdChng")
	public void validPasswordChangeAgnTest(String oldPassword, String newPassword) {
		try {
			 AccountSettingsPage as = new AccountSettingsPage((AppiumDriver<MobileElement>) driver);
			 UpdatePasswordPage up = new UpdatePasswordPage((AppiumDriver<MobileElement>) driver);
			 Utility.simpleWait(3000);
			 as.clickChangePasswordOption();
			 up.enterOldPassword(oldPassword);
			 up.enterNewPassword(newPassword);
			 up.reEnterNewPassword(newPassword);
			 up.clickSubmitButton();
			 if(device.equals("iOS")) {
				 up.clickOkButton();//added for Weiser ios
			 }
			 Utility.simpleWait(5000);
			 Log.addMessage("Password updated successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to update password");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update password");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vchpwdlogin")
	public void reLoginAfterChngPwdAgnTest(String email, String password) {
		 try {
			 LoginPage lp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 
			 System.out.println("user login");
			 lp.login(email, password);
			 Thread.sleep(10000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 //cp.readCode_email_reg("email.address3", "email.password3");//commented on 19-02-2021
			 cp.readCodeFromEmail("email.address3", "email.password3");
			 cp.clickSubmitButton(); 
			 Thread.sleep(2000);
			 Log.addMessage("Logged in after password recovery");
		 }catch(Exception e) {
			 Log.addMessage("Failed to log in after recover password");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to log in after recover password");
		 }
	}
	
	 @SuppressWarnings("unchecked")
     @Test
   	 public void validRecoverCanTouchAgnTest() {
   		 try {
   			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
   			// if(device.contentEquals("iOS")) {
   				 cvp.clickNotNowButton();
   			 //}
   			 Log.addMessage("Clicked not now button ");
   		 }catch(Exception e) {
   			 Log.addMessage("Failed to click not now button");
   			 e.printStackTrace();
   			 Assert.assertTrue(false, "Failed to click not now button");
   		 }
   	 }
	 
	@SuppressWarnings("unchecked")
	@Test
	public void navToAccountSettingsPageAgnTest() {
		 try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("user login");
			 ld.clickHamburgerButton();
			 mp.clickAccountSettingsButton();
			 Thread.sleep(2000);
			 Log.addMessage("Logged in after password recovery");
		 }catch(Exception e) {
			 Log.addMessage("Failed to log in after recover password");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to log in after recover password");
		 }
	}
	
	
	 
	@SuppressWarnings("unchecked")
	@Test(dataProvider="delAcPopUp")
	public void valDeleteAccountTest(String titleMsg, String valMsg, String iTitle, String iMsg) {
		 try {
			 AccountSettingsPage as = new AccountSettingsPage((AppiumDriver<MobileElement>) driver);
			 Thread.sleep(5000);
			 Thread.sleep(2000);
			 as.clickDeleteButton();
			 if(device.equals("iOS")) {
				 as.verifyDeletePopUpVerbiage(iTitle,iMsg);
			 }else {
				 as.verifyDeletePopUpVerbiage(titleMsg,valMsg);
			 }
			 as.clickCancelButton();
			 Thread.sleep(2000);
			 as.clickDeleteButton();
			 Thread.sleep(3000);
			 if(device.equals("iOS")) {
				 as.confirmDelete();
				 Thread.sleep(7000);//check again in iOS increased sleep from5 to 7sec
				 as.clickOKButton();
				 //check if 1 more account disabled/logged out pop up is displayed
			 }else {
				 as.clickOKButton();
				 Thread.sleep(5000);
				 as.clickOKButton();//deleted pop up ok button
			 }
			 Thread.sleep(7000);
			 //check for success pop up verbiage
			 Log.addMessage("Account deleted");
		 }catch(Exception e) {
			 Log.addMessage("Failed to delete account");
			 e.printStackTrace();
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="delAcPopUp")
	public void validDeleteAccountTest(String titleMsg, String valMsg, String iTitle, String iMsg) {
		 try {
			 AccountSettingsPage as = new AccountSettingsPage((AppiumDriver<MobileElement>) driver);
			 Thread.sleep(5000);
			 Thread.sleep(2000);
			 as.clickDeleteButton();
			 if(device.equals("iOS")) {
				 as.verifyDeletePopUpVerbiage(iTitle,iMsg);
			 }else {
				 as.verifyDeletePopUpVerbiage(titleMsg,valMsg);
			 }
			 as.clickCancelButton();
			 Thread.sleep(2000);
			 as.clickDeleteButton();
			 Thread.sleep(3000);
			 if(device.equals("iOS")) {
				 as.confirmDelete();
				 Thread.sleep(7000);//check again in iOS increased sleep from5 to 7sec
				 as.clickOKButton();
				 //check if 1 more account disabled/logged out pop up is displayed
			 }else {
				 as.clickOKButton();
				 Thread.sleep(5000);
				// as.clickOKButton();//deleted pop up ok button
			 }
			 Thread.sleep(7000);
			 //check for success pop up verbiage
			 Log.addMessage("Account deleted");
		 }catch(Exception e) {
			 Log.addMessage("Failed to delete account");
			 e.printStackTrace();
		 }
	}
	 
	@SuppressWarnings("unchecked")
	@Test(dataProvider="delFailPopUp")
	public void valFailToDeletePopUpTest(String valMessage) {
		 try {
			 EnterPasswordPage ep = new EnterPasswordPage((AppiumDriver<MobileElement>) driver);
			 ep.verifyDeletedFailPopUp(valMessage);
			 Thread.sleep(2000);
			 Log.addMessage("Unable to login to deleted account. Pop up verbiage verified");
		 }catch(Exception e) {
			 Log.addMessage("Failed to verify deleted account pop up");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to verify deleted account pop up");
		 }
	}
	 
	 	@SuppressWarnings("unchecked")
		@Test(dataProvider="vdellogin")
		public void valDeletedAccountLoginTest(String email, String password) {
			 try {
				 LoginPage lp = new LoginPage((AppiumDriver<MobileElement>) driver);
				 System.out.println("Deleted user login");
				 lp.login(email, password);
				 Thread.sleep(10000);
				 Log.addMessage("Entered user credentials of deleted account");
			 }catch(Exception e) {
				 Log.addMessage("Failed to enter user credentials of deleted account");
				 e.printStackTrace();
				 Assert.assertTrue(false, "Failed to enter user credentials of deleted account");
			 }
		}
    
	 	@SuppressWarnings("unchecked")
		@Test(dataProvider="delLoginPopUp")
		public void valDeletedAccountLoginPopUpTest(String valMessage,String valiMessage) {
			 try {
				 EnterPasswordPage ep = new EnterPasswordPage((AppiumDriver<MobileElement>) driver);
				 if(device.equals("iOS")) {
					 ep.verifyDeletedAccountPopUp(valiMessage);
				 }else {
					 ep.verifyDeletedAccountPopUp(valMessage); 
				 }
				 Thread.sleep(2000);
				 Log.addMessage("Unable to login to deleted account. Pop up verbiage verified");
			 }catch(Exception e) {
				 Log.addMessage("Failed to verify deleted account pop up");
				 e.printStackTrace();
				 Assert.assertTrue(false, "Failed to verify deleted account pop up");
			 }
		}
	 	
	 	@SuppressWarnings("unchecked")
		@Test(dataProvider="vdisablelogin")
		public void valDisabledAcntLoginTest(String email, String password) {
			 try {
				 LoginPage lp = new LoginPage((AppiumDriver<MobileElement>) driver);
				 System.out.println("Deleted user login");
				 lp.login(email, password);
				 Log.addMessage("Entered user credentials of disabled account");
			 }catch(Exception e) {
				 Log.addMessage("Failed to enter user credentials of disabled account");
				 e.printStackTrace();
				 Assert.assertTrue(false, "Failed to enter user credentials of disabled account");
			 }
		}
	 	
	 	@SuppressWarnings("unchecked")
		@Test(dataProvider="vdisableemail")
		public void valDisabledAcntEmailTest(String email) {
			try {
				ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
				cv.selectEmail();
				cv.clickSubmit();
				//Thread.sleep(3000);
				//ee.enterEmail(email);
				//ee.clickSubmitButton();
				Log.addMessage("Email validated");
			}catch(Exception e){
				Log.addMessage("Failed to validate email");
				e.printStackTrace();
				Assert.assertTrue(false, "Failed to validate email");
			} 
		}
		
		@SuppressWarnings("unchecked")
		@Test
		public void validDisableAcntEmailCodeTest() {
			 try {
				 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
				 Utility.simpleWait(8000);
				 // cv.readCodeFromEmailReg("email.address7", "email.password7");
				 cv.readCodeFromEmail("email.address7", "email.password7");
				 cv.clickSubmitButton(); 
				 if(device.equals("iOS")) {
					Utility.simpleWait(10000);
				 }
				 Log.addMessage("Clicked email code submit button");
			 }catch(Exception e) {
				 Log.addMessage("Failed to verify email verification code");
				 e.printStackTrace();
				 Assert.assertTrue(false, "Failed to verify email verification code");
			 }
		}
		
		 @SuppressWarnings("unchecked")
	     @Test
	   	 public void validDisabledCanTouchTest() {
	   		 try {
	   			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
	   			// if(device.contentEquals("iOS")) {
	   				 cvp.clickNotNowButton();
	   			 //}
	   			 Log.addMessage("Clicked not now button ");
	   		 }catch(Exception e) {
	   			 Log.addMessage("Failed to click not now button");
	   			 e.printStackTrace();
	   			 Assert.assertTrue(false, "Failed to click not now button");
	   		 }
	   	 }
	 	
	 	@SuppressWarnings("unchecked")
		@Test(dataProvider="disableLoginPopUp")
		public void valDisabledAcntLoginPopUpTest(String titleMsg, String valMessage) {
			 try {
				 EnterPasswordPage ep = new EnterPasswordPage((AppiumDriver<MobileElement>) driver);
				 Thread.sleep(10000);
				 ep.valDisblSuccessSessionPopUp(titleMsg,valMessage);
				 Thread.sleep(2000);
				 Log.addMessage("Unable to login to deleted account. Pop up verbiage verified");
			 }catch(Exception e) {
				 Log.addMessage("Failed to verify deleted account pop up");
				 e.printStackTrace();
				 Assert.assertTrue(false, "Failed to verify deleted account pop up");
			 }
		}
	 	
	ExcelRead excel = new ExcelRead();
	
	@DataProvider(name = "acntName")
	public Object[][] getData() throws Exception {
		return excel.getTableArray(InputData, "Validation", "ValUserName");
	}
	
	@DataProvider(name = "validAcntName")
	public Object[][] getDataVUName() throws Exception {
		return excel.getTableArray(InputData, "App", "ValidUserName");
	}
	
	@DataProvider(name = "validDelAcntName")
	public Object[][] getDataVUDelName() throws Exception {
		return excel.getTableArray(InputData, "App", "ValidDelUserName");
	}
	
	@DataProvider(name = "email")
	public Object[][] getDataEmail() throws Exception {
		return excel.getTableArray(InputData, "Validation", "ValEmail");
	}
	
	@DataProvider(name = "phvalidemail")
	public Object[][] getDataPVEmail() throws Exception {
		return excel.getTableArray(InputData, "App", "ValidPhEmail");
	}
	
	@DataProvider(name = "rcvremail")
	public Object[][] getDataRcvrEmail() throws Exception {
		return excel.getTableArray(InputData, "Validation", "ValRcvrEmail");
	}
	
	@DataProvider(name = "emailVerify")
	public Object[][] getDataEmlVrefy() throws Exception {
		return excel.getTableArray(InputData, "Validation", "ValEmailVerify");
	}
	
	@DataProvider(name = "rcvrLink")
	public Object[][] getDataEmlRcvr() throws Exception {
		return excel.getTableArray(InputData, "App", "RecoverEmail");
	}
	
	@DataProvider(name = "mobile")
	public Object[][] getDataPhone() throws Exception {
		return excel.getTableArray(InputData, "Validation", "PhoneVal");
	}
	
	@DataProvider(name = "valphone")
	public Object[][] getDataPhoneValid() throws Exception {
		return excel.getTableArray(InputData, "App", "PhoneValid");
	}
	
	@DataProvider(name = "emailCntnt")
	public Object[][] getDataEContent() throws Exception {
		return excel.getTableArray(InputData, "App", "EmailContnt");
	}
	
	@DataProvider(name = "emailCntntChPass")
	public Object[][] getDataEContentPass() throws Exception {
		return excel.getTableArray(InputData, "App", "EmailContntChngPass");
	}
	
	@DataProvider(name = "emailCntntPhReuse")
	public Object[][] getDataPhReUseContentPass() throws Exception {
		return excel.getTableArray(InputData, "App", "EmailContntPhReUse");
	}
	
	@DataProvider(name = "emailCntntChange")
	public Object[][] getDataEContentChg() throws Exception {
		return excel.getTableArray(InputData, "App", "ChPassEmailContnt");
	}
	
	@DataProvider(name = "wifiOfflogout")
	public Object[][] getDataPopuplogout() throws Exception {
		return excel.getTableArray(InputData, "App", "LogoutPopUp");
	}
	
	@DataProvider(name = "mobileVerify")
	public Object[][] getDataPhVerify() throws Exception {
		return excel.getTableArray(InputData, "Validation", "PhoneVerification");
	}
	
	@DataProvider(name = "vSecQn")
	public Object[][] getDataQn() throws Exception {
		return excel.getTableArray(InputData, "Validation", "ValSecurityAnswers");
	}
	
	@DataProvider(name = "vISecQn")
	public Object[][] getDataIQn() throws Exception {
		return excel.getTableArray(InputData, "Validation", "ValISecurityAnswers");
	}
	
	@DataProvider(name = "dupQn1")
	public Object[][] getDataDupQn1() throws Exception {
		return excel.getTableArray(InputData, "App", "ValDupQn1");
	}
	
	@DataProvider(name = "valISecQn")
	public Object[][] getDataVIQn() throws Exception {
		return excel.getTableArray(InputData, "App", "ValidISecurityAnswers");
	}
	
	@DataProvider(name = "valSecQn")
	public Object[][] getDataVQn() throws Exception {
		return excel.getTableArray(InputData, "App", "ValidSecurityAnswers");
	}
	
	@DataProvider(name = "vRcvrSecQn")
	public Object[][] getDataRcvrQn() throws Exception {
		return excel.getTableArray(InputData, "Validation", "ValRcvrSecurityAnswer");
	}
	
	@DataProvider(name = "validRcvrSecQn")
	public Object[][] getDataRcvalidrQn() throws Exception {
		return excel.getTableArray(InputData, "Validation", "ValidRcvrSecurityAnswer");
	}
	
	@DataProvider(name = "ValidatePwd")
	public Object[][] getDataPwd() throws Exception {		
		return excel.getTableArray(InputData, "Validation", "PasswordNewVal");
	}
	
	@DataProvider(name = "ValPwd")
	public Object[][] getDataVPwd() throws Exception {		
		return excel.getTableArray(InputData, "App", "ValidPhPassword");
	}
	
	@DataProvider(name = "login")
	public Object[][] getDataLogin() throws Exception {
		return excel.getTableArray(InputData, "Validation", "ValLogin");
	}
	
	@DataProvider(name = "vlogin")
	public Object[][] getDataVLogin() throws Exception {
		return excel.getTableArray(InputData, "App", "ValidLogin");
	}
	
	@DataProvider(name = "valChLogin")
	public Object[][] getDataValidChLogin() throws Exception {
		return excel.getTableArray(InputData, "App", "ValidChRegLogin");
	}
	
	@DataProvider(name = "vchlogin")
	public Object[][] getDataVChLogin() throws Exception {
		return excel.getTableArray(InputData, "App", "ValidChLogin");
	}
	
	@DataProvider(name = "vdellogin")
	public Object[][] getDataVDelLogin() throws Exception {
		return excel.getTableArray(InputData, "App", "ValidDelUserLogin");
	}
	
	@DataProvider(name = "vdisablelogin")
	public Object[][] getDataVDisLogin() throws Exception {
		return excel.getTableArray(InputData, "App", "ValidDisabledUserLogin");
	}
	
	@DataProvider(name = "vPhUselogin")
	public Object[][] getDataVPhLogin() throws Exception {
		return excel.getTableArray(InputData, "App", "ValidPhLogin");
	}
	
	@DataProvider(name = "vrelogin")
	public Object[][] getDataVReLogin() throws Exception {
		return excel.getTableArray(InputData, "App", "ValidReLogin");
	}
	
	@DataProvider(name = "vrecoverlogin")
	public Object[][] getDataVRecvrLogin() throws Exception {
		return excel.getTableArray(InputData, "App", "ValidRecoverLogin");
	}
	
	@DataProvider(name = "vchpwdlogin")
	public Object[][] getDatavchpwdloginLogin() throws Exception {
		return excel.getTableArray(InputData, "App", "ValidChPwdLogin");
	}
	
	@DataProvider(name = "vrcvrdisablelogin")
	public Object[][] getDataVRecvDisrLogin() throws Exception {
		return excel.getTableArray(InputData, "App", "ValidRcvrDisbledLogin");
	}
	
	@DataProvider(name = "mfapopup")
	public Object[][] getDataMFAPopUp() throws Exception {
		return excel.getTableArray(InputData, "App", "MFAPopUp");
	}
	
	@DataProvider(name = "resendPopup")
	public Object[][] getDataResend() throws Exception {
		return excel.getTableArray(InputData, "App", "ResendLimitPopup");
	}
	
	@DataProvider(name = "validChangePwd")
	public Object[][] getDataChPwd() throws Exception {
		return excel.getTableArray(InputData, "App", "ValidChangePassword");
	}
	
	@DataProvider(name = "vemail")
	public Object[][] getDataVEmail() throws Exception {
		return excel.getTableArray(InputData, "App", "ValidEmail");
	}
	
	@DataProvider(name = "vurl")
	public Object[][] getDataVUEmail() throws Exception {
		return excel.getTableArray(InputData, "App", "ValidURL");
	}
	
	@DataProvider(name = "vdisableemail")
	public Object[][] getDataVDisEmail() throws Exception {
		return excel.getTableArray(InputData, "App", "ValidDisEmail");
	}
	
	@DataProvider(name = "validemail")
	public Object[][] getDataValEmail() throws Exception {
		return excel.getTableArray(InputData, "App", "ValidAccountName");
	}
	
	@DataProvider(name = "vphone")
	public Object[][] getDataVPhone() throws Exception {
		return excel.getTableArray(InputData, "App", "ValidPhone");
	}
	
	@DataProvider(name = "vmobile")
	public Object[][] getDataVMPhone() throws Exception {
		return excel.getTableArray(InputData, "App", "ValidEmailPhone");
	}
	
	
	@DataProvider(name = "vldSecQn")
	public Object[][] getDataVSQn() throws Exception {
		return excel.getTableArray(InputData, "App", "ValidSQuestion");
	}
	
	@DataProvider(name = "VPwd")
	public Object[][] getDataVPass() throws Exception {
		return excel.getTableArray(InputData, "App", "ValidPassword");
	}
	
	@DataProvider(name = "createPopUp")
	public Object[][] getDataCreatePopUp() throws Exception {
		return excel.getTableArray(InputData, "App", "CrAccountPopup");
	}
	
	@DataProvider(name = "vEditphone")
	public Object[][] getDataEditPhone() throws Exception {
		return excel.getTableArray(InputData, "App", "PhoneValid");
	}
	
	@DataProvider(name = "vldSecEQn")
	public Object[][] getDataVESQn() throws Exception {
		return excel.getTableArray(InputData, "App", "ValidSEQuestion");
	}
	
	/*@DataProvider(name = "resendEmailRcvrPopup")
	public Object[][] getDataResendRcvrEmail() throws Exception {
		return excel.getTableArray(InputData, "App", "ResendLimitPopup");
	}
	
	@DataProvider(name = "resendMobileRcvrPopup")
	public Object[][] getDataResendRcvrMobile() throws Exception {
		return excel.getTableArray(InputData, "App", "ResendLimitPopup");
	}*/
	
	@DataProvider(name = "delAcPopUp")
	public Object[][] getDataDelPopUp() throws Exception {
		return excel.getTableArray(InputData, "App", "DeleteAccountPopUp");
	}
	
	@DataProvider(name = "delLoginPopUp")
	public Object[][] getDataDelLPopUp() throws Exception {
		return excel.getTableArray(InputData, "App", "DelAccountPopup");
	}
	
	@DataProvider(name = "delFailPopUp")
	public Object[][] getDataDelFlPopUp() throws Exception {
		return excel.getTableArray(InputData, "App", "DelFailPopup");
	}
	
	@DataProvider(name = "disableLoginPopUp")
	public Object[][] getDataDisLPopUp() throws Exception {
		return excel.getTableArray(InputData, "App", "DisAccountPopup");
	}
	
	@DataProvider(name = "chngAcntName")
	public Object[][] getDataAcntName() throws Exception {
		return excel.getTableArray(InputData, "Validation", "UserDetails");
	}
	
	@DataProvider(name = "editPhnNum")
	public Object[][] getDataPhNum() throws Exception {
		return excel.getTableArray(InputData, "Validation", "EditPhoneVal");
	}
	
	@DataProvider(name = "ValidateEditPwd")
	public Object[][] getDataChangePwd() throws Exception {		
		return excel.getTableArray(InputData, "Validation", "PasswordVal");
	}
	
	@DataProvider(name = "PwdChng")
	public Object[][] getDataChngPwd() throws Exception {		
		return excel.getTableArray(InputData, "App", "PasswordChange");
	}
	
	@DataProvider(name = "emailCntntChPwd")
	public Object[][] getDataChPassContent() throws Exception {
		return excel.getTableArray(InputData, "Portal", "ChPassEmailContnt");
	}
	
	@DataProvider(name = "verifyPassword")
	public Object[][] getDataVrfyPass() throws Exception {
	return excel.getTableArray(InputData, "Validation", "PasswordForgotVal");
	}
	
	@DataProvider(name = "verifyMblPassword")
	public Object[][] getDataVrfyMblPass() throws Exception {
	return excel.getTableArray(InputData, "Validation", "PasswordForgotVal");
	}
	
	@DataProvider(name = "valCreatePopup")
	public Object[][] getDataCreatePopup() throws Exception {
	return excel.getTableArray(InputData, "App", "CreatePopUp");
	}
	
	@DataProvider(name = "valSessionPopup")
	public Object[][] getDataSessionPopup() throws Exception {
	return excel.getTableArray(InputData, "App", "SessionPopup");
	}
	
	@DataProvider(name = "bioLoginPopup")
	public Object[][] getDataBioLoginPopup() throws Exception {
	return excel.getTableArray(InputData, "App", "ChPwdBioLogin");
	}
	
}
