package com.revature.testng;

import org.testng.annotations.Test;

import com.revature.selenium.CurriculumCore;
import com.revature.selenium.LoginPage;
import com.revature.selenium.ProfilePage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class CurriculaCoreTests {
	WebDriver driver;
	LoginPage lp;
	CurriculumCore cc;
	
	
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
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }
  
  @Test(priority=1)
  public void loginSuccessful() {
//	  File chrome = new File("src/main/resources/chromedriver");
	  File chrome = new File("src/test/resources/chromedriver.exe");
	  
	  System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
	  
	  driver = new ChromeDriver();
	  lp = new LoginPage();
	  cc = new CurriculumCore();
	  lp.loginAsVp(driver);
  }
  
  @Test(priority=2)
  public void goToCurriculaPage() {
	  cc.goToCurriculaPage(driver);
  }
  
  @Test(priority=3)
  public void clickAddButton() {
	  cc.clickAddButton(driver);
  }
  
  @Test(priority=4)
  public void addToCore() {
	  cc.addToCore(driver);
  }

}
