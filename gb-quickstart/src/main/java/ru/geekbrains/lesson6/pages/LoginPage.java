package ru.geekbrains.lesson6.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.geekbrains.lesson6.base.BaseView;
import ru.geekbrains.lesson6.pages.HomePage;

public class LoginPage extends BaseView {

    @FindBy(name = "login")
    private WebElement inputLogin;

    @FindBy(name = "password")
    private WebElement inputPassword;

    @FindBy(name = "commit")
    private WebElement buttonSignIn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    public LoginPage enterPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    public HomePage clickLoginButton() {
        buttonSignIn.click();
        return new HomePage(driver);
    }

    public HomePage authoriseScenario(String login, String password) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonSignIn.click();
        return new HomePage(driver);
    }
}
