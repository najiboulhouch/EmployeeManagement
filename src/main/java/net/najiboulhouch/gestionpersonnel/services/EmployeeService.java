package net.najiboulhouch.gestionpersonnel.services;

import net.najiboulhouch.gestionpersonnel.entities.Employee;

import java.util.List;


public interface EmployeeService extends BaseService<Employee> {

    public List<Employee> findAllEmployees();
}
