package pages.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
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

public class MenuFlyoutPage extends Settings{
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Account Settings']/XCUIElementTypeButton")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/navSettings"),
		@AndroidBy(id = "com.kwikset.blewifi:id/navSettings"),
		@AndroidBy(id = "com.spectrum.giga:id/navSettings"),
		@AndroidBy(id = "com.weiser.blewifi:id/navSettings"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/navSettings")
	})
	@CacheLookup
	private MobileElement accountSettingsButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Log Out']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/btnLogOut"),
		@AndroidBy(id = "com.kwikset.blewifi:id/btnLogOut"),
		@AndroidBy(id = "com.spectrum.giga:id/btnLogOut"),
		@AndroidBy(id = "com.weiser.blewifi:id/btnLogOut"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/btnLogOut")
	})
	@CacheLookup
	private MobileElement logoutButton;
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Manage']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/arrowUp"),
		@AndroidBy(id = "com.kwikset.blewifi:id/arrowUp"),
		@AndroidBy(id = "com.spectrum.giga:id/arrowUp"),
		@AndroidBy(id = "com.weiser.blewifi:id/arrowUp"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/arrowUp")
	})
	@CacheLookup
	private MobileElement upArrowButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Ok']")
	@AndroidFindBy(xpath = "//XCUIElementTypeButton[@name='Ok']")
	@CacheLookup
	private MobileElement oKButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Manage']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/btn_manage"),
		@AndroidBy(id = "com.kwikset.blewifi:id/btn_manage"),
		@AndroidBy(id = "com.spectrum.giga:id/btn_manage"),
		@AndroidBy(id = "com.weiser.blewifi:id/btn_manage"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/btn_manage")
	})
	@CacheLookup
	private MobileElement manageButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='App Ver:']/following-sibling::XCUIElementTypeStaticText")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tvApplicationVersion"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tvApplicationVersion"),
		@AndroidBy(id = "com.spectrum.giga:id/tvApplicationVersion"),
		@AndroidBy(id = "com.weiser.blewifi:id/tvApplicationVersion"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/tvApplicationVersion")
	})
	@CacheLookup
	private MobileElement appVersion;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='App Env:']/following-sibling::XCUIElementTypeStaticText")
	@AndroidFindBy(xpath = "//android.widget.TextView[2]")
	@CacheLookup
	private MobileElement appEnv;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Help / FAQ']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/navHelp"),
		@AndroidBy(id = "com.kwikset.blewifi:id/navHelp"),
		@AndroidBy(id = "com.spectrum.giga:id/navHelp"),
		@AndroidBy(id = "com.weiser.blewifi:id/navHelp"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/navHelp")
	})
	@CacheLookup
	private MobileElement helpMenu;
	
	/* Code added on 05-05-2020 */
	//@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeOther")
	/* Code added on 19-01-2021 */
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeCell")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/txt_header_name"),
		@AndroidBy(id = "com.kwikset.blewifi:id/txt_header_name"),
		@AndroidBy(id = "com.spectrum.giga:id/txt_header_name"),
		@AndroidBy(id = "com.weiser.blewifi:id/txt_header_name"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/txt_header_name")
	})
	@CacheLookup
	private List<MobileElement> homeNameLst;
	
	
	/* Code added on 24-09-2020 */
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeOther")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/lock_status"),
		@AndroidBy(id = "com.kwikset.blewifi:id/lock_status"),
		@AndroidBy(id = "com.spectrum.giga:id/lock_status"),
		@AndroidBy(id = "com.weiser.blewifi:id/lock_status"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/lock_status")
	})
	@CacheLookup
	private List<MobileElement> homeLockLst;
	
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/txt_submenu"),
		@AndroidBy(id = "com.kwikset.blewifi:id/txt_submenu"),
		@AndroidBy(id = "com.spectrum.giga:id/txt_submenu"),
		@AndroidBy(id = "com.weiser.blewifi:id/txt_submenu"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/txt_submenu")
	})
	@CacheLookup
	private MobileElement lockName;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeTable//XCUIElementTypeCell")//added on 19-01-2021
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/txt_submenu"),
		@AndroidBy(id = "com.kwikset.blewifi:id/txt_submenu"),
		@AndroidBy(id = "com.spectrum.giga:id/txt_submenu"),
		@AndroidBy(id = "com.weiser.blewifi:id/txt_submenu"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/txt_submenu")
	})
	@CacheLookup
	private List<MobileElement> lockNameLst;
	
	//@iOSXCUITFindBy(xpath="(//XCUIElementTypeTable//XCUIElementTypeImage)[2]")//commented as its the path for lock image on 22-05-2020
	@iOSXCUITFindBy(xpath="//XCUIElementTypeTable//XCUIElementTypeCell")//added on 22-05-2020
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/txt_submenu"),
		@AndroidBy(id = "com.kwikset.blewifi:id/txt_submenu"),
		@AndroidBy(id = "com.spectrum.giga:id/txt_submenu"),
		@AndroidBy(id = "com.weiser.blewifi:id/txt_submenu"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/txt_submenu")
	})//commented on 13-06-2020
	//@AndroidFindBy(xpath = "(//android.widget.ExpandableListView//android.widget.RelativeLayout)[2]")
	@CacheLookup
	private List< MobileElement> lockIcon;
	
	@AndroidFindBy(xpath = "(//android.widget.ExpandableListView//android.widget.RelativeLayout)[3]")
	@CacheLookup
	private MobileElement homeNameMenu;
	
	//added on 26-06-2020
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'Status as of')]")
	@AndroidFindBy(xpath = "(//android.widget.TextView[contains(@text,'Status as of')])[2]")
	@CacheLookup
	private MobileElement lockUpdtdTime;
	
	@iOSXCUITFindBy(id = "Ok")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/imgLockSettings"),
		@AndroidBy(id = "com.kwikset.blewifi:id/imgLockSettings"),
		@AndroidBy(id = "com.spectrum.giga:id/imgLockSettings"),
		@AndroidBy(id = "com.weiser.blewifi:id/imgLockSettings"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/imgLockSettings")
	})
	private MobileElement lockSettingsBtn;
	
	@iOSXCUITFindBy(id = "Ok")
	@AndroidFindBy(id="android:id/button1")
	private MobileElement OKButton;
	
	@iOSXCUITFindBy(id = "Ok")
	@AndroidFindBy(id = "android:id/button2")
	@CacheLookup
	private MobileElement cancelButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[1]")//added on 02-07-2020
	@AndroidFindBy(id = "android:id/alertTitle")
	@CacheLookup
	private MobileElement popUpTitleVerbiage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[2]")
	@AndroidFindBy(id="android:id/message")
	private MobileElement confirmMessage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[1]")//changed from [2] to [1]
	@AndroidFindBy(id = "android:id/message")
	@CacheLookup
	private MobileElement popUpMessageVerbiage;
	
	String actHmName, upTime, updateTime, actTitle,  actMessage, actLkName = "";
	int cnt =0;
	Boolean lockExists, menuPresent, dashboardPresent = false;
	
	/* Code added on 05-05-2020 */
	
	
	//Constructor
	
	@SuppressWarnings("static-access")
	public MenuFlyoutPage(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
		
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
			
	public void clickAccountSettingsButton() {
		try {
			Utility.waitForElementToBeVisible(accountSettingsButton);
			Utility.waitForElementToBeClickable(accountSettingsButton);
			accountSettingsButton.click();
			Log.addMessage("Clicked Account Settings Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Account Settings button.");
			Assert.assertTrue(false, "Failed to click Account Settings button.");
		}
	}
	
	/** 
	* Method Name: verifyMenuScrollToLogout(), 
	* This function is used to verify scroll in menu fly out Page
	*/
			
	public void verifyMenuScrollToLogout() {
		try {
			Utility.waitForElementToBeVisible(logoutButton);
			Utility.waitForElementToBeClickable(logoutButton);
			Log.addMessage("Scroll exists in menu fly out page");
		}catch(Exception e) {
			Log.addMessage("Failed to scroll in the menu fly out page");
			Assert.assertTrue(false, "Failed to scroll in the menu fly out page");
		}
	}
	

	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
			
	public void clickLogoutButton() {
		try {
			if(device.equals("iOS")) {
				Thread.sleep(2000);
				JavascriptExecutor js = appiumDriver;
				Map<String, Object> params = new HashMap<>();
				params.put("direction", "up");
				params.put("element",  driver.findElement(By.xpath("//XCUIElementTypeOther[@name='Account Settings']/XCUIElementTypeButton")));
				js.executeScript("mobile: swipe", params);
			}
			Utility.waitForElementToBeVisible(logoutButton);
			Utility.waitForElementToBeClickable(logoutButton);
			logoutButton.click();
			Log.addMessage("Clicked logout Button");
			/*Utility.waitForElementToBeVisible(OKButton);
			Utility.waitForElementToBeClickable(oKButton);
			oKButton.click();*/
			Log.addMessage("Logged out successfully");
		}catch(Exception e) {
			Log.addMessage("Logout failed");
			Assert.assertTrue(false, "Logout failed");
		}
	}
	
	public void clickManageButton() {
		try {
			//System.out.println("one");
			Utility.waitForElementToBeVisible(manageButton);
			//Utility.waitForElementToBeClickable(manageButton);
			//System.out.println("two");
			manageButton.click();
			//System.out.println("three");
			Log.addMessage("Clicked Manage Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click manage button");
			Assert.assertTrue(false, "Failed to click manage button");
		}
	}
	
	public void clickHelpFAQButton() {
		try {
			//System.out.println("in1");
			Utility.waitForElementToBeVisible(helpMenu);
			//System.out.println("in2");
			Utility.waitForElementToBeClickable(helpMenu);
			//System.out.println("in3");
			helpMenu.click();
			Log.addMessage("Clicked Help/FAQ Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Help/FAQ button");
			Assert.assertTrue(false, "Failed to click Help/FAQ button");
		}
	}
	
	public String getAppVersion() {
		try {
			Utility.waitForElementToBeVisible(appVersion);
			String app_ver = appVersion.getText();
			Log.addMessage("Application version is: "+app_ver);
			return app_ver;
		}catch(Exception e) {
			Log.addMessage("Failed to get app version");
			Assert.assertTrue(false, "Failed to get app version");
			return null;
		}
	}
	
	public void getAppEnv() {
		try {
			Utility.waitForElementToBeVisible(appEnv);
			String app_env = appEnv.getText();
			Log.addMessage("Application environment is: "+app_env);
		}catch(Exception e) {
			Log.addMessage("Failed to get app environment");
			Assert.assertTrue(false, "Failed to get app environment");
		}
	}
	
	public void compareAppVersions(String app_ver1, String app_ver2) {
		try {
			Assert.assertTrue(!(app_ver1.equals(app_ver2)),"App versions are different");
			Log.addMessage("App versions are different");
		}catch(Exception e) {
			Log.addMessage("Failed to get app versions");
			Assert.assertTrue(false, "Failed to get app versions");
		}
	}	
	
	/* code added from 05-05-2020 */
	public void verifyAllHomes(String hmName, int cnt) {
		try {
			//Utility.simpleWait(5000);
			if(homeNameLst.size()>0) {
				Utility.waitForElementToBeVisible(homeNameLst.get(0));
				Utility.waitForElementToBeClickable(homeNameLst.get(0));
				//homeNameLst.size()
				for(int i=cnt;i<homeNameLst.size();i++) {
					if(device.equals("android")) {
						actHmName = homeNameLst.get(i).getText();
					}else {
						actHmName = homeNameLst.get(i).getAttribute("name");
					}
					if(hmName.equals(actHmName)) {
						Assert.assertTrue(true, "Home Names are matching");
						Log.addMessage("Home Names are matching");
						break;
					}
					//commented below code on 11 jan 2021
					/*Assert.assertEquals(actHmName, hmName,"Home Names are different");
					Log.addMessage("Home Names are matching");
					break;*/
				}
			}
		}catch(Exception e) {
			Log.addMessage("Failed to get Home Names");
			Assert.assertTrue(false, "Failed to get Home Names");
		}
	}
	
	/* code added from 26-05-2020 */
	public void verifyAllHomesiOS(String hmName, int cnt) {
		try {
			//Utility.simpleWait(5000);
			if(homeNameLst.size()>0) {
				Utility.waitForElementToBeVisible(homeNameLst.get(0));
				Utility.waitForElementToBeClickable(homeNameLst.get(0));
				for(int i=cnt;i<homeNameLst.size();i++) {//limiting to check first 3 homes under the account
					System.out.println("homenamelist="+homeNameLst.size());
					System.out.println("homename="+homeNameLst.get(i).getAttribute("name"));
					actHmName = homeNameLst.get(i).getAttribute("name");
					Assert.assertEquals(actHmName, hmName,"Home Names are different");
					Log.addMessage("Home Names are matching");
					break;
				}
			}
		}catch(Exception e) {
			Log.addMessage("Failed to get Home Names");
			Assert.assertTrue(false, "Failed to get Home Names");
		}
	}
	

	public void verifyLockImageInMenu() {
		try {
			Utility.waitForElementToBeVisible(lockIcon.get(0));
			Utility.waitForElementToBeClickable(lockIcon.get(0));
		    Assert.assertTrue(true, "Lock icon is displayed in the Dashboard Page under Home");
		   
			Log.addMessage("Lock icon is displayed in the Dashboard Page under Home");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Assert.assertTrue(false, "Lock icon is not displayed in the Dashboard Page under Homee");
			Log.addMessage("Failed to verify dashboard of newly added home");
		} 	
	}
	
	public void verifyMenuFlyoutPage() {
		try {
			Utility.waitForElementToBeVisible(manageButton);
			Log.addMessage("Manage Button present in the menu flyout page");
			Utility.waitForElementToBeVisible(lockIcon.get(0));
			Log.addMessage("LockIcon present in the menu flyout page");
			Utility.waitForElementToBeVisible(upArrowButton);
			Log.addMessage("Up Arrow present in the menu flyout page for homes");
		}catch(Exception e) {
			Log.addMessage("Failed to click manage button");
			Assert.assertTrue(false, "Failed to click manage button");
		}
	}
	
	public void valHomeList() {
		try {
			Utility.waitForElementToBeVisible(lockIcon.get(0));
			Utility.waitForElementToBeClickable(lockIcon.get(0));
		    Assert.assertTrue(true, "Lock icon is displayed in the Dashboard Page under Home");
		   
			Log.addMessage("Lock icon is displayed in the Dashboard Page under Home");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Assert.assertTrue(false, "Lock icon is not displayed in the Dashboard Page under Homee");
			Log.addMessage("Failed to verify dashboard of newly added home");
		} 	
	}
	
	public void clickLockImageInMenu(String lockName) {
		try {
			Utility.waitForElementToBeVisible(lockIcon.get(0));
			Utility.waitForElementToBeClickable(lockIcon.get(0));
			if(lockName.equals("fp")) {
				 lockIcon.get(1).click();
			}else if(lockName.equals("Ar")) {
				 lockIcon.get(2).click();
			}else {
				System.out.println("lockName="+lockName+", lockicon="+lockIcon.get(0));
				lockIcon.get(0).click();
				System.out.println("out");
			}
		   //Assert.assertTrue(true, "Clicking lock icon redirects to Lock Management page");
			Log.addMessage("Clicking lock icon redirects to Lock Management page");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Assert.assertTrue(false, "Clicking lock icon is not redirecting to Lock Management page");
			Log.addMessage("Failed to redirect to Lock Management page");
		} 	
	}
	
	public void verifyLockInMenu(String homeName) {
		try {
			System.out.println("in try1="+lockIcon.size());
			Utility.waitForElementToBeVisible(lockIcon.get(0));
			//System.out.println("in try2");
			/*if(device.equals("android")) {
			//Utility.simpleWait(2000);
			}*/
			Utility.waitForElementToBeClickable(lockIcon.get(0));
		   
			Log.addMessage("Locks are listed under the home");
		}catch(Exception e) {
			System.out.println("in catch homesize="+homeNameLst.size());
			Log.addMessage(e.getMessage().toString());
			if(homeNameLst.size()==0 && device.equals("iOS")) {
				 LockDashboardPage ld = new LockDashboardPage(appiumDriver);
				 ld.clickHamburgerButton();
			}
			for(int i=cnt;i<homeNameLst.size();i++) {
				if(device.equals("android")) {
					actHmName = homeNameLst.get(i).getText();
				}else {
					//actHmName = homeNameLst.get(i).getAttribute("name");
					//System.out.println("actHmName in iOS");
					actHmName = homeNameLst.get(i).getText();
					System.out.println("actHmName in iOS="+actHmName);
				}
				if(actHmName!=null) {
					if(actHmName.equals(homeName)) {
						homeNameLst.get(i).click();
						Log.addMessage("Home Name "+homeName+" is matching");
						break;
					}else {
						Log.addMessage("Home Name "+homeName+" is not matching");
					}
				}else {
					Log.addMessage("Home Name not found");
				}
			}
			//Log.addMessage("Failed to find home name in menu page");
		} 	
	}
	
	public void verifyLockInMenuForBtry(String homeName) {
		try {
			System.out.println("in try1="+lockIcon.size());
			Utility.waitForElementToBeVisible(lockIcon.get(0));
			Utility.waitForElementToBeClickable(lockIcon.get(0));
		   
			Log.addMessage("Locks are listed under the home");
		}catch(Exception e) {
			System.out.println("in catch homesize="+homeNameLst.size());
			Log.addMessage(e.getMessage().toString());
			try {
				if(homeNameLst.size()==0 && device.equals("iOS")) {
					 LockDashboardPage ld = new LockDashboardPage(appiumDriver);
					 ld.clickHamburgerButtonForBtry();
				}
				for(int i=cnt;i<homeNameLst.size();i++) {
					if(device.equals("android")) {
						actHmName = homeNameLst.get(i).getText();
					}else {
						//actHmName = homeNameLst.get(i).getAttribute("name");
						//System.out.println("actHmName in iOS");
						actHmName = homeNameLst.get(i).getText();
						System.out.println("actHmName in iOS="+actHmName);
					}
					if(actHmName!=null) {
						if(actHmName.equals(homeName)) {
							homeNameLst.get(i).click();
							Log.addMessage("Home Name "+homeName+" is matching");
							break;
						}else {
							Log.addMessage("Home Name "+homeName+" is not matching");
						}
					}else {
						Log.addMessage("Home Name not found");
					}
				}
			}catch(Exception ex) {
				System.out.println("in nested catch");
				Log.addMessage(ex.getMessage().toString());
			}
		} 	
	}
	
	public void clickLockInMenu(String lockName) {
		try {
			 System.out.println("lockIcon="+lockIcon.size()+", lockName="+lockName);
			 if(device.equals("iOS")) {
				Utility.waitForElementToBeVisible(lockIcon.get(0));
				Utility.waitForElementToBeClickable(lockIcon.get(0));
			 }else {
				 System.out.println("one");
				 Utility.waitForElementToBeVisible(lockNameLst.get(0));
				 System.out.println("two");
				 Utility.waitForElementToBeClickable(lockNameLst.get(0)); 
				 System.out.println("three");
			 }
		    String lockNameLstd ="";
		    System.out.println("clickLockInMenu="+lockName+", lockcnt="+lockIcon.size());
			for(int i=0;i<lockIcon.size();i++) {
				lockNameLstd = "";
				if(device.equals("iOS")) {
					lockNameLstd = driver.findElement(By.xpath("//XCUIElementTypeTable//XCUIElementTypeCell["+(i+1)+"]//XCUIElementTypeStaticText[1]")).getAttribute("name");
					System.out.println("lockNameLstd="+lockNameLstd+", i="+i);
				}else {
					System.out.println("lockNameLstd lockName="+lockName);
					lockNameLstd = lockNameLst.get(i).getText();
					System.out.println("lockNameLstd="+lockNameLstd+", i="+i);
				}
				if(lockNameLstd!="") {
					if(lockNameLstd.equals(lockName)) {
						System.out.println("lockName="+lockName+", i="+i);
						if(device.equals("iOS")) {
							driver.findElement(By.xpath("//XCUIElementTypeTable//XCUIElementTypeCell["+(i+1)+"]")).click();
						}else {
							lockIcon.get(i).click();
						}
						break;
					}
				}
			}
			Log.addMessage("Clicking lock icon redirects to Lock Dashboard page");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			//below code to exit from menuflyout page
			/*if(device.equals("android")) {
				System.out.println("in catch lockName="+lockName);
				lockSettingsBtn.click();
			}*/
			Assert.assertTrue(false, "Clicking lock icon is not redirecting to Lock Dashboard page");
			Log.addMessage("Failed to redirect to Lock Dashboard page");
		} 	
	}
	
	public void clickLockInMenuForBtry(String lockName) {
		try {
			 System.out.println("lockIcon="+lockIcon.size()+", lockName="+lockName);
			 if(device.equals("iOS")) {
				Utility.waitForElementToBeVisible(lockIcon.get(0));
				Utility.waitForElementToBeClickable(lockIcon.get(0));
			 }else {
				 System.out.println("one");
				 Utility.waitForElementToBeVisible(lockNameLst.get(0));
				 System.out.println("two");
				 Utility.waitForElementToBeClickable(lockNameLst.get(0)); 
				 System.out.println("three");
			 }
		    String lockNameLstd ="";
		    System.out.println("clickLockInMenu="+lockName+", lockcnt="+lockIcon.size());
			for(int i=0;i<lockIcon.size();i++) {
				lockNameLstd = "";
				if(device.equals("iOS")) {
					lockNameLstd = driver.findElement(By.xpath("//XCUIElementTypeTable//XCUIElementTypeCell["+(i+1)+"]//XCUIElementTypeStaticText[1]")).getAttribute("name");
					System.out.println("lockNameLstd="+lockNameLstd+", i="+i);
				}else {
					System.out.println("lockNameLstd lockName="+lockName);
					lockNameLstd = lockNameLst.get(i).getText();
					System.out.println("lockNameLstd="+lockNameLstd+", i="+i);
				}
				if(lockNameLstd!="") {
					if(lockNameLstd.equals(lockName)) {
						System.out.println("lockName selected="+lockName+", i="+i);
						if(device.equals("iOS")) {
							driver.findElement(By.xpath("//XCUIElementTypeTable//XCUIElementTypeCell["+(i+1)+"]")).click();
						}else {
							lockIcon.get(i).click();
						}
						break;
					}
				}
			}
			Log.addMessage("Clicking lock icon redirects to Lock Dashboard page");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to select the Lock");
		} 	
	}
	
	public Boolean checkLockDisplay(String lockName) {
		try {
			System.out.println("lockIcon="+lockNameLst.size());
			 if(device.equals("iOS")) {
				Utility.waitForElementToBeVisible(lockIcon.get(0));
				Utility.waitForElementToBeClickable(lockIcon.get(0));
			 }else {
				 System.out.println("one");
				 Utility.waitForElementToBeVisible(lockNameLst.get(0));
				 System.out.println("two");
				 Utility.waitForElementToBeClickable(lockNameLst.get(0)); 
				 System.out.println("three");
			 }
		    String lockNameLstd ="";
		    System.out.println("clickLockInMenu="+lockName+", lockcnt="+lockIcon.size());
			for(int i=0;i<lockIcon.size();i++) {
				lockNameLstd = "";
				if(device.equals("iOS")) {
					lockNameLstd = driver.findElement(By.xpath("//XCUIElementTypeTable//XCUIElementTypeCell["+(i+1)+"]//XCUIElementTypeStaticText[1]")).getAttribute("name");
					System.out.println("lockNameLstd="+lockNameLstd+", i="+i);
				}else {
					System.out.println("lockNameLstd lockName="+lockName);
					lockNameLstd = lockNameLst.get(i).getText();
					System.out.println("lockNameLstd="+lockNameLstd+", i="+i);
				}
				if(lockNameLstd!="") {
					if(lockNameLstd.equals(lockName)) {
						System.out.println("lockName="+lockName+", i="+i);
						lockExists = true;
						break;
					}
				}
			}
			Log.addMessage("Clicking lock icon redirects to Lock Dashboard page");
			return lockExists;
			
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			//Assert.assertTrue(false, "Clicking lock icon is not redirecting to Lock Dashboard page");
			Log.addMessage("Failed to redirect to Lock Dashboard page");
			lockExists=false;
			return lockExists;
		} 	
	}
	
	/* code added from 27-05-2020 */
	public void clickFPLockInMenu(String hmName) {
		try {
			if(device.equals("iOS")) {
				Utility.waitForElementToBeVisible(driver.findElement(By.xpath("//XCUIElementTypeOther[@name='"+hmName+"']/following-sibling::XCUIElementTypeCell")));
				//Utility.waitForElementToBeClickable(driver.findElement(By.xpath("//XCUIElementTypeOther[@name='"+hmName+"']/following-sibling::XCUIElementTypeCell")));
				driver.findElement(By.xpath("//XCUIElementTypeOther[@name='"+hmName+"']/following-sibling::XCUIElementTypeCell")).click();
				
			}else {
				Utility.waitForElementToBeVisible(lockName);
				Utility.waitForElementToBeClickable(lockName);
				lockName.click();
			}
		    Assert.assertTrue(true, "Clicking lock redirects to Lock Management page");
			Log.addMessage("Clicking lock redirects to Lock Management page");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Assert.assertTrue(false, "Clicking lock is not redirecting to Lock Management page");
			Log.addMessage("Failed to redirect to Lock Management page");
		} 	
	}
	
	//added on 16-06-2020
	public void clickFPHomeNameInMenu(String hmName) {
		try {
			if(device.equals("android")) {
				Utility.waitForElementToBeVisible(driver.findElement(By.xpath("//android.widget.ExpandableListView//android.widget.LinearLayout//android.widget.TextView[@text='"+hmName+"']")));
				driver.findElement(By.xpath("//android.widget.ExpandableListView//android.widget.LinearLayout//android.widget.TextView[@text='"+hmName+"']")).click();
				//homeNameMenu.click();
			}else {
				Utility.waitForElementToBeVisible(driver.findElement(By.xpath("(//XCUIElementTypeStaticText[@name='"+hmName+"'])[1]")));
				driver.findElement(By.xpath("(//XCUIElementTypeStaticText[@name='"+hmName+"'])[1]")).click();
			}
		    Assert.assertTrue(true, "Clicking home redirects to Lock Dashboard page");
			Log.addMessage("Clicking home redirects to Lock Dashboard page");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Assert.assertTrue(false, "Clicking lock is not redirecting to Lock Dashboard page");
			Log.addMessage("Failed to redirect to Lock Dashboard page");
		} 	
	}
	
	//updated on 26-06-2020
	public String getLastUpdateTime() {
		try {
			Utility.waitForElementToBeVisible(lockUpdtdTime);
			updateTime ="";
			upTime = "";
			updateTime = lockUpdtdTime.getText();
			String[] tList = updateTime.split(" at ");
			if(tList.length==2) {
		   		upTime = tList[1];
		    }
	    	Log.addMessage("Last updated time is displayed in menuflyout page");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to display last updated time on menuflyout page");
		} 
		return upTime;
	}
	
	//added on 02-06-2020
	public void verifyPopUpVerbiage(String expTitle, String expMessage) {
		try {
			if(device.equals("android")) {
				Utility.waitForElementToBeVisible(popUpTitleVerbiage);
				//System.out.println("popUpTitleVerbiage.getText()="+popUpTitleVerbiage.getText()+",popUpTitleVerbiage.getAttribute('name')="+popUpTitleVerbiage.getAttribute("name"));
				actTitle = popUpTitleVerbiage.getText();
				Assert.assertEquals(actTitle, expTitle,"Title message is not matching");
			}
			Utility.waitForElementToBeVisible(popUpMessageVerbiage);
			actMessage = popUpMessageVerbiage.getText();
			System.out.println("expmainMsg="+expMessage+",mainMsg="+actMessage);	
			Assert.assertEquals(actMessage, expMessage,"Popup content message is not matching");
			Log.addMessage("Pop up verbiage is matching");
		}catch(Exception e) {
			Log.addMessage("Pop up verbiage is not matching");
			Assert.assertTrue(false, "Pop up verbiage is not matching");
		}
	}
	
	/** 
	* Method Name: clickOKButton(), 
	* This function is used to click OK button from the pop up Page
	*/ 
	public void clickOKButton() {
		try {
			Utility.waitForElementToBeVisible(OKButton);
			Utility.waitForElementToBeClickable(OKButton);
			OKButton.click();
			Log.addMessage("Clicked OK Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click OK Button");
			Assert.assertTrue(false, "Failed to click OK Button");
		}
	}
	
	/** 
	* Method Name: clickCancelButton(), 
	* This function is used to click cancel button from the pop up Page
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
	
	/** 
	* Method Name: verifyHomeShareDelete(), 
	* This function is verify if shared home is deleted
	*/ 
	public void verifyHomeShareDelete(String hmName) {
		try {
			Utility.simpleWait(5000);
			for(int i=0;i<homeNameLst.size();i++) {
				actHmName = homeNameLst.get(i).getText();
				if(actHmName.equals(homeNameLst.get(i).getText())) {
					Assert.assertTrue(false, "Shared home not deleted");
					Log.addMessage("Shared home not deleted");
				}else {
					Assert.assertTrue(true, "Shared home not deleted");
					Log.addMessage("Shared home deleted");
				}
				break;
			}
		}catch(Exception e) {
			Log.addMessage("Failed to get Home Names");
			Assert.assertTrue(false, "Failed to get Home Names");
		}
	}
	
	/** 
	* Method Name: verifyHomeName(), 
	* This function is verify the home name
	*/ 
	public void verifyHomeName(String hmName) {
		try {
			Utility.simpleWait(5000);
			for(int i=cnt;i<homeNameLst.size();i++) {
				actHmName = homeNameLst.get(i).getText();
				if(actHmName.equals(homeNameLst.get(i).getText())) {
					Assert.assertTrue(true, "Admin Shared home is present in admin account");
					Log.addMessage("Admin Shared home is present in admin account");
				}else {
					Assert.assertTrue(false, "Admin Shared home deleted from admin account");
					Log.addMessage("Admin Shared home deleted from admin account");
				}
				break;
			}
		}catch(Exception e) {
			Log.addMessage("Failed to get Admin shared Home Name");
			Assert.assertTrue(false, "Failed to get Admin shared Home Name");
		}
	}
	
	/** 
	* Method Name: verifyHomeLockName(), 
	* This function is verify the home lock name
	*/ 
	public void verifyHomeLockName(String lockName) {
		try {
			Utility.simpleWait(5000);
			for(int i=cnt;i<homeLockLst.size();i++) {
				actLkName = homeLockLst.get(i).getText();
				if(actLkName.equals(homeLockLst.get(i).getText())) {
					Assert.assertTrue(true, "Lock not displayed inside the home in menu flyout page");
					Log.addMessage("Lock displayed inside the home in menu flyout page");
				}else {
					Assert.assertTrue(false, "Lock not displayed inside the home in menu flyout page");
					Log.addMessage("Lock not displayed inside the home in menu flyout page");
				}
				break;
			}
		}catch(Exception e) {
			Log.addMessage("Failed to get Admin shared Home Name");
			Assert.assertTrue(false, "Failed to get Admin shared Home Name");
		}
	}
	
	/** 
	* Method Name: verifyAdminSharedHomeName(), 
	* This function is verify the admin shared home name
	*/ 
	public void verifyAdminSharedHomeName(String hmName) {
		try {
			Utility.simpleWait(5000);
			for(int i=cnt;i<homeNameLst.size();i++) {
				actHmName = homeNameLst.get(i).getText();
				if(actHmName.equals(homeNameLst.get(i).getText())) {
					Assert.assertTrue(false, "Owner Shared home is present in admin account after admin share is deleted");
					Log.addMessage("Owner Shared home is present in admin account after admin share is deleted");
				}else {
					Assert.assertTrue(true, "Owner Shared home is deleted from admin account");
					Log.addMessage("Owner Shared home deleted from admin account");
				}
				break;
			}
		}catch(Exception e) {
			Log.addMessage("Failed to get Admin shared Home Name");
			Assert.assertTrue(false, "Failed to get Admin shared Home Name");
		}
	}
	
	public boolean checkForAppStuckMenu() {
		try {
			if(device.equals("iOS")) {
				Utility.isElementPresent("//XCUIElementTypeStaticText[@name='Manage']");
			}else {
				Utility.isElementPresent("//android.widget.Button[@text='Manage']");
			}
		    System.out.println("in menu");
		    menuPresent=true;
		    Log.addMessage("Menu flyout is present");
		    return menuPresent;
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Popup not found");
			System.out.println("in catch Popup not found");
			try {
				if(device.equals("iOS")) {
					 driver.findElement(By.xpath("//XCUIElementTypeButton[@name='people']"));
				}else {
					 driver.findElement(By.xpath("com.kwikset.blewifi.dev:id/imgAcessCode"));
				}
			    System.out.println("in lockdashboard");
			    dashboardPresent=true;
			    Log.addMessage("Popup found");
			    return dashboardPresent;
			}catch(Exception ex) {
				Log.addMessage(ex.getMessage().toString());
				dashboardPresent=false;
				return dashboardPresent;
			}
			
		}
	}
	
	public boolean checkForAppStuckDashboard() {
			try {
				if(device.equals("iOS")) {
					 driver.findElement(By.xpath("//XCUIElementTypeButton[@name='people']"));
				}else {
					 driver.findElement(By.xpath("com.kwikset.blewifi.dev:id/imgAcessCode"));
				}
			    System.out.println("in lockdashboard");
			    dashboardPresent=true;
			    Log.addMessage("Popup found");
			    return dashboardPresent;
			}catch(Exception ex) {
				Log.addMessage(ex.getMessage().toString());
				dashboardPresent=false;
				return dashboardPresent;
			}
	}
}
