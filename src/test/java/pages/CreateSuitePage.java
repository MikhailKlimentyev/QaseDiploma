package pages;

import elements.Input;
import elements.TextArea;
import models.Suite;
import org.openqa.selenium.By;
import pages.base.BasePage;

import static models.Constants.*;

public class CreateSuitePage extends BasePage {

    public static final By SUITE_NAME_LABEL_LOCATOR = By.cssSelector("[for='inputTitle']");
    public static final By SUITE_NAME_INPUT_LOCATOR = By.id("inputTitle");
    public static final By SAVE_BUTTON_LOCATOR = By.id("saveButton");
    public static final By DESCRIPTION_TEXT_AREA_LOCATOR = By.xpath("//*[@for='inputDescription']" +
            "/following-sibling::*[contains(@class, 'CodeMirror')]");
    public static final By PRECONDITIONS_TEXT_AREA_LOCATOR = By.xpath("//*[@for='inputPreconditions']" +
            "/following-sibling::*[contains(@class, 'CodeMirror')]");

    public static String urlPattern = String.format(URL_PATTERN, BASE_URL, "suite/%s/create");
    public static String url;

    public void setUrl(String projectName) {
        url = String.format(urlPattern, projectName);
    }

    public CreateSuitePage fillInNewSuiteFields(Suite suite) {
        new Input(SUITE_NAME_INPUT_LOCATOR, SUITE_NAME_INPUT_LABEL).write(suite.getTitle());
        new TextArea(DESCRIPTION_TEXT_AREA_LOCATOR, SUITE_DESCRIPTION_TEXT_AREA_LABEL)
                .writeViaJs(suite.getDescription());
        new TextArea(PRECONDITIONS_TEXT_AREA_LOCATOR, SUITE_PRECONDITIONS_TEXT_AREA_LABEL)
                .writeViaJs(suite.getPreconditions());
        return this;
    }

    public ProjectsPage clickOnCreateSuiteButton() {
        clickOnButton(SAVE_BUTTON_LOCATOR, CREATE_SUITE_BUTTON);
        return new ProjectsPage();
    }

    @Override
    public CreateSuitePage openPage() {
        openPage(CREATE_SUITE_PAGE, url);
        return this;
    }

    @Override
    public CreateSuitePage isPageOpened() {
        isPageOpened(SUITE_NAME_LABEL_LOCATOR, CREATE_SUITE_PAGE);
        return this;
    }
}
