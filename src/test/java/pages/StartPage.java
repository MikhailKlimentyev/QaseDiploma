package pages;

import org.openqa.selenium.By;
import pages.base.BasePage;

import static models.Constants.LOGIN_BUTTON;
import static models.Constants.START_PAGE;


public class StartPage extends BasePage {

    public static final By LOGIN_BUTTON_LOCATOR = By.id("signin");

    public LoginPage clickOnLoginButton() {
        clickOnButton(LOGIN_BUTTON_LOCATOR, LOGIN_BUTTON);
        return new LoginPage();
    }

    @Override
    public StartPage openPage() {
        openPage(START_PAGE, START_URL);
        return this;
    }

    @Override
    public StartPage isPageOpened() {
        isPageOpened(LOGIN_BUTTON_LOCATOR, START_PAGE);
        return this;
    }
}
