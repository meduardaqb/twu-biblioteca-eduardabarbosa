package com.twu.biblioteca.util;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;

import java.util.List;
import java.util.Scanner;

public class IoOperation implements IoOperationInterface {

    @Override
    public String getInput() {
        return new Scanner(System.in).next();
    }

    @Override
    public void printErrorMessage() {
        printMessage("");
        printMessage(Constants.INVALID_CARACTER);
        printMessage("");
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void showBookList(List<Book> bookList) {
        for (int index = 0; index < bookList.size(); index++) {
            printMessage(index + " - " + bookList.get(index).getName() + ", " +
                    bookList.get(index).getAuthor() + ", " +
                    bookList.get(index).getYearPublished() );
        }
    }

    @Override
    public void showMovieList(List<Movie> movieList) {
        for (int index = 0; index < movieList.size(); index++) {
            printMessage(index + " - " + movieList.get(index).getName() + ", " +
                    movieList.get(index).getDirector() + ", " +
                    movieList.get(index).getYear() + ", " +
                    movieList.get(index).getRating());
        }
    }
}
