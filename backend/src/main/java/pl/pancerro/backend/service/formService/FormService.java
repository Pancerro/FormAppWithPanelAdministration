package pl.pancerro.backend.service.formService;

import pl.pancerro.backend.model.Member;
import pl.pancerro.backend.model.Project;
import pl.pancerro.backend.model.UniversityCourses;
import pl.pancerro.backend.model.UniversityDepartments;
import pl.pancerro.backend.model.message.WebStarterDesc;

import javax.mail.MessagingException;
import java.util.List;

public interface FormService {
    boolean sendForm(Member member,long idProject) throws MessagingException;
    List<UniversityCourses> getUniversityCourses();
    List<UniversityDepartments> getUniversityDepartments();
    List<Project> getActiveProject();
    WebStarterDesc getWebStarterDesc();

}
