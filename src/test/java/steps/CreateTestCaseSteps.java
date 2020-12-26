package steps;

import io.qameta.allure.Step;
import models.StepToReproduce;
import models.TestCase;
import org.testng.Assert;
import pages.CreateTestCasePage;

public class CreateTestCaseSteps extends BaseSteps {

    private CreateTestCasePage createCasePage;
    private DeleteProjectSteps deleteProjectSteps;

    public CreateTestCaseSteps(DeleteProjectSteps deleteProjectSteps) {
        this.createCasePage = new CreateTestCasePage();
        this.deleteProjectSteps = deleteProjectSteps;
    }

    public CreateTestCasePage getCreateCasePage() {
        return createCasePage;
    }

    @Step("Open create case page")
    public CreateTestCaseSteps openPage() {
        createCasePage
                .openPage()
                .isPageOpened();
        return this;
    }

    @Step("Create test case with {testCase}, {stepToReproduce}, {fileName}")
    public RepositoryProjectSteps createTestCase(TestCase testCase, StepToReproduce stepToReproduce, String fileName) {
        createCasePage
                .fillInNewTestCaseFields(testCase)
                .clickOnAddStepButton()
                .fillInStepToReproduceFields(stepToReproduce)
                .clickOnAddAttachmentButton()
                .isPageOpened()
                .uploadFile(fileName)
                .clickOnSaveButton();
        return new RepositoryProjectSteps(deleteProjectSteps);
    }

    @Step("Create test case with {title}")
    public RepositoryProjectSteps createTestCase(String title) {
        createCasePage
                .fillInTestCaseTitleField(title)
                .clickOnSaveButton();
        return new RepositoryProjectSteps(deleteProjectSteps);
    }

    @Step("Fill in test case fields with {title}, {fileName}")
    public CreateTestCaseSteps fillInTestCaseFields(String title, String fileName) {
        createCasePage
                .fillInTestCaseTitleField(title)
                .clickOnAddAttachmentButton()
                .isPageOpened()
                .uploadFile(fileName);
        return this;
    }

    @Step("Verify that create test case page is opened with actual state {isCreateTestCasePageDisplayed}")
    public void validateCreateSuitePageIsOpened(boolean isCreateTestCasePageDisplayed) {
        Assert.assertTrue(isCreateTestCasePageDisplayed, "Create test case page is not opened");
    }

    @Step("Verify that attached file name is visible {isFileNameDisplayed}")
    public void validateFileIsAttached(boolean isFileNameDisplayed) {
        Assert.assertTrue(isFileNameDisplayed, "File is not attached");
    }
}
