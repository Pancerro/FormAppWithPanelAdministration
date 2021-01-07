package pl.pancerro.backend.model.message;

import javax.persistence.*;

@Entity
@Table(name = "WebStarter")
public class WebStarterDesc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "Tytul")
    private String subject;
    @Column(name = "Tresc",columnDefinition="TEXT")
    private String text;
    @Column(name = "isHtml")
    private boolean html;

    public WebStarterDesc() {
    }

    public WebStarterDesc(String subject, String text, boolean html) {
        this.subject = subject;
        this.text = text;
        this.html = html;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isHtml() {
        return html;
    }

    public void setHtml(boolean html) {
        this.html = html;
    }
}
