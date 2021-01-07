package pl.pancerro.backend.service.memberService.additionalInformationService;

import pl.pancerro.backend.model.member.AdditionalInformation;


import java.util.List;

public interface AdditionalInformationService {
    List<AdditionalInformation> getAdditionalInformationList();
    void addAdditionalInformation(AdditionalInformation additionalInformation);
    void editAdditionalInformation(AdditionalInformation additionalInformation);
    boolean deleteAdditionalInformation(long id);
}
