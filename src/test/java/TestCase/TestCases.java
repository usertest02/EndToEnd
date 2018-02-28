package TestCase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Core.ControllerSuite;
import ObjectConfigInputs.ObjectConfigClass;
import UIWrapper.AddAccount;
import UIWrapper.HomePage;
import UIWrapper.LoginPage;
import Utility.UtilityClass;
import Utility.monitoringMail;

public class TestCases extends ControllerSuite  {
public static HomePage hp;
public static AddAccount aa;
public static int i=0;



	@Test(dataProvider="getData")
	public void loginGmail(String userNameP, String passwordP ) throws Throwable 
	{
		
		
		try
		{
		LoginPage lp=PageFactory.initElements(driver, LoginPage.class);	
		log.info("Login Page opened successfully for "+userNameP);
		UtilityClass.captureScreenshot("LoginPage"+userNameP, driver);
		hp=lp.doLogin(userNameP, passwordP);
		log.info("Home Page Landed successfully for "+userNameP);
		UtilityClass.captureScreenshot("HomePage"+userNameP, driver);
		aa=hp.logOut();
		log.info("Logged Out successfully for "+ userNameP);
		UtilityClass.captureScreenshot("LogoutPage"+userNameP, driver);
		aa.addAccount();
		
		}
		catch(Throwable t)
		{
			log.info("Error :( :(");
			UtilityClass.captureScreenshot("Error", driver);
			
		}
		
	}
	@DataProvider
	public static Object[][] getData()
	{
		int totalRows=excel.getRowCount(sheetName);
		System.out.println(totalRows);
	    int totalColumns=excel.getColumnCount(sheetName);
	    System.out.println(totalColumns);
		Object[][] Object = new Object[totalRows-1][totalColumns];
		
		for(int i=2; i<=totalRows;i++)
		{
			for(int j=0; j<=totalColumns-1 ;j++)
			{
				Object[i-2][j]=excel.getCellData(sheetName, j, i);
			}
		}
		
		return Object;
	}
	
	
	
	
	
}
