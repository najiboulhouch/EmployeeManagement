package net.najiboulhouch.gestionpersonnel.respositories;

import net.najiboulhouch.gestionpersonnel.entities.Absence;
import net.najiboulhouch.gestionpersonnel.entities.Employee;

import java.util.List;

public interface AbsenceRepository extends BaseRepository<Absence> {

    List<Absence> findByIsJustifieFalseAndEmployee(Employee employee);

    List<Absence> findByTypeAbsenceEqualsAndEmployee(int id , Employee employee);



}
