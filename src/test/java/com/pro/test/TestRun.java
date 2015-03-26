package com.pro.test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestRun {

	public WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	
  // Passing Browser parameter from TestNG xml
  public void beforeTest(String browser) {
  // If the browser is Firefox, then do this
	  if(browser.equalsIgnoreCase("firefox")) {
	  driver = new FirefoxDriver();
	 }
	  else if (browser.equalsIgnoreCase("ie")) {
  // Here I am setting up the path for my IEDriver
	 System.setProperty("webdriver.ie.driver", "C:\\eclipse\\prokarma\\src\\test\\resources\\IEDriverServer.exe");
	 driver = new InternetExplorerDriver();
  }
	  
	  else if (browser.equalsIgnoreCase("chrome")){
  // Here I am setting up the path for my IEDriver
		  System.setProperty("webdriver.chrome.driver","C:\\eclipse\\prokarma\\src\\test\\resources\\chromedriver.exe");
		  driver = new ChromeDriver();
		  
	  }
 
  driver.get("http://localhost:8080/app/#/home");
 
  }

	
	@Test
	public void testNegativeSubmit() throws InterruptedException{
		
		Thread.sleep(3000);
		driver.findElement(By.id("mobile-number")).sendKeys("123456789");
		Thread.sleep(3000);
		Select sel=new Select(driver.findElement(By.id("topup-amount")));
		sel.selectByIndex(1);
		Thread.sleep(3000);
		Select sele=new Select(driver.findElement(By.id("card-type")));
		sele.selectByIndex(2);
		Thread.sleep(3000);
		driver.findElement(By.id("card-number")).sendKeys("123456789111112");
		Thread.sleep(3000);
		driver.findElement(By.id("card-security-key")).sendKeys("1234");
		Thread.sleep(3000);
		driver.findElement(By.id("card-first-name")).sendKeys("Prokarma");
		Thread.sleep(3000);
		driver.findElement(By.id("card-last-name")).sendKeys("Professional");
		Thread.sleep(3000);
		driver.findElement(By.id("address1")).sendKeys("920 Hillview Court");
		Thread.sleep(3000);
		driver.findElement(By.id("address2")).sendKeys("Suite 280");
		Thread.sleep(3000);
		driver.findElement(By.id("city")).sendKeys("Milpitas");
		Thread.sleep(3000);
		Select selen=new Select(driver.findElement(By.id("region")));
		selen.selectByIndex(3);
		Thread.sleep(3000);
		boolean elementpresence;
		try {
			driver.findElement(By.id("terms-conditions"));
		   elementpresence = true;
		} catch (NoSuchElementException e) {
			elementpresence = false;
		}
		Assert.assertFalse(elementpresence);
	}	
	
	@Test
	public void testPositiveSubmit() throws InterruptedException{
		
		Thread.sleep(3000);
		driver.findElement(By.id("mobile-number")).sendKeys("123456789");
		Thread.sleep(3000);
		Select sel=new Select(driver.findElement(By.id("topup-amount")));
		sel.selectByIndex(1);
		Thread.sleep(3000);
		Select sele=new Select(driver.findElement(By.id("card-type")));
		sele.selectByIndex(2);
		Thread.sleep(3000);
		driver.findElement(By.id("card-number")).sendKeys("123456789111112");
		Thread.sleep(3000);
		driver.findElement(By.id("card-security-key")).sendKeys("1234");
		Thread.sleep(3000);
		driver.findElement(By.id("card-first-name")).sendKeys("Prokarma");
		Thread.sleep(3000);
		driver.findElement(By.id("card-last-name")).sendKeys("Professional");
		Thread.sleep(3000);
		driver.findElement(By.id("address1")).sendKeys("920 Hillview Court");
		Thread.sleep(3000);
		driver.findElement(By.id("address2")).sendKeys("Suite 280");
		Thread.sleep(3000);
		driver.findElement(By.id("city")).sendKeys("Milpitas");
		Thread.sleep(3000);
		Select selen=new Select(driver.findElement(By.id("region")));
		selen.selectByIndex(3);
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".btn")).click();
		Thread.sleep(3000);
		
		Assert.assertTrue(driver.findElement(By.id("terms-conditions")).isDisplayed());
		
	} 
	
	@Test
	public void testTopUp() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(By.id("mobile-number")).sendKeys("123456789");
		Thread.sleep(3000);
		Select sel=new Select(driver.findElement(By.id("topup-amount")));
		sel.selectByIndex(1);
		Thread.sleep(3000);
		Select sele=new Select(driver.findElement(By.id("card-type")));
		sele.selectByIndex(2);
		Thread.sleep(3000);
		driver.findElement(By.id("card-number")).sendKeys("123456789111112");
		Thread.sleep(3000);
		driver.findElement(By.id("card-security-key")).sendKeys("1234");
		Thread.sleep(3000);
		driver.findElement(By.id("card-first-name")).sendKeys("Prokarma");
		Thread.sleep(3000);
		driver.findElement(By.id("card-last-name")).sendKeys("Professional");
		Thread.sleep(3000);
		driver.findElement(By.id("address1")).sendKeys("920 Hillview Court");
		Thread.sleep(3000);
		driver.findElement(By.id("address2")).sendKeys("Suite 280");
		Thread.sleep(3000);
		driver.findElement(By.id("city")).sendKeys("Milpitas");
		Thread.sleep(3000);
		Select selen=new Select(driver.findElement(By.id("region")));
		selen.selectByIndex(3);
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".btn")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("terms-conditions")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".btn")).click();
		Thread.sleep(3000);
		
		Assert.assertTrue(driver.findElement(By.cssSelector(".glyphicon")).isDisplayed());
	}
	
	@Test
	public void testTopUpWithoutAccept() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(By.id("mobile-number")).sendKeys("123456789");
		Thread.sleep(3000);
		Select sel=new Select(driver.findElement(By.id("topup-amount")));
		sel.selectByIndex(1);
		Thread.sleep(3000);
		Select sele=new Select(driver.findElement(By.id("card-type")));
		sele.selectByIndex(2);
		Thread.sleep(3000);
		driver.findElement(By.id("card-number")).sendKeys("123456789111112");
		Thread.sleep(3000);
		driver.findElement(By.id("card-security-key")).sendKeys("1234");
		Thread.sleep(3000);
		driver.findElement(By.id("card-first-name")).sendKeys("Prokarma");
		Thread.sleep(3000);
		driver.findElement(By.id("card-last-name")).sendKeys("Professional");
		Thread.sleep(3000);
		driver.findElement(By.id("address1")).sendKeys("920 Hillview Court");
		Thread.sleep(3000);
		driver.findElement(By.id("address2")).sendKeys("Suite 280");
		Thread.sleep(3000);
		driver.findElement(By.id("city")).sendKeys("Milpitas");
		Thread.sleep(3000);
		Select selen=new Select(driver.findElement(By.id("region")));
		selen.selectByIndex(3);
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".btn")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".btn")).click();
		Thread.sleep(3000);
		 try 
		    { 
		        driver.switchTo().alert().accept(); 
		    }   // try 
		    catch (NoAlertPresentException Ex) 
		    { 
		    	Assert.fail("No Alert Shown ");
		    } 
	}
	
	
	
	
	@AfterClass
	public void afterTest() {

		driver.quit();

	}

}