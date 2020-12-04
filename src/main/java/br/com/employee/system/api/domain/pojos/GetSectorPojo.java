package br.com.employee.system.api.domain.pojos;

import br.com.employee.system.api.domain.models.Employee;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GetSectorPojo {

    @JsonProperty("id")
    private int id;

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("employees")
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("description")
    private String description;
}
