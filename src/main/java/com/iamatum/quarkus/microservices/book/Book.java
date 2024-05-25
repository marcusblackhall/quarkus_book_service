package com.iamatum.quarkus.microservices.book;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.json.bind.annotation.JsonbProperty;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.Instant;

@Schema(description = "It is a Book")
public class Book {

    @JsonbProperty("isbn_13")
    public String isbn13;
    public String genre;
    @JsonbDateFormat("dd-MM-YYYY")
    @JsonbProperty("creation_date")
    @Schema(implementation = String.class,format = "date")
    public Instant creationDate;
    public String author;
    @JsonbProperty("year_of_publication")


    public int yearOfPublication;

    public String title;

    @Override
    public String toString() {
        return "Book{" +
                "isbn13='" + isbn13 + '\'' +
                ", genre='" + genre + '\'' +
                ", creationDate=" + creationDate +
                ", author='" + author + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", title='" + title + '\'' +
                '}';
    }
}
