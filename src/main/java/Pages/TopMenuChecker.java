package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration; // Import Duration from java.time

public class TopMenuChecker {
    private WebDriver driver;

    public TopMenuChecker(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyMenuLinks() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitTimes.SHORT_WAIT.getSeconds()));

        // Sign Up
        WebElement signUpLink = driver.findElement(By.id("signin2"));
        wait.until(ExpectedConditions.elementToBeClickable(signUpLink)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModal")));

        // Log In
        WebElement logInLink = driver.findElement(By.id("login2"));
        wait.until(ExpectedConditions.elementToBeClickable(logInLink)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModal")));

        // Home
        WebElement homeLink = driver.findElement(By.linkText("Home"));
        wait.until(ExpectedConditions.elementToBeClickable(homeLink)).click();

        // Cart
        WebElement cartLink = driver.findElement(By.id("cartur"));
        wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
    }
}
