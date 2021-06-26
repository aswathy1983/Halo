package pages.app;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import utility.Log;
import utility.Utility;

public class LimitByDatePage extends Settings{
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/cancelAllhomes"),
		@AndroidBy(id = "com.kwikset.blewifi:id/cancelAllhomes"),
		@AndroidBy(id = "com.spectrum.giga:id/cancelAllhomes"),
		@AndroidBy(id = "com.weiser.blewifi:id/cancelAllhomes"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/cancelAllhomes")
	})
	@CacheLookup
	private MobileElement backButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Submit']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_submit"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_submit"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_submit"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_submit"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/tv_submit")
	})
	@CacheLookup
	private MobileElement submitButton;
		
	@iOSXCUITFindBy(id = "Start Date")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/textViewStartDate"),
		@AndroidBy(id = "com.kwikset.blewifi:id/textViewStartDate"),
		@AndroidBy(id = "com.spectrum.giga:id/textViewStartDate"),
		@AndroidBy(id = "com.weiser.blewifi:id/textViewStartDate"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/textViewStartDate")
	})
	@CacheLookup		
	private MobileElement startDate;
	
	@AndroidFindBy(id = "android:id/prev")
	@CacheLookup		
	private MobileElement prevMonth;
	
	@AndroidFindBy(id = "android:id/next")
	@CacheLookup		
	private MobileElement nextMonth;
	
	
	//@AndroidFindBy(xpath = "//com.kwikset.blewifi.dev:id/buttonLayout1//android.widget.Button)[2]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/buttonOk"),
		@AndroidBy(id = "com.kwikset.blewifi:id/buttonOk"),
		@AndroidBy(id = "com.spectrum.giga:id/buttonOk"),
		@AndroidBy(id = "com.weiser.blewifi:id/buttonOk"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/buttonOk")
	})
	@CacheLookup		
	private MobileElement dateOk;
	
	@iOSXCUITFindBy(id = "End Date")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/textViewEndDate"),
		@AndroidBy(id = "com.kwikset.blewifi:id/textViewEndDate"),
		@AndroidBy(id = "com.spectrum.giga:id/textViewEndDate"),
		@AndroidBy(id = "com.weiser.blewifi:id/textViewEndDate"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/textViewEndDate")
	})
	@CacheLookup
	private MobileElement endDate;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Ok']")
	@AndroidFindBy(id = "android:id/button1")
	@CacheLookup
	private MobileElement oKButton;
	
	By datePicker = MobileBy.xpath("//XCUIElementTypePickerWheel");
	
	WebDriverWait wait = new WebDriverWait(driver,10);


	//Constructor
	@SuppressWarnings("static-access")
	public LimitByDatePage(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
		
		
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void selectStartDate(String month, String day, String year) {
		try {
			Utility.waitForElementToBeVisible(startDate);
			Utility.waitForElementToBeClickable(startDate);
			startDate.click();
			List<WebElement> pickerEls = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(datePicker));
			pickerEls.get(0).sendKeys(month);
			pickerEls.get(1).sendKeys(day);
			pickerEls.get(2).sendKeys(year);
			Log.addMessage("Start date is set as: "+month+" "+day+", "+year);
		}catch(Exception e) {
			Log.addMessage("Failed to set start date");
			Assert.assertTrue(false, "Failed to set start date");
		}
	}
	
	
	public void selectEndDate(String month, String day, String year) {
	  try {
		   Utility.waitForElementToBeVisible(endDate);
		   Utility.waitForElementToBeClickable(endDate);
		   endDate.click();
		   List<WebElement> pickerEls = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(datePicker));
		   pickerEls.get(0).sendKeys(month);
		   pickerEls.get(1).sendKeys(day);
		   pickerEls.get(2).sendKeys(year);
		  Log.addMessage("Start date is set as: "+month+" "+day+", "+year);
	  }catch(Exception e) {
			Log.addMessage("Failed to set end date");
			Assert.assertTrue(false, "Failed to set end date");
	  }
	}
	
	public void setCurrStartDate() {
		try {
			Utility.waitForElementToBeVisible(startDate);
			startDate.click();
			Utility.waitForElementToBeVisible(dateOk);
			dateOk.click();
			Log.addMessage("Start date is set to current date");
		}catch(Exception e) {
			Log.addMessage("Failed to set start date");
			Assert.assertTrue(false, "Failed to set start date");
		}
	}
	
	public void setCurrEndDate() {
		try {
			Utility.waitForElementToBeVisible(endDate);
			Utility.waitForElementToBeClickable(endDate);
			endDate.click();
			By nxtMon = By.xpath("//android.widget.ImageButton[@content-desc='Next month']");
			Utility.waitForElementPresent(nxtMon, appiumDriver);
			driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Next month']")).click();
			driver.findElement(By.xpath("//android.view.View[@text='1']")).click();
			Utility.waitForElementToBeVisible(dateOk);
			dateOk.click();
			Log.addMessage("End date is set");
		}catch(Exception e) {
			Log.addMessage("Failed to set end date");
			Assert.assertTrue(false, "Failed to set end date");
		}
	}
	
	
	public void clickSubmitButton() {
		  try {
			  Utility.waitForElementToBeVisible(submitButton);
			  Utility.waitForElementToBeClickable(submitButton);
			  submitButton.click();
			  Log.addMessage("Clicked Submit Button");
		  }catch(Exception e) {
				Log.addMessage("Failed to click Submit button");
				Assert.assertTrue(false, "Failed to click Submit button");
		  }
	}
	
	public void clickOkButton() {
		  try {
			  Utility.waitForElementToBeVisible(oKButton);
			  Utility.waitForElementToBeClickable(oKButton);
			  oKButton.click();
			  Log.addMessage("Clicked Ok Button");
		  }catch(Exception e) {
				Log.addMessage("Failed to click Ok button");
				Assert.assertTrue(false, "Failed to click Ok button");
		  }
	}
	
	
}
