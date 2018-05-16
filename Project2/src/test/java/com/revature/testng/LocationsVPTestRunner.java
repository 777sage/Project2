package com.revature.testng;

import org.testng.annotations.Test;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features="src/test/resources", glue="LocationsVPStepDef")
public class LocationsVPTestRunner extends AbstractTestNGCucumberTests {
  @Test
  public void f() {
	  
  }
}
