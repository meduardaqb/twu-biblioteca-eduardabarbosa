package com.twu.biblioteca.mocks;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.util.IoOperationInterface;

import java.util.List;

public class IoOperationMock implements IoOperationInterface {

    public boolean getInoutWasCalled = false;
    public boolean printErrorMessageWasCalled = false;
    public boolean showBookListWasCalled = false;

    private String inputReturn = "";

    @Override
    public String getInput() {
        getInoutWasCalled = true;
        return this.inputReturn;
    }

    @Override
    public void printErrorMessage() {
        printErrorMessageWasCalled = true;
    }

    @Override
    public void printMessage(String message) {

    }

    @Override
    public void showBookList(List<Book> bookList) {
        showBookListWasCalled = true;
    }

    public void setInputReturn(String inputReturn) {
        this.inputReturn = inputReturn;
    }
}
