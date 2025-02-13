package org.counter.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.counter.utils.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CalenderPage extends CommonActions {

    @AndroidFindBy(accessibility = "OK")
    private WebElement okButton;
    @AndroidFindBy(accessibility = "Cancel")
    private WebElement cancelButton;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc,'15')]")
    private WebElement firstDate;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc,'16')]")
    private WebElement secondDate;

    public CalenderPage(WebDriver driver) {
        super(driver);
    }


    public void clickOnCalenderDate() {
        if (!getText(firstDate).contains("Today")) {
            click(firstDate);
        } else {
            click(secondDate);
        }
    }

    public void clickOnCalenderOKButton() {
        click(okButton);
    }

    public void clickOnCalenderCancelButton() {
        click(cancelButton);

    }


}
