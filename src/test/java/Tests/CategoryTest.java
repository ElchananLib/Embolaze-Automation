package Tests;

import Pages.DriverSingleton;
import Pages.PhonesChecker;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class CategoryTest {
    private static WebDriver driver;
    private static Phones phones;

    @BeforeClass
    public static void setUp() {
        driver = DriverSingleton.getDriver();
        phones = new Phones(driver);
    }

    @Test
    public void testPhonesCategory() {
        phones.navigateToPhones();
        assertTrue(phones.areProductsDisplayed());
    }

    @AfterClass
    public static void tearDown() {
        DriverSingleton.quitDriver();
    }exist
}
