package tests.app;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.app.EnterHomeNamePage;
import pages.app.LockDashboardPage;
import pages.app.ManageHomesPage;
import pages.app.MenuFlyoutPage;
import utility.ExcelRead;
import utility.Log;

public class AddHomeTest extends Settings{
	
	@SuppressWarnings("unchecked")
	
	@Test(dataProvider="addHome")
	public void addHome(String home) throws InterruptedException {
	  try {
		LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);
		MenuFlyoutPage mf = new MenuFlyoutPage((AppiumDriver<MobileElement>) driver);
		ManageHomesPage mh= new ManageHomesPage((AppiumDriver<MobileElement>) driver);
		EnterHomeNamePage ep = new EnterHomeNamePage((AppiumDriver<MobileElement>) driver);
		ld.clickHamburgerButton();
		mf.clickManageButton();
		mh.clickAddHomeButton();
		ep.enterHomeName(home);
		ep.clickSubmitButton();
		Log.addMessage("Home added successfully");
	  }catch(Exception e) {
		Log.addMessage("Failed to add home");  
		Assert.assertTrue(false, "Failed to add home");
	  }
	}

	ExcelRead excel = new ExcelRead();
	
	@DataProvider(name = "addHome")
	public Object[][] getData() throws Exception {
	return excel.getTableArray(InputData, "App", "AddHome");
	}
}
