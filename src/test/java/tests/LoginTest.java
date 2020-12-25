package tests;

import factories.UserFactory;
import io.qameta.allure.Feature;
import models.User;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static models.Constants.*;
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

    @Test(description = "Verify that error is appeared on attempt to login with invalid credentials",
            dataProvider = "invalidEmailAndInvalidPasswordDataProvider")
    public void errorShouldBeAppearedOnAttemptLoginWithInvalidCredentials(String email, String password) {
        User user = UserFactory.getUser(email, password);
        loginSteps
                .openPage()
                .login(user);
        String errorMessage = loginPage.getErrorMessage();
        loginSteps.validateErrorMessage(errorMessage, INVALID_CREDENTIALS_ERROR_MESSAGE);
    }

    @DataProvider(name = "invalidEmailAndInvalidPasswordDataProvider")
    public Object[][] invalidEmailAndInvalidPasswordDataProvider() {
        return new Object[][]{
                {getProperty(QASE_EMAIL_PROPERTY, QASE_EMAIL_PROPERTY), "Invalid password"},
                {"invalid@email.com", getProperty(QASE_PASSWORD_PROPERTY, QASE_PASSWORD_PROPERTY)},
        };
    }

    @Test(description = "Verify that validation message is appeared on attempt to login with email is not matched pattern",
            dataProvider = "emailNotMatchedPatternDataProvider")
    public void validationMessageShouldBeAppearedOnAttemptLoginWithEmailNotMatchedPattern(String email,
                                                                                          String expectedErrorMessage) {
        User user = UserFactory.getUser(email, getProperty(QASE_PASSWORD_PROPERTY, QASE_PASSWORD_PROPERTY));
        loginSteps
                .openPage()
                .login(user);
        String emailValidationMessage = loginPage.getEmailValidationMessage();
        loginSteps.validateErrorMessage(emailValidationMessage, expectedErrorMessage);
    }

    @DataProvider(name = "emailNotMatchedPatternDataProvider")
    public Object[][] emailNotMatchedPatternDataProvider() {
        return new Object[][]{
                {"email", EMAIL_NOT_CONTAINING_SYMBOL_ERROR_MESSAGE},
                {"email@.com", EMAIL_DOT_PLACE_ERROR_MESSAGE},
        };
    }
}
