package Tests;

import Pages.DriverSingleton;
import Pages.HomePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class HomePageTest {
    private static WebDriver driver;
    private static HomePage homePage;

    @BeforeAll
    public static void setUp() {
        driver = DriverSingleton.getDriver();
        homePage = new HomePage(driver);
    }

    @Test
    public void testHomePage() {
        homePage.openHomePage();
        homePage.verifyMenuLinks();
        homePage.checkCategories();
    }

    @AfterAll
    public static void tearDown() {
        DriverSingleton.quitDriver();
    }
}
