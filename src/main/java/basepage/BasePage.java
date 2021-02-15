package basepage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public WebDriver driver;
	public FileInputStream fisprop;
	public Properties prop;
	
	public WebDriver initializeDriver() throws Exception{
	
			String filePath = System.getProperty("user.dir")+"\\propertiesFile\\prop.properties";
			fisprop = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(fisprop);
		
			String browserName = prop.getProperty("Browser");
			
		if(browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("opera")) {
			WebDriverManager.operadriver().setup();
		    driver = new OperaDriver();
		}
		else if(browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		return driver;
	}

	public String takeScreenshots(String testName, WebDriver driver) throws IOException {
		/* to take screenshots using listeners interface you need to make 
		 * webdriver as public and global from tests package or where you have 
		 * kept test cases
		 * */
		Date currentDate = new Date();
		String screenShotFileName = currentDate.toString().replace(" ", "-").replace(":", "-");
		
		File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinatioFilePath = System.getProperty("user.dir")+"\\screenshots\\"+screenShotFileName+"-"+testName+".png";
//		FileUtils.copyFile(screenShotFile, new File(System.getProperty("user.dir")+"\\Screenshots\\"+screenShotFileName+".png"));
		FileUtils.copyFile(screenShotFile, new File(destinatioFilePath));		
		
		return destinatioFilePath;
	}
}
