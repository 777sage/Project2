package com.revature.testng;

import cucumber.api.CucumberOptions;

import cucumber.api.testng.*;

@CucumberOptions(features="src/test/resources", glue="LocationsPageStepDef")
public class LocationsTestRunner extends AbstractTestNGCucumberTests {
	
//	@Test(dataProvider = "dp")
//	public void locationsTest(Integer n, String s) {
//	  
//	}
//	@BeforeMethod
//	public void beforeMethod() {
//	}


//  @DataProvider
//  public Object[][] dp() {
//    return new Object[][] {
//      new Object[] { 1, "a" },
//      new Object[] { 2, "b" },
//    };
//  }
//  @BeforeClass
//  public void beforeClass() {
//  }
//
//  @AfterClass
//  public void afterClass() {
//	  
//  }
//
//  @BeforeTest
//  public void beforeTest() {
//	  File chrome = new File("src/test/resources/chromedriver.exe");
//		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
//		driver = new ChromeDriver();
//		driver.get("https://dev.assignforce.revaturelabs.com");
//		try {
//			  Properties props = new Properties();
//			  InputStream in = new FileInputStream("src/main/resources/util.properties");
//			  props.load(in);
//			  String trainerUsername = props.getProperty("trainerUsername");
//			  String trainerPassword = props.getProperty("trainerPassword");
//			  driver.findElement(By.id("username")).sendKeys(trainerUsername);
//			  driver.findElement(By.name("pw")).sendKeys(trainerPassword);
//			  driver.findElement(By.xpath("//*[@id='Login']")).click();
//		  } catch(Exception e) {
//			  System.out.println(e.getMessage());
//		  }
//  }
//
//  @AfterTest
//  public void afterTest() {  
//	  driver.close();
//	  driver.quit();
//  }

}