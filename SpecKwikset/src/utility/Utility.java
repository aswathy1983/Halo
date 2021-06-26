package utility;

import java.text.SimpleDateFormat;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import javax.imageio.ImageIO;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.opencsv.CSVWriter;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import pages.portal.ChooseVerificationMethodPage;
import pages.portal.EnterCodePage;
import pages.portal.LoginPage;

import static java.time.Duration.ofSeconds;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Utility extends Settings{
	
	
	static WebDriverWait wait = new WebDriverWait(driver, 30);
	
	/*
	 * Method to wait for an element 
	 */
	public static  void waitForElementToBeVisible( WebElement element){
	    wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static  void waitForElementToBeVisible1(MobileElement element, WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		 wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static  void waitForElementToBeClickable1(MobileElement element, WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/*
	 * Method to wait for an element by Element to be Clickable
	 */
	public static void waitForElementToBeClickable(WebElement element){
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/*
	 * Method to wait for an element Present
	 */
	public static void waitForPresenceOfElement(String locator){
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}
	
	/*
	 * Method to wait for an element 
	 */
	public static  void waitForElementToBePresent(MobileElement element, WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 40);
		System.out.println("in wait");
	    wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static  void waitForElementNotPresent(MobileElement element, WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 40);
		System.out.println("in wait");
	    //wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	/*
	 * Method to wait for an element 
	 */
	public static  void waitForElementPresent(By element, WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
	/*
	 * Method to wait for an element 
	 */
	public static  void waitForElementPresentBtry(By element, WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
	/*
	 * Method to wait for an element by Element to be Clickable
	 */
	public static void waitForElementClickable(By element, WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 40);
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/*
	 * Simple wait
	 */
	public static void simpleWait(int milliSeconds) throws InterruptedException{
	  Thread.sleep(milliSeconds);
	}
	
	/*
	 * Method to wait for a text present in an element 
	*/
	
	public static void waitForTextToBePresent(MobileElement element, String text) {
		  WebDriverWait wait = new WebDriverWait(driver, 50);
	      wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	
	public static void waitForTextToBePresentBy(String xpath, String txtName) {
		  WebDriverWait wait = new WebDriverWait(driver, 40);
	      wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(""+xpath+""), txtName));
	}
	
	/*
	 * Method to wait for a text not present in an element 
	*/
	
	public static void waitForTextNotPresent(String xpath) {
		 WebDriverWait wait = new WebDriverWait(driver, 60);
		 wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(""+xpath+""))));
	}
	
	public static void openNewTab() {
	    ((JavascriptExecutor)driver).executeScript("window.open('about:blank','_blank');");
	}
	
	/*
	 * Method to scroll to an element of a page
    */
	
	public void scrollingToElementofAPage(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
	}

	/*
	 * Method to scroll to an element
	 */
	
	 public void scrollTo(WebDriver driver, WebElement element) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
	    }
	 
   /*
	* Method to scroll to bottom of the page
	*/
	 
	 public void scrollToBottom(WebDriver driver) {
	        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    }
	
	/*
	 * Method to accept Alert
	 */
	
	 public static synchronized void acceptAlert( WebDriver driver){
	    WebDriverWait wait = new WebDriverWait(driver, 5);
	    wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	/*
	 * Scrolling the page down
	 */
	
	 public static void scrollDown(IOSDriver<?> driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "down");
		js.executeScript("mobile: scroll", scrollObject);
	}
	
	/*
	 * Scrolling the page up
	 */
	
	 public static void scrollUp(IOSDriver<?> driver) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	HashMap<String, String> scrollObject = new HashMap<String, String>();
	scrollObject.put("direction", "up");
	js.executeScript("mobile: scroll", scrollObject);
	}
	
	
	/*
	 * Swiping the page up
	 */
	public static void swipeUp(IOSDriver<?> driver,  MobileElement FromElement,MobileElement ToElement) {
		
		Point startLocation=FromElement.getLocation();
		Point endLocation=ToElement.getLocation();
		int startx=startLocation.getX();
		int starty=startLocation.getY();
		int endx=endLocation.getX();
		int endy=endLocation.getY();
		JavascriptExecutor js = driver;
		Map<String, Object> params = new HashMap<>();
		params.put("duration", 1.0);
		params.put("fromX", startx);
		params.put("fromY", starty);
		params.put("toX", endx);
		params.put("toY", endy);
		js.executeScript("mobile: dragFromToForDuration", params);
	}
	
	
	/*
	 * Swiping the element left
	 */

	public static void swipeLeft(IOSDriver<?> driver,  MobileElement swipeElement) {
		JavascriptExecutor js = driver;
		Map<String, Object> params = new HashMap<>();
		params.put("direction", "left");
		params.put("element", swipeElement.getId());
		js.executeScript("mobile: swipe", params);
	}

	/*
	 * Swiping the page up in Android
	 */
	@SuppressWarnings("rawtypes")
	public static void swipeVertical(AppiumDriver<MobileElement> driver, double startPercentage, double finalPercentage, int duration) {
		try {
			
			TouchAction action = new TouchAction(driver);
			Dimension size = driver.manage().window().getSize();
			int width=(int)(size.width/2);
			int startPoint=(int)(size.getHeight()*startPercentage);
			int endPoint=(int)(size.getHeight()*finalPercentage);
			//new TouchAction(driver).longPress(width,startPoint).waitAction(Duration.ofMillis(duration).moveTo(width,endPoint).release().perform());
			action.press(PointOption.point(width, startPoint))
			//.waitAction(Duration.ofMillis(duration))
            .moveTo(PointOption.point(width, endPoint)).release().perform();

			/*TouchActions touch = new TouchActions(driver);
			
			touch.longPress(driver.findElement(By.id("elementIontop")));
			touch.wait(2000);
			touch.moveToElement(driver.findElement(By.id("elementlast")));
			touch.release().perform();*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//added on 17-06-2020
	@SuppressWarnings("rawtypes")
	public static void verticalSwipe(AppiumDriver<MobileElement> driver) {
		try {
			TouchAction action = new TouchAction(appiumDriver); 
			action.press(PointOption.point(115, 900)).waitAction(WaitOptions.waitOptions(ofSeconds(2)))
			                .moveTo(PointOption.point(115, 200)).release().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * Clicking the Keyboard key for Android added on 28-05-2020
	 */

	public static void clickEnterKey(String keyName, MobileElement enterElement) {
		JavascriptExecutor js = appiumDriver;
		Map<String, Object> params = new HashMap<>();
		params.put("action", keyName);
		params.put("element", enterElement);
		js.executeScript("mobile: performEditorAction", params);
	}

	
	/*
	 * Random String generator
	 */

	static final String AB = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static Random rnd = new Random();
	static String uNameAppend;

	public static String randomString(int len) {
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
		sb.append(AB.charAt(rnd.nextInt(AB.length())));
		Log.addMessage(sb.toString());
		uNameAppend = sb.toString();
		return sb.toString();
	}

	/*
	 * Method to check for alerts
	 */
	
	public static void checkForAlerts() {
		Log.addMessage("Looking for open alerts");
		 try{
			 IOSElement ok = (IOSElement)
			 driver.findElement(By.name("icon dismiss x white"));
			 if(ok.isDisplayed()){
			 Log.addMessage("Alert window is displayed");
			 ok.click();
			 }
		 	}catch(Exception e){
			 Log.addMessage("Alert window is not displayed");
		 	}
	}
	
	/*
	 * Method to check for an element present
	 */
	
	public static Boolean isElementPresent(String element) {
		 Log.addMessage("Looking for element present");
		 try{
			 System.out.println("element="+element);
			 appiumDriver.findElement(By.xpath(element));
			 return true;
		 	}catch(Exception e){
			 Log.addMessage("Element is not displayed");
			 System.out.println("element in catch");
			 return false;
		 	}
	}
	

	/*
	 * Return todays date in given format
	 */
	
	public static String getTodaysDate(String format) {
		return new SimpleDateFormat(format).format(new Date());
	}

	/*
	 * Return test log
	 */
	
	public static String getTestLog(String testname) {
		try {
			String filePathName=System.getProperty("user.dir")+"/Log4j/Logs/halo.log";
			File file = new File(filePathName);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			Boolean setFlag = false;
			int i = 0;
			while ((line = bufferedReader.readLine()) != null) {
				if (line.trim().equals(testname)) {
					setFlag = true;
				}
				if (setFlag.equals(true)) {
					if (("-E---N---D-").equals(line.trim())) {
						break;
					}
					i++;
					if (i > 3) {
						stringBuffer.append(line);
						stringBuffer.append("\n");
					}
				}
			}
			fileReader.close();
			return stringBuffer.toString();
		} catch (IOException e) {
			return "Logging failed!" + e;
		}
	}
	
	/*
	 * Customize Report
	 */
	
	public static void customiseReport() {			
		try{		
			File readFile = new File(System.getProperty("user.dir")+"/test-output-extent/"+projectName+"_"+suite+"_Report.html");
			FileReader fileReader = new FileReader(readFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String textHtml = "";
			String line;
			
			while ((line = bufferedReader.readLine()) != null) {
				textHtml = textHtml.concat(line);
			}
			textHtml = textHtml.replace("ExtentReports 2.0", projectName);
			textHtml = textHtml.replace("ExtentReports", projectName);
			textHtml = textHtml.replace("logo-content", "logo-content_"+projectName);
			textHtml = textHtml.replace("http://extentreports.relevantcodes.com", "https://"+projectName+".com/");
			textHtml = textHtml.replace("v2.41.1", " ");
			
			textHtml = textHtml.replaceAll("</body></html>", 
					"<script>"
					+ "document.getElementById(\"clear-filters\").style.display = \"none\";"
					+ "document.getElementById(\"enableDashboard\").style.display = \"none\";"
					+ "document.getElementById(\"refreshCharts\").style.display = \"none\";"
					+ "document.getElementsByClassName(\"step-filters right\")[0].style.display=\"none\";"	
					+ "</script>"
					+ "</body></html>");
						
			fileReader.close();
			
			File writeFile = new File(System.getProperty("user.dir")+"/test-output-extent/"+projectName+"_"+suite+"_Report.html");
			FileWriter fileWriter = new FileWriter(writeFile.getAbsoluteFile());
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(textHtml);
			bufferedWriter.close();			
			} 
		catch (IOException e) {
				System.out.println(e);
			}
	}
	
	/*
	 * Method to encode an image file to Base64 binary format
	 */
	
	public static String encodeFileToBase64Binary(File file){
			String encodedfile = null;
			try {
				FileInputStream fileInputStreamReader = new FileInputStream(file);
				byte[] bytes = new byte[(int)file.length()];
				fileInputStreamReader.read(bytes);
				encodedfile = new String(Base64.encodeBase64(bytes), "UTF-8");
				fileInputStreamReader.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			return encodedfile;
		}
		
	/*
	 * Method to resize image
	 */
	
		public static File imageResizer(String inputImagePath,String outputImagePath, double percent) throws IOException {
			File inputFile = new File(inputImagePath);
		    BufferedImage inputImage = ImageIO.read(inputFile);
		    int scaledWidth = (int) (inputImage.getWidth() * percent);
		    int scaledHeight = (int) (inputImage.getHeight() * percent);
		    BufferedImage outputImage = new BufferedImage(scaledWidth,scaledHeight, inputImage.getType());
		    Graphics2D g2d = outputImage.createGraphics();
		    g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
		    g2d.dispose();
		    String formatName = outputImagePath.substring(outputImagePath.lastIndexOf(".") + 1);
		    ImageIO.write(outputImage, formatName, new File(outputImagePath));
		    return new File(outputImagePath);
		}
		
	/*
	 * Method to get final screenshot of the issue
	 */
		
		public static String finalScreenShot(String screenShotHtml,String encodedScreenShot) {
			screenShotHtml = screenShotHtml.replaceAll("<a[^>]*>", "");
			screenShotHtml = screenShotHtml.replaceAll("</a>", "");
			String[] parts = screenShotHtml.split("src='");
			String part1 = parts[0]; 
			String part2 = parts[1]; 
			String[] part3 = part2.split("' /");
			part3[0] = encodedScreenShot;
			String screenshot = part1+"src='data:image/png;base64,"+ part3[0]+"' /"+part3[1];
			return screenshot;
		}	
		
   
		
	public static void waitForPageToLoad() throws InterruptedException {

		 ExpectedCondition<Boolean> pageLoadCondition = new
	                ExpectedCondition<Boolean>() {
	                    public Boolean apply(WebDriver driver) {
	                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	                    }
	                };	
	                try {
	                	 WebDriverWait wait = new WebDriverWait(driver, 60);
	     		         wait.until(pageLoadCondition);
	                }catch(Throwable error) {
	                    Assert.fail("Timeout waiting for Page Load Request to complete.");
	                }
	       
	}
		
	public static void clickAction(WebDriver driver,WebElement element)	{
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();	
	}
	
	
	public static void generateCSVReport(List<String[]> data,File report) { 
		try { 
	    	//file.createNewFile();
	        FileWriter outputfile = new FileWriter(report); 
	        CSVWriter writer = new CSVWriter(outputfile); 
	        writer.writeAll(data); 
	        writer.close(); 
	    } 
	    catch (IOException e) { 
	        e.printStackTrace(); 
	    } 
	}
	
	public static String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH.mm.ss");
		Calendar cal = Calendar.getInstance();
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		return sdf.format(cal.getTime());
	}




/*
 * Method to check for popups/alerts and accept in android app
 */
public static void checkIfAlertIsPresentAndAccept(AppiumDriver<MobileElement> appiumDriver) {
	Log.addMessage("Checking if alert is present");
	try {
		Alert a = new WebDriverWait(appiumDriver, 10).until(ExpectedConditions.alertIsPresent());
		if(a!=null){
           Log.addMessage("Alert is present");
           driver.switchTo().alert().accept();
           Log.addMessage("Accepted the alert");	
        }else{
            throw new Throwable();
        }
	    
	    } catch (Throwable e) {
	    	Log.addMessage("Alert  is not displayed");
	    	System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Alert not present or couldn't accept the alert");
	    }
}

/*
* Method to login to Consumer Portal
*/
	
	public static void userlogin(String email,String password) throws InterruptedException {
		LoginPage lp=new LoginPage(driver);
		ChooseVerificationMethodPage cv=new ChooseVerificationMethodPage(driver);
		EnterCodePage ep=new EnterCodePage(driver);
		lp.userLogin(email, password);
		cv.clickEmailButton();
		cv.clickSendCodeButton();
		ep.enterCode();
		Utility.simpleWait(4000);
	}


}
