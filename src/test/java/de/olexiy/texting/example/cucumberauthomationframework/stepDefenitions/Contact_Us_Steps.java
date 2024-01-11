package de.olexiy.texting.example.cucumberauthomationframework.stepDefenitions;

import de.olexiy.texting.example.cucumberauthomationframework.stepDefenitions.base.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static de.olexiy.texting.example.cucumberauthomationframework.driver.DriverFactory.getDriver;

public class Contact_Us_Steps{
    private final WebDriver driver = getDriver();
    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
        driver.get("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
    }

    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        driver.findElement(By.xpath("//input[@name='first_name']"))
                .sendKeys("AutoFN"+generateRandomNumber(5));
    }

    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        driver.findElement(By.xpath("//input[@name='last_name']"))
                .sendKeys("AutoLN"+generateRandomNumber(5));
    }

    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        driver.findElement(By.xpath("//input[@name='email']"))
                .sendKeys("AutoEmail"+generateRandomNumber(5)+"@gmail.com");
    }

    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        driver.findElement(By.xpath("//textarea[@name='message']"))
                .sendKeys("Hello World! "+generateRandomAlphabetic(25));
    }

    @And("I click on the submit button")
    public void i_click_on_the_submit_button() {
        driver.findElement(By.xpath("//input[@value='SUBMIT']"))
                .click();
    }

    @When("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name(String firstName) {
        driver.findElement(By.xpath("//input[@name='first_name']"))
                .sendKeys(firstName);
    }
    @When("I enter a specific last name {word}")
    public void i_enter_a_specific_last_name(String lastName) {
        driver.findElement(By.xpath("//input[@name='last_name']"))
                .sendKeys(lastName);
    }
    @When("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address(String email) {
        driver.findElement(By.xpath("//input[@name='email']"))
                .sendKeys(email);
    }
    @When("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String message) {
        driver.findElement(By.xpath("//textarea[@name='message']"))
                .sendKeys(message);
    }
    @Then("I should be presented with a successful contact us submission page")
    public void iShouldBePresentedWithASuccessfulContactUsSubmissionPage() {
        assert driver.getCurrentUrl()
                .equals("https://www.webdriveruniversity.com/Contact-Us/contact-form-thank-you.html");
        assert driver.findElement(By.xpath("//h1[text()='Thank You for your Message!']"))
                .isDisplayed();
    }


    public String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public String generateRandomAlphabetic(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

}
