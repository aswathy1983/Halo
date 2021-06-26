package tests.app;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.app.HelpFAQPage;
import pages.app.LockDashboardPage;
import pages.app.MenuFlyoutPage;
import utility.Log;

public class HelpFAQTest extends Settings {

	@SuppressWarnings("unchecked")
	@Test
	public void helpSectionTest() {
	  try {
		LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
		MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
		HelpFAQPage hf = new HelpFAQPage((AppiumDriver<MobileElement>) driver);
		ld.clickHamburgerButton();
		mf.clickHelpFAQButton();
		hf.verifyLockInstallationGuide();
		hf.verifySupportCenter();
		hf.verifyUserAgreements();
		hf.clickBackButton();
		Log.addMessage("Validated Help section");
	  }catch(Exception e) {
		Log.addMessage("Failed to validate Help/FAQ section");
		Assert.assertTrue(false, "Failed to validate Help/FAQ section");	
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void helpFaqTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			ld.clickHamburgerButton();
			mf.clickHelpFAQButton();
			Log.addMessage("Clicked Help/Faq button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Help/Faq button");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click Help/Faq again button");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void lockInstallationTest() {
		try {
			HelpFAQPage hf = new HelpFAQPage((AppiumDriver<MobileElement>) driver);
			hf.verifyLockInstGuide();
			Log.addMessage("Clicked lock installation guide");
		}catch(Exception e) {
			Log.addMessage("Failed to click lock installation guide");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click lock installation guide");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void lockInstallationBackTest() {
		try {
			if(device.equals("iOS")) {
				((AppiumDriver<MobileElement>) driver).launchApp();
			}else {
				appiumDriver.navigate().back();
			}
			Log.addMessage("Clicked support centre guide");
		}catch(Exception e) {
			Log.addMessage("Failed to click support centre guide");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click support centre guide");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void helpFaqiOSTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			ld.clickHamburgerButton();
			mf.clickHelpFAQButton();
			Log.addMessage("Clicked Help/Faq button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Help/Faq button");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click Help/Faq again button");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void supportCentreTest() {
		try {
			HelpFAQPage hf = new HelpFAQPage((AppiumDriver<MobileElement>) driver);
			hf.verifySupportCenter();
			Log.addMessage("Clicked support centre guide");
		}catch(Exception e) {
			Log.addMessage("Failed to click support centre guide");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click support centre guide");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void supportCentreBackTest() {
		try {
			if(device.equals("iOS")) {
				((AppiumDriver<MobileElement>) driver).launchApp();
			}else {
				appiumDriver.navigate().back();
			}
			Log.addMessage("Clicked support centre guide");
		}catch(Exception e) {
			Log.addMessage("Failed to click support centre guide");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click support centre guide");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void helpFaqAgiOSTest() {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
			ld.clickHamburgerButton();
			mf.clickHelpFAQButton();
			Log.addMessage("Clicked Help/Faq button");
		}catch(Exception e) {
			Log.addMessage("Failed to click Help/Faq button");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click Help/Faq again button");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void userAgreementTest() {
		try {
			HelpFAQPage hf = new HelpFAQPage((AppiumDriver<MobileElement>) driver);
			hf.verifyUserAgreements();
			Log.addMessage("Clicked lock installation guide");
		}catch(Exception e) {
			Log.addMessage("Failed to click lock installation guide");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click lock installation guide");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void navBackTest() {
		try {
			HelpFAQPage hf = new HelpFAQPage((AppiumDriver<MobileElement>) driver);
			hf.clickBackButton();
			Log.addMessage("Clicked lock installation guide");
		}catch(Exception e) {
			Log.addMessage("Failed to click lock installation guide");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to click lock installation guide");
		}
	}

}
