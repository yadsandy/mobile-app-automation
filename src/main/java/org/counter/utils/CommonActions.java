package org.counter.utils;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static org.counter.utils.Constants.APPIUM_DRIVER_TIMEOUT;

public class CommonActions {
    WebDriver driver;

    public CommonActions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, APPIUM_DRIVER_TIMEOUT), this);
    }

    protected void click(WebElement element) {
        element.click();
    }

    public boolean checkElementVisibility(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected String getText(WebElement webElement) {
        return webElement.getText();
    }

    protected String getTextUsingAttributeContentDesc(WebElement webElement) {
        return webElement.getDomAttribute("content-desc");
    }


}

