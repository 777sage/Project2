package com.revature.testng;

import org.testng.annotations.Test;

import com.revature.selenium.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
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
	
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
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
	  File chrome = new File("src/main/resources/linux/chromedriver");
	  System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
	  driver = new ChromeDriver();
	  lp = new LoginPage();
	  
	  try {
		  Properties props = new Properties();
		  InputStream in = new FileInputStream("src/main/resources/util.properties");
		  props.load(in);
		  trainerUsername = props.getProperty("trainerUsername");
		  trainerPassword = props.getProperty("trainerPassword");
	  } catch(Exception e) {
		  System.out.println(e.getMessage());
	  }
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }
  
  @Test()
  public void findLoginPageSuccessful() {  
//	  wd.get("https://dev.assignforce.revaturelabs.com");
//	  System.out.println(loginPageTitle);
	  lp.findLoginPage(driver);
	  String loginPageTitle = lp.getTitle(driver);
	  assertEquals(loginPageTitle, "Login | Salesforce"); 
  }
  
  @Test()
  public void loginAsTrainerSuccessful() {
	  lp.loginAsTrainer(driver);
	  String homePageTitle = lp.getTitle(driver);
	  assertEquals(homePageTitle, "AssignForce");
  }
  
  @Test()
  public void loginAsTrainerWithWrongCredentials() {
	  
  }
  

}
