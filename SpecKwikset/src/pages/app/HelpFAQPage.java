package pages.app;

import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
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

public class HelpFAQPage extends Settings{
	
	@iOSXCUITFindBy(id = "Lock Installation Guide")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Lock Installation Guide']")
	@CacheLookup
	private MobileElement lockInstallationGuide;
	
	@iOSXCUITFindBy(id = "Support Center")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Support Center']")
	@CacheLookup
	private MobileElement supportCenter;
	
	@iOSXCUITFindBy(id = "User Agreements")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='User Agreement']")
	@CacheLookup
	private MobileElement userAgreements;
		
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=' Back']")
	@AndroidFindBy(id = "com.kwikset.blewifi.dev:id/cancelAllhomes")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/cancelAllhomes"),
		@AndroidBy(id = "com.kwikset.blewifi:id/cancelAllhomes"),
		@AndroidBy(id = "com.spectrum.giga:id/cancelAllhomes"),
		@AndroidBy(id = "com.weiser.blewifi:id/cancelAllhomes")
	})
	@CacheLookup
	private MobileElement backButton;	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Choose Your Experience\"]")
	@CacheLookup
	private MobileElement guideTitle;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='SELECT YOUR LANGUAGE']")
	@AndroidFindBy(xpath="//android.view.View[@text='SELECT YOUR LANGUAGE']")
	@CacheLookup
	private MobileElement selLanguage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Select A Product']")
	@AndroidFindBy(xpath="//android.view.View[@text='Select A Product']")
	@CacheLookup
	private MobileElement selProduct;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeLink[@name='ESPAÑOL'])[1]")
	@AndroidFindBy(xpath="//android.view.View[@text='SELECT YOUR LANGUAGE']")
	@CacheLookup
	private MobileElement selEspanol;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Installation Guide\"]")
	@CacheLookup
	private MobileElement installationGuide;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Aura\"]")
	@CacheLookup
	private MobileElement aura;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Halo Touchscreen\"]")
	@CacheLookup
	private MobileElement haloTouchscreen;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Halo Keypad\"]")
	@CacheLookup
	private MobileElement haloKeypad;
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"The Kwikset App is exclusively for use with Kwikset\"]")
	@CacheLookup
	private MobileElement supportCenterText;
	
	@iOSXCUITFindBy(id = "TERMS OF SERVICE")
	@CacheLookup
	private MobileElement termsofserviceText;
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[normalize-space(@name)='Back']")
	@CacheLookup
	private MobileElement backButton1;	
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btnEnglish;
	
	@FindBy(xpath="//a[@class='btn btn-default btn-lg']") 
	WebElement btnEspanol;
		

	//Constructor
	/*@SuppressWarnings("static-access")
	public HelpFAQPage(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}*/
	
	@SuppressWarnings("static-access")
	public HelpFAQPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}

	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void clickBackButton() {
		try {
			Utility.waitForElementToBeVisible(backButton);
			Utility.waitForElementToBeClickable(backButton);
			backButton.click();
			Log.addMessage("Clicked Back Button");
			Utility.simpleWait(8000);
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click Back button");
			Assert.assertTrue(false, "Failed to click Back button");
		}
	}
	
	/** 
	* Method Name: clickNavBack(), 
	* This function is used to navigate back from the Help/Faq Page
	*/
		
	public void clickNavBack() {
		try {
			Utility.waitForElementToBeVisible(backButton);
			Utility.waitForElementToBeClickable(backButton);
			backButton.click();
			Log.addMessage("Clicked Back Button");
			Utility.simpleWait(8000);
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click Back button");
			Assert.assertTrue(false, "Failed to click Back button");
		}
	}

	public void verifyLockInstallationGuide() {
		try {
			Utility.waitForElementToBeVisible(lockInstallationGuide);
			Utility.waitForElementToBeClickable(lockInstallationGuide);
			lockInstallationGuide.click();
			Log.addMessage("Clicked to view Lock Installation guide");
		    Utility.simpleWait(8000);
		    Assert.assertEquals(guideTitle.getText(), "Choose Your Experience");
		    Log.addMessage("User in Lock Installation guide page");
		    Assert.assertTrue(installationGuide.isDisplayed(), "Installation guide displayed");
		    Log.addMessage("Installation guide is displayed");
		    Assert.assertTrue(aura.isDisplayed(), "Aura guide is displayed");
		    Log.addMessage("Aura guide is displayed");
		    Assert.assertTrue(haloTouchscreen.isDisplayed(), "Halo Touchscreen guide displayed");
		    Log.addMessage("Halo Touchscreen guide is displayed");
		    Assert.assertTrue(haloKeypad.isDisplayed(), "Halo Keypad guide displayed");
		    Log.addMessage("Halo Keypad guide is displayed");
		    backButton.click();
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click Lock Installation Guide button");
			Assert.assertTrue(false, "Failed to click Lock Installation Guide button");
		}
	}
	
	public void verifyLockInstGuide() {
		try {
			Utility.waitForElementToBeVisible(lockInstallationGuide);
			Utility.waitForElementToBeClickable(lockInstallationGuide);
			lockInstallationGuide.click();
			Log.addMessage("Clicked to view Lock Installation guide");
		    Utility.simpleWait(8000);
		    /*  Set<String> contextNames = appiumDriver.getContextHandles();
		    System.out.println("contextNames="+contextNames.size());
		    System.out.println("contextNames[0]="+contextNames.toArray()[1].toString());
		    appiumDriver.context(contextNames.toArray()[1].toString());
		   
		   // appiumDriver.context("NATIVE_APP");
		    System.out.println("1");
		    Utility.waitForElementToBeVisible(btnEnglish);
		    System.out.println("2");
		    Utility.waitForElementToBeClickable(btnEnglish);
		    System.out.println("3");
		    appiumDriver.navigate().back();
		    System.out.println("4");*/
		    System.out.println("lan="+selLanguage.getText());
		    Utility.waitForElementToBeVisible(selLanguage);
		    Assert.assertEquals(selLanguage.getText(), "SELECT YOUR LANGUAGE");
		    Log.addMessage("User in Lock Installation guide page");
		    System.out.println("check");
		    //appiumDriver.navigate().back();
		    System.out.println("check back");
		    
		   /* Assert.assertTrue(installationGuide.isDisplayed(), "Installation guide displayed");
		    Log.addMessage("Installation guide is displayed");
		    Assert.assertTrue(aura.isDisplayed(), "Aura guide is displayed");
		    Log.addMessage("Aura guide is displayed");
		    Assert.assertTrue(haloTouchscreen.isDisplayed(), "Halo Touchscreen guide displayed");
		    Log.addMessage("Halo Touchscreen guide is displayed");
		    Assert.assertTrue(haloKeypad.isDisplayed(), "Halo Keypad guide displayed");
		    Log.addMessage("Halo Keypad guide is displayed");
		    backButton.click();*/
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click Lock Installation Guide button");
			Assert.assertTrue(false, "Failed to click Lock Installation Guide button");
		}
	}

	public void verifySupportCenter() {
		try {
			Utility.waitForElementToBeVisible(supportCenter);
			Utility.waitForElementToBeClickable(supportCenter);
			supportCenter.click();
			Log.addMessage("Clicked to view Support Center");
			Utility.simpleWait(8000);
			System.out.println("one");
			Utility.waitForElementToBeVisible(selProduct);
			System.out.println("two");
			Utility.waitForElementToBeClickable(selProduct);
			System.out.println("three");
			Assert.assertEquals(selProduct.getText(), "Select A Product");
		    Log.addMessage("User in Lock Installation guide page");
		    System.out.println("check");
		   // appiumDriver.navigate().back();
		    System.out.println("check back");
		    
			//Assert.assertEquals(supportCenterText.getText(), "The Kwikset App is exclusively for use with Kwikset", "User in Support Center Page");
			Log.addMessage("User in Support Center page");
			//driver.context("NATIVE_APP");
			//commented below code on 04-11-2020
			//driver.findElement(By.xpath("//XCUIElementTypeButton[normalize-space(@name)='Back']")).click();
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click Support Center button");
			Assert.assertTrue(false, "Failed to click Support Center button");
		}
	}

	public void verifyUserAgreements() {
		try {
			Utility.waitForElementToBeVisible(userAgreements);
			Utility.waitForElementToBeClickable(userAgreements);
			userAgreements.click();
			Log.addMessage("Clicked to view User Agreements");
			//Utility.simpleWait(5000);
		//	Assert.assertTrue(termsofserviceText.isDisplayed(),"User in User Agreements page");
			Log.addMessage("User Agreements Page verified");
			//driver.findElement(By.xpath("//XCUIElementTypeButton[normalize-space(@name)='Back']")).click();//commented on 03-11-2020
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click User Agreement button");
			Assert.assertTrue(false, "Failed to click User Agreement button");
		}
	}
}
