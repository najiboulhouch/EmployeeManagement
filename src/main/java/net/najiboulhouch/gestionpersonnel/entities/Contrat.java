package net.najiboulhouch.gestionpersonnel.entities;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "tab_contrats")
@Data
@Entity()
public class Contrat extends  BaseEntity{

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    private String numeroContrat;
    @Type(type="date")
    private Date dateDebut;
    @Type(type="date")
    private Date dateFin;
    private boolean isCourant;
}
