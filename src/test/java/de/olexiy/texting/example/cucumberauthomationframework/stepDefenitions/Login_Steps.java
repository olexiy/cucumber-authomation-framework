package de.olexiy.texting.example.cucumberauthomationframework.stepDefenitions;

import de.olexiy.texting.example.cucumberauthomationframework.stepDefenitions.base.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static de.olexiy.texting.example.cucumberauthomationframework.driver.DriverFactory.getDriver;

public class Login_Steps {
    private final WebDriver driver = getDriver();
    @Given("I open login page")
    public void i_open_login_page() {
        driver.get("https://www.webdriveruniversity.com/Login-Portal/index.html");
    }
    @When("I enter username as {string}")
    public void i_enter_username_as(String login) {
        driver.findElement(By.id("text")).sendKeys(login);
    }
    @And("I enter password as {string}")
    public void i_enter_password_as(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("I click login button")
    public void i_click_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("I should be presented with successful login message")
    public void i_should_be_presented_with_successful_login_message() {
        String message =  driver.switchTo().alert().getText();
        System.out.println(message);
        Assert.assertEquals(message, "validation succeeded");
    }

    @Then("I should be presented with unsuccessful login messages")
    public void i_should_be_presented_with_unsuccessful_login_messages() {
        String message =  driver.switchTo().alert().getText();
        Assert.assertEquals(message, "validation failed");
    }
}
