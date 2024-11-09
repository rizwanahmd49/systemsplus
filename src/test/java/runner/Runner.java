package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/resources/features", glue = {"stepdef"},
        monochrome = false,
        plugin = {"pretty", "html:target/cucumber-reports/HTML_Reports.html",
                "json:target/json-report/jsonreport.json"})
public class Runner extends AbstractTestNGCucumberTests {


}
