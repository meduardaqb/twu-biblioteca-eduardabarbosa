package com.twu.biblioteca.mocks;

import com.twu.biblioteca.data.ApiInterface;
import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;

public class ApiMock implements ApiInterface {

    @Override
    public List<Book> getBooks() {
        return getMockedBooks();
    }

    private List<Book> getMockedBooks() {
        List<Book> books = new ArrayList<>();

        books.add(new Book("La casa de papel","Netflix", 2018));
        books.add(new Book("Orange is the new black","Orange", 2017));
        books.add(new Book("Black Mirror","Net", 2016));
        books.add(new Book("Quantico","FBI", 2012));

        return books;
    }
}
