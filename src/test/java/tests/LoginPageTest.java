package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepage.BasePage;
import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class LoginPageTest extends BasePage{

	public WebDriver driver;
	public Logger log;
	@BeforeMethod
	public void setUp() throws Exception {
		log = LogManager.getLogger(LoginPageTest.class.getName());
		driver = initializeDriver();
		log.debug("Browser Launched");
		driver.get(prop.getProperty("Url"));
		log.debug("navigate to application Url");
		/* when you will run this test case you will get nullPointerException
		 * if you will not declare The Properties class on a global basis.
		 */
	}
	
	@Test(dataProvider = "getLoginData")
	public void test(String email,String passW,String expectedResult) {
	//	log = LogManager.getLogger(LoginPageTest.class.getName());
		/* don't create log manager statement here because @BeforeMethod 
		 * will run first otherwise if you will you will get nullPointerException
		 * */
		HomePage homePage = new HomePage(driver);
		homePage.myAccountDropDown().click();
		log.debug("Clicked on My Account dropDown");
		homePage.loginOptionDropDown().click();
		log.debug("clicked on login option");
		
		LoginPage loginPage = new LoginPage(driver);
		log.debug("navigate to application login page");
		loginPage.enterEmailId().sendKeys(email);
		log.debug("email address got entered");
		loginPage.enterPassword().sendKeys(passW);
		log.debug("password address got entered");
		loginPage.clickOnLogInBtn().click();
		log.debug("clicked on login button");
		
		AccountPage accountPage = new AccountPage(driver);
		
//		String actualResult = accountPage.validateAccount().getText();
		String actualResult = accountPage.validateAccount().getText();
		log.debug("user got the Account Text");
//		try{
//			if(accountPage.validateAccount().isDisplayed()) {
//				actualResult = "successful";
//			}
//		}
//		catch(Exception e) {
//			actualResult = "failure";
//		}
//		
//		Assert.assertEquals(actualResult, expectedResult);
//		System.out.println(accountPage.validateAccount().isDisplayed());
	    expectedResult="Account";
		Assert.assertEquals(actualResult, expectedResult);
		log.debug("user inside account");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		log.debug("Browser got Closed");
	}
	
	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data = {
				{"anilkashyap2011@gmail.com","@Sdf123","successful"}
//				{"xyz@yahoo.com","sane@321","failure"},
//				{"harsh@yahoo.com","harsh@321","failure"},
//				{"arun.selenium@gmail.com","Second@123","successful"}
				};
		
		return data;
	}
}
