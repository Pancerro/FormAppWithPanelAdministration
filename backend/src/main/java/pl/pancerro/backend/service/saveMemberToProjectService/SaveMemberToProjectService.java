package pl.pancerro.backend.service.saveMemberToProjectService;

import pl.pancerro.backend.model.Charts;
import pl.pancerro.backend.model.SaveMemberToProject;

import java.util.List;

public interface SaveMemberToProjectService {
    List<SaveMemberToProject> getSaveMemberToProjectList();
    void addSaveMemberToProject(SaveMemberToProject saveMemberToProject);
    boolean editSaveMemberToProject(SaveMemberToProject saveMemberToProject);
    boolean deleteSaveMemberToProject(long id);
    SaveMemberToProject getOneSaveMemberToProjectByMemberID(long id);
    List<Charts> getChartsMemberInProject();
}
