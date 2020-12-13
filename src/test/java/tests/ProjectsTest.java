package tests;

import io.qameta.allure.Feature;
import models.Project;
import org.testng.annotations.Test;

import static models.Constants.*;
import static models.ProjectAccessTypes.PRIVATE;
import static pages.CreateProjectPage.PROJECT_NAME_LABEL_LOCATOR;

@Feature("Projects")
public class ProjectsTest extends BaseTest {

    @Test(description = "Verify that new project is opened after clicking on 'Create new project' button")
    public void newProjectShouldBeOpened() {
        loginSteps
                .openPage()
                .login(getEnvOrReadProperty(QASE_EMAIL_PROPERTY), getEnvOrReadProperty(QASE_PASSWORD_PROPERTY))
                .createNewProject();
        boolean isProjectNameLabelDisplayed = createProjectPage.isElementDisplayed(PROJECT_NAME_LABEL_LOCATOR);
        createProjectSteps.projectNameLabelShouldBeDisplayed(isProjectNameLabelDisplayed);
    }

    @Test(description = "Verify that private project is created")
    public void privateProjectShouldBeCreated() {
        loginSteps
                .openPage()
                .login(getEnvOrReadProperty(QASE_EMAIL_PROPERTY), getEnvOrReadProperty(QASE_PASSWORD_PROPERTY));

        String expectedProjectName = createProjectSteps.getProjectName();
        Project project = Project.builder()
                .projectName(expectedProjectName)
                .projectAccessType(PRIVATE)
                .description(SOME_PROJECT_DESCRIPTION_TEXT)
                .build();
        createProjectSteps
                .openPage()
                .createPrivateProject(project);

        String actualProjectName = projectPage.getProjectName();
        projectSteps.projectNameShouldBeLike(actualProjectName, expectedProjectName);
    }
}
