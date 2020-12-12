package steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.ProjectsPage;

public class ProjectsSteps {

    private ProjectsPage projectsPage;

    public ProjectsSteps() {
        this.projectsPage = new ProjectsPage();
    }

    @Step("Verify that project name label should be displayed {isProjectNameLabelDisplayed}")
    public void projectNameLabelShouldBeDisplayed(boolean isProjectNameLabelDisplayed) {
        Assert.assertTrue(isProjectNameLabelDisplayed, "Project name label is not displayed");
    }

    @Step("Verify that user menu should be displayed {isUserMenuDisplayed}")
    public void userMenuShouldBeDisplayed(boolean isUserMenuDisplayed) {
        Assert.assertTrue(isUserMenuDisplayed, "User menu is not displayed");
    }
}
