package io.centilliard.rest;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1")
public class HeadlessResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/about")
    public Response about() {

        JsonObject about = Json.createObjectBuilder().add("Musslecraker Headless CMS", "Version 1.0")
                .add("Stable", "false")
                .build();

        return Response.ok(about).build();
    }

}