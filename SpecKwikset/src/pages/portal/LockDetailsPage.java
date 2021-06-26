package pages.portal;

import java.util.List;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Settings;
import utility.Log;
import utility.Utility;

public class LockDetailsPage extends Settings {
	
	@FindBy(xpath="(//h5[contains(@class,'lock-detail-key')])")
	List<WebElement> lockKeyButton;
	
	@FindBy(xpath="(//h5[contains(@class,'lock-detail-value')])")
	List<WebElement> lockValueButton;
	
	@SuppressWarnings("static-access")
	public LockDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	public void viewLockDetailsButton(String key1, String val1) throws InterruptedException {
		try {
			Utility.waitForElementToBeClickable(lockKeyButton.get(0));
			for(int i = 0;i<lockKeyButton.size();i++) {
				if((lockKeyButton.get(i).getText()).equals(key1)) {
					if((lockValueButton.get(i).getText()).equals(val1)) {
						Assert.assertTrue(true, "Lock detail matches");
					}
				}
			}
			Log.addMessage("Lock detail matches");
		}catch(Exception e) {
			Log.addMessage("Failed to view lock details");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to view lock details");
		}
	}
	

}
