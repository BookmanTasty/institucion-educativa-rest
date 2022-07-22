package org.demo.services;

import org.demo.models.*;

import java.util.List;
import java.util.UUID;

public interface InstitucionEducativa {
    List<Maestro> findMaestrosByMateriaId(UUID materiaId);
    List<Promedio> findAlumnosByPromedio(Long promedio);
    List<Alumno> findAlumnosByMaestroId(UUID maestroId);
    List<Materia> findMateriasBySalonId(UUID salonId);
    Calificacion createCalificacion(Alumno alumno, Materia materia, Long porcentaje);

}
