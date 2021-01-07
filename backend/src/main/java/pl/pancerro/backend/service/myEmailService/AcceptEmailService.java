package pl.pancerro.backend.service.myEmailService;

import pl.pancerro.backend.model.message.AcceptEmail;


public interface AcceptEmailService {
    void addAcceptEmail(AcceptEmail acceptEmail);
    boolean editAcceptEmail(AcceptEmail acceptEmail);
    boolean deleteAcceptEmail();
    AcceptEmail getAcceptEmail();
}
