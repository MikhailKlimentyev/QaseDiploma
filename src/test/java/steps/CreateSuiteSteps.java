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
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ProjectSteps(deleteProjectSteps);
    }

    @Step("Create suite with title {title}")
    public ProjectSteps createSuite(String title) {
        createSuiteModal
                .fillInSuiteNameField(title)
                .clickOnCreateButton();
        return new ProjectSteps(deleteProjectSteps);
    }
}
