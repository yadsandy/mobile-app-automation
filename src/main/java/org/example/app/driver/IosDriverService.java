package org.example.app.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.io.File;

import static org.example.app.utils.Constants.*;

public class IosDriverService implements MobileDriverService {
    private IOSDriver iosDriver;

    @Override
    public void spinUpDriver(AppiumDriverLocalService appiumService) {
        XCUITestOptions options = new XCUITestOptions()
                .setDeviceName(IOS_DEVICE_NAME)
                .setPlatformVersion(IOS_PLATFORM_VERSION)
                .setApp(new File(IOS_APP_FILE_PATH).getAbsolutePath())
                .setNoReset(Boolean.parseBoolean(IOS_NO_RESET))
                .setFullReset(Boolean.parseBoolean(IOS_FULL_RESET))
                .autoAcceptAlerts();

        iosDriver = new IOSDriver(appiumService.getUrl(), options);
        iosDriver.manage().timeouts().implicitlyWait(APPIUM_DRIVER_TIMEOUT);
    }

    @Override
    public void closeDriver() {
        iosDriver.quit();
    }

    @Override
    public AppiumDriver getDriver() {
        return iosDriver;
    }
}
