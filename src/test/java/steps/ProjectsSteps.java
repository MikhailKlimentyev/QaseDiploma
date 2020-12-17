package steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.ProjectsPage;

public class ProjectsSteps {

    private ProjectsPage projectsPage;

    public ProjectsSteps() {
        this.projectsPage = new ProjectsPage();
    }

    @Step("Create new project")
    public CreateProjectSteps createNewProject() {
        projectsPage
                .clickOnCreateNewProjectButton()
                .isPageOpened();
        return new CreateProjectSteps();
    }

    @Step("Verify that project name label with state {isProjectNameLabelDisplayed} is displayed")
    public void validateProjectNameLabelIsDisplayed(boolean isProjectNameLabelDisplayed) {
        Assert.assertTrue(isProjectNameLabelDisplayed, "Project name label is not displayed");
    }

    @Step("Verify that user menu is displayed with state {isUserMenuDisplayed} ")
    public void validateUserMenuIsDisplayed(boolean isUserMenuDisplayed) {
        Assert.assertTrue(isUserMenuDisplayed, "User menu is not displayed");
    }
}
