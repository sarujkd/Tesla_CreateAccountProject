package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.CreateAccountPage;
import testBase.BaseTest;

public class CreateAccountTest extends BaseTest{

	 CreateAccountPage cp;
	
	@Test
	public void test_Create_Account()    {
		
		 cp=new  CreateAccountPage();
   logger=report.startTest("test_Create_Account testcase is started");
   logger.log(LogStatus.INFO,"Create_Account testcase is started");
   logger.log(LogStatus.INFO,"URL is launched successfully");
   
   cp.Click_teslaAccountLink();
   logger.log(LogStatus.INFO,"Tesla Account Link is clicked");
   
   cp.Click_createAccountBtn();
   logger.log(LogStatus.INFO,"Create Account button is clicked");
   
   String act_title=cp.CreateAccountPageTitle();
   Assert.assertTrue(act_title.equals("Tesla SSO - Register"));
   logger.log(LogStatus.INFO,"Create Account page title"+" Tesla SSO - Register "+" is displayed");
   
   //Filling the details in Create Account form
   
   cp.AddFirstName(prop.getProperty("firstName"));
   cp.AddLastName(prop.getProperty("lastName"));
   cp.AddEmailAddress(prop.getProperty("email"));
   cp.AddPassword(prop.getProperty("password"));
   
   cp.Click_PrivacyCheckBox();
   logger.log(LogStatus.INFO,"Ignored next step because of recaptcha");
   
   //cp.Click_createAccntBtn();
   
   logger.log(LogStatus.PASS,"Create_Account testcase is passed");
	}
	
}
