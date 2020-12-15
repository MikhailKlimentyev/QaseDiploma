package elements;

import org.openqa.selenium.By;
import utils.ElementUtils;

import static models.Constants.TIME_OUT;

public abstract class Element {

    By locator;
    String label;

    public Element(By locator, String label) {
        this.locator = locator;
        this.label = label;
    }

    void write(String text) {
        new ElementUtils().findVisibleElement(locator, TIME_OUT).sendKeys(text);
    }
}
