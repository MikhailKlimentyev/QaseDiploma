package pages.base;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import utils.ElementUtils;

import static com.codeborne.selenide.Selenide.$;
import static models.Constants.EXPLICITLY_TIME_OUT;

@Log4j2
public abstract class AbstractPage {

    public abstract AbstractPage isPageOpened();

    public void isPageOpened(By locator, String pageName) {
        log.debug(String.format("Waiting for %s is opened", pageName));
        $(locator).waitUntil(Condition.visible, EXPLICITLY_TIME_OUT);
    }

    public void clickOnButton(By locator, String elementName) {
        log.info(String.format("Clicking on %s button", elementName));
        new ElementUtils().findVisibleElement(locator, EXPLICITLY_TIME_OUT).click();
    }

    public void enterText(By locator, String elementName, String text) {
        log.info(String.format("Entering '%s' text in %s field", text, elementName));
        new ElementUtils().findVisibleElement(locator, EXPLICITLY_TIME_OUT).sendKeys(text);
    }

    public boolean isElementDisplayed(By locator) {
        return new ElementUtils().findVisibleElement(locator, EXPLICITLY_TIME_OUT).isDisplayed();
    }

    public String getTextOfElement(By locator) {
        log.debug(String.format("Getting text for element with locator '%s'", locator));
        return new ElementUtils().findVisibleElement(locator, EXPLICITLY_TIME_OUT).getText();
    }
}
