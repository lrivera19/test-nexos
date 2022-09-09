/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author lfrivera
 */
@Entity
@Table(name = "departamentos")
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "departamento_codigo")
    @NotNull
    @Size(min = 1, max = 45)
    private String code;

    @Column(name = "departamento_nombre")
    @NotNull
    @Size(min = 1, max = 45)
    private String name;

    @Column(name = "fecha_hora_crea")
    @NotNull
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateTimeCreate;

    @Column(name = "fecha_hora_modifica")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateTimeModified;
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + this.id;
        return hash;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateTimeCreate() {
        return dateTimeCreate;
    }

    public void setDateTimeCreate(Date dateTimeCreate) {
        this.dateTimeCreate = dateTimeCreate;
    }

    public Date getDateTimeModified() {
        return dateTimeModified;
    }

    public void setDateTimeModified(Date dateTimeModified) {
        this.dateTimeModified = dateTimeModified;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Department other = (Department) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Department{" + "id=" + id + ", code=" + code + ", name=" + name + ", dateTimeCreate=" + dateTimeCreate + ", dateTimeModified=" + dateTimeModified + '}';
    }
}
