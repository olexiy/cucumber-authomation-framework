package de.olexiy.testing.example.cucumberauthomationframework.stepDefenitions;

import de.olexiy.testing.example.cucumberauthomationframework.pageObjects.Base_PO;
import de.olexiy.testing.example.cucumberauthomationframework.pageObjects.Contact_Us_PO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class Contact_Us_Steps extends Base_PO {

    private final Contact_Us_PO contact_us_po;
    private final WebDriver driver = getDriver();

    public Contact_Us_Steps(Contact_Us_PO contact_us_po) {
        this.contact_us_po = contact_us_po;
    }

    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
        contact_us_po.navigate_toWebdriverUniversityContactUsPage();
    }

    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        sendKeys(contact_us_po.firstName, "AutoFN" + generateRandomNumber(5));
    }

    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        sendKeys(contact_us_po.lastName, "AutoLN" + generateRandomNumber(5));
    }

    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        sendKeys(contact_us_po.email, "AutoEmail" + generateRandomNumber(5) + "@mail.com");
    }

    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        sendKeys(contact_us_po.message, "AutoMessage" + generateRandomNumber(5));
    }

    @And("I click on the submit button")
    public void i_click_on_the_submit_button() {
        waitClick(contact_us_po.submitButton);
    }

    @When("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name(String firstName) {
        sendKeys(contact_us_po.firstName, firstName);
    }

    @When("I enter a specific last name {word}")
    public void i_enter_a_specific_last_name(String lastName) {
        sendKeys(contact_us_po.lastName, lastName);
    }

    @When("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address(String email) {
        sendKeys(contact_us_po.email, email);
    }

    @When("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String message) {
        sendKeys(contact_us_po.message, message);
    }

    @Then("I should be presented with a successful contact us submission page")
    public void iShouldBePresentedWithASuccessfulContactUsSubmissionPage() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        assert driver.getCurrentUrl()
                .equals("https://www.webdriveruniversity.com/Contact-Us/contact-form-thank-you.html");
        assert driver.findElement(By.xpath("//h1[text()='Thank You for your Message!']"))
                .isDisplayed();
    }


}
