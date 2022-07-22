package org.demo.restservices;

import org.demo.models.Maestro;
import org.demo.services.InstitucionEducativa;

import javax.inject.Scope;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.Console;
import java.util.List;
import java.util.UUID;

@Path("/institucion")
public class InstitucionEducativaRest {



    @GET
    @Path("/materia/maestros")
    public List<Maestro> findMaestrosByMateriaId(UUID materiaId) {
        return Maestro.listAll();
    }

    @GET
    @Path("/maestros")
    public Maestro getMaestro() {
        UUID materiaId = UUID.fromString("25e4ee50-7be0-4dcb-b2cc-2fcb424d992d");
        Maestro maestro = Maestro.findById(materiaId);
        return maestro;
    }


}
