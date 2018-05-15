package com.revature.selenium;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
	
	public String[] enterNameInputAndChangePage(WebDriver driver) {
//		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		  WebDriverWait wait = new WebDriverWait(driver, 15);
		  
		  WebElement profileSpan;
		  try{
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'rofile')]")));
			    profileSpan = driver.findElement(By.xpath("//span[contains(text(), 'rofile')]"));
			}
			catch (NoSuchElementException e)
			{
			    System.out.println(e.getMessage());
			    profileSpan = null;
			}
		

		  for (int i = 0 ; i < 3 ; i++) {
			  if (profileSpan == null) {
				  profileSpan = driver.findElement(By.xpath("//span[contains(text(), 'rofile')]"));
			  }
		  }
		  
		  profileSpan.click();
			  
		  WebElement inputOne = driver.findElement(By.xpath("//label[contains(text(), 'First')]"));
		  inputOne = inputOne.findElement(By.xpath("following-sibling::*"));
		  inputOne.clear();
		  inputOne.sendKeys("William");
		  
		  WebElement inputTwo = driver.findElement(By.xpath("//label[contains(text(), 'Last')]"));
		  inputTwo = inputTwo.findElement(By.xpath("following-sibling::*"));
		  inputTwo.clear();
		  inputTwo.sendKeys("Gibson");
		  
		  String firstNameBeforePageChange = inputOne.getAttribute("value");
		  String lastNameBeforePageChange = inputTwo.getAttribute("value");
		  String nameBeforePageChange = firstNameBeforePageChange + " " + lastNameBeforePageChange;
		  
		  WebElement locationSpan = driver.findElement(By.xpath("//span[contains(text(), 'ocations')]"));
		  locationSpan.click();
		  profileSpan.click();

		  inputOne = driver.findElement(By.xpath("//label[contains(text(), 'First')]"));
		  inputOne = inputOne.findElement(By.xpath("following-sibling::*"));
		  
		  inputTwo = driver.findElement(By.xpath("//label[contains(text(), 'Last')]"));
		  inputTwo = inputTwo.findElement(By.xpath("following-sibling::*"));
		  String firstNameAfterPageChange = inputOne.getAttribute("value");
		  String lastNameAfterPageChange = inputTwo.getAttribute("value");
		  String nameAfterPageChange = firstNameAfterPageChange + " " + lastNameAfterPageChange;
		  
		  String[] result = new String[2];
		  result[0] = nameBeforePageChange;
		  result[1] = nameAfterPageChange;
		  return result;
	}
	
	public int addOneSkill(WebDriver driver) {
		  
		  WebElement currentSkills = driver.findElement(By.cssSelector("#view > md-card:nth-child(1) > md-content:nth-child(3) > div > md-list > div"));
		  WebElement skill = currentSkills.findElement(By.xpath("following-sibling::*"));
		  skill.click();
		  
		  List<WebElement> chipElements = driver.findElements(By.className("md-chip-content"));
		  return chipElements.size();
	}
	

}
