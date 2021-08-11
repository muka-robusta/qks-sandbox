package com.onetwostory;

import com.onetwostory.service.GreetingService;
import io.quarkus.test.Mock;

import javax.enterprise.context.ApplicationScoped;

@Mock
@ApplicationScoped
public class GreetingServiceTest extends GreetingService {

    @Override
    public String sayHello() {
        return "Hello, Vasya";
    }

}
