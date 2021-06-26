package pages.portal;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.Settings;
import utility.Log;
import utility.Utility;

public class SecretQuestionsPage extends Settings{
	
	
	@FindBy(xpath="//select[@formcontrolname='question1']")
	WebElement question1;
	
	@FindBy(xpath="//select[@formcontrolname='question2']")
	WebElement question2;
	
	@FindBy(xpath="//select[@formcontrolname='question3']")
	WebElement question3;
	
	@FindBy(xpath="//select[@formcontrolname='secretQuestion']")
	WebElement secQuestion;
	
	@FindBy(id="submitQuestions")
	WebElement updateButton;
	
	@FindBy(id="submitAnswer")
	WebElement submitAnswer;
	
	@FindBy(xpath="//textarea[@formcontrolname='answer1']")
	WebElement answer1;
	
	@FindBy(xpath="//textarea[@formcontrolname='answer2']")
	WebElement answer2;
	
	@FindBy(xpath="//textarea[@formcontrolname='answer3']")
	WebElement answer3;
	
	@FindBy(id="secretAnswer")
	WebElement secAnswer;
	
	@FindBy(xpath="//div[@class='modal-footer']/button")
	WebElement OKButton;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible fade in']")
	WebElement updateMessage;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible fade in']/a")
	WebElement closeButton;
	
	//@FindBy(xpath="//textarea[@formcontrolname='answer1']/following-sibling::p")
	@FindBy(xpath="(//p[@class='help-block'])[1]")
	WebElement secretAnsValidationMessage1;
	
	@FindBy(xpath="(//p[@class='help-block'])[2]")
	WebElement secretAnsValidationMessage2;
	
	@FindBy(xpath="(//p[@class='help-block'])[3]")
	WebElement secretAnsValidationMessage3;
	
	@FindBy(xpath="//p[@class='help-block']")
	WebElement secretAnsValidationMessage;
	
	
	
	@SuppressWarnings("static-access")
	public SecretQuestionsPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	/**
	 * Method Name: securityQuestionSetup() Description: This function will be called
	 * to set up security questions
	 * @throws InterruptedException 
	 */
	
	public void securityQuestionSetup(WebElement question, WebElement answer, String ques, String ans) throws InterruptedException {
			Select qSelect =new Select(question);
			System.out.println("-----ans b4 :"+ans);
			List <WebElement> totalQue = qSelect.getOptions();
			int qSize = totalQue.size(); 
			System.out.println("No:of questions is :"+qSize);
			System.out.println("ques="+ques);
			for(int i =0; i<qSize ; i++){
				String qValue = totalQue.get(i).getText();
				System.out.println("qValue="+qValue);
				if(qValue.equalsIgnoreCase(ques)) {
					System.out.println("before qn click");
					totalQue.get(i).click();
					System.out.println("----ans after click :"+ans+"-----");
					answer.clear();
					answer.sendKeys(ans);
					Utility.simpleWait(6000);
					break;
				}
			}
	}
	

	/**
	 * Method Name: secretQuestion1() Description: This function will be called
	 * to setup secret question1
	 */
	
	public void secretQuestion1(String que1, String ans1) {
	try {
		System.out.println("in secqn1 qn1="+que1+", ans1="+ans1);
		securityQuestionSetup(question1,answer1,que1,ans1);
		Log.addMessage("Security Question 1 setup completed");
	}catch(Exception e) {
		Log.addMessage("Security Question 1 setup failed");
		System.out.println(e.getMessage().toString());
		Assert.assertTrue(false,"Security Question 1 setup failed");
		}
   }
	
	/**
	 * Method Name: secretQuestion2() Description: This function will be called
	 * to setup secret question2
	 */
	
	public void secretQuestion2(String que2, String ans2) {
		try {
			System.out.println("in secqn2 qn2="+que2+", ans2="+ans2);
			securityQuestionSetup(question2,answer2,que2,ans2);
			Log.addMessage("Security Question 2 setup completed");
		}catch(Exception e) {
			Log.addMessage("Security Question 2 setup failed");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false,"Security Question 2 setup failed");
			}
	   }

	/**
	 * Method Name: secretQuestion3() Description: This function will be called
	 * to setup secret question3
	 */
	
	public void secretQuestion3(String que3, String ans3) {
		try {
			System.out.println("in secqn3 qn3="+que3+", ans3="+ans3);
			securityQuestionSetup(question3,answer3,que3,ans3);
			Log.addMessage("Security Question 3 setup completed");
		}catch(Exception e) {
			Log.addMessage("Security Question 3 setup failed");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false,"Security Question 3 setup failed");
			}
	   }
	
	/**
	 * Method Name: clickUpdateButton Description: This function will be called
	 * to click update button
	 */
	
	public void clickUpdateButton() {
		try {
			Utility.simpleWait(6000);
			Assert.assertTrue(updateButton.isDisplayed(), "Update Button is visible");
			updateButton.click();
			Utility.simpleWait(15000);
			Log.addMessage("Update Button is clicked");
		}
		catch(Exception e) {
			Log.addMessage("Failed to click Update Button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click Update button");
		}
	}
	
	/**
	 * Method Name: clickOkButton() Description: This function will be called
	 * to click OK button
	 */
	
	public void clickOKButton() {
		try {
			Utility.waitForElementToBeVisible(OKButton);
			Assert.assertTrue(OKButton.isDisplayed());
			OKButton.click();
		}catch(Exception e) {
			Log.addMessage("Failed to click OK Button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click OK Button");
		}
	}
	
	public void checkUpdateMessage(String successMessage) {
		try {
			Utility.waitForElementToBeVisible(updateMessage);
			Assert.assertTrue(updateMessage.getText().contains(successMessage),"Security Questions updated successfully");
			Utility.simpleWait(3000);
			closeButton.click();
		}catch(Exception e) {
			Log.addMessage("Failed to update security questions");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Security Questions not updated");
		}
	}
	
	/**
	 * Method Name: checkUpdateButton() Description: This function will be called
	 * to click send button
	 */
	
	public void checkUpdateButton() {
		try {
			Utility.waitForElementToBeVisible(updateButton);
			//Utility.waitForElementToBeClickable(updateButton);
			Assert.assertTrue(!(updateButton.isEnabled()), "Update button is disabled for invalid selection");
			Log.addMessage("Update button clicked");
		}
		catch(Exception e) {
			Log.addMessage("Failed to disable update button for invalid selection");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to disable update button for invalid selection");
		}
	}
	
	/**
	 * Method Name: invalidAns1Check() Description: This function will be called
	 * to enter phone number and verify the same
	 */
	
	public void invalidAns1Check() {
		try {
			Utility.simpleWait(6000);
			Utility.waitForElementToBeVisible(secretAnsValidationMessage1);
			System.out.println("Validation message is: "+secretAnsValidationMessage1.getText());
			Assert.assertTrue(secretAnsValidationMessage1.isDisplayed(), "Validation message displayed for security answer1 does not exist");
			//Assert.assertEquals(secretAnsValidationMessage1.getText(), valMessage, "Incorrect validation");
			Log.addMessage("Security answer1 to be verified is entered");
		}
		catch(Exception e) {
			Log.addMessage("Failed to enter security answer1");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter security answer1");
		}
	}
	/**
	 * Method Name: invalidAns2Check() Description: This function will be called
	 * to enter phone number and verify the same
	 */
	
	public void invalidAns2Check() {
		try {
			Utility.simpleWait(6000);
			
			Utility.waitForElementToBeVisible(secretAnsValidationMessage2);
			System.out.println("Validation message is: "+secretAnsValidationMessage2.getText());
			Assert.assertTrue(secretAnsValidationMessage2.isDisplayed(), "Validation message displayed for security answer2 does not exist");
			//Assert.assertEquals(secretAnsValidationMessage1.getText(), valMessage, "Incorrect validation");
			Log.addMessage("Security answer2 to be verified is entered");
		}
		catch(Exception e) {
			Log.addMessage("Failed to enter security answer2");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter security answer2");
		}
	}
	/**
	 * Method Name: invalidAns3Check() Description: This function will be called
	 * to enter phone number and verify the same
	 */
	
	public void invalidAns3Check() {
		try {
			Utility.simpleWait(6000);
			
			Utility.waitForElementToBeVisible(secretAnsValidationMessage3);
			System.out.println("Validation message is: "+secretAnsValidationMessage3.getText());
			Assert.assertTrue(secretAnsValidationMessage3.isDisplayed(), "Validation message displayed for security answer3 does not exist");
			//Assert.assertEquals(secretAnsValidationMessage1.getText(), valMessage, "Incorrect validation");
			Log.addMessage("Security answer3 to be verified is entered");
		}
		catch(Exception e) {
			Log.addMessage("Failed to enter security answer3");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter security answer3");
		}
	}
	
	/**
	 * Method Name: invalidAnsCheck() Description: This function will be called
	 * to enter phone number and verify the same
	 */
	
	public void invalidAnsCheck(String valMessage) {
		try {
			Utility.simpleWait(6000);
			
			Utility.waitForElementToBeVisible(secretAnsValidationMessage);
			System.out.println("Validation message is: "+secretAnsValidationMessage.getText());
			//Assert.assertTrue(secretAnsValidationMessage.isDisplayed(), "Validation message displayed for security answer1 does not exist");
			Assert.assertEquals(secretAnsValidationMessage.getText().contains(valMessage), "Incorrect validation");
			Log.addMessage("Security answer to be verified is entered");
		}
		catch(Exception e) {
			Log.addMessage("Failed to enter security answer");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter security answer");
		}
	}
	
	/**
	 * Method Name: placeHolderAnsTextCheck() Description: This function will be called
	 * to verify the place holder text in answer field
	 */
	
	public void placeHolderAnsTextCheck() {
		try {
			Utility.simpleWait(6000);
			Utility.waitForElementToBeVisible(secAnswer);
			System.out.println("secAnswer is: "+secAnswer);
			System.out.println("Answer is: "+secAnswer.getText());
			Assert.assertTrue(secAnswer.isDisplayed(), "Validation message displayed for security answer1 does not exist");
			Assert.assertEquals(secAnswer.getAttribute("placeholder"), "Answer", "Incorrect place holder text display");
			Log.addMessage("Security answer to be verified is entered");
		}
		catch(Exception e) {
			Log.addMessage("Failed to enter security answer");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter security answer");
		}
	}
	
	/**
	 * Method Name: secretQuestion1() Description: This function will be called
	 * to setup secret question1
	 */
	
	public void rcvrSecretQuestion(String que1, String ans1) {
	try {
		System.out.println("in secqn qn="+que1+", ans1="+ans1);
		securityQuestionSetup(secQuestion,secAnswer,que1,ans1);
		Log.addMessage("Security Question setup completed");
	}catch(Exception e) {
		Log.addMessage("Security Question setup failed");
		System.out.println(e.getMessage().toString());
		Assert.assertTrue(false,"Security Question setup failed");
		}
   }
	
   /**
	 * Method Name: clickUpdateRcvrButton Description: This function will be called
	 * to click Next button
   */
	public void clickUpdateRcvrButton() {
		try {
			Utility.simpleWait(6000);
			Utility.waitForElementToBeVisible(submitAnswer);
			//Assert.assertTrue(submitAnswer.isDisplayed(), "Next Button is visible");
			submitAnswer.click();
			//Utility.simpleWait(15000);
			Log.addMessage("Next Button is clicked");
		}
		catch(Exception e) {
			Log.addMessage("Failed to click Next Button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click Next button");
		}
	}
	
	/**
	 * Method Name: checkUpdateRcvrButton() Description: This function will be called
	 * to click send button
	*/
	public void checkUpdateRcvrButton() {
		try {
			Utility.waitForElementToBeVisible(submitAnswer);
			Utility.waitForElementToBeClickable(submitAnswer);
			Assert.assertTrue(false, "Failed to disable next button for invalid selection");
			Log.addMessage("Next button clicked");
		}
		catch(Exception e) {
			Log.addMessage("Next button is disabled for invalid selection");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(true, "Next button is disabled for invalid selection");
		}
	}
	
	/** 
	* Method Name: updateSecurityQuestion(), 
	* This function is used to update the Security Question
	*/
	public void updateSecurityQuestion(String qn1,String ans1,String qn2,String ans2,String qn3,String ans3, String errMessage, String valMessage, String mainMessage) {
		try {	
			
			System.out.println("qn1="+qn1);
			secretQuestion1(qn1, ans1);
		
			secretQuestion2(qn2, ans2);
		
			secretQuestion3(qn3, ans3);
			
			/*if(errMessage!="") {
				Assert.assertTrue(updateMessage.getText().contains(titleMsg), "Validation is proper");
				closeButton.click();
				Log.addMessage("Validation message for Change Security Questions is proper");
			}*/
			if(errMessage!="") {
				Assert.assertTrue(secretAnsValidationMessage1.getText().contains(errMessage), "Validation is proper");
				Log.addMessage("Validation message for Security Answer1 is proper");
			}
			if(valMessage!="" && errMessage!="") {
				Assert.assertTrue(secretAnsValidationMessage2.getText().contains(valMessage), "Validation is proper");
				Log.addMessage("Validation message for Security Answer2 is proper");
			}else if(valMessage!="") {
				Assert.assertTrue(secretAnsValidationMessage1.getText().contains(valMessage), "Validation is proper");
				Log.addMessage("Validation message for Security Answer2 is proper");
			}
			if(mainMessage!="" && valMessage!="" && errMessage!="") {
				Assert.assertTrue(secretAnsValidationMessage3.getText().contains(mainMessage), "Validation is proper");
				Log.addMessage("Validation message for Security Answer3 is proper");
			}else if((mainMessage!="" && valMessage!="") || (mainMessage!="" && errMessage!="")) {
				Assert.assertTrue(secretAnsValidationMessage2.getText().contains(mainMessage), "Validation is proper");
				Log.addMessage("Validation message for Security Answer3 is proper");
			}else if (mainMessage!="") {
				Assert.assertTrue(secretAnsValidationMessage1.getText().contains(mainMessage), "Validation is proper");
				Log.addMessage("Validation message for Security Answer3 is proper");
			}
			/*if(mainMessage!="") {
			updateButton.click();
			}else {*/
				checkUpdateButton();
			//}
			System.out.println("out");
			Log.addMessage("Security Questions Edited");
		}catch(Exception e) {
			Log.addMessage("Security Questions is not Edited");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Security Questions is not Edited");
		}
			
	}
	
}
