package stepdef.flipkart;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/flipkart.feature",glue = {"stepdef.flipkart"},
    plugin = {"pretty", "html:target/cucumber-reports/flipkart.html"},
    tags = "@SelectFromSuggestion", monochrome = true, dryRun = false)
public class FlipkartRunner extends AbstractTestNGCucumberTests {
}
