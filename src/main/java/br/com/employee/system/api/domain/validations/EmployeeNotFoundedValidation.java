package br.com.employee.system.api.domain.validations;

import br.com.employee.system.api.domain.pojos.GetValidationPojo;
import org.springframework.stereotype.Service;

@Service("employeeNotFoundedValidation")
public interface EmployeeNotFoundedValidation {

   GetValidationPojo execute(int id);
}
