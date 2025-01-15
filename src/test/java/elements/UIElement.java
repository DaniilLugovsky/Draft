package elements;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import services.WaitService;

import java.util.ArrayList;
import java.util.List;

public class UIElement implements WebElement {
    private WaitService waitService;
    private WebElement webElement;
    private WebDriver driver;

    private UIElement(WebDriver driver) {
        this.driver = driver;
        waitService = new WaitService(driver);
    }

    public UIElement(WebDriver driver, By by) {
        this(driver);
        webElement = waitService.presenceOfElementLocated(by);
    }

    public UIElement(WebDriver driver, WebElement webElement) {
        this(driver);
        this.webElement = webElement;
    }

    @Override
    public void click() {
        try {
            webElement.click();
        } catch (ElementNotInteractableException ex) {
            moveToElement();
            try {
                webElement.click();
            } catch (ElementClickInterceptedException ex1) {
                Actions actions = new Actions(driver);
                try {
                    actions.click(webElement).build().perform();
                } catch (ElementClickInterceptedException ex2) {
                    jsClick();
                }
            }
        }
    }

    @Override
    public void submit() {
        webElement.submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        webElement.sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        webElement.clear();
    }

    @Override
    public String getTagName() {
        return webElement.getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return webElement.getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return webElement.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return webElement.isEnabled();
    }

    @Override
    public String getText() {
        return webElement.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return webElement.findElements(by);
    }

    public List<UIElement> findUIElements(By by) {
        ArrayList<UIElement> list = new ArrayList<>();
        for (WebElement element : webElement.findElements(by)) {
            list.add(new UIElement(driver, element));
        }
        return list;
    }

    @Override
    public UIElement findElement(By by) {
        return new UIElement(driver, webElement.findElement(by));
    }

    public UIElement findUIElement(By by) {
        return new UIElement(driver, webElement.findElement(by));
    }

    @Override
    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return webElement.getLocation();
    }

    @Override
    public Dimension getSize() {
        return webElement.getSize();
    }

    @Override
    public Rectangle getRect() {
        return webElement.getRect();
    }

    @Override
    public String getCssValue(String propertyName) {
        return webElement.getCssValue(propertyName);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return webElement.getScreenshotAs(target);
    }

    public void moveToElement() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    public void jsClick() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);
    }

    public UIElement getParentElement() {
        return new UIElement(driver, webElement.findElement(By.xpath("./..")));
    }
}