package com.onetwostory.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@Path("/hello")
public class Greeter {

    private static final String EXAMPLE_TOKEN = "a6dfsdf8gfdg";
    private static final String AUTHOR_NAME = "Ilya";

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addHello(@HeaderParam("token") String token, @QueryParam("name") String aName, String body) {
        if (EXAMPLE_TOKEN.equals(token))
            return "success: author name is " + AUTHOR_NAME;
        else return "fail";
    }

    @GET
    @Path("/{name}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String greetSomeone(@PathParam("name") String name) {
        return "Hello, " + name;
    }


}