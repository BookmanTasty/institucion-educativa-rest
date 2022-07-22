package org.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
@Table(name = "promedio_cesar_leyva")
public class Promedio extends PanacheEntity {

    @Column(nullable = false)
    private long porcentaje;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "alumno_id")
    @JsonBackReference
    private Alumno alumno;


}