package ru.geekbrains.lesson6.pages;

import org.openqa.selenium.WebDriver;
import ru.geekbrains.lesson6.base.BaseView;
import ru.geekbrains.lesson6.views.CreationBar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage extends BaseView {

    private CreationBar creationBar;

    public HomePage(WebDriver driver) {
        super(driver);
        this.creationBar = new CreationBar(driver);
    }

    public void checkUrl(String url) {
        assertEquals(driver.getCurrentUrl(), url);
    }

    public CreationBar clickCreationBar() {
        return creationBar;
    }
}