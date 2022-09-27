package net.najiboulhouch.gestionpersonnel.api;

import net.najiboulhouch.gestionpersonnel.entities.Employee;
import net.najiboulhouch.gestionpersonnel.exceptions.ResourceNotFoundException;
import net.najiboulhouch.gestionpersonnel.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Najib OULHOUCH
 * @version 1.0
 */

@RequestMapping(path = "api/v1/employees")
@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping(path="photoEmployee/{id}",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
        Employee employee = getEntity(id , EMPLOYEE_NOT_EXIST_MESSAGE);
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/"+employee.getPhoto()));
    }


    @PostMapping(path = "/uploadPhoto/{id}")
    public void uploadPhoto(MultipartFile file, @PathVariable Long id) throws Exception{
        Employee employee=getEntity(id , EMPLOYEE_NOT_EXIST_MESSAGE);
        employee.setPhoto(file.getOriginalFilename());
        Files.write(Paths.get(System.getProperty("user.home")+"/"+employee.getPhoto()),file.getBytes());
        employeeService.save(employee);
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
        employee.setNationalite(employeeDetails.getNationalite());
        employee.setEtatCivil(employeeDetails.getEtatCivil());
        employee.setEmail(employeeDetails.getEmail());

        final Employee updateEmployee  = employeeService.save(employee);
        return ResponseEntity.ok(updateEmployee);
    }



}
