package com.revature.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	String trainerUsername;
	String trainerPassword;	
	String vpUsername;
	String vpPassword;
	
	public static void main(String[] args) {
//		File chrome = new File("src/main/resources/chromedriver");
//		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
//		WebDriver driver = new ChromeDriver();	
//
//		
//		LoginPage lp = new LoginPage();
//		lp.loginAsTrainerWithBadCredential(driver);
		
	}
		
	public LoginPage() {
	  try {
		  Properties props = new Properties();
		  InputStream in = new FileInputStream("src/main/resources/util.properties");
		  props.load(in);
		  trainerUsername = props.getProperty("trainerUsername");
		  trainerPassword = props.getProperty("trainerPassword");
		  vpUsername = props.getProperty("vpUsername");
		  vpPassword = props.getProperty("vpPassword");
	  } catch(Exception e) {
		  System.out.println(e.getMessage());
	  }
	}
	
	public void findLoginPage(WebDriver driver) {
		driver.get("https://dev.assignforce.revaturelabs.com");
	}
	
	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public void loginAsTrainerWithBadCredential(WebDriver driver) {
		findLoginPage(driver);
		driver.findElement(By.id("username")).sendKeys("Some Gibberish");
		driver.findElement(By.name("pw")).sendKeys("Some Gibberish");
		driver.findElement(By.xpath("//*[@id='Login']")).click();
		WebElement error = driver.findElement(By.id("error"));
		
	}
	
	public void loginAsTrainer(WebDriver driver) {
		//start sameer block
		System.out.println("Going to login");
		WebDriverWait wait = new WebDriverWait(driver, 10 );
		if(!driver.getTitle().equals("Login | Salesforce")) {
			//go to url
			findLoginPage(driver);
		}		
	
		try {
			if (wait.until(ExpectedConditions.elementToBeClickable(By.id("username"))) != null) {
				System.out.println("Logging in");
			} else {
				System.out.println("Tried to login when already logged in");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//end sameer block
		//findLoginPage(driver);
		driver.findElement(By.id("username")).sendKeys(trainerUsername);
		driver.findElement(By.name("pw")).sendKeys(trainerPassword);
		driver.findElement(By.xpath("//*[@id='Login']")).click();
		
		if (driver.getTitle().equals("Verify Your Identity | Salesforce")) {
			driver.findElement(By.id("emc")).sendKeys("49618");
			driver.findElement(By.id("save")).click();
		}
	}
	
	public void loginAsVp(WebDriver driver) {
		//start sameer block
		System.out.println("Going to login");
		if(!driver.getTitle().equals("Login | Salesforce")) {
			findLoginPage(driver);
		}		
	    WebDriverWait wait = new WebDriverWait(driver, 5 );
		try {
			if (wait.until(ExpectedConditions.elementToBeClickable(By.id("username"))) != null) {
				System.out.println("Logging in");
			} else {
				System.out.println("Tried to login when already logged in");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//end sameer block
		
		
	
		//findLoginPage(driver);
		driver.findElement(By.id("username")).sendKeys(vpUsername);
		driver.findElement(By.name("pw")).sendKeys(vpPassword);
		driver.findElement(By.xpath("//*[@id='Login']")).click();
		
		if (driver.getTitle().equals("Verify Your Identity | Salesforce")) {
			driver.findElement(By.id("emc")).sendKeys("49618");
			driver.findElement(By.id("save")).click();
		}
	}

}
