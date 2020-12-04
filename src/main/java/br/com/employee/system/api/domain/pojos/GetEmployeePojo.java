package br.com.employee.system.api.domain.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.Date;

public class GetEmployeePojo {

    @JsonProperty("id")
    private int id;

    public int getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("name")
    private String name;

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("telephone")
    private String telephone;

    @JsonProperty("email")
    private String email;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("age")
    private long age;

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("dt_birth")
    private LocalDate dt_birth;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("id_sector")
    private int id_sector;

    @CreatedDate
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("created_at")
    private Date created_at;

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public int getId_sector() {
        return id_sector;
    }

    public void setId_sector(int id_sector) {
        this.id_sector = id_sector;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDt_birth() {
        return dt_birth;
    }

    public void setDt_birth(LocalDate dt_birth) {
        this.dt_birth = dt_birth;
    }
}
