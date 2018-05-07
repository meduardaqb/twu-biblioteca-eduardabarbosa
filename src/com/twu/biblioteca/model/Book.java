package com.twu.biblioteca.model;

import com.twu.biblioteca.util.ITEM_TYPE;

public class Book extends Item {

    private String author;
    private int yearPublished;

    public Book(String name, String author, int yearPublished) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
        this.available = true;
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

    @Override
    ITEM_TYPE getType() {
        return ITEM_TYPE.BOOK;
    }
}
