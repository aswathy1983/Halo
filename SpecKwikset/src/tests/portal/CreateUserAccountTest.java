package tests.portal;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.app.ForgotPasswordPage;
import pages.portal.BrandNeutralPage;
import pages.portal.ChooseVerificationMethodPage;
import pages.portal.ConfirmationPage;
import pages.portal.CreateAnAccountPage;
import pages.portal.EmailVerificationPage;
import pages.portal.EnterCodePage;
import pages.portal.ForgotPasswordEnterPasswordPage;
import pages.portal.LoginPage;
import pages.portal.MobilePhoneVerificationPage;
import pages.portal.SecretQuestionsPage;
import pages.portal.UserHomePage;
import utility.ExcelRead;
import utility.Log;
import utility.Utility;

/*
 * TEST CASE: Check whether user is able to successfully register in Spectrum Cloud
 */

public class CreateUserAccountTest extends Settings{
	
	int cnt, emailcnt, emailvcnt, mobilevcnt, mobilecnt, secCnt = 0;
	 
	@Test(priority=1)
	public void betaUserLogin() {
		if(!((environment.equals("24x7"))||(environment.equals("QA2")))) {
		try {
			System.out.println("in pageurl="+getPageURL());
			open(getPageURL());
			System.out.println("after open url");
			/*BetaJumpPage bp = new BetaJumpPage(driver);
			bp.verifyJumpPage();*/
		}catch(Exception e) {
			Log.addMessage("Failed to login as Beta user");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to login as Beta User");
		}
		}
		else {
			System.out.println("three");
			open(getPageURL());
		}
	}
	
 @Test(dataProvider="brand",priority=2)
	public void chooseBrandTest(String brand) {
		try {
			BrandNeutralPage bn = new BrandNeutralPage(driver);
			bn.chooseBrand(brand);
		}catch(Exception e) {
			Log.addMessage("Failed to choose brand");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to choose brand");
		}
	}
	
	@SuppressWarnings("static-access")
	@Test(dataProvider="title",priority=3)
	public void clickCreateAnAccountLinkTest(String expectedTitle) {
		try {
			LoginPage lp = new LoginPage(driver);
			Utility.simpleWait(3000);
			lp.verifyPageTitle(expectedTitle);
			lp.clickCreateAccount();
			Log.addMessage("Started registration");
		}catch(Exception e) {
			Log.addMessage("New account creation encountered some errors");
			e.printStackTrace();
			Assert.assertTrue(false, "Some errors found in registration");
		}
	}
	
	@Test(dataProvider = "userTxtDetails",priority = 4)
	public void verifyAccountNameTextTest(String firstname,String lastname) {
		try {
			CreateAnAccountPage cp = new CreateAnAccountPage(driver);
			Thread.sleep(3000);
			cp.checkAcNamePlaceHolderText(firstname,lastname);
			Thread.sleep(5000);
		}catch(Exception e) {
			Log.addMessage("Failed to enter user details");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to enter user details");
		}
	}
	
	@Test(priority = 5)
	public void clickAllLinksTest() {
		try {
			CreateAnAccountPage cp = new CreateAnAccountPage(driver);
			Thread.sleep(3000);
			//Store the current window handle
			System.out.println("one");
			String winHandleBefore = driver.getWindowHandle();
			cp.clickTermsLink();
			Thread.sleep(5000);
			cp.toSwitchWindow(winHandleBefore);
			System.out.println("two");
			cp.clickPrivacyLink();
			Thread.sleep(5000);
			cp.toSwitchWindow(winHandleBefore);
			System.out.println("three");
			cp.clickTermsConditionLink();
			Thread.sleep(5000);
			cp.toSwitchWindow(winHandleBefore);
			System.out.println("four");
			cp.clickEULALink();
			Thread.sleep(5000);
			cp.toSwitchWindow(winHandleBefore);
			System.out.println("five");
			cp.clickTermsAndConditionsCheckBox();
			driver.switchTo().defaultContent();
			cp.clickEULAcheckBox();
			
			Thread.sleep(5000);
			System.out.println("six");
		}catch(Exception e) {
			Log.addMessage("Failed to enter user details");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to enter user details");
		}
	}
	
	@Test(dataProvider="vuserDetails",priority = 6)
	public void valUserDetailsTest(String firstname,String lastname,String firstNameValMsg,String lastNameValMsg) {
		try {
			CreateAnAccountPage cp = new CreateAnAccountPage(driver);
			cnt=cnt+1;
			cp.enterFirstName(firstname);
			if(firstNameValMsg!="") {
				cp.invalidFirstNameCheck(firstNameValMsg);
			}
			cp.enterLastName(lastname);
			if(lastNameValMsg!="") {
				cp.invalidLastNameCheck(lastNameValMsg);
			}
			if(cnt==1) {
				cp.clickCaptchaCheckBox();
				cp.clickTermsAndConditionsCheckBox();
				cp.clickEULAcheckBox();
				cp.checkNextButton();
			}else if(cnt==2) {
				cp.clickTermsAndConditionsCheckBox();
				cp.clickEULAcheckBox();
			}
			Thread.sleep(5000);
			Log.addMessage("User details entered successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to enter user details");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to enter user details");
		}
	}
	
	@Test(dataProvider = "userDetails",priority = 7)
	public void enterUserDetailsTest(String firstname,String lastname) {
		try {
			CreateAnAccountPage cp = new CreateAnAccountPage(driver);
			Thread.sleep(3000);
			cp.enterFirstName(firstname);
			cp.enterLastName(lastname);
			cp.clickCaptchaCheckBox();
			cp.clickTermsAndConditionsCheckBox();
			cp.clickEULAcheckBox();
			cp.clickNextButton();
			Thread.sleep(5000);
			Log.addMessage("User details entered successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to enter user details");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to enter user details");
		}
	}

	@Test(dataProvider = "backVpopup", priority = 8)
	public void checkBackButtonPopupTest(String popupMessage, String loginPopupMessage) {
		try {
			ConfirmationPage cp = new ConfirmationPage(driver);
			cp.validateBackButtonpopup(popupMessage);
			Utility.simpleWait(4000);
			Log.addMessage("Back button popup displayed");
		}catch(Exception e) {
			Log.addMessage("Failed to display popup on clicking browser back button");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display popup on clicking browser back button");
		}
	}
	
	@Test(dataProvider = "vEmail",priority=10)
	public void valEmailVerificationTest(String email, String valMessage,String alertMessage) {
		try {
			EmailVerificationPage ep = new EmailVerificationPage(driver);
			emailcnt = emailcnt + 1;
			ep.enterEmail(email);
			if(emailcnt==1) {
				ep.checkSendButton();
			}else if(alertMessage!=""){
				ep.clickSendButton();
			}
			if(valMessage!="") {
				ep.invalidEmailCheck(valMessage);
			}
			
			if(alertMessage!="") {
				ep.invalidEmailAlertCheck(alertMessage);
			}
			Log.addMessage("Email address of the user verified successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to verify user's email address");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify user's email address");
		}
	}
	
	@Test(dataProvider = "emailVerification",priority=11)
	public void emailVerificationTest(String email) {
		try {
			EmailVerificationPage ep = new EmailVerificationPage(driver);
			ep.enterEmailAndVerify(email);
			/*ep.enterVerificationCode();
			ep.clickVerifyButton();*/
			Log.addMessage("Email address of the user verified successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to verify user's email address");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify user's email address");
		}
	}
	
	@Test(dataProvider = "vemailVerification",priority=12)
	public void valEmailVerificationCodeTest(String code,String valMessage, String alertMessage) {
		try {
			EmailVerificationPage ep = new EmailVerificationPage(driver);
			emailvcnt = emailvcnt+1;
			ep.invalidVerificationCode(code);
			if(valMessage!="") {
				ep.invalidEmailCheck(valMessage);
			}
			if(emailvcnt==1) {
				ep.checkVerifyButton();
			}else {
				ep.clickVerifyButton();
			}
			if(alertMessage!="") {
				ep.invalidEmailAlertCheck(alertMessage);
			}
			Log.addMessage("Email address of the user verified successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to verify user's email address");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify user's email address");
		}
	}
	
	@Test(dataProvider = "emailVerification",priority=13)
	public void validEmailVerificationTest(String email) {
		try {
			EmailVerificationPage ep = new EmailVerificationPage(driver);
			ep.enterEmailAndVerify(email);
			ep.enterVerificationCode();
			ep.clickVerifyButton();
			Log.addMessage("Email address of the user verified successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to verify user's email address");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify user's email address");
		}
	}
	
	@Test(dataProvider = "vmobileVerification",priority=14)
	public void valMobileVerificationTest(String phoneNumber, String valMessage) {
		try {
			MobilePhoneVerificationPage mp = new MobilePhoneVerificationPage(driver);
			mobilecnt = mobilecnt + 1;
			mp.enterPhoneNumber(phoneNumber);
			if(valMessage!="") {
				mp.invalidPhoneCheck(valMessage);
			}
			System.out.println("valMessage="+valMessage);
			if(mobilecnt==1) {
				mp.checkSendButton();
			}else if(valMessage.equals("")) {
				System.out.println("in null");
				mp.clickSendButton();
			}
			Log.addMessage("Phone Number of the user verified successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to verify user's phone number");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify user's phone number");
		}
	}
	
	@Test(dataProvider = "vmobileCodeVerification",priority=15)
	public void valMobileVerificationCodeTest(String code, String alertMessage) {
		try {
			MobilePhoneVerificationPage mp = new MobilePhoneVerificationPage(driver);
			mobilevcnt = mobilevcnt+1;
			mp.invalidVerificationCode(code);
			if(mobilevcnt==1) {
				mp.checkVerifyButton();
			}else {
				mp.clickVerifyButton();
			}
			if(alertMessage!="") {
				mp.invalidMobileAlertCheck(alertMessage);
			}
			Log.addMessage("Mobile number of the user verified successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to verify user's mobile number");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify user's mobile number");
		}
	}
	
	@Test(dataProvider = "mobileVerification",priority=16)
	public void mobileVerificationTest(String phoneNumber) {
		try {
			MobilePhoneVerificationPage mp = new MobilePhoneVerificationPage(driver);
			mp.enterPhoneAndVerify(phoneNumber);
			mp.enterVerificationCode();
			System.out.println("two");
			mp.clickVerifyButton();
			System.out.println("three");
			Log.addMessage("Phone Number of the user verified successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to verify user's phone number");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify user's phone number");
		}
	}
	
	@Test(dataProvider = "vsecretQuestion",priority = 17)
	public void valSetUpSecretQuestionsTest(String question1, String answer1, String question2, String answer2, String question3, String answer3, String valMsg1, String valMsg2, String valMsg3) {
		try {
			SecretQuestionsPage sp = new SecretQuestionsPage(driver);
			System.out.println("answer1="+answer1+", answer2="+answer2+", answer3="+answer3);
			sp.secretQuestion1(question1, answer1);
			sp.secretQuestion2(question2, answer2);
			sp.secretQuestion3(question3, answer3);
			if(valMsg1!="") {
				sp.invalidAns1Check();
			}
			if(valMsg2!="") {
				sp.invalidAns2Check();
			}
			if(valMsg3!="") {
				sp.invalidAns3Check();
			}
			System.out.println("valMsg1="+valMsg1);
			if(valMsg1.equals("") && valMsg2.equals("") && valMsg3.equals("")) {
				System.out.println("in null message");
				sp.checkUpdateButton();
			}
			
			Log.addMessage("Secret Questions setup completed");
		}catch(Exception e) {
			Log.addMessage("Failed to set up Secret Questions");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to set up Secret Questions ");
		}
	}
	
	@Test(dataProvider = "secretQuestion",priority = 18)
	public void setUpSecretQuestionsTest(String question1, String answer1, String question2, String answer2, String question3, String answer3) {
		try {
			SecretQuestionsPage sp = new SecretQuestionsPage(driver);
			Thread.sleep(5000);
			sp.secretQuestion1(question1, answer1);
			sp.secretQuestion2(question2, answer2);
			sp.secretQuestion3(question3, answer3);
			sp.clickUpdateButton();
			Thread.sleep(5000);
			Log.addMessage("Secret Questions setup completed");
		}catch(Exception e) {
			Log.addMessage("Failed to set up Secret Questions");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to set up Secret Questions ");
		}
	}

	@Test(dataProvider = "vpassword",priority = 19)
	public void valRegistrationConfirmationTest(String password,String repassword, String pMessage, String rMessage) {
		try {
			ConfirmationPage cp = new ConfirmationPage(driver);
			cp.valEnterPassword(password,repassword);
			
			if(pMessage!="") {
				System.out.println("pMessage="+pMessage);
				cp.invalidPasswordCheck();
			}
			if(rMessage!="") {
				System.out.println("rMessage="+rMessage);
				cp.invalidRePasswordCheck();
			}
			
			if(pMessage.equals("") && rMessage.equals("")) {
				System.out.println("in null message");
				cp.checkConfirmButton();
			}
			Utility.simpleWait(4000);
			Log.addMessage("Password verified successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to verify password");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify password");
		}
	}
	
	@Test(dataProvider = "validpassword", priority = 20)
	public void registrationConfirmationTest(String password) {
		try {
			ConfirmationPage cp = new ConfirmationPage(driver);
			cp.enterPassword(password);
			cp.clickConfirmButton();
			Utility.simpleWait(4000);
			Log.addMessage("A new user is registered successfully in Spectrum Cloud");
		}catch(Exception e) {
			Log.addMessage("Failed to register new user");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to register");
		}
	}
	
	@Test(priority = 21)
	public void verifyUILoginTest() {
		try {
			LoginPage cp = new LoginPage(driver);
			cp.verifyUILogin();
			Utility.simpleWait(4000);
			Log.addMessage("Back button popup displayedd");
		}catch(Exception e) {
			Log.addMessage("Failed to display popup on clicking browser back button");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display popup on clicking browser back button");
		}
	}
	
	@Test(dataProvider="login", priority = 22)
	public void valLoginTest(String email, String password, String titleMessage1, String titleMessage2, String errMessage) {
		 try {
			LoginPage lp = new LoginPage(driver);
			lp.userLogin(email, password);
			if(errMessage.equals("")) {
				System.out.println("in null message");
				lp.checkLoginButton();
			}else {
				lp.clickLoginButton();
			}
			if(errMessage!="") {
				lp.incorrectUserAlertMessageCheck(); 
			}
			if(titleMessage1!="") {
				lp.invalidEmailCheck(titleMessage1);
			}
			if(titleMessage2!="") {
				lp.invalidPasswordCheck(titleMessage2);
			}
			System.out.println("errMessage="+errMessage);
			
			Log.addMessage("Login details entered");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter login credentials");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter login credentials");
		 }
	}
	
	@Test(dataProvider="validlogin", priority = 23)
	public void validLoginTest(String email, String password) {
		 try {
			 Thread.sleep(10000);//to test in btwn
			LoginPage lp = new LoginPage(driver);
			
			lp.enterLoginDetails(email, password);
			Log.addMessage("User logged in");
		 }catch(Exception e) {
			 Log.addMessage("Failed to login");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to login");
		 }
	}
	
	@Test(priority = 24)
	public void valMFATest() {
		try {
			ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
			cvm.checkSendCodeButton();
			Utility.simpleWait(4000);
			Log.addMessage("No selection made.");
			
		}catch(Exception e) {
			Log.addMessage("Failed to display disabled send button");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display disabled send button");
		}
	}
	
	@Test(dataProvider = "backVpopup", priority = 25)
	public void checkBrowserBackLoginTest(String popupMessage, String loginPopupMessage) {
		try {
			ConfirmationPage cp = new ConfirmationPage(driver);
			cp.validateBackButtonpopup(loginPopupMessage);
			//driver.switchTo().alert().accept();
			//Log.addMessage("Clicked leave button in the pop up");
			Utility.simpleWait(4000);
			Log.addMessage("Back button popup displayedd");
		}catch(Exception e) {
			Log.addMessage("Failed to display popup on clicking browser back button");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display popup on clicking browser back button");
		}
	}
	
	@Test(priority = 26)
	public void selectMFATest() {
		try {
			ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
			cvm.clickEmailNewButton();
			cvm.clickSendCodeButton();
			Utility.simpleWait(4000);
			Log.addMessage("Selected Email option");
		}catch(Exception e) {
			Log.addMessage("Failed to select email option");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to select email option");
		}
	}
	
	@Test(dataProvider = "vemailVerification",priority=27)
	public void valEmailVerifyCodeLoginTest(String code,String valMessage, String alertMessage) {
		try {
			EnterCodePage ep = new EnterCodePage(driver);
			ep.invalidVerificationCode(code,valMessage,alertMessage);
			
			Log.addMessage("Email address of the user verified successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to verify user's email address");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify user's email address");
		}
	}
	
	@Test(priority=28)
	public void invalidCodeRetryLimitTest() {
		try {
			EnterCodePage ep = new EnterCodePage(driver);
			Utility.simpleWait(5000);
			ep.isCodeInvalidRetryLimitMessageDisplayed();
			
			Log.addMessage("Email address of the user verified successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to verify user's email address");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify user's email address");
		}
	}
	
	@Test(dataProvider="validlogin", priority = 29)
	public void validReLoginTest(String email, String password) {
		 try {
			LoginPage lp = new LoginPage(driver);
			ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
			EnterCodePage ep = new EnterCodePage(driver);
			lp.enterLoginDetails(email, password);
			Log.addMessage("User logged in");
			cvm.clickEmailNewButton();
			cvm.clickSendCodeButton();
			Utility.simpleWait(4000);
			Log.addMessage("Selected Email option");
			//commented for testing by manually entering the verification code
			Utility.simpleWait(10000);
			//ep.enterCode();
		 }catch(Exception e) {
			 Log.addMessage("Failed to login");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to login");
		 }
	}
	
	@Test(priority = 30)
	public void logoutTest() {
		try {
			UserHomePage up=new UserHomePage(driver);
			up.clickHamburgerMenuButton();
			up.clickLogout();
			//betaUserLogin();
			Log.addMessage("User Logged out successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to logout");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to logout");
		}
	}
	
	@Test(dataProvider="validlogin", priority = 31)
	public void loginResendTest(String email, String password) {
		 try {
			LoginPage lp = new LoginPage(driver);
			ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
			lp.enterLoginDetails(email, password);
			Log.addMessage("User logged in");
			cvm.clickEmailNewButton();
			cvm.clickSendCodeButton();
			Utility.simpleWait(4000);
			Log.addMessage("Selected Email option");
		 }catch(Exception e) {
			 Log.addMessage("Failed to login");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to login");
		 }
	}
	
	@Test(dataProvider="resendPopup", priority = 32)
	public void valEmailResendLimitTest(String popupMsg, String ipopupMsg) {
		 try {
			 EnterCodePage ep = new EnterCodePage(driver);
			 for(int i=0;i<5;i++) {
				ep.clickResendButton();
				if(i==0) {
					ep.verifyResendPopUpVerbiage(popupMsg);
					ep.clickCloseButton();
				}
				 Thread.sleep(5000);
			 }
			 //check the popup verbiage for resend limits
			 Thread.sleep(5000);
			 ep.clickResendButton();
			 ep.verifyResendPopUpVerbiage(ipopupMsg);
			 //cv.clickOKButton();
			 Log.addMessage("Resend limits set");
		 }catch(Exception e) {
			 Log.addMessage("Resend limits not set for Email verification code");
			 e.printStackTrace();
		 }
	}
	//validEmailResendLoginTest method
	//logoutResendTest method
	
	@Test(dataProvider="validlogin", priority = 33)
	public void validPhoneLoginTest(String email, String password) {
		 try {
			LoginPage lp = new LoginPage(driver);
			ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
			lp.enterLoginDetails(email, password);
			Log.addMessage("User logged in");
			cvm.clickPhoneNewButton();
			cvm.clickSendCodeButton();
			Utility.simpleWait(4000);
			Log.addMessage("Selected Phone option");
		 }catch(Exception e) {
			 Log.addMessage("Failed to login");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to login");
		 }
	}
	
	@Test(dataProvider = "vmobileCodeVerification",priority=34)
	public void valPhoneVerifyCodeLoginTest(String code,String valMessage, String alertMessage) {
		try {
			EnterCodePage ep = new EnterCodePage(driver);
			ep.invalidVerificationCode(code,valMessage,alertMessage);
			
			Log.addMessage("Phone number of the user verified successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to verify user's phone number");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify user's phone number");
		}
	}
	
	@Test(priority=35)
	public void invalidPhoneCodeRetryLimitTest() {
		try {
			EnterCodePage ep = new EnterCodePage(driver);
			Utility.simpleWait(5000);
			ep.isCodeInvalidRetryLimitMessageDisplayed();
			
			Log.addMessage("Phone number of the user verified successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to verify user's phone number");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify user's phone number");
		}
	}
	
	@Test(dataProvider="validlogin", priority = 36)
	public void validRePhoneLoginTest(String email, String password) {
		 try {
			LoginPage lp = new LoginPage(driver);
			ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
			EnterCodePage ep = new EnterCodePage(driver);
			lp.enterLoginDetails(email, password);
			Log.addMessage("User logged in");
			cvm.clickPhoneNewButton();;
			cvm.clickSendCodeButton();
			Utility.simpleWait(4000);
			Log.addMessage("Selected Mobile option");
			//commented for testing by manually entering the verification code
			Utility.simpleWait(15000);
			//ep.enterCode();
		 }catch(Exception e) {
			 Log.addMessage("Failed to login");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to login");
		 }
	}
	
	@Test(priority = 37)
	public void logoutPhoneTest() {
		try {
			UserHomePage up=new UserHomePage(driver);
			up.clickHamburgerMenuButton();
			up.clickLogout();
			//betaUserLogin();
			Log.addMessage("User Logged out successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to logout");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to logout");
		}
	}
	
	@Test(dataProvider="validlogin", priority = 38)
	public void loginPhoneResendTest(String email, String password) {
		 try {
			LoginPage lp = new LoginPage(driver);
			ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
			lp.enterLoginDetails(email, password);
			Log.addMessage("User logged in");
			cvm.clickPhoneNewButton();
			cvm.clickSendCodeButton();
			Utility.simpleWait(4000);
			Log.addMessage("Selected Email option");
		 }catch(Exception e) {
			 Log.addMessage("Failed to login");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to login");
		 }
	}
	
	@Test(dataProvider="resendPopup", priority = 39)
	public void valPhoneResendLimitTest(String popupMsg, String ipopupMsg) {
		 try {
			 EnterCodePage ep = new EnterCodePage(driver);
			 for(int i=0;i<5;i++) {
				ep.clickResendButton();
				if(i==0) {
					ep.verifyResendPopUpVerbiage(popupMsg);
					ep.clickCloseButton();
				}
				 Thread.sleep(5000);
			 }
			 //check the popup verbiage for resend limits
			 Thread.sleep(5000);
			 ep.clickResendButton();
			 ep.verifyResendPopUpVerbiage(ipopupMsg);
			 //cv.clickOKButton();
			 Log.addMessage("Resend limits set");
		 }catch(Exception e) {
			 Log.addMessage("Resend limits not set for Email verification code");
			 e.printStackTrace();
		 }
	}
	
	@Test(priority = 40)
	public void selForgotPasswordTest() {
		 try {
			LoginPage lp = new LoginPage(driver);
			Utility.simpleWait(10000);
			//below code required if coming back after some activities in user login page - check
			//driver.switchTo().alert().accept();
			lp.clickForgotPassword();
			Log.addMessage("Clicked forgot password link");
			Utility.simpleWait(4000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to login");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to login");
		 }
	}
	
	@Test(priority = 41)
	public void verifyUIEmailRecoverTest() {
		 try {
			EmailVerificationPage ev=new EmailVerificationPage(driver);
			ev.verifyUIEmailRecover();
			Log.addMessage("UI elements displayed in email confirmation page.");
			Utility.simpleWait(2000);
			driver.navigate().back(); 
			Utility.simpleWait(4000);
			LoginPage lp = new LoginPage(driver);
			lp.clickForgotPassword();
			Utility.simpleWait(4000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to login");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to login");
		 }
	}
	
	@Test(dataProvider = "vRcvrEmail",priority=43)
	public void valEmailVerificationRecoverTest(String email, String valMessage,String alertMessage) {
		try {
			EmailVerificationPage ep = new EmailVerificationPage(driver);
			emailcnt = emailcnt + 1;
			ep.enterEmail(email);
			if(valMessage!="") {
				ep.invalidEmailCheck(valMessage);
			}
			if(emailcnt==1) {
				ep.checkSendButton();
			}else if(alertMessage!=""){
				ep.clickSendButton();
			}
			if(alertMessage!="") {
				ep.invalidEmailAlertCheck(alertMessage);
				ep.clickCloseButton();
			}
			Log.addMessage("Email address of the user verified successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to verify user's email address");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify user's email address");
		}
	}
	
	@Test(dataProvider = "backVpopup", priority = 44)
	public void checkBackButtonRcvrTest(String popupMessage, String loginPopupMessage) {
		try {
			ConfirmationPage cp = new ConfirmationPage(driver);
			cp.validateBackButtonpopup(popupMessage);
			Utility.simpleWait(7000);
			Log.addMessage("Back button popup displayedd");
		}catch(Exception e) {
			Log.addMessage("Failed to display popup on clicking browser back button");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display popup on clicking browser back button");
		}
	}
	
	@Test(dataProvider = "vRcvrValEmail",priority = 40)
	public void clickForgotPasswordTest(String valEmail) {
		 try {
			LoginPage lp = new LoginPage(driver);
			EmailVerificationPage ep = new EmailVerificationPage(driver);
			Utility.simpleWait(10000);
			lp.clickForgotPassword();
			Log.addMessage("Clicked forgot password link");
			ep.enterEmail(valEmail);
			ep.clickSendButton();
			Utility.simpleWait(4000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to login");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to login");
		 }
	}
	
	@Test(dataProvider = "vRcvrScrty",priority=45)
	public void valSecurityQuestionRecoverTest(String question1,String answer1,String valMessage, String alertMessage) {
		try {
			SecretQuestionsPage sp = new SecretQuestionsPage(driver);
			secCnt=secCnt+1;
			if(secCnt==1) {
				sp.placeHolderAnsTextCheck();
			}
			System.out.println("answer1="+answer1);
			if(question1!="") {
				sp.rcvrSecretQuestion(question1, answer1);
			}
			if(alertMessage!="") {
				System.out.println("in click button");
				sp.clickUpdateRcvrButton();
				//sp.cl
				Utility.simpleWait(5000);
			}else  {
				System.out.println("in check button");
				sp.checkUpdateRcvrButton();
			}
			
			if(alertMessage!="" && alertMessage!="Success") {
				sp.checkUpdateMessage(alertMessage);
			}
			if(valMessage!="") {
				sp.invalidAnsCheck(valMessage);
			}
			
			System.out.println("valMsg1="+valMessage);
			Log.addMessage("Secret Questions setup completed");
		}catch(Exception e) {
			Log.addMessage("Failed to set up Secret Questions");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to set up Secret Questions ");
		}
	}
	
	@Test(priority = 46)
	public void verifyUIMFATest() {
		try {
			ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);

			Thread.sleep(10000);//for test
			cvm.verifyUIMFA();
			cvm.checkSendRcvrCodeButton();
			Utility.simpleWait(4000);
			Log.addMessage("Selected Email option");
		}catch(Exception e) {
			Log.addMessage("Failed to select email option");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to select email option");
		}
	}
	
	@Test(priority = 47)
	public void valMFARcvrTest() {
		try {
			ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
			cvm.checkSendRcvrCodeButton();
			Utility.simpleWait(4000);
			Log.addMessage("No selection made.");
			
		}catch(Exception e) {
			Log.addMessage("Failed to display disabled send button");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display disabled send button");
		}
	}
	
	@Test(priority = 48)
	public void selectRcvrMFATest() {
		try {
			ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
			cvm.clickEmailNewRcvrButton();
			cvm.clickSendRcvrCodeButton();
			Utility.simpleWait(4000);
			Log.addMessage("Selected Email option");
		}catch(Exception e) {
			Log.addMessage("Failed to select email option");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to select email option");
		}
	}
	
	@Test(dataProvider="verifyPassword",priority = 49)
	public void valFrgtVerifyPassEmailTest(String vcode, String nwpass, String renewpass, String valMessage1, String valMessage2, String alertMessage) {
		 try {
			 ForgotPasswordEnterPasswordPage fp = new ForgotPasswordEnterPasswordPage(driver);
			 fp.validateRecoverPassword(vcode, nwpass, renewpass, valMessage1, valMessage2, alertMessage,"email");		
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter Email credentials");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter Email credentials");
		 }
	}
	
	@Test(dataProvider="resendPopup", priority = 50)
	public void valRcvrEmailResendLimitTest(String popupMsg, String ipopupMsg) {
		 try {
			 ForgotPasswordEnterPasswordPage ep = new ForgotPasswordEnterPasswordPage(driver);
			 for(int i=0;i<5;i++) {
				ep.clickResendButton();
				if(i==0) {
					System.out.println("in 1");
					ep.verifyValidationVerbiage(popupMsg);
					ep.clickCloseButton();
					System.out.println("after close");
				}
				 Thread.sleep(5000);
			 }
			 System.out.println("after limt");
			 //check the popup verbiage for resend limits
			 Thread.sleep(5000);
			 ep.clickResendButton();
			 System.out.println("after limit click again");
			 ep.verifyValidationVerbiage(ipopupMsg);
			 System.out.println("after limit verify verbiage");
			 //cv.clickOKButton();
			 Log.addMessage("Resend limits set");
		 }catch(Exception e) {
			 Log.addMessage("Resend limits not set for Email verification code");
			 e.printStackTrace();
		 }
	}
	

	@Test(dataProvider="valResendPassword", priority = 51)
	public void validRcvrResendEmailCodeTest(String pwd, String confPwd, String updateMessage) {
		 try {
			 ForgotPasswordEnterPasswordPage ep = new ForgotPasswordEnterPasswordPage(driver);
			 //check -> click resend button again and read resend code from email
			 ep.clickResendButton();
			// ep.enterVerificationCode();
			 ep.enterCode("123456");
			 System.out.println("Wait to manually enter verification code from email");
			 Utility.simpleWait(15000);
			 ep.enterNewPassword(pwd);
			 ep.reEnterPassword(confPwd);
			 ep.clickConfirmButton();
			 Thread.sleep(5000);
			 System.out.println("validating success verbiage");
			 ep.verifyValidationVerbiage(updateMessage);
			 ep.clickCloseButton();
			 Log.addMessage("Resend limits set");
		 }catch(Exception e) {
			 Log.addMessage("Resend limits not set for Email verification code");
			 e.printStackTrace();
		 }
	}
	
	@Test(dataProvider="valRecoverMobile", priority = 51)
	public void selForgotPasswordMobileTest(String email, String question1, String answer1) {
		 try {
			 LoginPage lp = new LoginPage(driver);
			 EmailVerificationPage ev = new EmailVerificationPage(driver);
			 SecretQuestionsPage sp = new SecretQuestionsPage(driver);
			 ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
			 System.out.println("inside selForgotPasswordMobileTest");
			 Utility.simpleWait(15000);
			 lp.clickForgotPassword();
			 Log.addMessage("Clicked forgot password link");
			 Utility.simpleWait(4000);
			 ev.enterEmail(email);	
			 Log.addMessage("Entered email");
			 Utility.simpleWait(4000);
			 sp.rcvrSecretQuestion(question1, answer1);
			 Log.addMessage("Entered security answer");
			 Utility.simpleWait(4000);
			 sp.clickUpdateRcvrButton(); 
			 Log.addMessage("Clicked next button");
			 Utility.simpleWait(4000);
			 cvm.clickPhoneNewRcvrButton();
			 cvm.clickSendRcvrCodeButton();
			 Utility.simpleWait(4000);
			 System.out.println("validating success verbiage");
			
			 Log.addMessage("Resend limits set");
		 }catch(Exception e) {
			 Log.addMessage("Resend limits not set for Email verification code");
			 e.printStackTrace();
		 }
	}
	
	@Test(dataProvider="verifyPassword",priority = 49)
	public void valFrgtVerifyPassMobileTest(String vcode, String nwpass, String renewpass, String valMessage1, String valMessage2, String alertMessage) {
		 try {
			 ForgotPasswordEnterPasswordPage fp = new ForgotPasswordEnterPasswordPage(driver);
			 fp.validateRecoverPassword(vcode, nwpass, renewpass, valMessage1, valMessage2, alertMessage,"mobile");		
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter Email credentials");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter Email credentials");
		 }
	}
	
	@Test(dataProvider="resendPopup", priority = 50)
	public void valRcvrMobileResendLimitTest(String popupMsg, String ipopupMsg) {
		 try {
			 ForgotPasswordEnterPasswordPage ep = new ForgotPasswordEnterPasswordPage(driver);
			 for(int i=0;i<5;i++) {
				ep.clickResendButton();
				if(i==0) {
					System.out.println("in 1");
					ep.verifyValidationVerbiage(popupMsg);
					ep.clickCloseButton();
					System.out.println("after close");
				}
				 Thread.sleep(5000);
			 }
			 System.out.println("after limt");
			 //check the popup verbiage for resend limits
			 Thread.sleep(5000);
			 ep.clickResendButton();
			 System.out.println("after limit click again");
			 ep.verifyValidationVerbiage(ipopupMsg);
			 System.out.println("after limit verify verbiage");
			 //cv.clickOKButton();
			 Log.addMessage("Resend limits set");
		 }catch(Exception e) {
			 Log.addMessage("Resend limits not set for Email verification code");
			 e.printStackTrace();
		 }
	}
	//check below code for priority
	@Test(dataProvider="valResendPassword", priority = 52)
	public void validRcvrResendMobileCodeTest(String pwd, String confPwd, String updateMessage) {
		 try {
			 ForgotPasswordEnterPasswordPage ep = new ForgotPasswordEnterPasswordPage(driver);
			 //check -> click resend button again and read resend code from email
			 ep.clickResendButton();
			// ep.enterVerificationCode();
			 ep.enterCode("123456");
			 System.out.println("Wait to manually enter verification code from email");
			 Utility.simpleWait(15000);
			 ep.enterNewPassword(pwd);
			 ep.reEnterPassword(confPwd);
			 ep.clickConfirmButton();
			 Thread.sleep(5000);
			 System.out.println("validating success verbiage");
			 ep.verifyValidationVerbiage(updateMessage);
			 ep.clickCloseButton();
			 Log.addMessage("Resend limits set");
		 }catch(Exception e) {
			 Log.addMessage("Resend limits not set for Email verification code");
			 e.printStackTrace();
		 }
	}
	
	ExcelRead excel = new ExcelRead();
	
	@DataProvider(name = "brand")
	public Object[][] getData() throws Exception {
	return excel.getTableArray(InputData, "Portal", "Brand");
	}

	@DataProvider(name = "title")
	public Object[][] getData1() throws Exception {
	return excel.getTableArray(InputData, "Portal", "Title");
	}
	
	@DataProvider(name = "userDetails")
	public Object[][] getData2() throws Exception {
	return excel.getTableArray(InputData, "Portal", "UserDetails");
	}
	
	@DataProvider(name = "userTxtDetails")
	public Object[][] getDataTxt2() throws Exception {
	return excel.getTableArray(InputData, "Portal", "UserTextDetails");
	}
	
	@DataProvider(name = "emailVerification")
	public Object[][] getData3() throws Exception {
	return excel.getTableArray(InputData, "Portal", "EmailVerification");
	}
	
	@DataProvider(name = "mobileVerification")
	public Object[][] getData4() throws Exception {
	return excel.getTableArray(InputData, "Portal", "MobileVerification");
	}
	
	@DataProvider(name = "secretQuestion")
	public Object[][] getData5() throws Exception {
	return excel.getTableArray(InputData, "Portal", "SecretQuestion");
	}
	
	@DataProvider(name = "validpassword")
	public Object[][] getData6() throws Exception {
	return excel.getTableArray(InputData, "App", "Password");
	}
	
	@DataProvider(name = "vuserDetails")
	public Object[][] getData7() throws Exception {
	return excel.getTableArray(InputData, "Portal", "ValUserName");
	}
	
	@DataProvider(name = "vEmail")
	public Object[][] getData8() throws Exception {
	return excel.getTableArray(InputData, "Portal", "ValEmail");
	}
	
	@DataProvider(name = "vemailVerification")
	public Object[][] getData9() throws Exception {
	return excel.getTableArray(InputData, "Portal", "ValEmailVerify");
	}
	
	@DataProvider(name = "vmobileVerification")
	public Object[][] getData10() throws Exception {
	return excel.getTableArray(InputData, "Portal", "phoneVal");
	}
	
	@DataProvider(name = "vmobileCodeVerification")
	public Object[][] getData11() throws Exception {
	return excel.getTableArray(InputData, "Portal", "ValPhoneVerify");
	}
	
	@DataProvider(name = "vsecretQuestion")
	public Object[][] getData12() throws Exception {
	return excel.getTableArray(InputData, "Portal", "ValSecurityQn");
	}
	
	@DataProvider(name = "vpassword")
	public Object[][] getData13() throws Exception {
	return excel.getTableArray(InputData, "Portal", "PasswordNewVal");
	}
	
	@DataProvider(name = "backVpopup")
	public Object[][] getDatabackpopup() throws Exception {
	return excel.getTableArray(InputData, "Portal", "BackBtnPopUp");
	}
	
	@DataProvider(name = "login")
	public Object[][] getDataLogin() throws Exception {
	return excel.getTableArray(InputData, "Portal", "ValLogin");
	}
	
	@DataProvider(name = "validlogin")
	public Object[][] getDataVLogin() throws Exception {
	return excel.getTableArray(InputData,"Portal", "ValidLogin");
	}
	
	@DataProvider(name = "resendPopup")
	public Object[][] getDataResend() throws Exception {
	return excel.getTableArray(InputData, "Portal", "ResendLimit");
	}
	
	@DataProvider(name = "vRcvrEmail")
	public Object[][] getDataResendRcvrEmail() throws Exception {
	return excel.getTableArray(InputData, "Portal", "ValRecoverEmail");
	}
	
	@DataProvider(name = "vRcvrScrty")
	public Object[][] getDataResendRcvrScrty() throws Exception {
	return excel.getTableArray(InputData, "Portal", "ValRcvrSecurityAnswer");
	}
	
	@DataProvider(name = "vRcvrValEmail")
	public Object[][] getDataResendRcvrEml() throws Exception {
	return excel.getTableArray(InputData, "Portal", "EmailVerification");
	}
	
	@DataProvider(name = "valResendPassword")
	public Object[][] getDatsUpdatePwd() throws Exception {
	return excel.getTableArray(InputData, "Portal", "ValPasswordMessage");
	}
	
	@DataProvider(name = "verifyPassword")
	public Object[][] getDataVrfyPass() throws Exception {
	return excel.getTableArray(InputData, "Portal", "PasswordForgotVal");
	}
	
	@DataProvider(name = "valRecoverMobile")
	public Object[][] getDataRcvrMobile() throws Exception {
	return excel.getTableArray(InputData, "Portal", "PasswordForgotMobileVal");
	}

}
