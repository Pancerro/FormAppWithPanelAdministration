package pl.pancerro.backend.service.memberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.pancerro.backend.model.Charts;
import pl.pancerro.backend.model.Member;
import pl.pancerro.backend.model.Project;
import pl.pancerro.backend.model.SaveMemberToProject;
import pl.pancerro.backend.model.message.MyEmail;
import pl.pancerro.backend.repository.MemberRepo;
import pl.pancerro.backend.service.myEmailService.MailService;
import pl.pancerro.backend.service.memberService.additionalInformationService.AdditionalInformationService;
import pl.pancerro.backend.service.memberService.basicInformationService.BasicInformationService;
import pl.pancerro.backend.service.memberService.contactDetailsService.ContactDetailsService;
import pl.pancerro.backend.service.memberService.directionOfEducationService.DirectionOfEducationService;
import pl.pancerro.backend.service.memberService.laborMarketStatusService.LaborMarketStatusService;
import pl.pancerro.backend.service.memberService.statementService.StatementService;
import pl.pancerro.backend.service.projectService.ProjectService;
import pl.pancerro.backend.service.saveMemberToProjectService.SaveMemberToProjectService;

import javax.mail.MessagingException;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepo memberRepo;
    private final AdditionalInformationService additionalInformationService;
    private final BasicInformationService basicInformationService;
    private final ContactDetailsService contactDetailsService;
    private final DirectionOfEducationService directionOfEducationService;
    private final LaborMarketStatusService laborMarketStatusService;
    private final StatementService statementService;
    private final SaveMemberToProjectService saveMemberToProjectService;
    private final ProjectService projectService;
    private final MailService mailService;

    @Autowired
    public MemberServiceImpl(MemberRepo memberRepo, AdditionalInformationService additionalInformationService, BasicInformationService basicInformationService, ContactDetailsService contactDetailsService, DirectionOfEducationService directionOfEducationService, LaborMarketStatusService laborMarketStatusService, StatementService statementService, SaveMemberToProjectService saveMemberToProjectService, ProjectService projectService, MailService mailService) {
        this.memberRepo = memberRepo;
        this.additionalInformationService = additionalInformationService;
        this.basicInformationService = basicInformationService;
        this.contactDetailsService = contactDetailsService;
        this.directionOfEducationService = directionOfEducationService;
        this.laborMarketStatusService = laborMarketStatusService;
        this.statementService = statementService;
        this.saveMemberToProjectService = saveMemberToProjectService;
        this.projectService = projectService;
        this.mailService = mailService;
    }

    @Override
    public List<Member> getMemberList() {
        return memberRepo.findAll();
    }

    @Override
    @Transactional
    public boolean addMember(Member member, Project project) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Member>> constraintViolations = validator.validate(member);
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<Member> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
            return false;
        } else {
            additionalInformationService.addAdditionalInformation(member.getAdditionalInformation());
            basicInformationService.addBasicInformation(member.getBasicInformation());
            contactDetailsService.addContactDetails(member.getContactDetails());
            directionOfEducationService.addDirectionOfEducation(member.getDirectionOfEducation());
            laborMarketStatusService.addLaborMarketStatus(member.getLaborMarketStatus());
            statementService.addStatement(member.getStatement());
            memberRepo.save(member);
            SaveMemberToProject saveMemberToProject = new SaveMemberToProject(member, project);
            saveMemberToProjectService.addSaveMemberToProject(saveMemberToProject);
            return true;
        }
    }

    @Override
    @Transactional
    public boolean editMember(Member member) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Member>> constraintViolations = validator.validate(member);
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<Member> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
            return false;
        } else {
            Optional<Member> memberOptional = memberRepo.findById(member.getIdMember());
            if (memberOptional.isPresent()) {
                statementService.editStatement(member.getStatement());
                laborMarketStatusService.editLaborMarketStatus(member.getLaborMarketStatus());
                additionalInformationService.editAdditionalInformation(member.getAdditionalInformation());
                directionOfEducationService.editDirectionOfEducation(member.getDirectionOfEducation());
                contactDetailsService.editContactDetails(member.getContactDetails());
                basicInformationService.editBasicInformation(member.getBasicInformation());
                return true;
            } else return false;
        }
    }

    @Override
    @Transactional
    public boolean deleteMember(long id) {
        Optional<Member> memberOptional = memberRepo.findById(id);
        if(memberOptional.isPresent()) {
            SaveMemberToProject saveMemberToProject = saveMemberToProjectService.getOneSaveMemberToProjectByMemberID(memberOptional.get().getIdMember());
            saveMemberToProjectService.deleteSaveMemberToProject(saveMemberToProject.getIdSave());
            memberRepo.deleteById(memberOptional.get().getIdMember());
            statementService.deleteStatement(memberOptional.get().getStatement().getIdStatement());
            laborMarketStatusService.deleteLaborMarketStatus(memberOptional.get().getLaborMarketStatus().getIdLaborMarketStatus());
            additionalInformationService.deleteAdditionalInformation(memberOptional.get().getAdditionalInformation().getIdAdditional());
            directionOfEducationService.deleteDirectionOfEducation(memberOptional.get().getDirectionOfEducation().getIdDirectionOfEducation());
            contactDetailsService.deleteContactDetails(memberOptional.get().getContactDetails().getIdContact());
            basicInformationService.deleteBasicInformation(memberOptional.get().getBasicInformation().getIdBasic());
            return true;
        } else return false;
    }

    @Override
    public List<Charts> getChartsMemberInAge() {
        List<Charts> chartsList = new ArrayList<>();
        Charts charts;
        for(int i = 0; i<memberRepo.getCountMemberInAge().size(); i++) {
            charts = new Charts(memberRepo.getCountMemberInAge().get(i).get("age").toString(),convertToLong(memberRepo.getCountMemberInAge().get(i).get("countAge")));
            chartsList.add(charts);
        }
        return chartsList;
    }
    @Override
    public List<Charts> getSexInMember() {
        List<Charts> chartsList = new ArrayList<>();
        Charts charts;
        Long countMen=0L, countWomen=0L;

        for(int i = 0; i<memberRepo.getCountSexInMember().size(); i++) {
            if(Integer.parseInt(memberRepo.getCountSexInMember().get(i).get("sex").toString()) % 2==0) {
                countWomen = countWomen + convertToLong(memberRepo.getCountSexInMember().get(i).get("countSex"));
            } else {
                countMen = countMen + convertToLong(memberRepo.getCountSexInMember().get(i).get("countSex"));
            }
        }
        charts = new Charts("Mezczyzni",countMen);
        chartsList.add(charts);
        charts = new Charts("Kobiety",countWomen);
        chartsList.add(charts);
        return chartsList;
    }
    @Override
    public List<Charts> getEducationInMember() {
        List<Charts> chartsList = new ArrayList<>();
        Charts charts;
        for(int i = 0; i<memberRepo.getCountEducationInMember().size(); i++) {
            charts = new Charts(memberRepo.getCountEducationInMember().get(i).get("education").toString(),convertToLong(memberRepo.getCountEducationInMember().get(i).get("countEducation")));
            chartsList.add(charts);
        }
        return chartsList;
    }
    @Override
    public List<Charts> getAreaInMember() {
        List<Charts> chartsList = new ArrayList<>();
        Charts charts;
        for(int i = 0; i<memberRepo.getCountAreaInMember().size(); i++) {
            charts = new Charts(memberRepo.getCountAreaInMember().get(i).get("area").toString(),convertToLong(memberRepo.getCountAreaInMember().get(i).get("countArea")));
            chartsList.add(charts);
        }
        return chartsList;
    }
    @Override
    public void sendEmail(MyEmail myEmail) throws MessagingException {
        mailService.sendMail(myEmail.getEmail(),myEmail.getSubject(),myEmail.getText(),myEmail.isHtml());
    }
    static Long convertToLong(Object o){
        String stringToConvert = String.valueOf(o);
        Long convertedLong = Long.parseLong(stringToConvert);
        return convertedLong;
    }
}
