package pages.app;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import utility.Log;
import utility.Utility;

public class LockNextPage2 extends Settings{
	
	/*         created on 07-05-2020          */
	
	@iOSXCUITFindBy(id = "Next")//added on 18-05-2020
	@AndroidFindBy(id = "com.kwikset.blewifi.dev:id/tv_next")
	@CacheLookup
	private MobileElement nextButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=' Back']")  //added on 16-09-2020
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/cancelAllhomes")
	@CacheLookup
	private MobileElement bkButton;
	
	//Constructor
		@SuppressWarnings("static-access")
		public LockNextPage2(AppiumDriver<MobileElement> driver){
			this.appiumDriver =driver;
			PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
		}
	
	public void clickNext() {
		try {
			Utility.simpleWait(6000);
			Utility.waitForElementToBeVisible(nextButton);
			Utility.waitForElementToBeClickable(nextButton);
			nextButton.click();
			Log.addMessage("Clicked next button");
		}catch(Exception e) {
			Log.addMessage("Failed to click next button");
		}
	}
	
	/** 
	* Method Name: clickBackButton(), 
	* This function is used to click Back button from Add lock name page
	*/
		
	public void clickBkButton() {
		try {
			Thread.sleep(6000);
			System.out.println("in lockname backmthd");
			Utility.waitForElementToBeVisible(bkButton);
			Utility.waitForElementToBeClickable(bkButton);
			System.out.println("inside clickBackButton");
			bkButton.click();
			System.out.println("clicked clickBackButton");
			Log.addMessage("Clicked Back Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Back button");
			Assert.assertTrue(false, "Failed to click Back button");
		}
	}

}
