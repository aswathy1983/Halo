package pages.app;

import java.util.HashMap;
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

public class NewUserEmailPage extends Settings{
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[1]")
	//@iOSXCUITFindBy(xpath = "XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeTextField")
	@AndroidFindBy(xpath = "//android.widget.EditText")
	@CacheLookup
	private MobileElement emailField;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/cancelAllhomes"),
		@AndroidBy(id = "com.kwikset.blewifi:id/cancelAllhomes"),
		@AndroidBy(id = "com.spectrum.giga:id/cancelAllhomes"),
		@AndroidBy(id = "com.weiser.blewifi:id/cancelAllhomes")
	})
	@CacheLookup
	private MobileElement backButton;
	
	//commented on 05-11-2020
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Submit']")
	//@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Next']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_submit"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_submit"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_submit"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_submit")
	})
	@CacheLookup
	private MobileElement submitButton;
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Next']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/info"),
		@AndroidBy(id = "com.kwikset.blewifi:id/info"),
		@AndroidBy(id = "com.spectrum.giga:id/info"),
		@AndroidBy(id = "com.weiser.blewifi:id/info")
	})
	@CacheLookup
	private MobileElement emailInformation;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[normalize-space(@name)='Admin']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/homeName"),
		@AndroidBy(id = "com.kwikset.blewifi:id/homeName"),
		@AndroidBy(id = "com.spectrum.giga:id/homeName"),
		@AndroidBy(id = "com.weiser.blewifi:id/homeName")
	})
	@CacheLookup
	private MobileElement homeName;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[normalize-space(@name)='Admin']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/lockCount"),
		@AndroidBy(id = "com.kwikset.blewifi:id/lockCount"),
		@AndroidBy(id = "com.spectrum.giga:id/lockCount"),
		@AndroidBy(id = "com.weiser.blewifi:id/lockCount")
	})
	@CacheLookup
	private MobileElement lockCount;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText")//added on 18-05-2020
	@AndroidFindBy(xpath="//android.widget.Toast[1]")
	@CacheLookup
	private MobileElement confirmToastMsg;
	
	@iOSXCUITFindBy(id = "Ok")
	@AndroidFindBy(id = "android:id/button1")//added on 08-06-2020
	@CacheLookup
	private MobileElement OkButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	@AndroidFindBy(id = "android:id/button2")
	@CacheLookup
	private MobileElement cancelButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[2]")
	@AndroidFindBy(id="android:id/message")
	private MobileElement valMessage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[1]")
	@AndroidFindBy(id="android:id/alertTitle")
	private MobileElement valTitleMessage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
	private MobileElement doneKeyboard;
	
	
	
	String actualRes, toastMessage, lkTxtName, actMessage, actTitle = "";
	

	//Constructor
		@SuppressWarnings("static-access")
		public NewUserEmailPage(AppiumDriver<MobileElement> driver) {
			this.appiumDriver = driver;
			PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
		}
		
		
	/** 
	* Method Name: enterNewUser(), 
	* This function is used to enter user name
	*/
		
	public void enterNewEmail(String newUser) throws InterruptedException {
		try {
			System.out.println("in email"+newUser);
			if(device.equals("iOS")) {
				Thread.sleep(6000);
			}else {
				Utility.waitForElementToBeVisible(emailField);
				System.out.println("in email2");
				Utility.waitForElementToBeClickable(emailField);
			}
			System.out.println("in email3");
			emailField.sendKeys(newUser);
			Log.addMessage("Email of new user is entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter email of user");
			Assert.assertTrue(false, "Failed to enter email of user");
		}
	}	
		
	
	
	
	public void clickSubmitButton() throws InterruptedException {
		try {
			if(device.equals("iOS")) {
				Thread.sleep(6000);
			}else {
				System.out.println("one1");
				Utility.waitForElementToBeVisible(submitButton);
			}
			System.out.println("one");
			submitButton.click();
			System.out.println("two");
			Log.addMessage("Clicked Next button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Next button");
			Assert.assertTrue(false, "Failed to click Next button");
		}
	}
	
	public void clickBackButton() throws InterruptedException {
		try {
			Thread.sleep(6000);
			backButton.click();
			Log.addMessage("Clicked Back button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Back button");
			Assert.assertTrue(false, "Failed to click Back button");
		}
	}
	
	//added on 03 Aug 2020
	public void verifyAddHomeUserEmailUI() throws InterruptedException {
		try {
			Utility.waitForElementToBeVisible(emailField);
			Log.addMessage("Add user button is present");
			Utility.waitForElementToBeVisible(backButton);
			Log.addMessage("Back Button is present");
			Utility.waitForElementToBeVisible(submitButton);
			Log.addMessage("Next Button is present");
			Utility.waitForElementToBeVisible(homeName);
			Log.addMessage("Home name is present");
			Utility.waitForElementToBeVisible(lockCount);
			Log.addMessage(""+lockCount+" present");
			Utility.waitForElementToBeVisible(emailInformation);
			Log.addMessage("Email info is displayed as "+emailInformation.getText());
			Log.addMessage("All UI elements are present");
		}catch(Exception e) {
			Log.addMessage("Failed to display all elements in add new user page");
			Assert.assertTrue(false, "Failed to display all elements in add new user page");
		}
	}
	
	/** 
	* Method Name: enterMobileNumberDoneKey(), 
	* This function is used to enter done key in keyboard from the phone number Page
	*/	
	public void enterEmailDoneKey(String email) {
		try {
			Utility.waitForElementToBeVisible(emailField);
			emailField.click();
			emailField.clear();
			emailField.sendKeys(email);
			Log.addMessage("Email field entered");
			
			if(device.equals("iOS")) {
				doneKeyboard.click();
			}else {
				JavascriptExecutor js = appiumDriver;
				Map<String, Object> params = new HashMap<>();
				params.put("action", "Done");
				params.put("element", emailField);
				js.executeScript("mobile: performEditorAction", params);
			}
			OkButton.click();
			Log.addMessage("Clicked Done Button");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to enter phone number");
			Assert.assertTrue(false, "Failed to enter phone number");
		}
	}
	
	public void valAddHomeUserEmail(String userEmail, String titleMessag, String validMessage, String toastMsg) {
		try {
				Utility.simpleWait(2000);
				System.out.println("in user name validation");
				enterNewEmail(userEmail);	
				System.out.println("updated userEmail="+userEmail);
				submitButton.click();	
				Utility.simpleWait(2000);
				System.out.println("updated out"+toastMsg);
				toastMessage="";
				if(toastMsg!="") {
					toastMessage=confirmToastMsg.getAttribute("name");
					System.out.println("toastMessage="+toastMessage+",exptoastmsg="+toastMsg);
					setErrMsg(toastMsg,toastMessage,"","");	
				}else {
					actMessage=valMessage.getText();
					actTitle = valTitleMessage.getText();
					System.out.println("toastMessage="+toastMessage);
					OkButton.click();
					setErrMsg(validMessage,actMessage,actTitle,titleMessag);	
				}
				System.out.println("toastMessage="+toastMessage);
				Log.addMessage("Lock name Updated and directed to Wifi Instructions page");
		}catch(Exception e) {
			Log.addMessage("Lock name Not Updated");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Lock name Not Updated");
		}
	}

	public void setErrMsg(String exRes, String tMsg, String actTitleMsg, String expTitleMsg) {
		try {
			if(exRes!="") {
				if(tMsg!="") {	
					
					actualRes = tMsg;
					if(actTitleMsg!="") {
						Assert.assertEquals(actTitleMsg, expTitleMsg,"Please check the title validation message.");
					}
					System.out.println("in toast="+actualRes);
					if (device.equals("iOS")) {
						OkButton.click();
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
	
	/** 
	* Method Name: clickOKButton(), 
	* This function is used to click OK button from the pop up Page
	*/ 
		
	public void clickOKButton() {
		try {
			System.out.println("one");
			Utility.waitForElementToBeVisible(OkButton);
			System.out.println("two");
			Utility.waitForElementToBeClickable(OkButton);
			System.out.println("three");
			OkButton.click();
			System.out.println("four");
			Log.addMessage("Clicked OK Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click OK Button");
			Assert.assertTrue(false, "Failed to click OK Button");
		}
	}
	
	public void clickCancelButton()  {
		try {
			Utility.waitForElementToBeVisible(cancelButton);
			Utility.waitForElementToBeClickable(cancelButton);
			cancelButton.click();
			Log.addMessage("Clicked Cancel Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Cancel button");
			Assert.assertTrue(false, "Failed to click Cancel button");
		}
	}
	
}
