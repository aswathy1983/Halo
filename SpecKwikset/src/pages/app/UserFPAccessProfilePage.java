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

public class UserFPAccessProfilePage extends Settings{
	
	//@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='add access code user']")//commented on 29-05-2020
	@iOSXCUITFindBy(id = "Back")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/cancelAllhomes"),
		@AndroidBy(id = "com.kwikset.blewifi:id/cancelAllhomes"),
		@AndroidBy(id = "com.spectrum.giga:id/cancelAllhomes"),
		@AndroidBy(id = "com.weiser.blewifi:id/cancelAllhomes"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/cancelAllhomes")
	})
	@CacheLookup
	private MobileElement backButton;
		
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Code:')]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/txt_code"),
		@AndroidBy(id = "com.kwikset.blewifi:id/txt_code"),
		@AndroidBy(id = "com.spectrum.giga:id/txt_code"),
		@AndroidBy(id = "com.weiser.blewifi:id/txt_code"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/txt_code")
	})
	@CacheLookup		
	private MobileElement codePin;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_schedule_type"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_schedule_type"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_schedule_type"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_schedule_type"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/tv_schedule_type")
	})
	@CacheLookup
	private MobileElement scheduleType;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[2]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/txtShareAccessCode"),
		@AndroidBy(id = "com.kwikset.blewifi:id/txtShareAccessCode"),
		@AndroidBy(id = "com.spectrum.giga:id/txtShareAccessCode"),
		@AndroidBy(id = "com.weiser.blewifi:id/txtShareAccessCode"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/txtShareAccessCode")
	})
	@CacheLookup
	private MobileElement shareAccessCode;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name='Disable Fingerprints']")//added on 04-06-2020 for FP
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/switch_deleteAccessCode"),
		@AndroidBy(id = "com.kwikset.blewifi:id/switch_deleteAccessCode"),
		@AndroidBy(id = "com.spectrum.giga:id/switch_deleteAccessCode"),
		@AndroidBy(id = "com.weiser.blewifi:id/switch_deleteAccessCode"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/switch_deleteAccessCode")
	})
	@CacheLookup
	private MobileElement disableAccessCode;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name='Disable Access Code']")//added on 16-10-2020 for Halo
	@CacheLookup
	private MobileElement disableAcsCode;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Edit User Name']")//added on 04-06-2020 for FP
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/txtEditPinCode"),
		@AndroidBy(id = "com.kwikset.blewifi:id/txtEditPinCode"),
		@AndroidBy(id = "com.spectrum.giga:id/txtEditPinCode"),
		@AndroidBy(id = "com.weiser.blewifi:id/txtEditPinCode"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/txtEditPinCode")
	})
	@CacheLookup
	private MobileElement editAccessCode;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Edit Access Code']")//added on 16-10-2020 for Halo lock
	@CacheLookup
	private MobileElement editAcsCode;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Edit User Name']")//added on 04-06-2020 for FP
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/txtEditName"),
		@AndroidBy(id = "com.kwikset.blewifi:id/txtEditName"),
		@AndroidBy(id = "com.spectrum.giga:id/txtEditName"),
		@AndroidBy(id = "com.weiser.blewifi:id/txtEditName"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/txtEditName")
	})
	@CacheLookup
	private MobileElement editCodeName;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Edit Code Name']")//added on 16-10-2020 for Halo lock
	@CacheLookup
	private MobileElement editCdName;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Delete']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/txtDeleteAccessCode"),
		@AndroidBy(id = "com.kwikset.blewifi:id/txtDeleteAccessCode"),
		@AndroidBy(id = "com.spectrum.giga:id/txtDeleteAccessCode"),
		@AndroidBy(id = "com.weiser.blewifi:id/txtDeleteAccessCode"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/txtDeleteAccessCode")
	})
	@CacheLookup
	private MobileElement deleteAccessCode;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Yes']")
	@AndroidFindBy(id = "android:id/button1")
	@CacheLookup
	private MobileElement yesButton;
	
	//added on 29-05-2020
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='fingerprint_icon']")
	@CacheLookup
	private List<MobileElement> fingerPrints;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Schedule Type']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/llScheduleType"),
		@AndroidBy(id = "com.kwikset.blewifi:id/llScheduleType"),
		@AndroidBy(id = "com.spectrum.giga:id/llScheduleType"),
		@AndroidBy(id = "com.weiser.blewifi:id/llScheduleType"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/llScheduleType")
	})
	@CacheLookup
	private MobileElement scheduleLabel;
	
	//@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeCell[1]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Schedule Type']/parent::XCUIElementTypeCell")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/llScheduleType"),
		@AndroidBy(id = "com.kwikset.blewifi:id/llScheduleType"),
		@AndroidBy(id = "com.spectrum.giga:id/llScheduleType"),
		@AndroidBy(id = "com.weiser.blewifi:id/llScheduleType"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/llScheduleType")
	})
	@CacheLookup
	private MobileElement scheduleButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Schedule Type']/parent::XCUIElementTypeCell")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/llScheduleType"),
		@AndroidBy(id = "com.kwikset.blewifi:id/llScheduleType"),
		@AndroidBy(id = "com.spectrum.giga:id/llScheduleType"),
		@AndroidBy(id = "com.weiser.blewifi:id/llScheduleType"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/llScheduleType")
	})
	@CacheLookup
	private MobileElement schBtn;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeCell[4]//XCUIElementTypeStaticText")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/txtFingerprint1"),
		@AndroidBy(id = "com.kwikset.blewifi:id/txtFingerprint1"),
		@AndroidBy(id = "com.spectrum.giga:id/txtFingerprint1"),
		@AndroidBy(id = "com.weiser.blewifi:id/txtFingerprint1"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/txtFingerprint1")
	})
	@CacheLookup
	private MobileElement fPDigitType1;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeCell[5]//XCUIElementTypeStaticText")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/txtFingerprint2"),
		@AndroidBy(id = "com.kwikset.blewifi:id/txtFingerprint2"),
		@AndroidBy(id = "com.spectrum.giga:id/txtFingerprint2"),
		@AndroidBy(id = "com.weiser.blewifi:id/txtFingerprint2"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/txtFingerprint2")
	})
	@CacheLookup
	private MobileElement fPDigitType2;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Save']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/txtSave"),
		@AndroidBy(id = "com.kwikset.blewifi:id/txtSave"),
		@AndroidBy(id = "com.spectrum.giga:id/txtSave"),
		@AndroidBy(id = "com.weiser.blewifi:id/txtSave"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/txtSave")
	})
	@CacheLookup
	private MobileElement saveButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Right']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/txtRight"),
		@AndroidBy(id = "com.kwikset.blewifi:id/txtRight"),
		@AndroidBy(id = "com.spectrum.giga:id/txtRight"),
		@AndroidBy(id = "com.weiser.blewifi:id/txtRight"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/txtRight")
	})
	@CacheLookup
	private MobileElement rightButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Left']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/txtLeft"),
		@AndroidBy(id = "com.kwikset.blewifi:id/txtLeft"),
		@AndroidBy(id = "com.spectrum.giga:id/txtLeft"),
		@AndroidBy(id = "com.weiser.blewifi:id/txtLeft"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/txtLeft")
	})
	@CacheLookup
	private MobileElement leftButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Index']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/txtIndex"),
		@AndroidBy(id = "com.kwikset.blewifi:id/txtIndex"),
		@AndroidBy(id = "com.spectrum.giga:id/txtIndex"),
		@AndroidBy(id = "com.weiser.blewifi:id/txtIndex"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/txtIndex")
	})
	@CacheLookup
	private MobileElement indexButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Thumb']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/txtThumb"),
		@AndroidBy(id = "com.kwikset.blewifi:id/txtThumb"),
		@AndroidBy(id = "com.spectrum.giga:id/txtThumb"),
		@AndroidBy(id = "com.weiser.blewifi:id/txtThumb"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/txtThumb")
	})
	@CacheLookup
	private MobileElement thumbButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Middle']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/txtMiddle"),
		@AndroidBy(id = "com.kwikset.blewifi:id/txtMiddle"),
		@AndroidBy(id = "com.spectrum.giga:id/txtMiddle"),
		@AndroidBy(id = "com.weiser.blewifi:id/txtMiddle"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/txtMiddle")
	})
	@CacheLookup
	private MobileElement middleButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Ring']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/txtRing"),
		@AndroidBy(id = "com.kwikset.blewifi:id/txtRing"),
		@AndroidBy(id = "com.spectrum.giga:id/txtRing"),
		@AndroidBy(id = "com.weiser.blewifi:id/txtRing"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/txtRing")
	})
	@CacheLookup
	private MobileElement ringButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Little']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/txtLittle"),
		@AndroidBy(id = "com.kwikset.blewifi:id/txtLittle"),
		@AndroidBy(id = "com.spectrum.giga:id/txtLittle"),
		@AndroidBy(id = "com.weiser.blewifi:id/txtLittle"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/txtLittle")
	})
	@CacheLookup
	private MobileElement littleButton;
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='fingerprint_icon']/following-sibling::XCUIElementTypeStaticText[@name='Add New Fingerprint']")
	@CacheLookup
	private MobileElement addNewFP;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Add New Fingerprint']")
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Add New Fingerprint']")
	@CacheLookup
	private MobileElement addNewFPLabel;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='delete']")
	@CacheLookup
	private List <MobileElement> lstDeleteButton;
	
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/imgFingerprint1"),
		@AndroidBy(id = "com.kwikset.blewifi:id/imgFingerprint1"),
		@AndroidBy(id = "com.spectrum.giga:id/imgFingerprint1"),
		@AndroidBy(id = "com.weiser.blewifi:id/imgFingerprint1"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/imgFingerprint1")
	})
	@CacheLookup
	private MobileElement deleteButton1;
	
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/imgFingerprint2"),
		@AndroidBy(id = "com.kwikset.blewifi:id/imgFingerprint2"),
		@AndroidBy(id = "com.spectrum.giga:id/imgFingerprint2"),
		@AndroidBy(id = "com.weiser.blewifi:id/imgFingerprint2"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/imgFingerprint2")
	})
	@CacheLookup
	private MobileElement deleteButton2;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Ok']")
	@AndroidFindBy(id = "android:id/button1")
	@CacheLookup
	private MobileElement okButton;
	
	By backBtn =By.xpath("//XCUIElementTypeStaticText[@name='Delete']");
	By backBtnAn =By.xpath("//android.widget.TextView[@text='Delete']");//added on 29-03-2021
	
	String fpText, accessCodeText  = "";
	String[] strAccessCode;
	int delCount = 0;
	boolean newFPOptPresent, swButtonPresent = false;
	
	//Constructor
	@SuppressWarnings("static-access")
	public UserFPAccessProfilePage(AppiumDriver<MobileElement> driver) {
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
	
	public boolean checkSwitchButton() throws InterruptedException {
		try {
		    Utility.waitForElementToBeVisible(disableAccessCode);
		    swButtonPresent=true;
		    Log.addMessage("Disable button found, syncing in progress");
		    return swButtonPresent;
		}catch(Exception e) {
			  Log.addMessage(e.getMessage().toString());
			  Log.addMessage("Failed to display disable button");
			  swButtonPresent=false;
			  return swButtonPresent;
		}
	}
	
	public void disableAccessCode() {
		  try {
			  Thread.sleep(10000);
			  disableAccessCode.click();
			  Log.addMessage("Access Code is disabled");
		  }catch(Exception e) {
			  Log.addMessage(e.getMessage().toString());
			  Log.addMessage("Failed to disable access code");
			  Assert.assertTrue(false, "Failed to disable access code");
		  }
	}
	
	public void disableAcsCode() {
		  try {
			  Thread.sleep(10000);
			  disableAcsCode.click();
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
	
	public void clickEditAcsCode() {
		  try {
			  Thread.sleep(8000);
			  System.out.println("in edit acs code="+editAcsCode);
			  editAcsCode.click();
			  Log.addMessage("Edit Access Code button is clicked");
		  }catch(Exception e) {
			  Log.addMessage(e.getMessage().toString());
			  Log.addMessage("Failed to click edit access code button");
			  Assert.assertTrue(false, "Failed to click edit access code button");
		  }
	}
	
	public void clickEditCodeName() {
		  try {
			  Thread.sleep(8000);
			  System.out.println("in edit code name");
			  editCodeName.click();
			  Log.addMessage("Edit Code Name button is clicked");
		  }catch(Exception e) {
			  Log.addMessage(e.getMessage().toString());
			  Log.addMessage("Failed to click edit code name button");
			  Assert.assertTrue(false, "Failed to click edit code name button");
		  }
	}
	
	public void clickEditCdName() {
		  try {
			  Thread.sleep(6000);
			  System.out.println("in code");
			  editCdName.click();
			  System.out.println("after click");
			  Log.addMessage("Edit Code Name button is clicked");
		  }catch(Exception e) {
			  Log.addMessage(e.getMessage().toString());
			  Log.addMessage("Failed to click edit code name button");
			  Assert.assertTrue(false, "Failed to click edit code name button");
		  }
		}
	
	public void deleteAccessCode() {
		  try {
			  Thread.sleep(6000);
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
	

	public void verifyUIUserAccessProfile() throws InterruptedException {
		try {
			Utility.simpleWait(10000);
			//System.out.println("in1");
			Utility.waitForElementToBeVisible(backButton);
			Assert.assertTrue(true, "Back button displayed in the UI for editing user profile");
			//System.out.println("in2");
			Utility.waitForElementToBeVisible(scheduleLabel);
			Assert.assertTrue(true, "Schedule Type displayed in the UI of user profile");
			//System.out.println("in3");
			Utility.waitForElementToBeVisible(shareAccessCode);
			Assert.assertTrue(true, "Schedule Type displayed in the UI of user profile");
			//System.out.println("in4");
			if(device.contentEquals("iOS")) {
				Utility.waitForElementToBeVisible(disableAcsCode);
			}else {
				Utility.waitForElementToBeVisible(disableAccessCode);
			}
			
			Assert.assertTrue(true, "Disable access code button displayed in the UI of user profile");
			//System.out.println("in5");
			if(device.equals("iOS")) {
				Utility.waitForElementToBeVisible(editAcsCode);
			}else {
				Utility.waitForElementToBeVisible(editAccessCode);
			}
			Assert.assertTrue(true, "Edit access code button displayed in the UI of user profile");
			//System.out.println("in6");
			if(device.equals("iOS")) {
				Utility.waitForElementToBeVisible(editCdName);
			}else {
				Utility.waitForElementToBeVisible(editCodeName);
			}
			Assert.assertTrue(true, "Edit code name displayed in the UI of user profile");
			//System.out.println("in7");
			Utility.waitForElementToBeVisible(deleteAccessCode);
			Assert.assertTrue(true, "Delete access code button displayed in the UI of user profile");
			//System.out.println("in8");
		}catch(Exception e) {
			Log.addMessage("Failed to display all elements in UI for username view page");
			Assert.assertTrue(false, "Failed to display all elements in UI for username view page");
		}
	}
	
	public void clickFingerPrint1() {
		  try {
			  Utility.waitForElementToBeVisible(fPDigitType1);
			  Utility.waitForElementToBeClickable(fPDigitType1);
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
			  Utility.waitForElementToBeVisible(fPDigitType1);
			  Utility.waitForElementToBeClickable(fPDigitType1);
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
	
	public String getAccessCodeText() {
		  try {
			  Utility.waitForElementToBeVisible(codePin);
			  if(device.equals("iOS")) {
				  accessCodeText =  codePin.getText();
				  strAccessCode = accessCodeText.split(": ");
				  if(strAccessCode.length>1) {
					  accessCodeText = strAccessCode[1].trim();
				  }else {
					  accessCodeText = "";
				  }
			  }else {
				  accessCodeText =  codePin.getText();
			  }
			  Log.addMessage("Access code displayed");
			  return accessCodeText;
		  }catch(Exception e) {
			  Log.addMessage(e.getMessage().toString());
			  Log.addMessage("Failed to display access code");
			  accessCodeText = "";
			  return accessCodeText;
		  }
		  
	}
	
	public void clickRightButton() {
		  try {
			  Utility.waitForElementToBeVisible(rightButton);
			  Utility.waitForElementToBeClickable(rightButton);
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
			  Utility.waitForElementToBeVisible(leftButton);
			  Utility.waitForElementToBeClickable(leftButton);
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
			  Utility.waitForElementToBeVisible(indexButton);
			  indexButton.click();
			  Log.addMessage("Index option selected");
		  }catch(Exception e) {
			  Log.addMessage(e.getMessage().toString());
			  Log.addMessage("Failed to select index option");
			  Assert.assertTrue(false, "Failed to select index option");
		  }
	}
	
	public void clickThumbButton() {
		  try {
			  Utility.waitForElementToBeVisible(thumbButton);
			  thumbButton.click();
			  Log.addMessage("Thumb option selected");
		  }catch(Exception e) {
			  Log.addMessage(e.getMessage().toString());
			  Log.addMessage("Failed to select thumb option");
			  Assert.assertTrue(false, "Failed to select thumb option");
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
			  Utility.waitForElementToBeVisible(saveButton);
			  saveButton.click();
			  Log.addMessage("Saved the selection");
		  }catch(Exception e) {
			  Log.addMessage(e.getMessage().toString());
			  Log.addMessage("Failed to save the options");
			  Assert.assertTrue(false, "Failed to save the options");
		  }
	}
	
	public void clickSchButton() {
		  try {
			  if(device.equals("iOS")) {
				  Utility.simpleWait(6000);//commented for bvt 09-10-2020
			  }
			  Utility.waitForElementToBeVisible(schBtn);
			  Utility.waitForElementToBeClickable(schBtn);
			  schBtn.click();
			  Assert.assertTrue(true, "Clicked schedule type button");
			  Log.addMessage("Clicked schedule type button");
		  }catch(Exception e) {
			  Log.addMessage(e.getMessage().toString());
			  Log.addMessage("Failed to click schedule type button");
			  Assert.assertTrue(false, "Failed to click schedule type button");
		  }
	}
	
	public void clickScheduleButton() {
		  try {
			  /*if(device.equals("iOS")) {
				  Utility.simpleWait(6000);//commented on 27-11-2020
			  }*/
			  Utility.waitForElementToBeVisible(scheduleButton);
			  Utility.waitForElementToBeClickable(scheduleButton);
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
		    okButton.click();
		    Log.addMessage("Clicked ok button");
		}catch(Exception e) {
			  Log.addMessage(e.getMessage().toString());
			  Log.addMessage("Failed to find ok button");
		}
		
	}
	
	public void clickSchBackButton() {
		try {
			if(device.equals("iOS")) {
				Utility.waitForElementPresent(backBtn,appiumDriver);
			}else {
				Utility.waitForElementPresent(backBtnAn,appiumDriver);
			}
			Utility.waitForElementToBeVisible(backButton);
			backButton.click();
			Log.addMessage("Clicked Back Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Back button ");
		}
	}
	
}
