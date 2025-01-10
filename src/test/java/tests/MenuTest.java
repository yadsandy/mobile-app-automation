package tests;

import org.example.app.pages.MenuPage;
import org.example.app.pages.SplashPage;
import org.example.app.utils.Feature;
import org.testng.annotations.Test;

import static org.example.app.utils.Constants.MENU;

public class MenuTest extends BaseTest {

    @Feature(MENU)
    @Test(description = "Verify menu options in VPN app")
    public void testMenuOptions() {
        MenuPage menuPage=new MenuPage();
        SplashPage splashPage=new SplashPage();
        splashPage.proceedToMainScreen();
        menuPage.clickOnMenu();
        menuPage.checkMenuList();
    }

}
