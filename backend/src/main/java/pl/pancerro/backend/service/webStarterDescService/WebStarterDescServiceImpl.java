package pl.pancerro.backend.service.webStarterDescService;

import org.springframework.stereotype.Service;
import pl.pancerro.backend.model.message.WebStarterDesc;
import pl.pancerro.backend.repository.WebStarterDescRepo;

import java.util.Optional;

@Service
public class WebStarterDescServiceImpl implements WebStarterDescService {
    private final WebStarterDescRepo webStarterDescRepo;

    public WebStarterDescServiceImpl(WebStarterDescRepo webStarterDescRepo) {
        this.webStarterDescRepo = webStarterDescRepo;
    }

    @Override
    public void addWebStarterDesc(WebStarterDesc webStarterDesc) {
        this.webStarterDescRepo.save(webStarterDesc);
    }

    @Override
    public boolean editWebStarterDesc(WebStarterDesc webStarterDesc) {
        Optional<WebStarterDesc> optionalWebStarterDesc = webStarterDescRepo.findById(1L);
        if(optionalWebStarterDesc.isPresent()) {
            WebStarterDesc updateWebStarterDesc = optionalWebStarterDesc.get();
            updateWebStarterDesc.setSubject(webStarterDesc.getSubject());
            updateWebStarterDesc.setText(webStarterDesc.getText());
            updateWebStarterDesc.setHtml(webStarterDesc.isHtml());
            webStarterDescRepo.save(updateWebStarterDesc);
            return true;
        } else return false;
    }

    @Override
    public boolean deleteWebStarterDesc() {
        Optional<WebStarterDesc> optionalWebStarterDesc = webStarterDescRepo.findById(1L);
        if(optionalWebStarterDesc.isPresent()) {
            webStarterDescRepo.deleteById(1L);
            return true;
        } else return false;
    }

    @Override
    public WebStarterDesc getWebStarterDesc() {
        return webStarterDescRepo.findById(1L).get();
    }
}


