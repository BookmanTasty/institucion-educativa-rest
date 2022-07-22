package org.demo.restservices.objects;

import java.util.UUID;

public class IngresoCalificacion {
    UUID alumnoId;
    UUID materiaId;
    Long porcentaje;

    public IngresoCalificacion() {
    }

    public IngresoCalificacion(UUID alumnoId, UUID materiaId, Long porcentaje) {
        this.alumnoId = alumnoId;
        this.materiaId = materiaId;
        this.porcentaje = porcentaje;
    }

    public UUID getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(UUID alumnoId) {
        this.alumnoId = alumnoId;
    }

    public UUID getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(UUID materiaId) {
        this.materiaId = materiaId;
    }

    public Long getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Long porcentaje) {
        this.porcentaje = porcentaje;
    }
}
