package pages.portal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Settings;
import utility.Log;
import utility.Utility;

public class BetaJumpPage extends Settings{
	
	@FindBy(xpath="//input[@id='loginEmail']")
	WebElement emailField;
	
	//@FindBy(xpath="//input[@id='loginCode']")//commented on 22-07-2020
	@FindBy(xpath="//input[@id='loginPassword']")
	WebElement loginCode;
	
	@FindBy(xpath="//button[@id='loginSubmit']")
	WebElement verifyButton;
	
	@SuppressWarnings("static-access")
	public BetaJumpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	/**
	 * Method Name: verifyPageTitle() Description: This function will be called
	 * to verify title of the page
	 * @throws InterruptedException 
	 */

	public void verifyJumpPage() throws InterruptedException {
	  try {
		//Assert.assertEquals(driver.getTitle(),("Welcome to Beta Testing"));
		Assert.assertEquals(driver.getTitle(),("GoConcourse"));
		enterEmail();
		enterCode();
		clickVerifyButton();
		Log.addMessage("Beta user validated");
	  }catch(Exception e) {
			Log.addMessage("Waited for 30 seconds. Jump page not exists. Proceeding to Registration test.");
			Assert.assertTrue(false, "Jump page not exists after waiting checking for 30 seconds");
		}
	}
	
	/**
	 * Method Name: verifyBrandJumpPage() Description: This function will be called
	 * to verify title of the page
	 * @throws InterruptedException 
	 */

	public void verifyBrandJumpPage() throws InterruptedException {
	  try {
		//Assert.assertEquals(driver.getTitle(),("Welcome to Beta Testing"));
		Assert.assertEquals(driver.getTitle(),("GoConcourse"));
		Log.addMessage("Jump page verified");
	  }catch(Exception e) {
			Log.addMessage("Waited for 30 seconds. Jump page not exists. Proceeding to Registration test.");
			Assert.assertTrue(false, "Jump page not exists after waiting checking for 30 seconds");
		}
	}

	
	@SuppressWarnings("static-access")
	public void enterEmail() {
		try {
			Utility.waitForElementToBeVisible(emailField);
			Assert.assertTrue(emailField.isDisplayed(), "Email field displayed");
			emailField.clear();
			emailField.sendKeys("default@whitelisted.com");
		}catch(Exception e) {
			Log.addMessage("Waited for 30 seconds and failed to enter email");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Waited for 30 seconds and Failed to enter email");
		}
	}

	
	@SuppressWarnings("static-access")
	public void enterCode() {
		try {
			Utility.waitForElementToBeVisible(loginCode);
			Assert.assertTrue(loginCode.isDisplayed(), "Login code field displayed");
			loginCode.clear();
			loginCode.sendKeys("123456");
		}catch(Exception e) {
			Log.addMessage("Failed to enter login code after waiting for 30 seconds");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter login code after waiting for 30 seconds");
		}
	}
	
	
	@SuppressWarnings("static-access")
	public void clickVerifyButton() {
		try {
			Utility.waitForElementToBeVisible(verifyButton);
			Utility.waitForElementToBeClickable(verifyButton);
			Assert.assertTrue(verifyButton.isEnabled(), "Verify button displayed");
			verifyButton.click();
		}catch(Exception e) {
			Log.addMessage("Failed to click verify button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click verify button");
		}
	}
}
