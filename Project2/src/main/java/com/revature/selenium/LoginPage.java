package com.revature.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
	String trainerUsername;
	String trainerPassword;	
	
	public static void main(String[] args) {
		File chrome = new File("src/main/resources/chromedriver");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		WebDriver driver = new ChromeDriver();	

		
		LoginPage lp = new LoginPage();
		lp.loginAsTrainerWithBadCredential(driver);
		
	}
		
	public LoginPage() {
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
	
	public void findLoginPage(WebDriver driver) {
		driver.get("https://dev.assignforce.revaturelabs.com");
	}
	
	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public void loginAsTrainer(WebDriver driver) {
		findLoginPage(driver);
		driver.findElement(By.id("username")).sendKeys(trainerUsername);
		driver.findElement(By.name("pw")).sendKeys(trainerPassword);
		driver.findElement(By.xpath("//*[@id='Login']")).click();
	}
	
	public void loginAsTrainerWithBadCredential(WebDriver driver) {
		findLoginPage(driver);
		driver.findElement(By.id("username")).sendKeys("Some Gibberish");
		driver.findElement(By.name("pw")).sendKeys("Some Gibberish");
		driver.findElement(By.xpath("//*[@id='Login']")).click();
	}
	

}
