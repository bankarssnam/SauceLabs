package testBase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import testData.TestDataProvider;
import utils.DateUtil;
import utils.PropertiesOperations;
import pageObjectRepository.*;
/**
 * Base class - creates driver object, properties file object.
 * setter and getter methods to get WebDriver object.
 * @BeforeClass to set driver object and launch the application.
 * @AfterClass to close the browser
 * browser and application URL - read from Config.properties file.
 * @author Suraj Bankar
 *
 */


public class TestBase {
	static Logger LOG = LoggerFactory.getLogger(TestBase.class);
	protected static WebDriver driver;
	public PropertiesOperations propObj;
	protected DateUtil dateUtil;

	@BeforeClass
	public void setup() throws IOException {
		this.propObj = PropertiesOperations.loadProperties();
		setupDriverObj();
	}

	public void setupDriverObj() throws IOException {
		String browser = propObj.getPropertyValueByKey("browser");
		
		ChromeOptions options=new ChromeOptions();
		if(browser.contains("headless")) {
			options.addArguments("headless");
		}		
		options.addArguments("--disable-notifications");
		options.addArguments("--incognito");
		
		driver = switch (browser) {
		case "headless" -> new ChromeDriver(options);
		case "chrome" -> new ChromeDriver(options);
		
		case "edge" -> new EdgeDriver();
		default -> throw new IllegalArgumentException("Unexpected value: " + browser);
		};
		LOG.info("WebDriver object is created for the browser : "+browser);
		launchBrowser();
	}

	public static WebDriver getDriverObj() {
		return driver;		
	}

	public void launchBrowser() throws IOException {
		String url = propObj.getPropertyValueByKey("url");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get(url);
		System.out.println("Launching the application URL success");
		LOG.info("Launching the application URL: "+url);
		//driver.findElement(By.id("user-name")).sendKeys("abc");
	}
	
	@AfterClass
	public void closeBrowser() throws IOException {
		LOG.info("Closing the browser....");
		driver.close();
		driver.quit();
	}
}
