package tests.app;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Settings;
import utility.Log;
import utility.Utility;



public class BatteryCycleTest extends Settings{

	static int batteryCycle = 0;
	int lock_count = 0;
	int unlock_count = 0;
	String bat_percent;
	Boolean lowBatAlert_30;
	Boolean lowBatAlert_20;
	Boolean lowBatAlert_10;
	Boolean lowBatAlert_0;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
	Calendar cal;
	File report = new File(System.getProperty("user.dir")+"/BatteryTestReports/Report.csv"); 
	
	
	

	@Test(retryAnalyzer = utility.RetryAnalyzer.class)
	
	public void batteryDrainTest() throws InterruptedException {
		lockUnlock();
	}
		
	
	//@Test
	public void printBatteryPercentage() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath(""));
	}
	
	
	@SuppressWarnings("static-access")
	
	public void lockUnlock() throws InterruptedException {	
	 try {
		String LockStatus = getLockStatus();
		if ((LockStatus).equals("Locked")) {
		  try {
			unlock();
			Thread.sleep(30000);
			checkForPopUp();
			checkForBatteryPercentage();
			lock();
			Thread.sleep(30000);
			checkForPopUp();
			System.out.println("Battery Cycle "+batteryCycle+" completed");
			bat_percent = checkForBatteryPercentage();
			lowBatAlert_30 = thirtyBatteryCheck(bat_percent);
			lowBatAlert_20 = twentyBatteryCheck(bat_percent);
			lowBatAlert_10 = tenBatteryCheck(bat_percent);
			lowBatAlert_0 = zeroBatteryCheck(bat_percent);
			Log.addMessage("Battery Cycle "+batteryCycle+" completed");
			batteryCycle++;
			sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
			cal = Calendar.getInstance();
			list.add(new String[] {Integer.toString(batteryCycle),bat_percent,String.valueOf(lowBatAlert_30),String.valueOf(lowBatAlert_20),String.valueOf(lowBatAlert_10),String.valueOf(lowBatAlert_0),sdf.format(cal.getTime())});
			Utility.generateCSVReport(list,report);
			lockUnlock();
		  }catch(Exception e) {
			  System.out.println(e.toString());
		  }
		}
		
		else if(LockStatus.equals("Unlocked")){
		  try {
			lock();
			Thread.sleep(30000);
			checkForPopUp();
			checkForBatteryPercentage();
			unlock();
			Thread.sleep(30000);
			checkForPopUp();
			checkForBatteryPercentage();
			System.out.println("Battery Cycle "+batteryCycle+" completed");
			bat_percent = checkForBatteryPercentage();
			lowBatAlert_30 = thirtyBatteryCheck(bat_percent);
			lowBatAlert_20 = twentyBatteryCheck(bat_percent);
			lowBatAlert_10 = tenBatteryCheck(bat_percent);
			lowBatAlert_0 = zeroBatteryCheck(bat_percent);
			Log.addMessage("Battery Cycle "+batteryCycle+" completed");
			batteryCycle++;
			sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
			cal = Calendar.getInstance();
			list.add(new String[] {Integer.toString(batteryCycle),bat_percent,String.valueOf(lowBatAlert_30),String.valueOf(lowBatAlert_20),String.valueOf(lowBatAlert_10),String.valueOf(lowBatAlert_0),sdf.format(cal.getTime())});
			lockUnlock();
		  }catch(Exception e) {
			  System.out.println(e.toString());
		  }
		}
		
		
		
		else if (LockStatus.equals("Jammed")) {
			System.out.println("Lock is jammed");
			WebDriverWait wait1 = new WebDriverWait(driver,60);
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeImage[@name='lock_jammed']/following-sibling::XCUIElementTypeButton")));
			driver.findElement(By.xpath("//XCUIElementTypeImage[@name='lock_jammed']/following-sibling::XCUIElementTypeButton")).click();
			if (getLockStatus().equals("Jammed")) {
				Log.addMessage("Lock status is jammed. Lock/Unlock operation cannot be continued");
				Assert.assertTrue(false, "Test failed since the lock status is jammed");
			}
			else {
				lockUnlock();
			}
		}
		
		else if (LockStatus.equals("Lock Offline")) {
			System.out.println("Lock is Offline");
			Log.addMessage("Lock status is Offline. Lock/Unlock operation cannot be continued");
			Assert.assertTrue(false, "Test failed since the lock is offline");
		}
	
		else if (driver.findElement(By.xpath("//XCUIElementTypeAlert[@name='Lock Offline']")).isDisplayed()){
			Log.addMessage("Lock offline pop up displayed.");
			driver.findElement(By.id("Ok")).click();
			lockUnlock();
			
		}

		else {
				Log.addMessage("Lock status not determined. Terminating the test execution");
				Assert.assertTrue(false, "Test failed since the lock status not determined.");
			}
		}catch(Exception e) {
			  System.out.println(e.toString());
		}
	}
		
		
	
	
	public boolean thirtyBatteryCheck(String batteryPercent) {
		int percent = Integer.parseInt(batteryPercent.replace("%", ""));
		if (percent<=30 && percent>20 ) 
			return true;
		else 
			return false;
		
	}
	
	public boolean twentyBatteryCheck(String batteryPercent) {
		int percent = Integer.parseInt(batteryPercent.replace("%", ""));
		if (percent<=20 && percent>10 ) 
			return true;
		else 
			return false;
		
	}
	
	public boolean tenBatteryCheck(String batteryPercent) {
		int percent = Integer.parseInt(batteryPercent.replace("%", ""));
		if (percent<=10 && percent>0 ) 
			return true;
		else 
			return false;
		
	}
	
	public boolean zeroBatteryCheck(String batteryPercent) {
		int percent = Integer.parseInt(batteryPercent.replace("%", ""));
		if (percent==0 ) 
			return true;
		else 
			return false;
		
	}
	
	
	public int lock() {
	    try {
	    	WebDriverWait wait1 = new WebDriverWait(driver,60);
	
	    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name='Unlocked']/preceding-sibling::XCUIElementTypeButton")));
			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeStaticText[@name='Unlocked']/preceding-sibling::XCUIElementTypeButton")));
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Unlocked']/preceding-sibling::XCUIElementTypeButton")).click();
	    	lock_count++;
	    	System.out.println("Door "+ getLockStatus());
	    	Log.addMessage("Door "+ getLockStatus());
	    	return lock_count;
	    }catch(Exception e) {
	    	Assert.assertTrue(false, "Lock Operation failed");
	    	System.out.println("Status not displayed correctly in the lock.");
	    	Log.addMessage("Status is not displayed correctly in the lock.");
	    	return 0;
	    } 	
	}
		
	public int unlock() {
		try {
			WebDriverWait wait1 = new WebDriverWait(driver,60);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name='Locked']/preceding-sibling::XCUIElementTypeButton")));
			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeStaticText[@name='Locked']/preceding-sibling::XCUIElementTypeButton")));
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Locked']/preceding-sibling::XCUIElementTypeButton")).click();
			unlock_count++;
			System.out.println("Door "+ getLockStatus());
			Log.addMessage("Door "+ getLockStatus());
			return unlock_count;
		}catch(Exception e) {
			Assert.assertTrue(false, "Unlock Operation failed");
			Log.addMessage("Status is not displayed correctly in the lock.");
			return 0;
		} 	
	}
		
	
	public String getLockStatus() throws InterruptedException {
		try {
			Thread.sleep(6000);
			WebDriverWait wait1 = new WebDriverWait(driver,60);
		    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeImage[@name='base_circle']/following-sibling::XCUIElementTypeStaticText")));
		    String lockStatus = driver.findElement(By.xpath("//XCUIElementTypeImage[@name='base_circle']/following-sibling::XCUIElementTypeStaticText")).getText();	
		    return lockStatus;
		}catch(Exception e) {
			System.out.println("Lock status cannot be determined. Terminating the test execution");
			Log.addMessage("Lock status cannot be determined. Terminating the test execution");
			Assert.assertTrue(false, "Test failed since the lock status not determined.");
			return null;
		}
	}
	
		
	public String checkForBatteryPercentage() throws InterruptedException {
		try {
		   String percent = "";
		   WebDriverWait wait1 = new WebDriverWait(driver,60);
		   wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeButton[@name='lock settting']")));
		   wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeButton[@name='lock settting']")));
		   driver.findElement(By.xpath("//XCUIElementTypeButton[@name='lock settting']")).click();
		   wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeTable/XCUIElementTypeStaticText[2]")));
		   if (driver.findElement(By.xpath("//XCUIElementTypeTable/XCUIElementTypeStaticText[2]")).isDisplayed()) {
			
			   percent = driver.findElement(By.xpath("//XCUIElementTypeTable/XCUIElementTypeStaticText[2]")).getText();
			   System.out.println("Battery percentage is: "+percent);
			   Log.addMessage("Battery percentage is: "+percent);
			   driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Back']")).click();
		   }
		
		   else if(driver.findElement(By.xpath("//XCUIElementTypeAlert[@name='Lock Batteries Low']")).isDisplayed()) {
			   driver.findElement(By.id("Ok")).click();
			   percent = driver.findElement(By.xpath("//XCUIElementTypeTable/XCUIElementTypeStaticText[2]")).getText();
			   System.out.println("Battery percentage is: "+percent);
			   driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Back']")).click();		
		   }
		   return percent;
		
		}catch(Exception e) {
			return null;
		}
	}
		
	public void checkForPopUp() throws InterruptedException {
	  try {
		  WebDriverWait wait1 = new WebDriverWait(driver,60);
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeImage[@name='base_circle']/following-sibling::XCUIElementTypeStaticText")));
		  
		  if( driver.findElement(By.xpath("//XCUIElementTypeImage[@name='base_circle']/following-sibling::XCUIElementTypeStaticText")).isDisplayed()){
			  System.out.println("Lock/unlock operation continues...");
			  Log.addMessage("Lock/unlock operation continues...");
		  	}
		  
		  else if ( driver.findElement(By.xpath("//XCUIElementTypeAlert[@name='Lock Batteries Critically Low']")).isDisplayed()) {
			
			  System.out.println("Lock batteries are critically low.");
			  Log.addMessage("Lock batteries are critically low.");
			  driver.findElement(By.id("Ok")).click();
			  driver.findElement(By.id("lock settting")).click();
			
			  try {
				Boolean batteryLowPopUp = driver.findElement(By.xpath("//XCUIElementTypeAlert[@name='Lock Batteries Low']")).isDisplayed();
				
				if (batteryLowPopUp) {
					driver.findElement(By.id("Ok")).click();
					driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Back']")).click();	
					System.out.println("Battery percentage is : "+checkForBatteryPercentage());						
				}
				else 
					System.out.println("Battery percentage is : "+checkForBatteryPercentage());	
			
			  	}catch(Exception e) {
				  	System.out.println("Battery percentage is : "+checkForBatteryPercentage());	
			  	}
			
			System.out.println("Now, the lock batteries are critically low. So lock and unlock operations cannot be carried out.");
			Log.addMessage("Now, the lock batteries are critically low. So lock and unlock operations cannot be carried out.");
			System.out.println("Exiting the test");
			Log.addMessage("Exiting the test");
			System.exit(0);
		   }
		
		else if ( driver.findElement(By.xpath("//XCUIElementTypeAlert[@name='Lock Offline']")).isDisplayed()) {
			System.out.println("Lock offline.");
			Log.addMessage("Lock offline.");
			driver.findElement(By.id("Ok")).click();
		}
		
		else{
			 System.out.println("Something went wrong...");
			 Log.addMessage("Something went wrong...");
		}
	 
	  }catch(Exception e) {
			
	}
  }
}
