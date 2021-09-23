package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	    public static  WebDriver driver;
		public static  Properties prop;
		
	    protected static ExtentTest logger;
		protected static ExtentReports report;
			
		
		public BaseTest()   {
			try {
			prop=new Properties();
			String cur_dir=System.getProperty("user.dir");
			FileInputStream fp= new FileInputStream( cur_dir+ "\\src\\com\\cap\\config\\config.properties");
				 prop.load(fp);
			} catch (IOException e) {
				
				e.printStackTrace();
						 
			}  
		}
		
		//Create Extent Report
		
		@BeforeSuite
		public static void CreateReport() {
			String fileName = new SimpleDateFormat("'GoogleReport_'YYYYMMddHHmm'.html'").format(new Date());
			String path = "./src/GoogleReport/" + fileName;
			report = new ExtentReports(path);
			report.addSystemInfo("Envirnment", "QA");
			report.addSystemInfo("User Name", "Sarvamangala");
		
		
		}
		
		//close the report
		
		@AfterSuite
		public static void CloseReport() {
			report.endTest(logger);
			report.flush();
		}

		@Parameters("browser")
		@BeforeMethod
		public static void setUp(String browser) throws IOException {
			  
		   //check for the browser
		  // String browser=prop.getProperty("browser");
		   if (browser.equalsIgnoreCase("Chrome")) {
			   WebDriverManager.chromedriver().setup();
		   
			   driver=new ChromeDriver();
		   }
		   else
			   if (browser.equalsIgnoreCase("FireFox")) {
				   WebDriverManager.firefoxdriver().setup();
				   driver=new FirefoxDriver();
			   }
			   else
				   if (browser.equalsIgnoreCase("edge")) {
					   WebDriverManager.edgedriver().setup();
					   driver=new EdgeDriver();
				   }
			   
		   driver.get(prop.getProperty("Google_url"));
		 
		   driver.manage().window().maximize();
		   driver.manage().deleteAllCookies();
		   driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		   driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);

		}

		@AfterMethod
		   public static void tearDown() throws Exception  {
			      
			 		   driver.quit();
		   }
		   
		   
		    public static String takeScreenShot(WebDriver driver,String screeshotName) throws Exception{

		    	String dateName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		        TakesScreenshot scrShot =(TakesScreenshot)driver;

		        //Call getScreenshotAs method to create image file

		                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

		            //Move image file to new destination
		                
		                String destination=System.getProperty("user.dir")+"/failedTestsScreenshots/"
		            +screeshotName+"-"+dateName+".png";

		                File DestFile=new File(destination);

		                //Copy file at destination

		                FileUtils.copyFile(SrcFile, DestFile);
		                
		       		      return destination;


		    }
		    

}
