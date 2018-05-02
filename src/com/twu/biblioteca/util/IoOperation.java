package com.twu.biblioteca.util;

import com.twu.biblioteca.model.Book;

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
}
