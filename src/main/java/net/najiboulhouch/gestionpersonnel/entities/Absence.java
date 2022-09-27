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
    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonBackReference
    private Employee employee;
    private TypeAbsence typeAbsence;
    @Transient
    private Long employeeId;
    private boolean isJustifie;
    private String justification;
}
