package com.onetwostory;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class BookResourceTest {
    @Test
    void testGetAllBooks() {
        given().when().get("/book")
                .then()
                .statusCode(200)
                .body(is(""));
    }
}
