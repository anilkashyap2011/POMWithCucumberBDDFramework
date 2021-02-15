package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TwoTest {
	public WebDriver driver;
	@Test
	public void secondTest() {
		System.out.println("Arabind has updated this line of code statement for some changes ");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.isro.gov.in/");
	}
}
