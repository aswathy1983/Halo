package pages.app;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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

public class ConfirmDeleteLockPage extends Settings{
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Confirm Deletion of Lock']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/llDeleteConfirmLock"),
		@AndroidBy(id = "com.kwikset.blewifi:id/llDeleteConfirmLock"),
		@AndroidBy(id = "com.spectrum.giga:id/llDeleteConfirmLock"),
		@AndroidBy(id = "com.weiser.blewifi:id/llDeleteConfirmLock"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/llDeleteConfirmLock")
	})
	@CacheLookup
	private MobileElement confirmDeleteLockButton;
	
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
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Delete Lock']")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Confirm Deletion of Lock']")
	@CacheLookup
	private MobileElement deleteButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Yes']")
	@AndroidFindBy(id = "android:id/button1")
	@CacheLookup
	private MobileElement yesButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Ok']")
	@AndroidFindBy(id = "android:id/button1")
	@CacheLookup
	private MobileElement okButton;
	
	@iOSXCUITFindBy(id = "Ok")//check xpath
	@AndroidFindBy(id = "android:id/button2")//added on 08-06-2020
	@CacheLookup
	private MobileElement cancelButton;
	
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
	
	
	//Constructor
	@SuppressWarnings("static-access")
	public ConfirmDeleteLockPage(AppiumDriver<MobileElement> driver) {
	this.appiumDriver = driver;
	PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
	
	/** 
	* Method Name: deleteLock(), 
	* This function is used to delete lock
	*/
		
	public void deleteLock() {
		try {
			Utility.waitForElementToBeVisible(confirmDeleteLockButton);
			Utility.waitForElementToBeClickable(confirmDeleteLockButton);
			confirmDeleteLockButton.click();
			Utility.waitForElementToBeVisible(yesButton);
			yesButton.click();
			if (device.equals("android")) {
				Utility.waitForElementToBeVisible(okButton);
				okButton.click();
			}
			Log.addMessage("Lock deleted successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to delete Lock");
			Assert.assertTrue(false, "Failed to delete Lock");
		}
	}
	
	/** 
	* Method Name: clickOKButton(), 
	* This function is used to click OK button
	*/
		
	public void clickOKButton() {
		try {
			Utility.waitForElementToBeVisible(okButton);
			okButton.click();
			Log.addMessage("Lock deleted successfully");
		}catch(Exception e) {
			Log.addMessage("Failed to delete Lock");
			Assert.assertTrue(false, "Failed to delete Lock");
		}
	}
	
	/** 
	* Method Name: clickBackButton(), 
	* This function is used to select Back option from the paired smart phone page
	*/
		
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
	
	/** 
	* Method Name: clickDeleteLockButton(), 
	* This function is used to delete lock from the home 
	*/
		
	public void clickDeleteLockButton() {
		try {
			Utility.waitForElementToBeVisible(deleteButton);
			deleteButton.click();
			Log.addMessage("Clicked Delete Lock Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Delete Lock button ");
			Assert.assertTrue(false, "Failed to click Delete Lock button");
		}
	}
	
	/** 
	* Method Name: clickCancelButton(), 
	* This function is used to click cancel button 
	*/
	public void clickCancelButton() {
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
}
