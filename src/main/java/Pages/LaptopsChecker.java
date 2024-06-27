package Pages;

import org.openqa.selenium.By; // Import the By class
import java.util.Arrays;

public class LaptopsChecker extends BaseCategoryChecker {
    public void checkLaptopsCategory() {
        driver.findElement(By.linkText("Laptops")).click();
        verifyCategoryItemsLoaded("Laptops", Arrays.asList(
                "Sony vaio i5",
                "Sony vaio i7",
                "MacBook air",
                "Dell i7 8gb",
                "2017 Dell 15.6 Inch",
                "MacBook Pro"
        ));
    }
}
