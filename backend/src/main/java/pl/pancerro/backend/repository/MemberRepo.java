package pl.pancerro.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.pancerro.backend.model.Member;

import javax.persistence.Tuple;
import java.util.List;

public interface MemberRepo extends JpaRepository<Member,Long> {
    @Query(value = "SELECT informacje_podstawowe.wiek as age, COUNT(informacje_podstawowe.wiek) as countAge FROM informacje_podstawowe GROUP BY informacje_podstawowe.wiek;",nativeQuery = true)
    List<Tuple> getCountMemberInAge();
    @Query(value = "SELECT LEFT(RIGHT(informacje_podstawowe.pesel,2),1) as sex, COUNT(informacje_podstawowe.imie) as countSex FROM informacje_podstawowe GROUP BY informacje_podstawowe.pesel;",nativeQuery = true)
    List<Tuple> getCountSexInMember();
    @Query(value = "SELECT informacje_podstawowe.poziom_wyksztalcenia as education, COUNT(informacje_podstawowe.id_podstawowych_informacji) as countEducation FROM informacje_podstawowe GROUP BY informacje_podstawowe.poziom_wyksztalcenia;",nativeQuery = true)
    List<Tuple> getCountEducationInMember();
    @Query(value = "SELECT dane_kontatkowe.obszar as area, COUNT(dane_kontatkowe.id_kontatku) as countArea FROM dane_kontatkowe GROUP BY dane_kontatkowe.obszar;",nativeQuery = true)
    List<Tuple> getCountAreaInMember();
}
