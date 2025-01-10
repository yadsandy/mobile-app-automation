package org.example.app.utils;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Ordering;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.PowerACState;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import static org.example.app.driver.MobileDriverHolder.getDriver;
import static org.example.app.utils.Constants.*;

public class CommonActions {

    public void waitUntilElementVisible(By by) {
        new WebDriverWait(getDriver(),APPIUM_DRIVER_TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement scrollToElement(String elementText) {
        WebElement element;

        if (MOBILE_PLATFORM_NAME.equalsIgnoreCase(ANDROID)) {
            element = getDriver()
                    .findElement(
                            AppiumBy.androidUIAutomator(
                                    "new UiScrollable(new UiSelector().scrollable(true))"
                                            + ".scrollIntoView(new UiSelector().text(\"" + elementText + "\"))"
                            )
                    );
        } else {
            element = getDriver().findElement(AppiumBy.iOSNsPredicateString("label == '" + elementText + "'"));
        }

        return element;
    }

    public void clickOnElement(By by) {
        if (checkElementVisibility(by)) {
            getDriver().findElement(by).click();
        }

    }

    public boolean checkElementVisibility(By by) {
        return !getDriver().findElements(by).isEmpty();
    }

    public void scrollAndTap(String elementText) {
        scrollToElement(elementText).click();
    }

    public void inputText(By by, String text) {
        waitUntilElementVisible(by);
        getDriver().findElement(by).sendKeys(text);
    }

    public void scrollAndInputText(String elementText, String text) {
        scrollToElement(elementText).sendKeys(text);
    }

    public String getAlertText() {
        new WebDriverWait(getDriver(), APPIUM_DRIVER_TIMEOUT).until(ExpectedConditions.alertIsPresent());
        return getDriver().switchTo().alert().getText();
    }

    public void assertToCheckElementVisibility(By by, Boolean checkVisibility) {
        if (checkVisibility) {
            Assert.assertTrue(checkElementVisibility(by));
        } else {
            Assert.assertFalse(checkElementVisibility(by));
        }
    }


    protected String getText(By by) {
        return getDriver().findElement(by).getText();
    }

    protected boolean isElementDisplayed(By by) {
        return getDriver().findElement(by).isDisplayed();
    }

    protected void doClear(By by) {
        getDriver().findElement(by).clear();
    }


    protected void moveMouseToElement(By by, int x_offset, int y_offset) {
        new Actions(getDriver())
                .moveToElement(getDriver().findElement(by), x_offset, y_offset)
                .perform();
    }

    protected void doubleClickOnElement(By by) {
        new Actions(getDriver())
                .moveToElement(getDriver().findElement(by))
                .doubleClick()
                .perform();
    }


    protected void enterValueAndPressEnter(By by, String value) {

        getDriver().findElement(by).sendKeys(value, Keys.ENTER);
    }

    public void verticalSwipeFromTopToBottom() {
            int startX = getDriver().manage().window().getSize().getWidth() / 2;
            int startY = (int) (getDriver().manage().window().getSize().getHeight() * 0.70);
            int endY = (int) (getDriver().manage().window().getSize().getHeight() * 0.2);
            PointerInput indexFinger = new PointerInput(PointerInput.Kind.TOUCH, "indexFinger");
            Sequence scroll = new Sequence(indexFinger, 1);
            scroll.addAction(indexFinger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, endY));
            scroll.addAction(indexFinger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            Duration pauseDuration = Duration.ofSeconds(1);
            scroll.addAction(new Pause(indexFinger, pauseDuration));
            Duration scrollingSpeedDuration = Duration.ofSeconds(2);
            scroll.addAction(indexFinger.createPointerMove(scrollingSpeedDuration, PointerInput.Origin.viewport(), startX, startY));
            scroll.addAction(indexFinger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            getDriver().perform(Collections.singletonList(scroll));

    }

    public void verticalSwipeFromBottomToTop() {
            int startX = getDriver().manage().window().getSize().getWidth() / 2;
            int startY = (int) (getDriver().manage().window().getSize().getHeight() * 0.70);
            int endY = (int) (getDriver().manage().window().getSize().getHeight() * 0.20);
            Point source = new Point(startX, startY);
            Point target = new Point(startX, endY);
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), source.x, source.y));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(500),
                    PointerInput.Origin.viewport(), target.x, target.y));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            getDriver().perform(List.of(swipe));
    }

}

