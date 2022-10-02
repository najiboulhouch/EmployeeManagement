package net.najiboulhouch.gestionpersonnel.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Table(name = "tab_contrats")
@Data
@Entity()
public class Contrat extends  BaseEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    @JsonBackReference
    private Employee employee;
    private String numeroContrat;
    @Type(type="date")
    private Date dateDebut;
    @Type(type="date")
    private Date dateFin;
    private boolean isCourant;

    @Override
    public String toString() {
        return "Contrat{" +
                "employee=" + employee +
                ", numeroContrat='" + numeroContrat + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", isCourant=" + isCourant +
                '}';
    }
}
