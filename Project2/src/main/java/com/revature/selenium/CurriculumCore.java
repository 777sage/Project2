package com.revature.selenium;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CurriculumCore {
	WebElement curriculaSpan;
	
	public void goToCurriculaPage(WebDriver driver) {
//		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		  WebDriverWait wait = new WebDriverWait(driver, 15);
		  
		  try{
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Curricula')]")));
			    curriculaSpan = driver.findElement(By.xpath("//span[contains(text(), 'Curricula')]"));
			}
			catch (NoSuchElementException e)
			{
			    System.out.println(e.getMessage());
			    curriculaSpan = null;
			}
		

		  for (int i = 0 ; i < 3 ; i++) {
			  if (curriculaSpan == null) {
				  curriculaSpan = driver.findElement(By.xpath("//span[contains(text(), 'Curricula')]"));
			  }
		  }
		  
		  curriculaSpan.click();
	}
	
	public void clickAddButton(WebDriver driver) {
		WebElement addButton = driver.findElement(By.xpath("//button[contains(@aria-label, 'Add New Curriculum')]"));
		addButton.click();
	}
	
	public void addToCore(WebDriver driver) {
		WebElement nameInput = driver.findElement(By.xpath("//input[contains(@aria-label, 'curriculumName')]"));
		nameInput.clear();
		nameInput.sendKeys("Android");
		
		WebElement skillSelect = driver.findElement(By.xpath("//md-select[contains(@aria-label, 'curriculumSkills')]"));
		skillSelect.click();
		
//		WebElement firstOption = driver.findElement(By.xpath("//md-content[@class='_md']"));
	}
}
