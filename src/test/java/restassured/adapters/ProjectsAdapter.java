package restassured.adapters;

import models.Project;

import java.util.List;

public class ProjectsAdapter extends BaseAdapter {

    private static final String URI = "v1/project";

    public String create(Project project) {
        return post(URI, converter.toJson(project))
                .getBody()
                .path("result.code");
    }

    public List<String> get(int limit) {
        return get(URI, limit)
                .getBody()
                .path("result.entities.code");
    }
}
