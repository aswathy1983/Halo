package tests.app;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.app.LockDashboardPage;
import pages.app.LockEventHistoryPage;
import utility.Log;

public class ViewLockHistoryTest extends Settings{
	
	@SuppressWarnings("unchecked")
	@Test
	public void viewLockHistory() {
		try {
		  LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
		  LockEventHistoryPage lh = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
		  ld.clickLockHistoryButton();
		  lh.displayAllEvents();
		  Log.addMessage("All events are displayed");
		}catch(Exception e) {
		  Log.addMessage("Failed to display all events");  
		  Assert.assertTrue(false, "Failed to display all events");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void clearLockHistory() {
		try {
		  LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
		  LockEventHistoryPage lh = new LockEventHistoryPage((AppiumDriver<MobileElement>) driver);
		  ld.clickLockHistoryButton();
		  lh.clearHistory();
		  Log.addMessage("All events are cleared from history");
		}catch(Exception e) {
		  Log.addMessage("Failed to clear all events");  
		  Assert.assertTrue(false, "Failed to clear all events");
		}
	}

}
