package steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.ProjectPage;

public class ProjectSteps {

    private ProjectPage projectPage;

    public ProjectSteps() {
        this.projectPage = new ProjectPage();
    }

    @Step("Verify that project name equals to {expectedProjectName}")
    public void projectNameShouldBeLike(String actualProjectName, String expectedProjectName) {
        Assert.assertEquals(actualProjectName, expectedProjectName,
                "Project name does not match to expected");
    }
}
