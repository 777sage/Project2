package com.revature.testng;

import org.testng.annotations.Test;

import com.revature.dao.Service;
import com.revature.selenium.LoginPage;

import org.testng.annotations.BeforeClass;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class TrainersTests {
	WebDriver driver;
	LoginPage lp;
	ChromeOptions options;
	
	@Test(priority=1)
  public void findTrainersPage() {
	  try {
		  lp.loginAsVp(driver);
		  WebElement trainersTab = driver.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[5]"));
		  trainersTab.click();
		  String curTab = trainersTab.getAttribute("aria-selected");
		  assertEquals(curTab,"true");
		  Service.updateTest("findTrainersPage", "Success");
	  }catch(Error e) {
		  System.out.println(e.getMessage());
		  Service.updateTest("findTrainersPage", "Fail");
	  }
  }
  
  @Test(priority=4, enabled=false)
  public void createNewTrainer() {
	  int beforeCount = 0;
	  int afterCount = 0;
	  try {
		  WebElement trainersTab = driver.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[5]"));
		  trainersTab.click();
		  driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		  try {
			  for(WebElement temp : driver.findElements(By.className("ng-binding"))) {
				  if(temp.getText().equals("New Trainer")) {
					  beforeCount++;
				  }
			  }
		  }catch(InvalidSelectorException e) {
		  }
		  WebElement createTrainerButton = driver.findElement(By.cssSelector("#view > md-card > md-toolbar:nth-child(1) > div > button:nth-child(3)"));
		  createTrainerButton.click();
		  driver.findElement(By.cssSelector("#input_7")).sendKeys("New");
		  driver.findElement(By.cssSelector("#input_8")).sendKeys("Trainer");
		  WebElement saveNewTrainer = driver.findElement(By.xpath("/html/body/div[3]/md-dialog/form/md-dialog-actions/button[1]"));
		  saveNewTrainer.click();
		  try {
			  Thread.sleep(1000);
		  }catch(InterruptedException e) {
			  e.printStackTrace();
		  }
		  trainersTab.click();
		  for(WebElement temp : driver.findElements(By.className("ng-binding"))) {
			  if(temp.getText().equals("New Trainer")) {
				  afterCount++;
			  }
		  }
		  beforeCount++;
		  System.out.println(beforeCount +" "+afterCount);
		  assertEquals(afterCount,beforeCount);
		  Service.updateTest("createNewTrainer", "Success");
	  }catch(Error e) {
		  System.out.println(e.getMessage());
		  Service.updateTest("createNewTrainer", "Failed");
	  }
  }
  
  @Test(priority=2, enabled = false)
  public void createTrainWithoutFirstName() {
	  try {
		  WebElement trainersTab = driver.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[5]"));
		  trainersTab.click();
		  driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		  WebElement createTrainerButton = driver.findElement(By.cssSelector("#view > md-card > md-toolbar:nth-child(1) > div > button:nth-child(3)"));
		  createTrainerButton.click();
		  WebElement trainFirstNameContainer = driver.findElement(By.cssSelector("#dialogContent_3 > div > div > md-input-container:nth-child(1)"));
		  driver.findElement(By.cssSelector("#input_2")).sendKeys("Trainer");
		  WebElement saveNewTrainer = driver.findElement(By.xpath("/html/body/div[3]/md-dialog/form/md-dialog-actions/button[1]"));
		  saveNewTrainer.click();
		  
		  assertEquals(trainFirstNameContainer.getAttribute("class"),"flex-100 ng-animate md-input-invalid");
		  Service.updateTest("createTrainWithoutFirstName", "Success");
		  driver.findElement(By.cssSelector("body > div.md-dialog-container.ng-scope > md-dialog > form > md-dialog-actions > button:nth-child(2)")).click();
		  try {
			  Thread.sleep(1000);
		  }catch(InterruptedException e) {
			  e.printStackTrace();
		  }
	  }catch(Error e) {
		  System.out.println(e.getMessage());
		  Service.updateTest("createTrainWithoutFirstName", "Failed");
	  }
  }
  
  @Test(priority=3, enabled=false)
  public void createTrainWithoutLastName() {
	  try {
		  WebElement trainersTab = driver.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[5]"));
		  trainersTab.click();
		  driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		  WebElement createTrainerButton = driver.findElement(By.cssSelector("#view > md-card > md-toolbar:nth-child(1) > div > button:nth-child(3)"));
		  createTrainerButton.click();
		  WebElement trainFirstNameContainer = driver.findElement(By.cssSelector("#dialogContent_6 > div > div > md-input-container:nth-child(2)"));
		  driver.findElement(By.cssSelector("#input_4")).sendKeys("New");
		  WebElement saveNewTrainer = driver.findElement(By.xpath("/html/body/div[3]/md-dialog/form/md-dialog-actions/button[1]"));
		  saveNewTrainer.click();
		  assertEquals(trainFirstNameContainer.getAttribute("class"),"flex-100 ng-animate md-input-invalid");
		  Service.updateTest("createTrainWithoutLastName", "Success");
		  driver.findElement(By.cssSelector("body > div.md-dialog-container.ng-scope > md-dialog > form > md-dialog-actions > button:nth-child(2)")).click();;
		  try {
			  Thread.sleep(1000);
		  }catch(InterruptedException e) {
			  e.printStackTrace();
		  }
	  }catch(Error e) {
		  System.out.println(e.getMessage());
		  Service.updateTest("createTrainWithoutLastName", "Failed");
	  }
  }
  
@Test(priority=5,enabled=false)
  public void deactivateTrainer(){
	try {
		WebElement trainersTab = driver.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[5]"));
		trainersTab.click();
		int active=0;
	   List<WebElement> activeTrainers= driver.findElements(By.className("md-icon-button"));
	   List<WebElement> allButtons = new ArrayList<WebElement>(activeTrainers);
	   for(WebElement temp:allButtons){
		   if(temp.getAttribute("ng-click").equals("tCtrl.removeTrainer(trainer)")) {
		   }
		   else {
			   activeTrainers.remove(temp);
		   }
	   }
	   active=activeTrainers.size();
	   activeTrainers.get(0).click();
	   activeTrainers= driver.findElements(By.className("md-icon-button"));
	   allButtons= new ArrayList<WebElement>(activeTrainers);
	   for(WebElement temp:allButtons){
		   if(temp.getAttribute("ng-click").equals("tCtrl.removeTrainer(trainer)")) {
		   }
		   else {
			   activeTrainers.remove(temp);
		   }
	   }
	   assertEquals(activeTrainers.size(),active-1);
	   Service.updateTest("deactivateTrainer", "Success");
	}
	catch(Error e){
		Service.updateTest("deactivateTrainer", "Failed");
	}
  }

@Test(priority=6,enabled=false)
public void activateTrainer(){
	try {
		WebElement trainersTab = driver.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[5]"));
		trainersTab.click();
		int notActive=0;
	   List<WebElement> inactiveTrainers= driver.findElements(By.className("md-icon-button"));
	   List<WebElement> allButtons = new ArrayList<WebElement>(inactiveTrainers);
	   for(WebElement temp:allButtons){
		   if(temp.getAttribute("ng-click").equals("tCtrl.activateTrainer(trainer)")) {
		   }
		   else {
			   inactiveTrainers.remove(temp);
		   }
	   }
	   notActive=inactiveTrainers.size();
	   inactiveTrainers.get(0).click();
	   inactiveTrainers= driver.findElements(By.className("md-icon-button"));
	   allButtons= new ArrayList<WebElement>(inactiveTrainers);
	   for(WebElement temp:allButtons){
		   if(temp.getAttribute("ng-click").equals("tCtrl.activateTrainer(trainer)")) {
		   }
		   else {
			   inactiveTrainers.remove(temp);
		   }
	   }
	   assertEquals(inactiveTrainers.size(),notActive-1);
	   Service.updateTest("activateTrainer", "Success");
	}
	catch(Error e){
		Service.updateTest("activateTrainer", "Failed");
	}
}

@Test(priority=7, enabled=true)
public void getResumeFormIndividualWithNoResume(){
	try {
		WebElement trainersTab = driver.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[5]"));
		trainersTab.click();
	   List<WebElement> inactiveTrainers= driver.findElements(By.className("md-icon-button"));
	   List<WebElement> allButtons = new ArrayList<WebElement>(inactiveTrainers);
	   for(WebElement temp:allButtons){
		   if(temp.getAttribute("ng-click").equals("tCtrl.grabS3Resume(trainer)")) {
			   temp.click();
			   break;
		   }
	   }
	   WebDriverWait wait = new WebDriverWait(driver, 10);
       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("md-toast > div > button")));
       driver.findElement(By.cssSelector("md-toast > div > button")).click();
	   Service.updateTest("getResumeFormIndividualWithNoResume", "Success");
	}
	catch(Exception e){
		System.out.println(e.getMessage());
		Service.updateTest("getResumeFormIndividualWithNoResume", "Failed");
	}
}

@Test(priority=8, enabled=true)
public void viewPTOcalanderPage(){
	try {
		WebElement trainersTab = driver.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[5]"));
		trainersTab.click();
	   List<WebElement> inactiveTrainers= driver.findElements(By.className("md-icon-button"));
	   List<WebElement> allButtons = new ArrayList<WebElement>(inactiveTrainers);
	   for(WebElement temp:allButtons){
		   if(temp.getAttribute("ng-click").equals("tCtrl.showCalendar()")) {
			   temp.click();
			   break;
		   }
	   }
	   WebDriverWait wait = new WebDriverWait(driver, 10);
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"dialogContent_1\"]/md-dialog-actions/button[2]")));
       driver.findElement(By.xpath("//*[@id=\"dialogContent_1\"]/md-dialog-actions/button[2]")).click();
	   Service.updateTest("viewPTOcalanderPage", "Success");
	}
	catch(Exception e){
		System.out.println(e.getMessage());
		Service.updateTest("viewPTOcalanderPage", "Failed");
	}
}
  
  @BeforeClass
  public void beforeClass() {
	  //options.addArguments("user-data-dir=C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User Data");
	  
		  options = new ChromeOptions();
		  options.addArguments("user-data-dir=C:\\Users\\Dakot\\AppData\\Local\\Google\\Chrome\\User Data");
		  options.addArguments("--start-maximized");
		  
//		  File chrome = new File("src/main/resources/chromedriver");
		  File chrome = new File("src/test/resources/chromedriver.exe");
		  System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		  
		  
//	 	  driver = new ChromeDriver();
		  driver = new ChromeDriver(options);
		  lp = new LoginPage();
  }

  @AfterClass
  public void afterClass() {
	  //driver.quit();
  }

}
