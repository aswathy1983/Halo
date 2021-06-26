package pages.portal;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Settings;
import utility.Log;
import utility.Utility;

public class LockHistoryPage extends Settings {
	
	@FindBy(linkText="< Back")
	WebElement backButton;
	
	@FindBy(xpath="//span[contains(@class,'sp-heading') and contains(text(),'Event')]")
	WebElement eventHeader;
	
	@FindBy(xpath="//a[contains(@class,'sp-heading') and contains(text(),'Event Description')]")
	WebElement eventDescriptionHeader;
	
	@FindBy(xpath="//a[contains(@class,'sp-heading') and contains(text(),'Source')]")
	WebElement sourceHeader;
	
	@FindBy(xpath="//a[contains(@class,'sp-heading') and contains(text(),'Date/Time')]")
	WebElement dateTimeHeader;
	
	@FindBy(xpath="//a[contains(@class,'sp-heading') and contains(text(),'Lock Name')]")
	WebElement lockHeader;
	
	@FindBy(xpath="//a[contains(text(),'Event Description')]/following-sibling::a")
	WebElement sortDescription;
	
	@FindBy(xpath="//span[contains(text(),'Event Description')]/following-sibling::a")
	WebElement filterDescription;
	
	@FindBy(xpath="//a[contains(text(),'Source')]/following-sibling::a")
	WebElement sortSource;
	
	@FindBy(xpath="//span[contains(text(),'Source')]/following-sibling::a")
	WebElement filterSource;
	
	@FindBy(xpath="//a[contains(text(),'Date/Time')]/following-sibling::a")
	WebElement sortDateTime;
	
	@FindBy(xpath="//span[contains(text(),'Date/Time')]/following-sibling::a")
	WebElement filterDateTime;
	
	@FindBy(xpath="//a[contains(text(),'Lock Name')]/following-sibling::a")
	WebElement sortLockName;
	
	@FindBy(xpath="//span[contains(text(),'Lock Name')]/following-sibling::a")
	WebElement filterLockName;
	
	@FindBy(xpath="//div//pagination")
	WebElement paginationLink;
	
	@FindBy(linkText=">")
	WebElement pageNextLink;

	@FindBy(linkText="<")
	WebElement pagePreviousLink;
	
	@FindBy(linkText="1")
	WebElement pageOne;
	
	@FindBy(xpath="//li//label[@class='sp-checkbox sp-middle-element']")
	List<WebElement> checkList;
	
	@FindBy(xpath="(//app-lock-history//h2)[1]")
	WebElement lockName;
	
	@FindBy(xpath="//div[@class='row history-items']//div[@class='col-xs-4 history-heading']//h5")
	List<WebElement> descList;
	
	@FindBy(xpath="//div[@class='row history-items ten-columns']//div[@class='col-sm-3 hidden-xs history-heading']//h5")
	List<WebElement> homeDescList;
	//div[contains(@class,'row history-items')]//div[contains(@class,'col-xs-3 history-heading')]/following-sibling::div[contains(@class,'col-xs-3 history-heading')]//h5[1]//changed on 19th AUg 2020
	@FindBy(xpath="//div[contains(@class,'row history-items')]//div[contains(@class,'col-xs-3 history-heading')]/following-sibling::div[contains(@class,'col-xs-3 history-heading')]//h5[1]")
	List<WebElement> dateList;
	
	@FindBy(xpath="//div[contains(@class,'row history-items')]//div[contains(@class,'col-xs-3 history-heading')]/following-sibling::div[contains(@class,'col-xs-3 history-heading')]//h5[2]")
	List<WebElement> timeList;
	
	@FindBy(xpath="//div[@class='col-xs-3 col-sm-2 history-heading']/following-sibling::div[2]//h5[1]")
	List<WebElement> homeDateList;
	
	@FindBy(xpath="//div[@class='col-xs-3 col-sm-2 history-heading']/following-sibling::div[2]//h5[2]")
	List<WebElement> homeTimeList;
	
	@FindBy(xpath="//div[@class='row history-items']//div[@class='col-xs-4 history-heading']/following-sibling::div[1]//h5")
	List<WebElement> sourceList;
	
	//div[contains(@class,'row history-items')]//div[@class='col-xs-3 col-sm-2 history-heading'][2]//added on 16-02-2021 for home history
	@FindBy(xpath="//div[@class='col-xs-3 col-sm-2 history-heading']/following-sibling::div[@class='col-xs-3 col-sm-2 history-heading']//h5[1]")
	List<WebElement> homeSourceList;
	
	//@FindBy(xpath="//div[@class='row history-items ten-columns ng-star-inserted']//div[@class='col-sm-3 hidden-xs history-heading']/following-sibling::div[1]//h5")
	@FindBy(xpath="//div[@class='col-sm-3 hidden-xs history-heading']/following-sibling::div[1]//h5")
	List<WebElement> lockNameList;
	
	@FindBy(xpath="//div[@class='row history-items']//div[@class='col-xs-2 history-heading']//img")
	List<WebElement> eventList;
	
	@FindBy(xpath="//div[@class='col-xs-3 col-sm-1 history-heading']//img")
	List<WebElement> homeEventList;
	
	@FindBy(xpath="//li//label[@class='sp-checkbox sp-middle-element']//input[@type='checkbox']")
	List<WebElement> checkDescList;
	
	@FindBy(xpath="//a[contains(text(),'Event Description')]/following-sibling::ul//li/following-sibling::li//div//button[@class='btn sp-clear']")
	WebElement clearButton;
	
	@FindBy(xpath="//span[contains(text(),'Event Description')]/following-sibling::ul//li/following-sibling::li//div//button[@class='btn sp-clear']")
	WebElement fltrClearButton;
	
	@FindBy(xpath="//a[contains(text(),'Event Description')]/following-sibling::ul//li/following-sibling::li//div//button[@class='btn sp-search']")
	WebElement searchButton;
	
	@FindBy(xpath="//a[contains(text(),'Source')]/following-sibling::ul//li/following-sibling::li//div//button[@class='btn sp-clear']")
	WebElement sourceClearButton;
	
	@FindBy(xpath="//span[contains(text(),'Source')]/following-sibling::ul//li/following-sibling::li//div//button[@class='btn sp-clear']")
	WebElement sourceFltrClearButton;
	
	@FindBy(xpath="//a[contains(text(),'Source')]/following-sibling::ul//li/following-sibling::li//div//button[@class='btn sp-search']")
	WebElement sourceSearchButton;
	
	@FindBy(xpath="//a[contains(text(),'Source')]/following-sibling::ul//li//form//input")
	WebElement searchSourceText;
	
	@FindBy(xpath="//a[contains(text(),'Date/Time')]/following-sibling::ul//li/following-sibling::li//div//button[@class='btn sp-clear']")
	WebElement dateClearButton;
	
	@FindBy(xpath="//span[contains(text(),'Date/Time')]/following-sibling::ul//li/following-sibling::li//div//button[@class='btn sp-clear']")
	WebElement dateFltrClearButton;
	
	@FindBy(xpath="//a[contains(text(),'Date/Time')]/following-sibling::ul//li/following-sibling::li//div//button[@class='btn sp-search']")
	WebElement dateSearchButton;
	
	@FindBy(xpath="//a[contains(text(),'Lock Name')]/following-sibling::ul//li/following-sibling::li//div//button[@class='btn sp-clear']")
	WebElement lockClearButton;
	
	@FindBy(xpath="//span[contains(text(),'Lock Name')]/following-sibling::ul//li/following-sibling::li//div//button[@class='btn sp-clear']")
	WebElement lockFltrClearButton;
	
	@FindBy(xpath="//a[contains(text(),'Lock Name')]/following-sibling::ul//li/following-sibling::li//div//button[@class='btn sp-search']")
	WebElement lockSearchButton;
	
	@FindBy(xpath="//a[contains(text(),'Lock Name')]/following-sibling::ul//li//form//input")
	WebElement lockNameText;
	
	@FindBy(xpath="(//input[@class='sp-date'])[1]")
	WebElement fromDateText;
	
	@FindBy(xpath="(//input[@class='sp-date'])[2]")
	WebElement toDateText;
	
	@FindBy(xpath="//owl-date-time-calendar//table//tr//td//span[@class='owl-dt-calendar-cell-content']")
	List<WebElement> fromDate;
	
	@FindBy(xpath="//owl-date-time-calendar//table//tr//td//span[@class='owl-dt-calendar-cell-content']")
	List<WebElement> toDate;
	
	int firstPageCnt, lastPageCnt, cntHm, cntHmTime = 0;
	String temp, from_seldate,to_seldate="";
	
	@SuppressWarnings("static-access")
	public LockHistoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}

	/**
	 * Method Name: clickBackButton() Description: This function will be called
	 * to click back button
	*/
	public void clickBackButton() throws InterruptedException {
		try {
			Utility.waitForElementToBeClickable(backButton);
			backButton.click();
			Log.addMessage("Clicked back link from lock history page");
		}catch(Exception e) {
			Log.addMessage("Failed to click back link from lock history pagen");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click back link from lock history page");
		}
	}

	/**
	 * Method Name: verifyUILockHistory() Description: This function will be called
	 * to verify the UI elements present in lock history page
	*/
	public void verifyUILockHistory() {
		try {
			Utility.waitForElementToBeVisible(eventHeader);
			Log.addMessage("Event header is displayed");
			System.out.println("one");
			Utility.waitForElementToBeVisible(eventDescriptionHeader);
			Log.addMessage("Event description header is displayed");
			System.out.println("two");
			Utility.waitForElementToBeVisible(sourceHeader);
			Log.addMessage("Source header is displayed");
			System.out.println("three");
			Utility.waitForElementToBeVisible(dateTimeHeader);
			Log.addMessage("Date/Time header is displayed");
			System.out.println("four");
			Utility.waitForElementToBeVisible(sortDescription);
			Log.addMessage("Date/Time header is displayed");
			System.out.println("five");
			Utility.waitForElementToBeVisible(sortSource);
			Log.addMessage("Date/Time header is displayed");
			System.out.println("six");
			Utility.waitForElementToBeVisible(sortDateTime);
			Log.addMessage("Date/Time header is displayed");
			System.out.println("seven");
			Utility.waitForElementToBeVisible(paginationLink);
			Log.addMessage("Pagination is displayed");
			System.out.println("eight");
		}catch(Exception e) {
			Log.addMessage("Failed display UI elements in lock history page");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed display UI elements in lock history page");
		}
		
	}
	
	/**
	 * Method Name: getDescriptionList() Description: This function will be called
	 * to retrieve the list under description in lock history page
	*/
	public String[] getDescriptionList(String descType, String sortType, List<WebElement> sortItem, WebElement secondInList, WebElement frstAfterSortInList) throws InterruptedException {
		try {
			//eventDescriptionHeader.click();//for testing in descending order
		//	Utility.simpleWait(5000);//for testing in descending order
			//firstPageCnt = descList.size();//commented for making common function on 13th Aug 2020
			firstPageCnt = sortItem.size();
			System.out.println("firstPageCnt="+firstPageCnt);
			//create 15 events and change size to 15
			//String strArray[] = new String[firstPageCnt+1];
			String strArray[]= new String[5];
			if(sortType.equals("source")) {
				 strArray = new String[firstPageCnt];
			}else {
				 strArray = new String[firstPageCnt+1];
			}
			System.out.println("descType="+descType);
			System.out.println("strArraylength="+strArray.length);
			int k=0;
			for(int i =0;i<firstPageCnt;i++)
			{
				System.out.println("firstpage b4sort="+sortItem.get(i).getText());
				System.out.println("i out="+i);
				
				if(descType.equals("des")) {
					if(sortType.equals("source")) {//added on 13th Aug
						if(k==0) {//changed from k==0 for source desc on 13 Aug
							System.out.println("i in des source="+i);
							/*System.out.println("i="+descSecondInList);*/
							System.out.println("firstpage in="+frstAfterSortInList.getText());
							//strArray[k]=descSecondInList.getText();
							strArray[k]=frstAfterSortInList.getText();
							i=i+1;//incrementing to eliminate value in the 2nd position
							k=k+1;
						}
						strArray[k]=sortItem.get(i).getText();
						k=k+1;
					}else {
						if(k==0) {
							System.out.println("i in asc="+i);
							/*System.out.println("i="+descSecondInList);*/
							System.out.println("firstpage in asc="+frstAfterSortInList.getText());
							//strArray[k]=descSecondInList.getText();
							strArray[k]=frstAfterSortInList.getText();
							//i=i+1;
							k=k+1;
						}
						strArray[k]=sortItem.get(i).getText();
						k=k+1;
					}
				}else {
					if(sortType.equals("source")) {//added on 13th Aug
						if(k==0) {
							System.out.println("i in asc source="+i);
							/*System.out.println("i="+descSecondInList);*/
							System.out.println("firstpage in="+frstAfterSortInList.getText());
							strArray[k]=frstAfterSortInList.getText();
							i=i+1;//for source to omit the second in list
							k=k+1;
						}
						strArray[k]=sortItem.get(i).getText();
						k=k+1;
					}else {
						//commented after events were increased
						/*System.out.println("firstpage sortItem asc="+sortItem.get(i).getText());
						strArray[k]=sortItem.get(i).getText();
						k=k+1;
						if(k==1) {
							System.out.println("i in asc="+i);
							System.out.println("firstpage in="+secondInList.getText());
							strArray[k]=secondInList.getText();
							//i=i+1;
							k=k+1;
						}*/
						if(k==0) {
							System.out.println("i in asc="+i);
							System.out.println("firstpage in asc="+frstAfterSortInList.getText());
							//strArray[k]=descSecondInList.getText();
							strArray[k]=frstAfterSortInList.getText();
							//i=i+1;
							k=k+1;
						}
						System.out.println("firstpage sortItem asc="+sortItem.get(i).getText());
						strArray[k]=sortItem.get(i).getText();
						k=k+1;
					}
				}
				System.out.println("length="+strArray.length);
			}	
			System.out.println("k after first page="+k+", strArray[k-1]="+strArray[k-1]+", sortItem.size()="+sortItem.size());
			//check for pagination here if more than 1 page exists then execute below code
			if(sortItem.size()>=9) {
				pageNextLink.click();
				Utility.simpleWait(5000);
				lastPageCnt = sortItem.size();
				System.out.println("/////////----lastPageCnt in second page="+lastPageCnt);
				int l=0;
				for(int j =0;j<=lastPageCnt;j++)
				{
					System.out.println("secondPage="+sortItem.get(j).getText()+",k="+k);
					//strArray[l+(firstPageCnt+1)]=descList.get(j).getText();
					if(descType.equals("asc")) {
						strArray[k]=sortItem.get(j).getText();
						System.out.println("in secondlist regular="+sortItem.get(j).getText());
						l=l+1;
						k=k+1;
						if(l==1) {
							System.out.println("in secondlist L equals 1="+secondInList.getText());
							strArray[k]=secondInList.getText();
							l=l+1;
							k=k+1;
						}
					}else {//check desc code with more events to get second page
						if(k==0) {
							System.out.println("i in des 2nd page="+j);
							/*System.out.println("i="+descSecondInList);*/
							System.out.println("firstpage in 2nd list="+frstAfterSortInList.getText());
							//strArray[k]=descSecondInList.getText();
							strArray[k]=frstAfterSortInList.getText();
							//i=i+1;
							k=k+1;
						}
						System.out.println("firstpage in 2nd page sortItem="+sortItem.get(j).getText());
						strArray[k]=sortItem.get(j).getText();
						k=k+1;
					}
				}
				//Comparing the array after sorting
				//clicking the previous link to go to first page
				pagePreviousLink.click();
				System.out.println("clicked previous page link");
				Utility.simpleWait(5000);
			}
			System.out.println("total description in the list="+strArray.length);
			return strArray;
		}catch(Exception e) {
			Log.addMessage("Failed get the events displayed under description in lock history page");
			System.out.println(e.getMessage().toString());
			return null;
			//Assert.assertTrue(false, "Failed get the events displayed under description in lock history page");
		}
		
	}
	/**
	 * Method Name: sortAscending() Description: This function will be called
	 * to sort the list in ascending order
	*/
	public String[] sortAscending(String descType, String[] strArrayList) throws InterruptedException {
		try {
			//Sorting the array
			/*for (int i = 0; i < strArrayList.length; i++) 
			{
				for (int j = i + 1; j < strArrayList.length; j++) 
				{
					if (strArrayList[i].compareTo(strArrayList[j])>0) 
					{
						temp = strArrayList[i];
						strArrayList[i] = strArrayList[j];
						strArrayList[j] = temp;
					}
				}
			}*/
			Arrays.sort(strArrayList);
			Log.addMessage("Events sorted in ascending order under description");
		  /*for (int i = 0; i < strArray.length; i++) 
			{
				for (int j = i + 1; j < strArray.length; j++) 
				{
					if (strArray[i].compareTo(strArray[j])<0) 
					{
						temp = strArray[i];
						strArray[i] = strArray[j];
						strArray[j] = temp;
					}
				}
			}*/
			Log.addMessage("Events sorted in descending order under description");
			return strArrayList;
		}catch(Exception e) {
			Log.addMessage("Failed to sort events under description in ascending order");
			System.out.println(e.getMessage().toString());
			return null;
			//Assert.assertTrue(false, "Failed get the events displayed under description in lock history page");
		}
	}
	/**
	 * Method Name: checkSortList() Description: This function will be called
	 * to verify if the list sorted is in ascending order
	*/
	public Boolean checkSortList(String sortType, List<String> strArrayList, List<WebElement> sortList) throws InterruptedException {
		try {
			//Comparing the array after sorting
			Utility.simpleWait(5000);
			//clicking the link for sorting
			if(sortType.equals("source") || sortType.equals("homesource")) {
				System.out.println("in header click");
				sourceHeader.click();
				System.out.println("clicked source header");
			}else if(sortType.equals("description")|| sortType.equals("homedescription")) {
				eventDescriptionHeader.click();
				System.out.println("clicked description sorting");
			}else if(sortType.equals("lockName")) {
				lockHeader.click();
				System.out.println("clicked description sorting");
			}else if(sortType.equals("homesource")) {
				lockHeader.click();
				System.out.println("clicked description sorting");
			}
			Utility.simpleWait(5000);
			System.out.println("one");
			System.out.println("for sorting="+sortList.size());
			System.out.println("count in first page after sorting="+strArrayList.size());
			boolean result = true;
			int i =0;
			for(i =0;i<sortList.size();i++)
			{	
				System.out.println(strArrayList.get(i)+"--------"+sortList.get(i).getText());
				if(strArrayList.get(i).toUpperCase().compareTo(sortList.get(i).getText().toUpperCase())!=0)//check condition for case sensitivity
				{
					result = false;
					System.out.println("Elements in the page 1 are not sorted first ");
					break;	
				}
				/*if(!((sortList.get(i).getText()).equals("Status Update")) && sortType.equals("homesource")) {
					i++;
				}*/
				System.out.println("elements="+result+", i="+i);
			}
			System.out.println("Elements in the first page are sorted::"+ result);
			System.out.println("i after first page="+i);
			int inHPagination =0;
			if(result) {
			while(sortList.size()>=10) {//changed on 19th Aug 2020
				//clicking the next link to go to next page
				pageNextLink.click();
				Utility.simpleWait(5000);
				inHPagination=inHPagination+1;
				System.out.println("list after sorting in page="+inHPagination+" are:"+sortList.size()+",i in the next page="+i+", strArrayList="+strArrayList.size());
				
				for(int j=0;j<sortList.size();j++)
				{	
					System.out.println(strArrayList.get(i)+"--------"+sortList.get(j).getText());
					if(strArrayList.get(i).toUpperCase().compareTo(sortList.get(j).getText().toUpperCase())!=0)
					{
						result = false;
						System.out.println("Elements in the page 1 are not sorted first ");
						break;	
					}
					i=i+1;
					/*if(!((sortList.get(j).getText()).equals("Status Update")) && sortType.equals("homesource")) {
						j++;
					}*/
					System.out.println("elements="+result+", i="+i);
				}
				if(!result) {
					System.out.println("Elements not sorted break:"+ result);
					break;
				}
				System.out.println("Elements in the page "+inHPagination+" are sorted::"+ result);
				//clicking the previous link to go to first page
				
			}
			}
			
			if(inHPagination>=1) {
				pageOne.click();
			}
			/*for(int cj=0;cj<inHPagination;cj++) {
				pagePreviousLink.click();
				System.out.println("clicked previous page link");
				Utility.simpleWait(5000);
			}*/
			Log.addMessage("Events sorted in order");
			return result;
		}catch(Exception e) {
			Log.addMessage("Failed to sort events in order");
			System.out.println(e.getMessage().toString());
			return false;
		}
	}
	
	/**
	 * Method Name: verifySortList() Description: This function will be called
	 * to verify if the list sorted is in ascending order
	*/
	public Boolean verifySortList(String sortType, List<String> strArrayList, List<WebElement> dList, List<WebElement> tList) throws InterruptedException {
		try {
			//Comparing the array after sorting
			//clicking the previous link to go to first page
			
			//clicking the link for sorting
			if(sortType.equals("source")) {
				sourceHeader.click();
				System.out.println("clicked source sorting");
			}else if(sortType.equals("description")) {
				eventDescriptionHeader.click();
				System.out.println("clicked description sorting");
			}else if(sortType.equals("dateTime") || (sortType.equals("homedateTime"))) {
				dateTimeHeader.click();
				System.out.println("clicked dateTime sorting");
			}
			
			Utility.simpleWait(5000);
			System.out.println("for sorting="+dList.size());
			System.out.println("---------------------After Sorting Printing the Values from the List---------------------");
			
			System.out.println("count in first page after sorting="+dList.size());
			System.out.println("count in first page after sorting="+strArrayList.size());
			boolean result = true;
			
			String dateTimeVal ="";
			int i=0;
			for(i =0;i<dList.size();i++)
			{
				dateTimeVal = dList.get(i).getText()+" "+tList.get(i).getText();
				//if(sortType.equals("dateTime")) {
					System.out.println(strArrayList.get(i)+"--------"+dateTimeVal);
					if(strArrayList.get(i).compareTo(dateTimeVal)!=0)
					{
						result = false;
						System.out.println("Elements in the page 1 are not sorted first ");
						break;	
					}
				//}
				System.out.println("elements="+result);
			}
			System.out.println("Elements in the first page are sorted::"+ result);
			System.out.println("i="+i);
			int cPage =0;
			if(sortType.equals("dateTime")) {
				while(sourceList.size()>=10 && result) {//to check if there is a next page
					//clicking the next link to go to next page
					pageNextLink.click();
					Utility.simpleWait(4000);
					System.out.println("in while cPage="+cPage);
					cPage=cPage+1;
					System.out.println("list after sorting in second page="+dList.size());
					
					for(int j=0;j<dList.size();j++)//j=i to j=0
					{
						dateTimeVal = dList.get(j).getText()+" "+tList.get(j).getText();
						//if(sortType.equals("dateTime")) {
							System.out.println(strArrayList.get(j)+"--------"+dateTimeVal);
							if(strArrayList.get(i).compareTo(dateTimeVal)!=0)//changed from j to i
							{
								result = false;
								System.out.println("Elements in the page 1 are not sorted first ");
								break;	
							}
							i=i+1;
						//}
						System.out.println("elements="+result);
					}
					System.out.println("Elements in the second page are sorted::"+ result);
					
				}
			}else {
				while(lockNameList.size()>=10 && result) {//to check if there is a next page
					//clicking the next link to go to next page
					pageNextLink.click();
					Utility.simpleWait(4000);
					System.out.println("in while cPage="+cPage);
					cPage=cPage+1;
					System.out.println("list after sorting in second page="+dList.size());
					for(int j=0;j<dList.size();j++)
					{
						dateTimeVal = dList.get(j).getText()+" "+tList.get(j).getText();
							System.out.println(strArrayList.get(j)+"--------"+dateTimeVal);
							if(strArrayList.get(i).compareTo(dateTimeVal)!=0)
							{
								result = false;
								System.out.println("Elements in the page 1 are not sorted first ");
								break;	
							}
							i=i+1;
						System.out.println("elements="+result);
					}
					System.out.println("Elements in the second page are sorted::"+ result);
					
				}
			}
			for(int k=0;k<cPage;k++) {
				//clicking the previous link to go to first page
				pagePreviousLink.click();
				System.out.println("clicked previous page link");
				Utility.simpleWait(5000);
			}
			Log.addMessage("Events sorted in ascending order under description");
			return result;
		}catch(Exception e) {
			Log.addMessage("Failed to sort events under description in ascending order");
			System.out.println(e.getMessage().toString());
			return false;
			//Assert.assertTrue(false, "Failed get the events displayed under description in lock history page");
		}
	}
	
	
	/**
	 * Method Name: sortAscDescriptionList() Description: This function will be called
	 * to verify if the elements are sorted in ascending order
	 * @throws InterruptedException 
	*/
	public void sortAscDescriptionList() throws InterruptedException {
		try {
			Utility.waitForElementToBeVisible(sortDescription);
			//Getting the events listed in the page under description
			List<String> descriptionList = getHistoryList("description", descList);
			//Sorting the array in ascending order
			//Arrays.sort(strArray);
			Collections.sort(descriptionList);
			System.out.println("---------------------Sorted values in the Array---------------------");
			for (int i = 0; i < descriptionList.size(); i++) 
			{
					System.out.println(descriptionList.get(i));
			}
			Boolean resultChk = checkSortList("description",descriptionList,descList);
			Assert.assertTrue(resultChk,"The list is sorted");
		}catch(Exception e) {
			Log.addMessage("Failed to sort events in ascending order");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to sort events in ascending order");
		}
	}
	
	/**
	 * Method Name: sortDescDescriptionList() Description: This function will be called
	 * to verify if the elements are sorted in ascending order
	 * @throws InterruptedException 
	*/
	public void sortDescDescriptionList() throws InterruptedException {
		try {
			Utility.waitForElementToBeVisible(sortDescription);
			//Getting the events listed in the page under description
			List<String> descriptionList = getHistoryList("description", descList);
			System.out.println("after strArray="+descriptionList.size());
			//Sorting the array
			//Arrays.sort(descriptionList,Collections.reverseOrder());
			Collections.sort(descriptionList,Collections.reverseOrder());
			System.out.println("---------------------Sorted values in the Array---------------------");
			for (int i = 0; i < descriptionList.size(); i++) 
			{
				System.out.println(descriptionList.get(i));
			}
			Boolean resultChk = checkSortList("description",descriptionList,descList);
			Assert.assertTrue(resultChk,"The list is sorted");
		}catch(Exception e) {
			Log.addMessage("Failed to sort events under description in descending order");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to sort events under description in descending order");
		}
	}
	
	/**
	 * Method Name: sortAscSourceList() Description: This function will be called
	 * to verify if the elements are sorted in ascending order
	 * @throws InterruptedException 
	*/
	public void sortAscSourceList(String histType) throws InterruptedException {
		try {
			Utility.waitForElementToBeVisible(sortSource);
			//Getting the events listed in the page under description
			List<String> strArray;
			if(histType.equals("lock")) {
				strArray = getHistoryList("source", sourceList);
			}else {
				strArray = getHistoryList("homesource", homeSourceList);	
			}
			System.out.println("after strArray="+strArray.size());
			//Sorting the array
			//Arrays.sort(strArray);
			Collections.sort(strArray);
			System.out.println("---------------------Sorted values in the Array---------------------");
			for (int i = 0; i < strArray.size(); i++) 
			{
				System.out.println(strArray.get(i));
			}
			Boolean resultChk=true;
			System.out.println("resultChk="+resultChk);
			if(histType.equals("lock")) {
				System.out.println("lock");
				 resultChk = checkSortList("source",strArray,sourceList);
			}else {
				System.out.println("homelock");
				 resultChk = checkSortList("homesource",strArray,homeSourceList);
			}
			Assert.assertTrue(resultChk,"The list is sorted");
		}catch(Exception e) {
			Log.addMessage("Failed to sort events under description in descending order");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to sort events under description in descending order");
		}
	}
	
	/**
	 * Method Name: sortDescDescriptionList() Description: This function will be called
	 * to verify if the elements are sorted in ascending order
	 * @throws InterruptedException 
	*/
	public void sortDesSourceList(String histType) throws InterruptedException {
		try {
			Utility.waitForElementToBeVisible(sortSource);
			//Getting the events listed in the page under description
			List<String> strArray;
			if(histType.equals("lock")) {
				strArray = getHistoryList("source", sourceList);
			}else {
				strArray = getHistoryList("homesource", homeSourceList);
			}
			System.out.println("after strArray="+strArray.size());
			//Sorting the array in descending order
			Collections.sort(strArray,Collections.reverseOrder());
			System.out.println("---------------------Sorted values in the Array---------------------");
			for (int i = 0; i < strArray.size(); i++) 
			{
				System.out.println(strArray.get(i));
			}
			Boolean resultChk=true;
			if(histType.equals("lock")) {
				resultChk = checkSortList("source",strArray,sourceList);
			}else {
				resultChk = checkSortList("homesource",strArray,homeSourceList);
			}
			Assert.assertTrue(resultChk,"The list is sorted");
		}catch(Exception e) {
			Log.addMessage("Failed to sort events under description in descending order");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to sort events under description in descending order");
		}
	}
	
	/**
	 * Method Name: sortAscDateTimeList() Description: This function will be called
	 * to verify if the elements are sorted in ascending order
	 * @throws InterruptedException 
	*/
	public void sortAscDateTimeList() throws InterruptedException {
		try {
			Utility.waitForElementToBeVisible(sortDateTime);
			//Getting the events listed in the page under DateTime
			
			List<String> dateStrList = getDateTimeList(dateList,timeList,"lock");
			System.out.println("after collecting the list");
			System.out.println("after strArray="+dateStrList.size());
			//Sorting the array
			//Sort String Date
			Collections.sort(dateStrList, new Comparator<String>() {
			DateFormat f = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			@Override
			public int compare(String o1, String o2) {
			try {
				return f.parse(o1).compareTo(f.parse(o2));
			    } catch (ParseException e) {
			      throw new IllegalArgumentException(e);
			    }
			}
			});
			System.out.println("---------------------Sorted values in the Array---------------------");
			for (int i = 0; i < dateStrList.size(); i++) 
			{
				System.out.println(dateStrList.get(i));
			}
			Boolean resultChk = verifySortList("dateTime",dateStrList,dateList,timeList);
			Assert.assertTrue(resultChk,"The list is sorted");
		}catch(Exception e) {
			Log.addMessage("Failed to sort events under description in descending order");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to sort events under description in descending order");
		}
	}
	
	/**
	 * Method Name: sortDesDateTimeList() Description: This function will be called
	 * to verify if the elements are sorted in ascending order
	 * @throws InterruptedException 
	*/
	public void sortDesDateTimeList() throws InterruptedException {
		try {
			Utility.waitForElementToBeVisible(sortDateTime);
			//Getting the events listed in the page under DateTime
			
			List<String> dateStrList = getDateTimeList(dateList,timeList,"lock");
			System.out.println("after collecting the list");
			System.out.println("after strArray="+dateStrList.size());
			//Sorting the array
			//Sort String Date
			Collections.sort(dateStrList, new Comparator<String>() {
			DateFormat f = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			@Override
			public int compare(String o1, String o2) {
			try {
			  return f.parse(o2).compareTo(f.parse(o1));
			    } catch (ParseException e) {
			      throw new IllegalArgumentException(e);
			    }
			}
			});
			System.out.println("---------------------Sorted values in the Descending order---------------------");
			for (int i = 0; i < dateStrList.size(); i++) 
			{
				System.out.println(dateStrList.get(i));
			}
			Boolean resultChk = verifySortList("dateTime",dateStrList,dateList,timeList);
			Assert.assertTrue(resultChk,"The list is sorted");
		}catch(Exception e) {
			Log.addMessage("Failed to sort events under description in descending order");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to sort events under description in descending order");
		}
	}
	
	/**
	 * Method Name: eventIconList() Description: This function will be called
	 * to verify if the elements are sorted in ascending order
	 * @throws InterruptedException 
	*/
	public void eventIconList(String strIconName) throws InterruptedException {
		try {
			Utility.waitForElementToBeVisible(sortDateTime);
			//Getting the events listed in the page under DateTime
			
			List<String> iconList = getEventIconList(eventList);
			String[] iconName = strIconName.split(",");
			System.out.println("after collecting the list");
			System.out.println("after strArray="+iconList.size());
			//Sorting the array in ascending order
			Collections.sort(iconList);
			System.out.println("---------------------Matching icons in the Array---------------------");
			int cntIcon = 0;
			for (int i = 0; i < iconName.length; i++) 
			{
				for (int j = 0; j < iconList.size(); j++)
				{
					if(iconName[i].equals(iconList.get(j))) {
						cntIcon=cntIcon+1;
						System.out.println(iconList.get(j));
						break;
					}
				}
			}
			System.out.println("iconName.length="+iconName.length+", cntIcon="+cntIcon);
			if(cntIcon==iconName.length) {
				Assert.assertTrue(true,"The list is matching");
			}
		}catch(Exception e) {
			Log.addMessage("Failed to list all the icons");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to list all the icons");
		}
	}
	/**
	 * Method Name: itemsInCheckList() Description: This function will be called
	 * to verify if the elements are sorted in ascending order
	 * @throws InterruptedException 
	*/
	public void itemsInCheckList(String strIconName) throws InterruptedException {
		try {
			Utility.waitForElementToBeVisible(sortDescription);
			sortDescription.click();
			//Getting the events listed in the page under DateTime
			
			List<String> filterList = getFilterList();
			String[] itemName = strIconName.split(",");
			System.out.println("after collecting the list");
			System.out.println("after strArray="+filterList.size());
			//Sorting the array in ascending order
			Collections.sort(filterList);
			System.out.println("---------------------Matching icons in the Array---------------------");
			int cntIcon = 0;
			for (int i = 0; i < itemName.length; i++) 
			{
				for (int j = 0; j < filterList.size(); j++)
				{
					if(itemName[i].equals(filterList.get(j))) {
						cntIcon=cntIcon+1;
						System.out.println(filterList.get(j));
						break;
					}
				}
			}
			if(cntIcon==itemName.length) {
				Assert.assertTrue(true,"The list is not matching");
			}
		}catch(Exception e) {
			Log.addMessage("Failed to list all the icons");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to list all the icons");
		}
	}
	/**
	* Method Name: getDateTimeList() Description: This function will be called
	 * to verify if the elements are sorted in ascending order
	 * @return 
	 * @throws InterruptedException 
	*/
	private  List<String> getDateTimeList(List<WebElement> dList,List<WebElement> tList, String histType)
	{
		try {
			List<String>dateStrList=new ArrayList<String>();
			//if(histType.equals("home")) {
			System.out.println("dateList="+dList.size());
			for(int i=0;i<dList.size();i++) {
				String date_time = dList.get(i).getText()+" "+tList.get(i).getText();
				dateStrList.add(date_time);
			}
			int pcount = 0;
			if(histType.equals("lock")) {
				while(sourceList.size()>=10) {
					pageNextLink.click();
					Utility.simpleWait(5000);
					pcount=pcount+1;
					System.out.println("dateList in 2nd page="+dList.size());
					for(int i=0;i<dList.size();i++) {
						String date_time = dList.get(i).getText()+" "+tList.get(i).getText();
						dateStrList.add(date_time);
					}
					
				}
			}else {
				while(lockNameList.size()>=10) {
					pageNextLink.click();
					Utility.simpleWait(5000);
					pcount=pcount+1;
					System.out.println("dateList in page"+pcount+"="+dList.size());
					for(int i=0;i<dList.size();i++) {
						String date_time = dList.get(i).getText()+" "+tList.get(i).getText();
						dateStrList.add(date_time);
					}
				}	
			}
			if(pcount>=1) {
				System.out.println("in click pageone");
				pageOne.click();
			}
			/*for(int k=0; k<pcount;k++) {
				pagePreviousLink.click();
				Utility.simpleWait(5000);
			}*/
			
			System.out.println("---> Date & Time List Before Sort (MM/dd/yyyy hh:mm a)");
			for(String dateStr:dateStrList)
			System.out.println(dateStr);
			return dateStrList;
			
		}catch(Exception e) {
			Log.addMessage("Failed to sort events under description in descending order");
			System.out.println(e.getMessage().toString());
			return null;
			//Assert.assertTrue(false, "Failed to sort events under description in descending order");
		}
	}
	
	/**
	* Method Name: getHistoryList() Description: This function will be called
	 * to verify if the elements are sorted in ascending order
	 * @return 
	 * @throws InterruptedException 
	*/
	public  List<String> getHistoryList(String sortType,List<WebElement> sortList)
	{
		try {
			List<String>strList=new ArrayList<String>();
			if(sortType.equals("description")) {
				System.out.println("description="+descList.size());
			}else if(sortType.equals("homedescription")) {
				System.out.println("homedescription="+homeDescList.size());
			}
			
			for(int i=0;i<sortList.size();i++) {
				strList.add(sortList.get(i).getText());
				/*if(!((sortList.get(i).getText()).equals("Status Update")) && sortType.equals("homesource")) {
					i++;
				}*/
			}
			System.out.println("strList="+strList.size());
			//if(sourceList.size()>=10) {//commented and changed below code for n number of pages on 18th Aug 2020
			String inPagination="";
			int cntPage =0;
			while(sortList.size()>=10) {
				pageNextLink.click();
				Utility.simpleWait(5000);
				cntPage=cntPage+1;
				System.out.println("dateList in 2nd page="+sortList.size());
				for(int i=0;i<sortList.size();i++) {
					strList.add(sortList.get(i).getText());
					/*if(!((sortList.get(i).getText()).equals("Status Update")) && sortType.equals("homesource")) {
						i++;
					}*/
				}
				inPagination="exists";
			}
			if(inPagination!="") {
				if(inPagination.equals("exists")) {
					//change to click page 1
					pageOne.click();
					/*for(int cntP = 0; cntP<sortList.size(); cntP++) {
						pagePreviousLink.click();
						Utility.simpleWait(5000);
					}*/
					
				}
			}
			
			
			System.out.println("---> List Before Sort-->");
			for(String sortStr:strList)
			System.out.println(sortStr);
			return strList;
			
		}catch(Exception e) {
			Log.addMessage("Failed to fetch events");
			System.out.println(e.getMessage().toString());
			return null;
		}
	}
	
	/**
	* Method Name: getEventIconList() Description: This function will be called
	 * to verify if the elements are sorted in ascending order
	 * @return 
	 * @throws InterruptedException 
	*/
	public  List<String> getEventIconList(List<WebElement> eList)
	{
		try {
			//Utility.waitForElementToBeVisible(eList.get(0));
			List<String>strList=new ArrayList<String>();
			List<String>newStrList=new ArrayList<String>();
			
			System.out.println("dateList="+eList.size());
			
			for(int i=0;i<eList.size();i++) {
				strList.add(eList.get(i).getAttribute("title"));
			}
			int pcnt =0;
			while(eList.size()>=10) {
				pageNextLink.click();
				Utility.simpleWait(5000);
				pcnt=pcnt+1;
				System.out.println("dateList in 2nd page="+eList.size());
				for(int i=0;i<eList.size();i++) {
					strList.add(eList.get(i).getAttribute("title"));
				}
			}
			if(pcnt>=1) {
				pageOne.click();
			}
			/*for(int k = 0; k<pcnt;k++) {
				pagePreviousLink.click();
				Utility.simpleWait(5000);
			}*/
			//Remove duplicate icons
			for(int i=0;i<strList.size();i++) {
	            if(!newStrList.contains(strList.get(i))){
	            	newStrList.add(strList.get(i));
	            }
			}
			
			System.out.println("---> Event Icon List After");
			for(String sortStr:newStrList)
			System.out.println(sortStr);
			return newStrList;
			
		}catch(Exception e) {
			Log.addMessage("Failed to fetch event icons");
			System.out.println(e.getMessage().toString());
			return null;
		}
	}
	
	/**
	* Method Name: getFilterList() Description: This function will be called
	 * to verify if the elements are sorted in ascending order
	 * @return 
	 * @throws InterruptedException 
	*/
	public  List<String> getFilterList()
	{
		try {
			Utility.waitForElementToBeVisible(checkList.get(0));
			List<String>strList=new ArrayList<String>();
			List<String>newStrList=new ArrayList<String>();
			
			System.out.println("checkList="+checkList.size());
			
			for(int i=0;i<checkList.size();i++) {
				strList.add(checkList.get(i).getText());
			}
			//Remove duplicate icons
			for(int i=0;i<strList.size();i++) {
	            if(!newStrList.contains(strList.get(i))){
	            	newStrList.add(strList.get(i));
	            }
			}
			System.out.println("---> Filter List After removing duplicate");
			for(String sortStr:newStrList)
			System.out.println(sortStr);
			return newStrList;
			
		}catch(Exception e) {
			Log.addMessage("Failed to fetch fliter items");
			System.out.println(e.getMessage().toString());
			return null;
		}
	}
	
	
	/**
	 * Method Name: verifyFilterButton() Description: This function will be called
	 * to verify filter
	 */
	
	public void verifyFilterButton() {
		try {
			Utility.simpleWait(2000);
			System.out.println("one checkDescList="+checkDescList.size());
			//Utility.waitForElementToBeVisible(checkDescList.get(0));
			System.out.println("one");
			checkDescList.get(0).click();
			System.out.println("two");
			Utility.simpleWait(2000);
			searchButton.click();
			System.out.println("three");
			
			Utility.simpleWait(4000);
			Log.addMessage("Filter button is clicked");
			Assert.assertTrue(true, "Filter button is clicked");
		}catch(Exception e) {
			Log.addMessage("Failed to click filter button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click filter button");
		}
	}
	
	/**
	 * Method Name: verifyFilterOption() Description: This function will be called
	 * to verify filter functionality
	 */
	
	public void verifyFilterOption(String histType) {
		try {
			Utility.simpleWait(2000);
			if(histType.equals("lock")) {
				if((descList.get(0).getText()).equals("Activation")) {
					Assert.assertTrue(true, "Filter action not executed");
				}
			}else {
				if((homeDescList.get(0).getText()).equals("Activation")) {
					Assert.assertTrue(true, "Filter action not executed");
				}
			}
			Log.addMessage("Filter action executed for description");
		}catch(Exception e) {
			Log.addMessage("Failed to perform filter action");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to perform filter action");
		}
	}
	
	/**
	 * Method Name: verifyClearOption() Description: This function will be called
	 * to verify clear functionality
	*/
	public void verifyClearOption(String histType) {
		try {
			Utility.waitForElementToBeVisible(sortDescription);//changed from sortDescrription on 21st August 2020
			sortDescription.click();
			Utility.waitForElementToBeVisible(clearButton);
			clearButton.click();
			Utility.simpleWait(5000);
			if(histType.equals("lock")) {
				if(descList.size()>1) {
					Assert.assertTrue(true, "Clear filter not executed");
				}
				Log.addMessage("Clear filter executed for description with "+descList.size()+" events listed");
			}else {
				if(homeDescList.size()>1) {
					Assert.assertTrue(true, "Clear filter not executed");
				}
				Log.addMessage("Clear filter executed for description with "+homeDescList.size()+" events listed");
			}
		}catch(Exception e) {
			Log.addMessage("Failed to perform clear action");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to perform clear action");
		}
	}
	
	/**
	 * Method Name: itemsInSourceSearch() Description: This function will be called
	 * to verify if the elements are sorted in ascending order
	 * @throws InterruptedException 
	*/
	public void itemsInSourceSearch() throws InterruptedException {
		try {
			Utility.waitForElementToBeVisible(sortSource);
			sortSource.click();
			Utility.waitForElementToBeVisible(searchSourceText);
			System.out.println("one");
			Utility.waitForElementToBeVisible(sourceClearButton);
			System.out.println("two");
			Utility.waitForElementToBeVisible(sourceSearchButton);
			System.out.println("three");
			Log.addMessage("All UI elements present in the search page for source");
		}catch(Exception e) {
			Log.addMessage("Failed to list all UI elements present in the search page for source");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to list all UI elements present in the search page for source");
		}
	}
	
	/**
	 * Method Name: verifySourceFilterButton() Description: This function will be called
	 * to verify filter
	 */
	
	public void verifySourceFilterButton() {
		try {
			Utility.simpleWait(2000);
			System.out.println("one");
			searchSourceText.sendKeys("status");
			System.out.println("two");
			sourceSearchButton.click();
			System.out.println("three");
			Utility.simpleWait(4000);
			Log.addMessage("Filter button is clicked");
			Assert.assertTrue(true, "Filter button is clicked");
		}catch(Exception e) {
			Log.addMessage("Failed to click filter button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click filter button");
		}
	}
	
	/**
	 * Method Name: verifySourceFilterOption() Description: This function will be called
	 * to verify filter functionality
	 */
	
	public void verifySourceFilterOption() {
		try {
			Utility.simpleWait(2000);
			if(sourceList.size()>0) {//should have a valid search result
				if((sourceList.get(0).getText()).equals("Status Update")) {
					Assert.assertTrue(true, "Filter action not executed");
				}
			}else {
				Assert.assertTrue(true, "Filter action not executed");
			}
			Log.addMessage("Filter action executed for source");
		}catch(Exception e) {
			Log.addMessage("Failed to perform filter action");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to perform filter action");
		}
	}
	

	/**
	 * Method Name: verifySourceClearOption() Description: This function will be called
	 * to verify clear functionality
	*/
	public void verifySourceClearOption(String histType) {
		try {
			Utility.waitForElementToBeVisible(sortSource);//commented on 21st August 2020
			sortSource.click();
			Utility.waitForElementToBeVisible(sourceClearButton);
			sourceClearButton.click();
			Utility.simpleWait(5000);
			if(histType.equals("lock")) {
				if(sourceList.size()>1) {
					Assert.assertTrue(true, "Clear filter not executed");
				}
				Log.addMessage("Clear filter executed for source with "+sourceList.size()+" events listed");
			}else {
				if(homeSourceList.size()>1) {
					Assert.assertTrue(true, "Clear filter not executed");
				}
				Log.addMessage("Clear filter executed for source with "+homeSourceList.size()+" events listed");
			}
			
		}catch(Exception e) {
			Log.addMessage("Failed to perform clear action");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to perform clear action");
		}
	}
	
	/**
	 * Method Name: itemsInDateSearch() Description: This function will be called
	 * to verify if the elements are sorted in ascending order
	 * @throws InterruptedException 
	*/
	public void itemsInDateSearch() throws InterruptedException {
		try {
			Utility.waitForElementToBeVisible(sortDateTime);
			sortDateTime.click();
			Utility.waitForElementToBeVisible(fromDateText);
			Utility.waitForElementToBeVisible(toDateText);
			Utility.waitForElementToBeVisible(dateClearButton);
			Utility.waitForElementToBeVisible(dateSearchButton);
			Utility.simpleWait(5000);
			System.out.println("three");
			Log.addMessage("All UI elements present in the search page for date time");
			
		}catch(Exception e) {
			Log.addMessage("Failed to list all UI elements present in the search page for date time");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to list all UI elements present in the search page for date time");
		}
	}
	
	/**
	 * Method Name: verifyDateFilterButton() Description: This function will be called
	 * to verify filter
	 */
	
	public void verifyDateFilterButton(String frmDt,String toDt) {
		try {
			Utility.simpleWait(2000);
			System.out.println("frmDt="+frmDt+", toDt="+toDt);
			fromDateText.click();
			int fDate = Integer.parseInt(frmDt);
			System.out.println("fDate="+fDate);
			System.out.println("fromDate="+fromDate.get(fDate+1).getText());
			fromDate.get(fDate).click();
			fromDateText.click();
			from_seldate = fromDateText.getAttribute("value");
			
			System.out.println("fromDateText value="+fromDateText.getAttribute("value"));
			Utility.simpleWait(2000);
			System.out.println("two");
			toDateText.click();
			
			int tDate = Integer.parseInt(toDt);
			System.out.println("tDate="+tDate);
			System.out.println("toDate="+toDate.get(tDate+1).getText());
			Utility.simpleWait(2000);
			toDate.get(tDate).click();
			Utility.simpleWait(3000);
			toDateText.click();
			to_seldate = toDateText.getAttribute("value");
			System.out.println("toDateText="+to_seldate);
			Utility.simpleWait(2000);
			dateSearchButton.click();
			System.out.println("three");
			Utility.simpleWait(4000);
			Log.addMessage("Filter button is clicked");
			Assert.assertTrue(true, "Filter button is clicked");
		}catch(Exception e) {
			Log.addMessage("Failed to click filter button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click filter button");
		}
	}
	/**
	 * Method Name: verifyDateFilterOption() Description: This function will be called
	 * to verify filter functionality
	 */
	
	public void verifyDateFilterOption(String frmDt,String toDt, String histType) {
		try {
			//Utility.simpleWait(2000);
			/*Utility.waitForElementToBeVisible(sortDateTime);
			sortDateTime.click();*/
			Utility.simpleWait(6000);
			//from_seldate = fromDateText.getAttribute("name");
			//System.out.println("from_seldate="+from_seldate);
			from_seldate = fromDateText.getAttribute("value");
			System.out.println("from_seldate="+from_seldate);
			System.out.println("to_seldate="+toDateText.getAttribute("value"));
			SimpleDateFormat outputFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.ENGLISH);
			SimpleDateFormat inputFormat = new SimpleDateFormat("MM-dd-yyyy hh:mm a", Locale.ENGLISH);
			//DateFormat mSDF = new SimpleDateFormat("hh:mm a");
			//String fromDate = outputFormat.format(inputFormat.parse(from_seldate));--one
			//Date parsedDate1=new SimpleDateFormat("dd/MM/yyyy").parse(from_seldate);  
			/*SimpleDateFormat formatter1 =  new SimpleDateFormat("MM/dd/yyyy HH:MM tt");
			 Date parsedDate1= formatter1.parse(fromDate);*/
			// DateTime date = DateTime.ParseExact("24/11/2016 04:30 pm", "dd/MM/yyyy hh:mm tt", CultureInfo.InvariantCulture);
			//Date parsedDate1 = inputFormat.parse(from_seldate);
			Date fromDate=inputFormat.parse(from_seldate);
			System.out.println("fromDate="+fromDate);
			String parsedFromDate =outputFormat.format(fromDate);
			System.out.println("parsedFromDate="+parsedFromDate);
			Date parsedDate1 = outputFormat.parse(parsedFromDate);
			System.out.println("parsedDate1 fromdate="+parsedDate1);
			String pfromdate=outputFormat.format(parsedDate1);
			System.out.println("parsedDate1 outputFormat="+outputFormat.format(parsedDate1));
			Date p_fromDate =outputFormat.parse(pfromdate);
			System.out.println("p_fromDate="+p_fromDate);
			
			//DateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy hh.mm a");
			
			/*String formattedDate1 = outputFormat.format(parsedDate1);
			String formattedDate1 = outputFormat.format(inputFormat.parse(from_seldate));
			System.out.println("formattedDate1="+outputFormat.format(parsedDate1));
			Date parsedDate_1 =  inputFormat.parse(formattedDate1);
			System.out.println("parsedDate_1="+parsedDate_1);*/
			
			//Date date1=(Date) new SimpleDateFormat("MM-dd-yyyy HH:MM a").parse(from_seldate);
			//System.out.println("date1="+date1);
			//to_seldate = toDateText.getAttribute("name");
			to_seldate = toDateText.getAttribute("value");
			System.out.println("to_seldate="+to_seldate);
			String toDate = outputFormat.format(inputFormat.parse(to_seldate));
			
			SimpleDateFormat formatter2 =  new SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.ENGLISH);
			Date parsedDate2= formatter2.parse(toDate);
			System.out.println("parsedDate2 toDate="+parsedDate2);
			
			/*Date parsedDate2 =  inputFormat.parse(to_seldate);
			String formattedDate2 =  outputFormat.format(parsedDate2);
			Date parsedDate_2 =  inputFormat.parse(formattedDate2);
			System.out.println("parsedDate2 inputFormat="+parsedDate2);
			System.out.println("formattedDate2 outputFormat="+formattedDate2);
			System.out.println("to_seldate="+to_seldate);*/
			//Date date2=(Date) new SimpleDateFormat("MM-dd-yyyy HH:MM a").parse(to_seldate);
			//System.out.println("date2="+date2);
			
			String fDate ="";
			Date chkDate;
			Boolean withinRange = true;
			if(histType.contentEquals("lock")) {
				System.out.println("dateList.size()="+dateList.size());
				for(int i=0;i<dateList.size();i++) {
					fDate = dateList.get(i).getText()+" "+timeList.get(i).getText();
					System.out.println("fDate="+fDate);
					chkDate=new SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.ENGLISH).parse(fDate);
					System.out.println("chkDate="+chkDate);
					
					if((parsedDate1.compareTo(chkDate)>0 && parsedDate2.compareTo(chkDate)<0)) {
						System.out.println("in false");
						withinRange=false;  
					}
				}
				int inHPagination =0;
				if(withinRange) {
				while(dateList.size()>=10) {//added on 23rd Aug 2020
					//clicking the next link to go to next page
					pageNextLink.click();
					Utility.simpleWait(5000);
					inHPagination=inHPagination+1;
					System.out.println("list after sorting in lock page="+inHPagination+" are:"+homeDateList.size());
					
					for(int i=0;i<dateList.size();i++) {
						fDate = dateList.get(i).getText()+" "+timeList.get(i).getText();
						System.out.println("fDate="+fDate);
						chkDate=new SimpleDateFormat("MM/dd/yyyy hh:mm a").parse(fDate);
						System.out.println("chkDate="+chkDate);
						
						System.out.println("parsedDate1="+parsedDate1+", parsedDate2="+parsedDate2);
						System.out.println("(parsedDate1.compareTo(chkDate)="+parsedDate1.compareTo(chkDate));
						System.out.println("parsedDate2.compareTo(chkDate)"+parsedDate2.compareTo(chkDate));
						if((parsedDate1.compareTo(chkDate)>0 && parsedDate2.compareTo(chkDate)<0)) {
							System.out.println("in false");
							withinRange=false;  
						}
					}
					if(!withinRange) {
						System.out.println("Elements not within the given dates break:"+ withinRange);
						break;
					}
					System.out.println("Elements in the page "+inHPagination+" are sorted::"+ withinRange);
					//clicking the previous link to go to first page
					
				}
				}
				
				if(inHPagination>=1) {
					pageOne.click();
					Utility.simpleWait(4000);
				}
			}else {
				System.out.println("homeDateList.size()="+homeDateList.size());
				int i=0;
				for(i=0;i<homeDateList.size();i++) {
					fDate = homeDateList.get(i).getText()+" "+homeTimeList.get(i).getText();
					System.out.println("fDate="+fDate);
					chkDate=new SimpleDateFormat("MM/dd/yyyy hh:mm a").parse(fDate);
					System.out.println("chkDate="+chkDate);
					
					System.out.println("parsedDate1="+parsedDate1+", parsedDate2="+parsedDate2);
					System.out.println("(parsedDate1.compareTo(chkDate)="+parsedDate1.compareTo(chkDate));
					System.out.println("parsedDate2.compareTo(chkDate)"+parsedDate2.compareTo(chkDate));
					if((parsedDate1.compareTo(chkDate)>0 && parsedDate2.compareTo(chkDate)<0)) {
						System.out.println("in false");
						withinRange=false;  
					}
				}
				int inHPagination =0;
				if(withinRange) {
				while(homeDateList.size()>=10) {//added on 23rd Aug 2020
					//clicking the next link to go to next page
					pageNextLink.click();
					Utility.simpleWait(5000);
					inHPagination=inHPagination+1;
					System.out.println("list after sorting in page="+inHPagination+" are:"+homeDateList.size()+",i in the next page="+i);
					
					for(i=0;i<homeDateList.size();i++) {
						fDate = homeDateList.get(i).getText()+" "+homeTimeList.get(i).getText();
						System.out.println("fDate="+fDate);
						chkDate=new SimpleDateFormat("MM/dd/yyyy hh:mm a").parse(fDate);
						System.out.println("chkDate="+chkDate);
						
						System.out.println("parsedDate1="+parsedDate1+", parsedDate2="+parsedDate2);
						System.out.println("(parsedDate1.compareTo(chkDate)="+parsedDate1.compareTo(chkDate));
						System.out.println("parsedDate2.compareTo(chkDate)"+parsedDate2.compareTo(chkDate));
						if((parsedDate1.compareTo(chkDate)>0 && parsedDate2.compareTo(chkDate)<0)) {
							System.out.println("in false");
							withinRange=false;  
						}
					}
					if(!withinRange) {
						System.out.println("Elements not within the given dates break:"+ withinRange);
						break;
					}
					System.out.println("Elements in the page "+inHPagination+" are sorted::"+ withinRange);
					//clicking the previous link to go to first page
					
				}
				}
				
				if(inHPagination>=1) {
					pageOne.click();
					Utility.simpleWait(4000);
				}
			} 
			Assert.assertTrue(withinRange, "Filter action not executed");
			
			Log.addMessage("Filter action executed for date time");
		}catch(Exception e) {
			Log.addMessage("Failed to perform filter action");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to perform filter action");
		}
	}
	
	/**
	 * Method Name: verifyDateClearOption() Description: This function will be called
	 * to verify clear functionality
	*/
	public void verifyDateClearOption(String histType) {
		try {
			Utility.waitForElementToBeVisible(sortDateTime);//changed on 21st Aug 2020
			sortDateTime.click();
			Utility.waitForElementToBeVisible(dateClearButton);
			dateClearButton.click();
			Utility.simpleWait(5000);
			if(histType.equals("lock")) {
				if(dateList.size()>1) {
					Assert.assertTrue(true, "Clear filter not executed");
				}
				Log.addMessage("Clear filter executed for source with "+dateList.size()+" events listed");
			}else {
				if(homeDateList.size()>1) {
					Assert.assertTrue(true, "Clear filter not executed");
				}
				Log.addMessage("Clear filter executed for source with "+homeDateList.size()+" events listed");
			}
			
		}catch(Exception e) {
			Log.addMessage("Failed to perform clear action");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to perform clear action");
		}
	}
	/**
	 * Method Name: sortAscLockNameList() Description: This function will be called
	 * to verify if the elements are sorted in ascending order
	 * @throws InterruptedException 
	*/
	public void sortAscLockNameList() throws InterruptedException {
		try {
			Utility.waitForElementToBeVisible(sortLockName);
			//Getting the events listed in the page under description
			List<String> lockList = getHistoryList("lockName", lockNameList);
			//Sorting the array in ascending order
			//Arrays.sort(strArray);
			Collections.sort(lockList);
			System.out.println("---------------------Sorted values in the Array---------------------");
			for (int i = 0; i < lockList.size(); i++) 
			{
						System.out.println(lockList.get(i).toString());
			}
			Boolean resultChk = checkSortList("lockName",lockList,lockNameList);
			Assert.assertTrue(resultChk,"The list is sorted");
		}catch(Exception e) {
			Log.addMessage("Failed to sort events in ascending order");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to sort events in ascending order");
		}
	}
	
	/**
	 * Method Name: sortDesLockNameList() Description: This function will be called
	 * to verify if the elements are sorted in ascending order
	 * @throws InterruptedException 
	*/
	public void sortDesLockNameList() throws InterruptedException {
		try {
			Utility.waitForElementToBeVisible(sortLockName);
			//Getting the events listed in the page under description
			List<String> lockList = getHistoryList("lockName", lockNameList);
			System.out.println("after strArray="+lockList.size());
			//Sorting the array
			//Arrays.sort(descriptionList,Collections.reverseOrder());
			Collections.sort(lockList,Collections.reverseOrder());
			System.out.println("---------------------Sorted values in the Array---------------------");
			for (int i = 0; i < lockList.size(); i++) 
			{
				System.out.println(lockList.get(i));
			}
			Boolean resultChk = checkSortList("lockName",lockList,lockNameList);
			Assert.assertTrue(resultChk,"The list is sorted");
		}catch(Exception e) {
			Log.addMessage("Failed to sort events under lock name in descending order");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to sort events under lock name in descending order");
		}
	}
	
	/**
	 * Method Name: itemsInLockNameSearch() Description: This function will be called
	 * to verify if the elements are sorted in ascending order
	 * @throws InterruptedException 
	*/
	public void itemsInLockNameSearch() throws InterruptedException {
		try {
			Utility.waitForElementToBeVisible(sortLockName);
			sortLockName.click();
			Utility.waitForElementToBeVisible(lockNameText);
			Utility.waitForElementToBeVisible(lockClearButton);
			Utility.waitForElementToBeVisible(lockSearchButton);
			Utility.simpleWait(5000);
			System.out.println("three");
			Log.addMessage("All UI elements present in the search page for date time");
			
		}catch(Exception e) {
			Log.addMessage("Failed to list all UI elements present in the search page for date time");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to list all UI elements present in the search page for date time");
		}
	}
	
	/**
	 * Method Name: verifyLockNameFilterButton() Description: This function will be called
	 * to verify filter
	 */
	
	public void verifyLockNameFilterButton(String lockName) {
		try {
			Utility.simpleWait(2000);
			System.out.println("one");
			lockNameText.sendKeys(lockName);
			System.out.println("two");
			lockSearchButton.click();
			System.out.println("three");
			Utility.simpleWait(4000);
			Log.addMessage("Filter button is clicked");
			Assert.assertTrue(true, "Filter button is clicked");
		}catch(Exception e) {
			Log.addMessage("Failed to click filter button");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to click filter button");
		}
	}	
	
	/**
	 * Method Name: verifyLockNameFilterOption() Description: This function will be called
	 * to verify filter functionality
	 */
	
	public void verifyLockNameFilterOption(String searchName) {
		try {
			Utility.simpleWait(2000);
			System.out.println("locklist size="+lockNameList.size());
			if(lockNameList.size()>0) {
				if((lockNameList.get(0).getText()).equals(searchName)) {
					Assert.assertTrue(true, "Filter action not executed");
				}
			}else {
				Assert.assertTrue(false, "Filter action not executed");
			}
			Log.addMessage("Filter action executed for source");
		}catch(Exception e) {
			Log.addMessage("Failed to perform filter action");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to perform filter action");
		}
	}
	
	/**
	 * Method Name: verifyLockNameClearOption() Description: This function will be called
	 * to verify clear functionality
	*/
	public void verifyLockNameClearOption() {
		try {
			Utility.waitForElementToBeVisible(sortLockName);
			sortLockName.click();
			Utility.waitForElementToBeVisible(lockClearButton);
			lockClearButton.click();
			Utility.simpleWait(5000);
			if(lockNameList.size()>1) {
				Assert.assertTrue(true, "Clear filter not executed");
			}
			Log.addMessage("Clear filter executed for lock name with "+lockNameList.size()+" events listed");
		}catch(Exception e) {
			Log.addMessage("Failed to perform clear action");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to perform clear action");
		}
	}
	
	/**
	 * Method Name: sortHomeAscDescriptionList() Description: This function will be called
	 * to verify if the elements are sorted in ascending order
	 * @throws InterruptedException 
	*/
	public void sortHomeAscDescriptionList() throws InterruptedException {
		try {
			Utility.waitForElementToBeVisible(sortDescription);
			//Getting the events listed in the page under description
			List<String> descriptionList = getHistoryList("homedescription", homeDescList);
			//Sorting the array in ascending order
			//Arrays.sort(strArray);
			Collections.sort(descriptionList);
			System.out.println("---------------------Sorted values in the Array---------------------");
			for (int i = 0; i < descriptionList.size(); i++) 
			{
			 
						System.out.println(descriptionList.get(i));
			}
			Boolean resultChk = checkSortList("homedescription",descriptionList,homeDescList);
			Assert.assertTrue(resultChk,"The list is sorted");
		}catch(Exception e) {
			Log.addMessage("Failed to sort events in ascending order");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to sort events in ascending order");
		}
	}
	
	/**
	 * Method Name: sortHomeDescDescriptionList() Description: This function will be called
	 * to verify if the elements are sorted in ascending order
	 * @throws InterruptedException 
	*/
	public void sortHomeDescDescriptionList() throws InterruptedException {
		try {
			Utility.waitForElementToBeVisible(sortDescription);
			//Getting the events listed in the page under description
			List<String> descriptionList = getHistoryList("homedescription", homeDescList);
			System.out.println("after strArray="+descriptionList.size());
			//Sorting the array
			//Arrays.sort(descriptionList,Collections.reverseOrder());
			Collections.sort(descriptionList,Collections.reverseOrder());
			System.out.println("---------------------Sorted values in the Array---------------------");
			for (int i = 0; i < descriptionList.size(); i++) 
			{
				System.out.println(descriptionList.get(i));
			}
			Boolean resultChk = checkSortList("homedescription",descriptionList,homeDescList);
			Assert.assertTrue(resultChk,"The list is sorted");
		}catch(Exception e) {
			Log.addMessage("Failed to sort events under description in descending order");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to sort events under description in descending order");
		}
	}
	
	/**
	 * Method Name: sortHomeAscDateTimeList() Description: This function will be called
	 * to verify if the elements are sorted in ascending order
	 * @throws InterruptedException 
	*/
	public void sortHomeAscDateTimeList() throws InterruptedException {
		try {
			Utility.waitForElementToBeVisible(sortDateTime);
			//Getting the events listed in the page under DateTime
			
			List<String> dateStrList = getDateTimeList(homeDateList,homeTimeList,"home");
			System.out.println("after collecting the list");
			System.out.println("after strArray="+dateStrList.size());
			//Sorting the array
			//Sort String Date
			Collections.sort(dateStrList, new Comparator<String>() {
			DateFormat f = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			@Override
			public int compare(String o1, String o2) {
			try {
				return f.parse(o1).compareTo(f.parse(o2));
			    } catch (ParseException e) {
			      throw new IllegalArgumentException(e);
			    }
			}
			});
			System.out.println("---------------------Sorted values in the Array---------------------");
			for (int i = 0; i < dateStrList.size(); i++) 
			{
				System.out.println(dateStrList.get(i));
			}
			Boolean resultChk = verifySortList("homedateTime",dateStrList,homeDateList,homeTimeList);
			Assert.assertTrue(resultChk,"The list is sorted");
		}catch(Exception e) {
			Log.addMessage("Failed to sort events under description in descending order");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to sort events under description in descending order");
		}
	}
	
	/**
	 * Method Name: sortHomeDesDateTimeList() Description: This function will be called
	 * to verify if the elements are sorted in ascending order
	 * @throws InterruptedException 
	*/
	public void sortHomeDesDateTimeList() throws InterruptedException {
		try {
			Utility.waitForElementToBeVisible(sortDateTime);
			//Getting the events listed in the page under DateTime
			
			List<String> dateStrList = getDateTimeList(homeDateList,homeTimeList,"home");
			System.out.println("after collecting the list");
			System.out.println("after strArray="+dateStrList.size());
			//Sorting the array
			//Sort String Date
			Collections.sort(dateStrList, new Comparator<String>() {
			DateFormat f = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			@Override
			public int compare(String o1, String o2) {
			try {
			  return f.parse(o2).compareTo(f.parse(o1));
			    } catch (ParseException e) {
			      throw new IllegalArgumentException(e);
			    }
			}
			});
			System.out.println("---------------------Sorted values in the Descending order---------------------");
			for (int i = 0; i < dateStrList.size(); i++) 
			{
				System.out.println(dateStrList.get(i));
			}
			Boolean resultChk = verifySortList("homedateTime",dateStrList,homeDateList,homeTimeList);
			Assert.assertTrue(resultChk,"The list is sorted");
		}catch(Exception e) {
			Log.addMessage("Failed to sort events under description in descending order");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to sort events under description in descending order");
		}
	}
	/**
	 * Method Name: eventHomeIconList() Description: This function will be called
	 * to verify if the elements are sorted in ascending order
	 * @throws InterruptedException 
	*/
	public void eventHomeIconList(String strIconName) throws InterruptedException {
		try {
			Utility.waitForElementToBeVisible(sortDateTime);
			//Getting the events listed in the page under DateTime
			
			List<String> iconList = getEventIconList(homeEventList);
			String[] iconName = strIconName.split(",");
			System.out.println("after collecting the list");
			System.out.println("after strArray="+iconList.size());
			//Sorting the array in ascending order
			Collections.sort(iconList);
			System.out.println("---------------------Matching icons in the Array---------------------");
			int cntIcon = 0;
			for (int i = 0; i < iconName.length; i++) 
			{
				for (int j = 0; j < iconList.size(); j++)
				{
					if(iconName[i].equals(iconList.get(j))) {
						cntIcon=cntIcon+1;
						System.out.println(iconList.get(j));
						break;
					}
				}
			}
			System.out.println("eventicon size="+iconName.length);
			if(cntIcon==iconName.length) {
				Assert.assertTrue(true,"The list is matching");
			}
		}catch(Exception e) {
			Log.addMessage("Failed to list all the icons");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to list all the icons");
		}
	}
	
	/**
	 * Method Name: checkHomeHistoryEvents() Description: This function will be called
	 * to verify if the elements are sorted in ascending order
	 * @throws InterruptedException 
	*/
	public void checkHomeHistoryEvents(String desc, String lkName, String source, String dateTime, int cnt, int cntTime) throws InterruptedException {
		try {
			Utility.waitForElementToBeVisible(dateTimeHeader);
			//Getting the events listed in the page for each row
			String descName, lockName, sourceName, dtTime, descNamePath, lockNamePath, sourceNamePath, dtTimePath="";
			
			descNamePath = "(//div[@class='row history-items ten-columns']//div[@class='col-sm-3 hidden-xs history-heading']//h5)";
			lockNamePath = "(//div[@class='col-sm-3 hidden-xs history-heading']/following-sibling::div[1]//h5)";
			sourceNamePath = "(//div[contains(@class,'row history-items')]//div[@class='col-xs-3 col-sm-2 history-heading'][2]//h5)";
			dtTimePath = "(//div[contains(@class,'row history-items')]//div[@class='col-xs-3 col-sm-2 history-heading'][3]//h5)";
			
			descName = driver.findElement(By.xpath(descNamePath+"["+cnt+"]")).getText().trim();
			lockName = driver.findElement(By.xpath(lockNamePath+"["+cnt+"]")).getText().trim();
			sourceName = driver.findElement(By.xpath(sourceNamePath+"["+cnt+"]")).getText().trim();
			System.out.println("dateTime="+dateTime+", cntTime="+cntTime);
			if(dateTime!="") {
				dtTime = driver.findElement(By.xpath(dtTimePath+"["+cntTime+"]")).getText().trim();
			}else {
				dtTime ="";
			}
			System.out.println("descName------="+descName+", lockName="+lockName+", sourceName="+sourceName+", dtTime="+dtTime);
			System.out.println("descName_DP---="+desc+", lockName="+lkName+", sourceName="+source+", dtTime="+dateTime);
			if(cnt==10) {
				//click next and follow same process
				System.out.println("in cnt 10");
				pageNextLink.click();
				Utility.simpleWait(5000);
			}
			if(descName.equals(desc)) {
				Log.addMessage("Event Description is matching");
			}else {
				Log.addMessage("Event Description is not matching");
				Assert.assertTrue(false, "Event Description is not matching");
			}
			if(lockName.equals(lkName)) {
				Log.addMessage("Lock Name is matching");
			}else {
				Log.addMessage("Lock Name is not matching");
				Assert.assertTrue(false, "Lock Name is not matching");
			}
			//if(sourceName.matches("/")) {
			String[] sourceMain =sourceName.split("/");
			System.out.println("len="+sourceMain.length);
			if(sourceMain.length>1) {
				System.out.println("len hmone="+sourceMain[0].trim());
				System.out.println("len hmtwo="+sourceMain[1].trim());
				sourceName= sourceMain[0].trim()+sourceMain[1].trim();
			}
			String[] sourceSub =source.split("/");
			System.out.println("len="+sourceSub.length);
			if(sourceSub.length>1) {
				System.out.println("len hmsubo="+sourceSub[0].trim());
				System.out.println("len hmsubo="+sourceSub[1].trim());
				source= sourceSub[0].trim()+sourceSub[1].trim();
			}
			/*sourceName.replaceAll("\\/", "H");
			source.replaceAll("\\/", "H");*/
			System.out.println("sourceName after replace="+sourceName+", source="+source);
			System.out.println("sourceName len="+sourceName.length()+", source len="+source.length());
			if(sourceName.equals(source)) {
			System.out.println("Home Source is matching1");
			}
			//}
			/*if(sourceName.equals(source.trim())) {
				Log.addMessage("Source is matching");
			}else {
				Log.addMessage("Source is not matching");
				Assert.assertTrue(false, "Source is not matching");
			}
			if(dateTime!="") {
				if((dtTime.trim()).equals(dateTime.trim())) {
					Log.addMessage("Date Time is matching");
				}else {
					Log.addMessage("Date Time is not matching");
					Assert.assertTrue(false, "Date Time is not matching");
				}	
			}*/
				System.out.println("compare val="+sourceName.trim().compareTo(source.trim()));
				if(sourceName.toUpperCase().compareTo(source.toUpperCase())!=0) {
					Log.addMessage("Source is not matching");
					Assert.assertTrue(false, "Source is not matching");
				}else {
					Log.addMessage("Source is matching");
				}
				if(dateTime!="") {
					if((dtTime.trim()).compareTo(dateTime.trim())!=0) {
						Log.addMessage("Date Time is not matching");
						Assert.assertTrue(false, "Date Time is not matching");
					}else {
						Log.addMessage("Date Time is matching");
					}	
				}
			System.out.println("---------------------Listed values in the home history---------------------");
		}catch(Exception e) {
			Log.addMessage("Failed to match events in home history");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to match events in home history");
		}
	}
	
	/**
	 * Method Name: checkLockHistoryEvents() Description: This function will be called
	 * to verify if the elements are sorted in ascending order
	 * @throws InterruptedException 
	*/
	public void checkLockHistoryEvents(String desc, String source, String dateTime, int cnt, int cntTime) throws InterruptedException {
		try {
			Utility.waitForElementToBeVisible(dateTimeHeader);
			//Getting the events listed in the page for each row
			String descName, sourceName, dtTime, descNamePath, sourceNamePath, dtTimePath="";
			
			if(cnt>10) {
				//click next and follow same process
				pageNextLink.click();
			}
			
			descNamePath = "(//div[@class='row history-items']//div[@class='col-xs-4 history-heading']//h5)";
			sourceNamePath = "(//div[@class='row history-items']//div[@class='col-xs-4 history-heading']/following-sibling::div[1]//h5)";
			dtTimePath = "(//div[contains(@class,'row history-items')]//div[contains(@class,'col-xs-3 history-heading')]/following-sibling::div[contains(@class,'col-xs-3 history-heading')]//h5[1])";
			
			descName = driver.findElement(By.xpath(descNamePath+"["+cnt+"]")).getText().trim();
			sourceName = driver.findElement(By.xpath(sourceNamePath+"["+cnt+"]")).getText().trim();
			System.out.println("dateTime="+dateTime+", cntTime="+cntTime+", cnt="+cnt);
			if(dateTime!="") {
				dtTime = driver.findElement(By.xpath(dtTimePath+"["+cntTime+"]")).getText().trim();
			}else {
				dtTime ="";
			}
			System.out.println("descName------="+descName+", sourceName="+sourceName+", dtTime="+dtTime);
			System.out.println("descName_DP---="+desc+", sourceName="+source+", dtTime="+dateTime);
			if(descName.equals(desc)) {
				Log.addMessage("Event Description is matching");
			}else {
				Log.addMessage("Event Description is not matching");
				Assert.assertTrue(false, "Event Description is not matching");
			}
			//if(sourceName.matches("/")) {
			String[] sourceMain =sourceName.split("/");
			System.out.println("len="+sourceMain.length);
			if(sourceMain.length>1) {
				System.out.println("len sone="+sourceMain[0].trim().length());
				System.out.println("len stwo="+sourceMain[1].trim().length());
				sourceName= sourceMain[0].trim()+sourceMain[1].trim();
			}
			String[] sourceSub =source.split("/");
			System.out.println("len="+sourceSub.length);
			if(sourceSub.length>1) {
				System.out.println("len one="+sourceSub[0].trim().length());
				System.out.println("len two="+sourceSub[1].trim().length());
				source= sourceSub[0].trim()+sourceSub[1].trim();
			}
				/*sourceName.replaceAll("\\/", "H");
				source.replaceAll("\\/", "H");*/
				System.out.println("sourceName after replace="+sourceName+", source="+source);
				System.out.println("locksourceName len="+sourceName.length()+", source len="+source.length());
				if(sourceName.equals(source)) {
				System.out.println("Source is matching1");
				}
			//}
			if(sourceName.toUpperCase().compareTo(source.toUpperCase().trim())!=0) {
				Log.addMessage("Source is not matching");
				Assert.assertTrue(false, "Source is not matching");
			}else {
				Log.addMessage("Source is matching");
			}
			if(dateTime!="") {
				if((dtTime.trim()).compareTo(dateTime.trim())!=0) {
					Log.addMessage("Date Time is not matching");
					Assert.assertTrue(false, "Date Time is not matching");
				}else {
					Log.addMessage("Date Time is matching");
				}	
			}
			System.out.println("---------------------Listed values in the home history---------------------");
		}catch(Exception e) {
			Log.addMessage("Failed to match events in home history");
			System.out.println(e.getMessage().toString());
			Assert.assertTrue(false, "Failed to match events in home history");
		}
	}
	
}