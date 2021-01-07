package pl.pancerro.backend.service.adminPanelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.pancerro.backend.model.*;
import pl.pancerro.backend.model.message.MyEmail;
import pl.pancerro.backend.model.message.AcceptEmail;
import pl.pancerro.backend.model.message.WebStarterDesc;
import pl.pancerro.backend.repository.UserRepo;
import pl.pancerro.backend.service.memberService.MemberService;
import pl.pancerro.backend.service.myEmailService.AcceptEmailService;
import pl.pancerro.backend.service.projectService.ProjectService;
import pl.pancerro.backend.service.saveMemberToProjectService.SaveMemberToProjectService;
import pl.pancerro.backend.service.univeristyService.universityCoursesService.UniversityCoursesService;
import pl.pancerro.backend.service.univeristyService.universityDepartmentsService.UniversityDepartmentsService;
import pl.pancerro.backend.service.webStarterDescService.WebStarterDescService;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Optional;

@Service
public class AdminPanelServiceImpl implements AdminPanelService {
    private final MemberService memberService;
    private final ProjectService projectService;
    private final AcceptEmailService acceptEmailService;
    private final WebStarterDescService webStarterDescService;
    private final UniversityDepartmentsService universityDepartmentsService;
    private final UniversityCoursesService universityCoursesService;
    private final SaveMemberToProjectService saveMemberToProjectService;
    private final UserRepo userRepo;
    public PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public AdminPanelServiceImpl(MemberService memberService, ProjectService projectService, AcceptEmailService acceptEmailService, WebStarterDescService webStarterDescService, UniversityDepartmentsService universityDepartmentsService, UniversityCoursesService universityCoursesService, SaveMemberToProjectService saveMemberToProjectService, UserRepo userRepo) {
        this.memberService = memberService;
        this.projectService = projectService;
        this.acceptEmailService = acceptEmailService;
        this.webStarterDescService = webStarterDescService;
        this.universityDepartmentsService = universityDepartmentsService;
        this.universityCoursesService = universityCoursesService;
        this.saveMemberToProjectService = saveMemberToProjectService;
        this.userRepo = userRepo;
    }

    @Override
    public List<Member> getAllMember() {
        return memberService.getMemberList();
    }
    @Override
    public boolean editMember(Member member) {
        if(this.memberService.editMember(member)) {
            return true;
        } else return false;
    }
    @Override
    public boolean deleteMember(long id) {
        if(this.memberService.deleteMember(id)) {
            return true;
        } else return false;
    }

    @Override
    public boolean addUniversityDepartment(UniversityDepartments universityDepartments) {
        this.universityDepartmentsService.addUniversityDepartments(universityDepartments);
        return true;
    }
    @Override
    public boolean editUniversityDepartment(UniversityDepartments universityDepartments){
        if(this.universityDepartmentsService.editUniversityDepartments(universityDepartments)){
            return true;
        } else return false;
    }
    @Override
    public boolean deleteUniversityDepartment(long id) {
        if(this.universityDepartmentsService.deleteUniversityDepartments(id)){
            return true;
        } else return false;
    }
    @Override
    public boolean addUniversityCourses(UniversityCourses universityCourses) {
        this.universityCoursesService.addUniversityCourses(universityCourses);
        return true;
    }
    @Override
    public boolean editUniversityCourses(UniversityCourses universityCourses) {
        if(this.universityCoursesService.editUniversityCourses(universityCourses)){
            return true;
        } else return false;
    }
    @Override
    public  boolean deleteUniversityCourses(long id) {
        if(this.universityCoursesService.deleteUniversityCourses(id)){
            return true;
        } else return false;
    }
    @Override
    public void addAcceptEmail(AcceptEmail acceptEmail) {
        acceptEmailService.addAcceptEmail(acceptEmail);
    }

    @Override
    public boolean editAcceptEmail(AcceptEmail acceptEmail) {
        if(acceptEmailService.editAcceptEmail(acceptEmail)) {
            return true;
        } else return false;
    }

    @Override
    public boolean deleteAcceptEmail() {
        if(acceptEmailService.deleteAcceptEmail()) {
            return true;
        } else return false;
    }

    @Override
    public AcceptEmail getAcceptEmail() {
        return acceptEmailService.getAcceptEmail();
    }

    @Override
    public void addWebStarterDesc(WebStarterDesc webStarterDesc) {
        webStarterDescService.addWebStarterDesc(webStarterDesc);
    }

    @Override
    public boolean editWebStarterDesc(WebStarterDesc webStarterDesc) {
        if(webStarterDescService.editWebStarterDesc(webStarterDesc)) {
            return true;
        } else return false;
    }

    @Override
    public boolean deleteWebStarterDesc() {
        if(webStarterDescService.deleteWebStarterDesc()) {
            return true;
        } else return false;
    }
    @Override
    public WebStarterDesc getWebStarterDesc() {
        return webStarterDescService.getWebStarterDesc();
    }
    @Override
    public List<Charts> getChartsMemberInAge() {
        return memberService.getChartsMemberInAge();
    }
    @Override
    public List<Charts> getChartsSexInMember() {
        return memberService.getSexInMember();
    }
    @Override
    public List<Charts> getChartsEducationInMember() {
        return memberService.getEducationInMember();
    }
    @Override
    public List<Charts> getChartsAreaInMember() {
        return memberService.getAreaInMember();
    }

    @Override
    public List<Charts> getChartsCountCoursesInDepartment() { return universityCoursesService.getChartsCoursesInDepartments();}
    @Override
    public void sendEmail(MyEmail myEmail) throws MessagingException {
        memberService.sendEmail(myEmail);
    }
    @Override
    public List<SaveMemberToProject> getSaveMemberToProject(){
        return saveMemberToProjectService.getSaveMemberToProjectList();
    }
    @Override
    public boolean editSaveMemberToProject(SaveMemberToProject saveMemberToProject) {
        if(saveMemberToProjectService.editSaveMemberToProject(saveMemberToProject)) {
            return true;
        } else return false;
    }
    @Override
    public boolean deleteSaveMemberToProject(long id) {
        if(saveMemberToProjectService.deleteSaveMemberToProject(id)) {
            return true;
        } else return false;
    }
    @Override

    public void addSaveMemberToProject(SaveMemberToProject saveMemberToProject) {
        saveMemberToProjectService.addSaveMemberToProject(saveMemberToProject);
    }
    @Override
    public List<Project> getProject(){
        return projectService.getProjectList();
    }
    @Override
    public boolean editProject(Project project) {
        if(projectService.editProject(project)) {
            return true;
        } else return false;
    }
    @Override
    public boolean deleteProject(long id) {
        if(projectService.deleteProject(id)) {
            return true;
        } else return false;
    }
    @Override
    public void addProject(Project project) {
        projectService.addProject(project);
    }
    @Override
    public List<Charts> getChartsMemberInProject() {
        return saveMemberToProjectService.getChartsMemberInProject();
    }
    @Override
    public boolean changePassword(String newPassword) {
        Optional<User> userOptional = Optional.ofNullable(userRepo.getUserByUsername("Admin"));
         if(userOptional.isPresent()){
             User updateUser = userOptional.get();
             updateUser.setPassword(passwordEncoder.encode(newPassword));
             userRepo.save(updateUser);
             return true;
         } else return false;
    }

}

