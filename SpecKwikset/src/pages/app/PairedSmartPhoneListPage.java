package pages.app;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

public class PairedSmartPhoneListPage extends Settings{

	/***    Created on 06-05-2020     ***/
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeCell//XCUIElementTypeStaticText")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/textViewBondedDevice"),
		@AndroidBy(id = "com.kwikset.blewifi:id/textViewBondedDevice"),
		@AndroidBy(id = "com.spectrum.giga:id/textViewBondedDevice"),
		@AndroidBy(id = "com.weiser.blewifi:id/textViewBondedDevice"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/textViewBondedDevice")
	})
	@CacheLookup
	private List<MobileElement> pairedList;//changed to List type on 26-05-2020 for  FP iOS
	
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
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Paired Smartphones']")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Paired Smartphones']")
	@CacheLookup
	private MobileElement pairedSmartPhone;
	
	By smartPhList = By.xpath("//XCUIElementTypeStaticText[@name='Paired Smartphones']");
	By okBtn= By.xpath("//XCUIElementTypeButton[@name='Ok']");
	By okAnBtn= By.id("android:id/button1");
	
	String pairedPhoneName = "";
	boolean matchPair, okButtonPresent =false;
	int pairCnt = 0;
	
	//constructor
	@SuppressWarnings("static-access")
	public PairedSmartPhoneListPage(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
	
	
	public void pairedPhoneList(String phameExp, int cntPhone) {
		try {
			//System.out.println("pairedList");
			Utility.simpleWait(6000);//added April29-21
			//if(checkOkButton())
				System.out.println("after check ok btn");
			if(device.equals("iOS")) {
				Utility.waitForElementPresent(smartPhList, appiumDriver);
			}else if(device.equals("android")) {
				Utility.waitForTextToBePresent(pairedSmartPhone, "Paired Smartphones");
			}
			System.out.println("cntPhone="+cntPhone+", pairedList.size()="+pairedList.size());
			matchPair=false;
			for(int i = 0; i<pairedList.size(); i++) {
    			pairedPhoneName = pairedList.get(i).getText().trim();
    			System.out.println("pairedPhoneName="+pairedPhoneName+", phameExp="+phameExp);
    			if(pairedPhoneName.equals(phameExp)) {
    				matchPair=true;
    				pairCnt++;
    				break;
    			}
			}
			if(matchPair) {
				if(pairCnt>0) {
					Assert.assertTrue(true, "Paired phone is matching");
				}else{
					Assert.assertTrue(false, "Paired phones is matching");
				}
			}else{
				Assert.assertTrue(false, "Paired phones not matching");	
			}
			Log.addMessage("Paired Phone is Matching.");
		}catch(Exception e) {
			Log.addMessage("Paired phone not listed");
			Assert.assertTrue(false, "Paired phone not listed");
		}
	}
	
	public void verifyPairedPhoneList() {
		try {
			Utility.simpleWait(8000);
			for(int i = 0; i<pairedList.size(); i++) {
				//System.out.println("pair size="+pairedList.size()+", cnt ="+i+", paired list="+pairedList.get(i).getText()+",phameExp");
    			pairedPhoneName = pairedList.get(i).getText();
			}
			Assert.assertTrue(true, "Paired phones are not listed");
			Log.addMessage("Paired Phones are listed.");
		}catch(Exception e) {
			Log.addMessage("Paired phone not listed");
			Assert.assertTrue(false, "Paired phone not listed");
		}
	}
	
	/** 
	* Method Name: clickBackButton(), 
	* This function is used to select Back option from the paired smart phone page
	*/
		
	public void clickBackButton() {
		try {
		//	Thread.sleep(6000);//commented for Halo bvt 23 oct 2020
			Utility.waitForElementToBeVisible(backButton);
			Utility.waitForElementToBeClickable(backButton);
			backButton.click();
			Log.addMessage("Clicked Back Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Back button ");
			Assert.assertTrue(false, "Failed to click Back button");
		}
	}
	
	public void waitForSmartPhone() throws InterruptedException {
		try {
			if(device.equals("android")) {
				Utility.waitForTextToBePresentBy("//android.widget.TextView[@text='Paired Smartphones']", "Paired Smartphones");
			}else {
				Utility.waitForTextToBePresentBy("//XCUIElementTypeStaticText[@name='Paired Smartphones']", "Paired Smartphones");
			}
			Log.addMessage("Loaded settings page");
		}catch(Exception e) {
			Log.addMessage("Failed to load settings page");
			Assert.assertTrue(false, "Failed to load settings page");
		}
	}
	
	public boolean checkOkButton() throws InterruptedException {
		try {
			if(device.equals("iOS")) {
				System.out.println("in check okbutton");
				 Utility.waitForElementPresent(okBtn,appiumDriver);
				 System.out.println("after click okbutton");
				 driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Ok']")).click();
				 System.out.println("after click okbutton");
			}else {
				System.out.println("in else");
				 Utility.waitForElementPresent(okAnBtn,appiumDriver);
				 driver.findElement(By.id("android:id/button1")).click();
			}
			System.out.println("after");
		    okButtonPresent=true;
		    Log.addMessage("Ok button found, syncing in progress");
		    return okButtonPresent;
		}catch(NoSuchElementException e) {
			System.out.println("no ok btn");
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Ok button not found");
			okButtonPresent=false;
			return okButtonPresent;
		}
	}
	

}
