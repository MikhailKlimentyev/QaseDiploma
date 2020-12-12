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
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.timeout = 7000;
        Configuration.headless = false;
        Configuration.holdBrowserOpen = true;
        startSteps = new StartSteps();
        loginSteps = new LoginSteps();
        projectsSteps = new ProjectsSteps();
        loginPage = new LoginPage();
        projectsPage = new ProjectsPage();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        getWebDriver().quit();
    }

    String getEnvOrReadProperty(String key) {
        String propertyValue = System.getenv().getOrDefault(key, PropertyReader.getProperty(key));
        log.debug(String.format("Getting property/environment variable with key '%s' and value '%s'",
                key, propertyValue));
        return propertyValue;
    }
}
