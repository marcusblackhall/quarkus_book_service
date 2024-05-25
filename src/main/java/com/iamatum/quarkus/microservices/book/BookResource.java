package com.iamatum.quarkus.microservices.book;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;


@Path("/api/books")
public class BookResource {

    @Inject
    Logger logger;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Book createBook(Book book) {
        logger.info(book);
        return book;

    }
}
