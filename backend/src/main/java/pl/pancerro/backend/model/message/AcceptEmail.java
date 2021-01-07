package pl.pancerro.backend.model.message;

import javax.persistence.*;

@Entity
@Table(name = "CheckedEmail")
public class AcceptEmail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Email")
    private long idEmail;
    @Column(name = "Tytul_Emaila")
    private String subjectEmail;
    @Column(name = "Tresc_Emaila",columnDefinition="TEXT")
    private String textEmail;
    @Column(name = "isHtml")
    private boolean html;

    public AcceptEmail() {
    }

    public AcceptEmail(String subjectEmail, String textEmail, boolean html) {
        this.subjectEmail = subjectEmail;
        this.textEmail = textEmail;
        this.html = html;
    }

    public long getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(long idEmail) {
        this.idEmail = idEmail;
    }

    public String getSubjectEmail() {
        return subjectEmail;
    }

    public void setSubjectEmail(String subjectEmail) {
        this.subjectEmail = subjectEmail;
    }

    public String getTextEmail() {
        return textEmail;
    }

    public void setTextEmail(String textEmail) {
        this.textEmail = textEmail;
    }

    public boolean isHtml() {
        return html;
    }

    public void setHtml(boolean html) {
        this.html = html;
    }
}
