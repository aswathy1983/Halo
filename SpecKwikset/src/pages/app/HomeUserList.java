package pages.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
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

public class HomeUserList extends Settings{
	
	// created on 05-05-2020
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeCell//XCUIElementTypeStaticText[1]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_user_name"),
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_user_name"),
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_user_name"),
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_user_name")
	})
	@CacheLookup
	private MobileElement homeOwner;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeCell//XCUIElementTypeStaticText[2]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_access_rights"),
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_access_rights"),
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_access_rights"),
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_access_rights")
	})
	@CacheLookup
	private MobileElement homeAccessType;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Manage Home Users'])[1]")
	@AndroidFindAll({//added on 9 sep 2020
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tvUserName"),
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tvUserName"),
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tvUserName"),
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tvUserName")
	})
	@CacheLookup
	private List<MobileElement> listHomeUser;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Delete Share']")
	@AndroidFindAll({//added on 9 sep 2020
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tvDelete"),
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tvDelete"),
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tvDelete"),
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tvDelete")
	})
	@CacheLookup
	private MobileElement deleteShareButton;
	
	//added on 30 sep 2020
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Share Status - Pending']/XCUIElementTypeButton")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_pending"),
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_pending"),
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_pending"),
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_pending")
	})
	@CacheLookup
	private MobileElement pendingBanner;
	
	@iOSXCUITFindBy(id = "add user")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/edit_user_name"),
		@AndroidBy(id = "com.kwikset.blewifi:id/edit_user_name"),
		@AndroidBy(id = "com.spectrum.giga:id/edit_user_name"),
		@AndroidBy(id = "com.weiser.blewifi:id/edit_user_name")
	})
	@CacheLookup
	private MobileElement editUserButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/homeName"),
		@AndroidBy(id = "com.kwikset.blewifi:id/homeName"),
		@AndroidBy(id = "com.spectrum.giga:id/homeName"),
		@AndroidBy(id = "com.weiser.blewifi:id/homeName")
	})
	@CacheLookup
	private MobileElement homeName;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/lockCount"),
		@AndroidBy(id = "com.kwikset.blewifi:id/lockCount"),
		@AndroidBy(id = "com.spectrum.giga:id/lockCount"),
		@AndroidBy(id = "com.weiser.blewifi:id/lockCount")
	})
	@CacheLookup
	private MobileElement lockCount;
	
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/tvUserName")
	@CacheLookup
	private List<MobileElement> usrName;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tvAccessRights"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tvAccessRights"),
		@AndroidBy(id = "com.spectrum.giga:id/tvAccessRights"),
		@AndroidBy(id = "com.weiser.blewifi:id/tvAccessRights")
	})
	@CacheLookup
	private List<MobileElement> usrType;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell)[3]//XCUIElementTypeStaticText[2]")//changed on 05-11-2020
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tvAccessRights"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tvAccessRights"),
		@AndroidBy(id = "com.spectrum.giga:id/tvAccessRights"),
		@AndroidBy(id = "com.weiser.blewifi:id/tvAccessRights")
	})
	@CacheLookup
	private MobileElement accessType;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tvEmail"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tvEmail"),
		@AndroidBy(id = "com.spectrum.giga:id/tvEmail"),
		@AndroidBy(id = "com.weiser.blewifi:id/tvEmail")
	})
	@CacheLookup
	private MobileElement userEmail;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/cancelAllhomes"),
		@AndroidBy(id = "com.kwikset.blewifi:id/cancelAllhomes"),
		@AndroidBy(id = "com.spectrum.giga:id/cancelAllhomes"),
		@AndroidBy(id = "com.weiser.blewifi:id/cancelAllhomes")
	})
	@CacheLookup
	private MobileElement navBack;
	
	String userName, userType, hmOwner, ownerAcsType ="";
	
		//Constructor
		@SuppressWarnings("static-access")
		public HomeUserList(AppiumDriver<MobileElement> driver) {
			this.appiumDriver = driver;
			PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
		}	
		
		/** 
		* Method Name: getOwnerName(), 
		* This function is used to get first name in Account First Name Text field in Edit Account Name Page
		*/
		public void getOwnerName(String ownrName, String acsType) {
			try {
				Utility.simpleWait(3000);
				Utility.waitForElementToBeVisible(homeOwner);
				Utility.waitForElementToBeVisible(homeAccessType);
				
				hmOwner = homeOwner.getText();
				Assert.assertEquals(hmOwner, ownrName,"Owner Name of the Home is not matching.");
				ownerAcsType = homeAccessType.getText();
				Assert.assertEquals(ownerAcsType, acsType,"Owner Access Type of the Home is not matching.");
				Log.addMessage("First Name entered");
			}catch(Exception e) {
				Log.addMessage("First Name field is not visible");
				System.out.println(e.getMessage().toString());
				Assert.assertTrue(false, "First Name field is not visible");
			}
			
		}
		
		/** 
		* Method Name: verifyAccessType(), 
		* This function is used to verify if Access Type is updated
		*/
		public void verifyAccessType(String hmAccessType) {
			try {
				Utility.simpleWait(3000);
				Utility.waitForElementToBeVisible(usrType.get(0));
				hmOwner = usrType.get(0).getText();
				Assert.assertEquals(hmOwner, hmAccessType,"Access Type is not matching.");
				Log.addMessage("Access Type is matching.");
			}catch(Exception e) {
				Log.addMessage("Access Type is not matching.");
				System.out.println(e.getMessage().toString());
				Assert.assertTrue(false, "Access Type is not matching.");
			}
			
		}
		
		/** 
		* Method Name: verifySecondAccessType(), 
		* This function is used to verify if Access Type is updated
		*/
		public void verifySecondAccessType(String hmAccessType) {
			try {
				Utility.simpleWait(3000);
				Utility.waitForElementToBeVisible(usrType.get(1));
				hmOwner = usrType.get(1).getText();
				Assert.assertEquals(hmOwner, hmAccessType,"Access Type is not matching.");
				Log.addMessage("Access Type is matching.");
			}catch(Exception e) {
				Log.addMessage("Access Type is not matching.");
				System.out.println(e.getMessage().toString());
				Assert.assertTrue(false, "Access Type is not matching.");
			}
			
		}
		
		/** 
		* Method Name: clickAccessType(), 
		* This function is used to select Admin user
		*/
				
		public void clickAccessType() {
			try {
				Utility.waitForElementToBeVisible(homeAccessType);
				homeAccessType.click();
				Log.addMessage("Clicked Access Type");
			}catch(Exception e) {
				Log.addMessage("Failed to click access type");
				Assert.assertTrue(false, "Failed to click access type");
			}
		}
		
		/** 
		* Method Name: verifyUserAccessType(), 
		* This function is used to verify if Access Type is updated
		*/
		public void verifyUserAccessType(String hmAccessType) {
			try {
				Utility.simpleWait(3000);
				Utility.waitForElementToBeVisible(accessType);
				hmOwner = accessType.getText();
				Assert.assertEquals(hmOwner, hmAccessType,"Access Type is not matching.");
				Log.addMessage("Access Type is matching.");
			}catch(Exception e) {
				Log.addMessage("Access Type is not matching.");
				System.out.println(e.getMessage().toString());
				Assert.assertTrue(false, "Access Type is not matching.");
			}
			
		}
		
		public void verifyHomeUsers(String hmName, String hmUsrType, int usr) {
			try {
				Utility.simpleWait(5000);
				for(int i=usr;i<usrName.size()+1;i++) {
					if(i==0) {
						getOwnerName(hmName,hmUsrType);
					}else {
						userName = usrName.get(i-1).getText();
						userType = usrType.get(i-1).getText();
						System.out.println("usrNm="+userName+",expusrName="+hmName+", usrType="+userType+",expUsrType="+hmUsrType);
						Assert.assertEquals(userName, hmName,"Home User is different");
						Log.addMessage("Home User is matching");
						Assert.assertEquals(userType, hmUsrType,"Home User Type is different");
					}
					Log.addMessage("Home User Type is matching");
					break;
				}
			}catch(Exception e) {
				Log.addMessage("Failed to get Home User");
				Assert.assertTrue(false, "Failed to get Home User");
			}
		}
		
		public void clickBackButton() throws InterruptedException {
			try {
				Utility.simpleWait(2000);
				System.out.println("inback");
				Utility.waitForElementToBeVisible(navBack);
				Utility.waitForElementToBeClickable(navBack);
				navBack.click();
				Log.addMessage("Clicked Back Button");
			}catch(Exception e) {
				Log.addMessage("Failed to click Back button");
				Assert.assertTrue(false, "Failed to click back button");
			}
		}
		
		public void clickDeleteShareButton() throws InterruptedException {
			try {
				Utility.simpleWait(2000);
				Utility.waitForElementToBeVisible(deleteShareButton);
				deleteShareButton.click();
				Log.addMessage("Clicked delete share");
			}catch(Exception e) {
				Log.addMessage("Failed to click delete share");
				Assert.assertTrue(false, "Failed to click delete share");
			}
		}
		
		public void verifyLeaveShareByAdminInOwner(String homeUsrName, String valType) throws InterruptedException {
			try {
				System.out.println("one");
				List<String>strList=new ArrayList<String>();
				boolean isExist = false;
				System.out.println("homeList before="+listHomeUser.size());
				for(int i=0;i<listHomeUser.size();i++) {
					System.out.println("name1="+listHomeUser.get(i).getText());
					if(listHomeUser.get(i).getText().equals(homeUsrName)) {
						isExist = true;
					}
				}
				if(valType.equals("leave")) {
					Assert.assertTrue(!isExist,"Admin user is not deleted from the home users list");
					Log.addMessage("Admin user is deleted from the home users list");
				}else {
					Assert.assertTrue(!isExist,"Share not deleted for the Admin user");
					Log.addMessage("Share home deleted for the user");
				}
			}catch(Exception e) {
				Log.addMessage("Failed to remove shared home");
				Assert.assertTrue(false, "Failed to remove shared home");
			}
		}
		
		//added on 30 Sep 2020
		public void verifyHomeUserUI() throws InterruptedException {
			try {
				Utility.waitForElementToBeVisible(homeName);
				Log.addMessage("Home name is present");
				Utility.waitForElementToBeVisible(editUserButton);
				Log.addMessage("Edit user button is present");
				Utility.waitForElementToBeVisible(userEmail);
				Log.addMessage("Owner name is present");
				Utility.waitForElementToBeVisible(accessType);
				Log.addMessage("Access level change button is present");
				Utility.waitForElementToBeVisible(navBack);
				Log.addMessage("Back button is present");
				Utility.waitForElementToBeVisible(deleteShareButton);
				Log.addMessage("Delete share button is present");
				Utility.waitForElementToBeVisible(lockCount);
				Log.addMessage(""+lockCount.getText()+" present");
				Log.addMessage("All UI elements are present in user edit page");
			}catch(Exception e) {
				Log.addMessage("Failed to display all elements in user edit page");
				Assert.assertTrue(false, "Failed to display all elements in user edit page");
			}
		}
}
