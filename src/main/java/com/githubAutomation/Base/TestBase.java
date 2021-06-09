package com.githubAutomation.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.githubAutomation.Utilis.Utilities;

@Listeners (com.githubAutomation.Listeners.TestNGListeners.class)

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	

	public TestBase() {

		try {
			prop = new Properties();

			FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "//config.properties");
			prop.load(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeTest
	@Parameters("browserName")
	
	public void browserinitialization(String browserName) {
		

		if (browserName.equalsIgnoreCase("Chrome")) {

			System.setProperty("WebDriver.chrome.driver", System.getProperty("user.dir") + "//chromedriver.exe");

			driver = new ChromeDriver();
			
		} else if (browserName.equalsIgnoreCase("firefox")) {
			
           System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//geckodriver.exe");
			
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(Utilities.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(Utilities.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));

	}
	
	@AfterTest
	
	public void tearDown() {
		
		driver.quit();
	}
}
