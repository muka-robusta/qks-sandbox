package com.onetwostory.service;

import com.onetwostory.configs.Base64Value;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class GreetingService {

    @ConfigProperty(name = "greeting.base64")
    Base64Value name;

    @ConfigProperty(name = "greeting.value", defaultValue = "Hello")
    String greetingValue;

    @ConfigProperty(name = "greeting.name")
    Optional<String> greetingName;

    public GreetingService() {
    }

    public String sayHello(String name) {
        return "Hello, " + name;
    }

    public String sayHello() {
        return "Hello, " + this.name.getValue();
    }

}
