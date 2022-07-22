package org.demo.services;

import org.demo.models.Alumno;
import org.demo.models.Maestro;
import org.demo.models.Materia;

import java.util.List;
import java.util.UUID;

public interface InstitucionEducativa {
    List<Maestro> findMaestrosByMateriaId(UUID materiaId);
    List<Alumno> findAlumnosByPromedio(Long promedio);
    List<Alumno> findAlumnosByMaestroId(UUID maestroId);
    List<Materia> findMateriasBySalonId(UUID salonId);

}
