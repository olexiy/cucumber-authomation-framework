package de.olexiy.texting.example.cucumberauthomationframework.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_PO extends Base_PO{
    private @FindBy(id = "text") WebElement username;
    private @FindBy(id = "password") WebElement password;
    private @FindBy(id = "login-button") WebElement loginButton;
    public Login_PO() {
        super();
    }

    public void navigate_toWebdriverUniversityLoginPage() {
        navigate_toURL("https://www.webdriveruniversity.com/Login-Portal/index.html");
    }

    public void setUsername(String username) {
        this.username.sendKeys(username);
    }

    public void setPassword(String password) {
        this.password.sendKeys(password);
    }

    public void clickLoginButton() {
        this.loginButton.click();
    }
}
