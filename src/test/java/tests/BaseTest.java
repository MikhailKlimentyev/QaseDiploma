package tests;

import com.codeborne.selenide.Configuration;
import factories.UserFactory;
import lombok.extern.log4j.Log4j2;
import models.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import restassured.adapters.ProjectsAdapter;
import steps.*;
import tests.listeners.TestListener;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static models.Constants.IMPLICITLY_WAIT_TIME_OUT;

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
    ProjectsAdapter projectsAdapter;
    CreateSuiteSteps createSuiteSteps;
    CreateSuiteModal createSuitePage;
    CreateTestCasePage createTestCasePage;
    CreateTestCaseSteps createTestCaseSteps;

    User validUser = UserFactory.getValidUser();

    @BeforeMethod
    public void setUp() {
        setBrowser();
        setBrowserMaximized();
        setTimeout();
        setPageLoadTimeout();
        setHeadless();
        setHoldBrowserOpen();
        createInstances();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        log.debug(String.format("%s driver is quited", getWebDriver()));
        getWebDriver().quit();
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
        projectsAdapter = new ProjectsAdapter();
        createSuitePage = new CreateSuiteModal();
        createSuiteSteps = new CreateSuiteSteps();
        createTestCasePage = new CreateTestCasePage();
        createTestCaseSteps = new CreateTestCaseSteps();
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
        int timeout = IMPLICITLY_WAIT_TIME_OUT;
        log.debug(String.format("Timeout is %s", timeout));
        Configuration.timeout = timeout;
    }

    private void setPageLoadTimeout() {
        int timeout = IMPLICITLY_WAIT_TIME_OUT;
        log.debug(String.format("PageLoadTimeout is %s", timeout));
        Configuration.pageLoadTimeout = timeout;
    }

    private void setHeadless() {
        boolean isHeadless = true;
        log.debug(String.format("Headless is enabled %s", isHeadless));
        Configuration.headless = isHeadless;
    }

    private void setHoldBrowserOpen() {
        boolean holdBrowserOpen = true;
        log.debug(String.format("Hold browser open %s", holdBrowserOpen));
        Configuration.holdBrowserOpen = true;
    }
}
