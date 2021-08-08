package com.onetwostory.controller;

import com.onetwostory.model.Book;
import com.onetwostory.persistance.map.MapBookDao;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/book")
@RequiredArgsConstructor
public class BookController {

    @Inject
    private MapBookDao bookPersister;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getBooks() {
        final StringBuilder allBooks = new StringBuilder();
        bookPersister.findAll().forEach(book -> allBooks.append(book.toString() + "\n"));
        return allBooks.toString();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String addBook(String book) {
        String[] bookInfo = book.split("-");
        Book addedBook = bookPersister.add(new Book()
                .setAuthor(bookInfo[0])
                .setName(bookInfo[1])
        );

        if (addedBook.getId() != null)
            return "success";
        else return "fail";
    }


}
