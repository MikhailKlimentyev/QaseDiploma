package tests;


import factories.SuiteFactory;
import io.qameta.allure.Feature;
import models.Suite;
import org.testng.annotations.Test;

import static pages.ProjectPage.getSuiteNameLocator;

@Feature("Suites")
public class SuiteTest extends BaseTest {

    @Test(description = "Verify that suite is created")
    public void suiteShouldBeCreated() {
        loginSteps.safelyLogin(validUser);

        String projectCode = createProjectSteps.createProject();
        projectPage.setUrl(projectCode);

        projectSteps
                .openPage()
                .clickOnCreateNewSuiteButton();

        String title = SuiteFactory.getSuite().getTitle();
        createSuiteSteps
                .createSuite(title);

        projectPage.setSuiteName(title);
        boolean isSuiteNameDisplayed = projectPage.isElementDisplayed(getSuiteNameLocator());
        projectSteps.validateSuiteNameIsDisplayed(isSuiteNameDisplayed);
    }

    @Test(description = "Verify that all fields of created suite equals to specified values while creating suite")
    public void allFieldsOfCreatedSuiteShouldBeAsSpecifiedOnes() {
        loginSteps.safelyLogin(validUser);

        String projectCode = createProjectSteps.createProject();
        projectPage.setUrl(projectCode);

        projectSteps
                .openPage()
                .clickOnCreateNewSuiteButton();

        Suite suite = SuiteFactory.getSuiteWithAllFieldsFilled();
        createSuiteSteps
                .createSuite(suite);

        projectPage.setSuiteName(suite.getTitle());
        String actualSuiteNameText = projectPage.getSuiteNameText();
        projectSteps.validateElementText(actualSuiteNameText, suite.getTitle());
        String actualSuiteDescriptionText = projectPage.getSuiteDescriptionText();
        projectSteps.validateElementText(actualSuiteDescriptionText, suite.getDescription());
    }
}
