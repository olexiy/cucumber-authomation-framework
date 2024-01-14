package de.olexiy.testing.example.cucumberauthomationframework.pageObjects;

import de.olexiy.testing.example.cucumberauthomationframework.utils.GlobalVars;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;

public class Contact_Us_PO extends Base_PO {
    public @FindBy(xpath = "//input[@name='first_name']") WebElement firstName;
    public @FindBy(xpath = "//input[@name='last_name']") WebElement lastName;
    public @FindBy(xpath = "//input[@name='email']") WebElement email;
    public @FindBy(xpath = "//textarea[@name='message']") WebElement message;
    public @FindBy(xpath = "//input[@value='SUBMIT']") WebElement submitButton;

    private @FindBy(xpath = "//div[@id='contact_reply']/h1") WebElement successfulSubmission_Message_Text;

    public Contact_Us_PO() {
        super();
    }

    public void navigate_toWebdriverUniversityContactUsPage() {
        navigate_toURL(GlobalVars.WEBDRIVER_UNIVERSITY_URL + "/Contact-Us/contactus.html");
    }

    public void setFirstName(String firstName) {
        sendKeys(this.firstName, firstName);
    }

    public void setLastName(String lastName) {
        sendKeys(this.lastName, lastName);
    }

    public void setEmailAddress(String email) {
        sendKeys(this.email, email);
    }

    public void setComments(String message) {
        sendKeys(this.message, message);
    }

    public void clickOnSubmitButton() {
        this.submitButton.click();
    }

    public void validate_Successful_SubmissionMessage_Text() {
        waitFor(successfulSubmission_Message_Text);
        assertEquals(successfulSubmission_Message_Text.getText(), "Thank You for your Message!");
    }


}
