package tests;

import io.qameta.allure.Feature;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static models.Constants.QASE_EMAIL_PROPERTY;
import static models.Constants.QASE_PASSWORD_PROPERTY;
import static pages.LoginPage.ERROR_MESSAGE_CLASS;
import static pages.LoginPage.LOGIN_BUTTON_ID;
import static pages.ProjectsPage.PROJECT_NAME_LABEL_XPATH;
import static pages.ProjectsPage.USER_MENU_CLASS;

@Feature("Login")
public class LoginTest extends BaseTest {

    @Test(description = "Login form should be opened after clicking on Login button")
    public void loginFormShouldBeOpened() {
        startSteps
                .openPage()
                .openLoginForm();
        boolean isLoginButtonDisplayed = loginPage.isElementDisplayed(LOGIN_BUTTON_ID);
        loginSteps.loginFormShouldBeDisplayed(isLoginButtonDisplayed);
    }

    @Test(description = "User should be logged in and projects page should be opened on attempt" +
            " to login with valid credentials")
    public void userShouldBeLoggedInAndProjectsPageShouldBeOpened() {
        loginSteps
                .openPage()
                .login(getEnvOrReadProperty(QASE_EMAIL_PROPERTY),
                        getEnvOrReadProperty(QASE_PASSWORD_PROPERTY));
        boolean isProjectNameLabelDisplayed = projectsPage.isElementDisplayed(PROJECT_NAME_LABEL_XPATH);
        projectsSteps.projectNameLabelShouldBeDisplayed(isProjectNameLabelDisplayed);
        boolean isUserMenuDisplayed = projectsPage.isElementDisplayed(USER_MENU_CLASS);
        projectsSteps.userMenuShouldBeDisplayed(isUserMenuDisplayed);
    }

    @Test(description = "Error should be appeared on attempt to login with invalid credentials",
            dataProvider = "invalidEmailAndInvalidPasswordDataProvider")
    public void errorShouldBeAppearedOnAttemptLoginWithInvalidCredentials(String email, String password) {
        loginSteps
                .openPage()
                .login(email, password);
        String errorText = loginPage.getTextOfElement(ERROR_MESSAGE_CLASS);
        loginSteps.errorMessageShouldBeLike(errorText);
    }

    @DataProvider(name = "invalidEmailAndInvalidPasswordDataProvider")
    public Object[][] invalidEmailAndInvalidPasswordDataProvider() {
        return new Object[][]{
                {getEnvOrReadProperty(QASE_EMAIL_PROPERTY), "Invalid password"},
                {"invalid@email.com", getEnvOrReadProperty(QASE_PASSWORD_PROPERTY)},
        };
    }
}
