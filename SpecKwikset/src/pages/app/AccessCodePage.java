package pages.app;

import java.util.List;

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

public class AccessCodePage extends Settings{
	
	//@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='add access code user']")//commented on 29-05-2020
	@iOSXCUITFindBy(id = "Back")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/cancelAllhomes"),
		@AndroidBy(id = "com.kwikset.blewifi:id/cancelAllhomes"),
		@AndroidBy(id = "com.spectrum.giga:id/cancelAllhomes"),
		@AndroidBy(id = "com.weiser.blewifi:id/cancelAllhomes")
	})
	@CacheLookup
	private MobileElement backButton;
		
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(text(),'Code:')]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/cancelAllhomes"),
		@AndroidBy(id = "com.kwikset.blewifi:id/cancelAllhomes"),
		@AndroidBy(id = "com.spectrum.giga:id/cancelAllhomes"),
		@AndroidBy(id = "com.weiser.blewifi:id/cancelAllhomes")
	})
	@CacheLookup		
	private MobileElement codePin;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_schedule_type"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_schedule_type"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_schedule_type"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_schedule_type")
	})
	@CacheLookup
	private MobileElement scheduleType;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[2]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/txtShareAccessCode"),
		@AndroidBy(id = "com.kwikset.blewifi:id/txtShareAccessCode"),
		@AndroidBy(id = "com.spectrum.giga:id/txtShareAccessCode"),
		@AndroidBy(id = "com.weiser.blewifi:id/txtShareAccessCode")
	})
	@CacheLookup
	private MobileElement shareAccessCode;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name='Disable Access Code']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/switch_deleteAccessCode"),
		@AndroidBy(id = "com.kwikset.blewifi:id/switch_deleteAccessCode"),
		@AndroidBy(id = "com.spectrum.giga:id/switch_deleteAccessCode"),
		@AndroidBy(id = "com.weiser.blewifi:id/switch_deleteAccessCode")
	})
	@CacheLookup
	private MobileElement disableAccessCode;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Edit Access Code']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/txtEditPinCode"),
		@AndroidBy(id = "com.kwikset.blewifi:id/txtEditPinCode"),
		@AndroidBy(id = "com.spectrum.giga:id/txtEditPinCode"),
		@AndroidBy(id = "com.weiser.blewifi:id/txtEditPinCode")
	})
	@CacheLookup
	private MobileElement editAccessCode;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Edit Code Name']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/txtEditName"),
		@AndroidBy(id = "com.kwikset.blewifi:id/txtEditName"),
		@AndroidBy(id = "com.spectrum.giga:id/txtEditName"),
		@AndroidBy(id = "com.weiser.blewifi:id/txtEditName")
	})
	@CacheLookup
	private MobileElement editCodeName;
	
	//@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Delete Access Code']")//commented on 16-11-2020
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Delete']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/txtDeleteAccessCode"),
		@AndroidBy(id = "com.kwikset.blewifi:id/txtDeleteAccessCode"),
		@AndroidBy(id = "com.spectrum.giga:id/txtDeleteAccessCode"),
		@AndroidBy(id = "com.weiser.blewifi:id/txtDeleteAccessCode")
	})
	@CacheLookup
	private MobileElement deleteAccessCode;
	
	By delCode= By.xpath("//XCUIElementTypeStaticText[@name='Delete']");
	By delCodeAn= By.xpath("//android.widget.TextView[@name='Delete']");
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Yes']")
	@AndroidFindBy(id = "android:id/button1")
	@CacheLookup
	private MobileElement yesButton;
	
	//added on 29-05-2020
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='fingerprint_icon']")
	@CacheLookup
	private List<MobileElement> fingerPrints;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Schedule Type']")
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/llScheduleType")
	@CacheLookup
	private MobileElement scheduleLabel;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeCell[1]")
	@CacheLookup
	private MobileElement scheduleButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeCell[4]//XCUIElementTypeStaticText")
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/txtFingerprint1")
	@CacheLookup
	private MobileElement fPDigitType1;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeCell[5]//XCUIElementTypeStaticText")
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/txtFingerprint2")
	@CacheLookup
	private MobileElement fPDigitType2;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Save']")
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/txtSave")
	@CacheLookup
	private MobileElement saveButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Right']")
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/txtRight")
	@CacheLookup
	private MobileElement rightButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Left']")
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/txtLeft")
	@CacheLookup
	private MobileElement leftButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Index']")
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/txtIndex")
	@CacheLookup
	private MobileElement indexButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Thumb']")
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/txtThumb")
	@CacheLookup
	private MobileElement thumbButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Middle']")
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/txtMiddle")
	@CacheLookup
	private MobileElement middleButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Ring']")
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/txtRing")
	@CacheLookup
	private MobileElement ringButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Little']")
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/txtLittle")
	@CacheLookup
	private MobileElement littleButton;
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='fingerprint_icon']/following-sibling::XCUIElementTypeStaticText[@name='Add New Fingerprint']")
	@CacheLookup
	private MobileElement addNewFP;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Add New Fingerprint']")
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/txtFingerprint2")
	@CacheLookup
	private MobileElement addNewFPLabel;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='delete']")
	@CacheLookup
	private List <MobileElement> lstDeleteButton;
	
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/imgFingerprint1")
	@CacheLookup
	private MobileElement deleteButton1;
	
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/imgFingerprint2")
	@CacheLookup
	private MobileElement deleteButton2;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Ok']")
	@CacheLookup
	private MobileElement okButton;
	
	String fpText = "";
	int delCount = 0;
	boolean newFPOptPresent = false;
	
	//Constructor
	@SuppressWarnings("static-access")
	public AccessCodePage(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
		
		
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void getAccessCodePin() {
		try {
			Thread.sleep(6000);
			Log.addMessage("Access code Pin is: "+codePin.getText());
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to get access code pin");
			Assert.assertTrue(false, "Failed to get access code pin");
		}
	}
	
	
	public void getScheduleType() {
	  try {
		  Thread.sleep(6000);
		  Log.addMessage("Schedule Type is: "+scheduleType.getText());
	  }catch(Exception e) {
		  Log.addMessage(e.getMessage().toString());
		  Log.addMessage("Failed to get schedule type of the access code");
		  Assert.assertTrue(false, "Failed to get schedule type of the access code");
	  }
	}
	
	public void editScheduleType() {
		  try {
			  Thread.sleep(6000);
			  scheduleType.click();
			  Log.addMessage("Schedule Type is clicked");
		  }catch(Exception e) {
			  Log.addMessage(e.getMessage().toString());
			  Log.addMessage("Failed to click schedule type of the access code");
			  Assert.assertTrue(false, "Failed to click schedule type of the access code");
		  }
		}
	
	public void clickShareAccessCode() {
		  try {
			  Thread.sleep(6000);
			  shareAccessCode.click();
			  Log.addMessage("Share Access Code button is clicked");
		  }catch(Exception e) {
			  Log.addMessage(e.getMessage().toString());
			  Log.addMessage("Failed to click share access code button");
			  Assert.assertTrue(false, "Failed to click share access code button");
		  }
		}
	
	public void disableAccessCode() {
		  try {
			  Thread.sleep(6000);
			  disableAccessCode.click();
			  Log.addMessage("Access Code is disabled");
		  }catch(Exception e) {
			  Log.addMessage(e.getMessage().toString());
			  Log.addMessage("Failed to disable access code");
			  Assert.assertTrue(false, "Failed to disable access code");
		  }
		}
	
	public void clickEditAccessCode() {
		  try {
			  Thread.sleep(6000);
			  editAccessCode.click();
			  Log.addMessage("Edit Access Code button is clicked");
		  }catch(Exception e) {
			  Log.addMessage(e.getMessage().toString());
			  Log.addMessage("Failed to click edit access code button");
			  Assert.assertTrue(false, "Failed to click edit access code button");
		  }
		}
	
	public void clickEditCodeName() {
		  try {
			  Thread.sleep(6000);
			  editCodeName.click();
			  Log.addMessage("Edit Code Name button is clicked");
		  }catch(Exception e) {
			  Log.addMessage(e.getMessage().toString());
			  Log.addMessage("Failed to click edit code name button");
			  Assert.assertTrue(false, "Failed to click edit code name button");
		  }
		}
	
	public void deleteAccessCode() {
		  try {
			  //Thread.sleep(6000);
			  if(device.equals("iOS")) {
				  Utility.waitForElementClickable(delCode, appiumDriver);
			  }else {
				 // Utility.waitForElementClickable(delCodeAn, appiumDriver);
				  Utility.waitForElementToBeVisible(deleteAccessCode);
				  Utility.waitForElementToBeClickable(deleteAccessCode);
			  }
			  System.out.println("after");
			  deleteAccessCode.click();
			  yesButton.click();
			  Log.addMessage("Access Code button is deleted");
		  }catch(Exception e) {
			  Log.addMessage(e.getMessage().toString());
			  Log.addMessage("Failed to delete access code");
			  Assert.assertTrue(false, "Failed to delete access code");
		  }
		}
	
	public void deleteUserProfile() {
		  try {
			  Thread.sleep(6000);
			  deleteAccessCode.click();
			  Log.addMessage("Delete access code button is clicked");
			  Assert.assertTrue(true, "Delete access code button is clicked");
		  }catch(Exception e) {
			  Log.addMessage(e.getMessage().toString());
			  Log.addMessage("Failed to delete access code");
			  Assert.assertTrue(false, "Failed to delete access code");
		  }
		}
	
	
	@SuppressWarnings("unchecked")
	public void fetchGivenAccessCode(String accessCode) {
	  try {
		 List<MobileElement> listOfAccessCodes = (List<MobileElement>) driver.findElement(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell"));
		 for(int i =0; i<=listOfAccessCodes.size();i++) {
		 String accessCodeName = driver.findElement(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell["+i+"]")).getText();
		 if (accessCodeName.equals(accessCode)) {
			 driver.findElement(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell["+i+"]")).click();
		 }
		 }
	  }catch(Exception e) {
		  Log.addMessage(e.getMessage().toString());
		  Log.addMessage("Failed to get the required access code");
		  Assert.assertTrue(false, "Failed to get the required access code");
	  }
	 }
	
	public void verifyUIFPUserProfile() throws InterruptedException {
		try {
			Utility.simpleWait(10000);
			System.out.println("in1");
			Utility.waitForElementToBeVisible(backButton);
			Assert.assertTrue(true, "Back button displayed in the UI for editing finger Print userprofile");
			System.out.println("in2");
			Utility.waitForElementToBeVisible(scheduleLabel);
			Assert.assertTrue(true, "Schedule Type displayed in the UI of finger Print userprofile");
			System.out.println("in3");
			Utility.waitForElementToBeVisible(disableAccessCode);
			Assert.assertTrue(true, "Disable access code button displayed in the UI of finger Print userprofile");
			System.out.println("in4");
			Utility.waitForElementToBeVisible(editCodeName);
			Assert.assertTrue(true, "Edit code name displayed in the UI of finger Print userprofile");
			System.out.println("in5");
			//Utility.waitForElementToBeVisible(fingerPrints.get(0));
			//Assert.assertTrue(true, "Finger print button displayed in the UI for selecting finger Print username");
			System.out.println("in6");
			Utility.waitForElementToBeVisible(deleteAccessCode);
			Assert.assertTrue(true, "Delete access code button displayed in the UI of finger Print userprofile");
			System.out.println("in7");
		}catch(Exception e) {
			Log.addMessage("Failed to display all elements in UI for FP username view page");
			Assert.assertTrue(false, "Failed to display all elements in UI for FP username view page");
		}
	}
	
	public void clickFingerPrint1() {
		  try {
			  Thread.sleep(6000);
			  fPDigitType1.click();
			  Log.addMessage("Fingerprint1 clicked");
		  }catch(Exception e) {
			  Log.addMessage(e.getMessage().toString());
			  Log.addMessage("Failed to click Fingerprint1");
			  Assert.assertTrue(false, "Failed to click Fingerprint1");
		  }
	}
	
	public void clickFingerPrint2() {
		  try {
			  Thread.sleep(6000);
			  fPDigitType2.click();
			  Log.addMessage("Fingerprint2 clicked");
		  }catch(Exception e) {
			  Log.addMessage(e.getMessage().toString());
			  Log.addMessage("Failed to click Fingerprint2");
			  Assert.assertTrue(false, "Failed to click Fingerprint2");
		  }
	}
	
	public String getFingerPrintText() {
		  try {
			  Thread.sleep(6000);
			  fpText =  fPDigitType1.getText();
			  Log.addMessage("Fingerprint1 clicked");
			  return fpText;
		  }catch(Exception e) {
			  Log.addMessage(e.getMessage().toString());
			  Log.addMessage("Failed to click Fingerprint1");
			  return fpText;
			  //Assert.assertTrue(false, "Failed to click Fingerprint1");
		  }
		  
	}
	
	public void clickRightButton() {
		  try {
			  Thread.sleep(6000);
			  rightButton.click();
			  Log.addMessage("Right option selected");
		  }catch(Exception e) {
			  Log.addMessage(e.getMessage().toString());
			  Log.addMessage("Failed to select Right option");
			  Assert.assertTrue(false, "Failed to select Right option");
		  }
	}
	
	public void clickLeftButton() {
		  try {
			  Thread.sleep(6000);
			  leftButton.click();
			  Log.addMessage("Left option selected");
		  }catch(Exception e) {
			  Log.addMessage(e.getMessage().toString());
			  Log.addMessage("Failed to select Left option");
			  Assert.assertTrue(false, "Failed to select Left option");
		  }
	}
	
	public void clickIndexButton() {
		  try {
			  Thread.sleep(2000);
			  indexButton.click();
			  Log.addMessage("Index option selected");
		  }catch(Exception e) {
			  Log.addMessage(e.getMessage().toString());
			  Log.addMessage("Failed to select index option");
			  Assert.assertTrue(false, "Failed to select index option");
		  }
	}
	public void selectAFinger(String finger) {
		try {
			Thread.sleep(6000);
			
			switch(finger) {
			
			case "Thumb" : thumbButton.click();
			break;
							
			case "Index" : indexButton.click();
			break;
			
			case "Middle" : middleButton.click();
			break;
			
			case "Ring" : ringButton.click();
			break;
			
			case "Little" : littleButton.click();
			break;
			
			default: indexButton.click();
			break;
							
			}
		  Log.addMessage("Selected Finger is: "+finger);
		}catch(Exception e) {
			Log.addMessage("Failed to select a day");
			Assert.assertTrue(false, "Failed to select a day");
		}
	}
	
	public void clickSaveButton() {
		  try {
			  Thread.sleep(2000);
			  saveButton.click();
			  Log.addMessage("Saved the selection");
		  }catch(Exception e) {
			  Log.addMessage(e.getMessage().toString());
			  Log.addMessage("Failed to save the options");
			  Assert.assertTrue(false, "Failed to save the options");
		  }
	}
	
	public void clickScheduleButton() {
		  try {
			  Utility.simpleWait(2000);
			  Utility.waitForElementToBeVisible(scheduleButton);
			  scheduleButton.click();
			  Assert.assertTrue(true, "Clicked schedule type button");
			  Log.addMessage("Clicked schedule type button");
		  }catch(Exception e) {
			  Log.addMessage(e.getMessage().toString());
			  Log.addMessage("Failed to click schedule type button");
			  Assert.assertTrue(false, "Failed to click schedule type button");
		  }
	}
	
	public boolean checkAddNewFP() throws InterruptedException {
		try {
		    Utility.simpleWait(3000);
		    Utility.waitForElementToBeVisible(addNewFPLabel);
		    newFPOptPresent=true;
		    Log.addMessage("Add New Fingerprint option available for the profile");
		    return newFPOptPresent;
		}catch(Exception e) {
			 
			  Log.addMessage(e.getMessage().toString());
			  Log.addMessage("Failed to display Add New Fingerprint option");
			  return newFPOptPresent;
			 // Assert.assertTrue(false, "Failed to display Add New Fingerprint option");
			 
		}
		
	}
	
	public boolean deleteFingerPrint(int fpcnt) throws InterruptedException {
		try {
		    Utility.simpleWait(3000);
		    if(device.equals("iOS")) {
			    if(lstDeleteButton.size()>1) {
			    	if(fpcnt==0) {
			    		lstDeleteButton.get(0).click();
			    		 Assert.assertTrue(true, "Fingerprint1 deleted");
			    	}else {
			    		lstDeleteButton.get(1).click();
			    	 	Assert.assertTrue(true, "Fingerprint2 deleted");
			    	}
			    	 Log.addMessage("One FP profile deleted");
			    }else {
			    	Assert.assertTrue(false, "Fingerprint cannot be deleted, no delete option available");
			    	Log.addMessage("Fingerprint cannot be deleted, no delete option available");
			    }
		    } else {
		    	if(fpcnt==0) {
		    		deleteButton1.click();
		    		 Assert.assertTrue(true, "Fingerprint1 deleted");
		    	}else {
		    		deleteButton2.click();
		    		Assert.assertTrue(true, "Fingerprint2 deleted");
		    	}
		    	Log.addMessage("One FP profile deleted");
		    }
		    
		}catch(Exception e) {
			  Log.addMessage(e.getMessage().toString());
			  Log.addMessage("Failed to delete fingerprint, no delete option available");
			  Assert.assertTrue(false, "Failed to delete fingerprint, no delete option available");
		}
		return newFPOptPresent;
	}
	
	public int checkDeleteButton() throws InterruptedException {
		try {
		    Utility.simpleWait(3000);
		    if(device.equals("iOS")) {
		    	 delCount = lstDeleteButton.size();
		    	 return delCount;
		    }else {
		    	Utility.waitForElementToBeVisible(deleteButton1);
		    	delCount=1;
		    	return delCount;
		    }
		   
		    
		}catch(Exception e) {
			  Log.addMessage(e.getMessage().toString());
			  Log.addMessage("Failed to find delete button");
			  return delCount;
		}
		
	}
	
	public void clickBackButton() throws InterruptedException {
		try {
		    Utility.simpleWait(3000);
		    backButton.click();
		    Log.addMessage("Clicked back button");
		}catch(Exception e) {
			  Log.addMessage(e.getMessage().toString());
			  Log.addMessage("Failed to find back button");
		}
		
	}
	
	public void clickOkButton() throws InterruptedException {
		try {
		    Utility.simpleWait(3000);
		    System.out.println("in ok");
		    okButton.click();
		    Log.addMessage("Clicked ok button");
		}catch(Exception e) {
			  Log.addMessage(e.getMessage().toString());
			  Log.addMessage("Failed to find ok button");
		}
		
	}
	
	
	
}
