package pl.pancerro.backend.repository.memberRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pancerro.backend.model.member.DirectionOfEducation;

public interface DirectionOfEducationRepo extends JpaRepository<DirectionOfEducation,Long> {
}
