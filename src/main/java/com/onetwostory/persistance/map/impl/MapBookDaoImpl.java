package com.onetwostory.persistance.map.impl;

import com.onetwostory.model.Book;
import com.onetwostory.persistance.map.MapBookDao;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class MapBookDaoImpl implements MapBookDao {

    private final Map<Long, Book> books = new HashMap<>();
    private Long lastBookId = 0L;

    @Override
    public List<Book> findAll() {
        return List.copyOf(books.values());
    }

    @Override
    public Book getById(Long bookId) {
        return books.get(bookId);
    }

    @Override
    public Book add(Book book) {
        book.setId(lastBookId);
        books.put(lastBookId, book);
        lastBookId++;
        return book;
    }

    @Override
    public Book update(Book book) {
        if (book.getId() == null) return add(book);
        books.put(book.getId(), book);
        return book;
    }

    @Override
    public void delete(Long bookId) {
        books.remove(bookId);
    }
}
