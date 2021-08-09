package com.onetwostory.configs;

import io.quarkus.arc.config.ConfigProperties;
import lombok.Data;

@Data
@ConfigProperties(prefix = "books.config")
public class BookConfig {

    private String language;
    private String region;

}
