package org.demo.services;

import org.demo.models.*;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.LinkedHashSet;
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
    public List<Promedio> findAlumnosByPromedio(Long promedio) {
        return Promedio.find("porcentaje", promedio).list();
    }

    @Override
    public List<Alumno> findAlumnosByMaestroId(UUID maestroId) {
        Maestro maestro = (Maestro) Maestro.findById(maestroId);
        List<AsignacionMateria> asignacionMaterias = AsignacionMateria.find("maestro", maestro).list();
        LinkedHashSet<Alumno> alumnos = new LinkedHashSet<>();
        for (AsignacionMateria asignacionMateria : asignacionMaterias) {
            asignacionMateria.getMateria().getAsignacionMaterias().forEach(asignacionMateria1 -> {
                if (asignacionMateria1.getAlumno() != null) {
                    alumnos.add(asignacionMateria1.getAlumno());
                }
            });
        }
        return new ArrayList<Alumno>(alumnos);
    }

    @Override
    public List<Materia> findMateriasBySalonId(UUID salonId) {
        Salon salon = (Salon) Salon.findById(salonId);
        return Materia.find("salon", salon).list();
    }

    @Override
    @Transactional
    public Calificacion createCalificacion(Alumno alumno, Materia materia, Long porcentaje) {
        Calificacion calificacion = new Calificacion();
        calificacion.setAlumno(alumno);
        calificacion.setMateria(materia);
        calificacion.setPorcentaje(porcentaje);
        calificacion.persist();
        return calificacion;
    }


}

