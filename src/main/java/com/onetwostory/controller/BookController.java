package com.onetwostory.controller;

import com.onetwostory.service.BookService;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/book")
@RequiredArgsConstructor
public class BookController {

    @Inject
    BookService bookService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getBooks() {
        return bookService.getAllBooks();
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String addBook(String book) {
        return bookService.addToLib(book);
    }


}
