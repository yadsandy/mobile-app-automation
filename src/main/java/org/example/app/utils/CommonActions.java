package org.example.app.utils;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.example.app.utils.Constants.ANDROID;
import static org.example.app.utils.Constants.MOBILE_PLATFORM_NAME;

public class CommonActions {
    public final WebDriver driver;
    public final WebDriverWait wait;

    public CommonActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void waitUntilElementVisible(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement scrollToElement(String elementText) {
        WebElement element;

        if (MOBILE_PLATFORM_NAME.equalsIgnoreCase(ANDROID)) {
            element = driver
                    .findElement(
                            AppiumBy.androidUIAutomator(
                                    "new UiScrollable(new UiSelector().scrollable(true))"
                                            + ".scrollIntoView(new UiSelector().text(\"" + elementText + "\"))"
                            )
                    );
        } else {
            element = driver.findElement(AppiumBy.iOSNsPredicateString("label == '" + elementText + "'"));
        }

        return element;
    }

    public void clickOnElement(By by) {
        if (checkElementVisibility(by)) {
            driver.findElement(by).click();
        }

    }

    public boolean checkElementVisibility(By by) {
        return !driver.findElements(by).isEmpty();
    }

    public void scrollAndTap(String elementText) {
        scrollToElement(elementText).click();
    }

    public void inputText(By by, String text) {
        waitUntilElementVisible(by);
        driver.findElement(by).sendKeys(text);
    }

    public void scrollAndInputText(String elementText, String text) {
        scrollToElement(elementText).sendKeys(text);
    }

    public String getAlertText() {
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }

    public void assertToCheckElementVisibility(By by, Boolean checkVisibility) {
        if (checkVisibility) {
            Assert.assertTrue(checkElementVisibility(by));
        } else {
            Assert.assertFalse(checkElementVisibility(by));
        }
    }


}
