package br.com.employee.system.api.application.services;

import br.com.employee.system.api.domain.models.Sector;
import br.com.employee.system.api.domain.repositories.SectorRepository;
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
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service("employeeService")
@Transactional
public class EmployeeApplicationService implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SectorRepository sectorRepository;

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

    @Override
    public BasePojo getAll() {

        final BasePojo response = new BasePojo();
        final List<Employee> employees = employeeRepository.findAll();
        final List<GetEmployeePojo> employeePojos = new ArrayList<GetEmployeePojo>();

        for (final Employee employee : employees) {
            final GetEmployeePojo pojo = new GetEmployeePojo();

            LocalDate date = LocalDate.now();

            long years = ChronoUnit.YEARS.between(employee.getDt_birth(),date);

            pojo.setId(employee.getId());
            pojo.setName(employee.getName());
            pojo.setCpf(employee.getCpf());
            pojo.setEmail(employee.getEmail());
            pojo.setTelephone(employee.getTelephone());
            pojo.setAge(years);
            pojo.setId_sector(employee.getSector().getId());

            employeePojos.add(pojo);
        }

        response.setPojo(employeePojos);
        response.ok();

        return response;

    }

    private void mapAndCreateResponse(final BasePojo response, final Employee employee) {

        final GetEmployeePojo responsePojo = new GetEmployeePojo();

        LocalDate date = LocalDate.now();

        long years = ChronoUnit.YEARS.between(employee.getDt_birth(),date);

        responsePojo.setId(employee.getId());
        responsePojo.setCpf(employee.getCpf());
        responsePojo.setName(employee.getName());
        responsePojo.setEmail(employee.getEmail());
        responsePojo.setTelephone(employee.getTelephone());
        responsePojo.setDt_birth(employee.getDt_birth());
        responsePojo.setId_sector(employee.getSector().getId());
        responsePojo.setCreated_at(employee.getCreated_at());
        responsePojo.setAge(years);
        response.created();
        response.setPojo(responsePojo);
    }

    private Employee mapAndCreateEmployee(final CreateEmployeePojo requestPojo) {
        final Employee employee = new Employee();

        final Sector sector = sectorRepository.findById(requestPojo.getId_sector());

        employee.setCpf(requestPojo.getCpf());
        employee.setName(requestPojo.getName());
        employee.setEmail(requestPojo.getEmail());
        employee.setTelephone(requestPojo.getTelephone());
        employee.setDt_birth(requestPojo.getDt_birth());
        employee.setSector(sector);

        employeeRepository.save(employee);

        return employee;
    }
}
