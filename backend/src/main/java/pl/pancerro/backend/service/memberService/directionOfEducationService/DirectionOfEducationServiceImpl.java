package pl.pancerro.backend.service.memberService.directionOfEducationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pancerro.backend.model.member.DirectionOfEducation;
import pl.pancerro.backend.repository.memberRepo.DirectionOfEducationRepo;

import java.util.List;
import java.util.Optional;

@Service
public class DirectionOfEducationServiceImpl implements DirectionOfEducationService {
    private final DirectionOfEducationRepo directionOfEducationRepo;
    @Autowired
    public DirectionOfEducationServiceImpl(DirectionOfEducationRepo directionOfEducationRepo) {
        this.directionOfEducationRepo = directionOfEducationRepo;
    }

    @Override
    public List<DirectionOfEducation> getDirectionOfEducation() {
        return directionOfEducationRepo.findAll();
    }

    @Override
    public void addDirectionOfEducation(DirectionOfEducation directionOfEducation) {
        directionOfEducationRepo.save(directionOfEducation);
    }

    @Override
    public void editDirectionOfEducation(DirectionOfEducation directionOfEducation) {
        Optional<DirectionOfEducation> optionalDirectionOfEducation = directionOfEducationRepo.findById(directionOfEducation.getIdDirectionOfEducation());
        if(optionalDirectionOfEducation.isPresent()) {
            DirectionOfEducation updateDirectionOfEducation = optionalDirectionOfEducation.get();
            updateDirectionOfEducation.setDegreeOfStudies(directionOfEducation.getDegreeOfStudies());
            updateDirectionOfEducation.setDepartment(directionOfEducation.getDepartment());
            updateDirectionOfEducation.setFieldOfStudy(directionOfEducation.getFieldOfStudy());
            updateDirectionOfEducation.setNameUniversity(directionOfEducation.getNameUniversity());
            updateDirectionOfEducation.setProfile(directionOfEducation.getProfile());
            updateDirectionOfEducation.setYearStartStudy(directionOfEducation.getYearStartStudy());
            directionOfEducationRepo.save(updateDirectionOfEducation);
        }

    }

    @Override
    public boolean deleteDirectionOfEducation(long id) {
        Optional<DirectionOfEducation>optionalDirectionOfEducation = directionOfEducationRepo.findById(id);
        if(optionalDirectionOfEducation.isPresent()) {
            directionOfEducationRepo.deleteById(id);
            return true;
        } else return false;
    }
}
