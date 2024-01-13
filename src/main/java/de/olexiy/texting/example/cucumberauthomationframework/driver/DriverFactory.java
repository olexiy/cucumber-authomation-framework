package de.olexiy.texting.example.cucumberauthomationframework.driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (webDriver.get() == null) {
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }

    private static WebDriver createDriver() {
        WebDriver driver = null;

        String browserType = getBrowserType();

        switch (browserType) {
            case "chrome" -> {
                //System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
                ChromeOptions options = new ChromeOptions();
                options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(options);
            }
            case "firefox" -> {
                //System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver");
                FirefoxOptions options = new FirefoxOptions();
                options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new FirefoxDriver(options);
            }
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static void cleanUp() {
        webDriver.get().quit();
        webDriver.remove();
    }

    private static String getBrowserType() {
        Properties properties = new Properties();
        FileInputStream file = null;
        try {
            file = new FileInputStream("src/main/resources/config.properties");
            properties.load(file);
            return properties.getProperty("browser").toLowerCase().trim();
        } catch (IOException e) {

            return "chrome";
        }

    }
}
