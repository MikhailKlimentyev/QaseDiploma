package pages;

import org.openqa.selenium.By;
import pages.base.AbstractPage;

import static models.Constants.REPOSITORY_TEST_CASE_MODAL;

public class RepositoryTestCaseModal extends AbstractPage {

    public static final By EDIT_BUTTON_BUTTON_LOCATOR = By.cssSelector("[title='Edit case']");
    public static final By TITLE_LOCATOR = By.cssSelector(".preview-title");
    public static final By ACTION_LOCATOR = By.xpath("//*[@class='steps']//p");

    public String testCaseNamePattern = "//*[contains(text(), '%s')]";
    public String testCaseName;
    public String fieldPattern = "//*[text()='%s']/following-sibling::*[contains(@class, 'preview-quick-edit')]";
    public String field;
    public String stepFieldPattern = "//*[text()='%s']/following-sibling::*//p";
    public String stepField;


    public void setTestCaseName(String testCaseName) {
        this.testCaseName = testCaseName;
    }

    public void setField(String field) {
        this.field = field;
    }

    public void setStepField(String stepField) {
        this.stepField = stepField;
    }

    public By getTestCaseNameLocator() {
        return By.xpath(String.format(testCaseNamePattern, testCaseName));
    }

    public By getFieldLocator() {
        return By.xpath(String.format(fieldPattern, field));
    }

    public By getStepFieldLocator() {
        return By.xpath(String.format(stepFieldPattern, stepField));
    }

    public String getTitleText() {
        return getTextOfElement(TITLE_LOCATOR);
    }

    public String getStepFieldText() {
        return getTextOfElement(getStepFieldLocator());
    }

    public String getFieldText() {
        return getTextOfElement(getFieldLocator());
    }

    public String getActionText() {
        return getTextOfElement(ACTION_LOCATOR);
    }

    @Override
    public RepositoryTestCaseModal isPageOpened() {
        isPageOpened(EDIT_BUTTON_BUTTON_LOCATOR, REPOSITORY_TEST_CASE_MODAL);
        return this;
    }
}
