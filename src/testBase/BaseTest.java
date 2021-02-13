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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	 public static WebDriver driver;
		public static  Properties prop;
		
		public BaseTest()   {
			try {
			prop=new Properties();
			FileInputStream fp= new FileInputStream("C:\\Users\\anand\\Documents\\Saru\\GitSample\\GitDemo\\TeslaAccountProject\\src\\onfig\\config.properties");
				 prop.load(fp);
			} catch (IOException e) {
				
				e.printStackTrace();
			
			 
			}  
		}
		@BeforeMethod
		public static void Initialize_The_Browser() throws IOException {
			  
		   //check for the browser
		   String browser=prop.getProperty("browser");
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
			   
		   driver.get(prop.getProperty("url"));
		   driver.manage().window().maximize();
		   driver.manage().deleteAllCookies();
		   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		   driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);

		}

		@AfterMethod
		   public static void close_The_Browser() throws IOException {
			   
			 		   driver.quit();
		   }
		   
		   
		    public  void takeScreenShot(WebDriver driver,String fileWithPath) throws Exception{

		        //Convert web driver object to TakeScreenshot

		        TakesScreenshot scrShot =((TakesScreenshot)driver);

		        //Call getScreenshotAs method to create image file

		                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

		            //Move image file to new destination

		                File DestFile=new File(fileWithPath);

		                //Copy file at destination

		                FileUtils.copyFile(SrcFile, DestFile);

		    }
		    
		    protected static ExtentTest logger;
			protected static ExtentReports report;
			
			@BeforeClass
			public static void CreateReport() {
				String fileName = new SimpleDateFormat("'TeslaReport_'YYYYMMddHHmm'.html'").format(new Date());
				String path = "./src/TeslaReport/" + fileName;
				report = new ExtentReports(path);
			}
			
			@AfterClass
			//close the report
			public static void CloseReport() {
				report.endTest(logger);
				report.flush();
			}


	
}
