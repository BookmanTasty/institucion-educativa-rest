package org.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "alumno_cesar_leyva")
public class Alumno  extends PanacheEntityBase {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")

    @Column(name = "id", nullable = false)
    private UUID id;
    @JoinColumn(name = "persona_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Persona persona;
    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Calificacion> calificaciones;
    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<AsignacionMateria> asignacionMaterias;


    public void setCalificacions(List<Calificacion> calificacions) {
        this.calificaciones = calificacions;
    }


    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public List<AsignacionMateria> getAsignacionMaterias() {
        return asignacionMaterias;
    }

    public void setAsignacionMaterias(List<AsignacionMateria> asignacionMaterias) {
        this.asignacionMaterias = asignacionMaterias;
    }
}