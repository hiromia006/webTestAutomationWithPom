package com.parabank.parasoft.testcasses;

import com.parabank.parasoft.pages.base.BasePage;
import com.parabank.parasoft.pages.base.Page;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;
    private Properties properties;

    Page page;

    public BaseTest() {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
        properties = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream(filePath);
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeMethod
    public void browserSetup() {
        String browserName = properties.getProperty("browserName");

        if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (Objects.equals(browserName, "chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("headless")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            driver = new FirefoxDriver(options);
        } else if (browserName.equalsIgnoreCase("chromeHeadless")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        } else {
            System.out.println("Please provide proper browser name");
        }

        driver.get(properties.getProperty("baseUrl"));
        driver.manage().window().maximize();

        page = new BasePage(driver);
    }


    @AfterMethod
    public void browserQuite() {
        driver.quit();
    }

    public String getUsername() {
        return properties.getProperty("username");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }

}
