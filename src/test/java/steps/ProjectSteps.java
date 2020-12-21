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

    @Step("Click on create new case button")
    public CreateTestCaseSteps clickOnCreateNewCaseButton() {
        projectPage
                .clickOnCreateNewCaseButton()
                .isPageOpened();
        return new CreateTestCaseSteps();
    }

    @Step("Verify that project name equals to {expectedProjectName}")
    public void validateProjectName(String actualProjectName, String expectedProjectName) {
        Assert.assertEquals(actualProjectName, expectedProjectName,
                "Project name does not match to expected");
    }

    @Step("Verify that suite name is displayed with actual state {isSuiteNameDisplayed}")
    public void validateSuiteNameIsDisplayed(boolean isSuiteNameDisplayed) {
        Assert.assertTrue(isSuiteNameDisplayed, "Suite name is not displayed");
    }

    @Step("Verify that test case name is displayed with actual state {isTestCaseNameDisplayed}")
    public void validateTestCaseNameIsDisplayed(boolean isTestCaseNameDisplayed) {
        Assert.assertTrue(isTestCaseNameDisplayed, "Test case name is not displayed");
    }
}
