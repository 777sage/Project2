package com.revature.selenium;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.revature.dao.Service;
//import com.revature.serviceHooks.ServiceHooks;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LocationsVPStepDef {


	@When("^add location button pressed$")
	public void add_location_button_pressed() throws Throwable {
		System.out.println("inside add location, push button");
		WebElement element = ServiceHooks.driver.findElement(By.xpath("//*[@id=\'locAdd\']"));
		ServiceHooks.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try {
			element.click();
			assertNotNull(element);
			System.out.println("Add location button exists success");
	    	Service.updateTest("Add location button exists", "Success");
		}catch (Error e) {
			System.out.println("No add location button, Failed");
	    	Service.updateTest("No add locations button exists", "Failed");
		}
		ServiceHooks.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Then("^check if pop up opened$")
	public void check_if_pop_up_opened() throws Throwable {
		System.out.println("inside check if pop up opened");
		WebElement element = ServiceHooks.driver.findElement(By.xpath("//form[@name='locationForm']"));
		try {
			assertNotNull(element);
			System.out.println("Locations form exists");
	    	Service.updateTest("Add location form exists", "Success");
		}catch (Error e) {
			System.out.println("No add location form, Failed");
	    	Service.updateTest("No add locations form exists", "Failed");
		}
		
		ServiceHooks.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
	}

	@Given("^location name, city, and state$")
	public void location_name_city_and_state() throws Throwable {
		System.out.println("inside location name, city, and state given");
		ServiceHooks.driver.findElement(By.xpath("//*[contains(@id,'dialogContent_6')]/div/div/md-input-container/input")).sendKeys("Moon");
		ServiceHooks.driver.findElement(By.xpath("//*[contains(@id,'dialogContent_6')]/div/div/md-input-container[2]/input")).sendKeys("Peoria");
		ServiceHooks.driver.findElement(By.xpath("//*[contains(@id,'dialogContent_6')]/div/div/md-input-container[3]/md-select")).sendKeys("IL");		
		ServiceHooks.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@When("^save button clicked$")
	public void save_button_clicked() throws Throwable {
		System.out.println("inside save button clicked");
		ServiceHooks.driver.findElement(By.xpath("//button[@type='submit']")).click();		
		ServiceHooks.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Then("^check if the location was added$")
	public void check_if_the_location_was_added() throws Throwable {
		System.out.println("inside check if the location was added");
		WebElement element = ServiceHooks.driver.findElement(By.xpath("//*[contains(text(),'Moon')]"));
		try {
			assertNotNull(element);
			System.out.println("Locations was added");
	    	Service.updateTest("Location was added", "Success");
		} catch (Error e) {
			System.out.println("Location was not added, Failed");
	    	Service.updateTest("Location was not added", "Failed");
		}
	}

	@When("^newly added location is selected press the add building button$")
	public void newly_added_location_is_selected_press_the_add_building_button() throws Throwable {
		System.out.println("inside newly added location is selected, press add");
		WebElement element = ServiceHooks.driver.findElement(By.xpath("//*[contains(text(),'Moon')/parent::div]"));
		
		element.findElement(By.xpath(".."));
		element.findElement(By.xpath("/following-sibling;;md-checkbox[1])"));
		element.click();
	}

	@Then("^see if the new building pop up appears$")
	public void see_if_the_new_building_pop_up_appears() throws Throwable {
		System.out.println("inside see if the new building pop up appears");
	}

	@Given("^a building name$")
	public void a_building_name() throws Throwable {
		System.out.println("inside building name given");
	}

	@Then("^see if the building was added$")
	public void see_if_the_building_was_added() throws Throwable {
		System.out.println("inside see if the building was added");
	}

	@When("^newly added location is selected press the add room button$")
	public void newly_added_location_is_selected_press_the_add_room_button() throws Throwable {
		System.out.println("inside newly added location is selected, press button");
	}

	@Given("^a room name$")
	public void a_room_name() throws Throwable {
		System.out.println("inside given a room name");
	}

	@Then("^check if the room was added$")
	public void check_if_the_room_was_added() throws Throwable {
		System.out.println("inside check if room was added");
	}

	@When("^newly added building is selected$")
	public void newly_added_building_is_selected() throws Throwable {
		System.out.println("inside newly added building is selected");
	}

	@Then("^see if room pop up appears$")
	public void see_if_room_pop_up_appears() throws Throwable {
		System.out.println("inside see if room pop up appears");
	}

	@Then("^see if the room was added$")
	public void see_if_the_room_was_added() throws Throwable {
		System.out.println("inside see if the room was added");
	}

	@When("^newly added room is selected press the add location button$")
	public void newly_added_room_is_selected_press_the_add_location_button() throws Throwable {
		System.out.println("inside newly added room is s selected, press button");
	}

	@Then("^see if the pop up window appears$")
	public void see_if_the_pop_up_window_appears() throws Throwable {
		System.out.println("inside see if the pop up window appears for not add room to location");

	}

	@When("^newly added room is selected, edit button pressed$")
	public void newly_added_room_is_selected_edit_button_pressed() throws Throwable {
		System.out.println("inside newly added room is selected to edit, press button");
	}

	@Then("^see if room pop up window appears$")
	public void see_if_room_pop_up_window_appears() throws Throwable {
		System.out.println("inside see if room pop up window appears");
	}

	@Given("^a new room number, save is pressed$")
	public void a_new_room_number_save_is_pressed() throws Throwable {
		System.out.println("inside a new room number, save pressed");
	}

	@Then("^see if the room was modified$")
	public void see_if_the_room_was_modified() throws Throwable {
		System.out.println("inside see if the room was modified");
	}

	@When("^newly added building is selected, edit button pressed$")
	public void newly_added_building_is_selected_edit_button_pressed() throws Throwable {
		System.out.println("inside newly added building is selected, press edit button");
	}

	@Then("^see if the building pop up opens$")
	public void see_if_the_building_pop_up_opens() throws Throwable {
		System.out.println("inside see if the building pop up opens");
	}

	@When("^building info is given, save is pressed$")
	public void building_info_is_given_save_is_pressed() throws Throwable {
		System.out.println("inside building info is given, save pressed");
	}

	@Then("^check if the building was modified$")
	public void check_if_the_building_was_modified() throws Throwable {
		System.out.println("inside check if the building was modified");
	}

	@When("^the newly added location is selected, edit button is pressed$")
	public void the_newly_added_location_is_selected_edit_button_is_pressed() throws Throwable {
		System.out.println("inside the newly added location is selected, edit button pressed");
	}

	@Then("^see if building pop up opens$")
	public void see_if_building_pop_up_opens() throws Throwable {
		System.out.println("inside see if building pop up opens");
	}

	@Given("^new location information$")
	public void new_location_information() throws Throwable {
		System.out.println(" inside new location information");
	}

	@When("^the save button is pressed$")
	public void the_save_button_is_pressed() throws Throwable {
		System.out.println("inside the save button is pressed");
	}

	@Then("^is the location modified$")
	public void is_the_location_modified() throws Throwable {
		System.out.println("inside is the location modified");
	}

	@When("^newly modified room is selected, inactivate selected button pressed$")
	public void newly_modified_room_is_selected_inactivate_selected_button_pressed() throws Throwable {
		System.out.println("inside newly modified room is selected, inactivate button pressed");
	}

	@Then("^see if the room was deleted$")
	public void see_if_the_room_was_deleted() throws Throwable {
		System.out.println("inside see if the room was deleted");
	}

	@When("^newly modified buidling is selected, inactivate button pressed$")
	public void newly_modified_buidling_is_selected_inactivate_button_pressed() throws Throwable {
		System.out.println("inside newly modified building is selected, inactivate button pressed");
	}

	@Then("^see if building was deleted$")
	public void see_if_building_was_deleted() throws Throwable {
		System.out.println("inside see if building was deleted");
	}

	@When("^newly modified location is selected, inactivate selected button pressed$")
	public void newly_modified_location_is_selected_inactivate_selected_button_pressed() throws Throwable {
		System.out.println("inside newly modified location is selected, inactivate button pressed");
	}

	@Then("^see if location was deleted$")
	public void see_if_lcation_was_deleted() throws Throwable {
		System.out.println("inside see if location was deleted");
	}
	
//	@When("^logged in as an admin$")
//	public void logged_in_as_an_admin() throws Throwable {
//		 System.out.println("inside logged in as admin, navigate to locations page");
//		    
//		    System.out.println(ServiceHooks.driver.getCurrentUrl() + "inside locations button");
//			System.out.println("Inside click locations, still here?");
//			ServiceHooks.driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
//			
//			System.out.println("inside click after timeout");
//			ServiceHooks.driver.findElement(By.cssSelector("body > div > div:nth-child(1) > ng-include > div > md-content > md-nav-bar > div > nav > ul > li:nth-child(4) > a")).click();
//			ServiceHooks.driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
//			ServiceHooks.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//			System.out.println(ServiceHooks.driver.getCurrentUrl() + "inside locations button after logout clicked");
//	}

	@When("^the locatiton page is selected$")
	public void the_locatiton_page_is_selected() throws Throwable {
		System.out.println("Check if inside clicking locations tab");
		WebElement element = ServiceHooks.driver.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[3]/a"));
		try {
			element.click();
			assertNotNull(element);
			System.out.println("Location tab was clicked success");
	    	Service.updateTest("Location tab was clicked exists", "Success");
		}catch (Error e) {
			System.out.println("No Revature location button, Failed");
	    	Service.updateTest("Location tab could not be clicked", "Failed");
		}
//		ServiceHooks.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//	    String expectedURL = "https://dev.assignforce.revaturelabs.com/locations";
//	    try{
//	    	assertTrue(expectedURL.equals(ServiceHooks.driver.getCurrentUrl()));
//			ServiceHooks.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//	    	System.out.println("Successful URL");
//	    	Service.updateTest("Check locations URL", "Success");
//	    	
//	    } catch(Error e) {
//	    	System.out.println("Non-matching URL's");
//	    	Service.updateTest("Check locations URL", "Failed");
//	    }
	}
}
