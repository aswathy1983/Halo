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

public class AddAccessCodePage extends Settings{
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[1]")
	@AndroidFindBy(xpath = "//android.widget.EditText")
	@CacheLookup
	private MobileElement accessCodeNameField;
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[2]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/edt_code"),
		@AndroidBy(id = "com.kwikset.blewifi:id/edt_code"),
		@AndroidBy(id = "com.spectrum.giga:id/edt_code"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/edt_code")
	})
	@CacheLookup
	private MobileElement acceessCodePinField;
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Submit']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_submit"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_submit"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_submit"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/tv_submit")
	})
	@CacheLookup
	private MobileElement submitButton;
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Generate Random Code']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/btn_manage"),
		@AndroidBy(id = "com.kwikset.blewifi:id/btn_manage"),
		@AndroidBy(id = "com.spectrum.giga:id/btn_manage"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/btn_manage")
		//@AndroidBy(id = "com.weiser.blewifi:id/btn_manage")
	})
	@CacheLookup
	private MobileElement generateRandomCodeButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeButton[1]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_schedule_type"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_schedule_type"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_schedule_type"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/tv_schedule_type")
		//@AndroidBy(id = "com.weiser.blewifi:id/btn_manage")
	})
	@CacheLookup
	private MobileElement schTypeButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton")
	@AndroidFindBy(id = "com.kwikset.blewifi.dev:id/alert")
	@CacheLookup
	private MobileElement invalidAccesscodeAlert;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton")
	@AndroidFindBy(id = "com.kwikset.blewifi.dev:id/alert")
	@CacheLookup
	private MobileElement okButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name='Cancel']")
	@AndroidFindBy(id = "android:id/button2")//added on 6-05-2021
	@CacheLookup
	private MobileElement CancelPairButton;
		
	//added on 10-06-2020
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name='Ok']")
	@AndroidFindBy(id = "android:id/button1")//added on  6-05-2021
	@CacheLookup
	private MobileElement OKButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[1]")
	@AndroidFindBy(id="android:id/alertTitle")
	@CacheLookup
	private MobileElement alertTitle;
	
	//added on 15 Jan 2021
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[2]")
	@AndroidFindBy(id = "android:id/message")
	@CacheLookup
	private MobileElement popUpMessageVerbiage;
	
	String titleMessage, actMessage ="";
	boolean okButtonPresent = false;
	By okBtn= By.xpath("//XCUIElementTypeButton[@name='Ok']");
	By okAnBtn= By.id("android:id/button1");
	

	//Constructor
		@SuppressWarnings("static-access")
		public AddAccessCodePage(AppiumDriver<MobileElement> driver) {
			this.appiumDriver = driver;
			PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
		}
		
		
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void enterAccessCodeName(String name) {
		try {	
			Utility.simpleWait(8000);
			Assert.assertTrue(accessCodeNameField.isEnabled(), "Access code name fied not displayed");
			accessCodeNameField.clear();
	    	accessCodeNameField.sendKeys(name);
			Log.addMessage("Access Code Name entered");
		}catch(Exception e) {
			try {
				Utility.waitForElementToBeVisible(alertTitle);
				titleMessage = alertTitle.getText();
				System.out.println("titleMessage="+titleMessage);
				Log.addMessage("Failed to click Add access code button as "+ titleMessage);
				Assert.assertTrue(false, "Failed to click Add access code button as "+ titleMessage);
			}catch(Exception ex) {
				Log.addMessage(ex.getMessage().toString());
				Log.addMessage("Failed to click Add access code button");
				Assert.assertTrue(false, "Failed to click Add access code button");
			}
		}
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void clickGenerateRandomCodeButton() {
		try {
	    	Utility.waitForElementToBeVisible(generateRandomCodeButton);
	    	Utility.waitForElementToBeClickable(generateRandomCodeButton);	
	    	generateRandomCodeButton.click();
			Log.addMessage("Clicked 'Generate Random Code' Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click 'Generate Random Code' button");
			Assert.assertTrue(false, "Failed to click 'Generate Random Code' button");
		}
	}
	
	/**  
	 * 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void clickSubmitButton() {
		try {
	    	Utility.waitForElementToBeVisible(submitButton);
	    	Utility.waitForElementToBeClickable(submitButton);
	    	submitButton.click();
			Log.addMessage("Clicked Submit Button");
			utility.Utility.simpleWait(8000);
		}catch(Exception e) {
			Log.addMessage("Failed to click Submit button");
			Assert.assertTrue(false, "Failed to click Submit button");
		}
	}

	/**  
	 * 
	* Method Name: clickSchTypeButton() for Halo lock, 
	* This function is used to click schedule type option
	*/
		
	public void clickSchTypeButton() {
		try {
	    	Utility.waitForElementToBeVisible(schTypeButton);
	    	Utility.waitForElementToBeClickable(schTypeButton);
	    	schTypeButton.click();
			Log.addMessage("Clicked schedule type Button");
			Utility.simpleWait(8000);
		}catch(Exception e) {
			Log.addMessage("Failed to click schedule type button");
			Assert.assertTrue(false, "Failed to click schedule type button");
		}
	}
	
	public void checkForInvalidAccessCodeAlert() {
		 try {
			 Utility.waitForElementToBeVisible(invalidAccesscodeAlert);
			 Assert.assertTrue(invalidAccesscodeAlert.isDisplayed(), "Invalid access alert displayed");
			 
			 //try once again with another access code
			
			 okButton.click();
			 clickGenerateRandomCodeButton();
			 clickSubmitButton();
			 Log.addMessage("Invalid Access Code Alert is displayed.");
			 
		 }catch(Exception e) {
			 
		}
	}
	
	public boolean checkHandlePopUp() {
		try {
			okButtonPresent=false;
			if(device.equals("iOS")) {
				 Utility.waitForElementPresent(okBtn,appiumDriver);
			}else {
				 Utility.waitForElementPresent(okAnBtn,appiumDriver);
			}
		    System.out.println("in ok");
		    okButtonPresent=true;
		    Log.addMessage("Popup found");
		    return okButtonPresent;
		   
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Popup not found");
			System.out.println("in catch Pair Popup not found");
			try {
				if(device.equals("iOS")) {
					 driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Pair']"));
				}else {
					driver.findElement(By.id("android:id/button1"));
				}
				 okButtonPresent =true;
				 Log.addMessage("Pair popup found");
				 return okButtonPresent;
			}catch(Exception ex) {
				Log.addMessage(ex.getMessage().toString());
				Log.addMessage("Popup not found");
				System.out.println("in catch Pair Popup not found");
				try {
					if(device.equals("iOS")) {
						driver.findElement(By.xpath("//XCUIElementTypeButton[@name='SETTINGS']"));
					}else {
						driver.findElement(By.id("android:id/button1"));
					}
					okButtonPresent =true;
					Log.addMessage("Internet popup found");
					return okButtonPresent;
				}catch(Exception ep) {
					Log.addMessage(ep.getMessage().toString());
					Log.addMessage("Internet Popup not found");
					System.out.println("in catch Internet Popup not found");
					okButtonPresent=false;
					return okButtonPresent;
				}
			}
		}
	}
	
	public void clickCancelPairBtn() {
		try {
			//Thread.sleep(6000);//commented for bvt on 13-10-2020
			Utility.waitForElementToBeVisible(CancelPairButton);
			System.out.println("in cancel");
			Utility.waitForElementToBeClickable(CancelPairButton);
			System.out.println("in cancel");
			CancelPairButton.click();
			System.out.println("in cancel");
			Log.addMessage("Clicked pair cancel button");
		}catch(Exception e) {
			Log.addMessage("Failed to click pair cancel button ");
			//Assert.assertTrue(false, "Failed to click OK button");
		}
	}
	
	public void clickOKButton() {
		try {
			//Thread.sleep(6000);//commented for bvt on 13-10-2020
			Utility.waitForElementToBeVisible(OKButton);
			Utility.waitForElementToBeClickable(OKButton);
			OKButton.click();
			Log.addMessage("Clicked OK button");
		}catch(Exception e) {
			Log.addMessage("Failed to click OK button ");
			//Assert.assertTrue(false, "Failed to click OK button");
		}
	}

	public String verifyPopUpVerbiage() {
		try {
			System.out.println("in popup1 low battery verbiage");
			/*if(device.equals("iOS")) {
				Utility.simpleWait(3000);
			}*/
			titleMessage = "";
			actMessage = "";
			Utility.waitForElementToBeVisible(popUpMessageVerbiage);
			System.out.println("in popup2  verbiage");
			actMessage = popUpMessageVerbiage.getText();
			System.out.println("actMessage="+actMessage);
			System.out.println("titleMessageb4="+titleMessage);
			Utility.waitForElementToBeVisible(alertTitle);
			titleMessage = alertTitle.getText();
			System.out.println("titleMessageafter="+titleMessage);
			Log.addMessage("Title message displayed");
			if(titleMessage!=null) {
				System.out.println("inside not null titleMessage="+titleMessage);
				//to capture the message instead of title if lock battery too low as title displayed is "Alert"
				/*if(device.equals("android") && actMessage.contains("too low to operate")) {
					titleMessage = actMessage;
				}*/
			}else {
				System.out.println("in null titleMessage="+titleMessage);
				//to display the message in cases where there is no title in a pop up
				titleMessage = actMessage;
			}
			return titleMessage;
		}catch(Exception e) {
			Log.addMessage("Title message is not displayed");
			System.out.println("title not displayed");
			return titleMessage;
			//Assert.assertTrue(false, "Title message is not displayed");
		}
	}
}

