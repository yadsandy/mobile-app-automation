package org.example.app.driver;

import java.security.InvalidParameterException;

import static org.example.app.utils.Constants.*;

public class MobileDriverFactory {
    public MobileDriverService getDriverService() {

        return switch (MOBILE_PLATFORM_NAME) {
            case ANDROID -> new AndroidDriverService();
            case IOS -> new IosDriverService();
            default -> throw new InvalidParameterException("Please use platform as '" + ANDROID + "' or '" + IOS + "'");
        };
    }
}
