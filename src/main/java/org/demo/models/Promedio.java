package org.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.*;
import java.util.UUID;

//utilizo Subselect para crear una vista que me de los promedios de cada alumno
@Entity
@Immutable
@Subselect("select row_number() over() as id, alumno_id as alumno,round(avg(porcentaje)) as porcentaje from calificacion_cesar_leyva group by alumno_id")
public class Promedio extends PanacheEntityBase {

    @Id
    long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "alumno")
    private Alumno alumno;
    private long porcentaje;

    public long getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(long porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
}