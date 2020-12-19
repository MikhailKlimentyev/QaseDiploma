package steps;

import factories.ProjectFactory;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Project;
import org.testng.Assert;
import pages.CreateProjectPage;
import restassured.adapters.ProjectsAdapter;

@Log4j2
public class CreateProjectSteps {

    private CreateProjectPage createProjectPage;
    private ProjectsAdapter projectsAdapter;

    public CreateProjectSteps() {
        this.createProjectPage = new CreateProjectPage();
        this.projectsAdapter = new ProjectsAdapter();
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
                .fillInNewProjectFields(project)
                .clickOnCreateProjectButton();
        return new ProjectSteps();
    }

    @Step("Create {project} using API")
    public String createProject() {
        Project project = ProjectFactory.getProject();
        return createProjectUsingAPI(project);
    }

    @Step("Verify that project name label is displayed with actual state {isProjectNameLabelDisplayed}")
    public void validateProjectNameLabelIsDisplayed(boolean isProjectNameLabelDisplayed) {
        Assert.assertTrue(isProjectNameLabelDisplayed, "Project name label is not displayed");
    }

    @Step("Create {project} using API")
    private String createProjectUsingAPI(Project project) {
        return projectsAdapter.create(project);
    }
}
