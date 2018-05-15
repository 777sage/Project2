package com.revature.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {
	
	public String[] enterNameInputAndChangePage(WebDriver driver) {
		  WebElement profileSpan = driver.findElement(By.xpath("//span[contains(text(), 'rofile')]"));

		  for (int i = 0 ; i < 1000 ; i++) {
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
}
