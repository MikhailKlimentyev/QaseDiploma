package pages;

import org.openqa.selenium.By;
import pages.base.BasePage;

import static models.Constants.CREATE_SUITE_PAGE;
import static models.Constants.URL_PATTERN;

public class CreateSuitePage extends BasePage {

    public static final By SUITE_NAME_LABEL_LOCATOR = By.cssSelector("[for='inputTitle']");

    public static String urlPattern = String.format(URL_PATTERN, BASE_URL, "suite/%s/create");
    public static String url;

    public void setUrl(String code) {
        url = String.format(urlPattern, code);
    }

    @Override
    public CreateSuitePage openPage() {
        openPage(CREATE_SUITE_PAGE, url);
        return null;
    }

    @Override
    public CreateSuitePage isPageOpened() {
        isPageOpened(SUITE_NAME_LABEL_LOCATOR, CREATE_SUITE_PAGE);
        return null;
    }
}
