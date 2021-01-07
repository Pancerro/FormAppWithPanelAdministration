package pl.pancerro.backend.service.memberService.directionOfEducationService;

import pl.pancerro.backend.model.member.DirectionOfEducation;

import java.util.List;

public interface DirectionOfEducationService {
    List<DirectionOfEducation> getDirectionOfEducation();
    void addDirectionOfEducation(DirectionOfEducation directionOfEducation);
    void editDirectionOfEducation(DirectionOfEducation directionOfEducation);
    boolean deleteDirectionOfEducation(long id);
}
