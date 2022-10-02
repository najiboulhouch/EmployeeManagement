package net.najiboulhouch.gestionpersonnel.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "tab_payments")
public class Payment extends BaseEntity{
    private double salaire;
    @Type(type="date")
    private Date datePayment;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonBackReference
    private Employee employee;

    @Override
    public String toString() {
        return "Payment{" +
                "salaire=" + salaire +
                ", datePayment=" + datePayment +
                ", employee=" + employee +
                '}';
    }
}
