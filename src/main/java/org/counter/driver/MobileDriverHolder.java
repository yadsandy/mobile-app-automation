package org.counter.driver;

import io.appium.java_client.AppiumDriver;

import java.security.InvalidParameterException;

import static org.counter.utils.Constants.*;


public class MobileDriverHolder {
    private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public static AppiumDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(AppiumDriver driver) {
        MobileDriverHolder.driver.set(driver);
    }

    public MobileDriverService getDriverService() {

        return switch (MOBILE_PLATFORM_NAME) {
            case ANDROID -> new AndroidDriverService();
            case IOS -> new IosDriverService();
            default -> throw new InvalidParameterException("Please use platform as '" + ANDROID + "' or '" + IOS + "'");
        };
    }

}
