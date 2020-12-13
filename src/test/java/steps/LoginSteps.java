package steps;

import io.qameta.allure.Step;
import models.User;
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

    @Step("Login for {user}")
    public ProjectsSteps login(User user) {
        loginPage
                .fillLoginFields(user.getEmail(), user.getPassword())
                .clickOnLoginButton();
        return new ProjectsSteps();
    }

    @Step("Verify that login form is displayed {isLoginFormDisplayed}")
    public void loginFormShouldBeDisplayed(boolean isLoginFormDisplayed) {
        Assert.assertTrue(isLoginFormDisplayed, "Login form is not displayed");
    }

    @Step("Verify that {errorMessage} equals to " + INVALID_CREDENTIALS_ERROR_MESSAGE)
    public void errorMessageShouldBeLike(String errorMessage) {
        Assert.assertEquals(errorMessage, INVALID_CREDENTIALS_ERROR_MESSAGE, "Error does not match to expected");
    }
}
