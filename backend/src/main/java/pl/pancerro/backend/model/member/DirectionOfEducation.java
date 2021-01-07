package pl.pancerro.backend.model.member;

import pl.pancerro.backend.model.enumPack.DegreeOfStudy;


import javax.persistence.*;

@Entity
@Table(name = "Edukacja_Studia")
public class DirectionOfEducation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Edukacji_Studii")
    private long idDirectionOfEducation;
    @Column(name = "Nazwa_uniwersytetu")
    private String nameUniversity; // nazwa uczelni
    @Column(name = "Wydzial")
    private String department; //wydzial
    @Column(name = "Kierunek_Studiow")
    private String fieldOfStudy; // kierunek studiow
    @Column(name = "Specjalnosc")
    private String profile; // specjalnosc / profil
    @Enumerated(EnumType.STRING)
    @Column(name = "Stopien_Studiow")
    private DegreeOfStudy degreeOfStudies; // stopien studiow
    @Column(name = "Rok_Rozpoczecia_Studiow")
    private String yearStartStudy; // rok rozpaczecia studiow
    public DirectionOfEducation() {
    }

    public DirectionOfEducation(String nameUniversity, String department, String fieldOfStudy, String profile, DegreeOfStudy degreeOfStudies, String yearStartStudy) {
        this.nameUniversity = nameUniversity;
        this.department = department;
        this.fieldOfStudy = fieldOfStudy;
        this.profile = profile;
        this.degreeOfStudies = degreeOfStudies;
        this.yearStartStudy = yearStartStudy;
    }

    public long getIdDirectionOfEducation() {
        return idDirectionOfEducation;
    }

    public void setIdDirectionOfEducation(long idDirectionOfEducation) {
        this.idDirectionOfEducation = idDirectionOfEducation;
    }

    public String getNameUniversity() {
        return nameUniversity;
    }

    public void setNameUniversity(String nameUniversity) {
        this.nameUniversity = nameUniversity;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) { this.department = department; }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public DegreeOfStudy getDegreeOfStudies() {
        return degreeOfStudies;
    }

    public void setDegreeOfStudies(DegreeOfStudy degreeOfStudies) {
        this.degreeOfStudies = degreeOfStudies;
    }

    public String getYearStartStudy() {
        return yearStartStudy;
    }

    public void setYearStartStudy(String yearStartStudy) {
        this.yearStartStudy = yearStartStudy;
    }

}
