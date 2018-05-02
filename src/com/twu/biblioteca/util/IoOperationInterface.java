package com.twu.biblioteca.util;

import com.twu.biblioteca.model.Book;
import java.util.List;

public interface IoOperationInterface {
    String getInput();
    void printErrorMessage();
    void printMessage(String message);
    void showBookList(List<Book> bookList);
}
