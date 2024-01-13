package de.olexiy.texting.example.cucumberauthomationframework.pageObjects;

import de.olexiy.texting.example.cucumberauthomationframework.driver.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base_PO {

    public Base_PO() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    public void navigate_toURL(String url) {
        getDriver().get(url);
    }

    public void sendKeys(By by, String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(text);
    }

    public void waitClick(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public String readAlertMessage() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        return getDriver().switchTo().alert().getText();
    }

    public String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public String generateRandomAlphabetic(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

}
