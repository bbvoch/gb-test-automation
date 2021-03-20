package ru.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test2 {

    private static final String LOGIN_PAGE_URL = "https://github.com/login";
    private static final String HOST = "https://github.com/";
    private static final String LOGIN = "gb-autotester";
    private static final String PASSWORD = "Bb1234567890/";
    private static final String REPO_NAME = "ds";
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

        driver.findElement(By.linkText("Create repository")).click();
        driver.findElement(By.id("repository_name")).sendKeys(REPO_NAME);
        driver.findElement(By.id("repository_auto_init")).click();

        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable
                (By.xpath(".//*[@id=\"new_repository\"]/div[4]/button")));

        driver.findElement(By.xpath(".//*[@id=\"new_repository\"]/div[4]/button")).click();
        driver.get(HOST + LOGIN + "/" + REPO_NAME);

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
