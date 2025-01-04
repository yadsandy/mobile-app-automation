package tests;

import org.example.app.utils.Feature;
import org.testng.annotations.Test;

import static org.example.app.utils.Constants.MAIN;

public class MainTest extends BaseTest {

    @Feature(MAIN)
    @Test(description = "Verify the VPN connection")
    public void testVPNConnection() {
        screen().getSplashPage().proceedToMainScreen();
        screen().getMainPage().connectVPN();
    }

}
