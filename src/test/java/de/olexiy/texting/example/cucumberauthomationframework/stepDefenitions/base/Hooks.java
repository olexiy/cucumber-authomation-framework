package de.olexiy.texting.example.cucumberauthomationframework.stepDefenitions.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static de.olexiy.texting.example.cucumberauthomationframework.driver.DriverFactory.cleanUp;
import static de.olexiy.texting.example.cucumberauthomationframework.driver.DriverFactory.getDriver;

public class Hooks {
    @Before
    public void setup() {
        getDriver();
    }
    @After
    public void tearDown() {
        cleanUp();
    }
}
