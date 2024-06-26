package Pages;

import org.openqa.selenium.WebDriver;
import java.util.Arrays;

public class PhonesChecker extends BaseCategoryChecker {

    public PhonesChecker(WebDriver driver) {
        super(driver);
    }

    public void checkPhones() {
        checkCategory("Phones", Arrays.asList(
                "Samsung galaxy s6",
                "Nokia lumia 1520",
                "Nexus 6",
                "Samsung galaxy s7",
                "Iphone 6 32gb",
                "Sony xperia z5",
                "HTC One M9"
        ));
    }
}
