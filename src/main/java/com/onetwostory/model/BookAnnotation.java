package com.onetwostory.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Accessors(chain = true)
public class BookAnnotation {
    private Long id;

    @Min(value = 5, message = "Book must contain at least 5 pages")
    @Max(value = 3000, message = "Book`s maximum page number is 3000")
    private Integer numberOfPages;
}
