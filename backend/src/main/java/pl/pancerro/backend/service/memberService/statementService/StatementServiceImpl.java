package pl.pancerro.backend.service.memberService.statementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pancerro.backend.model.member.Statement;
import pl.pancerro.backend.repository.memberRepo.StatementRepo;

import java.util.List;
import java.util.Optional;
@Service
public class StatementServiceImpl implements StatementService {
    private final StatementRepo statementRepo;
    @Autowired
    public StatementServiceImpl(StatementRepo statementRepo) {
        this.statementRepo = statementRepo;
    }

    @Override
    public List<Statement> getStatementList() {
        return statementRepo.findAll();
    }

    @Override
    public void addStatement(Statement statement) {
        statementRepo.save(statement);
    }

    @Override
    public void editStatement(Statement statement) {
        Optional<Statement> optionalStatement = statementRepo.findById(statement.getIdStatement());
        if(optionalStatement.isPresent()) {
            Statement updateStatement = optionalStatement.get();
            updateStatement.setAnotherUnfavorablePersonSocialSituation(statement.getAnotherUnfavorablePersonSocialSituation());
            updateStatement.setHomelessPerson(statement.getHomelessPerson());
            updateStatement.setStatement(statement.isStatement());
            statementRepo.save(updateStatement);
        }
    }

    @Override
    public boolean deleteStatement(long id) {
        Optional<Statement> optionalStatement = statementRepo.findById(id);
        if(optionalStatement.isPresent()) {
            statementRepo.deleteById(id);
            return true;
        } else return false;
    }
}
