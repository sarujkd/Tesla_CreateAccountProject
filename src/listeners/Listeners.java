package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import testBase.BaseTest;

public class Listeners extends BaseTest implements ITestListener{
	
			
    public void onTestFailure(ITestResult result) {					
        		
    	logger.log(LogStatus.FAIL, result.getName()+" is failed");
		logger.log(LogStatus.FAIL, result.getThrowable());
		
		String screenshotPath;
		try {
			screenshotPath = BaseTest.takeScreenShot(driver,result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
			
    }		

   		
    public void onTestSkipped(ITestResult result) {					
      			logger.log(LogStatus.SKIP,result.getName()+" is skipped");
      						
        		
    }	

    @Override		
    public void onTestStart(ITestResult result) {					
    	logger = report.startTest(result.getName()+" Test");
    	logger.log(LogStatus.INFO, result.getName()+" testcase is started");
        		
    }		

    @Override		
    public void onTestSuccess(ITestResult result) {					
      				
    	logger.log(LogStatus.PASS,result.getName()+" is passed");		
    }		
}		


