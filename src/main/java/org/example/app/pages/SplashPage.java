package org.example.app.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.example.app.utils.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SplashPage extends CommonActions {

    @AndroidFindBy(id = "com.fast.free.unblock.secure.vpn:id/iv_close")
    private WebElement closeButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Test Ad']")
    private WebElement adsLabel;
    public SplashPage(WebDriver driver) {
        super(driver);
    }

    public void checkClosePopUpAndClick() {
        clickOnElement(closeButton);
    }

    public void checkAdsAndClose() {
        clickOnElement(adsLabel);
    }

    public void proceedToMainScreen() {
        if (checkElementVisibility(closeButton)) {
            checkClosePopUpAndClick();
        } else {
            checkAdsAndClose();
        }
    }
}
