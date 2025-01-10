package org.example.app.pages;

import io.appium.java_client.AppiumDriver;
import org.example.app.utils.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.example.app.utils.Constants.ANDROID_APP_PACKAGE;

public class MainPage extends CommonActions {


    private static final String connectButton = ANDROID_APP_PACKAGE + ":id/btn_connect_desc";
    private static final String okButton = "android:id/button1";


    public MainPage(AppiumDriver driver) {
        super(driver);
    }

    private void checkOKAndClick() {
        if (checkElementVisibility(By.id(okButton))) {
            clickOnElement(By.id(okButton));
        }
    }

    private void clickConnect() {
        clickOnElement(By.id(connectButton));

    }

    public void connectVPN() {
        clickConnect();
        checkOKAndClick();
    }

}
