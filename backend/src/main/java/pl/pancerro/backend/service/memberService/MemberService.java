package pl.pancerro.backend.service.memberService;

import pl.pancerro.backend.model.Member;
import pl.pancerro.backend.model.message.MyEmail;
import pl.pancerro.backend.model.Project;
import pl.pancerro.backend.model.Charts;

import javax.mail.MessagingException;
import java.util.List;

public interface MemberService {
    List<Member> getMemberList();
    boolean addMember(Member member, Project project);
    boolean editMember(Member member);
    boolean deleteMember(long id);
    List<Charts> getChartsMemberInAge();
    List<Charts> getSexInMember();
    List<Charts> getEducationInMember();
    List<Charts> getAreaInMember();
    void sendEmail(MyEmail myEmail) throws MessagingException;
}
