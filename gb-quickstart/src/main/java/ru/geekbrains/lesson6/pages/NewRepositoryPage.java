package ru.geekbrains.lesson6.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.geekbrains.lesson6.base.BaseView;

public class NewRepositoryPage extends BaseView {

    public static final String BASE_URL = "https://github.com/";
    public static final String LOGIN = "gb-autotester";
    public static final String REPO_NAME = "ds";

    @FindBy(id = "repository_name")
    private WebElement inputRepositoryName;

    @FindBy(id = "repository_auto_init")
    private WebElement addReadmeFile;

    @FindBy(xpath = ".//*[@id=\"new_repository\"]/div[4]/button")
    private WebElement createRepositoryButton;

    public NewRepositoryPage(WebDriver driver) {
        super(driver);
    }

    @Step("Enter new repository name {REPO_NAME}")
    public NewRepositoryPage enterRepositoryName(String REPO_NAME) {
        inputRepositoryName.sendKeys(REPO_NAME);
        return this;
    }

    @Step("Add Readme file")
    public NewRepositoryPage clickAddReadmeFile() {
        addReadmeFile.click();
        return this;
    }

    @Step("Click 'Create repository' button")
    public NewRepositoryPage clickCreateRepository() {
        createRepositoryButton.click();
        driver.get(BASE_URL + LOGIN + "/" + REPO_NAME);
        return this;
    }
}
