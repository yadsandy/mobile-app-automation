package org.example.app.pages;

import io.appium.java_client.AppiumDriver;
import org.example.app.utils.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.example.app.utils.Constants.ANDROID_APP_PACKAGE;

public class MenuPage extends CommonActions {

    private static final String menuButton = ANDROID_APP_PACKAGE + ":id/menu_left";
    private static final String menuProfileLayout = ANDROID_APP_PACKAGE + ":id/menu_vip_profile_layout";
    private static final String menuAccount = ANDROID_APP_PACKAGE + ":id/menu_account";
    private static final String menuSetting = ANDROID_APP_PACKAGE + ":id/menu_setting";
    private static final String menuAppFilter = ANDROID_APP_PACKAGE + ":id/menu_app_filter";
    private static final String menuFeedback = ANDROID_APP_PACKAGE + ":id/menu_feedback";
    private static final String menuShare = ANDROID_APP_PACKAGE + ":id/menu_share";
    private static final String menuPurchase = ANDROID_APP_PACKAGE + ":id/purchase_layout";


    public MenuPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickOnMenu() {
        clickOnElement(By.id(menuButton));
    }

    public void checkMenuList() {
        verticalSwipeFromBottomToTop();
        assertToCheckElementVisibility(By.id(menuProfileLayout), Boolean.TRUE);
        assertToCheckElementVisibility(By.id(menuAccount), Boolean.TRUE);
        assertToCheckElementVisibility(By.id(menuSetting), Boolean.TRUE);
        assertToCheckElementVisibility(By.id(menuAppFilter), Boolean.TRUE);
        assertToCheckElementVisibility(By.id(menuFeedback), Boolean.TRUE);
        assertToCheckElementVisibility(By.id(menuShare), Boolean.TRUE);
        assertToCheckElementVisibility(By.id(menuPurchase), Boolean.TRUE);
    }

}
