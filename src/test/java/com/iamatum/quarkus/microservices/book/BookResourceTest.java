package com.iamatum.quarkus.microservices.book;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest

class BookResourceTest {
    @Test
    void testCreateABook() {

        String author = "Marcus";

        given()
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .formParam("author", author)
                .formParam("year", 2024)

                .when().post("/api/books")
                .prettyPeek()

                .then()
                .statusCode(201)
                .body("author", is("Marcus"))
                .body("year_of_publication", is(2024))

        ;
    }

}