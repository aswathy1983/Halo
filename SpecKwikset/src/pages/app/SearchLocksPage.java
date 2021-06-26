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

public class SearchLocksPage extends Settings{
	

	@iOSXCUITFindBy(xpath="//XCUIElementTypeCell[1]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/linearlayout"),
		@AndroidBy(id = "com.kwikset.blewifi:id/linearlayout"),
		@AndroidBy(id = "com.spectrum.giga:id/linearlayout"),
		@AndroidBy(id = "com.weiser.blewifi:id/linearlayout")
	})
	@CacheLookup
	private MobileElement LockOneCell;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeCell[1]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/link_text"),
		@AndroidBy(id = "com.kwikset.blewifi:id/link_text"),
		@AndroidBy(id = "com.spectrum.giga:id/link_text"),
		@AndroidBy(id = "com.weiser.blewifi:id/link_text")
	})
	@CacheLookup
	private MobileElement helpFaqLink;
	
	
	
	//added on 07-05-2020
	
	@iOSXCUITFindBy(id = "Back")
	@AndroidFindBy(id = "com.kwikset.blewifi.dev:id/cancelAllhomes")
	@CacheLookup
	private MobileElement backButton;
	
	//Constructor
	@SuppressWarnings("static-access")
	public SearchLocksPage(AppiumDriver<MobileElement> driver) {
	this.appiumDriver = driver;
	PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void selectLockoneCell() {
		try {
			Thread.sleep(6000);
			//System.out.println("in select lock");
			if (device.equals("iOS")) {
				//System.out.println("in ios");
				Thread.sleep(2000);
			}
			LockOneCell.click();
			//System.out.println("in click lock");
			Log.addMessage("Lock One selected");
		}catch(Exception e) {
			Log.addMessage("Failed to select Lock One");
			Assert.assertTrue(false, "Failed to select Lock One");
		}
	}
	
	/*    added on 07-05-2020      */
	/** 
	* Method Name: clickBackButton(), 
	* This function is used to click Back button
	*/
		
	public void clickBackButton() {
		try {
			Thread.sleep(6000);
			backButton.click();
			Log.addMessage("Clicked Back Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Back button");
			Assert.assertTrue(false, "Failed to click Back button");
		}
	}
	/** 
	* Method Name: clickFaqLink(), 
	* This function is used to click Help/Faq link from the search lock Page
	*/
	public void clickFaqLink() {
		try {
			Utility.waitForElementToBeVisible(helpFaqLink);
			helpFaqLink.click();
			Log.addMessage("Clicked Help/FAQ Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Help/FAQ button");
			Assert.assertTrue(false, "Failed to click Help/FAQ button");
		}
	}
	
}

