package base;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import javax.mail.MessagingException;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.appium.java_client.AppiumDriver;
import io.restassured.RestAssured;
import utility.Log;
import utility.PropertyUtility;
import utility.ReadEmail;
import base.Constants;

public class Settings extends Constants{
	
	/*
	 * Function to be executed before executing any suite
	 */
	
	
	@SuppressWarnings("static-access")
	@Parameters ({"appType","device","browser","environment"})// String browser, String environment//comment for bvt
	@BeforeSuite
	public void beforeClassInBase(String appType, String device,String browser, String environment) throws MessagingException {
//		this.environment = sysProps.getProperty("environment");
//		this.appType = sysProps.getProperty("appType");
//		sysProps.setProperty("logfilename", suite);
		
		this.appType=appType;
		this.device=device;
		this.browser=browser;//comment for bvt
		this.environment=environment;//comment for bvt
		
		sysProps.setProperty("logfilename", "halo");
		
		DOMConfigurator.configure("Log4j/log4j.xml");
		//emailUtils = new ReadEmail(PropertyUtility.getProperty("email.address"), PropertyUtility.getProperty("email.password"), PropertyUtility.getProperty("email.server"), PropertyUtility.getProperty("email.protocol"),993,ReadEmail.EmailFolder.INBOX);
		subject = PropertyUtility.getProperty("phoneSub");
		application = appType;
		try {
			if (appType.equals("web")) 
				webSettings();
			else if (appType.equals("device")) 
				deviceSettings();
			else  if (appType.equals("API")) {
				APISettings();
			}
			else
				webSettings();
		}catch (Exception e){
				e.printStackTrace();
		}
	}
	
	 /*
	  * Function for API Settings
	  */
	
	public static void APISettings() throws IOException {
		 file = new File(System.getProperty("user.dir")+"/loadTestReports/LoadTest.csv"); 
		 if (file.exists()) {
		     file.delete(); 
	     }
		file.createNewFile();
		data.add(new String[] { "API Name", "Start Time", "End Time" ,"Total Time", "Result","Status Code"});
		String device = sysProps.getProperty("device");
		
		if (environment.equals("production")) {
			env = "production";
			site = PropertyUtility.getProperty("prodUrl");
			
			if(device.equals("mobile")) {
				RestAssured.baseURI = PropertyUtility.getProperty("ProdMobileBaseUrl");
				datafile = System.getProperty("user.dir") + PropertyUtility.getProperty("MobileAPIList");
				url = PropertyUtility.getProperty("ProdMobileBaseUrl");
			}else{
				RestAssured.baseURI = PropertyUtility.getProperty("ProdWebBaseUrl");
				datafile = System.getProperty("user.dir") + PropertyUtility.getProperty("WebAPIList");
				url = PropertyUtility.getProperty("ProdWebBaseUrl");
			}
		}
		
		else if(environment.equals("beta")) {
			env = "beta";
			site = PropertyUtility.getProperty("betaUrl");
			
			if(device.equals("mobile")) {
				RestAssured.baseURI = PropertyUtility.getProperty("BetaMobileBaseUrl");
				datafile = System.getProperty("user.dir") + PropertyUtility.getProperty("MobileAPIList");
				url = PropertyUtility.getProperty("BetaMobileBaseUrl");	
			}else{
				RestAssured.baseURI=PropertyUtility.getProperty("BetaWebBaseUrl");
				datafile = System.getProperty("user.dir") + PropertyUtility.getProperty("WebAPIList");
				url = PropertyUtility.getProperty("BetaWebBaseUrl");
			}
		}
		
		else if(environment.equals(" 24x7")) {
			env = "24x7";
			site = PropertyUtility.getProperty("24x7Url");
			if(device.equals("mobile")) {
				RestAssured.baseURI = PropertyUtility.getProperty("24x7MobileBaseUrl");
				datafile = System.getProperty("user.dir") + PropertyUtility.getProperty("MobileAPIList");
				url = PropertyUtility.getProperty("24x7MobileBaseUrl");
			}else{
				RestAssured.baseURI=PropertyUtility.getProperty("24x7WebBaseUrl");
				datafile = System.getProperty("user.dir") + PropertyUtility.getProperty("WebAPIList");
				url=PropertyUtility.getProperty("24x7WebBaseUrl");
			}
		}
		
		else if(environment.equals("QA")) {
			env="QA";
			site = PropertyUtility.getProperty("QAUrl");
			if(device.equals("mobile")) {
				RestAssured.baseURI=PropertyUtility.getProperty("QAMobileBaseUrl");
				datafile = System.getProperty("user.dir") + PropertyUtility.getProperty("MobileAPIList");
				url=PropertyUtility.getProperty("QAMobileBaseUrl");
			}else{
				RestAssured.baseURI=PropertyUtility.getProperty("QAWebBaseUrl");
				datafile = System.getProperty("user.dir") + PropertyUtility.getProperty("WebAPIList");
				System.out.println("test data is "+datafile);
				url=PropertyUtility.getProperty("QAWebBaseUrl");
			}
		}
		else if(environment.equals("integration")) {
			env="integration";
			site = PropertyUtility.getProperty("integrationUrl");
			if(device.equals("mobile")) {
				RestAssured.baseURI=PropertyUtility.getProperty("IntMobileBaseUrl");
				datafile = System.getProperty("user.dir") + PropertyUtility.getProperty("MobileAPIList");
				url=PropertyUtility.getProperty("IntMobileBaseUrl");
			}else{
				RestAssured.baseURI=PropertyUtility.getProperty("IntWebBaseUrl");
				datafile = System.getProperty("user.dir") + PropertyUtility.getProperty("WebAPIList");
				url=PropertyUtility.getProperty("IntWebBaseUrl");
			}
		}
		else if(environment.equals("development")) {
			env="development";
			site = PropertyUtility.getProperty("developmentUrl");
			if(device.equals("mobile")) {
				RestAssured.baseURI=PropertyUtility.getProperty("DevMobileBaseUrl");
				datafile = System.getProperty("user.dir") + PropertyUtility.getProperty("MobileAPIList");
				url=PropertyUtility.getProperty("DevMobileBaseUrl");
			}else{
				RestAssured.baseURI=PropertyUtility.getProperty("DevWebBaseUrl");
				datafile = System.getProperty("user.dir") + PropertyUtility.getProperty("WebAPIList");
				url=PropertyUtility.getProperty("DevWebBaseUrl");
			}
		}
		else {
				site = PropertyUtility.getProperty("QAUrl");
				RestAssured.baseURI=PropertyUtility.getProperty("QAWebBaseUrl");
				datafile = System.getProperty("user.dir") + PropertyUtility.getProperty("WebAPIList");
				env="QA";
				url=PropertyUtility.getProperty("QAWebBaseUrl");
				System.out.println("test data is "+datafile);
		}
		contentType="application/json";
	}
			
	/*
	 * Function for Device Settings to redirect according to the type of application
	 */
				
	public static void deviceSettings() throws InterruptedException, IOException {
		//this.device = sysProps.getProperty("device");
		if (device.equals("iOS"))
			iOSSettings();
		else if (device.equals("android")) {
			System.out.println("in android");
			androidSettings();
		}else
			iOSSettings();
	}
	
	/*
	 * Function for iOS Settings
	 */
	
	public static void iOSSettings() throws InterruptedException, IOException {
		//stopServer();
		startServer();//uncommented for executing appium server on its own
	    iOSCapabilities.setCapability("automationName",PropertyUtility.getProperty("iOSAUTOMATION_NAME"));
		iOSCapabilities.setCapability("platformName","iOS");
		iOSCapabilities.setCapability("platformVersion", PropertyUtility.getProperty("iOSVersion"));
		iOSCapabilities.setCapability("deviceName", PropertyUtility.getProperty("iOSDeviceName"));
		iOSCapabilities.setCapability("udid", PropertyUtility.getProperty("UDID"));
		//iOSCapabilities.setCapability("app", System.getProperty("user.dir")+PropertyUtility.getProperty("iOSAppPath"));
		iOSCapabilities.setCapability("bundleId", PropertyUtility.getProperty("iOSBundleId"));
		iOSCapabilities.setCapability("updatedWDABundleId", PropertyUtility.getProperty("UpdatedBundleID"));
		iOSCapabilities.setCapability("noReset", true);
		//iOSCapabilities.setCapability("newCommandTimeout", "60");
		iOSCapabilities.setCapability("newCommandTimeout", 0);
		try {
			driver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),iOSCapabilities);//:4723 is default port appium -p 4725
		}catch(Exception e) {
			Log.addMessage("Appium Server not started. Plesae refer error log for more details");
		}
	
	}
	
	/*
	 * Function for Android Settings
	 */
	
	public static void androidSettings() throws IOException {
		
		//stopServer();
		System.out.println("in1");
		startServer();//uncommented for executing appium server on its own	
		System.out.println("in2");
		androidCapabilities.setCapability("automationName",PropertyUtility.getProperty("AndroidAutomationName"));
	    androidCapabilities.setCapability("platformName","Android");
		androidCapabilities.setCapability("platformVersion", PropertyUtility.getProperty("AndroidPlatformVersion"));
		androidCapabilities.setCapability("deviceName", PropertyUtility.getProperty("AndroidDeviceName"));
		//androidCapabilities.setCapability("app", System.getProperty("user.dir")+PropertyUtility.getProperty("AndroidAppPath"));
		androidCapabilities.setCapability("appPackage", PropertyUtility.getProperty("AndroidAppPackage"));
		androidCapabilities.setCapability("appActivity", PropertyUtility.getProperty("AndroidAppActivity"));;
		androidCapabilities.setCapability("noReset", true);
		androidCapabilities.setCapability("newCommandTimeout", 0);//edited from 60 sec to 90 for wifi pairing test on 08-05-2020
		try {
			driver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), androidCapabilities);
		}catch(Exception e) {
			Log.addMessage("Appium Server not started. Plesae refer error log for more details");
		}
		
	}
		
	/*
	 * Function for starting the Appium Server
	 */
	
	public static void startServer() throws IOException {	
		Log.addMessage("Starting the Appium Server");
		CommandLine command = new CommandLine("/usr/local/Cellar/node/12.6.0/bin/node");
		command.addArgument("/usr/local/lib/node_modules/appium/build/lib/main.js",false);
		command.addArgument("--address", false);
		command.addArgument(ip);
		command.addArgument("--port", false);
		command.addArgument("4723");
		command.addArgument("--no-reset", true);
		command.addArgument("--native-instruments-lib", true);
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		try {
			executor.execute(command, resultHandler);
			Thread.sleep(5000);
			Log.addMessage("Appium server started.");
		}catch (InterruptedException e) {
			Log.addIntExceptionMessage("Appium server not started",e);
			}		
	}

	/*
	 * Function for stopping the Appium Server
	 */
	
	public static void stopServer() throws InterruptedException {
		String[] command = { "/usr/bin/killall", "-KILL", "node" };
		try {
			Log.addMessage("Appium Server Stopped!!!");
			Runtime.getRuntime().exec(command);
			Thread.sleep(4000);
			Log.addMessage("Appium server stopped.");
		}catch (IOException e) {
			Log.addIOExceptionMessage("Appium server encountered an error ", e);
			}
	}		
	
	/*
	 * Function for Web Settings
	 */
	
	public static void webSettings() {
		//String browser = sysProps.getProperty("browser");
		if (browser.equals("chrome")) {
			System.out.println("chrome");
			chromeSettings();
		}else if (browser.equals("firefox")) 
			fireFoxSettings();
		else if (browser.equals("safari")) 
			safariSettings();
		else if (browser.equals("IE")) 
			IESettings();
		else 
		 	chromeSettings();
		}
	
	/*
	 * Function for Chrome Settings if Google chrome is chosen as the web browser
	 */
	
	public static void chromeSettings() {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeDriverService service = null;
		System.out.println("in chrome settings");
		if(System.getProperty("os.name").startsWith("Mac")) {
			System.out.println("mac");
		service = new ChromeDriverService.Builder()
		                            .usingDriverExecutable(new File(userDirectory+"/Driver/chromedriver"))
		                            .usingAnyFreePort()
		                            .build();
		}else if(System.getProperty("os.name").startsWith("Windows")) {
			service = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File(userDirectory+"/Driver/chromedriver.exe"))
                    .usingAnyFreePort()
                    .build();
		}
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		options.addArguments("--start-maximized");
		options.merge(capabilities);    
		driver = new ChromeDriver(service, options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("mac");
	}
	
	
	/*
	 * Function for Firefox Settings if Mozilla Firefox is chosen as the web browser
	 */
	
	public static void fireFoxSettings() {
		if(System.getProperty("os.name").startsWith("Mac"))
			System.setProperty("webdriver.gecko.driver",userDirectory+"/Driver/geckodriver");
		else if(System.getProperty("os.name").startsWith("Windows"))
			System.setProperty("webdriver.gecko.driver",userDirectory+"/Driver/geckodriver.exe");
		driver = new FirefoxDriver();		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement html = driver.findElement(By.tagName("html"));
		html.sendKeys(Keys.chord(Keys.CONTROL, "0"));
		driver.manage().window().maximize();
		}
	
	/*
	 * Function for Safari Settings if Safari is chosen as the web browser
	 */
	
	public static void safariSettings() {
		webCapabilities = new DesiredCapabilities();
		webCapabilities.setPlatform(Platform.MAC);
		driver = new SafariDriver();
		driver.manage().window().maximize();
		}
	
	/*
	 * Function for Internet Explorer Settings if Internet Explorer is chosen as the web browser
	 */
	
	public static void IESettings() {
		webCapabilities = new DesiredCapabilities();
		webCapabilities.setPlatform(Platform.WINDOWS);
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		}
	
	/*
	 * Function to open the url
	 */
	
	public void open(String url) {
		driver.get(url);
	}
	
	/*
	 * Function to open the url
	 */
	
	public void openWebUrl(String url, WebDriver driver) {
		driver.get(url);
	}
				
	/*
	 * Function for setting the url based on the environment
	 */
	
	public static String getPageURL() {
		if (environment.equals("production")) {
			url = PropertyUtility.getProperty("prodUrl");
			env="Production";
			testdata="Production";
			}
		else if(environment.equals("QA")) {
			url = PropertyUtility.getProperty("QAUrl");
			env="QA";
			testdata="QA";	
			
			}
		else if(environment.equals("QA2")) {
			url = PropertyUtility.getProperty("QA2Url");
			env="QA2";
			testdata="QA2";	
			
			}
		else if (environment.equals("integration")) {
			url = PropertyUtility.getProperty("intUrl");
			env="Integration";
			testdata="Integration";
			}
		else if (environment.equals("development")) {
			url = PropertyUtility.getProperty("devUrl");
			env="Development";
			testdata="Development";
			}
		else if (environment.equals("24x7")) {
			url = PropertyUtility.getProperty("24x7Url");
			env="24x7";
			testdata="24x7";
			subject=PropertyUtility.getProperty("phoneSub24x7");
			}
		else {
			url = PropertyUtility.getProperty("QAUrl");
			env="QA";
			testdata="QA";
		}
		return(url);
	}
				
				
	/*
	 * CODE for Sitecheck
	 */
				
	public int getStatusCode(String pageUrl) throws Exception  {
		URL url = new URL(pageUrl);
		HttpURLConnection huc = (HttpURLConnection)url.openConnection();
		huc.setRequestMethod("GET");
		huc.connect();
		return huc.getResponseCode();
	}
		
	/*
	 * Function to be executed after executing the suite
	 */
	
	@AfterSuite
	/**
	 * To ensure that the driver has been closed or not
	 */
	public void tearDown() throws InterruptedException {
		if (application.equals("API")) {
			
		}else {
		    boolean hasQuit = (driver.toString().contains("null")) ? true : false;
		    if (hasQuit == false) {
			driver.quit();
			//stopServer();//commented on 22-Apr-21
		}
	}
	}
}

	
	

	
