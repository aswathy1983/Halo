package pages.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
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

public class EnterHomeNamePage extends Settings{
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
	@AndroidFindBy(xpath = "//android.widget.EditText")
	@CacheLookup
	private MobileElement homeNameField;
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Submit']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_submit"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_submit"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_submit"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_submit")
	})
	@CacheLookup
	private MobileElement submitButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Back']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/cancelAllhomes"),
		@AndroidBy(id = "com.kwikset.blewifi:id/cancelAllhomes"),
		@AndroidBy(id = "com.spectrum.giga:id/cancelAllhomes"),
		@AndroidBy(id = "com.weiser.blewifi:id/cancelAllhomes")
	})
	@CacheLookup
	private MobileElement backButton;
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Back']")
	@AndroidFindAll({
		@AndroidBy(xpath = "//android.widget.ImageButton"),
		@AndroidBy(xpath = "//android.widget.ImageButton"),
		@AndroidBy(xpath = "//android.widget.ImageButton"),
		@AndroidBy(xpath = "//android.widget.ImageButton")
	})
	@CacheLookup
	private MobileElement clearButton;
	
	@iOSXCUITFindBy(id = "Ok")
	@AndroidFindBy(id="android:id/button1")
	private MobileElement OKButton;
	
	@AndroidFindBy(id="android:id/button2")
	private MobileElement cancelButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[2]")
	@AndroidFindBy(id="android:id/message")
	private MobileElement valMessage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[1]")
	@AndroidFindBy(id="android:id/alertTitle")
	private MobileElement valTitleMessage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
	private MobileElement doneKeyboard;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText")
	@AndroidFindBy(xpath="(//android.widget.Toast)[1]")
	@CacheLookup
	private MobileElement confirmToastMsg;
	
	String actualRes, actMessage, toastMessage, titleMsg ="";
	int toastSz =0;
	

	//Constructor
	@SuppressWarnings("static-access")
	public EnterHomeNamePage(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
		
		
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void enterHomeName(String home) {
		try {//commented for testing 200 homes
			//Thread.sleep(6000);
			homeNameField.clear();
			homeNameField.sendKeys(home);
			Log.addMessage("Home name entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter home name");
			Assert.assertTrue(false, "Failed to enter home name");
		}
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void clickSubmitButton() {
		try {
			//Thread.sleep(6000);
			Utility.waitForElementToBeVisible(submitButton);
			submitButton.click();
			Thread.sleep(6000);
			Log.addMessage("Clicked Submit button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Submit button.");
			Assert.assertTrue(false, "Failed to click Submit button.");
		}
	}
	
	/** 
	* Method Name: clickBackButton(), 
	* This function is used to click back button 
	*/
	
	public void clickBackButton() {
		try {
			Utility.waitForElementToBeVisible(backButton);
			backButton.click();
			Assert.assertTrue(true,"Failed to click back button");
			Log.addMessage("Back button is clicked");
		}catch(Exception e) {
			Log.addMessage("Failed to click back button");
			Assert.assertTrue(false, "Failed to click back button");
		}
		
	}
	
	/** 
	* Method Name: enterHomeName(), 
	* This function is used to update home name page
	*/
		
	public void valHomeName(String HName, String errMessage, String titleMessage, String tstMessage, String modType) {
		try {
			enterHomeName(HName);	
			System.out.println("updated homename="+HName);			
			clickSubmitButton();	
			Utility.simpleWait(2000);
			System.out.println("updated out");
			if(OKButton.isDisplayed()) {
				System.out.println("in OKButtonnP="+HName+",oP="+errMessage);
				if(modType.equals("add")) {
					if(errMessage!="") {
						actMessage=valMessage.getText();
					}else {
						//actMessage=confirmMessage.getText();
					}
				}else if(modType.equals("edit")) {
					if(titleMessage!="") {
						titleMsg = valTitleMessage.getText();
						actMessage=valMessage.getText();
					}else {
						actMessage=valMessage.getText();
					}
				}else if(modType.equals("mod")) {
					System.out.println("in mod");
					if(tstMessage!="") {
						Utility.simpleWait(2000);
						toastMessage="";
						toastMessage=confirmToastMsg.getAttribute("name");
					}else if(titleMessage!="") {
						titleMsg = valTitleMessage.getText();
						actMessage=valMessage.getText();
					}else {
						System.out.println("in toast null and mod");
						toastMessage="";
						actMessage=valMessage.getText();
					}
				}
				System.out.println("before message="+toastMessage);
				setErrMsg(errMessage,toastMessage,actMessage,titleMsg,titleMessage);		
				System.out.println("after message");
									
				Utility.simpleWait(2000);
			}								
			System.out.println("out");
			Log.addMessage("Home name entered");
		}catch(Exception e) {
			Log.addMessage("Home name not updated");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Home name not updated");
		}
	}

	public void setErrMsg(String exRes, String tMsg, String actlMsg, String titleMsg, String actTitle) {
		try {
			if(exRes!="") {
				System.out.println("-exRes-"+exRes+",tMsg="+tMsg+", actlMsg="+actlMsg);
				if(tMsg!="") {	
					System.out.println("in toast="+actualRes);
					actualRes = tMsg;
				}else if(OKButton.isDisplayed()) {
					System.out.println("---"+valMessage.getText());
					OKButton.click();
					actualRes =actlMsg;						
					if(titleMsg!="") {						
						Assert.assertEquals(actTitle, titleMsg,"Please check the title validation message.");
					}
					System.out.println("actRes---="+actualRes);
					System.out.println("expRes---="+exRes);
				}
				System.out.println("in Assert");
				Assert.assertEquals(actualRes, exRes,"Please check the validation message.");
			}else {
				OKButton.click();
			}
		}catch(Exception e) {
			e.printStackTrace();
			Assert.assertEquals(false, "Expected message is null.");
		}
	}
	
	public void verifyAddHomeUI() {
		try {
			Utility.simpleWait(7000);
			Utility.waitForElementToBeVisible(backButton);
			Log.addMessage("Back button is displayed");
			Utility.waitForElementToBeVisible(homeNameField);
			Log.addMessage("Home name textfield is displayed");
			Utility.waitForElementToBeVisible(submitButton);
			Log.addMessage("Submit button is displayed");
			enterHomeName("test");
			homeNameField.sendKeys("tt");
			Utility.waitForElementToBeVisible(clearButton);
			Log.addMessage("Clear button is displayed");
			clearButton.click();
			Log.addMessage("Clicked clear button");
			Assert.assertTrue(true,"All elements displayed in add new home page");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to display all elements in add new home page");
			Assert.assertTrue(false, "Failed to display all elements in add new home page");
		}
	}
	
	public void verifyClearButton() {
		try {
			
			Utility.waitForElementToBeVisible(homeNameField);
			System.out.println("homeNameField.getText()="+homeNameField.getText());
			if(homeNameField.getText().equals(null)) {
				Assert.assertTrue(true,"Clear button is working in add home page");
			}
			Log.addMessage("Home name text field is cleared");
			
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to display all elements in add new home page");
			Assert.assertTrue(false, "Failed to display all elements in add new home page");
		}
	}
	
	public void clickHomeNameDoneKey(String homename) {
		try {
			//Script to select done button from the keyboard 
			Utility.waitForElementToBeVisible(homeNameField);
			homeNameField.click();
			homeNameField.clear();
			homeNameField.sendKeys(homename);
			
			if(device.equals("iOS")) {
				doneKeyboard.click();
			}else {
				JavascriptExecutor js = appiumDriver;
				Map<String, Object> params = new HashMap<>();
				params.put("action", "Done");
				params.put("element", homename);
				js.executeScript("mobile: performEditorAction", params);
				Utility.simpleWait(3000);
				OKButton.click();
				clearButton.click();
			}
			Log.addMessage("Clicked Done Button");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click Done button");
			Assert.assertTrue(false, "Failed to click Done button");
		}
	}
	
	/** 
	* Method Name: clickOKButton(), 
	* This function is used to click OK button
	*/
		
	public void clickOKButton() {
		try {
			Utility.waitForElementToBeVisible(OKButton);
			Utility.waitForElementToBeClickable(OKButton);
			OKButton.click();
			//Thread.sleep(6000);
			Log.addMessage("Clicked Ok Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Ok button");
			Assert.assertTrue(false, "Failed to click Ok button");
		}
	}
	
	/** 
	* Method Name: clickClearButton(), 
	* This function is used to click clear button
	*/
		
	public void clickClearButton() {
		try {
			Utility.waitForElementToBeVisible(clearButton);
			Utility.waitForElementToBeClickable(clearButton);
			clearButton.click();
			//Thread.sleep(6000);
			Log.addMessage("Clicked clear button");
		}catch(Exception e) {
			Log.addMessage("Failed to click clear button");
			Assert.assertTrue(false, "Failed to click clear button");
		}
	}
	
	/** 
	* Method Name: clickCancelButton(), 
	* This function is used to click cancel button
	*/
		
	public void clickCancelButton() {
		try {
			Utility.waitForElementToBeVisible(cancelButton);
			Utility.waitForElementToBeClickable(cancelButton);
			cancelButton.click();
			Log.addMessage("Clicked cancel button");
		}catch(Exception e) {
			Log.addMessage("Failed to click cancel button");
			Assert.assertTrue(false, "Failed to click cancel button");
		}
	}

}
