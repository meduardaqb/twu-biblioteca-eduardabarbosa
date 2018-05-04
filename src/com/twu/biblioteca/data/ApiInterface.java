package com.twu.biblioteca.data;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.User;

import java.util.List;

public interface ApiInterface {
    List<Book> getBooks();
    List<User> getUsers();
}
