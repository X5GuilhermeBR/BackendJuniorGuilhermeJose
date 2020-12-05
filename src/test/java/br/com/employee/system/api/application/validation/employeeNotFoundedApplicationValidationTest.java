package br.com.employee.system.api.application.validation;

import br.com.employee.system.api.application.validations.CreateEmployeePojoApplicationValidation;
import br.com.employee.system.api.application.validations.EmployeeNotFoundedApplicationValidation;
import br.com.employee.system.api.domain.models.Employee;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
public class employeeNotFoundedApplicationValidationTest {

    EmployeeNotFoundedApplicationValidation employeeNotFoundedApplicationValidation = new EmployeeNotFoundedApplicationValidation();

    @Test
    void checkCpfThatDontExistInBlacklist() throws IOException {

    }

}
