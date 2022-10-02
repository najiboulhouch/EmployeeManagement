package net.najiboulhouch.gestionpersonnel.api;

import net.najiboulhouch.gestionpersonnel.entities.Employee;
import net.najiboulhouch.gestionpersonnel.exceptions.ResourceNotFoundException;
import net.najiboulhouch.gestionpersonnel.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Najib OULHOUCH
 * @version 1.0
 */

@RequestMapping(path = "api/v1/employees")
@RestController
public class EmployeeController extends BaseController<Employee> {

    @Autowired
    private EmployeeService employeeService;

    private static final String EMPLOYEE_NOT_EXIST_MESSAGE = "Employee not found for this id";


    @GetMapping("/employeesForList")
    public ResponseEntity<List<Employee>> selectAllEmployeesToList(){
        List<Employee> employees = employeeService.findAllEmployees();
        if(employees.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>( employees, HttpStatus.OK );
    }


    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId ,
                                                   @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {

        Employee employee = getEntity(employeeId , EMPLOYEE_NOT_EXIST_MESSAGE);

        employee.setCin(employeeDetails.getCin());
        employee.setNom(employeeDetails.getNom());
        employee.setPrenom(employeeDetails.getPrenom());
        employee.setAdresse(employeeDetails.getAdresse());
        employee.setDateNaissance(employeeDetails.getDateNaissance());
        employee.setLieuNaissance(employeeDetails.getLieuNaissance());
        employee.setSalaire(employeeDetails.getSalaire());
        employee.setNumTel(employeeDetails.getNumTel());
        employee.setPhoto(employeeDetails.getPhoto());
        employee.setNationalite(employeeDetails.getNationalite());
        employee.setEtatCivil(employeeDetails.getEtatCivil());
        employee.setEmail(employeeDetails.getEmail());

        final Employee updateEmployee  = employeeService.save(employee);
        return ResponseEntity.ok(updateEmployee);
    }



}
