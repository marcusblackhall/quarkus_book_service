package com.iamatum.quarkus.microservices.book;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class BookResourceTest {
    @Test
    void testCreateABook() {

        String author="Marcus";

        given()
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .formParam("author",author)
          .when().post("/api/books")
                .prettyPeek()

          .then()
             .statusCode(201)
             .body("author",is("Marcus"));
    }

}