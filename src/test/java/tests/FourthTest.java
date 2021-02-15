package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.internal.org.jline.utils.Log;

public class FourthTest {

	public WebDriver driver;
	@Test
	public void fourthTest() {
		
		System.out.println("Anil has updated the line of code with this statment");
		System.out.println("Anil second update");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		Assert.assertTrue(false);
		Log.error("Fourth test case got failed");

	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
