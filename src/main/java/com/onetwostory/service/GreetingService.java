package com.onetwostory.service;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

    public String sayHello(String name) {
        return "Hello, " + name;
    }

}
