package com.libr.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.libr.qa.utils.TestUtils;
import com.libr.qa.utils.WebEventListner;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListner eventListener;

	
public TestBase()
	{
		try{
			String myCurrentDir = System.getProperty("user.dir") ;
			prop = new Properties();
			FileInputStream fp = new FileInputStream(myCurrentDir+"/src/main/java/com/libr/qa/configs/config.properties");
			prop.load(fp);
		}
		catch(FileNotFoundException e)
		{
			e.getMessage();
		}
		catch(IOException e)
		{
			e.getMessage();
		}
	}


	public void initialise()
	{
		String browser = prop.getProperty("browser");

		if(browser.equals("chrome"))
		{
			System.out.println("Chrome browser");
			System.setProperty("webdriver.chrome.driver","E:/jars/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "E:/jars/geckodriver.exe");
			System.out.println("Ready");
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Incorrect Browser "+browser+" is specified in config.properties.");
		}

		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListner();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtils.ImpliciteWait, TimeUnit.MINUTES);
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PageLoadTimeout, TimeUnit.MINUTES);
		
		driver.get(prop.getProperty("url"));

		
		
		
		
		
		
		
		
		
		
		
	}

}
