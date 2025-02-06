package tests;

import org.example.app.pages.MenuPage;
import org.example.app.pages.SplashPage;
import org.example.app.utils.Feature;
import org.testng.annotations.Test;

import static org.example.app.driver.MobileDriverHolder.getDriver;
import static org.example.app.utils.Constants.MENU;

public class MenuTest extends BaseTest {

    @Feature(MENU)
    @Test(description = "Verify menu options in VPN app")
    public void testMenuOptions() {
        MenuPage menuPage = new MenuPage(getDriver());
        SplashPage splashPage = new SplashPage(getDriver());
        splashPage.proceedToMainScreen();
        menuPage.clickOnMenu();
        menuPage.checkMenuList();
    }

}
