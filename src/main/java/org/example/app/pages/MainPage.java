package org.example.app.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.example.app.utils.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPage extends CommonActions {
    @AndroidFindBy(id = "com.fast.free.unblock.secure.vpn:id/btn_connect_desc")
    private WebElement connectButton;
    @AndroidFindBy(id = "android:id/button1")
    private WebElement okButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }


    public void checkOKAndClick() {
        if (checkElementVisibility(okButton)) {
            clickOnElement(okButton);
        }
    }

    public void clickConnect() {
        clickOnElement(connectButton);

    }


}
