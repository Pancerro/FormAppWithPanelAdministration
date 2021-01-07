package pl.pancerro.backend.repository.memberRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pancerro.backend.model.member.LaborMarketStatus;


public interface LaborMarketStatusRepo extends JpaRepository<LaborMarketStatus,Long> {
}
