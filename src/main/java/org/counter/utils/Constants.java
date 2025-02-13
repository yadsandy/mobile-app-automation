package org.counter.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;

import static org.counter.utils.PropertyReader.getConfigValue;

public class Constants {
    // Appium Constants
    public static final String APPIUM_SERVER_IP = getConfigValue("appium_server_ip");
    public static final int APPIUM_SERVER_PORT = Integer.parseInt(getConfigValue("appium_server_port"));
    public static final Duration APPIUM_DRIVER_TIMEOUT = Duration.ofSeconds(
            Long.parseLong(getConfigValue("appium_driver_timeout_in_seconds"))
    );
    // Android Constants
    public static final String ANDROID = "android";
    public static final String ANDROID_DEVICE_NAME = getConfigValue("android_device_name");
    public static final String ANDROID_APP_FILE_PATH = getConfigValue("android_app_file_path");
    public static final String ANDROID_APP_PACKAGE = getConfigValue("android_app_package");
    public static final String ANDROID_APP_ACTIVITY = getConfigValue("android_app_activity");
    public static final String ANDROID_NO_RESET = getConfigValue("android_no_reset");
    public static final String ANDROID_FULL_RESET = getConfigValue("android_full_reset");
    // iOS Constants
    public static final String IOS = "ios";
    public static final String IOS_DEVICE_NAME = getConfigValue("ios_device_name");
    public static final String IOS_APP_FILE_PATH = getConfigValue("ios_app_file_path");
    public static final String IOS_PLATFORM_VERSION = getConfigValue("ios_platform_version");
    public static final String IOS_NO_RESET = getConfigValue("ios_no_reset");
    public static final String IOS_FULL_RESET = getConfigValue("ios_full_reset");
    //Other Constants
    public static final String HOME = "HOME PAGE";

    private final static Logger logger = LogManager.getLogger();
    public static final String MOBILE_PLATFORM_NAME = getPlatformName();

    private static String getPlatformName() {
        String platformNameFromPomXml = System.getProperty("platform");
        String platformName;
        if (platformNameFromPomXml != null)
            platformName = platformNameFromPomXml;
        else {
            logger.warn("The Maven Profile is missing the platform configuration.");
            logger.warn("The default platform '{}' will be enabled for this run.", ANDROID);
            platformName = ANDROID;
        }

        return platformName.toLowerCase();
    }
}
