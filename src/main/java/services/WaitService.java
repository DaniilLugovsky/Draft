package services;

import configuration.ReadProperties;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitService {
    private WebDriverWait wait;
    private WebDriver driver;

    public WaitService(WebDriver driver, Duration duration) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, duration);
    }

    public WaitService(WebDriver driver) {
        this(driver, Duration.ofSeconds(ReadProperties.timeout()));
    }

    public WebElement elementToBeClickable(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public WebElement waitVisibilityOf(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement presenceOfElementLocated(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitVisibilityOf(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public Boolean invisibilityOf(WebElement webElement) {
        return wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    public Boolean invisibilityOf(By by) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public Alert alertIsPresent() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public List<WebElement> visibilityOfAllElementsLocatedBy(By by) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }


    public WebElement fluentWaitForElement(By by) {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(50))
                .ignoring(NoSuchElementException.class);

        return fluentWait.until(driver -> driver.findElement(by));
    }

    public Boolean fluentWaitForInvisibility(By by) {
        FluentWait<WebDriver> fluent = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(50))
                .ignoring(RuntimeException.class);

        return (Boolean) fluent.until(driver -> driver.findElements(by).size() == 0 ? true : new RuntimeException());
    }
}