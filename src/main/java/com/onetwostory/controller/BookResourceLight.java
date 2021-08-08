package com.onetwostory.controller;

import io.quarkus.runtime.util.StringUtil;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/books")
public class BookResourceLight {

    private static final List<String> books = new ArrayList<>();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getAllBooks() {
        return StringUtil.join(", ", books.listIterator()).toString();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String addBook(String book) {
        books.add(book);
        return book;
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String updateBook(@PathParam("id") Integer id, String book) {
        books.remove(id.intValue());
        books.add(book);
        return book;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteBook(@PathParam("id") Integer id) {
        String removedBook = books.remove(id.intValue());
        return "deleted element: " + removedBook;
    }
}
