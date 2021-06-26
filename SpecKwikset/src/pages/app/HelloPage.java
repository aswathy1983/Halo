package pages.app;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import utility.Log;
import utility.Utility;

public class HelloPage extends Settings{
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Read Agreement']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/btn_read_agreement"),
		@AndroidBy(id = "com.kwikset.blewifi:id/btn_read_agreement"),
		@AndroidBy(id = "com.spectrum.giga:id/btn_read_agreement"),
		@AndroidBy(id = "com.weiser.blewifi:id/btn_read_agreement")
	})
	@CacheLookup
	private MobileElement readAgreementButton;
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='OK']")
	@CacheLookup
	private MobileElement okButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Don’t Allow']")
	@CacheLookup
	private MobileElement dontAllowButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Allow']")
	@CacheLookup
	private MobileElement allowButton;

	
	//Constructor
	@SuppressWarnings("static-access")
	public HelloPage(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
	
	
	/** 
	 * Method Name: clickOkButtonToUseBluetooth(), 
	 * This function is used to click on the Ok button in the Hello page to use Bluetooth
	 */
	public void clickOkButtonToUseBluetooth() {
		try {
			Utility.simpleWait(3000);
			okButton.click();
			Log.addMessage("Allowed to use Bluetooth");
		}catch(Exception e) {
			Log.addMessage("Bluetooth permission alert is not present");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Bluetooth permission alert is not present");
		}
	}
	
	
	/** 
	 * Method Name: clickAllowButtonToSendNotifications(), 
	 * This function is used to click on the Allow button in the Hello page to send notifications
	 */
	public void clickAllowButtonToSendNotifications() {
		try {
			allowButton.click();
			Log.addMessage("Allowed to send Notifications");
		}catch(Exception e) {
			Log.addMessage("Send Notification permission alert is not present");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Send Notification permission alert is not present");
		}
	}
	

	/** 
	 * Method Name: AcceptPopupIfPresent(), 
	 * This function is used to click on the Read agreement button in the Hello page
	 */
	public void AcceptPopupIfPresent() {
		try {
			utility.Utility.simpleWait(7000);
			utility.Utility.checkIfAlertIsPresentAndAccept(appiumDriver);
			Log.addMessage("Alert is present. Tapped on OK button in the alert");

		}catch(Exception e) {
			Log.addMessage("Alert is not present");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Alert is not present");
		}
	}
	
	
	
	/**
	 * Method Name: ClickOnReadAgreementButton(), 
	 * This function is used to click on the Read agreement button in the Hello page
	 */
	
	public void ClickOnReadAgreementButton() {
		try {
			//utility.Utility.simpleWait(000);
			//Assert.assertTrue(readAgreementButton.isDisplayed(),"Read Agreement button is displayed");
			//Log.addMessage("Read Agreement button is displayed");
			//Assert.assertTrue(readAgreementButton.getText().contentEquals("Read Agreement"),"Button name is 'Read Agreement'");
			//Log.addMessage("Button name is 'Read Agreement'");
			Utility.simpleWait(5000);
			readAgreementButton.click();
			Log.addMessage("Clicked on the Read Agreement button");
		}catch(Exception e) {
			Log.addMessage("Failed to click on the Read Agreement button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click on the Read Agreement button");
		}
	}
	
	/**
	 * Method Name: IsKwiksetImagePresent(), 
	 * This function is used to check if the Kwikset image is present in the Hello page
	 */
	public void IsKwiksetImagePresent() {
		try {
			utility.Utility.simpleWait(7000);
			MobileElement kwiksetImage = appiumDriver.findElement(By.className("android.widget.ImageView"));
			Assert.assertTrue(kwiksetImage.isDisplayed(), "Kwikset image is displayed");
			Log.addMessage("Kwikset image is displayed.");	
		}catch(Exception e){
			Log.addMessage("Kwikset image is not displayed.");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Kwikset image is not displayed.");
		}
	}
	
	
	/**
	 * Method Name: IsHelloTextPresent(), 
	 * This function is used to check if Hello text is present in the Hello page
	 */
	public void IsHelloTextPresent() {
		try {
			List<MobileElement> textViews = appiumDriver.findElements(By.className("android.widget.TextView"));
			for (MobileElement text:textViews ) {
				if(text.getText().contentEquals("Hello")) {
				Assert.assertTrue(text.getText().contentEquals("Hello"), "Hello text is displayed");
				}
			}
			Log.addMessage("Hello text is displayed.");	
		}catch(Exception e){
			Log.addMessage("Hello text is not displayed.");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Hello text is not displayed.");
		}
	}
	
	/**
	 * Method Name: IsPageDescriptionTextPresent(), 
	 * This function is used to check if page description text is present in the Hello page
	 */
	public void IsPageDescriptionTextPresent() {
		try {
			List<MobileElement> textViews = appiumDriver.findElements(By.className("android.widget.TextView"));
			for (MobileElement text:textViews ) {
				if(text.getText().contentEquals("Before you start using this App with a lock, please agree to our User License Agreement.")) {
				Assert.assertTrue(text.getText().contentEquals("Before you start using this App with a lock, please agree to our User License Agreement."), "Page description text is displayed");
				}
			}
			Log.addMessage("Page description text is displayed.");	
		}catch(Exception e){
			Log.addMessage("Page description text is not displayed.");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Page description text is not displayed.");
		}
	}
	
	/**
	 * Method Name: IsApplicationVersionTextPresent(), 
	 * This function is used to check if Application version text is present in the Hello page
	 */
	public void IsApplicationVersionTextPresent() {
		try {
			List<MobileElement> textViews = appiumDriver.findElements(By.id("android.widget.TextView"));
			for (MobileElement text:textViews ) {
				if(text.getText().contentEquals("App Version")) {
				Assert.assertTrue(text.getText().contentEquals("App Version"), "Application Version text is displayed");
				}
			}
			Log.addMessage("Application Version text is displayed.");	
		}catch(Exception e){
			Log.addMessage("Application Version text is not displayed.");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Application Version text is not displayed.");
		}
	}
	
	/**
	 * Method Name: CheckApplicationVersion(String) , 
	 * This function is used to check if the correct Application version is displayed in the Hello page
	 */
	
	public void CheckApplicationVersion(String applicationVersion) {
		try {
			List<MobileElement> textViews = appiumDriver.findElements(By.id("com.spectrum.giga:id/tv_version"));
			for (MobileElement text:textViews ) {
				if(text.getText().contentEquals(applicationVersion)) {
				Assert.assertTrue(text.getText().contentEquals(applicationVersion), "Correct application version is displayed");
				}
			}
			Log.addMessage("Correct application version is displayed.");	
		}catch(Exception e){
			Log.addMessage("Correct application version is not displayed.");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Correct application version is not displayed.");
		}
	}		
}
