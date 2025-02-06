package org.example.app.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.example.app.utils.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuPage extends CommonActions {

    private static final String APP_PACKAGE = "com.fast.free.unblock.secure.vpn";
    @AndroidFindBy(id = APP_PACKAGE + ":id/menu_left")
    private WebElement menuButton;
    @AndroidFindBy(id = APP_PACKAGE + ":id/menu_vip_profile_layout")
    private WebElement menuProfileLayout;
    @AndroidFindBy(id = APP_PACKAGE + ":id/menu_account")
    private WebElement menuAccount;
    @AndroidFindBy(id = APP_PACKAGE + ":id/menu_setting")
    private WebElement menuSetting;
    @AndroidFindBy(id = APP_PACKAGE + ":id/menu_app_filter")
    private WebElement menuAppFilter;
    @AndroidFindBy(id = APP_PACKAGE + ":id/menu_feedback")
    private WebElement menuFeedback;
    @AndroidFindBy(id = APP_PACKAGE + ":id/menu_share")
    private WebElement menuShare;
    @AndroidFindBy(id = APP_PACKAGE + ":id/purchase_layout")
    private WebElement menuPurchase;
    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnMenu() {
        clickOnElement(menuButton);
    }

    public void checkMenuList() {
        verticalSwipeFromBottomToTop();
        assertToCheckElementVisibility(menuProfileLayout, Boolean.TRUE);
        assertToCheckElementVisibility(menuAccount, Boolean.TRUE);
        assertToCheckElementVisibility(menuSetting, Boolean.TRUE);
        assertToCheckElementVisibility(menuAppFilter, Boolean.TRUE);
        assertToCheckElementVisibility(menuFeedback, Boolean.TRUE);
        assertToCheckElementVisibility(menuShare, Boolean.TRUE);
        assertToCheckElementVisibility(menuPurchase, Boolean.TRUE);
    }

}
