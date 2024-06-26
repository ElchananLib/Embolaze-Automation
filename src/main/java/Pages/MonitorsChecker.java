package Pages;

import org.openqa.selenium.WebDriver;
import java.util.Arrays;

public class MonitorsChecker extends BaseCategoryChecker {

    public MonitorsChecker(WebDriver driver) {
        super(driver);
    }

    public void checkMonitors() {
        checkCategory("Monitors", Arrays.asList(
                "Apple monitor 24",
                "Asus Full HD"
        ));
    }
}
