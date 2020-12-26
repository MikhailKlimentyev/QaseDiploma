package tests;

import factories.StepToReproduceFactory;
import factories.TestCaseFactory;
import io.qameta.allure.Feature;
import models.StepToReproduce;
import models.TestCase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static models.Constants.*;
import static pages.CreateTestCasePage.TITLE_LABEL_LOCATOR;

@Feature("Test Cases")
public class TestCaseTest extends BaseTest {

    @Test(description = "Verify that create test case page is opened after clicking on 'Create new case' button")
    public void createTestCasePageShouldBeOpened() {
        loginSteps.safelyLogin(validUser);

        String code = createProjectSteps.createProject();
        repositoryProjectPage.setUrl(code);

        repositoryProjectSteps
                .openPage()
                .clickOnCreateNewCaseButton();
        boolean isTitleLabelDisplayed = createTestCasePage.isElementDisplayed(TITLE_LABEL_LOCATOR);
        createTestCaseSteps.validateCreateSuitePageIsOpened(isTitleLabelDisplayed);
    }

    @Test(description = "Verify that test case is created")
    public void caseShouldBeCreated() {
        loginSteps.safelyLogin(validUser);

        String code = createProjectSteps.createProject();
        createTestCasePage.setUrl(code);
        String title = TestCaseFactory.getTestCaseName();
        createTestCaseSteps
                .openPage()
                .createTestCase(title);

        repositoryProjectPage.setTestCaseName(title);
        boolean isTestCaseNameDisplayed = repositoryProjectPage
                .isElementDisplayed(repositoryProjectPage.getTestCaseNameLocator());
        repositoryProjectSteps.validateTestCaseNameIsDisplayed(isTestCaseNameDisplayed);
    }

    @Test(description = "Verify that test case is opened after clicking on the test case name")
    public void testCaseShouldBeOpened() {
        loginSteps.safelyLogin(validUser);

        String code = createProjectSteps.createProject();
        createTestCasePage.setUrl(code);
        String title = TestCaseFactory.getTestCaseName();
        createTestCaseSteps
                .openPage()
                .createTestCase(title);

        repositoryProjectPage.setTestCaseName(title);
        repositoryProjectSteps.openTestCase();

        repositoryTestCaseModal.setTestCaseName(title);
        boolean isTestCaseNameDisplayed = repositoryTestCaseModal
                .isElementDisplayed(repositoryTestCaseModal.getTestCaseNameLocator());
        repositorySteps.validateTestCaseNameIsDisplayed(isTestCaseNameDisplayed);
    }

    @Test(description = "Verify that values of all fields of test case match entered values")
    public void allTestCaseFieldsValuesShouldMatchEnteredValues() {
        loginSteps.safelyLogin(validUser);

        String code = createProjectSteps.createProject();
        createTestCasePage.setUrl(code);
        TestCase testCase = TestCaseFactory.getTestCase();
        StepToReproduce stepToReproduce = StepToReproduceFactory.getStepToReproduce();
        createTestCaseSteps
                .openPage()
                .createTestCase(testCase, stepToReproduce, "test_data.txt");
        repositoryProjectPage.setTestCaseName(testCase.getTitle());
        repositoryProjectSteps.openTestCase();

        String titleText = repositoryTestCaseModal.getTitleText();
        repositorySteps.validateElementText(titleText, testCase.getTitle());

        repositorySteps.validateFieldValue(CASE_DESCRIPTION_INPUT_LABEL, testCase.getDescription());
        repositorySteps.validateFieldValue(CASE_SEVERITY_COMBO_BOX_LABEL, testCase.getSeverity().getField());
        repositorySteps.validateFieldValue(CASE_PRIORITY_COMBO_BOX_LABEL, testCase.getPriority().getField());
        repositorySteps.validateFieldValue(CASE_BEHAVIOR_COMBO_BOX_LABEL, testCase.getBehavior().getField());
        repositorySteps.validateFieldValue(CASE_TYPE_COMBO_BOX_LABEL, testCase.getType().getField());
        repositorySteps.validateFieldValue("Automation", testCase.getAutomationStatus().getField());
        repositorySteps.validateFieldValue(CASE_STATUS_COMBO_BOX_LABEL, testCase.getStatus().getField());
        repositorySteps.validateFieldValue("Preconditions", testCase.getPreConditions());
        repositorySteps.validateFieldValue("Postconditions", testCase.getPostConditions());

        String actionText = repositoryTestCaseModal.getActionText();
        repositorySteps.validateElementText(actionText, stepToReproduce.getAction());

        repositorySteps.validateStepFieldValue("Input Data", stepToReproduce.getInputData());
        repositorySteps.validateStepFieldValue("Expected result", stepToReproduce.getExpectedResult());
    }

    @Test(description = "Verify that file should be attached")
    public void fileShouldBeAttached() {
        loginSteps.safelyLogin(validUser);

        String code = createProjectSteps.createProject();
        createTestCasePage.setUrl(code);
        String title = TestCaseFactory.getTestCaseName();
        String fileName = "test_data.txt";
        createTestCaseSteps
                .openPage()
                .fillInTestCaseFields(title, fileName);

        createTestCasePage.setAttachmentName(fileName);
        By attachmentLocator = createTestCasePage.getAttachmentLocator();
        boolean isFileNameDisplayed = createTestCasePage.isElementDisplayed(attachmentLocator);
        createTestCaseSteps.validateFileIsAttached(isFileNameDisplayed);
    }
}
