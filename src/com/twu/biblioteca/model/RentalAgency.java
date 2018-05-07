package com.twu.biblioteca.model;
import com.twu.biblioteca.data.ApiInterface;
import com.twu.biblioteca.exception.ItemCheckedOutException;
import com.twu.biblioteca.exception.NonExistItemException;
import com.twu.biblioteca.exception.ItemReturnException;
import com.twu.biblioteca.util.ITEM_TYPE;

import java.util.List;
import java.util.stream.Collectors;

public class RentalAgency {


    private List<Book> books;
    private List<Movie> movies;

    public RentalAgency(ApiInterface api) {
        books = api.getBooks();
        movies = api.getMovies();
    }

    public List<Book> getBookList() {
        return this.books;
    }

    public List<Movie> getMovieList() {
        return this.movies;
    }

    public List<Book> getAvailableBookList() {
        return getBookList().stream()
                .filter(Book::isAvailable)
                .collect(Collectors.toList());
    }

    public List<Movie> getAvailableMovieList() {
        return getMovieList().stream()
                .filter(Movie::isAvailable)
                .collect(Collectors.toList());
    }

    public void checkOutItem(Item item) throws ItemCheckedOutException, NonExistItemException {

        try {
            verifyItem(item);

            if (item.isAvailable()) {
                handleItemAvailability(item, false);
            } else {
                throw new ItemCheckedOutException();
            }

        } catch (NonExistItemException e) {
            throw new NonExistItemException();
        }
    }

    public void returnItem(Item item) throws ItemReturnException, NonExistItemException {
        try {
            verifyItem(item);

            if (!item.isAvailable()) {
                handleItemAvailability(item, true);
            } else {
                throw new ItemReturnException();
            }

        } catch (NonExistItemException e) {
            throw new NonExistItemException();
        }
    }

    private void handleItemAvailability(Item item, boolean availability) throws NonExistItemException {
        if (item.getType() == ITEM_TYPE.BOOK) {
            updateBookAvailability(getBookIndexInList(item), availability);
        } else if (item.getType() == ITEM_TYPE.MOVIE) {
            updateMovieAvailability(getMovieIndexInList(item), availability);
        }
    }

    private int getBookIndexInList(Item item) throws NonExistItemException {
        for (int index = 0; index < getBookList().size(); index++) {
            if (getBookList().get(index).equals(item))
                return index;
        }
        throw new NonExistItemException();
    }

    private void updateBookAvailability(int bookIndex, boolean availability) {
        this.getBookList().get(bookIndex).setAvailable(availability);
    }

    private int getMovieIndexInList(Item item) throws NonExistItemException {
        for (int index = 0; index < getMovieList().size(); index++) {
            if (getMovieList().get(index).equals(item))
                return index;
        }
        throw new NonExistItemException();
    }

    private void updateMovieAvailability(int movieIndex, boolean availability) {
        getMovieList().get(movieIndex).setAvailable(availability);
    }

    private void verifyItem(Item item) throws NonExistItemException {
        if (item == null)
            throw new NonExistItemException();
    }
}
