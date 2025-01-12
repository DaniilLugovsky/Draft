package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Text{
   private UIElement uiElement;

    public Text(WebDriver driver, By by) {
        this.uiElement = new UIElement(driver,by);
    }

    public String getText() {
        return uiElement.getText();
    }
}
