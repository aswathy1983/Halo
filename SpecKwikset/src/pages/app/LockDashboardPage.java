package pages.app;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.WaitOptions;
import utility.Log;
import utility.Utility;

import io.appium.java_client.touch.offset.PointOption;
import static java.time.Duration.ofSeconds;


public class LockDashboardPage extends Settings{
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"This home does not have any locks.\"]")
	@AndroidFindAll({
		//@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_lock_status"),//commented for fp lock on 16-06-2020
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/txt_no_lock"),//added on 16-06-2020
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_lock_status"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_lock_status"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_lock_status"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/tv_lock_status")
	})
	@CacheLookup
	private MobileElement noLocksText;
	
	//updated on 09-06-2020 for fp lock
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='base_circle']/following-sibling::XCUIElementTypeStaticText")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_lock_status"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_lock_status"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_lock_status"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_lock_status"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/tv_lock_status")
	})
	@CacheLookup
	private MobileElement lockStatus;
	
	//commented on 08-06-2020 for fp iOS
	//@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='lock_unlocked']/following-sibling::XCUIElementTypeButton")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='base_circle']//preceding::XCUIElementTypeButton[1]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/imgLock"),
		@AndroidBy(id = "com.kwikset.blewifi:id/imgLock"),
		@AndroidBy(id = "com.spectrum.giga:id/imgLock"),
		@AndroidBy(id = "com.weiser.blewifi:id/imgLock"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/imgLock")
	})
	@CacheLookup
	private MobileElement lockButton;
	
	//commented on 08-06-2020 for fp iOS
	//@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='lock_locked']/following-sibling::XCUIElementTypeButton")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='base_circle']//preceding::XCUIElementTypeButton[1]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/imgLock"),
		@AndroidBy(id = "com.kwikset.blewifi:id/imgLock"),
		@AndroidBy(id = "com.spectrum.giga:id/imgLock"),
		@AndroidBy(id = "com.weiser.blewifi:id/imgLock"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/imgLock")
	})
	@CacheLookup
	private MobileElement unlockButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='people']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/imgAcessCode"),
		@AndroidBy(id = "com.kwikset.blewifi:id/imgAcessCode"),
		@AndroidBy(id = "com.spectrum.giga:id/imgAcessCode"),
		@AndroidBy(id = "com.weiser.blewifi:id/imgAcessCode"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/imgAcessCode")
	})	
	@CacheLookup
	private MobileElement accessCodeButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='reveal']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/hamburger"),
		@AndroidBy(id = "com.kwikset.blewifi:id/hamburger"),
		@AndroidBy(id = "com.spectrum.giga:id/hamburger"),
		@AndroidBy(id = "com.weiser.blewifi:id/hamburger"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/hamburger")
	})
	@CacheLookup
	private MobileElement hamburgerButton;
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Manage']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/btn_manage"),
		@AndroidBy(id = "com.kwikset.blewifi:id/btn_manage"),
		@AndroidBy(id = "com.spectrum.giga:id/btn_manage"),
		@AndroidBy(id = "com.weiser.blewifi:id/btn_manage"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/btn_manage")
	})
	@CacheLookup
	private MobileElement manageButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='add lock']")
	//@iOSXCUITFindBy(id = "add lock") //added on 18-05-2020
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_end_image"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_end_image"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_end_image"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_end_image"),
		@AndroidBy(id="com.weiser.blewifi.dev:id/tv_end_image")
	})
	@CacheLookup
	private MobileElement addLockButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='lock settting']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/imgLockSettings"),
		@AndroidBy(id = "com.kwikset.blewifi:id/imgLockSettings"),
		@AndroidBy(id = "com.spectrum.giga:id/imgLockSettings"),
		@AndroidBy(id = "com.weiser.blewifi:id/imgLockSettings"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/imgLockSettings")
	})
	@CacheLookup
	private MobileElement lockSettingsButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='lock history']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/imgLockActivity"),
		@AndroidBy(id = "com.kwikset.blewifi:id/imgLockActivity"),
		@AndroidBy(id = "com.spectrum.giga:id/imgLockActivity"),
		@AndroidBy(id = "com.weiser.blewifi:id/imgLockActivity"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/imgLockActivity")
	})
	@CacheLookup
	private MobileElement lockHistoryButton;
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='lock history']")
	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	@CacheLookup
	private MobileElement allowButton;
	
	//added on 13-05-2020
	
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_access_code_bar"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_access_code_bar"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_access_code_bar"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_access_code_bar"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/tv_access_code_bar")
	})
	@CacheLookup
	private MobileElement noFPBanner;

	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/img_status_change"),
		@AndroidBy(id = "com.kwikset.blewifi:id/img_status_change"),
		@AndroidBy(id = "com.spectrum.giga:id/img_status_change"),
		@AndroidBy(id = "com.weiser.blewifi:id/img_status_change"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/img_status_change")
	})
	@CacheLookup
	private MobileElement lockUnlockImg;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='lock history']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/img_bluetooth"),
		@AndroidBy(id = "com.kwikset.blewifi:id/img_bluetooth"),
		@AndroidBy(id = "com.spectrum.giga:id/img_bluetooth"),
		@AndroidBy(id = "com.weiser.blewifi:id/img_bluetooth"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/img_bluetooth")
	})
	@CacheLookup
	private MobileElement imgBLE;
	
	//added on 20-05-2020
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton")
	@CacheLookup
	private List<MobileElement> lockUnlockBtn;
	
	@AndroidFindBy(xpath="//android.widget.Toast")
	@CacheLookup
	private List<MobileElement> lstToastMsg;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name='LED Status']")//check xpath
	@AndroidFindBy(id = "android:id/button2")//added on 08-06-2020
	@CacheLookup
	private MobileElement cancelButton;
	
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/home_name"),
		@AndroidBy(id = "com.kwikset.blewifi:id/home_name"),
		@AndroidBy(id = "com.spectrum.giga:id/home_name"),
		@AndroidBy(id = "com.weiser.blewifi:id/home_name"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/home_name")
	})
	@CacheLookup
	private MobileElement homeNameButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Secure Mode Active']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/secure_mode_info"),
		@AndroidBy(id = "com.kwikset.blewifi:id/secure_mode_info"),
		@AndroidBy(id = "com.spectrum.giga:id/secure_mode_info"),
		@AndroidBy(id = "com.weiser.blewifi:id/secure_mode_info"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/secure_mode_info")
	})
	@CacheLookup
	private MobileElement secureModeBanner;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"This home does not have any locks.\"]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/info"),
		@AndroidBy(id = "com.kwikset.blewifi:id/info"),
		@AndroidBy(id = "com.spectrum.giga:id/info"),
		@AndroidBy(id = "com.weiser.blewifi:id/info"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/info")
	})
	@CacheLookup
	private MobileElement noLocksInfo;
	
	
	//added on 10-06-2020
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name='Cancel']")
	@AndroidFindBy(id = "android:id/button2")//added on 15-06-2020
	@CacheLookup
	private MobileElement CancelPairButton;
		
	//added on 10-06-2020
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name='Ok']")
	@AndroidFindBy(id = "android:id/button1")//added on 15-06-2020
	@CacheLookup
	private MobileElement OKButton;
	
	//added on 15 Jan 2021
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[1]")
	@AndroidFindBy(id="android:id/alertTitle")
	@CacheLookup
	private MobileElement alertTitle;
	
	//added on 15 Jan 2021
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[2]")
	@AndroidFindBy(id = "android:id/message")
	@CacheLookup
	private MobileElement popUpMessageVerbiage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Last updated')]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/textViewLockLastSeen"),
		@AndroidBy(id = "com.kwikset.blewifi:id/textViewLockLastSeen"),
		@AndroidBy(id = "com.spectrum.giga:id/textViewLockLastSeen"),
		@AndroidBy(id = "com.weiser.blewifi:id/textViewLockLastSeen"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/textViewLockLastSeen")
	})
	@CacheLookup
	private MobileElement lockUpdateTime;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[2]")
	@AndroidFindBy(xpath = "(//android.widget.TextView)[2]")
	@CacheLookup
	private MobileElement batteryPercent;
	
	//added on 25-Aug-2020
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeStaticText[2]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/btn_add"),
		@AndroidBy(id = "com.kwikset.blewifi:id/btn_add"),
		@AndroidBy(id = "com.spectrum.giga:id/btn_add"),
		@AndroidBy(id = "com.weiser.blewifi:id/btn_add"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/btn_add")
	})
	@CacheLookup
	private MobileElement createHomeButton;
	
	By okBtn= By.xpath("//XCUIElementTypeButton[@name='Ok']");
	By okAnBtn= By.id("android:id/button1");
	By pairBtn= By.xpath("//XCUIElementTypeButton[@name='Pair']");
	By pairAnBtn= By.id("android:id/button1");
	By settingsBtn= By.xpath("//XCUIElementTypeButton[@name='SETTINGS']");
	By settingsAnBtn= By.id("android:id/button1");
	
	boolean okButtonPresent, pairButtonPresent, internetButtonPresent = false;
	
	String updateTime, upTime, lkbatteryPercent, actMessage, titleMessage = "";
	
	//Constructor
	
	@SuppressWarnings("static-access")
	public LockDashboardPage(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
		
		
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public String getLockStatus() throws InterruptedException {
		try {
			//Utility.simpleWait(8000);commented and added below code on 06-10-2020
			Utility.waitForElementToBeVisible(lockStatus);
			String status = lockStatus.getText();
			Log.addMessage("Lock Status is :"+status);
			return status;
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to retrieve lock status");
			Assert.assertTrue(false, "Failed to retrieve lock status");
			return null;
		}
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public String getLockStatusForBtry() throws InterruptedException {
		try {
			//Utility.simpleWait(8000);commented and added below code on 06-10-2020
			Utility.waitForElementToBeVisible(lockStatus);
			String status = lockStatus.getText();
			Log.addMessage("Lock Status is :"+status);
			return status;
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to retrieve lock status");
			//Assert.assertTrue(false, "Failed to retrieve lock status");
			return null;
		}
	}
		
	public void lockOperation() {
	    try {
	    	Utility.waitForElementToBeVisible(lockButton);
	    	Utility.waitForElementToBeClickable(lockButton);
	    	lockButton.click();
	    	Utility.simpleWait(8000);
	    	Log.addMessage("Door "+ lockStatus.getText());
	    }catch(Exception e) {
	    	Log.addMessage(e.getMessage().toString());
	    	Log.addMessage("Lock Operation failed");
	    	Assert.assertTrue(false, "Lock Operation failed");	    	
	    } 	
	}
	
	public void lockOperationForBtry() {
	    try {
	    	Utility.waitForElementToBeVisible(lockButton);
	    	Utility.waitForElementToBeClickable(lockButton);
	    	lockButton.click();
	    	Utility.simpleWait(8000);
	    	Log.addMessage("Door "+ lockStatus.getText());
	    }catch(Exception e) {
	    	Log.addMessage(e.getMessage().toString());
	    	Log.addMessage("Lock Operation failed");
	    	//Assert.assertTrue(false, "Lock Operation failed");	    	
	    } 	
	}
	
	public void lockOperationWOLockStatus() {
	    try {
	    	Utility.waitForElementToBeVisible(lockButton);
	    	Utility.waitForElementToBeClickable(lockButton);
	    	lockButton.click();
	    	//Utility.simpleWait(3000);
	    	cancelButton.click();
	    	//Log.addMessage("Door "+ lockStatus.getText());
	    }catch(Exception e) {
	    	Log.addMessage(e.getMessage().toString());
	    	Log.addMessage("Lock Operation failed");
	    	Assert.assertTrue(false, "Lock Operation failed");	    	
	    } 	
	}
		
	public void unlockOperation() {
		try {
			Utility.waitForElementToBeVisible(unlockButton);
	    	Utility.waitForElementToBeClickable(unlockButton);
			unlockButton.click();
			Utility.simpleWait(8000);
			Log.addMessage("Door "+ lockStatus.getText());
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Unlock Operation failed");
			Assert.assertTrue(false, "Unlock Operation failed");
		} 	
	}
	
	public void unlockOperationForBtry() {
		try {
			Utility.waitForElementToBeVisible(unlockButton);
	    	Utility.waitForElementToBeClickable(unlockButton);
			unlockButton.click();
			Utility.simpleWait(8000);
			Log.addMessage("Door "+ lockStatus.getText());
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Unlock Operation failed");
			//Assert.assertTrue(false, "Unlock Operation failed");
		} 	
	}
	
	public void clickAccessCodeButton() {
		try {
			Utility.waitForElementToBeVisible(accessCodeButton);
	    	Utility.waitForElementToBeClickable(accessCodeButton);
			accessCodeButton.click();
			Log.addMessage("Clicked Access code button");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click Access code button");
			Assert.assertTrue(false, "Failed to click Access code button");
		} 	
	}
	
	public void clickHamburgerButton() {
		try {
			Utility.waitForElementToBeVisible(hamburgerButton);
	    	Utility.waitForElementToBeClickable(hamburgerButton);
			hamburgerButton.click();
			Log.addMessage("Clicked Hamburger button");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to clcik Hamburger button");
			Assert.assertTrue(false, "Failed to clcik Hamburger button");
		} 	
	}
	
	public void clickHamburgerButtonForBtry() {
		try {
			Utility.waitForElementToBeVisible(hamburgerButton);
	    	Utility.waitForElementToBeClickable(hamburgerButton);
			hamburgerButton.click();
			Log.addMessage("Clicked Hamburger button");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to clcik Hamburger button");
			//Assert.assertTrue(false, "Failed to clcik Hamburger button");
		} 	
	}
	
	public void clickManageButton() {
		try {
			Utility.waitForElementToBeVisible(manageButton);
	    	Utility.waitForElementToBeClickable(manageButton);
			manageButton.click();
			Log.addMessage("Clicked Manage button");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click Manage button");
			Assert.assertTrue(false, "Failed to click Manage button");
		} 	
	}
	
	public void clickAddLockButton() {
		try {
			Utility.waitForElementToBeVisible(addLockButton);
	    	Utility.waitForElementToBeClickable(addLockButton);
			addLockButton.click();
			Log.addMessage("Clicked Add Lock button");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click Add Lock Button");
			Assert.assertTrue(false, "Failed to click Add Lock Button");
		} 	
	}
	
	public void clickLockSettingsButton() {
		try {
			Utility.waitForElementToBePresent(lockSettingsButton, appiumDriver);
	    	Utility.waitForElementToBeClickable(lockSettingsButton);
			lockSettingsButton.click();
			Log.addMessage("Clicked Lock Settings button");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click Lock Settings Button");
			Log.addMessage("Failed to click Lock Settings Button");
		} 	
	}
	
	public void clickLockHistoryButton() {
		try {
			Utility.waitForElementToBeVisible(lockHistoryButton);
	    	Utility.waitForElementToBeClickable(lockHistoryButton);
			lockHistoryButton.click();
			Log.addMessage("Clicked Lock History button");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click Lock History Button");
			Log.addMessage("Failed to click Lock history Button");
		} 	
	}
	
	public void clickAllowButton() {
		try {
			Utility.waitForElementToBeVisible(allowButton);
	    	Utility.waitForElementToBeClickable(allowButton);
	    	allowButton.click();
			Log.addMessage("Clicked Allow button");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click Allow Button");
			Log.addMessage("Failed to click Allow Button");
		} 	
		
	}
	public void verifyDashboardWithNoLocks() {
		try {
			System.out.println("verify nolocks text");
			Utility.waitForElementToBeVisible(noLocksText);
			System.out.println("verify nolocks text2");
			//changed home to Home in expected messages of assert on 16-06-2020
			if(device.equals("iOS")) {
				Assert.assertEquals(noLocksText.getText(), "This home does not have any locks.","No locks in the newly added home");
			}else {
				Assert.assertEquals(noLocksText.getText(), "This Home does not have any locks.","No locks in the newly added home");
			}
				Log.addMessage("Verified user in dashboard of newly added home and this home doesnot have any locks");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to verify dashboard of newly added home");
			Log.addMessage("Failed to verify dashboard of newly added home");
		} 	
	}
	
	//added on 26 Aug 2020
	public void verifyHomeLandPageWithNoLocks() {
		try {
			System.out.println("verify nolocks text");
			Utility.waitForElementToBeVisible(noLocksInfo);
			System.out.println("verify nolocks text2");
			//changed home to Home in expected messages of assert on 16-06-2020
			if(device.equals("iOS")) {
				Assert.assertEquals(noLocksInfo.getText(), "Please create a Home for locks to be added to.","No home and locks for the first time user");
			}else {
				Assert.assertEquals(noLocksInfo.getText(), "Please create a Home for locks to be added to.","No home and locks for the first time user");
			}
				Log.addMessage("Verified first time user in dashboard with no home or locks");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to verify dashboard of first time user");
			Log.addMessage("Failed to verify dashboard of first time user");
		} 	
	}
	
	/* added on 06-05-2020 */
	
	public void verifyAddLockImage() {
		try {
			Utility.waitForElementToBeVisible(addLockButton);
			//Utility.waitForElementToBeClickable(addLockButton);
		    Assert.assertTrue(true, "Add lock button is displayed in the Home Management Page");
			Log.addMessage("Add lock button is displayed in the Home Management Page");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Assert.assertTrue(false, "Add lock button is not displayed in the Home Management Page");
			Log.addMessage("Failed to verify dashboard of newly added home");
		} 	
	}
	
	/*              added on 13-05-2020         */
	
	public void displayNoAccessBanner() {
		try {
			Utility.waitForElementToBeVisible(noFPBanner);
	    	Utility.waitForElementToBeClickable(noFPBanner);
	    	if(noFPBanner.getText().equals("No Fingerprint Set")) {
	    		Log.addMessage("No Fingerprint Set banner displayed matching verbiage");
	    	}else {
	    		Log.addMessage("No Fingerprint Set banner displayed with verbiage not matching");
	    	}
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Unlock Operation failed");
			Assert.assertTrue(false, "Unlock Operation failed");
		} 	
	}
	/*              added on 14-05-2020         */
	
	public void clickLockUnlockButton() {
		try {
			Utility.waitForElementToBeVisible(lockUnlockImg);
	    	Utility.waitForElementToBeClickable(lockUnlockImg);
	    	lockUnlockImg.click();
			Log.addMessage("Clicked Lock/Unlock Button");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click Access code button");
			Assert.assertTrue(false, "Failed to click Access code button");
		} 	
	}
/*              added on 14-05-2020         */
	
	public void clickLockUnlockButtoniOS() {
		try {
			Utility.waitForElementToBeVisible(lockUnlockBtn.get(2));
	    	Utility.waitForElementToBeClickable(lockUnlockBtn.get(2));
	    	lockUnlockBtn.get(2).click();
			Log.addMessage("Clicked Lock/Unlock Button");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click Access code button");
			Assert.assertTrue(false, "Failed to click Access code button");
		} 	
	}
	
	public void verifyOverLayMessage() {
		try {
			System.out.println("toast message size="+lstToastMsg.size());
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to display toast message");
			Assert.assertTrue(false, "Failed to display toast message");
		} 	
	}
	
	//added on 08-06-2020
	public void clickCancelButton() {
		try {
			//Thread.sleep(6000);//commented for bvt on 13-10-2020
			Utility.waitForElementToBeVisible(cancelButton);
			cancelButton.click();
			Log.addMessage("Clicked Cancel Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Cancel button ");
			Assert.assertTrue(false, "Failed to click Cancel button");
		}
	}
	//added on 10-06-2020
	public void clickOKButton() {
		try {
			/*if(device.equals("iOS")) {
				Thread.sleep(6000);//commented for bvt on 13-10-2020
			}
			System.out.println("three");*/
			Utility.waitForElementToBeVisible(OKButton);
			Utility.waitForElementToBeClickable(OKButton);
			OKButton.click();
			Log.addMessage("Clicked OK button");
		}catch(Exception e) {
			Log.addMessage("Failed to click OK button ");
			Assert.assertTrue(false, "Failed to click OK button");
		}
	}
	
	//added on 10-06-2020
	public void clickOKButtonForBtry() {
		try {
			//Thread.sleep(6000);//commented for bvt on 13-10-2020
			Utility.waitForElementToBeVisible(OKButton);
			Utility.waitForElementToBeClickable(OKButton);
			OKButton.click();
			Log.addMessage("Clicked OK button");
		}catch(Exception e) {
			Log.addMessage("Failed to click OK button ");
			//Assert.assertTrue(false, "Failed to click OK button");
		}
	}
	
	public void clickCancelPairForBtry() {
		try {
			//Thread.sleep(6000);//commented for bvt on 13-10-2020
			Utility.waitForElementToBeVisible(CancelPairButton);
			System.out.println("in cancel");
			Utility.waitForElementToBeClickable(CancelPairButton);
			System.out.println("in cancel");
			CancelPairButton.click();
			System.out.println("in cancel");
			Log.addMessage("Clicked pair cancel button");
		}catch(Exception e) {
			Log.addMessage("Failed to click pair cancel button ");
			//Assert.assertTrue(false, "Failed to click OK button");
		}
	}
	
	public void verifyBLEImage() {
	    try {
	    	Utility.waitForElementToBeVisible(imgBLE);
	    	
	    	Log.addMessage("BLE image is displayed");
	    }catch(Exception e) {
	    	Log.addMessage(e.getMessage().toString());
	    	Log.addMessage("Failed to display BLE image");
	    	Assert.assertTrue(false, "Failed to display BLE image");	    	
	    } 	
	}
	@SuppressWarnings("rawtypes")
	public void refreshlockDashboard() {
		
		/*TouchActions t= new TouchActions(appiumDriver);
		t.longPress(homeNameButton);
		//t.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)));
		t.moveToElement(lockHistoryButton);
		t.release().perform();*/
		System.out.println("in refresh");
		TouchAction action = new TouchAction(appiumDriver); 
		action.press(PointOption.point(115, 200)).waitAction(WaitOptions.waitOptions(ofSeconds(2)))
		                .moveTo(PointOption.point(115, 900)).release().perform();
		System.out.println("after refresh");
	}
	public void tapDashboardScreen() {
		try {
			Utility.waitForElementToBeVisible(noFPBanner);
	    	Utility.waitForElementToBeClickable(noFPBanner);
	    	for(int i=0;i<4;i++) {
	    		noFPBanner.click();
	    		Thread.sleep(1000);
	    	}
	    	Log.addMessage("Tapped on lock dashboard to remove overlay messages");
	    	
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to tap on dashboard");
			Assert.assertTrue(false, "Failed to tap on dashboard");
		} 	
	}
	
	public void secureModeScreen() {
		try {
			Thread.sleep(3000);
			System.out.println("banner before="+secureModeBanner.isDisplayed());
			Utility.waitForElementToBeVisible(secureModeBanner);
			System.out.println("banner after="+secureModeBanner.isDisplayed());
	    	Log.addMessage("Secure Mode banner displayed in lock dashboard page");
	    	
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to display Secure Mode banner on dashboard");
			//Assert.assertTrue(false, "Failed to display last updated time on dashboard");
		} 	
	}
	
	//updated on 26-06-2020
	public String getLastUpdateTime() {
		try {
			Thread.sleep(3000);
			System.out.println("time display");
			//System.out.println("time display status in dashboard="+lockUpdateTime.isDisplayed());
			Utility.waitForElementToBeVisible(lockUpdateTime);
			updateTime="";
			upTime="";
			updateTime = lockUpdateTime.getText();
			System.out.println("uptime text before="+updateTime);
			String[] tList = updateTime.split(" at ");
			if(tList.length==2) {
		   		upTime = tList[1];
		   		System.out.println("uptime="+upTime);
		    }
	    	Log.addMessage("Last updated time is displayed in lock dashboard page");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to display last updated time on dashboard");
			//Assert.assertTrue(false, "Failed to display last updated time on dashboard");
		} 
		return upTime;
	}
	
	/** 
	* Method Name: getBatteryPercentageDashboard(), 
	* This function is used to get lock battery percentage
	*/
	public String getBatteryPercentageDashboard() {
		try {
			Utility.simpleWait(6000);
			lkbatteryPercent="";
			Utility.waitForElementToBeVisible(batteryPercent);
			System.out.println("batteryPercentindash="+batteryPercent.getText());
			lkbatteryPercent = batteryPercent.getText();
			Log.addMessage("Lock battery percentage in lock dashboard page is "+lkbatteryPercent);
		}catch(Exception e) {
			System.out.println("batteryPercentindashcatch");
			Log.addMessage("Lock battery percentage in lock dashboard page not visible");
			System.out.println(e.getMessage().toString());
		}
		return lkbatteryPercent;
	}
	//added on 25-aug-2020
	public void clickCreateHomeButton() {
		try {
			Utility.waitForElementToBeVisible(createHomeButton);
			createHomeButton.click();
			Log.addMessage("Clicked manage home  button");
		}catch(Exception e) {
			Log.addMessage("Failed to click OK button ");
			Assert.assertTrue(false, "Failed to click OK button");
		}
	}
	
	/* added on 04-09-2020 */
	
	public void verifyLockDashboardPage() {
		try {
			Utility.waitForElementToBeVisible(hamburgerButton);
		    Assert.assertTrue(true, "Hamburger button is displayed in the lock dashboard page");
		    Utility.waitForElementToBeVisible(lockStatus);
		    Assert.assertTrue(true, "Hamburger button is displayed in the lock dashboard page");
			Log.addMessage("Add lock button is displayed in the Home Management Page");
			Utility.waitForElementToBeVisible(accessCodeButton);
			Log.addMessage("Access code button is displayed in the lock dashboard Page");
			Utility.waitForElementToBeVisible(lockSettingsButton);
			Log.addMessage("Lock settings button is displayed in the lock dashboard Page");
			Utility.waitForElementToBeVisible(lockHistoryButton);
			Log.addMessage("Lock history button is displayed in the lock dashboard Page");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to display all UI elements in the lock dashboard Page");
			Log.addMessage("Failed to display all UI elements in the lock dashboard Page");
		} 	
	}
	
	public void verifyLockDashboardSettingsAccess() {
		try {
			Utility.waitForElementToBeVisible(lockSettingsButton);
			Log.addMessage("Lock settings button is displayed in the lock dashboard Page for member");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Assert.assertTrue(true, "Lock settings button is displayed in the lock dashboard page for member");
			Log.addMessage("Lock settings button is not displayed in the lock dashboard page for member");
		} 	
	}
	
	public void verifyLockDashboardHistoryAccess() {
		try {
			Utility.waitForElementToBeVisible(lockHistoryButton);
			Log.addMessage("Lock history button is displayed in the lock dashboard Page for member");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Assert.assertTrue(true, "Lock history button is displayed in the lock dashboard page for member");
			Log.addMessage("Lock history button is not displayed in the lock dashboard page for member");
		} 	
	}
	
	public void verifyLockDashboardPeopleAccess() {
		try {
			Utility.waitForElementToBeVisible(lockHistoryButton);
			Log.addMessage("People button is displayed in the lock dashboard Page for member");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Assert.assertTrue(true, "People button is displayed in the lock dashboard page for member");
			Log.addMessage("People button is not displayed in the lock dashboard page for member");
		} 	
	}
	
	public boolean checkForPopUp() {
		try {
			if(device.equals("iOS")) {
				 Utility.waitForElementPresent(okBtn,appiumDriver);
			}else {
				 Utility.waitForElementPresent(okAnBtn,appiumDriver);
			}
		    System.out.println("in ok");
		    okButtonPresent=true;
		    Log.addMessage("Popup found");
		    return okButtonPresent;
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Popup not found");
			System.out.println("in catch Popup not found");
			okButtonPresent=false;
			return okButtonPresent;
		}
	}
	
	public boolean checkForFailedPopUp() {
		try {
			if(device.equals("iOS")) {
				 Utility.waitForElementPresentBtry(okBtn,appiumDriver);
			}else {
				 Utility.waitForElementPresentBtry(okAnBtn,appiumDriver);
			}
		    System.out.println("in ok");
		    okButtonPresent=true;
		    Log.addMessage("Popup found");
		    return okButtonPresent;
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Locking failed popup not found");
			System.out.println("in catch locking failed Popup not found");
			okButtonPresent=false;
			return okButtonPresent;
		}
	}
	
	
	public boolean checkForPairPopUp() {
		try {
			if(device.equals("iOS")) {
				 Utility.waitForElementPresent(pairBtn,appiumDriver);
			}else {
				 Utility.waitForElementPresent(pairAnBtn,appiumDriver);
			}
		    System.out.println("in pair ok");
		    if(device.equals("android")) {
		    	if(driver.findElement(pairBtn).getText()=="SETTINGS") {
		    		 okButtonPresent=false;
		    	}else {
		    		 okButtonPresent=true;
		    	}
		    }else {
		    	okButtonPresent=true;
		    }
		    Log.addMessage("Pair popup found");
		    return okButtonPresent;
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Pair Popup not found");
			System.out.println("in catch Pair Popup not found");
			okButtonPresent=false;
			return okButtonPresent;
		}
	}
	
	public boolean checkForInternetPopUp() {
		try {
			if(device.equals("iOS")) {
				 Utility.waitForElementPresent(settingsBtn,appiumDriver);
			}else {
				 Utility.waitForElementPresent(settingsAnBtn,appiumDriver);
			}
		    System.out.println("in ok");
		    okButtonPresent=true;
		    Log.addMessage("Internet Popup found");
		    return okButtonPresent;
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Popup not found");
			System.out.println("in catch Popup not found");
			okButtonPresent=false;
			return okButtonPresent;
		}
	}
	
	public String verifyLowBatteryPopUpVerbiage() {
		try {
			System.out.println("in popup1 low battery verbiage");
			/*if(device.equals("iOS")) {
				Utility.simpleWait(3000);
			}*/
			titleMessage = "";
			actMessage = "";
			Utility.waitForElementToBeVisible(popUpMessageVerbiage);
			System.out.println("in popup2 low battery verbiage");
			actMessage = popUpMessageVerbiage.getText();
			System.out.println("actMessage="+actMessage);
			System.out.println("titleMessageb4lowbattery="+titleMessage);
			Utility.waitForElementToBeVisible(alertTitle);
			titleMessage = alertTitle.getText();
			System.out.println("titleMessageafterlowbattery="+titleMessage);
			Log.addMessage("Title message displayed");
			if(titleMessage!=null) {
				System.out.println("inside not null titleMessage="+titleMessage);
				//to capture the message instead of title if lock battery too low as title displayed is "Alert"
				if(device.equals("android") && actMessage.contains("too low to operate")) {
					titleMessage = actMessage;
				}
			}else {
				System.out.println("in null titleMessage="+titleMessage);
				//to display the message in cases where there is no title in a pop up
				titleMessage = actMessage;
			}
			return titleMessage;
		}catch(Exception e) {
			Log.addMessage("Title message is not displayed");
			System.out.println("title not displayed");
			return titleMessage;
			//Assert.assertTrue(false, "Title message is not displayed");
		}
	}
	
	public boolean checkForLockName(String lockName) {
		try {
			if(device.equals("iOS")) {
				 driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='"+lockName+"']"));
			}else {
				 driver.findElement(By.xpath("//android.widget.TextView[@text='"+lockName+"']"));
			}
		    System.out.println("in lockdashboard");
		    okButtonPresent=true;
		    Log.addMessage("Popup found");
		    return okButtonPresent;
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Lock not found");
			System.out.println("in catch Lock not found");
			okButtonPresent=false;
			return okButtonPresent;
		}
	}
	
	public boolean checkHandlePopUp() {
		try {
			okButtonPresent=false;
			if(device.equals("iOS")) {
				 Utility.waitForElementPresent(okBtn,appiumDriver);
			}else {
				 Utility.waitForElementPresent(okAnBtn,appiumDriver);
			}
		    System.out.println("in ok");
		    okButtonPresent=true;
		    Log.addMessage("Popup found");
		    return okButtonPresent;
		   
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Popup not found");
			System.out.println("in catch Pair Popup not found");
			try {
				if(device.equals("iOS")) {
					 driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Pair']"));
				}else {
					driver.findElement(By.id("android:id/button1"));
				}
				 okButtonPresent =true;
				 Log.addMessage("Pair popup found");
				 return okButtonPresent;
			}catch(Exception ex) {
				Log.addMessage(ex.getMessage().toString());
				Log.addMessage("Popup not found");
				System.out.println("in catch Pair Popup not found");
				try {
					if(device.equals("iOS")) {
						driver.findElement(By.xpath("//XCUIElementTypeButton[@name='SETTINGS']"));
					}else {
						driver.findElement(By.id("android:id/button1"));
					}
					okButtonPresent =true;
					Log.addMessage("Internet popup found");
					return okButtonPresent;
				}catch(Exception ep) {
					Log.addMessage(ep.getMessage().toString());
					Log.addMessage("Internet Popup not found");
					System.out.println("in catch Internet Popup not found");
					okButtonPresent=false;
					return okButtonPresent;
				}
			}
		}
	}
	
		
}
