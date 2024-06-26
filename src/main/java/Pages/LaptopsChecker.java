package Pages;

import org.openqa.selenium.WebDriver;
import java.util.Arrays;

public class LaptopsChecker extends BaseCategoryChecker {

    public LaptopsChecker(WebDriver driver) {
        super(driver);
    }

    public void checkLaptops() {
        checkCategory("Laptops", Arrays.asList(
                "Sony vaio i5",
                "Sony vaio i7",
                "MacBook air",
                "Dell i7 8gb",
                "2017 Dell 15.6 Inch",
                "MacBook Pro"
        ));
    }
}
