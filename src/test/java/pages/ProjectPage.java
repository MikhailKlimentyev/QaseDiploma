package pages;

import org.openqa.selenium.By;
import pages.base.AbstractPage;
import pages.base.BasePage;

import static models.Constants.PROJECT_PAGE;

public class ProjectPage extends BasePage {

    public static final By PROJECT_NAME_LABEL_LOCATOR = By.className("header");
    public static final By CREATE_NEW_SUITE_BUTTON_LOCATOR = By.xpath("//*[contains(text(), 'Create new suite')]");

    public static String urlPattern = "https://app.qase.io/project/%s";
    public static String url;

    public void setUrl(String code) {
        url = String.format(urlPattern, code);
    }

    public String getProjectName() {
        return getTextOfElement(PROJECT_NAME_LABEL_LOCATOR);
    }

    @Override
    public AbstractPage openPage() {
        openPage(PROJECT_PAGE, url);
        return this;
    }

    @Override
    public AbstractPage isPageOpened() {
        isPageOpened(CREATE_NEW_SUITE_BUTTON_LOCATOR, PROJECT_PAGE);
        return this;
    }
}
