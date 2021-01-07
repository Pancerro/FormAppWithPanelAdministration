package pl.pancerro.backend.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pl.pancerro.backend.configuration.AuthenticationBean;
import pl.pancerro.backend.model.*;
import pl.pancerro.backend.model.message.MyEmail;
import pl.pancerro.backend.model.message.AcceptEmail;
import pl.pancerro.backend.model.message.WebStarterDesc;
import pl.pancerro.backend.service.adminPanelService.AdminPanelService;

import javax.mail.MessagingException;
import java.util.List;

@RestController()
@RequestMapping("/admin")
public class PanelAdminController {
    private final AdminPanelService adminPanelService;
    @Autowired
    public PanelAdminController(AdminPanelService adminPanelService) {
        this.adminPanelService = adminPanelService;
    }
    @GetMapping("/get-charts-age")
    public ResponseEntity<List<Charts>> getChartsAge(){
        return new ResponseEntity<>(adminPanelService.getChartsMemberInAge(), HttpStatus.OK);
    }
    @GetMapping("/get-charts-sex")
    public ResponseEntity<List<Charts>> getChartsSex(){
        return new ResponseEntity<>(adminPanelService.getChartsSexInMember(), HttpStatus.OK);
    }
    @GetMapping("/get-charts-education")
    public ResponseEntity<List<Charts>> getChartsEducation(){
        return new ResponseEntity<>(adminPanelService.getChartsEducationInMember(), HttpStatus.OK);
    }
    @GetMapping("/get-charts-area")
    public ResponseEntity<List<Charts>> getChartsArea(){
        return new ResponseEntity<>(adminPanelService.getChartsAreaInMember(), HttpStatus.OK);
    }
    @GetMapping("/all-member")
    public ResponseEntity<List<Member>> getMember(){
        return new ResponseEntity<>(adminPanelService.getAllMember(), HttpStatus.OK);
    }
    @PutMapping("/edit-member")
    public ResponseEntity<?> editMember(@RequestBody Member member) {
        if(adminPanelService.editMember(member)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
    @DeleteMapping("/delete-member/{idMember}")
    public ResponseEntity<?> deleteMember(@PathVariable long idMember) {
        if (adminPanelService.deleteMember(idMember)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }


    @PostMapping("/add-university-department")
    public ResponseEntity<?> addUniversityDepartment(@RequestBody UniversityDepartments universityDepartments) {
        if(adminPanelService.addUniversityDepartment(universityDepartments)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
    @PutMapping("/edit-university-department")
    public ResponseEntity<?> editUniversityDepartment(@RequestBody UniversityDepartments universityDepartments) {
        if(adminPanelService.editUniversityDepartment(universityDepartments)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
    @DeleteMapping("/delete-university-department/{idDepartment}")
    public ResponseEntity<?> deleteUniversityDepartment(@PathVariable long idDepartment) {
        if (adminPanelService.deleteUniversityDepartment(idDepartment)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
    @PostMapping("/add-university-courses")
    public ResponseEntity<?> addUniversityCourses(@RequestBody UniversityCourses universityCourses) {
        if(adminPanelService.addUniversityCourses(universityCourses)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
    @PutMapping("/edit-university-courses")
    public ResponseEntity<?> editUniversityCourses(@RequestBody UniversityCourses universityCourses) {
        if(adminPanelService.editUniversityCourses(universityCourses)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
    @DeleteMapping("/delete-university-courses/{idCourses}")
    public ResponseEntity<?> deleteUniversityCourses(@PathVariable long idCourses) {
        if (adminPanelService.deleteUniversityCourses(idCourses)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
    @GetMapping("/get-charts-courses")
    public ResponseEntity<List<Charts>> getChartsCountCoursesInDepartment() {
        return new ResponseEntity<>(adminPanelService.getChartsCountCoursesInDepartment(), HttpStatus.OK);
    }
    @PostMapping("/send-email")
    public ResponseEntity<?> sendEmail(@RequestBody MyEmail myEmail) throws MessagingException {
        adminPanelService.sendEmail(myEmail);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-accept-email")
    public ResponseEntity<AcceptEmail> getAcceptEmail() {
        return new ResponseEntity<>(adminPanelService.getAcceptEmail(), HttpStatus.OK);
    }
    @PostMapping("/add-accept-email")
    public ResponseEntity<?> addAcceptEmail(@RequestBody AcceptEmail acceptEmail) {
        adminPanelService.addAcceptEmail(acceptEmail);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @PutMapping("/edit-accept-email")
    public ResponseEntity<?> editAcceptEmail(@RequestBody AcceptEmail acceptEmail) {
        if(adminPanelService.editAcceptEmail(acceptEmail)) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
    @DeleteMapping("/delete-accept-email")
    public ResponseEntity<?> deleteAcceptEmail() {
        if (adminPanelService.deleteAcceptEmail()) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping("/get-web-starter")
    public ResponseEntity<WebStarterDesc> getWebStarterDesc() {
        return new ResponseEntity<>(adminPanelService.getWebStarterDesc(), HttpStatus.OK);
    }
    @PostMapping("/add-web-starter")
    public ResponseEntity<?> addWebStarterDesc(@RequestBody WebStarterDesc webStarterDesc) {
        adminPanelService.addWebStarterDesc(webStarterDesc);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @PutMapping("/edit-web-starter")
    public ResponseEntity<?> editWebStarterDesc(@RequestBody WebStarterDesc webStarterDesc) {
        if(adminPanelService.editWebStarterDesc(webStarterDesc)) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
    @DeleteMapping("/delete-web-starter")
    public ResponseEntity<?> deleteWebStarterDesc() {
        if (adminPanelService.deleteWebStarterDesc()) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping("/get-save-to-project")
    public ResponseEntity<List<SaveMemberToProject>> getSaveToProject() {
        return new ResponseEntity<>(adminPanelService.getSaveMemberToProject(), HttpStatus.OK);
    }
    @PostMapping("/add-save-to-project")
    public ResponseEntity<?> addSaveToProject(@RequestBody SaveMemberToProject saveMemberToProject) {
        adminPanelService.addSaveMemberToProject(saveMemberToProject);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @PutMapping("/edit-save-to-project")
    public ResponseEntity<?> editSaveToProject(@RequestBody SaveMemberToProject saveMemberToProject) {
        if(adminPanelService.editSaveMemberToProject(saveMemberToProject)) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
    @DeleteMapping("/delete-save-to-project/{idSave}")
    public ResponseEntity<?> deleteSaveToProject(@PathVariable long idSave) {
        if (adminPanelService.deleteSaveMemberToProject(idSave)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping("/get-project")
    public ResponseEntity<List<Project>> getProject() {
        return new ResponseEntity<>(adminPanelService.getProject(), HttpStatus.OK);
    }
    @PostMapping("/add-project")
    public ResponseEntity<?> addProject(@RequestBody Project project) {
        adminPanelService.addProject(project);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @PutMapping("/edit-project")
    public ResponseEntity<?> editProject(@RequestBody Project project) {
        System.out.println(project.isActive());
        if(adminPanelService.editProject(project)) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
    @DeleteMapping("/delete-project/{idProject}")
    public ResponseEntity<?> deleteProject(@PathVariable long idProject) {
        if (adminPanelService.deleteProject(idProject)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping("/get-charts-member-in-project")
    public ResponseEntity<List<Charts>> getChartsCountMemberInProject() {
        return new ResponseEntity<>(adminPanelService.getChartsMemberInProject(), HttpStatus.OK);
    }
    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody String newPassword) {
        if( adminPanelService.changePassword(newPassword)) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping(path = "/basicauth")
    public AuthenticationBean basicauth() {
        return new AuthenticationBean("You are authenticated");
    }
}
