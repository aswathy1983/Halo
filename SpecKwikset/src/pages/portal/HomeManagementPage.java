package pages.portal;

import java.util.List;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Settings;
import utility.Log;
import utility.Utility;

public class HomeManagementPage extends Settings {
	
	@FindBy(xpath="(//img[@class='history click'])[1]")
	WebElement lockButton;
	
	//@FindBy(xpath="(//img[@class='icons'])[1]")//changed on 20-Aug-2020
	@FindBy(xpath="(//img[contains(@src,'home/history.png')])[1]")
	WebElement homeLockButton;
			
	@FindBy(xpath="(//a[@class='lock-name ng-star-inserted']//img)//[1]")
	WebElement lockName;
	
	@FindBy(xpath="(//a[contains(@class,'lock-name')])")
	List<WebElement> lockNameList;
	
	@FindBy(xpath="//*[@class='sp-home-heading']")
	List<WebElement> homeList;
	
	@FindBy(xpath="(//div[contains(@class,'lock-name')])")
	WebElement lockMemName;
	
	//@FindBy(xpath="(((//div[contains(@class,'sp-home-locks')])[1]//div[contains(@class,'col-lg-10')]//div[contains(@class,'row ten-columns')])[3]//div)[1]//a")
	@FindBy(xpath="(//img[@class='lock' and (@alt='Unlocked' or @alt='Locked')])[1]")
	WebElement lockState;
	
	@FindBy(xpath="((//div[contains(@class,'row ten-columns' )])[2]//div)[3]")
	WebElement lockFW;
	
	@FindBy(xpath="(//img[@class='battery'])[1]")
	WebElement lockBtry;
	
	@FindBy(xpath="(//img[@class='history click'])[1]")
	WebElement lockHstry;
	
	@FindBy(xpath="(//img[@class='history custom-disabled'])[1]")
	WebElement lockMemHstry;
	
	@FindBy(xpath="(//button)[2]")
	WebElement acceptButton;
	
	@FindBy(xpath="(//button)[3]")
	WebElement declineButton;
	
	@FindBy(xpath="//button[contains(.,'Leave')]")
	WebElement leaveConfirmButton;
	
	@FindBy(xpath="//button[contains(.,' DECLINE ')]")
	WebElement decButton;
	
	@FindBy(xpath="//button[contains(.,' ACCEPT ')]")
	WebElement acButton;
	
	@FindBy(xpath="(//div[@class='sp-home-header'])[2]//button[contains(.,' ACCEPT ')]")
	WebElement acAdminButton;
	
	@FindBy(xpath="(//div[@class='sp-home-header'])[3]//button[contains(.,' ACCEPT ')]")
	WebElement acMemberButton;
	
	@FindBy(xpath="(//div[@class='sp-home-header'])[4]//button[contains(.,' DECLINE ')]")
	WebElement acDeclineButton;
	
	@FindBy(xpath="(//div[@class='sp-home-header'])[1]//button[contains(.,' ACCEPT ')]")
	WebElement acLeaveButton;
	
	@FindBy(xpath="//img[@alt='delete.png']")
	WebElement leaveShareButton;
	
	@FindBy(xpath="(//img[contains(@src,'home/admin.png')])[1]")
	WebElement homeManageButton;
	
	@FindBy(linkText="< Back")
	WebElement backButton;
	
	@FindBy(xpath="//img[contains(@src,'member.png')]")
	WebElement memberHomeManageButton;
	
	@FindBy(xpath="//img[contains(@src,'home/history.png')]")
	WebElement homeHistoryButton;		
	
	Boolean homeMatches, lockMatches = false;
	
	@SuppressWarnings("static-access")
	public HomeManagementPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	public void clickLockHistoryButton() throws InterruptedException {
		try {
			Utility.waitForElementToBeClickable(lockButton);
			lockButton.click();
			Log.addMessage("Clicked home history button");
		}catch(Exception e) {
			Log.addMessage("Failed to click home history button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click home history button");
		}
	}
	
	public void clickHomeLockHistoryButton() throws InterruptedException {
		try {
			Utility.simpleWait(5000);
			Utility.waitForElementToBeClickable(homeLockButton);
			homeLockButton.click();
			Log.addMessage("Clicked home history button");
		}catch(Exception e) {
			Log.addMessage("Failed to click home history button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click home history button");
		}
	}
	
	public void clickAcceptButton() throws InterruptedException {
		try {
			Utility.waitForElementToBeClickable(acceptButton);
			acceptButton.click();
			Log.addMessage("Clicked home share accept button");
		}catch(Exception e) {
			Log.addMessage("Failed to click home share accept button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click home share accept button");
		}
	}
	
	public void clickDeclineButton() throws InterruptedException {
		try {
			Utility.waitForElementToBeClickable(declineButton);
			declineButton.click();
			Log.addMessage("Clicked home share decline button");
		}catch(Exception e) {
			Log.addMessage("Failed to click home share decline button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click home share decline button");
		}
	}
	
	public void clickAcceptAdminButton() throws InterruptedException {
		try {
			Utility.simpleWait(5000);
			Utility.waitForElementToBeClickable(acAdminButton);
			acAdminButton.click();
			Log.addMessage("Clicked home share accept button");
		}catch(Exception e) {
			Log.addMessage("Failed to click home share accept button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click home share accept button");
		}
	}
	
	public void clickDeclineAdminButton() throws InterruptedException {
		try {
			Utility.simpleWait(5000);
			Utility.waitForElementToBeClickable(acDeclineButton);
			acDeclineButton.click();
			Log.addMessage("Clicked home share decline button");
		}catch(Exception e) {
			Log.addMessage("Failed to click home share decline button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click home share decline button");
		}
	}
	
	public void clickAcceptMemberButton() throws InterruptedException {
		try {
			Utility.simpleWait(5000);
			Utility.waitForElementToBeClickable(acMemberButton);
			acMemberButton.click();
			Log.addMessage("Clicked member home share accept button");
		}catch(Exception e) {
			Log.addMessage("Failed to click member home share accept button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click member home share accept button");
		}
	}
	
	public void clickAcceptAdLeaveButton() throws InterruptedException {
		try {
			Utility.simpleWait(5000);
			Utility.waitForElementToBeClickable(acLeaveButton);
			acLeaveButton.click();
			Log.addMessage("Clicked home share accept button");
		}catch(Exception e) {
			Log.addMessage("Failed to click home share accept button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click home share accept button");
		}
	}
	
	public void clickLeaveShareButton() throws InterruptedException {
		try {
			Utility.simpleWait(5000);
			Utility.waitForElementToBeClickable(leaveShareButton);
			leaveShareButton.click();
			Log.addMessage("Clicked leave home share button");
			Utility.simpleWait(3000);
			Utility.waitForElementToBeClickable(leaveConfirmButton);
			leaveConfirmButton.click();
			Log.addMessage("Confirmed leave home share");
		}catch(Exception e) {
			Log.addMessage("Failed to click leave home share button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click leave home share button");
		}
	}
	
	public void clickHomeManageButton() throws InterruptedException {
		try {
			 Utility.simpleWait(5000);
			 Utility.waitForElementToBeClickable(homeManageButton);
			 homeManageButton.click();
			 Log.addMessage("Clicked home management button");
		}catch(Exception e) {
			 Log.addMessage("Failed to click home management button");
			 System.out.println(e.getMessage().toString());
			 Assert.assertTrue(false, "Failed to click home management button");
		}
	}
	
	public void clickLockManageButton() throws InterruptedException {
		try {
			 Utility.simpleWait(5000);
			 Utility.waitForElementToBeClickable(lockNameList.get(0));
			 lockNameList.get(0).click();
			 Log.addMessage("Clicked lock management button");
		}catch(Exception e) {
			 Log.addMessage("Failed to click lock management button");
			 System.out.println(e.getMessage().toString());
			 Assert.assertTrue(false, "Failed to click lock management button");
		}
	}
	
	public void verifyHomeName(String hmName) throws InterruptedException {
		try {
			 Utility.simpleWait(5000);
			 Utility.waitForElementToBeClickable(homeList.get(0));
			 for(int i=0;i<homeList.size();i++) {
				 if((homeList.get(i).getText()).contains(hmName)) {
					 Assert.assertTrue(true, "Home name is listed");
					 homeMatches = true;
					 break;
				 }
			 }
			 if(!homeMatches) {
				 Assert.assertTrue(false, "Home name is not listed"); 
			 }
			 Log.addMessage("Clicked home management button");
		}catch(Exception e) {
			 Log.addMessage("Failed to click home management button");
			 System.out.println(e.getMessage().toString());
			 Assert.assertTrue(false, "Failed to click home management button");
		}
	}
	
	public void verifyLockName(String lkName) throws InterruptedException {
		try {
			 Utility.simpleWait(5000);
			 Utility.waitForElementToBeClickable(lockNameList.get(0));
			 for(int i=0;i<lockNameList.size();i++) {
				 if((lockNameList.get(i).getText()).contains(lkName)) {
					 Assert.assertTrue(true, "Lock name is listed");
					 lockMatches = true;
					 break;
				 }
			 }
			 if(!lockMatches) {
				 Utility.waitForElementToBeClickable(lockMemName);
				 if((lockMemName.getText()).contains(lkName)) {
					 lockMatches = true;
					 Assert.assertTrue(true, "Lock name is listed");
				 }else {
					 Assert.assertTrue(false, "Lock name is not listed"); 
				 }
			 }
			 Log.addMessage("Clicked home management button");
		}catch(Exception e) {
			 Log.addMessage("Failed to click home management button");
			 System.out.println(e.getMessage().toString());
			 Assert.assertTrue(false, "Failed to click home management button");
		}
	}
	
	public void verifyLockDetails(String lkName, String lkFw) throws InterruptedException {
		try {
			 Utility.simpleWait(5000);
			 Utility.waitForElementToBeClickable(lockNameList.get(0));
			 if((lockNameList.get(0).getText()).contains(lkName)) {
				 Assert.assertTrue(true, "Lock name is listed");
				 lockMatches = true;
			 }else {
				 Assert.assertTrue(false, "Lock name is not listed"); 
			 }
			 try {
				 Utility.waitForElementToBeClickable(lockState);
				 Assert.assertTrue(true, "Lock state is displayed");
			 }catch(Exception e) {
				 Assert.assertTrue(false, "Lock state is not displayed"); 
			 }
			 try {
				 Utility.waitForElementToBeClickable(lockFW);
				 if(lockFW.getText().equals(lkFw)) {
					 Assert.assertTrue(true, "Lock firmware is displayed");
				 }else {
					 Assert.assertTrue(false, "Lock firmware is not matching");
				 }
			 }catch(Exception e) {
				 Assert.assertTrue(false, "Lock firmware is not displayed"); 
			 }
			 try {
				 Utility.waitForElementToBeClickable(lockBtry);
				 Assert.assertTrue(true, "Lock battery is displayed");
			 }catch(Exception e) {
				 Assert.assertTrue(false, "Lock battery is not displayed"); 
			 }
			 try {
				 Utility.waitForElementToBeClickable(lockHstry);
				 Assert.assertTrue(true, "Lock history is displayed");
			 }catch(Exception e) {
				 Assert.assertTrue(false, "Lock history is not displayed"); 
			 }
			 Log.addMessage("Lock details displayed");
		}catch(Exception e) {
			 Log.addMessage("Failed to display lock details");
			 System.out.println(e.getMessage().toString());
			 Assert.assertTrue(false, "Failed to display lock details");
		}
	}
	
	public void viewLockDetails(String lkName, String lkState, String lkFw, String lkBtry, String lkHstry) throws InterruptedException {
		try {
			 Utility.simpleWait(5000);
			 Utility.waitForElementToBeClickable(lockNameList.get(0));
			 if((lockNameList.get(0).getText()).contains(lkName)) {
				 Assert.assertTrue(true, "Lock name is listed");
				 lockMatches = true;
			 }else {
				 Assert.assertTrue(false, "Lock name is not listed"); 
			 }
			 try {
				 Utility.waitForElementToBeClickable(lockState);
				 Assert.assertTrue(true, "Lock state is displayed");
			 }catch(Exception e) {
				 Assert.assertTrue(false, "Lock state is not displayed"); 
			 }
			 try {
				 Utility.waitForElementToBeClickable(lockFW);
				 if(lockFW.getText().equals(lkFw)) {
					 Assert.assertTrue(true, "Lock firmware is displayed");
				 }else {
					 Assert.assertTrue(false, "Lock firmware is not matching");
				 }
			 }catch(Exception e) {
				 Assert.assertTrue(false, "Lock firmware is not displayed"); 
			 }
			 try {
				 Utility.waitForElementToBeClickable(lockBtry);
				 Assert.assertTrue(true, "Lock battery is displayed");
			 }catch(Exception e) {
				 Assert.assertTrue(false, "Lock battery is not displayed"); 
			 }
			 try {
				 Utility.waitForElementToBeClickable(lockHstry);
				 Assert.assertTrue(true, "Lock history is displayed");
			 }catch(Exception e) {
				 Assert.assertTrue(false, "Lock history is not displayed"); 
			 }
			 Log.addMessage("Lock details displayed");
		}catch(Exception e) {
			 Log.addMessage("Failed to display lock details");
			 System.out.println(e.getMessage().toString());
			 Assert.assertTrue(false, "Failed to display lock details");
		}
	}
	
	public void clickBackButton() throws InterruptedException {
		try {
			Utility.simpleWait(5000);
			Utility.waitForElementToBeClickable(backButton);
			backButton.click();
			Log.addMessage("Clicked home management button");
		}catch(Exception e) {
			Log.addMessage("Failed to click home management button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click home management button");
		}
	}
	
	public void clickBackLMButton() throws InterruptedException {
		try {
			Utility.simpleWait(5000);
			Utility.waitForElementToBeClickable(backButton);
			backButton.click();
			Log.addMessage("Clicked lock management button");
		}catch(Exception e) {
			Log.addMessage("Failed to click lock management button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click lock management button");
		}
	}
	
	public void clickLockHistory() throws InterruptedException {
		try {
			Utility.simpleWait(5000);
			Utility.waitForElementToBeClickable(lockHstry);
			lockHstry.click();
			Log.addMessage("Clicked lock history button");
		}catch(Exception e) {
			Log.addMessage("Failed to click lock history button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click lock history button");
		}
	}
	
	public boolean checkMemberHomeManageButton() throws InterruptedException {
		try {
			Utility.simpleWait(5000);
			Utility.waitForElementToBeClickable(memberHomeManageButton);
			memberHomeManageButton.click();
			backButton.click();
			System.out.println("no exception");
			Log.addMessage("Clicked member home management button");
			return true;
		}catch(Exception e) {
			Log.addMessage("Failed to click home management button");
			System.out.println("in exception");
			System.out.println(e.getMessage().toString());
			return false;
			//Assert.assertTrue(false, "Failed to click home management button");
		}
	}
	
	public boolean checkMemberLockManageButton() throws InterruptedException {
		try {
			Utility.simpleWait(5000);
			Utility.waitForElementToBeClickable(lockMemName);
			lockMemName.click();
			backButton.click();
			System.out.println("no exception");
			Log.addMessage("Clicked member lock management button");
			return true;
		}catch(Exception e) {
			Log.addMessage("Failed to click lock management button");
			System.out.println("in exception");
			System.out.println(e.getMessage().toString());
			return false;
			//Assert.assertTrue(false, "Failed to click home management button");
		}
	}

}
