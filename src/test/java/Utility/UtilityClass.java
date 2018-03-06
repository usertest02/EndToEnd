package Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Core.ControllerSuite;
import Utility.ExcelReader;
public class UtilityClass extends ControllerSuite {

	static ExcelReader excel;
	// redundant
	public static Object[][] getData(String sheetName)
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
	
	public static void captureScreenshot(String screen, WebDriver driver) throws IOException
	{	
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile,new File(System.getProperty("user.dir")+"\\screenshot\\"+screen+timestamp()+".jpg"));
	
}
	public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
}
	
	public static String decodePassword(String encodedStringPassword)
	{
		byte[] bytesDecoded= Base64.decodeBase64(encodedStringPassword);
		return new String(bytesDecoded);
	}
	
	
}
