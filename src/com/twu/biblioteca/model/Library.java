package com.twu.biblioteca.model;
import com.twu.biblioteca.data.Api;
import com.twu.biblioteca.data.ApiInterface;
import com.twu.biblioteca.exception.BookCheckedOutException;
import com.twu.biblioteca.exception.NonExistBookException;
import com.twu.biblioteca.exception.BookReturnException;

import java.util.List;
import java.util.stream.Collectors;

public class Library {


    private List<Book> books;

    public Library(ApiInterface api) {
        books = api.getBooks();
    }

    public List<Book> getBookList() {
        return this.books;
    }

    public List<Book> getAvailableBookList() {
        return getBookList().stream()
                .filter(Book::isAvailable)
                .collect(Collectors.toList());
    }

    public void checkOutBook(Book book) throws BookCheckedOutException, NonExistBookException {

        try {
            verifyBook(book);

            if (book.isAvailable()) {
                updateBookAvailability(getBookIndexInList(book), false);
            } else {
                throw new BookCheckedOutException();
            }

        } catch (NonExistBookException e) {
            throw new NonExistBookException();
        }
    }

    public void returnBook(Book book) throws BookReturnException, NonExistBookException {
        try {
            verifyBook(book);

            if (!book.isAvailable()) {
                updateBookAvailability(getBookIndexInList(book), true);
            } else {
                throw new BookReturnException();
            }

        } catch (NonExistBookException e) {
            throw new NonExistBookException();
        }
    }

    private int getBookIndexInList(Book book) throws NonExistBookException {
        for (int index = 0; index < getBookList().size(); index++) {
            if (getBookList().get(index).equals(book))
                return index;
        }
        throw new NonExistBookException();
    }

    private void updateBookAvailability(int bookIndex, boolean availability) {
        this.getBookList().get(bookIndex).setAvailable(availability);
    }

    private void verifyBook(Book book) throws NonExistBookException {
         if (book == null)
            throw new NonExistBookException();
    }
}
