package steps;

import io.qameta.allure.Step;
import models.Suite;
import pages.CreateSuiteModal;

public class CreateSuiteSteps extends BaseSteps {

    private CreateSuiteModal createSuiteModal;
    private DeleteProjectSteps deleteProjectSteps;

    public CreateSuiteSteps(DeleteProjectSteps deleteProjectSteps) {
        this.createSuiteModal = new CreateSuiteModal();
        this.deleteProjectSteps = deleteProjectSteps;
    }

    @Step("Create suite {suite}")
    public ProjectSteps createSuite(Suite suite) {
        createSuiteModal
                .fillInNewSuiteFields(suite)
                .clickOnCreateButton();
        return new ProjectSteps(deleteProjectSteps);
    }
}
