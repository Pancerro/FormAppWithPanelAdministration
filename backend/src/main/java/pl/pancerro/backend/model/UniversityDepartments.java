package pl.pancerro.backend.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Wydzialy_Uniwersytetu")
public class UniversityDepartments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Wydzialu")
    private long idDepartments;
    @Column(name = "Nazwa_Wydzialu")
    private String nameDepartments;
    @Column(name = "Skrot")
    private String shortcut;
    public UniversityDepartments() {
    }

    public UniversityDepartments(String nameDepartments, String shortcut) {
        this.nameDepartments = nameDepartments;
        this.shortcut = shortcut;
    }

    public long getIdDepartments() {
        return idDepartments;
    }

    public void setIdDepartments(long idDepartments) {
        this.idDepartments = idDepartments;
    }

    public String getNameDepartments() {
        return nameDepartments;
    }

    public void setNameDepartments(String nameDepartments) {
        this.nameDepartments = nameDepartments;
    }

    public String getShortcut() {
        return shortcut;
    }

    public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
    }

}
