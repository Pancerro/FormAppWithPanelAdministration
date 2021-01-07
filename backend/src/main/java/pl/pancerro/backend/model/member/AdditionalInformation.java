package pl.pancerro.backend.model.member;



import javax.persistence.*;

@Entity
@Table(name = "Informacje_Dodatkowe")
public class AdditionalInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Informacji_Dodatkowych")
    private long idAdditional;
    @Column(name = "Powtarza_rok")
    private boolean repeatYear; //powtarzam rok
    @Column(name = "Studiuje_inny_kierunek")
    private boolean studyingAnotherDirection; //studiuje inny kierunek
    @Column(name = "Nazwa_Uniwersytetu")
    private String nameUniversity;
    @Column(name = "Wydzial")
    private String department;
    @Column(name = "Kierunek_Studiow")
    private String fieldOfStudy;
    @Column(name = "Specjalnosc")
    private String profile;
    @Column(name = "Rok_rozpoczacia_studiow")
    private String yearStartStudy;
    @Column(name = "Odbyte_Praktyki_Rodzaj_Praktyki_Oraz_Rok")
    private String workPlacementAndYear; // odbyte praktyki - rodzaj praktyki oraz rok
    @Column(name = "Studiuje_Na_Innym_Uniwersytecie")
    private boolean studiedAnotherUniversity;
    @Column(name = "Nazwa_Innego_Uniwersytetu")
    private String nameAnotherUniversity;
    @Column(name = "Wydzial_IU")
    private String departmentAnother;
    @Column(name = "Kierunek_Studiow_IU")
    private String fieldOfStudyAnother;
    @Column(name = "Specjalnosc_IU")
    private String profileAnother;
    @Column(name = "Rok_rozpoczacia_studiow_IU")
    private String yearStartAndEndStudyAnother;
    @Column(name = "Odbyte_Praktyki_Rodzaj_Praktyki_Oraz_Rok_IU")
    private String workPlacementAndYearAnother;
    public AdditionalInformation() {
    }

    public AdditionalInformation(boolean repeatYear, boolean studyingAnotherDirection, String nameUniversity, String department, String fieldOfStudy, String profile, String yearStartStudy, String workPlacementAndYear, boolean studiedAnotherUniversity, String nameAnotherUniversity, String departmentAnother, String fieldOfStudyAnother, String profileAnother, String yearStartAndEndStudyAnother, String workPlacementAndYearAnother) {
        this.repeatYear = repeatYear;
        this.studyingAnotherDirection = studyingAnotherDirection;
        this.nameUniversity = nameUniversity;
        this.department = department;
        this.fieldOfStudy = fieldOfStudy;
        this.profile = profile;
        this.yearStartStudy = yearStartStudy;
        this.workPlacementAndYear = workPlacementAndYear;
        this.studiedAnotherUniversity = studiedAnotherUniversity;
        this.nameAnotherUniversity = nameAnotherUniversity;
        this.departmentAnother = departmentAnother;
        this.fieldOfStudyAnother = fieldOfStudyAnother;
        this.profileAnother = profileAnother;
        this.yearStartAndEndStudyAnother = yearStartAndEndStudyAnother;
        this.workPlacementAndYearAnother = workPlacementAndYearAnother;
    }

    public long getIdAdditional() {
        return idAdditional;
    }

    public void setIdAdditional(long idAdditional) {
        this.idAdditional = idAdditional;
    }

    public boolean isRepeatYear() {
        return repeatYear;
    }

    public void setRepeatYear(boolean repeatYear) {
        this.repeatYear = repeatYear;
    }

    public boolean isStudyingAnotherDirection() {
        return studyingAnotherDirection;
    }

    public void setStudyingAnotherDirection(boolean studyingAnotherDirection) {
        this.studyingAnotherDirection = studyingAnotherDirection;
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

    public void setDepartment(String department) {
        this.department = department;
    }

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

    public String getYearStartStudy() {
        return yearStartStudy;
    }

    public void setYearStartStudy(String yearStartStudy) {
        this.yearStartStudy = yearStartStudy;
    }

    public String getWorkPlacementAndYear() {
        return workPlacementAndYear;
    }

    public void setWorkPlacementAndYear(String workPlacementAndYear) {
        this.workPlacementAndYear = workPlacementAndYear;
    }

    public boolean isStudiedAnotherUniversity() {
        return studiedAnotherUniversity;
    }

    public void setStudiedAnotherUniversity(boolean studiedAnotherUniversity) {
        this.studiedAnotherUniversity = studiedAnotherUniversity;
    }

    public String getNameAnotherUniversity() {
        return nameAnotherUniversity;
    }

    public void setNameAnotherUniversity(String nameAnotherUniversity) {
        this.nameAnotherUniversity = nameAnotherUniversity;
    }

    public String getDepartmentAnother() {
        return departmentAnother;
    }

    public void setDepartmentAnother(String departmentAnother) {
        this.departmentAnother = departmentAnother;
    }

    public String getFieldOfStudyAnother() {
        return fieldOfStudyAnother;
    }

    public void setFieldOfStudyAnother(String fieldOfStudyAnother) {
        this.fieldOfStudyAnother = fieldOfStudyAnother;
    }

    public String getProfileAnother() {
        return profileAnother;
    }

    public void setProfileAnother(String profileAnother) {
        this.profileAnother = profileAnother;
    }

    public String getYearStartAndEndStudyAnother() {
        return yearStartAndEndStudyAnother;
    }

    public void setYearStartAndEndStudyAnother(String yearStartAndEndStudyAnother) {
        this.yearStartAndEndStudyAnother = yearStartAndEndStudyAnother;
    }

    public String getWorkPlacementAndYearAnother() {
        return workPlacementAndYearAnother;
    }

    public void setWorkPlacementAndYearAnother(String workPlacementAndYearAnother) {
        this.workPlacementAndYearAnother = workPlacementAndYearAnother;
    }
}
