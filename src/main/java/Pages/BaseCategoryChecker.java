package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BaseCategoryChecker extends TopMenuChecker {

    public BaseCategoryChecker(WebDriver driver) {
        super(driver);
    }

    protected void checkCategory(String category, List<String> expectedProducts) {
        WebElement listGroupDiv = driver.findElement(By.xpath("//div[@class='col-lg-3']//div[@class='list-group']"));
        WebElement categoryLink = listGroupDiv.findElement(By.xpath(".//a[text()='" + category + "']"));

        categoryLink.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("card")));

        List<WebElement> productElements = driver.findElements(By.className("hrefch"));

        boolean allProductsDisplayed = true;
        for (String product : expectedProducts) {
            boolean productDisplayed = productElements.stream()
                    .anyMatch(element -> element.getText().contains(product));
            if (!productDisplayed) {
                allProductsDisplayed = false;
                System.out.println("Product not displayed in " + category + ": " + product);
            }
        }

        for (WebElement productElement : productElements) {
            String productName = productElement.getText();
            if (!expectedProducts.contains(productName)) {
                allProductsDisplayed = false;
                System.out.println("Unexpected product found in " + category + ": " + productName);
            }
        }

        System.out.println("Checked category: " + category);
        System.out.println("Current URL: " + driver.getCurrentUrl());

        if (allProductsDisplayed) {
            System.out.println("Test Passed: All expected products are displayed in " + category + ", no other products found.");
        } else {
            System.out.println("Test Failed: Not all expected products are displayed in " + category + ".");
        }
    }
}
