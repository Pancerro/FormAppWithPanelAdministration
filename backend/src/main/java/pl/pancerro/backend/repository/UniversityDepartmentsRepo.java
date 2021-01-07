package pl.pancerro.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pancerro.backend.model.UniversityDepartments;

public interface UniversityDepartmentsRepo extends JpaRepository<UniversityDepartments,Long> {
}
