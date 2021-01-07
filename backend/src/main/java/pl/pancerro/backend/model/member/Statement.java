package pl.pancerro.backend.model.member;

import javax.persistence.*;

@Entity
@Table(name = "Oswiadczenia")
public class Statement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Oswiadczenia")
    private long idStatement;
    @Column(name = "Osoba_Bezdomna")
    private String homelessPerson;
    @Column(name = "Osoba_w_niekorzystnej_sytuacji")
    private String anotherUnfavorablePersonSocialSituation;
    @Column(name = "Akceptacja_zgod")
    private boolean statement;
    public Statement() {
    }

    public Statement(String homelessPerson, String anotherUnfavorablePersonSocialSituation, boolean statement) {
        this.homelessPerson = homelessPerson;
        this.anotherUnfavorablePersonSocialSituation = anotherUnfavorablePersonSocialSituation;
        this.statement = statement;
    }

    public long getIdStatement() {
        return idStatement;
    }

    public void setIdStatement(long idStatement) {
        this.idStatement = idStatement;
    }

    public String getHomelessPerson() {
        return homelessPerson;
    }

    public void setHomelessPerson(String homelessPerson) {
        this.homelessPerson = homelessPerson;
    }

    public String getAnotherUnfavorablePersonSocialSituation() {
        return anotherUnfavorablePersonSocialSituation;
    }

    public void setAnotherUnfavorablePersonSocialSituation(String anotherUnfavorablePersonSocialSituation) {
        this.anotherUnfavorablePersonSocialSituation = anotherUnfavorablePersonSocialSituation;
    }

    public boolean isStatement() {
        return statement;
    }

    public void setStatement(boolean statement) {
        this.statement = statement;
    }

}
