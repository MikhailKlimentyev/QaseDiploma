package steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.ProjectsPage;

public class ProjectsSteps extends BaseSteps {

    private ProjectsPage projectsPage;
    private DeleteProjectSteps deleteProjectSteps;

    public ProjectsSteps(DeleteProjectSteps deleteProjectSteps) {
        this.projectsPage = new ProjectsPage();
        this.deleteProjectSteps = deleteProjectSteps;
    }

    public ProjectsPage getProjectsPage() {
        return projectsPage;
    }

    @Step("Create new project")
    public CreateProjectSteps createNewProject() {
        projectsPage
                .clickOnCreateNewProjectButton()
                .isPageOpened();
        return new CreateProjectSteps(deleteProjectSteps);
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
