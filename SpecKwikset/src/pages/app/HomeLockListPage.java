package pages.app;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
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

public class HomeLockListPage extends Settings  {
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Manage Home Users'])[1]")
	@AndroidFindBy(xpath = "(//androidx.recyclerview.widget.RecyclerView//android.widget.LinearLayout)[1]")
	@CacheLookup
	private MobileElement lockName;
		
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=' Back']")
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/cancelAllhomes")
	@CacheLookup
	private MobileElement backButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText")
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/info")
	@CacheLookup
	private MobileElement infoIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText")
	@AndroidFindBy(xpath="//android.widget.Toast[1]")
	@CacheLookup
	private MobileElement confirmToastMsg;
	
	@iOSXCUITFindBy(id = "Ok")
	@AndroidFindBy(id = "android:id/button1")
	@CacheLookup
	private MobileElement OkButton;
	
	
	String actualRes, toastMessage, lkTxtName="";
	
	//Constructor
	@SuppressWarnings("static-access")
	public HomeLockListPage(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
		
	/** 
	* Method Name: slectOneLock(), 
	* This function is used to select lock from the manage homes page
	*/
		
	public void slectOneLock() {
		try {
			Thread.sleep(3000);
			System.out.println("in  clear enter lock name");
			lockName.click();
			Log.addMessage("Selected a lock");
		}catch(Exception e) {
			Log.addMessage("Failed to select a lock");
			Assert.assertTrue(false, "Failed to select a lock");
		}
	}
	
	/** 
	* Method Name: clickBackButton(), 
	* This function is used to click Back button from Add lock name page
	*/
		
	public void clickBackButton() {
		try {
			Thread.sleep(6000);
			System.out.println("in lockname backmthd");
			Utility.waitForElementToBeVisible(backButton);
			Utility.waitForElementToBeClickable(backButton);
			System.out.println("inside clickBackButton");
			backButton.click();
			System.out.println("clicked clickBackButton");
			Log.addMessage("Clicked Back Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Back button");
			Assert.assertTrue(false, "Failed to click Back button");
		}
	}
	
	public void verifyUILockListPage() {
		try {
			Thread.sleep(3000);
			Utility.waitForElementToBeVisible(infoIcon);
			Log.addMessage("Delete lock info is visible");
			Utility.waitForElementToBeVisible(lockName);
			Log.addMessage("Lock name is visible");
			Utility.waitForElementToBeVisible(backButton);
			Log.addMessage("Back button is visible");
			Thread.sleep(2000);
			Assert.assertTrue(true, "All UI elements are not visible");
			Log.addMessage("All UI elements are visible");
		}catch(Exception e) {
			Log.addMessage("All UI elements are not visible");
			Assert.assertTrue(false, "All UI elements are not visible");
		}
	}
	
	/** 
	* Method Name: clickOkButton(), 
	* This function is used to click OK button from Add lock name page
	*/
		
	public void clickOkButton() {
		try {
			Thread.sleep(6000);
			System.out.println("in lockname OK");
			Utility.waitForElementToBeVisible(OkButton);
			Utility.waitForElementToBeClickable(OkButton);
			System.out.println("inside OK");
			OkButton.click();
			System.out.println("clicked OKButton");
			Log.addMessage("Clicked OK Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click OK button");
			Assert.assertTrue(false, "Failed to click OK button");
		}
	}
	
	

}
