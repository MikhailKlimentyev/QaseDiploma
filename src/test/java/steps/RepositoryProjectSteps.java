package steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.RepositoryProjectPage;

public class RepositoryProjectSteps extends RepositorySteps {

    private RepositoryProjectPage repositoryProjectPage;
    private DeleteProjectSteps deleteProjectSteps;

    public RepositoryProjectSteps(DeleteProjectSteps deleteProjectSteps) {
        this.deleteProjectSteps = deleteProjectSteps;
        this.repositoryProjectPage = new RepositoryProjectPage();
    }

    public RepositoryProjectPage getRepositoryProjectPage() {
        return repositoryProjectPage;
    }

    @Step("Open repository project page")
    public RepositoryProjectSteps openPage() {
        repositoryProjectPage
                .openPage()
                .isPageOpened();
        return this;
    }

    @Step("Click on create new suite button")
    public CreateProjectSteps clickOnCreateNewSuiteButton() {
        repositoryProjectPage
                .clickOnCreateNewSuiteButton()
                .isPageOpened();
        return new CreateProjectSteps(deleteProjectSteps);
    }

    @Step("Click on create new case button")
    public CreateTestCaseSteps clickOnCreateNewCaseButton() {
        repositoryProjectPage
                .clickOnCreateNewCaseButton()
                .isPageOpened();
        return new CreateTestCaseSteps(deleteProjectSteps);
    }

    @Step("Open test case")
    public RepositorySteps openTestCase() {
        repositoryProjectPage
                .clickOnTestCaseName()
                .isPageOpened();
        return new RepositorySteps();
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
}
