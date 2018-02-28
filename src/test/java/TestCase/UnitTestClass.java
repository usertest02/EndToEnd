package TestCase;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Utility.UtilityClass;
public class UnitTestClass {
	public static WebDriver driver= new FirefoxDriver();
	public static  String screen="malini";
	//public static  UtilityClass uc= new UtilityClass() ;
	public static void main(String[] a) throws IOException
	{
		driver.get("https://www.google.co.in");
		//uc= new UtilityClass();
		UtilityClass.captureScreenshot("Reuse", driver);
	
	}

}
