package pages.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.interactions.touch.Scroll;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import javafx.scene.input.KeyCode;
import utility.Log;
import utility.Utility;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

import java.time.Duration;

public class LimitByWeekdayAndTimePage extends Settings{
	
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
		
	@iOSXCUITFindBy(id = "Days to Allow")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_weekdays_value"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_weekdays_value"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_weekdays_value"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_weekdays_value"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/tv_weekdays_value")
	})
	@CacheLookup		
	private MobileElement daysToAllow;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name='Limit Time of Day']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/limit_switch"),
		@AndroidBy(id = "com.kwikset.blewifi:id/limit_switch"),
		@AndroidBy(id = "com.spectrum.giga:id/limit_switch"),
		@AndroidBy(id = "com.weiser.blewifi:id/limit_switch"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/limit_switch")
	})
	
	@CacheLookup
	private MobileElement limitTimeOfDay;
	
	@iOSXCUITFindBy(id = "Start Time")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_start_time"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_start_time"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_start_time"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_start_time"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/tv_start_time")
	})
	@CacheLookup
	private MobileElement startTime;
	
	@iOSXCUITFindBy(id = "End Time")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_end_time"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_end_time"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_end_time"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_end_time"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/tv_end_time")
	})
	@CacheLookup
	private MobileElement endTime;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Ok']")
	@AndroidFindBy(id = "android:id/button1")
	@CacheLookup
	private MobileElement OkButton;
	
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/btn_ok"),
		@AndroidBy(id = "com.kwikset.blewifi:id/btn_ok"),
		@AndroidBy(id = "com.spectrum.giga:id/btn_ok"),
		@AndroidBy(id = "com.weiser.blewifi:id/btn_ok"),
		@AndroidBy(id = "com.weiser.blewifi.dev:id/btn_ok")
	})
	@CacheLookup
	private MobileElement OkCal;
	
	@AndroidFindBy(className = "android.widget.NumberPicker")
	@CacheLookup
	private  List<MobileElement> timePickergen ;
	
	@AndroidFindBy(id = "android:id/numberpicker_input")
	@CacheLookup
	private List<MobileElement> timePicker2 ;
	
	@AndroidFindBy(xpath="//android.widget.NumberPicker[@index='0']//android.widget.EditText")
	@CacheLookup
	private MobileElement hourText;

	@AndroidFindBy(xpath="//android.widget.NumberPicker[@index='2']//android.widget.EditText")
	@CacheLookup
	private MobileElement minuteText;
	
	@AndroidFindBy(xpath="//android.widget.NumberPicker[@index='1']//android.widget.EditText")
	@CacheLookup
	private MobileElement amPMText;
	
	//For QA below code
	//By startElement = MobileBy.id("com.kwikset.blewifi.dev:id/rl_end_time");
	//By startElement = MobileBy.xpath("//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]");
	By startElement = MobileBy.xpath("//android.widget.TextView[@text='Start Time']");
	//For Beta below code
	//By startElement = MobileBy.id("com.spectrum.giga:id/rl_end_time");
	//For QA below code
	//By endElement = MobileBy.id("com.kwikset.blewifi.dev:id/rl_start_time");
	By endElement = MobileBy.xpath("//android.widget.TextView[@text='End Time']");
	//For Beta below code
	//By endElement = MobileBy.id("com.spectrum.giga:id/rl_start_time");
	
	By timePickerand = MobileBy.xpath("//android.widget.NumberPicker");
	
	By timePicker = MobileBy.xpath("//XCUIElementTypePickerWheel");
	
	
	WebDriverWait wait = new WebDriverWait(driver,10);


	//Constructor
	@SuppressWarnings("static-access")
	public LimitByWeekdayAndTimePage(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
		
		
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	
	public void clickDaysToAllowOption() {
		try {
			Utility.waitForElementToBeVisible(daysToAllow);
			Utility.waitForElementToBeClickable(daysToAllow);
			daysToAllow.click();
			Log.addMessage("Days to Allow option clicked");
		}catch(Exception e) {
			Log.addMessage("Failed to click days to allow option");
			Assert.assertTrue(false, "Failed to click days to allow option");
		}
	}
	
	@SuppressWarnings("rawtypes")
	public  void scrollKeys(AppiumDriver driver, String[] list) {
        System.out.println("Starting the process"+list.length);
        for (int i = 0; i < list.length; i++) {
            By meX = By.xpath("//android.widget.NumberPicker[@index='"+(i)+"']//android.widget.EditText["+(i+1)+"]");
            MobileElement me = (MobileElement) driver.findElement(meX);
            TouchAction t = new TouchAction(driver);
            WebElement first = driver.findElement(meX);
            t.longPress(new LongPressOptions().withElement(new 
                    ElementOption().withElement(first))).perform();
            driver.findElement(By.xpath("//android.widget.NumberPicker[@index='0']//android.widget.EditText")).clear();
			driver.findElement(By.xpath("//android.widget.NumberPicker[@index='0']//android.widget.EditText")).sendKeys(list[0]);
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();", KeyCode.NUMPAD7);
            JavascriptExecutor jsn = appiumDriver;
			Map<String, Object> params = new HashMap<>();
			params.put("action", "Next");
			params.put("element", me);
			jsn.executeScript("mobile: performEditorAction", params);
        }
	}
	
	public void selectStartTime(String hours, String min, String AM_PM) {
		try {
			//Thread.sleep(6000);commented for bvt 09-10-20
			Utility.waitForElementToBeVisible(startTime);
			startTime.click();
			if(device.equals("iOS")) {
				List<WebElement> pickerEls = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(timePicker));
				pickerEls.get(0).sendKeys(hours);
				pickerEls.get(1).sendKeys(min);
				pickerEls.get(2).sendKeys(AM_PM);
			}else {
				//System.out.println("selectEndTime");//commented on 26-11-2020
				
				if(timePicker2.size()>0) {
					//System.out.println("timePicker2 size="+timePicker2.size());//commented on 26-11-2020
					Thread.sleep(3000);
					/*driver.findElement(By.xpath("//android.widget.NumberPicker[@index='0']//android.widget.EditText")).click();
					driver.findElement(By.xpath("//android.widget.NumberPicker[@index='0']//android.widget.EditText")).clear();
					driver.findElement(By.xpath("//android.widget.NumberPicker[@index='0']//android.widget.EditText")).sendKeys(hours);*/
					hourText.click();
					hourText.clear();
					hourText.sendKeys(hours);
					JavascriptExecutor jsn = appiumDriver;
					Map<String, Object> params = new HashMap<>();
					params.put("action", "Next");
					params.put("element", hourText);
					jsn.executeScript("mobile: performEditorAction", params);
					
					/*driver.findElement(By.xpath("//android.widget.NumberPicker[@index='2']//android.widget.EditText")).click();
					driver.findElement(By.xpath("//android.widget.NumberPicker[@index='2']//android.widget.EditText")).clear();
					driver.findElement(By.xpath("//android.widget.NumberPicker[@index='2']//android.widget.EditText")).sendKeys(min);*/
					minuteText.click();
					minuteText.clear();
					minuteText.sendKeys(min);
					JavascriptExecutor js = appiumDriver;
					Map<String, Object> params1 = new HashMap<>();
					params1.put("action", "Next");
					params1.put("element", minuteText);
					js.executeScript("mobile: performEditorAction", params1);
					System.out.println("in elem5");//commented on 26-11-2020
					
					/*driver.findElement(By.xpath("//android.widget.NumberPicker[@index='1']//android.widget.EditText")).clear();
					driver.findElement(By.xpath("//android.widget.NumberPicker[@index='1']//android.widget.EditText")).sendKeys(AM_PM);*/
					//driver.findElement(By.xpath("//android.widget.NumberPicker[@index='1']//android.widget.EditText")).click();
					amPMText.click();
					amPMText.clear();
					amPMText.sendKeys(AM_PM);
					JavascriptExecutor js1 = appiumDriver;
					Map<String, Object> params2 = new HashMap<>();
					params2.put("action", "Done");
					params2.put("element", minuteText);
					js1.executeScript("mobile: performEditorAction", params2);
					System.out.println("in elem6");//commented on 26-11-2020
					//Thread.sleep(3000);//commented on 26-11-2020
					swipeByElements(findElement(startElement),findElement(endElement));
					Thread.sleep(2000);//commented on 26-11-2020
					System.out.println("ok");
					OkCal.click();
				}
			}
			Log.addMessage("Start time is set as: "+hours+" "+min+", "+AM_PM);
		}catch(Exception e) {
			Log.addMessage("Failed to set start time");
			Assert.assertTrue(false, "Failed to set start time");
		}
	}
	
	public void selectEndTime(String hours, String min, String AM_PM) {
		try {
			//Thread.sleep(6000);commented for bvt 09-10-2020
			Utility.waitForElementToBeVisible(endTime);
			endTime.click();
			if(device.equals("iOS")) {
				List<WebElement> pickerEls = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(timePicker));
				pickerEls.get(0).sendKeys(hours);
				pickerEls.get(1).sendKeys(min);
				pickerEls.get(2).sendKeys(AM_PM);
			}else {
				//System.out.println("selectEndTime4");//commented on 26-11-2020
				if(timePicker2.size()>0) {
					//System.out.println("timePicker2 size="+timePicker2.size()+", hours="+hours);//commented on 26-11-2020
					// driver.findElement(By.xpath("//*[@class='android.widget.NumberPicker' znd @index='0']")).sendKeys(hours);
					/*driver.findElement(By.xpath("//android.widget.NumberPicker[@index='0']//android.widget.EditText")).clear();
					driver.findElement(By.xpath("//android.widget.NumberPicker[@index='0']//android.widget.EditText")).sendKeys(hours);
					driver.findElement(By.xpath("//android.widget.NumberPicker[@index='1']//android.widget.EditText")).clear();
					driver.findElement(By.xpath("//android.widget.NumberPicker[@index='1']//android.widget.EditText")).sendKeys(AM_PM);
					driver.findElement(By.xpath("//android.widget.NumberPicker[@index='2']//android.widget.EditText")).clear();
					driver.findElement(By.xpath("//android.widget.NumberPicker[@index='2']//android.widget.EditText")).sendKeys(min);*/
					
					hourText.click();
					hourText.clear();
					hourText.sendKeys(hours);
					JavascriptExecutor jsn = appiumDriver;
					Map<String, Object> params = new HashMap<>();
					params.put("action", "Next");
					params.put("element", hourText);
					jsn.executeScript("mobile: performEditorAction", params);
					
					minuteText.click();
					minuteText.clear();
					minuteText.sendKeys(min);
					JavascriptExecutor js = appiumDriver;
					Map<String, Object> params1 = new HashMap<>();
					params1.put("action", "Next");
					params1.put("element", minuteText);
					js.executeScript("mobile: performEditorAction", params1);
					//System.out.println("in elem5");//commented on 26-11-2020
					
					/*amPMText.clear();
					amPMText.sendKeys(AM_PM);
					appiumDriver.hideKeyboard();*/
					//System.out.println("in elem5");//commented on 26-11-2020
					amPMText.click();
					amPMText.clear();
					amPMText.sendKeys(AM_PM);
					JavascriptExecutor js1 = appiumDriver;
					Map<String, Object> params2 = new HashMap<>();
					params2.put("action", "Done");
					params2.put("element", minuteText);
					js1.executeScript("mobile: performEditorAction", params2);
					
					
					//System.out.println("timePicker2 sendkeys="+hours);//commented on 26-11-2020
					
					swipeByElements(findElement(startElement),findElement(endElement));
					//System.out.println("after scroll");//commented on 26-11-2020
					//Thread.sleep(2000);//commented on 26-11-2020
					OkCal.click();
				}
					
				}
			//}
			
			Thread.sleep(9000);
			Log.addMessage("End time is set as: "+hours+" "+min+", "+AM_PM);
		}catch(Exception e) {
			Log.addMessage("Failed to set end time");
			Assert.assertTrue(false, "Failed to set end time");
		}
	}
	
	protected AndroidElement findElement (By by) {
		return (AndroidElement) driver.findElement(by);
	}
	
	@SuppressWarnings("rawtypes")
	public void swipeByElements (AndroidElement startElement, AndroidElement endElement) {
	        int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
	        int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);
	 
	        int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
	        int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);
	 
	        new TouchAction((PerformsTouchActions) driver)
	                .press(point(startX,startY))
	                .waitAction(waitOptions(ofMillis(1000)))
	                .moveTo(point(endX, endY))
	                .release().perform();
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
	
	public void clickBackButton() {
		  try {
			  Thread.sleep(6000);
			  backButton.click();
			  Log.addMessage("Clicked back button");
		  }catch(Exception e) {
				Log.addMessage("Failed to click back button");
				Assert.assertTrue(false, "Failed to click back button");
		  }
	}
	
	public void clickLimitTimeOfDay() {
		try {
			Utility.waitForElementToBeVisible(limitTimeOfDay);
			Utility.waitForElementToBeClickable(limitTimeOfDay);
			limitTimeOfDay.click();
			Log.addMessage("Limit Time of Day option clicked");
		}catch(Exception e) {
			Log.addMessage("Failed to click Limit Time of Day option");
			Assert.assertTrue(false, "Failed to click Limit Time of Day option");
		}
	}
	
	public void clickOkButton() {
		  try {
			  Utility.waitForElementToBeVisible(OkButton);
			  Utility.waitForElementToBeClickable(OkButton);
			  OkButton.click();
			  Log.addMessage("Clicked Ok Button");
		  }catch(Exception e) {
				Log.addMessage("Failed to click Ok button");
				Assert.assertTrue(false, "Failed to click Ok button");
		  }
	}
	
	
}
