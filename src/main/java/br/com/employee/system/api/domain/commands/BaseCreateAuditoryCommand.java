package br.com.employee.system.api.domain.commands;

import org.springframework.stereotype.Service;

@Service("createAuditoryCommand")
public interface BaseCreateAuditoryCommand {

    void execute(String objectName, long objectId, char operationType);
}
