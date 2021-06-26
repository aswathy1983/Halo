package utility;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import base.Settings;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class APICommonFunctions extends Settings{
	
	public static StringBuilder finalCode = null;
	public static String stringfinalCode, method, authorization;;
	public static JSONObject json, message, params, response, requestHeaders;
	public String code;
	public  String Eaddress;
	public  String Pwd;
	public int i=0;
	public ArrayList<String> authToken = new ArrayList<String>();

	
	
	 public static boolean isEmailValid(String Body) throws ParseException {
		 String email=elementExtractor(Body,"Email");
	     String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
	                            "[a-zA-Z0-9_+&*-]+)*@" +
	                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
	                            "A-Z]{2,7}$";
	                             
	        Pattern pat = Pattern.compile(emailRegex);
	        if (email == null)
	            return false;
	        return pat.matcher(email).matches();
	    }
	 
	 public static JSONObject jsonSchemaValidator(String body) throws ParseException {
		 try{
			 	Object obj1 = new JsonParser().parse(body);
			 	JSONObject jo1 = (JSONObject) obj1;
		  		return jo1;
		  		} 
		  		catch(JsonSyntaxException jse){
		  		System.out.println("Not a valid Json String:"+jse.getMessage());
		  		return null;
		  		}
	 }
	 
	 public static void responseValidator(Response resp,String response) {
	 	try {
	 		Assert.assertEquals(resp.getBody().asString(), response,"Response is verified");
	    	}
	 	catch(Exception e) {
	    		Log.addMessage("Response received is: "+resp.getBody().asString());
	    		errorResponseValidator(resp.getBody().asString());
	    	}
	 }
	 
	 
	 public static void responseValidator1(Response resp,JSONObject response) {
		 	try {
		 		Assert.assertEquals(resp.getBody().asString(), response,"Response is verified");
		 		JSONArray jsonarr_1 = (JSONArray) response.get("$");
		 		List<HashMap<String,Object>>keylist=resp.jsonPath().getList("$");
		 		for(int i=0;i<keylist.size();i++) {
		 			Assert.assertEquals(keylist.get(i),jsonarr_1.get(i),"Key and values are verified.");
		 		}
		    	}
		 	catch(Exception e) {
		    		Log.addMessage("Response received is: "+resp.getBody().asString());
		    		errorResponseValidator(resp.getBody().asString());
		    	}
		 }
	 
	 public static String elementExtractor(String body, String value) throws ParseException {
		 try {
			 JSONObject jo=jsonSchemaValidator(body);
			 jo.toString();
			 String element= String.valueOf(jo.get(value));
			 return element;
		 }
		 catch(Exception e) {
			 Log.addMessage("Field not found");
			 Assert.assertTrue(false, "");
			 return null;
		 }
	 }
	 
	 
	 public static void checkElementLength(String body, String value,int minSize,int maxSize) {
		try {
			String element=elementExtractor(body,value);
			Assert.assertTrue(element.length()>minSize&&element.length()<maxSize, "element is within limits");	
			}
		catch(Exception e) {
			 Log.addMessage("Element is not within length constraints");
			 Assert.assertTrue(false, "Character limit exceeded or below minimum");
			 }
		 }
	 
	 public static void caseCheck(String body) { 
		 try {
			 char[] charArray = body.toCharArray();
		      for(char letter:charArray){
		            Assert.assertTrue( !Character.isLowerCase(letter ),"All keys are not lowercase");
		        }
		 	 }
		  catch(Exception e) {
			  Log.addMessage("All the keys in payload are not lowercase");
		    	  Assert.assertTrue(false, "");
		      }  
		 }
	 
	 public static void mandatoryFieldCheck(String body, String field[]) {
		 
	 }
	 
	 public static void validateStatusCode(int actualStatus, int expectedStatus) {
		 try {
			 Assert.assertEquals(actualStatus, expectedStatus,"Status code is verified");
		 }
		 catch(Exception e) {
			 if (actualStatus != 200) {
				if(String.valueOf(actualStatus).contains("4")) {
					Log.addMessage("OOPs...User errors!!!");
				}else if(String.valueOf(actualStatus).contains("5")){
						Log.addMessage("Server errors!!!");
				 }else {
						Log.addMessage("OOPs...Got some other errors!!!");
				  }
			}
	      }
	   }
	 
	 public static void errorResponseValidator(String resp) {
		 
		 if (resp == "{\"error\":{\"code\":\"BAD_ARGUMENT\",\"target\":\"VerifyCode\"}}") {
			 Log.addMessage("Field validation error. Please try again");
			 Assert.assertTrue(false);
		 }else if (resp == "{\"error\":{\"code\":\"FAILED\",\"target\":\"VerifyCode\"}}") {
			 Log.addMessage("Request failed. Please try again");
			 Assert.assertTrue(false);
		 }else if (resp =="{\"error\":{\"code\":\"CODE_NOT_FOUND\",\"target\":\"VerifyCode\"}}") {
			 Log.addMessage("Code not found. Please try again");
			 Assert.assertTrue(false);
		 }else if(resp == "{\"error\":{\"code\":\"CODE_EXPIRED\",\"target\":\"VerifyCode\"}}") {
			 Log.addMessage("Code expired. Please generate another code");
			 Assert.assertTrue(false);
		 }else if (resp == "{\"error\":{\"code\":\"CODE_OLDER\",\"target\":\"VerifyCode\"}}") {
			 Log.addMessage("Code is older than 24 hours. Please generate another code");
			 Assert.assertTrue(false);
		 }	 
	 }
	 
	 
	 public  String tokenRetreival(String PUsername, String PPassword, String GUsername, String Gpassword, int count) throws Exception {
	    String bearerToken=DownloadPage(site, PUsername, PPassword, GUsername, Gpassword, count); 
	    return bearerToken;
	 }
		
	 
	@SuppressWarnings({ "static-access", "deprecation", "unused" })
	public  String DownloadPage(String url, String username, String password, String email, String pwd, int count) throws Exception{
		ChromeDriver drivernew = null;
		try{
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			LoggingPreferences logPrefs = new LoggingPreferences();
			logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
			cap.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
			//System.setProperty("webdriver.chrome.driver", "/Users/Spectrum/Documents/SAmpleTry/MyRepo/repository_qb/QTAF/Driver/chromedriver");
			if(System.getProperty("os.name").startsWith("Mac"))
				System.setProperty("webdriver.chrome.driver",userDirectory+"/Driver/chromedriver");
			else if(System.getProperty("os.name").startsWith("Windows"))
				System.setProperty("webdriver.chrome.driver",userDirectory+"/Driver/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			drivernew = new ChromeDriver(cap);
			drivernew.navigate().to(url);
			Thread.sleep(3000);
			WebElement KwiksetOption = drivernew.findElement(By.id("kwikset"));
			if(KwiksetOption.isDisplayed()) {
			KwiksetOption.click();
			}
			 WebElement UsernameField  = drivernew.findElement(By.id("loginEmail"));	
			 UsernameField.sendKeys(username);
			 WebElement PasswordField  = drivernew.findElement(By.id("loginPassword"));
			 PasswordField.sendKeys(password);
			 WebElement SubmitButton  = drivernew.findElement(By.id("loginSubmit"));
			 SubmitButton.click();
			 Thread.sleep(7000);
			 WebElement radio =  drivernew.findElement(By.id("choice"));
			 radio.click();
			 WebElement SendButton  = drivernew.findElement(By.id("signincode-form-submit"));
			 SendButton.click();
			 synchronized(this) {
			 ReadEmail emailUtils = new ReadEmail(email, pwd, "imap.gmail.com", "IMAP",993,ReadEmail.EmailFolder.INBOX);
			 code=emailUtils.getAccessCode("GoConcourse: Verification Code");  		
			 WebElement securityCode = drivernew.findElement(By.id("securityCode"));
			 securityCode.sendKeys(code);
			 WebElement verifybutton =  drivernew.findElement(By.id("signinverify-form-submit"));
			 verifybutton.click();
			}
			 Thread.sleep(10000);
			 String currentURL = "https://cognito-idp.us-east-1.amazonaws.com/";
			 LogEntries logs = drivernew.manage().logs().get(LogType.PERFORMANCE);
			 int status = -1;
			 for(LogEntry entry : logs ) { 
	                try{
	                    json = new JSONObject(entry.getMessage());
	                    message = json.getJSONObject("message");
	                    method = message.getString("method");
	                    if (method != null && "Network.requestWillBeSent".equals(method)){
	                         params = message.getJSONObject("params");
	                         response = params.getJSONObject("request");                       
	                         requestHeaders = response.getJSONObject("headers");
	                         authorization = requestHeaders.getString("Authorization");
	                    }
	      } catch (JSONException e){        	
	      }
			 }
			  authToken.add(authorization);
			  return authorization;

			        } finally{
			            if (drivernew != null){
			            }
			            drivernew.quit();
			        }
		
			    }
	
	 }



