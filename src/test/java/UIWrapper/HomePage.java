package UIWrapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Core.ControllerSuite;
import ObjectConfigInputs.ObjectConfigClass;

public class HomePage extends ControllerSuite {
	@FindBy(xpath=ObjectConfigClass.userName)
	public static WebElement userNameLink;
	
	@FindBy(xpath=ObjectConfigClass.signOutObj)
	public static WebElement signOutButtonEasy;
	
	@FindBy(xpath=ObjectConfigClass.signInFrist)
	public static WebElement firstSignInButton;
	
	public AddAccount logOut()
	{
		Actions action= new Actions(driver);
		action.moveToElement(userNameLink).perform();
		signOutButtonEasy.click();
		firstSignInButton.click();
		return PageFactory.initElements(driver, AddAccount.class);
		
	}
	
}
