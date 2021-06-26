package pages.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
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

public class SecurityQuestionsPage extends Settings{
	
	//@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Security Question #1']") //commented on 13-07-2020
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextView)[1]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/spinnerQuesion1"),
		@AndroidBy(id = "com.kwikset.blewifi:id/spinnerQuesion1"),
		@AndroidBy(id = "com.spectrum.giga:id/spinnerQuesion1"),
		@AndroidBy(id = "com.weiser.blewifi:id/spinnerQuesion1")
	})
	@CacheLookup
	private MobileElement question1;
	
	//@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Security Question #2']") //commented on 13-07-2020
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextView)[2]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/spinnerQuesion2"),
		@AndroidBy(id = "com.kwikset.blewifi:id/spinnerQuesion2"),
		@AndroidBy(id = "com.spectrum.giga:id/spinnerQuesion2"),
		@AndroidBy(id = "com.weiser.blewifi:id/spinnerQuesion2")
	})
	@CacheLookup
	private MobileElement question2;
	
	//@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Security Question #3']") //commented on 13-07-2020
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextView)[3]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/spinnerQuesion3"),
		@AndroidBy(id = "com.kwikset.blewifi:id/spinnerQuesion3"),
		@AndroidBy(id = "com.spectrum.giga:id/spinnerQuesion3"),
		@AndroidBy(id = "com.weiser.blewifi:id/spinnerQuesion3")
	})
	@CacheLookup
	private MobileElement question3;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[1]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/edtAnswer1"),
		@AndroidBy(id = "com.kwikset.blewifi:id/edtAnswer1"),
		@AndroidBy(id = "com.spectrum.giga:id/edtAnswer1"),
		@AndroidBy(id = "com.weiser.blewifi:id/edtAnswer1")
	})
	@CacheLookup
	private MobileElement answer1;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[2]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/edtAnswer2"),
		@AndroidBy(id = "com.kwikset.blewifi:id/edtAnswer2"),
		@AndroidBy(id = "com.spectrum.giga:id/edtAnswer2"),
		@AndroidBy(id = "com.weiser.blewifi:id/edtAnswer2")
	})	@CacheLookup
	private MobileElement answer2;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[3]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/edtAnswer3"),
		@AndroidBy(id = "com.kwikset.blewifi:id/edtAnswer3"),
		@AndroidBy(id = "com.spectrum.giga:id/edtAnswer3"),
		@AndroidBy(id = "com.weiser.blewifi:id/edtAnswer3")
	})
	@CacheLookup
	private MobileElement answer3;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Next']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_submit"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_submit"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_submit"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_submit")
	})
	@CacheLookup
	private MobileElement nextButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Submit']")
	@CacheLookup
	private MobileElement nextIButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Next:']")
	private MobileElement nextKeyboard;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
	private MobileElement doneKeyboard;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Return']")
	private MobileElement returnKeyboard;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextView)[1]")
	@AndroidFindBy(xpath = "//android.widget.TextView[2]")
	@CacheLookup
	private MobileElement dropdownitem1;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextView)[2]")
	@AndroidFindBy(xpath = "//android.widget.TextView[2]")
	@CacheLookup
	private MobileElement dropdownitem2;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextView)[3]")
	@AndroidFindBy(xpath = "//android.widget.TextView[2]")
	@CacheLookup
	private MobileElement dropdownitem3;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
	@CacheLookup
	private MobileElement doneButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeMenuItem[@name='Select All']")
	@CacheLookup
	private MobileElement selectAllMenu;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
	@CacheLookup
	private MobileElement cancelButton;
	
	//added on 08-07-2020
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextView")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/forgot_password_security_question"),
		@AndroidBy(id = "com.kwikset.blewifi:id/forgot_password_security_question"),
		@AndroidBy(id = "com.spectrum.giga:id/forgot_password_security_question"),
		@AndroidBy(id = "com.weiser.blewifi:id/forgot_password_security_question")
	})
	@CacheLookup
	private MobileElement rcvrQuestion;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/forgot_password_security_answer"),
		@AndroidBy(id = "com.kwikset.blewifi:id/forgot_password_security_answer"),
		@AndroidBy(id = "com.spectrum.giga:id/forgot_password_security_answer"),
		@AndroidBy(id = "com.weiser.blewifi:id/forgot_password_security_answer")
	})
	@CacheLookup
	private MobileElement rcvrAnswer;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Security Question #1']")
	@AndroidFindBy(xpath = "//android.widget.ListView//android.widget.TextView")
	@CacheLookup
	private List<MobileElement> selQn;
	
	//added on 29-06-2020
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_back"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_back"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_back"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_back")
	})
	//@AndroidFindBy(id="com.kwikset.blewifi.dev:id/cancelAllhomes")
	@CacheLookup
	private MobileElement backButton;
	
	//added on 07-07-2020
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/cancelAllhomes"),
		@AndroidBy(id = "com.kwikset.blewifi:id/cancelAllhomes"),
		@AndroidBy(id = "com.spectrum.giga:id/cancelAllhomes"),
		@AndroidBy(id = "com.weiser.blewifi:id/cancelAllhomes")
	})
	@CacheLookup
	private MobileElement backBtn;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextView)[1]")
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.kwikset.blewifi.dev:id/spItem']")
	@CacheLookup
	private List<MobileElement> lstQuestion1;
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[1]")
	@AndroidFindBy(xpath="//android.widget.EditText")
	@CacheLookup
	private MobileElement answer;

	@iOSXCUITFindBy(id = "Ok")
	@AndroidFindBy(id="android:id/button1")
	private MobileElement OKButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[2]")
	@AndroidFindBy(id="android:id/message")
	private MobileElement confirmMessage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[1]")
	@AndroidFindBy(id="android:id/alertTitle")
	private MobileElement alertTitle;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText")//added on 18-05-2020
	@AndroidFindBy(xpath="(//android.widget.Toast)[1]")
	@CacheLookup
	private MobileElement confirmToastMsg;
	
	By okBtn= By.xpath("//XCUIElementTypeButton[@name='Ok']");
	By okAnBtn= By.id("android:id/button1");
	
	boolean okButtonPresent = false;
	
	String actTitle, actMessage, actualRes, toastMessage ="";
	int cnt = 0;
	
	
	//XCUIElementTypePicker/XCUIElementTypePickerWheel/XCUIElementTypeOther[3]

	
	//Constructor
	@SuppressWarnings("static-access")
	public SecurityQuestionsPage(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void enterQuestion1() {
		try {
			Utility.waitForElementToBeVisible(question1);
			Utility.waitForElementToBeClickable(question1);
			question1.click();
			if (device.equals("android")) {
				Utility.waitForElementToBeVisible(dropdownitem1);
				Utility.waitForElementToBeClickable(dropdownitem1);
				dropdownitem1.click();
			}
			else {
				Utility.waitForElementToBeVisible(doneButton);
				Utility.waitForElementToBeClickable(doneButton);
				doneButton.click();	
			}
			Log.addMessage("Question 1 selected");
		}catch(Exception e) {
			Log.addMessage("Failed to select question 1");
			Assert.assertTrue(false, "Failed to select question 1");
		}
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void enterQuestion2() {
		try {
			Utility.waitForElementToBeVisible(question2);
			Utility.waitForElementToBeClickable(question2);
			question2.click();
			if (device.equals("android")) {
				Utility.waitForElementToBeVisible(dropdownitem2);
				Utility.waitForElementToBeClickable(dropdownitem2);
				dropdownitem2.click();
			}
			else {
				Utility.waitForElementToBeVisible(doneButton);
				Utility.waitForElementToBeClickable(doneButton);
				doneButton.click();
			}
			
			Log.addMessage("Question 2 selected");
		}catch(Exception e) {
			Log.addMessage("Failed to select Question 2");
			Assert.assertTrue(false, "Failed to select Question 2");
		}
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void enterQuestion3() {
		try {
			Utility.waitForElementToBeVisible(question3);
			Utility.waitForElementToBeClickable(question3);
			question3.click();
			if (device.equals("android")) {
				Utility.waitForElementToBeVisible(dropdownitem3);
				Utility.waitForElementToBeClickable(dropdownitem3);
				dropdownitem3.click();
			}
			else {
				Utility.waitForElementToBeVisible(doneButton);
				Utility.waitForElementToBeClickable(doneButton);
				doneButton.click();
			}
			
			Log.addMessage("Question 3 selected");
		}catch(Exception e) {
			Log.addMessage("Failed to select Question 3");
			Assert.assertTrue(false, "Failed to select Question 3");
		}
	}

	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void enterAnswer1(String answer) {
		try {
			Utility.waitForElementToBeVisible(answer1);
			answer1.click();
			if(device.equals("iOS") && !(answer1.getText()).equals("Answer")) {//changed on 7th Aug 2020 during regression
				answer1.click();
				Thread.sleep(1000);
				selectAllMenu.click();
			}
			answer1.clear();
			answer1.sendKeys(answer);
			if(device.equals("iOS")) {
				returnKeyboard.click();
			}else {
				appiumDriver.hideKeyboard();
			}
			Log.addMessage("Answer 1 entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter answer 1");
			Assert.assertTrue(false, "Failed to enter answer 1");
		}
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void enterAnswer2(String answer) {
		try {
			Utility.waitForElementToBeVisible(answer2);
			answer2.click();
			if(device.equals("iOS") && !(answer2.getText()).equals("Answer")) {
				answer2.click();
				Thread.sleep(1000);
				selectAllMenu.click();
			}
			answer2.clear();
			answer2.sendKeys(answer);
			if(device.equals("iOS")) {
				returnKeyboard.click();
			}else {
				appiumDriver.hideKeyboard();
			}
			Log.addMessage("Answer 2 entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter answer 2");
			Assert.assertTrue(false, "Failed to enter answer 2");
		}
	}

	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void enterAnswer3(String answer) {
		try {
			Utility.waitForElementToBeVisible(answer3);	
			answer3.click();
			if(device.equals("iOS") && !(answer3.getText()).equals("Answer")) {
				answer3.click();
				Thread.sleep(1000);
				selectAllMenu.click();
			}
			answer3.clear();
			answer3.sendKeys(answer);
			if(device.equals("iOS")) {//to hide keyboard
				question3.click();
				cancelButton.click();
			}else {
				appiumDriver.hideKeyboard();
			}
			Log.addMessage("Answer 3 entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter answer 3");
			Assert.assertTrue(false, "Failed to enter answer 3");
		}
	}
	
	/** 
	* Method Name: clickNextButton(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void clickNextButton() {
		try {
			/*if(device.contentEquals("iOS")) {//commented on 8th Aug 2020 for regression
				Utility.waitForElementToBeVisible(nextIButton);
				Utility.waitForElementToBeClickable(nextIButton);
				nextIButton.click();
			}else {*/
				Utility.waitForElementToBeVisible(nextButton);
				Utility.waitForElementToBeClickable(nextButton);
				nextButton.click();
			//}
			//Utility.simpleWait(6000);
			Log.addMessage("Clicked Next Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Next button");
			Assert.assertTrue(false, "Failed to click Next button");
		}
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void clickNextIButton() {
		try {
			Utility.waitForElementToBeVisible(nextIButton);
			Utility.waitForElementToBeClickable(nextIButton);
			nextIButton.click();
			//Utility.simpleWait(6000);
			Log.addMessage("Clicked Next Button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Next button");
			Assert.assertTrue(false, "Failed to click Next button");
		}
	}
	
	//added on 08-07-2020 for recover password
	/** 
	* Method Name: clickSecurityQn(), 
	* This function is used to click Security Question
	*/
	
	public void clickSecurityQn() {
		try {
			Utility.waitForElementToBeVisible(rcvrQuestion);
			Utility.waitForElementToBeClickable(rcvrQuestion);
			System.out.println("in clickSecurityQn");
			rcvrQuestion.click();
			Log.addMessage("Clicked Security Question");
		}catch(Exception e) {
			Log.addMessage("Security Question is not visible");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Security Question is not visible");
		}
	}
	//added on 02-03-2021
	/** 
	* Method Name: checkForCountAndDuplicateInQn1(), 
	* This function is used to click Change Security Question1
	*/
	
	public void checkForCountAndDuplicateInQn(String qn1, int cntQn) {
		try {
			//Utility.waitForElementToBeVisible(lstQuestion1.get(0));
			//Utility.waitForElementToBeClickable(lstQuestion1.get(0));
			Thread.sleep(3000);
			int Qsize1 = lstQuestion1.size();
			System.out.println("Total Questions : " + Qsize1);
			Log.addMessage("Total Questions in Security Question"+cntQn+" : "+Qsize1);
			
			String elText = "";
			ArrayList<String> ar = new ArrayList<String>();
			for(int i=0;i<lstQuestion1.size();i++)
			{
				elText="";
				elText = lstQuestion1.get(i).getText();
				if(ar.contains(elText))
				{
					System.out.println("Security Questions are repeating");
					Assert.assertTrue(false, "Questions are repeating in the SecurityQuestion #"+cntQn+" drop down");
					break;
				}else {
					ar.add(elText);
					System.out.println("Security Questions are not repeating");
				}
				
			}
			if(lstQuestion1.size()==ar.size()) {
				Assert.assertTrue(true, "No duplicate questions in SecurityQuestion #"+cntQn+" drop down");
				Log.addMessage("No duplicate questions in SecurityQuestion #"+cntQn+" drop down");
			}
			
		}catch(Exception e) {
			Log.addMessage("Change Security Question"+cntQn+" is not visible");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Change Security Question"+cntQn+" is not visible");
		}
	}
	
	/** 
	* Method Name: checkForDuplicateInNextQn(), 
	* This function is used to click Change Security Question1
	*/
	
	public void checkForDuplicateInNextQn(String qn1, String qn2, String qn3, int cntQn) {
		try {
			Utility.waitForElementToBeVisible(lstQuestion1.get(0));
			Utility.waitForElementToBeClickable(lstQuestion1.get(0));
	
			//below code to check and select the required question passed from the dataprovider
			String elText = "";
			boolean qnExist = false;
			boolean qnDupExist = false;
			for(int i=0;i<lstQuestion1.size();i++)
			{
				elText = "";
				elText = lstQuestion1.get(i).getText();
				if(cntQn==1) {
					if(elText.equals(qn1)) {
						 lstQuestion1.get(i).click();
						 qnExist = true;
						 break;
					}
				}else if(cntQn==2) {
					if(elText.equals(qn1)) {
						 lstQuestion1.get(i).click();
						 qnExist = false;
						 qnDupExist = true;
						 Assert.assertTrue(false, "Duplicate question found in Question1 and Question2 list: "+qn1);
						 Log.addMessage("Duplicate question found in Question1 and Question2 list: "+qn1);
						 break;
					}
					if(elText.equals(qn2) &&  !qnDupExist) {
						 lstQuestion1.get(i).click();
						 qnExist = true;
						 break;
					}
				}else {
					if(elText.equals(qn1) || elText.equals(qn2) ) {
						 lstQuestion1.get(i).click();
						 qnExist = false;
						 qnDupExist = true;
						 Assert.assertTrue(false, "Duplicate question found in Question1, Question2 and Question3 list: "+lstQuestion1.get(i).getText());
						 Log.addMessage("Duplicate question found in Question1, Question2 and Question3 list: "+lstQuestion1.get(i).getText());
						 break;
					}
					if(elText.equals(qn3) &&  !qnDupExist) {
						 lstQuestion1.get(i).click();
						 qnExist = true;
						 break;
					}
				}
			}
			if(qnExist) {
				Assert.assertTrue(true, "Selected one Security Question"+cntQn);
				Log.addMessage("Selected one Security Question"+cntQn);
			}else if(!qnExist && !qnDupExist) {
				Assert.assertTrue(false, "Could not find the required questions");
				Log.addMessage("Could not find the required questions");
			}
			
		}catch(Exception e) {
			Log.addMessage("Change Security Question"+cntQn+" is not visible");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Change Security Question"+cntQn+" is not visible");
		}
	}
	
	//added on 30-06-2020
		/** 
		* Method Name: clickChangeSecurityQn1(), 
		* This function is used to click Change Security Question1
		*/
		
		public void clickChangeSecurityQn1() {
			try {
				Utility.waitForElementToBeVisible(question1);
				Utility.waitForElementToBeClickable(question1);
				question1.click();
				Log.addMessage("Clicked Change Security Question1");
			}catch(Exception e) {
				Log.addMessage("Change Security Question1 is not visible");
				System.out.println(e.getMessage().toString());
				Assert.assertTrue(false, "Change Security Question1 is not visible");
			}
		}
	
	/** 
	* Method Name: selectSecurityQn(), 
	* This function is used to select Security Question1
	*/
	
	public void selectSecurityQn(String qn1) {
		try {
			cnt = Integer.parseInt(qn1);
			selQn.get(cnt).click();
			Log.addMessage("Selected Security Question");
		}catch(Exception e) {
			Log.addMessage("Security Question is not selected");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Security Question is not selected");
		}
	}
	
	/** 
	* Method Name: selectSecurityQn1(), 
	* This function is used to select Security Question1
	*/
	
	public void selectSecurityQn1(String qn1) {
		try {
			//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"What is your favourite team?\"));")).click();
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+qn1.toString()+"\"));")).click();
			
			//System.out.println("size="+driver.findElement(By.xpath("//android.widget.TextView[2]")).getSize());
			Log.addMessage("Selected Security Question1");
		}catch(Exception e) {
			Log.addMessage("Security Question1 is not selected");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Security Question1 is not selected");
		}
	}
	
	/** 
	* Method Name: clickChangeSecurityQn2(), 
	* This function is used to click Change Security Question1
	*/
	
	public void clickChangeSecurityQn2() {
		try {
			Utility.waitForElementToBeVisible(question2);
			Utility.waitForElementToBeClickable(question2);
			question2.click();
			Log.addMessage("Clicked Change Security Question2");
		}catch(Exception e) {
			Log.addMessage("Change Security Question2 is not visible");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Change Security Question2 is not visible");
		}
	}
	
	/** 
	* Method Name: selectSecurityQn2(), 
	* This function is used to select Security Question2
	*/
	
	public void selectSecurityQn2(String qn2) {
		try {
			
			//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"What was your favourite food as a child?\"));")).click();
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+qn2.toString()+"\"));")).click();
			Log.addMessage("Selected Security Question2");
		}catch(Exception e) {
			Log.addMessage("Security Question2 is not selected");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Security Question2 is not selected");
		}
	}
	
	/** 
	* Method Name: clickChangeSecurityQn3(), 
	* This function is used to click Change Security Question1
	*/
	
	public void clickChangeSecurityQn3() {
		try {
			Utility.waitForElementToBeVisible(question3);
			Utility.waitForElementToBeClickable(question3);
			question3.click();
			Log.addMessage("Clicked Change Security Question3");
		}catch(Exception e) {
			Log.addMessage("Change Security Question3 is not visible");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Change Security Question3 is not visible");
		}
	}
	
	/** 
	* Method Name: selectSecurityQn3(), 
	* This function is used to select Security Question2
	*/	
	public void selectSecurityQn3(String qn3) {
		try {			
			//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"What was your childhood nickname?\"));")).click();
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+qn3.toString()+"\"));")).click();
						
			Log.addMessage("Selected Security Question3");
		}catch(Exception e) {
			Log.addMessage("Security Question3 is not selected");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Security Question3 is not selected");
		}
	}
	
	/** 
	* Method Name: updateSecurityQuestion(), 
	* This function is used to update the Security Question
	*/
	public void updateSecurityQuestion(String qn1,String ans1,String qn2,String ans2,String qn3,String ans3, String errMessage, String titleMsg, String valType) {
		try {	
			if(device.equals("iOS")) {
				System.out.println("qn1="+qn1);
				if(qn1!="") {
					System.out.println("is not null");
					enterQuestion1();
					enterAnswer1(ans1);
				}
			}else {
				clickChangeSecurityQn1();
				selectSecurityQn1(qn1);
				enterAnswer1(ans1);
			}
			
			if(device.equals("iOS")) {
				System.out.println("qn2="+qn2);
				if(qn2!="") {
					System.out.println("is not null");
					enterQuestion2();
					enterAnswer2(ans2);
				}
			}else {
				clickChangeSecurityQn2();
				selectSecurityQn2(qn2);
				enterAnswer2(ans2);
			}
			
			if(device.equals("iOS")) {
				System.out.println("qn3="+qn3);
				if(qn3!="") {
					System.out.println("is not null");
					enterQuestion3();
					enterAnswer3(ans3);
				}
			}else {
				clickChangeSecurityQn3();
				selectSecurityQn3(qn3);
				enterAnswer3(ans3);
			}
			//if(valType.equals("new") && device.equals("iOS")) {//added on 29-07-2020 regression
			if(device.equals("iOS")) {
				Utility.waitForElementToBeVisible(nextButton);
				nextButton.click();
			}else {
				clickNextButton();
			}
			if(errMessage!="") {
				if(OKButton.isDisplayed()) {
					System.out.println("in Question qn1="+qn1+", ans1="+ans1);
					System.out.println("in Question qn2="+qn2+", ans2="+ans2);
					System.out.println("in Question qn2="+qn3+", ans3="+ans3);
					System.out.println("in confirmVerificationButton oP="+errMessage);
					if(titleMsg!="") {
						actTitle=alertTitle.getText();
						actMessage=confirmMessage.getText();
					}else {
						if(device.equals("iOS")) {
							actMessage=alertTitle.getText();
						}else {
							actMessage=confirmMessage.getText();
						}
					}
					
					System.out.println("mainMessage="+actMessage);
					setErrMsg(errMessage,actMessage,titleMsg, actTitle,"");	
					System.out.println("after message");
					
					
					Utility.simpleWait(2000);
				}
			}
			System.out.println("out");
			Log.addMessage("Security Questions Edited");
		}catch(Exception e) {
			Log.addMessage("Security Questions is not Edited");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Security Questions is not Edited");
		}
			
	}

	public void setErrMsg(String exRes, String mnMsg, String ttlMsg, String actTtl, String tstMsg) {
		try {
			if(exRes!="") {
				if(tstMsg!="") {
					actualRes = mnMsg;
				}else if(OKButton.isDisplayed()) {
					System.out.println("two");
					OKButton.click();
					
					actualRes = mnMsg;
					if(ttlMsg!="") {
						actTitle = actTtl;
						System.out.println("actTitle---="+actTitle+", expttl="+ttlMsg);
						Assert.assertEquals(actTitle, ttlMsg,"Please check the title validation message.");
					}
					System.out.println("actualres---="+actualRes);
					System.out.println("exRes---="+exRes);
				}
				System.out.println("in Assert");
				
				//below code to bypass the assert error.
				//confirmVerificationButton.click();
				Assert.assertEquals(actualRes, exRes,"Please check the validation message.");
			}
		}catch(Exception e) {
			e.printStackTrace();
			Assert.assertEquals(false, "Expected message is null.");
		}
	}
	
	/** 
	* Method Name: recoverSecurityQuestion(), 
	* This function is used to update the Security Question
	*/
	public void recoverSecurityQuestion(String qn1,String ans1, String errMessage, String titleMsg, String actlToastMsg, String iTitleMsg, String iMsg) {
		try {			
			if(device.equals("iOS")) {
				System.out.println("qn1="+qn1);
				if(qn1!="") {
					System.out.println("is not null="+ans1);
					enterQuestion1();
					answer1.click();
					if(!(answer1.getText()).equals("Answer")) {
						System.out.println("in="+answer1.getText());
						answer1.click();
						Thread.sleep(2000);
						selectAllMenu.click();
						answer1.clear();
					}
					System.out.println("ans1="+ans1);
					answer1.sendKeys(ans1);
				}
			}else {
				clickSecurityQn();
				selectSecurityQn(qn1);
				enterAnswer(ans1);
			}
			if(device.equals("iOS")) {
				clickNextIButton();
			}else {
				clickNextButton();
			}
			if(device.equals("android")) {
				toastMessage="";
				if(actlToastMsg!="") {
					Utility.simpleWait(2000);
					toastMessage=confirmToastMsg.getAttribute("name");
					System.out.println("in edit  qn1="+qn1+", ans1="+ans1+", toastMsg="+actlToastMsg+", toastMessage="+toastMessage);
					System.out.println("toastMessage="+toastMessage);
					setErrMsg(actlToastMsg, toastMessage, titleMsg, actTitle,"toast");	
				}else if(checkOkButton()) {//if(OKButton.isDisplayed()) {
					Utility.simpleWait(2000);
					System.out.println("in Question qn1="+qn1+", ans1="+ans1+", errMessage="+errMessage+", titleMsg="+titleMsg);
					System.out.println("in confirmVerificationButton oP="+errMessage);
					if(titleMsg!="") {
						actTitle=alertTitle.getText();
						actMessage=confirmMessage.getText();
					}else {
						/*if(device.equals("iOS")) {
							actMessage=confirmMessage.getText();
						}else {*/
							actMessage=confirmMessage.getText();
						//}
					}
					
					System.out.println("mainMessage="+actMessage);
					setErrMsg(errMessage,actMessage,titleMsg, actTitle,"");	
					System.out.println("after message");
					//OKButton.click();
					
					Utility.simpleWait(2000);
				}
			}else {
				Utility.simpleWait(2000);
				System.out.println("in Question qn1="+qn1+", ans1="+ans1+", errMessage="+errMessage+", titleMsg="+titleMsg);
				System.out.println("in confirmVerificationButton oP="+errMessage);
				if(iMsg!="") {
					if(iTitleMsg!="") {
						actTitle=alertTitle.getText();
						actMessage=confirmMessage.getText();
					}else {
						actMessage=alertTitle.getText();
					}
					System.out.println("mainMessage="+actMessage);
					setErrMsg(iMsg,actMessage,iTitleMsg, actTitle,"");	
					System.out.println("after message");
					//OKButton.click();
					Utility.simpleWait(2000);
				}
			}
			System.out.println("out");
			Log.addMessage("Security Questions Edited");
		}catch(Exception e) {
			Log.addMessage("Security Questions is not Edited");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Security Questions is not Edited");
		}
			
	}
	
	/** 
	* Method Name: validSecurityQuestion(), 
	* This function is used to update the Security Question
	*/
	public void validSecurityQuestion(String qn1,String ans1) {
		try {			
			if(device.equals("iOS")) {
				System.out.println("qn1="+qn1);
				if(qn1!="") {
					System.out.println("is not null="+ans1);
					enterQuestion1();
					answer1.click();
					if(!(answer1.getText()).equals("Answer")) {
						System.out.println("in="+answer1.getText());
						answer1.click();
						Thread.sleep(2000);
						selectAllMenu.click();
						answer1.clear();
					}
					System.out.println("ans1="+ans1);
					answer1.sendKeys(ans1);
				}
			}else {
				clickSecurityQn();
				selectSecurityQn(qn1);
				enterAnswer(ans1);
			}
			if(device.equals("iOS")) {
				clickNextIButton();
			}else {
				clickNextButton();
			}
			 Log.addMessage("Security Question entered");
		}catch(Exception e) {
			Log.addMessage("Failed to add security question");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to add security question");	
		}
	}
	
	/** 
	* Method Name: updateValidSecurityQuestion(), 
	* This function is used to update the Security Question
	*/
	public void updateValidSecurityQuestion(String qn1,String ans1,String qn2,String ans2,String qn3,String ans3) {
		try {	
			if(device.equals("iOS")) {
				System.out.println("qn1="+qn1);
				if(qn1!="") {
					System.out.println("is not null");
					enterQuestion1();
					enterAnswer1(ans1);
				}
			}else {
				clickChangeSecurityQn1();
				selectSecurityQn1(qn1);
				enterAnswer1(ans1);
			}
			
			if(device.equals("iOS")) {
				System.out.println("qn2="+qn2);
				if(qn2!="") {
					System.out.println("is not null");
					enterQuestion2();
					enterAnswer2(ans2);
				}
			}else {
				clickChangeSecurityQn2();
				selectSecurityQn2(qn2);
				enterAnswer2(ans2);
			}
			
			if(device.equals("iOS")) {
				System.out.println("qn3="+qn3);
				if(qn3!="") {
					System.out.println("is not null");
					enterQuestion3();
					enterAnswer3(ans3);
				}
			}else {
				clickChangeSecurityQn3();
				selectSecurityQn3(qn3);
				enterAnswer3(ans3);
			}
			//if(valType.equals("new") && device.equals("iOS")) {//added on 29-07-2020 regression
			if(device.equals("iOS")) {
				Utility.waitForElementToBeVisible(nextButton);
				nextButton.click();
			}else {
				clickNextButton();
			}
			System.out.println("out");
			Log.addMessage("Security Questions Edited");
		}catch(Exception e) {
			Log.addMessage("Security Questions is not Edited");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Security Questions is not Edited");
		}
			
	}
	
	public boolean checkOkButton() throws InterruptedException {
		try {
			if(device.equals("iOS")) {
				 Utility.waitForElementPresent(okBtn,appiumDriver);
			}else {
				 Utility.waitForElementPresent(okAnBtn,appiumDriver);
			}
		    okButtonPresent=true;
		    Log.addMessage("Ok button found, syncing in progress");
		    return okButtonPresent;
		}catch(NoSuchElementException e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to display Ok button");
			okButtonPresent=false;
			return okButtonPresent;
		}
	}
	//added on 01-07-2020-changed element on 08-07-2020 for rcvr scrty qn
	/** 
	* Method Name: clickBack(), 
	* This function is used to select Back option from the Name Page
	*/
		
	public void clickBack() {
		try {
			Utility.waitForElementToBeVisible(backBtn);
			Utility.waitForElementToBeClickable(backBtn);
			backBtn.click();
			Log.addMessage("Clicked Back Button");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click Back button");
			Assert.assertTrue(false, "Failed to click Back button");
		}
	}
	
	public void clickBackButton() {
		try {
			Utility.waitForElementToBeVisible(backButton);
			Utility.waitForElementToBeClickable(backButton);
			backButton.click();
			Log.addMessage("Clicked Back Button");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click Back button");
			Assert.assertTrue(false, "Failed to click Back button");
		}
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void enterAnswer(String ans) {
		try {
			Utility.waitForElementToBeVisible(rcvrAnswer);
			System.out.println("enterAnswer");
			rcvrAnswer.clear();
			rcvrAnswer.sendKeys(ans);
			Log.addMessage("Answer entered");
		}catch(Exception e) {
			Log.addMessage("Failed to enter answer");
			Assert.assertTrue(false, "Failed to enter answer");
		}
	}
	
	/** 
	* Method Name: clickOKButton(), 
	* This function is used to click OK Button
	*/
		
	public void clickOKButton() {
		try {			
			Utility.waitForElementToBeVisible(OKButton);
			Utility.waitForElementToBeClickable(OKButton);
			OKButton.click();	
			Log.addMessage("Clicked OK button in phone number page");
		}catch(Exception e) {
			Log.addMessage("Failed to click OK button in phone number page");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click OK button in phone number page");
		}
	}
	
	public void verifyUISecurityQuestion(String valType) {
		try {
			
			if(valType.equals("recover")) {//works with ios
				System.out.println("recover size=");
				Utility.waitForElementToBeVisible(rcvrQuestion);
				Log.addMessage("Question is displayed");
				Utility.waitForElementToBeVisible(rcvrAnswer);
				Log.addMessage("Answer text field is displayed");
				Utility.waitForElementToBeVisible(backButton);
				Log.addMessage("Back button is displayed");
				
			}else {
				Utility.waitForElementToBeVisible(question1);
				Log.addMessage("Question1 is displayed");
				Utility.waitForElementToBeVisible(answer1);
				Log.addMessage("Answer1 text field is displayed");
				Utility.waitForElementToBeVisible(question2);
				Log.addMessage("Question2 is displayed");
				Utility.waitForElementToBeVisible(answer2);
				Log.addMessage("Answer2 text field is displayed");
				Utility.waitForElementToBeVisible(question3);
				Log.addMessage("Question3 is displayed");
				Utility.waitForElementToBeVisible(answer3);
				Log.addMessage("Answer3 text field is displayed");
				if(device.equals("android")) {//added on 17-07-2020
					Utility.waitForElementToBeVisible(backBtn);
				}else {
					Utility.waitForElementToBeVisible(backButton);
				}
				Log.addMessage("Back button is displayed");
				
			}
			if(device.contentEquals("iOS") && valType.equals("recover")) {//added on 29-07-2020 regression
				Utility.waitForElementToBeVisible(nextIButton);
			}else {
				Utility.waitForElementToBeVisible(nextButton);
			}
			Log.addMessage("Submit button is displayed");
			Assert.assertTrue(true,"All elements displayed in change password page");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to display all elements in change password page");
			Assert.assertTrue(false, "Failed to display all elements in change password page");
		}
	}
	
	/** 
	* Method Name: enterAnswer1NextKey(), 
	* This function is used to enter next key in keyboard from the Security Question Page
	*/
	public void enterAnswer1NextKey() {
		try {
			/*if(device.equals("iOS")) {//added in accnt settings flow during regression for OS check
			question1.click();
			doneButton.click();	
			}*/
			Utility.waitForElementToBeVisible(answer1);
			
			answer1.click();
			answer1.clear();
			answer1.sendKeys("a");
			Log.addMessage("Phone verification code entered");
			if(device.equals("iOS")) {
				nextKeyboard.click();
			}else {
				JavascriptExecutor js = appiumDriver;
				Map<String, Object> params = new HashMap<>();
				params.put("action", "Next");
				params.put("element", answer1);
				js.executeScript("mobile: performEditorAction", params);
			}
			Log.addMessage("Clicked Next Button in keyboard");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click next button in keyboard");
			Assert.assertTrue(false, "Failed to click next button in keyboard");
		}
	}
	
	/** 
	* Method Name: enterAnswer2NextKey(), 
	* This function is used to next key in keyboard from the Security Question Page
	*/
	public void enterAnswer2NextKey() {
		try {
			/*if(device.equals("iOS")) {//added in accnt settings flow during regression for OS check
			question2.click();
			doneButton.click();	
			}*/
			Utility.waitForElementToBeVisible(answer2);
			answer2.click();
			answer2.clear();
			answer2.sendKeys("a");
			Log.addMessage("Phone verification code entered");
			
			if(device.equals("iOS")) {
				nextKeyboard.click();
			}else {
				JavascriptExecutor js = appiumDriver;
				Map<String, Object> params = new HashMap<>();
				params.put("action", "Next");
				params.put("element", answer2);
				js.executeScript("mobile: performEditorAction", params);
			}
			
			
			Log.addMessage("Clicked Next Button in keyboard");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click next button in keyboard");
			Assert.assertTrue(false, "Failed to click next button in keyboard");
		}
	}

	/** 
	* Method Name: enterAnswer3NextKey(), 
	* This function is used to next key in keyboard from the Security Question Page
	*/
	public void enterAnswer3NextKey() {
		try {
			/*if(device.equals("iOS")) {//added in accnt settings flow during regression for OS check
			question3.click();
			doneButton.click();	
			}*/
			Utility.waitForElementToBeVisible(answer3);
			answer3.click();
			answer3.clear();
			answer3.sendKeys("a");
			Log.addMessage("Phone verification code entered");
			if(device.equals("iOS")) {
				doneKeyboard.click();
			}else {
				JavascriptExecutor js = appiumDriver;
				Map<String, Object> params = new HashMap<>();
				params.put("action", "Done");
				params.put("element", answer3);
				js.executeScript("mobile: performEditorAction", params);
			}
			Log.addMessage("Clicked Done Button in keyboard");
		}catch(Exception e) {
			Log.addMessage(e.getMessage().toString());
			Log.addMessage("Failed to click done button in keyboard");
			Assert.assertTrue(false, "Failed to click done button in keyboard");
		}
	}

}

