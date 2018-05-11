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
import org.openqa.selenium.chrome.ChromeOptions;
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
//	ChromeOptions options;
	
	
//  @Test(dataProvider = "dp")
//  public void f(Integer n, String s) {
//  }
  @BeforeMethod
  public void beforeMethod() {
//	  options = new ChromeOptions().addArguments("user-data-dir=C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User Data");
	  
//	  File chrome = new File("src/main/resources/chromedriver");
	  File chrome = new File("src/test/resources/chromedriver.exe");
	  System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
	  
	  
	  driver = new ChromeDriver();
//	  driver = new ChromeDriver(options);
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
		  //Service.updateTest("findLoginPageSuccessful", "Success");
//		  System.out.println(Service.getAllTests());
	  } catch(Error e) {
		  //Service.updateTest("findLoginPageSuccessful", "Failed");
		  System.out.println(e.getMessage());
	  }
  }
  
  @Test(priority=1)
  public void loginAsTrainerWithWrongCredentials() {
	  System.out.println("Which page title bad credentials: " + driver.getTitle());
	  lp.loginAsTrainerWithBadCredential(driver);
	  WebElement error = driver.findElement(By.id("error"));
	  boolean passwordMessageShown = error.getText().contains("password"); 
//	  assertTrue(passwordMessageShown);
	  try {
		  assertTrue(passwordMessageShown);
//		  Service.updateTest("loginAsTrainerWithWrongCredentials", "Success");
//		  System.out.println(Service.getAllTests());
	  } catch(Error e) {
//		  Service.updateTest("loginAsTrainerWithWrongCredentials", "Failed");
		  System.out.println(e.getMessage());
	  }
  }
  
  @Test(priority=2)
  public void loginAsTrainerSuccessful() {
	  lp.loginAsTrainer(driver);
//	  assertEquals(homePageTitle, "AssignForce");
	  try {
		  String homePageTitle = lp.getTitle(driver);
		  assertEquals(homePageTitle, "AssignForce");
		  Service.updateTest("loginAsTrainerSuccessful", "Success");
//		  System.out.println(Service.getAllTests());
	  } catch(Error e) {
		  Service.updateTest("loginAsTrainerSuccessful", "Failed");
		  System.out.println(e.getMessage());
	  }
  }
  
  @Test(priority=3)
  public void homePageDisplaysAllBatches() {
	  lp.loginAsTrainer(driver);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  System.out.println("Title " + driver.getTitle());
	  try {
		  WebElement batchHeader = driver.findElement(By.xpath("//*[@id=\"view\"]/div/md-card/md-toolbar/div[1]/span"));
		  assertEquals(batchHeader.getText(), "All Batches");
		  Service.updateTest("loginAsTrainerLandsOnHomePage", "Success");
		  System.out.println(Service.getAllTests());
	  } catch(Error e) {
		  Service.updateTest("loginAsTrainerLandsOnHomePage", "Failed");
		  System.out.println(e.getMessage());
	  }
  }
  
  @Test(priority=4)
  public void navigationTagsActive() {
	  lp.loginAsTrainer(driver);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  try {
		  WebElement overviewTab = driver.findElement(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[1]"));
		  overviewTab.click();
		  
		  WebElement batchesTab = driver.findElement(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[2]/a"));
		  batchesTab.click();
		  
		  WebElement locationsTab = driver.findElement(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[3]"));
		  locationsTab.click();
		  
		  WebElement curriculumTab = driver.findElement(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[4]"));
		  curriculumTab.click();
		  
		  WebElement trainersTab = driver.findElement(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[5]"));
		  trainersTab.click();
		  
		  WebElement profileTab = driver.findElement(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[6]"));
		  profileTab.click();
		  
		  WebElement reportsTab = driver.findElement(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[7]"));
		  reportsTab.click();
		  String isSelected = reportsTab.getAttribute("aria-selected");
		  System.out.println("Is Selected: " + isSelected);
		  assertEquals(isSelected, "true");
		  service.updateTest("reportsTabSelected", "Success");
		  
		  WebElement reportsTabSpan = driver.findElement(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[7]/a/span/span"));
		  System.out.println("Reports Tab Test" + reportsTabSpan.getText());
		  String reportsTabText = reportsTabSpan.getText();
		  assertEquals(reportsTabText, "REPORTS");
		  
		  Service.updateTest("navigationTagsActive", "Success");

		     
	  } catch(Exception e) {
		  Service.updateTest("navigationTagsActive", "Failed");
		  System.out.println(e.getMessage());
	  }

  }
  
  @Test(priority=5)
  public void filterSuccessful() {
	  lp.loginAsTrainer(driver);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  WebElement filter = driver.findElement(By.xpath("//*[@id=\"view\"]/div/md-card/md-toolbar/md-menu/button/md-icon"));
	  filter.click();
	  
//	  WebElement selectAll = driver.findElement(By.xpath("//*[@id=\"menu_container_0\"]/md-menu-content/md-menu-item[3]/button"));
//	  WebElement selectAll = driver.findElement(By.xpath("//*[@id=\"menu_container_0\"]/md-menu-content/md-menu-item[3]/button/span"));

//	  selectAll.click();
	  
//	  filter.click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//	  WebElement selectTwoWeeks = driver.findElement(By.xpath("//*[@id=\"menu_container_0\"]/md-menu-content/md-menu-item[2]/button/span"));
	  WebElement selectTwoWeeks = driver.findElement(By.cssSelector("#view > div > md-card > md-toolbar > md-menu > button > md-icon"));

	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  WebElement filterModal = driver.findElement(By.xpath("//*[@id=\"view\"]/div/md-card/md-toolbar/md-menu/button"));
	  String isExpanded = filterModal.getAttribute("aria-expanded");
	  try {

		  assertEquals(isExpanded, "true");
		  Service.updateTest("filterSuccessful", "Success");
	  } catch(Error e) {
		  Service.updateTest("filterSuccessful", "Failed");
		  System.out.println(e.getMessage());
	  }

	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  selectTwoWeeks.click();

//	  WebElement filterMenu = driver.findElement(By.xpath("//*[@id=\"menu_container_163\"]"));
//	  String ishidden = filterMenu.getAttribute("aria-hidden");
	  
  
//	  filter.click();
//	  WebElement selectInProgress = driver.findElement(By.xpath("*[@id=\"menu_container_0\"]/md-menu-content/md-menu-item[1]/button/span"));	  
  
	  
  }
  
  @Test(priority=6)
  public void trainerTests() {
	  lp.loginAsTrainer(driver);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  WebElement trainersTab = driver.findElement(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[5]"));
	  trainersTab.click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	  WebElement firstRow = driver.findElement(By.cssSelector("#view > md-card > md-content:nth-child(2) > md-list > md-list-item:nth-child(1) > div.md-button.md-no-style > button"));
	  WebElement trainerLabel = driver.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content[1]/md-list/md-list-item[1]/div[1]/div[1]/div/h3"));
	  String labelName = trainerLabel.getText();
	  System.out.println("Trainer Label: " + labelName);
	  firstRow.click();
	  
	  WebElement trainerDetailElement = driver.findElement(By.xpath("//*[@id=\"view\"]/md-card[2]/md-content[1]/div/div[1]/form/md-input-container[1]/h3"));
	  String trainerDetailElementText = trainerDetailElement.getText();
	  
	  try {

		  assertTrue(labelName.contains(trainerDetailElementText));
		  Service.updateTest("trainerTests", "Success");
//		  System.out.println(Service.getAllTests());
	  } catch(Error e) {
		  Service.updateTest("trainerTests", "Failed");
		  System.out.println(e.getMessage());
	  }
  }
  
  
  
  @Test(priority=7)
  public void vpTrainerTests() {
	  lp.loginAsVp(driver);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  WebElement trainersTab = driver.findElement(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[5]"));
	  trainersTab.click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	  WebElement firstRow = driver.findElement(By.cssSelector("#view > md-card > md-content:nth-child(2) > md-list > md-list-item:nth-child(1) > div.md-button.md-no-style > button"));
	  WebElement trainerLabel = driver.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content[1]/md-list/md-list-item[1]/div[1]/div[1]/div/h3"));
	  String labelName = trainerLabel.getText();
	  System.out.println("Trainer Label: " + labelName);
	  firstRow.click();
	  
	  WebElement trainerDetailElement = driver.findElement(By.xpath("//*[@id=\"view\"]/md-card[2]/md-content[1]/div/div[1]/form/md-input-container[1]/h3"));
	  String trainerDetailElementText = trainerDetailElement.getText();
	  
	  try {

		  assertTrue(labelName.contains(trainerDetailElementText));
		  Service.updateTest("trainerTests", "Success");
//		  System.out.println(Service.getAllTests());
	  } catch(Error e) {
		  Service.updateTest("trainerTests", "Failed");
		  System.out.println(e.getMessage());
	  }
  }
  

  @Test(priority=10)
  public void loginAsVpSuccessful() {
	  lp.loginAsVp(driver);
	  try {
		  String homePageTitle = lp.getTitle(driver);
		  assertEquals(homePageTitle, "AssignForce");
		  Service.updateTest("loginAsVpSuccessful", "Success");
//		  System.out.println(Service.getAllTests());
	  } catch(Error e) {
		  Service.updateTest("loginAsVpSuccessful", "Failed");
		  System.out.println(e.getMessage());
	  }
  }
  
  
}
