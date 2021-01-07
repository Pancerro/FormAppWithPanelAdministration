package pl.pancerro.backend.service.memberService.laborMarketStatusService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pancerro.backend.model.member.LaborMarketStatus;
import pl.pancerro.backend.repository.memberRepo.LaborMarketStatusRepo;

import java.util.List;
import java.util.Optional;
@Service
public class LaborMarketStatusServiceImpl implements LaborMarketStatusService {

    private final LaborMarketStatusRepo laborMarketStatusRepo;
    @Autowired
    public LaborMarketStatusServiceImpl(LaborMarketStatusRepo laborMarketStatusRepo) {
        this.laborMarketStatusRepo = laborMarketStatusRepo;
    }

    @Override
    public List<LaborMarketStatus> getLaborMarketStatusList() {
        return laborMarketStatusRepo.findAll();
    }

    @Override
    public void addLaborMarketStatus(LaborMarketStatus laborMarketStatus) {
        laborMarketStatusRepo.save(laborMarketStatus);
    }

    @Override
    public void editLaborMarketStatus(LaborMarketStatus laborMarketStatus) {
        Optional<LaborMarketStatus> optionalLaborMarketStatus = laborMarketStatusRepo.findById(laborMarketStatus.getIdLaborMarketStatus());
        if(optionalLaborMarketStatus.isPresent()) {
            LaborMarketStatus updateLaborMarketStatus = optionalLaborMarketStatus.get();
            updateLaborMarketStatus.setDisabledPerson(laborMarketStatus.isDisabledPerson());
            updateLaborMarketStatus.setEmigrant(laborMarketStatus.isEmigrant());
            updateLaborMarketStatus.setEmployedInBigEnterprise(laborMarketStatus.isEmployedInBigEnterprise());
            updateLaborMarketStatus.setEmployedInGovernmentAdministration(laborMarketStatus.isEmployedInGovernmentAdministration());
            updateLaborMarketStatus.setEmployedInLocalGovernmentAdministration(laborMarketStatus.isEmployedInLocalGovernmentAdministration());
            updateLaborMarketStatus.setEmployedInMicroSmallMediumEnterprise(laborMarketStatus.isEmployedInMicroSmallMediumEnterprise());
            updateLaborMarketStatus.setEmployedInNonGovernmentalOrganization(laborMarketStatus.isEmployedInNonGovernmentalOrganization());
            updateLaborMarketStatus.setLearningPerson(laborMarketStatus.isLearningPerson());
            updateLaborMarketStatus.setLongTermUnemployed(laborMarketStatus.isLongTermUnemployed());
            updateLaborMarketStatus.setNameOfWorkplace(laborMarketStatus.getNameOfWorkplace());
            updateLaborMarketStatus.setNationalMinority(laborMarketStatus.isNationalMinority());
            updateLaborMarketStatus.setNotLearningPerson(laborMarketStatus.isNotLearningPerson());
            updateLaborMarketStatus.setOccupationPerformed(laborMarketStatus.getOccupationPerformed());
            updateLaborMarketStatus.setOther(laborMarketStatus.isOther());
            updateLaborMarketStatus.setProfessionallyInactive(laborMarketStatus.isProfessionallyInactive());
            updateLaborMarketStatus.setSelfEmployed(laborMarketStatus.isSelfEmployed());
            updateLaborMarketStatus.setUnemployedPerson(laborMarketStatus.isUnemployedPerson());
            updateLaborMarketStatus.setWorking(laborMarketStatus.isWorking());
            laborMarketStatusRepo.save(updateLaborMarketStatus);
        }
    }

    @Override
    public boolean deleteLaborMarketStatus(long id) {
        Optional<LaborMarketStatus> laborMarketStatus = laborMarketStatusRepo.findById(id);
        if(laborMarketStatus.isPresent()){
            laborMarketStatusRepo.deleteById(id);
            return true;
        } else return false;
    }
}
