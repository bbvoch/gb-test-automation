package ru.geekbrains.lesson6.features.repository;

import org.junit.jupiter.api.Test;
import ru.geekbrains.lesson6.base.BaseUITests;
import ru.geekbrains.lesson6.common.Configurations;
import ru.geekbrains.lesson6.enums.CreationBarTabs;
import ru.geekbrains.lesson6.pages.LoginPage;
import ru.geekbrains.lesson6.pages.NewRepositoryPage;

import static ru.geekbrains.lesson6.common.Configurations.REPO_NAME;

public class NewRepositoryTest extends BaseUITests {

    @Test
    public void createNewExpensePositiveTest() {
        NewRepositoryPage repositoryScreen = (NewRepositoryPage) new LoginPage(driver)
                .authoriseScenario(Configurations.LOGIN, Configurations.PASSWORD)
                .clickCreationBar()
                .clickSubMenuButton(CreationBarTabs.NEW_REPOSITORIES);

        repositoryScreen
                .enterRepositoryName(REPO_NAME)
                .clickAddReadmeFile()
                .clickCreateRepository();
    }
}
