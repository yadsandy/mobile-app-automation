package tests;

import org.example.app.pages.MainPage;
import org.example.app.pages.SplashPage;
import org.example.app.utils.Feature;
import org.testng.annotations.Test;

import static org.example.app.utils.Constants.MAIN;

public class MainTest extends BaseTest {

    @Feature(MAIN)
    @Test(description = "Verify the VPN connection")
    public void testVPNConnection() {
        MainPage mainPage=new MainPage();
        SplashPage splashPage=new SplashPage();
        splashPage.proceedToMainScreen();
        mainPage.connectVPN();
    }

}
