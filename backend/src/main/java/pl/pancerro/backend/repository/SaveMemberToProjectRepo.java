package pl.pancerro.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.pancerro.backend.model.SaveMemberToProject;

import javax.persistence.Tuple;
import java.util.List;

public interface SaveMemberToProjectRepo extends JpaRepository<SaveMemberToProject,Long> {
    SaveMemberToProject findByMember_IdMember(long id);
    @Query(value = "    SELECT projekty.nazwa_projektu as projectName, COUNT(uzytkownicy_w_projeckie.id_member) as countMember FROM uzytkownicy_w_projeckie INNER JOIN projekty ON uzytkownicy_w_projeckie.id_project = projekty.id_projektu GROUP BY projekty.nazwa_projektu;",nativeQuery = true)
    List<Tuple> getCountMemberInProject();
}
