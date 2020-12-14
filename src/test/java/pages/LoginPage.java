package pages;

import elements.Input;
import org.openqa.selenium.By;
import pages.base.BasePage;

import static models.Constants.*;

public class LoginPage extends BasePage {

    public static final String URL = String.format(URL_PATTERN, BASE_URL, "login");

    public static final By EMAIL_INPUT_LOCATOR = By.id("inputEmail");
    public static final By PASSWORD_INPUT_LOCATOR = By.id("inputPassword");
    public static final By LOGIN_BUTTON_LOCATOR = By.id("btnLogin");
    public static final By ERROR_MESSAGE_LOCATOR = By.className("form-control-feedback");

    public LoginPage fillLoginFields(String email, String password) {
        new Input(EMAIL_INPUT_LOCATOR, EMAIL_INPUT).write(email);
        new Input(PASSWORD_INPUT_LOCATOR, PASSWORD_INPUT).write(password);
        return this;
    }

    public ProjectsPage clickOnLoginButton() {
        clickOnButton(LOGIN_BUTTON_LOCATOR, LOGIN_BUTTON);
        return new ProjectsPage();
    }

    public String getErrorMessage() {
        return getTextOfElement(ERROR_MESSAGE_LOCATOR);
    }

    @Override
    public LoginPage openPage() {
        openPage(LOGIN_PAGE, URL);
        return this;
    }

    @Override
    public LoginPage isPageOpened() {
        isPageOpened(LOGIN_BUTTON_LOCATOR, LOGIN_PAGE);
        return this;
    }
}
