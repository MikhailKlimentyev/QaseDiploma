package steps;

import io.qameta.allure.Step;
import pages.StartPage;

public class StartSteps {

    private StartPage startPage;

    public StartSteps() {
        startPage = new StartPage();
    }

    @Step("Open start page")
    public StartSteps openPage() {
        startPage
                .openPage()
                .isPageOpened();
        return this;
    }

    @Step("Open login form")
    public LoginSteps openLoginForm() {
        startPage
                .clickOnLoginButton();
        return new LoginSteps();
    }
}
