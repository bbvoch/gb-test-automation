package ru.geekbrains.lesson6.enums;

import org.openqa.selenium.By;
import ru.geekbrains.lesson6.base.SubMenuButtons;

public enum CreationBarTabs implements SubMenuButtons {

    NEW_REPOSITORIES(".//div[6]/details/details-menu/a[1]"),
    IMPORT_REPOSITORY(".//div[6]/details/details-menu/a[2]"),
    NEW_GIST(".//div[6]/details/details-menu/a[3]"),
    NEW_ORGANISATION(".//div[6]/details/details-menu/a[4]"),
    NEW_PROJECT(".//div[6]/details/details-menu/a[5]");

    private final By by;

    CreationBarTabs(String xpath) {
        this.by = By.xpath(xpath);
    }

    public By getBy() {
        return by;
    }
}
