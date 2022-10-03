package org.makemytrip;

import java.time.Duration;
import java.util.List;

import org.baseUtility.BaseUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Flybook {
	static WebDriver driver;
	public static void main(String[] args) {
		String flightName,takeofftime,landingtime;
		
		BaseUtilities bu=new BaseUtilities();
		driver=bu.startUp("ch");
		driver.get("https://www.makemytrip.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.id("fromCity")).click();
		WebElement ele=driver.findElement(By.xpath("//input[contains(@class,'react-autosuggest')]"));
		ele.sendKeys("Pune");
		driver.findElement(By.xpath("//*[text()='Pune, India']")).click();

		WebElement ele1=driver.findElement(By.xpath("//input[contains(@class,'input--open')]"));
		ele1.sendKeys("bangaluru");
		driver.findElement(By.xpath("//*[text()='Bengaluru, India']")).click();
		
		driver.findElement(By.xpath("//div[@aria-label='Tue Jun 07 2022']")).click();
		driver.findElement(By.xpath("//*[text()='Search']")).click();
		driver.findElement(By.xpath("//*[text()='OKAY, GOT IT!']")).click();
		
		List<WebElement> name=driver.findElements(By.xpath("//*[contains(text(),'1 stop via')]//ancestor::div[@class='makeFlex simpleow']//p[@class='boldFont blackText airlineName']"));
		List<WebElement> takeOff=driver.findElements(By.xpath("//*[contains(text(),'1 stop via')]//ancestor::div[@class='timingOptionOuter']//div[contains(@class,'timeInfoLeft')]//p[contains(@class,'black')]"));
		List<WebElement> landing=driver.findElements(By.xpath("//*[contains(text(),'1 stop via')]//ancestor::div[@class='timingOptionOuter']//div[contains(@class,'timeInfoRight')]//p[contains(@class,'blackText')]"));
	
		for (int i = 0; i < name.size(); i++) {
			
			flightName=name.get(i).getText();
			takeofftime=takeOff.get(i).getText();
			landingtime=landing.get(i).getText();
			
			System.out.println(flightName + "     " + takeofftime + "     " + landingtime);
			
			
		}
		
	}

}
