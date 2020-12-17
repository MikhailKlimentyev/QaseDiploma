package tests;


import factories.ProjectFactory;
import io.qameta.allure.Feature;
import models.Project;
import org.testng.annotations.Test;

import static pages.CreateSuitePage.SUITE_NAME_LABEL_LOCATOR;

@Feature("Suits")
public class SuitTest extends BaseTest {

    @Test(description = "Verify that create suite page is opened after clicking on 'Create new suite' button")
    public void createSuitePageShouldBeOpened() {
        loginSteps
                .openPage()
                .login(validUser);

        Project project = ProjectFactory.getProject();
        String code = createProjectSteps.createProjectUsingAPI(project);
        projectPage.setUrl(code);

        projectSteps
                .openPage()
                .clickOnCreateNewSuiteButton();
        boolean isSuiteNameLabelDisplayed = projectPage.isElementDisplayed(SUITE_NAME_LABEL_LOCATOR);
        projectSteps.validateCreateSuitePageIsOpened(isSuiteNameLabelDisplayed);
    }
}
