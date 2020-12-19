package elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utils.ElementUtils;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static models.Constants.EXPLICITLY_TIME_OUT;

public abstract class Element {

    By locator;
    String label;

    public Element(By locator, String label) {
        this.locator = locator;
        this.label = label;
    }

    void write(String text) {
        new ElementUtils().findVisibleElement(locator, EXPLICITLY_TIME_OUT).sendKeys(text);
    }

    void writeViaJs(String text) {
        SelenideElement visibleElement = new ElementUtils().findVisibleElement(locator, EXPLICITLY_TIME_OUT);
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].CodeMirror.setValue('" + text + "');",
                visibleElement);
    }
}
