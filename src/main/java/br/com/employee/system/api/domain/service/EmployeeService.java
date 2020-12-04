package br.com.employee.system.api.domain.service;

import br.com.employee.system.api.domain.pojos.BasePojo;
import br.com.employee.system.api.domain.pojos.CreateEmployeePojo;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service("employeeService")
public interface EmployeeService {
    BasePojo create(CreateEmployeePojo request) throws IOException;

    BasePojo delete(int id);

    BasePojo get(int id);

    BasePojo getAll();
}
