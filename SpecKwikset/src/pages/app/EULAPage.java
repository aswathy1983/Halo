package pages.app;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import utility.Log;

public class EULAPage extends Settings{
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='I Agree']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_agree"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_agree"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_agree"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_agree")
	})
	@CacheLookup
	private MobileElement IAgreeButton;

	//Constructor
	@SuppressWarnings("static-access")
	public EULAPage(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
		
		
	/** 
	* Method Name: clickIAgreeButton(), 
	* This function is used to agree EULA
	*/
	public void clickIAgreeButton() {
		try {
			IAgreeButton.click();
			Log.addMessage("Agreed EULA");
		}catch(Exception e) {
			Log.addMessage("'I Agree' button is not present");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "I Agree' button is not present");
		}
	}
	
}
