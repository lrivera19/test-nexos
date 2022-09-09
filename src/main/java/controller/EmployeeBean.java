/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.EmployeeFacadeLocal;
import entity.Department;
import entity.Employee;
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
@ManagedBean(name = "employeeBean")
@SessionScoped
public class EmployeeBean implements Serializable {

    @EJB
    private EmployeeFacadeLocal employeeFace;
    private List<Employee> listEmployees = new ArrayList<>();
    private Employee employee;
    private Department department;
    private List<String> listDocumentTypes;
    private String msj;

    @PostConstruct
    public void init() {
        this.employee = new Employee();
        this.department = new Department();
        cargarTiposDocumento();
    }

    public void cargarTiposDocumento() {
        listDocumentTypes = new ArrayList<>();
        listDocumentTypes.add("RC");
        listDocumentTypes.add("TI");
        listDocumentTypes.add("CC");
        listDocumentTypes.add("CE");
    }

    public void guardar() {
        try {
            this.employee.setDepartmentId(department);
            this.employee.setDateTimeCreate(new Date());
            this.employeeFace.create(employee);
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
            this.employee.setDepartmentId(department);
            this.employee.setDateTimeModified(new Date());
            this.employeeFace.edit(employee);
            this.msj = "Registro actualizado correctamente";
            limpiar();
        } catch (Exception e) {
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage message = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void editar(Employee c) {
        this.department.setId(c.getDepartmentId().getId());
        this.employee = c;
    }

    public void limpiar() {
        this.department = new Department();
        this.employee = new Employee();
    }

    public void eliminar(Employee c) {
        try {
            this.employeeFace.remove(c);
            this.msj = "Registro eliminado correctamente";
        } catch (Exception e) {
            this.msj = "Error " + e.getMessage();
            e.printStackTrace();
        }
        FacesMessage message = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public EmployeeFacadeLocal getEmployeeFace() {
        return employeeFace;
    }

    public void setEmployeeFace(EmployeeFacadeLocal employeeFace) {
        this.employeeFace = employeeFace;
    }

    public List<Employee> getListEmployees() {
        listEmployees = this.employeeFace.findAll();
        return listEmployees;
    }

    public void setListEmployees(List<Employee> listEmployees) {
        this.listEmployees = listEmployees;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    public List<String> getListDocumentTypes() {
        return listDocumentTypes;
    }

    public void setListDocumentTypes(List<String> listDocumentTypes) {
        this.listDocumentTypes = listDocumentTypes;
    }

}
