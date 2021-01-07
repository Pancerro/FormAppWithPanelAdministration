package pl.pancerro.backend.repository.memberRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pancerro.backend.model.member.Statement;

public interface StatementRepo extends JpaRepository<Statement,Long> {
}
