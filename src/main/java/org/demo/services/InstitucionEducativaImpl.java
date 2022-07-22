package org.demo.services;

import org.demo.models.*;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class InstitucionEducativaImpl implements InstitucionEducativa {

    @Transactional
    @Override
    public List<Maestro> findMaestrosByMateriaId(UUID materiaId) {
        Materia materia = (Materia) Materia.findById(materiaId);
        List<AsignacionMateria> asignacionMaterias = materia.getAsignacionMaterias();
        List<Maestro> maestros = new ArrayList<>();
        for (AsignacionMateria asignacionMateria : asignacionMaterias) {
            if (asignacionMateria.getMaestro() != null) {
                maestros.add(asignacionMateria.getMaestro());
            }
        }
        return maestros;
    }

    @Override
    public List<Alumno> findAlumnosByPromedio(Long promedio) {

        return null;
    }

    @Override
    public List<Alumno> findAlumnosByMaestroId(UUID maestroId) {
        return null;
    }

    @Override
    public List<Materia> findMateriasBySalonId(UUID salonId) {
        return null;
    }
}

