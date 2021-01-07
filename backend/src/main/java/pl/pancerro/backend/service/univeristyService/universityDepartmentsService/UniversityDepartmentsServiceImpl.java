package pl.pancerro.backend.service.univeristyService.universityDepartmentsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pancerro.backend.model.Charts;
import pl.pancerro.backend.model.UniversityDepartments;
import pl.pancerro.backend.repository.UniversityDepartmentsRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UniversityDepartmentsServiceImpl implements UniversityDepartmentsService {

    private final UniversityDepartmentsRepo universityDepartmentsRepo;
    @Autowired
    public UniversityDepartmentsServiceImpl(UniversityDepartmentsRepo universityDepartmentsRepo) {
        this.universityDepartmentsRepo = universityDepartmentsRepo;
    }

    @Override
    public List<UniversityDepartments> getUniversityDepartmentsList() {
        return universityDepartmentsRepo.findAll();
    }

    @Override
    public void addUniversityDepartments(UniversityDepartments universityDepartments) {
        universityDepartmentsRepo.save(universityDepartments);
    }

    @Override
    public boolean editUniversityDepartments(UniversityDepartments universityDepartments) {
        Optional<UniversityDepartments> optionalUniversityDepartments = universityDepartmentsRepo.findById(universityDepartments.getIdDepartments());
        if(optionalUniversityDepartments.isPresent()) {
            UniversityDepartments updateUniversityDepartments = optionalUniversityDepartments.get();
            updateUniversityDepartments.setShortcut(universityDepartments.getShortcut());
            updateUniversityDepartments.setNameDepartments(universityDepartments.getNameDepartments());
            universityDepartmentsRepo.save(updateUniversityDepartments);
            return true;
        } else return false;
    }

    @Override
    public boolean deleteUniversityDepartments(long id) {
        Optional<UniversityDepartments> optionalUniversityDepartments = universityDepartmentsRepo.findById(id);
        if(optionalUniversityDepartments.isPresent()) {
            universityDepartmentsRepo.deleteById(id);
            return true;
        } else return false;
    }


}
