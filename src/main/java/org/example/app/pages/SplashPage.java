package org.example.app.pages;

import io.appium.java_client.AppiumDriver;
import org.example.app.utils.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.example.app.utils.Constants.ANDROID_APP_PACKAGE;

public class SplashPage extends CommonActions {


    private static final String closeButton = ANDROID_APP_PACKAGE + ":id/iv_close";
    private static final String adsLabel = "//android.widget.TextView[@text='Test Ad']";


    public void checkClosePopUpAndClick() {
        clickOnElement(By.id(closeButton));
    }

    public void checkAdsAndClose() {
        clickOnElement(By.id(adsLabel));
    }

    public void proceedToMainScreen() {
        if (checkElementVisibility(By.id(closeButton))) {
            checkClosePopUpAndClick();
        } else {
            checkAdsAndClose();
        }
    }
}
