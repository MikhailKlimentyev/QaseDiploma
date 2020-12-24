package pages;

import org.openqa.selenium.By;
import pages.base.BasePage;

import static models.Constants.*;

public class DeleteProjectPage extends BasePage {

    public static final By DELETE_PROJECT_LOCATOR = By.cssSelector("button.btn-cancel");

    public static String urlPattern = String.format(URL_PATTERN, BASE_URL, "project/%s/delete");
    public static String url;

    public DeleteProjectPage setUrl(String code) {
        url = String.format(urlPattern, code);
        return this;
    }

    public ProjectsPage clickOnDeleteProjectButton() {
        clickOnButton(DELETE_PROJECT_LOCATOR, DELETE_PROJECT_BUTTON);
        return new ProjectsPage();
    }

    @Override
    public DeleteProjectPage openPage() {
        openPage(DELETE_PROJECT_PAGE, url);
        return this;
    }

    @Override
    public DeleteProjectPage isPageOpened() {
        isPageOpened(DELETE_PROJECT_LOCATOR, DELETE_PROJECT_PAGE);
        return this;
    }
}
