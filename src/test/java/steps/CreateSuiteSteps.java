package steps;

import io.qameta.allure.Step;
import models.Suite;
import pages.CreateSuiteModal;

public class CreateSuiteSteps {

    private CreateSuiteModal createSuiteModal;

    public CreateSuiteSteps() {
        this.createSuiteModal = new CreateSuiteModal();
    }

    @Step("Create suite {suite}")
    public ProjectSteps createSuite(Suite suite) {
        createSuiteModal
                .fillInNewSuiteFields(suite)
                .clickOnCreateButton();
        return new ProjectSteps();
    }
}
