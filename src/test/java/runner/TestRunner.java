package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features="Features",
		glue    ="stepdefinitions",
		monochrome=true
		)
public class TestRunner extends AbstractTestNGCucumberTests{

}
