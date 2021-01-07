package pl.pancerro.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.pancerro.backend.model.UniversityCourses;

import javax.persistence.Tuple;
import java.util.List;

public interface UniversityCoursesRepo extends JpaRepository<UniversityCourses,Long> {
    @Query(value = "SELECT wydzialy_uniwersytetu.nazwa_wydzialu as nameDepartments, kierunki_studiow.id_wydzialu, COUNT(kierunki_studiow.id_kierunku) as countCourses FROM kierunki_studiow INNER JOIN wydzialy_uniwersytetu ON kierunki_studiow.id_wydzialu = wydzialy_uniwersytetu.id_wydzialu GROUP BY kierunki_studiow.id_wydzialu;",nativeQuery = true)
    List<Tuple> getCountCoursesInDepartment();
}
