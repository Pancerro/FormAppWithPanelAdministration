package pl.pancerro.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pancerro.backend.model.Member;
import pl.pancerro.backend.model.Project;
import pl.pancerro.backend.model.UniversityCourses;
import pl.pancerro.backend.model.UniversityDepartments;
import pl.pancerro.backend.model.message.WebStarterDesc;
import pl.pancerro.backend.service.formService.FormService;



import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {
    private final FormService formService;

    @Autowired
    public MemberController(FormService formService) {
        this.formService = formService;
    }
    @GetMapping("/university-courses")
    public ResponseEntity<List<UniversityCourses>> getCourses() {
        List<UniversityCourses> universityCourses = formService.getUniversityCourses();
        return new ResponseEntity<>(universityCourses, HttpStatus.OK);
    }
    @GetMapping("/university-departments")
    public ResponseEntity<List<UniversityDepartments>> getDepartments() {
        List<UniversityDepartments> universityDepartments = formService.getUniversityDepartments();
        return new ResponseEntity<>(universityDepartments, HttpStatus.OK);
    }
    @GetMapping("/active-project")
    public ResponseEntity<List<Project>> getActiveProject() {
        List<Project> projectList = formService.getActiveProject();
        return new ResponseEntity<>(projectList,HttpStatus.OK);
    }

    @PostMapping("/form/{id}")
    public ResponseEntity<?> sendForm(@RequestBody Member member,@PathVariable long id) throws MessagingException {
        if(formService.sendForm(member,id)){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
    @GetMapping("/get-web-starter")
    public ResponseEntity<WebStarterDesc> getWebStarterDesc() {
        return new ResponseEntity<>(formService.getWebStarterDesc(), HttpStatus.OK);
    }
}
