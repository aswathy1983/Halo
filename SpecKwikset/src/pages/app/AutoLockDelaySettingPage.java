package pages.app;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

public class AutoLockDelaySettingPage extends Settings{
	
	//commented on 09-06-2020 as was not working for fp lock
	//@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[@name='Auto Lock Delay, Auto test']/XCUIElementTypeSwitch")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeSwitch")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/switch_autotimer_screen"),
		@AndroidBy(id = "com.kwikset.blewifi:id/switch_autotimer_screen"),
		@AndroidBy(id = "com.spectrum.giga:id/switch_autotimer_screen"),
		@AndroidBy(id = "com.weiser.blewifi:id/switch_autotimer_screen"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/switch_autotimer_screen")
	})
	@CacheLookup
	private MobileElement autoLockDelayToggleButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeTable/XCUIElementTypeSwitch")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/switch_autotimer_screen"),
		@AndroidBy(id = "com.kwikset.blewifi:id/switch_autotimer_screen"),
		@AndroidBy(id = "com.spectrum.giga:id/switch_autotimer_screen"),
		@AndroidBy(id = "com.weiser.blewifi:id/switch_autotimer_screen"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/switch_autotimer_screen")
	})
	@CacheLookup
	private MobileElement autoLockDlTogBtn;
	
	//MobileElement autoLockTogBtn = driver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`name==\"Lock Sounds\"`]"));
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Lock Sounds']/following-sibling::android.widget.Switch")//added on 08-06-2020
	@CacheLookup
	private MobileElement lockSoundsButton;
	
	@iOSXCUITFindBy(id = "30 Seconds")
	@AndroidFindBy(xpath = "(//androidx.recyclerview.widget.RecyclerView//android.widget.RelativeLayout)[1]")
	@CacheLookup
	private MobileElement sec_30;
	
	@iOSXCUITFindBy(id = "1 Minute")
	@AndroidFindBy(xpath = "(//androidx.recyclerview.widget.RecyclerView//android.widget.RelativeLayout)[2]")
	@CacheLookup
	private MobileElement min_1;
	
	@iOSXCUITFindBy(id = "3 Minutes")
	@AndroidFindBy(xpath = "(//androidx.recyclerview.widget.RecyclerView//android.widget.RelativeLayout)[3]")
	@CacheLookup
	private MobileElement min_3;
	
	@iOSXCUITFindBy(id = "5 Minutes")
	@AndroidFindBy(xpath = "(//androidx.recyclerview.widget.RecyclerView//android.widget.RelativeLayout)[4]")
	@CacheLookup
	private MobileElement min_5;
	
	@iOSXCUITFindBy(id = "10 Minutes")
	//@AndroidFindBy(xpath = "(//android.support.v7.widget.RecyclerView//android.widget.RelativeLayout)[5]")//commented on 06-10-2020
	@AndroidFindBy(xpath = "(//androidx.recyclerview.widget.RecyclerView//android.widget.RelativeLayout)[5]")
	@CacheLookup
	private MobileElement min_10;	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='10 Minutes']/following-sibling::XCUIElementTypeImage")
	@CacheLookup
	private MobileElement min_10_stat;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/cancelAllhomes"),
		@AndroidBy(id = "com.kwikset.blewifi:id/cancelAllhomes"),
		@AndroidBy(id = "com.spectrum.giga:id/cancelAllhomes"),
		@AndroidBy(id = "com.weiser.blewifi:id/cancelAllhomes"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/cancelAllhomes")
	})
	@CacheLookup
	private MobileElement backButton;
	
	@iOSXCUITFindBy(id = "Ok")
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
	
	By autoTogBtn =By.xpath("//XCUIElementTypeTable/XCUIElementTypeSwitch");
	//below for QA and prod
	//By autoTogBtnAn =By.id("com.kwikset.blewifi.dev:id/switch_autotimer_screen");
	//below for beta
	///By autoTogBtnAn =By.id("com.spectrum.giga:id/switch_autotimer_screen");
	By autoTogBtnAn =By.xpath("(//android.widget.Switch)[1]");//added on 29-03-2021
	By autoLockPopup = By.xpath("//XCUIElementTypeAlert//XCUIElementTypeStaticText[@name='Sync Failed']");
	By autoLockPopupAn =By.xpath("//*[@text='Sync Failed']");
	By autoLockText = By.xpath("//XCUIElementTypeStaticText[@name='Auto Lock Delay']");
	By min10 = By.id("10 Minutes");
	By min10An = By.xpath("(//androidx.recyclerview.widget.RecyclerView//android.widget.RelativeLayout)[5]");
	By okBtn= By.xpath("//XCUIElementTypeButton[@name='Ok']");
	By okAnBtn= By.id("android:id/button1");
	By autoLockBtn = By.id("autoLockButton");
	By ledStsBtn = By.xpath("//XCUIElementTypeSwitch[@name='LED Status']");
	By syncPopup= By.xpath("//XCUIElementTypeAlert//XCUIElementTypeStaticText[@name='Syncing']");
	//By syncPopupAn= By.xpath("//*[@resource-id='android:id/alertTitle']");
	By syncPopupAn = By.xpath("//*[@text='Syncing']");
	
	String actTitle, actMessage, delayStatus, delayName="";
	Boolean okButtonPresent = false;
	
	
	//Constructor
	@SuppressWarnings("static-access")
	public AutoLockDelaySettingPage(AppiumDriver<MobileElement> driver) {
	this.appiumDriver = driver;
	PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
	
	public void clickAutoLock() {
		try {
			//Thread.sleep(6000);//commented for Halo bvt 23 oct 2020
			//System.out.println("one");
			if(device.equals("iOS")) {
				Utility.waitForElementPresent(autoTogBtn, appiumDriver);
				//System.out.println("autoTogBtn present");
				Utility.waitForElementClickable(autoTogBtn, appiumDriver);
				
			}else {
				//System.out.println("autoTogBtnAn");
				Utility.waitForElementPresent(autoTogBtnAn, appiumDriver);
				//Utility.waitForElementToBeVisible(autoLockDelayToggleButton);
				//System.out.println("autoTogBtnAn present");
				//Utility.waitForElementToBeClickable(autoLockDelayToggleButton);
					
			}
			//System.out.println("autoTogBtn clickable");
			autoLockDelayToggleButton.click();
			//System.out.println("autoLockDelayToggleButton clicked");
			//Utility.simpleWait(7000);
			if(device.equals("iOS")) {
				Utility.waitForElementPresent(autoTogBtn, appiumDriver);
				//System.out.println("two");
			}/*else {
				Utility.waitForElementToBeVisible(autoLockDelayToggleButton);
				System.out.println("two");
				//Utility.waitForElementToBeClickable(autoLockDelayToggleButton);
				System.out.println("three");	
			}*/
			//System.out.println("three");	
			Log.addMessage("Auto Lock ");
		}catch(Exception e) {
			Log.addMessage("Failed to delete Lock");
			Assert.assertTrue(false, "Failed to delete Lock");
		}
	}
	
	/** 
	* Method Name: clickAutoLockOff(), 
	* This function is used to select Email option from the MFA Page
	*/
	
	public void clickAutoLockOff() {
		try {
			if(device.equals("iOS")) {
				Utility.waitForElementPresent(autoTogBtn, appiumDriver);
				//System.out.println("autoTogBtn present");
				Utility.waitForElementClickable(autoTogBtn, appiumDriver);
				
			}else {
				//System.out.println("autoTogBtnAn");
				Utility.waitForElementPresent(autoTogBtnAn, appiumDriver);
			}
			autoLockDlTogBtn.click();
			if(device.equals("iOS")) {
				Utility.waitForElementPresent(autoTogBtn, appiumDriver);
			}	
			Log.addMessage("Auto Lock ");
		}catch(Exception e) {
			Log.addMessage("Failed to set auto lock toggle button to off");
			//Assert.assertTrue(false, "Failed to click auto lock toggle button");
		}
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
	
	public String getAutoDelayStatus() {
		try {
			if(device.equals("iOS")) {
				Utility.waitForElementPresent(autoTogBtn, appiumDriver);
				//Utility.waitForElementClickable(autoTogBtn, appiumDriver);
			}else {
				//Utility.waitForElementToBeVisible(autoLockDelayToggleButton);
				Utility.waitForElementPresent(autoTogBtnAn, appiumDriver);
				//Utility.waitForElementToBeClickable(autoLockDelayToggleButton);
			}
			delayStatus = autoLockDelayToggleButton.getText();
			Log.addMessage("Auto Lock Status is:"+delayStatus);
			return delayStatus;
		}catch(Exception e) {
			Log.addMessage("Failed to get Auto Lock Status");
			//System.out.println("autodelaystat2 in catch");
			delayStatus = "N";//added to catch null pointer exception
			return delayStatus;
		}
	}
	
		
	public void set_30Sec_Delay() {
		try {
			if(device.equals("iOS")) {
				Utility.waitForElementPresent(autoTogBtn, appiumDriver);
				Utility.waitForElementClickable(autoTogBtn, appiumDriver);
			}else {
				Utility.waitForElementToBeVisible(autoLockDelayToggleButton);
				Utility.waitForElementToBeClickable(autoLockDelayToggleButton);
			}
			sec_30.click();
			while(checkSyncPopup()) {
				//System.out.println("checkOkButton="+checkOkButton());
				if(device.equals("iOS")) {
					 Utility.waitForElementPresent(okBtn,appiumDriver);
					 driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Ok']")).click();
					 Utility.waitForElementPresent(ledStsBtn, appiumDriver);
				}else if(device.equals("android")) {
					 Utility.waitForElementPresent(okAnBtn,appiumDriver);
					 if(driver.findElement(syncPopupAn).getText().equals("Syncing")) {
						 driver.findElement(By.id("android:id/button1")).click();
					 }else {
						 System.out.println("in sync fail");
						 break;
					 }
					 Utility.waitForElementToBeVisible(lockSoundsButton);
				}
				sec_30.click();
			}
			Log.addMessage("Lock will be automatically locked after 30 seconds");
		}catch(Exception e) {
			Log.addMessage("Failed to set 30 sec auto Lock");
			//Assert.assertTrue(false, "Failed to set 30 sec auto Lock");
		}
	}
	
	public void set_1min_Delay() {
		try {
			Thread.sleep(6000);
			min_1.click();
			Utility.simpleWait(7000);
			Log.addMessage("Lock will be automatically locked after 1 minute");
		}catch(Exception e) {
			Log.addMessage("Failed to set 1 min auto Lock");
			Assert.assertTrue(false, "Failed to set 1 min auto Lock");
		}
	}
	
	public void set_3min_Delay() {
		try {
			Thread.sleep(6000);
			min_3.click();
			Utility.simpleWait(7000);
			Log.addMessage("Lock will be automatically locked after 3 minutes");
		}catch(Exception e) {
			Log.addMessage("Failed to set 3 min auto Lock");
			Assert.assertTrue(false, "Failed to set 3 min auto Lock");
		}
	}
	
	public void set_5min_Delay() {
		try {
			Thread.sleep(7000);
			min_5.click();
			Utility.simpleWait(7000);
			Log.addMessage("Lock will be automatically locked after 5 minutes");
		}catch(Exception e) {
			Log.addMessage("Failed to set 5 min auto Lock");
			Assert.assertTrue(false, "Failed to set 5 min auto Lock");
		}
	}
	
	public void set_10min_Delay() {
		try {
			if(device.equals("iOS")) {
				//System.out.println("one in 10mindelay");
				Utility.waitForElementPresent(autoTogBtn, appiumDriver);
				//System.out.println("two");
				Utility.waitForElementClickable(autoTogBtn, appiumDriver);
			}else {
				//System.out.println("one");
				Utility.simpleWait(6000);//added on 27 Apr 21 for Aura Lock
				Utility.waitForElementToBeVisible(autoLockDelayToggleButton);
				//System.out.println("two");
				Utility.waitForElementToBeClickable(autoLockDelayToggleButton);
			}
			//System.out.println("onemin_10");
			min_10.click();
			//System.out.println("four");
			while(checkSyncPopup()) {
				//System.out.println("checkOkButton="+checkOkButton());
				if(device.equals("iOS")) {
					 Utility.waitForElementPresent(okBtn,appiumDriver);
					 driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Ok']")).click();
					 Utility.waitForElementPresent(autoTogBtn, appiumDriver);
				}else if(device.equals("android")) {
					 Utility.waitForElementPresent(okAnBtn,appiumDriver);
					 if(driver.findElement(syncPopupAn).getText().equals("Syncing")) {
						 driver.findElement(By.id("android:id/button1")).click();
					 }else {
						 break;
					 }
					 Utility.waitForElementPresent(min10An, appiumDriver);
				}
				if(device.equals("iOS")) {
					Utility.waitForElementPresent(autoTogBtn, appiumDriver);
					Utility.waitForElementClickable(autoTogBtn, appiumDriver);
				}else {
					Utility.waitForElementPresent(autoTogBtnAn, appiumDriver);
				}
				min_10.click();
				//System.out.println("popuptwo");
			}
			Log.addMessage("Lock will be automatically locked after 10 minutes");
		}catch(Exception e) {
			Log.addMessage("Failed to set 10 min auto Lock");
			//System.out.println("in set_10_min delay catch");
			//commented on 12-11-2020
			//Assert.assertTrue(false, "Failed to set 10 min auto Lock");
		}
	}
	
	public void checkAutoLockOff()  {
		try {
		    if(device.equals("iOS")) {
		    	Utility.waitForElementPresent(autoLockPopup,appiumDriver);
		    }else {
		    	Utility.waitForElementPresent(autoLockPopupAn,appiumDriver);
		    }
		    Utility.waitForElementToBeVisible(OkButton);
		    OkButton.click();
		    if(device.equals("iOS")) {
			    Utility.waitForElementPresent(autoLockText,appiumDriver);
			    clickBackButton();
			    Log.addMessage("Back button found in auto lock off");
		    }
		}catch(Exception e) {
			System.out.println("in catch AutoLock");
			Log.addMessage("Returned to lock settings page");
		}
	}
	
	public void checkInAutoLockPage()  {
		try {
		    if(device.equals("iOS")) {
			    Utility.waitForElementPresent(autoLockText,appiumDriver);
			    clickBackButton();
			    Log.addMessage("Back button found in auto lock off");
		    }
		}catch(Exception e) {
			//System.out.println("in catch");
			Log.addMessage("Returned to lock settings page");
		}
	}
	
	public boolean checkOkButton() throws InterruptedException {
		try {
			if(device.equals("iOS")) {
				 Utility.waitForElementPresent(okBtn,appiumDriver);
			}else {
				 Utility.waitForElementPresent(okAnBtn,appiumDriver);
			}
		    okButtonPresent=true;
		    Log.addMessage("Ok button found, syncing in progress");
		    return okButtonPresent;
		}catch(NoSuchElementException e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to display Ok button");
			//System.out.println("in catch");
			okButtonPresent=false;
			return okButtonPresent;
		}
	}
	
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
	
	public void selectTimeDelay(String time) {
		try {
			Thread.sleep(6000);
			switch(time) {
			
			case "1" : sec_30.click();
			break;
							
			case "2" : min_1.click();
			break;
			
			case "3" : min_3.click();
			break;
			
			case "4" : min_5.click();
			break;
			
			case "5" : min_10.click();
			break;
			
			default: min_10.click();
			break;
							
			}
		  Log.addMessage("Selected time delay is: "+time);
		}catch(Exception e) {
			Log.addMessage("Failed to select a time delay");
			Assert.assertTrue(false, "Failed to select a time delay");
		}
	}
	//added on 23-06-2020
	public void verifyPopUpVerbiage(String expTitle, String expMessage, String iosMessage) {
		try {
			Utility.waitForElementToBeVisible(popUpTitleVerbiage);
			actTitle = popUpTitleVerbiage.getText();
			Assert.assertEquals(actTitle, expTitle,"Title message is not matching");
			Utility.waitForElementToBeVisible(popUpMessageVerbiage);
			actMessage = popUpMessageVerbiage.getText();
			System.out.println("exptitleMsg="+expTitle+",xptitleMsg="+actTitle+",expmainMsg="+expMessage+",mainMsg="+actMessage);
			if(device.contentEquals("iOS")) {//added on 22-05-2020
				Assert.assertEquals(actMessage, iosMessage,"Content message is not matching");
			}else {
				Assert.assertEquals(actMessage, expMessage,"Content message is not matching");
			}
			OkButton.click();
			Log.addMessage("Pop up verbiage is matching");
		}catch(Exception e) {
			Log.addMessage("Pop up verbiage is not matching");
			Assert.assertTrue(false, "Pop up verbiage is not matching");
		}
	}

	
	public void clickBackButton() {
		try {
			Utility.waitForElementToBeVisible(backButton);
			backButton.click();
			Log.addMessage("Clicked Back Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Back button ");
			Assert.assertTrue(false, "Failed to click Back button");
		}
	}
	
	public void clickAutoLockBackButton() {
		try {
			if(device.equals("iOS")) {
				Utility.waitForElementPresent(autoTogBtn,appiumDriver);
			}else {
				Utility.waitForElementPresent(autoTogBtnAn,appiumDriver);
			}
			Utility.waitForElementToBeVisible(backButton);
			backButton.click();
			Log.addMessage("Clicked Back Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Back button ");
			//Assert.assertTrue(false, "Failed to click Back button");
		}
	}
	
}
