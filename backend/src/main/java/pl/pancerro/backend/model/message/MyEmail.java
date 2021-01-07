package pl.pancerro.backend.model.message;

public class MyEmail {
    String email;
    String subject;
    String text;
    boolean isHtml;

    public MyEmail(String email, String subject, String text, boolean isHtml) {
        this.email = email;
        this.subject = subject;
        this.text = text;
        this.isHtml = isHtml;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return isHtml;
    }

    public void setHtml(boolean html) {
        isHtml = html;
    }
}
