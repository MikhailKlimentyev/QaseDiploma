package pages;

import elements.ComboBox;
import elements.Input;
import elements.ProseMirrorField;
import models.StepToReproduce;
import models.TestCase;
import org.openqa.selenium.By;
import pages.base.BasePage;

import static models.Constants.*;

public class CreateTestCasePage extends BasePage {

    public static final By TITLE_INPUT_LOCATOR = By.id("title");
    public static final By ADD_STEP_BUTTON_LOCATOR = By.id("addStep");
    public static final By SAVE_BUTTON_LOCATOR = By.xpath("//button[text()='Save']");
    public static final By ADD_ATTACHMENT_BUTTON_LOCATOR = By.xpath("//*[@id='case-attachments']/" +
            "following-sibling::*[@type='button']");
    public static final By TITLE_LABEL_LOCATOR = By.cssSelector("[for='title']");

    public static String urlPattern = String.format(URL_PATTERN, BASE_URL, "case/%s/create");
    public static String url;

    public void setUrl(String code) {
        url = String.format(urlPattern, code);
    }

    public CreateTestCasePage fillInNewTestCaseFields(TestCase testCase) {
        new Input(TITLE_INPUT_LOCATOR, CASE_TITLE_INPUT_LABEL).write(testCase.getTitle());
        new ProseMirrorField(CASE_DESCRIPTION_INPUT_LABEL).write(testCase.getDescription());
        new ComboBox(CASE_STATUS_COMBO_BOX_LABEL).set(testCase.getStatus().getField());
        new ComboBox(CASE_SUITE_COMBO_BOX_LABEL).set(testCase.getSuite().getField());
        new ComboBox(CASE_SEVERITY_COMBO_BOX_LABEL).set(testCase.getSeverity().getField());
        new ComboBox(CASE_PRIORITY_COMBO_BOX_LABEL).set(testCase.getPriority().getField());
        new ComboBox(CASE_TYPE_COMBO_BOX_LABEL).set(testCase.getType().getField());
        new ComboBox(CASE_BEHAVIOR_COMBO_BOX_LABEL).set(testCase.getBehavior().getField());
        new ComboBox(CASE_AUTOMATION_STATUS_COMBO_BOX_LABEL).set(testCase.getAutomationStatus().getField());
        new ProseMirrorField(CASE_PRE_CONDITIONS_INPUT_LABEL).write(testCase.getPreConditions());
        new ProseMirrorField(CASE_POST_CONDITIONS_INPUT_LABEL).write(testCase.getPostConditions());
        return this;
    }

    public CreateTestCasePage clickOnAddStepButton() {
        clickOnButton(ADD_STEP_BUTTON_LOCATOR, CASE_ADD_STEP_BUTTON);
        return this;
    }

    public CreateTestCasePage fillInStepToReproduceFields(StepToReproduce step) {
        new ProseMirrorField(CASE_ACTION_INPUT_LABEL).write(step.getAction());
        new ProseMirrorField(CASE_EXPECTED_RESULT_INPUT_LABEL).write(step.getExpectedResult());
        new ProseMirrorField(CASE_INPUT_DATA_INPUT_LABEL).write(step.getInputData());
        return this;
    }

    public UploadAttachmentModal clickOnAddAttachmentButton() {
        clickOnButton(ADD_ATTACHMENT_BUTTON_LOCATOR, CASE_ADD_ATTACHMENT_BUTTON);
        return new UploadAttachmentModal();
    }

    public ProjectPage clickOnSaveButton() {
        clickOnButton(SAVE_BUTTON_LOCATOR, CASE_SAVE_BUTTON);
        return new ProjectPage();
    }

    @Override
    public CreateTestCasePage openPage() {
        openPage(CREATE_TEST_CASE_PAGE, url);
        return this;
    }

    @Override
    public CreateTestCasePage isPageOpened() {
        isPageOpened(TITLE_LABEL_LOCATOR, CREATE_TEST_CASE_PAGE);
        return this;
    }
}
