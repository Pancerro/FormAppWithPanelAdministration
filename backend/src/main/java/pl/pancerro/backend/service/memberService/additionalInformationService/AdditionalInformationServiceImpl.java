package pl.pancerro.backend.service.memberService.additionalInformationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pancerro.backend.model.member.AdditionalInformation;
import pl.pancerro.backend.repository.memberRepo.AdditionalInformationRepo;

import java.util.List;
import java.util.Optional;
@Service
public class AdditionalInformationServiceImpl implements AdditionalInformationService {

    private final AdditionalInformationRepo additionalInformationRepo;
    @Autowired
    public AdditionalInformationServiceImpl(AdditionalInformationRepo additionalInformationRepo) {
        this.additionalInformationRepo = additionalInformationRepo;
    }

    @Override
    public List<AdditionalInformation> getAdditionalInformationList() {
        return additionalInformationRepo.findAll();
    }

    @Override
    public void addAdditionalInformation(AdditionalInformation additionalInformation) {
         additionalInformationRepo.save(additionalInformation);
    }

    @Override
    public void editAdditionalInformation(AdditionalInformation additionalInformation) {
        Optional<AdditionalInformation> optionalAdditionalInformation = additionalInformationRepo.findById(additionalInformation.getIdAdditional());
        if(optionalAdditionalInformation.isPresent()) {
            AdditionalInformation updateAdditionalInformation = optionalAdditionalInformation.get();
            updateAdditionalInformation.setDepartment(additionalInformation.getDepartment());
            updateAdditionalInformation.setDepartmentAnother(additionalInformation.getDepartmentAnother());
            updateAdditionalInformation.setFieldOfStudy(additionalInformation.getFieldOfStudy());
            updateAdditionalInformation.setFieldOfStudyAnother(additionalInformation.getFieldOfStudyAnother());
            updateAdditionalInformation.setNameAnotherUniversity(additionalInformation.getNameAnotherUniversity());
            updateAdditionalInformation.setNameUniversity(additionalInformation.getNameUniversity());
            updateAdditionalInformation.setProfile(additionalInformation.getProfile());
            updateAdditionalInformation.setProfileAnother(additionalInformation.getProfileAnother());
            updateAdditionalInformation.setRepeatYear(additionalInformation.isRepeatYear());
            updateAdditionalInformation.setStudiedAnotherUniversity(additionalInformation.isStudiedAnotherUniversity());
            updateAdditionalInformation.setStudyingAnotherDirection(additionalInformation.isStudyingAnotherDirection());
            updateAdditionalInformation.setWorkPlacementAndYear(additionalInformation.getWorkPlacementAndYear());
            updateAdditionalInformation.setWorkPlacementAndYearAnother(additionalInformation.getWorkPlacementAndYearAnother());
            updateAdditionalInformation.setYearStartAndEndStudyAnother(additionalInformation.getYearStartAndEndStudyAnother());
            updateAdditionalInformation.setYearStartStudy(additionalInformation.getYearStartStudy());
            additionalInformationRepo.save(updateAdditionalInformation);
        }
    }

    @Override
    public boolean deleteAdditionalInformation(long id) {
        Optional<AdditionalInformation> deleteAdditionalInformation = additionalInformationRepo.findById(id);
        if(deleteAdditionalInformation.isPresent()) {
            additionalInformationRepo.deleteById(id);
            return true;
        } else return false;
    }
}
