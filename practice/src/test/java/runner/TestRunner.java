package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "feature",
		glue = { "stepDefiniton" }, 
		monochrome = true, 
		plugin = { "pretty","html:results/cucumber-reports", "junit:target/cucumber-reports/Cucumber.xml" }
		)

public class TestRunner {

}
