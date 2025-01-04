package tests;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.app.driver.MobileDriverFactory;
import org.example.app.driver.MobileDriverService;
import org.example.app.pages.PageSelector;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.time.Duration;

import static org.example.app.driver.MobileDriverHolder.getDriver;
import static org.example.app.driver.MobileDriverHolder.setDriver;
import static org.example.app.utils.Constants.MOBILE_PLATFORM_NAME;

@Listeners(org.example.app.utils.TestListener.class)
public class BaseTest {
    private final MobileDriverService driverService = new MobileDriverFactory().getDriverService();
    private final Logger logger = LogManager.getLogger();
    private AppiumDriverLocalService appiumService;

    @BeforeSuite
    public void oneTimeSetup() {
        logger.debug("Test execution platform: {}", MOBILE_PLATFORM_NAME);
    }

    @BeforeMethod
    public void openApp() {
        appiumService = driverService.startAppiumService();
        driverService.spinUpDriver(appiumService);
        setDriver(driverService.getDriver());
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public PageSelector screen() {
        return new PageSelector(getDriver());
    }

    @AfterMethod
    public void closeApp() {
        driverService.closeDriver();
        driverService.stopAppiumService(appiumService);
    }
}
