package tests.app;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.app.CreateAHomePage;
import pages.app.EnterHomeNamePage;
import pages.app.LockDashboardPage;
import utility.ExcelRead;
import utility.Log;

public class AddFirstHomeTest extends Settings {
	
	@SuppressWarnings("unchecked")
	
	@Test(dataProvider="firstHome")
	public void createFirstHomeTest(String homename) {
		try {
			CreateAHomePage ch = new CreateAHomePage((AppiumDriver<MobileElement>) driver);
			EnterHomeNamePage eh = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
			ch.clickCreateAHomeButton();
			eh.enterHomeName(homename);
			eh.clickSubmitButton();
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
			ld.verifyDashboardWithNoLocks();
			Log.addMessage("First home created");
		}catch(Exception e) {
			Log.addMessage("Failed to create First Home");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to create First Home");
		}
	}
	
	ExcelRead excel = new ExcelRead();
	 
 	@DataProvider(name = "firstHome")
	public Object[][] getData() throws Exception {
	return excel.getTableArray(InputData, "App", "FirstHome");
	}

}
