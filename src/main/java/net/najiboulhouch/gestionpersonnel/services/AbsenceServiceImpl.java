package net.najiboulhouch.gestionpersonnel.services;

import net.najiboulhouch.gestionpersonnel.entities.Absence;
import net.najiboulhouch.gestionpersonnel.entities.Employee;
import net.najiboulhouch.gestionpersonnel.enums.TypeAbsence;
import net.najiboulhouch.gestionpersonnel.respositories.AbsenceRepository;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
@Qualifier("absenceServiceImpl")
public class AbsenceServiceImpl extends BaseServiceImpl<Absence> implements AbsenceService {

    @Autowired
    private AbsenceRepository absenceRepository ;

    @Override
    public Integer getNbrJoursAbsenceByEmployee(Employee employee) {
        final int[] numberAbs = {0};
        employee.getAbsences().forEach(absence ->{
            if(absence.isJustifie() == false )
            numberAbs[0] += getNbJoursBetween(absence.getDateDebut() , absence.getDateFin());
        });
        return Arrays.stream(numberAbs).sum();
    }

    @Override
    public Integer getNbrCongeByEmployee(Employee employee) {
        final int[] numberAbs = {0};
        employee.getAbsences().forEach(absence ->{
            if(absence.getTypeAbsence() == TypeAbsence.ADMINISTRATIVE_LEAVE)
                numberAbs[0] += getNbJoursBetween(absence.getDateDebut() , absence.getDateFin());
        });
        return Arrays.stream(numberAbs).sum();
    }

    @Override
    public List<Absence> getAbsencesForEmployee(Employee employee) {
        return absenceRepository.findByIsJustifieFalseAndEmployee(employee);
    }


    private int getNbJoursBetween(Date dateStart, Date dateEnd) {
        DateTimeZone.setDefault(DateTimeZone.UTC);
        DateTime startDate = DateTime.parse(dateStart.toString());
        DateTime endDate = DateTime.parse(dateEnd.toString());
        Days dateResult = Days.daysBetween(startDate, endDate);
        return dateResult.getDays();
    }



}
