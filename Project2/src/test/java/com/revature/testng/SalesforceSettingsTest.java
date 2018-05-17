package com.revature.testng;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.revature.dao.Service;
import com.revature.selenium.LoginPage;
import com.revature.selenium.SettingsPage;

//test if settings save after tab change
//test if settings save after refresh
//test if settings save after logout/login
//test if settings save between sessions
//test if settings save between vp and trainer
//test if reset button works between tab change
//test if reset saves between sessions

public class SalesforceSettingsTest {
	WebDriver driver;
	LoginPage lp;
	SettingsPage sp;
	String trainerUsername;
	String trainerPassword;
	Service service;
	ChromeOptions options;
	// note: reset button does not work
	// refreshing page loses save and update buttons

	@BeforeMethod
	public void beforeMethod() {
//		options = new ChromeOptions();
//		options.addArguments("user-data-dir=C:\\Users\\skhaw\\AppData\\Local\\Google\\Chrome\\User Data");
//		options.addArguments("--start-maximized", "--disable-session-crashed-bubble");
		
//		File chrome = new File("src/main/resources/chromedriver");
		File chrome = new File("src/test/resources/chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		
//		driver = new ChromeDriver(options);
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
		lp = new LoginPage();
		sp = new SettingsPage();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, "a" }, new Object[] { 2, "b" }, };
	}

	
	@Test(priority = 0, invocationCount = 1)
	public void settingsButtonsWorks() {
		lp.loginAsTrainer(driver);
		sp.changeToSettings(driver);
		String settingsURL = sp.getURL(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertEquals(settingsURL, "https://dev.assignforce.revaturelabs.com/settings");
	}

	
	@Test(priority = 1, invocationCount = 1)
	public void settingsDoNotSaveBetweenTabs() {
		try {
			lp.loginAsVp(driver);
			sp.changeToSettings(driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			sp.getAllTextBoxes(driver);
			sp.updateSettings(driver);
			sp.changeToOverview(driver);
			sp.changeToSettings(driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			sp.getAllTextBoxes(driver);
			assertTrue(!sp.compareTextBoxes() && !sp.compareDropdown(driver));
			// Service.updateTest("settingsSaveBetweenTabs", "Success");
		} catch (Error e) {
			// Service.updateTest("settingsSaveBetweenTabs", "Failed");
			System.out.println(e.getMessage());
		}
	}

	
	@Test(priority = 2, invocationCount = 1)
	public void settingsDoNotSaveAfterRefresh() {
		try {
			lp.loginAsVp(driver);
			sp.changeToSettings(driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			sp.getAllTextBoxes(driver);
			sp.updateSettings(driver);
			driver.navigate().refresh();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			sp.getAllTextBoxes(driver);
			assertTrue(!sp.compareTextBoxes() && !sp.compareDropdown(driver));
			// Service.updateTest("settingsSaveBetweenTabs", "Success");
		} catch (Error e) {
			// Service.updateTest("settingsSaveBetweenTabs", "Failed");
			System.out.println(e.getMessage());
		}
	}

	
	@Test(priority = 3, invocationCount = 1)
	public void settingsDoNotSaveAfterLogout() {
		try {
			lp.loginAsVp(driver);
			sp.changeToSettings(driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			sp.getAllTextBoxes(driver);
			sp.updateSettings(driver);
			sp.logout(driver);
			lp.loginAsVp(driver);
			sp.changeToSettings(driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			sp.getAllTextBoxes(driver);
			assertTrue(!sp.compareTextBoxes() && !sp.compareDropdown(driver));
			// Service.updateTest("settingsSaveBetweenTabs", "Success");
		} catch (Error e) {
			// Service.updateTest("settingsSaveBetweenTabs", "Failed");
			System.out.println(e.getMessage());
		}
	}

	
	@Test(priority = 4, invocationCount = 1)
	public void settingsSaveBetweenTabs() {
		try {
			lp.loginAsVp(driver);
			sp.changeToSettings(driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			sp.getAllTextBoxes(driver);
			sp.updateSettings(driver);
			sp.clickSave(driver);
			sp.changeToOverview(driver);
			sp.changeToSettings(driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			sp.getAllTextBoxes(driver);
			assertTrue(sp.compareTextBoxes() && sp.compareDropdown(driver));
			// Service.updateTest("settingsSaveBetweenTabs", "Success");
		} catch (Error e) {
			// Service.updateTest("settingsSaveBetweenTabs", "Failed");
			System.out.println(e.getMessage());
		}
	}

	// note, dialog box "Settings have been saved" blocks us from logging out
	
	@Test(priority = 5, invocationCount = 1)
	public void settingsSaveAfterLogout() {
		try {
			lp.loginAsVp(driver);
			sp.changeToSettings(driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			sp.getAllTextBoxes(driver);
			sp.updateSettings(driver);
			sp.clickSave(driver);
			sp.logout(driver);
			sp.nap(1000);
			lp.loginAsVp(driver);
			sp.changeToSettings(driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			sp.getAllTextBoxes(driver);
			assertTrue(sp.compareTextBoxes() && sp.compareDropdown(driver));
			// Service.updateTest("settingsSaveBetweenTabs", "Success");
		} catch (Error e) {
			// Service.updateTest("settingsSaveBetweenTabs", "Failed");
			System.out.println(e.getMessage());
		}
	}
	
	@Test(priority = 5, invocationCount = 1)
	public void settingsSaveAfterLoginAsTrainer() {
		try {
			lp.loginAsVp(driver);
			sp.changeToSettings(driver);
			sp.getAllTextBoxes(driver);
			sp.updateSettings(driver);
			sp.clickSave(driver);
			sp.logout(driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			sp.nap(200);
			lp.loginAsTrainer(driver);
			sp.nap(200);
			sp.changeToSettings(driver);
			sp.getAllTextBoxes(driver);
			assertTrue(sp.compareTextBoxes() && sp.compareDropdown(driver));
			// Service.updateTest("settingsSaveBetweenTabs", "Success");
		} catch (Error e) {
			// Service.updateTest("settingsSaveBetweenTabs", "Failed");
			System.out.println(e.getMessage());
		}
	}
	
	@Test(priority = 6, invocationCount = 1)
	public void settingsDoNotResetBetweenTabs() {
		try {
			lp.loginAsVp(driver);
			sp.changeToSettings(driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			sp.getAllTextBoxes(driver);
			sp.updateSettings(driver);
			sp.clickReset(driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			sp.getAllTextBoxes(driver);
			assertTrue(!sp.compareTextBoxes() && !sp.compareDropdown(driver));
			// Service.updateTest("settingsSaveBetweenTabs", "Success");
		} catch (Error e) {
			// Service.updateTest("settingsSaveBetweenTabs", "Failed");
			System.out.println(e.getMessage());
		}
	}
	
	@Test(priority = 7, invocationCount = 1)
	public void settingsSaveBetweenTabsTrainer() {
		try {
			lp.loginAsTrainer(driver);
			sp.changeToSettings(driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			sp.getAllTextBoxes(driver);
			sp.updateSettings(driver);
			sp.changeToOverview(driver);
			sp.changeToSettings(driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			sp.getAllTextBoxes(driver);
			assertTrue(!sp.compareTextBoxes() && !sp.compareDropdown(driver));
			// Service.updateTest("settingsSaveBetweenTabs", "Success");
		} catch (Error e) {
			// Service.updateTest("settingsSaveBetweenTabs", "Failed");
			System.out.println(e.getMessage());
		}
	}
	
	

}
