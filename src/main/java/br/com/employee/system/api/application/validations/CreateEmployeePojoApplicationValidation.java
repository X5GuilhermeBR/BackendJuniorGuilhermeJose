package br.com.employee.system.api.application.validations;

import br.com.employee.system.api.domain.enums.ErrorType;
import br.com.employee.system.api.domain.models.Employee;
import br.com.employee.system.api.domain.models.Sector;
import br.com.employee.system.api.domain.models.UserBlacklist;
import br.com.employee.system.api.domain.pojos.CreateEmployeePojo;
import br.com.employee.system.api.domain.pojos.GetValidationPojo;
import br.com.employee.system.api.domain.repositories.EmployeeRepository;
import br.com.employee.system.api.domain.repositories.SectorRepository;
import br.com.employee.system.api.domain.validations.CreateEmployeePojoValidation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service("createEmployeePojoValidation")
public class CreateEmployeePojoApplicationValidation implements CreateEmployeePojoValidation {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SectorRepository sectorRepository;

    @Override
    public GetValidationPojo execute (final CreateEmployeePojo request) throws IOException {

        if (request == null) {
            return new GetValidationPojo(ErrorType.NULLABLE_REQUEST);
        }

        boolean Blacklist = checkBlackList(request.getCpf());

        if (Blacklist == true){
            return new GetValidationPojo(ErrorType.USER_BANNED);
        }

        boolean availableSpace = checkAgePercentage(request.getDt_birth());

        if (availableSpace == true){
            return new GetValidationPojo(ErrorType.LIMIT_AGE_REACHED);
        }

        if (request.getCpf().length() != 11) {
            return new GetValidationPojo(ErrorType.WRONG_CPF);
        }

        Employee employee = employeeRepository.findByCpf(request.getCpf());

        if (employee != null) {
            return new GetValidationPojo(ErrorType.DUPLICATED_CPF);
        }

        employee = employeeRepository.findByEmail(request.getEmail());

        if (employee != null) {
            return new GetValidationPojo(ErrorType.DUPLICATED_EMAIL);
        }

        final Sector sector = sectorRepository.findById(request.getId_sector());

        if (sector == null) {
            return new GetValidationPojo(ErrorType.SECTOR_NOT_EXIST);
        }

        return null;

    }

    public boolean checkAgePercentage (LocalDate birthEmployee){
        LocalDate date = LocalDate.now();

        long years = ChronoUnit.YEARS.between(birthEmployee,date);

        int count = employeeRepository.findAllUserUnderEighteenYearsOld(date);

        List<Employee> employees = employeeRepository.findAll();

        double result = employees.size() * 0.20;

        if (count > result && years < 18){
            return true;
        }

        count = employeeRepository.findAllUserAboveSixtyFiveYearsOld(date);

        result = employees.size() * 0.20;

        if (count > result && years > 65){
            return true;
        }

    return false;

    }

    public boolean checkBlackList (String cpf) throws IOException {
        URL obj = new URL("https://5e74cb4b9dff120016353b04.mockapi.io/api/v1/blacklist?filter=" + cpf);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");

        BufferedReader in = new BufferedReader(new InputStreamReader((con.getInputStream())));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        ObjectMapper mapper = new ObjectMapper();

        UserBlacklist[] userBlacklists = mapper.readValue(response.toString(), UserBlacklist[].class);

        in.close();

        String result = response.toString();

        result = result.replace("[", " ");
        result = result.replace("]", " ");


        if (result.isEmpty() && userBlacklists[0].getCpf() == cpf){
            return true;
        }

        return false;
    }
}
