package org.demo.services;

import org.demo.models.Alumno;
import org.demo.models.Maestro;
import org.demo.models.Materia;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

public class InstitucionEducativaImpl implements InstitucionEducativa {

    @Transactional
    @Override
    public List<Maestro> findMaestrosByMateriaId(UUID materiaId) {

        return Maestro.findAll().list();
    }

    @Override
    public List<Alumno> findAlumnosByPromeedio(Long promedio) {
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

