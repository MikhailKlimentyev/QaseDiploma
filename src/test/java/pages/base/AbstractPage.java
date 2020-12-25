package pages.base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utils.ElementUtils;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static models.Constants.EXPLICITLY_WAIT_TIME_OUT;

@Log4j2
public abstract class AbstractPage {

    public abstract AbstractPage isPageOpened();

    public void isPageOpened(By locator, String pageName) {
        log.debug(String.format("Waiting for %s is opened", pageName));
        $(locator).waitUntil(Condition.visible, EXPLICITLY_WAIT_TIME_OUT);
    }

    public void clickOnButton(By locator, String elementName) {
        log.info(String.format("Clicking on %s button", elementName));
        click(locator);
    }

    public void enterText(By locator, String elementName, String text) {
        log.info(String.format("Entering '%s' text in %s field", text, elementName));
        new ElementUtils().findVisibleElement(locator, EXPLICITLY_WAIT_TIME_OUT).sendKeys(text);
    }

    public void uploadFile(By locator, File file) {
        log.info(String.format("Uploading '%s' file", file.toString()));
        new ElementUtils().findElement(locator, EXPLICITLY_WAIT_TIME_OUT).uploadFile(file);
    }

    public boolean isElementDisplayed(By locator) {
        log.debug(String.format("Verifying is element with locator '%s' displayed", locator));
        boolean isElementDisplayed = new ElementUtils().findVisibleElement(locator, EXPLICITLY_WAIT_TIME_OUT).isDisplayed();
        log.debug(String.format("Is element displayed %s", isElementDisplayed));
        return isElementDisplayed;
    }

    public String getTextOfElement(By locator) {
        log.debug(String.format("Getting text for element with locator '%s'", locator));
        String text = new ElementUtils().findVisibleElement(locator, EXPLICITLY_WAIT_TIME_OUT).getText();
        log.debug(String.format("Text of element %s", text));
        return text;
    }

    public String getValidationMessage(By locator) {
        log.debug(String.format("Getting validation message for element with locator '%s'", locator));
        SelenideElement element = new ElementUtils().findVisibleElement(locator, EXPLICITLY_WAIT_TIME_OUT);
        String message = ((JavascriptExecutor) getWebDriver())
                .executeScript("return arguments[0].validationMessage;", element).toString();
        log.debug(String.format("Validation message '%s'", message));
        return message;
    }

    public void clickViaJsOnButton(By locator, String elementName) {
        log.info(String.format("Clicking via JS on %s button", elementName));
        Configuration.clickViaJs = true;
        click(locator);
        Configuration.clickViaJs = false;
    }

    private void click(By locator) {
        new ElementUtils().findVisibleElement(locator, EXPLICITLY_WAIT_TIME_OUT).click();
    }
}
