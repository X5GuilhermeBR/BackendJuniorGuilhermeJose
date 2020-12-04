package br.com.employee.system.api.application.services;

import br.com.employee.system.api.domain.validations.CreateEmployeePojoValidation;
import br.com.employee.system.api.domain.models.Employee;
import br.com.employee.system.api.domain.pojos.BasePojo;
import br.com.employee.system.api.domain.pojos.CreateEmployeePojo;
import br.com.employee.system.api.domain.pojos.GetEmployeePojo;
import br.com.employee.system.api.domain.pojos.GetValidationPojo;
import br.com.employee.system.api.domain.repositories.EmployeeRepository;
import br.com.employee.system.api.domain.service.EmployeeService;
import br.com.employee.system.api.domain.validations.EmployeeNotFoundedValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;

@Service("employeeService")
@Transactional
public class EmployeeApplicationService implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CreateEmployeePojoValidation createEmployeePojoValidation;

    @Autowired
    private EmployeeNotFoundedValidation employeeNotFoundedValidation;

    @Override
    public BasePojo create(final CreateEmployeePojo requestPojo) throws IOException {
        final BasePojo response = new BasePojo();

        final GetValidationPojo validation = createEmployeePojoValidation.execute(requestPojo);

        if (validation != null) {
            response.setPojo(validation);
            response.setStatus(validation.getCode());

            return response;
        }

        final Employee employee = mapAndCreateEmployee(requestPojo);

        mapAndCreateResponse(response, employee);

        return response;
    }

    @Override
    public BasePojo delete(int id) {
        final BasePojo response = new BasePojo();

        final GetValidationPojo validation = employeeNotFoundedValidation.execute(id);

        if (validation != null) {
            response.setPojo(validation);
            response.setStatus(validation.getCode());

            return response;
        }

        final Employee employee = employeeRepository.findById(id);

        employeeRepository.delete(employee);
        response.noContent();

        return response;
    }

    @Override
    public BasePojo get(int id) {
        final BasePojo response = new BasePojo();

        final GetValidationPojo validation = employeeNotFoundedValidation.execute(id);

        if (validation != null) {
            response.setPojo(validation);
            response.setStatus(validation.getCode());

            return response;
        }

        final Employee employee = employeeRepository.findById(id);

        mapAndCreateResponse(response, employee);

        response.ok();

        return response;
    }

    private void mapAndCreateResponse(final BasePojo response, final Employee employee) {

        final GetEmployeePojo responsePojo = new GetEmployeePojo();

        responsePojo.setId(employee.getId());
        responsePojo.setCpf(employee.getCpf());
        responsePojo.setName(employee.getName());
        responsePojo.setEmail(employee.getEmail());
        responsePojo.setTelephone(employee.getTelephone());
        responsePojo.setDt_birth(employee.getDt_birth());
        responsePojo.setId_sector(employee.getId_sector());
        responsePojo.setCreated_at(employee.getCreated_at());
        response.created();
        response.setPojo(responsePojo);
    }

    private Employee mapAndCreateEmployee(final CreateEmployeePojo requestPojo) {
        final Employee employee = new Employee();

        employee.setCpf(requestPojo.getCpf());
        employee.setName(requestPojo.getName());
        employee.setEmail(requestPojo.getEmail());
        employee.setTelephone(requestPojo.getTelephone());
        employee.setDt_birth(requestPojo.getDt_birth());
        employee.setId_sector(requestPojo.getId_sector());

        employeeRepository.save(employee);

        return employee;
    }
}
