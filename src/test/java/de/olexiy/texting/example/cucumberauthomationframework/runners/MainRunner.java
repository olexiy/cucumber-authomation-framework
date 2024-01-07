package de.olexiy.texting.example.cucumberauthomationframework.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"classpath:features"},
        glue = {"classpath:de.olexiy.texting.example.cucumberauthomationframework.stepDefenitions"},
        monochrome = true,
        dryRun = false,
        tags = "@contactUs or @login",
        plugin = {"pretty", "html:target/cucumber-report.html", "json:target/cucumber.json"}
)
public class MainRunner extends AbstractTestNGCucumberTests {
}
