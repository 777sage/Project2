package com.revature.testng;

import com.revature.selenium.CurriculaPage;
import com.revature.selenium.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CurriculaTest {

    WebDriver driver;
    LoginPage lp;
    CurriculaPage cp;

    @BeforeClass
    public void setupClassTests() {
        File chrome = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());

        driver = new ChromeDriver();
        lp = new LoginPage();
        cp = new CurriculaPage(driver);

        lp.findLoginPage(driver);
        lp.loginAsTrainer(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        cp.goToCurriculaPage();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void finishClassTests() {
        driver.quit();
    }

//    @BeforeMethod
//    public void BeforeEachTest() {
//        // go to overview too
//        cp.goToCurriculaPage();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    }

    @Test
    public void coreCurriclaLoadedTest() {
        WebElement coreCurriculumList = cp.getCoreCurriculumList();
        List<WebElement> coreCurriculaListItems = coreCurriculumList.findElements(By.xpath("./*"));
        // there are 5 core curriculum
        int expectedNumCoreCurricula = 5;
        Assert.assertEquals(expectedNumCoreCurricula, coreCurriculaListItems.size());
    }

    @Test
    public void coreCurriculaToggleVisibilityTest() throws InterruptedException {
        // should be visible on page load
        Assert.assertTrue(cp.isCoreCurriculumVisible());
        cp.toggleCoreCurriculumVisibility();
        Thread.sleep(2000);
        Assert.assertFalse(cp.isCoreCurriculumVisible());

        cp.toggleCoreCurriculumVisibility();
        Thread.sleep(2000);
        Assert.assertTrue(cp.isCoreCurriculumVisible());
    }

    @Test
    public void focusLoadedTest() {
        WebElement focusList = cp.getFocusList();
        List<WebElement> focusListItems = focusList.findElements(By.xpath("./*"));
        // there is at least one focus
        Assert.assertTrue(focusListItems.size()>0);
    }

    @Test
    public void focusToggleVisibilityTest() throws InterruptedException {
        // should be visible on page load
        Assert.assertTrue(cp.isFocusVisible());
        cp.toggleFocusVisibility();
        Thread.sleep(2000);
        Assert.assertFalse(cp.isFocusVisible());

        cp.toggleFocusVisibility();
        Thread.sleep(2000);
        Assert.assertTrue(cp.isFocusVisible());
    }
}
