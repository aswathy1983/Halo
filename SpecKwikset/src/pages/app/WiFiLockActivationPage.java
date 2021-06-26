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

public class WiFiLockActivationPage extends Settings{
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Ok']")
	@CacheLookup
	private MobileElement OkButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText")//added on 19-05-2020
	@AndroidFindBy(xpath="//android.widget.TextView")
	@CacheLookup
	private List<MobileElement> chkList;
	
	@iOSXCUITFindBy(id="Connecting to your LAN")
	@CacheLookup
	private MobileElement chkLstAct1;
	
	@iOSXCUITFindBy(id="Connecting to the Cloud")
	@CacheLookup
	private MobileElement chkLstAct2;
	
	@iOSXCUITFindBy(id="Attaching Lock to your Home")
	@CacheLookup
	private MobileElement chkLstAct3;
	
	@iOSXCUITFindBy(id="Lock activated to your Account")
	@CacheLookup
	private MobileElement chkLstAct4;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeImage")
	@AndroidFindBy(xpath="//android.widget.ImageView")
	@CacheLookup
	private List<MobileElement> imgList;
	
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/img1")
	@CacheLookup
	private MobileElement  tick1;
	
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/img2")
	@CacheLookup
	private MobileElement  tick2;
	
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/img3")
	@CacheLookup
	private MobileElement  tick3;
	
	@AndroidFindBy(id="com.kwikset.blewifi.dev:id/img4")
	@CacheLookup
	private MobileElement  tick4;
	
	//Constructor
	@SuppressWarnings("static-access")
	public WiFiLockActivationPage(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void clickOKButton() {
		try {
			Thread.sleep(12000);
			OkButton.click();
			Log.addMessage("Clicked OK button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Ok button");
			Assert.assertTrue(false, "Failed to click Ok button");
		}
	}
	
	
	
	/** 
	* Method Name: verifyCheckListImg(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void verifyCheckListImg() {
		try {
			Thread.sleep(10000);
			System.out.println("tick size="+imgList.size());
			//if(tick1.isEnabled()) {
			Assert.assertEquals(imgList.get(2).isDisplayed(), true,"Tick1 not displayed");
			if(imgList.get(2).isDisplayed()) {
				System.out.println("tick1");
				Log.addMessage("Tick1 displayed");
			}
			Assert.assertEquals(imgList.get(3).isDisplayed(), true,"Tick2 not displayed");
			if(imgList.get(3).isDisplayed()) {
				System.out.println("tick2");
				Log.addMessage("Tick2 displayed");
			}
			
			Thread.sleep(10000);
			Assert.assertEquals(imgList.get(4).isDisplayed(), true,"Tick3 not displayed");
			if(imgList.get(4).isDisplayed()) {
				System.out.println("tick3");
				Log.addMessage("Tick3 displayed");
			}
			
			Thread.sleep(40000);
			Utility.waitForElementToBeVisible(imgList.get(5));
			Assert.assertEquals(imgList.get(5).isDisplayed(), true,"Tick4 not displayed");
			if(imgList.get(5).isDisplayed()) {
			//if(tick4.isEnabled()) {
				System.out.println("tick4");
				Log.addMessage("Tick4 displayed");
			}
			
		}catch(Exception e) {
			Log.addMessage("Failed to display all the tick marks");
			Assert.assertTrue(false, "Failed to display all the tick marks");
		}
	}

	
	/** 
	* Method Name: verifyCheckList(), 
	* This function is used to select Email option from the MFA Page
	*/
			
	public void verifyCheckList(String chkList1, String chkList2, String chkList3, String chkList4) {
		try {
			Thread.sleep(20000);
			System.out.println("chkList. size="+chkList.size());
			System.out.println("inone="+chkList.get(2).getText());
			Assert.assertEquals(chkList.get(2).getText(), chkList1,"Checklist1 displayed");
			Log.addMessage("Checklist1 displayed");
			Thread.sleep(5000);
			System.out.println("intwo="+chkList.get(3).getText());
			Assert.assertEquals(chkList.get(3).getText(), chkList2,"Checklist2 displayed");
			Log.addMessage("Checklist2 displayed");
			
			System.out.println("inthree="+chkList.get(4).getText());
			Assert.assertEquals(chkList.get(4).getText(), chkList3,"Checklist3 displayed");
			Log.addMessage("Checklist3 displayed");
			
			System.out.println("infour="+chkList.get(5).getText());
			Assert.assertEquals(chkList.get(5).getText(), chkList4,"Checklist4 displayed");
			Log.addMessage("Checklist4 displayed");
			
			Log.addMessage("All 4 Checklist displayed");
		}catch(Exception e) {
			Log.addMessage("Failed to display all checklist");
			Assert.assertTrue(false, "Failed to display all checklist");
		}
	}

	/** 
	* Method Name: verifyiOSCheckList(), 
	* This function is used to select Email option from the MFA Page
	*/
			
	public void verifyiOSCheckList(String chkList1, String chkList2, String chkList3, String chkList4) {
		try {
			Thread.sleep(20000);
			System.out.println("chkList. size="+chkList.size());
			System.out.println("inone="+chkList.get(2).getText());
			System.out.println("chkLstAct1="+chkLstAct1.getAttribute("name"));
			System.out.println("chkLstAct1="+chkLstAct2.getAttribute("name"));
			System.out.println("chkLstAct1="+chkLstAct3.getAttribute("name"));
			System.out.println("chkLstAct1="+chkLstAct4.getAttribute("name"));
			Assert.assertEquals(chkLstAct1.getAttribute("name"), chkList1,"Checklist1 displayed");
			Log.addMessage("Checklist1 displayed");
			Thread.sleep(5000);
			System.out.println("intwo="+chkList.get(3).getText());
			Assert.assertEquals(chkLstAct2.getAttribute("name"), chkList2,"Checklist2 displayed");
			Log.addMessage("Checklist2 displayed");
			
			System.out.println("inthree="+chkList.get(4).getText());
			Assert.assertEquals(chkLstAct3.getAttribute("name"), chkList3,"Checklist3 displayed");
			Log.addMessage("Checklist3 displayed");
			
			System.out.println("infour="+chkList.get(5).getText());
			Assert.assertEquals(chkLstAct4.getAttribute("name"), chkList4,"Checklist4 displayed");
			Log.addMessage("Checklist4 displayed");
			
			Log.addMessage("All 4 Checklist displayed");
		}catch(Exception e) {
			Log.addMessage("Failed to display all checklist");
			Assert.assertTrue(false, "Failed to display all checklist");
		}
	}


}
