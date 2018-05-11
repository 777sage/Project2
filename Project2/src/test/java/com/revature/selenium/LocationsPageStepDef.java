package com.revature.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LocationsPageStepDef {
	private WebDriver driver;

	public void initializeWebDriver(WebDriver driver) {
		this.driver = driver;
	}

	@Given("^a location$")
	public void a_location() throws Throwable {
		System.out.println("I am running in given location");
	}

	@Given("^with a building$")
	public void with_a_building() throws Throwable {
		System.out.println("inside with a buidling given");
	}

	@Given("^room$")
	public void room() throws Throwable {
		System.out.println("Inside room option");
	}

	@When("^the location is clicked$")
	public void the_location_is_clicked() throws Throwable {
		System.out.println("inside the location is clicked");
	}

	@Then("^does a building dropdown window open$")
	public void does_a_building_dropdown_window_open() throws Throwable {
		System.out.println("inside buidlign dropdown window open");
	}

	@When("^the building is clicked$")
	public void the_building_is_clicked() throws Throwable {
		System.out.println("Inside building is clicked");
	}

	@Then("^does a room dropdown window open$")
	public void does_a_room_dropdown_window_open() throws Throwable {
		System.out.println("inside does a room dropdown window open");
	}

	@When("^logout button clicked$")
	public void logout_button_clicked() throws Throwable {
		System.out.println("Inside logout button clicked");
	}
	
	@Then("^check if the login screen is loaded$")
	public void check_if_the_login_screen_is_loaded() throws Throwable {
		System.out.println("inside check if the login screen is loaded");
	}

	@Then("^close the test$")
	public void close_the_test() throws Throwable {
		System.out.println("inside close the test");
	}
	
	@When("^locations button pressed$")
	public void locations_button_pressed() throws Throwable {
		System.out.println("Inside click locations");
		driver.findElement(By.className("_md-nav-button-text ng-scope")).click();
	}

	@Then("^check the url$")
	public void check_the_url() throws Throwable {
	    System.out.println("inside check url bottom");
	}
}
