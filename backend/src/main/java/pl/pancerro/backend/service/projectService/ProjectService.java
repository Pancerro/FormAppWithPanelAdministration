package pl.pancerro.backend.service.projectService;

import pl.pancerro.backend.model.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getProjectList();
    void addProject(Project project);
    boolean editProject(Project project);
    boolean deleteProject(long id);
    Project getProjectById(long id);
    List<Project> getActiveProject();
}
