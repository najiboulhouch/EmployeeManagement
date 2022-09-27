package net.najiboulhouch.gestionpersonnel.entities;

import lombok.Data;

import javax.persistence.*;


@MappedSuperclass
@Data
public class BaseEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
}
