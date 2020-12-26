package tests;

import factories.ProjectFactory;
import io.qameta.allure.Feature;
import models.Project;
import org.testng.annotations.Test;

import static models.Constants.REQUIRED_FIELD_IS_NOT_FILLED_ERROR_MESSAGE;
import static pages.CreateProjectPage.PROJECT_NAME_LABEL_LOCATOR;

@Feature("Projects")
public class ProjectsTest extends BaseTest {

    @Test(description = "Verify that new project is opened after clicking on 'Create new project' button")
    public void newProjectShouldBeOpened() {
        loginSteps.safelyLogin(validUser)
                .createNewProject();
        boolean isProjectNameLabelDisplayed = createProjectPage.isElementDisplayed(PROJECT_NAME_LABEL_LOCATOR);
        createProjectSteps.validateProjectNameLabelIsDisplayed(isProjectNameLabelDisplayed);
    }

    @Test(description = "Verify that private project is created")
    public void privateProjectShouldBeCreated() {
        loginSteps.safelyLogin(validUser);

        Project project = ProjectFactory.getProject();
        String expectedProjectName = project.getTitle();

        createProjectSteps
                .openPage()
                .createProject(project);

        String actualProjectName = repositoryProjectPage.getProjectName();
        repositoryProjectSteps.validateProjectName(actualProjectName, expectedProjectName);
    }

    @Test(description = "Verify that validation message is appeared on attempt to create project with empty title")
    public void validationMessageShouldBeAppearedOnAttemptToCreateProjectWithEmptyTitle() {
        loginSteps.safelyLogin(validUser);

        Project project = ProjectFactory.getProject();
        project.setTitle("");

        createProjectSteps
                .openPage()
                .createProject(project);
        String validationMessage = createProjectPage.getProjectNameValidationMessage();
        loginSteps.validateErrorMessage(validationMessage, REQUIRED_FIELD_IS_NOT_FILLED_ERROR_MESSAGE);
    }
}
