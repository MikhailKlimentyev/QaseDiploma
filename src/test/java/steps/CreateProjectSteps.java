package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Project;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import pages.CreateProjectPage;

@Log4j2
public class CreateProjectSteps {

    private CreateProjectPage createProjectPage;

    public CreateProjectSteps() {
        this.createProjectPage = new CreateProjectPage();
    }

    @Step("Open Create project page")
    public CreateProjectSteps openPage() {
        createProjectPage
                .openPage()
                .isPageOpened();
        return this;
    }

    @Step("Create private {project}")
    public ProjectSteps createPrivateProject(Project project) {
        createProjectPage
                .enterNewProjectFields(project.getProjectName(), project.getDescription())
                .clickOnCreateProjectButton();
        return new ProjectSteps();
    }

    public String getProjectName() {
        String projectName = "QA" + RandomStringUtils.randomAlphabetic(10);
        log.debug(String.format("Getting project name %s", projectName));
        return projectName;
    }

    @Step("Verify that project name label is displayed {isProjectNameLabelDisplayed}")
    public void projectNameLabelShouldBeDisplayed(boolean isProjectNameLabelDisplayed) {
        Assert.assertTrue(isProjectNameLabelDisplayed, "Project name label is not displayed");
    }
}
