package pages;

import org.openqa.selenium.By;
import pages.base.BasePage;

import static models.Constants.*;

public class ProjectPage extends BasePage {

    public static final By PROJECT_NAME_LABEL_LOCATOR = By.className("header");
    public static final By CREATE_NEW_SUITE_BUTTON_LOCATOR = By.xpath("//*[contains(text(), 'Create new suite')]");

    public static String urlPattern = String.format(URL_PATTERN, BASE_URL, "project/%s");
    public static String url;

    public void setUrl(String code) {
        url = String.format(urlPattern, code);
    }

    public String getProjectName() {
        return getTextOfElement(PROJECT_NAME_LABEL_LOCATOR);
    }

    public CreateProjectPage clickOnCreateNewSuiteButton() {
        clickOnButton(CREATE_NEW_SUITE_BUTTON_LOCATOR, CREATE_NEW_SUITE_BUTTON);
        return new CreateProjectPage();
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
