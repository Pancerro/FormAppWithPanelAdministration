package pl.pancerro.backend.service.memberService.statementService;

import pl.pancerro.backend.model.member.Statement;

import java.util.List;

public interface StatementService {
    List<Statement> getStatementList();
    void addStatement(Statement statement);
    void editStatement(Statement statement);
    boolean deleteStatement(long id);
}
