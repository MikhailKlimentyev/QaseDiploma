package steps;

import io.qameta.allure.Step;
import models.Suite;
import pages.CreateSuitePage;

public class CreateSuiteSteps {

    private CreateSuitePage createSuitePage;

    public CreateSuiteSteps() {
        this.createSuitePage = new CreateSuitePage();
    }

    @Step("Open create suite page")
    public CreateSuiteSteps openPage() {
        createSuitePage
                .openPage()
                .isPageOpened();
        return new CreateSuiteSteps();
    }

    @Step("Create suite {suite}")
    public ProjectSteps createSuite(Suite suite) {
        createSuitePage
                .fillInNewSuiteFields(suite)
                .clickOnCreateSuiteButton();
        return new ProjectSteps();
    }
}
