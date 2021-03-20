package ru.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test1 {

    private static final String LOGIN_PAGE_URL = "https://github.com/login";
    private static final String HOST = "https://github.com/";
    private static final String LOGIN = "gb-autotester";
    private static final String PASSWORD = "Bb1234567890/";
    private static final WebDriver driver;

    static {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(options);
    }

    public static void main(String[] args) throws InterruptedException {
        login();

        new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath
                (".//div[7]/details/summary/img"))));

        driver.findElement(By.xpath(".//div[7]/details/summary/img")).click();
        driver.get(HOST + LOGIN);

        if (driver != null) {
            driver.quit();
        }
    }

    private static void login() {
        driver.get(LOGIN_PAGE_URL);
        driver.findElement(By.id("login_field")).sendKeys(LOGIN);
        driver.findElement(By.id("password")).sendKeys(PASSWORD);
        driver.findElement(By.name("commit")).click();
    }
}
