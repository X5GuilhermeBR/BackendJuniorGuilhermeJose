package br.com.employee.system.api.domain.repositories;

import br.com.employee.system.api.domain.models.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("setorRepository")
public interface SectorRepository extends JpaRepository<Sector, Long> {

    Sector findById(int id);

}
