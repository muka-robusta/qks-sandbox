package com.onetwostory.persistance.map;

import com.onetwostory.model.Book;

import java.util.List;

public interface MapBookDao {
    List<Book> findAll();
    Book getById(Long bookId);
    Book add(Book book);
    Book update(Book book);
    void delete(Long bookId);
}
