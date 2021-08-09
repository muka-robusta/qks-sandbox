package com.onetwostory.controller;

import com.onetwostory.service.BookService;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/book")
@RequiredArgsConstructor
public class BookController {

    @Inject
    private BookService bookService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getBooks() {
        return bookService.getAllBooks();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String addBook(String book) {
        String addedBook = bookService.addToLib(book);
        return addedBook;
    }


}
