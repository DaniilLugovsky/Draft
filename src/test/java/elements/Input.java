package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input {
    private UIElement uiElement;

    public Input(WebDriver driver, By by) {
        this.uiElement = new UIElement(driver, by);
    }

    public void write(String text) {
        uiElement.sendKeys(text);
    }

    public void clearAndWrite(String text) {
        uiElement.clear();
        write(text);
    }

    public void clickAndWrite(String text) {
        uiElement.click();
        write(text);
    }

    public String getText() {
        return uiElement.getText();
    }
}