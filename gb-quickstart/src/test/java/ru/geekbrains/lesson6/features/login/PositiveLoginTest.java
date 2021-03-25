package ru.geekbrains.lesson6.features.login;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;
import ru.geekbrains.lesson6.base.BaseUITests;
import ru.geekbrains.lesson6.helpers.ScreenshotMaker;
import ru.geekbrains.lesson6.pages.LoginPage;

import static ru.geekbrains.lesson6.common.Configurations.BASE_URL;
import static ru.geekbrains.lesson6.common.Configurations.LOGIN;
import static ru.geekbrains.lesson6.common.Configurations.PASSWORD;

@Feature("Login")
@Severity(SeverityLevel.BLOCKER)
public class PositiveLoginTest extends BaseUITests {

    @Test
    public void loginWithBaseUserTest() {
        new LoginPage(driver)
                .enterLogin(LOGIN)
                .enterPassword(PASSWORD)
                .clickLoginButton()
                .checkUrl(BASE_URL);

        ScreenshotMaker.makeScreenshot(driver,"login.jpg");
    }
}
