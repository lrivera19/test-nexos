/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.DepartmentFacadeLocal;
import entity.Department;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author lfrivera
 */
@ManagedBean(name = "departmentBean")
@SessionScoped
public class DepartmentBean implements Serializable {
    
    @EJB
    private DepartmentFacadeLocal departmentFace;
    private List<Department> listDepartments = new ArrayList<>();
    private Department department;
    private String msj;
    
    @PostConstruct
    public void init() {
        this.department = new Department();
    }
    
    public void guardar() {
        try {
            this.department.setDateTimeCreate(new Date());
            this.departmentFace.create(department);
            this.msj = "Registro creado correctamente";
            limpiar();
        } catch (Exception e) {
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage message = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void modificar() {
        try {
            this.department.setDateTimeModified(new Date());
            this.departmentFace.edit(department);
            this.msj = "Registro actualizado correctamente";
            limpiar();
        } catch (Exception e) {
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage message = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void editar(Department c) {
        this.department = c;
    }

    public void limpiar() {
        this.department = new Department();
    }

    public void eliminar(Department c) {
        try {
            this.departmentFace.remove(c);
            this.msj = "Registro eliminado correctamente";
        } catch (Exception e) {
            this.msj = "Error " + e.getMessage();
            e.printStackTrace();
        }
        FacesMessage message = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public DepartmentFacadeLocal getDepartmentFace() {
        return departmentFace;
    }

    public void setDepartmentFace(DepartmentFacadeLocal departmentFace) {
        this.departmentFace = departmentFace;
    }

    public List<Department> getListDepartments() {
        listDepartments = this.departmentFace.findAll();
        return listDepartments;
    }

    public void setListDepartments(List<Department> listDepartments) {
        this.listDepartments = listDepartments;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getMsj() {
        return msj;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }
    
    
    
}
