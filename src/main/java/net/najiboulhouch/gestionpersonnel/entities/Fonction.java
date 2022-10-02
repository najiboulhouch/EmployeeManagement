package net.najiboulhouch.gestionpersonnel.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tab_fonctions")
public class Fonction  extends BaseEntity implements Serializable {

    @NotNull
    private String label;
    @NotNull
    private String description;

    @OneToMany(mappedBy = "fonction" ,cascade = CascadeType.ALL ,
            fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<Employee> employees;

    @Override
    public String toString() {
        return "Fonction{" +
                "label='" + label + '\'' +
                ", description='" + description + '\'' +
                ", employees=" + employees +
                '}';
    }
}
