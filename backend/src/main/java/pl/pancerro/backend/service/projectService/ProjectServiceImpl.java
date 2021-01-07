package pl.pancerro.backend.service.projectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pancerro.backend.model.Project;
import pl.pancerro.backend.repository.ProjectRepo;

import java.util.List;
import java.util.Optional;
@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepo projectRepo;
    @Autowired
    public ProjectServiceImpl(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    @Override
    public List<Project> getProjectList() {
        return projectRepo.findAll();
    }

    @Override
    public void addProject(Project project) {
        if(project.isActive()) {
            changeActive();
        }
        projectRepo.save(project);
    }

    @Override
    public boolean editProject(Project project) {
        Optional<Project> optionalProject = projectRepo.findById(project.getIdProject());
        if(optionalProject.isPresent()) {
            if(project.isActive()) {
                changeActive();
            }
            Project updateProject = optionalProject.get();
            updateProject.setDataEnd(project.getDataEnd());
            updateProject.setDataStart(project.getDataStart());
            updateProject.setDescriptionProject(project.getDescriptionProject());
            updateProject.setNameProject(project.getNameProject());
            updateProject.setActive(project.isActive());
            projectRepo.save(updateProject);
            return true;
        } else return false;
    }

    @Override
    public boolean deleteProject(long id) {
        Optional<Project> optionalProject = projectRepo.findById(id);
        if(optionalProject.isPresent()) {
            projectRepo.deleteById(id);
            return true;
        } else return false;
    }

    @Override
    public Project getProjectById(long id) {
        Optional<Project> optionalProject = projectRepo.findById(id);
        return optionalProject.orElse(null);
    }
    @Override
    public List<Project> getActiveProject() {
        return projectRepo.findByActive(true);
    };

    public void changeActive() {
        List<Project> projectList = projectRepo.findAll();
        projectList.forEach(project -> project.setActive(false));
    }
}
