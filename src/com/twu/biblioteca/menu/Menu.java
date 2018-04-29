package com.twu.biblioteca.menu;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.util.Constants;

import java.util.List;
import java.util.Scanner;

public abstract class Menu {
    protected String getInput() {
        return new Scanner(System.in).next();
    }

    protected void printErrorMessage() {
        printMessage("");
        printMessage(Constants.INVALID_CARACTER);
        printMessage("");
    }

    protected void printMessage(String message) {
        System.out.println(message);
    }

    protected void showBookList(List<Book> bookList) {
        for (int index = 0; index < bookList.size(); index++) {
            printMessage(index + " - " + bookList.get(index).getName() + ", " +
                    bookList.get(index).getAuthor() + ", " +
                    bookList.get(index).getYearPublished() );
        }
    }
}
