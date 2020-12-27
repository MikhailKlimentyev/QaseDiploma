package tests;

import factories.UserFactory;
import models.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import pages.*;
import steps.*;
import tests.listeners.FcConfigurationListener;
import tests.listeners.TestListener;
import utils.SelenideUtils;

import java.util.List;

import static models.Constants.PROJECT_NAME_PREFIX;

@Listeners({TestListener.class, FcConfigurationListener.class})
public class BaseTest {

    LoginPage loginPage;
    ProjectsPage projectsPage;
    CreateProjectPage createProjectPage;
    RepositoryProjectPage repositoryProjectPage;
    CreateTestCasePage createTestCasePage;
    RepositoryTestCaseModal repositoryTestCaseModal;

    DeleteProjectSteps deleteProjectSteps = new DeleteProjectSteps();
    StartSteps startSteps = new StartSteps(deleteProjectSteps);
    LoginSteps loginSteps = new LoginSteps(deleteProjectSteps);
    ProjectsSteps projectsSteps = new ProjectsSteps(deleteProjectSteps);
    CreateProjectSteps createProjectSteps = new CreateProjectSteps(deleteProjectSteps);
    RepositoryProjectSteps repositoryProjectSteps = new RepositoryProjectSteps(deleteProjectSteps);
    CreateSuiteSteps createSuiteSteps = new CreateSuiteSteps(deleteProjectSteps);
    CreateTestCaseSteps createTestCaseSteps = new CreateTestCaseSteps(deleteProjectSteps);
    RepositorySteps repositorySteps = new RepositorySteps();
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
        instantiatePages();
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

    public void instantiatePages() {
        loginPage = loginSteps.getLoginPage();
        projectsPage = projectsSteps.getProjectsPage();
        createProjectPage = createProjectSteps.getCreateProjectPage();
        repositoryProjectPage = repositoryProjectSteps.getRepositoryProjectPage();
        createTestCasePage = createTestCaseSteps.getCreateCasePage();
        repositoryTestCaseModal = repositorySteps.getRepositoryTestCaseModal();
    }
}
