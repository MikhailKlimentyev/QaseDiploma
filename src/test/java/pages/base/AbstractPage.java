package pages.base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public abstract class AbstractPage {

    public abstract AbstractPage isPageOpened();

    public void isPageOpened(By locator, String pageName) {
        log.debug(String.format("Waiting for %s is opened", pageName));
        $(locator).waitUntil(Condition.visible, 14000);
    }

    public void clickOnButton(By locator, String elementName) {
        log.info(String.format("Clicking on %s button", elementName));
        $(locator).click();
    }

    public void enterText(By locator, String elementName, String text) {
        log.info(String.format("Entering '%s' text in %s field", text, elementName));
        $(locator).sendKeys(text);
    }

    public boolean isElementDisplayed(By locator) {
        return findElement(locator).isDisplayed();
    }

    public String getTextOfElement(By locator) {
        log.debug(String.format("Getting text for element with locator '%s'", locator));
        return findElement(locator).getText();
    }

    private SelenideElement findElement(By locator) {
        log.debug(String.format("Waiting for element with locator '%s' is visible", locator));
        return $(locator).waitUntil(Condition.visible, 14000);
    }
}
