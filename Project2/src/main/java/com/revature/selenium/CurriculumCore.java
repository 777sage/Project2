package com.revature.selenium;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CurriculumCore {
	WebElement curriculaSpan;
	
	public void goToCurriculaPage(WebDriver driver) {
//		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		  WebDriverWait wait = new WebDriverWait(driver, 15);
		  
		  try {
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
		  WebDriverWait wait = new WebDriverWait(driver, 15);
		  WebElement addButton;
		  try {
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@aria-label, 'Add New Curriculum')]")));
			    addButton = driver.findElement(By.xpath("//button[contains(@aria-label, 'Add New Curriculum')]"));
			}
			catch (NoSuchElementException e)
			{
			    System.out.println(e.getMessage());
			    addButton = null;
			}
		addButton.click();
	}
	
	public int[] addToCoreThenCancel(WebDriver driver) {
		WebElement core = driver.findElement(By.xpath("//md-card-content[@id='core']/md-list"));
		List<WebElement> coreList = core.findElements(By.xpath("//md-list-item[@role='listitem']"));
		System.out.println("Core List size before: " + coreList.size());
		int listSizeBefore = coreList.size();
		
		WebElement nameInput = driver.findElement(By.xpath("//input[contains(@aria-label, 'curriculumName')]"));
//		nameInput.clear();
		for (int i = 0 ; i < 9 ; i++) {
			nameInput.sendKeys(Keys.BACK_SPACE);
		}
		nameInput.sendKeys("Angular");
		
		
		WebElement skillSelect = driver.findElement(By.xpath("//md-select[contains(@aria-label, 'curriculumSkills')]"));
		skillSelect.click();
		
//		WebElement firstOption = driver.findElement(By.xpath("//md-content[@class='_md']"));
//		WebElement skillModal = driver.findElement(By.xpath("//div[contains(@id, 'select_container')]"));
		
		WebElement firstOption = driver.findElement(By.xpath("//div[contains(@id, 'select_container')]/md-select-menu/md-content/md-option"));
		firstOption.click();
		
		WebElement secondOption = firstOption.findElement(By.xpath("following-sibling::*"));
		secondOption.click();
		secondOption.sendKeys(Keys.TAB);
		
//		WebElement nameLabel = driver.findElement(By.xpath("//h4[contains(text(), 'Curriculum Name')]"));
//		for (int i = 0 ; i < 5 ; i++) {
//			nameLabel.click();
//		}
			
//		WebElement saveSpan = driver.findElement(By.xpath("//span[contains(text(), 'Save')]"));
//		saveSpan.click();
//		saveSpan.click();
		
//		WebElement hitLocation = driver.findElement(By.className("hitLocation"));
//		new Actions(driver)
//	    .moveToElement(hitLocation, 1, 1)
//	    .click()
//	    .perform();		
		
//		WebElement html = driver.findElement(By.xpath("//html"));
//		skillModal.sendKeys("{ESC}");
//		driver.findElement(By.xpath("")).sendKeys(Keys.ESCAPE);

		
//		WebElement skillInput = driver.findElement(By.xpath("//md-select-value[contains(@id, 'select_value_label')]/span"));
//		skillInput.sendKeys("an");
			
		WebElement cancelSpan = driver.findElement(By.xpath("//span[contains(text(), 'Cancel')]"));
		cancelSpan.click();
		
		core = driver.findElement(By.xpath("//md-card-content[@id='core']/md-list"));
		coreList = core.findElements(By.xpath("//md-list-item[@role='listitem']"));
		System.out.println("Core List size after: " + coreList.size());
		int listSizeAfter = coreList.size();
		
		int[] result = new int[2];
		result[0] = listSizeBefore;
		result[1] = listSizeAfter;
		
		return result;
	}
}
