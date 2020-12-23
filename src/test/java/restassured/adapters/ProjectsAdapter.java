package restassured.adapters;

import io.restassured.response.Response;
import models.Project;

public class ProjectsAdapter extends BaseAdapter {

    private static final String URI = "v1/project";

    public Response create(Project project) {
        return post(URI, converter.toJson(project));
    }

    public Response getAll(int limit) {
        return get(String.format("%s?%s=%s", URI, "limit", limit));
    }

    public Response getByCode(String code) {
        return get(String.format("%s/%s", URI, code));
    }
}
