package pages.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.google.common.collect.ImmutableMap;

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

public class EnterWiFiPasswordPage extends Settings{
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/edtPassword"),
		@AndroidBy(id = "com.kwikset.blewifi:id/edtPassword"),
		@AndroidBy(id = "com.spectrum.giga:id/edtPassword"),
		@AndroidBy(id = "com.weiser.blewifi:id/edtPassword")
	})
	@CacheLookup
	private MobileElement passwordField;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Submit']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_submit"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_submit"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_submit"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_submit")
	})
	@CacheLookup
	private MobileElement submitButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=' Back']")//added on 19-05-2020
	@AndroidFindBy(id = "com.kwikset.blewifi.dev:id/cancelAllhomes")
	@CacheLookup
	private MobileElement backButton;
	
	/* added on 27-05-2020 */
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[3]")
	@CacheLookup
	private MobileElement nextButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[1]")//added on 18-05-2020
	@AndroidFindBy(xpath="//android.widget.Toast[1]")
	@CacheLookup
	private MobileElement confirmToastMsg;
	
	@AndroidFindBy(xpath="//android.widget.Toast")
	@CacheLookup
	private List<MobileElement> lstToastMsg;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText")//added on 18-05-2020
	@CacheLookup
	private List<MobileElement> lstMsg;
	 
	@AndroidFindBy(id="android:id/button1")
	@CacheLookup
	private MobileElement confirmVerificationButton;
	
	@iOSXCUITFindBy(id="Ok")
	@CacheLookup
	private MobileElement OkButton;
	
	@AndroidFindBy(id="android:id/message")
	@CacheLookup
	private MobileElement confirmMessage;
	
	@AndroidFindBy(id="android:id/alertTitle")
	@CacheLookup
	private MobileElement alertTitle;
	
	int toastSz=0;
	String actualRes, toastMessage, lkTxtName, actTitleMsg="";
	

	
	
	//Constructor
	@SuppressWarnings("static-access")
	public EnterWiFiPasswordPage(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void enterWiFiPassword(String password) {
		try {
			Thread.sleep(6000);
			passwordField.clear();
			//passwordField.sendKeys("123qbtech");
			passwordField.sendKeys("23453abpr"); //   changed on 08-05-2020
			passwordField.click();
			
			//Script to select done button from the keyboard 
			//added on 27-05-2020
			
			if(device.contentEquals("iOS")) {
				//clicking return on iOS device
				passwordField.sendKeys(Keys.RETURN);
				Thread.sleep(1000);
				
			}else {
				//clicking return on Android device
				JavascriptExecutor js = appiumDriver;
				Map<String, Object> params = new HashMap<>();
				params.put("action", "done");
				params.put("element", passwordField);
				js.executeScript("mobile: performEditorAction", params);
			}
			Log.addMessage("WiFi Password entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter WiFi Password");
			Assert.assertTrue(false, "Failed to enter WiFi Password");
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
		}catch(Exception e) {
			Log.addMessage("Failed to click Submit button");
			Assert.assertTrue(false, "Failed to enter WiFi Password");
		}
	}
	
	/** 
	* Method Name: clickBackButton(), 
	* This function is used to click Back button from Manual Setup page
	*/
		
	public void clickBackButton() {
		try {
			Thread.sleep(6000);
			Utility.waitForElementToBeVisible(backButton);//added on 19-05-2020 for iOS
			System.out.println("inside pwd back");
			backButton.click();
			Log.addMessage("Clicked Back Button from Wifi Password page");
		}catch(Exception e) {
			Log.addMessage("Failed to click Back button from Wifi Password page");
			Assert.assertTrue(false, "Failed to click Back button from Wifi Password page");
		}
	}
	
	/** 
	* Method Name: valLockName(), 
	* This function is used to validate lock name field
	*/
		
	public void setWifiPass(String pwd) {
		try {
			Utility.waitForElementToBeVisible(passwordField);
			passwordField.clear();
			passwordField.sendKeys(pwd); 
			Log.addMessage("Entered wifi password");
		}catch(Exception e) {
			Log.addMessage("Failed to enter wifi password");
			Assert.assertTrue(false, "Failed to enter wifi password");
		}
	}

	public void valPassword(String wifipass, String tMsg, String errMessage) {
		try {
				Utility.simpleWait(2000);
				System.out.println("in lpassword validation");
				setWifiPass(wifipass);	
				System.out.println("set wifipass="+wifipass);	
				
				clickSubmitButton();	
				
				if(wifipass!="" && errMessage!="" ) //checking the condition when wrong password is given. As pop up shown after some time only
				Utility.simpleWait(10000);
				
				System.out.println("updated out");
				toastMessage="";
				
				toastSz =0;
								
				toastSz=lstToastMsg.size();
				if(toastSz>0 || device.equals("iOS")) {//added on 18-05-2020) {
					System.out.println("inside toast");
					toastMessage=confirmToastMsg.getAttribute("name");
					System.out.println("toastMessage wfipwd="+toastMessage);
					Log.addMessage("Message captured for blank field");
				}else {
					System.out.println("inside else toast");
					Thread.sleep(15000);
				}
				System.out.println("two");
				if(errMessage!="") {
					System.out.println("three");
					setErrMsg(errMessage,tMsg,toastMessage);	
				}
				System.out.println("toastMessage="+toastMessage);
				Log.addMessage("Password updated and directed to checklist page");
		}catch(Exception e) {
			Log.addMessage("Password not updated");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Password not updated");
		}
	}

	public void setErrMsg(String exRes,String exptitle, String tMsg) {
		try {
			if(exRes!="") {
				if(tMsg!="") {					
					actualRes = tMsg;
					System.out.println("in toast="+actualRes);
					if (device.equals("iOS")) {
						if(lstMsg.size()==2) {
							actTitleMsg =lstMsg.get(0).getText();
							actualRes = lstMsg.get(1).getText();
							Assert.assertEquals(actTitleMsg, exptitle,"Please check the title verbiage of the popup");
						}
						OkButton.click();
					}
				}else if(alertTitle.getText()!="") {
					actTitleMsg = alertTitle.getText();
					actualRes = confirmMessage.getText();
					confirmVerificationButton.click();
					Assert.assertEquals(actTitleMsg, exptitle,"Please check the title verbiage of the popup");
					Log.addMessage("Title matching");
				}
				System.out.println("actRes---="+actualRes);
				System.out.println("expRes---="+exRes);
				
				Assert.assertEquals(actualRes, exRes,"Please check the popup verbiage.");
				
			}
		}catch(Exception e) {
			e.printStackTrace();
			Assert.assertEquals(false, "Expected message is null.");
		}
	}

}
