package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	
	public WebDriver driver;
	
	public AccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//ul[@class='breadcrumb']//a[contains(text(),'Account')]")
	private WebElement validateAccount;
	public WebElement validateAccount() {
		return validateAccount;
	}
}
