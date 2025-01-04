package org.example.app.pages;

import org.example.app.utils.CommonActions;
import org.openqa.selenium.WebDriver;

public class PageSelector extends CommonActions {
    public PageSelector(WebDriver driver) {
        super(driver);
    }

    public MainPage getMainPage() {
        return new MainPage(driver);
    }

    public MenuPage getMenuPage() {
        return new MenuPage(driver);
    }

    public SplashPage getSplashPage() {
        return new SplashPage(driver);
    }
}
