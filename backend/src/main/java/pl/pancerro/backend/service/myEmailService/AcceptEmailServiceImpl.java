package pl.pancerro.backend.service.myEmailService;

import org.springframework.stereotype.Service;
import pl.pancerro.backend.model.message.AcceptEmail;
import pl.pancerro.backend.repository.AcceptEmailRepo;

import java.util.Optional;
@Service
public class AcceptEmailServiceImpl implements AcceptEmailService {
    private final AcceptEmailRepo acceptEmailRepo;

    public AcceptEmailServiceImpl(AcceptEmailRepo acceptEmailRepo) {
        this.acceptEmailRepo = acceptEmailRepo;
    }

    @Override
    public void addAcceptEmail(AcceptEmail acceptEmail) {
        acceptEmailRepo.save(acceptEmail);
    }

    @Override
    public boolean editAcceptEmail(AcceptEmail acceptEmail) {
        Optional<AcceptEmail> optionalAcceptEmail = acceptEmailRepo.findById(1L);
        if(optionalAcceptEmail.isPresent()) {
            AcceptEmail updateAcceptEmail = optionalAcceptEmail.get();
            updateAcceptEmail.setSubjectEmail(acceptEmail.getSubjectEmail());
            updateAcceptEmail.setTextEmail(acceptEmail.getTextEmail());
            updateAcceptEmail.setHtml(acceptEmail.isHtml());
            acceptEmailRepo.save(updateAcceptEmail);
            return true;
        } else return false;
    }

    @Override
    public boolean deleteAcceptEmail() {
        Optional<AcceptEmail> optionalAcceptEmail = acceptEmailRepo.findById(1L);
        if(optionalAcceptEmail.isPresent()) {
            acceptEmailRepo.deleteById(1L);
            return true;
        } else return false;
    }

    @Override
    public AcceptEmail getAcceptEmail() {
        return acceptEmailRepo.findById(1L).get();
    }
}
