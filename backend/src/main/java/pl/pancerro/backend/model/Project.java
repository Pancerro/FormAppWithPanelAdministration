package pl.pancerro.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "Projekty")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Projektu")
    private long idProject;
    @Column(name = "Nazwa_Projektu")
    private String nameProject;
    @Column(name = "Opis_Projecktu")
    private String descriptionProject;
    @Column(name = "Data_Rozpoczacia")
    private String dataStart;
    @Column(name = "Data_Zakonczenia")
    private String dataEnd;
    @Column(name = "Aktywny")
    private boolean active;


    public Project() {
    }

    public Project(String nameProject, String descriptionProject, String dataStart, String dataEnd, Boolean active) {
        this.nameProject = nameProject;
        this.descriptionProject = descriptionProject;
        this.dataStart = dataStart;
        this.dataEnd = dataEnd;
        this.active = active;
    }

    public long getIdProject() {
        return idProject;
    }

    public void setIdProject(long idProject) {
        this.idProject = idProject;
    }

    public String getNameProject() {
        return nameProject;
    }

    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    public String getDescriptionProject() {
        return descriptionProject;
    }

    public void setDescriptionProject(String descriptionProject) {
        this.descriptionProject = descriptionProject;
    }

    public String getDataStart() {
        return dataStart;
    }

    public void setDataStart(String dataStart) {
        this.dataStart = dataStart;
    }

    public String getDataEnd() {
        return dataEnd;
    }

    public void setDataEnd(String dataEnd) {
        this.dataEnd = dataEnd;
    }
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }



}
