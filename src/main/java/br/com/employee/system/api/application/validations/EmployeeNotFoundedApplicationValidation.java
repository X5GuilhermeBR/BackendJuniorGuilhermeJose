package br.com.employee.system.api.application.validations;

import br.com.employee.system.api.domain.enums.ErrorType;
import br.com.employee.system.api.domain.models.Employee;
import br.com.employee.system.api.domain.pojos.GetValidationPojo;
import br.com.employee.system.api.domain.repositories.EmployeeRepository;
import br.com.employee.system.api.domain.validations.EmployeeNotFoundedValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userNotFoundedValidation")
public class EmployeeNotFoundedApplicationValidation implements EmployeeNotFoundedValidation {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public GetValidationPojo execute(int id) {

        final Employee employee = employeeRepository.findById(id);

        if (employee == null) {
            return new GetValidationPojo(ErrorType.USER_NOT_FOUNDED);
        }

        return null;
    }
}
