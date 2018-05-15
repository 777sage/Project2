package com.revature.testng;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;


import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.revature.dao.Service;
import com.revature.selenium.LoginPage;
import com.revature.selenium.ProfilePage;

public class ProfileTests {
	WebDriver driver;
	LoginPage lp;
	ProfilePage pp;
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
  public void profileNameInputDoesNotSave() {
	  File chrome = new File("src/main/resources/chromedriver");
//	  File chrome = new File("src/test/resources/chromedriver.exe");
	  
	  System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
	  
	  driver = new ChromeDriver();
	  lp = new LoginPage();
	  pp = new ProfilePage();
	  
	  lp.loginAsTrainer(driver);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  String[] result = pp.enterNameInputAndChangePage(driver);
	  String nameBeforePageChange = result[0];
	  String nameAfterPageChange = result[1];
	  
	  assertNotEquals(nameBeforePageChange, nameAfterPageChange);

	  driver.quit();
  }
}
