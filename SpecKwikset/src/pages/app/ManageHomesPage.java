package pages.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import utility.Log;
import utility.Utility;

public class ManageHomesPage extends Settings{
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='add home']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_end_image"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_end_image"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_end_image"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_end_image")
	})
	@CacheLookup
	private MobileElement addHomeButton;
	
	@iOSXCUITFindBy(id = "Add Lock")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_add_lock"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_add_lock"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_add_lock"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_add_lock")
	})
	@CacheLookup
	private MobileElement addLockButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeTable/XCUIElementTypeCell[2]")
	@AndroidFindAll({//commented on 04 nov 2020
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_edit_name"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_edit_name"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_edit_name"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_edit_name")
	})
	@CacheLookup
	private MobileElement editHomeName;
	
	//@iOSXCUITFindBy(xpath="//XCUIElementTypeTable/XCUIElementTypeCell[1]")//commented on 05-11-20202
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Edit User Name']")
	@AndroidFindAll({//added on 25 aug 2020
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/edit_user_name"),
		@AndroidBy(id = "com.kwikset.blewifi:id/edit_user_name"),
		@AndroidBy(id = "com.spectrum.giga:id/edit_user_name"),
		@AndroidBy(id = "com.weiser.blewifi:id/edit_user_name")
	})
	@CacheLookup
	private MobileElement editHomeUser;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeTable/XCUIElementTypeCell[3]")
	@AndroidFindAll({//added on 25 aug 2020
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tvAccessRights"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tvAccessRights"),
		@AndroidBy(id = "com.spectrum.giga:id/tvAccessRights"),
		@AndroidBy(id = "com.weiser.blewifi:id/tvAccessRights")
	})
	@CacheLookup
	private MobileElement editAccessType;
	
	//@iOSXCUITFindBy(id = "Manage Home Users")//commented on 05-11-2020
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Delete ')]")
	@AndroidFindAll({//added on 25 aug 2020
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_delete"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_delete"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_delete"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_delete")
	})
	@CacheLookup
	private MobileElement deleteHomeButton;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Manage Home Users'])[1]")
	@AndroidFindAll({//added on 25 aug 2020
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_manage"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_manage"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_manage"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_manage")
	})
	@CacheLookup
	private MobileElement manageHomeUsers;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Manage Home Users'])[1]")
	@AndroidFindAll({//added on 18 sep 2020
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_manage"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_manage"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_manage"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_manage")
	})
	@CacheLookup
	private List<MobileElement> manageHomeUsersList;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Manage Home Users'])[1]")
	@AndroidFindAll({//added on 25 aug 2020
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/leave_home"),
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/leave_home"),
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/leave_home"),
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/leave_home")
	})
	@CacheLookup
	private MobileElement leaveHomeUser;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Manage Home Users'])[1]")
	@AndroidFindAll({//added on 9 sep 2020
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/homeName"),
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/homeName"),
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/homeName"),
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/homeName")
	})
	@CacheLookup
	private List<MobileElement> listHomeName;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Manage Home Users'])[1]")//changed to [1] on 05-11-2020
	@CacheLookup
	private MobileElement manageHomeUsersTo;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Manage Home Users'])[3]")//added on 26-05-2020
	@CacheLookup
	private MobileElement manageHomeUsersEnd;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Yes']")
	@CacheLookup
	private MobileElement yesButton;
	
	@AndroidFindBy(id = "com.kwikset.blewifi.dev:id/lockCount")
	@CacheLookup
	private MobileElement lockCount;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	@AndroidFindBy(id = "android:id/button2")
	@CacheLookup
	private MobileElement cancelButton;
	
	@AndroidFindBy(id = "com.kwikset.blewifi.dev:id/tv_title")
	@CacheLookup
	private MobileElement offlineBanner;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Ok']")
	@AndroidFindBy(id = "android:id/button1")
	@CacheLookup
	private MobileElement okButton;
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Ok']")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
	@CacheLookup
	private MobileElement OKButton;
	
	//@iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name='SPHomesListVC']//XCUIElementTypeButton[1]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Back']")
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/cancelAllhomes")//added on 05-05-2020
	@CacheLookup
	private MobileElement backButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/cancelAllhomes")//added on 05-05-2020
	@CacheLookup
	private MobileElement navBackBtn;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[1]")
	@AndroidFindBy(id="android:id/alertTitle")
	private MobileElement alertTitle;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[2]")
	@AndroidFindBy(id = "android:id/message")
	@CacheLookup
	private MobileElement popUpMessageVerbiage;
	
	String actMessage, titleMessage = "";
	

	//Constructor
	@SuppressWarnings("static-access")
	public ManageHomesPage(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
		
		
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
		
	public void clickEditHomeNameButton() throws InterruptedException {
		try {
			Utility.waitForElementToBeVisible(editHomeName);
			Utility.waitForElementToBeClickable(editHomeName);
			editHomeName.click();
			Log.addMessage("Clicked Edit Home Name Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Edit Home Name button");
			Assert.assertTrue(false, "Failed to click Edit Home Name button");
		}
	}
	
	/** 
	* Method Name: clickEditHomeUserButton(), 
	* This function is used to select Email option from the MFA Page
	*/
		
		
	public void clickEditHomeUserButton() throws InterruptedException {
		try {
			Utility.waitForElementToBeVisible(editHomeUser);
			Utility.waitForElementToBeClickable(editHomeUser);
			editHomeUser.click();
			Log.addMessage("Clicked Edit Home Name Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Edit Home Name button");
			Assert.assertTrue(false, "Failed to click Edit Home Name button");
		}
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	//added on 04-11-2020	
	public void clickEditAccessTypeButton() throws InterruptedException {
		try {
			System.out.println("1");
			Utility.waitForElementToBeVisible(editAccessType);
			System.out.println("2");
			Utility.waitForElementToBeClickable(editAccessType);
			System.out.println("3");
			editAccessType.click();
			System.out.println("4");
			Log.addMessage("Clicked Edit Access Type Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click  Edit Access Type button");
			Assert.assertTrue(false, "Failed to click  Edit Access Type button");
		}
	}
	
	public void clickAddLockButton() throws InterruptedException {
		try {
			Utility.waitForElementToBeVisible(addLockButton);
			Utility.waitForElementToBeClickable(addLockButton);
			addLockButton.click();
			Log.addMessage("Clicked Add Lock Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Add Lock button");
			Assert.assertTrue(false, "Failed to click Add Lock button");
		}
	}
	
	public void clickAddHomeButton() throws InterruptedException {
		try {
			Utility.waitForElementToBeVisible(addHomeButton);
			//Utility.waitForElementToBeClickable(addHomeButton);
			addHomeButton.click();
			Log.addMessage("Clicked Add Home Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Add Home button");
			Assert.assertTrue(false, "Failed to click Add Home button");
		}
	}
	
	public void verifyHomeOfflineBanner() throws InterruptedException {
		try {
			Utility.simpleWait(2000);
			Utility.waitForElementToBeVisible(cancelButton);
			cancelButton.click();
			Log.addMessage("Clicked Cancel Button");
			Utility.waitForElementToBeVisible(offlineBanner);
			Log.addMessage("Homes - Offline banner is displayed");
		}catch(Exception e) {
			Log.addMessage("Failed to display Homes - Offline banner");
			Assert.assertTrue(false, "Failed to display Homes - Offline banner");
		}
	}

	
	public void clickManageHomeUsersButton() throws InterruptedException {
		try {
			Thread.sleep(3000);//changed on 26-05-2020
			System.out.println("in manage users");
			if(device.equals("iOS")) {
				/*JavascriptExecutor js = appiumDriver;
				Map<String, Object> params = new HashMap<>();
				params.put("direction", "up");
				params.put("element", manageHomeUsersTo);
				js.executeScript("mobile: swipe", params);*/
				Utility.waitForElementToBeVisible(manageHomeUsersTo);
				//Utility.waitForElementToBeClickable(manageHomeUsers);
				System.out.println("in manage usersTo");
				//manageHomeUsersEnd.click();//commented and added below code on 30-10-2020
				manageHomeUsersTo.click();
			}else {
			Utility.waitForElementToBeVisible(manageHomeUsers);
			//Utility.waitForElementToBeClickable(manageHomeUsers);
			System.out.println("in manage users2");
			manageHomeUsers.click();
			}
			Log.addMessage("Clicked Manage Home Users Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Manage Home Users button");
			Assert.assertTrue(false, "Failed to click Manage Home Users button");
		}
	}
	
	public void clickManageAdminHomeUsersButton() throws InterruptedException {
		try {
			Thread.sleep(3000);//changed on 26-05-2020
			System.out.println("in manage users");
			if(device.equals("iOS")) {
				JavascriptExecutor js = appiumDriver;
				Map<String, Object> params = new HashMap<>();
				params.put("direction", "up");
				params.put("element", manageHomeUsersTo);
				js.executeScript("mobile: swipe", params);
				Utility.waitForElementToBeVisible(manageHomeUsersTo);
				//Utility.waitForElementToBeClickable(manageHomeUsers);
				System.out.println("in manage usersTo");
				manageHomeUsersEnd.click();
			}else {
				Utility.waitForElementToBeVisible(manageHomeUsersList.get(1));
				//Utility.waitForElementToBeClickable(manageHomeUsers);
				System.out.println("in manage users2");
				manageHomeUsersList.get(1).click();
			}
			Log.addMessage("Clicked Manage Home Users Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Manage Home Users button");
			Assert.assertTrue(false, "Failed to click Manage Home Users button");
		}
	}
	
	public void addHomeUserButton() throws InterruptedException {
		try {
			Thread.sleep(3000);//changed on 26-05-2020
			System.out.println("in manage users");
			/*if(device.equals("iOS")) {
				JavascriptExecutor js = appiumDriver;
				Map<String, Object> params = new HashMap<>();
				params.put("direction", "up");
				params.put("element", manageHomeUsersTo);
				js.executeScript("mobile: swipe", params);
				Utility.waitForElementToBeVisible(manageHomeUsersTo);
				//Utility.waitForElementToBeClickable(manageHomeUsers);
				System.out.println("in manage usersTo");
				manageHomeUsersEnd.click();
			}else {*/
			Utility.waitForElementToBeVisible(manageHomeUsers);
			//Utility.waitForElementToBeClickable(manageHomeUsers);
			System.out.println("in manage users2");
			manageHomeUsers.click();
			//}
			Log.addMessage("Clicked Manage Home Users Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Manage Home Users button");
			Assert.assertTrue(false, "Failed to click Manage Home Users button");
		}
	}
	/** 
	* Method Name: deleteHome(), 
	* This function is used to delete a home
	*/
		
	public void deleteHome() throws InterruptedException {
		try {
			Utility.waitForElementToBeVisible(deleteHomeButton);
			Utility.waitForElementToBeClickable(deleteHomeButton);
			deleteHomeButton.click();
			if(device.equals("android")) {
				System.out.println("in android");
				cancelButton.click();//for Android function is cancel
				Utility.simpleWait(3000);
				System.out.println("click cancel");
				deleteHomeButton.click();
				System.out.println("click delete");
			}
			
			if(device.equals("iOS")) {
				yesButton.click();
			}else {
				System.out.println("click confirm");
				okButton.click();
				System.out.println("click yes");
			}
			Utility.simpleWait(12000);
			System.out.println("click ok");
			OKButton.click();
			System.out.println("clicked ok");
			Log.addMessage("Deleted home");
		}catch(Exception e) {
			Log.addMessage("Failed to delete home");
			Assert.assertTrue(false, "Failed to delete home");
		}
	}
	
	/** 
	* Method Name: deleteHomeWithLock(), 
	* This function is used to delete a home
	*/
		
	public void deleteHomeWithLock(String valMessage) throws InterruptedException {
		try {
			Utility.waitForElementToBeVisible(deleteHomeButton);
			//Utility.waitForElementToBeClickable(deleteHomeButton);
			deleteHomeButton.click();
			Log.addMessage("Clicked delete home");
			Utility.waitForElementToBeVisible(popUpMessageVerbiage);
			actMessage = popUpMessageVerbiage.getText();
			System.out.println("expmainMsg="+valMessage+",mainMsg="+actMessage);
			okButton.click();
			System.out.println("clicked ok");
			Assert.assertEquals(actMessage,valMessage,"Popup content message is not matching");
			Log.addMessage("Pop up verbiage is matching");
		}catch(Exception e) {
			Log.addMessage("Failed to delete home");
			Assert.assertTrue(false, "Failed to delete home");
		}
	}
	
	@SuppressWarnings("unchecked")
	public void viewAllHomes() throws InterruptedException {
		try {
			Thread.sleep(6000);			
			List<MobileElement> list_of_others = (List<MobileElement>)driver.findElement(By.xpath("//XCUIElementTypeTable/XCUIElementTypeOther"));
			//String [] list_of_homes = new String[list_of_others.size()];
			Log.addMessage("Homes are : ");
			for(int i =0; i<list_of_others.size(); i++) {
				Log.addMessage(driver.findElement(By.xpath("//XCUIElementTypeTable/XCUIElementTypeOther["+(i+2)+"]")).getText());
				i++;
			}
		}catch(Exception e) {
			Log.addMessage("Failed to fetch all homes");
			Assert.assertTrue(false, "Failed to fetch all homes");
		}
	}
	
	public void clickOkButton() throws InterruptedException {
		try {
			Utility.simpleWait(2000);
			Utility.waitForElementToBeVisible(okButton);
			Utility.waitForElementToBeClickable(okButton);
			okButton.click();
			Log.addMessage("Clicked OK Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click OK button");
			Assert.assertTrue(false, "Failed to click OK button");
		}
	}
	
	public void clickOkBtn() throws InterruptedException {
		try {
			Utility.simpleWait(2000);
			Utility.waitForElementToBeVisible(OKButton);
			Utility.waitForElementToBeClickable(OKButton);
			OKButton.click();
			Log.addMessage("Clicked OK Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click OK button");
			Assert.assertTrue(false, "Failed to click OK button");
		}
	}
	
	public void clickLeaveShare() throws InterruptedException {
		try {
			Utility.simpleWait(2000);
			Utility.waitForElementToBeVisible(leaveHomeUser);
			Utility.waitForElementToBeClickable(leaveHomeUser);
			leaveHomeUser.click();
			Log.addMessage("Clicked Leave Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click OK button");
			Assert.assertTrue(false, "Failed to click OK button");
		}
	}
	
	public void clickBackButton() throws InterruptedException {
		try {
			//Utility.simpleWait(2000);//commented on 04-11-2020
			System.out.println("two");
			Utility.waitForElementToBeVisible(backButton);
			System.out.println("two2");
			Utility.waitForElementToBeClickable(backButton);
			System.out.println("two3");
			backButton.click();
			System.out.println("two4");
			Log.addMessage("Clicked Back Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Back button");
			Assert.assertTrue(false, "Failed to click back button");
		}
	}
	
	//added on 05-11-2020
	public void clickNavBackButton() throws InterruptedException {
		try {
			//Utility.simpleWait(2000);//commented on 04-11-2020
			System.out.println("two");
			Utility.waitForElementToBeVisible(navBackBtn);
			System.out.println("two2");
			Utility.waitForElementToBeClickable(navBackBtn);
			System.out.println("two3");
			navBackBtn.click();
			System.out.println("two4");
			Log.addMessage("Clicked Back Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Back button");
			Assert.assertTrue(false, "Failed to click back button");
		}
	}
	
	public void verifyAddHomeButton() throws InterruptedException {
		try {
			Utility.simpleWait(6000);
			Utility.waitForElementToBeVisible(addHomeButton);
			Assert.assertTrue(true,"Add home redirected to manage homes page");
			//backButton.click();
		}catch(Exception e) {
			Log.addMessage("Failed to redirect to manage homes page");
			Assert.assertTrue(false, "Failed to redirect to manage homes page");
		}
	}
	
	public void clickCancelButton()  {
		try {
			Utility.simpleWait(2000);
			Utility.waitForElementToBeVisible(okButton);
			Utility.waitForElementToBeClickable(okButton);
			okButton.click();
			Log.addMessage("Clicked Cancel Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Cancel button");
			Assert.assertTrue(false, "Failed to click Cancel button");
		}
	}
	
	public void clickCancel()  {
		try {
			Utility.simpleWait(2000);
			Utility.waitForElementToBeVisible(cancelButton);
			Utility.waitForElementToBeClickable(cancelButton);
			cancelButton.click();
			Log.addMessage("Clicked Cancel Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Cancel button");
			Assert.assertTrue(false, "Failed to click Cancel button");
		}
	}
	
	public void verifyLeaveSharePopUpVerbiage(String ttlMessage, String expMessage) {
		try {
			System.out.println("in popup1"+expMessage);
			Utility.waitForElementToBeVisible(popUpMessageVerbiage);
			System.out.println("in popup2");
			actMessage = popUpMessageVerbiage.getText();
			System.out.println("actMessage="+actMessage);
			if(ttlMessage!="") {
				Utility.waitForElementToBeVisible(alertTitle);
				titleMessage = alertTitle.getText();
				Assert.assertEquals(titleMessage, ttlMessage,"Popup title message is not matching");
			}
			actMessage = popUpMessageVerbiage.getText();
			System.out.println("expmainMsg="+expMessage+",mainMsg="+actMessage);
			
			Log.addMessage("Pop up title verbiage is matching");
			Assert.assertTrue(actMessage.contains(expMessage),"Popup content message is not matching");
			Log.addMessage("Pop up verbiage is matching");
		}catch(Exception e) {
			Log.addMessage("Pop up verbiage is not matching");
			Assert.assertTrue(false, "Pop up verbiage is not matching");
		}
	}
	
	public void verifyHomeManagementButton() throws InterruptedException {
		try {
			Utility.waitForElementToBeVisible(addHomeButton);
			Log.addMessage("Add Home button is present");
			Utility.waitForElementToBeVisible(addLockButton);
			Log.addMessage("Add Lock Button is present");
			Utility.waitForElementToBeVisible(editHomeName);
			Log.addMessage("Edit home name button is present");
			Utility.waitForElementToBeVisible(manageHomeUsers);
			Log.addMessage("Back Button is present");
			Utility.waitForElementToBeVisible(backButton);
			Log.addMessage("Back Button is present");
			Utility.waitForElementToBeVisible(lockCount);
			Log.addMessage("Count of locks is present");
			Utility.waitForElementToBeVisible(deleteHomeButton);
			Log.addMessage("Delete Home Button is present");
		}catch(Exception e) {
			Log.addMessage("Failed to display all elements in manage homes page");
			Assert.assertTrue(false, "Failed to display all elements in manage homes page");
		}
	}
	
	public void verifyAdminHomeManagementButton() throws InterruptedException {
		try {
			Utility.waitForElementToBeVisible(addHomeButton);
			Log.addMessage("Add Home button is present");
			Utility.waitForElementToBeVisible(editHomeName);
			Log.addMessage("Edit home name button is present");
			Utility.waitForElementToBeVisible(manageHomeUsers);
			Log.addMessage("Back Button is present");
			Utility.waitForElementToBeVisible(backButton);
			Log.addMessage("Back Button is present");
			Utility.waitForElementToBeVisible(lockCount);//check for lock count
			Log.addMessage("Count of locks is present");
			Utility.waitForElementToBeVisible(leaveHomeUser);
			Log.addMessage("Leave Home Button is present");
		}catch(Exception e) {
			Log.addMessage("Failed to display all elements in manage homes page");
			Assert.assertTrue(false, "Failed to display all elements in manage homes page");
		}
	}
	
	public void verifyModifiedHomeNameAsAdmin(String homeName) throws InterruptedException {
		try {
			Utility.waitForElementToBeVisible(listHomeName.get(0));
			Log.addMessage("Home name is present");
			if(listHomeName.get(0).getText().equals(homeName)) {
				Assert.assertTrue(true, "Home Name not modified in admin");
				Log.addMessage("Home Name is modified in admin");
			}else {
				Assert.assertTrue(false, "Home Name modified in admin");
				Log.addMessage("Home Name is not modified in admin");
			}
			
		}catch(Exception e) {
			Log.addMessage("Failed to display modified home name in admin page");
			Assert.assertTrue(false, "Failed to display modified home name in admin page");
		}
	}
	
	public void verifyMemberHomeManagementButton() throws InterruptedException {
		try {
			Utility.waitForElementToBeVisible(addHomeButton);
			Log.addMessage("Add Home button is present");
			Utility.waitForElementToBeVisible(backButton);
			Log.addMessage("Back Button is present");
			Utility.waitForElementToBeVisible(lockCount);//check for lock count
			Log.addMessage("Count of locks is present");
			Utility.waitForElementToBeVisible(leaveHomeUser);
			Log.addMessage("Leave Home Button is present");
		}catch(Exception e) {
			Log.addMessage("Failed to display all elements in manage homes page");
			Assert.assertTrue(false, "Failed to display all elements in manage homes page");
		}
	}
	
	public void verifyMemberHomeUserButtonPresent() throws InterruptedException {
		try {
			Utility.waitForElementToBeVisible(manageHomeUsers);
			Log.addMessage("Manage home users button is displayed in the Manage Homes page for member");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Assert.assertTrue(true, "Manage home users button is displayed in the Manage Homes page for member");
			Log.addMessage("Manage home users button is not displayed in the Manage Homes page for member");
		}
	}
	
	public void verifyModifiedHomeNameAsMember(String homeName) throws InterruptedException {
		try {
			
			Utility.waitForElementToBeVisible(listHomeName.get(0));
			Log.addMessage("Home name is present");
			if(listHomeName.get(0).getText().equals(homeName)) {
				Assert.assertTrue(true, "Home Name not modified in member");
				Log.addMessage("Home Name is modified in member");
			}else {
				Assert.assertTrue(false, "Home Name modified in member");
				Log.addMessage("Home Name is not modified in member");
			}
			
		}catch(Exception e) {
			Log.addMessage("Failed to display modified home name in member page");
			Assert.assertTrue(false, "Failed to display modified home name in member page");
		}
	}
	
	public void viewManageHomeScroll(String toHomeName) throws InterruptedException {
		try {
			System.out.println("one");
			if(device.equals("android")) {
				driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+toHomeName+"\"));")).click();
			}
			Assert.assertTrue(true,"Page is not scrollable");
			Log.addMessage("Home management page is scrollable");
		}catch(Exception e) {
			Log.addMessage("Failed to scroll homes page");
			Assert.assertTrue(false, "Failed to scroll homes page");
		}
	}
	
	public void verifyLeaveShareHome() throws InterruptedException {
		try {
			Utility.simpleWait(3000);
			Assert.assertTrue(!(listHomeName.size()>0),"Leave home share is success");
			Log.addMessage("Leave home share is success");
		}catch(Exception e) {
			Log.addMessage("Failed to leave shared home");
			Assert.assertTrue(false, "Failed to leave shared home");
		}
	}
	
	public void viewAscHomeName(String toHomeName, String fromHomeName) throws InterruptedException {
		try {
			System.out.println("one");
			List<String>strList=new ArrayList<String>();
			List<MobileElement> homeList1 = (List<MobileElement>)  appiumDriver.findElements(By.id("com.kwikset.blewifi.dev:id/homeName"));
			System.out.println("homeList before="+homeList1.size());
			for(int i=0;i<homeList1.size();i++) {
				System.out.println("name1="+homeList1.get(i).getText());
				strList.add(homeList1.get(i).getText());
			}
			Utility.simpleWait(4000);
			driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().resourceId('com.kwikset.blewifi.dev:id/rv_all_homes')).getChildByText("
					+ "new UiSelector().className(\"android.widget.TextView\"), '"+fromHomeName+"')"));
			 Utility.simpleWait(4000);
			 //Perform the action on the element
			/*element.click();*/
	
			//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+fromHomeName+"\"));")).click();
			List<MobileElement> homeList2 = (List<MobileElement>)  appiumDriver.findElements(By.id("com.kwikset.blewifi.dev:id/homeName"));
			System.out.println("homeList after="+homeList2.size());
			for(int j=0;j<homeList2.size();j++) {
				System.out.println("name2="+homeList2.get(j).getText());
				strList.add(homeList2.get(j).getText());
			}
			System.out.println("Total homes="+strList.size());
			Collections.sort(strList);
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+fromHomeName+"\"));")).click();
			
			Assert.assertTrue(true,"Page is not scrollable");
			Log.addMessage("Home management page is scrollable");
		}catch(Exception e) {
			Log.addMessage("Failed to scroll homes page");
			Assert.assertTrue(false, "Failed to scroll homes page");
		}
	}
	
	
}
