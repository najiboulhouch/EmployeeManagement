package net.najiboulhouch.gestionpersonnel.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import net.najiboulhouch.gestionpersonnel.enums.TypeAbsence;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Table(name = "tab_absences")
@Entity
@Data
public class Absence extends BaseEntity{
    @Type(type="date")
    private Date dateDebut;
    @Type(type="date")
    private Date dateFin;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    @JsonBackReference
    private Employee employee;
    private TypeAbsence typeAbsence;
    @Transient
    private Long employeeId;
    private boolean isJustifie;
    private String justification;

    @Override
    public String toString() {
        return "Absence{" +
                "dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", employee=" + employee +
                ", typeAbsence=" + typeAbsence +
                ", employeeId=" + employeeId +
                ", isJustifie=" + isJustifie +
                ", justification='" + justification + '\'' +
                '}';
    }
}
