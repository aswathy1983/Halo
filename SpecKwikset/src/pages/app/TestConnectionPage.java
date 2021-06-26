package pages.app;

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

public class TestConnectionPage extends Settings{
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Yes']")
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/txtYes")//added on 07-05-2020
	@CacheLookup
	private MobileElement yesButton;
	
	@iOSXCUITFindBy(id = "Pair")
	@CacheLookup
	private MobileElement pairButton;
	
	@iOSXCUITFindBy(id = "Cancel")
	@CacheLookup
	private MobileElement cancelButton;
	
	@iOSXCUITFindBy(id = "Ok")
	@CacheLookup
	private MobileElement OkButton;
	
	/* added on 07-05-2020 */
	
	@iOSXCUITFindBy(id = "No, try again")//added on 18-05-2020
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/txtTryAgain")
	@CacheLookup
	private MobileElement tryAgainButton;
	
	@iOSXCUITFindBy(id = "Help / FAQ")//added on 18-05-2020
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/txt_help_faq") 
	@CacheLookup
	private MobileElement helpFaqButton;
	
	@iOSXCUITFindBy(xpath = "XCUIElementTypeStaticText[@name='Back']")//added on 18-05-2020
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/cancelAllhomes")
	@CacheLookup
	private MobileElement backButton;
	
	/* added on 07-05-2020 */
	
	//Constructor
	@SuppressWarnings("static-access")
	public TestConnectionPage(AppiumDriver<MobileElement> driver) {
	this.appiumDriver = driver;
	PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void clickYesButton() {
		try {
			Thread.sleep(10000);
			yesButton.click();
			Log.addMessage("Clicked Yes Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Yes button");
			Assert.assertTrue(false, "Failed to click Yes button");
		}
	}
	
	public void clickPairButton() {
		try {
			Thread.sleep(4000);
			pairButton.click();
			Log.addMessage("Clicked Pair Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Pair button");
			Assert.assertTrue(false, "Failed to click Pair button");
		}
	}
	
	/*      added on 18-05-2020      */
	
	public void clickCancelButton() {
		try {
			Thread.sleep(2000);
			cancelButton.click();
			Log.addMessage("Clicked Cancel Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Cancel button");
			Assert.assertTrue(false, "Failed to click Cancel button");
		}
	}
	
	public void clickOkButton() {
		try {
			Thread.sleep(6000);
			OkButton.click();
			Log.addMessage("Clicked Ok Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Ok button");
			Assert.assertTrue(false, "Failed to click Ok button");
		}
	}
	
	/*      added on 07-05-2020      */
	/** 
	* Method Name: clickTryAgainButton(), 
	* This function is used to click Try Again Button in Test Connection Page
	*/
		
	public void clickTryAgainButton() {
		try {
			//Thread.sleep(6000);
			tryAgainButton.click();
			Log.addMessage("Clicked Try Again Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Try Again button");
			Assert.assertTrue(false, "Failed to click Try Again button");
		}
	}
	/** 
	* Method Name: clickBackButton(), 
	* This function is used to click Back button
	*/
		
	public void clickBackButton() {
		try {
			Thread.sleep(6000);
			backButton.click();
			Log.addMessage("Clicked Back Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Back button");
			Assert.assertTrue(false, "Failed to click Back button");
		}
	}
	
	/** 
	* Method Name: clickHelpFaqButton(), 
	* This function is used to click Help/Faq  option in Test Connection Page
	*/
		
	public void clickHelpFaqButton() {
		try {
			Thread.sleep(6000);
			helpFaqButton.click();
			Log.addMessage("Clicked Back Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Back button");
			Assert.assertTrue(false, "Failed to click Back button");
		}
	}
	
	/** 
	* Method Name: verifyElements(), 
	* This function is used to verify all Elements are present in Test Connection Page
	*/
		
	public void verifyElements() {
		try {
			Thread.sleep(6000);
			Assert.assertEquals(yesButton.getText(), "Yes","Yes button is present in the page");
			Assert.assertEquals(backButton.getText(), "Back","Back button is present in the page");
			Assert.assertEquals(helpFaqButton.getText(), "Help/Faq","Help/Faq button is present in the page");
			Assert.assertEquals(tryAgainButton.getText(), "Try Again","Try Again button is present in the page");
			Log.addMessage("All elements present in the Test Connection page");
		}catch(Exception e) {
			Log.addMessage("Failed to display Aal elements present in the Test Connection page");
			Assert.assertTrue(false, "Failed to display all elements present in the Test Connection page");
		}
	}
	
	/* added on 07-05-2020 */

}
