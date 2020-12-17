package tests;

import factories.ProjectFactory;
import io.qameta.allure.Feature;
import models.Project;
import org.testng.annotations.Test;

import static pages.CreateProjectPage.PROJECT_NAME_LABEL_LOCATOR;

@Feature("Projects")
public class ProjectsTest extends BaseTest {

    @Test(description = "Verify that new project is opened after clicking on 'Create new project' button")
    public void newProjectShouldBeOpened() {
        loginSteps
                .openPage()
                .login(validUser)
                .createNewProject();
        boolean isProjectNameLabelDisplayed = createProjectPage.isElementDisplayed(PROJECT_NAME_LABEL_LOCATOR);
        createProjectSteps.validateProjectNameLabelIsDisplayed(isProjectNameLabelDisplayed);
    }

    @Test(description = "Verify that private project is created")
    public void privateProjectShouldBeCreated() {
        loginSteps
                .openPage()
                .login(validUser);

        Project project = ProjectFactory.getProject();
        String expectedProjectName = project.getTitle();

        createProjectSteps
                .openPage()
                .createPrivateProject(project);

        String actualProjectName = projectPage.getProjectName();
        projectSteps.validateProjectName(actualProjectName, expectedProjectName);
    }
}
