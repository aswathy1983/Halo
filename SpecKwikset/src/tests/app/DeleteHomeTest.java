package tests.app;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.app.ManageHomesPage;
import utility.Log;

public class DeleteHomeTest extends Settings{
	
	@SuppressWarnings("unchecked")
	
	@Test
	public void deleteHomeWithoutLocksTest() {
		try {
			ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
			mh.deleteHome();			
		}catch(Exception e) {
			Log.addMessage("Failed to lock/unlock");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to lock/unlock");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void deleteHomeWithLocksTest() {
	try {
		ManageHomesPage mh = new ManageHomesPage((AppiumDriver<MobileElement>) driver);
		mh.deleteHome();			
	}catch(Exception e) {
		Log.addMessage("Failed to lock/unlock");
		e.printStackTrace();
		Assert.assertTrue(false, "Failed to lock/unlock");
	}
}

}
