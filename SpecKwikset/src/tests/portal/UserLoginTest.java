package tests.portal;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Settings;
import pages.portal.BrandNeutralPage;
import pages.portal.ChangePasswordPage;
import pages.portal.ChooseVerificationMethodPage;
import pages.portal.DeleteMyAccountPage;
import pages.portal.EditProfilePage;
import pages.portal.EnableDisableAccountPage;
import pages.portal.EnterCodePage;
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

public class UserLoginTest extends Settings{
	 
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
 
    @Test(dataProvider="login",priority=3)
	public void valLoginTest(String email, String password, String titleMessage, String errMessage, String iMessage) {
		 try {
			 LoginPage lp = new LoginPage(driver);
			 lp.valLogin(email, password, errMessage, titleMessage,iMessage);
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter login credentials");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter login credentials");
		 }
	}
    
    @Test(dataProvider="validlogin", priority = 4)
	public void valMFATest(String email, String password) {
		 try {
			LoginPage lp = new LoginPage(driver);
			ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
			//EnterCodePage ep = new EnterCodePage(driver);
			lp.enterLoginDetails(email, password);
			Log.addMessage("User logged in");
			//cvm.clickEmailButton();
			cvm.checkSendCodeButton();
			Log.addMessage("No option selected");
			Utility.simpleWait(4000);
			cvm.clickEmailButton();
			cvm.clickSendCodeButton();
			Log.addMessage("Selected Email option");
		 }catch(Exception e) {
			 Log.addMessage("Failed to login");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to login");
		 }
    }
    
    @Test(dataProvider="vemailVerification", priority = 5)
	public void valEmailCodeTest(String code,String valMessage, String alertMessage) {
		 try {
			 	//EmailVerificationPage ep = new EmailVerificationPage(driver);
			 	EnterCodePage ec = new EnterCodePage(driver);
			 	ec.invalidVerificationCode(code,valMessage,alertMessage);
				
				Log.addMessage("Email verification code of the user verified successfully");
				Log.addMessage("Email verification code of the user verified successfully");
			}catch(Exception e) {
				Log.addMessage("Failed to verify user's email address");
				e.printStackTrace();
				Assert.assertTrue(false, "Failed to verify user's email address");
			}
    }
	
    @Test(dataProvider="resendPopup", priority = 6)
	public void valEmailResendLimitTest(String popupMsg, String ipopupMsg) {
		 try {
			 EnterCodePage ep = new EnterCodePage(driver);
			 for(int i=0;i<5;i++) {
				ep.clickResendButton();
				if(i==0) {
					System.out.println("in one popupMsg="+popupMsg);
					ep.verifyResendPopUpVerbiage(popupMsg);
					System.out.println("in close popup one");
					ep.clickCloseButton();
				}
				 Thread.sleep(5000);
			 }
			 //check the popup verbiage for resend limits
			 Thread.sleep(5000);
			 System.out.println("in two");
			 EnterCodePage ep1 = new EnterCodePage(driver);
			 ep1.clickResendButton();
			 System.out.println("before ipopupMsg="+ipopupMsg);
			 Thread.sleep(3000);
			 ep1.verifyResendPopUpVerbiage(ipopupMsg);
			 //cv.clickOKButton();
			 Log.addMessage("Resend limits set");
		 }catch(Exception e) {
			 Log.addMessage("Resend limits not set for Email verification code");
			 e.printStackTrace();
		 }
	}
    
    @Test(dataProvider="validlogin", priority = 7)
   	public void valReMFATest(String email, String password) {
   		 try {
   			LoginPage lp = new LoginPage(driver);
   			ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
   			//EnterCodePage ep = new EnterCodePage(driver);
   			lp.enterLoginDetails(email, password);
   			Log.addMessage("User logged in");
   			;
   			Utility.simpleWait(4000);
   			cvm.clickPhoneButton();
   			cvm.clickSendCodeButton();
   			Log.addMessage("Selected Phone option");
   		 }catch(Exception e) {
   			 Log.addMessage("Failed to login");
   			 e.printStackTrace();
   			 Assert.assertTrue(false, "Failed to login");
   		 }
    }
    
    @Test(dataProvider="vemailVerification", priority = 8)
	public void valMobileCodeNewTest(String code,String valMessage, String alertMessage) {
		 try {
			 	//EmailVerificationPage ep = new EmailVerificationPage(driver);
			 	EnterCodePage ec = new EnterCodePage(driver);
			 	ec.invalidVerificationCode(code,valMessage,alertMessage);
				
				Log.addMessage("Mobile verification code of the user verified successfully");
				Log.addMessage("Mobile");
			}catch(Exception e) {
				Log.addMessage("Failed to verify user's mobile number");
				e.printStackTrace();
				Assert.assertTrue(false, "Failed to verify user's mobile number");
			}
    }
    
    @Test(dataProvider="resendPopup", priority = 9)
	public void valMobileResendLimitTest(String popupMsg, String ipopupMsg) {
		 try {
			 EnterCodePage ep = new EnterCodePage(driver);
			 for(int i=0;i<5;i++) {
				ep.clickResendButton();
				System.out.println("after click resend"+i);
				if(i==0) {
					System.out.println("in one popupMsg="+popupMsg);
					ep.verifyResendPopUpVerbiage(popupMsg);
					System.out.println("in close popup one");
					ep.clickCloseButton();
				}
				 Thread.sleep(5000);
			 }
			 //check the popup verbiage for resend limits
			 Thread.sleep(5000);
			 System.out.println("in two");
			 EnterCodePage ep1 = new EnterCodePage(driver);
			 ep1.clickResendButton();
			 System.out.println("before ipopupMsg="+ipopupMsg);
			 Thread.sleep(3000);
			 ep1.verifyResendPopUpVerbiage(ipopupMsg);
			 //cv.clickOKButton();
			 Log.addMessage("Resend limits set");
		 }catch(Exception e) {
			 Log.addMessage("Resend limits not set for Email verification code");
			 e.printStackTrace();
		 }
	}
       
 	@Test(dataProvider="validlogin", priority = 10)
	public void validLoginTest(String email, String password) {
		 try {
			LoginPage lp = new LoginPage(driver);
			ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
			EnterCodePage ep = new EnterCodePage(driver);
			lp.enterLoginDetails(email, password);
			Log.addMessage("User logged in");
			cvm.clickEmailButton();
			cvm.clickSendCodeButton();
			Utility.simpleWait(4000);
			Log.addMessage("Selected Email option");
			//commented for testing by manually entering the verification code
			//ep.enterCodeReceivedInPhone();
			System.out.println("Wait for reading verification code from email");
			Utility.simpleWait(15000);
			ep.enterVerificationCode();
			Log.addMessage("Entered verification code");
			Utility.simpleWait(5000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to login");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to login");
		 }
	}
 	
 	@Test(priority=11)
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
 	
 	@Test(dataProvider="disablePopup", priority=12)
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
	
	@Test(dataProvider="disableMessage", priority=13)
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
	
	@Test( priority=14)
	public void disabledAccountLogoutTest() {
		try {
			EnableDisableAccountPage ep=new EnableDisableAccountPage(driver);
			UserHomePage up=new UserHomePage(driver);
			Utility.simpleWait(3000);
			ep.clickBackToHome();
			Log.addMessage("Clicked Back hyperlink");
			Utility.simpleWait(3000);
			up.clickHamburgerMenuButton();
			up.clickLogout();
			Log.addMessage("Account logged out successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}

	@Test(dataProvider="validlogin", priority=15)
	public void disabledAccountloginTest(String email, String password) {
		try {
			LoginPage lp = new LoginPage(driver);
			ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
			EnterCodePage ep = new EnterCodePage(driver);
			lp.enterLoginDetails(email, password);
			Log.addMessage("User logged in");
			cvm.clickEmailButton();
			cvm.clickSendCodeButton();
			Utility.simpleWait(4000);
			Log.addMessage("Selected Email option");
			//commented for testing by manually entering the verification code
			//ep.enterCode();
			System.out.println("Wait for reading verification code from email");
			Utility.simpleWait(10000);
			ep.enterVerificationCode();
			Log.addMessage("Entered verification code");
			Utility.simpleWait(5000);
		}catch(Exception e) {
			Log.addMessage("Failed to log in");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to log in");
		}
	}
	
	@Test(priority=16)
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
	
	@Test(dataProvider="ValidateEditPwd", priority=17)
	public void valChangePasswordTest(String nwPwd,String rePwd,String oldPwd, String titleMessage, String valMessage, String mainMessage) {
		 try {
			 ChangePasswordPage up = new ChangePasswordPage(driver);
			 up.valPassword(oldPwd, nwPwd, rePwd, titleMessage, valMessage, mainMessage);
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter login credentials");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter login credentials");
		 }
	}
	 
	@Test(dataProvider="validChangePwd", priority=18)
	public void disabledAccountChangePasswordTest(String oldPassword, String newPassword) {
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
			Log.addMessage("Password updated successfully");
			//betaUserLogin();
		}catch(Exception e) {
			Log.addMessage("Failed to update password");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update password");
		}
	}
	
	@Test(dataProvider="validRelogin", priority = 19)
	public void disabledAccountloginAgainTest(String email, String password) {
		 try {
			LoginPage lp = new LoginPage(driver);
			ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
			EnterCodePage ep = new EnterCodePage(driver);
			Utility.simpleWait(10000);
			lp.enterLoginDetails(email, password);
			Log.addMessage("User logged in");
			cvm.clickPhoneButton();
			cvm.clickSendCodeButton();
			Utility.simpleWait(4000);
			Log.addMessage("Selected Email option");
			//commented for testing by manually entering the verification code
			//ep.enterCodeReceivedInPhone();
			System.out.println("Wait for reading verification code from email");
			Utility.simpleWait(15000);
			ep.enterVerificationCode();
			Log.addMessage("Entered verification code");
			Utility.simpleWait(5000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to login");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to login");
		 }
	}
	
	@Test(priority=20)
	public void validateChangeSecurityQstnsOptionTest() {
		try {
			UserHomePage up=new UserHomePage(driver);
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
	 
  	 @Test(dataProvider="vSecQn", priority=21)
  	 public void valEditSecurityQuestionTest(String qn1,String ans1,String qn2, String ans2,String qn3, String ans3, String ttlMessage, String valMessage, String mainMessage) {
  		 try {
  			SecretQuestionsPage eq = new SecretQuestionsPage(driver);
  			 //Thread.sleep(27000);//for testing in between
  			 eq.updateSecurityQuestion(qn1,ans1, qn2,ans2, qn3,ans3, valMessage, ttlMessage,mainMessage);
  			 
  		 }catch(Exception e) {
  			 Log.addMessage("Failed to enter security questions");
  			 e.printStackTrace();
  			 Assert.assertTrue(false, "Failed to enter security questions");
  		 }
  	}
	
	@Test(dataProvider="changeSecurityQuestion",priority=22)
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
	
	//check for message and close button xpath
	@Test(dataProvider="successMessage", priority=23)
	public void successMessageTest(String valMessage1,String valMessage2) {
		try {
			EnableDisableAccountPage ep=new EnableDisableAccountPage(driver);
			ep.verifyValidationMessage(valMessage1);
			Log.addMessage("Validation is matching");
		}catch(Exception e) {
			Log.addMessage("Failed to display validation");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display validation");
		}
	}
	
	@Test(priority=24)
	public void validateEditMyProfileOptionTest() {
		try {
			UserHomePage up=new UserHomePage(driver);
			up.clickHamburgerMenuButton();
			up.selectEditProfileOption();
			Log.addMessage("User profile selected");
		}catch(Exception e) {
			Log.addMessage("Failed to select user profile");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to select user profile");
		}
	}
	
	@Test(dataProvider="vuserDetails",priority = 25)
	public void valUserProfileTest(String firstname,String lastname,String mobNumber,String firstNameValMsg,String lastNameValMsg,String mobileValMsg,String errValMsg) {
		try {
			EditProfilePage ep=new EditProfilePage(driver);
			
			ep.updateUserName(firstname,lastname, mobNumber, firstNameValMsg,lastNameValMsg, mobileValMsg, errValMsg);
			Thread.sleep(5000);
			Log.addMessage("User details entered successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to enter user details");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to enter user details");
		}
	}
	
	
	@Test(dataProvider="editProfile",priority=26)
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
			ep.updateMobileNumber(mobileNumber);
			ep.clickConfirmButton();
		
			
			Utility.simpleWait(3000);
			mp.clickBackButton();
			Utility.simpleWait(2000);
			ep.clickConfirmButton();
			Utility.simpleWait(3000);
			mp.clickSendButton();
			Utility.simpleWait(5000);
			Log.addMessage("User details updated successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to update user details");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update user details");
		}
	}
	

	@Test(dataProvider="vmobileCodeVerification",priority=27)
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
	
	@Test(priority=28)
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
	//check for success verbiage
	@Test(dataProvider="enableMessage", priority=29)
	public void enableAccountTest(String valMesssage) {
		try {
			EnableDisableAccountPage ep=new EnableDisableAccountPage(driver);
			/*UserHomePage up=new UserHomePage(driver);
			Utility.simpleWait(25000);
			System.out.println("inside home page");
			up.clickHamburgerMenuButton();
			up.selectEnableDisableMyAccountOption();*/
			Utility.simpleWait(5000);
			ep.clickEnableDisableFromBanner();
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
	
	@Test(priority = 30)
	public void checkBrowserBackButtonTest() {
		try {
			EnableDisableAccountPage cp = new EnableDisableAccountPage(driver);
			
			Utility.simpleWait(4000);
			Log.addMessage("Back button popup displayedd");
		}catch(Exception e) {
			Log.addMessage("Failed to click on browser back button");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click on browser back button");
		}
	}
	
	@Test(priority=31)
	public void enabledAccountLogoutTest() {
		try {
			Utility.simpleWait(40000);
		
			
			EnableDisableAccountPage ep=new EnableDisableAccountPage(driver);
			UserHomePage up=new UserHomePage(driver);
			Utility.simpleWait(3000);
			//ep.clickBackToHome();
			//Log.addMessage("Clicked Back hyperlink");
			Utility.simpleWait(3000);
			up.clickHamburgerMenuButton();
			up.clickLogout();
			Log.addMessage("Account logged out successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@Test(dataProvider="validRelogin", priority=32)
	public void enabledAccountloginTest(String email, String password) {
		try {
			LoginPage lp = new LoginPage(driver);
			ChooseVerificationMethodPage cvm=new ChooseVerificationMethodPage(driver);
			EnterCodePage ep = new EnterCodePage(driver);
			lp.enterLoginDetails(email, password);
			Log.addMessage("User logged in");
			cvm.clickEmailButton();
			cvm.clickSendCodeButton();
			Utility.simpleWait(4000);
			Log.addMessage("Selected Email option");
			//commented for testing by manually entering the verification code
			//ep.enterCodeReceivedInPhone();
			Utility.simpleWait(10000);
			ep.enterVerificationCode();
			Log.addMessage("Entered verification code");
			Utility.simpleWait(5000);
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@Test(priority=33)
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

	
	ExcelRead excel = new ExcelRead();
	
	@DataProvider(name = "brand")
	public Object[][] getData() throws Exception {
	return excel.getTableArray(InputData, "Portal", "Brand");
	}
	
	@DataProvider(name = "validlogin")
	public Object[][] getDataVLogin() throws Exception {
	return excel.getTableArray(InputData,"Portal", "ValidLogin");
	}
	
	@DataProvider(name = "validRelogin")
	public Object[][] getDataVReLogin() throws Exception {
	return excel.getTableArray(InputData,"Portal", "ValidReLogin");
	}
	
	@DataProvider(name = "disablePopup")
	public Object[][] getData2() throws Exception {
	return excel.getTableArray(InputData, "Portal", "DisablePopup");
	}
	
	@DataProvider(name = "disableMessage")
	public Object[][] getData3() throws Exception {
	return excel.getTableArray(InputData, "Portal", "DisableVal");
	}
	
	@DataProvider(name = "enableMessage")
	public Object[][] getData4() throws Exception {
	return excel.getTableArray(InputData, "Portal", "EnableVal");
	}
	
	@DataProvider(name = "successMessage")
	public Object[][] getDataSuccess() throws Exception {
	return excel.getTableArray(InputData, "Portal", "UpdateMessageVal");
	}
	
	@DataProvider(name = "validChangePwd")
	public Object[][] getData5() throws Exception {
	return excel.getTableArray(InputData, "Portal", "ChangePasswordVal");
	}
	
	@DataProvider(name = "ValidateEditPwd")
	public Object[][] getDataPasswordVal() throws Exception {
	return excel.getTableArray(InputData, "Portal", "PasswordLoginVal");
	}
	
	@DataProvider(name = "changeSecurityQuestion")
	public Object[][] getData6() throws Exception {
	return excel.getTableArray(InputData, "Portal", "ChangeSecurityQuestion");
	}
	
	@DataProvider(name = "editProfile")
	public Object[][] getData7() throws Exception {
	return excel.getTableArray(InputData, "Portal", "EditValidProfile");
	}
	
	@DataProvider(name = "vSecQn")
	public Object[][] getDataQn() throws Exception {
		return excel.getTableArray(InputData, "Portal", "ValSecurityAnswers");
	}
	
	@DataProvider(name = "vuserDetails")
	public Object[][] getDataUserName() throws Exception {
	return excel.getTableArray(InputData, "Portal", "ValEditUserName");
	}
	
	@DataProvider(name = "vmobileCodeVerification")
	public Object[][] getData11() throws Exception {
	return excel.getTableArray(InputData, "Portal", "ValPhoneCodeVerify");
	}
	
	@DataProvider(name = "login")
	public Object[][] getDataLogin() throws Exception {
		return excel.getTableArray(InputData, "Portal", "ValLogin");
	}
	
	@DataProvider(name = "vemailVerification")
	public Object[][] getData9() throws Exception {
	return excel.getTableArray(InputData, "Portal", "ValEmailVerify");
	}
	
	@DataProvider(name = "resendPopup")
	public Object[][] getDataResend() throws Exception {
	return excel.getTableArray(InputData, "Portal", "ResendLimit");
	}

}
