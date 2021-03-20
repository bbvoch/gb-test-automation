package ru.geekbrains.lesson6.features.enter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.geekbrains.lesson6.base.BaseUITests;
import ru.geekbrains.lesson6.common.Configurations;
import ru.geekbrains.lesson6.enums.CreationBarTabs;
import ru.geekbrains.lesson6.pages.LoginPage;

public class EnterTest extends BaseUITests {

    static CreationBarTabs[] creationTabProvider() {
        return CreationBarTabs.values();
    }

    @ParameterizedTest
    @MethodSource("creationTabProvider")
    public void checkCreationTabsTest(CreationBarTabs barTab) {
        new LoginPage(driver)
                .authoriseScenario(Configurations.LOGIN, Configurations.PASSWORD)
                .clickCreationBar()
                .checkTabVisibility(barTab);
    }
}
