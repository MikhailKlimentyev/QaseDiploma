package pages;

import org.openqa.selenium.By;
import pages.base.BasePage;

import static models.Constants.*;

public class ProjectPage extends BasePage {

    public static final By PROJECT_NAME_LABEL_LOCATOR = By.className("header");
    public static final By CREATE_NEW_SUITE_BUTTON_LOCATOR = By.xpath("//*[contains(text(), 'Create new suite')]");
    public static final By CREATE_NEW_CASE_BUTTON_LOCATOR = By.xpath("//*[contains(text(), 'Create new case')]");
    public static final By SUITE_NAME_LOCATOR = By.className("suite-header");
    public static final By DESCRIPTION_NAME_LOCATOR = By.className("suite-description");

    public static String suiteNamePattern = "//*[@class='suite-header-title'][text()='%s']";
    public static String suiteName;
    public static String testCaseNamePattern = "//*[contains(text(), '%s')]";
    public static String testCaseName;
    public static String urlPattern = String.format(URL_PATTERN, BASE_URL, "project/%s");
    public static String url;

    public static By getSuiteNameLocator() {
        return By.xpath(String.format(suiteNamePattern, suiteName));
    }

    public static By getTestCaseNameLocator() {
        return By.xpath(String.format(testCaseNamePattern, testCaseName));
    }

    public ProjectPage setUrl(String code) {
        url = String.format(urlPattern, code);
        return this;
    }

    public void setSuiteName(String suiteName) {
        this.suiteName = suiteName;
    }

    public void setTestCaseName(String testCaseName) {
        this.testCaseName = testCaseName;
    }

    public String getProjectName() {
        return getTextOfElement(PROJECT_NAME_LABEL_LOCATOR);
    }

    public CreateSuiteModal clickOnCreateNewSuiteButton() {
        clickOnButton(CREATE_NEW_SUITE_BUTTON_LOCATOR, CREATE_NEW_SUITE_BUTTON);
        return new CreateSuiteModal();
    }

    public CreateTestCasePage clickOnCreateNewCaseButton() {
        clickOnButton(CREATE_NEW_CASE_BUTTON_LOCATOR, CREATE_NEW_CASE_BUTTON);
        return new CreateTestCasePage();
    }

    public String getSuiteNameText() {
        return getTextOfElement(SUITE_NAME_LOCATOR);
    }

    public String getSuiteDescriptionText() {
        return getTextOfElement(DESCRIPTION_NAME_LOCATOR);
    }

    @Override
    public ProjectPage openPage() {
        openPage(PROJECT_PAGE, url);
        return this;
    }

    @Override
    public ProjectPage isPageOpened() {
        isPageOpened(CREATE_NEW_SUITE_BUTTON_LOCATOR, PROJECT_PAGE);
        return this;
    }
}
