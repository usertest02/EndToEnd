package UIWrapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Core.ControllerSuite;
import ObjectConfigInputs.ObjectConfigClass;

public class LoginPage extends ControllerSuite {
		
	
	
	@FindBy(xpath=ObjectConfigClass.usernameObj)
	public static WebElement userNameTextBox;
	
	@FindBy(xpath=ObjectConfigClass.nextObj)
	public static WebElement nextButton;
	
	@FindBy(xpath=ObjectConfigClass.passwordObj)
	public static WebElement passwordTextBox;
	
	@FindBy(xpath=ObjectConfigClass.signInObj)
	public static WebElement signInButton;
	

	
 public HomePage doLogin(String username, String password)
 {
		
	userNameTextBox.sendKeys(username);
	nextButton.click();
	passwordTextBox.sendKeys(password);
	signInButton.click();
	return PageFactory.initElements(driver, HomePage.class);
	 
 }
	
	
	
	
}
