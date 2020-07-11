package pe.com.swtestingdragons.dragonautomationfw.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {
        "pretty",
        "html:target/cucumber-reports/cucumber-pretty",
        "json:target/cucumber-reports/json-reports/Cucumber.json",
        "junit:target/cucumber-reports/junit-reports/Cucumber.xml"},
        tags = {"@ApiRest or @E2E"},
        glue = {"pe.com.swtestingdragons.dragonautomationfw.cucumber"},
        features ={"src/test/resources/cucumber/features"},
        monochrome = true, snippets = SnippetType.CAMELCASE)

public class RunCucumberTest {
}