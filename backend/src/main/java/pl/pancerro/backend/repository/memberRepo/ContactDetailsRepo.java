package pl.pancerro.backend.repository.memberRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pancerro.backend.model.member.ContactDetails;

public interface ContactDetailsRepo extends JpaRepository<ContactDetails,Long> {
}
