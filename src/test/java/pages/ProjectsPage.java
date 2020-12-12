package pages;

import org.openqa.selenium.By;
import pages.base.BasePage;

import static models.Constants.PROJECTS_PAGE;

public class ProjectsPage extends BasePage {

    public static final String URL = "https://app.qase.io/projects";

    public static final By PROJECT_NAME_LABEL_XPATH = By.xpath("//*[contains(text(), 'Project name')]");
    public static final By USER_MENU_CLASS = By.className("user-menu");

    @Override
    public ProjectsPage openPage() {
        openPage(PROJECTS_PAGE, URL);
        return this;
    }

    @Override
    public ProjectsPage isPageOpened() {
        isPageOpened(PROJECT_NAME_LABEL_XPATH, PROJECTS_PAGE);
        return this;
    }
}
