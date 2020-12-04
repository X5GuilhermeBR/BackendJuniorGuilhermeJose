package br.com.employee.system.api.application.services;

import br.com.employee.system.api.domain.models.Employee;
import br.com.employee.system.api.domain.models.Sector;
import br.com.employee.system.api.domain.pojos.BasePojo;
import br.com.employee.system.api.domain.pojos.GetEmployeePojo;
import br.com.employee.system.api.domain.pojos.GetSectorPojo;
import br.com.employee.system.api.domain.repositories.EmployeeRepository;
import br.com.employee.system.api.domain.repositories.SectorRepository;
import br.com.employee.system.api.domain.service.EmployeeService;
import br.com.employee.system.api.domain.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("sectorService")
@Transactional
public class SectorApplicationService  implements SectorService {

    @Autowired
    private SectorRepository sectorRepository;

    @Override
    public BasePojo getAll(String include) {
        final BasePojo response = new BasePojo();
        final List<Sector> sectors = sectorRepository.findAll();
        final List<GetSectorPojo> sectorsPojos = new ArrayList<GetSectorPojo>();

        for (final Sector sector : sectors) {
            final GetSectorPojo pojo = new GetSectorPojo();

            if (include != null && include.equals("employee")){
                pojo.setEmployees(sector.getEmployees());
            }

            pojo.setId(sector.getId());
            pojo.setDescription(sector.getDescription());

            sectorsPojos.add(pojo);
        }

        response.setPojo(sectorsPojos);
        response.ok();

        return response;
    }
}
