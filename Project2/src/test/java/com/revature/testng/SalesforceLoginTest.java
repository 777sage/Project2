package com.revature.testng;

import org.testng.annotations.Test;

import com.revature.dao.Service;
import com.revature.selenium.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class SalesforceLoginTest {
	WebDriver driver;
	LoginPage lp;
	String trainerUsername;
	String trainerPassword;
	Service service;
	
	
//  @Test(dataProvider = "dp")
//  public void f(Integer n, String s) {
//  }
  @BeforeMethod
  public void beforeMethod() {
	  File chrome = new File("src/main/resources/chromedriver");
//	  File chrome = new File("src/test/resources/chromedriver.exe");
	  System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
	  driver = new ChromeDriver();
	  lp = new LoginPage();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  @BeforeClass
  public void beforeClass() {

  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
//	  File chrome = new File("src/main/resources/chromedriver");
////	  File chrome = new File("src/test/resources/chromedriver.exe");
//	  System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
//	  driver = new ChromeDriver();
//	  lp = new LoginPage();
	  
//	  try {
//		  Properties props = new Properties();
//		  InputStream in = new FileInputStream("src/main/resources/util.properties");
//		  props.load(in);
//		  trainerUsername = props.getProperty("trainerUsername");
//		  trainerPassword = props.getProperty("trainerPassword");
//	  } catch(Exception e) {
//		  System.out.println(e.getMessage());
//	  }
  }

  @AfterTest
  public void afterTest() {
//	  driver.close();
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }
  
  @Test(priority=0)
  public void findLoginPageSuccessful() {  
//	  wd.get("https://dev.assignforce.revaturelabs.com");
//	  System.out.println(loginPageTitle);
	  lp.findLoginPage(driver);
	  String loginPageTitle = lp.getTitle(driver);
//	  assertEquals(loginPageTitle, "Login | Salesforce"); 
	  try {
		  assertEquals(loginPageTitle, "Login | Salesforce"); 
		  Service.updateTest("findLoginPageSuccessul", "Success");
		  System.out.println(Service.getAllTests());
	  } catch(Error e) {
		  Service.updateTest("findLoginPageSuccessful", "Failed");
		  System.out.println(e.getMessage());
	  }
  }
  
  @Test(priority=1)
  public void loginAsTrainerWithWrongCredentials() {
	  System.out.println("Which page title bad credentials: " + driver.getTitle());
	  lp.loginAsTrainerWithBadCredential(driver);
	  WebElement error = driver.findElement(By.id("error"));
	  boolean passwordMessageShown = error.getText().contains("password"); 
	  assertTrue(passwordMessageShown);
  }
  
  @Test(priority=2)
  public void loginAsTrainerSuccessful() {
	  lp.loginAsTrainer(driver);
	  String homePageTitle = lp.getTitle(driver);
	  assertEquals(homePageTitle, "AssignForce");
  }
  
  @Test(priority=3)
  public void loginAsTrainerLandsOnHomePage() {
	  System.out.println("Which page show all batches: " + driver.getTitle());
	  lp.loginAsTrainer(driver);
//	  WebElement batchHead = driver.findElement(By.tagName("table"));
//	  System.out.println(batchHead);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  WebElement logo = driver.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/img"));
	  System.out.println("Title " + driver.getTitle());
	  System.out.println(logo);
	  WebElement batchHeader = driver.findElement(By.xpath("//*[@id=\"view\"]/div/md-card/md-toolbar/div[1]/span"));
	  System.out.println(batchHeader.getText());
  }
  
  @Test(priority=4)
  public void loginAsVpSuccessful() {
	  lp.loginAsVp(driver);
	  String homePageTitle = lp.getTitle(driver);
	  assertEquals(homePageTitle, "AssignForce");
  }
  

}
