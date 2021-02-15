package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'My Account')]") 
	private WebElement clickOnMyAccountDropDown;
	public WebElement myAccountDropDown() {
		return clickOnMyAccountDropDown;
	}
	
	@FindBy(xpath="//ul//a[contains(text(),'Login')]")
	private WebElement LoginOption;
	public WebElement loginOptionDropDown() {
		return LoginOption;
	}
	
}
