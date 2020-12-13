package pages;

import elements.Input;
import elements.TextArea;
import org.openqa.selenium.By;
import pages.base.AbstractPage;
import pages.base.BasePage;

import static models.Constants.*;

public class CreateProjectPage extends BasePage {

    public static final String URL = "https://app.qase.io/project/create";

    public static final By PROJECT_NAME_LABEL_LOCATOR = By.cssSelector("[for='inputTitle']");
    public static final By PROJECT_NAME_INPUT_LOCATOR = By.id("inputTitle");
    public static final By DESCRIPTION_TEXT_AREA_LOCATOR = By.id("inputDescription");
    public static final By CREATE_PROJECT_BUTTON_LOCATOR = By.xpath("//*[contains(text(), 'Create project')]");

    public CreateProjectPage enterNewProjectFields(String projectName, String description) {
        new Input(PROJECT_NAME_INPUT_LOCATOR, PROJECT_NAME_INPUT_LABEL).write(projectName);
        new TextArea(DESCRIPTION_TEXT_AREA_LOCATOR, DESCRIPTION_TEXT_AREA_LABEL).write(description);
        return this;
    }

    public ProjectsPage clickOnCreateProjectButton() {
        clickOnButton(CREATE_PROJECT_BUTTON_LOCATOR, CREATE_PROJECT_BUTTON);
        return new ProjectsPage();
    }

    @Override
    public AbstractPage openPage() {
        openPage(CREATE_PROJECT_PAGE, URL);
        return this;
    }

    @Override
    public AbstractPage isPageOpened() {
        isPageOpened(PROJECT_NAME_LABEL_LOCATOR, CREATE_PROJECT_PAGE);
        return this;
    }
}
