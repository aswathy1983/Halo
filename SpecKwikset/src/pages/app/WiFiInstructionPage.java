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

public class WiFiInstructionPage extends Settings {
	
	@iOSXCUITFindBy(id = "Next")
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/tv_next")
	@CacheLookup
	private MobileElement nextButton;
	
	/* added on 07-05-2020 */
	
	@iOSXCUITFindBy(id = "Back")
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/cancelAllhomes")
	@CacheLookup
	private MobileElement backButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText")
	@AndroidFindBy(xpath="//android.widget.TextView")
	@CacheLookup
	private List<MobileElement> txtInstruction;
	
	String actTitle, actMessage1, actMessage2 ="";
	
	//Constructor
	@SuppressWarnings("static-access")
	public WiFiInstructionPage(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void clickNextButton() {
		try {
			Thread.sleep(6000);
			//System.out.println("size of textview=");//added on 08-05-2020
			nextButton.click();
			Log.addMessage("Clicked Next button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Next button");
			Assert.assertTrue(false, "Failed to click Next button");
		}
	}
	/* added on 07-05-2020 */
	
	/** 
	* Method Name: clickBackButton(), 
	* This function is used to click Back button from Wifi Instruction page
	*/
		
	public void clickBackButton() {
		try {
			
			Utility.waitForElementToBeVisible(backButton);
			Utility.waitForElementToBeClickable(backButton);
			backButton.click();
			Log.addMessage("Clicked Back Button from Wifi Instruction");
		}catch(Exception e) {
			Log.addMessage("Failed to click Back button from Wifi Instruction");
			Assert.assertTrue(false, "Failed to click Back button from Wifi Instruction");
		}
	}
	
	public void verifyWifiInstructionVerbiage(String expTitle, String expMessage1, String expMessage2) {
		try {
			System.out.println("instructions verbiage size="+txtInstruction.size());
			Utility.waitForElementToBeVisible(txtInstruction.get(3));
			actTitle = txtInstruction.get(3).getText();
			Assert.assertEquals(actTitle, expTitle,"Title message is not matching");
			
			System.out.println("Verified expTitle="+expTitle+",actTitle="+actTitle);
			
			Log.addMessage("Verified title message in Wifi Instruction page");
			Utility.waitForElementToBeVisible(txtInstruction.get(5));
			actMessage1 = txtInstruction.get(5).getText();
			
			System.out.println("Verified expTitle="+expMessage1+",actTitle="+actMessage1);
			
			
			Assert.assertEquals(actMessage1, expMessage1,"Message in para1 is not matching");
			Log.addMessage("Verified message in para1 in Wifi Instruction page");
			
			Utility.waitForElementToBeVisible(txtInstruction.get(7));
			
			actMessage2 = txtInstruction.get(7).getText();
			
			System.out.println("Verified expTitle="+expMessage2+",actTitle="+actMessage2);
			
			Assert.assertEquals(actMessage2, expMessage2,"Message in para2 is not matching");
			Log.addMessage("Verified message in para2 in Wifi Instruction page");
			Log.addMessage("Verified the Wifi instruction verbiage");
		}catch(Exception e) {
			Log.addMessage("Wifi instruction verbiage is not matching");
			Assert.assertTrue(false, "Wifi instruction verbiage is not matching");
		}
	}
	/* added on 07-05-2020 */
	public void verifyiOSWifiInstructionVerbiage(String expTitle, String expMessage1, String expMessage2) {
		try {
			System.out.println("instructions verbiage size="+txtInstruction.size());
			System.out.println("instructions verbiage size="+txtInstruction.get(2).getText());
			Utility.waitForElementToBeVisible(txtInstruction.get(2));
			actTitle = txtInstruction.get(2).getText();
			Assert.assertEquals(actTitle, expTitle,"Title message is not matching");
			
			System.out.println("Verified expTitle="+expTitle+",actTitle="+actTitle);
			
			Log.addMessage("Verified title message in Wifi Instruction page");
			Utility.waitForElementToBeVisible(txtInstruction.get(3));
			actMessage1 = txtInstruction.get(3).getText();
			
			System.out.println("Verified expTitle="+expMessage1+",actTitle="+actMessage1);
			
			
			Assert.assertEquals(actMessage1, expMessage1,"Message in para1 is not matching");
			Log.addMessage("Verified message in para1 in Wifi Instruction page");
			
			Utility.waitForElementToBeVisible(txtInstruction.get(4));
			
			actMessage2 = txtInstruction.get(4).getText();
			
			System.out.println("Verified expTitle="+expMessage2+",actTitle="+actMessage2);
			
			Assert.assertEquals(actMessage2, expMessage2,"Message in para2 is not matching");
			Log.addMessage("Verified message in para2 in Wifi Instruction page");
			Log.addMessage("Verified the Wifi instruction verbiage");
		}catch(Exception e) {
			Log.addMessage("Wifi instruction verbiage is not matching");
			Assert.assertTrue(false, "Wifi instruction verbiage is not matching");
		}
	}
	/* added on 19-05-2020 */

}
