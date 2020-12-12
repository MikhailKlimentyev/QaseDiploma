package steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.LoginPage;

import static models.Constants.INVALID_CREDENTIALS_ERROR_MESSAGE;

public class LoginSteps {

    private LoginPage loginPage;

    public LoginSteps() {
        this.loginPage = new LoginPage();
    }

    @Step("Open login page")
    public LoginSteps openPage() {
        loginPage
                .openPage()
                .isPageOpened();
        return this;
    }

    @Step("Login with {email} email, {password} password")
    public ProjectsSteps login(String email, String password) {
        loginPage
                .enterEmail(email)
                .enterPassword(password)
                .clickOnLoginButton();
        return new ProjectsSteps();
    }

    @Step("Verify that login form should be displayed {isLoginFormDisplayed}")
    public void loginFormShouldBeDisplayed(boolean isLoginFormDisplayed) {
        Assert.assertTrue(isLoginFormDisplayed, "Login form is not displayed");
    }

    @Step("Verify that error message should be like {errorMessage}")
    public void errorMessageShouldBeLike(String errorMessage) {
        Assert.assertEquals(errorMessage, INVALID_CREDENTIALS_ERROR_MESSAGE, "Error does not match to expected");
    }
}
