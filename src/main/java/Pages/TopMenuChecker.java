package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TopMenuChecker {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public TopMenuChecker(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void verifySignUpLink() {
        WebElement signUpLink = driver.findElement(By.id("signin2"));
        signUpLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModal")));
        closeModal();
        System.out.println("Sign Up link verified successfully.");
    }

    public void verifyLoginLink() {
        WebElement loginLink = driver.findElement(By.id("login2"));
        loginLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModal")));
        closeModal();
        System.out.println("Login link verified successfully.");
    }

    public void verifyAboutUsLink() {
        WebElement aboutUsLink = driver.findElement(By.xpath("//a[contains(text(), 'About us')]"));
        aboutUsLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("videoModal")));
        closeModal();
        System.out.println("About Us link verified successfully.");
    }

    public void verifyContactLink() {
        WebElement contactLink = driver.findElement(By.xpath("//a[contains(text(), 'Contact')]"));
        contactLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("exampleModal")));
        closeModal();
        System.out.println("Contact link verified successfully.");
    }

    public void verifyCartLink() {
        WebElement cartLink = driver.findElement(By.id("cartur"));
        cartLink.click();
        wait.until(ExpectedConditions.urlContains("cart.html"));
        System.out.println("Cart link verified successfully.");
    }

    public void verifyHomeLink() {
        WebElement homeLink = driver.findElement(By.xpath("//a[contains(text(), 'Home')]"));
        homeLink.click();
        wait.until(ExpectedConditions.urlContains("index.html"));
        System.out.println("Home link verified successfully.");
    }

    private void closeModal() {
        try {
            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-secondary' and @data-dismiss='modal']")));
            closeButton.click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, 'modal show')]")));
            Thread.sleep(1000); // Ensure smooth execution
        } catch (Exception e) {
            System.out.println("Failed to close the modal. Error: " + e.getMessage());
            dismissBackdrop();
        }
    }

    private void dismissBackdrop() {
        try {
            WebElement backdrop = driver.findElement(By.className("modal-backdrop"));
            Actions actions = new Actions(driver);
            actions.moveToElement(backdrop, 0, 0).click().perform();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-backdrop")));
        } catch (Exception e) {
            System.out.println("Failed to dismiss the backdrop. Error: " + e.getMessage());
        }
    }

    public void verifyTopMenuLinks() {
        verifySignUpLink();
        verifyLoginLink();
        verifyAboutUsLink();
        verifyContactLink();
        verifyCartLink();
        verifyHomeLink();
    }
}
