package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {

    public HomePage() {
        System.setProperty("webdriver.chrome.driver", "/home/mefathim/ChromeDriver/chromedriver-linux64/chromedriver");
    }

    public static void main(String[] args) {
        new HomePage();

        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://www.demoblaze.com");

            PhonesChecker phonesChecker = new PhonesChecker(driver);
            phonesChecker.verifyTopMenuLinks();
            phonesChecker.checkPhones();

            LaptopsChecker laptopsChecker = new LaptopsChecker(driver);
            laptopsChecker.verifyTopMenuLinks();
            laptopsChecker.checkLaptops();

            MonitorsChecker monitorsChecker = new MonitorsChecker(driver);
            monitorsChecker.verifyTopMenuLinks();
            monitorsChecker.checkMonitors();

        } finally {
            driver.quit();
        }
    }
}
