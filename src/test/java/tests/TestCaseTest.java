package tests;

import factories.StepToReproduceFactory;
import factories.TestCaseFactory;
import io.qameta.allure.Feature;
import models.StepToReproduce;
import models.TestCase;
import org.testng.annotations.Test;

import static pages.CreateTestCasePage.TITLE_LABEL_LOCATOR;
import static pages.ProjectPage.getTestCaseNameLocator;

@Feature("Test Cases")
public class TestCaseTest extends BaseTest {

    @Test(description = "Verify that create test case page is opened after clicking on 'Create new case' button")
    public void createTestCasePageShouldBeOpened() {
        loginSteps.safelyLogin(validUser);

        String code = createProjectSteps.createProject();
        projectPage.setUrl(code);

        projectSteps
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
        TestCase testCase = TestCaseFactory.getTestCase();
        StepToReproduce stepToReproduce = StepToReproduceFactory.getStepToReproduce();

        createTestCaseSteps
                .openPage()
                .createTestCase(testCase, stepToReproduce, "test_data.txt");

        projectPage.setTestCaseName(testCase.getTitle());
        boolean isTestCaseNameDisplayed = projectPage.isElementDisplayed(getTestCaseNameLocator());
        projectSteps.validateTestCaseNameIsDisplayed(isTestCaseNameDisplayed);
    }
}
