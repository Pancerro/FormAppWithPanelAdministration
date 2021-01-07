package pl.pancerro.backend.service.webStarterDescService;

import pl.pancerro.backend.model.message.WebStarterDesc;

public interface WebStarterDescService {
    void addWebStarterDesc(WebStarterDesc webStarterDesc);
    boolean editWebStarterDesc(WebStarterDesc webStarterDesc);
    boolean deleteWebStarterDesc();
    WebStarterDesc getWebStarterDesc();
}
