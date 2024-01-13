package de.olexiy.texting.example.cucumberauthomationframework.stepDefenitions;

import de.olexiy.texting.example.cucumberauthomationframework.pageObjects.Base_PO;
import de.olexiy.texting.example.cucumberauthomationframework.pageObjects.Contact_Us_PO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Contact_Us_Steps extends Base_PO {

    private final Contact_Us_PO contact_us_po;
    public Contact_Us_Steps(Contact_Us_PO contact_us_po) {
        this.contact_us_po = contact_us_po;
    }

    private final WebDriver driver = getDriver();
    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
        contact_us_po.navigate_toWebdriverUniversityContactUsPage();
    }

    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        contact_us_po.setFirstName("AutoFN"+generateRandomNumber(5));
    }

    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {contact_us_po.setLastName("AutoLN"+generateRandomNumber(5));
    }

    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {contact_us_po.setEmailAddress("AutoEmail"+generateRandomNumber(5)+"@mail.com");
    }

    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {contact_us_po
            .setComments("AutoMessage"+generateRandomNumber(5));
    }

    @And("I click on the submit button")
    public void i_click_on_the_submit_button() {
        contact_us_po.clickOnSubmitButton();
    }

    @When("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name(String firstName) {
       contact_us_po.setFirstName(firstName);
    }
    @When("I enter a specific last name {word}")
    public void i_enter_a_specific_last_name(String lastName) {
        contact_us_po.setLastName(lastName);
    }
    @When("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address(String email) {

        contact_us_po.setEmailAddress(email);
    }
    @When("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String message) {
        contact_us_po.setComments(message);
    }
    @Then("I should be presented with a successful contact us submission page")
    public void iShouldBePresentedWithASuccessfulContactUsSubmissionPage() {
        assert driver.getCurrentUrl()
                .equals("https://www.webdriveruniversity.com/Contact-Us/contact-form-thank-you.html");
        assert driver.findElement(By.xpath("//h1[text()='Thank You for your Message!']"))
                .isDisplayed();
    }


}
