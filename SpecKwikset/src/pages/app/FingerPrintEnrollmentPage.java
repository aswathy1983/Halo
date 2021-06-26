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

public class FingerPrintEnrollmentPage extends Settings{
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Scan your fingerprint']")
	@AndroidFindBy(id = "com.kwikset.blewifi.dev:id/txtScanTitle")
	@CacheLookup
	private MobileElement scanTitle;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=' Back']")
	@AndroidFindBy(id = "com.kwikset.blewifi.dev:id/cancelAllhomes")
	@CacheLookup
	private MobileElement backButton;
	
	String scanTitleMsg = "";
	
	//Constructor
	@SuppressWarnings("static-access")
	public FingerPrintEnrollmentPage(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}

	/** 
	* Method Name: getFPScanMessage(), 
	* This function is used to get Scan Message displayed in the page 
	*/
	
	public String getFPScanMessage() {
		try {
			Thread.sleep(3000);
			Utility.waitForElementToBeVisible(scanTitle);
			
			scanTitleMsg = scanTitle.getText();
			Log.addMessage("Get schedule type selected");
		} catch (InterruptedException e) {
			Log.addMessage("Failed to display schedule type");
			Assert.assertTrue(false, "Failed to display schedule type");
		}
		return scanTitleMsg;
	}
	
	/** 
	* Method Name: clickBackButton(), 
	* This function is used to click back button 
	*/
	
	public void clickBackButton() {
		try {
			Thread.sleep(3000);
			System.out.println("in fp enroll back");
			//Utility.waitForElementToBeVisible(backButton);
			System.out.println("in fp enroll back u1");
			
			backButton.click();
			System.out.println("in fp enroll back click");
			Log.addMessage("Clicked back button");
		}catch(Exception e) {
			Log.addMessage("Failed to click back button");
			Assert.assertTrue(false, "Failed to click back button");
		}
		
	}
	
}
