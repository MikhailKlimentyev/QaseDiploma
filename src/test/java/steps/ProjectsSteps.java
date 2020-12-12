package steps;

import org.testng.Assert;
import pages.ProjectsPage;

public class ProjectsSteps {

    private ProjectsPage projectsPage;

    public ProjectsSteps() {
        this.projectsPage = new ProjectsPage();
    }

    public void projectNameLabelShouldBeDisplayed(boolean isProjectNameLabelDisplayed) {
        Assert.assertTrue(isProjectNameLabelDisplayed, "Project name label is not displayed");
    }

    public void userMenuShouldBeDisplayed(boolean isUserMenuDisplayed) {
        Assert.assertTrue(isUserMenuDisplayed, "User menu is not displayed");
    }
}
