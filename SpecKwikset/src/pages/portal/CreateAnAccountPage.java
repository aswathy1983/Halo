package pages.portal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import base.Settings;
import utility.Log;
import utility.Utility;

public class CreateAnAccountPage extends Settings {
	
	@FindBy(id="firstName")
	WebElement firstNameField;
	
	@FindBy(id="lastName")
	WebElement lastNameField;
	
	@FindBy(xpath="//iframe[@role='presentation']")
	WebElement iframe;
	
	@FindBy(xpath="//div[@class='recaptcha-checkbox-border']")
	WebElement captcha;
	
	@FindBy(xpath="//label[@class='sp-checkbox']/span")
	WebElement termsAndConditionsCheckbox;
	
	@FindBy(xpath="//label[2]")
	WebElement EULACheckbox;
	
	@FindBy(id="submitInfo")
	WebElement nextButton;
	
	@FindBy(xpath="//*[@id=\"ngrecaptcha-0\"]/div/div/iframe")
	WebElement recpatchaframe;
	
	@FindBy(xpath="//input[@id='firstName']/following-sibling::p")
	WebElement firstNameValidationMessage;
	
	@FindBy(xpath="//input[@id='lastName']/following-sibling::p")
	WebElement lastNameValidationMessage;
	
	//@FindBy(linkText="Privacy")//commented and updated on 17-02-2021
	@FindBy(linkText="Privacy Policy")
	WebElement privacy;
	
	@FindBy(linkText="Support Center")
	WebElement supportCntr;
	
	@FindBy(linkText="Products")
	WebElement product;
	
	@FindBy(linkText="Apps")
	WebElement apps;
	
	@FindBy(linkText="Web Accessibility")
	WebElement webAcs;
	
	@FindBy(linkText="Version Info")
	WebElement verInfo;
	
	@FindBy(xpath="//button[@class='close']")
	WebElement btnClose;
	
	@FindBy(xpath="//div[@class='branding branding--kwikset']")
	WebElement kwikBrand;
	
	@FindBy(xpath="(//img[contains(@alt,'Weiser')])[2]")
	WebElement weisBrand;
	
	@FindBy(linkText="Terms")
	WebElement terms;
	
	@FindBy(linkText="Terms and Conditions")
	WebElement termsCondition;
	
	@FindBy(linkText="EULA")
	WebElement eula;

	
	@SuppressWarnings("static-access")
	public CreateAnAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	/**
	 * Method Name: enterFirstName() Description: This function will be called
	 * to enter First Name
	 */
	
	public void enterFirstName(String firstname) {
		try {
			Utility.waitForElementToBeVisible(firstNameField);
			Assert.assertTrue(firstNameField.isDisplayed(), "FirstName field is visible");
			firstNameField.clear();
			firstNameField.sendKeys(firstname);
			Log.addMessage("First Name entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter First Name");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter First Name");
		}
	}
	

	/**
	 * Method Name: enterLastName() Description: This function will be called
	 * to enter Last Name
	 */
	
	public void enterLastName(String lastname) {
		try {
			Utility.waitForElementToBeVisible(lastNameField);
			Assert.assertTrue(lastNameField.isDisplayed(), "LastName field is visible");
			lastNameField.clear();
			lastNameField.sendKeys(lastname);
			Log.addMessage("Last Name entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter Last Name");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter Last Name");
		}
	}
	
	/**
	 * Method Name: checkAcNamePlaceHolderText() Description: This function will be called
	 * to enter First Name
	 */
	
	public void checkAcNamePlaceHolderText(String firstName, String lastName) {
		try {
			Utility.waitForElementToBeVisible(firstNameField);
			Assert.assertEquals(firstNameField.getAttribute("placeholder"),firstName,"Place holder text not matching for first name field");
			Log.addMessage("First Name place holder text is matching");
			Utility.waitForElementToBeVisible(lastNameField);
			Assert.assertEquals(lastNameField.getAttribute("placeholder"),lastName,"Place holder text not matching for last name field");
			Log.addMessage("Last Name place holder text is matching");
		}catch(Exception e) {
			Log.addMessage("Failed to enter First Name");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter First Name");
		}
	}
	

	/**
	 * Method Name: clickTermsAndConditionsCheckbox() Description: This function will be called
	 * to click Terms And Conditions checkbox
	*/
	
	public void clickTermsAndConditionsCheckBox() {
		try {
			Utility.simpleWait(3000);
			driver.switchTo().defaultContent();
			Utility.waitForElementToBeVisible(termsAndConditionsCheckbox);
			Utility.waitForElementToBeClickable(termsAndConditionsCheckbox);
			System.out.println("isEnabled="+termsAndConditionsCheckbox.isEnabled());
			Assert.assertTrue(termsAndConditionsCheckbox.isDisplayed(), "Terms and Conditions checkbox visible");
			termsAndConditionsCheckbox.click();
			Log.addMessage("Terms And Conditions checkbox clicked");
		}
		catch(Exception e) {
			Log.addMessage("Unable to click Terms And Conditions checkbox");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click Terms And Conditions checkbox");
		}
	}
	
	/**
	 * Method Name: toSwitchWindow() Description: This function will be called
	 * to click Terms And Conditions checkbox
	*/
	
	public void toSwitchWindow(String winHandleBefore) {
		try {
			// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}
			// Perform the actions on new window
			// Close the new window, if that window no more required
			driver.close();
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			Log.addMessage("Terms And Conditions checkbox clicked");
		}
		catch(Exception e) {
			Log.addMessage("Unable to click Terms And Conditions checkbox");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click Terms And Conditions checkbox");
		}
	}
	
	/**
	 * Method Name: toSwitchSupportWindow() Description: This function will be called
	 * to check kwikset logo
	*/
	
	public void toSwitchSupportWindow(String winHandleBefore, String linkType) {
		try {
			// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}
			// Perform the actions on new window
			Utility.simpleWait(10000);
			//driver.switchTo().frame(0);
			Utility.waitForElementToBeVisible(kwikBrand);
			Utility.waitForElementToBeClickable(kwikBrand);
			if(linkType.equals("support")) {
				Assert.assertTrue(kwikBrand.isDisplayed(), "Kwikset logo displayed in Support Center page");
				Log.addMessage("Kwikset logo displayed in Support Center page");
			}else if(linkType.equals("product")) {
				Assert.assertTrue(kwikBrand.isDisplayed(), "Kwikset logo displayed in Products page");
				Log.addMessage("Kwikset logo displayed in Products page");
			}else {
				Assert.assertTrue(kwikBrand.isDisplayed(), "Kwikset logo displayed in Apps page");
				Log.addMessage("Kwikset logo displayed in Apps page");
			}
			// Close the new window, if that window no more required
			driver.close();
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			Log.addMessage("Create account page displayed");
		}catch(Exception e) {
			Log.addMessage("Unable to display Kwikset logo in the selected page");
			System.out.println(e.getMessage().toString());
			// Close the new window, if that window no more required
			driver.close();
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			Assert.assertTrue(false, "Failed to display Kwikset logo in Support Center page");
		}
	}
	

	/**
	 * Method Name: toSwitchSupportWindow() Description: This function will be called
	 * to check Weiser logo
	*/
	
	public void toSwitchSupportWeiserWindow(String winHandleBefore, String linkType) {
		try {
			// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
				System.out.println("in");
			    driver.switchTo().window(winHandle);
			    System.out.println("in2");
			}
			// Perform the actions on new window
			Utility.simpleWait(10000);
			//driver.switchTo().frame(0);
			Utility.waitForElementToBeVisible(weisBrand);
			  System.out.println("in3");
			Utility.waitForElementToBeClickable(weisBrand);
			System.out.println("in4");
			if(linkType.equals("support")) {
				Assert.assertTrue(weisBrand.isDisplayed(), "Weiser logo displayed in Support Center page");
				Log.addMessage("Weiser logo displayed in Support Center page");
			}else if(linkType.equals("product")) {
				Assert.assertTrue(weisBrand.isDisplayed(), "Kwikset logo displayed in Products page");
				Log.addMessage("Weiser logo displayed in Products page");
			}else {
				Assert.assertTrue(weisBrand.isDisplayed(), "Kwikset logo displayed in Apps page");
				Log.addMessage("Weiser logo displayed in Apps page");
			}
			System.out.println("in5");
			// Close the new window, if that window no more required
			driver.close();
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			Log.addMessage("Displayed create an account page");
		}catch(Exception e) {
			Log.addMessage("Unable to display Kwikset logo in the selected page");
			System.out.println(e.getMessage().toString());
			// Close the new window, if that window no more required
			driver.close();
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			Assert.assertTrue(false, "Failed to display Kwikset logo in the selected page");
		}
	}

	/**
	 * Method Name: toClearBrowserHistory() Description: This function will be called
	 * to clear browser history data and to switch to parent window
	*/
	
	public void toClearBrowserHistory(String winHandleBefore) {
		try {
			// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}
			// Perform the actions on new window
			// Close the new window, if that window no more required
			driver.close();
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			Log.addMessage("Terms And Conditions checkbox clicked");
		}
		catch(Exception e) {
			Log.addMessage("Unable to click Terms And Conditions checkbox");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click Terms And Conditions checkbox");
		}
	}
	

	/**
	 * Method Name: clickEULAcheckBox() Description: This function will be called
	 * to click EULA checkbox
	 */
	
	public void clickEULAcheckBox() {
		try {
			Utility.waitForElementToBeVisible(EULACheckbox);
			Utility.waitForElementToBeClickable(EULACheckbox);
			Assert.assertTrue(EULACheckbox.isDisplayed(), "EULA checkbox visible");
			EULACheckbox.click();
			Log.addMessage("EULA checkbox clicked");
		}
		catch(Exception e) {
			Log.addMessage("Unable to click EULA checkbox");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click EULA checkbox");
		}
	}
	

	/**
	 * Method Name: clickCaptchaCheckBox() Description: This function will be called
	 * to click Captcha Check Box
	 * @throws InterruptedException 
	 */
	
	public void clickCaptchaCheckBox() throws InterruptedException {
		try {
			Utility.simpleWait(8000);
			driver.switchTo().frame(0);
			Utility.waitForElementToBeVisible(captcha);
			Utility.waitForElementToBeClickable(captcha);
			Assert.assertTrue(captcha.isDisplayed(), "Captcha visible");
			captcha.click();
			Log.addMessage("REcaptcha checkbox clicked");
			}catch(Exception e) {
			Log.addMessage("Unable to click REcaptcha checkbox");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click REcaptcha checkbox");
		}
	}
	
	/**
	 * Method Name: clickTermsLink() Description: This function will be called
	 * to click Terms link 
	 * @throws InterruptedException 
	 */
	
	public void clickTermsLink() throws InterruptedException {
		try {
			Utility.simpleWait(8000);
			driver.switchTo().frame(0);
			Utility.waitForElementToBeVisible(terms);
			Utility.waitForElementToBeClickable(terms);
			Assert.assertTrue(terms.isDisplayed(), "Terms hyperlink is visible");
			terms.click();
			Log.addMessage("Terms hyperlink clicked");
			}catch(Exception e) {
			Log.addMessage("Unable to click Terms hyperlink");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click Terms hyperlink");
		}
	}
	
	/**
	 * Method Name: clickPrivacyLink() Description: This function will be called
	 * to click Privacy link 
	 * @throws InterruptedException 
	 */
	
	public void clickPrivacyLink() throws InterruptedException {
		try {
			Utility.simpleWait(8000);
			//driver.switchTo().frame(0);
			Utility.waitForElementToBeVisible(privacy);
			Utility.waitForElementToBeClickable(privacy);
			Assert.assertTrue(privacy.isDisplayed(), "Privacy hyperlink is visible");
			privacy.click();
			Log.addMessage("Privacy hyperlink clicked");
			}catch(Exception e) {
			Log.addMessage("Unable to click Privacy hyperlink");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click Privacy hyperlink");
		}
	}
	
	/**
	 * Method Name: clickTermsConditionLink() Description: This function will be called
	 * to click Privacy link 
	 * @throws InterruptedException 
	 */
	
	public void clickTermsConditionLink() throws InterruptedException {
		try {
			Utility.simpleWait(8000);
			Utility.waitForElementToBeVisible(termsCondition);
			Utility.waitForElementToBeClickable(termsCondition);
			Assert.assertTrue(termsCondition.isDisplayed(), "Terms and Conditions hyperlink is visible");
			termsCondition.click();
			Log.addMessage("Terms and Conditions hyperlink clicked");
			}catch(Exception e) {
			Log.addMessage("Unable to click Terms and Conditions hyperlink");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click Terms and Conditions hyperlink");
		}
	}
	
	/**
	 * Method Name: clickEULALink() Description: This function will be called
	 * to click EULA link 
	 * @throws InterruptedException 
	 */
	
	public void clickEULALink() throws InterruptedException {
		try {
			Utility.simpleWait(8000);
			Utility.waitForElementToBeVisible(eula);
			Utility.waitForElementToBeClickable(eula);
			Assert.assertTrue(eula.isDisplayed(), "EULA hyperlink is visible");
			eula.click();
			Log.addMessage("EULA hyperlink clicked");
			}catch(Exception e) {
			Log.addMessage("Unable to click EULA hyperlink");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click EULA hyperlink");
		}
	}

	/**
	 * Method Name: clickNextButton() Description: This function will be called
	 * to click Next button
	 */
	
	public void clickNextButton() {
		try {
			Utility.waitForElementToBeVisible(nextButton);
			Utility.waitForElementToBeClickable(nextButton);
			Assert.assertTrue(nextButton.isDisplayed(), "Next button visible");
			nextButton.click();
			Log.addMessage("Next Button clicked");
		}
		catch(Exception e) {
			Log.addMessage("Unable to click Next Button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click Next Button");
		}
	}
	
	/**
	 * Method Name: checkNextButton() Description: This function will be called
	 * to check if Next button is enabled
	 */
	
	public void checkNextButton() {
		try {
			Utility.waitForElementToBeVisible(nextButton);
			Utility.waitForElementToBeClickable(nextButton);
			nextButton.click();
			Assert.assertTrue(false, "Failed to disable next button for invalid selection");
			Log.addMessage("Next Button clicked");
		}
		catch(Exception e) {
			Log.addMessage("Next Button is disabled for invalid selection");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(true, "Next Button is disabled for invalid selection");
		}
	}
	
	/**
	 * Method Name: clickSupportLink() Description: This function will be called
	 * to click Support link 
	 * @throws InterruptedException 
	 */
	
	public void clickSupportLink() throws InterruptedException {
		try {
			Utility.simpleWait(8000);
			//driver.switchTo().frame(0);
			Utility.waitForElementToBeVisible(supportCntr);
			Utility.waitForElementToBeClickable(supportCntr);
			Assert.assertTrue(supportCntr.isDisplayed(), "Support Centre hyperlink is visible");
			supportCntr.click();
			Log.addMessage("Support Centre hyperlink clicked");
			}catch(Exception e) {
			Log.addMessage("Unable to click Support Centre hyperlink");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click Support Centre hyperlink");
		}
	}
	
	/**
	 * Method Name: verifyKwiksetLogoInSupport() Description: This function will be called
	 * to click Support link 
	 * @throws InterruptedException 
	 */
	
	public void verifyKwiksetLogoInSupport() throws InterruptedException {
		try {
			Utility.simpleWait(8000);
			//driver.switchTo().frame(0);
			Utility.waitForElementToBeVisible(kwikBrand);
			Utility.waitForElementToBeClickable(kwikBrand);
			Assert.assertTrue(kwikBrand.isDisplayed(), "Kwikset logo displayed in Support Center page");
			//kwikBrand.click();
			Log.addMessage("Kwikset logo displayed in Support Center page");
			}catch(Exception e) {
			Log.addMessage("Unable to display Kwikset logo in Support Center page");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to display Kwikset logo in Support Center page");
		}
	}
	
	/**
	 * Method Name: clickProductLink() Description: This function will be called
	 * to click Products link 
	 * @throws InterruptedException 
	 */
	
	public void clickProductLink() throws InterruptedException {
		try {
			Utility.simpleWait(8000);
			//driver.switchTo().frame(0);
			Utility.waitForElementToBeVisible(product);
			Utility.waitForElementToBeClickable(product);
			Assert.assertTrue(product.isDisplayed(), "Products hyperlink is visible");
			product.click();
			Log.addMessage("Products hyperlink clicked");
			}catch(Exception e) {
			Log.addMessage("Unable to click Products hyperlink");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click Products hyperlink");
		}
	}
	
	/**
	 * Method Name: clickAppLink() Description: This function will be called
	 * to click Apps link 
	 * @throws InterruptedException 
	 */
	
	public void clickAppLink() throws InterruptedException {
		try {
			Utility.simpleWait(8000);
			//driver.switchTo().frame(0);
			Utility.waitForElementToBeVisible(apps);
			Utility.waitForElementToBeClickable(apps);
			Assert.assertTrue(apps.isDisplayed(), "Apps hyperlink is visible");
			apps.click();
			Log.addMessage("Apps hyperlink clicked");
			}catch(Exception e) {
			Log.addMessage("Unable to click Apps hyperlink");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click Apps hyperlink");
		}
	}
	
	/**
	 * Method Name: clickWebAccessibilityLink() Description: This function will be called
	 * to click web accessibility link 
	 * @throws InterruptedException 
	 */
	
	public void clickWebAccessibilityLink() throws InterruptedException {
		try {
			Utility.simpleWait(8000);
			//driver.switchTo().frame(0);
			Utility.waitForElementToBeVisible(webAcs);
			Utility.waitForElementToBeClickable(webAcs);
			Assert.assertTrue(webAcs.isDisplayed(), "Web accessibility hyperlink is visible");
			webAcs.click();
			Log.addMessage("Web accessibility hyperlink clicked");
			}catch(Exception e) {
			Log.addMessage("Unable to click Web accessibility hyperlink");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click Web accessibility hyperlink");
		}
	}
	
	/**
	 * Method Name: closeWebAccessibility() Description: This function will be called
	 * to click close button 
	 * @throws InterruptedException 
	 */
	
	public void closeWebAccessibility() throws InterruptedException {
		try {
			Utility.simpleWait(8000);
			//driver.switchTo().frame(0);
			Utility.waitForElementToBeVisible(btnClose);
			Utility.waitForElementToBeClickable(btnClose);
			Assert.assertTrue(btnClose.isDisplayed(), "Close button is visible");
			btnClose.click();
			Log.addMessage("Close button clicked");
			}catch(Exception e) {
			Log.addMessage("Unable to click close button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click close button");
		}
	}
	
	/**
	 * Method Name: clickVersionInfoLink() Description: This function will be called
	 * to click Version Info link 
	 * @throws InterruptedException 
	 */
	
	public void clickVersionInfoLink() throws InterruptedException {
		try {
			Utility.simpleWait(8000);
			//driver.switchTo().frame(0);
			Utility.waitForElementToBeVisible(verInfo);
			Utility.waitForElementToBeClickable(verInfo);
			Assert.assertTrue(verInfo.isDisplayed(), "Version Info hyperlink is visible");
			verInfo.click();
			Log.addMessage("Version Info hyperlink clicked");
			}catch(Exception e) {
			Log.addMessage("Unable to click Version Info hyperlink");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click Version Info hyperlink");
		}
	}
	
	/**
	 * Method Name: invalidFirstNameCheck() Description: This function will be called
	 * to check firstName with invalid entry
	 */
	

	public void invalidFirstNameCheck(String validationMsg) {
		try {	
			Utility.simpleWait(6000);
			Utility.waitForElementToBeVisible(firstNameValidationMessage);
			System.out.println("Validation message is: "+firstNameValidationMessage.getText());
			Assert.assertTrue(firstNameValidationMessage.isDisplayed(), "Validation message displayed for user not exists");
			Assert.assertEquals(firstNameValidationMessage.getText(), validationMsg, "Incorrect validation");
			Log.addMessage("User not exists");
		}catch(Exception e) {
			Log.addMessage("Failed to display validation message for user");
			System.out.println(e.getMessage().toString());
			Assert.assertFalse(true, "Failed to display validation message for user");
		}
	}
	
	/**
	 * Method Name: invalidLastNameCheck() Description: This function will be called
	 * to check lastName with invalid entry
	 */
	

	public void invalidLastNameCheck(String validationMsg) {
		try {	
			Utility.simpleWait(6000);
			Utility.waitForElementToBeVisible(lastNameValidationMessage);
			System.out.println("Validation message is: "+lastNameValidationMessage.getText());
			Assert.assertTrue(lastNameValidationMessage.isDisplayed(), "Validation message displayed for user not exists");
			Assert.assertEquals(lastNameValidationMessage.getText(), validationMsg, "Incorrect last name validation");
			Log.addMessage("User not exists");
		}catch(Exception e) {
			Log.addMessage("Failed to display validation message for user");
			System.out.println(e.getMessage().toString());
			Assert.assertFalse(true, "Failed to display validation message for user");
		}
	}
}
