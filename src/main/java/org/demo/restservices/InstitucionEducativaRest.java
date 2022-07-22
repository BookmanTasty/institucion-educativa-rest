package org.demo.restservices;


import org.demo.models.*;
import org.demo.restservices.objects.IngresoCalificacion;
import org.demo.services.InstitucionEducativa;
import org.demo.services.InstitucionEducativaImpl;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.*;


@Path("/institucion")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class InstitucionEducativaRest {
    InstitucionEducativa institucion = new InstitucionEducativaImpl();

    @GET
    @Path("/maestro/materia/{uuid}")
    public List<Maestro> findMaestrosByMateriaId(@PathParam("uuid") UUID materiaId) {
        return institucion.findMaestrosByMateriaId(materiaId);
    }

    @GET
    @Path("/alumnos/promedio/{porcentaje}")
    public List<Promedio> findAlumnosByPromedio(@PathParam("porcentaje") Long porcentaje) {
        return institucion.findAlumnosByPromedio(porcentaje);
    }

    @GET
    @Path("/alumnos/maestro/{uuid}")
    public List<Alumno> findAlumnosByMaestroId(@PathParam("uuid") UUID maestroId) {
        return institucion.findAlumnosByMaestroId(maestroId);
    }

    @GET
    @Path("/materias/salon/{uuid}")
    public List<Materia> findMateriasBySalonId(@PathParam("uuid") UUID salonId) {
        return institucion.findMateriasBySalonId(salonId);
    }

    @POST
    @Path("/materias/calificacion")
    @Transactional
    public Response createCalificacion(IngresoCalificacion ingresoCalificacion) {

        try {
            Alumno alumno = Alumno.findById(ingresoCalificacion.getAlumnoId());
            Materia materia = Materia.findById(ingresoCalificacion.getMateriaId());
            if (alumno == null || materia == null) {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }else {
                Calificacion calificacion = institucion.createCalificacion(alumno, materia, ingresoCalificacion.getPorcentaje());
                HashMap<String, String> map = new HashMap<>();
                map.put("id", calificacion.getId().toString());
                return Response.ok(map).build();
            }
        }catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }


}
