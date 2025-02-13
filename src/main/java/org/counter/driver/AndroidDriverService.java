package org.counter.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.io.File;

import static org.counter.utils.Constants.*;


public class AndroidDriverService implements MobileDriverService {
    private AndroidDriver androidDriver;

    @Override
    public void spinUpDriver(AppiumDriverLocalService appiumService) {
        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid(ANDROID_DEVICE_NAME)
                .setApp(new File(ANDROID_APP_FILE_PATH).getAbsolutePath())
                .setAppActivity(ANDROID_APP_ACTIVITY)
                .setNoReset(Boolean.parseBoolean(ANDROID_NO_RESET))
                .setFullReset(Boolean.parseBoolean(ANDROID_FULL_RESET))
                .autoGrantPermissions();

        androidDriver = new AndroidDriver(appiumService.getUrl(), options);
        androidDriver.manage().timeouts().implicitlyWait(APPIUM_DRIVER_TIMEOUT);
    }

    @Override
    public void closeDriver() {
        androidDriver.terminateApp(ANDROID_APP_PACKAGE);
    }

    @Override
    public AppiumDriver getDriver() {
        return androidDriver;
    }
}
