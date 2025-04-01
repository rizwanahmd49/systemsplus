package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/resources/features", glue = {"stepdef.systemplus"},
        monochrome = false,
        plugin = {"pretty", "html:target/cucumber-reports/HTML_Reports.html",
                "json:target/json-report/jsonreport.json"},
        tags = "@FindCenter")
public class SystemRunnerTest extends AbstractTestNGCucumberTests {


}
