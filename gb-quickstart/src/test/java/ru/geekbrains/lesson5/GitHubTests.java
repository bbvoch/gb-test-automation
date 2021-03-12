package ru.geekbrains.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class GitHubTests {

    private final String LOGIN_PAGE_URL = "https://github.com/login";
    private final String HOST = "https://github.com/";
    private final String LOGIN = "gb-autotester";
    private final String PASSWORD = "Bb1234567890/";
    private final String REPO_NAME = "ds";
    private final String PROJ_NAME = "qw12";
    private WebDriver driver;
    private JavascriptExecutor jsExec;

    @BeforeAll
    public static void setupWebDriverManager() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void beforeTest() {
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        jsExec = (JavascriptExecutor) driver;
        login();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLogin(){
        login();
    }

    @Test
    public void testEnter(){
        new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath
                (".//div[7]/details/summary/img"))));

        driver.findElement(By.xpath(".//div[7]/details/summary/img")).click();
        WebElement userMenu = driver.findElement(By.xpath(".//div[7]/details/details-menu/div[1]/a"));
        Assertions.assertTrue(userMenu.isDisplayed());
    }

    @Test
    public void testCreateRepository(){
        driver.findElement(By.xpath(".//div[6]/details/summary/svg")).click();

        new WebDriverWait(driver, 1).until(ExpectedConditions.elementToBeClickable
                (By.xpath(".//div[6]/details/details-menu")));

        driver.findElement(By.xpath(".//div[6]/details/details-menu/a[1]")).click();
        driver.findElement(By.id("repository_name")).sendKeys(REPO_NAME);
        driver.findElement(By.id("repository_auto_init")).click();

        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable
                (By.xpath(".//*[@id=\"new_repository\"]/div[4]/button")));

        driver.findElement(By.xpath(".//*[@id=\"new_repository\"]/div[4]/button")).click();
        WebElement newRepo = driver.findElement(By.xpath(".//*[@id=\"repos-container\"]/ul/li/div/a/span[2]"));
        Assertions.assertTrue(newRepo.isDisplayed());
    }

    @Test
    public void testCreateProject(){
        driver.findElement(By.xpath(".//div[6]/details/summary/svg")).click();

        new WebDriverWait(driver, 1).until(ExpectedConditions.elementToBeClickable
                (By.xpath(".//div[6]/details/details-menu")));

        driver.findElement(By.xpath(".//div[6]/details/details-menu/a[5]")).click();
        driver.findElement(By.id("project_name")).sendKeys(PROJ_NAME);

        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable
                (By.xpath(".//div[4]/button")));

        driver.findElement(By.xpath(".//div[4]/button")).click();
        driver.findElement(By.xpath(".//div[4]/div/div[1]/nav/a[2]")).click();
        WebElement newProj = driver.findElement(By.xpath("//*[@id=\"projects-results\"]/div[1]"));
        Assertions.assertTrue(newProj.isDisplayed());
    }

    @Test
    public void testDeleteProject(){
        new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath
                (".//div[7]/details/summary/img"))));

        driver.findElement(By.xpath(".//div[7]/details/summary/img")).click();
        driver.findElement(By.xpath(".//div[7]/details/details-menu/a[3]")).click();
        driver.findElement(By.xpath(".//*[@id=\"projects-results\"]/div/details/summary/svg")).click();

        new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath
                (".//*[@id=\"projects-results\"]/div/details/details-menu"))));

        driver.findElement(By.xpath(".//*[@id=\"projects-results\"]/div/details/details-menu/a[1]")).click();
        driver.findElement(By.xpath(".//div[4]/main/div/form[2]/div/button")).click();
        driver.switchTo().alert().accept();
    }

    private void login() {
        driver.get(LOGIN_PAGE_URL);
        driver.findElement(By.name("login")).sendKeys(LOGIN);
        driver.findElement(By.name("password")).sendKeys(PASSWORD);
        driver.findElement(By.name("commit")).click();
    }
}
