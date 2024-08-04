package ActivityRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Features",
		glue = {"stepdefinitions"},
		tags = "@smoketest",
		plugin = {"html: test-reports"},
	    monochrome = true

)
public class Activity6_activityrunner {

}
