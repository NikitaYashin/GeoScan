package implementation;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Project;
import services.ProjectService;

import static io.restassured.RestAssured.given;

public class ProjectServiceImplementation implements ProjectService {

    private final String SERVICE = "/projects";

    @Override
    public Project createProject(Project project) {
        String url = URI + SERVICE + "?projectName=" + project.getId();

        Response response = given()
                .contentType(ContentType.JSON)
                //.header(KEY, KEY_VALUE)
                .body(project)
                .post(url);
        if (response.statusCode() != 200) {
            System.out.println(response.statusCode() + "project not created");
            return null;
        } else
            return response.as(Project.class);
    }

    @Override
    public Project getProjectFromSite(Project project) {
        String url = URI + SERVICE + "/" + project.getId();
        return getProject(url);
    }

    private Project getProject(String url) {
        Response r = given().get(url);
        if (r.statusCode() != 200) {
            System.out.println(r.statusCode() + "could not get Project");
            return null;
        }
        return r.as(Project.class);
    }

    @Override
    public Project updateExistingProject(Project project) {
        String url = URI + SERVICE + "/" + project.getId();
        ;
        Response response = given()
                .contentType(ContentType.JSON)
                //.header(KEY, KEY_VALUE)
                .body(project)
                .put(url);
        if (response.statusCode() != 201) {
            System.out.println(response.statusCode() + "could not update");
            return null;
        }
        return response.as(Project.class);
    }


    @Override
    public int deleteProject(Project project) {
        String url = URI + SERVICE + "/" + project.getId();
        Response response = given()
                .contentType(ContentType.JSON)
                //.header(KEY, KEY_VALUE)
                .delete(url);
        return response.statusCode();
    }

    @Override
    public int getNotExistingProject(Project project) {
        String url = URI + SERVICE + "/" + project.getId();
        Response response = given()
                .contentType(ContentType.JSON)
                //.header(KEY, KEY_VALUE)
                .get(url);
        return response.statusCode();
    }

}