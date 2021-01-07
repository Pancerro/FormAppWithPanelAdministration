package pl.pancerro.backend.model.member;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.pl.PESEL;
import pl.pancerro.backend.model.enumPack.Education;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Informacje_Podstawowe")
public class BasicInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Podstawowych_Informacji")
    private  long idBasic;
    @NotEmpty
    @Length(min = 2)
    @Column(name = "Imie")
    private String name;
    @NotEmpty
    @Length(min = 2)
    @Column(name = "Nazwisko")
    private String surname;
    @PESEL
    @NotEmpty
    @Column(name = "Pesel")
    private String pesel;
    @NotEmpty
    @Column(name = "Numer_dowodu_osobistego")
    private String idNumber; //numer dowodu osobistego
    @Min(0)
    @Max(130)
    @Column(name = "Wiek")
    private int age;
    @Enumerated(EnumType.STRING)
    @Column(name = "Poziom_Wyksztalcenia")
    private Education education;

    public BasicInformation() {
    }

    public BasicInformation(String name, String surname, String pesel, String idNumber, int age, Education education) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.idNumber = idNumber;
        this.age = age;
        this.education = education;
    }

    public long getIdBasic() {
        return idBasic;
    }

    public void setIdBasic(long idBasic) {
        this.idBasic = idBasic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

}
