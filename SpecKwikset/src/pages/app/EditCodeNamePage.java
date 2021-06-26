package pages.app;

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
import utility.Utility;

public class EditCodeNamePage extends Settings{
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[1]")
	@AndroidFindBy(xpath = "//android.widget.EditText")
	@CacheLookup
	private MobileElement acceessCodeNameField;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Submit']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_submit"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_submit"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_submit"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_submit"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/tv_submit")
	})
	@CacheLookup
	private MobileElement submitButton;	
	
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
	
	@iOSXCUITFindBy(id = "Ok")
	@AndroidFindBy(id = "android:id/button1")
	@CacheLookup
	private MobileElement OKButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[1]")
	@AndroidFindBy(id = "android:id/alertTitle")
	@CacheLookup
	private MobileElement alertTitleMsg;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[2]")
	@AndroidFindBy(id = "android:id/message")
	@CacheLookup
	private MobileElement messageVerbiage;
	
	By backBtn =By.xpath("//XCUIElementTypeTextField[1]");
	By backBtnAn =By.xpath("//android.widget.EditText");//added on 29-03-2021
	
	String actTitle, actMessage, actualRes ="";

	//Constructor
	@SuppressWarnings("static-access")
	public EditCodeNamePage(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
		
		
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void enterAccessCodeName(String name) {
		try {
			Thread.sleep(6000);
			acceessCodeNameField.clear();
			acceessCodeNameField.sendKeys(name);
			Log.addMessage("Access Code Name entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter access code name");
			Assert.assertTrue(false, "Failed to enter access code name");
		}
	}
	
	public void setAccessCodeName(String name) {
		try {
			Thread.sleep(6000);
			acceessCodeNameField.clear();
			acceessCodeNameField.sendKeys(name);
			Log.addMessage("Access Code Name entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter access code name");
			Assert.assertTrue(false, "Failed to enter access code name");
		}
	}
		
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void clickSubmitButton() {
		try {
			Thread.sleep(6000);
			submitButton.click();
			Log.addMessage("Clicked Submit Button");
			Utility.simpleWait(8000);
		}catch(Exception e) {
			Log.addMessage("Failed to click Submit button");
			Assert.assertTrue(false, "Failed to click Submit button");
		}
	}
	
	public void valUserProfileName(String usrNm, String titleMsg, String errMessage, String titleMsg2, String errMessage2) {
		try {
				Utility.simpleWait(2000);
				System.out.println("in user name validation");
				setAccessCodeName(usrNm);	
				System.out.println("updated UsrName="+usrNm);	
				
				clickSubmitButton();	
				Utility.simpleWait(2000);
				System.out.println("updated out");
				if(device.equals("iOS")) {
					if(errMessage!="") {
						if(titleMsg!="") {
							actTitle=alertTitleMsg.getText();
							actMessage=messageVerbiage.getText();
						}else {
							actMessage=alertTitleMsg.getText();
						}
						
						System.out.println("mainMessage="+actMessage);
						setErrMsg(errMessage,actMessage,titleMsg, actTitle);	
					}
				}else {
					if(errMessage2!="") {
						if(titleMsg2!="") {
							actTitle=alertTitleMsg.getText();
							actMessage=messageVerbiage.getText();
						}else {
							actMessage=alertTitleMsg.getText();
						}
						
						System.out.println("mainMessage="+actMessage);
						setErrMsg(errMessage2,actMessage,titleMsg2, actTitle);	
					}
				}
				
				System.out.println("actMessage="+actMessage);
				Log.addMessage("Lock name Updated and directed to Wifi Instructions page");
		}catch(Exception e) {
			Log.addMessage("Lock name Not Updated");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Lock name Not Updated");
		}
	}

	public void setErrMsg(String exRes, String mnMsg, String ttlMsg, String actTtl) {
		try {
			if(exRes!="") {
				if(mnMsg!="") {					
					actualRes = mnMsg;
					
					System.out.println("in toast="+actualRes);
					//if (device.equals("iOS")) {//commented on 4-06-2020 for android validation
						
						OKButton.click();
					//}
					if(ttlMsg!="") {
						actTitle = actTtl;
						System.out.println("actTitle---="+actTitle+", expttl="+ttlMsg);
						Assert.assertEquals(actTitle, ttlMsg,"Please check the title validation message.");
					}
				}
				System.out.println("actRes---="+actualRes);
				System.out.println("expRes---="+exRes);
				
				Assert.assertEquals(actualRes, exRes,"Please check the validation message.");
			}
		}catch(Exception e) {
			e.printStackTrace();
			Assert.assertEquals(false, "Expected message is null.");
		}
	}

	public void clickAccessNameBackButton() {
		try {
			if(device.equals("iOS")) {
				Utility.waitForElementPresent(backBtn,appiumDriver);
			}else {
				Utility.waitForElementPresent(backBtnAn,appiumDriver);
			}
			Utility.waitForElementToBeVisible(acceessCodeNameField);
			backButton.click();
			Log.addMessage("Clicked Back Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Back button ");
		}
	}
}