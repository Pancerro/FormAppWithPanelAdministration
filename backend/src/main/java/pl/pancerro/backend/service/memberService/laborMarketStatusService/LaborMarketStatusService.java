package pl.pancerro.backend.service.memberService.laborMarketStatusService;

import pl.pancerro.backend.model.member.LaborMarketStatus;

import java.util.List;

public interface LaborMarketStatusService {
    List<LaborMarketStatus> getLaborMarketStatusList();
    void addLaborMarketStatus(LaborMarketStatus laborMarketStatus);
    void editLaborMarketStatus(LaborMarketStatus laborMarketStatus);
    boolean deleteLaborMarketStatus(long id);
}
