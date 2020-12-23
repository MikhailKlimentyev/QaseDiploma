package utils;

import com.codeborne.selenide.Configuration;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static models.Constants.IMPLICITLY_WAIT_TIME_OUT;

@Log4j2
public class SelenideUtils {

    public void configureSelenide() {
        this.setBrowser();
        this.setBrowserMaximized();
        this.setTimeout();
        this.setPageLoadTimeout();
        this.setHeadless();
        this.setHoldBrowserOpen();
    }

    public void closeBrowser() {
        try {
            WebDriver webDriver = getWebDriver();
            log.debug(String.format("%s driver is quited", webDriver));
            webDriver.quit();
        } catch (IllegalStateException e) {
            log.debug(e);
        }
    }

    public void setBrowser() {
        String browser = "chrome";
        log.debug(String.format("Browser is %s", browser));
        Configuration.browser = browser;
    }

    public void setBrowserMaximized() {
        boolean isMaximized = true;
        log.debug(String.format("Browser is maximized %s", isMaximized));
        Configuration.startMaximized = isMaximized;
    }

    public void setTimeout() {
        int timeout = IMPLICITLY_WAIT_TIME_OUT;
        log.debug(String.format("Timeout is %s", timeout));
        Configuration.timeout = timeout;
    }

    public void setPageLoadTimeout() {
        int timeout = IMPLICITLY_WAIT_TIME_OUT;
        log.debug(String.format("PageLoadTimeout is %s", timeout));
        Configuration.pageLoadTimeout = timeout;
    }

    public void setHeadless() {
        boolean isHeadless = true;
        log.debug(String.format("Headless is enabled %s", isHeadless));
        Configuration.headless = isHeadless;
    }

    public void setHoldBrowserOpen() {
        boolean holdBrowserOpen = true;
        log.debug(String.format("Hold browser open %s", holdBrowserOpen));
        Configuration.holdBrowserOpen = holdBrowserOpen;
    }
}
