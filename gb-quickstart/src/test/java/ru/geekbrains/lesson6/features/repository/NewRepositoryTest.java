package ru.geekbrains.lesson6.features.repository;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.geekbrains.lesson6.base.BaseUITests;
import ru.geekbrains.lesson6.common.Configurations;
import ru.geekbrains.lesson6.enums.CreationBarTabs;
import ru.geekbrains.lesson6.pages.LoginPage;
import ru.geekbrains.lesson6.pages.NewRepositoryPage;

import static ru.geekbrains.lesson6.common.Configurations.REPO_NAME;

@Feature("New repository")
public class NewRepositoryTest extends BaseUITests {

    @Story("Create new repository")
    @Disabled
    @Test
    public void createNewRepositoryTest() throws InterruptedException {
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
