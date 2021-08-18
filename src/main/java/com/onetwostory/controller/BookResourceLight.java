package com.onetwostory.controller;

import com.onetwostory.model.Book;
import io.quarkus.runtime.util.StringUtil;

import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Path("/books")
public class BookResourceLight {

    @Inject
    Validator validator;

    private static final List<Book> books = new ArrayList<>();

    static {
        books.add(new Book(1L, "Життя комах", "Victor Pelevin"));
    }

//
//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public String showAllBooks() {
//        return StringUtil.join(",",
//                books.stream()
//                        .map(Book::toString)
//                        .collect(Collectors.toList())
//                        .listIterator());
//    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllBooks() {
        return Response.status(202)
                .entity(books)
                .build();
//        return Response.ok(books).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBook(@Valid Book book) {
        books.add(book);
        return Response.ok(book).build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBook(@PathParam("id") Integer id,Book book) {
        final Set<ConstraintViolation<Book>> violations = validator.validate(book);
        if (violations.size() > 0)
            return Response.status(400)
                .entity("Check Book for correct input")
                .build();

        final Book removed = books.remove(id.intValue());
        if (removed == null) return Response.status(404).entity("Not found").build();
        books.add(book);
        return Response.ok(book).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteBook(@PathParam("id") Integer id) {
        Book removedBook = books.remove(id.intValue());
        return "deleted element: " + removedBook.toString();
    }
}
