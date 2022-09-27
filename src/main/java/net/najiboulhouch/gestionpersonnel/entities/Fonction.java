package net.najiboulhouch.gestionpersonnel.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tab_fonctions")
public class Fonction  extends BaseEntity implements Serializable {

    private String label;
    private String description;

}
