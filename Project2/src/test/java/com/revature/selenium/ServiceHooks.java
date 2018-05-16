package com.revature.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class ServiceHooks {
public static WebDriver driver;
	
	@Before("@TryAllEntries")
	public void initializeUserTest(){
//		File chrome = new File("src/main/resources/chromedriver");
		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		driver = new ChromeDriver();
		driver.get("https://dev.assignforce.revaturelabs.com");
		try {
			  Properties props = new Properties();
			  InputStream in = new FileInputStream("src/main/resources/util.properties");
			  props.load(in);
			  String trainerUsername = props.getProperty("trainerUsername");
			  String trainerPassword = props.getProperty("trainerPassword");
			  driver.findElement(By.id("username")).sendKeys(trainerUsername);
			  driver.findElement(By.name("pw")).sendKeys(trainerPassword);
			  driver.findElement(By.xpath("//*[@id='Login']")).click();
			  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  } catch(Exception e) {
			  System.out.println(e.getMessage());
		  }
		System.out.println("in service hooks before");
	}
	
	@After("@TryAllEntries")
	public void closeUserTest(Scenario scenario) {
	    if (scenario.isFailed()) {
	        try {
	            // Code to capture and embed images in test reports (if scenario fails)
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    else {
	    	//send success to the database
	    }
	    System.out.println("in service hooks after");
	    driver.close();
	    driver.quit();
	}
	
	
	
	@Before("@LocationsAdminScenario")
	public void initializeAdminTest(){
//		File chrome = new File("src/main/resources/chromedriver");
		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		driver = new ChromeDriver();
		driver.get("https://dev.assignforce.revaturelabs.com");
		try {
			  Properties props = new Properties();
			  InputStream in = new FileInputStream("src/main/resources/util.properties");
			  props.load(in);
			  String vpUsername = props.getProperty("vpUsername");
			  String vpPassword = props.getProperty("vpPassword");
			  driver.findElement(By.id("username")).sendKeys(vpUsername);
			  driver.findElement(By.name("pw")).sendKeys(vpPassword);
			  driver.findElement(By.xpath("//*[@id='Login']")).click();
			  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  } catch(Exception e) {
			  System.out.println(e.getMessage());
		  }
		System.out.println("in service hooks before");
	}
	
	@After("@LocationsAdminScenario")
	public void closeAdminTest(Scenario scenario) {
	    if (scenario.isFailed()) {
	        try {
	            // Code to capture and embed images in test reports (if scenario fails)
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    else {
	    	//send success to the database
	    }
	    System.out.println("in service hooks after");
	    driver.close();
	    driver.quit();
	}
	
	
	
}
