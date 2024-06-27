package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openHomePage() {
        driver.get("https://www.demoblaze.com");
        WebElement homeLink = driver.findElement(By.id("nava"));
        assert homeLink.isDisplayed() : "Home link is not displayed";
    }

    public void verifyMenuLinks() {
        driver.findElement(By.linkText("Home")).click();
        verifyPageLoad();

        driver.findElement(By.linkText("Cart")).click();
        verifyPageLoad();
    }

    private void verifyPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitTimes.MEDIUM_WAIT.getSeconds()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbodyid")));
    }

    public void checkCategories() {
        new PhonesChecker().checkPhonesCategory();
        new MonitorsChecker().checkMonitorsCategory();
        new LaptopsChecker().checkLaptopsCategory();
    }
}
