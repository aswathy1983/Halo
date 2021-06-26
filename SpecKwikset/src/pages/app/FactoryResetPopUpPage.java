package pages.app;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utility.Log;
import utility.Utility;

public class FactoryResetPopUpPage extends Settings {
	
	/*         created on 07-05-2020          */
	
	
	@AndroidFindBy(id="android:id/button1")
	@CacheLookup
	private MobileElement OKButton;
	
	@AndroidFindBy(id="android:id/alertTitle")
	@CacheLookup
	private MobileElement popUpTitleVerbiage;
	
	@AndroidFindBy(id="android:id/message")
	@CacheLookup
	private MobileElement popUpMessageVerbiage;
	
	String actTitle, actMessage ="";
	
	//Constructor
	
	@SuppressWarnings("static-access")
	public FactoryResetPopUpPage(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
	
	public void clickOKButton() {
		try {
			Utility.waitForElementToBeVisible(OKButton);
			Utility.waitForElementToBeClickable(OKButton);
			OKButton.click();
			Log.addMessage("Clicked OK button in the factory reset pop up page");
		}catch(Exception e) {
			Log.addMessage("Failed to display factory reset pop up");
			Assert.assertTrue(false, "Failed to display factory reset pop up");
		}
	}
	
	public void verifyPopUpVerbiage(String expTitle, String expMessage) {
		try {
			Utility.waitForElementToBeVisible(popUpTitleVerbiage);
			actTitle = popUpTitleVerbiage.getText();
			Assert.assertEquals(actTitle, expTitle,"Title is not matching");
			Utility.waitForElementToBeVisible(popUpMessageVerbiage);
			actMessage = popUpMessageVerbiage.getText();
			Assert.assertEquals(actMessage, expMessage,"Message is not matching");
			
			Log.addMessage("Pop up verbiage is matching");
		}catch(Exception e) {
			Log.addMessage("Pop up verbiage is not matching");
			Assert.assertTrue(false, "Pop up verbiage is not matching");
		}
	}


}
