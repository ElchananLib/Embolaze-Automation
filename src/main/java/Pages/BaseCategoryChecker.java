package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseCategoryChecker {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BaseCategoryChecker() {
        this.driver = DriverSingleton.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(WaitTimes.MEDIUM_WAIT.getSeconds()));
    }

    public void verifyCategoryItemsLoaded(String category, List<String> expectedItems) {
        List<WebElement> items = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#tbodyid .card-title a")));
        assert items.size() == expectedItems.size() : "Expected items count does not match for category: " + category;

        for (WebElement item : items) {
            String itemName = item.getText();
            assert expectedItems.contains(itemName) : "Unexpected item found: " + itemName;
        }
    }
}
