package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.app.pages.MainPage;
import org.example.app.pages.SplashPage;
import org.example.app.utils.Feature;
import org.testng.annotations.Test;

import static org.example.app.driver.MobileDriverHolder.getDriver;
import static org.example.app.utils.Constants.MAIN;

public class MainTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger();

    @Feature(MAIN)
    @Test(description = "Verify the VPN connection")
    public void testVPNConnection() {
        MainPage mainPage = new MainPage(getDriver());
        SplashPage splashPage = new SplashPage(getDriver());
        splashPage.proceedToMainScreen();
        logger.debug("go to main screen");
        mainPage.clickConnect();
        logger.debug("clicked on connect button");
        mainPage.checkOKAndClick();
        logger.debug("VPN is connected");
    }

}
