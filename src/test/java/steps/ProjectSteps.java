package steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.ProjectPage;

public class ProjectSteps {

    private ProjectPage projectPage;

    public ProjectSteps() {
        this.projectPage = new ProjectPage();
    }

    @Step("Open project page")
    public ProjectSteps openPage() {
        projectPage
                .openPage()
                .isPageOpened();
        return this;
    }

    @Step("Click on create new suite button")
    public CreateProjectSteps clickOnCreateNewSuiteButton() {
        projectPage
                .clickOnCreateNewSuiteButton()
                .isPageOpened();
        return new CreateProjectSteps();
    }

    @Step("Verify that project name equals to {expectedProjectName}")
    public void validateProjectName(String actualProjectName, String expectedProjectName) {
        Assert.assertEquals(actualProjectName, expectedProjectName,
                "Project name does not match to expected");
    }

    @Step("Verify that create suite page is opened with actual state {isCreateSuitePageDisplayed}")
    public void validateCreateSuitePageIsOpened(boolean isCreateSuitePageDisplayed) {
        Assert.assertTrue(isCreateSuitePageDisplayed, "Create suite page is not opened");
    }
}
