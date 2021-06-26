package pages.app;

import java.util.HashMap;
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
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import utility.Log;
import utility.PropertyUtility;
import utility.Utility;

public class AppUpgradePage extends Settings{
	
	String iOS_App = System.getProperty("user.dir") +
			PropertyUtility.getProperty("iOSAppPath");

	String appPackage = System.getProperty("user.dir") +
			PropertyUtility.getProperty("AndroidAppPackage");

	String appActivity = System.getProperty("user.dir") +
			PropertyUtility.getProperty("AndroidAppActivity");

	String android_App = System.getProperty("user.dir") +
			PropertyUtility.getProperty("AndroidAppPath");
	
	//Constructor
	@SuppressWarnings("static-access")
	public AppUpgradePage(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
		
		
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
	@SuppressWarnings("unchecked")	
	public void appUpgrade() throws InterruptedException {
		try {
			if (device.equals("iOS")) {
				HashMap<String, String> bundleArgs = new HashMap<>();
				bundleArgs.put("bundleId", "com.spectrumhhi.ble-wifi");
				((AppiumDriver<MobileElement>) driver).executeScript("mobile:terminateApp", bundleArgs);
				HashMap<String, String> installArgs = new HashMap<>();
				installArgs.put("app", iOS_App);
				((AppiumDriver<MobileElement>) driver).executeScript("mobile:installApp", installArgs);
				((AppiumDriver<MobileElement>)driver).executeScript("mobile:launchApp", bundleArgs);
			}
			else if (device.equals("android")) {
				((AppiumDriver<MobileElement>) driver).installApp(android_App);
				((AppiumDriver<MobileElement>) driver).launchApp();
			}
			else {
				Log.addMessage("Error!!!!!!!!...Application not found.");
				Assert.assertTrue(false);
			}
			Utility.simpleWait(10000);
		}catch(Exception e) {
		  Log.addMessage(e.getMessage().toString());
		  Log.addMessage("Something went wrong. App upgrade cannot be done");
		  Assert.assertTrue(false, "Some error occured. App upgrade cannot be carried out");
		}
	}
	
}
