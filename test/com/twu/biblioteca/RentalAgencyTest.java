package com.twu.biblioteca;

import com.twu.biblioteca.exception.ItemCheckedOutException;
import com.twu.biblioteca.exception.NonExistItemException;
import com.twu.biblioteca.exception.ItemReturnException;
import com.twu.biblioteca.mocks.ApiMock;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.RentalAgency;
import org.junit.Assert;
import org.junit.Test;

public class RentalAgencyTest {

    @Test
    public void getBookListTest() {
        RentalAgency rentalAgency = new RentalAgency(new ApiMock());
        Assert.assertNotNull(rentalAgency.getBookList());
    }

    @Test
    public void getAvailableBookListTest() {
        RentalAgency rentalAgency = new RentalAgency(new ApiMock());
        Assert.assertNotNull(rentalAgency.getAvailableBookList());
    }

    @Test
    public void getMovieListTest() {
        RentalAgency rentalAgency = new RentalAgency(new ApiMock());
        Assert.assertNotNull(rentalAgency.getMovieList());
    }

    @Test
    public void getAvailableMovieListTest() {
        RentalAgency rentalAgency = new RentalAgency(new ApiMock());
        Assert.assertNotNull(rentalAgency.getAvailableMovieList());
    }


    @Test
    public void checkOutBookSuccessfulTest() {
        try {
            Book book = new Book("La casa de papel","Netflix", 2018);

            RentalAgency rentalAgency = new RentalAgency(new ApiMock());
            rentalAgency.checkOutItem(book);

        } catch (ItemCheckedOutException | NonExistItemException e) {
            Assert.fail();
        }
    }

    @Test (expected = ItemCheckedOutException.class)
    public void checkOutBookUnsuccessfulTest() throws ItemCheckedOutException {

        Book book = new Book("La casa de papel","Netflix", 2018);
        book.setAvailable(false);

        try {
            RentalAgency rentalAgency = new RentalAgency(new ApiMock());
            rentalAgency.checkOutItem(book);
        } catch (NonExistItemException e) {
            Assert.fail();
        }
    }

    @Test (expected = NonExistItemException.class)
    public void checkOutNonexistentBookTest() throws NonExistItemException {

        Book book = new Book(null, null ,0);

        try {
            RentalAgency rentalAgency = new RentalAgency(new ApiMock());
            rentalAgency.checkOutItem(book);
        } catch (ItemCheckedOutException e) {
            Assert.fail();
        }
    }


    @Test
    public void checkOutMovieSuccessfulTest() {
        try {
            Movie movie = new Movie("Lagoa Azul", 1980, "Eduarda", 2);

            RentalAgency rentalAgency = new RentalAgency(new ApiMock());
            rentalAgency.checkOutItem(movie);

        } catch (ItemCheckedOutException | NonExistItemException e) {
            Assert.fail();
        }
    }

    @Test (expected = ItemCheckedOutException.class)
    public void checkOutMovieUnsuccessfulTest() throws ItemCheckedOutException {

        Movie movie = new Movie("Lagoa Azul", 1980, "Eduarda", 2);
        movie.setAvailable(false);

        try {
            RentalAgency rentalAgency = new RentalAgency(new ApiMock());
            rentalAgency.checkOutItem(movie);
        } catch (NonExistItemException e) {
            Assert.fail();
        }
    }

    @Test (expected = NonExistItemException.class)
    public void checkOutNonexistentMovieTest() throws NonExistItemException {

        Movie movie = new Movie(null, 0, null, 0);

        try {
            RentalAgency rentalAgency = new RentalAgency(new ApiMock());
            rentalAgency.checkOutItem(movie);
        } catch (ItemCheckedOutException e) {
            Assert.fail();
        }
    }

    @Test (expected = NonExistItemException.class)
    public void checkOutBookPassingNullItemTest() throws NonExistItemException, ItemCheckedOutException {
        RentalAgency rentalAgency = new RentalAgency(new ApiMock());
        rentalAgency.checkOutItem(null);
    }


    @Test
    public void returnBookSuccessfulTest() {

        try {
            Book book = new Book("La casa de papel","Netflix", 2018);
            book.setAvailable(false);

            RentalAgency rentalAgency = new RentalAgency(new ApiMock());
            rentalAgency.returnItem(book);

        } catch (ItemReturnException | NonExistItemException e) {
            Assert.fail();
        }
    }

    @Test (expected = NonExistItemException.class)
    public void returnMoviePassingNullBookTest() throws NonExistItemException, ItemReturnException {
        RentalAgency rentalAgency = new RentalAgency(new ApiMock());
        rentalAgency.returnItem(null);
    }

    @Test (expected = ItemReturnException.class)
    public void returnBookUnsuccessfulTest() throws ItemReturnException {

        Book book = new Book("TWU-Book", "TW" ,2018);

        try {
            RentalAgency rentalAgency = new RentalAgency(new ApiMock());
            rentalAgency.returnItem(book);
        } catch (NonExistItemException e) {
            Assert.fail();
        }
    }

    @Test (expected = NonExistItemException.class)
    public void returnNonexistentBookTest() throws NonExistItemException {

        Book book = new Book(null, null ,0);
        book.setAvailable(false);

        try {
            RentalAgency rentalAgency = new RentalAgency(new ApiMock());
            rentalAgency.returnItem(book);
        } catch (ItemReturnException e) {
            Assert.fail();
        }
    }

    @Test
    public void returnMovieSuccessfulTest() {

        try {
            Movie movie = new Movie("Lagoa Azul", 1980, "Eduarda", 2);
            movie.setAvailable(false);

            RentalAgency rentalAgency = new RentalAgency(new ApiMock());
            rentalAgency.returnItem(movie);

        } catch (ItemReturnException | NonExistItemException e) {
            Assert.fail();
        }
    }


    @Test (expected = ItemReturnException.class)
    public void returnMovieUnsuccessfulTest() throws ItemReturnException {

        Movie movie = new Movie("Lagoa Azul", 1980, "Eduarda", 2);

        try {
            RentalAgency rentalAgency = new RentalAgency(new ApiMock());
            rentalAgency.returnItem(movie);
        } catch (NonExistItemException e) {
            Assert.fail();
        }
    }

    @Test (expected = NonExistItemException.class)
    public void returnNonExistentMovieTest() throws NonExistItemException {

        Movie movie = new Movie(null, 0, null, 0);
        movie.setAvailable(false);
        try {
            RentalAgency rentalAgency = new RentalAgency(new ApiMock());
            rentalAgency.returnItem(movie);
        } catch (ItemReturnException e) {
            Assert.fail();
        }
    }
}
