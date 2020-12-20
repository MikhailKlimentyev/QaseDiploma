package steps;

import io.qameta.allure.Step;
import models.Suite;
import pages.CreateSuiteModal;

public class CreateSuiteSteps {

    private CreateSuiteModal createSuitePage;

    public CreateSuiteSteps() {
        this.createSuitePage = new CreateSuiteModal();
    }

    @Step("Create suite {suite}")
    public ProjectSteps createSuite(Suite suite) {
        createSuitePage
                .fillInNewSuiteFields(suite)
                .clickOnCreateButton();
        return new ProjectSteps();
    }
}
