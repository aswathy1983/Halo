package pages.app;

import java.util.List;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import utility.Log;
import utility.Utility;

public class FPUserScheduleTypePage  extends Settings{

	/*                  Created on 13-05-2020                  */
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField")
	@AndroidFindBy(xpath="//android.widget.EditText")
	@CacheLookup
	private MobileElement userNameText;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name='Clear text']")
	@AndroidFindBy(xpath="//android.widget.ImageButton")
	@CacheLookup
	private MobileElement ClearButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView")
	@CacheLookup
	private List<MobileElement> lstLabel;
	
	//added on 20-05-2020
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton")
	@CacheLookup
	private List<MobileElement> lstSchedule;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Schedule Type']")
	@CacheLookup
	private MobileElement lblSchType;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Any Time']")
	@CacheLookup
	private MobileElement edtSchType;
	
	@iOSXCUITFindBy(id="Schedule Type")
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/ll_schedule_type")
	@CacheLookup
	private MobileElement schType;
	
	@iOSXCUITFindBy(id="Submit")
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/tv_submit")
	@CacheLookup
	private MobileElement submitButton;
	
	@iOSXCUITFindBy(id="Back")
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/cancelAllhomes")
	@CacheLookup
	private MobileElement backButton;
	
	@iOSXCUITFindBy(id="Ok")
	@AndroidFindBy(id="android:id/button1")
	private MobileElement confirmVerificationButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeAlert//XCUIElementTypeStaticText")
	@AndroidFindBy(id="android:id/message")
	private MobileElement confirmMessage;
	
	@AndroidFindBy(id="android:id/alertTitle")
	private MobileElement alertTitle;
	
	int toastSz=0;
	String userNm, actualRes, toastMessage, lkTxtName, actTitleMsg, schTypeName="";
	
	//Constructor
	@SuppressWarnings("static-access")
	public FPUserScheduleTypePage(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
	
	/** 
	* Method Name: getUserName(), 
	* This function is used to get user name 
	*/
	
	public String getUserName() {
		try {
			Thread.sleep(3000);
			Utility.waitForElementToBeVisible(userNameText);
			Utility.waitForElementToBeClickable(userNameText);
			userNm = userNameText.getText();
			Log.addMessage("Get user name");
		} catch (InterruptedException e) {
			Log.addMessage("Failed to display user name");
			Assert.assertTrue(false, "Failed to display user name");
		}
		return userNm;
	}
	
	/** 
	* Method Name: getSchType(), 
	* This function is used to get schedule type 
	*/
	
	public String getSchType() {
		try {
			Thread.sleep(3000);
			Utility.waitForElementToBeVisible(lstLabel.get(5));
			Utility.waitForElementToBeClickable(lstLabel.get(5));
			schTypeName = lstLabel.get(5).getText();
			Log.addMessage("Get schedule type selected");
		} catch (InterruptedException e) {
			Log.addMessage("Failed to display schedule type");
			Assert.assertTrue(false, "Failed to display schedule type");
		}
		return schTypeName;
	}
	
	/** 
	* Method Name: getSchTypeiOS(), 
	* This function is used to get schedule type 
	*/
	
	public String getSchTypeiOS() {
		try {
			Thread.sleep(3000);
			System.out.println("schTypeName="+schTypeName);
			//Utility.waitForElementToBeVisible(lstLabel.get(3));
			//Utility.waitForElementToBeClickable(lstLabel.get(3));
			System.out.println("schTypeName="+edtSchType.getText());
			schTypeName = edtSchType.getText();
			Log.addMessage("Get schedule type selected");
		} catch (InterruptedException e) {
			Log.addMessage("Failed to display schedule type");
			Assert.assertTrue(false, "Failed to display schedule type");
		}
		return schTypeName;
	}
	
	/** 
	* Method Name: editUserName(), 
	* This function is used to enter user name in user schedule type page
	*/
		
	public void editUserName(String usrNm) {
		try {
			Thread.sleep(3000);
			System.out.println("in enter user name");
			userNameText.clear();
			
			System.out.println("in  clear user name");
			userNameText.sendKeys(usrNm);
			System.out.println("in user name method");
			Log.addMessage("Entered user name");
		}catch(Exception e) {
			Log.addMessage("Failed to enter user name");
			Assert.assertTrue(false, "Failed to enter user name");
		}
	}
	
	/** 
	* Method Name: labelScheduleVisible(), 
	* This function is used to check if schedule type text is displayed in the page
	*/
		
	public void labelScheduleVisible() {
		try {
			//added on 20-05-2020
			if(device.equals("iOS")) {
				System.out.println("in schtype buttob 2="+lblSchType);
				Thread.sleep(3000);
				//Utility.waitForElementToBeVisible(lblSchType);
				System.out.println("in schtype buttob -2"+lblSchType.getText());
			}else
			Utility.waitForElementToBeVisible(lstLabel.get(5));
			System.out.println("in schedule label2");
			Log.addMessage("Displayed schedule type label");
		}catch(Exception e) {
			Log.addMessage("Failed to display schedule type label");
			Assert.assertTrue(false, "Failed to display schedule type label");
		}
	}
	
	
	/** 
	* Method Name: clickScheduleType(), 
	* This function is used to click schedule type 
	*/
		
	public void clickScheduleType() {
		try {
			System.out.println("in click schedule type");
			if(device.equals("iOS")) {
				System.out.println("in click schedule type ios");
				Utility.waitForElementToBeVisible(lstSchedule.get(2));
				System.out.println("in click schedule type wait");
				lstSchedule.get(2).click();
				System.out.println("in click schedule type click");
			}else
			schType.click();
			System.out.println("in click schedule type2");
			Log.addMessage("Clicked schedule type button");
		}catch(Exception e) {
			Log.addMessage("Failed to click schedule type");
			Assert.assertTrue(false, "Failed to click schedule type");
		}
	}
	
	/** 
	* Method Name: displaySubmit(), 
	* This function is used to verify if submit button is displayed 
	*/
	
	public void displaySubmit() {
		try {
			Utility.waitForElementToBeVisible(submitButton);
			Utility.waitForElementToBeClickable(submitButton);
			Log.addMessage("Submit button present");
		}catch(Exception e) {
			Log.addMessage("Failed to display Submit button");
			Assert.assertTrue(false, "Failed to display Submit button");
		}
		
	}
	
	/** 
	* Method Name: clickSubmitButton(), 
	* This function is used to click submit button 
	*/
	
	public void clickSubmitButton() {
		try {
			Thread.sleep(2000);
			submitButton.click();
			Log.addMessage("Clicked submit button");
		}catch(Exception e) {
			Log.addMessage("Failed to click submit button");
			Assert.assertTrue(false, "Failed to click submit button");
		}
	}
	
	/** 
	* Method Name: displayBackButton(), 
	* This function is used to verify back button 
	*/
	
	public void displayBackButton() {
		try {
			Utility.waitForElementToBeVisible(backButton);
			Utility.waitForElementToBeClickable(backButton);
			Log.addMessage("Back button present");
		}catch(Exception e) {
			Log.addMessage("Failed to display back button");
			Assert.assertTrue(false, "Failed to display back button");
		}
		
	}
	
	/** 
	* Method Name: clickBackButton(), 
	* This function is used to click back button 
	*/
	
	public void clickBackButton() {
		try {
			Thread.sleep(3000);
			System.out.println("in user schedule back button");
			backButton.click();
			Log.addMessage("Clicked back button in user schedule page");
		}catch(Exception e) {
			Log.addMessage("Failed to click back button in user schedule page");
			Assert.assertTrue(false, "Failed to click back button in user schedule page");
		}
	}
	/** 
	* Method Name: valUserName(), 
	* This function is used to validate user name 
	*/
	
	public void valUserName(String userName, String tMsg,  String errMessage) {
		try {
				Utility.simpleWait(4000);
				System.out.println("in valUserName validation");
				editUserName(userName);	
				System.out.println("set username="+userName);	
				
				clickSubmitButton();	
				
				System.out.println("updated out");
				
				if(errMessage!="") {
					System.out.println("three");
					setErrMsg(errMessage,tMsg);	
				}
				System.out.println("toastMessage="+toastMessage);
				Log.addMessage("Username updated and directed to checklist page");
		}catch(Exception e) {
			Log.addMessage("Username not updated");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Username not updated");
		}
	}
	
	/** 
	* Method Name: valUserName(), 
	* This function is used to validate user name 
	*/
	
	public void valUserNameiOS(String userName, String errMessage) {
		try {
				//Utility.simpleWait(4000);
				System.out.println("in valUserName validation");
				editUserName(userName);	
				System.out.println("set username="+userName);	
				
				clickSubmitButton();	
				
				System.out.println("updated out");
				
				if(errMessage!="") {
					System.out.println("three");
					setErrMsg(errMessage,"");	
				}
				System.out.println("toastMessage="+toastMessage);
				Log.addMessage("Username updated and directed to checklist page");
		}catch(Exception e) {
			Log.addMessage("Username not updated");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Username not updated");
		}
	}


	/** 
	* Method Name: setErrMsg(), 
	* This function is used to verify if error message while validating is matching with expected
	*/
	
	public void setErrMsg(String exRes,String exptitle) {
		try {
			if(exRes!="") {
				
				if(exptitle!="" && alertTitle.getText()!="") {//condition changed on 20-05-2020
					actTitleMsg = alertTitle.getText();
					actualRes = confirmMessage.getText();
					confirmVerificationButton.click();
					Assert.assertEquals(actTitleMsg, exptitle,"Please check the title verbiage of the popup");
					Log.addMessage("Title not matching");
				}else { //added on 20-05-2020
					actualRes = confirmMessage.getText();
					confirmVerificationButton.click();
					System.out.println("in else val");
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


	//com.kwikset.blewifi.dev:id/tv_done
}
