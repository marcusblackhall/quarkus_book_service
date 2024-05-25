package com.iamatum.quarkus.microservices.book;

import java.time.Instant;

public class Book {

    public String isbn13;
    public String genre;
    public Instant creationDate;
    public String author;
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
