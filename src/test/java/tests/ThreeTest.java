package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ThreeTest {
	public WebDriver driver;
	@Test
	public void thirdTest() {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
		driver.get("https://www.nasa.gov/");
	}
}
