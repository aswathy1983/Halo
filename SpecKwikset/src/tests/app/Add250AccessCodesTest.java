package tests.app;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.app.AddAccessCodePage;
import pages.app.LockDashboardPage;
import pages.app.ViewAccessCodesPage;
import utility.Log;
import utility.Utility;

public class Add250AccessCodesTest extends Settings{
	
	
	
	Random rand = new Random();
	String name, titleMessage;
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void clickAccessCodeButtonTest() {
	  try {
		LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
		Thread.sleep(15000);
		ld.clickAccessCodeButton();//commented on 26 Aug for weiser
		//ld.clickAcesCodeButton();
	  }catch(Exception e) {
		  Log.addMessage("Failed to click access code button");
		  e.printStackTrace();		  
		  Assert.assertTrue(false, "Failed to click access code button");
	  }
	}
	
	@SuppressWarnings("unchecked")
	@Test ()
	public void addAccessCodeTest() {
		try {
			ViewAccessCodesPage ap = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			//for (int i = 1;i<=400;i++) {//commented for overnight execution on 22-12-20
			for (int i = 0;i<=5;i++) {
			 ap.clickAddAccessCodeButton();
			 name = "tcode";
			 name = name + i;
			 AddAccessCodePage ac = new AddAccessCodePage((AppiumDriver<MobileElement>) driver);
			 ac.enterAccessCodeName(name);
			 ac.clickGenerateRandomCodeButton();
			 Thread.sleep(10000);//for creating dup code check
			 ac.clickSubmitButton();
			 if(ac.checkHandlePopUp()) {
				 titleMessage = ac.verifyPopUpVerbiage();
					if(titleMessage!=null || titleMessage!="") {
						System.out.println("titleMessage="+titleMessage);
						if(titleMessage.equals("Code In Use") || titleMessage.equals("Invalid Access Code") ){// popup in android and iOS respectively for duplicate code
							ac.clickOKButton();
							 Utility.simpleWait(5000);
							ac.clickGenerateRandomCodeButton();
							ac.clickSubmitButton();
						}else if(titleMessage.equals("Lock Pairing Available") || titleMessage.equals("Internet Connection Required")) {
							ac.clickCancelPairBtn();
						}else{
							ac.clickOKButton();	
						}
					  }
			 }
			 Utility.simpleWait(25000);
			 System.out.println("Access code "+i+" created");
			}
		}catch(Exception e) {
			//check for presence of invalid access code pop up->if yes->dismiss pop up->click generate random code and submit.
			Log.addMessage("Failed to add access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to add access code");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test ()
	public void addAccessCodeDupTest() {
		try {
			ViewAccessCodesPage ap = new ViewAccessCodesPage((AppiumDriver<MobileElement>) driver);
			//for (int i = 1;i<=400;i++) {//commented for overnight execution on 22-12-20
			for (int i = 250;i<=270;i++) {
			 ap.clickAddAccessCodeButton();
			 name = "tcode";
			 name = name + i;
			 AddAccessCodePage ac = new AddAccessCodePage((AppiumDriver<MobileElement>) driver);
			 ac.enterAccessCodeName(name);
			 ac.clickGenerateRandomCodeButton();
			 ac.clickSubmitButton();
			 
			 Utility.simpleWait(25000);
			 System.out.println("Access code "+i+" created");
			}
		}catch(Exception e) {
			//check for presence of invalid access code pop up->if yes->dismiss pop up->click generate random code and submit.
			Log.addMessage("Failed to add access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to add access code");
		}
	}
	
	
}
