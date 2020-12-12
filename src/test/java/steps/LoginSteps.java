package steps;

import org.testng.Assert;
import pages.LoginPage;

import static models.Constants.INVALID_CREDENTIALS_ERROR_MESSAGE;

public class LoginSteps {

    private LoginPage loginPage;

    public LoginSteps() {
        this.loginPage = new LoginPage();
    }

    public LoginSteps openPage() {
        loginPage
                .openPage()
                .isPageOpened();
        return this;
    }

    public ProjectsSteps safelyLogin(String email, String password) {
        loginPage
                .enterEmail(email)
                .enterPassword(password)
                .clickOnLoginButton();
        return new ProjectsSteps();
    }

    public void loginFormShouldBeDisplayed(boolean isLoginFormDisplayed) {
        Assert.assertTrue(isLoginFormDisplayed, "Login form is not displayed");
    }

    public void errorMessageShouldBeLike(String errorMessage) {
        Assert.assertEquals(errorMessage, INVALID_CREDENTIALS_ERROR_MESSAGE, "Error does not match to expected");
    }
}
