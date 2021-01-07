package pl.pancerro.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "Kierunki_Studiow")
public class UniversityCourses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Kierunku")
    private long idCourses;
    @Column(name = "Nazwa_Kierunku")
    private String nameCourses;
    @ManyToOne
    @JoinColumn(name = "id_Wydzialu")
    private UniversityDepartments universityDepartments;

    public UniversityCourses() {
    }

    public UniversityCourses(String nameCourses) {
        this.nameCourses = nameCourses;
    }

    public long getIdCourses() {
        return idCourses;
    }

    public void setIdCourses(long idCourses) {
        this.idCourses = idCourses;
    }

    public String getNameCourses() {
        return nameCourses;
    }

    public void setNameCourses(String nameCourses) {
        this.nameCourses = nameCourses;
    }

    public UniversityDepartments getUniversityDepartments() {
        return universityDepartments;
    }

    public void setUniversityDepartments(UniversityDepartments universityDepartments) {
        this.universityDepartments = universityDepartments;
    }
}
