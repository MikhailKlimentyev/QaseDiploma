package steps;

import io.qameta.allure.Step;
import models.User;
import org.testng.Assert;
import pages.LoginPage;

public class LoginSteps extends BaseSteps {

    private LoginPage loginPage;
    private DeleteProjectSteps deleteProjectSteps;

    public LoginSteps(DeleteProjectSteps deleteProjectSteps) {
        this.loginPage = new LoginPage();
        this.deleteProjectSteps = deleteProjectSteps;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    @Step("Open login page")
    public LoginSteps openPage() {
        loginPage
                .openPage()
                .isPageOpened();
        return this;
    }

    @Step("Login by {user}")
    public ProjectsSteps login(User user) {
        loginPage
                .openPage()
                .fillLoginFields(user.getEmail(), user.getPassword())
                .clickOnLoginButton();
        return new ProjectsSteps(deleteProjectSteps);
    }

    @Step("Login by {user}")
    public ProjectsSteps safelyLogin(User user) {
        return this.openPage()
                .login(user);
    }

    @Step("Verify that login form is displayed with actual state {isLoginFormDisplayed}")
    public void validateLoginFormIsDisplayed(boolean isLoginFormDisplayed) {
        Assert.assertTrue(isLoginFormDisplayed, "Login form is not displayed");
    }
}
