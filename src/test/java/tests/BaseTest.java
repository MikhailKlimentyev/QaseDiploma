package tests;

import com.codeborne.selenide.Configuration;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.CreateProjectPage;
import pages.LoginPage;
import pages.ProjectPage;
import pages.ProjectsPage;
import steps.*;
import tests.listeners.TestListener;
import utils.PropertyReader;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Log4j2
@Listeners({TestListener.class})
public class BaseTest {

    StartSteps startSteps;
    LoginPage loginPage;
    LoginSteps loginSteps;
    ProjectsPage projectsPage;
    ProjectsSteps projectsSteps;
    CreateProjectPage createProjectPage;
    CreateProjectSteps createProjectSteps;
    ProjectPage projectPage;
    ProjectSteps projectSteps;

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
        loginPage = new LoginPage();
        loginSteps = new LoginSteps();
        projectsPage = new ProjectsPage();
        projectsSteps = new ProjectsSteps();
        createProjectPage = new CreateProjectPage();
        createProjectSteps = new CreateProjectSteps();
        projectPage = new ProjectPage();
        projectSteps = new ProjectSteps();
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
        int timeout = 10000;
        log.debug(String.format("Timeout is %s", timeout));
        Configuration.timeout = timeout;
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
