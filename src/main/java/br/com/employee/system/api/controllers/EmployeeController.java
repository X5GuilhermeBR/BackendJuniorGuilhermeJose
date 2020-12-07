package br.com.employee.system.api.controllers;


import br.com.employee.system.api.domain.pojos.BasePojo;
import br.com.employee.system.api.domain.pojos.CreateEmployeePojo;
import br.com.employee.system.api.domain.service.EmployeeService;
import br.com.employee.system.api.infrastructure.helpers.HttpHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @CrossOrigin
    @PostMapping(value = "/employee")
    public ResponseEntity post(@RequestBody final CreateEmployeePojo request) throws IOException {
        final BasePojo response = employeeService.create(request);
        final HttpStatus status = HttpHelper.convertToHttpStatus(response.getStatus());

        return ResponseEntity.status(status).body(response.getPojo());
    }

    @CrossOrigin
    @DeleteMapping(value = "/employee/{idEmployee}")
    public ResponseEntity delete(@PathVariable final int idEmployee) {
        final BasePojo response = employeeService.delete(idEmployee);
        final HttpStatus status = HttpHelper.convertToHttpStatus(response.getStatus());

        return ResponseEntity.status(status).body(response.getPojo());
    }

    @CrossOrigin
    @GetMapping(value = "/employee/{idEmployee}")
    public ResponseEntity get(@PathVariable final int idEmployee) {
        final BasePojo response = employeeService.get(idEmployee);
        final HttpStatus status = HttpHelper.convertToHttpStatus(response.getStatus());

        return ResponseEntity.status(status).body(response.getPojo());
    }

    @CrossOrigin
    @GetMapping(value = "/employee")
    public ResponseEntity get() {
        final BasePojo response = employeeService.getAll();
        final HttpStatus status = HttpHelper.convertToHttpStatus(response.getStatus());

        return ResponseEntity.status(status).body(response.getPojo());
    }
}
