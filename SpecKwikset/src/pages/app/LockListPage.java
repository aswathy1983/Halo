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

public class LockListPage extends Settings  {
	/* created on 15-09-2020 */
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Submit']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/door_name"),
		@AndroidBy(id = "com.kwikset.blewifi:id/door_name"),
		@AndroidBy(id = "com.spectrum.giga:id/door_name"),
		@AndroidBy(id = "com.weiser.blewifi:id/door_name")
	})
	@CacheLookup
	private List<MobileElement> listLockName;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/cancelAllhomes")
	@CacheLookup
	private MobileElement navBack;
	
	//Constructor
	@SuppressWarnings("static-access")
	public LockListPage(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
		
	/** 
	* Method Name: selectLockName(), 
	* This function is used to select one Lock from the locks listed Page
	*/
		
	public void selectLockName(String lockname) {
		try {
			Utility.waitForElementToBeVisible(listLockName.get(0));
			System.out.println("in select lock name");
			for(int i = 0; i<listLockName.size();i++) {
				if(listLockName.get(i).getText().equals(lockname)) {
					listLockName.get(i).click();
					break;
				}
			}
			System.out.println("outside lock selection");
			
			Log.addMessage("Selected one lock");
		}catch(Exception e) {
			Log.addMessage("Failed to select one lock");
			Assert.assertTrue(false, "Failed to select one lock");
		}
	}
	
	
	/** 
	* Method Name: clickBackButton(), 
	* This function is used to click Back button from Add lock name page
	*/
		
	public void clickBkButton() {
		try {
			Thread.sleep(6000);
			System.out.println("in lockname backmthd");
			Utility.waitForElementToBeVisible(navBack);
			Utility.waitForElementToBeClickable(navBack);
			System.out.println("inside clickBackButton");
			navBack.click();
			System.out.println("clicked clickBackButton");
			Log.addMessage("Clicked Back Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Back button");
			Assert.assertTrue(false, "Failed to click Back button");
		}
	}

}
