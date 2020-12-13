package utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class ElementUtils {

    public SelenideElement findVisibleElement(By locator, int timeOut) {
        log.debug(String.format("Waiting for element with locator '%s' is visible", locator));
        return $(locator).waitUntil(Condition.visible, timeOut);
    }
}
