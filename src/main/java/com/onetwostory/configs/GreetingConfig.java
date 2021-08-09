package com.onetwostory.configs;

import io.quarkus.arc.config.ConfigProperties;
import lombok.Data;

import java.util.Optional;

@Data
@ConfigProperties(prefix = "greeting")
public class GreetingConfig {

    private String name;
    private String suffix = "___";
    private Optional<String> preffix;


}
