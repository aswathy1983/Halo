package tests.app;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.app.LockDashboardPage;
import pages.app.LockInfoPage;
import pages.app.LockSettingsPage;
import utility.Log;

public class LockAttributesTest extends Settings{

	@SuppressWarnings("unchecked")
	@Test
	public void get_lock_attributes_test(String lock_model,String lock_prod_family,String lock_sku, String lock_serial_number, 
			String lock_FW_bundle_version,String lock_MB_firmware, String lock_BLE_firmware, String lock_WFC_firmware, String lock_WFR_firmware,
			String lock_HW_revision, String lock_manfacture_date, String lock_activation_date ) {
		try {
			LockDashboardPage ld = new LockDashboardPage((AppiumDriver<MobileElement>) driver);	
			LockSettingsPage ls = new LockSettingsPage((AppiumDriver<MobileElement>) driver);	
			LockInfoPage lp = new LockInfoPage((AppiumDriver<MobileElement>) driver);
			ld.clickLockSettingsButton();
			ls.clickLockInfoButton();
			lp.getModel(lock_model);
			lp.getProductFamily(lock_prod_family);
			lp.getSKU(lock_sku);
			lp.getSerialNumber(lock_serial_number);
			lp.getFWBundleVersion(lock_FW_bundle_version);
			lp.getMBFirmware(lock_MB_firmware);
			lp.getBLEFirmware(lock_BLE_firmware);
			lp.getWFCFirmware(lock_WFC_firmware);
			lp.getWFRFirmware(lock_WFR_firmware);
			lp.getHardwareRevision(lock_HW_revision);
			lp.getManufactureDate(lock_manfacture_date);
			lp.getActivationDate(lock_activation_date);
			Log.addMessage("Successfully retrieved all lock attributes");
		}catch(Exception e) {
			Log.addMessage("Failed to retrieve lock attributes");
			 Assert.assertTrue(false, "Failed to retrieve lock attributes");
		}
		
	}
	
}
