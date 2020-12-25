package steps;

import io.qameta.allure.Step;
import pages.StartPage;

public class StartSteps extends BaseSteps {

    private StartPage startPage;
    private DeleteProjectSteps deleteProjectSteps;

    public StartSteps(DeleteProjectSteps deleteProjectSteps) {
        startPage = new StartPage();
        this.deleteProjectSteps = deleteProjectSteps;
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
        return new LoginSteps(deleteProjectSteps);
    }
}
