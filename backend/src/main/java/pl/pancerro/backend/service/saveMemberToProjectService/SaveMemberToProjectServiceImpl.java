package pl.pancerro.backend.service.saveMemberToProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pancerro.backend.model.Charts;
import pl.pancerro.backend.model.SaveMemberToProject;
import pl.pancerro.backend.repository.SaveMemberToProjectRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class SaveMemberToProjectServiceImpl implements SaveMemberToProjectService {

    private final SaveMemberToProjectRepo saveMemberToProjectRepo;
    @Autowired
    public SaveMemberToProjectServiceImpl(SaveMemberToProjectRepo saveMemberToProjectRepo) {
        this.saveMemberToProjectRepo = saveMemberToProjectRepo;
    }

    @Override
    public List<SaveMemberToProject> getSaveMemberToProjectList() {
        return saveMemberToProjectRepo.findAll();
    }

    @Override
    public void addSaveMemberToProject(SaveMemberToProject saveMemberToProject) {
        saveMemberToProjectRepo.save(saveMemberToProject);
    }

    @Override
    public boolean editSaveMemberToProject(SaveMemberToProject saveMemberToProject) {
        Optional<SaveMemberToProject> optionalSaveMemberToProject = saveMemberToProjectRepo.findById(saveMemberToProject.getIdSave());
        if(optionalSaveMemberToProject.isPresent()) {
            SaveMemberToProject updateSaveMemberToProject = optionalSaveMemberToProject.get();
            updateSaveMemberToProject.setProject(saveMemberToProject.getProject());
            updateSaveMemberToProject.setMember(saveMemberToProject.getMember());
            saveMemberToProjectRepo.save(updateSaveMemberToProject);
            return true;
        } else return false;
    }

    @Override
    public boolean deleteSaveMemberToProject(long id) {
        Optional<SaveMemberToProject> optionalSaveMemberToProject = saveMemberToProjectRepo.findById(id);
        if(optionalSaveMemberToProject.isPresent()) {
            saveMemberToProjectRepo.deleteById(id);
            return true;
        } else return false;
    }
    @Override
    public SaveMemberToProject getOneSaveMemberToProjectByMemberID(long id) {
        Optional<SaveMemberToProject> optionalSaveMemberToProject = Optional.ofNullable(saveMemberToProjectRepo.findByMember_IdMember(id));
        return optionalSaveMemberToProject.orElse(null);
    }

    @Override
    public List<Charts> getChartsMemberInProject() {
        List<Charts> chartsList = new ArrayList<>();
        Charts charts;
        for(int i = 0; i<saveMemberToProjectRepo.getCountMemberInProject().size(); i++) {
            charts = new Charts(saveMemberToProjectRepo.getCountMemberInProject().get(i).get("projectName").toString(),convertToLong(saveMemberToProjectRepo.getCountMemberInProject().get(i).get("countMember")));
            chartsList.add(charts);
        }
        return chartsList;
    }
    static Long convertToLong(Object o){
        String stringToConvert = String.valueOf(o);
        Long convertedLong = Long.parseLong(stringToConvert);
        return convertedLong;
    }
}
