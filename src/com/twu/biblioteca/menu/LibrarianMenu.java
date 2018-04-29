package com.twu.biblioteca.menu;

import com.twu.biblioteca.exception.BookCheckedOutException;
import com.twu.biblioteca.exception.BookReturnException;
import com.twu.biblioteca.exception.NonExistBookException;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.util.Constants;


public class LibrarianMenu extends Menu {
    private MainMenu mainMenu;

    public LibrarianMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    public void librarianMenu() {
        printMessage(Constants.SELECT_ACTION);
        printMessage(Constants.CHECKOUT_BOOK);
        printMessage(Constants.RETURN_BOOK);
        printMessage(Constants.BACK);

        handleLibrarianMenu(getInput());
    }

    private void handleLibrarianMenu(String input) {
        if (input.equals("c")) {
            this.checkoutBookMenu();
        } else if (input.equals("r")) {
            this.returnBookMenu();
        } else if (input.equals("b")) {
            this.mainMenu.main();
        } else {
            printErrorMessage();
            librarianMenu();
        }
    }

    private void checkoutBookMenu() {
        printMessage(Constants.SELECT_BOOK_CHECKOUT);
        showBookList(this.mainMenu.library.getBookList());
        printMessage(Constants.BACK);
        handleCheckoutBook(getInput());
    }

    private void handleCheckoutBook(String input) {
        try {
            handleInputNumberCheckOut(Integer.parseInt(input));
        } catch(NumberFormatException e) {
            handleInputStringCheckout(input);
        }
    }

    private void handleInputNumberCheckOut(int input) {
        try {
            Book book = mainMenu.library.getBookList().get(input);

            mainMenu.library.checkOutBook(book);
            showCheckOutResult(Constants.SUCCESSFUL_CHECKOUT);
        } catch (BookCheckedOutException e) {
            showCheckOutResult(Constants.UNSUCCESSFUL_CHECKOUT);
        } catch (NonExistBookException | IndexOutOfBoundsException e) {
            showCheckOutResult(Constants.INVALID_CARACTER);
        }
    }

    private void handleInputStringCheckout(String input) {
        if (input.equals("b")) {
            librarianMenu();
        } else {
            printErrorMessage();
            checkoutBookMenu();
        }
    }

    private void showCheckOutResult(String message) {
        printMessage(message);
        checkoutBookMenu();
    }

    private void returnBookMenu() {
        printMessage(Constants.SELECT_BOOK_RETURN);
        showBookList(this.mainMenu.library.getBookList());
        printMessage(Constants.BACK);
        handleReturnBook(getInput());
    }

    private void handleReturnBook(String input) {
        try {
            handleInputNumberReturn(Integer.parseInt(input));
        } catch(NumberFormatException e) {
            handleInputStringReturn(input);
        }
    }

    private void handleInputNumberReturn(int input) {
        try {
            Book book = mainMenu.library.getBookList().get(input);

            mainMenu.library.returnBook(book);
            showReturnResult(Constants.SUCCESSFUL_RETURN);
        } catch (BookReturnException e) {
            showReturnResult(Constants.UNSUCCESSFUL_RETURN);
        } catch (NonExistBookException | IndexOutOfBoundsException e) {
            showReturnResult(Constants.INVALID_CARACTER);
        }
    }

    private void handleInputStringReturn(String input) {
        if (input.equals("b")) {
            librarianMenu();
        } else {
            printErrorMessage();
            returnBookMenu();
        }
    }

    private void showReturnResult(String message) {
        printMessage(message);
        returnBookMenu();
    }
}
