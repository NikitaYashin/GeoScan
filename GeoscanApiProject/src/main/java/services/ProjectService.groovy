package services

import models.Project

interface ProjectService extends BasicService {

    Project createProject(Project project);

    Project getProjectFromSite(Project project);

    Project updateExistingProject(Project project)

    int deleteProject(Project project)

    int getNotExistingProject(Project project);

}

