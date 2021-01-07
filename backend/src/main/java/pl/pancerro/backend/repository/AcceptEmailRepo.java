package pl.pancerro.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pancerro.backend.model.message.AcceptEmail;

public interface AcceptEmailRepo extends JpaRepository<AcceptEmail,Long> {
}
