package tests.app;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.app.AddAccessCodePage;
import pages.app.BLEInstructionPage1;
import pages.app.BLEInstructionPage2;
import pages.app.LockDashboardPage;
import pages.app.LockNamePage;
import pages.app.SearchLocksPage;
import pages.app.TestConnectionPage;
import utility.Log;

public class AddAuraLockTest extends Settings{
	
	@SuppressWarnings("unchecked")
	
	@Test
	public void clickAddLockButtonTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			ld.clickAddLockButton();
		}catch(Exception e) {
			Log.addMessage("Failed to click Add Lock Button");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click Add Lock Button");
		}
	}
	
	@SuppressWarnings("unchecked")
	
	@Test
	public void readInstructionsTest() {
		try {
			BLEInstructionPage1 b1 = new BLEInstructionPage1((AppiumDriver<MobileElement>) driver);
			BLEInstructionPage2 b2 = new BLEInstructionPage2((AppiumDriver<MobileElement>) driver);
			b1.clickNextButton();
			b2.clickNextButton();
		}catch(Exception e) {
			Log.addMessage("Failed to click Next Button");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click Next Button");
		}
	}
	
	@SuppressWarnings("unchecked")
	
	@Test
	public void selectLockTest() {
		try {
			SearchLocksPage sl = new SearchLocksPage((AppiumDriver<MobileElement>) driver);
			sl.selectLockoneCell();
		}catch(Exception e) {
			Log.addMessage("Failed to select lock");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to select Lock");
		}
	}
	
	@SuppressWarnings("unchecked")
	
	@Test
	public void connectionTest() {
		try {
			TestConnectionPage tc = new TestConnectionPage((AppiumDriver<MobileElement>) driver);
			tc.clickYesButton();
			tc.clickPairButton();
		}catch(Exception e) {
			Log.addMessage("Failed to pair lock");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to pair Lock");
			
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void enterLockNameTest(String lockname) {
		try {
			LockNamePage ln = new LockNamePage((AppiumDriver<MobileElement>) driver);
			ln.enterLockName(lockname);
			ln.clickSubmitButton();
		}catch(Exception e) {
			Log.addMessage("Failed to enter lock name");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to enter lock name");
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void enterAccessCodeTest(String accessCodeName) {
		try {
			 AddAccessCodePage ac = new AddAccessCodePage((AppiumDriver<MobileElement>) driver);
			 ac.enterAccessCodeName(accessCodeName);
			 ac.clickGenerateRandomCodeButton();
			 ac.clickSubmitButton();
		}catch(Exception e) {
			Log.addMessage("Failed to add access code");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to add access code");
		}
	}
	
}
