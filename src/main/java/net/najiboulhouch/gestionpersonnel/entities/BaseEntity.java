package net.najiboulhouch.gestionpersonnel.entities;

import lombok.Data;

import javax.persistence.*;


@MappedSuperclass
@Data
public class BaseEntity {
    @Id
    @SequenceGenerator(name="pk_sequence",sequenceName="entity_id_seq", allocationSize=1  , initialValue = 80 )
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence" )
    @Column(name="ID")
    private Long id;
}
