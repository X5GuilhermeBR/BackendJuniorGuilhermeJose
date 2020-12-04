package br.com.employee.system.api.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tb_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "sector_id")
    private Sector sector;

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }
//    @NotNull
//    @Column(name = "id_sector")
//    private int id_sector;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @NotNull
    @Column(name = "cpf")
    private String cpf;

        /**
         * O nome.
         */
        @NotEmpty
        @Column(name = "name", length = 100)
        private String name;

        /**
         * O telefone.
         */
        @NotNull
        @Column(name = "telephone", length = 11)
        private String telephone;

    @NotNull
    @Column(name = "email", length = 100)
    private String email;

    @NotNull
    @Column(name = "dt_birth")
    private LocalDate dt_birth;

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

    public int getId() {
        return id;
    }

    public LocalDate getDt_birth() {
        return dt_birth;
    }

    public void setDt_birth(LocalDate dt_birth) {
        this.dt_birth = dt_birth;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

//    public int getId_sector() {
//        return id_sector;
//    }
//
//    public void setId_sector(int id_sector) {
//        this.id_sector = id_sector;
//    }

    @CreatedDate
    @Column(name = "created_at")
    private Date created_at;

}
