package pl.pancerro.backend.service.memberService.contactDetailsService;

import pl.pancerro.backend.model.member.ContactDetails;

import java.util.List;

public interface ContactDetailsService {
    List<ContactDetails> getContactDetailsList();
    void addContactDetails(ContactDetails contactDetails);
    void editContactDetails(ContactDetails contactDetails);
    boolean deleteContactDetails(long id);
}
