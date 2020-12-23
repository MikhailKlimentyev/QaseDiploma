package steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import pages.DeleteProjectPage;
import restassured.adapters.ProjectsAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.http.HttpStatus.SC_OK;

@Log4j2
public class DeleteProjectSteps {

    private List<String> projectsCodes = new ArrayList<>();
    private DeleteProjectPage deleteProjectPage;
    private ProjectsAdapter projectsAdapter;

    public DeleteProjectSteps() {
        deleteProjectPage = new DeleteProjectPage();
        projectsAdapter = new ProjectsAdapter();
    }

    public int getProjectsCodesCount() {
        int size = projectsCodes.size();
        log.debug(String.format("Getting projects codes count %s", size));
        return size;
    }

    @Step("Delete projects by {projectsCodesPrefix} prefix")
    public void deleteProjects(String projectsCodesPrefix) {
        log.info(String.format("Deleting projects with '%s' prefix", projectsCodesPrefix));
        List<String> projectsCodes = getProjectsCodesUsingAPI();
        List<String> filteredProjectsCodes = filterProjectsCodesByPrefix(projectsCodes, projectsCodesPrefix);
        deleteProjects(filteredProjectsCodes);
    }

    @Step("Delete projects")
    public void deleteProjects() {
        log.info("Deleting projects");
        deleteProjects(projectsCodes);
    }

    @Step("Clear collection with projects codes")
    public void clear() {
        log.debug("Clear collection with projects codes");
        projectsCodes = new ArrayList<>();
    }

    @Step("Add {projectCode} code into collection")
    public void addCode(String projectCode) {
        log.debug(String.format("Adding project code '%s' to collection", projectCode));
        projectsCodes.add(projectCode);
    }

    private List<String> getProjectsCodesUsingAPI() {
        Response response = projectsAdapter.getAll(1000);
        if (response.getStatusCode() == SC_OK) {
            List<String> codes = response.getBody().path("result.entities.code");
            projectsCodes.addAll(codes);
            return projectsCodes;
        }
        Assert.fail(String.format("Project codes '%s' is not received", projectsCodes));
        return projectsCodes;
    }

    private List<String> filterProjectsCodesByPrefix(List<String> projectsCodes, String projectsCodesPrefix) {
        log.debug(String.format("Filtering projects codes '%s' with prefix %s", projectsCodes.toString(),
                projectsCodesPrefix));
        return projectsCodes.stream()
                .filter(code -> code.startsWith(projectsCodesPrefix))
                .collect(Collectors.toList());
    }

    private void deleteProjects(List<String> projectsCodes) {
        log.debug(String.format("Deleting projects codes '%s'", projectsCodes.toString()));
        projectsCodes.forEach(this::deleteProject);
    }

    private void deleteProject(String projectCode) {
        int statusCode = projectsAdapter.getByCode(projectCode).getStatusCode();
        if (statusCode == SC_OK) {
            log.debug(String.format("Deleting project with '%s' project code", projectCode));
            deleteProjectPage
                    .setUrl(projectCode)
                    .openPage()
                    .clickOnDeleteProjectButton();
        }
    }
}
