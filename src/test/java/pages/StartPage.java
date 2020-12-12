package pages;

import org.openqa.selenium.By;
import pages.base.BasePage;

import static models.Constants.LOGIN_BUTTON;
import static models.Constants.START_PAGE;


public class StartPage extends BasePage {

    public static final String URL = "https://qase.io/";

    public static final By LOGIN_BUTTON_ID = By.id("signin");

    public LoginPage clickOnLoginButton() {
        clickOnButton(LOGIN_BUTTON_ID, LOGIN_BUTTON);
        return new LoginPage();
    }

    @Override
    public StartPage openPage() {
        openPage(START_PAGE, URL);
        return this;
    }

    @Override
    public StartPage isPageOpened() {
        isPageOpened(LOGIN_BUTTON_ID, START_PAGE);
        return this;
    }
}
