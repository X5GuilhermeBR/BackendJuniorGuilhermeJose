package br.com.employee.system.api.domain.repositories;

import br.com.employee.system.api.domain.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;

@Repository("funcionarioRepository")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findById(int id);

    Employee findByCpf(String cpf);

    Employee findByEmail (String email);

    @Query(value = "select count(*) from db_employee_system.tb_employee TB where floor(datediff(:currentDate,TB.dt_birth)/365.25)<18", nativeQuery = true)
    int findAllUserUnderEighteenYearsOld(LocalDate currentDate);

    @Query(value = "select count(*) from db_employee_system.tb_employee TB where floor(datediff(:currentDate,TB.dt_birth)/365.25)>65", nativeQuery = true)
    int findAllUserAboveSixtyFiveYearsOld(LocalDate currentDate);

}
