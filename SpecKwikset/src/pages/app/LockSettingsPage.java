package pages.app;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import utility.Log;
import utility.Utility;

public class LockSettingsPage extends Settings{
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Delete Lock']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/ll_row_delete_lock"),
		@AndroidBy(id = "com.kwikset.blewifi:id/ll_row_delete_lock"),
		@AndroidBy(id = "com.spectrum.giga:id/ll_row_delete_lock"),
		@AndroidBy(id = "com.weiser.blewifi:id/ll_row_delete_lock"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/ll_row_delete_lock")
	})
	@CacheLookup
	private MobileElement deleteLockButton;
	
	//@iOSXCUITFindBy(id = "Edit Lock Name") //commented on 29-05-2020
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeCell[1]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/ll_row_edit_lock"),
		@AndroidBy(id = "com.kwikset.blewifi:id/ll_row_edit_lock"),
		@AndroidBy(id = "com.spectrum.giga:id/ll_row_edit_lock"),
		@AndroidBy(id = "com.weiser.blewifi:id/ll_row_edit_lock"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/ll_row_edit_lock")
	})
	@CacheLookup
	private MobileElement editLockName;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Edit Lock Name']")
	@CacheLookup
	private MobileElement lockNameButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[2]//XCUIElementTypeStaticText[2]")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Auto Lock']/following-sibling::android.widget.TextView")
	@CacheLookup
	private MobileElement lockStatusNm;
	
	/* added on 06-05-2020 */
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[2]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/common_lock_setting_title"),
		@AndroidBy(id = "com.kwikset.blewifi:id/common_lock_setting_title"),
		@AndroidBy(id = "com.spectrum.giga:id/common_lock_setting_title"),
		@AndroidBy(id = "com.weiser.blewifi:id/common_lock_setting_title"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/common_lock_setting_title")
	})
	@CacheLookup
	private MobileElement mnLockName;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch")
	@AndroidFindBy(xpath = "//android.widget.Switch")
	@CacheLookup
	private List<MobileElement> lockSndLEDStatus;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[5]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/bonded_device"),
		@AndroidBy(id = "com.kwikset.blewifi:id/bonded_device"),
		@AndroidBy(id = "com.spectrum.giga:id/bonded_device"),
		@AndroidBy(id = "com.weiser.blewifi:id/bonded_device"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/bonded_device")
	})
	@CacheLookup
	private MobileElement lockPairList;
	
	/* added on 06-05-2020 */
	
	@iOSXCUITFindBy(id = "Auto Lock")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/llAutoLockDelay"),
		@AndroidBy(id = "com.kwikset.blewifi:id/llAutoLockDelay"),
		@AndroidBy(id = "com.spectrum.giga:id/llAutoLockDelay"),
		@AndroidBy(id = "com.weiser.blewifi:id/llAutoLockDelay"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/llAutoLockDelay")
	})
	@CacheLookup
	private MobileElement autoLockButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name='Lock Sounds']")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Lock Sounds']/following-sibling::android.widget.Switch")//added on 08-06-2020
	@CacheLookup
	private MobileElement lockSoundsButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Lock Sounds']")
	@AndroidFindBy(xpath = "//*[@text='Lock Sounds']")
	//@AndroidFindBy(xpath = "//android.widget.LinearLayout[@id='com.kwikset.blewifi.dev:id/switch_lock_sound']//android.widget.TextView")
	//added on 10-11-2020
	////android.widget.ScrollView//android.widget.LinearLayout[@id='com.kwikset.blewifi.dev:id/switch_lock_sound']//android.widget.TextView
	@CacheLookup
	private MobileElement lockSoundsText;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name='LED Status']")//commented a space on 08-06-2020
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='LED Status']/following-sibling::android.widget.Switch")//added on 08-06-2020
	@CacheLookup
	private MobileElement ledStatusButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name='Unlock with Google Assistant']")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Unlock with Google Assistant']")//added on 16-10-2020
	@CacheLookup
	private MobileElement googleAstButton;
	
	@iOSXCUITFindBy(id = "Paired Smartphones")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/bonded_device"),
		@AndroidBy(id = "com.kwikset.blewifi:id/bonded_device"),
		@AndroidBy(id = "com.spectrum.giga:id/bonded_device"),
		@AndroidBy(id = "com.weiser.blewifi:id/bonded_device"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/bonded_device")
	})
	@CacheLookup
	private MobileElement pairedSmartPhones;
	
	@iOSXCUITFindBy(id = "info white")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_end_image"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_end_image"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_end_image"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_end_image"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/tv_end_image")
	})
	@CacheLookup
	private MobileElement lockInfoButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[6]")//added on 04-09-2020
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Identify Lock']")
	@CacheLookup
	private MobileElement identifyLock;
	
	@iOSXCUITFindBy(id = "Back")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/cancelAllhomes"),
		@AndroidBy(id = "com.kwikset.blewifi:id/cancelAllhomes"),
		@AndroidBy(id = "com.spectrum.giga:id/cancelAllhomes"),
		@AndroidBy(id = "com.weiser.blewifi:id/cancelAllhomes"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/cancelAllhomes")
	})
	@CacheLookup
	private MobileElement backButton;
	
	@iOSXCUITFindBy(id = "Ok")//check xpath
	@AndroidFindBy(id = "android:id/button2")//added on 08-06-2020
	@CacheLookup
	private MobileElement cancelButton;
	
	@AndroidFindBy(xpath="//android.widget.Toast[1]")//added on 08-06-2020
	@CacheLookup
	private MobileElement confirmToastMsg;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeTable//XCUIElementTypeStaticText)[2]")
	@AndroidFindBy(xpath = "(//android.widget.TextView)[3]")
	@CacheLookup
	private MobileElement batteryPercent;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeTable//XCUIElementTypeStaticText)[1]")
	//@AndroidFindBy(xpath = "(//android.widget.TextView)[2]")
	@AndroidFindBy(xpath = "(//android.widget.TextView)[4]")
	@CacheLookup
	private MobileElement lockNameDisp;
	
	//added on 23-06-2020
	//@iOSXCUITFindBy(id = "Ok")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Ok']")
	@AndroidFindBy(id = "android:id/button1")
	@CacheLookup
	private MobileElement OkButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[1]")
	@AndroidFindBy(id = "android:id/alertTitle")
	@CacheLookup
	private MobileElement popUpTitleVerbiage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[2]")
	@AndroidFindBy(id = "android:id/message")
	@CacheLookup
	private MobileElement popUpMessageVerbiage;
	
	//@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[6]")//commented on 27-11-2020
	@iOSXCUITFindBy(xpath = "XCUIElementTypeStaticText[@name='Identify Lock']")
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Identify Lock']")
	@CacheLookup		
	private MobileElement lockSettingsLoad;
	
	By edtLockNm = By.xpath("//XCUIElementTypeTable//XCUIElementTypeCell[1]");
	By edtLockNmAn = By.xpath("//android.widget.TextView[@text='Delete Lock']");
	By lockSnd = By.xpath("//XCUIElementTypeSwitch[@name='Lock Sounds']");
	By lockSndAn = By.xpath("//android.widget.TextView[@text='Lock Sounds']/following-sibling::android.widget.Switch");
	By ledStsBtn = By.xpath("//XCUIElementTypeSwitch[@name='LED Status']");
	By ledStsBtnAn= By.id("//android.widget.TextView[@text='LED Status']/following-sibling::android.widget.Switch");
	//By autoDelayText = By.xpath("//XCUIElementTypeStaticText[@name='Auto Lock Delay']");
	//By autoDelayAnText = By.xpath("//XCUIElementTypeStaticText[@name='Auto Lock Delay']");
	By okBtn= By.xpath("//XCUIElementTypeButton[@name='Ok']");
	By okAnBtn= By.id("android:id/button1");
	By autoLockBtn = By.id("Auto Lock");
	By syncPopup= By.xpath("//XCUIElementTypeAlert//XCUIElementTypeStaticText[@name='Syncing']");
	By syncPopupAn= By.xpath("//*[@resource-id='android:id/alertTitle']");
	
	boolean okButtonPresent = false;
	
	
	String actTitle, actMessage, autoLkStts, ledStts, lkSoundStts ="";
	
	String lkName, lkStatus, lkSound, lkLED, toastMessage, lkbatteryPercent ="";
	
	
	//Constructor
	@SuppressWarnings("static-access")
	public LockSettingsPage(AppiumDriver<MobileElement> driver) {
	this.appiumDriver = driver;
	PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
	
	/** 
	* Method Name: clickDeleteLockButton(), 
	* This function is used to click Delete Lock option 
	*/	
	public void clickDeleteLockButton() {
		try {
			Utility.waitForElementToBeVisible(deleteLockButton);
			Utility.waitForElementToBeClickable(deleteLockButton);
			deleteLockButton.click();
			Log.addMessage("Clicked Delete Lock Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Delete Lock button ");
			Assert.assertTrue(false, "Failed to click Delete Lock button");
		}
	}
	
	/** 
	* Method Name: clickLockInfoButton(), 
	* This function is used to click  back button
	*/
	public void clickBackButton() {
		try {
			Thread.sleep(3000);//commented on 09-11-2020
			Utility.waitForElementToBeVisible(backButton);
			backButton.click();
			Log.addMessage("Clicked Back Button in lock settings page");
		}catch(Exception e) {
			Log.addMessage("Failed to click Back button in lock settings page");
			Assert.assertTrue(false, "Failed to click Back button in lock settings page");
		}
	}
	
	/** 
	* Method Name: clickCancelButton(), 
	* This function is used to click  Cancel button
	*/	public void clickCancelButton() {
		try {
			Thread.sleep(6000);
			cancelButton.click();
			System.out.println("in cancel");
			Log.addMessage("Clicked Cancel Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Cancel button ");
			Assert.assertTrue(false, "Failed to click Cancel button");
		}
	}
	
	/** 
	* Method Name: clickLockInfoButton(), 
	* This function is used to click  lock info option
	*/
	public void clickLockInfoButton() {
		try {
			Thread.sleep(6000);
			lockInfoButton.click();
			Log.addMessage("Clicked Lock Info Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Lock Info button ");
			Assert.assertTrue(false, "Failed to click Lock Info button");
		}
	}
	
	/** 
	* Method Name: clickGoogleAstButton(), 
	* This function is used to click  option for google assistant 
	*/
	public void clickGoogleAstButton() {
		try {
			Thread.sleep(6000);
			googleAstButton.click();
			Log.addMessage("Clicked google assistant Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click google assistant button ");
			Assert.assertTrue(false, "Failed to click google assistant button");
		}
	}
	
	/** 
	* Method Name: clickEditLockNameButton(), 
	* This function is used to click  edit lock name 
	*/
	public void clickEditLockNameButton() {
		try {
			if(device.equals("android")) {
				Utility.waitForElementPresent(edtLockNmAn, appiumDriver);
			}else {
				Utility.waitForElementPresent(edtLockNm, appiumDriver);
			}
			editLockName.click();
			Log.addMessage("Clicked Edit Lock Name Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Edit Lock Name button ");
			Assert.assertTrue(false, "Failed to click Edit lock Name button");
		}
	}
	
	/** 
	* Method Name: clickAutoLockButton(), 
	* This function is used to click  edit autolock button
	*/
	public void clickAutoLockButton() {
		try {
			if(device.equals("iOS")) {
				Utility.waitForElementPresent(ledStsBtn, appiumDriver);
			}else if(device.equals("android")) {
				//Utility.waitForTextToBePresentBy("//android.widget.TextView[@text='Auto Lock']", "Auto Lock");//below for Aura Lock check
				Utility.waitForTextToBePresentBy("//android.widget.TextView[@text='Auto Lock']", "Auto Lock");
			}
			autoLockButton.click();
			while(checkSyncPopup()) {
				if(device.equals("iOS")) {
					 Utility.waitForElementPresent(okBtn,appiumDriver);
					 driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Ok']")).click();
					 Utility.waitForElementPresent(ledStsBtn, appiumDriver);
				}else if(device.equals("android")) {
					 Utility.waitForElementPresent(okAnBtn,appiumDriver);
					 if(driver.findElement(syncPopupAn).getText().equals("Syncing")) {
						 driver.findElement(By.id("android:id/button1")).click();
					 }else {
						 break;
					 }
					 Utility.waitForTextToBePresent(lockSoundsText, "Lock Sounds");
				}
				autoLockButton.click();
			}
			Log.addMessage("Clicked Auto Lock Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Auto Lock button ");
			//Assert.assertTrue(false, "Failed to click Auto Lock button");
		}
	}
	
	/** 
	* Method Name: verifyAutoLockUpdate(), 
	* This function is used to update the autolock status
	*/
	@SuppressWarnings("unchecked")
	@Test
	public void verifyAutoLockUpdate(String autSts, String ledSts, String lkSndSts) throws InterruptedException {
		try {
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);
			autoLkStts = ls.getAutoLockStts();
			Assert.assertEquals(autoLkStts, autSts, "Failed to update auto lock status");
			Log.addMessage("Auto lock status updated");
			ledStts = ls.getLEDStatus();
			Assert.assertEquals(ledStts, ledSts, "Failed to update auto lock status");
			Log.addMessage("LED status updated");
			lkSoundStts = ls.getAudioStatus();
			Assert.assertEquals(lkSoundStts, lkSndSts, "Failed to update auto lock status");
			Log.addMessage("Lock sounds updated");
		}catch(Exception e) {
			Log.addMessage("Failed to update lock settings");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to update lock settings");
		}
	}
	
	/** 
	* Method Name: clickSyncFailPopUp(), 
	* This function is used to click OK in sync faled popup displayed
	*/
		
	public void clickSyncFailPopUp() {
		try {
			if(device.equals("iOS")) {
				 Utility.waitForElementPresent(okBtn,appiumDriver);
				 driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Ok']")).click();
			}else if(device.equals("android")) {
				 Utility.waitForElementPresent(okAnBtn,appiumDriver);
				 driver.findElement(By.id("android:id/button1")).click();
			}
			Log.addMessage("Clicked sync failed Ok button");
		}catch(Exception e) {
			Log.addMessage("Failed to click sync failed Ok button");
			Assert.assertTrue(true, "Failed to click sync failed Ok button");
		}
	}
	
	
	public boolean checkOkButton() throws InterruptedException {
		try {
			System.out.println("in checkok button");
			if(device.equals("iOS")) {
				 Utility.waitForElementPresent(okBtn,appiumDriver);
			}else {
				 Utility.waitForElementPresent(okAnBtn,appiumDriver);
			}
			System.out.println("in checkok button true");
		    okButtonPresent=true;
		    Log.addMessage("Ok button found, syncing in progress");
		    return okButtonPresent;
		}catch(Exception e) {
			System.out.println("catch checkok button");
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to display Ok button");
			System.out.println("catch checkok button false");
			okButtonPresent=false;
			return okButtonPresent;
		}
	}
	
	public void clickOkButton()  {
		try {
		    Utility.waitForElementToBeVisible(OkButton);
		    OkButton.click();
		    Assert.assertTrue(true, "Clicked Ok button");
		    Log.addMessage("Clicked Ok button");
		}catch(Exception e) {
			  Log.addMessage(e.getMessage().toString());
			  Log.addMessage("Failed to click Ok button");
			  Assert.assertTrue(false, "Failed to click Ok button");
		}
	}
	
	public void clickLockSoundsButton() {
		try {
		    if(device.equals("iOS")) {
				Utility.waitForElementPresent(lockSnd, appiumDriver);
			}else {
				Utility.waitForElementPresent(lockSndAn, appiumDriver);
			}
			lockSoundsButton.click();
			Log.addMessage("Clicked Lock Sounds Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Lock Sounds button ");
			Assert.assertTrue(false, "Failed to click Lock Sounds button");
		}
	}
	
	public void clickLEDStatusButton() {
		try {
			if(device.equals("iOS")) {
				Utility.waitForElementClickable(lockSnd, appiumDriver);
			}else {
				Utility.waitForTextToBePresent(lockSoundsText, "Lock Sounds");
			}
			Utility.waitForElementToBeClickable(ledStatusButton);
			ledStatusButton.click();
			while(checkSyncPopup()) {
				if(device.equals("iOS")) {
					 Utility.waitForElementPresent(okBtn,appiumDriver);
					 driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Ok']")).click();
					 Utility.waitForElementPresent(lockSnd, appiumDriver);
				}else if(device.equals("android")) {
					 Utility.waitForElementPresent(okAnBtn,appiumDriver);
					 if(driver.findElement(syncPopupAn).getText().equals("Syncing")) {
						 driver.findElement(By.id("android:id/button1")).click();
					 }else {
						 break;
					 }
					 Utility.waitForElementToBeVisible(lockSoundsButton);
				}
				//lockSoundsButton.click();
				ledStatusButton.click();
			}
			Log.addMessage("Clicked LED status Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click LED status button ");
			//Assert.assertTrue(false, "Failed to click LED status button");
		}
	}
	
	public void clickPairedSmartPhonesButton() {
		try {
			Utility.simpleWait(4000);
			Utility.waitForElementToBeVisible(pairedSmartPhones);
			Utility.waitForElementToBeClickable(pairedSmartPhones);
			pairedSmartPhones.click();
			Log.addMessage("Clicked Paired SmartPhones Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Paired SmartPhones button ");
			Assert.assertTrue(false, "Failed to click Paired SmartPhones button");
		}
	}
	
	/** 
	* Method Name: getLockName(), 
	* This function is used to get Lock Name
	*/
	public void getLockName(String lockName) {
		try {
			Utility.waitForTextToBePresent(lockSoundsText, "Lock Sounds");
			Utility.waitForElementToBeVisible(mnLockName);
			lkName = mnLockName.getText();
			Assert.assertEquals(lkName, lockName,"Lock Name of the Home is matching.");
			Log.addMessage("Lock Name of the Home is matching.");
		}catch(Exception e) {
			Log.addMessage("Lock Name of the Home is not visible");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Lock Name of the Home is not visible");
		}
	}
	
	/** 
	* Method Name: getAutoLockStatus(), 
	* This function is used to get Auto Lock Status
	*/
	public void getAutoLockStatus(String lockAuto) {
		try {
			Utility.waitForTextToBePresent(lockSoundsText, "Lock Sounds");
			if(device.equals("iOS")) {
				lkStatus = lockStatusNm.getText();
			}else {
				lkStatus = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,\""+lockAuto+"\")]")).getText();
			}
			Assert.assertEquals(lkStatus, lockAuto,"Auto Lock Status of the Home is "+lkStatus);
			Log.addMessage("Auto Lock Status of the Home is "+lkStatus);
		}catch(Exception e) {
			Log.addMessage("Auto Lock Status not matching");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Auto Lock Status not matching");
		}
	}
	
	/** 
	* Method Name: getAutoLockStts(), 
	* This function is used to get Auto Lock Status
	*/
	public String getAutoLockStts() {
		try {
			Utility.waitForTextToBePresent(lockSoundsText, "Lock Sounds");
			lkStatus = lockStatusNm.getText().trim();
			Log.addMessage("Auto Lock Status of the Home is "+lkStatus);
		}catch(Exception e) {
			Log.addMessage("Auto Lock Status not matching");
			lkStatus ="";
			//System.out.println(e.getMessage().toString());
		}
		return lkStatus;
		
	}
	
	/** 
	* Method Name: checkSyncPopup(), 
	* This function is used to check for a syncing popup
	*/
	public boolean checkSyncPopup() throws InterruptedException {
		try {
			if(device.equals("iOS")) {
				Utility.waitForElementPresent(syncPopup, appiumDriver);
			}else {
				Utility.waitForElementPresent(syncPopupAn, appiumDriver);
			}
		    okButtonPresent=true;
		    Log.addMessage("Ok button found, syncing in progress");
		    return okButtonPresent;
		}catch(NoSuchElementException e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to display Ok button");
			okButtonPresent=false;
			return okButtonPresent;
		}
	}
	
	/** 
	* Method Name: getLockSoundStatus(), 
	* This function is used to get lock Sound Status
	*/
	public void getLockSoundStatus(String lkSndStts) {
		try {
			Utility.waitForTextToBePresent(lockSoundsText, "Lock Sounds");
			lkSound = lockSndLEDStatus.get(0).getText();
			if(device.contentEquals("iOS")) {
				if(lkSound.equals("0")) {
					lkSound="Off";
				}else
					lkSound="On";
			}
			Assert.assertEquals(lkSound, lkSound,"Lock Sounds set to "+lkSound);
			Log.addMessage("Lock Sounds set to "+lkSound);
		}catch(Exception e) {
			Log.addMessage("Lock Sounds not visible");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Lock Sounds not visible");
		}
	}
		
		/** 
		* Method Name: getAudioStatus(), 
		* This function is used to get lock Sound Status
		*/
		public String getAudioStatus() {
			try {
				Utility.waitForElementToBeVisible(lockSndLEDStatus.get(0));
				lkSound = lockSndLEDStatus.get(0).getText();
				if(device.contentEquals("iOS")) {
					if(lkSound.equals("0")) {
						lkSound="Off";
					}else
						lkSound="On";
				}
				Log.addMessage("Lock Sounds set to "+lkSound);
			}catch(Exception e) {
				Log.addMessage("Lock Sounds not visible");
				System.out.println(e.getMessage().toString());
			}
			return lkSound;
			
	}
		
	/** 
	* Method Name: getBatteryPercentage(), 
	* This function is used to get lock battery percentage
	*/
	public String getBatteryPercentage() {
		try {
			Utility.simpleWait(3000);
			Utility.waitForElementToBeVisible(batteryPercent);
			lkbatteryPercent = batteryPercent.getText();
			Log.addMessage("Lock battery percentage in lock settings page is "+lkbatteryPercent);
		}catch(Exception e) {
			Log.addMessage("Lock battery percentage in lock settings page not visible");
			System.out.println(e.getMessage().toString());
		}
		return lkbatteryPercent;
	}
		
	/** 
	* Method Name: getLEDStatus(), 
	* This function is used to get lock LED Status
	*/
	public String getLEDStatus() {
		try {
			Utility.simpleWait(3000);
			if(device.equals("iOS")) {
				lkSound = lockSndLEDStatus.get(1).getAttribute("value");
				if(lkSound.equals("0")) {
					lkSound="Off";
				}else
					lkSound="On";
			}else {
				lkSound = lockSndLEDStatus.get(1).getText();
			}
			Log.addMessage("Lock LED status set to "+lkSound);
		}catch(Exception e) {
			Log.addMessage("Lock LED status not visible");
			System.out.println(e.getMessage().toString());
		}
		return lkSound;
	}
	
	/** 
	* Method Name: getLockLEDStatus(), 
	* This function is used to get Lock LED Status
	*/
	public void getLockLEDStatus(String lkLEDStts) {
		try {
			Utility.waitForTextToBePresent(lockSoundsText, "Lock Sounds");
			lkLED = lockSndLEDStatus.get(1).getText();
			if(device.contentEquals("iOS")) {
				if(lkLED.equals("0")) {
					lkLED="Off";
				}else
					lkLED="On";
			}
			Assert.assertEquals(lkLED, lkLEDStts,"Lock LED status set to ON.");
			Log.addMessage("Lock LED status set to ON");
		}catch(Exception e) {
			Log.addMessage("Lock LED status not visible");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Lock LED status not visible");
		}
	}
	
	/** 
	* Method Name: getLockSettingsList(), 
	* This function is used to get locks current settings
	*/
	public void getLockSettingsList(String lkName,String lkSound, String lkLED, String lkAuto) {
		 try {
			 Utility.simpleWait(3000);
			 getLockName(lkName);
			 getLockSoundStatus(lkSound);
			 getLockLEDStatus(lkLED);
			 getAutoLockStatus(lkAuto);
		 }catch(Exception e) {
				Log.addMessage("Lock settings are visible");
				System.out.println(e.getMessage().toString());
				Assert.assertTrue(false, "Lock settings are visible");
			}
		
	}
	
	/** 
	* Method Name: valWifiOffMessage(), 
	* This function is used to get pop up messge when Wifi is off
	*/
	public void valWifiOffMessage(String actMessage) {
		 try {
			 toastMessage=confirmToastMsg.getAttribute("name");
			 Assert.assertEquals(actMessage, toastMessage,"Please check the validation message.");
			 Log.addMessage("Wifi Off popup dispalyed");
		 
		 }catch(Exception e) {
				Log.addMessage("Failed to dispaly wifi off pop up message");
				System.out.println(e.getMessage().toString());
				Assert.assertTrue(false, "Failed to dispaly wifi off pop up message");
			}
		
	}
	/** 
	* Method Name: getLockName(), 
	* This function is used to get Lock Name
	*/
	public String getLockName() {
		try {
			Utility.simpleWait(6000);
			//System.out.println("lock name=");
			//Utility.waitForElementToBeVisible(mnLockName);
			Utility.waitForElementToBeVisible(lockNameDisp);
			lkName = lockNameDisp.getText();
			//System.out.println("lock name="+lkName);
			//Assert.assertEquals(lkName, lockName,"Lock Name of the Home is matching.");
			
			Log.addMessage("Lock Name of the Home is matching.");
		}catch(Exception e) {
			Log.addMessage("Lock Name of the Home is not visible");
			System.out.println(e.getMessage().toString());
			//Assert.assertTrue(false, "Lock Name of the Home is not visible");
		}
		return lkName;
		
	}
	
	//added on 23-06-2020
	public void verifyPopUpVerbiage(String expTitle, String expMessage) {
		try {
			Utility.waitForElementToBeVisible(popUpTitleVerbiage);
			actTitle = popUpTitleVerbiage.getText();
			Assert.assertEquals(actTitle, expTitle,"Title message is not matching");
			Utility.waitForElementToBeVisible(popUpMessageVerbiage);
			actMessage = popUpMessageVerbiage.getText();
			System.out.println("exptitleMsg="+expTitle+",xptitleMsg="+actTitle+",expmainMsg="+expMessage+",mainMsg="+actMessage);
			/*if(device.contentEquals("iOS")) {//added on 22-05-2020
				Assert.assertEquals(actMessage, iosMessage,"Content message is not matching");
			}else {*/
				
				Assert.assertEquals(actMessage, expMessage,"Content message is not matching");
			//}
			OkButton.click();
			Log.addMessage("Pop up verbiage is matching");
		}catch(Exception e) {
			Log.addMessage("Pop up verbiage is not matching");
			Assert.assertTrue(false, "Pop up verbiage is not matching");
		}
	}
	/** 
	* Method Name: getPairedSmartPhones(), 
	* This function is used to get Paired Smart Phone List
	*/
	/*public void getPairedSmartPhones() {
		try {
			Utility.simpleWait(3000);
			Utility.waitForElementToBeVisible(lockPairList);
			Utility.waitForElementToBeClickable(lockPairList);
			lockPairList.click();
			
			Log.addMessage("Lock Paired smart phones clicked");
		}catch(Exception e) {
			Log.addMessage("Lock Paired smart phones not visible");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Lock Paired smart phones not visible");
		}
		
	}*/
	
	/*    added on 04-09-2020 */
	
	@Test
	public void verifyLockSettingsUI() {
		try {
			Utility.waitForElementToBeVisible(mnLockName);
			Log.addMessage("Lock name is displayed");
			Utility.waitForElementToBeVisible(editLockName);
			Log.addMessage("Edit lock name option is displayed");
			Utility.waitForElementToBeVisible(autoLockButton);
			Log.addMessage("Auto lock status is displayed");
			Utility.waitForElementToBeVisible(lockSndLEDStatus.get(0));
			Log.addMessage("Lock sounds is displayed");
			Utility.waitForElementToBeVisible(lockSndLEDStatus.get(1));
			Log.addMessage("LED status is displayed");
			Utility.waitForElementToBeVisible(pairedSmartPhones);
			Log.addMessage("Paired smart phones option is displayed");
			Utility.waitForElementToBeVisible(lockInfoButton);
			Log.addMessage("Lock info option is displayed");
			Utility.waitForElementToBeVisible(identifyLock);
			Log.addMessage("Identify lock option is displayed");
			Log.addMessage("Lock settings UI is displayed");
		}catch(Exception e) {
			Log.addMessage("Lock Back button functionality failed");
			e.printStackTrace();
			Assert.assertTrue(false, "Lock Back button functionality failed");
		}
	}
	
	public void waitForSync() throws InterruptedException {
		try {
			Utility.waitForTextToBePresent(lockSettingsLoad,"Access Disabled");
			Log.addMessage("Access disabled for user profile");
		}catch(Exception e) {
			Log.addMessage("Failed to disable access for user profile");
			Assert.assertTrue(false, "Failed to disable access for user profile");
		}
	}

	public void waitForSettings() throws InterruptedException {
		try {
			if(device.equals("android")) {
				Utility.waitForTextToBePresentBy("//android.widget.TextView[@text='Paired Smartphones']", "Paired Smartphones");
			}else {
				//Utility.simpleWait(3000);
				Utility.waitForTextToBePresentBy("//XCUIElementTypeStaticText[@name='Paired Smartphones']", "Paired Smartphones");
				//System.out.println("two");
			}
			Log.addMessage("Loaded settings page");
		}catch(Exception e) {
			Log.addMessage("Failed to load settings page");
			Assert.assertTrue(false, "Failed to load settings page");
		}
	}

}
