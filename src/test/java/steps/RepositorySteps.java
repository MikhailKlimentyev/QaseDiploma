package steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.RepositoryTestCaseModal;

public class RepositorySteps extends BaseSteps {

    private RepositoryTestCaseModal repositoryTestCaseModal;

    public RepositorySteps() {
        this.repositoryTestCaseModal = new RepositoryTestCaseModal();
    }

    public RepositoryTestCaseModal getRepositoryTestCaseModal() {
        return repositoryTestCaseModal;
    }

    @Step("Verify that test case name is displayed with actual state {isTestCaseNameDisplayed}")
    public void validateTestCaseNameIsDisplayed(boolean isTestCaseNameDisplayed) {
        Assert.assertTrue(isTestCaseNameDisplayed, "Test case name is not displayed");
    }

    @Step("Verify that value of field with {label} label equals to {expectedValue} expected value")
    public void validateFieldValue(String label, String expectedValue) {
        repositoryTestCaseModal.setField(label);
        String fieldText = repositoryTestCaseModal.getFieldText();
        validateElementText(fieldText, expectedValue);
    }

    @Step("Verify that value of step field with {label} label equals to {expectedValue} expected value")
    public void validateStepFieldValue(String label, String expectedValue) {
        repositoryTestCaseModal.setStepField(label);
        String inputDataText = repositoryTestCaseModal.getStepFieldText();
        validateElementText(inputDataText, expectedValue);
    }
}
