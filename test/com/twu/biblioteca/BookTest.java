package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import org.junit.Assert;
import org.junit.Test;

public class BookTest {
    @Test
    public void isBookEqualSuccessfulTest() {
        Book book = new Book("First", "bla bla", 2018);
        Book book2 = new Book("First", "bla bla", 2018);

        Assert.assertTrue(book.equals(book2));
    }

    @Test
    public void isBookEqualUnSuccessfulTest() {
        Book book = new Book("First", "bla bla", 2018);
        Book book2 = new Book("Second", "bla bla", 2018);

        Assert.assertFalse(book.equals(book2));
    }
}
