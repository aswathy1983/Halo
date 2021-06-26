package tests.portal;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Settings;
import pages.portal.BetaJumpPage;
import pages.portal.BrandNeutralPage;
import pages.portal.ChangePasswordPage;
import pages.portal.ChooseVerificationMethodPage;
import pages.portal.ConfirmationPage;
import pages.portal.CreateAnAccountPage;
import pages.portal.DeleteMyAccountPage;
import pages.portal.EditProfilePage;
import pages.portal.EmailVerificationPage;
import pages.portal.EnableDisableAccountPage;
import pages.portal.EnterCodePage;
import pages.portal.ForgotPasswordEnterPasswordPage;
import pages.portal.HomeManagementPage;
import pages.portal.LockDetailsPage;
import pages.portal.LockHistoryPage;
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

public class ConsumerAccountTest extends Settings{
	
	int cnt, emailcnt, emailvcnt, mobilevcnt, mobilecnt, secCnt, cntHist, cntTime, cntLkHist, cntLkTime = 0;
	 
	@Test
	public void openPageURL() {
		System.out.println("open");
		if(!((environment.equals("24x7"))||(environment.equals("QA2")))) {
			try {
				System.out.println("in pageurl="+getPageURL());
				open(getPageURL());
				System.out.println("after open url");
			}catch(Exception e) {
				Log.addMessage("Failed to login as Beta user");
				e.printStackTrace();
				Assert.assertTrue(false, "Failed to login as Beta User");
			}
		}else {
			System.out.println("three");
			open(getPageURL());
		}
	}
	
	@Test
	public void verifyJumpPage() {
		try {	
			System.out.println("after login");
			BetaJumpPage bp = new BetaJumpPage(driver);
			bp.verifyBrandJumpPage();
		}catch(Exception e) {
			Log.addMessage("Failed to display jump page");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display jump page");
		}
	}

	@Test(dataProvider="vbrand")
	public void chooseBrandWeiserTest(String brand) {
		try {
			BrandNeutralPage bn = new BrandNeutralPage(driver);
			bn.chooseBrand(brand);
		}catch(Exception e) {
			Log.addMessage("Failed to choose brand");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to choose brand");
		}
	}
	
	@Test
	public void clickAllLinksWeiserTest() {
		try {
			CreateAnAccountPage cp = new CreateAnAccountPage(driver);
			Thread.sleep(3000);
			//Store the current window handle
			System.out.println("one");
			String winHandleBefore = driver.getWindowHandle();
			//cp.clickTermsLink();//commented on 17-02-2021
			//Thread.sleep(5000);
			//cp.toSwitchWindow(winHandleBefore);
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
			Thread.sleep(5000);
		}catch(Exception e) {
			Log.addMessage("Failed to enter user details");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to enter user details");
		}
	}
	
	@Test
	public void clickAllFooterLinksWeiserTest() {
		try {
			CreateAnAccountPage cp = new CreateAnAccountPage(driver);
			Thread.sleep(3000);
			//Store the current window handle
			System.out.println("one");
			String winHandleBefore = driver.getWindowHandle();
			System.out.println("two");
			cp.clickSupportLink();
			Thread.sleep(5000);
			cp.toSwitchSupportWeiserWindow(winHandleBefore,"support");
			Thread.sleep(5000);
			System.out.println("three");
			cp.clickProductLink();
			Thread.sleep(5000);
			cp.toSwitchSupportWeiserWindow(winHandleBefore,"product");
			Thread.sleep(5000);
			System.out.println("four");
			cp.clickAppLink();
			Thread.sleep(5000);
			cp.toSwitchSupportWeiserWindow(winHandleBefore,"app");
			System.out.println("five");
			cp.clickWebAccessibilityLink();
			Thread.sleep(5000);
			cp.closeWebAccessibility();
			Thread.sleep(5000);
			cp.clickVersionInfoLink();
			Thread.sleep(5000);
			cp.closeWebAccessibility();
			System.out.println("six");
		}catch(Exception e) {
			Log.addMessage("Failed to enter user details");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to enter user details");
		}
	}
	
	@Test(dataProvider = "userDetails")
	public void enterWZUserDetailsTest(String firstname,String lastname) {
		try {
			CreateAnAccountPage cp = new CreateAnAccountPage(driver);
			Thread.sleep(3000);
			cp.enterFirstName(firstname);
			cp.enterLastName(lastname);
			/*cp.clickCaptchaCheckBox();//commented for test in between else comment it
			cp.clickTermsAndConditionsCheckBox();//commented as its already checked from previous methods
			cp.clickEULAcheckBox();*/
			cp.clickNextButton();
			Thread.sleep(5000);
			Log.addMessage("User details entered successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to enter user details");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to enter user details");
		}
	}
	
	@Test(dataProvider = "emailVerification")
	public void validWZEmailVerificationTest(String email) {
		try {
			EmailVerificationPage ep = new EmailVerificationPage(driver);
			ep.enterEmailAndVerify(email);
			/*ep.readCodeFromEmail("email.address3", "email.password3","reg");
			ep.clickVerifyButton(); */
			Log.addMessage("Email address of the user verified successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to verify user's email address");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify user's email address");
		}
	}
	
	@Test(dataProvider="vurlwz")
	public void createAcntWZEmailHyperLinksTest(String url1, String url2,String url3,String url4,String url5) {
		 try {
			 EmailVerificationPage cv = new EmailVerificationPage(driver);
			// Utility.simpleWait(20000);//to test in bbtwn
			 Utility.simpleWait(8000);
			 cv.readHyperLinksFromEmailRegWZ("email.address3", "email.password3", url1, url2, url3, url4, url5);
			
			 Log.addMessage("Verified hyperlinks in create account");
		 }catch(Exception e) {
			 Log.addMessage("Failed to verify hyperlinks in create account");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to verify  hyperlinks in create account");
		 }
	}
	
	@Test
	public void createAccountWZResendTest() {
		 try {
			 EmailVerificationPage ev = new EmailVerificationPage(driver);
			 Utility.simpleWait(8000);
			 ev.clickSendButton();
			 Utility.simpleWait(2000);
			 Log.addMessage("Email validated");
		 }catch(Exception e) {
			 Log.addMessage("Failed to verify hyperlinks in create account");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to verify  hyperlinks in create account");
		 }
	}
	
	@Test(dataProvider="emailCntntWZ")
	public void createAccountWZEmailContentTest(String emailText, String frmAdrs) {
		 try {
			 EmailVerificationPage cvp = new EmailVerificationPage(driver);
			 Thread.sleep(5000);
			 System.out.println("wait to retrieve verification code from email");
			 cvp.readContentFromEmail("email.address3", "email.password3",emailText,frmAdrs);
			 Log.addMessage("Entered valid email verification code");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter valid email verification code.");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter valid email verification code.");
		 }
			
	}
	
	@Test
	public void createAccountAccountWZBackAgnTest() {
		 try {
			 EmailVerificationPage ev = new EmailVerificationPage(driver);
			 Utility.simpleWait(8000);
			 ev.clickSendButton();
			 Utility.simpleWait(2000);
			 Log.addMessage("Email validated");
		 }catch(Exception e) {
			 Log.addMessage("Failed to verify hyperlinks in create account");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to verify  hyperlinks in create account");
		 }
	}
	
	@Test
	public void validCrtAcntWZEmailCodeTest() {
		 try {
			 EmailVerificationPage ep = new EmailVerificationPage(driver);
			 ep.readCodeFromEmail("email.address3", "email.password3","reg");
			 ep.clickVerifyButton(); 
			 Log.addMessage("Clicked email code submit button");
		 }catch(Exception e) {
			 Log.addMessage("Failed to verify email verification code");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to verify email verification code");
		 }
	}
	
	
	@Test(dataProvider = "valMobileVerification")
	public void mobileWZVerificationTest(String phoneNumber) {
		try {
			MobilePhoneVerificationPage mp = new MobilePhoneVerificationPage(driver);
			mp.enterPhoneAndVerify(phoneNumber);
			//mp.enterVerificationCode();
			System.out.println("two");
			mp.readMobileCodeFromEmail("email.address5", "email.password5");
			mp.clickVerifyButton();
			System.out.println("three");
			Log.addMessage("Phone Number of the user verified successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to verify user's phone number");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify user's phone number");
		}
	}
	
	@Test(dataProvider = "secretQuestion")
	public void setUpWZSecretQuestionsTest(String question1, String answer1, String question2, String answer2, String question3, String answer3) {
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
	
	@Test(dataProvider = "validPwd")
	public void registrationWZConfirmationTest(String password) {
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
	
	@Test
	public void verifyWZUILoginTest() {
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
	
	@Test(dataProvider="validlogin")
	public void validWZLoginTest(String email, String password) {
		 try {
			 //Thread.sleep(10000);//to test in btwn
			 LoginPage lp = new LoginPage(driver);
			 lp.enterLoginDetails(email, password);
			 ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
			 cvm.checkSendCodeButton();
			 Log.addMessage("User logged in");
		 }catch(Exception e) {
			 Log.addMessage("Failed to login");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to login");
		 }
	}
	
	@Test
	public void selectWZMFATest() {
		try {
			ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
			cvm.clickPhoneNewButton();
			cvm.clickSendCodeButton();
			Utility.simpleWait(4000);
			Log.addMessage("Selected Email option");
		}catch(Exception e) {
			Log.addMessage("Failed to select email option");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to select email option");
		}
	}
	
	@Test(dataProvider = "valMobileVerification")
	public void validWZPhoneCodeTest(String phoneNumber) {
		 try {
			    MobilePhoneVerificationPage mp = new MobilePhoneVerificationPage(driver);
				//mp.enterPhoneAndVerify(phoneNumber);
				//mp.enterVerificationCode();
				System.out.println("two");
				mp.readMobileCodeLoginEmail("email.address5", "email.password5");
				Utility.simpleWait(4000);//to enter by reading from email
				mp.clickVerifySubmit();
				Utility.simpleWait(6000);
				Log.addMessage("Phone Number of the user verified successfully");
		 }catch(Exception e) {
			 Log.addMessage("Failed to login with mobile option");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to login with mobile option");
		 }
	}
	
	@Test
	public void logoutWZTest() {
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
	

	
	@Test(dataProvider="validlogin")
	public void validWZEmailLoginTest(String email, String password) {
		 try {
			LoginPage lp = new LoginPage(driver);
			ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
			lp.enterLoginDetails(email, password);
			cvm.checkSendCodeButton();
			Log.addMessage("User logged in");
		 }catch(Exception e) {
			 Log.addMessage("Failed to login");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to login");
		 }
	}
	
	@Test
	public void validWZEmailCodeTest() {
		 try {
			 EmailVerificationPage ev=new EmailVerificationPage(driver);
			 ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
			 cvm.clickEmailNewButton();
			 cvm.clickSendCodeButton();
			/* ev.readCodeFromEmail("email.address3", "email.password3","login");
			 ev.clickVerifySubButton();*/
			 Utility.simpleWait(4000);
			 Log.addMessage("Selected Email option");
			 
		 }catch(Exception e) {
			 Log.addMessage("Failed to login with email option");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to login with email option");
		 }
	}
	
	@Test(dataProvider="vurlwz")
	public void loginWZEmailHyperLinksTest(String url1, String url2,String url3,String url4,String url5) {
		 try {
			 EmailVerificationPage cv = new EmailVerificationPage(driver);
			 Utility.simpleWait(10000);//tested for iOS
			 cv.readHyperLinksFromEmailRegWZ("email.address3", "email.password3", url1, url2, url3, url4, url5);
			
			 Log.addMessage("Verified hyperlinks in create account");
		 }catch(Exception e) {
			 Log.addMessage("Failed to verify hyperlinks in create account");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to verify  hyperlinks in create account");
		 }
	}
	
	@Test
	public void loginWZResendEmailTest() {
		 try {
			 EmailVerificationPage cv = new EmailVerificationPage(driver);
			 Utility.simpleWait(8000);
			 cv.clickResendVerifyLink();
			 Log.addMessage("Clicked back button");
		 }catch(Exception e) {
			 Log.addMessage("Failed to verify hyperlinks in create account");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to verify  hyperlinks in create account");
		 }
	}
	
	@Test(dataProvider="emailCntntWZ")
	public void loginWZEmailContentTest(String emailText, String frmAdrs) {
		 try {
			EmailVerificationPage cvp = new EmailVerificationPage(driver);
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
	
	@Test
	public void loginWZResendEmailAgnTest() {
		 try {
			EmailVerificationPage cv = new EmailVerificationPage(driver);
			 Utility.simpleWait(8000);
			 cv.clickResendVerifyLink();
			 Log.addMessage("Clicked back button");
		 }catch(Exception e) {
			 Log.addMessage("Failed to verify hyperlinks in create account");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to verify  hyperlinks in create account");
		 }
	}
	
	@Test
	public void validWZEmailCodeSelTest() {
		 try {
			 EmailVerificationPage ev=new EmailVerificationPage(driver);
			 ev.readCodeFromEmail("email.address3", "email.password3","login");
			 ev.clickVerifySubButton();
			 Utility.simpleWait(4000);
			 Log.addMessage("Selected Email option");
			 
		 }catch(Exception e) {
			 Log.addMessage("Failed to login with email option");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to login with email option");
		 }
	}
	
	
	@Test
	public void validateWZChangePasswordOptionTest() {
		try {
			UserHomePage up=new UserHomePage(driver);
			ChangePasswordPage cp=new ChangePasswordPage(driver);
			Utility.simpleWait(3000);
			up.clickHamburgerMenuButton();
			up.selectChangePasswordOption();
			Log.addMessage("Change Password option selected");
			//betaUserLogin();
		}catch(Exception e) {
			Log.addMessage("Failed to select Change Password");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to select Change Password");
		}
	}
	
	@Test(dataProvider="validChangePwd")
	public void changeWZPasswordTest(String oldPassword, String newPassword) {
		try {
			UserHomePage up=new UserHomePage(driver);
			ChangePasswordPage cp=new ChangePasswordPage(driver);
			Utility.simpleWait(3000);
			
			/*up.clickHamburgerMenuButton();
			up.selectChangePasswordOption();*/
			cp.enterExistingPassword(oldPassword);
			cp.enterNewPassword(newPassword);
			cp.enterConfirmNewPassword(newPassword);
			cp.clickUpdateButton();
			Utility.simpleWait(5000);
			//cp.checkLoginButton();
			Log.addMessage("Password updated successfully");
			//betaUserLogin();
		}catch(Exception e) {
			Log.addMessage("Failed to update password");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update password");
		}
	}
	
	@Test(dataProvider="emailCntntChPwdWZ")
	public void editWZAccountEmailContentTest(String emailText, String frmAdrs) {
		 try {
			 EmailVerificationPage cvp = new EmailVerificationPage(driver);
			 Thread.sleep(7000);
			 System.out.println("wait to retrieve verification code from email");
			 cvp.readContentFromChangeAcntEmail("email.address3", "email.password3",emailText,frmAdrs);
			 Log.addMessage("Entered valid email verification code");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter valid email verification code.");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter valid email verification code.");
		 }
			
	}
	
	
	@Test
	public void verifyKWUIEmailRecoverTest() {
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
	
	@Test(dataProvider = "emailVerification")
	public void validKWEmailVerificationRcvrTest(String email) {
		try {
			EmailVerificationPage ep = new EmailVerificationPage(driver);
			ep.enterEmailAndVerify(email);
			Utility.simpleWait(7000);
			ep.readCodeFromEmail("email.address3", "email.password3","reg");
			ep.clickVerifyButton(); 
			//ep.clickVerifyButton();
			Log.addMessage("Email address of the user verified successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to verify user's email address");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify user's email address");
		}
	}
	
	@Test(dataProvider = "validRcvrScrty")
	public void validKWSecurityQuestionRecoverTest(String question1,String answer1) {
		try {
			SecretQuestionsPage sp = new SecretQuestionsPage(driver);
			System.out.println("answer1="+answer1);
			if(question1!="") {
				sp.rcvrSecretQuestion(question1, answer1);
			}
			sp.clickUpdateRcvrButton();
			Log.addMessage("Secret Questions answered");
		}catch(Exception e) {
			Log.addMessage("Failed to answer Secret Questions");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to answer Secret Questions ");
		}
	}

	@Test
	public void verifyKWUIMFATest() {
		try {
			ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);

			Thread.sleep(3000);//for test
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
	
	@Test
	public void selectWZRcvrMFATest() {
		try {
			ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
			//Thread.sleep(10000);
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
	
	
	@Test
	public void selKWForgotPasswordTest() {
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
	
	@Test(dataProvider="vurlwz")
	public void forgotPwdWZEmailHyperLinksTest(String url1, String url2,String url3,String url4,String url5) {
		 try {
			 EmailVerificationPage cv = new EmailVerificationPage(driver);
			 Utility.simpleWait(10000);//tested for iOS
			 cv.readHyperLinksFromEmailRegWZ("email.address3", "email.password3", url1, url2, url3, url4, url5);
			
			 Log.addMessage("Verified hyperlinks in create account");
		 }catch(Exception e) {
			 Log.addMessage("Failed to verify hyperlinks in create account");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to verify  hyperlinks in create account");
		 }
	}
	
	@Test
	public void forgotPwdWZResendTest() {
		 try {
			 EmailVerificationPage cv = new EmailVerificationPage(driver);
			 Utility.simpleWait(8000);
			 cv.clickResendVerifyLink();
			 Log.addMessage("Clicked Resend link");
			 Utility.simpleWait(2000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to click resend link");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to click resend link");
		 }
	}
	
	@Test(dataProvider="emailCntntFrgtPwdWZ")
	public void forgotPwdWZEmailCntntTest(String emailText, String frmAdrs) {
		 try {
			 EmailVerificationPage cvp = new EmailVerificationPage(driver);
			 Thread.sleep(5000);
			 System.out.println("wait to retrieve verification code from email");
			
				 cvp.readContentFromEmail("email.address3", "email.password3",emailText,frmAdrs);
			
			 Log.addMessage("Entered valid email verification code");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter valid email verification code.");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter valid email verification code.");
		 }
	}
	
	@Test
	public void forgotPwdWZResendAgnTest() {
		 try {
			 EmailVerificationPage cv = new EmailVerificationPage(driver);
			 Utility.simpleWait(8000);
			 cv.clickResendVerifyLink();
			 Log.addMessage("Clicked Resend link");
			 Utility.simpleWait(2000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to click resend link");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to click resend link");
		 }
	}
	
	@Test(dataProvider="verifyEmailPassword")
	public void validWZFrgtVerifyPassEmailTest(String nwpass, String renewpass, String valMessage1) {
		 try {
			 ForgotPasswordEnterPasswordPage fp = new ForgotPasswordEnterPasswordPage(driver);
			 EmailVerificationPage ep = new EmailVerificationPage(driver);
			 ep.readCodeFromEmail("email.address3", "email.password3","recover");
			 fp.enterNewPassword(nwpass);
			 fp.reEnterPassword(renewpass);
			 fp.clickConfirmButton();
			 Utility.simpleWait(3000);
			// fp.verifyValidationVerbiage(valMessage1);//check again
			// fp.clickCloseButton();
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter Email credentials");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter Email credentials");
		 }
	}
	
	@Test(dataProvider="validEmllogin")
	public void validWZReLoginEmailTest(String email, String password) {
		 try {
			LoginPage lp = new LoginPage(driver);
			ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
			EmailVerificationPage ev = new EmailVerificationPage(driver);
			lp.enterLoginDetails(email, password);
			Log.addMessage("User logged in");
			cvm.clickEmailNewButton();
			cvm.clickSendCodeButton();
			Utility.simpleWait(4000);
			Log.addMessage("Selected Email option");
			//commented for testing by manually entering the verification code
			//Utility.simpleWait(10000);
			ev.readCodeFromEmail("email.address3", "email.password3","login");
			//ev.clickVerifyButton(); 
			ev.clickVerifySubButton();//added on 04-Feb-2021
			//ep.enterCode();
		 }catch(Exception e) {
			 Log.addMessage("Failed to login");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to login");
		 }
	}
	
	@Test
	public void validateWZChangePasswordTest() {
		try {
			UserHomePage up=new UserHomePage(driver);
			Utility.simpleWait(8000);
			up.clickHamburgerMenuButton();
			up.selectChangePasswordOption();
			Log.addMessage("Change Password option selected");
			//betaUserLogin();
		}catch(Exception e) {
			Log.addMessage("Failed to select Change Password");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to select Change Password");
		}
	}
	
	@Test(dataProvider="validFrgtChangePwd")
	public void enblWZChangePasswordTest(String oldPassword, String newPassword) {
		try {
			UserHomePage up=new UserHomePage(driver);
			ChangePasswordPage cp=new ChangePasswordPage(driver);
			Utility.simpleWait(3000);
			
			/*up.clickHamburgerMenuButton();
			up.selectChangePasswordOption();*/
			cp.enterExistingPassword(oldPassword);
			cp.enterNewPassword(newPassword);
			cp.enterConfirmNewPassword(newPassword);
			cp.clickUpdateButton();
			Utility.simpleWait(5000);
			//cp.checkLoginButton();
			Log.addMessage("Password updated successfully");
			//betaUserLogin();
		}catch(Exception e) {
			Log.addMessage("Failed to update password");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update password");
		}
	}
	
	@Test(dataProvider="vurlwz")
	public void chngPwdWZAcntEmailHyperLinksTest(String url1, String url2,String url3,String url4,String url5) {
		 try {
			 EmailVerificationPage cv = new EmailVerificationPage(driver);
			 Utility.simpleWait(8000);
			 cv.readHyperLinksFromEmailWZ("email.address3", "email.password3", url1, url2, url3, url4, url5);
			 
			 Log.addMessage("Verified hyperlinks in create account");
		 }catch(Exception e) {
			 Log.addMessage("Failed to verify hyperlinks in create account");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to verify  hyperlinks in create account");
		 }
	}
	
	@SuppressWarnings("static-access")
	@Test(dataProvider="title")
	public void clickWZCreatePhReuseTest(String expectedTitle) {
		try {
			LoginPage lp = new LoginPage(driver);
			Utility.simpleWait(3000);
			lp.verifyPageTitle(expectedTitle);
			if(lp.checkCloseBanner()) {
				lp.clickCloseBanner();
			}
			lp.clickCreateAccount();
			Log.addMessage("Started registration");
		}catch(Exception e) {
			Log.addMessage("New account creation encountered some errors");
			e.printStackTrace();
			Assert.assertTrue(false, "Some errors found in registration");
		}
	}
	
	@Test(dataProvider = "phReUserDetails")
	public void enterWZPhReuseUserDetailsTest(String firstname,String lastname) {
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
	
	@Test(dataProvider = "phReuseEmailVerification")
	public void validWZPhReuseEmailTest(String email) {
		try {
			EmailVerificationPage ep = new EmailVerificationPage(driver);
			ep.enterEmailAndVerify(email);
			Log.addMessage("Email address of the user entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter user's email address");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to enter user's email address");
		}
	}
	
	@Test(dataProvider = "phReuseEmailVerification")
	public void validWZPhReuseEmailVerificationTest(String email) {
		try {
			EmailVerificationPage ep = new EmailVerificationPage(driver);
			ep.readCodeFromEmail("email.address6", "email.password6","reg");
			ep.clickVerifyButton(); 
			Log.addMessage("Email address of the user verified successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to verify user's email address");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify user's email address");
		}
	}
	
	@Test(dataProvider = "valMobileVerification")
	public void mobileWZVPhReuserVerificationTest(String phoneNumber) {
		try {
			MobilePhoneVerificationPage mp = new MobilePhoneVerificationPage(driver);
			mp.enterPhoneAndVerify(phoneNumber);
			mp.enterVerificationCode();
			System.out.println("two");
			mp.readMobileCodeFromEmail("email.address5", "email.password5");
			mp.clickVerifyButton();
			System.out.println("three");
			Log.addMessage("Phone Number of the user verified successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to verify user's phone number");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify user's phone number");
		}
	}
	
	@Test(dataProvider = "secretQuestion")
	public void setUpWZSecretQuestionsPhReuseTest(String question1, String answer1, String question2, String answer2, String question3, String answer3) {
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
	
	@Test(dataProvider = "validPwd")
	public void registrationWZConfirmationnPhReuseTest(String password) {
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
	
	 @Test(dataProvider="emailCntntPhReuse")
	 public void phUsedWZEmailContentTest(String emailText, String frmAdrs) {
		 try {
			 EmailVerificationPage ep = new EmailVerificationPage(driver);
			 Thread.sleep(7000);
			 System.out.println("wait to retrieve verification code from email");
			 ep.readContentFromPhReUseEmail("email.address3", "email.password3",emailText,frmAdrs);
			 Log.addMessage("Entered valid email verification code");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter valid email verification code.");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter valid email verification code.");
		 }
	 }
	 
	 @Test(dataProvider="vphReuselogin")
		public void validWZReLoginMobileTest(String email, String password) {
			 try {
				LoginPage lp = new LoginPage(driver);
				ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
				EmailVerificationPage ev = new EmailVerificationPage(driver);
				lp.enterLoginDetails(email, password);
				Log.addMessage("User logged in");
				cvm.clickEmailNewButton();
				cvm.clickSendCodeButton();
				Utility.simpleWait(4000);
				Log.addMessage("Selected Email option");
				//commented for testing by manually entering the verification code
				//Utility.simpleWait(10000);
				ev.readCodeFromEmail("email.address6", "email.password6","login");
				//ev.clickVerifyButton(); 
				ev.clickVerifySubButton();//added on 04-Feb-2021
				//ep.enterCode();
			 }catch(Exception e) {
				 Log.addMessage("Failed to login");
				 e.printStackTrace();
				 Assert.assertTrue(false, "Failed to login");
			 }
		}
	 
	 @Test(dataProvider = "valMobileVerification")
		public void mobileValidPhReuseTest(String phoneNumber) {
			try {
				MobilePhoneVerificationPage mp = new MobilePhoneVerificationPage(driver);
				mp.enterPhoneAndVerify(phoneNumber);
				mp.enterVerificationCode();
				System.out.println("two");
				Utility.simpleWait(7000);
				mp.readMobileCodeFromEmail("email.address5", "email.password5");
				mp.clickVerifyButton();
				System.out.println("three");
				Log.addMessage("Phone Number of the user verified successfully");
			}catch(Exception e) {
				Log.addMessage("Failed to verify user's phone number");
				e.printStackTrace();
				Assert.assertTrue(false, "Failed to verify user's phone number");
			}
		}
		

		@Test
		public void deleteWZPhReUseTest() {
			try {
				DeleteMyAccountPage dm = new DeleteMyAccountPage(driver);
				UserHomePage up=new UserHomePage(driver);
				Utility.simpleWait(7000);
				System.out.println("inside home page");
				up.clickHamburgerMenuButton();
				up.selectDeleteMyAccountOption();
				Utility.simpleWait(5000);
				dm.deleteCancelAccount();
				Utility.simpleWait(5000);
				dm.deleteAccount();
				Log.addMessage("Clicked Enable/Disable Account in the menu");
			}catch(Exception e) {
				Log.addMessage("Failed to update account status");
				e.printStackTrace();
				Assert.assertTrue(false, "Failed to update account status");
			}
		}

	
	
	@Test(dataProvider="validEnblogin")
	public void validWZEnblReLoginMobileTest(String email, String password) {
		 try {
			LoginPage lp = new LoginPage(driver);
			ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
			EmailVerificationPage ev = new EmailVerificationPage(driver);
			lp.enterLoginDetails(email, password);
			Log.addMessage("User logged in");
			cvm.clickEmailNewButton();
			cvm.clickSendCodeButton();
			Utility.simpleWait(4000);
			Log.addMessage("Selected Email option");
			//commented for testing by manually entering the verification code
			//Utility.simpleWait(10000);
			ev.readCodeFromEmail("email.address3", "email.password3","login");
			//ev.clickVerifyButton(); 
			ev.clickVerifySubButton();//added on 04-Feb-2021
			//ep.enterCode();
		 }catch(Exception e) {
			 Log.addMessage("Failed to login");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to login");
		 }
	}
	
	@Test(dataProvider = "valMobileVerification")
	public void mobileVPhReuseTest(String phoneNumber) {
		try {
			MobilePhoneVerificationPage mp = new MobilePhoneVerificationPage(driver);
			mp.enterPhoneAndVerify(phoneNumber);
			mp.enterVerificationCode();
			System.out.println("two");
			Utility.simpleWait(7000);
			mp.readMobileCodeFromEmail("email.address5", "email.password5");
			mp.clickVerifyButton();
			System.out.println("three");
			Log.addMessage("Phone Number of the user verified successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to verify user's phone number");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify user's phone number");
		}
	}
	
	@Test(dataProvider="validEnblogin")
	public void validWZEnblPhoneTest(String email, String password) {
		 try {
			LoginPage lp = new LoginPage(driver);
			ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
			EmailVerificationPage ev = new EmailVerificationPage(driver);
			lp.enterLoginDetails(email, password);
			Log.addMessage("User logged in");
			cvm.clickEmailNewButton();
			cvm.clickSendCodeButton();
			Utility.simpleWait(4000);
			Log.addMessage("Selected Email option");
			//commented for testing by manually entering the verification code
			//Utility.simpleWait(10000);
			ev.readCodeFromEmail("email.address3", "email.password3","login");
			//ev.clickVerifyButton(); 
			ev.clickVerifySubButton();//added on 04-Feb-2021
			//ep.enterCode();
		 }catch(Exception e) {
			 Log.addMessage("Failed to login");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to login");
		 }
	}
	

	@Test
	public void deleteWZAccountTest() {
		try {
			DeleteMyAccountPage dm = new DeleteMyAccountPage(driver);
			UserHomePage up=new UserHomePage(driver);
			Utility.simpleWait(7000);
			System.out.println("inside home page");
			up.clickHamburgerMenuButton();
			up.selectDeleteMyAccountOption();
			Utility.simpleWait(5000);
			dm.deleteCancelAccount();
			Utility.simpleWait(5000);
			dm.deleteAccount();
			Log.addMessage("Clicked Enable/Disable Account in the menu");
		}catch(Exception e) {
			Log.addMessage("Failed to update account status");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update account status");
		}
	}
	
	@Test
	public void goToHomePageWeisTest() {
		try {
			ConfirmationPage cp = new ConfirmationPage(driver);
			Utility.simpleWait(3000);
			cp.clickBrwsrBackButton();
			Utility.simpleWait(3000);
			Log.addMessage("Started registration");
		}catch(Exception e) {
			Log.addMessage("New account creation encountered some errors");
			e.printStackTrace();
			Assert.assertTrue(false, "Some errors found in registration");
		}
	}
	
	@Test
	public void reloadPageTest() {
		try {
			System.out.println("in reload test");
			System.out.println("size of cookies="+driver.manage().getCookies().size());
			String winHandleBefore = driver.getWindowHandle();
			driver.manage().deleteAllCookies();
			//((JavaScriptExecutor) driver).executeScript("document.getElementById('ID').setAttribute('target', 'self');");
			//driver.findElement(By.xpath("body")).sendKeys(Keys.COMMAND +"t");
			Utility.openNewTab();
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			System.out.println(tabs.size());
			driver.switchTo().window(tabs.get(1)); //switches to new tab
			driver.get("chrome://settings/clearBrowserData");
			for(int i = 0; i<7 ;i++) {
				System.out.println("i="+i);
				driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.TAB);
				System.out.println("after tab"+i);
			}
			driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
			System.out.println("after enter");
			Utility.simpleWait(10000);
			driver.close();
			driver.switchTo().window(winHandleBefore);
			System.out.println("size of cookies after delete="+driver.manage().getCookies().size());
			System.out.println("after deletion of cookies");
			driver.navigate().refresh();
			System.out.println("after page refresh");
		}catch(Exception e) {
			Log.addMessage("Failed to choose brand");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to choose brand");
		}
	}
	
	@Test(dataProvider="brand")
	public void chooseBrandKwiksetTest(String brand) {
		try {
			/*WebDriver driver = new ChromeDriver();
			System.out.println("in pageurl="+getPageURL());
			openWebUrl(getPageURL(), driver);*/
			LoginPage lp = new LoginPage(driver);
			lp.clickCloseBanner();
			BrandNeutralPage bn = new BrandNeutralPage(driver);
			bn.chooseBrand(brand);
		}catch(Exception e) {
			Log.addMessage("Failed to choose brand");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to choose brand");
		}
	}
	
	@SuppressWarnings("static-access")
	@Test(dataProvider="title")
	public void clickCreateAnAccountKwikLinkTest(String expectedTitle) {
		try {
			LoginPage lp = new LoginPage(driver);
			Utility.simpleWait(3000);
			lp.verifyPageTitle(expectedTitle);
			if(lp.checkCloseBanner()) {
				lp.clickCloseBanner();
			}
			lp.clickCreateAccount();
			Log.addMessage("Started registration");
		}catch(Exception e) {
			Log.addMessage("New account creation encountered some errors");
			e.printStackTrace();
			Assert.assertTrue(false, "Some errors found in registration");
		}
	}
	
	@SuppressWarnings("static-access")
	@Test(dataProvider="title")
	public void clickCreateAnAccountLinkTest(String expectedTitle) {
		try {
			LoginPage lp = new LoginPage(driver);
			Utility.simpleWait(3000);
			lp.verifyPageTitle(expectedTitle);
			if(lp.checkCloseBanner()) {
				lp.clickCloseBanner();
			}
			lp.clickCreateAccount();
			Log.addMessage("Started registration");
		}catch(Exception e) {
			Log.addMessage("New account creation encountered some errors");
			e.printStackTrace();
			Assert.assertTrue(false, "Some errors found in registration");
		}
	}
	
	@Test(dataProvider = "userTxtDetails")
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
	
	@Test
	public void clickAllLinksTest() {
		try {
			CreateAnAccountPage cp = new CreateAnAccountPage(driver);
			Thread.sleep(3000);
			//Store the current window handle
			System.out.println("one");
			String winHandleBefore = driver.getWindowHandle();
			//cp.clickTermsLink();//commented on 17-02-2021
			//Thread.sleep(5000);
			//cp.toSwitchWindow(winHandleBefore);
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
			/*cp.clickTermsAndConditionsCheckBox();
			driver.switchTo().defaultContent();
			cp.clickEULAcheckBox();*/
			
			Thread.sleep(5000);
			System.out.println("six");
		}catch(Exception e) {
			Log.addMessage("Failed to enter user details");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to enter user details");
		}
	}
	
	@Test
	public void clickAllFooterLinksTest() {
		try {
			CreateAnAccountPage cp = new CreateAnAccountPage(driver);
			Thread.sleep(3000);
			//Store the current window handle
			System.out.println("one");
			String winHandleBefore = driver.getWindowHandle();
			System.out.println("two");
			cp.clickSupportLink();
			Thread.sleep(5000);
			cp.toSwitchSupportWindow(winHandleBefore,"support");
			Thread.sleep(5000);
			System.out.println("three");
			cp.clickProductLink();
			Thread.sleep(5000);
			cp.toSwitchSupportWindow(winHandleBefore,"product");
			Thread.sleep(5000);
			System.out.println("four");
			cp.clickAppLink();
			Thread.sleep(5000);
			cp.toSwitchSupportWindow(winHandleBefore,"app");
			System.out.println("five");
			cp.clickWebAccessibilityLink();
			Thread.sleep(5000);
			cp.closeWebAccessibility();
			Thread.sleep(5000);
			cp.clickVersionInfoLink();
			Thread.sleep(5000);
			cp.closeWebAccessibility();
			System.out.println("six");
		}catch(Exception e) {
			Log.addMessage("Failed to enter user details");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to enter user details");
		}
	}
	
	@Test(dataProvider = "userDetails")
	public void enterUserDetailsTest(String firstname,String lastname) {
		try {
			CreateAnAccountPage cp = new CreateAnAccountPage(driver);
			
			cp.enterFirstName(firstname);
			cp.enterLastName(lastname);
			cp.clickCaptchaCheckBox();//commented on 23Mar2021
			//Thread.sleep(30000);//to verify images of captcha
			//cp.clickTermsAndConditionsCheckBox();//commented as its already checked from previous methods
			//cp.clickEULAcheckBox();
			cp.clickNextButton();
			Thread.sleep(5000);
			Log.addMessage("User details entered successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to enter user details");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to enter user details");
		}
	}
	
	@Test(dataProvider = "vEmail")
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
	
	@Test(dataProvider = "emailVerification")
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
	
	@Test(dataProvider = "emailVerification")
	public void validEmailVerificationTest(String email) {
		try {
			EmailVerificationPage ep = new EmailVerificationPage(driver);
			ep.enterEmailAndVerify(email);
			//ep.enterVerificationCode();
			ep.readCodeFromEmail("email.address3", "email.password3","reg");
			ep.clickVerifyButton(); 
			//ep.clickVerifyButton();
			Log.addMessage("Email address of the user verified successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to verify user's email address");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify user's email address");
		}
	}
	
	@Test(dataProvider = "vmobileVerification")
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
	
	@Test(dataProvider = "vmobileCodeVerification")
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
	
	@Test(dataProvider = "valMobileVerification")
	public void mobileVerificationTest(String phoneNumber) {
		try {
			MobilePhoneVerificationPage mp = new MobilePhoneVerificationPage(driver);
			mp.enterPhoneAndVerify(phoneNumber);
			//mp.enterVerificationCode();
			System.out.println("two");
			mp.readMobileCodeFromEmail("email.address5", "email.password5");
			mp.clickVerifyButton();
			System.out.println("three");
			Log.addMessage("Phone Number of the user verified successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to verify user's phone number");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify user's phone number");
		}
	}
	
	
	@Test(dataProvider = "secretQuestion")
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
	
	@Test(dataProvider = "validPwd")
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
	
	@Test
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
	
	@Test(dataProvider="validlogin")
	public void validLoginTest(String email, String password) {
		 try {
			 //Thread.sleep(10000);//to test in btwn
			 LoginPage lp = new LoginPage(driver);
			 lp.enterLoginDetails(email, password);
			 ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
			 cvm.checkSendCodeButton();
			 Log.addMessage("User logged in");
		 }catch(Exception e) {
			 Log.addMessage("Failed to login");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to login");
		 }
	}
	
	@Test
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
	
	@Test
	public void selectMFATest() {
		try {
			ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
			cvm.clickPhoneNewButton();
			cvm.clickSendCodeButton();
			Utility.simpleWait(4000);
			Log.addMessage("Selected Email option");
		}catch(Exception e) {
			Log.addMessage("Failed to select email option");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to select email option");
		}
	}
	
	@Test(dataProvider = "valMobileVerification")
	public void validPhoneCodeTest(String phoneNumber) {
		 try {
			    MobilePhoneVerificationPage mp = new MobilePhoneVerificationPage(driver);
				//mp.enterPhoneAndVerify(phoneNumber);
				//mp.enterVerificationCode();
				System.out.println("two");
				mp.readMobileCodeLoginEmail("email.address5", "email.password5");
				Utility.simpleWait(4000);//to enter manually from email as critical error in reading from email
				mp.clickVerifySubmit();
				Utility.simpleWait(6000);
				Log.addMessage("Phone Number of the user verified successfully");
		 }catch(Exception e) {
			 Log.addMessage("Failed to login with mobile option");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to login with mobile option");
		 }
	}
	
	@Test
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
	

	
	@Test(dataProvider="validlogin")
	public void validEmailLoginTest(String email, String password) {
		 try {
			LoginPage lp = new LoginPage(driver);
			ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
			lp.enterLoginDetails(email, password);
			cvm.checkSendCodeButton();
			Log.addMessage("User logged in");
		 }catch(Exception e) {
			 Log.addMessage("Failed to login");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to login");
		 }
	}
	
	@Test
	public void validEmailCodeTest() {
		 try {
			 EmailVerificationPage ev=new EmailVerificationPage(driver);
			 ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
			 cvm.clickEmailNewButton();
			 cvm.clickSendCodeButton();
			/* ev.readCodeFromEmail("email.address3", "email.password3","login");
			 ev.clickVerifySubButton();*/
			 Utility.simpleWait(4000);
			 Log.addMessage("Selected Email option");
			 
		 }catch(Exception e) {
			 Log.addMessage("Failed to login with email option");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to login with email option");
		 }
	}
	
	@Test(dataProvider="vurl")
	public void loginEmailHyperLinksTest(String url1, String url2,String url3,String url4,String url5,String url6, String url7, String url8) {
		 try {
			 EmailVerificationPage cv = new EmailVerificationPage(driver);
			 Utility.simpleWait(5000);
			 cv.readHyperLinksFromEmailReg("email.address3", "email.password3", url1, url2, url3, url4, url5, url6, url7, url8);
			
			 Log.addMessage("Verified hyperlinks in create account");
		 }catch(Exception e) {
			 Log.addMessage("Failed to verify hyperlinks in create account");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to verify  hyperlinks in create account");
		 }
	}
	
	@Test
	public void loginResendEmailTest() {
		 try {
			 EmailVerificationPage cv = new EmailVerificationPage(driver);
			 Utility.simpleWait(5000);
			 cv.clickResendVerifyLink();
			 Log.addMessage("Clicked back button");
		 }catch(Exception e) {
			 Log.addMessage("Failed to verify hyperlinks in create account");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to verify  hyperlinks in create account");
		 }
	}
	
	@Test(dataProvider="emailCntnt")
	public void loginEmailContentTest(String emailText, String frmAdrs) {
		 try {
			 EmailVerificationPage cvp = new EmailVerificationPage(driver);
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
	
	@Test
	public void loginResendEmailAgnTest() {
		 try {
			 EmailVerificationPage cv = new EmailVerificationPage(driver);
			 Utility.simpleWait(5000);
			 cv.clickResendVerifyLink();
			 Log.addMessage("Clicked back button");
		 }catch(Exception e) {
			 Log.addMessage("Failed to verify hyperlinks in create account");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to verify  hyperlinks in create account");
		 }
	}
	
	@Test
	public void validEmailCodeSelTest() {
		 try {
			 EmailVerificationPage ev=new EmailVerificationPage(driver);
			 ev.readCodeFromEmail("email.address3", "email.password3","login");
			
			 ev.clickVerifySubButton();
			 Utility.simpleWait(4000);
			 Log.addMessage("Selected Email option");
			 
		 }catch(Exception e) {
			 Log.addMessage("Failed to login with email option");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to login with email option");
		 }
	}
	
	@Test
	public void disableAccountTest() {
		try {
			EnableDisableAccountPage ep=new EnableDisableAccountPage(driver);
			UserHomePage up=new UserHomePage(driver);
			Utility.simpleWait(25000);
			System.out.println("inside home page");
			up.clickHamburgerMenuButton();
			up.selectEnableDisableMyAccountOption();
			Utility.simpleWait(5000);
			ep.enableDisableAccount();
			Utility.simpleWait(5000);
			Log.addMessage("Clicked Enable/Disable Account in the menu");
		}catch(Exception e) {
			Log.addMessage("Failed to update account status");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update account status");
		}
	}
 	
 	@Test(dataProvider="disablePopup")
	public void verifyDisableAccountVerbiageTest(String titleMessage, String valMessage) {
		try {
			EnableDisableAccountPage ep=new EnableDisableAccountPage(driver);
			Utility.simpleWait(3000);
			ep.verifyAlertVerbiageCancel(titleMessage, valMessage);
			Utility.simpleWait(3000);
			ep.enableDisableAccount();
			Utility.simpleWait(3000);
			ep.verifyAlertAccept();
			Utility.simpleWait(7000);
			Log.addMessage("Account status updated successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to update account status");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update account status");
		}
	}
	
	@Test(dataProvider="disableMessage")
	public void valDisableTest(String valMessage1, String valMessage2) {
		try {
			EnableDisableAccountPage ep=new EnableDisableAccountPage(driver);
			ep.verifyValidationMessage(valMessage1);
			ep.verifyDisableBannerMessage(valMessage2);
			Log.addMessage("Validation is matching");
		}catch(Exception e) {
			Log.addMessage("Failed to display avalidation");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display avalidation");
		}
	}
	
	@Test(dataProvider="enableMessage")
	public void enableAccountTest(String valMesssage) {
		try {
			EnableDisableAccountPage ep=new EnableDisableAccountPage(driver);
			UserHomePage up=new UserHomePage(driver);
			Utility.simpleWait(25000);
			System.out.println("inside home page");
			up.clickHamburgerMenuButton();
			up.selectEnableDisableMyAccountOption();
			Utility.simpleWait(5000);
			//ep.clickEnableDisableFromBanner();
			ep.enableDisableAccount();
			Utility.simpleWait(7000);
			//check this
			ep.verifyValidationMessage(valMesssage);
			Log.addMessage("Account Enabled and message verified");
		}catch(Exception e) {
			Log.addMessage("Failed to enable account status");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to enable account status");
		}
	}
	
	@Test
	public void validateChangePasswordOptionTest() {
		try {
			UserHomePage up=new UserHomePage(driver);
			ChangePasswordPage cp=new ChangePasswordPage(driver);
			Utility.simpleWait(3000);
			up.clickHamburgerMenuButton();
			up.selectChangePasswordOption();
			Log.addMessage("Change Password option selected");
			//betaUserLogin();
		}catch(Exception e) {
			Log.addMessage("Failed to select Change Password");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to select Change Password");
		}
	}
	
	@Test(dataProvider="validChangePwd")
	public void changePasswordTest(String oldPassword, String newPassword) {
		try {
			UserHomePage up=new UserHomePage(driver);
			ChangePasswordPage cp=new ChangePasswordPage(driver);
			Utility.simpleWait(3000);
			
			/*up.clickHamburgerMenuButton();
			up.selectChangePasswordOption();*/
			cp.enterExistingPassword(oldPassword);
			cp.enterNewPassword(newPassword);
			cp.enterConfirmNewPassword(newPassword);
			cp.clickUpdateButton();
			Utility.simpleWait(5000);
			//cp.checkLoginButton();
			Log.addMessage("Password updated successfully");
			//betaUserLogin();
		}catch(Exception e) {
			Log.addMessage("Failed to update password");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update password");
		}
	}
	
	@Test(dataProvider="emailCntntChPwd")
	public void editAccountEmailContentTest(String emailText, String frmAdrs) {
		 try {
			 EmailVerificationPage cvp = new EmailVerificationPage(driver);
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
	
	@Test(dataProvider="validMblogin")
	public void validReLoginTest(String email, String password) {
		 try {
			LoginPage lp = new LoginPage(driver);
			ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
			EmailVerificationPage ev = new EmailVerificationPage(driver);
			lp.enterLoginDetails(email, password);
			Log.addMessage("User logged in");
			cvm.clickEmailNewButton();
			cvm.clickSendCodeButton();
			Utility.simpleWait(4000);
			Log.addMessage("Selected Email option");
			//commented for testing by manually entering the verification code
			//Utility.simpleWait(10000);
			ev.readCodeFromEmail("email.address3", "email.password3","login");
			//ev.clickVerifyButton(); 
			ev.clickVerifySubButton();//added on 04-Feb-2021
			//ep.enterCode();
		 }catch(Exception e) {
			 Log.addMessage("Failed to login");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to login");
		 }
	}
	
	@Test
	public void validateChangeSecurityQstnsOptionTest() {
		try {
			UserHomePage up=new UserHomePage(driver);
			Utility.simpleWait(15000);
			System.out.println("inside home page");
			up.clickHamburgerMenuButton();
			up.selectChangeSecurityQuestionsOption();
			Log.addMessage("Change Security Questions option selected");
			//betaUserLogin();
		}catch(Exception e) {
			Log.addMessage("Failed to select Change Security Questions");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to select Change Security Questions");
		}
	}
	
	@Test(dataProvider="changeSecurityQuestion")
	public void changeSecurityQuestionsTest(String que1, String ans1, String que2, String ans2, String que3, String ans3) {
		try {
			UserHomePage up=new UserHomePage(driver);
			SecretQuestionsPage sp= new SecretQuestionsPage(driver);
			/*up.clickHamburgerMenuButton();
			up.selectChangeSecurityQuestionsOption();*/
			sp.secretQuestion1(que1, ans1);
			sp.secretQuestion2(que2, ans2);
			sp.secretQuestion3(que3, ans3);
			sp.clickUpdateButton();
			Log.addMessage("Secret Questions updated successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to update secret questions");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update secret questions");
		}
	}
	
	@Test(dataProvider="editProfile")
	public void editProfileTest(String firstname, String lastname, String mobileNumber) {
		try {
			UserHomePage up=new UserHomePage(driver);
			EditProfilePage ep=new EditProfilePage(driver);
			MobilePhoneVerificationPage mp = new MobilePhoneVerificationPage(driver);
			up.clickHamburgerMenuButton();
			up.selectEditProfileOption();
			//ep.validateEmail(email);
			ep.updateFirstName(firstname);
			ep.updateLastName(lastname);
			//ep.updateMobileNumber(mobileNumber);//commented on 4mar-2021
			ep.clickConfirmButton();	
			Utility.simpleWait(3000);
			//commented below code on 05-Feb-2021
			
			/*mp.clickBackButton();
			Utility.simpleWait(2000);
			ep.clickConfirmButton();
			Utility.simpleWait(3000);
			mp.clickSendButton();*/
			Utility.simpleWait(10000);
			Log.addMessage("User details updated successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to update user details");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update user details");
		}
	}
	
	@Test
	public void logoutDisableTest() {
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
	
	@Test
	public void selDsblForgotPasswordTest() {
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
	
	@Test
	public void verifyDsblUIEmailRecoverTest() {
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
	
	@Test(dataProvider = "emailVerification")
	public void validDsblEmailVerificationRcvrTest(String email) {
		try {
			EmailVerificationPage ep = new EmailVerificationPage(driver);
			ep.enterEmailAndVerify(email);
			//ep.enterVerificationCode();
			ep.readCodeFromEmail("email.address3", "email.password3","reg");
			ep.clickVerifyButton(); 
			//ep.clickVerifyButton();
			Log.addMessage("Email address of the user verified successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to verify user's email address");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify user's email address");
		}
	}
	
	@Test(dataProvider = "validDsblRcvrScrty")
	public void validDsblSecurityQuestionRecoverTest(String question1,String answer1) {
		try {
			SecretQuestionsPage sp = new SecretQuestionsPage(driver);
			System.out.println("answer1="+answer1);
			if(question1!="") {
				sp.rcvrSecretQuestion(question1, answer1);
			}
			sp.clickUpdateRcvrButton();
			Log.addMessage("Secret Questions answered");
		}catch(Exception e) {
			Log.addMessage("Failed to answer Secret Questions");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to answer Secret Questions ");
		}
	}
	
	
	@Test
	public void verifyDsblUIMFATest() {
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
	
	@Test
	public void selectDsblRcvrMFATest() {
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
	
	@Test(dataProvider="verifyEmailPassword")
	public void validDsblFrgtVerifyPassEmailTest(String nwpass, String renewpass, String valMessage1) {
		 try {
			 ForgotPasswordEnterPasswordPage fp = new ForgotPasswordEnterPasswordPage(driver);
			 EmailVerificationPage ep = new EmailVerificationPage(driver);
			 ep.readCodeFromEmail("email.address3", "email.password3","recover");
			 fp.enterNewPassword(nwpass);
			 fp.reEnterPassword(renewpass);
			 fp.clickConfirmButton();
			// fp.verifyValidationVerbiage(valMessage1);//commented for bvt
			// fp.clickCloseButton();
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter Email credentials");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter Email credentials");
		 }
	}
	
	@Test(dataProvider="validEmllogin")
	public void validDsblReLoginEmailTest(String email, String password) {
		 try {
			LoginPage lp = new LoginPage(driver);
			ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
			EmailVerificationPage ev = new EmailVerificationPage(driver);
			lp.enterLoginDetails(email, password);
			Log.addMessage("User logged in");
			cvm.clickEmailNewButton();
			cvm.clickSendCodeButton();
			Utility.simpleWait(4000);
			Log.addMessage("Selected Email option");
			//commented for testing by manually entering the verification code
			//Utility.simpleWait(10000);
			ev.readCodeFromEmail("email.address3", "email.password3","login");
			//ev.clickVerifyButton(); 
			ev.clickVerifySubButton();//added on 04-Feb-2021
			//ep.enterCode();
			Utility.simpleWait(4000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to login");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to login");
		 }
	}
	
	@Test
	public void logoutDsblEmailTest() {
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
	
	@Test(dataProvider="valDsblRecoverMobile")
	public void selDsblForgotPasswordMobileTest(String email, String question1, String answer1) {
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
			 ev.clickVerifySubButton();
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
	
	//check below code for priority
		@Test(dataProvider="valResendMobPassword")
		public void validDsblRcvrResendMobileCodeTest(String pwd, String confPwd, String updateMessage) {
			 try {
				 ForgotPasswordEnterPasswordPage ep = new ForgotPasswordEnterPasswordPage(driver);
				 MobilePhoneVerificationPage mp = new MobilePhoneVerificationPage(driver);
				 //check -> click resend button again and read resend code from email
				 ep.clickResendButton();
				// ep.enterVerificationCode();
				 Utility.simpleWait(4000);
				 mp.readMobileCodeFromCPEmail("email.address5", "email.password5");
				 mp.clickVerifyButton();
				// ep.enterCode("123456");
				 System.out.println("Wait to manually enter verification code from email");
				// Utility.simpleWait(15000);
				 ep.enterNewPassword(pwd);
				 ep.reEnterPassword(confPwd);
				 ep.clickConfirmButton();
				 Thread.sleep(5000);
				 System.out.println("validating success verbiage");
				/* ep.verifyValidationVerbiage(updateMessage);//commented for bvt check
				 ep.clickCloseButton();*/
				 Log.addMessage("Resend limits set");
			 }catch(Exception e) {
				 Log.addMessage("Resend limits not set for Email verification code");
				 e.printStackTrace();
			 }
		}
		
		@Test(dataProvider="validMblogin")
		public void validDsblReLoginMobileTest(String email, String password) {
			 try {
				LoginPage lp = new LoginPage(driver);
				ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
				EmailVerificationPage ev = new EmailVerificationPage(driver);
				lp.enterLoginDetails(email, password);
				Log.addMessage("User logged in");
				cvm.clickEmailNewButton();
				cvm.clickSendCodeButton();
				Utility.simpleWait(4000);
				Log.addMessage("Selected Email option");
				//commented for testing by manually entering the verification code
				//Utility.simpleWait(10000);
				ev.readCodeFromEmail("email.address3", "email.password3","login");
				//ev.clickVerifyButton(); 
				ev.clickVerifySubButton();//added on 04-Feb-2021
				//ep.enterCode();
			 }catch(Exception e) {
				 Log.addMessage("Failed to login");
				 e.printStackTrace();
				 Assert.assertTrue(false, "Failed to login");
			 }
		}
		
		@Test
		public void validateEnblChangePasswordOptionTest() {
			try {
				UserHomePage up=new UserHomePage(driver);
				ChangePasswordPage cp=new ChangePasswordPage(driver);
				Utility.simpleWait(3000);
				up.clickHamburgerMenuButton();
				up.selectChangePasswordOption();
				Log.addMessage("Change Password option selected");
				//betaUserLogin();
			}catch(Exception e) {
				Log.addMessage("Failed to select Change Password");
				e.printStackTrace();
				Assert.assertTrue(false, "Failed to select Change Password");
			}
		}
		
		@Test(dataProvider="validEnblChangePwd")
		public void enblChangePasswordTest(String oldPassword, String newPassword) {
			try {
				UserHomePage up=new UserHomePage(driver);
				ChangePasswordPage cp=new ChangePasswordPage(driver);
				Utility.simpleWait(3000);
				
				/*up.clickHamburgerMenuButton();
				up.selectChangePasswordOption();*/
				cp.enterExistingPassword(oldPassword);
				cp.enterNewPassword(newPassword);
				cp.enterConfirmNewPassword(newPassword);
				cp.clickUpdateButton();
				Utility.simpleWait(5000);
				//cp.checkLoginButton();
				Log.addMessage("Password updated successfully");
				//betaUserLogin();
			}catch(Exception e) {
				Log.addMessage("Failed to update password");
				e.printStackTrace();
				Assert.assertTrue(false, "Failed to update password");
			}
		}
		
		@Test(dataProvider="vurl")
		public void enblAcntEmailHyperLinksTest(String url1, String url2,String url3,String url4,String url5,String url6, String url7, String url8) {
			 try {
				 EmailVerificationPage cv = new EmailVerificationPage(driver);
				 Utility.simpleWait(8000);
				 cv.readHyperLinksFromEmail("email.address3", "email.password3", url1, url2, url3, url4, url5, url6, url7, url8);
				 Log.addMessage("Verified hyperlinks in create account");
			 }catch(Exception e) {
				 Log.addMessage("Failed to verify hyperlinks in create account");
				 e.printStackTrace();
				 Assert.assertTrue(false, "Failed to verify  hyperlinks in create account");
			 }
		}
		
		@Test(dataProvider="validEnblogin")
		public void validEnblReLoginMobileTest(String email, String password) {
			 try {
				LoginPage lp = new LoginPage(driver);
				ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
				EmailVerificationPage ev = new EmailVerificationPage(driver);
				lp.enterLoginDetails(email, password);
				Log.addMessage("User logged in");
				cvm.clickEmailNewButton();
				cvm.clickSendCodeButton();
				Utility.simpleWait(4000);
				Log.addMessage("Selected Email option");
				//commented for testing by manually entering the verification code
				//Utility.simpleWait(10000);
				ev.readCodeFromEmail("email.address3", "email.password3","login");
				//ev.clickVerifyButton(); 
				ev.clickVerifySubButton();//added on 04-Feb-2021
				//ep.enterCode();
			 }catch(Exception e) {
				 Log.addMessage("Failed to login");
				 e.printStackTrace();
				 Assert.assertTrue(false, "Failed to login");
			 }
		}
		
		
		
	
	@Test(dataProvider="vmobileCodeVerification")
	public void valMobileCodeTest(String mobileNumber, String code, String valMessage, String alertMessage) {
		try {
			MobilePhoneVerificationPage mp = new MobilePhoneVerificationPage(driver);
			
			Utility.simpleWait(2000);
			
			mp.updateVerificationCode(mobileNumber, code, valMessage, alertMessage);
			
			Log.addMessage("User mobile verified and updated successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to update user mobile verification code details");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update user mobile verification code details");
		}
	}
	
	@Test
	public void validMobileVerificationTest() {
		try {
			MobilePhoneVerificationPage mp = new MobilePhoneVerificationPage(driver);
			//mp.enterPhoneAndVerify(phoneNumber);
			//mp.enterVerificationCode();
			mp.clickSendButton();
			System.out.println("wait to read mobile code manually");
			Utility.simpleWait(30000);
			//mp.readMobileCodeFromEmail("email.address5", "email.password5");
			mp.clickVerifyButton();
			System.out.println("three");
			Log.addMessage("Phone Number of the user verified successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to verify user's phone number");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify user's phone number");
		}
	}
	
	@Test
	public void deleteAccountTest() {
		try {
			DeleteMyAccountPage dm = new DeleteMyAccountPage(driver);
			UserHomePage up=new UserHomePage(driver);
			Utility.simpleWait(25000);
			System.out.println("inside home page");
			up.clickHamburgerMenuButton();
			up.selectDeleteMyAccountOption();
			Utility.simpleWait(5000);
			dm.deleteCancelAccount();
			Utility.simpleWait(5000);
			dm.deleteAccount();
			Log.addMessage("Clicked Enable/Disable Account in the menu");
		}catch(Exception e) {
			Log.addMessage("Failed to update account status");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update account status");
		}
	}
	
	@SuppressWarnings("static-access")
	@Test(dataProvider="title")
	public void clickCreateDeletedAccountTest(String expectedTitle) {
		try {
			LoginPage lp = new LoginPage(driver);
			Utility.simpleWait(3000);
			lp.verifyPageTitle(expectedTitle);
			if(lp.checkCloseBanner()) {
				lp.clickCloseBanner();
			}
			lp.clickCreateAccount();
			Log.addMessage("Started registration");
		}catch(Exception e) {
			Log.addMessage("New account creation encountered some errors");
			e.printStackTrace();
			Assert.assertTrue(false, "Some errors found in registration");
		}
	}
	
	@Test(dataProvider = "userDetails")
	public void enterUserDetailsAgnTest(String firstname,String lastname) {
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
	
	@Test(dataProvider = "emailVerification")
	public void validEmailVerificationAgnTest(String email) {
		try {
			EmailVerificationPage ep = new EmailVerificationPage(driver);
			ep.enterEmailAndVerify(email);
			/*ep.readCodeFromEmail("email.address3", "email.password3","reg");
			ep.clickVerifyButton(); */
			
			Log.addMessage("Email address of the user verified successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to verify user's email address");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify user's email address");
		}
	}
	
	@Test(dataProvider="vurl")
	public void createAcntEmailHyperLinksTest(String url1, String url2,String url3,String url4,String url5,String url6, String url7, String url8) {
		 try {
			 EmailVerificationPage cv = new EmailVerificationPage(driver);
			 Utility.simpleWait(8000);
			 cv.readHyperLinksFromEmailReg("email.address3", "email.password3", url1, url2, url3, url4, url5, url6, url7, url8);
			 
			 Log.addMessage("Verified hyperlinks in create account");
		 }catch(Exception e) {
			 Log.addMessage("Failed to verify hyperlinks in create account");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to verify  hyperlinks in create account");
		 }
	}
	
	@Test
	public void deletedAccountResendTest() {
		 try {
			 EmailVerificationPage ev = new EmailVerificationPage(driver);
			 Utility.simpleWait(8000);
			 ev.clickSendButton();
			 Utility.simpleWait(2000);
			 Log.addMessage("Email validated");
		 }catch(Exception e) {
			 Log.addMessage("Failed to verify hyperlinks in create account");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to verify  hyperlinks in create account");
		 }
	}
	
	@Test(dataProvider="emailCntnt")
	public void createAccountEmailContentTest(String emailText, String frmAdrs) {
		 try {
			 EmailVerificationPage cvp = new EmailVerificationPage(driver);
			 Thread.sleep(5000);
			 System.out.println("wait to retrieve verification code from email");
			 cvp.readContentFromEmail("email.address3", "email.password3",emailText,frmAdrs);
			 Log.addMessage("Entered valid email verification code");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter valid email verification code.");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter valid email verification code.");
		 }
			
	}
	
	@Test
	public void deletedAccountBackAgnTest() {
		 try {
			 EmailVerificationPage ev = new EmailVerificationPage(driver);
			 Utility.simpleWait(8000);
			 ev.clickSendButton();
			 Utility.simpleWait(2000);
			 Log.addMessage("Email validated");
		 }catch(Exception e) {
			 Log.addMessage("Failed to verify hyperlinks in create account");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to verify  hyperlinks in create account");
		 }
	}
	
	@Test
	public void validDeletedEmailCodeTest() {
		 try {
			 EmailVerificationPage ep = new EmailVerificationPage(driver);
			 ep.readCodeFromEmail("email.address3", "email.password3","reg");
			 ep.clickVerifyButton(); 
			 Log.addMessage("Clicked email code submit button");
		 }catch(Exception e) {
			 Log.addMessage("Failed to verify email verification code");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to verify email verification code");
		 }
	}
	
	
	
	@Test(dataProvider = "valMobileVerification")
	public void mobileVerificationAgnTest(String phoneNumber) {
		try {
			MobilePhoneVerificationPage mp = new MobilePhoneVerificationPage(driver);
			mp.enterPhoneAndVerify(phoneNumber);
			mp.enterVerificationCode();
			System.out.println("two");
			mp.readMobileCodeFromEmail("email.address5", "email.password5");
			mp.clickVerifyButton();
			System.out.println("three");
			Log.addMessage("Phone Number of the user verified successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to verify user's phone number");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify user's phone number");
		}
	}
	
	@Test(dataProvider = "secretQuestion")
	public void setUpSecretQuestionsAgnTest(String question1, String answer1, String question2, String answer2, String question3, String answer3) {
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
	
	@Test(dataProvider = "validPwd")
	public void registrationConfirmationnAgTest(String password) {
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
	
	@Test(dataProvider="valRelogin")
	public void validReLoginAgnTest(String email, String password) {
		 try {
			LoginPage lp = new LoginPage(driver);
			ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
			EmailVerificationPage ev = new EmailVerificationPage(driver);
			lp.enterLoginDetails(email, password);
			Log.addMessage("User logged in");
			cvm.clickEmailNewButton();
			cvm.clickSendCodeButton();
			Utility.simpleWait(4000);
			Log.addMessage("Selected Email option");
			//commented for testing by manually entering the verification code
			//Utility.simpleWait(10000);
			ev.readCodeFromEmail("email.address3", "email.password3","login");
			//ev.clickVerifyButton(); 
			ev.clickVerifySubButton();//added on 04-Feb-2021
			//ep.enterCode();
			Utility.simpleWait(4000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to login");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to login");
		 }
	}
	
	@Test
	public void logoutAgnTest() {
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
	
	@Test
	public void validMobileResendCodeTest() {
		try {
			MobilePhoneVerificationPage mp=new MobilePhoneVerificationPage(driver);
			//mp.enterPhoneNumber(mobileNumber);
			//mp.clickSendButton();
			System.out.println("Wait for manually entering the code");
			Log.addMessage("Clicked resend Code button");
			Utility.simpleWait(3000);
			mp.enterVerificationCode();
			mp.clickVerifyButton();
			
			Log.addMessage("User mobile verified and updated successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to update user details");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update user details");
		}
	}
	
	@Test(dataProvider="validlogin")
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
	
	@Test(dataProvider="resendPopup")
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
	
	@Test(dataProvider="validlogin")
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
	
	@Test(dataProvider = "vmobileCodeVerification")
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
	
	@Test
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
	
	@Test(dataProvider="validlogin")
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
	
	@Test
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
	
	@Test(dataProvider="validlogin")
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
	
	@Test(dataProvider="resendPopup")
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
	
	@Test
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
	
	@Test
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
	
	@Test(dataProvider = "emailVerification")
	public void validEmailVerificationRcvrTest(String email) {
		try {
			EmailVerificationPage ep = new EmailVerificationPage(driver);
			ep.enterEmailAndVerify(email);
			/*Utility.simpleWait(4000);
			ep.readCodeFromEmail("email.address3", "email.password3","recover");
			ep.clickVerifyButton(); */
			Utility.simpleWait(4000);
			Log.addMessage("Email address of the user verified successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to verify user's email address");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify user's email address");
		}
	}
	
	@Test(dataProvider = "vRcvrEmail")
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
	
	@Test(dataProvider = "backVpopup")
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
	
	@Test(dataProvider = "vRcvrValEmail")
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
	
	@Test(dataProvider = "vRcvrScrty")
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
	
	@Test(dataProvider = "validRcvrScrty")
	public void validSecurityQuestionRecoverTest(String question1,String answer1) {
		try {
			SecretQuestionsPage sp = new SecretQuestionsPage(driver);
			System.out.println("answer1="+answer1);
			if(question1!="") {
				sp.rcvrSecretQuestion(question1, answer1);
			}
			sp.clickUpdateRcvrButton();
			Log.addMessage("Secret Questions answered");
		}catch(Exception e) {
			Log.addMessage("Failed to answer Secret Questions");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to answer Secret Questions ");
		}
	}
	
	
	@Test
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
	
	@Test
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
	
	@Test
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
	
	@Test(dataProvider="verifyPassword")
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
	
	@Test(dataProvider="vurl")
	public void forgotPwdEmailHyperLinksTest(String url1, String url2,String url3,String url4,String url5,String url6, String url7, String url8) {
		 try {
			 EmailVerificationPage cv = new EmailVerificationPage(driver);
			 Utility.simpleWait(10000);//tested for iOS
			 cv.readHyperLinksFromEmailReg("email.address3", "email.password3", url1, url2, url3, url4, url5, url6, url7, url8);
			
			 Log.addMessage("Verified hyperlinks in create account");
		 }catch(Exception e) {
			 Log.addMessage("Failed to verify hyperlinks in create account");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to verify  hyperlinks in create account");
		 }
	}
	
	@Test
	public void forgotPwdResendTest() {
		 try {
			 EmailVerificationPage cv = new EmailVerificationPage(driver);
			 Utility.simpleWait(8000);
			 cv.clickResendVerifyLink();
			 Log.addMessage("Clicked Resend link");
			 Utility.simpleWait(2000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to click resend link");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to click resend link");
		 }
	}
	
	@Test(dataProvider="emailCntntFrgtPwd")
	public void forgotPwdEmailCntntTest(String emailText, String frmAdrs) {
		 try {
			 EmailVerificationPage cvp = new EmailVerificationPage(driver);
			 Thread.sleep(5000);
			 System.out.println("wait to retrieve verification code from email");
			 cvp.readContentFromEmail("email.address3", "email.password3",emailText,frmAdrs);
			 Log.addMessage("Entered valid email verification code");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter valid email verification code.");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter valid email verification code.");
		 }
	}
	
	@Test
	public void forgotPwdResendAgnTest() {
		 try {
			 EmailVerificationPage cv = new EmailVerificationPage(driver);
			 Utility.simpleWait(8000);
			 cv.clickResendVerifyLink();
			 Log.addMessage("Clicked Resend link");
			 Utility.simpleWait(2000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to click resend link");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to click resend link");
		 }
	}
	
	@Test(dataProvider="verifyEmailPassword")
	public void validFrgtVerifyPassEmailTest(String nwpass, String renewpass, String valMessage1) {
		 try {
			 ForgotPasswordEnterPasswordPage fp = new ForgotPasswordEnterPasswordPage(driver);
			 EmailVerificationPage ep = new EmailVerificationPage(driver);
			 ep.readCodeFromEmail("email.address3", "email.password3","recover");
			 fp.enterNewPassword(nwpass);
			 fp.reEnterPassword(renewpass);
			 fp.clickConfirmButton();
			/* fp.verifyValidationVerbiage(valMessage1);//commented for bvt check
			 fp.clickCloseButton();*/
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter Email credentials");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter Email credentials");
		 }
	}
	
	@Test(dataProvider="validEmllogin")
	public void validReLoginEmailTest(String email, String password) {
		 try {
			LoginPage lp = new LoginPage(driver);
			ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
			EmailVerificationPage ev = new EmailVerificationPage(driver);
			lp.enterLoginDetails(email, password);
			Log.addMessage("User logged in");
			cvm.clickEmailNewButton();
			cvm.clickSendCodeButton();
			Utility.simpleWait(4000);
			Log.addMessage("Selected Email option");
			//commented for testing by manually entering the verification code
			//Utility.simpleWait(10000);
			ev.readCodeFromEmail("email.address3", "email.password3","login");
			//ev.clickVerifyButton(); 
			ev.clickVerifySubButton();//added on 04-Feb-2021
			//ep.enterCode();
			Utility.simpleWait(4000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to login");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to login");
		 }
	}
	
	@Test
	public void logoutEmailTest() {
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
	
	
	@Test(dataProvider="resendPopup")
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
	

	@Test(dataProvider="valResendPassword")
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
	
	@Test(dataProvider="valRecoverMobile")
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
			 ev.clickVerifySubButton();
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
	
	@Test(dataProvider="verifyPassword")
	public void valFrgtVerifyPassMobileTest(String vcode, String nwpass, String renewpass, String valMessage1, String valMessage2, String alertMessage) {
		 try {
			 ForgotPasswordEnterPasswordPage fp = new ForgotPasswordEnterPasswordPage(driver);
			 fp.validateRecoverPassword(vcode, nwpass, renewpass, valMessage1, valMessage2, alertMessage,"mobile");	
			 EmailVerificationPage ev = new EmailVerificationPage(driver);
			 ev.readCodeFromEmail("email.address3", "email.password3","recover");
			/* ev.enterNewPassword(nwpass);
			 ev.reEnterPassword(renewpass);
			 ev.clickConfirmButton();*/
			 Thread.sleep(5000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter Email credentials");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter Email credentials");
		 }
	}
	
	@Test(dataProvider="resendPopup")
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
	@Test(dataProvider="valResendMobPassword")
	public void validRcvrResendMobileCodeTest(String pwd, String confPwd, String updateMessage) {
		 try {
			 ForgotPasswordEnterPasswordPage ep = new ForgotPasswordEnterPasswordPage(driver);
			 MobilePhoneVerificationPage mp = new MobilePhoneVerificationPage(driver);
			 //check -> click resend button again and read resend code from email
			// ep.clickResendButton();
			// ep.enterVerificationCode();
			 Utility.simpleWait(4000);
			 mp.readMobileCodeFromCPEmail("email.address5", "email.password5");
			 mp.clickVerifyButton();
			// ep.enterCode("123456");
			 System.out.println("Wait to manually enter verification code from email");
			// Utility.simpleWait(15000);
			 ep.enterNewPassword(pwd);
			 ep.reEnterPassword(confPwd);
			 ep.clickConfirmButton();
			 Thread.sleep(5000);
			 System.out.println("validating success verbiage");
			/* ep.verifyValidationVerbiage(updateMessage);//commented for bvt
			 ep.clickCloseButton();*/
			 Log.addMessage("Resend limits set");
		 }catch(Exception e) {
			 Log.addMessage("Resend limits not set for Email verification code");
			 e.printStackTrace();
		 }
	}
	
	@Test(dataProvider="validMblogin")
	public void validReLoginMobileTest(String email, String password) {
		 try {
			LoginPage lp = new LoginPage(driver);
			ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
			EmailVerificationPage ev = new EmailVerificationPage(driver);
			lp.enterLoginDetails(email, password);
			Log.addMessage("User logged in");
			cvm.clickEmailNewButton();
			cvm.clickSendCodeButton();
			Utility.simpleWait(4000);
			Log.addMessage("Selected Email option");
			//commented for testing by manually entering the verification code
			//Utility.simpleWait(10000);
			ev.readCodeFromEmail("email.address3", "email.password3","login");
			//ev.clickVerifyButton(); 
			ev.clickVerifySubButton();//added on 04-Feb-2021
			//ep.enterCode();
		 }catch(Exception e) {
			 Log.addMessage("Failed to login");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to login");
		 }
	}
	
	@Test(dataProvider="emailCntntShrRqst")
	public void shareRequestEmailCntntTest(String emailText, String frmAdrs) {
		 try {
			 EmailVerificationPage cvp = new EmailVerificationPage(driver);
			 Thread.sleep(5000);
			 System.out.println("wait to retrieve verification code from email");
			 cvp.readContentFromShareEmail("email.address3", "email.password3",emailText,frmAdrs);
			 Log.addMessage("Entered valid email verification code");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter valid email verification code.");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter valid email verification code.");
		 }
	}
	
	@Test(dataProvider="vurl")
	public void shareRequestEmailHyperLinksTest(String url1, String url2,String url3,String url4,String url5,String url6, String url7, String url8) {
		 try {
			 EmailVerificationPage cv = new EmailVerificationPage(driver);
			 Utility.simpleWait(10000);//tested for iOS
			 cv.readHyperLinksFromEmailShare("email.address3", "email.password3", url1, url2, url3, url4, url5, url6, url7, url8,"share");
			
			 Log.addMessage("Verified hyperlinks in create account");
		 }catch(Exception e) {
			 Log.addMessage("Failed to verify hyperlinks in create account");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to verify  hyperlinks in create account");
		 }
	}
	
	
	@Test
	public void shareAcceptTest() {
		 try {
			HomeManagementPage hm = new HomeManagementPage(driver);
			hm.clickAcceptAdminButton();
			Thread.sleep(5000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to accept share");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to accept share");
		 }
	}
	
	@Test
	public void shareAcceptMemberTest() {
		 try {
			HomeManagementPage hm = new HomeManagementPage(driver);
			hm.clickAcceptMemberButton();
			Thread.sleep(5000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to accept share");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to accept share");
		 }
	}
	
	@Test
	public void shareAcceptAdLeaveTest() {
		 try {
			HomeManagementPage hm = new HomeManagementPage(driver);
			hm.clickAcceptAdLeaveButton();
			Thread.sleep(5000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to accept share");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to accept share");
		 }
	}
	
	@Test
	public void shareDeclineAdminTest() {
		 try {
			HomeManagementPage hm = new HomeManagementPage(driver);
			hm.clickDeclineAdminButton();
			Thread.sleep(5000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to decline share");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to decline share");
		 }
	}
	
	@Test
	public void leaveSharedHomeTest() {
		 try {
			HomeManagementPage hm = new HomeManagementPage(driver);
			hm.clickLeaveShareButton();
			Thread.sleep(5000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to leave shared home");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to leave shared home");
		 }
	}
	
	@Test
	public void acceptMemberHomeTest() {
		 try {
			HomeManagementPage hm = new HomeManagementPage(driver);
			hm.clickAcceptButton();
			Thread.sleep(5000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to leave shared home");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to leave shared home");
		 }
	}
	
	@Test
	public void goToHomeManagementTest() {
		 try {
			 Utility.simpleWait(7000);//for test in between
			 HomeManagementPage hm = new HomeManagementPage(driver);
			 hm.clickHomeManageButton();
			 hm.clickBackButton();
		 }catch(Exception e) {
			 Log.addMessage("Failed to leave shared home");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to leave shared home");
		 }
	}
	
	@Test
	public void goToHomeManagementMemberTest() {
		 try {
			HomeManagementPage hm = new HomeManagementPage(driver);
			if(hm.checkMemberHomeManageButton()) {
				Assert.assertTrue(false, "Members home management page displayed");
			}else {
				Assert.assertTrue(true, "Failed to go to members home management page");
			}
		 }catch(Exception e) {
			 Log.addMessage("Members home management page displayed");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Members home management page displayed");
		 }
	}
	
	@Test
	public void goToHomeHistoryTest() {
		 try {
			 Utility.simpleWait(5000);//for test in between
			 HomeManagementPage hm = new HomeManagementPage(driver);
			 hm.clickHomeLockHistoryButton();
		 }catch(Exception e) {
			 Log.addMessage("Failed to leave shared home");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to leave shared home");
		 }
	}
	
	@Test(dataProvider="hmHstryEvents")
	public void verifyHomeHistoryEventsTest(String desc, String lkName, String source, String dateTime) {
		 try {
			 Utility.simpleWait(5000);//for test in between
			 LockHistoryPage  lh = new LockHistoryPage(driver);
			 if(cntHist==10) {
				 Utility.simpleWait(5000);
				 System.out.println("in 11 next page");
				 cntHist=0;
				 cntTime=0;
			 }
			 cntHist=cntHist+1;
			 System.out.println("dateTime="+dateTime);
			 if(dateTime!="") {
				 cntTime = cntTime+1; 
			 }
			
			 System.out.println("cntHist="+cntHist);
			 System.out.println("cntTime="+cntTime);
			
			 lh.checkHomeHistoryEvents(desc,lkName, source, dateTime, cntHist, cntTime);
			 Assert.assertTrue(true, "History is matching");
		 }catch(Exception e) {
			 Log.addMessage("History is not matching");
			 e.printStackTrace();
			 Assert.assertTrue(false, "History is not matching");
		 }
	}
	
	@Test
	public void goToHomePageTest() {
		 try {
			HomeManagementPage hm = new HomeManagementPage(driver);
			hm.clickBackButton();
		 }catch(Exception e) {
			 Log.addMessage("Members home management page displayed");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Members home management page displayed");
		 }
	}
	
	
	@Test
	public void goToLockHistoryTest() {
		 try {
			HomeManagementPage hm = new HomeManagementPage(driver);
			hm.clickLockHistory();
		 }catch(Exception e) {
			 Log.addMessage("Members home management page displayed");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Members home management page displayed");
		 }
	}
	
	@Test
	public void viewLockHistoryPage() {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		HomeManagementPage hm = new HomeManagementPage(driver);
	 		lh.verifyUILockHistory();
			//hm.clickBackButton();
	 		Log.addMessage("Lock history UI elements are displayed");
 		}catch(Exception e) {
			Log.addMessage("Failed to display lock history UI elements");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display lock history UI elements");
		}
 	}
	
	@Test(dataProvider="lkHstryEvents")
	public void verifyLockHistoryEventsTest(String desc, String source, String dateTime) {
		 try {
			 Utility.simpleWait(5000);//for test in between
			 LockHistoryPage  lh = new LockHistoryPage(driver);
			 cntLkHist=cntLkHist+1;
			 System.out.println("dateTime="+dateTime);
			 if(dateTime!="") {
				 cntLkTime = cntLkTime+1; 
			 }
			 System.out.println("cntHist="+cntLkHist);
			 System.out.println("cntTime="+cntLkTime);
			
			 lh.checkLockHistoryEvents(desc, source, dateTime, cntLkHist, cntLkTime);
			 Assert.assertTrue(true, "History is matching");
		 }catch(Exception e) {
			 Log.addMessage("History is not matching");
			 e.printStackTrace();
			 Assert.assertTrue(false, "History is not matching");
		 }
	}
	
	@Test
	public void goToHomeLockPageTest() {
		 try {
			HomeManagementPage hm = new HomeManagementPage(driver);
			hm.clickBackButton();
		 }catch(Exception e) {
			 Log.addMessage("Members home management page displayed");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Members home management page displayed");
		 }
	}
	
	@Test(dataProvider="hmList")
	public void viewHomeListTest(String hmName) {
		 try {
			HomeManagementPage hm = new HomeManagementPage(driver);
			hm.verifyHomeName(hmName);
		 }catch(Exception e) {
			 Log.addMessage("Members home management page displayed");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Members home management page displayed");
		 }
	}
	
	@Test(dataProvider="lkList")
	public void viewLockListTest(String lkName) {
		 try {
			HomeManagementPage hm = new HomeManagementPage(driver);
			hm.verifyLockName(lkName);
		 }catch(Exception e) {
			 Log.addMessage("Members home management page displayed");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Members home management page displayed");
		 }
	}
	
	@Test(dataProvider="lkdtlHome")
	public void viewLockDetailsTest(String lkName, String lkFw) {
		 try {
			HomeManagementPage hm = new HomeManagementPage(driver);
			hm.verifyLockDetails(lkName, lkFw);
		 }catch(Exception e) {
			 Log.addMessage("Members home management page displayed");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Members home management page displayed");
		 }
	}
	
	@Test
	public void goToLockManagementTest() {
		 try {
			 Utility.simpleWait(5000);//for test in between
			 HomeManagementPage hm = new HomeManagementPage(driver);
			 hm.clickLockManageButton();
			// hm.clickBackLMButton();16-02-2021
		 }catch(Exception e) {
			 Log.addMessage("Failed to leave shared home");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to leave shared home");
		 }
	}
	
	@Test
	public void goToLockManagementMemberTest() {
		 try {
			HomeManagementPage hm = new HomeManagementPage(driver);
			if(hm.checkMemberLockManageButton()) {
				Assert.assertTrue(false, "Members lock management page displayed");
			}else {
				Assert.assertTrue(true, "Failed to go to members lock management page");
			}
		 }catch(Exception e) {
			 Log.addMessage("Members lock management page displayed");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Members lock management page displayed");
		 }
	}
	
	@Test(dataProvider="lkdtlList")
	public void viewLockManagementTest(String key1, String val1) {
		 try {
			 LockDetailsPage lp = new LockDetailsPage(driver);
			lp.viewLockDetailsButton(key1, val1);
		 }catch(Exception e) {
			 Log.addMessage("Failed to display Lock details");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to display Lock details");
		 }
	}
	
	@SuppressWarnings("static-access")
	@Test(dataProvider="title")
	public void clickCreatePhReuseTest(String expectedTitle) {
		try {
			LoginPage lp = new LoginPage(driver);
			Utility.simpleWait(3000);
			lp.verifyPageTitle(expectedTitle);
			if(lp.checkCloseBanner()) {
				lp.clickCloseBanner();
			}
			lp.clickCreateAccount();
			Log.addMessage("Started registration");
		}catch(Exception e) {
			Log.addMessage("New account creation encountered some errors");
			e.printStackTrace();
			Assert.assertTrue(false, "Some errors found in registration");
		}
	}
	
	@Test(dataProvider = "phReUserDetails")
	public void enterPhReuseUserDetailsTest(String firstname,String lastname) {
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
	
	@Test(dataProvider = "phReuseEmailVerification")
	public void validPhReuseEmailTest(String email) {
		try {
			EmailVerificationPage ep = new EmailVerificationPage(driver);
			ep.enterEmailAndVerify(email);
			Log.addMessage("Email address of the user entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter user's email address");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to enter user's email address");
		}
	}
	
	
	
	 @Test(dataProvider="vurl")
	 public void disableAcntEmailHyperLinksTest(String url1, String url2,String url3,String url4,String url5,String url6, String url7, String url8) {
		 try {
			 EmailVerificationPage cv = new EmailVerificationPage(driver);
			 Utility.simpleWait(10000);//tested for iOS
			 cv.readHyperLinksFromEmailReg("email.address3", "email.password3", url1, url2, url3, url4, url5, url6, url7, url8);
			
			 Log.addMessage("Verified hyperlinks in create account");
		 }catch(Exception e) {
			 Log.addMessage("Failed to verify hyperlinks in create account");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to verify  hyperlinks in create account");
		 }
	 }
	 
	 @Test(dataProvider="vchlogin")
	 public void emailCodeResendPhUseTest(String email, String password) {
		 try {
			 EmailVerificationPage ep = new EmailVerificationPage(driver);
			
			 Thread.sleep(3000);
			 ep.clickResendLink();
			 Thread.sleep(7000);
			 Log.addMessage("Clicked resend button of email page");
		 }catch(Exception e) {
			 Log.addMessage("Failed to click resend button of email page");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to click resend button of email page");
		 }
	 }
		 
	 @Test(dataProvider="emailCntntPhReuse")
	 public void phUsedEmailContentTest(String emailText, String frmAdrs) {
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
	
	 @Test(dataProvider="vchlogin")
	 public void emailCodeResendAgnPhUseTest(String email, String password) {
		 try {
			 EmailVerificationPage ep = new EmailVerificationPage(driver);
			
			 Thread.sleep(3000);
			 ep.clickResendLink();
			 Thread.sleep(7000);
			 Log.addMessage("Clicked resend button of email page");
		 }catch(Exception e) {
			 Log.addMessage("Failed to click resend button of email page");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to click resend button of email page");
		 }
	 }
	 
	@Test(dataProvider = "phReuseEmailVerification")
	public void validPhReuseEmailVerificationTest(String email) {
		try {
			EmailVerificationPage ep = new EmailVerificationPage(driver);
			ep.readCodeFromEmail("email.address6", "email.password6","reg");
			ep.clickVerifyButton(); 
			Log.addMessage("Email address of the user verified successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to verify user's email address");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify user's email address");
		}
	}
	
	@Test(dataProvider = "valMobileVerification")
	public void mobileVPhReuserVerificationTest(String phoneNumber) {
		try {
			MobilePhoneVerificationPage mp = new MobilePhoneVerificationPage(driver);
			mp.enterPhoneAndVerify(phoneNumber);
			mp.enterVerificationCode();
			System.out.println("two");
			Utility.simpleWait(4000);
			mp.readMobileCodeFromEmail("email.address5", "email.password5");
			mp.clickVerifyButton();
			System.out.println("three");
			Log.addMessage("Phone Number of the user verified successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to verify user's phone number");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify user's phone number");
		}
	}
	
	@Test(dataProvider = "secretQuestion")
	public void setUpSecretQuestionsPhReuseTest(String question1, String answer1, String question2, String answer2, String question3, String answer3) {
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
	
	@Test(dataProvider = "validPwd")
	public void registrationConfirmationnPhReuseTest(String password) {
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
	
	@Test(dataProvider="validMblogin")
	public void validPhReuseLoginTest(String email, String password) {
		 try {
			LoginPage lp = new LoginPage(driver);
			ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
			EmailVerificationPage ev = new EmailVerificationPage(driver);
			lp.enterLoginDetails(email, password);
			Log.addMessage("User logged in");
		 }catch(Exception e) {
			 Log.addMessage("Failed to login");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to login");
		 }
	}
	
	@Test
	public void validPhReuseViewMFATest() {
		try {
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage(driver);
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
	
	@Test(dataProvider="vchlogin")
	public void validPhReuseMFATest(String email, String password) {
		 try {
			ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
			EmailVerificationPage ev = new EmailVerificationPage(driver);
			cvm.clickEmailNewButton();
			cvm.clickSendCodeButton();
			Utility.simpleWait(4000);
			Log.addMessage("Selected Email option");
			ev.readCodeFromEmail("email.address3", "email.password3","login");
			//ev.clickVerifyButton(); 
			ev.clickVerifySubButton();//added on 04-Feb-2021
			//ep.enterCode();
		 }catch(Exception e) {
			 Log.addMessage("Failed to login");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to login");
		 }
	}
	
	@Test(dataProvider = "valMobileVerification")
	public void mobilePhReuseTest(String phoneNumber) {
		try {
			MobilePhoneVerificationPage mp = new MobilePhoneVerificationPage(driver);
			mp.enterPhoneAndVerify(phoneNumber);
			mp.enterVerificationCode();
			System.out.println("two");
			Utility.simpleWait(7000);
			mp.readMobileCodeFromEmail("email.address5", "email.password5");
			mp.clickVerifyButton();
			System.out.println("three");
			Log.addMessage("Phone Number of the user verified successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to verify user's phone number");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify user's phone number");
		}
	}
	
	@Test
	public void deleteOldAccountTest() {
		try {
			DeleteMyAccountPage dm = new DeleteMyAccountPage(driver);
			UserHomePage up=new UserHomePage(driver);
			Utility.simpleWait(7000);
			System.out.println("inside home page");
			up.clickHamburgerMenuButton();
			up.selectDeleteMyAccountOption();
			Utility.simpleWait(5000);
			dm.deleteCancelAccount();
			Utility.simpleWait(5000);
			dm.deleteAccount();
			Log.addMessage("Clicked Enable/Disable Account in the menu");
		}catch(Exception e) {
			Log.addMessage("Failed to update account status");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update account status");
		}
	}
	
	 @Test(dataProvider="vphReuselogin")
		public void reUsedPhLoginTest(String email, String password) {
			 try {
				LoginPage lp = new LoginPage(driver);
				ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
				EmailVerificationPage ev = new EmailVerificationPage(driver);
				lp.enterLoginDetails(email, password);
				Log.addMessage("User logged in");
				cvm.clickEmailNewButton();
				cvm.clickSendCodeButton();
				Utility.simpleWait(4000);
				Log.addMessage("Selected Email option");
				//commented for testing by manually entering the verification code
				//Utility.simpleWait(10000);
				ev.readCodeFromEmail("email.address6", "email.password6","login");
				//ev.clickVerifyButton(); 
				ev.clickVerifySubButton();//added on 04-Feb-2021
				//ep.enterCode();
			 }catch(Exception e) {
				 Log.addMessage("Failed to login");
				 e.printStackTrace();
				 Assert.assertTrue(false, "Failed to login");
			 }
		}
	 
	 @Test(dataProvider = "valMobileVerification")
		public void mobPhReuseTest(String phoneNumber) {
			try {
				MobilePhoneVerificationPage mp = new MobilePhoneVerificationPage(driver);
				mp.enterPhoneAndVerify(phoneNumber);
				mp.enterVerificationCode();
				System.out.println("two");
				Utility.simpleWait(7000);
				mp.readMobileCodeFromEmail("email.address5", "email.password5");
				mp.clickVerifyButton();
				System.out.println("three");
				Log.addMessage("Phone Number of the user verified successfully");
			}catch(Exception e) {
				Log.addMessage("Failed to verify user's phone number");
				e.printStackTrace();
				Assert.assertTrue(false, "Failed to verify user's phone number");
			}
		}
		

		@Test
		public void deletePhReUseTest() {
			try {
				DeleteMyAccountPage dm = new DeleteMyAccountPage(driver);
				UserHomePage up=new UserHomePage(driver);
				Utility.simpleWait(7000);
				System.out.println("inside home page");
				up.clickHamburgerMenuButton();
				up.selectDeleteMyAccountOption();
				Utility.simpleWait(5000);
				dm.deleteCancelAccount();
				Utility.simpleWait(5000);
				dm.deleteAccount();
				Log.addMessage("Clicked Enable/Disable Account in the menu");
			}catch(Exception e) {
				Log.addMessage("Failed to update account status");
				e.printStackTrace();
				Assert.assertTrue(false, "Failed to update account status");
			}
		}

	
	@Test
	public void logoutMobileTest() {
		try {
			UserHomePage up=new UserHomePage(driver);
			Utility.simpleWait(4000);
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
	
	ExcelRead excel = new ExcelRead();
	
	@DataProvider(name = "vbrand")
	public Object[][] getData() throws Exception {
	return excel.getTableArray(InputData, "Portal", "BrandVerify");
	}

	@DataProvider(name = "hmList")
	public Object[][] getDataHmList() throws Exception {
	return excel.getTableArray(InputData, "Portal", "HomeList");
	}
	
	@DataProvider(name = "lkList")
	public Object[][] getDataLkList() throws Exception {
	return excel.getTableArray(InputData, "Portal", "LockList");
	}
	
	@DataProvider(name = "lkdtlHome")
	public Object[][] getDataLkDtlHome() throws Exception {
	return excel.getTableArray(InputData, "Portal", "LockDetailHome");
	}
	
	@DataProvider(name = "lkdtlList")
	public Object[][] getDataLkDtlList() throws Exception {
	return excel.getTableArray(InputData, "Portal", "LockDetails");
	}
	
	@DataProvider(name = "hmHstryEvents")
	public Object[][] getDataHmHstryEvents() throws Exception {
	return excel.getTableArray(InputData, "Portal", "HomeHistoryEvents");
	}
	
	@DataProvider(name = "lkHstryEvents")
	public Object[][] getDataLkHstryEvents() throws Exception {
	return excel.getTableArray(InputData, "Portal", "LockHistoryEvents");
	}
	
	@DataProvider(name = "brand")
	public Object[][] getBrandData() throws Exception {
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
	
	@DataProvider(name = "phReUserDetails")
	public Object[][] getDataphReUse() throws Exception {
	return excel.getTableArray(InputData, "Portal", "ValidUserName");
	}
	
	@DataProvider(name = "userTxtDetails")
	public Object[][] getDataTxt2() throws Exception {
	return excel.getTableArray(InputData, "Portal", "UserTextDetails");
	}
	
	@DataProvider(name = "emailVerification")
	public Object[][] getData3() throws Exception {
	return excel.getTableArray(InputData, "Portal", "EmailVerification");
	}
	
	@DataProvider(name = "phReuseEmailVerification")
	public Object[][] getDataPVEmail() throws Exception {
		return excel.getTableArray(InputData, "Portal", "ValidPhEmail");
	}
	
	@DataProvider(name = "valMobileVerification")
	public Object[][] getData4() throws Exception {
	return excel.getTableArray(InputData, "Portal", "ValidMobileVerify");
	}
	
	@DataProvider(name = "secretQuestion")
	public Object[][] getData5() throws Exception {
	return excel.getTableArray(InputData, "Portal", "SecretQuestion");
	}
	
	@DataProvider(name = "validPwd")
	public Object[][] getDataPwd() throws Exception {
	return excel.getTableArray(InputData, "Portal", "RegPassword");
	}
	
	@DataProvider(name = "vuserDetails")
	public Object[][] getData7() throws Exception {
	return excel.getTableArray(InputData, "Portal", "ValUserName");
	}
	
	@DataProvider(name = "vphReuselogin")
	public Object[][] getDataphreuse() throws Exception {
	return excel.getTableArray(InputData, "Portal", "ValidPhReUseEmail");
	}
	
	@DataProvider(name = "vEmail")
	public Object[][] getData8() throws Exception {
	return excel.getTableArray(InputData, "Portal", "ValEmail");
	}
	
	@DataProvider(name = "vurl")
	public Object[][] getDataVUEmail() throws Exception {
		return excel.getTableArray(InputData, "App", "ValidURL");
	}
	
	@DataProvider(name = "vurlwz")
	public Object[][] getDataURlEmail() throws Exception {
		return excel.getTableArray(InputData, "Portal", "ValidURLWZ");
	}
	
	@DataProvider(name = "vemailVerification")
	public Object[][] getData9() throws Exception {
	return excel.getTableArray(InputData, "Portal", "ValEmailVerify");
	}
	
	@DataProvider(name = "emailCntntFrgtPwdWZ")
	public Object[][] getDataEContent() throws Exception {
		return excel.getTableArray(InputData, "Portal", "ChFrgtPassEmailContntWZ");
	}
	
	@DataProvider(name = "emailCntntFrgtPwd")
	public Object[][] getDataEFrgtPContent() throws Exception {
		return excel.getTableArray(InputData, "Portal", "ChFrgtPassEmailContnt");
	}
	
	@DataProvider(name = "emailCntnt")
	public Object[][] getDataEmlContent() throws Exception {
		return excel.getTableArray(InputData, "Portal", "EmailContnt");
	}
	
	@DataProvider(name = "emailCntntWZ")
	public Object[][] getDataWZSEmlContent() throws Exception {
		return excel.getTableArray(InputData, "Portal", "EmailContntWZ");
	}
	
	@DataProvider(name = "emailCntntChPwdWZ")
	public Object[][] getDataChPassWZContent() throws Exception {
		return excel.getTableArray(InputData, "Portal", "ChPassEmailContntWZ");
	}
	
	@DataProvider(name = "emailCntntChPwd")
	public Object[][] getDataChPassContent() throws Exception {
		return excel.getTableArray(InputData, "Portal", "ChPassEmailContnt");
	}
	
	@DataProvider(name = "emailCntntPhReuse")
	public Object[][] getDataPhReuseContent() throws Exception {
		return excel.getTableArray(InputData, "Portal", "EmailContntPhReUse");
	}
	
	@DataProvider(name = "emailCntntShrRqst")
	public Object[][] getDataShareRqstContent() throws Exception {
		return excel.getTableArray(InputData, "Portal", "EmailContntShrRequest");
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
	
	@DataProvider(name = "valRelogin")
	public Object[][] getDataVReLogin() throws Exception {
	return excel.getTableArray(InputData,"Portal", "ValidReLoginAgn");
	}
	
	@DataProvider(name = "vchlogin")
	public Object[][] getDataVChLogin() throws Exception {
		return excel.getTableArray(InputData, "Portal", "ValidChReLogin");
	}
	
	@DataProvider(name = "validEmllogin")
	public Object[][] getDataVEmllogin() throws Exception {
	return excel.getTableArray(InputData,"Portal", "ValidEmailLogin");
	}
	
	@DataProvider(name = "validMblogin")
	public Object[][] getDataVMoblogin() throws Exception {
	return excel.getTableArray(InputData,"Portal", "ValidMobileLogin");
	}
	
	@DataProvider(name = "validEnblogin")
	public Object[][] getDataEnblMoblogin() throws Exception {
	return excel.getTableArray(InputData,"Portal", "ValidEnblMobileLogin");
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
	
	@DataProvider(name = "validRcvrScrty")
	public Object[][] getDataValidRcvrScrty() throws Exception {
	return excel.getTableArray(InputData, "Portal", "ValidRcvrSecurityAnswer");
	}
	
	@DataProvider(name = "validDsblRcvrScrty")
	public Object[][] getDataValidDsblRcvrScrty() throws Exception {
	return excel.getTableArray(InputData, "Portal", "ValidDsblRcvrSecurityAnswer");
	}
	
	@DataProvider(name = "vRcvrValEmail")
	public Object[][] getDataResendRcvrEml() throws Exception {
	return excel.getTableArray(InputData, "Portal", "EmailVerification");
	}
	
	@DataProvider(name = "valResendPassword")
	public Object[][] getDatsUpdatePwd() throws Exception {
	return excel.getTableArray(InputData, "Portal", "ValPasswordMessage");
	}
	
	@DataProvider(name = "valResendMobPassword")
	public Object[][] getDatsUpdateMobPwd() throws Exception {
	return excel.getTableArray(InputData, "Portal", "ValPasswordMobMessage");
	}
	
	@DataProvider(name = "verifyPassword")
	public Object[][] getDataVrfyPass() throws Exception {
	return excel.getTableArray(InputData, "Portal", "PasswordForgotVal");
	}
	
	@DataProvider(name = "verifyEmailPassword")
	public Object[][] getDataVrfyEmailPass() throws Exception {
	return excel.getTableArray(InputData, "Portal", "ValPasswordEmailMessage");
	}
	
	@DataProvider(name = "valRecoverMobile")
	public Object[][] getDataRcvrMobile() throws Exception {
	return excel.getTableArray(InputData, "Portal", "PasswordForgotMobileVal");
	}
	
	@DataProvider(name = "valDsblRecoverMobile")
	public Object[][] getDataDsblRcvrMobile() throws Exception {
	return excel.getTableArray(InputData, "Portal", "PasswordForgotMobileValDsbl");
	}
	
	@DataProvider(name = "disablePopup")
	public Object[][] getDataDisable() throws Exception {
	return excel.getTableArray(InputData, "Portal", "DisablePopup");
	}
	
	@DataProvider(name = "disableMessage")
	public Object[][] getDataDisMsg() throws Exception {
	return excel.getTableArray(InputData, "Portal", "DisableVal");
	}
	
	@DataProvider(name = "validChangePwd")
	public Object[][] getDataChPwd() throws Exception {
	return excel.getTableArray(InputData, "Portal", "validChangePassword");
	}
	
	@DataProvider(name = "validEnblChangePwd")
	public Object[][] getDataEnblChPwd() throws Exception {
	return excel.getTableArray(InputData, "Portal", "validEnblChangePassword");
	}
	
	@DataProvider(name = "validFrgtChangePwd")
	public Object[][] getDataFrgtChPwd() throws Exception {
	return excel.getTableArray(InputData, "Portal", "validFrgtChangePassword");
	}
	
	@DataProvider(name = "enableMessage")
	public Object[][] getDataEnMsg() throws Exception {
	return excel.getTableArray(InputData, "Portal", "EnableVal");
	}
	
	@DataProvider(name = "changeSecurityQuestion")
	public Object[][] getDataChSeQn() throws Exception {
	return excel.getTableArray(InputData, "Portal", "ChangeSecurityQuestion");
	}
	
	@DataProvider(name = "editProfile")
	public Object[][] getDataPrfl() throws Exception {
	return excel.getTableArray(InputData, "Portal", "EditValidProfile");
	}

}
