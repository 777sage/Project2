package com.revature.selenium;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.revature.dao.Service;
<<<<<<< HEAD
//import com.revature.serviceHooks.ServiceHooks;
=======
>>>>>>> new-mitch-branch

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LocationsPageStepDef {

	private String location;
	private String building;
	private String room;
	
	@Given("^a location$")
	public void a_location() throws Throwable {
		System.out.println("I am running in given location");
		location = "Revature, Reston VA";
	}

	@Given("^with a building$")
	public void with_a_building() throws Throwable {
		System.out.println("inside with a building given");
		building = "Revature 11730";
	}

	@Given("^room$")
	public void room() throws Throwable {
		System.out.println("Inside room option");
		room = "201";
	}

	@When("^the location is clicked$")
	public void the_location_is_clicked() throws Throwable {
		System.out.println("inside the location is clicked");
		WebElement element = ServiceHooks.driver.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content/md-list/md-list-item[4]/div[1]/button"));
		try {
			element.click();
			assertNotNull(element);
			System.out.println("Location exists success");
	    	Service.updateTest("Location Revature exists", "Success");
		}catch (Error e) {
			System.out.println("No Revature location button, Failed");
	    	Service.updateTest("Location Revature exists", "Failed");
		}
		ServiceHooks.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Then("^does a building dropdown window open$")
	public void does_a_building_dropdown_window_open() throws Throwable {
		System.out.println("inside building dropdown window open");
	}

	@When("^the building is clicked$")
	public void the_building_is_clicked() throws Throwable {
		System.out.println("Inside building is clicked");
		WebElement element = ServiceHooks.driver.findElement(By.xpath("//*[@id=\"loc367\"]/md-list-item/div/button"));
		try {
			element.click();
			assertNotNull(element);
			System.out.println("Building exists, Success");
	    	Service.updateTest("Revature building exists", "Success");
		}catch (Error e) {
			System.out.println("No Revature building button, Failed");
	    	Service.updateTest("Revature building exists", "Failed");
		}
		ServiceHooks.driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@Then("^does a room dropdown window open$")
	public void does_a_room_dropdown_window_open() throws Throwable {
		System.out.println("inside does a room dropdown window open");
		WebElement element = ServiceHooks.driver.findElement(By.xpath("//*[@id=\"bldg252\"]/md-list-item[1]/div/button"));
		try {
			element.click();
			assertNotNull(element);
			System.out.println("Room exists, success");
	    	Service.updateTest("Revature room exists", "Success");
		}catch (Error e) {
			System.out.println("No Revature location button, Failed");
	    	Service.updateTest("Revature room exists", "Failed");
		}
		ServiceHooks.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@When("^logout button clicked$")
	public void logout_button_clicked() throws Throwable {
		System.out.println("Inside logout button clicked");
		ServiceHooks.driver.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[9]/button")).click();
		ServiceHooks.driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		ServiceHooks.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println(ServiceHooks.driver.getCurrentUrl());

	}
	
	@Then("^check if the login screen is loaded$")
	public void check_if_the_login_screen_is_loaded() throws Throwable {
		System.out.println("inside login screen");
		ServiceHooks.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		ServiceHooks.driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		ServiceHooks.driver.findElement(By.xpath("//*[@id=\"logo\"]"));
		ServiceHooks.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		
		String expectedURL = "https://revature--int1.cs17.my.salesforce.com";
			try{
			System.out.println("This is our expected URL" + expectedURL);
			System.out.println("This is our actual URL" + ServiceHooks.driver.getCurrentUrl());
			
			assertTrue(ServiceHooks.driver.getCurrentUrl().contains(expectedURL));
			ServiceHooks.driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	    	System.out.println("Successful URL");
	    	Service.updateTest("Check login URL", "Success");
	    	
	    } catch(Error e) {
	    	System.out.println("Non-matching URL's");
	    	Service.updateTest("Check login URL", "Failed");
	    }
	}

	@Then("^close the test$")
	public void close_the_test() throws Throwable {
		System.out.println("inside close the test");
	}
	
	@When("^locations button pressed$")
	public void locations_button_pressed() throws Throwable {
		System.out.println("before current url in button press");
		System.out.println(ServiceHooks.driver.getCurrentUrl() + "inside locations button");
		System.out.println("Inside click locations, still here?");
		ServiceHooks.driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		System.out.println("inside click after timeout");
		ServiceHooks.driver.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[3]/a/span")).click();
		ServiceHooks.driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		ServiceHooks.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println(ServiceHooks.driver.getCurrentUrl() + "inside locations button after logout clicked");
	}

	@Then("^check the url$")
	public void check_the_url() throws Throwable {
	    System.out.println("inside check url bottom");
	    String expectedURL = "https://dev.assignforce.revaturelabs.com/locations";
	    try{
	    	assertTrue(expectedURL.equals(ServiceHooks.driver.getCurrentUrl()));
	    	System.out.println("Successful URL");
	    	Service.updateTest("Check locations URL", "Success");
	    	
	    } catch(Error e) {
	    	System.out.println("Non-matching URL's");
	    	Service.updateTest("Check locations URL", "Failed");
	    }
	}
}
