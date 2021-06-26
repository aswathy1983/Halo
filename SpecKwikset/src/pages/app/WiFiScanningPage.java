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


public class WiFiScanningPage extends Settings{
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]")
	@AndroidFindBy(xpath="//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]")//added on 07-05-2020
	@CacheLookup
	private MobileElement firstHotspot;
	
	/* added on 07-05-2020 */
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell//XCUIElementTypeStaticText")//added on 18-05-2020
	@AndroidFindBy(xpath="//android.support.v7.widget.RecyclerView/android.widget.LinearLayout")
	@CacheLookup
	private List<MobileElement> lstHotSpot;
	
	//@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Cancel\"]")
	@iOSXCUITFindBy(id = "Cancel")//added on 18-05-2020
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/cancel")
	@CacheLookup
	private MobileElement cancelButton;
	
	@iOSXCUITFindBy(id = "Rescan")//added on 18-05-2020
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/tv_scan_again")
	@CacheLookup
	private MobileElement reScanButton;
	
	@iOSXCUITFindBy(id = "Manual Setup")//added on 18-05-2020
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/tvAdvanced")
	@CacheLookup
	private MobileElement manualSetupButton;
	
	
	//Constructor
	@SuppressWarnings("static-access")
	public WiFiScanningPage(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void selectFirstHotSpot() {
		try {
			Thread.sleep(10000);
			System.out.println("in  hotspot");
			firstHotspot.click();
			System.out.println("after click  hotspot");
			Log.addMessage("Selected first hotspot");
		}catch(Exception e) {
			Log.addMessage("Failed to select First Hotspot");
			Assert.assertTrue(false, "Failed to select First Hotspot");
		}
	}

	/* added from 07-05-2020 */
	
	/** 
	* Method Name: clickBackButton(), 
	* This function is used to click Back button from Add lock name page
	*/
		
	public void clickCancelButton() {
		try {
			Thread.sleep(6000);
			cancelButton.click();
			Log.addMessage("Clicked Cancel Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Cancel button");
			Assert.assertTrue(false, "Failed to click Cancel button");
		}
	}
	
	/** 
	* Method Name: clickBackButton(), 
	* This function is used to click re-scan button in Wifi Scanning page
	*/
		
	public void clickReScanButton() {
		try {
			//Thread.sleep(6000);//commented on 19-05-2020
			Utility.waitForElementToBeVisible(reScanButton);//added on 19-05-2020
			reScanButton.click();
			Log.addMessage("Clicked re-scan Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click re-scan button");
			Assert.assertTrue(false, "Failed to click re-scan button");
		}
	}
	
	/** 
	* Method Name: scrollHotSpot(), 
	* This function is used to scroll through Hotspot listed
	*/
		
	public void scrollHotSpot() {
		try {
			Thread.sleep(10000);
			//firstHotspot.click();
			Log.addMessage("Selected First Hotspot");
		}catch(Exception e) {
			Log.addMessage("Failed to select First Hotspot");
			Assert.assertTrue(false, "Failed to select First Hotspot");
		}
	}

	
	/** 
	* Method Name: clickManualSetupButton(), 
	* This function is used to click Manual Setup button from Wifi Scanning page
	*/
		
	public void clickManualSetupButton() {
		try {
			//Thread.sleep(6000);
			Utility.waitForElementToBeVisible(manualSetupButton);//added on 19-05-2020
			manualSetupButton.click();
			Log.addMessage("Clicked manual setup Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click manual setup button");
			Assert.assertTrue(false, "Failed to click manual setup button");
		}
	}
	
	//added on 19-05-2020
	/** 
	* Method Name: clickManualSetupiOSButton(), 
	* This function is used to click Manual Setup button from Wifi Scanning page
	*/
		
	public void clickManualSetupiOSButton() {
		try {
			//Thread.sleep(6000);
			int cntList = lstHotSpot.size();
			System.out.println("in hotspotlist="+cntList);
			Utility.waitForElementToBeVisible(lstHotSpot.get(cntList-1));//added on 19-05-2020
			System.out.println("manual hotspotlist="+lstHotSpot.get(cntList-1));
			lstHotSpot.get(cntList-1).click();
			Log.addMessage("Clicked manual setup Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click manual setup button");
			Assert.assertTrue(false, "Failed to click manual setup button");
		}
	}
	
	/** 
	* Method Name: listAllHotSpot(), 
	* This function is used to select all the listed hotspots 
	*/
		
	public void listAllHotSpot() {
		try {
			Thread.sleep(5000);
			System.out.println("in  hotspot="+lstHotSpot.size());
			
			if(lstHotSpot.size()>0) {
				for(int i=0; i<lstHotSpot.size()-1;i++){//updated -1 on 20-05-2020
					System.out.println("lstHotSpot"+i+"="+lstHotSpot.get(i).getText());
					Log.addMessage("The hotspots listed are :"+lstHotSpot.get(i).getText());
				}
			}else {
				System.out.println("HotSpots not listed");
				Log.addMessage("No hotspots listed");
			}
			Log.addMessage("Listed hotspots");
		}catch(Exception e) {
			Log.addMessage("Failed to list Hotspot");
			Assert.assertTrue(false, "Failed to list  Hotspot");
		}
	}
	
	/* added on 07-05-2020 */

}
