package com.cap.testCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.cap.pages.GooglePage;
import com.relevantcodes.extentreports.LogStatus;


import testBase.BaseTest;

public class Google_Test extends BaseTest {
	
		GooglePage cp;

	@Test(priority = 1,  enabled = true)
	public void test_Google() throws Exception {

		cp = new GooglePage();

		
		logger.log(LogStatus.INFO, "URL is launched successfully");

		// Display Title
		String act_Title=cp.google_Title();
		System.out.println("Title is: "+act_Title);
		String exp_Title="Google4";
		
		Assert.assertEquals(act_Title,exp_Title);
		logger.log(LogStatus.INFO, "Expected Title : "+act_Title+" is displayed");
		   
	}

	@Test(priority = 2, enabled = true)
	public void test_display_CurrentURL() throws Exception {

		cp = new GooglePage();
		
		logger.log(LogStatus.INFO, "URL is launched successfully");

		// Get current URL

		String actualCur_URL = cp.displayCurrent_Url();
		String expected_URL = "https://www.google.com/";
		
		Assert.assertTrue(actualCur_URL.equals(expected_URL));
		logger.log(LogStatus.INFO, "Current URL " + actualCur_URL+ "  is displayed");

	}

}

