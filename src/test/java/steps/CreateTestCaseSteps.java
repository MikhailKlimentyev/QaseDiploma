package steps;

import io.qameta.allure.Step;
import models.StepToReproduce;
import models.TestCase;
import org.testng.Assert;
import pages.CreateTestCasePage;
import pages.UploadAttachmentModal;

public class CreateTestCaseSteps {

    private CreateTestCasePage createCasePage;
    private UploadAttachmentModal uploadAttachmentModal;

    public CreateTestCaseSteps() {
        this.createCasePage = new CreateTestCasePage();
        this.uploadAttachmentModal = new UploadAttachmentModal();
    }

    @Step("Open create case page")
    public CreateTestCaseSteps openPage() {
        createCasePage
                .openPage()
                .isPageOpened();
        return this;
    }

    @Step("Create test case with {testCase}, {stepToReproduce}, {fileName}")
    public ProjectSteps createTestCase(TestCase testCase, StepToReproduce stepToReproduce, String fileName) {
        createCasePage
                .fillInNewTestCaseFields(testCase)
                .clickOnAddStepButton()
                .fillInStepToReproduceFields(stepToReproduce)
                .clickOnAddAttachmentButton()
                .isPageOpened()
                .uploadFile(fileName)
                .clickOnSaveButton();
        return new ProjectSteps();
    }

    @Step("Verify that create test case page is opened with actual state {isCreateTestCasePageDisplayed}")
    public void validateCreateSuitePageIsOpened(boolean isCreateTestCasePageDisplayed) {
        Assert.assertTrue(isCreateTestCasePageDisplayed, "Create test case page is not opened");
    }
}
