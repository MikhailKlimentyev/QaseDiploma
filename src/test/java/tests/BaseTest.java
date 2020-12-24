package tests;

import factories.UserFactory;
import lombok.extern.log4j.Log4j2;
import models.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import pages.*;
import steps.*;
import tests.listeners.TestListener;
import utils.SelenideUtils;

import java.util.List;

import static models.Constants.PROJECT_NAME_PREFIX;

@Log4j2
@Listeners({TestListener.class})
public class BaseTest {

    LoginPage loginPage = new LoginPage();
    ProjectsPage projectsPage = new ProjectsPage();
    CreateProjectPage createProjectPage = new CreateProjectPage();
    ProjectPage projectPage = new ProjectPage();
    CreateTestCasePage createTestCasePage = new CreateTestCasePage();
    DeleteProjectSteps deleteProjectSteps = new DeleteProjectSteps();
    StartSteps startSteps = new StartSteps(deleteProjectSteps);
    LoginSteps loginSteps = new LoginSteps(deleteProjectSteps);
    ProjectsSteps projectsSteps = new ProjectsSteps(deleteProjectSteps);
    CreateProjectSteps createProjectSteps = new CreateProjectSteps(deleteProjectSteps);
    ProjectSteps projectSteps = new ProjectSteps(deleteProjectSteps);
    CreateSuiteSteps createSuiteSteps = new CreateSuiteSteps(deleteProjectSteps);
    CreateTestCaseSteps createTestCaseSteps = new CreateTestCaseSteps(deleteProjectSteps);
    SelenideUtils selenideUtils = new SelenideUtils();

    User validUser = UserFactory.getValidUser();

    @BeforeSuite
    public void deleteProjectsByPrefix() {
        List<String> projects = deleteProjectSteps.getFilteredProjectsCodesByPrefix(PROJECT_NAME_PREFIX);
        if (!projects.isEmpty()) {
            selenideUtils.configureSelenide();
            loginSteps.safelyLogin(validUser);
            deleteProjectSteps.deleteProjects(projects);
            selenideUtils.closeBrowser();
        }
    }

    @BeforeMethod
    public void setUp() {
        deleteProjectSteps.clear();
        selenideUtils.configureSelenide();
    }

    @AfterMethod(alwaysRun = true)
    public void CleanUp() {
        if (deleteProjectSteps.getProjectsCodesCount() != 0) {
            selenideUtils.closeBrowser();
            loginSteps.safelyLogin(validUser);
            deleteProjectSteps.deleteProjects();
        }
        selenideUtils.closeBrowser();
    }
}
