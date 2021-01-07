package pl.pancerro.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pancerro.backend.model.Project;

import java.util.List;

public interface ProjectRepo extends JpaRepository<Project,Long> {
    List<Project> findByActive(boolean active);
}
