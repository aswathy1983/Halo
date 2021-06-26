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

public class SplashScreenPage extends Settings {
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Allow']")
	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	@CacheLookup
	private MobileElement allowButton;
	

	
	
	@SuppressWarnings("static-access")
	public SplashScreenPage(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
	
	/**
	 * Method Name: clickOnAllowButton(), 
	 * This function is used to click on the Allow button
	 */
	public void clickOnAllowButton() {
		try {
			//utility.Utility.simpleWait(6000);
			//Assert.assertTrue(allowButton.getText().contains("Allow") && allowButton.isDisplayed(), "Allow button is displayed");
			allowButton.click();
			Log.addMessage("Clicked on Allow button");	
		}catch(Exception e){
			Log.addMessage("Allow button is not displayed");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Allow button is not displayed");
		}
	}

}

