package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
 public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	// If you will not initialize an object It will return nullPointerException or
	//StaleElementReferenceExeption

	//Page Factory 
	@FindBy(id="input-email")
	private WebElement emailAddressField;
	
	//Page Factory 
	@FindBy(id="input-password")
	private WebElement passwordField;

	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement loginBtn;
		
	public WebElement enterEmailId() {
		return emailAddressField;
	}

	public WebElement enterPassword() {
		return passwordField;
	}

	public WebElement clickOnLogInBtn() {
		return loginBtn;
	}

}
