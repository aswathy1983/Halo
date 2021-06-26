package tests.portal;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Settings;
import pages.portal.BrandNeutralPage;
import pages.portal.ChangePasswordPage;
import pages.portal.ChooseVerificationMethodPage;
import pages.portal.ConfirmationPage;
import pages.portal.DeleteMyAccountPage;
import pages.portal.EditProfilePage;
import pages.portal.EnableDisableAccountPage;
import pages.portal.EnterCodePage;
import pages.portal.HomeManagementPage;
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

public class UserHomeHistoryTest extends Settings{
	 
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
       
 	@Test(dataProvider="validlogin", priority = 3)
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
 	
 	@Test(priority=4)
	public void homeHistoryNavigationTest() {
		try {
			HomeManagementPage hm=new HomeManagementPage(driver);
			LockHistoryPage  lh = new LockHistoryPage(driver);
			Utility.simpleWait(3000);
			System.out.println("inside home page");
			hm.clickLockHistoryButton();
			Log.addMessage("Clicked history button from home listed");
			Utility.simpleWait(3000);
			lh.clickBackButton();
			Log.addMessage("Clicked back button");
			Utility.simpleWait(3000);
			hm.clickLockHistoryButton();
			Log.addMessage("Clicked history button from home listed");
		}catch(Exception e) {
			Log.addMessage("Failed to update account status");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update account status");
		}
	}
 	
 	@Test(priority = 5)
	public void checkBrowserBackButtonTest() {
		try {
			HomeManagementPage hm=new HomeManagementPage(driver);
			driver.navigate().back(); 
			Log.addMessage("Clicked browser back button");
			Utility.simpleWait(3000);
			hm.clickLockHistoryButton();
			Utility.simpleWait(3000);
		}catch(Exception e) {
			Log.addMessage("Failed to display popup on clicking browser back button");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display popup on clicking browser back button");
		}
	}
 	@Test(priority = 6)
 	public void viewHomeHistoryPage() {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.verifyUILockHistory();
	 		Log.addMessage("Lock history UI elements are displayed");
 		}catch(Exception e) {
			Log.addMessage("Failed to display lock history UI elements");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to display lock history UI elements");
		}
 	}
 	
 	@Test(priority = 7)
 	public void viewDescriptionSortAscending() {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.sortAscDescriptionList();
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Lock history description sorted in ascending order");
 		}catch(Exception e) {
			Log.addMessage("Failed to sort description in lock history");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to sort description in lock history");
		}
 	}
 	
 	@Test(priority = 8)
 	public void viewDescriptionSortDescending() {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.sortDescDescriptionList();
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Lock history description sorted in ascending order");
 		}catch(Exception e) {
			Log.addMessage("Failed to sort description in lock history");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to sort description in lock history");
		}
 	}
 	
 	@Test(priority = 9)
 	public void viewSourceSortAscending() {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.sortAscSourceList("lock");
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Lock history source sorted in ascending order");
 		}catch(Exception e) {
			Log.addMessage("Failed to sort source in lock history");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to sort source in lock history");
		}
 	}
 	
 	@Test(priority = 10)
 	public void viewSourceSortDescending() {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.sortDesSourceList("lock");
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Lock history source sorted in descending order");
 		}catch(Exception e) {
			Log.addMessage("Failed to sort source in lock history");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to sort source in lock history");
		}
 	}
 	
 	@Test(priority = 11)
 	public void viewDateTimeSortAscending() {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.sortAscDateTimeList();
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Lock history source sorted in descending order");
 		}catch(Exception e) {
			Log.addMessage("Failed to sort source in lock history");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to sort source in lock history");
		}
 	}
	
 	@Test(priority = 12)
 	public void viewDateTimeSortDescending() {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.sortDesDateTimeList();
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Lock history source sorted in descending order");
 		}catch(Exception e) {
			Log.addMessage("Failed to sort source in lock history");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to sort source in lock history");
		}
 	}
 	
 	@Test(dataProvider = "iconName", priority = 13)
 	public void viewEventIconList(String iconName) {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.eventIconList(iconName);
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Lock history source sorted in descending order");
 		}catch(Exception e) {
			Log.addMessage("Failed to sort source in lock history");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to sort source in lock history");
		}
 	}
 	
 	@Test(dataProvider = "iconName", priority = 14)
 	public void viewUICheckListDescription(String iconName) {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.itemsInCheckList(iconName);
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Check list listed for description");
 		}catch(Exception e) {
			Log.addMessage("Failed to list all the checklist options for description");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to list all the checklist options for description");
		}
 	}
 	
 	@Test(priority = 15)
 	public void verifyFilterButtonDescription() {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.verifyFilterButton();
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Lock history source sorted in descending order");
 		}catch(Exception e) {
			Log.addMessage("Failed to sort source in lock history");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to sort source in lock history");
		}
 	}

 	@Test(priority = 16)
 	public void verifyFilterAction() {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.verifyFilterOption("lock");
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Lock history source sorted in descending order");
 		}catch(Exception e) {
			Log.addMessage("Failed to sort source in lock history");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to sort source in lock history");
		}
 	}
	
 	@Test(priority = 17)
 	public void verifyClearAction() {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.verifyClearOption("lock");
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Lock history source sorted in descending order");
 		}catch(Exception e) {
			Log.addMessage("Failed to sort source in lock history");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to sort source in lock history");
		}
 	}
 	
 	@Test(priority = 18)
 	public void viewUICheckListSource() {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.itemsInSourceSearch();
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Search option listed for source");
 		}catch(Exception e) {
			Log.addMessage("Failed to list search option for source");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to list search option for source");
		}
 	}
 	
 	@Test(priority = 19)
 	public void verifyFilterButtonSource() {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.verifySourceFilterButton();
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Lock history sorted with entered search in source");
 		}catch(Exception e) {
			Log.addMessage("Failed to sort lock history with search entered in source source");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to sort lock history with search entered in source source");
		}
 	}
 	
 	@Test(priority = 20)
 	public void verifySourceFilterAction() {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.verifySourceFilterOption();
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Lock history source sorted in descending order");
 		}catch(Exception e) {
			Log.addMessage("Failed to sort source in lock history");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to sort source in lock history");
		}
 	}
 	
 	@Test(priority = 21)
 	public void verifySourceClearAction() {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.verifySourceClearOption("lock");
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Lock history source sorted in descending order");
 		}catch(Exception e) {
			Log.addMessage("Failed to sort source in lock history");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to sort source in lock history");
		}
 	}
 	
 	@Test(priority = 22)
 	public void viewUICheckListDateTime() {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.itemsInDateSearch();
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Search option listed for source");
 		}catch(Exception e) {
			Log.addMessage("Failed to list search option for source");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to list search option for source");
		}
 	}
 	
 	@Test(dataProvider="dateVal" , priority = 23)
 	public void verifyFilterButtonDate(String frmDt, String toDt) {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.verifyDateFilterButton(frmDt,toDt);
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Lock history sorted with entered search in source");
 		}catch(Exception e) {
			Log.addMessage("Failed to sort lock history with search entered in source source");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to sort lock history with search entered in source source");
		}
 	}
 	
 	@Test(priority = 24)
 	public void verifyDateFilterAction(String frmDt,String toDt) {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.verifyDateFilterOption(frmDt, toDt,"lock");
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Lock history filtered with date time");
 		}catch(Exception e) {
			Log.addMessage("Failed to filter lock history  with date time");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to filter lock history  with date time");
		}
 	}
 	
 	@Test(priority = 25)
 	public void verifyDateClearAction() {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.verifyDateClearOption("lock");
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Lock history source sorted in descending order");
 		}catch(Exception e) {
			Log.addMessage("Failed to sort source in lock history");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to sort source in lock history");
		}
 	}
 	
 	@Test(priority=26)
	public void homeLockHistoryNavigationTest() {
		try {
			HomeManagementPage hm=new HomeManagementPage(driver);
			LockHistoryPage  lh = new LockHistoryPage(driver);
			System.out.println("inside home page");
			Utility.simpleWait(3000);
			lh.clickBackButton();
			Log.addMessage("Clicked back button");
			Utility.simpleWait(4000);
			hm.clickHomeLockHistoryButton();
			Utility.simpleWait(4000);
			Log.addMessage("Clicked history button for multiple locks from home listed");
			
		}catch(Exception e) {
			Log.addMessage("Failed to update account status");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update account status");
		}
 	}
 	
 	@Test(priority = 27)
 	public void viewLockNameSortAscending() {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.sortAscLockNameList();
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Lock history description sorted in ascending order");
 		}catch(Exception e) {
			Log.addMessage("Failed to sort description in lock history");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to sort description in lock history");
		}
 	}
 	
 	@Test(priority = 28)
 	public void viewLockNameSortDescending() {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.sortDesLockNameList();
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Lock history description sorted in ascending order");
 		}catch(Exception e) {
			Log.addMessage("Failed to sort description in lock history");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to sort description in lock history");
		}
 	}
 	
 	@Test(priority = 29)
 	public void viewUICheckListLockName() {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.itemsInLockNameSearch();
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Search option listed for lock name");
 		}catch(Exception e) {
			Log.addMessage("Failed to list search option for lock name");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to list search option for lock name");
		}
 	}
 	
 	@Test(dataProvider="lockNm" ,priority = 30)
 	public void verifyFilterButtonLockName(String lockName) {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.verifyLockNameFilterButton(lockName);
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Lock history sorted with entered search in lock name");
 		}catch(Exception e) {
			Log.addMessage("Failed to sort lock history with search entered in ock name");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to sort lock history with search entered in ock name");
		}
 	}
 	
 	@Test(dataProvider="lockNm" , priority = 31)
 	public void verifyLockNameFilterAction(String lockName) {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.verifyLockNameFilterOption(lockName);
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Lock history lock name sorted in descending order");
 		}catch(Exception e) {
			Log.addMessage("Failed to sort lock name in lock history");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to sort lock name in lock history");
		}
 	}
 	
 	@Test(priority = 32)
 	public void verifyLockNameClearAction() {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.verifyLockNameClearOption();
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Lock history lock name sorted in descending order");
 		}catch(Exception e) {
			Log.addMessage("Failed to sort lock name in lock history");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to sort lock name in lock history");
		}
 	}
 	
 	@Test(priority = 33)
 	public void viewHomeDescriptionSortAscending() {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.sortHomeAscDescriptionList();
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Lock history description sorted in ascending order");
 		}catch(Exception e) {
			Log.addMessage("Failed to sort description in lock history");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to sort description in lock history");
		}
 	}
 	
 	@Test(priority = 34)
 	public void viewHomeDescriptionSortDescending() {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.sortHomeDescDescriptionList();
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Lock history description sorted in ascending order");
 		}catch(Exception e) {
			Log.addMessage("Failed to sort description in lock history");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to sort description in lock history");
		}
 	}
 	
 	@Test(priority = 35)
 	public void viewHomeDateTimeSortAscending() {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.sortHomeAscDateTimeList();
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Lock history source sorted in descending order");
 		}catch(Exception e) {
			Log.addMessage("Failed to sort source in lock history");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to sort source in lock history");
		}
 	}
	
 	@Test(priority = 36)
 	public void viewHomeDateTimeSortDescending() {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.sortHomeDesDateTimeList();
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Lock history source sorted in descending order");
 		}catch(Exception e) {
			Log.addMessage("Failed to sort source in lock history");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to sort source in lock history");
		}
 	}
 	
 	@Test(dataProvider = "iconName", priority = 37)
 	public void viewHomeEventIconList(String iconName) {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.eventHomeIconList(iconName);
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Lock history source sorted in descending order");
 		}catch(Exception e) {
			Log.addMessage("Failed to sort source in lock history");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to sort source in lock history");
		}
 	}
 	
 	@Test(dataProvider = "iconName", priority = 38)
 	public void viewHomeUICheckListDescription(String iconName) {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.itemsInCheckList(iconName);
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Check list listed for description");
 		}catch(Exception e) {
			Log.addMessage("Failed to list all the checklist options for description");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to list all the checklist options for description");
		}
 	}
 	@Test(priority = 39)
 	public void verifyHomeFilterButtonDescription() {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.verifyFilterButton();
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Lock history source sorted in descending order");
 		}catch(Exception e) {
			Log.addMessage("Failed to sort source in lock history");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to sort source in lock history");
		}
 	}

 	@Test(priority = 40)
 	public void verifyHomeFilterAction() {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.verifyFilterOption("home");
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Lock history source sorted in descending order");
 		}catch(Exception e) {
			Log.addMessage("Failed to sort source in lock history");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to sort source in lock history");
		}
 	}
	
 	@Test(priority = 41)
 	public void verifyHomeClearAction() {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.verifyClearOption("home");
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Lock history source sorted in descending order");
 		}catch(Exception e) {
			Log.addMessage("Failed to sort source in lock history");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to sort source in lock history");
		}
 	}
 	@Test(priority = 42)
 	public void viewHomeUICheckListDateTime() {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.itemsInDateSearch();
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Search option listed for source");
 		}catch(Exception e) {
			Log.addMessage("Failed to list search option for source");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to list search option for source");
		}
 	}
 	
 	@Test(dataProvider="dateVal" , priority = 43)
 	public void verifyHomeFilterButtonDate(String frmDt, String toDt) {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.verifyDateFilterButton(frmDt,toDt);
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Lock history sorted with entered search in source");
 		}catch(Exception e) {
			Log.addMessage("Failed to sort lock history with search entered in source source");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to sort lock history with search entered in source source");
		}
 	}
 	
 	@Test(dataProvider="dateVal" , priority = 44)
 	public void verifyHomeDateFilterAction(String frmDt, String toDt) {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.verifyDateFilterOption(frmDt,toDt,"home");
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Lock history filtered with date time");
 		}catch(Exception e) {
			Log.addMessage("Failed to filter lock history  with date time");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to filter lock history  with date time");
		}
 	}
 	
 	@Test(priority = 45)
 	public void verifyHomeDateClearAction() {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.verifyDateClearOption("home");
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Lock history source sorted in descending order");
 		}catch(Exception e) {
			Log.addMessage("Failed to sort source in lock history");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to sort source in lock history");
		}
 	}
 	
 	@Test(priority = 46)
 	public void viewHomeSourceSortAscending() {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.sortAscSourceList("home");
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Lock history source sorted in ascending order");
 		}catch(Exception e) {
			Log.addMessage("Failed to sort source in lock history");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to sort source in lock history");
		}
 	}
 	
 	@Test(priority = 47)
 	public void viewHomeSourceSortDescending() {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.sortDesSourceList("home");
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Lock history source sorted in descending order");
 		}catch(Exception e) {
			Log.addMessage("Failed to sort source in lock history");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to sort source in lock history");
		}
 	}
 	
 	@Test(priority = 48)
 	public void viewUIHomeCheckListSource() {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.itemsInSourceSearch();
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Search option listed for source");
 		}catch(Exception e) {
			Log.addMessage("Failed to list search option for source");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to list search option for source");
		}
 	}
 	
 	@Test(priority = 49)
 	public void verifyHomeFilterButtonSource() {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.verifySourceFilterButton();
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Lock history sorted with entered search in source");
 		}catch(Exception e) {
			Log.addMessage("Failed to sort lock history with search entered in source source");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to sort lock history with search entered in source source");
		}
 	}
 	
 	@Test(priority = 50)
 	public void verifyHomeSourceFilterAction() {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.verifySourceFilterOption();
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Lock history source sorted in descending order");
 		}catch(Exception e) {
			Log.addMessage("Failed to sort source in lock history");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to sort source in lock history");
		}
 	}
 	
 	@Test(priority = 51)
 	public void verifyHomeSourceClearAction() {
 		try {
	 		LockHistoryPage  lh = new LockHistoryPage(driver);
	 		lh.verifySourceClearOption("home");
	 		Utility.simpleWait(5000);
	 		Log.addMessage("Lock history source sorted in descending order");
 		}catch(Exception e) {
			Log.addMessage("Failed to sort source in lock history");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to sort source in lock history");
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
	
	@DataProvider(name = "iconName")
	public Object[][] getDataIcons() throws Exception {
	return excel.getTableArray(InputData,"Portal", "ValEventVerify");
	}
	
	@DataProvider(name = "dateVal")
	public Object[][] getData2() throws Exception {
	return excel.getTableArray(InputData, "Portal", "ValDateRange");
	}
	
	@DataProvider(name = "lockNm")
	public Object[][] getData3() throws Exception {
	return excel.getTableArray(InputData, "Portal", "FilterLockName");
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
