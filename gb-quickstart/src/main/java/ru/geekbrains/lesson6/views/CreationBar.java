package ru.geekbrains.lesson6.views;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.geekbrains.lesson6.base.BaseView;
import ru.geekbrains.lesson6.base.SubMenu;
import ru.geekbrains.lesson6.base.SubMenuButtons;
import ru.geekbrains.lesson6.enums.CreationBarTabs;
import ru.geekbrains.lesson6.pages.NewRepositoryPage;

public class CreationBar extends SubMenu {

    @FindBy(xpath = ".//div[6]/details/summary")
    private WebElement creationBarButton;

    public CreationBar(WebDriver driver) {
        super(driver);
    }

    @Override
    public BaseView clickSubMenuButton(SubMenuButtons buttons) {
        if (buttons instanceof CreationBarTabs) {
            switch ((CreationBarTabs) buttons) {
                case NEW_REPOSITORIES:
                    driver.findElement(((CreationBarTabs) buttons).getBy()).click();
                    return new NewRepositoryPage(driver);
                default:
                    throw new IllegalArgumentException("Not implemented yet");
            }
        } else {
            throw new IllegalArgumentException("Incorrect button type");
        }
    }

    public CreationBar checkTabVisibility(CreationBarTabs tab) {
        creationBarButton.click();
        Assertions.assertTrue(driver.findElement(tab.getBy()).isDisplayed());
        return this;
    }
}

