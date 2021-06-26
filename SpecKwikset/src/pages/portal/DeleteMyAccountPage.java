package pages.portal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import base.Settings;
import utility.Log;
import utility.Utility;


public class DeleteMyAccountPage extends Settings{
	
	@FindBy(id="submit")
	WebElement deleteButton;
	
	@FindBy(xpath="//div[@class='modal-footer']/button[1]")
	WebElement deleteOption;
	
	@FindBy(xpath="//div[@class='modal-footer']/button[2]")
	WebElement cancelOption;
	
	@SuppressWarnings("static-access")
	public DeleteMyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Method Name: deleteAccount() Description: This function will be called
	 * to delete account
	 */
	
	public void deleteAccount() {
		try {
			Assert.assertTrue(deleteButton.isDisplayed(), "DeleteAccount Button is visible");
			deleteButton.click();
			Utility.waitForElementToBeClickable(deleteOption);
			Assert.assertTrue(deleteOption.isDisplayed(),"Delete option in popup is not visible");
			deleteOption.click();
			Utility.simpleWait(6000);
			Log.addMessage("Account is deleted");
		}catch(Exception e) {
			Log.addMessage("Failed to delete account");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to delete account");
		}
	}
	
	/**
	 * Method Name: deleteCancelAccount() Description: This function will be called
	 * to cancel delete account pop up
	 */
	
	public void deleteCancelAccount() {
		try {
			Assert.assertTrue(deleteButton.isDisplayed(), "DeleteAccount Button is visible");
			deleteButton.click();
			Utility.waitForElementToBeClickable(cancelOption);
			Assert.assertTrue(cancelOption.isDisplayed(),"Cancel option in popup is not visible");
			cancelOption.click();
			Utility.simpleWait(6000);
			Log.addMessage("Account deletion is cancelled");
		}catch(Exception e) {
			Log.addMessage("Failed to cancel delete");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to cancel delete");
		}
	}

}
