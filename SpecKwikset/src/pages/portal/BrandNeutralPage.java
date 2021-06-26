package pages.portal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Settings;
import utility.Log;
import utility.Utility;


public class BrandNeutralPage extends Settings{
		
	@FindBy(xpath="//a[@id='kwikset']")
	WebElement KwiksetBrand;
	
	@FindBy(xpath="//a[@id='weiser']")
	WebElement WeiserBrand;
	
	@SuppressWarnings("static-access")
	public BrandNeutralPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	/**
	 * Method Name: chooseBrand() Description: This function will be called
	 * to choose Brand of the lock
	 */
	
	public void chooseBrand(String brandname) {
		try {
			Utility.simpleWait(3000);
			if(brandname.equalsIgnoreCase("Kwikset")) {
				System.out.println("in kwik");
				Utility.waitForElementToBeVisible(KwiksetBrand);
				Utility.waitForElementToBeClickable(KwiksetBrand);
				KwiksetBrand.click();
				Log.addMessage("Kwikset Brand is selected");
			}else if (brandname.equalsIgnoreCase("Weiser")) {
				System.out.println("in weiser");
				Utility.waitForElementToBeVisible(WeiserBrand);
				Utility.waitForElementToBeClickable(WeiserBrand);
				WeiserBrand.click();
				Log.addMessage("Weiser Brand is selected");
			}else {
				Log.addMessage(brandname+" brand is not available");
			}
			Utility.simpleWait(3000);
		}catch(Exception e) {
			Log.addMessage("Failed to select brand");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to select brand");
		}
	}


}
