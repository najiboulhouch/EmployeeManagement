package net.najiboulhouch.gestionpersonnel.api;

import net.najiboulhouch.gestionpersonnel.entities.Absence;
import net.najiboulhouch.gestionpersonnel.entities.Employee;
import net.najiboulhouch.gestionpersonnel.exceptions.ResourceNotFoundException;
import net.najiboulhouch.gestionpersonnel.services.AbsenceService;
import net.najiboulhouch.gestionpersonnel.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Najib OULHOUCH
 * @version 1.0
 */


@RestController
@RequestMapping(path = "api/v1/absences")
public class AbsenceController extends BaseController<Absence>{

    @Autowired
    private AbsenceService absenceService ;

    @Autowired
    private EmployeeService employeeService;

    @Override
    public ResponseEntity<Page<Absence>> getAllRows(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                    @RequestParam(value = "size", defaultValue = "10") Integer size) {
       ResponseEntity<Page<Absence>>  pageResponseEntity =  super.getAllRows(page, size);
       Page<Absence> absences =  pageResponseEntity.getBody();
        absences.forEach(absence ->  {
            absence.setEmployeeId(absence.getEmployee().getId());
        } );
        return new ResponseEntity<>(absences , HttpStatus.OK );
    }

    @GetMapping(path = "/getNbrAbsenceByEmployee/{id}")
    public ResponseEntity<Integer> getNbrAbsencesByEmployee(@PathVariable(value = "id") Long employeeId )
            throws ResourceNotFoundException {
        Employee employee = getEmployee(employeeId);
        return new ResponseEntity<>(absenceService.getNbrJoursAbsenceByEmployee(employee) , HttpStatus.OK);
    }


    @GetMapping(path = "/getNbrCongeByEmployee/{id}")
    public ResponseEntity<Integer> getNbrCongeByEmployee(@PathVariable(value = "id") Long employeeId )
            throws ResourceNotFoundException{
        Employee employee = getEmployee(employeeId);
        return new ResponseEntity<>(absenceService.getNbrCongeByEmployee(employee) , HttpStatus.OK);
    }


    @GetMapping("/getAbsenceEmploye/{id}")
    public ResponseEntity<List<Absence>> getAbsencesForEmployee(@PathVariable(value = "id") Long employeeId)
    throws ResourceNotFoundException{
        Employee employee = getEmployee(employeeId);
        return new ResponseEntity<>(absenceService.getAbsencesForEmployee(employee) , HttpStatus.OK );
    }


    private Employee getEmployee(Long employeeId) {
        Employee employee = employeeService.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId) );
        return employee;
    }



}
