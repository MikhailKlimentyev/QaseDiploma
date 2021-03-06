package pages;

import elements.Input;
import elements.TextArea;
import models.Project;
import org.openqa.selenium.By;
import pages.base.BasePage;

import static models.Constants.*;

public class CreateProjectPage extends BasePage {

    public static final String URL = String.format(URL_PATTERN, BASE_URL, "project/create");

    public static final By PROJECT_NAME_LABEL_LOCATOR = By.cssSelector("[for='inputTitle']");
    public static final By PROJECT_NAME_INPUT_LOCATOR = By.id("inputTitle");
    public static final By DESCRIPTION_TEXT_AREA_LOCATOR = By.id("inputDescription");
    public static final By CREATE_PROJECT_BUTTON_LOCATOR = By.xpath("//*[contains(text(), 'Create project')]");

    public CreateProjectPage fillInNewProjectFields(Project project) {
        new Input(PROJECT_NAME_INPUT_LOCATOR, PROJECT_NAME_INPUT_LABEL).write(project.getTitle());
        new TextArea(DESCRIPTION_TEXT_AREA_LOCATOR, DESCRIPTION_TEXT_AREA_LABEL).write(project.getDescription());
        return this;
    }

    public ProjectsPage clickOnCreateProjectButton() {
        clickOnButton(CREATE_PROJECT_BUTTON_LOCATOR, CREATE_PROJECT_BUTTON);
        return new ProjectsPage();
    }

    public String getProjectNameValidationMessage() {
        return getValidationMessage(PROJECT_NAME_INPUT_LOCATOR);
    }

    @Override
    public CreateProjectPage openPage() {
        openPage(CREATE_PROJECT_PAGE, URL);
        return this;
    }

    @Override
    public CreateProjectPage isPageOpened() {
        isPageOpened(PROJECT_NAME_LABEL_LOCATOR, CREATE_PROJECT_PAGE);
        return this;
    }
}
