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

        Suite suite = SuiteFactory.getSuite();
        createSuiteSteps
                .createSuite(suite);

        projectPage.setSuiteName(suite.getTitle());
        boolean isSuiteNameDisplayed = projectPage.isElementDisplayed(getSuiteNameLocator());
        projectSteps.validateSuiteNameIsDisplayed(isSuiteNameDisplayed);
    }
}
