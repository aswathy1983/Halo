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

public class ForgotPasswordSecretQuestionsPage extends Settings {
	
	@FindBy(xpath="*//select[@formcontrolname='secretQuestion']")
	WebElement secretQuestion;
	
	@FindBy(id="secretAnswer")
	WebElement secretAnswer;
	
	@FindBy(id="submitAnswer")
	WebElement nextButton;
	
	
	@SuppressWarnings("static-access")
	public ForgotPasswordSecretQuestionsPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Method Name: enterSecretQuestion() Description: This function will be called
	 * to enter Secret Question
	 */
	
	public void enterSecretQuestion(String ques, String ans) {
		try {
			Select qSelect =new Select(secretQuestion);
			List <WebElement> totalQue = qSelect.getOptions();
			int qSize = totalQue.size(); 
			for(int i =0; i<qSize ; i++){
				String qValue = totalQue.get(i).getText();
				if(qValue.equalsIgnoreCase(ques)) {
					Utility.simpleWait(5000);
					totalQue.get(i).click();
					secretAnswer.sendKeys(ans);
				}
			}
		}catch(Exception e) {
			Log.addMessage("Failed to enter secret question and answer");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to enter secret question and answer");
		}
	}

	/**
	 * Method Name: clickNextButton() Description: This function will be called
	 * to click Next button
	 */
	
	public void clickNextButton() {
		try {
			Assert.assertTrue(nextButton.isDisplayed(),"Next Button is visible");
			nextButton.click();
			Log.addMessage("Next Button clicked");
		}catch(Exception e) {
			Log.addMessage("Failed to click Next Button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click Next Button");
		}
	}
}
