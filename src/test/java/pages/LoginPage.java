package pages;

import org.openqa.selenium.By;
import pages.base.BasePage;

import static models.Constants.*;

public class LoginPage extends BasePage {

    public static final String URL = "https://app.qase.io/login";

    public static final By EMAIL_INPUT_ID = By.id("inputEmail");
    public static final By PASSWORD_INPUT_ID = By.id("inputPassword");
    public static final By LOGIN_BUTTON_ID = By.id("btnLogin");
    public static final By ERROR_MESSAGE_CLASS = By.className("form-control-feedback");

    public LoginPage enterEmail(String text) {
        enterText(EMAIL_INPUT_ID, EMAIL_INPUT, text);
        return this;
    }

    public LoginPage enterPassword(String text) {
        enterText(PASSWORD_INPUT_ID, PASSWORD_INPUT, text);
        return this;
    }

    public ProjectsPage clickOnLoginButton() {
        clickOnButton(LOGIN_BUTTON_ID, LOGIN_BUTTON);
        return new ProjectsPage();
    }

    @Override
    public LoginPage openPage() {
        openPage(LOGIN_PAGE, URL);
        return this;
    }

    @Override
    public LoginPage isPageOpened() {
        isPageOpened(LOGIN_BUTTON_ID, LOGIN_PAGE);
        return this;
    }
}
