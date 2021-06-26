package pages.app;

import static java.time.Duration.ofSeconds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import utility.Log;
import utility.Utility;

public class LockEventHistoryPage extends Settings{
	
     //commented on 10-06-2020 for fp iOS
	//@iOSXCUITFindBy(id = "Clear History")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Clear History']")
	@AndroidFindBy(xpath= "//android.widget.Button[@text='Clear History']")
	@CacheLookup
	private MobileElement clearHistoryButton;
	
	@iOSXCUITFindBy(id = "Clear History")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='No history to display']")
	@CacheLookup
	private MobileElement noEventsToDisplayText;

	@iOSXCUITFindBy(id = "Clear History")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='No history to display']")
	@CacheLookup
	private MobileElement YesButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Lock History']")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Lock History']")
	@CacheLookup
	private MobileElement historyText;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeCell[1]")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Lock History']")
	@CacheLookup
	private MobileElement historylistCell;
	
	/* added on 05-05-2020 */
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/eventTitle"),
		@AndroidBy(id = "com.kwikset.blewifi:id/eventTitle"),
		@AndroidBy(id = "com.spectrum.giga:id/eventTitle"),
		@AndroidBy(id = "com.weiser.blewifi:id/eventTitle")
	})
	@CacheLookup
	private List<MobileElement> lockTitle;
	 
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/event_sub_title"),
		@AndroidBy(id = "com.kwikset.blewifi:id/event_sub_title"),
		@AndroidBy(id = "com.spectrum.giga:id/event_sub_title"),
		@AndroidBy(id = "com.weiser.blewifi:id/event_sub_title")
	})
	@CacheLookup
	private List<MobileElement> lockSubTitle;
	
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/eventTime"),
		@AndroidBy(id = "com.kwikset.blewifi:id/eventTime"),
		@AndroidBy(id = "com.spectrum.giga:id/eventTime"),
		@AndroidBy(id = "com.weiser.blewifi:id/eventTime")
	})
	@CacheLookup
	private List<MobileElement> lockTime;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/cancelAllhomes"),
		@AndroidBy(id = "com.kwikset.blewifi:id/cancelAllhomes"),
		@AndroidBy(id = "com.spectrum.giga:id/cancelAllhomes"),
		@AndroidBy(id = "com.weiser.blewifi:id/cancelAllhomes"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/cancelAllhomes")
	})
	@CacheLookup
	private MobileElement navBack;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeCell")
	@AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView//android.widget.RelativeLayout")
	@CacheLookup
	private List<MobileElement> lstHist;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeCell[1]//XCUIElementTypeStaticText[1]")
	@AndroidFindBy(xpath="//android.widget.Toast[1]")
	@CacheLookup
	private MobileElement firstEvent;
	
	//added on 10-06-2020
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name='SPLockActivityVC']")
	@AndroidFindBy(xpath = "(//android.widget.ImageView)[2]")
	@CacheLookup
	private MobileElement brandLogo;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[1]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/home_name"),
		@AndroidBy(id = "com.kwikset.blewifi:id/home_name"),
		@AndroidBy(id = "com.spectrum.giga:id/home_name"),
		@AndroidBy(id = "com.weiser.blewifi:id/home_name")
	})
	@CacheLookup
	private MobileElement homeName;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Lock History']/following-sibling::XCUIElementTypeStaticText[1]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_title"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_title"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_title"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_title"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/tv_title")
	})
	@CacheLookup
	private MobileElement lockName;
	
	@AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView//android.widget.RelativeLayout")
	@CacheLookup		
	private List<MobileElement> histEventList;
	
	@iOSXCUITFindBy(id = "Cancel")
	@AndroidFindBy(id = "android:id/button2")
	@CacheLookup
	private MobileElement cancelButton;
	
	@iOSXCUITFindBy(id = "Yes")
	@AndroidFindBy(id = "android:id/button1")
	@CacheLookup
	private MobileElement OkButton;
	
	By histCell = By.xpath("//XCUIElementTypeTable//XCUIElementTypeCell[1]");
	By histCellAn = By.xpath("//android.widget.TextView[contains(@text,'App:')]");
	By okBtn= By.xpath("//XCUIElementTypeButton[@name='Ok']");
	By yesBtn= By.xpath("//XCUIElementTypeButton[@name='Yes']");
	By okAnBtn= By.id("android:id/button1");
	By okBtnFp= By.xpath("//XCUIElementTypeButton[@name='Yes']");
	By okAnBtnFp= By.id("android:id/button1");
	
	boolean okButtonPresent, strExist = false;
	String lName, lSubName , lTime, eventMainName, eventSubName, eventName, eventTime, clearMsg = "";
	String lsttext ="Device Activation";
	int j, m, rmnglistcnt, subnamecount, timecount, ttlCnt, p, eventSubNameCnt, eventTimeCount, listedSize, eventMainNameCnt, timecnt = 0;
	
	/* added on 05-05-2020 */
		
	//Constructor
	
	@SuppressWarnings("static-access")
	
	public LockEventHistoryPage(AppiumDriver<MobileElement> driver) {
	this.appiumDriver = driver;
	PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
		
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
			
	public void clearHistory() {
		try {
			//Thread.sleep(6000);//commented on 06-10-2020
			Utility.waitForElementToBeVisible(clearHistoryButton);
			Utility.waitForElementToBeClickable(clearHistoryButton);
			//System.out.println("after finding the button");
			clearHistoryButton.click();
			if(device.equals("iOS")) {//added on 16-06-2020
				if (noEventsToDisplayText.isDisplayed())
				Log.addMessage("Lock event history is cleared");
			}else {
				Log.addMessage("Lock event history is cleared");
			}
		}catch(Exception e) {
			Log.addMessage("Failed to clear Lock history");
			Assert.assertTrue(false, "Failed to clear Lock history");
		}
	}
	
	@SuppressWarnings("unchecked")
	public void displayAllEvents() {
		try {
			List<MobileElement> totalEvents = (List<MobileElement>)driver.findElement(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell"));
			for(int i =1; i<=totalEvents.size(); i++) {
				Log.addMessage(driver.findElement(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell["+i+"]")).getText());
			}
			
		}catch(Exception e) {
			Log.addMessage("Failed to display all events from Lock history");
			Assert.assertTrue(false, "Failed to display all events from Lock history");
		}
		
	}
	/* added on 05-05-2020 */
	/** 
	* Method Name: getLockHistoryList(), 
	* This function is used to get Access Codes attached to the account
	*/
		
	public void getLockHistoryList(String lkName, String lkSubName, String lkTime,int cdcnt,int subcnt, int tcnt) {
		try {
	    	//Utility.simpleWait(8000);
			//Utility.waitForTextToBePresent(historyText, "Lock History");
			Utility.waitForElementPresent(histCellAn, appiumDriver);
			//Utility.waitForElementToBePresent(lockTitle.get(0),driver);
	    	System.out.println("after wait");
	    	Utility.waitForElementToBeVisible(lockTitle.get(0));
	    	System.out.println("historylist cdcnt="+cdcnt+", lock history size="+lstHist.size());
	    	if(cdcnt == 0) {
	    		//System.out.println("in zero"+lockTitle.get(0));
	    		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/rv_eventlog\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")); 
	    		/*List<String>strList=new ArrayList<String>();
	    		for(int i=0;i<lockTitle.size();i++) {
	    			if(!lockTitle.get(i).getText().equals("Status Update: Jammed") && !lockTitle.get(i).getText().equals("Status Update: Locked") && !lockTitle.get(i).getText().equals("Status Update: Unlocked")) {
    					timecnt=timecnt+1;
    					strList.add(lockTitle.get(i).getText()+"-"+lockTime.get(timecnt).getText().trim());
	    			}
				}
	    		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/rv_eventlog\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")); 
	    		timecnt = 0;
	    		for(int i=0;i<lockTitle.size();i++) {
	    			for(int ar=0;ar<strList.size();ar++) {
		    			if(lockTitle.get(i).getText().trim().toUpperCase().compareTo(strList.get(ar).toString().toUpperCase())==0)//check condition for case sensitivity
						{
		    				strExist = true;
		    				break;
		    			}
	    			}
	    			if(!strExist) {
	    				if(!lockTitle.get(i).getText().equals("Status Update: Jammed") && !lockTitle.get(i).getText().equals("Status Update: Locked") && !lockTitle.get(i).getText().equals("Status Update: Unlocked")) {
	    					timecnt=timecnt+1;
	    					strList.add(lockTitle.get(i).getText()+"-"+lockTime.get(timecnt).getText().trim());
	    				}
	    			}
	    			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/rv_eventlog\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")); 
	    		
				}*/
	    	}
	    	Utility.waitForElementToBeVisible(lockTitle.get(0));
	    	System.out.println("cdcnt="+cdcnt+", name size="+lockTitle.size());
    		for(int i = cdcnt; i<lockTitle.size(); i++) {
    			System.out.println("in");
	    		lName = lockTitle.get(i).getText().trim();
	    		System.out.println("lNameb4="+lName+",exp lkName="+ lkName);
	    		Assert.assertEquals(lName, lkName.trim(),"Lock status matches");
	    		System.out.println("lName="+lName+",exp lkName="+ lkName);
	    		
	    		if(lkTime!="") {
	    			System.out.println("locktime");
		    		lTime = lockTime.get(tcnt).getText().trim();
		    		System.out.println("lTimeb4="+lTime+",exp lTime="+ lkTime);
		    		Assert.assertEquals(lTime, lkTime.trim(),"Lock Time matches");
		    		System.out.println("lTime="+lTime+",exp lTime="+ lkTime);
	    		}
	    		Log.addMessage("Lock event from history is: "+lName);
	    		if(lkSubName!="") {
	    			System.out.println("j="+j);
	    			System.out.println("lSubNameb4="+lSubName+",exp lSubName="+ lkSubName);
		    		lSubName = lockSubTitle.get(subcnt).getText().trim();
		    		Assert.assertEquals(lSubName, lkSubName.trim(),"Lock Status sub title matches");
		    		System.out.println("lSubName="+lSubName+",exp lSubName="+ lkSubName);
		    		j++;
		    		Log.addMessage("Lock sub event from history is: "+lSubName);
	    		}
    		break;
	    	}
	    	
			Log.addMessage("Lock history listed");
		}catch(Exception e) {
			Log.addMessage("Failed to list lock history");
			Assert.assertTrue(false, "Failed to list lock History");
		}
	}
	
	/* added on 25-05-2020 */
	/** 
	* Method Name: getLockHistoryiOSList(), 
	* This function is used to get Access Codes attached to the account
	*/
		
	
	public void getLockHistoryiOSList(String lkName, String lkTime,int cdcnt,int subcnt, int tcnt) {
		try {
	    	//Utility.simpleWait(6000);//changed below code on 09-11-2020
			//System.out.println("in");
	    	//Utility.waitForTextToBePresent(historyText, "Lock History");
	    	Utility.waitForElementPresent(histCell, appiumDriver);
	    	//System.out.println("after wait"+cdcnt);
	    	if(cdcnt==0) {
	    		//System.out.println("in zero="+lstHist.size());
	    		//check for scroll
	    		if(device.equals("iOS") && lstHist.size()>7) {
	    			//System.out.println("one");
	    			Thread.sleep(2000);
					JavascriptExecutor js = appiumDriver;
					Map<String, Object> params = new HashMap<>();
					params.put("direction", "up");
					params.put("element",  driver.findElement(By.xpath("//XCUIElementTypeTable//XCUIElementTypeCell[7]")));
					js.executeScript("mobile: swipe", params);
					//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/rv_eventlog\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")); 
	    	
	    		}
	    	}
	    	//System.out.println("cdcnt="+cdcnt+", name size="+lstHist.size());
    		for(int i = cdcnt; i<lstHist.size()+1; i++) {
    			//System.out.println("inside");
    			lName="";
    			lTime="";
	    		lName = driver.findElement(By.xpath("//XCUIElementTypeTable//XCUIElementTypeCell["+(i+1)+"]//XCUIElementTypeStaticText[1]")).getText().trim();
	    		//System.out.println("lock name="+lName);
	    		//System.out.println("lName="+lName+",exp lkName="+ lkName);
	    		Assert.assertEquals(lName, lkName,"Lock status matches");
	    		
	    		
	    		if(lkTime!="") {
		    		lTime = driver.findElement(By.xpath("//XCUIElementTypeTable//XCUIElementTypeCell["+(i+1)+"]//XCUIElementTypeStaticText[2]")).getText();
		    		//System.out.println("lock time="+lTime);
		    		//System.out.println("lTime="+lTime+",exp lTime="+ lkTime);
		    		Assert.assertEquals(lTime, lkTime,"Lock Time matches");
	    		}
	    		Log.addMessage("Lock event from history is: "+lName);
	    		break;
	    	}
			Log.addMessage("Lock history listed");
		}catch(Exception e) {
			Log.addMessage("Failed to list lock history");
			Assert.assertTrue(false, "Failed to list lock History");
		}
	}
	
	/* added on 10-11-2020 */
	/** 
	* Method Name: getLockHistoryViewList(), 
	* This function is used to check if new app activity is updated in lock history page
	*/
		
	public void getLockHistoryViewList(String lkName) {
		try {
	    	//Utility.simpleWait(8000);
			Utility.waitForTextToBePresent(historyText, "Lock History");
	    	System.out.println("name size="+lockTitle.size());	
    		if(lockTitle.size()>=1) {
    			lName = lockTitle.get(0).getText();
    			System.out.println("lNameb4="+lName+",exp lkName="+ lkName);
	    		if(lName.equals(lkName)) {
		    		System.out.println("lNameb4="+lName+",exp lkName="+ lkName);
		    		System.out.println("lName="+lName+",exp lkName="+ lkName);
	    		}else if(lockTitle.size()>1) {
	    			System.out.println("in else");
	    			lName = lockTitle.get(1).getText();
	    		}
	    		Assert.assertEquals(lName, lkName,"Lock status matches");
    		}
			Log.addMessage("Lock history listed");
		}catch(Exception e) {
			Log.addMessage("Failed to list lock history");
			Assert.assertTrue(false, "Failed to list lock History");
		}
	}
	
	/* added on 10-11-2020 */
	/** 
	* Method Name: getLockHistoryiOSViewList(), 
	* This function is used to check if new app activity is updated in lock history page
	*/
		
	public void getLockHistoryiOSViewList(String lkName) {
		try {
	    	//Utility.simpleWait(8000);
			Utility.waitForTextToBePresent(historyText, "Lock History");
	    	System.out.println("lstHist size="+lstHist.size());	
    		if(lstHist.size()>=1) {
    			lName = driver.findElement(By.xpath("//XCUIElementTypeTable//XCUIElementTypeCell[1]//XCUIElementTypeStaticText[1]")).getText().trim();
	    		System.out.println("name1="+lkName+", lkName="+lkName);
    			if(lName.equals(lkName)) {
		    		System.out.println("lNameb4="+lName+",exp lkName="+ lkName);
		    		System.out.println("lName="+lName+",exp lkName="+ lkName);
	    		}else if(lstHist.size()>1) {
	    			System.out.println("else lname="+lkName);
	    			lName = driver.findElement(By.xpath("//XCUIElementTypeTable//XCUIElementTypeCell[1]//XCUIElementTypeStaticText[1]")).getText().trim();
	    			System.out.println("else after lname="+lkName);
	    		}
	    		Assert.assertEquals(lName, lkName,"Lock status matches");
    		}
			Log.addMessage("Lock history listed");
		}catch(Exception e) {
			Log.addMessage("Failed to list lock history");
			Assert.assertTrue(false, "Failed to list lock History");
		}
	}
	
	/* added on 10-11-2020 */
	/** 
	* Method Name: getLockHstryiOSViewList(), 
	* This function is used to check if new app activity is updated in lock history page
	*/
		
	public void getLockHstryiOSViewList(String lkName) {
		try {
	    	//Utility.simpleWait(8000);
			Utility.waitForTextToBePresent(historyText, "Lock History");
	    	System.out.println("lstHist size="+lstHist.size());	
    		if(lstHist.size()>=1) {
    			lName = driver.findElement(By.xpath("//XCUIElementTypeTable//XCUIElementTypeCell[1]//XCUIElementTypeStaticText[1]")).getText().trim();
	    		System.out.println("name1="+lkName);
    			if(lName.equals(lkName)) {
		    		System.out.println("lNameb4="+lName+",exp lkName="+ lkName);
		    		System.out.println("lName="+lName+",exp lkName="+ lkName);
	    		}else if(lstHist.size()>1) {
	    			lName = driver.findElement(By.xpath("//XCUIElementTypeTable//XCUIElementTypeCell[2]//XCUIElementTypeStaticText[1]")).getText().trim();
	    		}
	    		Assert.assertEquals(lName, lkName,"Lock status matches");
    		}
			Log.addMessage("Lock history listed");
		}catch(Exception e) {
			Log.addMessage("Failed to list lock history");
			Assert.assertTrue(false, "Failed to list lock History");
		}
	}
	
	//added on 11-06-2020
	public void getFPLockEventHistoryiOSList(String lkName, String lkTime,int cdcnt,int subcnt, int tcnt, int totalCount) {
		try {
	    	Utility.simpleWait(6000);
	    	if(cdcnt==0) {
	    		System.out.println("in zero");
	    		//check for scroll commented on 11-06-2020 for fp iOS
	    		/*if(device.equals("iOS") && lstHist.size()>7) {
	    			
	    			Thread.sleep(2000);
					JavascriptExecutor js = appiumDriver;
					Map<String, Object> params = new HashMap<>();
					params.put("direction", "up");
					params.put("element",  driver.findElement(By.xpath("//XCUIElementTypeTable//XCUIElementTypeCell[7]")));
					js.executeScript("mobile: swipe", params);
	    		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/rv_eventlog\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")); 
	    	
	    		}*/
	    	}
	    	System.out.println("cdcnt="+cdcnt+", name size="+lstHist.size());
    		for(int i = cdcnt; i<lstHist.size()+1; i++) {
    			System.out.println("inside");
	    		lName = driver.findElement(By.xpath("//XCUIElementTypeTable//XCUIElementTypeCell["+(i+1)+"]//XCUIElementTypeStaticText[1]")).getText().trim();
	    		System.out.println("lock name="+lName);
	    		System.out.println("lName="+lName+",exp lkName="+ lkName);
	    		Assert.assertEquals(lName, lkName,"Lock status matches");
	    		
	    		
	    		if(lkTime!="") {
		    		lTime = driver.findElement(By.xpath("//XCUIElementTypeTable//XCUIElementTypeCell["+(i+1)+"]//XCUIElementTypeStaticText[2]")).getText();
		    		System.out.println("lock time="+lTime);
		    		Assert.assertEquals(lTime, lkTime,"Lock Time matches");
		    		System.out.println("lTime="+lTime+",exp lTime="+ lkTime);
	    		}
	    		Log.addMessage("Lock event from history is: "+lName);
    		
    		break;
	    	}
    		System.out.println("inside cdcnt="+cdcnt);
    			
    		if(totalCount>lstHist.size() && cdcnt == lstHist.size()+1) {
    			rmnglistcnt = totalCount - lstHist.size();
    			for(int i = rmnglistcnt; i>0; i--) {
    				System.out.println("inside second loop");
    	    		lName = driver.findElement(By.xpath("//XCUIElementTypeTable//XCUIElementTypeCell["+(i)+"]//XCUIElementTypeStaticText[1]")).getText().trim();
    	    		System.out.println("2nd lock name="+lName);
    	    		System.out.println("2nd lName="+lName+",exp lkName="+ lkName);
    	    		Assert.assertEquals(lName, lkName,"Lock status matches");
    	    		
    	    		if(lkTime!="") {
    		    		lTime = driver.findElement(By.xpath("//XCUIElementTypeTable//XCUIElementTypeCell["+(i)+"]//XCUIElementTypeStaticText[2]")).getText();
    		    		System.out.println("2nd lock time="+lTime);
    		    		Assert.assertEquals(lTime, lkTime,"Lock Time matches");
    		    		System.out.println("2nd lTime="+lTime+",exp lTime="+ lkTime);
    	    		}
    	    		Log.addMessage("Lock event from history is: "+lName);
        		
    	    		break;
    			}
    		}
	    	
			Log.addMessage("Lock history listed");
		}catch(Exception e) {
			Log.addMessage("Failed to list lock history");
			Assert.assertTrue(false, "Failed to list lock History");
		}
	}
	
	public void getFPLockEventHistoryList(String lkName, String lkSubName, String lkTime,int cdcnt,int subcnt, int tcnt,int totalCount, String[][] lstHistArray) {
		try {
	    	Utility.simpleWait(8000);
	    	System.out.println("historylist cdcnt="+cdcnt+", lock history size="+lstHistArray.length);
	    	if(cdcnt == 0) {
	    		System.out.println("in zero");
	    		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/rv_eventlog\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))")); 
	    	}
	    	//System.out.println("cdcnt="+cdcnt+", name size="+lockTitle.size());
    		//for(int i = cdcnt; i<lstHist.size(); i++) {
    		for(int i = cdcnt; i<lstHistArray.length; i++) {
    			for(int j=0; j<lstHistArray[i].length;j++) {
	    			
	    			System.out.println("in i="+i);
		    		//lName = lockTitle.get(i).getText();
	    			//System.out.println("subname="+subName.getText());
		    		//lName = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.widget.LinearLayout["+(i+1)+"]//android.widget.RelativeLayout//android.widget.LinearLayout//android.widget.TextView[1]")).getText();
	    			lName = lstHistArray[i][0];
	    			Assert.assertEquals(lName, lkName,"Lock status matches");
		    		System.out.println("lName="+lName+",exp lkName="+ lkName);
		    		if(lkTime!="") {
		    			timecount = tcnt;
			    		//lTime = lockTime.get(tcnt).getText();
			    		//lTime =  driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.widget.LinearLayout["+(i+1)+"]//android.widget.RelativeLayout//android.widget.LinearLayout/following-sibling::android.widget.TextView")).getText();
		    			lTime = lstHistArray[i][2];
		    			Assert.assertEquals(lTime, lkTime,"Lock Time matches");
			    		System.out.println("lTime="+lTime+",exp lTime="+ lkTime);
		    		}
		    		//commented on 13-06-2020
		    		//Log.addMessage("Lock event from history is: "+lName);
		    		if(lkSubName!="") {
		    			subnamecount = subcnt;
		    			System.out.println("j="+j);
			    		//lSubName = lockSubTitle.get(subcnt).getText();
			    		//lSubName = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.widget.LinearLayout["+(i+1)+"]//android.widget.RelativeLayout//android.widget.LinearLayout//android.widget.TextView[2]")).getText();
		    			lSubName = lstHistArray[i][1];
		    			Assert.assertEquals(lSubName, lkSubName,"Lock Status sub title matches");
			    		System.out.println("lSubName="+lSubName+",exp lSubName="+ lkSubName);
			    		j++;
			    		Log.addMessage("Lock sub event from history is: "+lSubName);
		    		}
    			}
    			Log.addMessage("Lock event from history is: "+lName);
	    		break;
	    	}
	    	
			Log.addMessage("Lock history listed");
		}catch(Exception e) {
			Log.addMessage("Failed to list lock history");
			Assert.assertTrue(false, "Failed to list lock History");
		}
	}
	
	@SuppressWarnings("unchecked")
	public String[][]  getAllHistoryEvents(int totCount) {
		String[][] eventArray = null;
		//String[] eventList = null;
		ArrayList<String> eventList = new ArrayList<String>();
		boolean eventFlag = false;
		 LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
	  try {
		Thread.sleep(5000);
		List<MobileElement> histEventLst = (List<MobileElement>)  appiumDriver.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.widget.RelativeLayout"));
		System.out.println("histEventList="+histEventLst.size());
		System.out.println("one");
		//ttlCnt = Integer.parseInt(totCount);
		System.out.println("totcnt="+ttlCnt);
		listedSize = histEventList.size();
		System.out.println("two");
		eventArray = new String[totCount][3];
		//eventList = new String[totCount];
		j = 0;
		p = 0;
		System.out.println("three");
		
		do {
			System.out.println("in do");
			for(m =0; m<histEventLst.size()-1;m++) {
				System.out.println("four listsize="+histEventLst.size());
				eventName = "";
				eventMainName = "";
				eventMainNameCnt = 0;
				eventSubNameCnt = 0;	
				eventSubName = "";
				eventTimeCount = 0;
				eventTime = "";
				//changed from (m+j+1) to m+1 on 17-06-2020
				eventMainNameCnt  = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.widget.LinearLayout["+(m+1)+"]//android.widget.RelativeLayout//android.widget.LinearLayout//android.widget.TextView[1]")).size();
				if(eventMainNameCnt>0) {
					eventMainName  = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.widget.LinearLayout["+(m+1)+"]//android.widget.RelativeLayout//android.widget.LinearLayout//android.widget.TextView[1]")).getText().trim();
				}
				System.out.println("eventMainName ="+eventMainName);
				eventSubNameCnt = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.widget.LinearLayout["+(m+1)+"]//android.widget.RelativeLayout//android.widget.LinearLayout//android.widget.TextView[2]")).size();
				if(eventSubNameCnt>0) {
					System.out.println("eventSubNameCnt ="+eventSubNameCnt);
					eventSubName = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.widget.LinearLayout["+(m+1)+"]//android.widget.RelativeLayout//android.widget.LinearLayout//android.widget.TextView[2]")).getText().trim();
					System.out.println("eventSubName="+eventSubName);
				}
				
				System.out.println("eventMainName ="+eventMainName+", eventSubName="+eventSubName);
				eventArray[m+p][0] = eventMainName;
				eventArray[m+p][1] = eventSubName;
				if(!eventMainName.equals("Status Update: Locked")) {
					System.out.println("inside eventTime");
					eventTimeCount = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.widget.LinearLayout["+(m+1)+"]//android.widget.RelativeLayout//android.widget.LinearLayout/following-sibling::android.widget.TextView")).size();
					if(eventTimeCount>0) {
						eventTime = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.widget.LinearLayout["+(m+1)+"]//android.widget.RelativeLayout//android.widget.LinearLayout/following-sibling::android.widget.TextView")).getText().trim();
					}
				}
				eventArray[m+p][2] = eventTime;
				eventName = eventMainName+"/"+eventSubName+"/"+eventTime;
				//check if event already added to the array
				if(j>0) {
					eventFlag = false;
					System.out.println("m="+m);
					//checking for partially visible text
					//can check if eventMainName contains text app and time is null break 
					if(eventMainName!="" && m>0) {
						System.out.println("eventList length="+eventList.size());
						//for(int ec=0;ec<(m+p);ec++) {
						for(int ec=0;ec<eventList.size();ec++) {
							System.out.println("eventList.get("+ec+")="+eventList.get(ec)+", event name="+eventName);
							if(eventList.get(ec).equals(eventName)) {
								System.out.println("event exists");
								eventFlag = true;
								break;
							}
							System.out.println("event exists break loop eventFlag");
						}
						if(!eventFlag) {
							System.out.println("new event add to list="+eventName);
							//eventList[m+p] = eventName;
							eventList.add(eventName);
						}
					}
					
				}else {
					//eventList[m+p] = eventName;
					eventList.add(eventName);
				}
				System.out.println("eventTime ="+eventTime);
			}
			j=j+1;
			p = m;
			System.out.println("cnt index="+j);
			//this is for only 3 swipes
			//checking last element in the last swipe
			if(j==4) {
				eventMainNameCnt=0;
				eventMainName="";
				System.out.println("histEventLst size="+histEventLst.size());
				eventMainNameCnt  = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.widget.LinearLayout["+histEventLst.size()+"]//android.widget.RelativeLayout//android.widget.LinearLayout//android.widget.TextView[1]")).size();
				if(eventMainNameCnt>0) {
					eventMainName  = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.widget.LinearLayout["+histEventLst.size()+"]//android.widget.RelativeLayout//android.widget.LinearLayout//android.widget.TextView[1]")).getText().trim();
				}
				eventName=eventMainName+"//";
				eventList.add(eventName);
				System.out.println("eventName last="+eventName+" evenlist size="+eventList.size());
				break;
			}
			verticalSwipe(appiumDriver);
			//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.kwikset.blewifi.dev:id/rv_eventlog\")).scrollIntoView(new UiSelector().textMatches(\""+lsttext+"\").instance(0))"));
			System.out.println("test");
			Thread.sleep(1000);
			System.out.println("test after wait");
			histEventLst = appiumDriver.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.widget.RelativeLayout"));
			System.out.println("histEventLst new="+histEventLst.size()+", eventMainName="+eventMainName);
		}while(!eventMainName.equals("Device Activation"));
		
		//System.out.println("-----event size="+eventArray.length);
		System.out.println("-----event size="+eventList.size());
		
		
		Log.addMessage("Lock events and time are listed");
		
	  }catch(Exception e) {
			Log.addMessage("Failed to get lock events");
			Assert.assertTrue(false, "Failed to get lock events");
	  }
	  return eventArray;
	}
	
	//added on 17-06-2020
	@SuppressWarnings("rawtypes")
	public static void verticalSwipe(AppiumDriver<MobileElement> driver) {
		try {
			TouchAction action = new TouchAction(appiumDriver); 
			action.press(PointOption.point(115, 1200)).waitAction(WaitOptions.waitOptions(ofSeconds(2)))
			                .moveTo(PointOption.point(115, 500)).release().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	/** 
	* Method Name: clickBackButton(), 
	* This function is used to go back to Lock Settings Page
	*/
	
	public void clickBackButton() throws InterruptedException {
		try {
			Utility.waitForElementToBePresent(navBack, appiumDriver);
			//System.out.println("after wait back");
			//Utility.waitForElementToBeVisible(navBack);
			Utility.waitForElementToBeClickable(navBack);
			navBack.click();
			Log.addMessage("Clicked Back Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Back button");
			Assert.assertTrue(false, "Failed to click back button");
		}
	}
	/* added on 10-06-2020 */
	
	public void verifyLockHistoryScreen() throws InterruptedException {
		try {
			//Utility.simpleWait(10000);//commented on 06-10-2020 for bvt
			//System.out.println("in1");
			Utility.waitForElementToBeVisible(brandLogo);
			Assert.assertTrue(true, "Brand Logo displayed in the lock history screen");
			//System.out.println("in2");
			Utility.waitForElementToBeVisible(navBack);
			Assert.assertTrue(true, "Back button displayed in the lock history screen");
			//System.out.println("in3");
			Utility.waitForElementToBeVisible(clearHistoryButton);
			Assert.assertTrue(true, "Clear History button displayed in the lock history screen");
			//System.out.println("in4");
			Utility.waitForElementToBeVisible(homeName);
			Assert.assertTrue(true, "Home Name displayed in the lock history screen");
			//System.out.println("in5");
			Utility.waitForElementToBeVisible(lockName);
			Assert.assertTrue(true, "Lock Name displayed in the lock history screen");
			//System.out.println("in6");
		}catch(Exception e) {
			Log.addMessage("Failed to display all elements in UI for username view page");
			Assert.assertTrue(false, "Failed to display all elements in UI for username view page");
		}
	}
	
	/* added on 16-10-2020 */
	
	public void verifyHaloLockHistoryScreen() throws InterruptedException {
		try {
			if(device.equals("iOS")) {
				Utility.simpleWait(5000);
			}
			//Utility.simpleWait(10000);//commented on 06-10-2020 for bvt
			//System.out.println("in1");
			Utility.waitForElementToBeVisible(navBack);
			Assert.assertTrue(true, "Back button displayed in the lock history screen");
			//System.out.println("in3");
			Utility.waitForElementToBeVisible(clearHistoryButton);
			Assert.assertTrue(true, "Clear History button displayed in the lock history screen");
			//System.out.println("in4");
			Utility.waitForElementToBeVisible(homeName);
			Assert.assertTrue(true, "Home Name displayed in the lock history screen");
			//System.out.println("in5");
			Utility.waitForElementToBeVisible(lockName);
			Assert.assertTrue(true, "Lock Name displayed in the lock history screen");
			//System.out.println("in6");
		}catch(Exception e) {
			Log.addMessage("Failed to display all elements in UI for username view page");
			Assert.assertTrue(false, "Failed to display all elements in UI for username view page");
		}
	}
	
	public void clearHistoryWhenEmpty(String histClearMssg) throws InterruptedException {
		try {
			//Utility.simpleWait(10000);
			if(device.equals("iOS")) {
				clearMsg = firstEvent.getText();
			}else {
				clearMsg = firstEvent.getAttribute("name");
			}
			System.out.println("in first event="+clearMsg);
			Assert.assertEquals(clearMsg,histClearMssg,"History cleared message displayed");
			System.out.println("in6");
			Log.addMessage("History cleared message displayed when empty");
		}catch(Exception e) {
			Log.addMessage("Failed to display history cleared message");
			Assert.assertTrue(false, "Failed to display history cleared message");
		}
	}
	
	//added on 15-06-2020
	public void clickCancelButton() {
		try {
			Thread.sleep(6000);
			cancelButton.click();
			Log.addMessage("Clicked Cancel Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Cancel button ");
			Assert.assertTrue(false, "Failed to click Cancel button");
		}
	}
	
	public boolean checkOkButton() {
		try {
		   //Utility.simpleWait(3000);//commented for bvt 09-10-2020
			//System.out.println("in ok");
			//Utility.waitForElementToBeVisible1(OkButton, driver);
			
			if(device.equals("iOS")) {
				 Utility.waitForElementPresent(yesBtn,appiumDriver);
			}else {
				 Utility.waitForElementPresent(okAnBtn,appiumDriver);
			}
		   // System.out.println("in ok");
		    okButtonPresent=true;
		    Log.addMessage("Ok button found, syncing in progress");
		    return okButtonPresent;
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to display Ok button");
			//System.out.println("in ok btn catch");
			okButtonPresent=false;
			return okButtonPresent;
		}
	}
	
	public boolean checkOkButtonFP() {
		try {
		   //Utility.simpleWait(3000);//commented for bvt 09-10-2020
			//System.out.println("in ok");
			//Utility.waitForElementToBeVisible1(OkButton, driver);
			
			if(device.equals("iOS")) {
				 Utility.waitForElementPresent(okBtnFp,appiumDriver);
			}else {
				 Utility.waitForElementPresent(okAnBtnFp,appiumDriver);
			}
		    System.out.println("in ok");
		    okButtonPresent=true;
		    Log.addMessage("Ok button found, syncing in progress");
		    return okButtonPresent;
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to display Ok button");
			System.out.println("in catch");
			okButtonPresent=false;
			return okButtonPresent;
		}
	}
	
	

}
