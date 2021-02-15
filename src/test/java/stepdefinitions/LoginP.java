package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import basepage.BasePage;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class LoginP extends BasePage{

	WebDriver driver;
	HomePage homePage;
	LoginPage loginPage;
	AccountPage accountPage;
    @Given("^Open any Browser$")
    public void open_any_browser() throws Exception {
    	driver = initializeDriver();
    }
    @When("^Navigate to Login page$")
    public void navigate_to_login_page() {
    	driver.get(prop.getProperty("Url"));
    	homePage = new HomePage(driver);
		homePage.myAccountDropDown().click();
		homePage.loginOptionDropDown().click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @And("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\" into the fields$")
    public void user_enters_username_as_something_and_password_as_something_into_the_fields(String username, String password) {
		loginPage = new LoginPage(driver);
		loginPage.enterEmailId().sendKeys(username);
		loginPage.enterPassword().sendKeys(password);
    }
    @And("^User clicks on Login button$")
    public void user_clicks_on_login_button() {
		loginPage.clickOnLogInBtn().click();
    }
    @Then("^Verify user is able to successfully login$")
    public void verify_user_is_able_to_successfully_login() {
    	AccountPage accountPage = new AccountPage(driver);
    	Assert.assertEquals(accountPage.validateAccount().getText(),"Account");
    }
    
    @After
    public void tearDown() {
    	driver.close();
    }
    
}
