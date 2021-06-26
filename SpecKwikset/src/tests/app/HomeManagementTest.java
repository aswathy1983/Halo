package tests.app;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pages.app.HomeLockListPage;
import pages.app.HomeUserAccessType;
import pages.app.HomeUserList;
import pages.app.HomeUsersPage;
import pages.app.LockCancelPopupPage;
import pages.app.AccessCodePage;
import pages.app.AccountNamePage;
import pages.app.AddAccessCodePage;
import pages.app.ChooseVerificationMethodPage;
import pages.app.CodeVerificationPage;
import pages.app.ConfirmDeleteLockPage;
import pages.app.CreateAHomePage;
import pages.app.EditAccessCodePage;
import pages.app.EditCodeNamePage;
import pages.app.EnterEmailPage;
import pages.app.EnterHomeNamePage;
import pages.app.EnterMobileNumberPage;
import pages.app.EnterPasswordPage;
import pages.app.FactoryResetPopUpPage;
import pages.app.HelpFAQPage;
import pages.app.LockDashboardPage;
import pages.app.LockEventHistoryPage;
import pages.app.LockInstallationGuidePage;
import pages.app.LockListPage;
import pages.app.LockNamePage;
import pages.app.LockNextPage1;
import pages.app.LockNextPage2;
import pages.app.LockSettingsPage;
import pages.app.LoginPage;
import pages.app.ManageHomesPage;
import pages.app.MenuFlyoutPage;
import pages.app.NewUserEmailPage;
import pages.app.NewUserPage;
import pages.app.NoLocksPage;
import pages.app.PairedSmartPhoneListPage;
import pages.app.SearchLocksPage;
import pages.app.SecurityQuestionsPage;
import pages.app.SelectScheduleTypePage;
import pages.app.ViewAccessCodesPage;
import utility.ExcelRead;
import utility.Log;
import utility.Utility;

public class HomeManagementTest extends Settings {
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="ownerlogin")
	public void loginToOwnerHomeTest(String email, String password) {
		try {
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 HomeUserList hu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			 
			 cp.login(email, password);
			 Thread.sleep(5000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 System.out.println("wait to retrieve verification code from email");
			 cvp.readCodeFromEmail("email.address", "email.password");//commented for testing inbetween on 23-03-21
			 Thread.sleep(5000);//to edit while testing
			 cvp.clickSubmitButton(); 
			 Thread.sleep(3000);
			 cvp.clickNotNowButton();
			 Thread.sleep(15000);
			Log.addMessage("Logged in to owner account");
		}catch(Exception e) {
			Log.addMessage("Failed to log in");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to log in");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyCreateFirstHomePageTest() {
		try {
			CreateAHomePage ch = new CreateAHomePage((AppiumDriver<MobileElement>) driver);
			ch.verifyCreateHomeButton();
			/*LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			ld.verifyHomeLandPageWithNoLocks();
			Log.addMessage("First home created");*/
		}catch(Exception e) {
			Log.addMessage("Failed to create First Home");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to create First Home");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void createFirstHomeTest() {
		try {
			CreateAHomePage ch = new CreateAHomePage((AppiumDriver<MobileElement>) driver);
			ch.clickCreateAHomeButton();
			Log.addMessage("First home created");
		}catch(Exception e) {
			Log.addMessage("Failed to create First Home");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to create First Home");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyUIAddHome() {
		 try {
			 EnterHomeNamePage cp = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
			 cp.verifyAddHomeUI();
			Log.addMessage("Title of the add home page is :"+driver.getTitle());
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter Phone Number");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter Phone Number");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void navigateBackTest() {
		 try {
			 EnterHomeNamePage cp = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
			 cp.clickBackButton();
			 Utility.simpleWait(2000);
			/* CreateAHomePage ch = new CreateAHomePage((AppiumDriver<MobileElement>) driver);
			 ch.clickCreateAHomeButton();
			 Utility.simpleWait(2000);*/
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter Phone Number");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter Phone Number");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void createFirstHomeHamburgerTest() {
		 try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 ld.clickHamburgerButton();
			 ld.clickManageButton();
			 Utility.simpleWait(2000);
			/* CreateAHomePage ch = new CreateAHomePage((AppiumDriver<MobileElement>) driver);
			 ch.clickCreateAHomeButton();
			 Utility.simpleWait(2000);
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 mh.clickAddHomeButton();*/
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter Phone Number");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter Phone Number");
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
	
	//added on 05-11-2020 during bvt
	@SuppressWarnings("unchecked")
	@Test
	public void verifyCreateHomeLandPageTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			ld.verifyHomeLandPageWithNoLocks();
			Log.addMessage("First home created");
		}catch(Exception e) {
			Log.addMessage("Failed to create First Home");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to create First Home");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void create200HomeTest() {
		try {
			Thread.sleep(4000);
			for(int i=80;i<200;i++) {
				//for iOS
				//Thread.sleep(4000);
				LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
				ld.clickHamburgerButton();
				System.out.println("inside");
				MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
				//commented for ios
				Utility.simpleWait(3000);
				mf.clickManageButton();
				System.out.println("in menu");
				ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
				Utility.simpleWait(8000);
				mh.clickAddHomeButton();
				//eh.clickClearButton();
				EnterHomeNamePage eh1 = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
				eh1.enterHomeName("test"+i);
				//Utility.simpleWait(3000);
				eh1.clickSubmitButton();
				System.out.println("home added with home name :test"+i);
				//for Android
				//Thread.sleep(2000);
				//for iOS
				Thread.sleep(15000);
				//below 2 lines of code when in Beta env - Android
				/*eh1.clickOKButton();
				eh1.clickBackButton();*/
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
	public void verifyHomeNameKeyboardTest() {
		 try {
			 EnterHomeNamePage cp = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
			 Thread.sleep(5000);
			 cp.clickHomeNameDoneKey("t");
			 Utility.simpleWait(2000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter Phone Number");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter Phone Number");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="hmName")
	public void valAddHome(String homeNm, String valMessage) {
		 try {
			 EnterHomeNamePage cp = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
			 cp.valHomeName(homeNm, valMessage, "","","mod");
			 
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter Home Name");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter Home Name");
		 }
	}
	
	//below test case for BVT
	@SuppressWarnings("unchecked")
	@Test(dataProvider="firstHome")
	public void validFirstHomeTest(String homename) {
		try {
			CreateAHomePage ch = new CreateAHomePage((AppiumDriver<MobileElement>) driver);
			EnterHomeNamePage eh = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
			ch.clickCreateAHomeButton();
			eh.enterHomeName(homename);
			eh.clickSubmitButton();
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			ld.verifyDashboardWithNoLocks();
			Log.addMessage("First home created");
		}catch(Exception e) {
			Log.addMessage("Failed to create First Home");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to create First Home");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test 
	public void deleteFirstHomeWIfiOffTest() {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			System.out.println("Wait for Wifi Off");
			Utility.simpleWait(20000);
			mh.clickCancelButton();
			mh.deleteHome();
			mh.clickCancelButton();
		}catch(Exception e) {
			Log.addMessage("Failed to verify add lock button navigation");
			Assert.assertTrue(false, "Failed to verify add lock button navigation");
		  }
	}
	
	@SuppressWarnings("unchecked")
	@Test 
	public void deleteFirstHomeTest() {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			
			mh.deleteHome();
			mh.clickBackButton();
		
		}catch(Exception e) {
			Log.addMessage("Failed to verify add lock button navigation");
			Assert.assertTrue(false, "Failed to verify add lock button navigation");
		  }
	}
	
	//bvt
	@SuppressWarnings("unchecked")
	@Test 
	public void deleteHomeTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			ld.clickHamburgerButton();
			mf.clickManageButton();
			mh.deleteHome();
			//mh.clickBackButton();
		}catch(Exception e) {
			Log.addMessage("Failed to verify add lock button navigation");
			Assert.assertTrue(false, "Failed to verify add lock button navigation");
		  }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="firstHome")
	public void valBLEOffCreateHomeTest(String homename) {
		try {
			CreateAHomePage ch = new CreateAHomePage((AppiumDriver<MobileElement>) driver);
			EnterHomeNamePage eh = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
			System.out.println("Wait for Wifi ON and BLE OFF");
			Utility.simpleWait(27000);
			ch.clickCreateAHomeButton(); 
			eh.enterHomeName(homename);
			eh.clickSubmitButton();
			eh.clickOKButton();
			Log.addMessage("First home created");
		}catch(Exception e) {
			Log.addMessage("Failed to create First Home");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to create First Home");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test (dataProvider = "secondHome")
	public void addAnotherHomeButtonTest(String homeName) {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			EnterHomeNamePage eh = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
			System.out.println("Wait for switching ON Wifi and BLE");
			ld.clickHamburgerButton();
			mf.clickManageButton();
			mh.clickAddHomeButton();
			eh.enterHomeName(homeName);
			eh.clickClearButton();
			eh.clickBackButton();
			ManageHomesPage mh1 = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			mh1.clickAddHomeButton();
		}catch(Exception e) {
			Log.addMessage("Failed to add new home");
			Assert.assertTrue(false, "Failed to add new home");
		  }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyAddHomeNameKeyboardTest() {
		 try {
			 EnterHomeNamePage cp = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
			 cp.clickHomeNameDoneKey("t");
			 Utility.simpleWait(2000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter Phone Number");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter Phone Number");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test (dataProvider = "addHomeName")
	public void valAnotherHomeTest(String homeName, String valMessage, String titleMessage) {
		try {
			EnterHomeNamePage eh = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
			eh.valHomeName(homeName, valMessage,titleMessage,"","edit");
			
		}catch(Exception e) {
			Log.addMessage("Failed to add new home");
			Assert.assertTrue(false, "Failed to add new home");
		  }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyAddHomeLandPageTest() {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			mh.verifyAddHomeButton();
			Log.addMessage("Add home redirected to manage homes page");
		}catch(Exception e) {
			Log.addMessage("Failed to redirect to manage homes page");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to redirect to manage homes page");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="firstHome")
	public void valWifiOffAddHomeTest(String homename) {
		try {
			ManageHomesPage ch = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			EnterHomeNamePage eh = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
			System.out.println("Wait for Wifi Off");
			Utility.simpleWait(27000);
			ch.clickCancelButton();
			ch.verifyHomeOfflineBanner();//check the code added on 27 Aug 2020
			ch.clickAddHomeButton();
			eh.clickCancelButton();
			Log.addMessage("Home cannot be added with WiFi off condition");
		}catch(Exception e) {
			Log.addMessage("Home added with Wifi off condition");
			e.printStackTrace();
			Assert.assertTrue(false, "Home added with Wifi off condition");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="firstHome")
	public void valBLEOffAddHomeTest(String homename) {
		try {
			ManageHomesPage ch = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			EnterHomeNamePage eh = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
			System.out.println("Wait for Wifi ON and BLE OFF");
			Utility.simpleWait(27000);
			ch.clickAddHomeButton();
			eh.enterHomeName(homename);
			eh.clickSubmitButton();
			eh.clickOKButton();
			Log.addMessage("Home added");
		}catch(Exception e) {
			Log.addMessage("Failed to add home");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to add home");
		}
	}
	
	//below test case for BVT
	@SuppressWarnings("unchecked")
	@Test(dataProvider="secondHome")
	public void validAnotherHomeAddTest(String homename) {
		try {
			ManageHomesPage ch = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			EnterHomeNamePage eh = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
			 CreateAHomePage ca = new CreateAHomePage((AppiumDriver<MobileElement>) driver);
			// EnterHomeNamePage eh = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
			 ca.clickCreateAHomeButton();
			//ch.clickAddHomeButton();
			eh.enterHomeName(homename);
			eh.clickSubmitButton();
			if(device.equals("android")) {
				eh.clickOKButton();
			}
			
			Log.addMessage("Home added");
		}catch(Exception e) {
			Log.addMessage("Failed to add home");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to add home");
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Test (dataProvider = "secondHome")
	public void modifyHomeButtonTest(String homeName) {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			EnterHomeNamePage eh = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
			System.out.println("Wait for switching ON Wifi and BLE");
			Utility.simpleWait(27000);
			mh.clickEditHomeNameButton();
			eh.enterHomeName(homeName);
			eh.clickClearButton();
			eh.clickBackButton();
			ManageHomesPage mh1 = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			mh1.clickEditHomeNameButton();
		}catch(Exception e) {
			Log.addMessage("Failed to add new home");
			Assert.assertTrue(false, "Failed to add new home");
		  }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void modifyHomeNameKeyboardTest() {
		 try {
			 EnterHomeNamePage cp = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
			 cp.clickHomeNameDoneKey("t");
			 Utility.simpleWait(2000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter Phone Number");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter Phone Number");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test (dataProvider = "modHomeName")
	public void valModifyHomeTest(String homeName, String valMessage, String titleMessage, String toastMessage) {
		try {
			EnterHomeNamePage eh = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
			eh.valHomeName(homeName, valMessage, titleMessage, toastMessage, "mod");
			
		}catch(Exception e) {
			Log.addMessage("Failed to add new home");
			Assert.assertTrue(false, "Failed to add new home");
		  }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyModifyHomeLandPageTest() {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			mh.verifyAddHomeButton();
			Log.addMessage("Add home redirected to manage homes page");
		}catch(Exception e) {
			Log.addMessage("Failed to redirect to manage homes page");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to redirect to manage homes page");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="firstHome")
	public void valWifiOffModifyHomeTest(String homename) {
		try {
			ManageHomesPage ch = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			EnterHomeNamePage eh = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
			System.out.println("Wait for Wifi Off");
			Utility.simpleWait(27000);
			ch.clickCancelButton();
			//ch.clickAddHomeButton();//commented on 14th sep to check modify home name with wifi off
			ch.clickEditHomeNameButton();
			ch.clickCancelButton();
			/*eh.enterHomeName(homename);
			eh.clickSubmitButton();
			eh.clickCancelButton();
			eh.clickBackButton();*/
			/*LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			ld.verifyDashboardWithNoLocks();*/
			Log.addMessage("Home name cannot be modified with Wifi off");
		}catch(Exception e) {
			Log.addMessage("Home name modified with Wifi off");
			e.printStackTrace();
			Assert.assertTrue(false, "Home name modified with Wifi off");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="firstHome")
	public void valBLEOffModifyHomeTest(String homename) {
		try {
			ManageHomesPage ch = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			EnterHomeNamePage eh = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
			System.out.println("Wait for Wifi ON and BLE OFF");
			Utility.simpleWait(27000);
			//ch.clickAddHomeButton();
			ch.clickEditHomeNameButton();
			eh.enterHomeName(homename);
			eh.clickSubmitButton();
			eh.clickOKButton();
			Log.addMessage("Home name modified with BLE off");
		}catch(Exception e) {
			Log.addMessage("Home name cannot be modified with BLE off");
			e.printStackTrace();
			Assert.assertTrue(false, "Home name cannot be modified with BLE off");
		}
	}
	
	//for bvt
	@SuppressWarnings("unchecked")
	@Test(dataProvider="firstHome")
	public void validModifyHomeTest(String homename) {
		try {
			ManageHomesPage ch = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			EnterHomeNamePage eh = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			
			ld.clickHamburgerButton();
			mf.clickManageButton();
			ch.clickEditHomeNameButton();
			eh.enterHomeName(homename);
			eh.clickSubmitButton();
			eh.clickOKButton();
			Log.addMessage("Home name modified with BLE off");
		}catch(Exception e) {
			Log.addMessage("Home name cannot be modified with BLE off");
			e.printStackTrace();
			Assert.assertTrue(false, "Home name cannot be modified with BLE off");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyManageHomeUITest() {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			mh.verifyHomeManagementButton();
		}catch(Exception e) {
			Log.addMessage("Failed to verify all elements in manage homes page");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify all elements in manage homes page");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="firstHome")
	public void valWifiOffManageHomeUITest(String homename) {
		try {
			ManageHomesPage ch = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			EnterHomeNamePage eh = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
			System.out.println("Wait for Wifi Off");
			Utility.simpleWait(27000);
			//ch.clickCancelButton();
			ch.verifyHomeOfflineBanner();
			ch.clickAddHomeButton();
			eh.clickCancelButton();
			Log.addMessage("Home cannot be added with WiFi off condition");
		}catch(Exception e) {
			Log.addMessage("Home added with Wifi off condition");
			e.printStackTrace();
			Assert.assertTrue(false, "Home added with Wifi off condition");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="firstHome")
	public void valBLEOffManageHomeUITest(String homename) {
		try {
			ManageHomesPage ch = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			EnterHomeNamePage eh = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
			System.out.println("Wait for Wifi ON and BLE OFF");
			Utility.simpleWait(27000);
			ch.clickAddHomeButton();
			eh.enterHomeName(homename);
			eh.clickBackButton();
		}catch(Exception e) {
			Log.addMessage("Failed to add home");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to add home");
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="tohomeNm")
	public void viewManageHomeScrollTest(String toHomeName, String fromHomeName) {
		try {
			Utility.simpleWait(27000);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			mh.viewManageHomeScroll(toHomeName);
			Log.addMessage("Manage homes page is scrollable");
		}catch(Exception e) {
			Log.addMessage("Failed to scroll manage homes page");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to scroll manage homes page");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="tohomeNm")
	public void verifyHomeNameListOrderTest(String toHomeName, String fromHomeName) {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			//mh.clickBackButton();
			mh.viewAscHomeName(toHomeName, fromHomeName);
			Log.addMessage("Manage homes page is scrollable");
		}catch(Exception e) {
			Log.addMessage("Failed to scroll manage homes page");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to scroll manage homes page");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void logOutFromHomeOwnerTest() {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 mh.clickBackButton();
			 ld.clickHamburgerButton();
			 Thread.sleep(2000);
			 String lsttext ="Log Out";
			 if(device.equals("android")) {
				 System.out.println("in scroll");
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")).click();
					//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text('Log Out'));")).click();
			 }else {
				 mp.clickLogoutButton();
			 }
			 mp.clickOKButton();
			 
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void clickCreateAccountTest() {
		 try {
			 LoginPage lp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 AccountNamePage an = new AccountNamePage((AppiumDriver<MobileElement>) driver);
			 lp.clickCreateAnAccountButton();
			 Thread.sleep(5000);
			 Log.addMessage("Clicked create account button");
			 //Thread.sleep(27000);//for test in between
			 an.enterFirstName("specBVT");
			 an.enterLastName("envBVT");
			 an.clickNextButton();
			 System.out.println("after val return");
			 Log.addMessage("Account name entered");
		 }catch(Exception e) {
			 Log.addMessage("Failed to click create account button");
			 e.printStackTrace();
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vemail")
	public void validEmailTest(String email) {
		try {
			EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			//Thread.sleep(1000);
			System.out.println("in val main");
			ee.enterEmail(email);
			ee.clickSubmitButton();
			//Thread.sleep(3000);
			cv.selectEmail();
			cv.clickSubmit();
			Thread.sleep(15000);
			System.out.println("wait to retrieve verification code from email");
			//get verification code from mail and submit
			cvp.enterMobileCode("123456");
			Thread.sleep(5000);//to edit while testing
			cvp.clickSubmitButton();
			Log.addMessage("Email validated");
		}catch(Exception e){
			Log.addMessage("Failed to validate email");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to validate email");
		} 
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="vphone")
	public void validMobileTest(String mobileNum) {
		 try {
			 EnterMobileNumberPage em = new EnterMobileNumberPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cv = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 em.enterMobileNumber(mobileNum);
			 em.clickSubmitButton();
			 Log.addMessage("Phone number entered");
			 
			 System.out.println("Wait for reading code from email");
			 Thread.sleep(15000);
			 cv.enterMobileCode("123456");
			 Thread.sleep(5000);//for editing wo reading from mail for testing purpose
			 cv.clickSubmitButton();
			 Log.addMessage("Email verification Code entered");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter phone number");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter phone number");
		 }
	}
	
	 @SuppressWarnings("unchecked")
	 @Test(dataProvider="vldSecQn")
	 public void validSecurityQuestionTest(String qn1,String ans1,String qn2, String ans2,String qn3, String ans3) {
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
			 Log.addMessage("Entered security questions");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter security questions");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter security questions");
		 }
	 }
	 
	 @SuppressWarnings("unchecked")
	 @Test(dataProvider="othermemlogin")
	 public void validPasswordTest(String usrName,String pwd) {
		 try {
			 EnterPasswordPage cp = new EnterPasswordPage((AppiumDriver<MobileElement>) driver);
			
			 cp.enterPassword(pwd);
			 cp.reEnterPassword(pwd);
			 cp.clickSubmitButton();
			 Utility.simpleWait(5000);
			 cp.clickOKButton();
			 
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter login credentials"); 
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter login credentials");
		 }
	}
	
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="adminlogin")
	public void loginHomeAdminOptionTest(String email, String password) {
		try {
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			
			 //Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(5000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 Thread.sleep(15000);
			 System.out.println("wait to retrieve verification code from email");
			 //get verification code from mail and submit
			 cvp.enterMobileCode("123456");
			 Thread.sleep(5000);//to edit while testing
			 cvp.clickSubmitButton(); 
			 Thread.sleep(15000);
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void modifyLockSoundOptionTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			ld.clickLockSettingsButton();
			ls.clickLockSoundsButton();
			Utility.simpleWait(5000);
			ls.clickBackButton();
		}catch(Exception e) {
			Log.addMessage("Failed to verify all elements in manage homes page");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify all elements in manage homes page");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void viewShareHomeAdminOptionTest() {
		try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
		     ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
		     ld.clickHamburgerButton();
			 mf.clickManageButton();
			 mh.verifyAdminHomeManagementButton();
		}catch(Exception e) {
			Log.addMessage("Failed to verify all elements in manage homes page");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify all elements in manage homes page");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="firstHome")
	public void verifyModifiedHomeNameAsAdminTest(String modHomeName) {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			mh.verifyModifiedHomeNameAsAdmin(modHomeName);
		}catch(Exception e) {
			Log.addMessage("Failed to verify all elements in manage homes page");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify all elements in manage homes page");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="lsharepopup")
	public void leaveHomeSharePopupTest(String titleMsg, String valMsg, String valMsg2) {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			mh.clickLeaveShare();
			mh.verifyLeaveSharePopUpVerbiage(titleMsg,valMsg);
			mh.clickCancel();
			Utility.simpleWait(5000);
			mh.clickLeaveShare();
			mh.clickOkButton();
			Utility.simpleWait(10000);
			mh.verifyLeaveSharePopUpVerbiage("",valMsg2);//test this case
			mh.clickOkButton();
		}catch(Exception e) {
			Log.addMessage("Failed to leave the shared home");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to leave the shared home");
		}
	}
	//check if need to verify if shared home is present then pass dataprovider
	@SuppressWarnings("unchecked")
	@Test
	public void leaveHomeShareReflectionInAdminTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			ld.clickHamburgerButton();
			mp.clickManageButton();
			Thread.sleep(2000);
			mh.verifyLeaveShareHome();
		}catch(Exception e) {
			Log.addMessage("Failed to verify all elements in manage homes page");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify all elements in manage homes page");
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void logOutFromHomeAdminTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			//mh.clickBackButton();
			ld.clickHamburgerButton();
			 Thread.sleep(2000);
			 String lsttext ="Log Out";
			 if(device.equals("android")) {
				 System.out.println("in scroll2");
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")).click();
					//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text('Log Out'));")).click();
			 }else {
				 mp.clickLogoutButton();
			 }
			
			 mp.clickOKButton();
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="ownerlogin")
	public void loginHomeOwnerReflectionTest(String email, String password) {
		try {
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 HomeUserList hu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(5000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 Thread.sleep(15000);
			 System.out.println("wait to retrieve verification code from email");
			 //get verification code from mail and submit
			 cvp.enterMobileCode("123456");
			 Thread.sleep(5000);//to edit while testing
			 cvp.clickSubmitButton(); 
			 Thread.sleep(15000);
			/* ld.clickHamburgerButton();
			 mf.clickManageButton();
			 mh.clickManageHomeUsersButton();*/
			Log.addMessage("Logged in");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="adminAccessCode")
	public void verifyAccesCodeByAdminInOwnerTest(String accessCode) {
		try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver); 
			 ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 ld.clickAccessCodeButton();
			 va.verifyUserAccessCode(accessCode);
			 va.clickBackButton();
		}catch(Exception e) {
			Log.addMessage("Access code not listed for the user");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	//write code to add access code and edit lock settings
	@SuppressWarnings("unchecked")
	@Test(dataProvider="adminAudio")
	public void verifySettingsByAdminInOwnerTest(String adminAudio) {
		try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver); 
			 LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 ld.clickLockSettingsButton();
			ls.getLockLEDStatus(adminAudio);
		}catch(Exception e) {
			Log.addMessage("Lock Settings not updated for the user");
			e.printStackTrace();
			Assert.assertTrue(false, "Lock Settings not updated for the user");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="adminUserName")
	public void leaveHomeShareReflectionInOwnerTest(String homeUserName) {
		try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 ViewAccessCodesPage va = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			 HomeUserList hu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			
			 hu.verifyLeaveShareByAdminInOwner(homeUserName,"leave");
			Log.addMessage("Logged in");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void logOutFromHomeOwnerAfterVerifyTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			HomeUserList hu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			hu.clickBackButton();
			mh.clickBackButton();
			ld.clickHamburgerButton();
			 Thread.sleep(2000);
			 String lsttext ="Log Out";
			 if(device.equals("android")) {
				 System.out.println("in scroll2");
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")).click();
					//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text('Log Out'));")).click();
			 }else {
				 mp.clickLogoutButton();
			 }
			
			 mp.clickOKButton();
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="memlogin")
	public void loginHomeMemberOptionTest(String email, String password) {
		try {
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(5000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 Thread.sleep(15000);
			 System.out.println("wait to retrieve verification code from email");
			 //get verification code from mail and submit
			 cvp.enterMobileCode("123456");
			 Thread.sleep(5000);//to edit while testing
			 cvp.clickSubmitButton(); 
			 Thread.sleep(15000);
				
			 ld.clickHamburgerButton();
			 mf.clickManageButton();
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void viewShareHomeMemberOptionTest() {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			mh.verifyMemberHomeManagementButton();
			//mh.clickBackButton();
		}catch(Exception e) {
			Log.addMessage("Failed to verify all elements in manage homes page");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify all elements in manage homes page");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="firstHome")
	public void verifyModifiedHomeNameAsMemberTest(String modhmName) {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			mh.verifyModifiedHomeNameAsMember(modhmName);
			//mh.clickBackButton();
		}catch(Exception e) {
			Log.addMessage("Failed to verify all elements in manage homes page");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify all elements in manage homes page");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="lsharepopup")
	public void leaveHomeShareMemberTest(String titleMsg, String valMsg, String valMsg2) {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			mh.clickLeaveShare();
			mh.verifyLeaveSharePopUpVerbiage(titleMsg,valMsg);
			mh.clickCancel();
			Utility.simpleWait(5000);
			mh.clickLeaveShare();
			mh.clickOkButton();
			Utility.simpleWait(10000);
			mh.verifyLeaveSharePopUpVerbiage("",valMsg2);//test this case
			mh.clickOkButton();
		
		}catch(Exception e) {
			Log.addMessage("Failed to leave the shared home");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to leave the shared home");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void leaveHomeShareReflectionInMemberTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			ld.clickHamburgerButton();
			mp.clickManageButton();
			Thread.sleep(2000);
			mh.verifyLeaveShareHome();
		}catch(Exception e) {
			Log.addMessage("Failed to verify all elements in manage homes page");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify all elements in manage homes page");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void logOutFromHomeMemberTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 ld.clickHamburgerButton();
			 Thread.sleep(2000);
			 String lsttext ="Log Out";
			 if(device.equals("android")) {
				 System.out.println("in scroll3");
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")).click();
					//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text('Log Out'));")).click();
			 }else {
				 mp.clickLogoutButton();//added on 29-07-2020 regression
			 }
			 mp.clickOKButton();
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="ownerlogin")
	public void loginHomeOwnerTest(String email, String password) {
		try {
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(5000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 Thread.sleep(15000);
			 System.out.println("wait to retrieve verification code from email");
			 //get verification code from mail and submit
			 cvp.enterMobileCode("123456");
			 Thread.sleep(5000);//to edit while testing
			 cvp.clickSubmitButton(); 
			 Thread.sleep(15000);
				
			 ld.clickHamburgerButton();
			 mf.clickManageButton();
			 // mh.deleteHome();//check this added on 06 sep 2020
			Log.addMessage("Logged in");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="memberUserName")
	public void leaveHomeShareMemReflectionInOwnerTest(String homeUserName) {
		try {
			 HomeUserList hu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 mh.clickManageHomeUsersButton();
			 hu.verifyLeaveShareByAdminInOwner(homeUserName,"leave");
			Log.addMessage("Logged in");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="sendShare")
	public void sendHomeShareToAdminTest(String userName, String email) {
		 try {
			 NewUserPage nu = new NewUserPage((AppiumDriver<MobileElement>) driver);
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 HomeUsersPage al = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			 NewUserEmailPage ne = new NewUserEmailPage((AppiumDriver<MobileElement>) driver);
			 mh.clickManageHomeUsersButton();
			 al.clickAddUserButton();
			 nu.enterNewUser(userName);
			 nu.clickNextButton();
			 ne.enterNewEmail(email);
			 ne.clickSubmitButton();
			 Utility.simpleWait(4000);
			 ne.clickOKButton();
		 }catch(Exception e) {
			 Log.addMessage("Failed to display Phone Number");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter Phone Number");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void userAccessStatusAfterSendShareOwnerTest() {
		 try {
			 HomeUsersPage al = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			 al.getUserShareStatus();
		 }catch(Exception e) {
			 Log.addMessage("Failed to display Phone Number");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter Phone Number");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void logOutFromHomeOwnerStatusTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			//mh.clickBackButton();
			ld.clickHamburgerButton();
			 Thread.sleep(2000);
			 String lsttext ="Log Out";
			 if(device.equals("android")) {
				 System.out.println("in scroll2");
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")).click();
					//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text('Log Out'));")).click();
			 }else {
				 mp.clickLogoutButton();
			 }
			
			 mp.clickOKButton();
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="adminlogin")
	public void loginHomeAdminShAcceptTest(String email, String password) {
		try {
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(5000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 Thread.sleep(15000);
			 System.out.println("wait to retrieve verification code from email");
			 //get verification code from mail and submit
			 cvp.enterMobileCode("123456");
			 Thread.sleep(5000);//to edit while testing
			 cvp.clickSubmitButton(); 
			 Thread.sleep(15000);
			 ld.clickOKButton();//to accept invite popup	
			
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void userAccessStatusAdminTest() {
		 try {
			 HomeUsersPage al = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			 al.getUserShareStatus();
		 }catch(Exception e) {
			 Log.addMessage("Failed to display Phone Number");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter Phone Number");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void logOutFromHomeAdminShAcceptTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			//mh.clickBackButton();
			ld.clickHamburgerButton();
			 Thread.sleep(2000);
			 String lsttext ="Log Out";
			 if(device.equals("android")) {
				 System.out.println("in scroll2");
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")).click();
					//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text('Log Out'));")).click();
			 }else {
				 mp.clickLogoutButton();
			 }
			
			 mp.clickOKButton();
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="ownerlogin")
	public void loginHomeOwnerAccessDemoteTest(String email, String password) {
		try {
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 HomeUserList hu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(5000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 Thread.sleep(15000);
			 System.out.println("wait to retrieve verification code from email");
			 //get verification code from mail and submit
			 cvp.enterMobileCode("123456");
			 Thread.sleep(5000);//to edit while testing
			 cvp.clickSubmitButton(); 
			 Thread.sleep(15000);
				
			 ld.clickHamburgerButton();
			 mf.clickManageButton();
			 mh.clickManageHomeUsersButton();
			Log.addMessage("Logged in");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyOwnerAdminToMemberAccessTest() {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			mh.verifyMemberHomeManagementButton();
			//mh.clickBackButton();
		}catch(Exception e) {
			Log.addMessage("Failed to verify all elements in manage homes page");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify all elements in manage homes page");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void logOutFromHomeOwnerShAcceptTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			HomeUserList hu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			hu.clickBackButton();
			mh.clickBackButton();
			ld.clickHamburgerButton();
			 Thread.sleep(2000);
			 String lsttext ="Log Out";
			 if(device.equals("android")) {
				 System.out.println("in scroll2");
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")).click();
					//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text('Log Out'));")).click();
			 }else {
				 mp.clickLogoutButton();
			 }
			
			 mp.clickOKButton();
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="delsharepopup")
	public void deleteHomeShareofAdminPopupTest(String titleMsg, String valMsg, String valMsg2) {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			HomeUsersPage hu = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			HomeUserList nu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			mh.clickManageHomeUsersButton();
			hu.clickAdminUserButton();
			nu.clickDeleteShareButton();
			mh.verifyLeaveSharePopUpVerbiage(titleMsg,valMsg);
			mh.clickCancel();
			Utility.simpleWait(5000);
			nu.clickDeleteShareButton();
			mh.clickOkButton();
			Utility.simpleWait(10000);
			mh.verifyLeaveSharePopUpVerbiage("",valMsg2);//test this case
			mh.clickOkButton();
		}catch(Exception e) {
			Log.addMessage("Failed to leave the shared home");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to leave the shared home");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="adminUserName")
	public void verifyDeleteAdminHomeShareInOwnerTest(String userName) {
		try {
			HomeUserList nu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			nu.clickBackButton();
			nu.verifyLeaveShareByAdminInOwner(userName,"delete");
			Log.addMessage("Home User  access type verified as Member");
		}catch(Exception e) {
			Log.addMessage("Failed to verify access type as member");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify access type as member");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="delsharepopup")
	public void deleteHomeShareofMemberPopupTest(String titleMsg, String valMsg, String valMsg2) {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			HomeUsersPage hu = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			HomeUserList nu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			//mh.clickManageHomeUsersButton();
			hu.clickMemberUserButton();
			nu.clickDeleteShareButton();
			mh.verifyLeaveSharePopUpVerbiage(titleMsg,valMsg);
			mh.clickCancel();
			Utility.simpleWait(5000);
			nu.clickDeleteShareButton();
			mh.clickOkButton();
			Utility.simpleWait(10000);
			mh.verifyLeaveSharePopUpVerbiage("",valMsg2);//test this case
			mh.clickOkButton();
		}catch(Exception e) {
			Log.addMessage("Failed to leave the shared home");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to leave the shared home");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="memberUserName")
	public void verifyDeleteMemberHomeShareInOwnerTest(String userName) {
		try {
			HomeUserList nu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			nu.clickBackButton();
			nu.verifyLeaveShareByAdminInOwner(userName,"delete");
			Log.addMessage("Home User  access type verified as Member");
		}catch(Exception e) {
			Log.addMessage("Failed to verify access type as member");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify access type as member");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="deleHomeLock")
	public void deleteHomeWithLockBleOffTest(String valmessage, String lockName) {
		 try {
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 LockListPage ll = new LockListPage((AppiumDriver<MobileElement>) driver);
			 ConfirmDeleteLockPage cd = new ConfirmDeleteLockPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("Wait for BLE OFF");
			 Thread.sleep(20000);
			 mh.deleteHomeWithLock(valmessage);
			 ll.selectLockName(lockName);
			 cd.deleteLock();
		 }catch(Exception e) {
			 Log.addMessage("Failed to click delete home");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to click delete home");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyHomeLockListTest() {
		 try {
			 HomeLockListPage al = new HomeLockListPage((AppiumDriver<MobileElement>) driver);
			 al.verifyUILockListPage();
			 al.slectOneLock();
			//Log.addMessage("Title of the add home page is :"+appiumDriver.getTitle());
		 }catch(Exception e) {
			 Log.addMessage("Failed to list locks");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to list locks");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void deleteHomeLockTest() {
		 try {
			 ConfirmDeleteLockPage cd = new ConfirmDeleteLockPage((AppiumDriver<MobileElement>) driver);
			 cd.clickDeleteLockButton();
			 cd.clickCancelButton();
			 cd.clickDeleteLockButton();
			 cd.clickOKButton();
			Log.addMessage("Title of the add home page is :"+driver.getTitle());
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter Phone Number");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter Phone Number");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="deleHomeLock")
	public void deleteHomeWithLockBleONTest(String valmessage,String lockName) {
		 try {
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 LockListPage ll = new LockListPage((AppiumDriver<MobileElement>) driver);
			 ConfirmDeleteLockPage cd = new ConfirmDeleteLockPage((AppiumDriver<MobileElement>) driver);
			 System.out.println("Wait for BLE ON");
			 Thread.sleep(20000);
			 mh.deleteHomeWithLock(valmessage);
			 ll.selectLockName(lockName);
			 cd.deleteLock();
			
		 }catch(Exception e) {
			 Log.addMessage("Failed to click delete home");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to click delete home");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="modifiedHome")
	public void valModifyAdminHomeTest(String homename) {
		try {
			LockDashboardPage ld =  new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage ch = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			EnterHomeNamePage eh = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
			System.out.println("Wait for Wifi ON and BLE OFF");
			Utility.simpleWait(27000);
			ld.clickHamburgerButton();
			mf.clickManageButton();
			ch.clickEditHomeNameButton();
			eh.enterHomeName(homename);
			eh.clickSubmitButton();
			eh.clickOKButton();
			Log.addMessage("Home name modified by Admin");
		}catch(Exception e) {
			Log.addMessage("Home name cannot be modified by Admin");
			e.printStackTrace();
			Assert.assertTrue(false, "Home name cannot be modified by Admin");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void manageHomeUserUITest() {
		 try {
			 LockDashboardPage ld =  new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 HomeUsersPage al = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			 //Utility.simpleWait(12000);//to test in between
			 if(device.equals("iOS")) {
				 ld.clickHamburgerButton();
				 mf.clickManageButton();
			 }
			 mh.clickManageHomeUsersButton();
			 al.verifyHomeUserUI();
		 }catch(Exception e) {
			 Log.addMessage("Failed to list all elements of home users page");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to list all elements of home users page");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void manageHomeUserListTest() {
		 try {
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 HomeUsersPage al = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			 al.getUserShareStatus();
			 al.clickAddUserButton();
		 }catch(Exception e) {
			 Log.addMessage("Failed to list home users");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to list home users");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void addHomeUserUITest() {
		 try {
			 NewUserPage nu = new NewUserPage((AppiumDriver<MobileElement>) driver);
			 nu.verifyAddHomeUserUI();
			 nu.clickMemberButton();
		 }catch(Exception e) {
			 Log.addMessage("Failed to display Phone Number");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter Phone Number");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="firstHome")
	public void valWifiOffCreateHomeTest(String homename) {
		try {
			CreateAHomePage ch = new CreateAHomePage((AppiumDriver<MobileElement>) driver);
			EnterHomeNamePage eh = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
			System.out.println("Wait for Wifi Off");
			Utility.simpleWait(27000);
			ch.clickCancelButton();
			ch.clickCreateAHomeButton();
			eh.enterHomeName(homename);
			eh.clickSubmitButton();
			eh.clickCancelButton();
			eh.clickBackButton();
			/*LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			ld.verifyDashboardWithNoLocks();*/
			Log.addMessage("First home created");
		}catch(Exception e) {
			Log.addMessage("Failed to create First Home");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to create First Home");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="addHome")
	public void valAddHomeUserTest(String userName, String valMessage) {
		 try {
			 NewUserPage nu = new NewUserPage((AppiumDriver<MobileElement>) driver);
			 nu.valAddHomeUser(userName, valMessage);
		 }catch(Exception e) {
			 Log.addMessage("Failed to display Phone Number");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter Phone Number");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void addHomeUserEmailUITest() {
		 try {
			 NewUserEmailPage nu = new NewUserEmailPage((AppiumDriver<MobileElement>) driver);
			 nu.verifyAddHomeUserEmailUI();
		 }catch(Exception e) {
			 Log.addMessage("Failed to display Phone Number");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter Phone Number");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void homeUserEmailDoneKeyboardTest() {
		 try {
			 NewUserEmailPage nu = new NewUserEmailPage((AppiumDriver<MobileElement>) driver);
			 nu.enterEmailDoneKey("te");
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter Email");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter Email");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="addHomeEmail")
	public void valAddHomeUserEmailTest(String userEmail, String titleMessage, String valMessage, String toastMessage) {
		 try {
			 NewUserEmailPage nu = new NewUserEmailPage((AppiumDriver<MobileElement>) driver);
			 nu.valAddHomeUserEmail(userEmail, titleMessage, valMessage, toastMessage);
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter Email");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter Email");
		 }
	}
	
	//bvt
	@SuppressWarnings("unchecked")
	@Test(dataProvider="validAddHome")
	public void sendShareHomeUserMemberTest(String valUserName, String valEmail) {
		 try {
			 NewUserPage nu = new NewUserPage((AppiumDriver<MobileElement>) driver);
			 NewUserEmailPage ne = new NewUserEmailPage((AppiumDriver<MobileElement>) driver);
			 HomeUsersPage al = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(12000);//for testing in between
			 if(device.equals("android")) {
				 al.clickAddUserButton(); 
			 }
			//al.clickAddUserButton();//commented for iOS
			 System.out.println("one");
			 nu.enterNewUser(valUserName);
			 System.out.println("two");
			 //nu.verifyAddHomeUserUI();
			 nu.clickMemberButton();
			 System.out.println("three");
			 nu.clickNextButton();
			 System.out.println("four");
			 ne.enterNewEmail(valEmail);
			 System.out.println("five");
			 ne.clickSubmitButton();
			 System.out.println("fivesix");
			 ne.clickOKButton();
			 Log.addMessage("New user added");
		 }catch(Exception e) {
			 Log.addMessage("Failed to add user name");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to add user name");
		 }
	}
	
	//bvt
	@SuppressWarnings("unchecked")
	@Test(dataProvider="validAddAnthrHome")
	public void sendShareHomeUserAdminTest(String valUserName, String valEmail) {
		 try {
			 NewUserPage nu = new NewUserPage((AppiumDriver<MobileElement>) driver);
			 NewUserEmailPage ne = new NewUserEmailPage((AppiumDriver<MobileElement>) driver);
			 HomeUsersPage al = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			 
			 al.clickAddUserButton();
			 nu.enterNewUser(valUserName);
			 nu.clickAdminButton();
			 nu.clickNextButton();
			 ne.enterNewEmail(valEmail);
			 ne.clickSubmitButton();
			 ne.clickOKButton();
		 }catch(Exception e) {
			 Log.addMessage("Failed to list all elements of home users page");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to list all elements of home users page");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="memberInvitePopup")
	public void sendInvitePopupTest(String expTitle, String expMessage) {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			mh.verifyLeaveSharePopUpVerbiage(expTitle,expMessage);
			mh.clickOkButton();
			Log.addMessage("Share invite sent pop up verbiage is matching");
		}catch(Exception e) {
			Log.addMessage("Share invite pop up verbiage is not matching");
			e.printStackTrace();
			Assert.assertTrue(false, "Share invite pop up verbiage is not matching");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void pendingBannerDisplayTest() {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			HomeUsersPage hu = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			HomeUserList nu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			
			hu.clickMemberUserButton();
			nu.verifyHomeUserUI();
			nu.clickBackButton();
			Log.addMessage("All elements displayed in the pending user page");
		}catch(Exception e) {
			Log.addMessage("Failed to display all UI elements");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display all UI elements");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void logoutHomeOwnerPendingAcceptTest() {
		try {
			NewUserPage nu = new NewUserPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			System.out.println("in1");
			//Utility.simpleWait(12000);
			nu.clickBackButton();
			System.out.println("in2");
			//Utility.simpleWait(3000);
			mh.clickBackButton();
			System.out.println("in3");
			//Utility.simpleWait(3000);
			ld.clickHamburgerButton();
			Thread.sleep(2000);
			String lsttext ="Log Out";
			if(device.equals("android")) {
				 System.out.println("in scroll3");
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")).click();
			}else {
				 mp.clickLogoutButton();
			}
			mp.clickOKButton();
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="memlogin")
	public void loginHomeMemberPendingShareRejectTest(String email, String password) {
		try {
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(5000);
			 cv.selectEmail();
			 cv.clickSubmit();
			// Thread.sleep(15000);commented on 06-11-2020
			 System.out.println("wait to retrieve verification code from email");
			 //added reademail on 04-11-2020
			 cvp.readCodeFromEmail("email.address2", "email.password2");
			 Thread.sleep(5000);//to edit while testing
			 cvp.clickSubmitButton(); 
			 Thread.sleep(3000);//
			 cvp.clickNotNowButton();
			 Log.addMessage("Clicked not now button");
			 Thread.sleep(15000);
			 //cvp.clickOKButton();//added on 03-11-2020
			 if(device.equals("android")) {
				 cvp.clickCancelButton();
			 }else {
				 cvp.clickDeclineButton();
			 }
			 //ld.clickHamburgerButton();
			// mf.clickManageButton();
			Log.addMessage("Clicked log in");
		}catch(Exception e) {
			Log.addMessage("Failed to click log in");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log in");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void logoutHomeMemberPendingAcceptTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			
			ld.clickHamburgerButton();
			Thread.sleep(2000);
			String lsttext ="Log Out";
			if(device.equals("android")) {
				 System.out.println("in scroll3");
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")).click();
			}else {
				 mp.clickLogoutButton();
			}
			mp.clickOKButton();
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="adminlogin")
	public void loginHomeAdminPendingShareAcceptTest(String email, String password) {
		try {
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 HomeUserList hu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(5000);
			 cv.selectEmail();
			 cv.clickSubmit();
			// Thread.sleep(15000);
			 System.out.println("wait to retrieve verification code from email");
			 //get verification code from mail and submit
			// cvp.enterMobileCode("123456");
			 cvp.readCodeFromEmail("email.address1", "email.password1");
			 Thread.sleep(5000);//to edit while testing
			 cvp.clickSubmitButton(); 
			 Thread.sleep(3000);
			 cvp.clickNotNowButton();
			 Thread.sleep(15000);
			 if(device.equals("iOS")) {
				 cvp.clickAcceptButton();
			 }else {
				 cvp.clickOKButton();
			 }
			Log.addMessage("Admin share accept is rejected");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void logoutHomeAdminPendingAcceptTest() {
		try {
			NewUserPage nu = new NewUserPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			System.out.println("in1");
			//commented on 04-11-2020
			/*nu.clickBackButton();
			System.out.println("in2");
			//Utility.simpleWait(3000);
			mh.clickBackButton();
			System.out.println("in3");*/
			//Utility.simpleWait(3000);
			ld.clickHamburgerButton();
			//Thread.sleep(2000);
			String lsttext ="Log Out";
			if(device.equals("android")) {
				 System.out.println("in scroll3");
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")).click();
			}else {
				 mp.clickLogoutButton();
			}
			mp.clickOKButton();
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	//bvt
	@SuppressWarnings("unchecked")
	@Test(dataProvider="ownerlogin")
	public void loginHomeOwnerShareHomeNameTest(String email, String password) {
		try {
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 HomeUserList hu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(5000);
			 cv.selectEmail();
			 cv.clickSubmit();
			// Thread.sleep(15000);
			 System.out.println("wait to retrieve verification code from email");
			 //get verification code from mail and submit
			// cvp.enterMobileCode("123456");
			 cvp.readCodeFromEmail("email.address3", "email.password3");
			// cvp.readCodeFromEmail("email.address", "email.password");//commented for testing inbetween on 23-03-21
			 Thread.sleep(5000);//to edit while testing
			 cvp.clickSubmitButton(); 
			 Thread.sleep(3000);
			 cvp.clickNotNowButton();
			 Thread.sleep(15000);
				
			 ld.clickHamburgerButton();
			 mf.clickManageButton();
			Log.addMessage("Logged in");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	//bvt
	@SuppressWarnings("unchecked")
	@Test(dataProvider="validAddHome")
	public void sendShareHomeUserMemberEditTest(String valUserName, String valEmail) {
		 try {
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 NewUserPage nu = new NewUserPage((AppiumDriver<MobileElement>) driver);
			 NewUserEmailPage ne = new NewUserEmailPage((AppiumDriver<MobileElement>) driver);
			 HomeUsersPage al = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			// Thread.sleep(12000);//for testing in between
			 
			 mh.clickManageHomeUsersButton();
			 al.clickAddUserButton();
			 nu.enterNewUser(valUserName);
			 nu.verifyAddHomeUserUI();
			 nu.clickMemberButton();
			 nu.clickNextButton();
			 ne.enterNewEmail(valEmail);
			 ne.clickSubmitButton();
			 ne.clickOKButton();
			 Log.addMessage("New user added");
		 }catch(Exception e) {
			 Log.addMessage("Failed to add user name");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to add user name");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyOwnerHomePendingToMemberTest() {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			HomeUsersPage hu = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			
			mh.clickManageHomeUsersButton();
			hu.verifyHomeUserUI();
			hu.getUserShareStatus();
		}catch(Exception e) {
			Log.addMessage("Failed to update the pending access to member in owners page");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update the pending access to member in owners page");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyOwnerHomeEditUserNameUITest() {
		try {
			HomeUsersPage hu = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			NewUserPage mh = new NewUserPage((AppiumDriver<MobileElement>) driver);
			
			hu.clickMemberUserButton();
			mh.verifyAddHomeUserUI();
			
		}catch(Exception e) {
			Log.addMessage("Failed to update the modified home name in owners page");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update the modified home name in owners page");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="modHome")
	public void valEditHomeUserTest(String userName, String valMessage) {
		 try {
			 NewUserPage nu = new NewUserPage((AppiumDriver<MobileElement>) driver);
			 nu.valAddHomeUser(userName, valMessage);
		 }catch(Exception e) {
			 Log.addMessage("Failed to display Phone Number");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter Phone Number");
		 }
	}
	
	//bvt
	@SuppressWarnings("unchecked")
	@Test(dataProvider="modValidHome")
	public void validOwnerHomeEditUserNameTest(String valHome) {
		try {
			ManageHomesPage ch = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			EnterHomeNamePage eh = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
			HomeUsersPage hu = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			//Utility.simpleWait(10000);//to test in btwn
			hu.clickPendingUserButton();
			ch.clickEditHomeUserButton();
			eh.enterHomeName(valHome);
			eh.clickSubmitButton();
			//eh.clickOKButton();
		}catch(Exception e) {
			Log.addMessage("Failed to update the modified home name in owners page");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update the modified home name in owners page");
		}
	}
	
	//bvt
	@SuppressWarnings("unchecked")
	@Test
	public void validEditHomeUserAccessLevelTest() {
		 try {
			 ManageHomesPage ch = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 HomeUserList hu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			 HomeUserAccessType nu = new HomeUserAccessType((AppiumDriver<MobileElement>) driver);
			// Thread.sleep(10000);
			 ch.clickEditAccessTypeButton();
			// hu.clickAccessType();
			 nu.selectAdmin();
			 Thread.sleep(10000);
			 hu.verifyUserAccessType("Admin");
		 }catch(Exception e) {
			 Log.addMessage("Failed to display Phone Number");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter Phone Number");
		 }
	}
	
	//bvt
	@SuppressWarnings("unchecked")
	@Test
	public void deleteValidHomeShareMemberTest() {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			HomeUsersPage hu = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			HomeUserList nu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			//mh.clickManageHomeUsersButton();
			//Thread.sleep(5000);//to test in btwn
			Thread.sleep(3000);
			hu.clickPendingUserButton();
			nu.clickDeleteShareButton();
			mh.clickOkButton();
			Utility.simpleWait(10000);
			mh.clickOkBtn();//changed on 04-11-2020
			Log.addMessage("Home share deleted for member from owner account");
		}catch(Exception e) {
			Log.addMessage("Failed to delete the shared home for member");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to delete the shared home for member");
		}
	}
	
	//bvt
	@SuppressWarnings("unchecked")
	@Test(dataProvider="validAddHome")
	public void sendShareHomeUserMemberAgnTest(String valUserName, String valEmail) {
		 try {
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 NewUserPage nu = new NewUserPage((AppiumDriver<MobileElement>) driver);
			 NewUserEmailPage ne = new NewUserEmailPage((AppiumDriver<MobileElement>) driver);
			 HomeUsersPage al = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			 Thread.sleep(12000);//for testing in between
			 
			 //mh.clickManageHomeUsersButton();
			 al.clickAddUserButton();
			 nu.enterNewUser(valUserName);
			 nu.verifyAddHomeUserUI();
			 nu.clickMemberButton();
			 nu.clickNextButton();
			 ne.enterNewEmail(valEmail);
			 ne.clickSubmitButton();
			 ne.clickOKButton();
			 Log.addMessage("New user added");
		 }catch(Exception e) {
			 Log.addMessage("Failed to add user name");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to add user name");
		 }
	}
	
	//bvt
	@SuppressWarnings("unchecked")
	@Test
	public void logoutHomeOwnerPendingAcceptAgnTest() {
		try {
			NewUserPage nu = new NewUserPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			HomeUsersPage al = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			Utility.simpleWait(12000);
			System.out.println("in1");
			nu.clickBackButton();
			System.out.println("in2");
			//Utility.simpleWait(3000);
			mh.clickNavBackButton();//changed on 05-11-2020
			//mh.clickNavBackButton();//changed on 05-11-2020
			mh.clickBackButton();
			System.out.println("in3");
			//Utility.simpleWait(3000);
			ld.clickHamburgerButton();
			Thread.sleep(2000);
			String lsttext ="Log Out";
			if(device.equals("android")) {
				 System.out.println("in scroll3");
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")).click();
			}else {
				 mp.clickLogoutButton();
			}
			mp.clickOKButton();
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	//bvt
	@SuppressWarnings("unchecked")
	@Test(dataProvider="memlogin")
	public void loginHomeMemberPendingShareAcceptTest(String email, String password) {
		try {
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			// Thread.sleep(12000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(5000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 //Thread.sleep(15000);
			 System.out.println("wait to retrieve verification code from email");
			 //get verification code from mail and submit
			 //cvp.enterMobileCode("123456");
			 //added reademail on 04-11-2020
			 cvp.readCodeFromEmail("email.address2", "email.password2");
			 //Thread.sleep(5000);//to edit while testing
			 cvp.clickSubmitButton(); 
			 Thread.sleep(3000);
			 cvp.clickNotNowButton();
			 Thread.sleep(15000);
			 //cvp.clickOKButton();//commented on 05-11-2020
			 if(device.equals("iOS")) {
				 cvp.clickAcceptButton();
			 }else {
				 cvp.clickOKButton();
			 }
			 //cvp.clickCancelButton();
			 //ld.clickHamburgerButton();
			// mf.clickManageButton();
			Log.addMessage("Clicked log in");
		}catch(Exception e) {
			Log.addMessage("Failed to click log in");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log in");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void valEditHomeUserAccessLevelTest() {
		 try {
			 HomeUserList hu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			 HomeUserAccessType nu = new HomeUserAccessType((AppiumDriver<MobileElement>) driver);
			// nu.clickBackButton();
			 hu.clickAccessType();
			 nu.verifyAddHomeUserAccessLevelUI();
		 }catch(Exception e) {
			 Log.addMessage("Failed to display Phone Number");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter Phone Number");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void editHomeUserAccessLevelToMemberTest() {
		 try {
			 HomeUserAccessType nu = new HomeUserAccessType((AppiumDriver<MobileElement>) driver);
			 HomeUserList hu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			 nu.selectMember();
			 Thread.sleep(10000);
			
		 }catch(Exception e) {
			 Log.addMessage("Failed to modify access level");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to modify access level");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyEditHomeUserAccessLevelToMemberTest() {
		 try {
			 
			 HomeUserList hu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			 hu.verifyUserAccessType("Member");
		 }catch(Exception e) {
			 Log.addMessage("Failed to display Phone Number");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter Phone Number");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void editHomeUserAccessLevelToAdminTest() {
		 try {
			 HomeUserList hu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			 HomeUserAccessType nu = new HomeUserAccessType((AppiumDriver<MobileElement>) driver);
			 hu.clickAccessType();
			 nu.selectAdmin();
			 Thread.sleep(10000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to update access level to admin");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to update access level to admin");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyEditHomeUserAccessLevelToAdminTest() {
		 try {
			 HomeUserList hu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			 hu.verifyUserAccessType("Admin");
		 }catch(Exception e) {
			 Log.addMessage("Failed to verify access level to admin");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to verify access level to admin");
		 }
	}
	

	@SuppressWarnings("unchecked")
	@Test
	public void verifyOwnerManageUsersAdminTest() {
		 try {
			 HomeUsersPage hp = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			 HomeUserList hu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			 hu.clickBackButton();
			 hp.clickAdminUserButton();
			 hu.verifyHomeUserUI();
			 hu.clickBackButton();
			 Thread.sleep(10000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to display all UI elements in admin view of owner account");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to display all UI elements in admin view of owner account");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyOwnerManageUsersMemberTest() {
		 try {
			 HomeUsersPage hp = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			 HomeUserList hu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			 hp.clickMemberUserButton();
			 hu.verifyHomeUserUI();
			 hu.clickBackButton();
			 Thread.sleep(10000);
		 }catch(Exception e) {
			 Log.addMessage("Failed to display all UI elements in member view of owner account");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to display all UI elements in member view of owner account");
		 }
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="delsharepopup")
	public void deleteHomeShareAdminTest(String titleMsg, String valMsg, String valMsg2) {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			HomeUsersPage hu = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			HomeUserList nu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			//mh.clickManageHomeUsersButton();
			hu.clickMemberUserButton();
			nu.clickDeleteShareButton();
			mh.verifyLeaveSharePopUpVerbiage(titleMsg,valMsg);
			mh.clickCancel();
			Utility.simpleWait(5000);
			nu.clickDeleteShareButton();
			mh.clickOkButton();
			Utility.simpleWait(10000);
			mh.verifyLeaveSharePopUpVerbiage("",valMsg2);//test this case
			mh.clickOkButton();
			Log.addMessage("Home share deleted for member from owner account");
		}catch(Exception e) {
			Log.addMessage("Failed to delete the shared home for member");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to delete the shared home for member");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="memberUserName")
	public void verifyDeleteShareLandPageAdminTest(String userName) {
		try {
			HomeUserList nu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			nu.clickBackButton();
			nu.verifyLeaveShareByAdminInOwner(userName,"delete");
			Log.addMessage("Home share deleted for member from owner account");
		}catch(Exception e) {
			Log.addMessage("Failed to verify the landing page after delete share");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify the landing page after delete share");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void logoutHomeOwnerTest() {
		try {
			NewUserPage nu = new NewUserPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			nu.clickBackButton();
			Utility.simpleWait(3000);
			mh.clickBackButton();
			Utility.simpleWait(3000);
			ld.clickHamburgerButton();
			Thread.sleep(2000);
			String lsttext ="Log Out";
			if(device.equals("android")) {
				 System.out.println("in scroll3");
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")).click();
			}else {
				 mp.clickLogoutButton();
			}
			mp.clickOKButton();
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="adminlogin")
	public void loginHomeAdminShareAcceptTest(String email, String password) {
		try {
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(5000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 Thread.sleep(15000);
			 System.out.println("wait to retrieve verification code from email");
			 //get verification code from mail and submit
			 cvp.enterMobileCode("123456");
			 Thread.sleep(5000);//to edit while testing
			 cvp.clickSubmitButton(); 
			 Thread.sleep(15000);
				
			 //ld.clickHamburgerButton();
			// mf.clickManageButton();
			Log.addMessage("Clicked log in");
		}catch(Exception e) {
			Log.addMessage("Failed to click log in");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log in");
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void viewAccessCodesBeforeLockPairTest() {
		try {
			 LockDashboardPage lp = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 ViewAccessCodesPage ap = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			// lp.clickCancelButton();//for testing in between
			 Thread.sleep(10000);
			 Utility.simpleWait(5000);
			 lp.clickAccessCodeButton();
			 Utility.simpleWait(5000);
			 ap.verifyUIFP();
		}catch(Exception e) {
			Log.addMessage("Failed to view access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to view access code");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test ()
	public void addAccessCodeBeforeLockPairTest() {
		try {
			ViewAccessCodesPage ap = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			AddAccessCodePage ac = new AddAccessCodePage((AppiumDriver<MobileElement>) driver);
			 ap.clickAddAccessCodeButton();
			 ac.enterAccessCodeName("tcode2");
			 ac.clickGenerateRandomCodeButton();
			 ac.clickSubmitButton();
			 Utility.simpleWait(10000);
			 System.out.println("Access code tcode2 created");
			 ap.clickBackButton();
		}catch(Exception e) {
			Log.addMessage("Failed to add access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to add access code");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void viewLockHistoryBeforePairTest() {
		try {
			 LockDashboardPage lp = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 LockEventHistoryPage le = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
			 lp.clickCancelButton();//check if pair pop up comes in this step
			 lp.clickLockHistoryButton();
			 Utility.simpleWait(5000);
			 le.verifyLockHistoryScreen();
		}catch(Exception e) {
			Log.addMessage("Failed to view access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to view access code");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void clearLockHistoryBeforePairTest() {
		try {
			 LockEventHistoryPage le = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
			 LockCancelPopupPage lc = new LockCancelPopupPage((AppiumDriver<MobileElement>) driver);
			 Utility.simpleWait(8000);
			 le.clearHistory();
			 lc.clickOkButton();
			 Utility.simpleWait(8000);
			 le.clickBackButton();
		}catch(Exception e) {
			Log.addMessage("Failed to view access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to view access code");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void viewLockSettingsBeforePairTest() {
		try {
			 LockDashboardPage lp = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			 Thread.sleep(8000);
			 lp.clickCancelButton();//check as not clicked
			 lp.clickLockSettingsButton();
			 Utility.simpleWait(5000);
			 ls.verifyLockSettingsUI();
			 ls.clickBackButton();
		}catch(Exception e) {
			Log.addMessage("Failed to view access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to view access code");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="inviteAdmin")
	public void adminShareAcceptPopupTest(String titleMsg, String valMsg) {
		try {
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			// mh.clickLeaveShare();
			 mh.verifyLeaveSharePopUpVerbiage(titleMsg,valMsg);
			 //Thread.sleep(27000);//for testing in between
			 Thread.sleep(15000);
			 // mh.clickCancel();
			 Utility.simpleWait(5000);
			 // mh.clickLeaveShare();
			 mh.clickOkButton();
			 Thread.sleep(8000);
			 //ld.clickHamburgerButton();
			 //mf.clickManageButton();
			Log.addMessage("Clicked share accept");
		}catch(Exception e) {
			Log.addMessage("Failed to click share accept");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click share accept");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="adminLockPair")
	public void adminLockPairPopupTest(String titleMsg, String valMsg) {
		try {
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 Thread.sleep(10000);
			// mh.clickLeaveShare();
			 mh.verifyLeaveSharePopUpVerbiage(titleMsg,valMsg);
			 Thread.sleep(15000);
			 Utility.simpleWait(5000);
			 mh.clickCancelButton();//check how to create the pair pop up on tapping lock status
			 //mh.clickOkButton();
			 System.out.println("Lock Status after cancelling invitation is :"+ld.getLockStatus());
			 //lp.lockOperation();
			 Thread.sleep(8000);
			 Log.addMessage("Clicked cancel lock pair");
		}catch(Exception e) {
			Log.addMessage("Failed to click cancel lock pair");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to cancel lock pair");
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void adminAddLockPairTest() {
		try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 ld.clickHamburgerButton();
			 mf.clickManageButton();
			 mh.clickBackButton();
			 System.out.println("adminAddLockPairTest");
			 mh.clickOkButton();
			 LockNextPage1 ln1 =new LockNextPage1((AppiumDriver<MobileElement>) driver); 
			 ln1.clickBkButton();
			 Log.addMessage("Clicked back button");
			 mh.clickOkButton();
			 ln1.clickNext();
			 LockNextPage2 ln2 =new LockNextPage2((AppiumDriver<MobileElement>) driver); 
			 ln2.clickBkButton();
			 Log.addMessage("Clicked back button");
			 ln1.clickNext();
			 System.out.println("Wait for clicking A button to identify the lock in the search page");
			 Utility.simpleWait(5000);
			 ln2.clickNext();
			 Log.addMessage("Clicked next button");
		}catch(Exception e) {
			Log.addMessage("Failed to click next Button");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click next Button");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void selectLockTest() {
		try {
			Thread.sleep(3000);
			SearchLocksPage sl = new SearchLocksPage((AppiumDriver<MobileElement>) driver);
			sl.selectLockoneCell();
			
		}catch(Exception e) {
			Log.addMessage("Failed to select lock");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to select Lock");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="addLockPopup")
	public void lockAddSuccessPopUpVerbiageTest(String expTitle, String expMessage) {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			//mh.clickLeaveShare();
			mh.verifyLeaveSharePopUpVerbiage(expTitle,expMessage);
			Log.addMessage("Lock pairing success pop up verbiage is matching");
		}catch(Exception e) {
			Log.addMessage("FLock pairing success pop up verbiage is not matching");
			e.printStackTrace();
			Assert.assertTrue(false, "Lock pairing success pop up verbiage is not matching");
			
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyLockDashboardUITest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			ld.verifyLockDashboardPage();
			ld.getBatteryPercentageDashboard();
			Log.addMessage("Lock Image present in Manage Home");
		}catch(Exception e) {
			Log.addMessage("Lock Image not present in Manage Home");
			e.printStackTrace();
			Assert.assertTrue(false, "Lock Image not present Manage Home");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyLockDoorTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			ld.clickLockUnlockButton();
			Utility.simpleWait(15000);
			Log.addMessage("Status of the door lock is "+ld.getLockStatus());
		}catch(Exception e) {
			Log.addMessage("Failed to do lock unlock operation on the door");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to do lock unlock operation on the door");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test ()
	public void addAccessCodeAfterLockPairTest() {
		try {
			NewUserPage nu = new NewUserPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			ViewAccessCodesPage ap = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			AddAccessCodePage ac = new AddAccessCodePage((AppiumDriver<MobileElement>) driver);
			 nu.clickBackButton();
			 Utility.simpleWait(3000);
			 mh.clickBackButton();
			 Utility.simpleWait(3000);
			 ld.clickAccessCodeButton();
			 ap.clickAddAccessCodeButton();
			 ac.enterAccessCodeName("tcode3");
			 ac.clickGenerateRandomCodeButton();
			 ac.clickSubmitButton();
			 Utility.simpleWait(10000);
			 System.out.println("Access code tcode3 created");
		}catch(Exception e) {
			Log.addMessage("Failed to add access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to add access code");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void editAccessCodeNameTest() {
		try {
			 ViewAccessCodesPage ap = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			 AccessCodePage ac = new AccessCodePage((AppiumDriver<MobileElement>) driver);
			 EditCodeNamePage ea = new EditCodeNamePage((AppiumDriver<MobileElement>) driver);
			 
			 ap.selSecondFPUser();
			 ac.clickEditCodeName();
			 ea.enterAccessCodeName("tcodes1");
			 ea.clickSubmitButton();
			 System.out.println("Access code modified");
			 Utility.simpleWait(10000);
		}catch(Exception e) {
			Log.addMessage("Failed to modify access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to modify access code");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void editAccessCodeTest() {
		try {
			 ViewAccessCodesPage ap = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			 AccessCodePage ac = new AccessCodePage((AppiumDriver<MobileElement>) driver);
			 EditAccessCodePage ea = new EditAccessCodePage((AppiumDriver<MobileElement>) driver);
			
			 ap.selSecondFPUser();
			 ac.clickEditAccessCode();
			 ea.enterAccessCodePin("111111");
			 ea.clickSubmitButton();
			 Utility.simpleWait(10000);
			 Log.addMessage("Access code name is updated");
		}catch(Exception e) {
			Log.addMessage("Failed to update access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update access code");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void deleteAccessCodeTest() {
		try {
			ViewAccessCodesPage ap = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			AccessCodePage ea = new AccessCodePage((AppiumDriver<MobileElement>) driver);
			ap.selSecondFPUser();
			ea.deleteAccessCode();
			Utility.simpleWait(10000);
			Log.addMessage("Access code name is deleted");
		}catch(Exception e) {
			Log.addMessage("Failed to delete access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to delete access code");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void setAnyTimeScheduleTypeTest() {
		try {
			ViewAccessCodesPage ap = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			AccessCodePage ac = new AccessCodePage((AppiumDriver<MobileElement>) driver);
			SelectScheduleTypePage sp = new SelectScheduleTypePage((AppiumDriver<MobileElement>) driver);
			ap.selFirstFPUser();
			ac.editScheduleType();
			sp.selectAnyTime();
			Utility.simpleWait(10000);
			Log.addMessage("Anytime schedule type is set for the access code");	
		}catch(Exception e) {
			Log.addMessage("Failed to set Anytime schedule type");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to set Anytime schedule type");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void disableAccessCodeTest() {
		try {
			ViewAccessCodesPage ap = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			AccessCodePage ac = new AccessCodePage((AppiumDriver<MobileElement>) driver);
			ap.selFirstFPUser();
			ac.disableAccessCode();
			Utility.simpleWait(10000);
			Log.addMessage("Access code is disabled");
		}catch(Exception e) {
			Log.addMessage("Failed to disable access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to disable access code");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shareAccessCodeTest() {
		try {
			ViewAccessCodesPage ap = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			AccessCodePage ac = new AccessCodePage((AppiumDriver<MobileElement>) driver);
			
			ap.selSecondFPUser();
			ac.clickShareAccessCode();//check below code to go back to app
			ap.clickHomeName();
			ap.clickBackButton();
			ap.clickBackButton();
			Log.addMessage("Access code is shared.");
		}catch(Exception e) {
			Log.addMessage("Failed to share access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to share access code");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void viewLockHistoryAfterPairTest() {
		try {
			 LockDashboardPage lp = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 LockEventHistoryPage le = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
			 
			 lp.clickLockHistoryButton();
			 Utility.simpleWait(5000);
			 le.verifyLockHistoryScreen();
			 le.clickBackButton();
		}catch(Exception e) {
			Log.addMessage("Failed to view access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to view access code");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void viewLockSettingsAfterPairTest() {
		try {
			 LockDashboardPage lp = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			 lp.clickLockSettingsButton();
			 Utility.simpleWait(5000);
			 ls.verifyLockSettingsUI();
		}catch(Exception e) {
			Log.addMessage("Failed to view access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to view access code");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void editLockSettingsNameTest() {
		try {
			 LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			 LockNamePage ln = new LockNamePage((AppiumDriver<MobileElement>) driver);
			 Thread.sleep(15000);
			 Utility.simpleWait(5000);
			 ls.clickEditLockNameButton();
			 ln.enterLockName("IO Doors");
			 ln.clickSubmitButton();
			 Utility.simpleWait(15000);
			 ln.clickOkButton();
			 Utility.simpleWait(5000);
		}catch(Exception e) {
			Log.addMessage("Failed to view access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to view access code");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void pairedSmartPhonesListTest() {
		try {
			 LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			 PairedSmartPhoneListPage ln = new PairedSmartPhoneListPage((AppiumDriver<MobileElement>) driver);
			 ls.clickPairedSmartPhonesButton();
			 ln.verifyPairedPhoneList();
			 ln.clickBackButton();
			 Utility.simpleWait(15000);
			 ls.clickBackButton();
			 Utility.simpleWait(5000);
		}catch(Exception e) {
			Log.addMessage("Failed to view access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to view access code");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void manageMemberHomeUserUITest() {
		 try {
			 //LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			// MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 HomeUsersPage al = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			// ld.clickHamburgerButton();
			// mf.clickManageButton();
			 mh.clickManageHomeUsersButton();
			 al.verifyHomeUserUI();
			 al.clickAddUserButton();
			 Utility.simpleWait(5000);
			 
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter users");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter users");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="modifiedHome")
	public void verifyModAdminHomeNameAsMemberTest(String modhmName) {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			mh.verifyModifiedHomeNameAsMember(modhmName);
			//mh.clickBackButton();
		}catch(Exception e) {
			Log.addMessage("Failed to verify all elements in manage homes page");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify all elements in manage homes page");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void addMemberHomeUserUITest() {
		 try {
			 NewUserPage nu = new NewUserPage((AppiumDriver<MobileElement>) driver);
			 HomeUsersPage al = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			 nu.verifyAddHomeUserUI();
			 nu.clickBackButton();
			 Utility.simpleWait(2000);
			 al.clickAddUserButton();
			 Utility.simpleWait(2000);
			 nu.clickMemberButton();
			 
		 }catch(Exception e) {
			 Log.addMessage("Failed to display Phone Number");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter Phone Number");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="addHome")
	public void valAddMemberHomeUserTest(String userName, String valMessage) {
		 try {
			 NewUserPage nu = new NewUserPage((AppiumDriver<MobileElement>) driver);
			 nu.valAddHomeUser(userName, valMessage);
		 }catch(Exception e) {
			 Log.addMessage("Failed to display Phone Number");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter Phone Number");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void addMemberUserEmailUITest() {
		 try {
			 NewUserEmailPage nu = new NewUserEmailPage((AppiumDriver<MobileElement>) driver);
			 NewUserPage np = new NewUserPage((AppiumDriver<MobileElement>) driver);
			 nu.verifyAddHomeUserEmailUI();
			 np.clickBackButton();
			 Utility.simpleWait(2000);
			 np.clickNextButton();
			 
		 }catch(Exception e) {
			 Log.addMessage("Failed to display Phone Number");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter Phone Number");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void homeMemberUserEmailDoneKeyboardTest() {
		 try {
			 NewUserEmailPage nu = new NewUserEmailPage((AppiumDriver<MobileElement>) driver);
			 nu.enterEmailDoneKey("te");
		 }catch(Exception e) {
			 Log.addMessage("Failed to display Phone Number");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter Phone Number");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="addHomeMemEmail")
	public void valAddMemberUserEmailTest(String userEmail, String titleMessage, String valMessage, String toastMessage) {
		 try {
			 NewUserEmailPage nu = new NewUserEmailPage((AppiumDriver<MobileElement>) driver);
			 nu.valAddHomeUserEmail(userEmail, titleMessage, valMessage, toastMessage);
		 }catch(Exception e) {
			 Log.addMessage("Failed to enter Email");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter Email");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void userAccessStatusAfterSendShareMemberTest() {
		 try {
			 HomeUsersPage al = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			 al.getUserShareStatus();
		 }catch(Exception e) {
			 Log.addMessage("Failed to display Phone Number");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter Phone Number");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void sendShareToMemberTest() {
		try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 HomeUsersPage al = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			 ld.clickHamburgerButton();
			 mf.clickManageButton();
			 mh.clickManageHomeUsersButton();
			 al.clickAddUserButton();
			 Utility.simpleWait(5000);
		}catch(Exception e) {
			Log.addMessage("Failed to view access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to view access code");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void logOutFromAdminHomeTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			//mh.clickBackButton();
			ld.clickHamburgerButton();
			 Thread.sleep(2000);
			 String lsttext ="Log Out";
			 if(device.equals("android")) {
				 System.out.println("in scroll2");
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")).click();
					//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text('Log Out'));")).click();
			 }else {
				 mp.clickLogoutButton();
			 }
			
			 mp.clickOKButton();
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="memlogin")
	public void loginToMemberHomeTest(String email, String password) {
		try {
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(5000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 Thread.sleep(15000);
			 System.out.println("wait to retrieve verification code from email");
			 //get verification code from mail and submit
			 cvp.enterMobileCode("123456");
			 Thread.sleep(5000);//to edit while testing
			 cvp.clickSubmitButton(); 
			 Thread.sleep(15000);
			ld.clickOKButton();//to accept share invite
			 ld.clickHamburgerButton();
			 mf.clickManageButton();
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	

	@SuppressWarnings("unchecked")
	@Test(dataProvider="inviteMember")
	public void shareInviteMemberWithoutHomeTest(String userName, String emailName) {
		try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 HomeUsersPage al = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			 NewUserPage nu = new NewUserPage((AppiumDriver<MobileElement>) driver);
			 NewUserEmailPage ne = new NewUserEmailPage((AppiumDriver<MobileElement>) driver);
			 Utility.simpleWait(20000);//for test in between
			 ld.clickHamburgerButton();
			 mf.clickManageButton();
			 mh.clickManageHomeUsersButton();
			 al.clickAddUserButton();
			 nu.clickMemberButton();
			 nu.enterNewUser(userName);
			 nu.clickNextButton();
			 ne.enterNewEmail(emailName);
			 ne.clickSubmitButton();
			 Thread.sleep(10000);
			Log.addMessage("Sent share invite");
		}catch(Exception e) {
			Log.addMessage("Failed to click share invite");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click share invite");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="memberInvitePopup")
	public void shareInvitePopupTest(String expTitle, String expMessage) {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			mh.verifyLeaveSharePopUpVerbiage(expTitle,expMessage);
			mh.clickOkButton();
			Log.addMessage("Share invite sent pop up verbiage is matching");
		}catch(Exception e) {
			Log.addMessage("Share invite pop up verbiage is not matching");
			e.printStackTrace();
			Assert.assertTrue(false, "Share invite pop up verbiage is not matching");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="adminhomename")
	public void verifyAddNewHomeTest(String hmName, String titleMessage, String valMessage) {
		try {
			NewUserPage nu = new NewUserPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			EnterHomeNamePage cp = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
			nu.clickBackButton();
			mh.clickAddHomeButton();
			cp.valHomeName(hmName, valMessage, titleMessage,"","edit");
			cp.clickBackButton();
			Log.addMessage("Cannot add home with same name as that of shared home in admin");
		}catch(Exception e) {
			Log.addMessage("Home with same name as shared home added in admin");
			e.printStackTrace();
			Assert.assertTrue(false, "Home with same name as shared home added in admin");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="addHomeAdminEmail")
	public void verifyAddNewHomeAdminEmailTest(String usrEmail, String titleMessage, String valMessage) {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			HomeUsersPage hu = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			NewUserPage nu = new NewUserPage((AppiumDriver<MobileElement>) driver);
			NewUserEmailPage ne = new NewUserEmailPage((AppiumDriver<MobileElement>) driver);
			
			mh.clickManageHomeUsersButton();
			hu.clickAddUserButton();
			nu.enterNewUser("testadmin");
			nu.clickNextButton();
			ne.valAddHomeUserEmail(usrEmail, titleMessage, valMessage, "");
			Log.addMessage("Share invite sent pop up verbiage is matching");
		}catch(Exception e) {
			Log.addMessage("Share invite pop up verbiage is not matching");
			e.printStackTrace();
			Assert.assertTrue(false, "Share invite pop up verbiage is not matching");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="nonspectrumAdminEmail")
	public void sendShareNonSpectrumCloudUserTest(String usrEmail) {
		try {
			NewUserEmailPage ne = new NewUserEmailPage((AppiumDriver<MobileElement>) driver);
			
			ne.enterNewEmail(usrEmail);
			ne.clickSubmitButton();
			ne.clickOKButton();
			
			Thread.sleep(2000);
			
			Log.addMessage("Send invite to a non spectrum cloud user");
		}catch(Exception e) {
			Log.addMessage("Failed to send invite and click logout");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to send invite and click logout");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void changeHomeShareAdminToMemberTest() {
		try {
			HomeUsersPage hu = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			HomeUserList nu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			HomeUserAccessType ha= new HomeUserAccessType((AppiumDriver<MobileElement>) driver);
			
			//hu.clickAddUserButton();
			hu.clickAdminUserButton();
			nu.clickBackButton();
			hu.clickAdminUserButton();
			nu.clickAccessType();
			ha.selectMember();
			Utility.simpleWait(20000);
			
			Log.addMessage("Home User  access type is updated to Member");
		}catch(Exception e) {
			Log.addMessage("Failed to update access type to member");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update access type to member");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyHomeAccessTypeAdminToMemberTest() {
		try {
			HomeUserList nu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			nu.verifyAccessType("Member");
			Log.addMessage("Home User  access type verified as Member");
		}catch(Exception e) {
			Log.addMessage("Failed to verify access type as member");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify access type as member");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="editHomeName")
	public void modifyHomeNameAdminToMemberTest(String homeName) {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			EnterHomeNamePage eh = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
			mh.clickEditHomeNameButton();
			eh.enterHomeName(homeName);
			eh.clickSubmitButton();
			Utility.simpleWait(10000);
			eh.clickOKButton();
			Log.addMessage("Home name updated as Member");
		}catch(Exception e) {
			Log.addMessage("Failed to update home name as member");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update home name as member");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyOwnerMemberToAdminAccessTest() {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			mh.verifyAdminHomeManagementButton();
			//mh.clickBackButton();
		}catch(Exception e) {
			Log.addMessage("Failed to verify all elements in manage homes page");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify all elements in manage homes page");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void logoutFromHomeOwnerElevateTest() {
		try {
			NewUserPage nu = new NewUserPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			
			mh.clickBackButton();
			Utility.simpleWait(3000);
			ld.clickHamburgerButton();
			Thread.sleep(2000);
			String lsttext ="Log Out";
			if(device.equals("android")) {
				 System.out.println("in scroll3");
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")).click();
			}else {
				 mp.clickLogoutButton();
			}
			mp.clickOKButton();
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="ownerlogin")
	public void loginHomeOwnerVerifyEditElevateTest(String email, String password) {
		try {
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(5000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 Thread.sleep(15000);
			 System.out.println("wait to retrieve verification code from email");
			 //get verification code from mail and submit
			 cvp.enterMobileCode("123456");
			 Thread.sleep(5000);//to edit while testing
			 cvp.clickSubmitButton(); 
			 Thread.sleep(15000);
				
			 //ld.clickHamburgerButton();
			// mf.clickManageButton();
			Log.addMessage("Clicked log in");
		}catch(Exception e) {
			Log.addMessage("Failed to click log in");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log in");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyHomeAdminElevateUITest() {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			mh.verifyMemberHomeManagementButton();
			//mh.clickBackButton();
		}catch(Exception e) {
			Log.addMessage("Failed to verify all elements in manage homes page");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify all elements in manage homes page");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyHomeAdminElevateLockPairTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			System.out.println("LockStatus of the paired lock is :"+ld.getLockStatus());
			ld.verifyLockDashboardPage();
		}catch(Exception e) {
			Log.addMessage("Failed to verify all elements in manage homes page");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify all elements in manage homes page");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="modifyLockSetting")
	public void verifyAdminLockSettingsNameTest(String lockName) {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			LockNamePage ln = new LockNamePage((AppiumDriver<MobileElement>) driver);
			ld.clickLockSettingsButton();
			ls.clickEditLockNameButton();
			ln.enterLockName(lockName);
			ln.clickSubmitButton();
			Utility.simpleWait(10000);
			ln.clickOkButton();
		}catch(Exception e) {
			Log.addMessage("Settings button present in lock dashboard of member");
			e.printStackTrace();
			Assert.assertTrue(false, "Settings button present in lock dashboard of member");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="modifyAutoLockSetting")
	public void verifyAdminLockSettingsAutoLockTest(String lockStatus) {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			LockNamePage ln = new LockNamePage((AppiumDriver<MobileElement>) driver);
			
			ls.clickAutoLockButton();
			//check the code
			Utility.simpleWait(10000);
			ln.clickOkButton();
		}catch(Exception e) {
			Log.addMessage("Settings button present in lock dashboard of member");
			e.printStackTrace();
			Assert.assertTrue(false, "Settings button present in lock dashboard of member");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="modifyLockSettingSound")
	public void verifyAdminLockSettingsSoundTest(String lockStatus) {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			LockNamePage ln = new LockNamePage((AppiumDriver<MobileElement>) driver);
			
			ls.clickLockSoundsButton();
			Utility.simpleWait(10000);
			ln.clickOkButton();
		}catch(Exception e) {
			Log.addMessage("Settings button present in lock dashboard of member");
			e.printStackTrace();
			Assert.assertTrue(false, "Settings button present in lock dashboard of member");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="modifyAutoLockSetting")
	public void verifyAdminLockSettingsLedTest(String lockStatus) {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			LockNamePage ln = new LockNamePage((AppiumDriver<MobileElement>) driver);
			
			ls.clickLEDStatusButton();
			Utility.simpleWait(10000);
			ln.clickOkButton();
		}catch(Exception e) {
			Log.addMessage("Settings button present in lock dashboard of member");
			e.printStackTrace();
			Assert.assertTrue(false, "Settings button present in lock dashboard of member");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyAdminPairedSmartPhoneTest() {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			PairedSmartPhoneListPage ln = new PairedSmartPhoneListPage((AppiumDriver<MobileElement>) driver);
			
			ls.clickPairedSmartPhonesButton();
			Utility.simpleWait(10000);
			ln.verifyPairedPhoneList();
			ln.clickBackButton();
			Utility.simpleWait(15000);
			Log.addMessage("Paired smart phones listed after elevating member to admin");
		}catch(Exception e) {
			Log.addMessage("Paired smart phones not listed after elevating member to admin");
			e.printStackTrace();
			Assert.assertTrue(false, "Paired smart phones not listed after elevating member to admin");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyAdminLockHistoryTest() {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			LockEventHistoryPage le = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
			ls.clickBackButton();
			ld.clickLockHistoryButton();
			Utility.simpleWait(5000);
			le.clickBackButton();
			Log.addMessage("Lock history can be accessed from lock dashboard of member elevated to admin");
		}catch(Exception e) {
			Log.addMessage("Lock history cannot be accessed from lock dashboard of member elevated to admin");
			e.printStackTrace();
			Assert.assertTrue(false, "Lock history cannot be accessed from lock dashboard of member elevated to admin");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyAdminLockAddAccessCodeTest() {
		try {
			ViewAccessCodesPage ap = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			AddAccessCodePage ac = new AddAccessCodePage((AppiumDriver<MobileElement>) driver);
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			ld.clickAccessCodeButton();
			Utility.simpleWait(5000);
			ap.clickAddAccessCodeButton();
			String name = "tcode";
			ac.enterAccessCodeName(name);
			ac.clickGenerateRandomCodeButton();
			ac.clickSubmitButton();
			Utility.simpleWait(10000);
			 Log.addMessage("Access Code is created after elevating member to admin");
		}catch(Exception e) {
			Log.addMessage("Failed to add access code after elevating member to admin");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to add access code after elevating member to admin");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="accessName")
	public void verifyAdminLockEditAccessCodeNameTest(String accessName) {
		try {
			ViewAccessCodesPage ap = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			AccessCodePage ac = new AccessCodePage((AppiumDriver<MobileElement>) driver);
			EditCodeNamePage ec = new EditCodeNamePage((AppiumDriver<MobileElement>) driver);
			ap.selFirstFPUser();
			ac.clickEditAccessCode();
			ec.enterAccessCodeName(accessName);
			ec.clickSubmitButton();
			Utility.simpleWait(10000);
			 Log.addMessage("Access Code is created");
		}catch(Exception e) {
			Log.addMessage("Settings button present in lock dashboard of member");
			e.printStackTrace();
			Assert.assertTrue(false, "Settings button present in lock dashboard of member");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyAdminLockEditAccessCodeTest() {
		try {
			ViewAccessCodesPage ap = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			AccessCodePage ac = new AccessCodePage((AppiumDriver<MobileElement>) driver);
			EditAccessCodePage ea = new EditAccessCodePage((AppiumDriver<MobileElement>) driver);
			
			 ap.selSecondFPUser();
			 ac.clickEditAccessCode();
			 ea.enterAccessCodePin("111111");
			 ea.clickSubmitButton();
			 Utility.simpleWait(10000);
			 Log.addMessage("Access code name is updated");
		}catch(Exception e) {
			Log.addMessage("Failed to update access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update access code");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyAdminLockDeleteAccessCodeTest() {
		try {
			ViewAccessCodesPage ap = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			AccessCodePage ea = new AccessCodePage((AppiumDriver<MobileElement>) driver);
			ap.selSecondFPUser();
			ea.deleteAccessCode();
			Utility.simpleWait(10000);
			Log.addMessage("Access code name is deleted");
		}catch(Exception e) {
			Log.addMessage("Failed to delete access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to delete access code");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyAdminLockSetScheduleTypeTest() {
		try {
			ViewAccessCodesPage ap = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			AccessCodePage ac = new AccessCodePage((AppiumDriver<MobileElement>) driver);
			SelectScheduleTypePage sp = new SelectScheduleTypePage((AppiumDriver<MobileElement>) driver);
			ap.selFirstFPUser();
			ac.editScheduleType();
			sp.selectAnyTime();
			Utility.simpleWait(10000);
			Log.addMessage("Anytime schedule type is set for the access code");	
		}catch(Exception e) {
			Log.addMessage("Failed to set Anytime schedule type");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to set Anytime schedule type");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyAdminLockShareAccessCodeTest() {
		try {
			ViewAccessCodesPage ap = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			AccessCodePage ac = new AccessCodePage((AppiumDriver<MobileElement>) driver);
			
			ap.selSecondFPUser();
			ac.clickShareAccessCode();//check below code to go back to app
			ap.clickHomeName();
			ap.clickBackButton();
			ap.clickBackButton();
			Log.addMessage("Access code is shared.");
		}catch(Exception e) {
			Log.addMessage("Failed to share access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to share access code");
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyAdminLockDisableAccessCodeTest() {
		try {
			ViewAccessCodesPage ap = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			AccessCodePage ac = new AccessCodePage((AppiumDriver<MobileElement>) driver);
			ap.selFirstFPUser();
			ac.disableAccessCode();
			Utility.simpleWait(12000);
			Log.addMessage("Access code is disabled");
		}catch(Exception e) {
			Log.addMessage("Failed to disable access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to disable access code");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyAdminLockReEnableAccessCodeTest() {
		try {
			ViewAccessCodesPage ap = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			AccessCodePage ac = new AccessCodePage((AppiumDriver<MobileElement>) driver);
			ap.selFirstFPUser();
			ac.disableAccessCode();
			Utility.simpleWait(10000);
			ac.clickBackButton();
			Log.addMessage("Access code is enabled");
		}catch(Exception e) {
			Log.addMessage("Failed to re-enable access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to re-enable access code");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="editHomeName")
	public void editHomeNameMemberToAdminTest(String homeName) {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			EnterHomeNamePage eh = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
			mh.clickEditHomeNameButton();
			eh.enterHomeName(homeName);
			eh.clickSubmitButton();
			Utility.simpleWait(10000);
			eh.clickOKButton();
			Log.addMessage("Home name updated as Member");
		}catch(Exception e) {
			Log.addMessage("Failed to update home name as member");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update home name as member");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="sendAnAdminShare")
	public void verifyElevateManageHomeShareAsAdminTest(String userName, String email) {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			HomeUsersPage hu = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			NewUserPage nu = new NewUserPage((AppiumDriver<MobileElement>) driver);
			NewUserEmailPage ne = new NewUserEmailPage((AppiumDriver<MobileElement>) driver);
			mh.verifyHomeManagementButton();
			mh.clickManageHomeUsersButton();
			hu.clickAddUserButton();
			nu.enterNewUser(userName);
			nu.clickNextButton();
			ne.enterNewEmail(email);
			ne.clickSubmitButton();
			Utility.simpleWait(4000);
			ne.clickOKButton();
			Log.addMessage("Manage users functionality verified as admin");
		}catch(Exception e) {
			Log.addMessage("Failed to verify manage users functionality as admin");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify manage users functionality as admin");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="sendAMemberShare")
	public void valWifiOffElevateManageHomeShareAsMemberTest(String userName, String email) {
		try {
			ManageHomesPage ch = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			EnterHomeNamePage eh = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
			HomeUsersPage hu = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			NewUserPage nu = new NewUserPage((AppiumDriver<MobileElement>) driver);
			NewUserEmailPage ne = new NewUserEmailPage((AppiumDriver<MobileElement>) driver);
			System.out.println("Wait for Wifi Off");
			Utility.simpleWait(27000);
			ch.clickCancel();
			hu.clickAddUserButton();
			nu.enterNewUser(userName);
			nu.clickMemberButton();
			nu.clickNextButton();
			ne.enterNewEmail(email);
			ne.clickSubmitButton();
			Utility.simpleWait(4000);
			ne.clickCancelButton();
			//ne.clickBackButton();
			Log.addMessage("Manage users functionality with wifi off verified");
		}catch(Exception e) {
			Log.addMessage("Failed to manage users functionality to send share invite as member");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to manage users functionality to send share invite as member");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="sendAMemberShare")
	public void valBLEOffManageHomeUIMemberToAdminTest(String userName, String email) {
		try {
			ManageHomesPage ch = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			NewUserEmailPage ne = new NewUserEmailPage((AppiumDriver<MobileElement>) driver);
			System.out.println("Wait for Wifi ON and BLE OFF");
			Utility.simpleWait(27000);
			ch.clickLeaveShare();
			ne.clickSubmitButton();
			Log.addMessage("Manage users functionality with wifi off verified by sending share invite as membe");
			Utility.simpleWait(4000);
		}catch(Exception e) {
			Log.addMessage("Failed manage users functionality to send share invite as member");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed  manage users functionality to send share invite as member");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="existElevAddHomeName")
	public void verifyElevateAddExistHomeNameTest(String homeNm, String titleMessage, String valMessage) {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			EnterHomeNamePage eh = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
			mh.clickAddHomeButton();
			eh.valHomeName(homeNm,valMessage,titleMessage,"","edit");
			Utility.simpleWait(20000);
			Log.addMessage("New home cannot be added with existing home name.");
		}catch(Exception e) {
			Log.addMessage("Failed to update access type to member");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update access type to member");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="lsharepopup")
	public void leaveShareMemberToAdminTest(String titleMsg, String valMsg, String valMsg2) {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			mh.clickLeaveShare();
			mh.verifyLeaveSharePopUpVerbiage(titleMsg,valMsg);
			mh.clickCancel();
			Utility.simpleWait(5000);
			mh.clickLeaveShare();
			mh.clickOkButton();
			Utility.simpleWait(10000);
			mh.verifyLeaveSharePopUpVerbiage("",valMsg2);//test this case
			mh.clickOkButton();
		}catch(Exception e) {
			Log.addMessage("Settings button present in lock dashboard of member");
			e.printStackTrace();
			Assert.assertTrue(false, "Settings button present in lock dashboard of member");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="existElevHomeName")
	public void verifyElevateAddSameHomeNameTest(String homeNm) {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			EnterHomeNamePage eh = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
			mh.clickAddHomeButton();
			eh.enterHomeName(homeNm);
			eh.clickSubmitButton();
			Utility.simpleWait(5000);
			eh.clickOKButton();
			eh.clickBackButton();
			Log.addMessage("New home cannot be added with existing home name.");
		}catch(Exception e) {
			Log.addMessage("Failed to update access type to member");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update access type to member");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void logOutFromHomeAdminAccessChangeTest() {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			
			mh.clickBackButton();
			Utility.simpleWait(3000);
			ld.clickHamburgerButton();
			Thread.sleep(2000);
			String lsttext ="Log Out";
			if(device.equals("android")) {
				 System.out.println("in scroll3");
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")).click();
			}else {
				 mp.clickLogoutButton();
			}
			mp.clickOKButton();
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="ownerlogin")
	public void loginVerifyHomeEditOwnerElevateTest(String email, String password) {
		try {
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(5000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 Thread.sleep(15000);
			 System.out.println("wait to retrieve verification code from email");
			 //get verification code from mail and submit
			 cvp.enterMobileCode("123456");
			 Thread.sleep(5000);//to edit while testing
			 cvp.clickSubmitButton(); 
			 Thread.sleep(15000);
				
			 //ld.clickHamburgerButton();
			// mf.clickManageButton();
			Log.addMessage("Clicked log in");
		}catch(Exception e) {
			Log.addMessage("Failed to click log in");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log in");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="accessName")
	public void verifyElevAdminEditAccessCodeNameTest(String accessName) {
		try {
			ViewAccessCodesPage ap = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			ap.verifyUserAccessCodeName(accessName);
			Utility.simpleWait(10000);
			Log.addMessage("Access code name updated by elevated member in owner account");
		}catch(Exception e) {
			Log.addMessage("Access code name not updated by elevated member in owner account");
			e.printStackTrace();
			Assert.assertTrue(false, "Access code name not updated by elevated member in owner account");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="sendAnAdminShare")
	public void valManageHomeShareAsMemberTest(String userName, String email) {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			HomeUsersPage hu = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			NewUserPage nu = new NewUserPage((AppiumDriver<MobileElement>) driver);
			NewUserEmailPage ne = new NewUserEmailPage((AppiumDriver<MobileElement>) driver);
			mh.verifyHomeManagementButton();
			mh.clickManageHomeUsersButton();
			hu.clickAddUserButton();
			nu.enterNewUser(userName);
			nu.clickMemberButton();
			nu.clickNextButton();
			ne.enterNewEmail(email);
			ne.clickSubmitButton();
			Utility.simpleWait(4000);
			ne.clickOKButton();
			Log.addMessage("Manage users functionality verified as admin");
		}catch(Exception e) {
			Log.addMessage("Failed to verify manage users functionality as admin");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify manage users functionality as admin");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="modifiedHome")
	public void verifyModElevHomeNameReflectOwnerTest(String modhmName) {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			mh.verifyModifiedHomeNameAsMember(modhmName);
			Log.addMessage("Home name updated by elevated member is reflected in owner");
		}catch(Exception e) {
			Log.addMessage("Failed to verify home name change by elevated member in owner");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify home name change by elevated member in owner");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyMemberLockDashboardSettingsAccessTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			ld.verifyLockDashboardSettingsAccess();
		}catch(Exception e) {
			Log.addMessage("Settings button present in lock dashboard of member");
			e.printStackTrace();
			Assert.assertTrue(false, "Settings button present in lock dashboard of member");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyMemberLockDashboardHistoryAccessTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			ld.verifyLockDashboardHistoryAccess();
		}catch(Exception e) {
			Log.addMessage("History button present in lock dashboard of member");
			e.printStackTrace();
			Assert.assertTrue(false, "History button present in lock dashboard of member");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyMemberLockDashboardPeopleAccessTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			ld.verifyLockDashboardPeopleAccess();
		}catch(Exception e) {
			Log.addMessage("People button present in lock dashboard of member");
			e.printStackTrace();
			Assert.assertTrue(false, "People button present in lock dashboard of member");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void logOutFromHomeOwnerAfterMemVerifyTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 ld.clickHamburgerButton();
			 Thread.sleep(2000);
			 String lsttext ="Log Out";
			 if(device.equals("android")) {
				 System.out.println("in scroll3");
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")).click();
					//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text('Log Out'));")).click();
			 }else {
				 mp.clickLogoutButton();//added on 29-07-2020 regression
			 }
			 mp.clickOKButton();
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="adminlogin")
	public void loginHomeAdminToVerifyMemLeaveShareTest(String email, String password) {
		try {
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(5000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 Thread.sleep(15000);
			 System.out.println("wait to retrieve verification code from email");
			 //get verification code from mail and submit
			 cvp.enterMobileCode("123456");
			 Thread.sleep(5000);//to edit while testing
			 cvp.clickSubmitButton(); 
			 Thread.sleep(15000);
				
			 ld.clickHamburgerButton();
			 mf.clickManageButton();
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyLeaveShareAsMemberInAdminTest() {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			mh.verifyAdminHomeManagementButton();
		}catch(Exception e) {
			Log.addMessage("Failed to verify all elements in manage homes page");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify all elements in manage homes page");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void logoutFromHomeOwnerDemoteTest() {
		try {
			NewUserPage nu = new NewUserPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			
			mh.clickBackButton();
			Utility.simpleWait(3000);
			ld.clickHamburgerButton();
			Thread.sleep(2000);
			String lsttext ="Log Out";
			if(device.equals("android")) {
				 System.out.println("in scroll3");
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")).click();
			}else {
				 mp.clickLogoutButton();
			}
			mp.clickOKButton();
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="adminlogin")
	public void loginHomeAdminDemoteTest(String email, String password) {
		try {
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(5000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 Thread.sleep(15000);
			 System.out.println("wait to retrieve verification code from email");
			 //get verification code from mail and submit
			 cvp.enterMobileCode("123456");
			 Thread.sleep(5000);//to edit while testing
			 cvp.clickSubmitButton(); 
			 Thread.sleep(15000);
				
			 //ld.clickHamburgerButton();
			// mf.clickManageButton();
			Log.addMessage("Clicked log in");
		}catch(Exception e) {
			Log.addMessage("Failed to click log in");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log in");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyHomeAdminDemoteUITest() {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			mh.verifyMemberHomeManagementButton();
			//mh.clickBackButton();
		}catch(Exception e) {
			Log.addMessage("Failed to verify all elements in manage homes page");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify all elements in manage homes page");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="editHomeName")
	public void verifyHomeNameAdminToMemberTest(String homeName) {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			mh.verifyModifiedHomeNameAsAdmin(homeName);
			Log.addMessage("Home name updated by owner is updated in member view");
		}catch(Exception e) {
			Log.addMessage("Failed to update home name in member view");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update home name in member view");
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyHomeAdminDemoteManageUsersTest() {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			mh.verifyMemberHomeUserButtonPresent();
			//mh.clickBackButton();
		}catch(Exception e) {
			Log.addMessage("Manage home users button is not displayed in the Manage Homes page for member");
			e.printStackTrace();
			Assert.assertTrue(false, "Manage home users button is not displayed in the Manage Homes page for member");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="sameHomeName")
	public void verifyAddHomeSameNameAdminToMemberTest(String homeName) {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			EnterHomeNamePage ee = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
			mh.addHomeUserButton();
			ee.enterHomeName(homeName);
			ee.clickSubmitButton();
		}catch(Exception e) {
			Log.addMessage("Manage home users button is not displayed in the Manage Homes page for member");
			e.printStackTrace();
			Assert.assertTrue(false, "Manage home users button is not displayed in the Manage Homes page for member");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyHomeAdminDemoteLockPairTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			System.out.println("LockStatus of the paired lock is :"+ld.getLockStatus());
			if(device.equals("android")) {
				ld.clickLockUnlockButton();
			}else {
				ld.clickLockUnlockButtoniOS();
			}
			
		}catch(Exception e) {
			Log.addMessage("Failed to verify all elements in manage homes page");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify all elements in manage homes page");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void logOutFromHomeAdminDemoteTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			//mh.clickBackButton();
			ld.clickHamburgerButton();
			 Thread.sleep(2000);
			 String lsttext ="Log Out";
			 if(device.equals("android")) {
				 System.out.println("in scroll2");
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")).click();
					//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text('Log Out'));")).click();
			 }else {
				 mp.clickLogoutButton();
			 }
			
			 mp.clickOKButton();
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="ownerlogin")
	public void loginHomeOwnerElevateTest(String email, String password) {
		try {
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 HomeUserList hu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(5000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 Thread.sleep(15000);
			 System.out.println("wait to retrieve verification code from email");
			 //get verification code from mail and submit
			 cvp.enterMobileCode("123456");
			 Thread.sleep(5000);//to edit while testing
			 cvp.clickSubmitButton(); 
			 Thread.sleep(15000);
				
			 ld.clickHamburgerButton();
			 mf.clickManageButton();
			 mh.clickManageHomeUsersButton();
			Log.addMessage("Logged in");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void changeHomeShareMemberToAdminTest() {
		try {
			HomeUsersPage hu = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			HomeUserList nu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			HomeUserAccessType ha= new HomeUserAccessType((AppiumDriver<MobileElement>) driver);
			
			//hu.clickAddUserButton();
			hu.clickAdminUserButton();
			nu.clickAccessType();
			ha.selectMember();
			Utility.simpleWait(20000);
			hu.clickMemberUserButton();
			nu.clickAccessType();
			ha.selectAdmin();
			
			Log.addMessage("Home User  access type is updated to Member");
		}catch(Exception e) {
			Log.addMessage("Failed to update access type to member");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update access type to member");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyHomeAccessTypeMemberToAdminTest() {
		try {
			HomeUserList nu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			nu.verifySecondAccessType("Admin");
			Log.addMessage("Home User  access type verified as Admin");
		}catch(Exception e) {
			Log.addMessage("Failed to verify access type as Admin");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify access type as Admin");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="existHomeName")
	public void verifyAddHomeWithExistingNameTest(String homeNm, String titleMessage, String valMessage) {
		try {
			HomeUsersPage hu = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			HomeUserList nu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			EnterHomeNamePage eh = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
			
			nu.clickBackButton();
			hu.clickBackButton();
			mh.clickAddHomeButton();
			eh.valHomeName(homeNm,valMessage,titleMessage,"","edit");
			Utility.simpleWait(20000);
			Log.addMessage("New home cannot be added with existing home name.");
		}catch(Exception e) {
			Log.addMessage("Failed to update access type to member");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update access type to member");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void logoutHomeMemberTest() {
		try {
			NewUserPage nu = new NewUserPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			nu.clickBackButton();
			Utility.simpleWait(3000);
			mh.clickBackButton();
			Utility.simpleWait(3000);
			ld.clickHamburgerButton();
			Thread.sleep(2000);
			String lsttext ="Log Out";
			if(device.equals("android")) {
				 System.out.println("in scroll3");
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")).click();
			}else {
				 mp.clickLogoutButton();
			}
			mp.clickOKButton();
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="ownerlogin")
	public void loginHomeOwnerHomeNameTest(String email, String password) {
		try {
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 HomeUserList hu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(5000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 Thread.sleep(15000);
			 System.out.println("wait to retrieve verification code from email");
			 //get verification code from mail and submit
			 cvp.enterMobileCode("123456");
			 Thread.sleep(5000);//to edit while testing
			 cvp.clickSubmitButton(); 
			 Thread.sleep(15000);
				
			 ld.clickHamburgerButton();
			 mf.clickManageButton();
			Log.addMessage("Logged in");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="modifiedHome")
	public void verifyModAdminHomeNameAsOwnerTest(String modhmName) {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			mh.verifyModifiedHomeNameAsMember(modhmName);
			//mh.clickBackButton();
		}catch(Exception e) {
			Log.addMessage("Failed to update the modified home name in owners page");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update the modified home name in owners page");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void logoutFromHomeOwnerTest() {
		try {
			NewUserPage nu = new NewUserPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			
			mh.clickBackButton();
			Utility.simpleWait(3000);
			ld.clickHamburgerButton();
			Thread.sleep(2000);
			String lsttext ="Log Out";
			if(device.equals("android")) {
				 System.out.println("in scroll3");
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")).click();
			}else {
				 mp.clickLogoutButton();
			}
			mp.clickOKButton();
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="othermemlogin")
	public void loginHomeMemberShareAcceptTest(String email, String password) {
		try {
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(5000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 Thread.sleep(15000);
			 System.out.println("wait to retrieve verification code from email");
			 //get verification code from mail and submit
			 cvp.enterMobileCode("123456");
			 Thread.sleep(5000);//to edit while testing
			 cvp.clickSubmitButton(); 
			 Thread.sleep(15000);
				
			 //ld.clickHamburgerButton();
			// mf.clickManageButton();
			Log.addMessage("Clicked log in");
		}catch(Exception e) {
			Log.addMessage("Failed to click log in");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log in");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="inviteAdmin")
	public void memShareDeclinePopupTest(String titleMsg, String valMsg) {
		try {
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 mh.verifyLeaveSharePopUpVerbiage(titleMsg,valMsg);
			 //Thread.sleep(27000);//for testing in between
			 Thread.sleep(15000);
			 mh.clickCancelButton();
			Log.addMessage("Clicked share decline");
		}catch(Exception e) {
			Log.addMessage("Failed to click share accept");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click share accept");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void logoutHomeMemberDeclineTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			//mh.clickBackButton();
			ld.clickHamburgerButton();
			 Thread.sleep(2000);
			 String lsttext ="Log Out";
			 if(device.equals("android")) {
				 System.out.println("in scroll2");
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")).click();
					//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text('Log Out'));")).click();
			 }else {
				 mp.clickLogoutButton();
			 }
			
			 mp.clickOKButton();
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="ownerlogin")
	public void loginHomeOwnerHomeShareAgainTest(String email, String password) {
		try {
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(5000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 Thread.sleep(15000);
			 System.out.println("wait to retrieve verification code from email");
			 //get verification code from mail and submit
			 cvp.enterMobileCode("123456");
			 Thread.sleep(5000);//to edit while testing
			 cvp.clickSubmitButton(); 
			 Thread.sleep(15000);
			ld.clickOKButton();//to accept share invite
			 ld.clickHamburgerButton();
			 mf.clickManageButton();
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="sendShareMem")
	public void sendHomeShareToNSpecUserTest(String userName, String email) {
		 try {
			 NewUserPage nu = new NewUserPage((AppiumDriver<MobileElement>) driver);
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 HomeUsersPage al = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			 NewUserEmailPage ne = new NewUserEmailPage((AppiumDriver<MobileElement>) driver);
			 mh.clickManageHomeUsersButton();
			 al.clickAddUserButton();
			 nu.enterNewUser(userName);
			 nu.clickMemberButton();
			 nu.clickNextButton();
			 ne.enterNewEmail(email);
			 ne.clickSubmitButton();
			 Utility.simpleWait(4000);
			 ne.clickOKButton();
		 }catch(Exception e) {
			 Log.addMessage("Failed to display Phone Number");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to enter Phone Number");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void logoutHomeOwnerDeclineTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			//mh.clickBackButton();
			ld.clickHamburgerButton();
			 Thread.sleep(2000);
			 String lsttext ="Log Out";
			 if(device.equals("android")) {
				 System.out.println("in scroll2");
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")).click();
					//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text('Log Out'));")).click();
			 }else {
				 mp.clickLogoutButton();
			 }
			
			 mp.clickOKButton();
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="othermemlogin")
	public void loginHomeMemberShareAcceptAgainTest(String email, String password) {
		try {
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(5000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 Thread.sleep(15000);
			 System.out.println("wait to retrieve verification code from email");
			 //get verification code from mail and submit
			 cvp.enterMobileCode("123456");
			 Thread.sleep(5000);//to edit while testing
			 cvp.clickSubmitButton(); 
			 Thread.sleep(15000);
				
			 //ld.clickHamburgerButton();
			// mf.clickManageButton();
			Log.addMessage("Clicked log in");
		}catch(Exception e) {
			Log.addMessage("Failed to click log in");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log in");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="inviteAdmin")
	public void memShareAcceptPopupTest(String titleMsg, String valMsg) {
		try {
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			// mh.clickLeaveShare();
			 mh.verifyLeaveSharePopUpVerbiage(titleMsg,valMsg);
			 //Thread.sleep(27000);//for testing in between
			 Thread.sleep(15000);
			 // mh.clickCancel();
			 Utility.simpleWait(5000);
			 // mh.clickLeaveShare();
			 mh.clickOkButton();
			 Thread.sleep(8000);
			 //ld.clickHamburgerButton();
			 //mf.clickManageButton();
			Log.addMessage("Clicked share accept");
		}catch(Exception e) {
			Log.addMessage("Failed to click share accept");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click share accept");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="adminLockPair")
	public void memberLockPairPopupTest(String titleMsg, String valMsg) {
		try {
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 LockDashboardPage lp = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 Thread.sleep(10000);
			// mh.clickLeaveShare();
			 mh.verifyLeaveSharePopUpVerbiage(titleMsg,valMsg);
			 Thread.sleep(15000);
			 Utility.simpleWait(5000);
			 mh.clickCancelButton();//check how to create the pair pop up on tapping lock status
			 //mh.clickOkButton();
			 System.out.println("Lock Status after cancelling invitation is :"+lp.getLockStatus());
			 //lp.lockOperation();
			 Thread.sleep(8000);
			 //ld.clickHamburgerButton();
			 //mf.clickManageButton();
			 Log.addMessage("Clicked cancel lock pair");
		}catch(Exception e) {
			Log.addMessage("Failed to click cancel lock pair");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to cancel lock pair");
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void memberAddLockPairTest() {
		try {
			System.out.println("adminAddLockPairTest");
			LockNextPage1 ln1 =new LockNextPage1((AppiumDriver<MobileElement>) driver); 
			ln1.clickNext();
			LockNextPage2 ln2 =new LockNextPage2((AppiumDriver<MobileElement>) driver); 
			ln2.clickNext();
			Log.addMessage("Clicked next button");
		}catch(Exception e) {
			Log.addMessage("Failed to click next Button");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click next Button");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void selectNoLockMemberTest() {
		try {
			SearchLocksPage sl = new SearchLocksPage((AppiumDriver<MobileElement>) driver);
			HelpFAQPage hf = new HelpFAQPage((AppiumDriver<MobileElement>) driver);
			sl.clickFaqLink();
			 Utility.simpleWait(10000);
			hf.clickBackButton();
			//sl.selectLockoneCell();
			Utility.simpleWait(30000);
		}catch(Exception e) {
			Log.addMessage("Failed to select lock");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to select Lock");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyNoLockUIMemberTest() {
		try {
			NoLocksPage nl = new NoLocksPage((AppiumDriver<MobileElement>) driver);
			nl.verifyNoLocksUIPage();
		}catch(Exception e) {
			Log.addMessage("Failed to select lock");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to select Lock");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyNoLockMemberTest() {
		try {
			SearchLocksPage sl = new SearchLocksPage((AppiumDriver<MobileElement>) driver);
			NoLocksPage nl = new NoLocksPage((AppiumDriver<MobileElement>) driver);
			LockInstallationGuidePage li = new LockInstallationGuidePage((AppiumDriver<MobileElement>) driver);
			HelpFAQPage hf = new HelpFAQPage((AppiumDriver<MobileElement>) driver);
			nl.clickInstallationGuide();
			li.clickBackButton();
			nl.clickFaqLink();
		    Utility.simpleWait(10000);
		    hf.clickBackButton();
		   // System.out.println("Wait for clicking A button to identify the lock in the search page");
		    nl.clickScanAgain();//check how this option works
		    Utility.simpleWait(35000);
		    nl.clickBackButton();
		    sl.clickBackButton();
		}catch(Exception e) {
			Log.addMessage("Failed to select lock");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to select Lock");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void selectOneLockMemberTest() {
		try {
			LockNextPage2 ln2 =new LockNextPage2((AppiumDriver<MobileElement>) driver); 
			SearchLocksPage sl = new SearchLocksPage((AppiumDriver<MobileElement>) driver);
			System.out.println("Wait for clicking A button to identify the lock in the search page");
			Utility.simpleWait(5000);
			ln2.clickNext();
			sl.selectLockoneCell();
			
		}catch(Exception e) {
			Log.addMessage("Failed to select lock");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to select Lock");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="addLockPopup")
	public void lockAddSuccessMemPopUpVerbiageTest(String expTitle, String expMessage) {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			
			mh.verifyLeaveSharePopUpVerbiage(expTitle,expMessage);
			Log.addMessage("Lock pairing success pop up verbiage is matching");
		}catch(Exception e) {
			Log.addMessage("FLock pairing success pop up verbiage is not matching");
			e.printStackTrace();
			Assert.assertTrue(false, "Lock pairing success pop up verbiage is not matching");
			
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyLockDashboardMemUITest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			ld.verifyLockDashboardPage();
			ld.getBatteryPercentageDashboard();
			Log.addMessage("Lock Image present in Manage Home");
		}catch(Exception e) {
			Log.addMessage("Lock Image not present in Manage Home");
			e.printStackTrace();
			Assert.assertTrue(false, "Lock Image not present Manage Home");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void changeMHomeShareMemberToAdminTest() {
		try {
			HomeUsersPage hu = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			HomeUserList nu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			HomeUserAccessType ha= new HomeUserAccessType((AppiumDriver<MobileElement>) driver);
			
			//hu.clickAddUserButton();
			hu.clickAdminUserButton();
			nu.clickAccessType();
			ha.selectMember();
			Utility.simpleWait(20000);
			
			Log.addMessage("Home User  access type is updated to Member");
		}catch(Exception e) {
			Log.addMessage("Failed to update access type to member");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update access type to member");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyMHomeAccessTypeMemberToAdminTest() {
		try {
			HomeUserList nu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			nu.verifyAccessType("Admin");
			Log.addMessage("Home User  access type verified as Admin");
		}catch(Exception e) {
			Log.addMessage("Failed to verify access type as Admin");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify access type as Admin");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void changeMHomeShareAdminToMemberTest() {
		try {
			HomeUsersPage hu = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			HomeUserList nu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			HomeUserAccessType ha= new HomeUserAccessType((AppiumDriver<MobileElement>) driver);
			
			//hu.clickAddUserButton();
			hu.clickAdminUserButton();
			nu.clickAccessType();
			ha.selectMember();
			Utility.simpleWait(20000);
			
			Log.addMessage("Home User  access type is updated to Member");
		}catch(Exception e) {
			Log.addMessage("Failed to update access type to member");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update access type to member");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyMHomeAccessTypeAdminToMemberTest() {
		try {
			HomeUserList nu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			nu.verifyAccessType("Member");
			Log.addMessage("Home User  access type verified as Member");
		}catch(Exception e) {
			Log.addMessage("Failed to verify access type as member");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify access type as member");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void logoutHomeMemberAcceptTest() {
		try {
			NewUserPage nu = new NewUserPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			nu.clickBackButton();
			Utility.simpleWait(3000);
			mh.clickBackButton();
			Utility.simpleWait(3000);
			ld.clickHamburgerButton();
			Thread.sleep(2000);
			String lsttext ="Log Out";
			if(device.equals("android")) {
				 System.out.println("in scroll3");
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")).click();
			}else {
				 mp.clickLogoutButton();
			}
			mp.clickOKButton();
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="adminlogin")
	public void loginHomeAdminAccessTypeTest(String email, String password) {
		try {
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(5000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 Thread.sleep(15000);
			 System.out.println("wait to retrieve verification code from email");
			 //get verification code from mail and submit
			 cvp.enterMobileCode("123456");
			 Thread.sleep(5000);//to edit while testing
			 cvp.clickSubmitButton(); 
			 Thread.sleep(15000);
				
			/* ld.clickHamburgerButton();
			 mf.clickManageButton();*/
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="adminHomeName")
	public void verifyDeleteHomeShareInAdminTest(String homeName, String titleMessage, String valMessage) {
		try {
			MenuFlyoutPage nu = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			nu.verifyAdminSharedHomeName(homeName);
		}catch(Exception e) {
			Log.addMessage("Failed to display admin shared home in shared user account");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display admin shared home in shared user account");
		
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void logoutVerifyDeleteHomeAdminTest() {
		try {
			NewUserPage nu = new NewUserPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			nu.clickBackButton();
			Utility.simpleWait(3000);
			mh.clickBackButton();
			Utility.simpleWait(3000);
			ld.clickHamburgerButton();
			Thread.sleep(2000);
			String lsttext ="Log Out";
			if(device.equals("android")) {
				 System.out.println("in scroll3");
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")).click();
			}else {
				 mp.clickLogoutButton();
			}
			mp.clickOKButton();
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="anotheradminlogin")
	public void loginHomeAnotherAdminDeleteTest(String email, String password) {
		try {
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(5000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 Thread.sleep(15000);
			 System.out.println("wait to retrieve verification code from email");
			 //get verification code from mail and submit
			 cvp.enterMobileCode("123456");
			 Thread.sleep(5000);//to edit while testing
			 cvp.clickSubmitButton(); 
			 Thread.sleep(15000);
				
			/* ld.clickHamburgerButton();
			 mf.clickManageButton();*/
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="adminHomeName")
	public void verifyHomeShareInSharedAdminTest(String homeName, String titleMessage, String valMessage) {
		try {
			MenuFlyoutPage nu = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			nu.verifyHomeName(homeName);
		}catch(Exception e) {
			Log.addMessage("Failed to display admin shared home in shared user account");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display admin shared home in shared user account");
		
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="delsharepopup")
	public void deleteHomeShareAdminPopupTest(String titleMsg, String valMsg, String valMsg2) {
		try {
			MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			HomeUsersPage hu = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			HomeUserList nu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			mf.clickManageButton();
			mh.clickManageAdminHomeUsersButton();
			hu.clickAdminUserButton();
			nu.clickDeleteShareButton();
			mh.verifyLeaveSharePopUpVerbiage(titleMsg,valMsg);
			mh.clickCancel();
			Utility.simpleWait(5000);
			nu.clickDeleteShareButton();
			mh.clickOkButton();
			Utility.simpleWait(10000);
			mh.verifyLeaveSharePopUpVerbiage("",valMsg2);//test this case
			mh.clickOkButton();
		}catch(Exception e) {
			Log.addMessage("Failed to leave the shared home");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to leave the shared home");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="anotheradminUserName")
	public void verifyDeleteHomeShareInAnthrAdminTest(String userName) {
		try {
			HomeUserList nu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			nu.clickBackButton();
			nu.verifyLeaveShareByAdminInOwner(userName,"delete");
			Log.addMessage("Home User  access type verified as Member");
		}catch(Exception e) {
			Log.addMessage("Failed to verify access type as member");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify access type as member");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="anotheradminHomeName")
	public void verifyLockAfterDeleteInAdminWifiOffTest(String anotheradminHomeName) {
		try {
			HomeUserList nu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			System.out.println("Wait for Wifi Off");
			Utility.simpleWait(20000);
			mf.clickCancelButton();
			nu.clickBackButton();
			nu.clickBackButton();
			mf.verifyHomeName(anotheradminHomeName);
			Log.addMessage("Home User  access type verified as Member");
		}catch(Exception e) {
			Log.addMessage("Failed to verify access type as member");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify access type as member");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void logoutFromHomeAnthrAdminTest() {
		try {
			NewUserPage nu = new NewUserPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			
			mh.clickBackButton();
			Utility.simpleWait(3000);
			ld.clickHamburgerButton();
			Thread.sleep(2000);
			String lsttext ="Log Out";
			if(device.equals("android")) {
				 System.out.println("in scroll3");
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")).click();
			}else {
				 mp.clickLogoutButton();
			}
			mp.clickOKButton();
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="ownerlogin")
	public void loginHomeOwnerVerifyAnotherAdminLockTest(String email, String password) {
		try {
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 HomeUserList hu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(5000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 Thread.sleep(15000);
			 System.out.println("wait to retrieve verification code from email");
			 //get verification code from mail and submit
			 cvp.enterMobileCode("123456");
			 Thread.sleep(5000);//to edit while testing
			 cvp.clickSubmitButton(); 
			 Thread.sleep(15000);
				
			/* ld.clickHamburgerButton();
			 mf.clickManageButton();*/
			Log.addMessage("Logged in");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyAdminLockSettingsTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			//ld.verifyLockDashboardSettingsAccess();
		}catch(Exception e) {
			Log.addMessage("Settings button present in lock dashboard of member");
			e.printStackTrace();
			Assert.assertTrue(false, "Settings button present in lock dashboard of member");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="sendShare")
	public void sendOwnerHomeShareToAdminTest(String userName, String email) {
		 try {
			 NewUserPage nu = new NewUserPage((AppiumDriver<MobileElement>) driver);
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 HomeUsersPage al = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			 NewUserEmailPage ne = new NewUserEmailPage((AppiumDriver<MobileElement>) driver);
			 mh.clickManageHomeUsersButton();
			 al.clickAddUserButton();
			 nu.enterNewUser(userName);
			 nu.clickNextButton();
			 ne.enterNewEmail(email);
			 ne.clickSubmitButton();
			 Utility.simpleWait(4000);
			 ne.clickOKButton();
		 }catch(Exception e) {
			 Log.addMessage("Failed to send share invite");
			 e.printStackTrace();
			 Assert.assertTrue(false, "Failed to send share invite");
		 }
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void logOutFromHomeOwnerShareInviteTest() {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 mh.clickBackButton();
			 ld.clickHamburgerButton();
			 Thread.sleep(2000);
			 String lsttext ="Log Out";
			 if(device.equals("android")) {
				 System.out.println("in scroll");
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")).click();
					//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text('Log Out'));")).click();
			 }else {
				 mp.clickLogoutButton();
			 }
			 mp.clickOKButton();
			 
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="adminlogin")
	public void loginHomeAdminShInviteAcceptTest(String email, String password) {
		try {
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(5000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 Thread.sleep(15000);
			 System.out.println("wait to retrieve verification code from email");
			 //get verification code from mail and submit
			 cvp.enterMobileCode("123456");
			 Thread.sleep(5000);//to edit while testing
			 cvp.clickSubmitButton(); 
			 Thread.sleep(15000);
			 ld.clickOKButton();//to accept invite popup	
			
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void logOutFromHomeAdminShInviteAcceptTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			//mh.clickBackButton();
			ld.clickHamburgerButton();
			 Thread.sleep(2000);
			 String lsttext ="Log Out";
			 if(device.equals("android")) {
				 System.out.println("in scroll2");
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")).click();
					//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text('Log Out'));")).click();
			 }else {
				 mp.clickLogoutButton();
			 }
			
			 mp.clickOKButton();
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="ownerlogin")
	public void loginHomeOwnerDeleteShareTest(String email, String password) {
		try {
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 HomeUserList hu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(5000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 Thread.sleep(15000);
			 System.out.println("wait to retrieve verification code from email");
			 //get verification code from mail and submit
			 cvp.enterMobileCode("123456");
			 Thread.sleep(5000);//to edit while testing
			 cvp.clickSubmitButton(); 
			 Thread.sleep(15000);
				
			 ld.clickHamburgerButton();
			 mf.clickManageButton();
			 mh.clickManageHomeUsersButton();
			Log.addMessage("Logged in");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="memlogin")
	public void loginHomeMemberShareDeleteTest(String email, String password) {
		try {
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(5000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 Thread.sleep(15000);
			 System.out.println("wait to retrieve verification code from email");
			 //get verification code from mail and submit
			 cvp.enterMobileCode("123456");
			 Thread.sleep(5000);//to edit while testing
			 cvp.clickSubmitButton(); 
			 Thread.sleep(15000);
				
			 //ld.clickHamburgerButton();
			// mf.clickManageButton();
			Log.addMessage("Clicked log in");
		}catch(Exception e) {
			Log.addMessage("Failed to click log in");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log in");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="adminHomeName")
	public void verifyHomeShareInSharedMemberTest(String homeName, String titleMessage, String valMessage) {
		try {
			MenuFlyoutPage nu = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			nu.verifyHomeName(homeName);
		}catch(Exception e) {
			Log.addMessage("Failed to display owner shared home in shared user account");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display owner shared home in shared user account");
		
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void logoutFromHomeSharedMemberTest() {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 mh.clickBackButton();
			 ld.clickHamburgerButton();
			 Thread.sleep(2000);
			 String lsttext ="Log Out";
			 if(device.equals("android")) {
				 System.out.println("in scroll");
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")).click();
					//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text('Log Out'));")).click();
			 }else {
				 mp.clickLogoutButton();
			 }
			 mp.clickOKButton();
			 
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="adminlogin")
	public void loginHomeSharedAdminDeleteTest(String email, String password) {
		try {
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(5000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 Thread.sleep(15000);
			 System.out.println("wait to retrieve verification code from email");
			 //get verification code from mail and submit
			 cvp.enterMobileCode("123456");
			 Thread.sleep(5000);//to edit while testing
			 cvp.clickSubmitButton(); 
			 Thread.sleep(15000);
				
			/* ld.clickHamburgerButton();
			 mf.clickManageButton();*/
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="memberUserName")
	public void verifyMemberHomeShareInSharedAdminTest(String userName) {
		try {
			HomeUserList nu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			nu.clickBackButton();
			nu.verifyLeaveShareByAdminInOwner(userName,"delete");
			Log.addMessage("Home User  access type verified as Member");
		}catch(Exception e) {
			Log.addMessage("Failed to verify access type as member");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify access type as member");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void logoutVerifyMemberInSharedAdmin() {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 mh.clickBackButton();
			 ld.clickHamburgerButton();
			 Thread.sleep(2000);
			 String lsttext ="Log Out";
			 if(device.equals("android")) {
				 System.out.println("in scroll");
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")).click();
					//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text('Log Out'));")).click();
			 }else {
				 mp.clickLogoutButton();
			 }
			 mp.clickOKButton();
			 
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="anotheradminlogin")
	public void loginHomeAnotherAdminForMemberDeleteTest(String email, String password) {
		try {
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(5000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 Thread.sleep(15000);
			 System.out.println("wait to retrieve verification code from email");
			 //get verification code from mail and submit
			 cvp.enterMobileCode("123456");
			 Thread.sleep(5000);//to edit while testing
			 cvp.clickSubmitButton(); 
			 Thread.sleep(15000);
				
			 ld.clickHamburgerButton();
			 /* mf.clickManageButton();*/
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="delsharepopup")
	public void deleteHomeAdminSharedMemberPopupTest(String titleMsg, String valMsg, String valMsg2) {
		try {
			MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			HomeUsersPage hu = new HomeUsersPage((AppiumDriver<MobileElement>) driver);
			HomeUserList nu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			mf.clickManageButton();
			mh.clickManageAdminHomeUsersButton();
			hu.clickMemberUserButton();
			nu.clickDeleteShareButton();
			mh.verifyLeaveSharePopUpVerbiage(titleMsg,valMsg);
			mh.clickCancel();
			Utility.simpleWait(5000);
			nu.clickDeleteShareButton();
			mh.clickOkButton();
			Utility.simpleWait(10000);
			mh.verifyLeaveSharePopUpVerbiage("",valMsg2);//test this case
			mh.clickOkButton();
		}catch(Exception e) {
			Log.addMessage("Failed to leave the shared home");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to leave the shared home");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="anotheradminUserName")
	public void verifyDeleteHomeShareInAnotherAdminTest(String userName) {
		try {
			HomeUserList nu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			nu.clickBackButton();
			nu.verifyLeaveShareByAdminInOwner(userName,"delete");
			Log.addMessage("Home User  access type verified as Member");
		}catch(Exception e) {
			Log.addMessage("Failed to verify access type as member");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify access type as member");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void logoutFromHomeAnotherAdminTest() {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 mh.clickBackButton();
			 ld.clickHamburgerButton();
			 Thread.sleep(2000);
			 String lsttext ="Log Out";
			 if(device.equals("android")) {
				 System.out.println("in scroll");
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")).click();
					//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text('Log Out'));")).click();
			 }else {
				 mp.clickLogoutButton();
			 }
			 mp.clickOKButton();
			 
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="memlogin")
	public void loginHomeMemberofAnthrAdminMemberTest(String email, String password) {
		try {
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(5000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 Thread.sleep(15000);
			 System.out.println("wait to retrieve verification code from email");
			 //get verification code from mail and submit
			 cvp.enterMobileCode("123456");
			 Thread.sleep(5000);//to edit while testing
			 cvp.clickSubmitButton(); 
			 Thread.sleep(15000);
				
			 //ld.clickHamburgerButton();
			// mf.clickManageButton();
			Log.addMessage("Clicked log in");
		}catch(Exception e) {
			Log.addMessage("Failed to click log in");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log in");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="adminHomeName")
	public void verifyHomeShareInAnthrAdminSharedMemberTest(String homeName, String titleMessage, String valMessage) {
		try {
			MenuFlyoutPage nu = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			nu.verifyHomeName(homeName);
		}catch(Exception e) {
			Log.addMessage("Failed to display owner shared home in shared user account");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display owner shared home in shared user account");
		
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="adminHomeName")//check if adminHomeName is enough
	public void verifyLockAfterDeleteInAnotherAdminWifiOffTest(String anotheradminHomeName, String titleMessage, String valMessage) {
		try {
			System.out.println("Wait for wifi Off");
			Utility.simpleWait(20000);
			MenuFlyoutPage nu = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			nu.clickCancelButton();
			nu.verifyHomeName(anotheradminHomeName);
			Log.addMessage("Home User  access type verified as Member");
		}catch(Exception e) {
			Log.addMessage("Failed to verify access type as member");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to verify access type as member");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void logoutFromHomeMemAnotherAdminTest() {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mp = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 mh.clickBackButton();
			 ld.clickHamburgerButton();
			 Thread.sleep(2000);
			 String lsttext ="Log Out";
			 if(device.equals("android")) {
				 System.out.println("in scroll");
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")).click();
					//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text('Log Out'));")).click();
			 }else {
				 mp.clickLogoutButton();
			 }
			 mp.clickOKButton();
			 
			Log.addMessage("Clicked log out");
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="ownerlogin")
	public void loginHomeOwnerAnthrAdminMemberTest(String email, String password) {
		try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(5000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 Thread.sleep(15000);
			 System.out.println("wait to retrieve verification code from email");
			 //get verification code from mail and submit
			 cvp.enterMobileCode("123456");
			 Thread.sleep(5000);//to edit while testing
			 cvp.clickSubmitButton(); 
			 Thread.sleep(15000);
				
			 ld.clickHamburgerButton();
			 mf.clickManageButton();
			Log.addMessage("Clicked log in");
		}catch(Exception e) {
			Log.addMessage("Failed to click log in");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log in");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="memberUserName")
	public void verifyHomeShareOwnerInAnthrAdminSharedMemberTest(String memUserName) {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			HomeUserList nu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			mh.clickManageHomeUsersButton();
			nu.verifyLeaveShareByAdminInOwner(memUserName,"delete");
		}catch(Exception e) {
			Log.addMessage("Failed to display owner shared home in shared user account");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display owner shared home in shared user account");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="memberUserName")
	public void viewMenuFlyOutPageTest(String memUserName) {
		try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 HomeUserList nu = new HomeUserList((AppiumDriver<MobileElement>) driver);
			 ld.clickHamburgerButton();
			 mf.verifyMenuFlyoutPage();
			 String lsttext="Log Out";
			 String settext="Settings";
			 String helptext="Help/FAQ";
			 String workstext="Works With";
			 String sendtext="Send Logs";
			 if(device.equals("android")) {
				 System.out.println("in scroll2");
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))"));
				 Log.addMessage("LogOut button present in the menu flyout page for homes");
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+settext+"\").instance(0))"));
				 Log.addMessage("Settings present in the menu flyout page for homes");
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+helptext+"\").instance(0))"));
				 Log.addMessage("Help/FAQ button present in the menu flyout page for homes");
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+workstext+"\").instance(0))"));
				 Log.addMessage("Works With button present in the menu flyout page for homes");
				 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+sendtext+"\").instance(0))"));
				 Log.addMessage("Send Logs button present in the menu flyout page for homes");
			 }else {
				// mf.clickLogoutButton();
			 }
			 mf.getAppVersion();
			 mf.getAppEnv();
		}catch(Exception e) {
			Log.addMessage("Failed to display owner shared home in shared user account");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display owner shared home in shared user account");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="lsthomeName")
	public void viewMenuHomeNameAlphaListTest(String hmName) {
		try {
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 mf.verifyAllHomes(hmName,0);
			 
		}catch(Exception e) {
			Log.addMessage("Failed to list home names in Alphabetical order");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to list home names in Alphabetical order");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void viewMenuSlideTest() {
		try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 //ld.clickAddLockButton();
			 ld.verifyLockDashboardPage();
			 Log.addMessage("Menu flyout slid from right to left");
			 Utility.simpleWait(2000);
			 ld.clickHamburgerButton();
			 mf.verifyMenuFlyoutPage();
			 Log.addMessage("Menu flyout slid from left to right");
		}catch(Exception e) {
			Log.addMessage("Failed to list home names in Alphabetical order");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to list home names in Alphabetical order");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="lockhmName")
	public void viewLockInMenuTest(String homeName, String lockName) {
		try {
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 
			 ld.clickHamburgerButton();
			 mf.clickFPHomeNameInMenu(homeName);
			 mf.verifyHomeLockName(lockName);
			 Log.addMessage("Menu flyout slid from left to right");
		}catch(Exception e) {
			Log.addMessage("Failed to list home names in Alphabetical order");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to list home names in Alphabetical order");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyVerticalScrollInMenuTest() {
		try {
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			if(device.equals("android")) {
				 System.out.println("in scroll");
				 String lsttext = "Log Out";
				 Utility.waitForElementToBeVisible(driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")));
				 System.out.println("out of scroll");	
			 }else {
				 mf.verifyMenuScrollToLogout();
			 }
		}catch(Exception e) {
			Log.addMessage("Failed to scroll in the menu flyout page");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed toscroll in the menu flyout page");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void logoutFromHomeAnotherAdminSharedUserTest() {
		try {
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
				if(device.equals("android")) {
					 System.out.println("in scroll");
					 String lsttext = "Log Out";
					 Utility.waitForElementToBeVisible(driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/expandableListView\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")));
					 System.out.println("out of scroll");	
				 }else {
					 mf.verifyMenuScrollToLogout();
				 }
		}catch(Exception e) {
			Log.addMessage("Failed to click log out");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click log out");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider="adminlogin")
	public void loginHomeAdminShInviteAcceptSharedUserTest(String email, String password) {
		try {
			 ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			 ChooseVerificationMethodPage cv = new ChooseVerificationMethodPage((AppiumDriver<MobileElement>) driver);
			 EnterEmailPage ee = new EnterEmailPage((AppiumDriver<MobileElement>) driver);
			 LoginPage cp = new LoginPage((AppiumDriver<MobileElement>) driver);
			 CodeVerificationPage cvp = new CodeVerificationPage((AppiumDriver<MobileElement>) driver);
			 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			 MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			 //Thread.sleep(27000);//for testing in between
			 cp.login(email, password);
			 Thread.sleep(5000);
			 cv.selectEmail();
			 cv.clickSubmit();
			 Thread.sleep(15000);
			 System.out.println("wait to retrieve verification code from email");
			 //get verification code from mail and submit
			 cvp.enterMobileCode("123456");
			 Thread.sleep(5000);//to edit while testing
			 cvp.clickSubmitButton(); 
			 Thread.sleep(15000);
			Log.addMessage("Logged in to admin account");
		}catch(Exception e) {
			Log.addMessage("Failed to log in to admin account");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to log in to admin account");
		}
	}
	
	
	ExcelRead excel = new ExcelRead();
	 
 	@DataProvider(name = "firstHome")
	public Object[][] getData() throws Exception {
	return excel.getTableArray(InputData, "App", "FirstHome");
	}
 	@DataProvider(name = "secondHome")
	public Object[][] getDataSHome() throws Exception {
	return excel.getTableArray(InputData, "App", "AnotherHome");
	}
 	@DataProvider(name = "hmName")
	public Object[][] getDataHmName() throws Exception {
		return excel.getTableArray(InputData, "Validation", "ValHomeName");
	}
 	@DataProvider(name = "addHomeName")
	public Object[][] getDataAddHmName() throws Exception {
		return excel.getTableArray(InputData, "Validation", "ValAddHomeName");
	}
 	@DataProvider(name = "modHomeName")
	public Object[][] getDataModHmName() throws Exception {
		return excel.getTableArray(InputData, "Validation", "ValEdtHmName");
	}
 	@DataProvider(name = "editHomeName")
	public Object[][] getDataEditHmName() throws Exception {
		return excel.getTableArray(InputData, "App", "EditHomeName");
	}
 	@DataProvider(name = "tohomeNm")
	public Object[][] getDatatohomeNm() throws Exception {
		return excel.getTableArray(InputData, "App", "ToHomeName");
	}
 	@DataProvider(name = "adminlogin")
	public Object[][] getDataVLogin() throws Exception {
		return excel.getTableArray(InputData, "App", "LoginAdmin");
	}
 	@DataProvider(name = "memlogin")
	public Object[][] getDataVMemLogin() throws Exception {
		return excel.getTableArray(InputData, "App", "LoginMember");
	}
	@DataProvider(name = "othermemlogin")
	public Object[][] getDataOMemLogin() throws Exception {
		return excel.getTableArray(InputData, "App", "LoginOthMember");
	}
	@DataProvider(name = "ownerlogin")
	public Object[][] getDataOwnLogin() throws Exception {
		return excel.getTableArray(InputData, "App", "LoginOwner");
	}
	@DataProvider(name = "lsharepopup")
	public Object[][] getDatalsharepopup() throws Exception {
		return excel.getTableArray(InputData, "App", "LeaveSharePopup");
	}
	@DataProvider(name = "delsharepopup")
	public Object[][] getDataDelsharepopup() throws Exception {
		return excel.getTableArray(InputData, "App", "DeleteSharePopup");
	}
	@DataProvider(name = "addHome")
	public Object[][] getDataaddHome() throws Exception {
		return excel.getTableArray(InputData, "Validation", "ValAddHomeUser");
	}
	@DataProvider(name = "validAddHome")
	public Object[][] getDataVAddHome() throws Exception {
		return excel.getTableArray(InputData, "Validation", "ValidAddHomeUser");
	}
	@DataProvider(name = "validAddAnthrHome")
	public Object[][] getDataAnthrAddHome() throws Exception {
		return excel.getTableArray(InputData, "Validation", "validAddAnthrHome");
	}
	@DataProvider(name = "modHome")
	public Object[][] getDataModHome() throws Exception {
		return excel.getTableArray(InputData, "Validation", "ValEditHomeUser");
	}
	@DataProvider(name = "memberInvitePopup")
	public Object[][] getDataMemberInvitePopup() throws Exception {
		return excel.getTableArray(InputData, "App", "MemberInvite");
	}
	@DataProvider(name = "addHomeEmail")
	public Object[][] getDataaddHomeEmail() throws Exception {
		return excel.getTableArray(InputData, "Validation", "ValUserShareEmail");
	}
	@DataProvider(name = "addHomeAdminEmail")
	public Object[][] getDataAddHomeAdminEmail() throws Exception {
		return excel.getTableArray(InputData, "App", "AdminHomeUserEmail");
	}
	@DataProvider(name = "inviteAdmin")
	public Object[][] getDataInviteAdmin() throws Exception {
		return excel.getTableArray(InputData, "App", "AdminInvitation");
	}
	@DataProvider(name = "inviteMember")
	public Object[][] getDataInviteMember() throws Exception {
		return excel.getTableArray(InputData, "App", "ShareMember");
	}
	@DataProvider(name = "adminLockPair")
	public Object[][] getDataAdminLockPair() throws Exception {
		return excel.getTableArray(InputData, "App", "LockPairPopUp");
	}
	@DataProvider(name = "addLockPopup")
	public Object[][] getDataAddLockPopup() throws Exception {
		return excel.getTableArray(InputData, "App", "LockAddSuccess");
	}
	@DataProvider(name = "deleHomeLock")
	public Object[][] getDataDeleHomeLock() throws Exception {
		return excel.getTableArray(InputData, "App", "DeleteHomeLockPopup");
	}
	@DataProvider(name = "adminUserName")
	public Object[][] getDataAdminUser() throws Exception {
		return excel.getTableArray(InputData, "App", "AdminUser");
	}
	@DataProvider(name = "memberUserName")
	public Object[][] getDataMemberUser() throws Exception {
		return excel.getTableArray(InputData, "App", "MemberUser");
	}
	@DataProvider(name = "adminHomeName")
	public Object[][] getDataAdminHomeName() throws Exception {
		return excel.getTableArray(InputData, "App", "AdminHome");
	}
	@DataProvider(name = "modifiedHome")
	public Object[][] getDataAdminModifiedHome() throws Exception {
		return excel.getTableArray(InputData, "App", "ModifyHome");
	}
	@DataProvider(name = "existHomeName")
	public Object[][] getDataAdminExistHomeNm() throws Exception {
		return excel.getTableArray(InputData, "App", "AdminHomeUserName");
	}
	@DataProvider(name = "existElevHomeName")
	public Object[][] getDataAdminExistElevHomeNm() throws Exception {
		return excel.getTableArray(InputData, "App", "EditHomeName");
	}
	@DataProvider(name = "existElevAddHomeName")
	public Object[][] getDataAdminExistElevAddHomeNm() throws Exception {
		return excel.getTableArray(InputData, "App", "AdminElevHomeName");
	}
	@DataProvider(name = "vemail")
	public Object[][] getDataVEmail() throws Exception {
		return excel.getTableArray(InputData, "App", "ValidEmail");
	}
	@DataProvider(name = "vphone")
	public Object[][] getDataVPhone() throws Exception {
		return excel.getTableArray(InputData, "App", "ValidPhone");
	}
	@DataProvider(name = "vldSecQn")
	public Object[][] getDataVSQn() throws Exception {
		return excel.getTableArray(InputData, "App", "ValidSQuestion");
	}
	@DataProvider(name = "sendShare")
	public Object[][] getDataSendShare() throws Exception {
		return excel.getTableArray(InputData, "App", "ValidSendShareAdmin");
	}
	@DataProvider(name = "sendShareMem")
	public Object[][] getDataSendShareMem() throws Exception {
		return excel.getTableArray(InputData, "App", "ValidSendShareMember");
	}
	@DataProvider(name = "anotheradminlogin")
	public Object[][] getDataAnotherAdmin() throws Exception {
		return excel.getTableArray(InputData, "App", "LoginOthAdmin");
	}
	@DataProvider(name = "anotheradminHomeName")
	public Object[][] getDataAnotherAdminHmName() throws Exception {
		return excel.getTableArray(InputData, "App", "AnotherAdminHomeName");
	}
	@DataProvider(name = "anotheradminUserName")
	public Object[][] getDataAnotherAdminUserName() throws Exception {
		return excel.getTableArray(InputData, "App", "AnotherAdminUserName");
	}
	@DataProvider(name = "adminAccessCode")
	public Object[][] getDataAdminAccessCode() throws Exception {
		return excel.getTableArray(InputData, "App", "VAdminAccessCode");
	}
	@DataProvider(name = "adminAudio")
	public Object[][] getDataAdminSettings() throws Exception {
		return excel.getTableArray(InputData, "App", "VlockSetting");
	}
	@DataProvider(name = "lsthomename")
	public Object[][] getDataListHomeName() throws Exception {
		return excel.getTableArray(InputData, "Validation", "ListHomeName");
	}
	@DataProvider(name = "lockhmName")
	public Object[][] getDatalockhmName() throws Exception {
		return excel.getTableArray(InputData, "App", "HomeLockName");
	}
	@DataProvider(name = "accessName")
	public Object[][] getDataAccessName() throws Exception {
		return excel.getTableArray(InputData, "App", "LockAccessName");
	}
	@DataProvider(name = "sameHomeName")
	public Object[][] getDataSameHomeName() throws Exception {
		return excel.getTableArray(InputData, "App", "AnotherAdminHomeName");
	}
	@DataProvider(name = "modValidHome")
	public Object[][] getDataModHomeName() throws Exception {
		return excel.getTableArray(InputData, "App", "ModifyHomeUser");
	}
}
