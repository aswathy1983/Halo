package pages.app;

import java.util.List;

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

public class UpdateAccountNamePage extends Settings{
		
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[1]")
	@AndroidFindBy(xpath="(//android.widget.EditText)[1]")//added on 06-07-2020
	@CacheLookup
	private MobileElement firstNameField;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
	@AndroidFindBy(xpath="//android.widget.EditText")//added on 04-05-2020
	private List<MobileElement> accntName;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[2]")
	@AndroidFindBy(xpath="(//android.widget.EditText)[2]")//added on 04-05-2020
	@CacheLookup
	private MobileElement lastNameField;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Clear text'])[1]")
	@AndroidFindBy(xpath="(//android.widget.ImageButton)[1]")//added on 07-07-2020
	@CacheLookup
	private MobileElement clearFirstNameButton;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Clear text'])[1]")
	@AndroidFindBy(xpath="(//android.widget.ImageButton)[1]")//added on 07-07-2020
	@CacheLookup
	private MobileElement clearLastNameButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Next:']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_submit"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_submit"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_submit"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_submit")
	})//added on 04-05-2020
	@CacheLookup
	private MobileElement nextButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
	private MobileElement doneKeyboard;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/backArrowLayout"),
		@AndroidBy(id = "com.kwikset.blewifi:id/backArrowLayout"),
		@AndroidBy(id = "com.spectrum.giga:id/backArrowLayout"),
		@AndroidBy(id = "com.weiser.blewifi:id/backArrowLayout")
	})//added on 04-05-2020
	private MobileElement navBack;//added on 04-05-2020
	
	@iOSXCUITFindBy(id = "Ok")
	@AndroidFindBy(id = "android:id/button1")
	private MobileElement OKButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[2]")
	@AndroidFindBy(id="android:id/message")
	private MobileElement confirmMessage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[1]")
	@AndroidFindBy(id="android:id/alertTitle")
	private MobileElement alertTitle;
	
	String actTitle, actMessage, actualRes, fName, lName, frName, lsName ="";
	
	//Constructor
	
	@SuppressWarnings("static-access")
	public UpdateAccountNamePage(AppiumDriver<MobileElement> driver) {
	this.appiumDriver = driver;
	PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void updateFirstName(String firstname) {
		try {
			Utility.simpleWait(5000);
			firstNameField.click();
			firstNameField.clear();
			firstNameField.sendKeys(firstname);
			Log.addMessage("First name entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter Firstname");
			Assert.assertTrue(false, "Failed to enter Firstname");
		}
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void updateLastName(String lastname) {
		try {
			Utility.simpleWait(5000);
			lastNameField.click();
			lastNameField.clear();
			lastNameField.sendKeys(lastname);
			Log.addMessage("Last name entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter Last name");
			Assert.assertTrue(false, "Failed to enter Last name");
		}
	}
	
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void clickNextButton() {
		try {
			Utility.simpleWait(5000);
			nextButton.click();
			Log.addMessage("Clicked Next Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Next Button");
			Assert.assertTrue(false, "Failed to click Next Button");
		}
	}
	
	//added on 06-07-2020
	/** 
	* Method Name: verifyClearButton(), 
	* This function is used to verify ClearButton in update phone number Page
	*/
		
	public void verifyClearButton() {
		try {
			Utility.simpleWait(7000);
			System.out.println("afterwait");
			clearFirstNameButton.click();
			System.out.println("afterclear1");
			Utility.simpleWait(2000);
			clearLastNameButton.click();
			System.out.println("afterclear2");
			if((firstNameField.getText()).equals("First Name") && lastNameField.getText().equals("Last Name")) {
				System.out.println("cleared");
				Assert.assertTrue(true,"Clear button is not working");
				System.out.println("after assert");
			}
			Log.addMessage("Clicked clear button");
		}catch(Exception e) {
			Log.addMessage("Failed to click clear button");
			Assert.assertTrue(false, "Failed to click clear button");
		}
	}
	
	/*  Code added on 04-05-2020  */

	/** 
	* Method Name: getFirstName(), 
	* This function is used to get first name in Account First Name Text field in Edit Account Name Page
	*/
	public void getFirstName(String firstname) {
		try {
			Utility.simpleWait(3000);
			Utility.waitForElementToBeVisible(accntName.get(0));
			fName = accntName.get(0).getText();
			Assert.assertEquals(fName, firstname,"First Name of the account is not matching.");
			Log.addMessage("First Name entered");
		}catch(Exception e) {
			Log.addMessage("First Name field is not visible");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "First Name field is not visible");
		}
		
	}
	
	/** 
	* Method Name: getLastName(), 
	* This function is used to get last name in Account Last Name Text field in Edit Account Name Page
	*/
	public void getLastName(String lastname) {
		try {
			Utility.waitForElementToBeVisible(accntName.get(1));
			lName = accntName.get(1).getText();
			Assert.assertEquals(lName, lastname,"Last Name of the account is not matching.");
			Log.addMessage("Last Name entered");
		}catch(Exception e) {
			Log.addMessage("Last Name field is not visible");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Last Name field is not visible");
		}
		
	}
	
	/** 
	* Method Name: verifyAccountName(), 
	* This function is used to update First Name and Second Name in Edit field of  AccountName Page
	*/
		
	public void verifyAccountName(String firstname,String lastname) {
		try {
			getFirstName(firstname);
			getLastName(lastname);			
			//clickBack();
			System.out.println("updated");
			//Utility.simpleWait(15000);
			Log.addMessage("Account Name Updated and directed to AccountSettings page");
		}catch(Exception e) {
			Log.addMessage("Account Name Not Updated");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Account Name Not Updated");
		}
	}
	
	/** 
	* Method Name: clickBack(), 
	* This function is used to move back to AccountSettings Page
	*/
		
	public void clickBack() {
		try {
			Utility.waitForElementToBeVisible(navBack);
			Utility.waitForElementToBeClickable(navBack);
			navBack.click();
			Log.addMessage("Clicked Back button");
		}catch(Exception e) {
			Log.addMessage("Back button  is not visible");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Back button is not visible");
		}
	}
		
	/*  Code added on 07-07-2020  */
	/** 
	* Method Name: updateAccountName(), 
	* This function is used to update First Name and Second Name in Edit field of  AccountName Page
	*/
		
	public void updateAccountName(String firstname,String lastname, String errMessage, String iTitle,String iMessage) {
		try {
			updateFirstName(firstname);
			updateLastName(lastname);	
			if(device.equals("iOS")) {
				doneKeyboard.click();
			}else {
				clickNextButton();
			}
            //Utility.simpleWait(2000);		
			System.out.println("updated");
			if(device.equals("iOS")) {
				if(iTitle!="" && OKButton.isDisplayed()) {
					if(iTitle!="") {
						actTitle=alertTitle.getText();
						actMessage=confirmMessage.getText();
					}else {
						actMessage=confirmMessage.getText();
					}
					setErrMsg(iMessage, actMessage, iTitle, actTitle);
				}
			}else {
				if(errMessage!="" && OKButton.isDisplayed()) {
					actMessage=confirmMessage.getText();
					setErrMsg(errMessage, actMessage, "", "");
				}
			}
			Utility.simpleWait(2000);
			Log.addMessage("Account Name Updated and directed to AccountSettings page");
		}catch(Exception e) {
			Log.addMessage("Account Name Not Updated");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Account Name Not Updated");
		}
	}
	
	public void setErrMsg(String exRes, String mnMsg, String ttlMsg, String actTtl) {
		try {
			System.out.println("in errmsg");
			if(exRes!="") {
				System.out.println("in errmsg2");
				if(OKButton.isDisplayed()) {
					System.out.println("in confirmVerificationButton");
					OKButton.click();
					if(device.equals("iOS")) {
						if(ttlMsg!="") {
							actTitle = actTtl;
							System.out.println("actTitle---="+actTitle+", expttl="+ttlMsg);
							Assert.assertEquals(actTitle, ttlMsg,"Please check the title validation message.");
					}
					}
					actualRes =mnMsg;
					//System.out.println("in actualRes="+confirmMessage.getText());
				}
				System.out.println("out errmsg");
				Assert.assertEquals(actualRes, exRes,"Please check the validation message.");
			}
		}catch(Exception e) {
			System.out.println("catch errmssg");
			e.printStackTrace();
			Assert.assertEquals(false, "Expected message is null.");
		}
	}
}