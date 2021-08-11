package com.onetwostory.service;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.wildfly.common.Assert;

import javax.inject.Inject;

@QuarkusTest
public class GreetingServiceTest {

    @Inject
    GreetingService greetingService;

    @Test
    void checkReturnsHello() {
        Assert.assertTrue(greetingService.sayHello().equals("Hello, Vasya"));
    }
}
