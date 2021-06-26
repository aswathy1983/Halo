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

public class HomeUserAccessType extends Settings{
	
	// created on 14-09-2020
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeCell[1]")
	//@AndroidFindBy(xpath = "(//android.widget.CheckedTextView)[1]")//commented on 04-11-2020
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tvAdmin"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tvAdmin"),
		@AndroidBy(id = "com.spectrum.giga:id/tvAdmin"),
		@AndroidBy(id = "com.weiser.blewifi:id/tvAdmin")
	})
	@CacheLookup
	private MobileElement homeAdmin;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeCell[2]")
	//@AndroidFindBy(xpath = "(//android.widget.CheckedTextView)[2]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tvGuest"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tvGuest"),
		@AndroidBy(id = "com.spectrum.giga:id/tvGuest"),
		@AndroidBy(id = "com.weiser.blewifi:id/tvGuest")
	})
	@CacheLookup
	private MobileElement homeMember;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/cancelAllhomes"),
		@AndroidBy(id = "com.kwikset.blewifi:id/cancelAllhomes"),
		@AndroidBy(id = "com.spectrum.giga:id/cancelAllhomes"),
		@AndroidBy(id = "com.weiser.blewifi:id/cancelAllhomes")
	})
	@CacheLookup
	private MobileElement navBack;
	
	//added on 30-09-2020
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/lockCount"),
		@AndroidBy(id = "com.kwikset.blewifi:id/lockCount"),
		@AndroidBy(id = "com.spectrum.giga:id/lockCount"),
		@AndroidBy(id = "com.weiser.blewifi:id/lockCount")
	})
	@CacheLookup
	private MobileElement lockCount;
	
	//added on 30-09-2020
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/homeName"),
		@AndroidBy(id = "com.kwikset.blewifi:id/homeName"),
		@AndroidBy(id = "com.spectrum.giga:id/homeName"),
		@AndroidBy(id = "com.weiser.blewifi:id/homeName")
	})
	@CacheLookup
	private MobileElement homeName;
		
	String userName, userType, hmOwner, ownerAcsType ="";
	
		//Constructor
		@SuppressWarnings("static-access")
		public HomeUserAccessType(AppiumDriver<MobileElement> driver) {
			this.appiumDriver = driver;
			PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
		}	
		
		
		
		/** 
		* Method Name: selectAdmin(), 
		* This function is used to select Admin user
		*/
				
		public void selectAdmin() {
			try {
				if(device.equals("iOS")) {
					Thread.sleep(6000);
				}else {
					Utility.waitForElementToBeVisible(homeAdmin);
				}
				homeAdmin.click();
				Log.addMessage("Selected Admin");
			}catch(Exception e) {
				Log.addMessage("Failed to select admin");
				Assert.assertTrue(false, "Failed to select admin");
			}
		}
		
		/** 
		* Method Name: selectMember(), 
		* This function is used to select Member user
		*/
				
		public void selectMember() {
			try {
				Utility.waitForElementToBeVisible(homeMember);
				homeMember.click();
				Log.addMessage("Selected Member");
			}catch(Exception e) {
				Log.addMessage("Failed to select member");
				Assert.assertTrue(false, "Failed to select member");
			}
		}
		
		public void clickBackButton() throws InterruptedException {
			try {
				Utility.simpleWait(2000);
				Utility.waitForElementToBeVisible(navBack);
				Utility.waitForElementToBeClickable(navBack);
				navBack.click();
				Log.addMessage("Clicked Back Button");
			}catch(Exception e) {
				Log.addMessage("Failed to click Back button");
				Assert.assertTrue(false, "Failed to click back button");
			}
		}
		
		//added on 30 Sep 2020
		public void verifyAddHomeUserAccessLevelUI() throws InterruptedException {
			try {
				Utility.waitForElementToBeVisible(homeAdmin);
				Log.addMessage("Admin button is present");
				Utility.waitForElementToBeVisible(navBack);
				Log.addMessage("Back Button is present");
				Utility.waitForElementToBeVisible(homeMember);
				Log.addMessage("Member button is present");
				Utility.waitForElementToBeVisible(homeName);
				Log.addMessage("Home name is present");
				Utility.waitForElementToBeVisible(lockCount);
				Log.addMessage(""+lockCount+" present");
				Log.addMessage("All UI elements are present");
			}catch(Exception e) {
				Log.addMessage("Failed to display all elements in add new user page");
				Assert.assertTrue(false, "Failed to display all elements in add new user page");
			}
		}
		
}
