package pl.pancerro.backend.service.memberService.contactDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pancerro.backend.model.member.ContactDetails;
import pl.pancerro.backend.repository.memberRepo.ContactDetailsRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ContactDetailsServiceImpl implements ContactDetailsService {
    private final ContactDetailsRepo contactDetailsRepo;
    @Autowired
    public ContactDetailsServiceImpl(ContactDetailsRepo contactDetailsRepo) {
        this.contactDetailsRepo = contactDetailsRepo;
    }

    @Override
    public List<ContactDetails> getContactDetailsList() {
        return contactDetailsRepo.findAll();
    }

    @Override
    public void addContactDetails(ContactDetails contactDetails) {
        contactDetailsRepo.save(contactDetails);
    }

    @Override
    public void editContactDetails(ContactDetails contactDetails) {
        Optional<ContactDetails> optionalContactDetails = contactDetailsRepo.findById(contactDetails.getIdContact());
        if(optionalContactDetails.isPresent()) {
            ContactDetails updateContact = optionalContactDetails.get();
            updateContact.setArea(contactDetails.getArea());
            updateContact.setCommunity(contactDetails.getCommunity());
            updateContact.setDistrict(contactDetails.getDistrict());
            updateContact.setEmail(contactDetails.getEmail());
            updateContact.setHouseNumber(contactDetails.getHouseNumber());
            updateContact.setPhoneNumber(contactDetails.getPhoneNumber());
            updateContact.setPostalCode(contactDetails.getPostalCode());
            updateContact.setPostOffice(contactDetails.getPostOffice());
            updateContact.setStreet(contactDetails.getStreet());
            updateContact.setTownship(contactDetails.getTownship());
            updateContact.setVoivodeship(contactDetails.getVoivodeship());
            contactDetailsRepo.save(updateContact);
        }
    }

    @Override
    public boolean deleteContactDetails(long id) {
        Optional<ContactDetails> optionalContactDetails = contactDetailsRepo.findById(id);
        if(optionalContactDetails.isPresent()) {
            contactDetailsRepo.deleteById(id);
            return true;
        } else return false;
    }
}
