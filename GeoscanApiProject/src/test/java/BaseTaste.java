import implementation.ProjectServiceImplementation;
import models.Project;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import services.ProjectService;

import static context.Context.get;
import static context.Context.put;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;


public class BaseTaste {


    ProjectService projectService = new ProjectServiceImplementation();
    private long projectIdForTest = 121212;

    @Test
    public void projectCreationTest() {
        Project project = Project.builder()
                .id(projectIdForTest)
                .name("auto_" + RandomStringUtils.randomAlphabetic(10))
                .build();
        Project createdProject = projectService.createProject(project);
        put("project", project);
        assertNotNull(createdProject);
        assertEquals(project.getId(), createdProject.getId());
        assertEquals(project.getName(), createdProject.getName());
    }

    @Test
    public void getProjectByIdTest() {
        Project project = get("project", Project.class);
        Project projectReturned = projectService.getProjectFromSite(project);
        assertNotNull(projectReturned);
        assertEquals(project.getId(), projectReturned.getId());
    }

    @Test
    public void updateProjectTest() {
        Project project = get("project", Project.class);
        project.setName("auto_" + RandomStringUtils.randomAlphabetic(10));
        Project updatedProject = projectService.updateExistingProject(project);
        assertEquals(updatedProject.getName(), project.getName());
    }

    @Test
    public void deleteProjectTest() {
        Project project = get("project", Project.class);
        int statusCode = projectService.deleteProject(project);
        assertEquals(statusCode, 200);
    }

    @Test
    public void getNotExistingProject() {
        Project project = get("project", Project.class);
        int statusCode = projectService.getNotExistingProject(project);
        assertEquals(statusCode, 403);
    }

    @Test
    public void testWrongIdValues() {
        Project project = Project.builder()
                .id(0L)
                .name(null)
                .build();
        Project createdProject = projectService.createProject(project);
        assertNotNull(createdProject.getId());
    }

}
