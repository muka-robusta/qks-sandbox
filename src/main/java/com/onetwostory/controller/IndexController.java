package com.onetwostory.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class IndexController {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String indexPage() {
        return "chat.html";
    }

}
