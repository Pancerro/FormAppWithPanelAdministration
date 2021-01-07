package pl.pancerro.backend.service.formService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pancerro.backend.model.Member;
import pl.pancerro.backend.model.Project;
import pl.pancerro.backend.model.UniversityCourses;
import pl.pancerro.backend.model.UniversityDepartments;

import pl.pancerro.backend.model.message.AcceptEmail;
import pl.pancerro.backend.model.message.MyEmail;
import pl.pancerro.backend.model.message.WebStarterDesc;
import pl.pancerro.backend.service.memberService.MemberService;
import pl.pancerro.backend.service.myEmailService.AcceptEmailService;
import pl.pancerro.backend.service.projectService.ProjectService;
import pl.pancerro.backend.service.univeristyService.universityCoursesService.UniversityCoursesService;
import pl.pancerro.backend.service.univeristyService.universityDepartmentsService.UniversityDepartmentsService;
import pl.pancerro.backend.service.webStarterDescService.WebStarterDescService;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Optional;

@Service
public class FormServiceImpl implements FormService{


    private final MemberService memberService;
    private final ProjectService projectService;
    private final UniversityCoursesService universityCoursesService;
    private final UniversityDepartmentsService universityDepartmentsService;
    private final AcceptEmailService acceptEmailService;
    private final WebStarterDescService webStarterDescService;
    @Autowired
    public FormServiceImpl(MemberService memberService, ProjectService projectService, UniversityCoursesService universityCoursesService, UniversityDepartmentsService universityDepartmentsService, AcceptEmailService acceptEmailService, WebStarterDescService webStarterDescService) {
        this.memberService = memberService;
        this.projectService = projectService;
        this.universityCoursesService = universityCoursesService;
        this.universityDepartmentsService = universityDepartmentsService;
        this.acceptEmailService = acceptEmailService;
        this.webStarterDescService = webStarterDescService;
    }

    @Override
    public List<UniversityCourses> getUniversityCourses(){
        return universityCoursesService.getUniversityCourses();
    }
    @Override
    public List<UniversityDepartments> getUniversityDepartments(){
        return universityDepartmentsService.getUniversityDepartmentsList();
    }
    @Override
    public List<Project> getActiveProject() {
        return projectService.getActiveProject();
    }
    @Override
    public WebStarterDesc getWebStarterDesc() {
        return webStarterDescService.getWebStarterDesc();
    }
    @Override
    public boolean sendForm(Member member, long idProject) throws MessagingException {
        Project project = projectService.getProjectById(idProject);
        if(this.memberService.addMember(member,project)){
            Optional<AcceptEmail> optionalAcceptEmail = Optional.ofNullable(acceptEmailService.getAcceptEmail());
            if(optionalAcceptEmail.isPresent()) {
                MyEmail myEmail = new MyEmail(member.getContactDetails().getEmail(),
                        optionalAcceptEmail.get().getSubjectEmail(),
                        optionalAcceptEmail.get().getTextEmail(),
                        optionalAcceptEmail.get().isHtml());
                memberService.sendEmail(myEmail);
            }
            return true;
    } else return false;
    }
}
