package Pages;

import java.util.Arrays;
import org.openqa.selenium.By;

public class PhonesChecker extends BaseCategoryChecker {
    public void checkPhonesCategory() {
        driver.findElement(By.linkText("Phones")).click();
        verifyCategoryItemsLoaded("Phones", Arrays.asList(
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
