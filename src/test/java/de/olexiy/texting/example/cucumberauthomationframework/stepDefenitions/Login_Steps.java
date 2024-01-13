package de.olexiy.texting.example.cucumberauthomationframework.stepDefenitions;

import de.olexiy.texting.example.cucumberauthomationframework.pageObjects.Base_PO;
import de.olexiy.texting.example.cucumberauthomationframework.pageObjects.Login_PO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Login_Steps extends Base_PO {
    private final Login_PO login_po;
    public Login_Steps(Login_PO login_po) {
        this.login_po = login_po;
    }
    @Given("I open login page")
    public void i_open_login_page() {
        login_po.navigate_toWebdriverUniversityLoginPage();
    }
    @When("I enter a username {}")
    public void i_enter_a_username(String login) {
        login_po.setUsername(login);
    }
    @And("I enter a password {}")
    public void i_enter_a_password(String password) {
        login_po.setPassword(password);
    }

    @And("I click login button")
    public void i_click_login_button() {
        login_po.clickLoginButton();
    }

    @Then("I should be presented with the following validation message {}")
    public void i_should_be_presented_with_the_following_validation_message_(String loginValidationMessage) {
        String message =  readAlertMessage();
        Assert.assertEquals(message, loginValidationMessage);
    }

}
