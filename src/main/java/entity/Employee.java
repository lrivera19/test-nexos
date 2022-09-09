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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author lfrivera
 */
@Entity
@Table(name = "empleados")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "documento_tipo")
    @NotNull
    @Size(min = 1, max = 3)
    private String documentType;

    @Column(name = "documento_numero")
    @NotNull
    @Size(min = 1, max = 16)
    private String documentNumber;

    @Column(name = "nombres")
    @NotNull
    @Size(min = 1, max = 45)
    private String names;

    @Column(name = "apellidos")
    @NotNull
    @Size(min = 1, max = 45)
    private String surnames;
    
    @Column(name = "ciudad")
    @NotNull
    @Size(min = 1, max = 45)
    private String city;

    @Column(name = "direccion")
    @NotNull
    @Size(min = 1, max = 45)
    private String address;

    @Column(name = "correo_electronico")
    @NotNull
    @Size(min = 1, max = 45)
    private String email;

    @Column(name = "telefono")
    @NotNull
    @Size(min = 1, max = 16)
    private String phone;

    @Column(name = "fecha_hora_crea")
    @NotNull
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateTimeCreate;

    @Column(name = "fecha_hora_modifica")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateTimeModified;
    
    @JoinColumn(name = "departamentos_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @NotNull
    private Department departmentId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + this.id;
        return hash;
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
        final Employee other = (Employee) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", documentType=" + documentType + ", documentNumber=" + documentNumber + ", names=" + names + ", surnames=" + surnames + ", city=" + city + ", address=" + address + ", email=" + email + ", phone=" + phone + ", dateTimeCreate=" + dateTimeCreate + ", dateTimeModified=" + dateTimeModified + '}';
    }

}
