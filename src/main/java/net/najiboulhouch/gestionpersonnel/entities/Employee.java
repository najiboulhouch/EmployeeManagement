package net.najiboulhouch.gestionpersonnel.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.najiboulhouch.gestionpersonnel.enums.EtatCivil;

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
    @Column(nullable = true, length = 64)
    private String photo;

    @OneToMany(mappedBy = "employee" ,cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonManagedReference
    private List<Absence> absences;


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
