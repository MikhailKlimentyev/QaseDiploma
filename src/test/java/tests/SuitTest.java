package tests;


import factories.SuiteFactory;
import io.qameta.allure.Feature;
import models.Suite;
import org.testng.annotations.Test;

import static pages.CreateSuitePage.DESCRIPTION_TEXT_AREA_LOCATOR;
import static pages.ProjectPage.getSuiteNameLocator;

@Feature("Suits")
public class SuitTest extends BaseTest {

    @Test(description = "Verify that create suite page is opened after clicking on 'Create new suite' button")
    public void createSuitePageShouldBeOpened() {
        loginSteps.safelyLogin(validUser);

        String code = createProjectSteps.createProject();
        projectPage.setUrl(code);

        projectSteps
                .openPage()
                .clickOnCreateNewSuiteButton();
        boolean isSuiteNameLabelDisplayed = projectPage.isElementDisplayed(DESCRIPTION_TEXT_AREA_LOCATOR);
        projectSteps.validateCreateSuitePageIsOpened(isSuiteNameLabelDisplayed);
    }

    @Test(description = "Verify that suite with all filled fields is created")
    public void suiteShouldBeCreated() {
        loginSteps.safelyLogin(validUser);

        String code = createProjectSteps.createProject();
        createSuitePage.setUrl(code);
        Suite suite = SuiteFactory.getSuite();

        createSuiteSteps
                .openPage()
                .createSuite(suite);
        projectPage.setSuiteName(suite.getTitle());
        boolean isSuiteNameDisplayed = projectPage.isElementDisplayed(getSuiteNameLocator());
        projectSteps.validateSuiteNameIsDisplayed(isSuiteNameDisplayed);
    }
}
