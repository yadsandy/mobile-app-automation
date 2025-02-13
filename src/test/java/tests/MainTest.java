package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.counter.pages.CalenderPage;
import org.counter.pages.HomePage;
import org.counter.utils.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.counter.driver.MobileDriverHolder.getDriver;
import static org.counter.utils.Constants.HOME;


public class MainTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger();

    @Feature(HOME)
    @Test(description = "Verify Counter App functionality.")
    public void testCounterAppFlow() {
        HomePage homePage = new HomePage(getDriver());
        CalenderPage calender = new CalenderPage(getDriver());
        Assert.assertTrue(homePage.checkHomePageElements());
        logger.debug("homepage elements are verified");
        String valueOfCountOnAppLaunch = homePage.getCountOnAppLaunch();
        Assert.assertEquals(valueOfCountOnAppLaunch, "0");
        logger.debug("verified counter displays 0 on app launch.");
        String valueOfCountAfterIncrement = homePage.clickIncrementAndGetCount();
        Assert.assertEquals(valueOfCountAfterIncrement, "1");
        logger.debug("verified counter displays 1 after increment.");
        String valueOfCountAfterDecrement = homePage.clickDecrementAndGetCount();
        Assert.assertEquals(valueOfCountAfterDecrement, "-1");
        logger.debug("verified counter displays -1 after decrement.");
        String valueOfCountAfterReset = homePage.clickResetAndGetCount();
        Assert.assertEquals(valueOfCountAfterReset, "0");
        logger.debug("verified counter displays 0 after reset.");
        homePage.clickOnPickADateButton();
        logger.debug("clicked on pick a date button.");
        calender.clickOnCalenderDate();
        logger.debug("clicked on calender date.");
        calender.clickOnCalenderCancelButton();
        logger.debug("clicked on calender cancel button.");
        Assert.assertFalse(homePage.checkSelectedLabel());
        logger.debug("verified selected label when cancelled the date selection from calender.");
        homePage.clickOnPickADateButton();
        logger.debug("clicked on pick a date button.");
        calender.clickOnCalenderDate();
        logger.debug("clicked on calender date.");
        calender.clickOnCalenderOKButton();
        logger.debug("clicked on calender ok button.");
        Assert.assertTrue(homePage.checkSelectedLabel());
        logger.debug("verified selected label when the date is selected from calender.");


    }

}
