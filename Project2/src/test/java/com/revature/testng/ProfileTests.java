package com.revature.testng;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.revature.dao.Service;
import com.revature.selenium.LoginPage;

public class ProfileTests {
	WebDriver driver;
	LoginPage lp;
	String trainerUsername;
	String trainerPassword;
	Service service;

  @Test
  public void afterClass() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void afterMethod() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void afterSuite() {
	  
  }

  @Test
  public void afterTest() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void beforeClass() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void beforeMethod() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void beforeSuite() {	  
//	  File chrome = new File("src/main/resources/chromedriver");
////	  File chrome = new File("src/test/resources/chromedriver.exe");
//	  System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
//	  
//	  driver = new ChromeDriver();
//	  lp = new LoginPage();
  }

  @Test
  public void beforeTest() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void dp() {
    throw new RuntimeException("Test not implemented");
  }
  
  @Test(priority=1)
  public void loginAsTrainerSuccessful() {
	  File chrome = new File("src/main/resources/chromedriver");
//	  File chrome = new File("src/test/resources/chromedriver.exe");
	  System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
	  
	  driver = new ChromeDriver();
	  lp = new LoginPage();
	  
	  lp.loginAsTrainer(driver);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  WebElement profileSpan = driver.findElement(By.xpath("//span[contains(text(), 'rofile')]"));
	  profileSpan.click();
	  
//	  WebElement profileSpan = driver.findElement(By.cssSelector("body > div > div:nth-child(1) > ng-include > div > md-content > md-nav-bar > div > nav > ul > li:nth-child(7) > a > span > span"));
//	  for (int i = 0 ; i < 2 ; i++) {
//		  profileSpan.click();
//	  }
		  
	  WebElement inputOne = driver.findElement(By.id("input_1"));
	  inputOne.clear();
	  inputOne.sendKeys("William");
	  
	  WebElement inputTwo = driver.findElement(By.id("input_2"));
	  inputTwo.clear();
	  inputTwo.sendKeys("Gibson");
	  
	  String firstNameBeforePageChange = inputOne.getText();
	  String lastNameBeforePageChange = inputTwo.getText();
	  System.out.println("Name before page change: " + (firstNameBeforePageChange + lastNameBeforePageChange));
	  
	  WebElement locationSpan = driver.findElement(By.xpath("//span[contains(text(), 'ocations')]"));
	  locationSpan.click();
	  profileSpan.click();
	  
	  String firstNameAfterPageChange = inputOne.getText();
	  String lastNameAfterPageChange = inputTwo.getText();
	  System.out.println("Name after page change: " + (firstNameAfterPageChange + lastNameAfterPageChange));
	  
	  
//	  WebElement locationsTab = driver.findElement(By.cssSelector("body > div > div:nth-child(1) > ng-include > div > md-content > md-nav-bar > div > nav > ul > li:nth-child(4) > a > span > span"));
//	  for (int i = 0 ; i < 2 ; i++) {
//		  locationsTab.click();
//	  }
//	  
//	  for (int i = 0 ; i < 2 ; i++) {
//		  profileSpan.click();
//	  }
//	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//	  driver.quit();
  }
}
