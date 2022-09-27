package net.najiboulhouch.gestionpersonnel.services;

import net.najiboulhouch.gestionpersonnel.entities.Absence;
import net.najiboulhouch.gestionpersonnel.entities.Employee;

import java.util.List;

public interface AbsenceService extends BaseService<Absence> {

     Integer getNbrJoursAbsenceByEmployee(Employee employee);

     Integer getNbrCongeByEmployee(Employee employee);

     List<Absence> getAbsencesForEmployee(Employee employee);

}
