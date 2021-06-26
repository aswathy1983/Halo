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

public class LockNamePage extends Settings  {
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
	@AndroidFindBy(xpath = "//android.widget.EditText")
	@CacheLookup
	private MobileElement lockNameField;
	
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
	
	
	/* added on 20-05-2020 */
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[3]")
	@CacheLookup
	private MobileElement nextButton;
	
	/* added on 07-05-2020 */
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=' Back']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/cancelAllhomes"),
		@AndroidBy(id = "com.kwikset.blewifi:id/cancelAllhomes"),
		@AndroidBy(id = "com.spectrum.giga:id/cancelAllhomes"),
		@AndroidBy(id = "com.weiser.blewifi:id/cancelAllhomes"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/cancelAllhomes")
	})
	@CacheLookup
	private MobileElement bkButton;
	
	@iOSXCUITFindBy(id = "Clear text")
	@AndroidFindBy(xpath="//android.widget.ImageButton")
	@CacheLookup
	private MobileElement clearIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText")//added on 18-05-2020
	@AndroidFindBy(xpath="//android.widget.Toast[1]")
	@CacheLookup
	private MobileElement confirmToastMsg;
	
	@iOSXCUITFindBy(id = "Ok")
	@AndroidFindBy(id = "android:id/button1")//added on 08-06-2020
	@CacheLookup
	private MobileElement OkButton;
	
	
	String actualRes, toastMessage, lkTxtName="";
	
	public static final int KEYCODE_ENTER=66;
	
	//Constructor
	@SuppressWarnings("static-access")
	public LockNamePage(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
		
	/** 
	* Method Name: enterLockName(), 
	* This function is used to  enter the lock namefor android
	*/
		
	public void enterLockName(String lockname) {
		try {
			Thread.sleep(3000);
			lockNameField.clear();
			lockNameField.click();
			lockNameField.sendKeys("Front Door");
			//Script to select done button from the keyboard 
			JavascriptExecutor js = appiumDriver;
			Map<String, Object> params = new HashMap<>();
			params.put("action", "done");
			params.put("element", lockNameField);
			js.executeScript("mobile: performEditorAction", params);
			Log.addMessage("Entered lock name");
		}catch(Exception e) {
			Log.addMessage("Failed to enter lock name");
			Assert.assertTrue(false, "Failed to enter lock name");
		}
	}
	
	/** 
	* Method Name: enterLockNameiOS(), 
	* This function is used to enter the lock namefor iOS
	*/
		
	public void enterLockNameiOS(String lockname) {
		try {
			Thread.sleep(3000);
			lockNameField.clear();
			lockNameField.sendKeys("Front Door");
			nextButton.click();
			Log.addMessage("Entered lock name");
		}catch(Exception e) {
			Log.addMessage("Failed to enter lock name");
			Assert.assertTrue(false, "Failed to enter lock name");
		}
	}
	
	/** 
	* Method Name: clickSubmitButton(), 
	* This function is used to click Submit button
	*/
		
	public void clickSubmitButton() {
		try {
			Utility.waitForElementToBeVisible(submitButton);
			Utility.waitForElementToBeClickable(submitButton);
			submitButton.click();
			Log.addMessage("Clicked Submit Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Submit button");
			Assert.assertTrue(false, "Failed to click Submit button");
		}
	}
	/* added on 07-05-2020 */
	
	/** 
	* Method Name: clickBackButton(), 
	* This function is used to click Back button from Add lock name page
	*/
		
	public void clickBkButton() {
		try {
			Thread.sleep(6000);
			Utility.waitForElementToBeVisible(bkButton);
			Utility.waitForElementToBeClickable(bkButton);
			bkButton.click();
			Log.addMessage("Clicked Back Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Back button");
			Assert.assertTrue(false, "Failed to click Back button");
		}
	}
	
	/** 
	* Method Name: setLockName(), 
	* This function is used to set lock name field
	*/
		
	public void setLockName(String lockname) {
		try {
			Utility.waitForElementToBeVisible(lockNameField);
			Utility.waitForElementToBeClickable(lockNameField);
			lockNameField.clear();
			lockNameField.sendKeys(lockname);
			Log.addMessage("Entered lock name");
		}catch(Exception e) {
			Log.addMessage("Failed to display lock name text");
			Assert.assertTrue(false, "Failed to display lock name text");
		}
	}
	
	
	/** 
	* Method Name: verifyClearButton(), 
	* This function is used to validate lock name field
	*/
	public void verifyClearButton() {
		try {
			Thread.sleep(3000);
			lockNameField.sendKeys("Test clear button");
			System.out.println("in verifyClearButton test");
			Thread.sleep(1000);
			Utility.waitForElementToBeVisible(clearIcon);
			Utility.waitForElementToBeClickable(clearIcon);
			Log.addMessage("Clear button is visible");
			clearIcon.click();
			Log.addMessage("Clicked clear button lock name");
			System.out.println("lockNameField.getText="+lockNameField.getText());
			Thread.sleep(2000);
			Assert.assertEquals(lockNameField.getText(), "ex. Front Door or Back Door","Clear Text functionality is working");
			//System.out.println("text after clear="+lockNameField.getText());
			Log.addMessage("Clear Text functionality is working");
		}catch(Exception e) {
			Log.addMessage("Clear Text functionalit failed.");
			Assert.assertTrue(false, "Clear Text functionalit failed.");
		}
	}
	
	public void valLockName(String lkName, String errMessage) {
		try {
				Utility.simpleWait(2000);
				System.out.println("in lock name validation");
				setLockName(lkName);	
				System.out.println("updated lkName="+lkName);	
				
				clickSubmitButton();	
				Utility.simpleWait(2000);
				System.out.println("updated out");
				toastMessage="";
				if(errMessage!="") {
					toastMessage=confirmToastMsg.getAttribute("name");
					System.out.println("toastMessage="+toastMessage);
					setErrMsg(errMessage,toastMessage);	
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
	
	/* added on 08-06-2020 */
	
	/** 
	* Method Name: clickOkButton(), 
	* This function is used to click OK button from Add lock name page
	*/
		
	public void clickOkButton() {
		try {
			//Thread.sleep(6000);//commented on 23rd oct 2020 
			//System.out.println("in lockname OK");
			Utility.waitForElementToBeVisible(OkButton);
			Utility.waitForElementToBeClickable(OkButton);
			//System.out.println("inside OK");
			OkButton.click();
			//System.out.println("clicked OKButton");
			Log.addMessage("Clicked OK Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click OK button");
			Assert.assertTrue(false, "Failed to click OK button");
		}
	}
	
	

}
