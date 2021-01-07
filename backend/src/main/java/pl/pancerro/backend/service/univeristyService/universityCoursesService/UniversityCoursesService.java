package pl.pancerro.backend.service.univeristyService.universityCoursesService;

import pl.pancerro.backend.model.Charts;
import pl.pancerro.backend.model.UniversityCourses;

import java.util.List;

public interface UniversityCoursesService {
    List<UniversityCourses> getUniversityCourses();
    void addUniversityCourses(UniversityCourses universityCourses);
    boolean editUniversityCourses(UniversityCourses universityCourses);
    boolean deleteUniversityCourses(long id);
    List<Charts> getChartsCoursesInDepartments();
}
