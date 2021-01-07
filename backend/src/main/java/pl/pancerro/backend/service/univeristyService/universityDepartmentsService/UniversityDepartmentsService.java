package pl.pancerro.backend.service.univeristyService.universityDepartmentsService;

import pl.pancerro.backend.model.UniversityDepartments;

import java.util.List;

public interface UniversityDepartmentsService {
    List<UniversityDepartments> getUniversityDepartmentsList();
    void addUniversityDepartments(UniversityDepartments universityDepartments);
    boolean editUniversityDepartments(UniversityDepartments universityDepartments);
    boolean deleteUniversityDepartments(long id);

}
