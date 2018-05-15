package com.revature.testng;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.List;
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
  public void loginSuccessful() {
	  File chrome = new File("src/main/resources/chromedriver");
//	  File chrome = new File("src/test/resources/chromedriver.exe");
	  
	  System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
	  
	  driver = new ChromeDriver();
	  lp = new LoginPage();
	  pp = new ProfilePage();
	  lp.loginAsTrainer(driver);
  }
  
  @Test(priority=2)
  public void profileNameInputDoesNotSave() {
//	  File chrome = new File("src/main/resources/chromedriver");
//	  File chrome = new File("src/test/resources/chromedriver.exe");
	  
//	  System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
//	  
//	  driver = new ChromeDriver();
//	  lp = new LoginPage();
//	  pp = new ProfilePage();
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  String[] result = pp.enterNameInputAndChangePage(driver);
	  String nameBeforePageChange = result[0];
	  String nameAfterPageChange = result[1];
	  
	  assertNotEquals(nameBeforePageChange, nameAfterPageChange);

  }
  
  @Test(priority=3)
  public void addOneSkillSuccessful() {
	  List<WebElement> chipElements = driver.findElements(By.className("md-chip-content"));
	  int chipElementsCountBeforeClick = chipElements.size();
	  
	  int chipElementsCountAfterClick = pp.addOneSkill(driver);
	  
	  int expectedIncreaseInElements = chipElementsCountBeforeClick + 2;

	  assertEquals(chipElementsCountAfterClick, expectedIncreaseInElements);
	  
  }
  
  @Test(priority=4)
  public void addMultipleSkillsSuccessful() {
	  List<WebElement> chipElements = driver.findElements(By.className("md-chip-content"));
	  int chipElementsCountBeforeClicks = chipElements.size();
//	  System.out.println("Chip elements count before clicks: " + chipElementsCountBeforeClicks);
	  
	  int chipElementsCountAfterClicks = pp.addMultipleSkills(driver);
//	  System.out.println("Chip elements count after clicks: " + chipElementsCountAfterClicks);
	  
	  int expectedIncreaseInElements = chipElementsCountBeforeClicks + 20;
	  
	  assertEquals(chipElementsCountAfterClicks, expectedIncreaseInElements);
	  
  }
  
  @Test(priority=5)
  public void unsavedSkillsDoNotPersist() {
	  List<WebElement> chipElements = driver.findElements(By.className("md-chip-content"));
	  int chipElementsCountBeforePageChange = chipElements.size();
//	  System.out.println("Chip elements count before navigate Away: " + chipElementsCountBeforePageChange);
	  
	  pp.navigateAwayAndBack(driver);
	  
	  chipElements = driver.findElements(By.className("md-chip-content"));
	  int chipElementsCountAfterPageChange = chipElements.size();
//	  System.out.println("Chip elements count After navigate Away: " + chipElementsCountAfterPageChange);
	  
	  boolean changesUnsaved = chipElementsCountAfterPageChange < chipElementsCountBeforePageChange;
	  assertTrue(changesUnsaved);
	  
  }
  
  @Test(priority=6)
  public void addMultipleSkillsAndSaveSuccessful() {
	  List<WebElement> chipElements = driver.findElements(By.className("md-chip-content"));
	  int chipElementsCountBeforeClicks = chipElements.size();
	  System.out.println("Chip elements count before clicks: " + chipElementsCountBeforeClicks);
	  
	  int chipElementsCountAfterClicks = pp.addMultipleSkills(driver);
	  System.out.println("Chip elements count after clicks: " + chipElementsCountAfterClicks);
	  
	  pp.clickSaveSkillsButton(driver);
	  
	  pp.logout(driver);
	  
	  lp.loginAsTrainer(driver);
	  pp.goToProfilePage(driver);
	  
	  chipElements = driver.findElements(By.className("md-chip-content"));
	  int chipElementsCountAfterLoggedBackIn = chipElements.size();
	  System.out.println("Count after logged back in: " + chipElementsCountAfterLoggedBackIn);
	  
	  assertEquals(chipElementsCountAfterClicks, chipElementsCountAfterLoggedBackIn);
	  
	  driver.quit();
  }
  
}
