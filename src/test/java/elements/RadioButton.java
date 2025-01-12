package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class RadioButton {
    private List<UIElement> uiElementsList;

    public RadioButton(WebDriver driver, By by) {
        uiElementsList = new ArrayList<>();

        for (WebElement element : driver.findElements(by)){
            UIElement uiElement = new UIElement(driver, element);
            uiElementsList.add(uiElement);
        }
    }

    public void selectByIndex(int index) {
        if (index >= 0 && index < uiElementsList.size()) {
            uiElementsList.get(index).click();
        } else {
            throw new IndexOutOfBoundsException("Индекс больше размера колекции");
        }
    }


}
