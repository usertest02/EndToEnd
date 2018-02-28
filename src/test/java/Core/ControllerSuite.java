package Core;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ObjectConfigInputs.ObjectConfigClass;
import Utility.ExcelReader;
import Utility.monitoringMail;

public class ControllerSuite extends ObjectConfigClass {

	public static WebDriver driver= null;
	public static Logger log= Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\TestData.xlsx");
    public  static String log4jConfPath = System.getProperty("user.dir")+"\\src\\test\\java\\log4j.properties";

	
    @BeforeSuite
	public static void Startup()
	{
		PropertyConfigurator.configure(log4jConfPath);
		try
		{
		log.info("Launching !!");
			
		driver= new FirefoxDriver();
		driver.navigate().to(ObjectConfigClass.testSiteURL);
		driver.findElement(By.xpath(signInFrist)).click();
		log.info("TestSite Opened Successfully !!");
		driver.manage().timeouts().implicitlyWait(100L, TimeUnit.SECONDS);
		}
		catch(Throwable t)
		{
			log.info("Error in opening the test site :( :(");
		}
		
	}
	
	@AfterSuite
	public static void ShutDown()
	{
		try
		{
		driver.quit();
		log.info("Browser closed successfully !!");
		monitoringMail mail = new monitoringMail();
		mail.sendMail(ObjectConfigClass.server, ObjectConfigClass.from, ObjectConfigClass.to, ObjectConfigClass.subject, ObjectConfigClass.messageBody, ObjectConfigClass.attachmentPath, ObjectConfigClass.attachmentName);
		}
		catch(Throwable t)
		{
			log.info("Error while quiting the browser :(");
		}
	}
	
	
	
}
