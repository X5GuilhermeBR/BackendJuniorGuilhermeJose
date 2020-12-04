package br.com.employee.system.api.controllers;


import br.com.employee.system.api.domain.models.Sector;
import br.com.employee.system.api.domain.pojos.BasePojo;
import br.com.employee.system.api.domain.service.SectorService;
import br.com.employee.system.api.infrastructure.helpers.HttpHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SectorController {

    @Autowired
    private SectorService sectorService;

    @GetMapping(value = "/sector")
    public ResponseEntity get(@RequestParam (required = false) String include) {
        final BasePojo response = sectorService.getAll(include);
        final HttpStatus status = HttpHelper.convertToHttpStatus(response.getStatus());

        return ResponseEntity.status(status).body(response.getPojo());
    }
}
