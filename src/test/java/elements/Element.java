package elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utils.ElementUtils;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static models.Constants.EXPLICITLY_WAIT_TIME_OUT;

public abstract class Element {

    public By locator;
    public String label;

    public Element(String label) {
        this.label = label;
    }

    public Element(By locator, String label) {
        this.locator = locator;
        this.label = label;
    }

    void write(String text) {
        new ElementUtils().findVisibleElement(locator, EXPLICITLY_WAIT_TIME_OUT).sendKeys(text);
    }

    void writeViaJs(String text) {
        SelenideElement visibleElement = new ElementUtils().findVisibleElement(locator, EXPLICITLY_WAIT_TIME_OUT);
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].CodeMirror.setValue('" + text + "');",
                visibleElement);
    }

    void set(String text) {
        new ElementUtils().findVisibleElement(locator, EXPLICITLY_WAIT_TIME_OUT).setValue(text);
    }

    void enter(String text) {
        new ElementUtils().findVisibleElement(locator, EXPLICITLY_WAIT_TIME_OUT).setValue(text).pressEnter();
    }
}
