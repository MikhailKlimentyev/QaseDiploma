package steps;

import io.qameta.allure.Step;
import org.testng.Assert;

public abstract class BaseSteps {

    @Step("Verify that '{actualErrorMessage}' equals to '{expectedErrorMessage}'")
    public void validateErrorMessage(String actualErrorMessage, String expectedErrorMessage) {
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error does not match expected");
    }

    @Step("Verify that element's text '{actualText}' equals to '{expectedText}'")
    public void validateElementText(String actualText, String expectedText) {
        Assert.assertEquals(actualText, expectedText, "Element text does not match expected");
    }
}
