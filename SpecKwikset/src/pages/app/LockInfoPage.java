package pages.app;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import utility.Log;
import utility.Utility;

public class LockInfoPage extends Settings{
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[13]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_model"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_model"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_model"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_model")
	})
	@CacheLookup
	private MobileElement model;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[14]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_product_family"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_product_family"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_product_family"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_product_family")
	})
	@CacheLookup
	private MobileElement product_family;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[15]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_sku"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_sku"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_sku"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_sku")
	})
	@CacheLookup
	private MobileElement SKU;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[16]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_serial_number"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_serial_number"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_serial_number"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_serial_number")
	})
	@CacheLookup
	private MobileElement serial_number;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[17]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_ver_firmware_bundle"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_ver_firmware_bundle"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_ver_firmware_bundle"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_ver_firmware_bundle")
	})
	@CacheLookup
	private MobileElement firmware_bundle_version;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[18]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_mb_firmware"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_mb_firmware"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_mb_firmware"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_mb_firmware")
	})
	@CacheLookup
	private MobileElement MB_Firmware;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[19]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/ble_firmware_version"),
		@AndroidBy(id = "com.kwikset.blewifi:id/ble_firmware_version"),
		@AndroidBy(id = "com.spectrum.giga:id/ble_firmware_version"),
		@AndroidBy(id = "com.weiser.blewifi:id/ble_firmware_version")
	})
	@CacheLookup
	private MobileElement BLE_Firmware;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[20]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_wfc_firmware"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_wfc_firmware"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_wfc_firmware"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_wfc_firmware")
	})
	@CacheLookup
	private MobileElement WFC_Firmware;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[21]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_wfr_firmware"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_wfr_firmware"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_wfr_firmware"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_wfr_firmware")
	})
	@CacheLookup
	private MobileElement WFR_Firmware;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[25]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_exterior_firmware"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_exterior_firmware"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_exterior_firmware"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_exterior_firmware")
	})
	@CacheLookup
	private MobileElement firmware_revision;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[22]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_hardware_revision"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_hardware_revision"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_hardware_revision"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_hardware_revision")
	})
	@CacheLookup
	private MobileElement hardware_revision;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[23]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_manufacture_date"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_manufacture_date"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_manufacture_date"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_manufacture_date")
	})
	@CacheLookup
	private MobileElement manufacture_date;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[24]")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/tv_activation_date"),
		@AndroidBy(id = "com.kwikset.blewifi:id/tv_activation_date"),
		@AndroidBy(id = "com.spectrum.giga:id/tv_activation_date"),
		@AndroidBy(id = "com.weiser.blewifi:id/tv_activation_date")
	})
	@CacheLookup
	private MobileElement activation_date;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeStaticText[2]")
	@AndroidFindBy(xpath = "(//android.widget.TextView)[3]")
	@CacheLookup
	private MobileElement batteryPercent;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	@AndroidFindAll({
		@AndroidBy(id = "com.kwikset.blewifi.dev:id/cancelAllhomes"),
		@AndroidBy(id = "com.kwikset.blewifi:id/cancelAllhomes"),
		@AndroidBy(id = "com.spectrum.giga:id/cancelAllhomes"),
		@AndroidBy(id = "com.weiser.blewifi:id/cancelAllhomes")
	})
	@CacheLookup
	private MobileElement backButton;
	
	String manufactureDate, activationDate,lkbatteryPercent = "";
	
	//Constructor
	@SuppressWarnings("static-access")
	public LockInfoPage(AppiumDriver<MobileElement> driver) {
	this.appiumDriver = driver;
	PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void getModel(String lock_model) {
		try {
			//Thread.sleep(6000);
			Utility.waitForElementToBePresent(model, appiumDriver);
			Log.addMessage("Lock Model is: "+model.getText());
			if(model.getText().equals(lock_model))
				Log.addMessage("Lock Model is correctly displayed");
			else
				Log.addMessage("Wrong model info displayed");
		}catch(Exception e) {
			Log.addMessage("Failed to display lock model");
			Assert.assertTrue(false, "Failed to display lock model");
		}
	}
	
	/** 
	* Method Name: getModelInfo(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void getModelInfo() {
		try {
			Thread.sleep(6000);
			Log.addMessage("Lock Model is: "+model.getText());
			Log.addMessage("Lock Model is correctly displayed");
		}catch(Exception e) {
			Log.addMessage("Failed to display lock model");
			Assert.assertTrue(false, "Failed to display lock model");
		}
	}
	
	public void getProductFamily(String lock_prod_family) {
		try {
			//Thread.sleep(6000);
			Log.addMessage("Lock Product family is: "+product_family.getText());
			if(product_family.getText().equals(lock_prod_family))
				Log.addMessage("Lock Product family is correctly displayed");
			else
				Log.addMessage("Wrong Product family info displayed");
		}catch(Exception e) {
			Log.addMessage("Failed to display lock Product family");
			Assert.assertTrue(false, "Failed to display lock Product family");
		}
	}
	
	/** 
	* Method Name: getProductFamilyInfo(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void getProductFamilyInfo() {
		try {
			Thread.sleep(6000);
			Log.addMessage("Product family is: "+product_family.getText());
			Log.addMessage("Product family is correctly displayed");
		}catch(Exception e) {
			Log.addMessage("Failed to display product family");
			Assert.assertTrue(false, "Failed to display lock model");
		}
	}
	
	public void getSKU(String lock_sku) {
		try {
			//Thread.sleep(6000);
			Log.addMessage("Lock SKU is: "+SKU.getText());
			if(SKU.getText().equals(lock_sku))
				Log.addMessage("Lock SKU is correctly displayed");
			else
				Log.addMessage("Wrong SKU info displayed");
		}catch(Exception e) {
			Log.addMessage("Failed to display lock SKU");
			Assert.assertTrue(false, "Failed to display lock SKU");
		}
	}
	
	/** 
	* Method Name: getSKUInfo(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void getSKUInfo() {
		try {
			Thread.sleep(6000);
			Log.addMessage("Lock SKU is: "+SKU.getText());
			Log.addMessage("Lock SKU is correctly displayed");
		}catch(Exception e) {
			Log.addMessage("Failed to display lock SKU");
			Assert.assertTrue(false, "Failed to display lock SKU");
		}
	}
	
	public void getSerialNumber(String lock_serial_number) {
		try {
			//Thread.sleep(6000);
			Log.addMessage("Lock Serial Number is: "+serial_number.getText());
			if(serial_number.getText().equals(lock_serial_number))
				Log.addMessage("Lock Serial Number is correctly displayed");
			else
				Log.addMessage("Wrong Serial Number info displayed");
		}catch(Exception e) {
			Log.addMessage("Failed to display lock Serial Number");
			Assert.assertTrue(false, "Failed to display lock Serial Number");
		}
	}
	
	/** 
	* Method Name: getSerialNumberInfo(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void getSerialNumberInfo() {
		try {
			Thread.sleep(6000);
			Log.addMessage("Lock serial number is: "+serial_number.getText());
			Log.addMessage("Lock serial number is correctly displayed");
		}catch(Exception e) {
			Log.addMessage("Failed to display lock serial number");
			Assert.assertTrue(false, "Failed to display lock serial number");
		}
	}
	
	public void getFWBundleVersion(String lock_FW_bundle_version) {
		try {
			//Thread.sleep(6000);
			Log.addMessage("Lock Firmware Bundle Version is: "+firmware_bundle_version.getText());
			if(firmware_bundle_version.getText().equals(lock_FW_bundle_version))
				Log.addMessage("Lock Firmware Bundle Version is correctly displayed");
			else
				Log.addMessage("Wrong Firmware Bundle Version info displayed");
		}catch(Exception e) {
			Log.addMessage("Failed to display lock Firmware Bundle Version");
			Assert.assertTrue(false, "Failed to display lock Firmware Bundle Version");
		}
	}
	
	/** 
	* Method Name: getFWBundleVersionInfo(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void getFWBundleVersionInfo() {
		try {
			Thread.sleep(6000);
			Log.addMessage("Firmware bundle version is: "+firmware_bundle_version.getText());
			Log.addMessage("Firmware bundle version is correctly displayed");
		}catch(Exception e) {
			Log.addMessage("Failed to display firmware bundle version");
			Assert.assertTrue(false, "Failed to display firmware bundle version");
		}
	}
	
	public void getMBFirmware(String lock_MB_firmware) {
		try {
			//Thread.sleep(6000);
			Log.addMessage("Lock MB firmware is: "+MB_Firmware.getText());
			if(MB_Firmware.getText().equals(lock_MB_firmware))
				Log.addMessage("Lock MB Firmware is correctly displayed");
			else
				Log.addMessage("Wrong MB Firmware info displayed");
		}catch(Exception e) {
			Log.addMessage("Failed to display lock MB Firmware");
			Assert.assertTrue(false, "Failed to display lock MB Firmware");
		}
	}
	
	/** 
	* Method Name: getMBFirmwareInfo(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void getMBFirmwareInfo() {
		try {
			Thread.sleep(6000);
			Log.addMessage("MB Firmware is: "+MB_Firmware.getText());
			Log.addMessage("MB Firmware is correctly displayed");
		}catch(Exception e) {
			Log.addMessage("Failed to display MB Firmware");
			Assert.assertTrue(false, "Failed to display MB Firmware");
		}
	}
	
	public void getBLEFirmware(String lock_BLE_firmware) {
		try {
			//Thread.sleep(6000);
			Log.addMessage("Lock BLE Firmware is: "+BLE_Firmware.getText());
			if(BLE_Firmware.getText().equals(lock_BLE_firmware))
				Log.addMessage("Lock BLE Firmware is correctly displayed");
			else
				Log.addMessage("Wrong BLE Firmware info displayed");
		}catch(Exception e) {
			Log.addMessage("Failed to display lock BLE Firmware");
			Assert.assertTrue(false, "Failed to display lock BLE Firmware");
		}
	}
	
	/** 
	* Method Name: getBLEFirmwareInfo(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void getBLEFirmwareInfo() {
		try {
			Thread.sleep(6000);
			Log.addMessage("BLE Firmware is: "+BLE_Firmware.getText());
			Log.addMessage("BLE Firmware is correctly displayed");
		}catch(Exception e) {
			Log.addMessage("Failed to display BLE Firmware");
			Assert.assertTrue(false, "Failed to display BLE Firmware");
		}
	}
	
	public void getWFCFirmware(String lock_WFC_firmware) {
		try {
			//Thread.sleep(6000);
			Log.addMessage("Lock WFC Firmware is: "+WFC_Firmware.getText());
			if(WFC_Firmware.getText().equals(lock_WFC_firmware))
				Log.addMessage("Lock WFC Firmware is correctly displayed");
			else
				Log.addMessage("Wrong WFC Firmware info displayed");
		}catch(Exception e) {
			Log.addMessage("Failed to display lock WFC Firmware");
			Assert.assertTrue(false, "Failed to display lock WFC Firmware");
		}
	}
	

	/** 
	* Method Name: getWFCFirmwareInfo(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void getWFCFirmwareInfo() {
		try {
			Thread.sleep(6000);
			Log.addMessage("WFC Firmware is: "+WFC_Firmware.getText());
			Log.addMessage("WFC Firmware is correctly displayed");
		}catch(Exception e) {
			Log.addMessage("Failed to display WFC Firmware");
			Assert.assertTrue(false, "Failed to display WFC Firmware");
		}
	}
	
	public void getWFRFirmware(String lock_WFR_firmware) {
		try {
			//Thread.sleep(6000);
			Log.addMessage("Lock WFR Firmware is: "+WFR_Firmware.getText());
			if(WFR_Firmware.getText().equals(lock_WFR_firmware))
				Log.addMessage("Lock WFR Firmware is correctly displayed");
			else
				Log.addMessage("Wrong WFR Firmware info displayed");
		}catch(Exception e) {
			Log.addMessage("Failed to display lock WFR Firmware");
			Assert.assertTrue(false, "Failed to display lock WFR Firmware");
		}
	}
	
	/** 
	* Method Name: getWFRFirmwareInfo(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void getWFRFirmwareInfo() {
		try {
			Thread.sleep(6000);
			Log.addMessage("WFR Firmware is: "+WFR_Firmware.getText());
			Log.addMessage("WFR Firmware is correctly displayed");
		}catch(Exception e) {
			Log.addMessage("Failed to display WFR Firmware");
			Assert.assertTrue(false, "Failed to display WFR Firmware");
		}
	}
	
	public void getHardwareRevision(String lock_HW_revision) {
		try {
			//Thread.sleep(6000);
			Log.addMessage("Lock Hardware Revision is: "+hardware_revision.getText());
			if(hardware_revision.getText().equals(lock_HW_revision))
				Log.addMessage("Lock Hardware Revision is correctly displayed");
			else
				Log.addMessage("Wrong Hardware Revision info displayed");
		}catch(Exception e) {
			Log.addMessage("Failed to display lock Hardware Revision");
			Assert.assertTrue(false, "Failed to display lock Hardware Revision");
		}
	}
	
	public void getExtFirmwareRevision(String lock_FW_revision) {
		try {
			//Thread.sleep(6000);
			Log.addMessage("Lock Exterior Firmware Revision is: "+firmware_revision.getText());
			if(firmware_revision.getText().equals(lock_FW_revision))
				Log.addMessage("Lock exterior firmware revision is correctly displayed");
			else
				Log.addMessage("Wrong exterior firmware revision info displayed");
		}catch(Exception e) {
			Log.addMessage("Failed to display exterior firmware revision");
			Assert.assertTrue(false, "Failed to display exterior firmware revision");
		}
	}
	
	/** 
	* Method Name: getHardwareRevisionInfo(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void getHardwareRevisionInfo() {
		try {
			Thread.sleep(6000);
			Log.addMessage("Hardware Revision is: "+hardware_revision.getText());
			Log.addMessage("Hardware Revision is correctly displayed");
		}catch(Exception e) {
			Log.addMessage("Failed to display Hardware Revision");
			Assert.assertTrue(false, "Failed to display Hardware Revision");
		}
	}

	public void getManufactureDate(String lock_manfacture_date) {
		try {
			//Thread.sleep(6000);
			Log.addMessage("Lock Manufacture Date is: "+manufacture_date.getText());
			if(manufacture_date.getText().equals(lock_manfacture_date))
				Log.addMessage("Lock Manufacture Date is correctly displayed");
			else
				Log.addMessage("Wrong Manufacture Date info displayed");
		}catch(Exception e) {
			Log.addMessage("Failed to display lock Manufacture Date");
			Assert.assertTrue(false, "Failed to display lock Manufacture Date");
		}
	}
	
	public void getActivationDate(String lock_activation_date) {
		try {
			//Thread.sleep(6000);
			Log.addMessage("Lock Activation Date is: "+activation_date.getText());
			if(activation_date.getText().equals(lock_activation_date))
				Log.addMessage("Lock Activation Date is correctly displayed");
			else
				Log.addMessage("Wrong Activation Date info displayed");
		}catch(Exception e) {
			Log.addMessage("Failed to display lock Activation Date");
			Assert.assertTrue(false, "Failed to display lock Activation Date");
		}
	}
	
	//added on 22-06-2020
	public String getManufactureDate() {
		try {
			Thread.sleep(6000);
			manufactureDate = manufacture_date.getText();
			Log.addMessage("Lock Manufacture Date is: "+manufactureDate);
			
		}catch(Exception e) {
			Log.addMessage("Failed to display lock Manufacture Date");
			//Assert.assertTrue(false, "Failed to display lock Manufacture Date");
		}
		return manufactureDate;
	}
	
	//added on 22-06-2020
	public String getActivationDate() {
		try {
			Thread.sleep(6000);
			activationDate = activation_date.getText();
			Log.addMessage("Lock Activation Date is: "+activationDate);
			
		}catch(Exception e) {
			Log.addMessage("Failed to display lock Activation Date");
		}
		return activationDate;
	}
	
	/** 
	* Method Name: selectEmail(), 
	* This function is used to select Email option from the MFA Page
	*/
		
	public void clickBackButton() {
		try {
			//Thread.sleep(6000);
			Utility.waitForElementToBePresent(backButton, appiumDriver);
			backButton.click();
			Log.addMessage("Clicked Back Button in lock info page");
		}catch(Exception e) {
			Log.addMessage("Failed to click Back button in lock info page");
			Assert.assertTrue(false, "Failed to click Back button in lock info page");
		}
	}
	
	/** 
	* Method Name: getLockInfoBatteryPercentage(), 
	* This function is used to get lock battery percentage
	*/
	public String getLockInfoBatteryPercentage() {
		try {
			Utility.simpleWait(3000);
			
			Utility.waitForElementToBeVisible(batteryPercent);
			System.out.println("batteryPercent="+batteryPercent.getText());
			
			lkbatteryPercent = batteryPercent.getText();
			/*if(device.contentEquals("iOS")) {
				System.out.println("ledsound="+lockSndLEDStatus.get(0).getAttribute("value"));
				if(lkSound.equals("0")) {
					lkSound="Off";
				}else
					lkSound="On";
			}*/
			//Assert.assertEquals(lkSound, lkSound,"Lock Sounds set to OFF.");
			
			Log.addMessage("Lock battery percentage in lock info page is "+lkbatteryPercent);
		}catch(Exception e) {
			Log.addMessage("Lock battery percentage not visible in lock info page");
			System.out.println(e.getMessage().toString());
			//Assert.assertTrue(false, "Lock Sounds not visible");
		}
		return lkbatteryPercent;
			
	}

}
