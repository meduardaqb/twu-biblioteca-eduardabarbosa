package com.twu.biblioteca.mocks;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.util.IoOperationInterface;

import java.util.LinkedList;
import java.util.List;

public class IoOperationMock implements IoOperationInterface {

    public boolean getInputoutWasCalled = false;
    public boolean printErrorMessageWasCalled = false;
    public boolean printMessageWasCalled = false;
    public boolean showBookListWasCalled = false;

    private LinkedList<String> inputQueue;

    @Override
    public String getInput() {
        getInputoutWasCalled = true;

        if (this.inputQueue.size() != 0) {
            String input = this.inputQueue.getFirst();
            this.inputQueue.removeFirst();
            return input;
        }
        return "";
    }

    @Override
    public void printErrorMessage() {
        printErrorMessageWasCalled = true;
    }

    @Override
    public void printMessage(String message) {
        printMessageWasCalled = true;
    }

    @Override
    public void showBookList(List<Book> bookList) {
        showBookListWasCalled = true;
    }

    public void setInputReturn(LinkedList<String> inputQueue) {
        this.inputQueue = inputQueue;
    }
}
