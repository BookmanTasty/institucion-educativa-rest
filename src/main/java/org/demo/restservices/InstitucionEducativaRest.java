package org.demo.restservices;

import io.quarkus.panache.common.Sort;
import org.demo.models.AsignacionMateria;
import org.demo.models.Maestro;
import org.demo.models.Materia;
import org.demo.services.InstitucionEducativa;
import org.demo.services.InstitucionEducativaImpl;
import org.jboss.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Path("/institucion")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class InstitucionEducativaRest {

    private static final Logger LOGGER = Logger.getLogger(Maestro.class.getName());
    InstitucionEducativa institucion = new InstitucionEducativaImpl();
    @GET
    @Path("/maestros")
    public List<Maestro> get() {
        return Maestro.listAll(Sort.by("id"));
    }

    @GET
    @Path("/materias")
    public List<Materia> getMaterias() {
        return Materia.listAll(Sort.by("id"));
    }
    @GET
    @Path("/materias/asignadas")
    public List<AsignacionMateria> getMateriasAsignadas() {
        return AsignacionMateria.listAll(Sort.by("id"));
    }


    @GET
    @Path("/materias/maestro/{uuid}")
    public List<Maestro> findMaestrosByMateriaId(@PathParam("uuid") UUID materiaId) {
        return institucion.findMaestrosByMateriaId(materiaId);
    }

}
