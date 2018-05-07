package com.twu.biblioteca.mocks;

import com.twu.biblioteca.data.ApiInterface;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.User;

import java.util.ArrayList;
import java.util.List;

public class ApiMock implements ApiInterface {

    @Override
    public List<Book> getBooks() {
        return getMockedBooks();
    }

    @Override
    public List<User> getUsers() {
        return getMockedUsers();
    }

    @Override
    public List<Movie> getMovies() {
        return getMockedMovies();
    }

    private List<Book> getMockedBooks() {
        List<Book> books = new ArrayList<>();

        books.add(new Book("La casa de papel","Netflix", 2018));
        books.add(new Book("Orange is the new black","Orange", 2017));
        books.add(new Book("Black Mirror","Net", 2016));
        books.add(new Book("Quantico","FBI", 2012));

        return books;
    }

    private List<User> getMockedUsers() {
        List<User> users = new ArrayList<>();

        users.add(new User("Duda", "123-4567", "duda@email.com", "Street whatever", "8887877778", "123"));
        users.add(new User("Clara", "456-7890", "clara@email.com", "Street nothing", "123132132", "123"));

        return users;
    }

    private List<Movie> getMockedMovies() {
        List<Movie> movies = new ArrayList<>();

        movies.add(new Movie("Lagoa Azul", 1980, "Eduarda", 2));
        movies.add(new Movie("Todo mundo em pânico", 2014, "Késsia", 5));

        return movies;
    }
}
