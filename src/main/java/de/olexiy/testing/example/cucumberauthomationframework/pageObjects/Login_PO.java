package de.olexiy.testing.example.cucumberauthomationframework.pageObjects;

import de.olexiy.testing.example.cucumberauthomationframework.utils.GlobalVars;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_PO extends Base_PO {
    private @FindBy(id = "text") WebElement username;
    private @FindBy(id = "password") WebElement password;
    private @FindBy(id = "login-button") WebElement loginButton;

    public Login_PO() {
        super();
    }

    public void navigate_toWebdriverUniversityLoginPage() {
        navigate_toURL(GlobalVars.WEBDRIVER_UNIVERSITY_URL + "/Login-Portal/index.html");
    }

    public void setUsername(String username) {
        sendKeys(this.username, username);
    }

    public void setPassword(String password) {
        sendKeys(this.password, password);
    }

    public void clickLoginButton() {
        waitClick(this.loginButton);
    }
}
