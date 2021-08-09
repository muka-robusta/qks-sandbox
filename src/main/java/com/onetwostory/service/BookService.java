package com.onetwostory.service;

import com.onetwostory.configs.Base64Value;
import com.onetwostory.configs.BookConfig;
import com.onetwostory.model.Book;
import com.onetwostory.persistance.map.MapBookDao;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class BookService {

    @Inject
    private MapBookDao mapBookDao;

    @Inject
    private BookConfig bookConfig;

    @ConfigProperty(name = "book.splitter")
    private String splitter;

    public String addToLib(String bookInfo) {
        // String[] bookInfoArray = bookInfo.split(splitter);
        String[] bookInfoArray = bookInfo.split(ConfigProvider.getConfig().getValue("book.splitter", String.class));
        final Book book = new Book()
                .setName(bookInfoArray[1])
                .setAuthor(bookInfoArray[0]);
        mapBookDao.add(book);

        return bookInfo;
    }

    public String getAllBooks() {
        final StringBuilder stringBuilder = new StringBuilder();
        mapBookDao.findAll().forEach(book -> stringBuilder.append(book.toString() + "\n"));
        return stringBuilder.toString();
    }
}
