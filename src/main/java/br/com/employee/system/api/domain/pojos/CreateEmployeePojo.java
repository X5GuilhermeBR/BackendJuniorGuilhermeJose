package br.com.employee.system.api.domain.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.Date;

public class CreateEmployeePojo {

    @JsonProperty("id")
    private int id;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("telephone")
    private String telephone;

    @JsonProperty("email")
    private String email;

    @JsonProperty("dt_birth")
    private LocalDate dt_birth;

    @JsonProperty("id_sector")
    private int id_sector;


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

    public int getId_sector() {
        return id_sector;
    }

    public LocalDate getDt_birth() {
        return dt_birth;
    }

    public void setDt_birth(LocalDate dt_birth) {
        this.dt_birth = dt_birth;
    }

    public void setId_sector(int id_sector) {
        this.id_sector = id_sector;
    }
}
