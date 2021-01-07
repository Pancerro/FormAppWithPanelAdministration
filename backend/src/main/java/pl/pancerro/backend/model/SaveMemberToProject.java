package pl.pancerro.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "Uzytkownicy_w_Projeckie")
public class SaveMemberToProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSave;
    @ManyToOne
    @JoinColumn(name = "id_member")
    private Member member;
    @ManyToOne
    @JoinColumn(name = "id_project")
    private Project project;

    public SaveMemberToProject() {
    }

    public SaveMemberToProject(Member member, Project project) {
        this.member = member;
        this.project = project;
    }

    public Long getIdSave() {
        return idSave;
    }

    public void setIdSave(Long idSave) {
        this.idSave = idSave;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
