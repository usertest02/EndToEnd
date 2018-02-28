package UIWrapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Core.ControllerSuite;
import ObjectConfigInputs.ObjectConfigClass;

public class AddAccount extends ControllerSuite {
	
	
	
	@FindBy(xpath=ObjectConfigClass.addAccountObj)
	public static WebElement addAccountButton;
	
public void addAccount()
{
	addAccountButton.click();
	
}
}
