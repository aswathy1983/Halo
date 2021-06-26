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

public class NoLocksPage extends Settings{
	

	@iOSXCUITFindBy(xpath="//XCUIElementTypeCell[1]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/txtScanAgain"),
		@AndroidBy(id = "com.kwikset.blewifi:id/txtScanAgain"),
		@AndroidBy(id = "com.spectrum.giga:id/txtScanAgain"),
		@AndroidBy(id = "com.weiser.blewifi:id/txtScanAgain")
	})
	@CacheLookup
	private MobileElement scanAgainButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeCell[1]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/lock_installation_guide"),
		@AndroidBy(id = "com.kwikset.blewifi:id/lock_installation_guide"),
		@AndroidBy(id = "com.spectrum.giga:id/lock_installation_guide"),
		@AndroidBy(id = "com.weiser.blewifi:id/lock_installation_guide")
	})
	@CacheLookup
	private MobileElement lockGuideButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeCell[1]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/help_faq"),
		@AndroidBy(id = "com.kwikset.blewifi:id/help_faq"),
		@AndroidBy(id = "com.spectrum.giga:id/help_faq"),
		@AndroidBy(id = "com.weiser.blewifi:id/help_faq")
	})
	@CacheLookup
	private MobileElement helpFaqButton;
	
	
	
	//added on 07-05-2020
	
	@iOSXCUITFindBy(id = "Back")
	@AndroidFindBy(id = "com.kwikset.blewifi.dev:id/cancelAllhomes")
	@CacheLookup
	private MobileElement backButton;
	
	//Constructor
	@SuppressWarnings("static-access")
	public NoLocksPage(AppiumDriver<MobileElement> driver) {
	this.appiumDriver = driver;
	PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
	
	/** 
	* Method Name: clickScanAgain(), 
	* This function is used to click Scan Again option from the search lock Page
	*/
		
	public void clickScanAgain() {
		try {
			Utility.waitForElementToBeVisible(scanAgainButton);
			//System.out.println("in select lock");
			/*if (device.equals("iOS")) {
				//System.out.println("in ios");
				Thread.sleep(2000);
			}*/
			scanAgainButton.click();
			//System.out.println("in click lock");
			Log.addMessage("Clicked Scan Again");
		}catch(Exception e) {
			Log.addMessage("Failed to click Scan Again");
			Assert.assertTrue(false, "Failed to click Scan Again");
		}
	}
	
	/** 
	* Method Name: verifyNoLocksUIPage(), 
	* This function is used to click Lock Installation Guide link from the search lock Page
	*/
		
	public void verifyNoLocksUIPage() {
		try {
			Utility.waitForElementToBeVisible(scanAgainButton);
			Utility.waitForElementToBeVisible(lockGuideButton);
			Utility.waitForElementToBeVisible(helpFaqButton);
			Utility.waitForElementToBeVisible(backButton);
			//System.out.println("in click lock");
			Log.addMessage("All UI elemnets in nolocks found page are listed");
		}catch(Exception e) {
			Log.addMessage("Failed to list all UI elements in nolocks found page");
			Assert.assertTrue(false, "Failed to list all UI elements in nolocks found page");
		}
	}
	
	/** 
	* Method Name: clickInstallationGuide(), 
	* This function is used to click Lock Installation Guide link from the search lock Page
	*/
		
	public void clickInstallationGuide() {
		try {
			Utility.waitForElementToBeVisible(lockGuideButton);
			lockGuideButton.click();
			//System.out.println("in click lock");
			Log.addMessage("Clicked lock installation guide");
		}catch(Exception e) {
			Log.addMessage("Failed to click lock installation guide");
			Assert.assertTrue(false, "Failed to click lock installation guide");
		}
	}
	
	/** 
	* Method Name: clickHelpFaq(), 
	* This function is used to click Help/Faq link from the search lock Page
	*/
		
	public void clickHelpFaq() {
		try {
			Utility.waitForElementToBeVisible(lockGuideButton);
			lockGuideButton.click();
			//System.out.println("in click lock");
			Log.addMessage("Clicked lock installation guide");
		}catch(Exception e) {
			Log.addMessage("Failed to click lock installation guide");
			Assert.assertTrue(false, "Failed to click lock installation guide");
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
	* Method Name: clickHelpFaq(), 
	* This function is used to click Help/Faq link from the search lock Page
	*/
	public void clickFaqLink() {
		try {
			Utility.waitForElementToBeVisible(helpFaqButton);
			helpFaqButton.click();
			Log.addMessage("Clicked Help/FAQ Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Help/FAQ button");
			Assert.assertTrue(false, "Failed to click Help/FAQ button");
		}
	}
	
}

