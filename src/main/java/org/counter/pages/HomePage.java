package org.counter.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.counter.utils.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage extends CommonActions {

    @AndroidFindBy(accessibility = "Counter App")
    private static WebElement counterAppLabel;
    @AndroidFindBy(accessibility = "Current Value:")
    private static WebElement currentValueLabel;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Current Value:']/following-sibling::android.view.View")
    private static WebElement counter;
    @AndroidFindBy(accessibility = "+1")
    private static WebElement addOneCounter;
    @AndroidFindBy(accessibility = "-2")
    private static WebElement subtractTwoCounter;
    @AndroidFindBy(accessibility = "Reset")
    private static WebElement reset;
    @AndroidFindBy(accessibility = "Pick a Date")
    private static WebElement pickADateButton;
    @AndroidFindBy(accessibility = "Selected")
    private static WebElement selectedLabel;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Selected'])[2]")
    private static WebElement selectedToastMessage;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public boolean checkHomePageElements() {
        // Check visibility of each element
        if (!checkElementVisibility(counterAppLabel)) return false;
        if (!checkElementVisibility(currentValueLabel)) return false;
        if (!checkElementVisibility(counter)) return false;
        if (!checkElementVisibility(addOneCounter)) return false;
        if (!checkElementVisibility(subtractTwoCounter)) return false;
        if (!checkElementVisibility(reset)) return false;
        return checkElementVisibility(pickADateButton);
    }

    public String getCountOnAppLaunch() {
        return getTextUsingAttributeContentDesc(counter);
    }

    public String clickIncrementAndGetCount() {
        click(addOneCounter);
        return getTextUsingAttributeContentDesc(counter);
    }

    public String clickDecrementAndGetCount() {
        click(subtractTwoCounter);
        return getTextUsingAttributeContentDesc(counter);
    }

    public String clickResetAndGetCount() {
        click(reset);
        return getTextUsingAttributeContentDesc(counter);
    }

    public void clickOnPickADateButton() {
        click(pickADateButton);
    }

    public boolean checkSelectedLabel() {
        if (!checkElementVisibility(selectedLabel)) return false;
        return checkElementVisibility(selectedToastMessage);
    }


}
