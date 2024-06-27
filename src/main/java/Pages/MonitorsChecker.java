package Pages;

import org.openqa.selenium.By; // Import the By class
import java.util.Arrays;

public class MonitorsChecker extends BaseCategoryChecker {
    public void checkMonitorsCategory() {
        driver.findElement(By.linkText("Monitors")).click();
        verifyCategoryItemsLoaded("Monitors", Arrays.asList(
                "Apple monitor 24",
                "Asus Full HD"
        ));
    }
}
