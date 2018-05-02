package com.twu.biblioteca;

import com.twu.biblioteca.exception.BookCheckedOutException;
import com.twu.biblioteca.exception.NonExistBookException;
import com.twu.biblioteca.exception.BookReturnException;
import com.twu.biblioteca.mocks.ApiMock;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import org.junit.Assert;
import org.junit.Test;

public class LibraryTest {

    @Test
    public void getBookListTest() {
        Library library = new Library(new ApiMock());
        Assert.assertNotNull(library.getBookList());
    }

    @Test
    public void getAvailableBookListTest() {
        Library library = new Library(new ApiMock());
        Assert.assertNotNull(library.getAvailableBookList());
    }

    @Test
    public void checkOutBookSuccessfulTest() {
        try {
            Book book = new Book("La casa de papel","Netflix", 2018);

            Library library = new Library(new ApiMock());
            library.checkOutBook(book);

        } catch (BookCheckedOutException | NonExistBookException e) {
            Assert.fail();
        }
    }

    @Test (expected = BookCheckedOutException.class)
    public void checkOutBookUnsuccessfulTest() throws BookCheckedOutException {

        Book book = new Book("La casa de papel","Netflix", 2018);
        book.setAvailable(false);

        try {
            Library library = new Library(new ApiMock());
            library.checkOutBook(book);
        } catch (NonExistBookException e) {
            Assert.fail();
        }
    }

    @Test (expected = NonExistBookException.class)
    public void checkOutNonexistentBookTest() throws NonExistBookException {

        Book book = new Book(null, null ,0);

        try {
            Library library = new Library(new ApiMock());
            library.checkOutBook(book);
        } catch (BookCheckedOutException e) {
            Assert.fail();
        }
    }

    @Test (expected = NonExistBookException.class)
    public void checkOutBookPassingNullBookTest() throws NonExistBookException, BookCheckedOutException {
        Library library = new Library(new ApiMock());
        library.checkOutBook(null);
    }

    @Test
    public void returnBookSuccessfulTest() {

        try {
            Book book = new Book("La casa de papel","Netflix", 2018);
            book.setAvailable(false);

            Library library = new Library(new ApiMock());
            library.returnBook(book);

        } catch (BookReturnException | NonExistBookException e) {
            Assert.fail();
        }
    }

    @Test (expected = NonExistBookException.class)
    public void returnBookPassingNullBookTest() throws NonExistBookException, BookReturnException {
        Library library = new Library(new ApiMock());
        library.returnBook(null);
    }

    @Test (expected = BookReturnException.class)
    public void returnBookUnsuccessfulTest() throws BookReturnException {

        Book book = new Book("TWU-Book", "TW" ,2018);

        try {
            Library library = new Library(new ApiMock());
            library.returnBook(book);
        } catch (NonExistBookException e) {
            Assert.fail();
        }
    }

    @Test (expected = NonExistBookException.class)
    public void returnNonexistentBookTest() throws NonExistBookException {

        Book book = new Book(null, null ,0);
        book.setAvailable(false);

        try {
            Library library = new Library(new ApiMock());
            library.returnBook(book);
        } catch (BookReturnException e) {
            Assert.fail();
        }
    }
}
