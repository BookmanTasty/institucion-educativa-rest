package org.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "maestro_cesar_leyva")
public class Maestro extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")

    @Column(name = "id", nullable = false)
    private UUID id;
    @JoinColumn(name = "persona_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Persona persona;
    @OneToMany(mappedBy = "maestro", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<AsignacionMateria> asignacionMateria;

    public Maestro() {
    }

    public Maestro(UUID id, Persona persona) {
        this.id = id;
        this.persona = persona;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<AsignacionMateria> getAsignacionMateria() {
        return asignacionMateria;
    }

    public void setAsignacionMateria(List<AsignacionMateria> asignacionMateria) {
        this.asignacionMateria = asignacionMateria;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }


}