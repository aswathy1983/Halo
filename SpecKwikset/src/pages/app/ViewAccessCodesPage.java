package pages.app;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

public class ViewAccessCodesPage extends Settings{
	
	//@AndroidFindBy(id = "com.kwikset.blewifi:id/tv_end_image")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='add access code user']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_end_image"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_end_image"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_end_image"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_end_image"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/tv_end_image")
	})
	@CacheLookup
	private MobileElement addAccessCodeButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeImage[@name='people']")
	@CacheLookup
	private MobileElement dispPplImage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='access delete']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/access_delete"),
		@AndroidBy(id = "com.kwikset.blewifi:id/access_delete"),
		@AndroidBy(id = "com.spectrum.giga:id/access_delete"),
		@AndroidBy(id = "com.weiser.blewifi:id/access_delete"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/access_delete")
	})
	@CacheLookup
	private MobileElement closeButton;
	
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/access_retry"),
		@AndroidBy(id = "com.kwikset.blewifi:id/access_retry"),
		@AndroidBy(id = "com.spectrum.giga:id/access_retry"),
		@AndroidBy(id = "com.weiser.blewifi:id/access_retry"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/access_retry")
	})
	@CacheLookup
	private MobileElement retryButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeActivityIndicator[@name='In progress']")
	@AndroidFindBy(xpath = "//android.widget.ProgressBar")
	@CacheLookup
	private MobileElement dispProgressImage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Secure Mode']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/row_secure_mode"),
		@AndroidBy(id = "com.kwikset.blewifi:id/row_secure_mode"),
		@AndroidBy(id = "com.spectrum.giga:id/row_secure_mode"),
		@AndroidBy(id = "com.weiser.blewifi:id/row_secure_mode"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/row_secure_mode")
	})
	@CacheLookup
	private MobileElement dispSecMode;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Secure Mode']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/home_name"),
		@AndroidBy(id = "com.kwikset.blewifi:id/home_name"),
		@AndroidBy(id = "com.spectrum.giga:id/home_name"),
		@AndroidBy(id = "com.weiser.blewifi:id/home_name"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/home_name")
	})
	@CacheLookup
	private MobileElement homeName;
	
	@AndroidFindBy(id = "android:id/button2")//added on 18-06-2020
	@CacheLookup
	private MobileElement cancelButton;

	//@AndroidFindBy(id = "com.kwikset.blewifi.dev:id/secure_mode_switch")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch")
	@AndroidFindBy(xpath = "//android.widget.Switch")
	@CacheLookup
	private List<MobileElement> secModeSwitch;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Secure Mode']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/secure_mode"),
		@AndroidBy(id = "com.kwikset.blewifi:id/secure_mode"),
		@AndroidBy(id = "com.spectrum.giga:id/secure_mode"),
		@AndroidBy(id = "com.weiser.blewifi:id/secure_mode"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/secure_mode")
	})
	@CacheLookup
	private MobileElement secModeText;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(text(),'Code:')]")
	@CacheLookup		
	private MobileElement codePin;

	/* added on 05-05-2020 */
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeCell")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_submenu"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_submenu"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_submenu"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_submenu"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/tv_submenu")
	})
	@CacheLookup
	private List<MobileElement> codeName;
	
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_lock_connection"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_lock_connection"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_lock_connection"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_lock_connection"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/tv_lock_connection")
	})
	@CacheLookup
	private List<MobileElement> shdlType;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Ok']")
	@AndroidFindBy(id = "android:id/button1")
	@CacheLookup		
	private MobileElement OkButton;		

	
	//@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	@iOSXCUITFindBy(id = "Back")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/cancelAllhomes"),
		@AndroidBy(id = "com.kwikset.blewifi:id/cancelAllhomes"),
		@AndroidBy(id = "com.spectrum.giga:id/cancelAllhomes"),
		@AndroidBy(id = "com.weiser.blewifi:id/cancelAllhomes"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/cancelAllhomes")
	})
	@CacheLookup
	private MobileElement navBack;
	
	//added on 25-05-2020
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeCell")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/single_row_locks"),
		@AndroidBy(id = "com.kwikset.blewifi:id/single_row_locks"),
		@AndroidBy(id = "com.spectrum.giga:id/single_row_locks"),
		@AndroidBy(id = "com.weiser.blewifi:id/single_row_locks"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/single_row_locks")
	})
	@CacheLookup
	private List<MobileElement> cntAccessCode;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeCell[3]")
	@CacheLookup		
	private MobileElement userProfile;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Access Disabled']/parent::XCUIElementTypeCell")
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Access Disabled']")
	@CacheLookup		
	private MobileElement userdisabledProfile;
	
	//added on 23-10-2020
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Syncing']/parent::XCUIElementTypeCell")
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Syncing']")
	@CacheLookup		
	private MobileElement syncProfile;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeCell[2]")
	@CacheLookup		
	private MobileElement firstUserAccess;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeCell")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/single_row_locks"),
		@AndroidBy(id = "com.kwikset.blewifi:id/single_row_locks"),
		@AndroidBy(id = "com.spectrum.giga:id/single_row_locks"),
		@AndroidBy(id = "com.weiser.blewifi:id/single_row_locks"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/single_row_locks")
	})
	@CacheLookup		
	private List<MobileElement> lstUserAccess;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeCell")
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView//android.widget.LinearLayout//android.widget.LinearLayout[1]//android.widget.RelativeLayout//android.widget.LinearLayout//android.widget.TextView[1]")
	@CacheLookup		
	private List<MobileElement> lstUsrAcs;
	
	By okBtn= By.xpath("//XCUIElementTypeButton[@name='Ok']");
	By okAnBtn= By.id("android:id/button1");
	By addUser =By.xpath("//XCUIElementTypeButton[@name='add access code user']");
	By addUserAn = By.id("com.kwikset.blewifi.dev:id/tv_end_image");
	By syncingText = By.xpath("//XCUIElementTypeSwitch[@name='LED Status']");
	By syncFail = By.xpath("//XCUIElementTypeStaticText[@name='Sync Failed']/parent::XCUIElementTypeCell");
	By syncFailAn =By.xpath("//android.widget.TextView[@text='Sync Failed']");
	
	String cName, sType, usrAccessType, secureStatus = "";
	boolean okButtonPresent, accessExists = false;
	
	//Constructor
	@SuppressWarnings("static-access")
	public ViewAccessCodesPage(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
		
		
	/** 
	* Method Name: clickAddAccessCodeButton(), 
	* This function is used to click add access code button
	*/
		
	public void clickAddAccessCodeButton() {
		try {
	    	Utility.waitForElementToBeVisible(addAccessCodeButton);
	    	Utility.waitForElementToBeClickable(addAccessCodeButton);
	    	addAccessCodeButton.click();
			Log.addMessage("Clicked Add Access code Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Add access code button");
			Assert.assertTrue(false, "Failed to click Add access code button");
		}
	}
	
	/** 
	* Method Name: fetchAllAccessCodes(), 
	* This function is used to fetch a given access code for iOS
	*/
	@SuppressWarnings("unchecked")
	public void fetchAllAccessCodes() {
	  try {
		List<MobileElement> listOfAccessCodes = (List<MobileElement>) driver.findElement(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell"));
		String[] accessCodeName = new String[listOfAccessCodes.size()];
		String[] accessCodePin = new String[listOfAccessCodes.size()];
		for(int i =0; i<=listOfAccessCodes.size();i++) {
			accessCodeName[i]  = driver.findElement(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell["+i+"]")).getText();
			driver.findElement(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell["+i+"]")).click();
			accessCodePin[i] = codePin.getText();
		}
		for(int j=0; j<listOfAccessCodes.size(); j++) {
			Log.addMessage("Access code is: "+accessCodeName[j]+" and pin is: "+accessCodePin[j]);
		}
	  }catch(Exception e) {
			Log.addMessage("Failed to fetch access codes");
			Assert.assertTrue(false, "Failed to fetch access codes");
	  }
	}
	
	/** 
	* Method Name: fetchGivenAccessCode(), 
	* This function is used to fetch a given access code for iOS
	*/
	@SuppressWarnings("unchecked")
	public void fetchGivenAccessCode(String accessCode) {
	  try {
		 List<MobileElement> listOfAccessCodes = (List<MobileElement>) driver.findElement(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell"));
		for(int i =0; i<=listOfAccessCodes.size();i++) {
			 String accessCodeName = driver.findElement(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell["+i+"]")).getText();
			 System.out.println("accessCodeName="+accessCodeName+", listOfAccessCodes.size()="+listOfAccessCodes.size()+", exp accessCode="+accessCode);
			 if (accessCodeName.equals(accessCode)) {
				 driver.findElement(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell["+i+"]")).click();
			 }
		 }
	  }catch(Exception e) {
		  Log.addMessage("Failed to get the required access code");
		  Assert.assertTrue(false, "Failed to get the required access code");
	  }
	 }
	
	/** 
	* Method Name: selGivenAccessCodeName(), 
	* This function is used to select a given access code for iOS
	*/
	public void selGivenAccessCodeName(String accessCode) {
	  try {
		 for(int i =2; i<=lstUsrAcs.size();i++) {
			 String accessCodeName="";
			 if(device.equals("iOS")) {
				 System.out.println("in ios="+driver.findElement(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell["+i+"]//XCUIElementTypeStaticText[1]")).getText());
				  accessCodeName = driver.findElement(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell["+i+"]//XCUIElementTypeStaticText[1]")).getText();
			 }else {
				 System.out.println("in and="+lstUsrAcs.get(i-2).getText());
				  accessCodeName = lstUsrAcs.get(i-2).getText();
			 }
			 if (accessCodeName.equals(accessCode)) {
				 if(device.equals("iOS")) {
					 driver.findElement(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell["+i+"]")).click();
				 }else {
					 lstUsrAcs.get(i-2).click();
				 }
			 }
		 }
	  }catch(Exception e) {
		  Log.addMessage("Failed to get the required access code");
		  Assert.assertTrue(false, "Failed to get the required access code");
	  }
	 }
	
	/** 
	* Method Name: selGivenAccessCodeNameAn(), 
	* This function is used to select a given access code for android
	*/
	public void selGivenAccessCodeNameAn(String accessCode) {
	  try {
		 for(int i =0; i<lstUsrAcs.size();i++) {
			 String accessCodeName="";
			 if(device.equals("iOS")) {
				 System.out.println("in ios="+driver.findElement(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell["+i+"]//XCUIElementTypeStaticText[1]")).getText());
				  accessCodeName = driver.findElement(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell["+i+"]//XCUIElementTypeStaticText[1]")).getText();
			 }else {
				 //System.out.println("in and="+lstUsrAcs.get(i).getText());
				  accessCodeName = lstUsrAcs.get(i).getText();
			 }
			 //System.out.println("accessCodeName="+accessCodeName);
			 if (accessCodeName.equals(accessCode)) {
				 if(device.equals("iOS")) {
					 driver.findElement(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell["+i+"]")).click();
				 }else {
					 lstUsrAcs.get(i).click();
				 }
			 }
		 }
	  }catch(Exception e) {
		  Log.addMessage("Failed to get the required access code");
		  Assert.assertTrue(false, "Failed to get the required access code");
	  }
	 }
	
	/* added on 05-05-2020 */
	/** 
	* Method Name: getAccessCodeList(), 
	* This function is used to get Access Codes attached to the account
	*/
	public void getAccessCodeList(String cdName, String shType, int cdcnt) {
		try {
			if(codeName.size()>0) {
				Utility.waitForElementToBePresent(codeName.get(0), appiumDriver);
				Utility.waitForElementToBeClickable(codeName.get(0));
		    	for(int i = cdcnt; i<codeName.size(); i++) {
		    		cName = codeName.get(i).getText();
		    		Assert.assertEquals(cName, cdName,"Access Code matches");
		    		sType = shdlType.get(i).getText();
		    		Assert.assertEquals(sType, shType,"Access Code Type matches");
		    		System.out.println("cName="+cName+",exp cName="+ cdName+", sType="+sType+", exp stype="+shType);
		    		Log.addMessage("Access code is: "+codeName.get(i).getText()+" and ScheduleType is: "+shdlType.get(i).getText());
		    		break;
		    	}
		    	if(cdcnt>=codeName.size()) {
		    		Assert.assertTrue(false,"Access code not listed");
		    	}
			}
			Log.addMessage("Get Access code List");
		}catch(Exception e) {
			Log.addMessage("Failed to list access codes");
			Assert.assertTrue(false, "Failed to list access codes");
		}
	}
	
	public void getAccessCodeiOSList(String cdName, String shType, int cdcnt) {
		try {
			Utility.waitForElementToBePresent(codeName.get(0), appiumDriver);
			if(codeName.size()>1) {
				Utility.waitForElementToBePresent(codeName.get(1), appiumDriver);
				Utility.waitForElementToBeClickable(codeName.get(1));
		    	System.out.println("cdcnt="+cdcnt+", name size="+(cntAccessCode.size()-1));
		    	if(cdcnt!=cntAccessCode.size()) {
			    	for(int i = cdcnt; i<cntAccessCode.size(); i++) {//-1 to avoid cell containing Secure Mode
			    		cName = driver.findElement(By.xpath("//XCUIElementTypeTable//XCUIElementTypeCell["+(i+2)+"]//XCUIElementTypeStaticText[1]")).getText();
			    		System.out.println("//XCUIElementTypeTable//XCUIElementTypeCell["+(i+2)+"]//XCUIElementTypeStaticText[1]");
			    		System.out.println("cName="+cName+",exp cName="+cdName+"-");
			    		Assert.assertEquals(cName.trim(), cdName.trim(),"Access Code matches");
			    		
			    		sType = driver.findElement(By.xpath("//XCUIElementTypeTable//XCUIElementTypeCell["+(i+2)+"]//XCUIElementTypeStaticText[2]")).getText();
			    		System.out.println("//XCUIElementTypeTable//XCUIElementTypeCell["+(i+2)+"]//XCUIElementTypeStaticText[2]");
			    		Assert.assertEquals(sType.trim(), shType.trim(),"Access Code Type matches");
			    		System.out.println("cName="+cName+",exp cName="+ cdName+", sType="+sType+", exp stype="+shType);
			    		Log.addMessage("Access code is: "+cName+" and ScheduleType is: "+sType);
			    		break;
			    	}
		    	}else {
		    		Assert.assertTrue(false, "Failed to list access codes");
		    	}
			} else {
				Assert.assertTrue(false, "Failed to list access codes");
			}
			Log.addMessage("Get Access code List");
		}catch(Exception e) {
			Log.addMessage("Failed to list access codes");
			Assert.assertTrue(false, "Failed to list access codes");
		}
	}
	
	/* added from 29-05-2020 for FP User Access */
	
	public void verifyUIFP() throws InterruptedException {
		try {
		
			Utility.simpleWait(10000);
			Utility.waitForElementToBeVisible(dispSecMode);
			Assert.assertTrue(true, "Secure Mode displayed in the UI for selecting finger Print username");
			//System.out.println("in dispsecMd3");
			Utility.waitForElementToBeVisible(navBack);
			Assert.assertTrue(true, "Back button displayed in the UI for selecting finger Print username");
			//System.out.println("in dispsecMd4");
			Utility.waitForElementToBeVisible(addAccessCodeButton);
			Assert.assertTrue(true, "Add access code button displayed in the UI for selecting finger Print username");
			//System.out.println("in dispsecMd5");
			
		}catch(Exception e) {
			Log.addMessage("Failed to display all elements in UI for FP username view page");
			Assert.assertTrue(false, "Failed to display all elements in UI for FP username view page");
		}
	}
	public void getAccessCodeCnt() throws InterruptedException {
		try {
			Utility.waitForElementToBeVisible(cntAccessCode.get(0));
			Utility.waitForElementToBeClickable(cntAccessCode.get(0));
			if(cntAccessCode.size()>=1) {//changed on 27-oct-2020for bvt
				Assert.assertTrue(true, "UI for selecting finger Print username is dispalyed");
			}else {
				Assert.assertTrue(false, "UI for selecting finger Print username is not dispalyed");
			}
		}catch(Exception e) {
			Log.addMessage("Failed to list access codes");
			Assert.assertTrue(false, "Failed to list access codes");
		}
	}
	
	public int accessCodeCnt() throws InterruptedException {
		try {
			Utility.waitForElementToBeVisible(cntAccessCode.get(0));
			Utility.waitForElementToBeClickable(cntAccessCode.get(0));
			if(cntAccessCode.size()>=1) {//changed on 27-oct-2020for bvt
				return cntAccessCode.size();
			}else {
				return 0;
			}
		}catch(Exception e) {
			Log.addMessage("Failed to list access codes");
			return 0;
			//Assert.assertTrue(false, "Failed to list access codes");
		}
		
	}
	public void selSecondFPUser() throws InterruptedException {
		try {
			if(device.equals("iOS")) {
				Utility.waitForElementToBeVisible(userProfile);
				Utility.waitForElementToBeClickable(userProfile);
				userProfile.click();
			}else {
				Utility.waitForElementToBeVisible(lstUserAccess.get(1));
				Utility.waitForElementToBeClickable(lstUserAccess.get(1));
				lstUserAccess.get(1).click();
			}
			Assert.assertTrue(true, "Selected one finger print user profile");
			Log.addMessage("Selected one finger print user profile");
		}catch(Exception e) {
			Log.addMessage("Failed to select a finger print user profile");
			Assert.assertTrue(false, "Failed to select a finger print user profile");
		}
	}
	
	public void selFirstFPUser() throws InterruptedException {
		try {
			if(device.equals("iOS")) {
				Utility.simpleWait(8000);
				Utility.waitForElementToBeVisible(firstUserAccess);
				Utility.waitForElementToBeClickable(firstUserAccess);
				firstUserAccess.click();
			}else {
				Utility.simpleWait(3000);//added on 28Apr21
				Utility.waitForElementToBeVisible(lstUserAccess.get(0));
				Utility.waitForElementToBeClickable(lstUserAccess.get(0));
				lstUserAccess.get(0).click();
			}
			while(checkSyncPopup()) {
				if(device.equals("iOS")) {
					 Utility.waitForElementPresent(okBtn,appiumDriver);
					 driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Ok']")).click();
					 Utility.waitForElementPresent(addUser, appiumDriver);
				}else if(device.equals("android")) {
					 Utility.waitForElementPresent(okAnBtn,appiumDriver);
					 driver.findElement(By.id("android:id/button1")).click();
					 Utility.waitForElementPresent(addUserAn, appiumDriver);
				}
				if(device.equals("iOS")) {
					firstUserAccess.click();
					waitForSyncComplete();
				}else {
					lstUserAccess.get(0).click();
					Utility.simpleWait(40000);//added for bvt of fp lock
				}
				
			}
			Assert.assertTrue(true, "Selected one user profile");
			Log.addMessage("Selected one user profile");
		}catch(Exception e) {
			Log.addMessage("Failed to select a user profile");
			System.out.println("in catch firstUser");
			//Assert.assertTrue(false, "Failed to select a finger print user profile");
		}
	}
	
	/** 
	* Method Name: selDisabledFPUser(), 
	* This function is used to select the disabled user access code
	*/
	public void selDisabledFPUser() throws InterruptedException {
		try {
			Utility.waitForElementToBeVisible(userdisabledProfile);
			userdisabledProfile.click();
			Log.addMessage("Selected one access disabled user profile");
		}catch(Exception e) {
			Log.addMessage("Failed to select access disabled user profile");
			Assert.assertTrue(false, "Failed to select access disabled user profile");
		}
	}
	
	/** 
	* Method Name: checkOkButton(), 
	* This function is used to click OK button
	*/
	public boolean checkOkButton() throws InterruptedException {
		try {
		    Utility.waitForElementToBeVisible(OkButton);
		    okButtonPresent=true;
		    Log.addMessage("Ok button found, syncing in progress");
		    return okButtonPresent;
		}catch(Exception e) {
			  Log.addMessage(e.getMessage().toString());
			  Log.addMessage("Failed to display Ok button");
			  okButtonPresent=false;
			  return okButtonPresent;
		}
	}
	
	/** 
	* Method Name: checkSyncPopup(), 
	* This function is used to check for syncing popup
	*/
	public boolean checkSyncPopup() throws InterruptedException {
		try {
			if(device.equals("iOS")) {
				Utility.waitForElementPresent(okBtn, appiumDriver);
			}else {
				Utility.waitForElementPresent(okAnBtn, appiumDriver);
			}
		    okButtonPresent=true;
		    Log.addMessage("Ok button found, syncing in progress");
		    return okButtonPresent;
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to display Ok button");
			okButtonPresent=false;
			return okButtonPresent;
		}
	}
	
	/** 
	* Method Name: clickBackButton(), 
	* This function is used to go back to previous page
	*/
	public void clickOkButton()  {
		try {
		    Utility.simpleWait(3000);
		    OkButton.click();
		    Assert.assertTrue(true, "Clicked Ok button");
		    Log.addMessage("Clicked Ok button");
		}catch(Exception e) {
			  Log.addMessage(e.getMessage().toString());
			  Log.addMessage("Failed to click Ok button");
			  Assert.assertTrue(false, "Failed to click Ok button");
		}
	}
	
	/** 
	* Method Name: clickOkBtn(), 
	* This function is used to go back to previous page
	*/
	public void clickOkBtn()  {
		try {
		    Utility.simpleWait(3000);
		    OkButton.click();
		   // Assert.assertTrue(true, "Clicked Ok button");
		    Log.addMessage("Clicked Ok button");
		}catch(Exception e) {
			  Log.addMessage(e.getMessage().toString());
			  Log.addMessage("Failed to click Ok button");
			  //Assert.assertTrue(false, "Failed to click Ok button");
		}
	}
	
	/** 
	* Method Name: clickBackButton(), 
	* This function is used to go back to Lock Settings Page
	*/
	public void clickBackButton() throws InterruptedException {
		try {
			Utility.waitForElementToBePresent(navBack, driver);
			navBack.click();
			Log.addMessage("Clicked Back Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Back button");
			Assert.assertTrue(false, "Failed to click back button");
		}
	}
	
	/** 
	* Method Name: verifyUISecureModeFP(), 
	* This function is used to go back to Lock Settings Page
	*/
	//added on 18-06-2020
	public void verifyUISecureModeFP() throws InterruptedException {
		try {
			if(device.equals("iOS")) {
				Utility.simpleWait(10000);//added on 16 Nov 2020 for bvt
			}
			Utility.waitForElementToBeClickable(secModeSwitch.get(0));
			//System.out.println("in dispsecMd1");
			Utility.waitForElementToBeVisible(dispSecMode);
			Assert.assertTrue(true, "Secure Mode displayed in the UI for selecting finger Print username");
			//System.out.println("in dispsecMd2");
			Utility.waitForElementToBeVisible(secModeText);
			//System.out.println("in dispsecMd3");
			Assert.assertTrue(true, "Secure Mode text displayed in the UI for secure mode");
			//System.out.println("in dispsecMd4");
			Assert.assertTrue(true, "Secure Mode disabled icon displayed in the UI for secure mode");
		}catch(Exception e) {
			Log.addMessage("Failed to display all elements in UI for FP username view page");
			Assert.assertTrue(false, "Failed to display all elements in UI for FP username view page");
		}
	}
	
	/** 
	* Method Name: enableSecureMode(), 
	* This function is used to enable/disable secure mode Page
	*/
	
	public void enableSecureMode() throws InterruptedException {
		try {
			//Thread.sleep(3000);//commented on 26-11-2020
			System.out.println("in enableSecureMode");
			By secMode;
			if(device.equals("android")) {
				 secMode = By.xpath("//android.widget.Switch");
			}else {
				 secMode = By.xpath("//XCUIElementTypeSwitch");
			}
			
			Utility.waitForElementPresent(secMode, appiumDriver);
			//Utility.waitForElementToBeVisible(secModeSwitch.get(0));
			//Utility.waitForElementToBeClickable(secModeSwitch.get(0));
			secModeSwitch.get(0).click();
			//Thread.sleep(10000);//commented on 26-11-2020
			/*if(device.equals("android")) {
				
			}*/
			//System.out.println("after clicking secModeSwitch");
			
			Log.addMessage("Clicked Secure Mode ");
		}catch(Exception e) {
			Log.addMessage("Failed to click Secure Mode ");
			Assert.assertTrue(false, "Failed to click Secure Mode ");
		}
	}
	
	/** 
	* Method Name: enableSecureMode(), 
	* This function is used to enable/disable secure mode Page
	*/
	
	public String getSecureModeStatus() throws InterruptedException {
		try {
			//Thread.sleep(3000);//commented for bvt on 26-11-2020
			By secMode;
			if(device.equals("android")) {
				 secMode = By.xpath("//android.widget.Switch");
			}else {
				 secMode = By.xpath("//XCUIElementTypeSwitch");
			}
			Utility.waitForElementPresent(secMode, appiumDriver);
			 /* Utility.waitForElementToBeVisible(secModeSwitch.get(0));
			  Utility.waitForElementToBeClickable(secModeSwitch.get(0));*/
			  
			  if(secModeSwitch.size()>0) {
					secureStatus = secModeSwitch.get(0).getText();
					System.out.println("secModeSwitch.getText()="+secModeSwitch.size());
					if(device.contentEquals("iOS")) {
						//System.out.println("secure mode switch="+secModeSwitch.get(0).getAttribute("value"));
						if(secureStatus.equals("0")) {
							secureStatus="Off";
						}else
							secureStatus="On";
					}
			  }
			//System.out.println("Secure mode status is "+secureStatus);
			Log.addMessage("Secure mode status displayed");
		}catch(Exception e) {
			Log.addMessage("Failed to display secure mode status");
			//Assert.assertTrue(false, "Failed to display secure mode status");
		}
		return secureStatus;
	}
	
	//added on 18-06-2020
	public void clickCancelButton() {
		try {
			Thread.sleep(6000);
			cancelButton.click();
			Log.addMessage("Clicked Cancel Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Cancel button ");
			Assert.assertTrue(false, "Failed to click Cancel button");
		}
	}
	
	//added on 04-09-2020
	public void clickHomeName() {
		try {
			Thread.sleep(6000);
			homeName.click();
			Log.addMessage("Clicked home name");
		}catch(Exception e) {
			Log.addMessage("Failed to click home name");
			Assert.assertTrue(false, "Failed to click home name");
		}
	}
	
	/** 
	* Method Name: verifyUserAccessCode(), 
	* This function is used to get Access Codes attached to the account
	*/	
	
	public void verifyUserAccessCode(String cdName) {
		try {
	    	Utility.simpleWait(6000);
	    	System.out.println("name size="+codeName.size());
	    	for(int i = 0; i<codeName.size(); i++) {
	    		cName = codeName.get(i).getText();
	    		if(cName.equals(cdName)) {
	    			accessExists=true;
	    			System.out.println("existName="+cName+",exp cName="+ cdName);
	    			break;
	    		}
	    		Log.addMessage("Access code is: "+codeName.get(i).getText());
	    	}
	    	if(accessExists) {
	    		Assert.assertTrue(true,"Access Code of the user does not exist in the lock");
	    	}else {
	    		Assert.assertTrue(false, "Access Code of the user does not exist in the lock");
	    	}
			Log.addMessage("Get Access code List");
		}catch(Exception e) {
			Log.addMessage("Failed to list access codes");
			Assert.assertTrue(false, "Failed to list access codes");
		}
	}
	
	/** 
	* Method Name: verifyUserAccessCodeName(), 
	* This function is used to get Access Codes attached to the account
	*/	
	
	public void verifyUserAccessCodeName(String cdName) {
		try {
			if(device.equals("iOS")) {
				Utility.waitForElementToBeVisible(firstUserAccess);
				System.out.println("in firstUser");
				Assert.assertEquals(firstUserAccess.getText(),cdName,"Access code name of the elevated member does not exist in the lock");
				Log.addMessage("Access code name is: "+firstUserAccess.getText());
			}else {
				Utility.waitForElementToBeVisible(lstUserAccess.get(0));
				System.out.println("in firstUser");
				Assert.assertEquals(lstUserAccess.get(0).getText(),cdName,"Access code name of the elevated member does not exist in the lock");
				Log.addMessage("Access code name is: "+lstUserAccess.get(0).getText());
			}
		}catch(Exception e) {
			Log.addMessage("Failed to list updated access code");
			Assert.assertTrue(false, "Failed to list updated access code");
		}
	}
	
	public void waitForSync() throws InterruptedException {
		try {
			Utility.waitForTextToBePresent(userdisabledProfile,"Access Disabled");
			Log.addMessage("Access disabled for user profile");
		}catch(Exception e) {
			Log.addMessage("Failed to disable access for user profile");
			Assert.assertTrue(false, "Failed to disable access for user profile");
		}
	}
	
	public void waitForSyncComplete() throws InterruptedException {
		try {
			if(device.equals("android")) {
				Utility.waitForTextNotPresent("//android.widget.TextView[@text='Syncing']");
			}else {
				Thread.sleep(8000);
				Utility.waitForTextNotPresent("//XCUIElementTypeStaticText[@name='Syncing']/parent::XCUIElementTypeCell");
			}
			Log.addMessage("Access code updated for user profile");
		}catch(Exception e) {
			Log.addMessage("Access for user profile is syncing");
			//Assert.assertTrue(false, "Access for user profile is syncing");
		}
	}
	
	public void checkSyncFail() throws InterruptedException  {
		try {
			System.out.println("in sync fail");
		    if(device.equals("iOS")) {
		    	Utility.waitForElementPresent(syncFail,appiumDriver);
		    }else {
		    	Utility.waitForElementPresent(syncFailAn,appiumDriver);
		    }
		    System.out.println("in sync fail");
		    Utility.waitForElementToBeVisible(closeButton);
		    closeButton.click();
		    selFirstFPUser();
		    Assert.assertTrue(false, "Failed to update access for user profile");//commented on 29 APril 21
		}catch(Exception e) {
			System.out.println("in catch");
			Log.addMessage("Updated access for user profile");
			selFirstFPUser();
			//Assert.assertTrue(false, "Failed to update access for user profile");//commented on 29 APril 21
			Assert.assertTrue(true, "Updated access for user profile");
		}
	}
	
	public void checkSyncFailAR() throws InterruptedException  {
		try {
			System.out.println("in sync fail");
		    if(device.equals("iOS")) {
		    	Utility.waitForElementPresent(syncFail,appiumDriver);
		    }else {
		    	Utility.waitForElementPresent(syncFailAn,appiumDriver);
		    }
		    System.out.println("in sync fail");
		    Utility.waitForElementToBeVisible(closeButton);
		    closeButton.click();
		    selFirstFPUser();
		    Assert.assertTrue(false, "Failed to update access for user profile");//commented on 29 APril 21
		}catch(Exception e) {
			System.out.println("in catch");
			Log.addMessage("Updated access for user profile");
			//selFirstFPUser();
			//Assert.assertTrue(false, "Failed to update access for user profile");//commented on 29 APril 21
			Assert.assertTrue(true, "Updated access for user profile");
		}
	}
	
	public void checkSyncFailClose()  {
		try {
			System.out.println("in sync fail");
		    if(device.equals("iOS")) {
		    	Utility.waitForElementPresent(syncFail,appiumDriver);
		    }else {
		    	Utility.waitForElementPresent(syncFailAn,appiumDriver);
		    }
		    System.out.println("in sync fail");
		    Utility.waitForElementToBeVisible(closeButton);
		    closeButton.click();
		}catch(Exception e) {
			System.out.println("in catch");
			Log.addMessage("Failed to update access for user profile");
		}
	}
	
}
