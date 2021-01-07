package pl.pancerro.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pancerro.backend.model.message.WebStarterDesc;

public interface WebStarterDescRepo extends JpaRepository<WebStarterDesc,Long> {
}
