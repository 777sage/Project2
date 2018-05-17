package com.revature.selenium;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingsPage {
	String timelineTrainersPerPage;
	String reportsOutgoingGrads;
	String reportsCandidatesIncoming;
	String defaultBatchLocation;
	String minimumBatchSize;
	String maximumBatchSize;
	String defaultBatchLength;
	String minimumDayBetweenTrainerBatches;
	Vector<Integer> rngarr;
	List<WebElement> settingElements;
	List<WebElement> dropdownElements;
	String dropdownValue;

	public SettingsPage() {
		try {
			Properties props = new Properties();
			InputStream in = new FileInputStream("src/main/resources/util.properties");
			props.load(in);
			timelineTrainersPerPage = props.getProperty("timelineTrainersPerPage");
			reportsOutgoingGrads = props.getProperty("reportsOutgoingGrads");
			reportsCandidatesIncoming = props.getProperty("reportsCandidatesIncoming");
			defaultBatchLocation = props.getProperty("defaultBatchLocation");
			minimumBatchSize = props.getProperty("minimumBatchSize");
			maximumBatchSize = props.getProperty("maximumBatchSize");
			defaultBatchLength = props.getProperty("defaultBatchLength");
			minimumDayBetweenTrainerBatches = props.getProperty("minimumDayBetweenTrainerBatches");
			randomNumGen();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void randomNumGen() {
		rngarr = new Vector<>();
		Random rand = new Random();
		int rand_int;
		for (int i = 0; i < 7; i++) { // generate random numbers for settings page
			rand_int = rand.nextInt(100);
			rngarr.add(rand_int);
		}

	}

	public void nap(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// create an array of all input elements
	public void getAllTextBoxes(WebDriver driver) {
		System.out.println("Getting all textboxes");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.tagName("input")));
		settingElements = new ArrayList<WebElement>();
		settingElements = driver.findElements(By.tagName("input"));
	}

	//TODO
	//called after dropdown is clicked
	//fix time after clicking dropdown box
	//fix time after selecting option
	public void getDropDownMenu(WebDriver driver) {
		dropdownElements = new ArrayList<WebElement>();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dropdownElements = driver.findElements(By.tagName("md-option"));
		Random rand = new Random();
		int rand_int = rand.nextInt(dropdownElements.size() - 1); // add random value for dropdown menu
		rngarr.add(rand_int);
	}

	public boolean compareTextBoxes() {
		int previous;
		int current;
		boolean modelsMatched = true;
		for (int i = 0; i < settingElements.size(); i++) {
			// System.out.print(i + " ");
			previous = rngarr.get(i);
			try {
				current = Integer.parseInt(settingElements.get(i).getAttribute("value"));
				if (previous != current) {
					System.out.println();
					System.out.println("i: " + i + " previous: " + previous + " current: " + current);
					modelsMatched = false;
				}
			} catch (NumberFormatException e) {

			}

		}
		System.out.println();
		return modelsMatched;
	}

	public boolean compareDropdown(WebDriver driver) {
		String current = driver.findElement(By.tagName("md-select-value")).getText();
		if (current.equals(dropdownValue)) {
			System.out.println("DropDown are equal");
			System.out.println("previous: " + dropdownValue + " current: " + current);
			
			return true;
		} else {
			System.out.println("DropDown don't match");
			System.out.println("previous: " + dropdownValue + " current: " + current);
			
		}
		return false;
	}

	public void findSettingsPage(WebDriver driver) {
		driver.get("https://dev.assignforce.revaturelabs.com/settings");
	}

	public String getURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	// changes page via click
	public void changeToSettings(WebDriver driver) {
		nap(200);
		System.out.println("Changing to settings");
		String settingsPath = "/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[8]";
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(settingsPath)));

		WebElement element = driver.findElement(By.xpath(settingsPath));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();

	}

	public void changeToOverview(WebDriver driver) {
		System.out.println("Changing to Overview");
		String overviewPath = "/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[1]/a/span/span";
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(overviewPath)));
		WebElement element = driver.findElement(By.xpath(overviewPath));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();

	}

	public void logout(WebDriver driver) {
		WebElement element2 = driver.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/img"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element2);

		String logoutPath = "/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[9]/button";
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(logoutPath)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(logoutPath)));
		WebElement element = driver.findElement(By.xpath(logoutPath));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
	}

	// ---------------------------------------------------------------------------------------------------------------------------------------
	// send key value should be from external file
	public void timelineTrainersPerPageEntry(WebDriver driver) {
		WebElement myEle = null;
		for (int i = 0; i < settingElements.size(); i++) {
			if (settingElements.get(i).getAttribute("ng-model").contains("sCtrl.settings.trainersPerPage")) {
				myEle = settingElements.get(i);
			}
		}
		myEle.clear();
		myEle.sendKeys("" + rngarr.get(0));
	}

	public void reportsOutgoingGradsEntry(WebDriver driver) {
		WebElement myEle = null;
		for (int i = 0; i < settingElements.size(); i++) {
			if (settingElements.get(i).getAttribute("ng-model").contains("sCtrl.settings.reportGrads")) {
				myEle = settingElements.get(i);
			}
		}
		myEle.clear();
		myEle.sendKeys("" + rngarr.get(1));
	}

	public void reportsCandidateIncomingEntry(WebDriver driver) {
		WebElement myEle = null;
		for (int i = 0; i < settingElements.size(); i++) {
			if (settingElements.get(i).getAttribute("ng-model").contains("sCtrl.settings.reportIncomingGrads")) {
				myEle = settingElements.get(i);
			}
		}
		myEle.clear();
		myEle.sendKeys("" + rngarr.get(2));
	}

	public void minimumBatchSizeEntry(WebDriver driver) {
		
		WebElement myEle = null;
		for (int i = 0; i < settingElements.size(); i++) {
			if (settingElements.get(i).getAttribute("ng-model").contains("sCtrl.settings.minBatchSize")) {
				myEle = settingElements.get(i);
			}
		}
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(myEle));
		myEle.clear();
		myEle.sendKeys("" + rngarr.get(3));
	}

	public void maximumBatchSizeEntry(WebDriver driver) {
		WebElement myEle = null;
		for (int i = 0; i < settingElements.size(); i++) {
			if (settingElements.get(i).getAttribute("ng-model").contains("sCtrl.settings.maxBatchSize")) {
				myEle = settingElements.get(i);
			}
		}
		myEle.clear();
		myEle.sendKeys("" + rngarr.get(4));
	}

	public void defaultBatchLengthEntry(WebDriver driver) {
		WebElement myEle = null;
		for (int i = 0; i < settingElements.size(); i++) {
			if (settingElements.get(i).getAttribute("ng-model").contains("sCtrl.settings.batchLength")) {
				myEle = settingElements.get(i);
			}
		}
		myEle.clear();
		myEle.sendKeys("" + rngarr.get(5));
	}

	public void minimumDayBetweenTrainerBatchesEntry(WebDriver driver) {
		WebElement myEle = null;
		for (int i = 0; i < settingElements.size(); i++) {
			if (settingElements.get(i).getAttribute("ng-model").contains("sCtrl.settings.trainerBreakDays")) {
				myEle = settingElements.get(i);
			}
		}
		myEle.clear();
		myEle.sendKeys("" + rngarr.get(6));
	}

	public void defaultBatchLocationEntry(WebDriver driver) {
		WebElement element = driver.findElement(By.tagName("md-select-value"));
		dropdownValue = driver.findElement(By.tagName("md-select-value")).getText();
		element.click();
		getDropDownMenu(driver);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(
				ExpectedConditions.elementToBeClickable(By.id(dropdownElements.get(rngarr.get(7)).getAttribute("id"))));
		WebElement dropdownElement = driver.findElement(By.id(dropdownElements.get(rngarr.get(7)).getAttribute("id")));
		Actions actions = new Actions(driver);
		actions.moveToElement(dropdownElement).click().perform();

		wait.until(ExpectedConditions.elementToBeClickable(By.tagName("md-select-value")));

		dropdownValue = driver.findElement(By.tagName("md-select-value")).getText();

	}

	public void clickSave(WebDriver driver) {
		String savePath = "//*[@id=\"view\"]/md-card/md-content/md-list/section/button[1]/span";
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(savePath)));
		WebElement element = driver.findElement(By.xpath(savePath));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
	}

	public void clickReset(WebDriver driver) {
		String resetPath = "//*[@id=\"view\"]/md-card/md-content/md-list/section/button[2]/span";
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(resetPath)));
		WebElement element = driver.findElement(By.xpath(resetPath));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
	}

	public void updateSettings(WebDriver driver) {
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		// wait.until(ExpectedConditions
		// .elementToBeClickable(By.xpath("//*[@id=\"view\"]/md-card/md-content/md-list/section/button[1]/span")));
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		timelineTrainersPerPageEntry(driver);
		timelineTrainersPerPageEntry(driver);
		reportsOutgoingGradsEntry(driver);
		reportsCandidateIncomingEntry(driver);
		defaultBatchLocationEntry(driver);
		nap(200);
		minimumBatchSizeEntry(driver);
		maximumBatchSizeEntry(driver);
		defaultBatchLengthEntry(driver);
		minimumDayBetweenTrainerBatchesEntry(driver);
	}

}
