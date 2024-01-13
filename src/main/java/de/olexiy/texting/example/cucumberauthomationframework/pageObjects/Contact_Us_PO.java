package de.olexiy.texting.example.cucumberauthomationframework.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Contact_Us_PO  extends Base_PO{
    public @FindBy(xpath = "//input[@name='first_name']") WebElement firstName;
    public @FindBy(xpath = "//input[@name='last_name']") WebElement lastName;
    public @FindBy(xpath = "//input[@name='email']") WebElement email;
    public @FindBy(xpath = "//textarea[@name='message']") WebElement message;
    public @FindBy(xpath = "//input[@value='SUBMIT']") WebElement submitButton;

    public Contact_Us_PO() {
        super();
    }

    public void navigate_toWebdriverUniversityContactUsPage() {
        navigate_toURL("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
    }

    public void setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }

    public void setEmailAddress(String email) {
        this.email.sendKeys(email);
    }

    public void setComments(String message) {
        this.message.sendKeys(message);
    }

    public void clickOnSubmitButton() {
        this.submitButton.click();
    }


}
