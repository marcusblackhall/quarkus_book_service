package com.iamatum.quarkus.microservices.book;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;

import java.time.Instant;


@Path("/api/books")
@Tag( name = "Quarkus Book Resource" , description = "Book resource endpoint")
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
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Operation(description = "Creates a book with an isbn 13 format")
    public Response createBook(@FormParam("title") String title,
                               @FormParam("author") String author,
                               @FormParam("year") int yearOfPublication,
                               @FormParam("genre") String genre
                               ) {
        Book book = new Book();
        book.author = author;
        book.isbn13 = "13-55555";
        book.genre = genre;
        book.title = title;
        book.creationDate = Instant.now();
        book.yearOfPublication = yearOfPublication;
        logger.info(book);
        return Response.status(201).entity(book).build();

    }
}
