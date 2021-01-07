package pl.pancerro.backend.service.adminPanelService;

import pl.pancerro.backend.model.*;
import pl.pancerro.backend.model.message.MyEmail;
import pl.pancerro.backend.model.message.AcceptEmail;
import pl.pancerro.backend.model.message.WebStarterDesc;

import javax.mail.MessagingException;
import java.util.List;

public interface AdminPanelService {

    List<Member> getAllMember();
    boolean editMember(Member member);
    boolean deleteMember(long id);
    boolean addUniversityDepartment(UniversityDepartments universityDepartments);
    boolean editUniversityDepartment(UniversityDepartments universityDepartments);
    boolean deleteUniversityDepartment(long id);
    boolean addUniversityCourses(UniversityCourses universityCourses);
    boolean editUniversityCourses(UniversityCourses universityCourses);
    boolean deleteUniversityCourses(long id);
    void addAcceptEmail(AcceptEmail acceptEmail);
    boolean editAcceptEmail(AcceptEmail acceptEmail);
    boolean deleteAcceptEmail();
    AcceptEmail getAcceptEmail();
    void addWebStarterDesc(WebStarterDesc webStarterDesc);
    boolean editWebStarterDesc(WebStarterDesc webStarterDesc);
    boolean deleteWebStarterDesc();
    WebStarterDesc getWebStarterDesc();
    List<Charts> getChartsMemberInAge();
    List<Charts> getChartsSexInMember();
    List<Charts> getChartsEducationInMember();
    List<Charts> getChartsAreaInMember();
    List<Charts> getChartsCountCoursesInDepartment();
    void sendEmail(MyEmail myEmail) throws MessagingException;
    List<SaveMemberToProject> getSaveMemberToProject();
    boolean editSaveMemberToProject(SaveMemberToProject saveMemberToProject);
    boolean deleteSaveMemberToProject(long id);
    void addSaveMemberToProject(SaveMemberToProject saveMemberToProject);
    List<Project> getProject();
    boolean editProject(Project project);
    boolean deleteProject(long id);
    void addProject(Project project);
    List<Charts> getChartsMemberInProject();
    boolean changePassword(String newPassword);

}
