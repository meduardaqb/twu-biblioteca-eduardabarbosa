package com.twu.biblioteca.model;

public class Book {

    private String name;
    private String author;
    private int yearPublished;
    private boolean available;

    public Book(String name, String author, int yearPublished) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
        this.available = true;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    @Override
    public boolean equals(Object obj) {
        Book book = (Book) obj;

        return this.name.equals(book.name) &&
                this.author.equals(book.author) &&
                this.yearPublished == book.yearPublished;
    }
}
