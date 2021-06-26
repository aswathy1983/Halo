package utility;

import java.io.IOException;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import base.Settings;

public class RetryAnalyzer implements IRetryAnalyzer  {
	 
	 int counter = 0;
	 int retryLimit = 10;
	 Settings s;
	 /*
	 * (non-Javadoc)
	 * @see org.testng.IRetryAnalyzer#retry(org.testng.ITestResult)
	 * 
	 * This method decides how many times a test needs to be rerun.
	 * TestNg will call this method every time a test fails. So we 
	 * can put some code in here to decide when to rerun the test.
	 * 
	 * Note: This method will return true if a tests needs to be retried
	 * and false it not.
	 *
	 */
	 
	 @SuppressWarnings("static-access")
	@Override
	 public boolean retry(ITestResult result) {
		s.driver.quit();
		try {
			s.iOSSettings();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	 if(counter < retryLimit)
	 {
	 counter++;
	 return true;
	 }
	 return false;
	 }
	}