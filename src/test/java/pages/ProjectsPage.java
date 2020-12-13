package pages;

import org.openqa.selenium.By;
import pages.base.BasePage;

import static models.Constants.CREATE_NEW_PROJECT_BUTTON;
import static models.Constants.PROJECTS_PAGE;

public class ProjectsPage extends BasePage {

    public static final String URL = "https://app.qase.io/projects";

    public static final By PROJECT_NAME_LABEL_LOCATOR = By.xpath("//*[contains(text(), 'Project name')]");
    public static final By USER_MENU_LOCATOR = By.className("user-menu");
    public static final By CREATE_NEW_PROJECT_LOCATOR = By.id("createButton");

    public CreateProjectPage clickOnCreateNewProjectButton() {
        clickOnButton(CREATE_NEW_PROJECT_LOCATOR, CREATE_NEW_PROJECT_BUTTON);
        return new CreateProjectPage();
    }

    @Override
    public ProjectsPage openPage() {
        openPage(PROJECTS_PAGE, URL);
        return this;
    }

    @Override
    public ProjectsPage isPageOpened() {
        isPageOpened(PROJECT_NAME_LABEL_LOCATOR, PROJECTS_PAGE);
        return this;
    }
}
