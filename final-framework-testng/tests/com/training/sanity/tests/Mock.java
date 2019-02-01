package com.training.sanity.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Mock {
	public static WebDriver driver;
	@Test
	public static void run() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Demo\\chromedriver.exe");
		WebDriver driver;
		driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.findElement(By.name("userName")).sendKeys("venkat");
    	driver.findElement(By.name("password")).sendKeys("venkat");
    	driver.findElement(By.name("login")).click();
		boolean expected=true;
		boolean actual = fromport();
		assertEquals(actual, expected);
	}
		
	/*	Select sortList = new Select(driver.findElement(By.id("products-orderby")));
		List <WebElement> listS = sortList.getOptions();
		int size = listS.size();
		System.out.println(size); */
		
/*		driver.findElement(By.name("userName")).sendKeys("venkat");
    	driver.findElement(By.name("password")).sendKeys("venkat");
    	driver.findElement(By.name("login")).click();
    	Select fromList = new Select(driver.findElement(By.name("fromPort")));
    	fromList.selectByVisibleText("Sydney");
    	Select toList = new Select(driver.findElement(By.name("toPort")));
    	List <WebElement> listTo = toList.getOptions();
    	for (int i=0; i<listTo.size(); i++) {
    		String temp=listTo.get(i).getText();
    		if (temp == "Sydney") {
    			return true;
    			break;
    		}
    		else return false;
    	}
 //   	List <WebElement> fromList1 = fromList.getOptions(); 
 //   	int actualfrom = fromList1.size();
    	System.out.println(actualfrom);
    	int expectedfrom=10;
		assertEquals(actualfrom, expectedfrom);
		
		
	/*	WebElement userName = driver.findElement(By.name("userName"));
		userName.sendKeys("manzoor");
		Thread.sleep(2000);
		String ActualResult = userName.getAttribute("value");
		System.out.println(ActualResult);
		String ExpectedResult="manzoor";
		Assert.assertEquals(ActualResult, ExpectedResult);
		/*System.setProperty("webdriver.chrome.driver", "C:\\Selenium Demo\\chromedriver.exe");
		WebDriver driver;
		driver = new ChromeDriver();
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		String handle = driver.getWindowHandle();
		System.out.println(handle);
		driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div/div/p[3]/button")).click();
		Set handles = driver.getWindowHandles();
		System.out.println(handles);
		
		for(String h1:driver.getWindowHandles()) {
			System.out.println(h1);
			driver.switchTo().window(h1);      
		}
//		WebDriverWait wait = new WebDriverWait(driver,20);
//		WebElement link1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathExpression)));
	//	link1.click();
		
/*		List<WebElement> tagList = driver.findElements(By.tagName("a"));
		for (int i=0; i<tagList.size(); i++) {
			System.out.println(tagList.get(i).getText());
		}
		System.out.println(tagList.size());
		List<WebElement> iFrame = driver.findElements(By.xpath("//iframe"));
		for (int i=0; i<iFrame.size(); i++) {
			System.out.println(iFrame.get(i).getText());
		}
		System.out.println("iFrames:"+iFrame.size());
*/		
//		driver.close();
	//	driver.quit();

	static public boolean fromport(){
		//compare values 
		Select fromList = new Select(driver.findElement(By.name("fromPort")));
    	fromList.selectByVisibleText("Sydney");
    	Select toList = new Select(driver.findElement(By.name("toPort")));
    	List <WebElement> listTo = toList.getOptions();
    	boolean value=false;
    	for (int i=0; i<listTo.size(); i++) {
    		String temp=listTo.get(i).getText();
    		if (temp == "Sydney") {
    			value=true;
    			break;
    			}
    		else value=false;
    	}
    	return value;
	}
}

