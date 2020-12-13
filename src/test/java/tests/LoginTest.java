package tests;

import io.qameta.allure.Feature;
import models.User;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static models.Constants.QASE_EMAIL_PROPERTY;
import static models.Constants.QASE_PASSWORD_PROPERTY;
import static pages.LoginPage.LOGIN_BUTTON_LOCATOR;
import static pages.ProjectsPage.PROJECT_NAME_LABEL_LOCATOR;
import static pages.ProjectsPage.USER_MENU_LOCATOR;

@Feature("Login")
public class LoginTest extends BaseTest {

    @Test(description = "Verify that login form is be opened after clicking on Login button")
    public void loginFormShouldBeOpened() {
        startSteps
                .openPage()
                .openLoginForm();
        boolean isLoginButtonDisplayed = loginPage.isElementDisplayed(LOGIN_BUTTON_LOCATOR);
        loginSteps.loginFormShouldBeDisplayed(isLoginButtonDisplayed);
    }

    @Test(description = "Verify that user should is logged in and projects page is be opened on attempt" +
            " to login with valid credentials")
    public void userShouldBeLoggedInAndProjectsPageShouldBeOpened() {
        loginSteps
                .openPage()
                .login(validUser);
        boolean isProjectNameLabelDisplayed = projectsPage.isElementDisplayed(PROJECT_NAME_LABEL_LOCATOR);
        projectsSteps.projectNameLabelShouldBeDisplayed(isProjectNameLabelDisplayed);
        boolean isUserMenuDisplayed = projectsPage.isElementDisplayed(USER_MENU_LOCATOR);
        projectsSteps.userMenuShouldBeDisplayed(isUserMenuDisplayed);
    }

    @Test(description = "Verify that error is be appeared on attempt to login with invalid credentials",
            dataProvider = "invalidEmailAndInvalidPasswordDataProvider")
    public void errorShouldBeAppearedOnAttemptLoginWithInvalidCredentials(String email, String password) {
        User user = User.builder()
                .email(email)
                .password(password)
                .build();
        loginSteps
                .openPage()
                .login(user);
        String errorMessage = loginPage.getErrorMessage();
        loginSteps.errorMessageShouldBeLike(errorMessage);
    }

    @DataProvider(name = "invalidEmailAndInvalidPasswordDataProvider")
    public Object[][] invalidEmailAndInvalidPasswordDataProvider() {
        return new Object[][]{
                {getEnvOrReadProperty(QASE_EMAIL_PROPERTY), "Invalid password"},
                {"invalid@email.com", getEnvOrReadProperty(QASE_PASSWORD_PROPERTY)},
        };
    }
}
