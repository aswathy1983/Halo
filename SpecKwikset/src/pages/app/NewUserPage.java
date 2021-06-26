package pages.app;

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

public class NewUserPage extends Settings{
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[1]")
	@AndroidFindBy(xpath="//android.widget.EditText")
	@CacheLookup
	private MobileElement nameField;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[normalize-space(@name)='Admin']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tvOptionAdmin"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tvOptionAdmin"),
		@AndroidBy(id = "com.spectrum.giga:id/tvOptionAdmin"),
		@AndroidBy(id = "com.weiser.blewifi:id/tvOptionAdmin")
	})
	@CacheLookup
	private MobileElement adminButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[normalize-space(@name)='Member']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tvOptionMember"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tvOptionMember"),
		@AndroidBy(id = "com.spectrum.giga:id/tvOptionMember"),
		@AndroidBy(id = "com.weiser.blewifi:id/tvOptionMember")
	})
	@CacheLookup
	private MobileElement memberButton;
	
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
	//@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Next']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Next']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_next"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_next"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_next"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_next")
	})
	@CacheLookup
	private MobileElement nextButton;
	
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
	
	
	String actualRes, toastMessage, lkTxtName="";
	

	//Constructor
		@SuppressWarnings("static-access")
		public NewUserPage(AppiumDriver<MobileElement> driver) {
			this.appiumDriver = driver;
			PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
		}
		
		
	/** 
	* Method Name: enterNewUser(), 
	* This function is used to enter user name
	*/
		
	public void enterNewUser(String newUser) throws InterruptedException {
		try {
			//Thread.sleep(6000);//commented on 05-11-2020
			Utility.waitForElementToBeVisible(nameField);
			Utility.waitForElementToBeClickable(nameField);
			System.out.println("in new user");
			nameField.sendKeys(newUser);
			Log.addMessage("Name of new user is entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter name of user");
			Assert.assertTrue(false, "Failed to enter name of user");
		}
	}	
		
	public void clickAdminButton() throws InterruptedException {
		try {
			Thread.sleep(6000);
			adminButton.click();
			Log.addMessage("Selected access level as Admin");
		}catch(Exception e) {
			Log.addMessage("Failed to select access level as admin");
			Assert.assertTrue(false, "Failed to select access level as admin");
		}
	}
	
	public void clickMemberButton() throws InterruptedException {
		try {
			Thread.sleep(6000);
			memberButton.click();
			Log.addMessage("Selected access level as Member");
		}catch(Exception e) {
			Log.addMessage("Failed to select access level as Member");
			Assert.assertTrue(false, "Failed to select access level as Member");
		}
	}
	
	
	public void clickNextButton() throws InterruptedException {
		try {
			//Thread.sleep(6000);
			Utility.waitForElementToBeVisible(nextButton);
			Utility.waitForElementToBeClickable(nextButton);
			nextButton.click();
			Log.addMessage("Clicked Next button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Next button");
			Assert.assertTrue(false, "Failed to click Next button");
		}
	}
	
	public void clickBackButton() throws InterruptedException {
		try {
			//Thread.sleep(6000);
			System.out.println("one");
			Utility.waitForElementToBeVisible(backButton);
			System.out.println("two");
			Utility.waitForElementToBeClickable(backButton);
			System.out.println("three");
			backButton.click();
			System.out.println("four");
			Log.addMessage("Clicked Back button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Back button");
			Assert.assertTrue(false, "Failed to click Back button");
		}
	}
	
	//added on 03 Aug 2020
	public void verifyAddHomeUserUI() throws InterruptedException {
		try {
			Utility.waitForElementToBeVisible(nameField);
			Log.addMessage("Add user button is present");
			Utility.waitForElementToBeVisible(adminButton);
			Log.addMessage("Admin button is present");
			Utility.waitForElementToBeVisible(backButton);
			Log.addMessage("Back Button is present");
			Utility.waitForElementToBeVisible(memberButton);
			Log.addMessage("Member button is present");
			Utility.waitForElementToBeVisible(nextButton);
			Log.addMessage("Next Button is present");
			Utility.waitForElementToBeVisible(homeName);
			Log.addMessage("Home name is present");
			Utility.waitForElementToBeVisible(lockCount);
			Log.addMessage(""+lockCount+" present");
			Log.addMessage("All UI elements are present");
		}catch(Exception e) {
			Log.addMessage("Failed to display all elements in add new user page");
			Assert.assertTrue(false, "Failed to display all elements in add new user page");
		}
	}
	
	public void valAddHomeUser(String userName, String valMessage) {
		try {
				Utility.simpleWait(2000);
				System.out.println("in user name validation");
				enterNewUser(userName);	
				System.out.println("updated userName="+userName);	
				clickNextButton();	
				Utility.simpleWait(2000);
				System.out.println("updated out");
				toastMessage="";
				if(valMessage!="") {
					toastMessage=confirmToastMsg.getAttribute("name");
					System.out.println("toastMessage="+toastMessage);
					setErrMsg(valMessage,toastMessage);	
				}					
				System.out.println("toastMessage="+toastMessage);
				Log.addMessage("Lock name Updated and directed to Wifi Instructions page");
		}catch(Exception e) {
			Log.addMessage("Lock name Not Updated");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Lock name Not Updated");
		}
	}

	public void setErrMsg(String exRes, String tMsg) {
		try {
			if(exRes!="") {
				if(tMsg!="") {					
					actualRes = tMsg;
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
	

	
}
