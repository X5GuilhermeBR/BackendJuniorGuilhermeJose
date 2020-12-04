package br.com.employee.system.api.domain.service;

import br.com.employee.system.api.domain.pojos.BasePojo;
import org.springframework.stereotype.Service;

@Service("sectorService")
public interface SectorService {

    BasePojo getAll(String include);
}
