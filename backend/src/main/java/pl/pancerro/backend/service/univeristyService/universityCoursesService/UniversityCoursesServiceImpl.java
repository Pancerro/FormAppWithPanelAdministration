package pl.pancerro.backend.service.univeristyService.universityCoursesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pancerro.backend.model.Charts;
import pl.pancerro.backend.model.UniversityCourses;
import pl.pancerro.backend.repository.UniversityCoursesRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UniversityCoursesServiceImpl implements UniversityCoursesService {

    private final UniversityCoursesRepo universityCoursesRepo;
    @Autowired
    public UniversityCoursesServiceImpl(UniversityCoursesRepo universityCoursesRepo) {
        this.universityCoursesRepo = universityCoursesRepo;
    }

    @Override
    public List<UniversityCourses> getUniversityCourses() {
        return universityCoursesRepo.findAll();
    }

    @Override
    public void addUniversityCourses(UniversityCourses universityCourses) {
        universityCoursesRepo.save(universityCourses);
    }

    @Override
    public boolean editUniversityCourses(UniversityCourses universityCourses) {
        Optional<UniversityCourses> optionalUniversityCourses = universityCoursesRepo.findById(universityCourses.getIdCourses());
        if(optionalUniversityCourses.isPresent()) {
            UniversityCourses updateUniversityCourses = optionalUniversityCourses.get();
            updateUniversityCourses.setNameCourses(universityCourses.getNameCourses());
            updateUniversityCourses.setUniversityDepartments(universityCourses.getUniversityDepartments());
            universityCoursesRepo.save(updateUniversityCourses);
            return true;
        } else return false;
    }

    @Override
    public boolean deleteUniversityCourses(long id) {
        Optional<UniversityCourses> optionalUniversityCourses = universityCoursesRepo.findById(id);
        if(optionalUniversityCourses.isPresent()) {
            universityCoursesRepo.deleteById(id);
            return true;
        }else return false;
    }
    @Override
    public List<Charts> getChartsCoursesInDepartments() {
        List<Charts> chartsList = new ArrayList<>();
        Charts charts;
        for(int i = 0; i<universityCoursesRepo.getCountCoursesInDepartment().size(); i++) {
            charts = new Charts(universityCoursesRepo.getCountCoursesInDepartment().get(i).get("nameDepartments").toString(),convertToLong(universityCoursesRepo.getCountCoursesInDepartment().get(i).get("countCourses")));
            chartsList.add(charts);
        }
        return chartsList;
    }
    static Long convertToLong(Object o){
        String stringToConvert = String.valueOf(o);
        Long convertedLong = Long.parseLong(stringToConvert);
        return convertedLong;
    }
}
