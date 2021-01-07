package pl.pancerro.backend.service.memberService.basicInformationService;

import pl.pancerro.backend.model.member.BasicInformation;

import java.util.List;

public interface BasicInformationService {
    List<BasicInformation> getBasicInformationList();
    void addBasicInformation(BasicInformation basicInformation);
    void editBasicInformation(BasicInformation basicInformation);
    boolean deleteBasicInformation(long id);
}
