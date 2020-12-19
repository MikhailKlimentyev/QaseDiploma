package tests;

import factories.UserFactory;
import io.qameta.allure.Feature;
import models.User;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static models.Constants.QASE_EMAIL_PROPERTY;
import static models.Constants.QASE_PASSWORD_PROPERTY;
import static pages.LoginPage.LOGIN_BUTTON_LOCATOR;
import static pages.ProjectsPage.PROJECT_NAME_LABEL_LOCATOR;
import static pages.ProjectsPage.USER_MENU_LOCATOR;
import static utils.PropertyReader.getProperty;

@Feature("Login")
public class LoginTest extends BaseTest {

    @Test(description = "Verify that login form is be opened after clicking on Login button")
    public void loginFormShouldBeOpened() {
        startSteps
                .openPage()
                .openLoginForm();
        boolean isLoginButtonDisplayed = loginPage.isElementDisplayed(LOGIN_BUTTON_LOCATOR);
        loginSteps.validateLoginFormIsDisplayed(isLoginButtonDisplayed);
    }

    @Test(description = "Verify that user should is logged in and projects page is be opened on attempt" +
            " to login with valid credentials")
    public void userShouldBeLoggedInAndProjectsPageShouldBeOpened() {
        loginSteps.safelyLogin(validUser);
        boolean isProjectNameLabelDisplayed = projectsPage.isElementDisplayed(PROJECT_NAME_LABEL_LOCATOR);
        projectsSteps.validateProjectNameLabelIsDisplayed(isProjectNameLabelDisplayed);
        boolean isUserMenuDisplayed = projectsPage.isElementDisplayed(USER_MENU_LOCATOR);
        projectsSteps.validateUserMenuIsDisplayed(isUserMenuDisplayed);
    }

    @Test(description = "Verify that error is be appeared on attempt to login with invalid credentials",
            dataProvider = "invalidEmailAndInvalidPasswordDataProvider")
    public void errorShouldBeAppearedOnAttemptLoginWithInvalidCredentials(String email, String password) {
        User user = UserFactory.getUser(email, password);
        loginSteps
                .openPage()
                .login(user);
        String errorMessage = loginPage.getErrorMessage();
        loginSteps.validateErrorMessage(errorMessage);
    }

    @DataProvider(name = "invalidEmailAndInvalidPasswordDataProvider")
    public Object[][] invalidEmailAndInvalidPasswordDataProvider() {
        return new Object[][]{
                {getProperty(QASE_EMAIL_PROPERTY, QASE_EMAIL_PROPERTY), "Invalid password"},
                {"invalid@email.com", getProperty(QASE_PASSWORD_PROPERTY, QASE_PASSWORD_PROPERTY)},
        };
    }
}
