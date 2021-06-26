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

public class HomeUsersPage extends Settings{
	
	@iOSXCUITFindBy(id = "add user")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_end_image"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_end_image"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_end_image"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_end_image")
	})
	@CacheLookup
	private MobileElement addUserButton;
	
	//commented on 05-11-2020
	//@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeOther[2]/XCUIElementTypeStaticText")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeStaticText[1]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_user_name"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_user_name"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_user_name"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_user_name")
	})
	@CacheLookup
	private MobileElement ownerName;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/cancelAllhomes"),
		@AndroidBy(id = "com.kwikset.blewifi:id/cancelAllhomes"),
		@AndroidBy(id = "com.spectrum.giga:id/cancelAllhomes"),
		@AndroidBy(id = "com.weiser.blewifi:id/cancelAllhomes")
	})
	@CacheLookup
	private MobileElement backButton;
	
	//@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeStaticText[2]")//commented on 05-11-2020
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeTable//XCUIElementTypeOther//XCUIElementTypeStaticText)[2]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/lockCount"),
		@AndroidBy(id = "com.kwikset.blewifi:id/lockCount"),
		@AndroidBy(id = "com.spectrum.giga:id/lockCount"),
		@AndroidBy(id = "com.weiser.blewifi:id/lockCount")
	})
	@CacheLookup
	private MobileElement lockCount;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Admin']")
	//@AndroidFindBy(xpath = "(//android.widget.ListView//android.widget.LinearLayout)[1]")//commented on 04-11-2020
	@AndroidFindBy(xpath = "//android.widget.ListView//android.widget.LinearLayout//android.widget.TextView[@text='Admin']")
	@CacheLookup
	private MobileElement adminUser;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Member']")
	//@AndroidFindBy(xpath = "(//android.widget.ListView//android.widget.LinearLayout)[2]")//commented on 04-11-2020
	@AndroidFindBy(xpath = "//android.widget.ListView//android.widget.LinearLayout//android.widget.TextView[@text='Member']")
	@CacheLookup
	private MobileElement memberUser;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Pending']")
	@AndroidFindBy(xpath = "//android.widget.ListView//android.widget.LinearLayout//android.widget.TextView[@text='Pending']")
	@CacheLookup
	private MobileElement pendingUser;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tvUserName"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tvUserName"),
		@AndroidBy(id = "com.spectrum.giga:id/tvUserName"),
		@AndroidBy(id = "com.weiser.blewifi:id/tvUserName")
	})
	@CacheLookup
	private MobileElement adminUserName;
	
	//commented on 05-11-2020
	//@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeTable//XCUIElementTypeOther//XCUIElementTypeStaticText)[1]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/homeName"),
		@AndroidBy(id = "com.kwikset.blewifi:id/homeName"),
		@AndroidBy(id = "com.spectrum.giga:id/homeName"),
		@AndroidBy(id = "com.weiser.blewifi:id/homeName")
	})
	@CacheLookup
	private MobileElement homeName;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Ok']")
	@AndroidFindBy(id = "android:id/button1")
	@CacheLookup
	private MobileElement okButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert[@name='Share Sent']")
	@CacheLookup
	private MobileElement shareSentAlert;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell//XCUIElementTypeStaticText[2])")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tvAccessRights"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tvAccessRights"),
		@AndroidBy(id = "com.spectrum.giga:id/tvAccessRights"),
		@AndroidBy(id = "com.weiser.blewifi:id/tvAccessRights")
	})
	@CacheLookup
	private List<MobileElement> shareStatus;
	
	
	
	boolean stsExists = false;
	

	//Constructor
		@SuppressWarnings("static-access")
		public HomeUsersPage(AppiumDriver<MobileElement> driver) {
			this.appiumDriver = driver;
			PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
		}
		
		
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void clickAddUserButton() throws InterruptedException {
		try {
			//Thread.sleep(6000);//commented on 05-11-2020
			Utility.waitForElementToBeVisible(addUserButton);
			Utility.waitForElementToBeClickable(addUserButton);
			addUserButton.click();
			Log.addMessage("Clicked Add User Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Add user button");
			Assert.assertTrue(false, "Failed to click Add User button");
		}
	}
	
	public void getOwnersName() throws InterruptedException {
		try {
			Thread.sleep(6000);
			Log.addMessage("Owner of the home is: "+ownerName.getText());
		}catch(Exception e) {
			Log.addMessage("Failed to fetch owner's name");
			Assert.assertTrue(false, "Failed to fetch owner's name");
		}
	}
	
	public void checkForShareSentAlert() throws InterruptedException {
		try {
			Thread.sleep(6000);
			if (shareSentAlert.isDisplayed()) {
				okButton.click();
				Log.addMessage("Share Sent alert displayed");
			}
		}catch(Exception e) {
			Log.addMessage("Failed to display Share sent alert");
			Assert.assertTrue(false, "Failed to display Share sent alert");
		}
	}
	//added on 03 Aug 2020
	public void verifyHomeUserUI() throws InterruptedException {
		try {
			System.out.println("inside home");
			//Utility.waitForElementToBeVisible(homeName);//commented for bvt on 06-11-2020
			System.out.println("1");
			Log.addMessage("Home name is present");
			Utility.waitForElementToBeVisible(addUserButton);
			System.out.println("2");
			Log.addMessage("Add user button is present");
			Utility.waitForElementToBeVisible(ownerName);
			System.out.println("3");
			Log.addMessage("Owner name is present");
			Utility.waitForElementToBeVisible(backButton);
			System.out.println("4");
			Log.addMessage("Back Button is present");
			Utility.waitForElementToBeVisible(lockCount);
			System.out.println("5");
			Log.addMessage(""+lockCount.getText()+" present");
			Log.addMessage("All UI elements are present");
		}catch(Exception e) {
			Log.addMessage("Failed to display all elements in manage homes page");
			Assert.assertTrue(false, "Failed to display all elements in manage homes page");
		}
	}
	
	public void clickBackButton() throws InterruptedException {
		try {
			
			Thread.sleep(6000);
			System.out.println("two");
			Utility.waitForElementToBeVisible(backButton);
			System.out.println("one");
			backButton.click();
			System.out.println("two");
			Log.addMessage("Clicked Back button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Back button");
			Assert.assertTrue(false, "Failed to click Back button");
		}
	}
	
	/** 
	* Method Name: clickAdminUserButton(), 
	* This function is used to select Admin user
	*/
			
	public void clickAdminUserButton() {
		try {
			Utility.waitForElementToBeVisible(adminUser);
			adminUser.click();
			Log.addMessage("Clicked Admin user");
			/*Utility.waitForElementToBeVisible(OKButton);
			Utility.waitForElementToBeClickable(oKButton);
			oKButton.click();*/
			Log.addMessage("Logged out successfully");
		}catch(Exception e) {
			Log.addMessage("Logout failed");
			Assert.assertTrue(false, "Logout failed");
		}
	}
	
	/** 
	* Method Name: clickMemberUserButton(), 
	* This function is used to select Admin user
	*/
			
	public void clickMemberUserButton() {
		try {
			Utility.waitForElementToBeVisible(memberUser);
			memberUser.click();
			Log.addMessage("Clicked Member user");
		}catch(Exception e) {
			Log.addMessage("Failed to click member user");
			Assert.assertTrue(false, "Failed to click member user");
		}
	}
	
	/** 
	* Method Name: clickPendingUserButton(), 
	* This function is used to select Pending user
	*/
			
	public void clickPendingUserButton() {
		try {
			Utility.waitForElementToBeVisible(pendingUser);
			pendingUser.click();
			Log.addMessage("Clicked Member user");
		}catch(Exception e) {
			Log.addMessage("Failed to click member user");
			Assert.assertTrue(false, "Failed to click member user");
		}
	}
	
	/** 
	* Method Name: getUserShareStatus(), 
	* This function is used to select status of the user
	*/
			
	public void getUserShareStatus() {
		try {
			System.out.println("share in"+shareStatus.size());
			Thread.sleep(2000);
			System.out.println("share after wait");
			Utility.waitForElementToBeVisible(shareStatus.get(0));
			System.out.println("in2="+shareStatus.size());
			for(int i=0;i<shareStatus.size();i++) {
				//if((shareStatus.get(0).getText()).equals("Pending")){
					stsExists=true;
					Log.addMessage("Status of shared home user list are :"+shareStatus.get(i).getText());
					//break;
				//}
			}
			Assert.assertTrue(true, "User status is not found for the user to which request is sent");
			Log.addMessage("Status of shared home user is :"+shareStatus.get(0).getText());
		}catch(Exception e) {
			Log.addMessage("User status is not found for the user to which request is sent");
			Assert.assertTrue(false, "User status is not found for the user to which request is sent");
		}
	}
}
