package pl.pancerro.backend.repository.memberRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pancerro.backend.model.member.AdditionalInformation;

public interface AdditionalInformationRepo extends JpaRepository<AdditionalInformation,Long> {
}
