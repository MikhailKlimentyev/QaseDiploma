package pages;

import elements.Input;
import elements.ProseMirrorField;
import models.Suite;
import org.openqa.selenium.By;
import pages.base.AbstractPage;

import static models.Constants.*;

public class CreateSuiteModal extends AbstractPage {

    public static final By SUITE_NAME_LABEL_LOCATOR = By.cssSelector("label[for='name']");
    public static final By SUITE_NAME_INPUT_LOCATOR = By.id("name");
    public static final By CREATE_BUTTON_LOCATOR = By.xpath("//*[text()='Create']");

    public CreateSuiteModal fillInSuiteNameField(String title) {
        new Input(SUITE_NAME_INPUT_LOCATOR, SUITE_NAME_INPUT_LABEL).write(title);
        return this;
    }

    public CreateSuiteModal fillInNewSuiteFields(Suite suite) {
        new Input(SUITE_NAME_INPUT_LOCATOR, SUITE_NAME_INPUT_LABEL).write(suite.getTitle());
        new ProseMirrorField(SUITE_DESCRIPTION_INPUT_LABEL).write(suite.getDescription());
        new ProseMirrorField(SUITE_PRECONDITIONS_INPUT_LABEL).write(suite.getPreconditions());
        return this;
    }

    public ProjectsPage clickOnCreateButton() {
        clickOnButton(CREATE_BUTTON_LOCATOR, CREATE_SUITE_BUTTON);
        return new ProjectsPage();
    }

    @Override
    public CreateSuiteModal isPageOpened() {
        isPageOpened(SUITE_NAME_LABEL_LOCATOR, CREATE_SUITE_PAGE);
        return this;
    }
}
