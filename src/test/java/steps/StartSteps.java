package steps;

import pages.StartPage;

public class StartSteps {

    private StartPage startPage;

    public StartSteps() {
        startPage = new StartPage();
    }

    public StartSteps openPage() {
        startPage
                .openPage()
                .isPageOpened();
        return this;
    }

    public LoginSteps openLoginForm() {
        startPage
                .clickOnLoginButton();
        return new LoginSteps();
    }
}
