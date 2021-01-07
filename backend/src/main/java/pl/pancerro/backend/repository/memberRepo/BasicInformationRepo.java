package pl.pancerro.backend.repository.memberRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pancerro.backend.model.member.BasicInformation;

public interface BasicInformationRepo extends JpaRepository<BasicInformation,Long> {
}
