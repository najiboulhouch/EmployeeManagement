package net.najiboulhouch.gestionpersonnel.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.najiboulhouch.gestionpersonnel.enums.EtatCivil;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "tab_employees")
@AllArgsConstructor
@NoArgsConstructor
public class Employee  extends  BaseEntity{
    @Column(unique = true )
    private String cin;
    private String nom;
    private String prenom ;
    @Type(type="date")
    private Date dateNaissance;
    private String lieuNaissance;
    private String adresse;
    private String nationalite;
    private EtatCivil etatCivil;
    private String numTel;
    private double salaire;
    private String email;
    @ManyToOne
    @JoinColumn(name = "fonction_id")
    private Fonction fonction;

    @Column(length = 1024)
    private String photo;

    @OneToMany(mappedBy = "employee" ,cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<Absence> absences;

    @OneToMany(mappedBy = "employee" ,cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<Contrat> contrats;

    @OneToMany(mappedBy = "employee" ,cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<Payment> payments;


    @Override
    public String toString() {
        return "Employee{" +
                "cin='" + cin + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", lieuNaissance='" + lieuNaissance + '\'' +
                ", adresse='" + adresse + '\'' +
                ", nationalite='" + nationalite + '\'' +
                ", etatCivil=" + etatCivil +
                ", numTel='" + numTel + '\'' +
                ", salaire=" + salaire +
                ", email='" + email + '\'' +
                ", fonction=" + fonction +
                '}';
    }
}
