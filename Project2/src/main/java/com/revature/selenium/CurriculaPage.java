package com.revature.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CurriculaPage {
    WebDriver driver;
    public CurriculaPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToCurriculaPage() {
        WebElement profileNavButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[4]"));
        profileNavButton.click();
    }

    public WebElement getCoreCurriculumList() {
        return driver.findElement(By.xpath("//*[@id=\"core\"]/md-list"));
    }

    public WebElement getFocusList() {
        return driver.findElement(By.xpath("//*[@id=\"focus\"]/md-list"));
    }

    public boolean isCoreCurriculumVisible() {
        WebElement listHolder = driver.findElement(By.xpath("//*[@id=\"core\"]"));
        return (!listHolder.getCssValue("display").equals("none"));
    }

    public boolean isFocusVisible() {
        WebElement listHolder = driver.findElement(By.xpath("//*[@id=\"focus\"]"));
        return (!listHolder.getCssValue("display").equals("none"));
    }

    public void toggleCoreCurriculumVisibility() {
        WebElement coreToggleButton = driver.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content/md-card[1]/md-toolbar/div/button"));
        coreToggleButton.click();
    }

    public void toggleFocusVisibility() {
        WebElement focusToggleButton = driver.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content/md-card[2]/md-toolbar/div/button"));
        focusToggleButton.click();
    }
}
