package com.iamatum.quarkus.microservices.book;

import com.iamatum.quarkus.microservices.client.NumberProxy;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.Instant;


@Path("/api/books")
@Tag(name = "Quarkus Book Resource", description = "Book resource endpoint")
public class BookResource {

    @Inject
    Logger logger;

    @RestClient
    NumberProxy numberProxy;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Operation(description = "Creates a book with an isbn 13 format")
    @Fallback(
            fallbackMethod = "createBookFallback"

    )
    @Retry(delay = 3000, maxRetries = 3)
    public Response createBook(@FormParam("title") String title,
                               @FormParam("author") String author,
                               @FormParam("year") int yearOfPublication,
                               @FormParam("genre") String genre
    ) {
        Book book = new Book();
        book.author = author;
        book.isbn13 = numberProxy.generateIsbnnumbers().isbn13;

        book.genre = genre;
        book.title = title;
        book.creationDate = Instant.now();
        book.yearOfPublication = yearOfPublication;
        logger.info(book);
        return Response.status(201).entity(book).build();

    }

    public Response createBookFallback(String title,
                                       String author,
                                       int yearOfPublication,
                                       String genre
    ) {
        Book book = new Book();
        book.author = author;
        book.isbn13 = "we could get this it service is down";

        book.genre = genre;
        book.title = title;
        book.creationDate = Instant.now();
        book.yearOfPublication = yearOfPublication;
        logger.info(book);
        return Response.status(206).entity(book).build();

    }
}
