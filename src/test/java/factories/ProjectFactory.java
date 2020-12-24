package factories;

import lombok.extern.log4j.Log4j2;
import models.Project;
import org.apache.commons.lang3.RandomStringUtils;

import static models.Constants.PROJECT_NAME_PREFIX;
import static models.enums.Accesses.NONE;

@Log4j2
public class ProjectFactory {

    public static Project getProject() {
        Project project = Project.builder()
                .title(getProjectName())
                .access(NONE)
                .description("Awesome project")
                .code(getCode())
                .build();
        log.debug(String.format("Getting project %s", project.toString()));
        return project;
    }

    private static String getCode() {
        String code = getProjectName().substring(0, 3).toUpperCase();
        log.debug(String.format("Getting code %s", code));
        return code;
    }

    private static String getProjectName() {
        String projectName = PROJECT_NAME_PREFIX + RandomStringUtils.randomAlphabetic(10);
        log.debug(String.format("Getting project name %s", projectName));
        return projectName;
    }
}
