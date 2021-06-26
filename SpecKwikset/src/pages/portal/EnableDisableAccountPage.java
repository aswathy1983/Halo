package pages.portal;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Settings;
import utility.Log;
import utility.Utility;


public class EnableDisableAccountPage extends Settings {
	
	@FindBy(id="submit")
	WebElement enableDisableButton;
	
	@FindBy(xpath="//div[@class='modal-footer']/button")
	WebElement disableButton;
	
	@FindBy(xpath="//div[@class='account-enable-bar']")
	WebElement disableBanner;
	
	@FindBy(xpath="//div//a[contains(text(),'here')]")
	WebElement enableDisableLink;
	
	@FindBy(xpath="//div[@class='col-xs-12 sp-back']//a")
	WebElement backLink;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible fade in']")
	WebElement updateMessage;
	
	@FindBy(xpath="(//div[@class='alert alert-danger alert-dismissible fade in']/a)[1]")
	WebElement closeButton;
	
	@FindBy(xpath="//h4[contains(text(),'Disable Confirmation')]")
	WebElement titlePopupMessage;
	
	@FindBy(xpath="//div[@class='modal-body']//p")
	WebElement contentPopupMessage;
	
	@FindBy(xpath="//button[contains(text(),'CONFIRM')]")
	WebElement confirmButton;
	
	@FindBy(xpath="//button[contains(text(),'CANCEL')]")
	WebElement cancelButton;
	
	
	@SuppressWarnings("static-access")
	public EnableDisableAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
  

	/**
	 * Method Name: enableOrDisableAccount() Description: This function will be called
	 * to enable or disable account
	 */
	
	public void enableOrDisableAccount() {
		try {
			Assert.assertTrue(enableDisableButton.isDisplayed(), "Enable/Disable account is visible");
			if(enableDisableButton.getText().equals("ENABLE")) {
				enableDisableButton.click();
				Log.addMessage("Account is enabled");
			}
			else if(enableDisableButton.getText().equals("DISABLE")) {
				enableDisableButton.click();
				Utility.waitForElementToBeVisible(disableButton);
				disableButton.click();
				Log.addMessage("Account is disabled");
			}else {
				Log.addMessage("Account status not available");
			}
		}catch(Exception e) {
			Log.addMessage("Failed to enable/Disable account");
			Log.addMessage(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enable/Disable account");
		}
	}
	
	/**
	 * Method Name: enableOrDisableAccount() Description: This function will be called
	 * to enable or disable account
	 */
	
	public void enableDisableAccount() {
		try {
			Assert.assertTrue(enableDisableButton.isDisplayed(), "Enable/Disable account is visible");
			if(enableDisableButton.getText().equals("ENABLE")) {
				enableDisableButton.click();
				Log.addMessage("Account is enabled");
			}
			else if(enableDisableButton.getText().equals("DISABLE")) {
				enableDisableButton.click();
				Log.addMessage("Account is disabled");
			}else {
				Log.addMessage("Account status not available");
			}
		}catch(Exception e) {
			Log.addMessage("Failed to enable/Disable account");
			Log.addMessage(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enable/Disable account");
		}
	}
	
	
	/**
	 * Method Name: verifyAlertVerbiageCancel() Description: This function will be called
	 * to  verify alert validation and cancel the popup
	*/
	
	public void verifyAlertVerbiageCancel(String titleMessage,String valMessage) {
		try {
			System.out.println("in alert1 valMessage="+valMessage);
			Utility.simpleWait(25000);
			//driver.switchTo().alert();
			System.out.println("in alert2");
			/*String parentWindow = driver.getWindowHandle();
			Set<String> s=driver.getWindowHandles();
			System.out.println("size="+s.size());
			// Now iterate using Iterator
			Iterator<String> I1= s.iterator();

			while(I1.hasNext())
			{
				String child_window=I1.next();
				System.out.println("message in popup="+driver.switchTo().window(child_window));
			}*/
			System.out.println("out");
			//System.out.println("text="+driver.switchTo().alert().getText());
			Assert.assertTrue(titlePopupMessage.getText().contains(titleMessage),"Title verbiage is matching");
			Log.addMessage("Title verbiage is matching");
			Assert.assertTrue(contentPopupMessage.getText().contains(valMessage),"Content verbiage is matching");
			Log.addMessage("Content verbiage is matching");
			Thread.sleep(3000);
			cancelButton.click();
			Thread.sleep(3000);
			//driver.switchTo().window(parentWindow);
			Log.addMessage("Clicked cancel button in the pop up");
		}catch(Exception e) {
			Log.addMessage("Validation is not matching");
			Assert.assertTrue(false, "Validation is not matching");
		}
	}
	
	/**
	 * Method Name: verifyAlertAccept() Description: This function will be called
	 * to  verify alert validation and accept the popup
	*/
	
	public void verifyAlertAccept() {
		try {
			/*String parentWindow = driver.getWindowHandle();
			Set<String> s=driver.getWindowHandles();
			System.out.println("size="+s.size());
			// Now iterate using Iterator
			Iterator<String> I1= s.iterator();

			while(I1.hasNext())
			{
				String child_window=I1.next();
				System.out.println("message in popup="+driver.switchTo().window(child_window));
			}*/
			confirmButton.click();
			Thread.sleep(3000);
			Log.addMessage("Clicked confirm button in the pop up");
		}catch(Exception e) {
			Log.addMessage("Failed to click confirm button");
			Assert.assertTrue(false, "Failed to click confirm button");
		}
	}
	
	/**
	 * Method Name: verifyValidationMessage() Description: This function will be called
	 * to  verify disable validation 
	*/
	
	public void verifyValidationMessage(String valMessage) {
		try {
			Utility.waitForElementToBeVisible(updateMessage);
			System.out.println("updateMessage="+updateMessage.getText());
			System.out.println("valMessage="+valMessage);
			Assert.assertTrue(updateMessage.getText().contains(valMessage),"Validation message is not matching");
			Log.addMessage("Validation message is matching");
			closeButton.click();
			Log.addMessage("Clicked close button");
			Thread.sleep(3000);
		}catch(Exception e) {
			Log.addMessage("Validation is not matching");
			Assert.assertTrue(false, "Validation is not matching");
		}
	}
	
	/**
	 * Method Name: clickEnableDisableFromBanner() Description: This function will be called
	 * to click Enable/Disable from the banner
	 */
	
	public void clickEnableDisableFromBanner() {
		try {
			Utility.waitForElementToBeVisible(enableDisableLink);
			enableDisableLink.click();
			Log.addMessage("Clicked account enable/disable link in banner");
		}catch(Exception e) {
			Log.addMessage("Failed to click account enable/disable link in banner");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click account enable/disable link in banner");
		}
	}
	
	/**
	 * Method Name: clickBackToHome() Description: This function will be called
	 * to click Back navigation
	 */
	
	public void clickBackToHome() {
		try {
			Utility.waitForElementToBeVisible(backLink);
			backLink.click();
			Log.addMessage("Clicked back navigation link");
		}catch(Exception e) {
			Log.addMessage("Failed to click back navigation link");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click back navigation link");
		}
	}
	
	/**
	 * Method Name: validateBrowserBack() Description: This function will be called
	 * to validate browser back navigation
	 */
	
	public void validateBrowserBack() {
		try {
			Utility.simpleWait(2000);
			driver.navigate().back(); 
			Assert.assertTrue(true,"Clicked browser back button");
			Thread.sleep(3000);
			Log.addMessage("Clicked browser back button");
		}catch(Exception e) {
			Log.addMessage("Failed to click browser back button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click browser back button");
		}
	}
	
	/**
	 * Method Name: verifyDisableBannerMessage() Description: This function will be called
	 * to  verify disable validation 
	*/
	
	public void verifyDisableBannerMessage(String valMessage) {
		try {
			System.out.println("in banner validation="+valMessage);
			Utility.waitForElementToBeVisible(disableBanner);
			System.out.println("after banner is visible="+disableBanner.getText());
			Assert.assertTrue(disableBanner.getText().contains(valMessage),"Banner message displayed is not matching");
			Log.addMessage("Banner message is matching");
			Thread.sleep(3000);
		}catch(Exception e) {
			Log.addMessage("Banner verbiage is not matching");
			Assert.assertTrue(false, "Banner verbiage is not matching");
		}
	}
	

}
