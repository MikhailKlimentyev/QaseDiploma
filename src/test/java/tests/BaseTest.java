package tests;

import com.codeborne.selenide.Configuration;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.LoginPage;
import pages.ProjectsPage;
import steps.LoginSteps;
import steps.ProjectsSteps;
import steps.StartSteps;
import tests.listeners.TestListener;
import utils.PropertyReader;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Log4j2
@Listeners({TestListener.class})
public class BaseTest {

    StartSteps startSteps;
    LoginSteps loginSteps;
    ProjectsSteps projectsSteps;
    LoginPage loginPage;
    ProjectsPage projectsPage;

    @BeforeMethod
    public void setUp() {
        setBrowser();
        setBrowserMaximized();
        setTimeout();
        setHeadless();
        setHoldBrowserOpen();
        createInstances();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        log.debug("Driver is quited");
        getWebDriver().quit();
    }

    String getEnvOrReadProperty(String key) {
        String propertyValue = System.getenv().getOrDefault(key, PropertyReader.getProperty(key));
        log.debug(String.format("Getting property/environment variable with key '%s' and value '%s'",
                key, propertyValue));
        return propertyValue;
    }

    private void createInstances() {
        startSteps = new StartSteps();
        loginSteps = new LoginSteps();
        projectsSteps = new ProjectsSteps();
        loginPage = new LoginPage();
        projectsPage = new ProjectsPage();
    }

    private void setBrowser() {
        String browser = "chrome";
        log.debug(String.format("Browser is %s", browser));
        Configuration.browser = browser;
    }

    private void setBrowserMaximized() {
        boolean isMaximized = true;
        log.debug(String.format("Browser is maximized %s", isMaximized));
        Configuration.startMaximized = isMaximized;
    }

    private void setTimeout() {
        int timeout = 7000;
        log.debug(String.format("Timeout is %s", 7000));
        Configuration.timeout = 7000;
    }

    private void setHeadless() {
        boolean isHeadless = false;
        log.debug(String.format("Headless is enabled %s", isHeadless));
        Configuration.headless = isHeadless;
    }

    private void setHoldBrowserOpen() {
        boolean holdBrowserOpen = true;
        log.debug(String.format("Hold browser open %s", holdBrowserOpen));
        Configuration.holdBrowserOpen = true;
    }
}
