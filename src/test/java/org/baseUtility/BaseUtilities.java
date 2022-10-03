package org.baseUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseUtilities {
	
		public WebDriver startUp(String browserName)
		{
			String projectPath=System.getProperty("user.dir");
			WebDriver driver=null;
			if(browserName.equalsIgnoreCase("ch"))
			{
			System.setProperty("webdriver.chrome.driver", projectPath+"\\Driver\\chromedriver.exe");
			driver=new ChromeDriver();
			}
			else if(browserName.equalsIgnoreCase("ff"))
			{
			System.setProperty("webdriver.chrome.driver", projectPath+"\\Driver\\geckodriver.exe");
			driver=new FirefoxDriver(); 
		    }
			driver.manage().window().maximize();
			return driver;
		}
}
