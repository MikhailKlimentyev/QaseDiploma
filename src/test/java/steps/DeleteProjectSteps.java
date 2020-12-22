package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.DeleteProjectPage;
import restassured.adapters.ProjectsAdapter;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class DeleteProjectSteps {

    private DeleteProjectPage deleteProjectPage;
    private ProjectsAdapter projectsAdapter;

    public DeleteProjectSteps() {
        deleteProjectPage = new DeleteProjectPage();
        projectsAdapter = new ProjectsAdapter();
    }

    @Step("Delete projects by {projectsCodesPrefix} prefix")
    public void deleteProjects(String projectsCodesPrefix) {
        log.info(String.format("Deleting projects with '%s' prefix", projectsCodesPrefix));
        List<String> projectsCodes = getProjectsCodesUsingAPI();
        List<String> filteredProjectsCodes = filterProjectsCodesByPrefix(projectsCodes, projectsCodesPrefix);
        deleteProjects(filteredProjectsCodes);
    }

    private List<String> getProjectsCodesUsingAPI() {
        return projectsAdapter.get(1000);
    }

    private List<String> filterProjectsCodesByPrefix(List<String> projectsCodes, String projectsCodesPrefix) {
        log.debug(String.format("Filtering projectsCodes '%s' with prefix %s", projectsCodes.toString(),
                projectsCodesPrefix));
        return projectsCodes
                .stream()
                .filter(code -> code.startsWith(projectsCodesPrefix))
                .collect(Collectors.toList());
    }

    private void deleteProjects(List<String> projectsCodes) {
        log.debug(String.format("Deleting projectsCodes '%s'", projectsCodes.toString()));
        projectsCodes
                .forEach(code ->
                        deleteProjectPage
                                .setUrl(code)
                                .openPage()
                                .clickOnDeleteProjectButton());
    }
}
