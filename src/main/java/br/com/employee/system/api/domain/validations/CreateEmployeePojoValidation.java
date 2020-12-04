package br.com.employee.system.api.domain.validations;

import br.com.employee.system.api.domain.pojos.CreateEmployeePojo;
import br.com.employee.system.api.domain.pojos.GetValidationPojo;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service("createEmployeePojoValidation")
public interface CreateEmployeePojoValidation  {

    GetValidationPojo execute(CreateEmployeePojo request) throws IOException;

}
