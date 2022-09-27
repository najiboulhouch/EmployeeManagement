package net.najiboulhouch.gestionpersonnel.services;

import net.najiboulhouch.gestionpersonnel.entities.Employee;
import net.najiboulhouch.gestionpersonnel.respositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl extends BaseServiceImpl<Employee> implements EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }
}
