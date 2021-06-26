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
import utility.Utility;

public class LockAddSuccessPopupPage extends Settings {
	
	/*         created on 13-05-2020          */
	
	
	@iOSXCUITFindBy(id = "Ok")
	@AndroidFindBy(id = "android:id/button1")
	@CacheLookup
	private MobileElement OkButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[1]")
	@AndroidFindBy(id = "android:id/alertTitle")
	@CacheLookup
	private MobileElement popUpTitleVerbiage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[2]")
	@AndroidFindBy(id = "android:id/message")
	@CacheLookup
	private MobileElement popUpMessageVerbiage;
	
	String actTitle, actMessage ="";
	
		//Constructor
	
		@SuppressWarnings("static-access")
		public LockAddSuccessPopupPage(AppiumDriver<MobileElement> driver) {
			this.appiumDriver = driver;
			PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
		}
		
		public void clickOkButton() {
			try {
				Utility.waitForElementToBeVisible(OkButton);
				Utility.waitForElementToBeClickable(OkButton);
				OkButton.click();// commented as need to check presence of OK button only
				Log.addMessage("Ok button present in the pop up page");
			}catch(Exception e) {
				Log.addMessage("Failed to display Ok button in the pop up");
				Assert.assertTrue(false, "Failed to display Ok button in the pop up");
			}
		}
		
		public void verifyPopUpVerbiage(String expTitle, String expMessage) {
			try {
				System.out.println("in popupverbiage");
				Utility.waitForElementToBeVisible(popUpTitleVerbiage);
				System.out.println("popUpTitleVerbiage.getText()="+popUpTitleVerbiage.getText()+",popUpTitleVerbiage.getAttribute('name')="+popUpTitleVerbiage.getAttribute("name"));
				actTitle = popUpTitleVerbiage.getText();
				Assert.assertEquals(actTitle, expTitle,"Title message is not matching");
				Utility.waitForElementToBeVisible(popUpMessageVerbiage);
				actMessage = popUpMessageVerbiage.getText();
				Assert.assertEquals(actMessage, expMessage,"Content message is not matching");
				
				Log.addMessage("Pop up verbiage is matching");
			}catch(Exception e) {
				Log.addMessage("Pop up verbiage is not matching");
				Assert.assertTrue(false, "Pop up verbiage is not matching");
			}
		}

}

