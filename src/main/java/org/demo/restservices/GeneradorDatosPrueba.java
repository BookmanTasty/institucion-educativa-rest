package org.demo.restservices;

import org.demo.models.*;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import java.util.ArrayList;

@Path("/generardatos")
public class GeneradorDatosPrueba {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Transactional
    public String hello() {
        //creamos 4 salones y los guardamos en un arraylist para su uso posterior
        ArrayList<Salon> salones = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Salon salon = new Salon();
            salon.setNombre("Salon 10" + i);
            salon.persist();
            salones.add(salon);
        }

        // creamos 10 materias
        String[] nombresMaterias = {"Matematicas", "Fisica", "Quimica", "Historia", "Lengua", "Etica", "Filosofia", "Biologia", "Geografia", "Arte"};
        ArrayList<Materia> materias = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String materiaString = nombresMaterias[i];
            Materia materia = new Materia();
            materia.setNombre(materiaString);
            materia.setSalon(salones.get(i % 4));
            materia.persist();
            materias.add(materia);
        }
        ArrayList<Persona> personas = new ArrayList<>();
        String[] nombresPersonas = {"Ezra", "Curran", "Habibah", "Zuniga", "Kaif", "Shah", "Sayed", "Bullock", "Hugh", "Thatcher", "Cohen", "Donnelly", "Levison", "Fry", "Alexie" ,"Fletcher", "Jim", "Hays", "Blair", "Nicholson"};
        // creamos 20 personas
        for (int i = 0; i < 20; i++) {
            long limite1 = 1L;
            long limite2 = 10L;
            long idNombre = limite1 + (long) (Math.random() * (limite2 - limite1));
            long idP = limite1 + (long) (Math.random() * (limite2 - limite1));
            long idM = limite1 + (long) (Math.random() * (limite2 - limite1));
            Persona persona = new Persona();
            persona.setNombre(nombresPersonas[((int) idNombre)]);
            persona.setApellidoPaterno(nombresPersonas[((int) idP)]);
            persona.setApellidoMaterno(nombresPersonas[((int) idM)]);
            persona.persist();
            personas.add(persona);
        }

        // creamos 5 maestros
        ArrayList<Maestro> maestros = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Maestro maestro = new Maestro();
            maestro.setPersona(personas.get(i));
            maestro.persist();
            maestros.add(maestro);
        }
        // creamos 15 alumnos
        ArrayList<Alumno> alumnos = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Alumno alumno = new Alumno();
            alumno.setPersona(personas.get(i + 5));
            alumno.persist();
            alumnos.add(alumno);
        }
        // asignamos las materias a los maestros
        for (int i = 0; i < 5; i++) {
            AsignacionMateria asignacionMateria = new AsignacionMateria();
            asignacionMateria.setMaestro(maestros.get(i));
            asignacionMateria.setMateria(materias.get(i));
            asignacionMateria.persist();
            AsignacionMateria asignacionMateria2 = new AsignacionMateria();
            asignacionMateria2.setMaestro(maestros.get(i));
            asignacionMateria2.setMateria(materias.get(i+5));
            asignacionMateria2.persist();
        }

        // asignamos materias a los alumnos

        ArrayList<AsignacionMateria> asignacionMateriasAlumnos = new ArrayList<>();
        for (Materia materia : materias) {
            for (Alumno alumno : alumnos) {
                AsignacionMateria asignacionMateria = new AsignacionMateria();
                asignacionMateria.setAlumno(alumno);
                asignacionMateria.setMateria(materia);
                asignacionMateria.persist();
                asignacionMateriasAlumnos.add(asignacionMateria);
            }
        }

        // asignamos calificacion a las materias asignadas
        for (AsignacionMateria asignacionMateria : asignacionMateriasAlumnos) {
            Calificacion calificacion = new Calificacion();
            calificacion.setPorcentaje(1L + (long) (Math.random() * (100L - 1L)));;
            calificacion.setAlumno(asignacionMateria.getAlumno());
            calificacion.setMateria(asignacionMateria.getMateria());
            calificacion.persist();
        }

        return "Datos de prueba generados con exito"  ;
    }
}