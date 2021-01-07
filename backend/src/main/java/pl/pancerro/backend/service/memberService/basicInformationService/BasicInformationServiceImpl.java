package pl.pancerro.backend.service.memberService.basicInformationService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pancerro.backend.model.member.BasicInformation;
import pl.pancerro.backend.repository.memberRepo.BasicInformationRepo;

import java.util.List;
import java.util.Optional;
@Service
public class BasicInformationServiceImpl implements BasicInformationService {
    private final BasicInformationRepo basicInformationRepo;
    @Autowired
    public BasicInformationServiceImpl(BasicInformationRepo basicInformationRepo) {
        this.basicInformationRepo = basicInformationRepo;
    }

    @Override
    public List<BasicInformation> getBasicInformationList() {
        return basicInformationRepo.findAll();
    }

    @Override
    public void addBasicInformation(BasicInformation basicInformation) {
        Optional<BasicInformation> optionalBasicInformation = basicInformationRepo.findById(basicInformation.getIdBasic());
        if(!optionalBasicInformation.isPresent()) basicInformationRepo.save(basicInformation);
    }

    @Override
    public void editBasicInformation(BasicInformation basicInformation) {
        Optional<BasicInformation> optionalBasicInformation = basicInformationRepo.findById(basicInformation.getIdBasic());
        if(optionalBasicInformation.isPresent()) {
            BasicInformation updateBasicInformation = optionalBasicInformation.get();
            updateBasicInformation.setAge(basicInformation.getAge());
            updateBasicInformation.setEducation(basicInformation.getEducation());
            updateBasicInformation.setIdNumber(basicInformation.getIdNumber());
            updateBasicInformation.setName(basicInformation.getName());
            updateBasicInformation.setPesel(basicInformation.getPesel());
            updateBasicInformation.setSurname(basicInformation.getSurname());
            basicInformationRepo.save(updateBasicInformation);
        }

    }

    @Override
    public boolean deleteBasicInformation(long id) {
        Optional<BasicInformation> optionalBasicInformation = basicInformationRepo.findById(id);
        if(optionalBasicInformation.isPresent()) {
            basicInformationRepo.deleteById(id);
            return true;
        } else return false;
    }
}
