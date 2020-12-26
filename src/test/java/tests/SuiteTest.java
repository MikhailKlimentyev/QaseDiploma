package tests;


import factories.SuiteFactory;
import io.qameta.allure.Feature;
import models.Suite;
import org.testng.annotations.Test;

@Feature("Suites")
public class SuiteTest extends BaseTest {

    @Test(description = "Verify that suite is created")
    public void suiteShouldBeCreated() {
        loginSteps.safelyLogin(validUser);

        String projectCode = createProjectSteps.createProject();
        repositoryProjectPage.setUrl(projectCode);

        repositoryProjectSteps
                .openPage()
                .clickOnCreateNewSuiteButton();

        String title = SuiteFactory.getTitle();
        createSuiteSteps
                .createSuite(title);

        repositoryProjectPage.setSuiteName(title);
        boolean isSuiteNameDisplayed = repositoryProjectPage
                .isElementDisplayed(repositoryProjectPage.getSuiteNameLocator());
        repositoryProjectSteps.validateSuiteNameIsDisplayed(isSuiteNameDisplayed);
    }

    @Test(description = "Verify that all fields of created suite equals to specified values while creating suite")
    public void allFieldsOfCreatedSuiteShouldBeAsSpecifiedOnes() {
        loginSteps.safelyLogin(validUser);

        String projectCode = createProjectSteps.createProject();
        repositoryProjectPage.setUrl(projectCode);

        repositoryProjectSteps
                .openPage()
                .clickOnCreateNewSuiteButton();

        Suite suite = SuiteFactory.getSuite();
        createSuiteSteps
                .createSuite(suite);

        repositoryProjectPage.setSuiteName(suite.getTitle());
        String actualSuiteNameText = repositoryProjectPage.getSuiteNameText();
        repositoryProjectSteps.validateElementText(actualSuiteNameText, suite.getTitle());
        String actualSuiteDescriptionText = repositoryProjectPage.getSuiteDescriptionText();
        repositoryProjectSteps.validateElementText(actualSuiteDescriptionText, suite.getDescription());
    }
}
