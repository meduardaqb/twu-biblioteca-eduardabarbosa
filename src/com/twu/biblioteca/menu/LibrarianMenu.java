package com.twu.biblioteca.menu;

import com.twu.biblioteca.data.ApiInterface;
import com.twu.biblioteca.exception.BookCheckedOutException;
import com.twu.biblioteca.exception.BookReturnException;
import com.twu.biblioteca.exception.NonExistBookException;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.util.Constants;
import com.twu.biblioteca.util.IoOperationInterface;


public class LibrarianMenu implements LibrarianMenuInterface {
    private UserTypeMenuInterface userTypeMenu;
    private IoOperationInterface io;
    private Library library;
    private LoginMenu loginMenuCheckout;
    private LoginMenu loginMenuReturn;

    public LibrarianMenu(UserTypeMenuInterface userTypeMenu, IoOperationInterface io, Library library, ApiInterface api) {
        this.userTypeMenu = userTypeMenu;
        this.io = io;
        this.library = library;

        this.loginMenuCheckout = new LoginMenu(new AuthResponseInterface() {
            @Override
            public void onSignInSuccess() {
                checkoutBookMenu();
                librarianMenu();
            }

            @Override
            public void onSignInError() {
                librarianMenu();
            }
        }, io, api);

        this.loginMenuReturn = new LoginMenu(new AuthResponseInterface() {
            @Override
            public void onSignInSuccess() {
                returnBookMenu();
                librarianMenu();
            }

            @Override
            public void onSignInError() {
                librarianMenu();
            }
        }, io, api);
    }

    @Override
    public void librarianMenu() {
        io.printMessage(Constants.SELECT_ACTION);
        io.printMessage(Constants.CHECKOUT_BOOK);
        io.printMessage(Constants.RETURN_BOOK);
        io.printMessage(Constants.BACK);

        handleLibrarianMenu(io.getInput());
    }

    private void handleLibrarianMenu(String input) {
        if (input.equals("c")) {
            this.loginMenuCheckout.signInForm();
        } else if (input.equals("r")) {
            this.loginMenuReturn.signInForm();
        } else if (input.equals("b")) {
            this.userTypeMenu.userTypeChoiceMenu();
        } else {
            io.printErrorMessage();
            librarianMenu();
        }
    }

    private void checkoutBookMenu() {
        io.printMessage(Constants.SELECT_BOOK_CHECKOUT);
        io.showBookList(this.library.getBookList());
        io.printMessage(Constants.BACK);
        handleCheckoutBook(io.getInput());
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
            Book book = this.library.getBookList().get(input);

            this.library.checkOutBook(book);
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
            io.printErrorMessage();
            checkoutBookMenu();
        }
    }

    private void showCheckOutResult(String message) {
        io.printMessage(message);
        checkoutBookMenu();
    }

    private void returnBookMenu() {
        io.printMessage(Constants.SELECT_BOOK_RETURN);
        io.showBookList(this.library.getBookList());
        io.printMessage(Constants.BACK);
        handleReturnBook(io.getInput());
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
            Book book = this.library.getBookList().get(input);

            this.library.returnBook(book);
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
            io.printErrorMessage();
            returnBookMenu();
        }
    }

    private void showReturnResult(String message) {
        io.printMessage(message);
        returnBookMenu();
    }
}
