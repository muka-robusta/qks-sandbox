package com.onetwostory.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Locale;

@Data
@Accessors(chain = true)
public class Book {

    private Long id;
    private String name;
    private String author;

    public String toString() {
        return "[ " + author + "] - " + name;
    }

}
