package com.onetwostory.controller;

import com.onetwostory.service.GreetingService;
import com.onetwostory.service.cryptocurrency.CurrencyService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("/hello")
public class Greeter {

    private static final String EXAMPLE_TOKEN = "a6dfsdf8gfdg";
    private static final String AUTHOR_NAME = "Ilya";

    @Inject
    GreetingService greetingService;

    @Inject
    @RestClient
    CurrencyService currencyService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return greetingService.sayHello();
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
    @Path("/currency")
    @Produces(MediaType.APPLICATION_JSON)
    public Response showCurrency(@QueryParam("id") String id) {
        return Response.status(200)
                .entity(currencyService.getCurrency(id))
                .build();
    }
//
//    @GET
//    @Path("/{name}")
//    @Consumes(MediaType.TEXT_PLAIN)
//    @Produces(MediaType.TEXT_PLAIN)
//    public String greetSomeone(@PathParam("name") String name) {
//        return "Hello, " + name;
//    }


}