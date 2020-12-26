package steps;

import factories.ProjectFactory;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import models.Project;
import org.testng.Assert;
import pages.CreateProjectPage;
import restassured.adapters.ProjectsAdapter;

import static org.apache.http.HttpStatus.SC_OK;

@Log4j2
public class CreateProjectSteps extends BaseSteps {

    private CreateProjectPage createProjectPage;
    private ProjectsAdapter projectsAdapter;
    private DeleteProjectSteps deleteProjectSteps;

    public CreateProjectSteps(DeleteProjectSteps deleteProjectSteps) {
        this.createProjectPage = new CreateProjectPage();
        this.projectsAdapter = new ProjectsAdapter();
        this.deleteProjectSteps = deleteProjectSteps;
    }

    public CreateProjectPage getCreateProjectPage() {
        return createProjectPage;
    }

    @Step("Open Create project page")
    public CreateProjectSteps openPage() {
        createProjectPage
                .openPage()
                .isPageOpened();
        return this;
    }

    @Step("Create project {project}")
    public RepositoryProjectSteps createProject(Project project) {
        createProjectPage
                .fillInNewProjectFields(project)
                .clickOnCreateProjectButton();
        String title = project.getTitle();
        String projectCode;
        if (title.length() >= 10) {
            projectCode = project.getTitle().toUpperCase().substring(0, 10);
        } else {
            projectCode = project.getTitle();
        }
        deleteProjectSteps.addCode(projectCode);
        return new RepositoryProjectSteps(deleteProjectSteps);
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
        String projectCode = "";
        Response response = projectsAdapter.create(project);
        if (response.getStatusCode() == SC_OK) {
            projectCode = response.getBody().path("result.code");
            deleteProjectSteps.addCode(projectCode);
            return projectCode;
        }
        Assert.fail(String.format("Project '%s' is not created", project));
        return projectCode;
    }
}
